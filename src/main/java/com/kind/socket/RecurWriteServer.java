package com.kind.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 演示允许多次调用write方法进入写入操作
 * 服务端不执行while循环的条件是，当客户端调用outstream.close(),代表到达流的结尾，不再传输数据
 * ？？当outstream不执行close方法，但是client结束，也会符合上述，是什么原因？
 */
public class RecurWriteServer {

    public static void main(String[] args) {
        char[] chars = new char[15];

        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("accept begin:"+new Date());
            Socket socket = serverSocket.accept();
            System.out.println("accept end:"+new Date());

            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            //如果没有接受的client的写入数据，则会一直阻塞
            System.out.println("read begin:"+new Date());
            int read = inputStreamReader.read(chars);
            while(read != -1){
                String s = new String(chars, 0, read);
                System.out.println(s);
                read = inputStreamReader.read(chars);
            }

            System.out.println("read end:"+new Date());

            socket.close();
            serverSocket.close();


        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}

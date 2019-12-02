package com.kind.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
/**
 * 演示服务端客户端的经典案例---服务端与客户端传递字符串
 * server
 */
public class DeliverServer {

    public static void main(String[] args) {
        char[] chars = new char[6];

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

            //开始从服务端向客户端传递字符串
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("原来你就是周吉峰啊，我是董英博啊".getBytes());

            outputStream.flush();
            outputStream.close();
            socket.close();
            serverSocket.close();


        } catch (IOException e) {

            e.printStackTrace();
        }


    }
}

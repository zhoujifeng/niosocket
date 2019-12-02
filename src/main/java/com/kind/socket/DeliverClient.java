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
 * client
 */
public class DeliverClient {
    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println("socket begin:"+new Date());
        Socket socket = new Socket("localhost",8888);
        System.out.println("socket end:"+new Date());

        Thread.sleep(3000);
        //等待3s之后开始向socket连接中写入数据
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("我是周吉峰啊".getBytes());


        //本来想在同一个server和client中实现通信
        //发现根本实现不了。
        //两边的read方法同时阻塞
//        char[] chars = new char[1024];
//        InputStream inputStream = socket.getInputStream();
//        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//        int read = inputStreamReader.read(chars);
//        while (read != -1){
//            System.out.println(new String(chars,0,read));
//            read = inputStreamReader.read(chars);
//        }
//        inputStream.close();
        outputStream.flush();
        outputStream.close();
        socket.close();

    }
}

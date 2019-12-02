package com.kind.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 演示服务端向客户端传输字符串
 * server
 */
public class ServerDeliverToClientServer {
    public static void main(String[] args) throws IOException, InterruptedException {


        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("accept阻塞begin:"+new Date());
        Socket accept = serverSocket.accept();
        System.out.println("accept阻塞end:"+new Date());
        OutputStream outputStream = accept.getOutputStream();
        outputStream.write("原来你就是周吉峰啊".getBytes());
        outputStream.flush();
        outputStream.close();
        accept.close();
        serverSocket.close();

    }
}

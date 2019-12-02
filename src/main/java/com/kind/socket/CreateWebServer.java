package com.kind.socket;

import javax.print.DocFlavor;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 通过SocketServer实现一个简易的web服务器
 * 通过端口666开启一个SocketServer服务，通过浏览器输入
 * http://localhost:666
 * 将会在控制台打印浏览器传入的请求头信息，并返回相应内容到页面
 */
public class CreateWebServer {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(666);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String getString = "";
        while(!"".equals(getString = bufferedReader.readLine())){
            System.out.println(getString);
        }

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
        outputStream.write(("<html><body>" +
                "<a href = 'http://www.baidu.com'>" +
                " i am baidu.com</a></boyd></html>").getBytes());

        outputStream.flush();
        inputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();

    }
}

package com.kind.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 演示调用Stream的close方法会造成socket关闭
 * server
 */
public class StreamCloseServer {

    public static void main(String[] args) throws IOException {

        byte[] chars = new byte[1024];
        ServerSocket serverSocket = new ServerSocket(8888);

        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        int readlength = inputStream.read(chars);
        while (readlength != -1){
            String s = new String(chars, 0, readlength);
            System.out.println(s);
            readlength = inputStream.read(chars);
        }
        inputStream.close();
        //这里会抛出SocketException异常
        OutputStream outputStream = socket.getOutputStream();
        serverSocket.close();

    }
}

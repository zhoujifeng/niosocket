package com.kind.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 验证read方法具有阻塞性
 * server服务
 *
 * 如果客户端一直不关闭，并且不发送数据到服务端
 * 那么会引起服务端的read方法阻塞
 * 服务器会一直尝试从客户端传递来的数据
 */
public class ReadBlockServer {

    public static void main(String[] args) throws IOException {

        byte[] byteArray = new byte[1024];
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("accept阻塞begin:"+new Date());
        Socket socket = serverSocket.accept();
        System.out.println("accept阻塞end:"+new Date());

        InputStream inputStream = socket.getInputStream();
        System.out.println("read阻塞begin:"+new Date());
        int read = inputStream.read(byteArray);
        System.out.println("read阻塞end："+new Date());

        inputStream.close();
        socket.close();
        serverSocket.close();

    }
}

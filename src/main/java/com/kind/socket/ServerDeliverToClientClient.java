package com.kind.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;

/**
 * 演示服务端客户端的经典案例---服务端与客户端传递字符串
 * client
 */
public class ServerDeliverToClientClient {
    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println("socket begin:"+new Date());
        Socket socket = new Socket("localhost",8888);
        System.out.println("socket end:"+new Date());


        char[] chars = new char[1024];
        InputStream inputStream = socket.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        int read = inputStreamReader.read(chars);
        while (read != -1){
            System.out.println(new String(chars,0,read));
            read = inputStreamReader.read(chars);
        }
        inputStream.close();
        socket.close();

    }
}

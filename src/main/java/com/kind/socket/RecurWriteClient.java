package com.kind.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;

/**
 * 演示服务端客户端的经典案例---服务端与客户端传递字符串
 * client
 */
public class RecurWriteClient {
    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println("socket begin:"+new Date());
        Socket socket = new Socket("localhost",8888);
        System.out.println("socket end:"+new Date());

        Thread.sleep(3000);
        //等待3s之后开始向socket连接中写入数据
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("我是周吉峰啊".getBytes());

        Thread.sleep(3000);
        outputStream.write("我是周吉峰2号".getBytes());

        Thread.sleep(3000);
        outputStream.write("我是周吉峰3号".getBytes());
        //outputStream.flush();
        //outputStream.close();
        socket.close();

    }
}

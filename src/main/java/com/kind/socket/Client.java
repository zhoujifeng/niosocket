package com.kind.socket;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * @author zhoujifeng
 * @date 2019/12/2 20:01
 */
public class Client {

    public static void main(String[] args) {
        System.out.println("客户端准备连接"+new Date());

        try {
            Socket socket = new Socket("localhost",8088);
            System.out.println("客户端连接结束"+new Date());
            //socket.close();
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

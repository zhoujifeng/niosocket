package com.kind.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Date;

/**
 * 验证ServerSocket 的accept()方法具有阻塞性
 * @author zhoujifeng
 * @date 2019/12/2 19:53
 */
public class Server {

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(8088);
            System.out.println("server服务器开始运行:"+ new Date());
            //accept 会一直阻塞
            serverSocket.accept();
            System.out.println("server服务器开始结束:"+ new Date());
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

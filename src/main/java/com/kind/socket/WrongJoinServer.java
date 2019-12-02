package com.kind.socket;

import java.io.IOException;
import java.net.Socket;

/**
 * 验证连接一个错误的socket地址
 * 但是书上抛出的是UnknownHostException异常
 * 我验证的结果是ConnectException异常
 */
public class WrongJoinServer {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("www.csdnsssewwwemm878ssssdssssss.com",80);
            System.out.println("server连接成功");
        } catch (IOException e) {
            System.out.println("server连接失败");
            e.printStackTrace();
        }

    }
}

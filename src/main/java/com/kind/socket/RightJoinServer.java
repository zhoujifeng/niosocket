package com.kind.socket;

import java.io.IOException;
import java.net.Socket;

/**
 * 验证连接一个正确的socket地址
 */
public class RightJoinServer {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("www.baidu.com",80);
            System.out.println("server连接成功");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

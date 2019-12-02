package com.kind.socket;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

public class ReadBlockClient {

    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println("socket begin:"+new Date());
        Socket socket = new Socket("localhost",8888);
        System.out.println("socket end:"+new Date());
        //Thread.sleep(Integer.MAX_VALUE);
        //socket.close();
    }
}

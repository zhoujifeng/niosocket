package com.kind.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 演示调用stream的close方法会导致socket关闭
 * client
 */
public class StreamCloseClient {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost",8888);

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("我叫周吉峰".getBytes());
        outputStream.close();
        socket.close();

    }
}

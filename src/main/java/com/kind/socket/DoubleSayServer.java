package com.kind.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 演示服务器与客户端多次的往来通信
 * server
 */
public class DoubleSayServer {

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            int readInt = objectInputStream.readInt();
            byte[] bytes = new byte[readInt];
            System.out.println("readFully begin:"+ new Date());
            objectInputStream.readFully(bytes);
            String newString = new String(bytes);
            System.out.println("readFully end:"+ new Date());
            System.out.println(newString);

            OutputStream outputStream = socket.getOutputStream();
            String strA = "客户端你好A\n";
            String strB = "客户端你好B\n";
            String strC = "客户端你好C\n";

            int allByteLength = (strA + strB + strC).getBytes().length;

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeInt(allByteLength);
            objectOutputStream.flush();

            objectOutputStream.write(strA.getBytes());
            objectOutputStream.write(strB.getBytes());
            objectOutputStream.write(strC.getBytes());
            objectOutputStream.flush();

            readInt = objectInputStream.readInt();
            bytes = new byte[readInt];
            objectInputStream.readFully(bytes);
            newString = new String(bytes);
            System.out.println(newString);

            //OutputStream outputStream = socket.getOutputStream();
            String strD = "客户端你好D\n";
            String strE = "客户端你好E\n";
            String strF = "客户端你好F\n";

            allByteLength = (strD + strE + strF).getBytes().length;

            //ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeInt(allByteLength);
            objectOutputStream.flush();

            objectOutputStream.write(strD.getBytes());
            objectOutputStream.write(strE.getBytes());
            objectOutputStream.write(strF.getBytes());
            objectOutputStream.flush();

            inputStream.close();
            socket.close();




        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

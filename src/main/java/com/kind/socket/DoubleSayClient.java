package com.kind.socket;

import java.io.*;
import java.net.Socket;

/**
 * 演示服务器与服务端多次的往来通信
 * client
 */
public class DoubleSayClient {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost",8888);

        
        OutputStream outputStream = socket.getOutputStream();
        String strA = "服务端你好A\n";
        String strB = "服务端你好B\n";
        String strC = "服务端你好C\n";

        int allByteLength = (strA + strB + strC).getBytes().length;

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeInt(allByteLength);
        objectOutputStream.flush();

        objectOutputStream.write(strA.getBytes());
        objectOutputStream.write(strB.getBytes());
        objectOutputStream.write(strC.getBytes());
        objectOutputStream.flush();


        InputStream inputStream = socket.getInputStream();
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        int readInt = objectInputStream.readInt();
        byte[] bytes = new byte[readInt];
        objectInputStream.readFully(bytes);
        String newString = new String(bytes);
        System.out.println(newString);

        //OutputStream outputStream = socket.getOutputStream();
        String strD = "服务端你好D\n";
        String strE = "服务端你好E\n";
        String strF = "服务端你好F\n";

        allByteLength = (strD + strE + strF).getBytes().length;

        //ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeInt(allByteLength);
        objectOutputStream.flush();

        objectOutputStream.write(strD.getBytes());
        objectOutputStream.write(strE.getBytes());
        objectOutputStream.write(strF.getBytes());
        objectOutputStream.flush();


        readInt = objectInputStream.readInt();
        bytes = new byte[readInt];
        objectInputStream.readFully(bytes);
        newString = new String(bytes);
        System.out.println(newString);

        objectOutputStream.close();
        outputStream.close();
        socket.close();
    }
}

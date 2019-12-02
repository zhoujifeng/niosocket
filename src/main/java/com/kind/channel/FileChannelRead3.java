package com.kind.channel;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 验证FileChannel的read()方法。
 *
 * read方法将字节放入到ByteBuffer的当前位置，
 *
 * 两个线程同时去读取一个文件，最后的结果没有重复的读取，数名read方法在多线程下是线程安全的。
 */
public class FileChannelRead3 {

    public static void main(String[] args) throws Exception {

        FileInputStream fisRef = new FileInputStream("src/main/resources/file/c.txt");
        FileChannel channel = fisRef.getChannel();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ByteBuffer byteBuffer = ByteBuffer.allocate(5);
                    int readLength = channel.read(byteBuffer);
                    while(readLength != -1){
                        byte[] array = byteBuffer.array();
                        System.out.println(new String(array,0,readLength));
                        byteBuffer.clear();
                        readLength = channel.read(byteBuffer);

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ByteBuffer byteBuffer = ByteBuffer.allocate(5);
                    int readLength = channel.read(byteBuffer);
                    while(readLength != -1){
                        byte[] array = byteBuffer.array();
                        System.out.println(new String(array,0,readLength));
                        byteBuffer.clear();
                        readLength = channel.read(byteBuffer);

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();
        Thread.sleep(3000);

        channel.close();
        fisRef.close();


    }
}

package com.kind.channel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 测试FileChannel Write()方法相关特性
 *  验证write方法具有同步特性
 *  方法中开启20个线程同时进行对文件的写入，没有字符乱序的情况出现
 *  说明是同步的，多线程下线程安全的
 */
public class FileChannleWrite3 {


    public static void main(String[] args) throws IOException, InterruptedException {

        //构建输出流和通道
        FileOutputStream fosref = new FileOutputStream("src/main/resources/a.txt");
        FileChannel fileChannel = fosref.getChannel();

        for (int i = 0; i <10 ; i++) {
            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    ByteBuffer byteBuffer = ByteBuffer.wrap("abcde\r".getBytes());
                    try {
                        fileChannel.write(byteBuffer);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    ByteBuffer byteBuffer = ByteBuffer.wrap("我是中国人\r".getBytes());
                    try {
                        fileChannel.write(byteBuffer);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            thread1.start();
            thread2.start();
        }

        Thread.sleep(3000);

        //关闭资源
        fileChannel.close();
        fosref.close();

    }


}

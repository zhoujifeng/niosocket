package com.kind.channel;

import javax.print.DocFlavor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * FileChannel read()方法的返回值
 * 1.返回值为正数：代表从通道的当前位置向缓冲区中读的字节个数，只要读到，则就为正数
 * 2.返回值为0，代表从管道中没有读取到任何的数据，也就是0，发生的情况通常是缓冲区中没有剩余空间了
 * 3.-1：代表到达文件的末端，一定是当前读的时候，文件流已经到达末端
 */
public class FileChannelRead1 {

    public static void main(String[] args) throws Exception {

        FileInputStream fisRef = new FileInputStream("src/main/resources/file/b.txt");
        FileChannel channel = fisRef.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(5);
        //第一次返回5，代表从通道的当前位置向缓冲区中读了5个字节
        int readLength = channel.read(byteBuffer);
        System.out.println(readLength);
        //第二次返回是0，是因为缓冲区中没有remaining剩余空间了，而不是因为文件读到头了
        readLength = channel.read(byteBuffer);
        System.out.println(readLength);

        byteBuffer.clear();
        //第三次返回是-1，是因为到达文件流的末端了。
        readLength = channel.read(byteBuffer);
        System.out.println(readLength);

        byteBuffer.clear();
        channel.close();
        fisRef.close();

    }
}

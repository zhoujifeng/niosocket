package com.kind.channel;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 验证FileChannel的read()方法。
 *
 * read方法是从管道的当前位置开始读取的。
 */
public class FileChannelRead2 {

    public static void main(String[] args) throws Exception {

        FileInputStream fisRef = new FileInputStream("src/main/resources/file/b.txt");
        FileChannel channel = fisRef.getChannel();

        channel.position(2);
        ByteBuffer byteBuffer = ByteBuffer.allocate(5);
        //读到的length为3。
        //返回的是读到的个数。如果当前读，已经到达末尾导致任何一个字节也没有读到，才会返回-1
        int readLength = channel.read(byteBuffer);
        System.out.println(readLength);

        byte[] array = byteBuffer.array();
        for (int i = 0; i <array.length ; i++) {
            System.out.print((char) array[i]);
        }

        byteBuffer.clear();
        channel.close();
        fisRef.close();

    }
}

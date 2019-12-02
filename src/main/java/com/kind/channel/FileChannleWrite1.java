package com.kind.channel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 测试FileChannel Write()方法相关特性
 * 1 wirete方法是从通道的当前位置写入的
 */
public class FileChannleWrite1 {


    public static void main(String[] args) throws IOException {

        //构建输出流和通道
        FileOutputStream fosref = new FileOutputStream("src/main/resources/file/a.txt");
        FileChannel fileChannel = fosref.getChannel();

        //构建缓冲区
        ByteBuffer buffer = ByteBuffer.wrap("abcde".getBytes());
        //输出此时的通道位置为0
        System.out.println("A filechannle.position() = " + fileChannel.position());

        //将缓冲区内容写入通道
        System.out.println("write() 1 返回值" + fileChannel.write(buffer));

        //查看此时的通道位置变为5
        System.out.println("B filechannle.position() = " + fileChannel.position());

        //将通道的位置置为2
        fileChannel.position(2);

        //还原buffer的位置为0，为了能重新读取buffer中的内容
        buffer.rewind();

        System.out.println("write() 2 返回值" + fileChannel.write(buffer));

        System.out.println("C filechannle.position() = " + fileChannel.position());

        fileChannel.close();

        fosref.close();

    }


}

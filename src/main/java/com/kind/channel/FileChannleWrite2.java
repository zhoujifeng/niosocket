package com.kind.channel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 测试FileChannel Write()方法相关特性
 * 1 wirete方法将ByteBuffer的remaining写入通道
 */
public class FileChannleWrite2 {


    public static void main(String[] args) throws IOException {

        //构建输出流和通道
        FileOutputStream fosref = new FileOutputStream("src/main/resources/a.txt");
        FileChannel fileChannel = fosref.getChannel();

        ByteBuffer buffer1 = ByteBuffer.wrap("abcde".getBytes());
        ByteBuffer buffer2 = ByteBuffer.wrap("12345".getBytes());

        fileChannel.write(buffer1);
        System.out.println(fileChannel.position());

        //设置buffer2的当前位置为1，也就是下个取的是坐标为1的位置，对应的value是1
        buffer2.position(1);
        //buffer2 的remaing为 23
        buffer2.limit(3);
        fileChannel.write(buffer2);

        //关闭资源
        fileChannel.close();
        fosref.close();

    }


}

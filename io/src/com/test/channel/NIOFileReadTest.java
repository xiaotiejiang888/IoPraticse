package com.test.channel;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 使用通道读取文件
 */
public class NIOFileReadTest {
    public static void main(String[] args) throws IOException
    {
        RandomAccessFile raf = new RandomAccessFile("C:/windows-version.txt","rw");
        FileChannel fis = raf.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        fis.read(buffer);
        buffer.flip();
        while(buffer.hasRemaining())
        {
            System.out.print((char)buffer.get());
        }
        buffer.clear();
        fis.close();
    }
}

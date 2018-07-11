package com.test.channel;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOFileWriteTest {
    public static void main(String[] args) throws Exception
    {
        FileOutputStream fos = new FileOutputStream("d:/out.txt");
        FileChannel fc = fos.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.clear();
        String str = "Channel";
        buffer.put(str.getBytes());
        buffer.flip();
        while(buffer.hasRemaining())
        {
            fc.write(buffer);
        }
        fc.close();
        fos.close();
    }
}

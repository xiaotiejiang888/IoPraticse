package com.test.zmy.stream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**http://www.cnblogs.com/dongguacai/p/5658388.html
 * 缓冲输出流在输出的时候，不是直接一个字节一个字节的操作，而是先写入内存的缓冲区内。
 * 直到缓冲区满了或者我们调用close方法或flush方法，该缓冲区的内容才会写入目标。
 * 才会从内存中转移到磁盘上
 */
public class BufferedOutputStreamTest {
    public static void main(String[] args) throws IOException
    {
        OutputStream os = new FileOutputStream("c:/test.txt");
        OutputStream bs = new BufferedOutputStream(os);
        byte[] buffer = "中国移动阅读基地".getBytes();
        bs.write(buffer);
        /**
         * BufferedOutputStream本身没有close方法，调用的是父类FilterOutputStream的close方法
         * 这个方法的本质是在在关闭资源之前，调用的flush方法。
         * 而flush在JDK中的定义为：刷新此缓冲的输出流。这迫使所有缓冲的输出字节被写出到底层输出流中
         */
        bs.close();
        os.close();
    }
}

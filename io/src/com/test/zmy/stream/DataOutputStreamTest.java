package com.test.zmy.stream;

import java.io.*;

/**
 * http://www.cnblogs.com/dongguacai/p/5658388.html
 */
public class DataOutputStreamTest {
    public static void main(String[] args) throws IOException {
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(
                new FileOutputStream("c:/data.txt")));
        byte b = 4;
        char c = 'c';
        int i = 12;
        float f = 3.3f;
        dos.writeByte(b);
        dos.writeChar(c);
        dos.writeInt(i);
        dos.writeFloat(f);
        dos.close();
        /**
         * 打开之后，里面是乱码，程序写入之后是一个二进制文件
         */
        DataInputStream dis = new DataInputStream(new BufferedInputStream(
                new FileInputStream("c:/data.txt")));
        System.out.println(dis.readByte());
        System.out.println(dis.readChar());
        System.out.println(dis.readInt());
        System.out.println(dis.readFloat());
        dis.close();
    }
}

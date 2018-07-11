package com.test.zmy;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileOutputStreamTest {
    public static void main(String[] args) throws IOException {
        OutputStream os = new FileOutputStream("c:/test1.txt",true);
        String str = "用户6亿";
        byte[] b = str.getBytes();
        os.write(b);
        os.close();
    }
}

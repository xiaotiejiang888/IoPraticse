package com.test.zmy;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:/windows-version.txt");
        int length = 0;
        byte[] bytes = new byte[60];
        while(-1!=(length = fileInputStream.read(bytes,0,60))){
            String s = new String(bytes, 0, length);
            System.out.println(s);
        }
        fileInputStream.close();
    }
}

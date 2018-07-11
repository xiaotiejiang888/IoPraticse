package com.test.readerwriter;

import java.io.*;

/**
 * BufferedWriter、BufferedReader与字节流中的BufferedInputStream、BufferedOutputStream相对应，功能原理类似
 * OutputStreamWriter、InputStreamReader就是输入/输出体系中提供的两个转换流，用于实现将字节流转换成字符流。
 */
public class BufferedWriterTest {
    public static void main(String[] args) throws IOException
    {
//        FileOutputStream fos = new FileOutputStream("d:/data.txt");
//        OutputStreamWriter osw = new OutputStreamWriter(fos,"utf-8");
        FileWriter fileWriter = new FileWriter("d:/data.txt");
        BufferedWriter bw = new BufferedWriter(fileWriter);
        String str1 = "中国移动阅读基地";
        String str2 = "中国移动视频基地";
        bw.write(str1);
        bw.write("\r\n");
        bw.write(str2);
        bw.close();

//        FileInputStream fis = new FileInputStream("d:/data.txt");
//        InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
        FileReader fr = new FileReader("d:data.txt");
        BufferedReader br = new BufferedReader(fr);
        String str;
        while(null != (str = br.readLine()))
        {
            System.out.println(str);
        }
        br.close();
    }
}

package com.test.readerwriter;

import java.io.*;

/**
 1、使用FileReader或BufferedReader从文件中读取字符或文本数据，并总是指定字符编码；
 使用FileInputStream从Java中文件或套接字中读取原始字节流。

 2、由于BufferedReader具有一个readLine方法，可以非常方便地一次读入一行内容，
 所以经常把读取文件内容的输入流包装成BufferedReader，用来方便地读取输入流的文本内容。

 知识点TIPS

 计算机的文件常被分成文本文件和二进制文件两大类：

 1、我们不妨可以这样绝对的认为：所有能用记事本打开并且看到其中字符内容文件称为文本文件，反之则是二进制文件。

 2、其实计算机中所有的文件都是二进制文件，文本文只是二进制文件中的一个特殊的存在。如果二进制文件的内容恰好能被正常解析成字符时，则该二进制文件就可以称之为文本文件。

 3、在有些情况下，文本文件使用了错误的字符集打开，也会生成乱码。所以如果向正常使用文本文件，必须在打开文件时使用与保存文件是相同的字符集。
 */
public class BufferedWriterTest2 {
    public static void main(String[] args) throws IOException
    {

        FileWriter fileWriter = new FileWriter("d:/data.txt");

        String str1 = "中国移动阅读基地";
        String str2 = "中国移动视频基地";
        fileWriter.write(str1);
        fileWriter.write("\r\n");
        fileWriter.write(str2);
        fileWriter.close();

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

package com.test.zmy.stream;

import java.io.FileInputStream;
import java.io.IOException;

/**http://www.cnblogs.com/dongguacai/p/5658388.html
 * 读写数据的逻辑步骤为：
 *
 * open a stream
 *
 * while more information
 *
 * read/write information
 *
 * close the stream
 */
public class FileInputStreamTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:/windows-version.txt");
        /**
         * length的作用是表示在最后一次读取的时候，读取的长度小于等于buffer数组的长度，
         * while循环体执行结束后，
         * 下一次再来读取已经没有内容了，read方法在这个时候会返　　  回-1，然后跳出循环。
         */
        int length = 0;
        byte[] bytes = new byte[60];
        while(-1!=(length = fileInputStream.read(bytes,0,60))){
            String s = new String(bytes, 0, length);
            System.out.println(s);
        }
        /**
         * 对于流的操作，最后一步永远是调用close方法，释放资源
         */
        fileInputStream.close();
    }
}

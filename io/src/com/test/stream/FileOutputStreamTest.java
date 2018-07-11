package com.test.stream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * http://www.cnblogs.com/dongguacai/p/5658388.html
 */
public class FileOutputStreamTest {
    public static void main(String[] args) throws IOException {
        /**
         * 这个方法中如果指定的文件不存在，则会创建一个新的；
         * 如果指定的文件存在，在后面的写入操作会覆盖原有的内容
         * 如果第二个参数为 true，则将字节写入文件末尾处，而不是写入文件开始处。
         */
        OutputStream os = new FileOutputStream("c:/test1.txt",true);
        String str = "用户6亿";
        byte[] b = str.getBytes();
        os.write(b);
        os.close();
    }
}

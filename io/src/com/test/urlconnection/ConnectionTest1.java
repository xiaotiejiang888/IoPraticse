package com.test.urlconnection;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class ConnectionTest1 {
    public static void main(String[] args) throws IOException
    {
        URL url = new URL("http://www.baidu.com");
        URLConnection connection = url.openConnection();
        InputStream is = connection.getInputStream();
        OutputStream os = new FileOutputStream("c:/data.txt");
        byte[] buffer = new byte[1024];
        int flag = 0;
        while (-1 != (flag = is.read(buffer, 0, buffer.length)))
        {
            os.write(buffer, 0, flag);
        }
        os.close();
        is.close();
    }
}

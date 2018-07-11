package com.test.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;

public class ClientSocketTest2 {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 5555);
        InputStream is = s.getInputStream();
        byte[] buffer = new byte[1024];
        int flag = 0;
        while(-1 != (flag = is.read(buffer,0,buffer.length)))
        {
            String str = new String(buffer,0,flag);
            System.out.print(str);
        }
        PrintStream ps = new PrintStream(s.getOutputStream());
        ps.println("客户端：欢迎参加开源中国论坛");
        ps.println("客户端：欢迎参加G20峰会");
        is.close();
        ps.close();
        s.close();
    }
}

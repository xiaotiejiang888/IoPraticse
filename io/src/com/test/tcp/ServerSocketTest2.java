package com.test.tcp;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerSocketTest2 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(5555);
        Socket socket = ss.accept();
        PrintStream ps = new PrintStream(socket.getOutputStream());
        ps.println("服务器端：开源中国杭州论坛");
        ps.println("服务器端：杭州G20峰会");
        //关闭输出流，表明输出已经结束
        socket.shutdownOutput();
        //判断该socket是否关闭
        System.out.println(socket.isClosed());
        Scanner scan = new Scanner((socket.getInputStream()));
        while(scan.hasNextLine())
        {
            System.out.println(scan.nextLine());
        }
        scan.close();
        socket.close();
        ss.close();
    }
}

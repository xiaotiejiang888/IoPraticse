package com.test.tomcat.v3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SimPleServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8086);
        while (true){
            Socket socket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
            String s = in.readLine();
            System.out.println("客户端说:"+s);
            PrintStream writer = new PrintStream(socket.getOutputStream(), true);
            writer.println("HTTP/1.0 200 OK");// 返回应答消息,并结束应答
            writer.println("Content-Type:text/html;charset=utf-8");
            writer.println();
            writer.println("<html><body>");
            writer.println("hello world");
            writer.println("</html></body>");
            writer.println();// 根据 HTTP 协议, 空行将结束头信息
            writer.close();
            socket.close();//请求资源处理完毕，关闭socket链接
            continue;
        }
    }
}

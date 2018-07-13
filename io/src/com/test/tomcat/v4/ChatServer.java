package com.test.tomcat.v4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader in = null;
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            socket = serverSocket.accept();
            new ServerThread(socket).start();
            in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
            while (true){
                String s = in.readLine();
                System.out.println("客户端说:"+s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                socket.close();//请求资源处理完毕，关闭socket链接
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

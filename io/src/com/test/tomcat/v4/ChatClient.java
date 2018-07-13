package com.test.tomcat.v4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class ChatClient {
    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader in = null;
        try {
            socket = new Socket(InetAddress.getByName("192.168.0.40"), 8888);
            new ClientThread(socket).start();
            in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
            while (true){
                System.out.println("服务器说:"+in.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

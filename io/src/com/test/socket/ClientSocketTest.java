package com.test.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientSocketTest {
    public static void main(String[] args) throws IOException, Exception
    {
        Socket socket = new Socket("localhost",8888);
        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String str = br.readLine();
        System.out.println("111"+str);
        br.close();
        is.close();
        socket.close();
    }
}

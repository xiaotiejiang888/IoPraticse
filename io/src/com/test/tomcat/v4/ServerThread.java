package com.test.tomcat.v4;

import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread {
    Socket ss;
    BufferedWriter out;
    BufferedReader in;
    public ServerThread(Socket st) {
        this.ss = st;
        try {
            out = new BufferedWriter(new OutputStreamWriter(st.getOutputStream()));
            in = new BufferedReader(new InputStreamReader(System.in));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while(true){
                String s = in.readLine();
                out.write(s+"\n");
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

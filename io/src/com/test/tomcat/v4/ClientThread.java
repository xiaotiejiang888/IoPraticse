package com.test.tomcat.v4;

import java.io.*;
import java.net.Socket;

public class ClientThread extends Thread {
    Socket ss;
    BufferedWriter out;
    BufferedReader in;
    public ClientThread(Socket st) {
        this.ss = st;
        try {
            out = new BufferedWriter(new OutputStreamWriter(st.getOutputStream()));
            in = new BufferedReader(new InputStreamReader(st.getInputStream()));
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
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

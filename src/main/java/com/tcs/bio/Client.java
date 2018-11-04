package com.tcs.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	  //默认的端口号
    private static int DEFAULT_SERVER_PORT = 8080;

    private static String DEFAULT_SERVER_IP = "127.0.0.1";

    public static void send(String message) {

        send(DEFAULT_SERVER_PORT, message);
    }

    public static void send(int port, String message) {
      
        Socket socket = null;

        BufferedReader in = null;

        PrintWriter out = null;

        try {
            socket = new Socket(DEFAULT_SERVER_IP, port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            out.println(message);
         
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                in = null;

            }

            if (out != null) {
                out.close();
                out = null;

            }

            if (socket != null) {

                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                socket = null;

            }

        }
    }

}

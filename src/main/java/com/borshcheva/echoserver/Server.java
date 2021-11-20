package com.borshcheva.echoserver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(3000);
             Socket socket = serverSocket.accept();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));) {

            while (true) {
                String messageFromClient = bufferedReader.readLine();
                bufferedWriter.write("echo: " + messageFromClient);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        }
    }
}

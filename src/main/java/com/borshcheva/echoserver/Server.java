package com.borshcheva.echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(3000);
        while (true) {
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            byte[] buffer = new byte[100];
            int count = inputStream.read(buffer);
            String message = new String(buffer, 0, count);
            message = "echo " + message;
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(message.getBytes());

            inputStream.close();
            outputStream.close();

        }


    }
}

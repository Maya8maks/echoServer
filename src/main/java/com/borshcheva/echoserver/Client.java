package com.borshcheva.echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 3000);
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(message.getBytes());

        InputStream inputStream = socket.getInputStream();
        byte[] buffer = new byte[100];
        int count = inputStream.read(buffer);
        System.out.println(new String(buffer, 0, count));

        inputStream.close();
        outputStream.close();
    }
}

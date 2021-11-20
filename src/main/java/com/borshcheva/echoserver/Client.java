package com.borshcheva.echoserver;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("localhost", 3000);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        ) {
            while (true) {
                Scanner scanner = new Scanner(System.in);
                String message = scanner.nextLine();

                bufferedWriter.write(message);
                bufferedWriter.newLine();
                bufferedWriter.flush();

                String echo = bufferedReader.readLine();
                System.out.println(echo);
            }

        }

    }
}

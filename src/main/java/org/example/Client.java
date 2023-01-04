package org.example;

import java.io.*;
import java.net.Socket;

public class Client {
    private static final int PORT = 4040;
    private static final String HOST = "localhost";

    public static void main(String[] args) {
        try (Socket clientSocket = new Socket(HOST, PORT);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            out.println("Some message");
            String name = in.readLine();
            System.out.println(name);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
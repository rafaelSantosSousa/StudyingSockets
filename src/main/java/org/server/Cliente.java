package org.server;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost",4000);
        Scanner scanner = new Scanner(System.in);

        new ClienteThread(socket).start();
        PrintStream saida = new PrintStream(socket.getOutputStream());
        String teclado = scanner.nextLine();
        saida.println(teclado);




    }
}
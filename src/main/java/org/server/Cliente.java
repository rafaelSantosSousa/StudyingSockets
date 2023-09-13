package org.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws IOException {

        //1 - Abrir Conexão
        Socket socket = new Socket("127.0.0.1",54321);

        //2 - Definir Stream de saída de dados do cliente
        DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
        saida.writeUTF("rafael");

        //3 - Definir Stream de entrada de dados do cliente
        DataInputStream entrada = new DataInputStream(socket.getInputStream());
        String novaMensagem = entrada.readUTF();//Receber mensagem em maiúsculo do servidor
        System.out.println(novaMensagem);

        //4 - Fechar Streams de entrada e saída de dados
        entrada.close();
        saida.close();

        //5 - Fechar o socket
        socket.close();






    }
}
package org.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApplication {
    public static void main(String[] args) throws IOException {
        //1 - Definir o serverSocket
        ServerSocket serverSocket = new ServerSocket(54321);
        System.out.println("A porta 54321 foi aberta!");
        System.out.println("Servidor esperando receber mensagem de cliente...!");

        //2 - Aguardar solicitação de conexão de cliente
        Socket socket = serverSocket.accept();

        //Mostrar endereço IP do cliente conectado

        System.out.println("Cliente " + socket.getInetAddress().getHostAddress() + "conectado");

        //3 - Definir Stream de entrada de dados no servidor

        DataInputStream entrada = new DataInputStream(socket.getInputStream());
        String mensagem = entrada.readUTF();//receber mensagem em minusculo do cliente
        String novaMensagem = mensagem.toUpperCase(); // Converter mensagem em maiúsculo

        //4 - Definir stream de saída de dados do servidor

        DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
        saida.writeUTF(novaMensagem);

        //5 - Fechar Stream de saída de dados do servidor
        entrada.close();
        saida.close();

        //6 - Fechar sockets de comunicação e conexão

        socket.close();
        serverSocket.close();


    }
}
package org.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApplication {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //1 - Definir o serverSocket
        ServerSocket serverSocket = new ServerSocket(54321);
        System.out.println("A porta 54321 foi aberta!");
        System.out.println("Servidor esperando receber objeto de cliente...!");

        //2 - Aguardar solicitação de conexão de cliente
        Socket socket = serverSocket.accept();

        //3 - Mostrar endereço IP do cliente conectado
        System.out.println("Cliente " + socket.getInetAddress().getHostAddress() + "conectado");

        //4 - Definir Stream de entrada de dados no servidor
        ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
        Pessoa p = (Pessoa) entrada.readObject();
        System.out.println("Nome: " + p.getNome() + "\nIdade: " + p.getIdade());

        //5 - Fechar streams de entrada de dados
        entrada.close();

        //6 - Fechar sockets de comunicação e conexão
        socket.close();
        serverSocket.close();



    }
}
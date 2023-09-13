package org.server;

import java.io.*;
import java.net.Socket;

public class ThreadSockets extends Thread {

    private Socket socket;

    public ThreadSockets(Socket s) {
        this.socket = s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()); //Imprimir o nome da Thread
        try {
            //1 - Definir stream de entrada de dados no servidor
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            String mensagem = entrada.readUTF();
            String novaMensagem = mensagem.toUpperCase();

            //2 - Definir Stream de saída de dados do servidor
            DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
            saida.writeUTF(novaMensagem); // Enviando mensagem em maiusculo para cliente

            //3 - Fechar streams de entrada e saida de dados
            entrada.close();
            saida.close();

            //4 - Fechar socket de comunicação
            socket.close();
        } catch(IOException ioe){
                System.out.println("Erro: " + ioe.toString());
            }

         }
     }

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

import java.io.*;
import java.net.*;

public class Cliente {
    private static final String SERVER_ADDRESS = "localhost";  // Altere para o endereço do servidor
    private static final int SERVER_PORT = 6789;

    private DatagramSocket socket;
    private InetAddress serverAddress;

    public Cliente() {
        try {
            socket = new DatagramSocket();
            serverAddress = InetAddress.getByName(SERVER_ADDRESS);
        } catch (SocketException | UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Cliente cliente = new Cliente();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Filmes não avaliados");
            System.out.println("2 - Avaliar filme");
            System.out.println("3 - Recomendar filme");
            System.out.println("4 - Listar avaliações");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer

            String mensagem = "";
            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome de usuário: ");
                    mensagem = "1;" + scanner.nextLine();
                    break;
                case 2:
                    System.out.print("Digite o nome de usuário: ");
                    String nomeUsuario = scanner.nextLine();
                    System.out.print("Digite o nome do filme: ");
                    String nomeFilme = scanner.nextLine();
                    System.out.print("Digite a nota (de 1 a 5): ");
                    int nota = scanner.nextInt();
                    mensagem = "2;" + nomeUsuario + ";" + nomeFilme + ";" + nota;
                    break;
                case 3:
                    System.out.print("Digite o nome de usuário: ");
                    mensagem = "3;" + scanner.nextLine();
                    break;
                case 4:
                    System.out.print("Digite o nome de usuário: ");
                    mensagem = "4;" + scanner.nextLine();
                    break;
                default:
                    System.out.println("Opção inválida!");
                    continue;
            }

            cliente.enviaMensagem(mensagem);
        }
    }

    public void enviaMensagem(String mensagem) {
        try {
            byte[] sendData = mensagem.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, SERVER_PORT);
            socket.send(sendPacket);

            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);
            System.out.println("\n\n\n");
            String resposta = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Resposta do servidor:\n " + resposta);
            System.out.println("\n\n\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package Cliente;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import java.net.*;
import javax.swing.JOptionPane;

public class Cliente {
   private static final String SERVER_ADDRESS = "localhost";  
    private static final int SERVER_PORT = 6789;

    private DatagramSocket socket;
    private InetAddress serverAddress;

    public Cliente() {
        try {
            socket = new DatagramSocket();
            serverAddress = InetAddress.getByName(SERVER_ADDRESS);
        } catch (SocketException | UnknownHostException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao iniciar Cliente", JOptionPane.ERROR_MESSAGE);
           
        }
    }

    public String enviaMensagem(String mensagem) {
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
            return resposta;
        } catch (IOException e) {
            e.printStackTrace();
            return "Erro ao buscar no servidor!";
        }
    }
}

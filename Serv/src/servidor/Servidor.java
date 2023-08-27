package servidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Servidor {
    private static Data bd = null;
    private static final int PORTA = 6789;

    public static void main(String[] args) {
        DatagramSocket socket = null;
        bd = new Data();
        
        try {
            socket = new DatagramSocket(PORTA);
            System.out.println("Servidor iniciado...");

            while (true) {
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);

                String requisicao = new String(receivePacket.getData(), 0, receivePacket.getLength());
                String resposta = bd.processarRequisicao(requisicao);

                DatagramPacket sendPacket = new DatagramPacket(resposta.getBytes(), resposta.length(),
                        receivePacket.getAddress(), receivePacket.getPort());
                socket.send(sendPacket);
            }
        } catch(SocketException e) {
            System.out.println("Servidor: socket: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(socket != null) socket.close();
        }
    }
}

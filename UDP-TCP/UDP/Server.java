package UDP;

import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            // Créer un DatagramSocket pour écouter sur le port 9876
            DatagramSocket serverSocket = new DatagramSocket(9876);
            
            byte[] receiveData = new byte[1024];

            System.out.println("Serveur UDP en attente de messages...");

            while (true) {
                // Créer un DatagramPacket pour recevoir les données du client
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

                // Attendre la réception d'un paquet du client
                serverSocket.receive(receivePacket);

                // Extraire les données du paquet
                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());

                System.out.println("Message reçu du client : " + message);

                // Répondre au client
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                String responseMessage = "Message reçu avec succès!";
                byte[] sendData = responseMessage.getBytes();

                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                
                // Envoyer la réponse au client
                serverSocket.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package UDP;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            // Créer un DatagramSocket pour envoyer et recevoir des données
            DatagramSocket clientSocket = new DatagramSocket();

            // Adresse IP du serveur
            InetAddress serverAddress = InetAddress.getByName("localhost");

            // Données à envoyer au serveur
            String message = "Bonjour, serveur!";
            byte[] sendData = message.getBytes();

            // Créer un DatagramPacket pour envoyer les données au serveur
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 9876);

            // Envoyer le paquet au serveur
            clientSocket.send(sendPacket);

            byte[] receiveData = new byte[1024];

            // Créer un DatagramPacket pour recevoir la réponse du serveur
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            // Attendre la réponse du serveur
            clientSocket.receive(receivePacket);

            // Extraire les données de la réponse
            String responseMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());

            System.out.println("Réponse du serveur : " + responseMessage);

            // Fermer le socket
            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



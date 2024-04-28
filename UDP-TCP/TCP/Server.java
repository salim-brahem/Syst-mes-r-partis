package TCP;
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            // Créer un ServerSocket qui écoute sur le port 6789
            ServerSocket serverSocket = new ServerSocket(6789);
            
            System.out.println("Serveur TCP en attente de connexions...");

            while (true) {
                // Accepter la connexion d'un client
                Socket clientSocket = serverSocket.accept();
                
                System.out.println("Client connecté.");

                // Créer des flux d'entrée et de sortie pour la communication avec le client
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                // Lire le message envoyé par le client
                String message = in.readLine();
                System.out.println("Message reçu du client : " + message);

                // Envoyer une réponse au client
                out.println("Message reçu avec succès!");

                // Fermer les flux et le socket du client
                in.close();
                out.close();
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

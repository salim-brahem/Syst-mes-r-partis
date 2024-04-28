package TCP;
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            // Créer une socket pour se connecter au serveur sur le port 6789
            Socket socket = new Socket("localhost", 6789);
            
            // Créer des flux d'entrée et de sortie pour la communication avec le serveur
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Envoyer un message au serveur
            out.println("Bonjour, serveur!");

            // Lire la réponse du serveur
            String response = in.readLine();
            System.out.println("Réponse du serveur : " + response);

            // Fermer les flux et la socket
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

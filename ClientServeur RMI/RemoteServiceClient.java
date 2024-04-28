package RMI;


import java.rmi.Naming;

public class RemoteServiceClient {
    public static void main(String[] args) {
        try {
            // Localiser le service distant en utilisant le nom
            RemoteService remoteService = (RemoteService) Naming.lookup("RemoteService");

            // Appeler la méthode à distance avec une chaîne en entrée
            String result = remoteService.performOperation("Hello, RMI!");

            // Afficher le résultat
            System.out.println("Résultat de l'opération à distance : " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
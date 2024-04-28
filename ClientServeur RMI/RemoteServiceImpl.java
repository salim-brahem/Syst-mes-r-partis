package RMI;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class RemoteServiceImpl extends UnicastRemoteObject implements RemoteService {

    public RemoteServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String performOperation(String input) throws RemoteException {
        // Exemple de traitement : conversion de la chaîne en majuscules
        return input.toUpperCase();
    }

    public static void main(String[] args) {
        try {
           
            LocateRegistry.createRegistry(5000);

            RemoteService service = new RemoteServiceImpl();

           
            Naming.rebind("//localhost/RemoteService", service); // Ajout de la spécification de l'hôte

            System.out.println("Serveur RMI prêt.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
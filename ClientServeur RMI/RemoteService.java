package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteService extends Remote {
    String performOperation(String input) throws RemoteException;
}
package signature;

import auxiliar.Node;

import java.nio.channels.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by tales on 14/07/14.
 */
public interface ClusterService extends Remote {
    public boolean testNode(Node node) throws RemoteException,AlreadyBoundException,NotBoundException;

    public String testCluster() throws RemoteException,AlreadyBoundException,NotBoundException;

    public void addStorage(Node node) throws RemoteException,AlreadyBoundException,NotBoundException;

}

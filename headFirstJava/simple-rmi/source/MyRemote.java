import java.rmi.*;

interface MyRemote extends Remote{
    String hello() throws RemoteException;
}

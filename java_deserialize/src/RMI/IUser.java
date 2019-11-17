package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IUser extends Remote {
	public void setName(String name) throws RemoteException;
	public String getName() throws RemoteException;
}

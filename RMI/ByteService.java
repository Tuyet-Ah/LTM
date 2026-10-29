package RMI;
import java.io.*;
import java.util.*;
import java.rmi.*;
import java.rmi.Remote;

public interface ByteService extends Remote {
    public byte[] requestData(String studentCode, String qCode) throws RemoteException;
    public void submitData(String studentCode, String qCode, byte[] data) throws RemoteException;
}

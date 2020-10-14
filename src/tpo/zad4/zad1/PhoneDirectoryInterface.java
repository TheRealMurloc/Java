package tpo.zad4.zad1;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PhoneDirectoryInterface extends Remote {

    public String getPhoneNumber(String nameToGetNumber) throws RemoteException;

    public boolean addPhoneNumber(String nameToAdd, String numberToAdd) throws RemoteException;

    public boolean replacePhoneNumber(String nameToReplaceNumber, String newNumber) throws RemoteException;

}
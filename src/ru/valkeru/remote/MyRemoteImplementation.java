package ru.valkeru.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyRemoteImplementation extends UnicastRemoteObject implements MyRemote {
  MyRemoteImplementation() throws RemoteException {
  }

  @Override
  public String sayHello() throws RemoteException {
    return "Hi! I am remote server!";
  }
}

package ru.valkeru.remote;

import java.rmi.Naming;

public class Main {
  public static void main(String[] args) {
    try {
      MyRemoteImplementation myRemote = new MyRemoteImplementation();
      Naming.rebind("RHello", myRemote);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

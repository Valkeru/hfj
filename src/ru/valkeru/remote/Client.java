package ru.valkeru.remote;

import java.rmi.Naming;

public class Client {
  public static void main(String[] args) {
    try {
      MyRemote service = (MyRemote) Naming.lookup("rmi://localhost/RHello");
      System.out.println(service.sayHello());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

package ru.valkeru.chat.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class Client {
  private String message;
  private Socket socket;
  private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  private PrintWriter writer;
  private static final int SERVER_PORT = 13666;

  void init() {
    try {
      socket = new Socket("localhost", SERVER_PORT);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  boolean isReady() {
    return socket != null;
  }

  String getMessageToSend() {
    try {
      message = reader.readLine();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return message;
  }

  void sendMessage(String message) {
    try {
      writer = new PrintWriter(socket.getOutputStream());
      writer.println(message);
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  String getMessageFromServer() {
    try {
      BufferedReader reader = new BufferedReader(
              new InputStreamReader(socket.getInputStream())
      );

      String incomingMessage = reader.readLine();
      reader.close();

      return incomingMessage;
    } catch (IOException e) {
      e.printStackTrace();

      return null;
    }
  }

  void inactivate() {
    try {
      reader.close();
      if (writer != null) {
        writer.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

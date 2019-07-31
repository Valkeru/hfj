package ru.valkeru.chat.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

class Server {
  ServerSocket serverSocket;

  void run() {
    try {
      serverSocket = new ServerSocket(13666);

      while (true) {
        Socket socket = serverSocket.accept();
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
        );

        String incomingMessage = bufferedReader.readLine();
        System.out.println(incomingMessage);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

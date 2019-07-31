package ru.valkeru.chat.client;

public class ClientMain {
  public static void main(String[] args) {
    Client client = new Client();
    client.init();

    if (!client.isReady()) {
      return;
    }

    while (true) {
      String message = client.getMessageToSend();
      if (message == null) {
        return;
      }

      if (message.equals(":q")) {
        client.inactivate();

        return;
      }

      client.sendMessage(message);
    }
  }
}

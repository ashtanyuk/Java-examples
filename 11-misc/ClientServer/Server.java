import java.io.*;
import java.net.*;

public class Server {

  public static void main(String[] args) throws IOException {
    System.out.println("Старт сервера");
    BufferedReader in = null;
    PrintWriter    out= null;

    ServerSocket server = null;
    Socket       client = null;

    // создаем серверный сокет
    try {
      server = new ServerSocket(1234);
    } catch (IOException e) {
      System.out.println("Ошибка связывания с портом 1234");
      System.exit(-1);
    }

    try {
      System.out.print("Ждем соединения");
      client= server.accept();
      System.out.println("Клиент подключился");
    } catch (IOException e) {
      System.out.println("Не могу установить соединение");
      System.exit(-1);
    }

    in  = new BufferedReader(
          new InputStreamReader(client.getInputStream()));
    out = new PrintWriter(client.getOutputStream(),true);
    String input,output;

    System.out.println("Ожидаем сообщений");
    while ((input = in.readLine()) != null) {
     if (input.equalsIgnoreCase("exit")) 
       break;
     out.println("Сервер: "+input);
     System.out.println(input);
    }
    out.close();
    in.close();
    client.close();
    server.close();
  }
}
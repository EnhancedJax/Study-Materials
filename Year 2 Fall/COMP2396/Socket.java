/* ---------------------------------- */
/*           Multithreading           */
/* ---------------------------------- */
public class Main implements Runnable {
  public static int a, b;

  public static void main(String[] args) {
    a = 100; b = 100;
    Thread thread1 = new Thread(new Main());
    Thread thread2 = new Thread(new Main());
    thread1.start(); thread2.start();
    // Wait for the threads to finish running
    try {
        thread1.join(); thread2.join();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    // do something after threads finish
    // if we don't need to do anything, 
    // we can remove the try-catch block
    }
  public void run() {
    for (int i = 0; i < 10000000; i++) {transfer();}
  }
  // synchronized: only one thread can access this method at a time
  public static synchronized void transfer() {
    (a > b ? a--;b++ : a++;b--);
  }
"""
Obj’s Lock
- come into play when there are synchronized methods
- only 1 key even if >=1 synchronized method
- once a thread enters, no other threads can enter any synchronized
methods on the same obj
Deadlock Problem
- When two threads are holding a key the other thread wants
- Java has no mechanism to handle deadlock
"""
}
/* ---------------------------------- */
/*             Networking             */
/* ---------------------------------- */
import java.io.*;
import java.net.*;
public class Client {
  Socket sock;
  public static void main(String[] args) {
    try {
      // Connect to the server
      Socket sock = new Socket("localhost", 1234); 
      // localhost: server IP, 1234: port number
      System.out.println("Connected to server");

      // Create a thread to listen for messages from the server
      new Thread(() -> {
        try {
          BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
          String serverMessage;
          while ((serverMessage = in.readLine()) != null) {
            System.out.println("Server says: " + serverMessage);
          }
        } catch (IOException e) {
          e.printStackTrace();
        }
      }).start();

      // Send messages to the server
      PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
      BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
      String clientMessage;
      while ((clientMessage = userInput.readLine()) != null) {
        out.println(clientMessage);
      }

      // Close the socket
      sock.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
public class Server {
  ServerSocket serverSock;
  public static void main(String[] args) {
    try {
      ServerSocket serverSock = new ServerSocket(1234); // 1234: port number
      while (true) {
        // Wait for client to connect
        Socket sock = serverSock.accept(); // waits for client to connect, returns a socket
        System.out.println("Client connected");

        // Create a thread to listen for messages from the client
        new Thread(() -> {
          try {
            BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            String clientMessage;
            while ((clientMessage = in.readLine()) != null) {
                System.out.println("Client says: " + clientMessage);
            }
          } catch (IOException e) {
            e.printStackTrace();
          }
        }).start();

        // Send messages to the client
        PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
        BufferedReader serverInput = new BufferedReader(new InputStreamReader(System.in));
        String serverMessage;
        while ((serverMessage = serverInput.readLine()) != null) {
          out.println(serverMessage);
        }

        // Close the socket
        sock.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
package ar.com.unpaz.gestionfinales.console;

import java.util.Scanner;

public class ConsoleReader {

  private static Scanner scanner;
  
  static {
    scanner = new Scanner(System.in);
  }
  
  public int readInteger() {
    return scanner.nextInt();
  }
  
  public void close() {
    scanner.close();
  }
  
}

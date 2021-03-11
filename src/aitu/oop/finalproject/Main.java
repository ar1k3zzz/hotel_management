package aitu.oop.finalproject;

import java.sql.*;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Menu.printMenu();
        Menu.getMenuOption(scanner.nextInt());
    }
}

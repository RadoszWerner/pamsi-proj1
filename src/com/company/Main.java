package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        TerminalMsg terminalMsg1 = new TerminalMsg();
        int c = 0;
        while (c != 3) {
            System.out.println("1. Napisz wiadomość w terminalu.");
            System.out.println("2. Wczytaj wiadomość z pliku txt.");
            System.out.println("3. Zakończ program");
            System.out.println("Twoj wybór: ");
            Scanner scanner = new Scanner(System.in);
            c = scanner.nextInt();
            switch (c) {
                case 1:
                    terminalMsg1.InsertMessage();
                    terminalMsg1.ViewMessage();
                    break;
                case 2:
                    //LoadMsg();
                    break;
                default:
                    break;
            }
        }
    }
}

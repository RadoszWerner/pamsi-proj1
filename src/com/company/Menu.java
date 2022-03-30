package com.company;

import java.util.Scanner;

public class Menu {
    public Menu(){
        MsgManager msgManager = new MsgManager();
        int c = 0;
        while (c != 3) {
            System.out.println("1. Napisz wiadomość w terminalu.");
            System.out.println("2. Odczytaj wiadomość");
            System.out.println("3. Zakończ program");
            System.out.println("");
            System.out.println("Twoj wybór: ");
            Scanner scanner = new Scanner(System.in);
            c = scanner.nextInt();
            System.out.println("");
            switch (c) {
                case 1 -> msgManager.sendMyMsg();
                case 2 -> msgManager.receiveMyMsg();
                default -> {
                }
            }
            //Wszystko czego tylko dotkne to staje sie zlotem to staje sie zlotem midas midas midas
            //proline
        }
    }
}


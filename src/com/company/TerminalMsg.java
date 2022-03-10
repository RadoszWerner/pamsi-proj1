package com.company;

import java.util.Scanner;

public class TerminalMsg {
    String fullTxtMsg;
    public void InsertMessage(){
        System.out.println("Podaj swoją wiadomość:");
        Scanner scanner = new Scanner(System.in);
        fullTxtMsg = scanner.nextLine();
    }
    public void ViewMessage(){
        System.out.println("Twoja wiadomość:");
        System.out.println(fullTxtMsg);
    }
}

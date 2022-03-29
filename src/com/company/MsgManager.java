package com.company;

import java.util.Scanner;

public class MsgManager {
    
    String fullTxtMsg;
    MsgStack stackedTxtMsg = new MsgStack();
    int packageSize = 10;


    public void InsertMessage(){
        System.out.println("Podaj swoją wiadomość:");
        Scanner scanner = new Scanner(System.in);
        fullTxtMsg = scanner.nextLine();
    }

    public void ViewMessage(){
        System.out.println("Twoja wiadomość:");
        System.out.println(fullTxtMsg);
    }

    public void ConvertMsg(int number) {

        String tempTextMsg=fullTxtMsg;
        String msg;
        int iterator = 0;
        while(tempTextMsg!=null){
            if(tempTextMsg.length()>number){
                msg=tempTextMsg.substring(0, number);
                tempTextMsg=tempTextMsg.substring(number);
                stackedTxtMsg.insert(iterator, msg);
                iterator++;
            }
            else{
                stackedTxtMsg.insert(iterator++, tempTextMsg);
                tempTextMsg=null;
            }
        }
    }

//    public void showConvertedMsg(){
//        try {
//            stackedTxtMsg.showMsgStack();
//        }
//        catch(Exception e){
//            System.out.println(e.getMessage());
//        }
//    }

//    public MsgStack shuffleMsg(MsgStack stackedTxtMsg){
//        try {
//            return(stackedTxtMsg.shuffle());
//        }
//        catch(Exception e){
//            System.out.println(e.getMessage());
//        }
//        return stackedTxtMsg;
//    }

//    public MsgStack sortMsg(MsgStack stackedTxtMsg){
//        try{
//            return(stackedTxtMsg.sort());
//        }
//        catch(Exception e){
//            System.out.println(e.getMessage());
//        }
//        return stackedTxtMsg;
//    }

    public void sendMyMsg(){
        InsertMessage();
        ConvertMsg(packageSize);
        try {
            stackedTxtMsg = stackedTxtMsg.shuffle();
            System.out.println("Wysłano wiadomość!");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void receiveMyMsg(){
        try {
            stackedTxtMsg = stackedTxtMsg.sort();
            System.out.println("Odebrano wiadomość!: ");
            stackedTxtMsg.showWholeMsg();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}


package com.company;

import java.util.Scanner;

public class MsgManager {

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

    public void ConvertMsg(int number, MsgStack ourMsg) {

        String tempTextMsg=fullTxtMsg;
        String msg;
        int iterator = 0;
        while(tempTextMsg!=null){
            if(tempTextMsg.length()>number){
                msg=tempTextMsg.substring(0, number);
                tempTextMsg=tempTextMsg.substring(number);
                ourMsg.insert(iterator, msg);
                iterator++;
            }
            else{
                ourMsg.insert(iterator++, tempTextMsg);
                tempTextMsg=null;
            }
        }
    }

    public void showConvertedMsg(MsgStack ourMsg){
        try {
            ourMsg.showMsgStack();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}


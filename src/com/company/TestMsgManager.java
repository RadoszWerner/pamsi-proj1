package com.company;

public class TestMsgManager {
    public static void main(String[] args) {
        MsgManager msgManager = new MsgManager();
        MsgStack shuffledMsg = new MsgStack();
        MsgStack sortedMsg = new MsgStack();
        MsgStack ourMsg = new MsgStack();
        msgManager.insertMessage();
        msgManager.viewMessage();
        msgManager.convertMsg(10);
//        msgManager.showConvertedMsg();
//        shuffledMsg = msgManager.shuffleMsg(ourMsg);
//        msgManager.showConvertedMsg();
//        sortedMsg = msgManager.sortMsg(shuffledMsg);
//        msgManager.showConvertedMsg();
    }
}

package com.company;

public class TestMsgManager {
    public static void main(String[] args) {
        MsgManager msgManager = new MsgManager();
        MsgStack ourMsg = new MsgStack();
        msgManager.InsertMessage();
        msgManager.ViewMessage();
        msgManager.ConvertMsg(10, ourMsg);
        msgManager.showConvertedMsg(ourMsg);
    }
}

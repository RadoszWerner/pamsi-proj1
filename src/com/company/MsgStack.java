package com.company;

public class MsgStack {
    private String value;
    private int key;
    private MsgStack msgPackage;


    public MsgStack() {
    }

    public MsgStack(String value, int key) {
        this.value = value;
        this.key = key;
        msgPackage = null;
    }

    public MsgStack(String value, int key, MsgStack msgPackage) {
        this.value = value;
        this.key = key;
        this.msgPackage = msgPackage;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public MsgStack getMsgPackage() {
        return msgPackage;
    }

    public void setMsgPackage(MsgStack msgPackage) {
        this.msgPackage = msgPackage;
    }

    public void insert(String value, int key){
        MsgStack newPackage = new MsgStack(value, key);
        newPackage.msgPackage = null;
        msgPackage = newPackage;
    }

    public void delElement(){
        msgPackage = null;
    }

    public boolean isEmpty(){
        if (msgPackage==null){
            return true;
        }
        else{
            return false;
        }
    }





}

package com.company;

public class TestMsgStack {
    public static void main(String[] args) {
        MsgStack testMsgStack = new MsgStack();
        int[] keys = {2,3,45,7,8,9,8888,0};
        String[] values = {"a","b","c","d","e","f","g","h"};
        for (int i = 0; i< values.length-1 ; i++){
            testMsgStack.insert(keys[i],values[i]);
        }
        try {
            testMsgStack.popHead();
        }
        catch(EmptyException xxx){
            System.out.println(xxx.getMessage());
        }
    }
}

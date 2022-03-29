package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class MsgStack implements Cloneable{

    private Package head;
    private Package tail;
    private int size;

    public MsgStack() {
        size = 0;
        head = new Package();
        tail = new Package();
    }

    public boolean isEmpty(){
        return(size == 0);
    }

    public void insert(int key, String value) {
        if (isEmpty()) {
            head = tail = new Package(key, value);
        }
        else {
            Package newPackage = new Package(key, value, head);
            head.nextPackage = newPackage;
            head = newPackage;
        }
        size++;
    }

    public Package popHead() throws EmptyException {
        if(size == 0){
            throw new EmptyException("Stos pusty!");
        }
        else if (size>1) {
            int key = head.key;
            String value = head.value;
            Package tempPackage = new Package(key, value);
            head.previousPackage.nextPackage = null;
            head = head.previousPackage;
            --size;
            return tempPackage;
        }
        else{
            int key = head.key;
            String value = head.value;
            Package tempPackage = new Package(key, value);
            --size;
            return tempPackage;
        }
    }

    public Package showHead() throws EmptyException {
        if(size == 0){
            throw new EmptyException("Stos pusty!");
        }
        else if (size>1) {
            int key = head.key;
            String value = head.value;
            Package tempPackage = new Package(key, value);
            return tempPackage;
        }
        else{
            int key = head.key;
            String value = head.value;
            Package tempPackage = new Package(key, value);
            return tempPackage;
        }
    }

    public void showMsgStack() throws EmptyException{
        if(size == 0){
            throw new EmptyException("Stos pusty!");
        }else {
            try{
                MsgStack tempPackageList = (MsgStack) this.clone();
                for (int i = 0; i < size; i++) {
                    Package tempPackage = tempPackageList.popHead();
                    System.out.println("Key: " + tempPackage.key + " . Value: " + tempPackage.value);
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void showWholeMsg() throws EmptyException{
        if(size == 0){
            throw new EmptyException("Stos pusty!");
        }else {
            try{
                MsgStack tempPackageList = (MsgStack) this.clone();
                System.out.println("");
                for (int i = 0; i < size; i++) {
                    Package tempPackage = tempPackageList.popHead();
                    System.out.print(tempPackage.value);
                }
                System.out.println("");
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public MsgStack shuffle() throws EmptyException {
        if(size == 0){
            throw new EmptyException("Stos pusty!");
        }
        else{
            ArrayList<Integer> numbers = new ArrayList<>();
            for (int i = 0; i < size ; i++) {
                numbers.add(i);
            }
            Collections.shuffle(numbers);
            MsgStack shuffledStack = new MsgStack();
            try {
                for (int i = 0; i < size; i++) {

                    MsgStack tempPackageList = (MsgStack) this.clone();

                    int drawnNumber = numbers.remove(0);
                    for (int j = 0; j < size; j++) {
                        Package tempPackage = tempPackageList.popHead();

                        if (tempPackage.getKey() == drawnNumber) {
                            shuffledStack.insert(tempPackage.getKey(), tempPackage.getValue());
                        }
                    }
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            return shuffledStack;
        }
    }

    public MsgStack sort() throws EmptyException{
        if (size==0){
            throw new EmptyException("Stos pusty!");
        }
        MsgStack sortedStack = new MsgStack();
        System.out.println("Sprawdzamy, czy stos nie jest pusty (tylko dla 1 operacji)");
        while(!isEmpty()){
            Package oldPackage = popHead();

            if (sortedStack.isEmpty()) {
                System.out.println("Stos docelowy jest pusty, wiec wrzucamy pierwsza wartosc - "+oldPackage.getKey() + ".");
            }
            else{
                System.out.println("sprawdzamy czy wartosc key elementu z stosu tymczasowego ("+oldPackage.getKey()+")");
                System.out.println("jest większy od wartosci key elementu z docelowo posortowanego stosu ("+sortedStack.showHead().getKey() + ")");
            }

            while(!sortedStack.isEmpty() && sortedStack.showHead().getKey() < oldPackage.getKey()){
                System.out.println(oldPackage.getKey() + " jest większy od " + sortedStack.showHead().getKey() + " wiec zwracamy go do stosu do posortowania.");
                Package tempPackage = sortedStack.popHead();
                insert(tempPackage.getKey(), tempPackage.getValue());
            }

            if (sortedStack.isEmpty()) {
                System.out.println("");
            }
            else{
                System.out.println(oldPackage.getKey() + " jest mniejsze od " + sortedStack.showHead().getKey() + " wiec dodajemy "+ oldPackage.getKey()+  " do stosu posortowanego.");
            }

            sortedStack.insert(oldPackage.getKey(), oldPackage.getValue());

        }
        return sortedStack;
    }

    public Package getHead() {
        return head;
    }

    public void setHead(Package head) {
        this.head = head;
    }

    public Package getTail() {
        return tail;
    }

    public void setTail(Package tail) {
        this.tail = tail;
    }

    private static final class Package {
        private int key;
        private String value;
        private Package nextPackage, previousPackage;

        public Package(int key, String value, Package previousPackage) {
            this.key = key;
            this.value = value;
            this.previousPackage = previousPackage;
            this.nextPackage = null;
        }

        public Package getPreviousPackage() {
            return previousPackage;
        }

        public void setPreviousPackage(Package previousPackage) {
            this.previousPackage = previousPackage;
        }

        public Package getNextPackage() {
            return nextPackage;
        }

        public void setNextPackage(Package nextPackage) {
            this.nextPackage = nextPackage;
        }

        public Package() {
        }

        public Package(int key, String value) {
            this.key = key;
            this.value = value;
            nextPackage = null;
            previousPackage = null;
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
    }

}

package com.company;

public class MsgStack {

    private Package head, tail;
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

    public void popHead() throws EmptyException {
        if(size == 0){
            throw new EmptyException("No packages!");
        }
        else{
            head.previousPackage.nextPackage = null;
            head = head.previousPackage;

        }
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

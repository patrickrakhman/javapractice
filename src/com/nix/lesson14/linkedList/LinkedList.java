package com.nix.lesson14.linkedList;

public class LinkedList {
    class Element {
        int data;
        Element next;

        public Element(int data){
            this.data = data;
        }
    }

    Element head;
    int size;
    public void add(int data) {
        if (head == null) {
            head = new Element(data);
            size += 1;
            return;
        }

        Element current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Element(data);
        size += 1;
    }


    public int getSize() {
        return size;
    }

    public void add(int data, int index) {

        if (index > getSize()) {
            return;
        }

        Element current = head;
        int pos = 0;
        Element newNode = new Element(data);

        if (index == 0)
        {
            newNode.next = head;
            head = newNode;
            size += 1;
            return;
        }
        while (current.next != null) {
            if (pos == index - 1) {
                break;
            }
            pos++;
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;
        size += 1;

    }


    public void print() {

        if(getSize() == 0) {
            return;
        }
        Element current = head;
        while (current.next != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.print(current.data + "\n");
    }
}



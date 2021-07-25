package com.nix.lesson14.linkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList lt = new LinkedList();
        lt.print();
        lt.add(3);
        lt.add(5);
        lt.add(6);
        lt.print();
        lt.add(4);
        lt.print();
        lt.add(4);// 7 is an invalid index
        lt.add(8);
        lt.print();
    }
}

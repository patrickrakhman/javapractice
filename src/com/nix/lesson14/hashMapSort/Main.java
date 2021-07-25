package com.nix.lesson14.hashMapSort;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Phone phone1 = new Phone("Apple","12",  800);
        Phone phone2 = new Phone("Samsung","S22",  600);
        Phone phone3 = new Phone("Google","Pixel",  500);
        Phone phone4 = new Phone("Apple","11",  600);
        Phone phone5 = new Phone("Apple","11",  600);

        HashMap<Integer, Phone> phones = new HashMap<>();

        phones.put(1, phone1);
        phones.put(2, phone2);
        phones.put(3, phone3);
        phones.put(4, phone4);
        phones.put(5, phone4);


        System.out.println("Phones collection: \n" + phones.entrySet());
        System.out.println();
        System.out.println("Sorted by value: ");
        HashMapSort.sortByValue(phones);
        System.out.println();
        System.out.println("Sorted by key: ");
        HashMapSort.sortByKey(phones);
        System.out.println();

    }
}

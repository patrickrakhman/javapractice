package com.nix.lesson14.hashMapSort;

import java.util.*;

public class HashMapSort {
    public static void sortByValue(HashMap<Integer, Phone> entry) {

        List<Phone> values = new ArrayList<>(entry.values());
        Collections.sort(values);

        StringBuilder stringbuilder = new StringBuilder();

        for (int i = 0; i < entry.size(); i++) {
            Phone phone = values.get(i);

            for (Map.Entry<Integer, Phone> e : entry.entrySet()) {
                if (e.getValue().equals(phone)) {
                    stringbuilder.append(e.getKey().toString()).append(" = ").append(phone.toString()).append("\n");
                    break;
                }
            }
        }
        System.out.println(stringbuilder);
    }

    public static void sortByKey(HashMap<Integer, Phone> entry) {
        List<Integer> keys = new ArrayList<>(entry.keySet());
        List<Phone> values = new ArrayList<>(entry.values());
        Collections.sort(values);
        Collections.sort(keys);

        StringBuilder stringbuilder = new StringBuilder();

        for (int i = 0; i < entry.size(); i++) {
            Integer orderedKey = keys.get(i);

            for (Map.Entry<Integer, Phone> e : entry.entrySet()) {
                if (e.getKey().equals(orderedKey)) {
                    stringbuilder.append(e.getKey().toString()).append("=").append(e.getValue().toString()).append("\n");
                    break;
                }
            }
        }
        System.out.println(stringbuilder);
    }
}

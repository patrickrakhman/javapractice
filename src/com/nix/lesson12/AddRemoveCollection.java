package com.nix.lesson12;

import java.util.Collection;
import java.util.Objects;

public class AddRemoveCollection {
    static void add(Collection<Integer> collection, int count) {
        for (int i = 0; i < count; i++) {
            collection.add(i);
        }
    }

    static void remove(Collection<Integer> collection) {
        collection.removeIf(Objects::nonNull);
    }

    static String getCollectionClassName(Collection<?> collection) {
        return  collection.getClass().getSimpleName();
    }
}

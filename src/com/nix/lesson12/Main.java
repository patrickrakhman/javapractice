package com.nix.lesson12;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        int count;
        int iter;

        List<Integer> arraylist = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        Set<Integer> treeSet = new TreeSet<>();

        Collection<?>[] collections = {arraylist, linkedList, hashSet, linkedHashSet, treeSet};


        Scanner in = new Scanner(System.in);
        System.out.println("Input count:");
        count = in.nextInt();
        System.out.println("Input iter:");
        iter = in.nextInt();

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Results:\nCount: ")
                .append(count)
                .append(", Iterations: ")
                .append(iter)
                .append("\n");

        for (Collection<?> collection : collections) {

            stringBuilder.append(AddRemoveCollection.getCollectionClassName(collection)).append("\n");

            for (int i = 1; i <= iter; i++) {

                long start = System.currentTimeMillis();

                AddRemoveCollection.add(arraylist, count);

                long end = System.currentTimeMillis() - start;
                stringBuilder.append("Add: ").append(end).append("\n");

                start = System.currentTimeMillis();

                AddRemoveCollection.remove(arraylist);

                end = System.currentTimeMillis() - start;
                stringBuilder.append("Remove: ").append(end).append("\n\n");
            }
        }
        System.out.println(stringBuilder.toString());
        //FileManager.writeToFile(stringBuilder.toString());
        try(
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FileType.FILE_PATH.getPath(), false));
                BufferedReader bufferedReader = new BufferedReader(new FileReader(FileType.FILE_PATH.getPath()))
        ) {

            bufferedWriter.write(stringBuilder.toString());
            bufferedWriter.flush();
            bufferedReader.lines().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }



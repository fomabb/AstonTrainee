package io.nikolay.kirilyuk.astontrainee.collection;

import io.nikolay.kirilyuk.astontrainee.collection.custom.CustomList;
import io.nikolay.kirilyuk.astontrainee.collection.custom.CustomArrayListImpl;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        CustomList<Integer> list = new CustomArrayListImpl<>();

        list.add(0, 1);
        list.add(1, 2);
        list.add(2, 3);
        System.out.println("List after adding element at index 1: " + Arrays.toString(list.toArray()));

        list.remove((Integer) 2);
        System.out.println("List after removing element 2: " + Arrays.toString(list.toArray()));

        list.clear();

        list.addAll(Arrays.asList(25, 35, 40));
        System.out.println("List after adding collection: " + Arrays.toString(list.toArray()));

        System.out.println("Element at index 2: " + list.get(2));

        list.remove(2);
        System.out.println("List after removing element at index 2: " + Arrays.toString(list.toArray()));

        list.update(1, 50);
        System.out.println("List after updating element at index 1 to 50: " + Arrays.toString(list.toArray()));

        list.clear();
        System.out.println("List after clear: " + Arrays.toString(list.toArray()));

        System.out.println("Is list empty? " + list.isEmpty());

        list.addAll(Arrays.asList(5, 3, 8, 1, 2));
        System.out.println("List after adding elements: " + Arrays.toString(list.toArray()));

        list.sort(Comparator.naturalOrder());
        System.out.println("List after sorting: " + Arrays.toString(list.toArray()));
    }
}

package io.nikolay.kirilyuk.astontrainee.collections;

import io.nikolay.kirilyuk.astontrainee.collections.custom.ICustomArrayList;
import io.nikolay.kirilyuk.astontrainee.collections.custom.CustomArrayListImpl;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ICustomArrayList<Integer> list = new CustomArrayListImpl<>();

        // Test add(int index, E element)
        list.add(0, 1);
        list.add(1, 2);
        list.add(2, 3);
        System.out.println("List after adding element at index 1: " + Arrays.toString(list.toArray()));

        // Test remove(Object o)
        list.remove((Object) 2);
        System.out.println("List after removing element 15: " + Arrays.toString(list.toArray()));

        list.clear();

        // Test addAll(Collection<? extends E> c)
        list.addAll(Arrays.asList(25, 35, 40));
        System.out.println("List after adding collection: " + Arrays.toString(list.toArray()));

        // Test get(int index)
        System.out.println("Element at index 2: " + list.get(2));

        // Test remove(int index)
        list.remove(2);
        System.out.println("List after removing element at index 2: " + Arrays.toString(list.toArray()));

        // Test update(int index, E e)
        list.update(1, 50);
        System.out.println("List after updating element at index 1 to 50: " + Arrays.toString(list.toArray()));

        // Test clear()
        list.clear();
        System.out.println("List after clear: " + Arrays.toString(list.toArray()));

        // Test isEmpty()
        System.out.println("Is list empty? " + list.isEmpty());

        // Add elements back to the list
        list.addAll(Arrays.asList(5, 3, 8, 1, 2));
        System.out.println("List after adding elements: " + Arrays.toString(list.toArray()));

        // Test sort(Comparator<? super E> c)
        list.sort(Comparator.naturalOrder());
        System.out.println("List after sorting: " + Arrays.toString(list.toArray()));
    }
}

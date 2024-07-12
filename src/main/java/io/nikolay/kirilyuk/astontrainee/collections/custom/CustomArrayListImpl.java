package io.nikolay.kirilyuk.astontrainee.collections.custom;

import java.util.*;

public class CustomArrayListImpl<E> implements ICustomArrayList<E> {

    private E[] values;
    private int size;

    public CustomArrayListImpl() {
        values = (E[]) new Object[10];
        size = 0;
    }

    @Override
    public boolean add(E e) {
        try {
            E[] temp = values;
            values = (E[]) new Object[temp.length + 1];
            System.arraycopy(temp, 0, values, 0, temp.length);
            values[values.length - 1] = e;
            return true;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > values.length) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        ensureCapacity(size + 1);
        System.arraycopy(values, index, values, index + 1, size - index);
        values[index] = element;
        size++;
    }

    @Override
    public void addAll(Collection<? extends E> c) {
        ensureCapacity(size + c.size());
        for (E e : c) {
            values[size++] = e;
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            values[i] = null;
        }
        size = 0;
    }

    @Override
    public void remove(int index) {
        try {
            E[] temp = values;
            values = (E[]) new Object[temp.length - 1];
            System.arraycopy(temp, 0, values, 0, index);
            System.arraycopy(temp, index + 1, values, index, temp.length - index - 1);
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (values[i].equals(o)) {
                remove(i);
                return;
            }
        }
    }

    @Override
    public E get(int index) {
        return values[index];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public void update(int index, E e) {
        values[index] = e;
    }

    @Override
    public void sort(Comparator<? super E> c) {

        //Stream
//        List<E> sortedList = Arrays.stream(values, 0, size)
//                .sorted(c)
//                .toList();
//
//        for (int i = 0; i < size; i++) {
//            values[i] = sortedList.get(i);
//        }

        // MergeSort
        mergeSort(values, 0, size - 1, c);
    }

    private void mergeSort(E[] array, int left, int right, Comparator<? super E> c) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(array, left, middle, c);
            mergeSort(array, middle + 1, right, c);
            merge(array, left, middle, right, c);
        }
    }

    private void merge(E[] array, int left, int middle, int right, Comparator<? super E> c) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        E[] leftArray = (E[]) new Object[n1];
        E[] rightArray = (E[]) new Object[n2];

        System.arraycopy(array, left, leftArray, 0, n1);
        System.arraycopy(array, middle + 1, rightArray, 0, n2);

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (c.compare(leftArray[i], rightArray[j]) <= 0) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<>(values);
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(values, size);
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > values.length) {
            int newCapacity = Math.max(values.length * 2, minCapacity);
            E[] newArray = (E[]) new Object[newCapacity];
            System.arraycopy(values, 0, newArray, 0, size);
            values = newArray;
        }
    }
}

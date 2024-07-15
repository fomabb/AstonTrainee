package io.nikolay.kirilyuk.astontrainee.collection.custom;

import java.util.Collection;
import java.util.Comparator;

public interface CustomList<E> extends Iterable<E> {
    boolean add(E e);
    void add(int index, E element);
    void addAll(Collection<? extends E> c);
    void clear();
    E remove(int index);
    boolean remove(E object);
    E get(int index);
    boolean isEmpty();
    int size();
    void update(int index, E e);
    void sort(Comparator<? super E> c);
    Object[] toArray();
}

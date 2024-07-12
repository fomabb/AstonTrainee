package io.nikolay.kirilyuk.astontrainee.collections.custom;

import java.util.Collection;
import java.util.Comparator;

public interface ICustomArrayList<E> extends Iterable<E> {
    boolean add(E e);
    void add(int index, E element);
    void addAll(Collection<? extends E> c);
    void clear();
    void remove(int index);
    void remove(Object o);
    E get(int index);
    boolean isEmpty();
    int size();
    void update(int index, E e);
    void sort(Comparator<? super E> c);
    Object[] toArray();
}

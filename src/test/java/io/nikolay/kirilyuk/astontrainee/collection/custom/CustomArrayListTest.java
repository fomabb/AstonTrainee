package io.nikolay.kirilyuk.astontrainee.collection.custom;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CustomArrayListTest {

    private CustomList<Integer> list;

    @Before
    public void setUp() {
        list = new CustomArrayListImpl<>();
    }

    @Test
    public void testAddIndex() {
        list.add(0, 10);
        list.add(1, 20);
        list.add(2, 30);
        assertEquals(3, list.size());
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
    }

    @Test
    public void testAddAll() {
        List<Integer> integers = Arrays.asList(10, 20, 30);
        list.addAll(integers);
        assertEquals(3, list.size());
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
    }

    @Test
    public void testClear() {
        list.add(10);
        list.add(20);
        list.clear();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    public void testRemoveByIndex() {
        list.add(0, 10);
        list.add(1, 20);
        list.remove(0);
        assertEquals(1, list.size());
        assertEquals(20, list.get(0));
    }

    @Test
    public void testRemoveByObject() {
        list.add(0, 10);
        list.add(1, 20);
        assertTrue(list.remove((Integer) 10));
        assertEquals(1, list.size());
        assertEquals(20, list.get(0));
        assertFalse(list.remove((Integer) 30));
    }

    @Test
    public void testGet() {
        list.add(0, 10);
        list.add(1, 20);
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
    }

    @Test
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.add(0, 10);
        assertFalse(list.isEmpty());
    }

    @Test
    public void testUpdate() {
        list.add(0, 10);
        list.add(1, 20);
        list.update(1, 25);
        assertEquals(25, list.get(1));
    }

    @Test
    public void testSort() {
        list.add(0, 5);
        list.add(1, 10);
        list.add(2, 12);
        list.add(3, 1);
        list.sort(Comparator.naturalOrder());
        assertEquals(Arrays.asList(1, 5, 10, 12), Arrays.asList(list.toArray()));
    }
}

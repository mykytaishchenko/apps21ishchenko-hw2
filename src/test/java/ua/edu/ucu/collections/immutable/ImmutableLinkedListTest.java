package ua.edu.ucu.collections.immutable;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    ImmutableList list = new ImmutableLinkedList(new Integer[]{1, 2, 3});

    @Test
    public void testToArray() {
        assertArrayEquals(new Integer[]{1, 2, 3}, list.toArray());
    }

    @Test
    public void testAdd() {
        assertArrayEquals(new Object[]{1, 2, 3, 4}, list.add(4).toArray());
    }

    @Test
    public void testAddIndex() {
        assertArrayEquals(new Object[]{1, 1.5, 2, 3}, list.add(1, 1.5).toArray());
    }

    @Test
    public void testAddAll() {
        assertArrayEquals(new Object[]{1, 2, 3, 4, 5, 6}, list.addAll(new Object[]{4, 5, 6}).toArray());
    }

    @Test
    public void testAddAllIndex() {
        assertArrayEquals(new Object[]{1, 4, 5, 6, 2, 3}, list.addAll(1, new Object[]{4, 5, 6}).toArray());
    }

    @Test
    public void testGet() {
        assertEquals(3, list.get(2));
    }

    @Test
    public void testRemove() {
        assertArrayEquals(new Object[]{2, 3}, list.remove(0).toArray());
    }

    @Test
    public void testSet() {
        assertArrayEquals(new Object[]{1, 0, 3}, list.set(1, 0).toArray());
    }

    @Test
    public void testIndexOf() {
        assertEquals(0, list.indexOf(1));
    }

    @Test
    public void testSize() {
        assertEquals(3, list.size());
    }

    @Test
    public void testIsEmpty() {
        assertFalse(list.isEmpty());
    }

    @Test
    public void testAddFirst() {
        assertArrayEquals(new Object[]{0, 1, 2, 3}, ((ImmutableLinkedList) list).addFirst(0).toArray());
    }

    @Test
    public void testAddLast() {
        assertArrayEquals(new Object[]{1, 2, 3, 4}, ((ImmutableLinkedList) list).addLast(4).toArray());
    }

    @Test
    public void testGetHead() {
        assertEquals(1, ((ImmutableLinkedList) list).getHead().getValue());
    }

    @Test
    public void testGetTail() {
        assertEquals(3, ((ImmutableLinkedList) list).getTail().getValue());
    }

    @Test
    public void testGetFirst() {
        assertEquals(1, ((ImmutableLinkedList) list).getFirst());
    }

    @Test
    public void testGetLast() {
        assertEquals(3, ((ImmutableLinkedList) list).getLast());
    }

    @Test
    public void testRemoveFirst() {
        assertArrayEquals(new Object[]{2, 3}, ((ImmutableLinkedList) list).removeFirst().toArray());
    }

    @Test
    public void testRemoveLast() {
        assertArrayEquals(new Object[]{1, 2}, ((ImmutableLinkedList) list).removeLast().toArray());
    }
}
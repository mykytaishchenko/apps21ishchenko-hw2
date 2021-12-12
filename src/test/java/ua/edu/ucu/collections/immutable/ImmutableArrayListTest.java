package ua.edu.ucu.collections.immutable;

import org.junit.Assert;
import org.junit.Test;


import static org.junit.Assert.assertArrayEquals;

public class ImmutableArrayListTest {
    ImmutableList list = new ImmutableArrayList(new Integer[]{1, 2, 3});

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
        Assert.assertEquals(3, list.get(2));
    }

    @Test
    public void testRemove() {
        assertArrayEquals(new Object[]{2, 3}, list.remove(0).toArray());
    }

    @Test
    public void testSet() {
        assertArrayEquals(new Object[]{-1, 2, 3}, list.set(0, -1).toArray());
    }

    @Test
    public void testIndexOf() {
        Assert.assertEquals(0, list.indexOf(1));
    }

    @Test
    public void testSize() {
        Assert.assertEquals(3, list.size());
    }

    @Test
    public void testIsEmpty() {
        Assert.assertFalse(list.isEmpty());
    }
}
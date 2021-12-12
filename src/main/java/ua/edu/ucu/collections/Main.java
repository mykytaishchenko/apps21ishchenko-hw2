package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ImmutableLinkedList list = new ImmutableLinkedList();
        list = (ImmutableLinkedList) list.addAll(new Object[]{0, 1});
        list = list.removeFirst();
        list = list.removeFirst();
        System.out.println(Arrays.toString(list.toArray()));
    }
}

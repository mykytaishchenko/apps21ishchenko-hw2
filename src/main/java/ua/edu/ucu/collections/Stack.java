package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    ImmutableLinkedList list = new ImmutableLinkedList();

    public void push(Object e) { list = list.addFirst(e); }

    public Object pop() {
        Object first = peek();
        list = list.removeFirst();
        return first;
    }

    public Object peek() {
        return list.getFirst();
    }
}

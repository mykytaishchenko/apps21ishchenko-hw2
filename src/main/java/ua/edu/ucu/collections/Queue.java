package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;
import ua.edu.ucu.collections.immutable.ImmutableList;

public class Queue {
    ImmutableList list = new ImmutableLinkedList();

    public Object peek() {
        return ((ImmutableLinkedList) list).getFirst();
    }

    public Object dequeue() {
        Object first = peek();
        list = ((ImmutableLinkedList) list).removeFirst();
        return first;
    }

    public void enqueue(Object e) {
        list = ((ImmutableLinkedList) list).addLast(e);
    }
}

package ua.edu.ucu.collections.immutable;

import java.util.ArrayList;
import java.util.List;

public final class ImmutableLinkedList implements ImmutableList {
    Node head;
    int size;

    public ImmutableLinkedList(Object[] elements) {
        if (elements.length > 0) {
            head = new Node(elements[0], null, null);
            size = elements.length;
            Node cur = head;
            for (int i = 1; i < elements.length; i++) {
                cur.setNext(new Node(elements[i], cur, null));
                cur = cur.getNext();
            }
        }
        else size = 0;
    }

    public ImmutableLinkedList() {
        size = 0;
    }

    @Override
    public ImmutableList add(Object e) {
        return addAll(new Object[]{e});
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return addAll(index, new Object[]{e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(size, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        Object[] elements = toArray();
        Object[] newElements = new Object[size() + c.length];
        System.arraycopy(elements, 0, newElements, 0, index);
        System.arraycopy(c, 0, newElements, index, c.length);
        System.arraycopy(elements, index, newElements, index + c.length, newElements.length - (index + c.length));
        size = newElements.length;
        return new ImmutableLinkedList(newElements);
    }

    @Override
    public Object get(int index) {
        Node cur = head;
        int counter = 0;
        while (counter != index && cur != null) {
            counter++;
            cur = cur.getNext();
        }
        if (cur != null) return cur.getValue();
        return null;
    }

    @Override
    public ImmutableList remove(int index) {
        Object[] elements = toArray().clone();
        Object[] newElements = new Object[elements.length - 1];
        System.arraycopy(elements, 0, newElements, 0, index);
        System.arraycopy(elements, index + 1, newElements, index, newElements.length - index);
        size--;
        return new ImmutableLinkedList(newElements);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        Object[] newElements = toArray().clone();
        newElements[index] = e;
        return new ImmutableLinkedList(newElements);
    }

    @Override
    public int indexOf(Object e) {
        Node cur = head;
        int counter = 0;
        while (cur != null) {
            if (e == cur.getValue()) return counter;
            cur = cur.getNext();
            counter++;
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object[] toArray() {
        Node cur = head;
        Object[] elements = new Object[size];
        int counter = 0;
        while (cur != null) {
            elements[counter] = cur.getValue();
            cur = cur.getNext();
            counter++;
        }
        return elements;
    }

    public ImmutableLinkedList addFirst(Object e) {
        return (ImmutableLinkedList) add(0, e);
    }

    public ImmutableLinkedList addLast(Object e) {
        return (ImmutableLinkedList) add(size, e);
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        Node cur = head;
        while (cur != null && cur.getNext() != null) cur = cur.getNext();
        return cur;
    }

    public Object getFirst() {
        return getHead().getValue();
    }

    public Object getLast() {
        return getTail().getValue();
    }

    public ImmutableLinkedList removeFirst() {
        return (ImmutableLinkedList) remove(0);
    }

    public ImmutableLinkedList removeLast() {
        return (ImmutableLinkedList) remove(size - 1);
    }
}

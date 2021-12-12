package ua.edu.ucu.collections.immutable;

import java.util.Arrays;
import java.util.Objects;

public final class ImmutableArrayList implements ImmutableList {
    Object[] elements;

    public ImmutableArrayList(Object[] elements) {
        this.elements = elements;
    }

    public ImmutableArrayList() {
        this.elements = new Object[0];
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
        return addAll(elements.length, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        Object[] newElements = new Object[elements.length + c.length];
        System.arraycopy(elements, 0, newElements, 0, index);
        System.arraycopy(c, 0, newElements, index, c.length);
        System.arraycopy(elements, index, newElements, index + c.length, newElements.length - (index + c.length));
        return new ImmutableArrayList(newElements);
    }

    @Override
    public Object get(int index) {
        return elements[index];
    }

    @Override
    public ImmutableList remove(int index) {
        Object[] newElements = new Object[elements.length - 1];
        System.arraycopy(elements, 0, newElements, 0, index);
        System.arraycopy(elements, index + 1, newElements, index, newElements.length - index);
        return new ImmutableArrayList(newElements);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        Object[] newElements = this.elements.clone();
        newElements[index] = e;
        return new ImmutableArrayList(newElements);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < elements.length; i++) if (elements[i] == e) return i;
        return -1;
    }

    @Override
    public int size() {
        return elements.length;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Object[] toArray() {
        return elements;
    }
}

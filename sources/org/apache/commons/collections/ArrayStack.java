package org.apache.commons.collections;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class ArrayStack extends ArrayList implements Buffer {
    private static final long serialVersionUID = 2130079159931574599L;

    public ArrayStack() {
    }

    public boolean empty() {
        return isEmpty();
    }

    public Object get() {
        int size = size();
        if (size != 0) {
            return get(size - 1);
        }
        throw new BufferUnderflowException();
    }

    public Object peek() throws EmptyStackException {
        int size = size();
        if (size > 0) {
            return get(size - 1);
        }
        throw new EmptyStackException();
    }

    public Object pop() throws EmptyStackException {
        int size = size();
        if (size > 0) {
            return remove(size - 1);
        }
        throw new EmptyStackException();
    }

    public Object push(Object obj) {
        add(obj);
        return obj;
    }

    public Object remove() {
        int size = size();
        if (size != 0) {
            return remove(size - 1);
        }
        throw new BufferUnderflowException();
    }

    public int search(Object obj) {
        int i10 = 1;
        int size = size() - 1;
        while (size >= 0) {
            Object obj2 = get(size);
            if ((obj == null && obj2 == null) || (obj != null && obj.equals(obj2))) {
                return i10;
            }
            size--;
            i10++;
        }
        return -1;
    }

    public ArrayStack(int i10) {
        super(i10);
    }

    public Object peek(int i10) throws EmptyStackException {
        int size = (size() - i10) - 1;
        if (size >= 0) {
            return get(size);
        }
        throw new EmptyStackException();
    }
}

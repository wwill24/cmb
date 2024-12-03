package org.apache.commons.collections.iterators;

import java.util.ListIterator;

public class ProxyListIterator implements ListIterator {
    private ListIterator iterator;

    public ProxyListIterator() {
    }

    public void add(Object obj) {
        getListIterator().add(obj);
    }

    public ListIterator getListIterator() {
        return this.iterator;
    }

    public boolean hasNext() {
        return getListIterator().hasNext();
    }

    public boolean hasPrevious() {
        return getListIterator().hasPrevious();
    }

    public Object next() {
        return getListIterator().next();
    }

    public int nextIndex() {
        return getListIterator().nextIndex();
    }

    public Object previous() {
        return getListIterator().previous();
    }

    public int previousIndex() {
        return getListIterator().previousIndex();
    }

    public void remove() {
        getListIterator().remove();
    }

    public void set(Object obj) {
        getListIterator().set(obj);
    }

    public void setListIterator(ListIterator listIterator) {
        this.iterator = listIterator;
    }

    public ProxyListIterator(ListIterator listIterator) {
        this.iterator = listIterator;
    }
}

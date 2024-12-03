package org.apache.commons.collections.iterators;

import java.util.Iterator;

public class ProxyIterator implements Iterator {
    private Iterator iterator;

    public ProxyIterator() {
    }

    public Iterator getIterator() {
        return this.iterator;
    }

    public boolean hasNext() {
        return getIterator().hasNext();
    }

    public Object next() {
        return getIterator().next();
    }

    public void remove() {
        getIterator().remove();
    }

    public void setIterator(Iterator it) {
        this.iterator = it;
    }

    public ProxyIterator(Iterator it) {
        this.iterator = it;
    }
}

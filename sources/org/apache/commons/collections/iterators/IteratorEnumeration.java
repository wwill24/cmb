package org.apache.commons.collections.iterators;

import java.util.Enumeration;
import java.util.Iterator;

public class IteratorEnumeration implements Enumeration {
    private Iterator iterator;

    public IteratorEnumeration() {
    }

    public Iterator getIterator() {
        return this.iterator;
    }

    public boolean hasMoreElements() {
        return this.iterator.hasNext();
    }

    public Object nextElement() {
        return this.iterator.next();
    }

    public void setIterator(Iterator it) {
        this.iterator = it;
    }

    public IteratorEnumeration(Iterator it) {
        this.iterator = it;
    }
}

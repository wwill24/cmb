package org.apache.commons.collections.iterators;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;

public class EnumerationIterator implements Iterator {
    private Collection collection;
    private Enumeration enumeration;
    private Object last;

    public EnumerationIterator() {
        this((Enumeration) null, (Collection) null);
    }

    public Enumeration getEnumeration() {
        return this.enumeration;
    }

    public boolean hasNext() {
        return this.enumeration.hasMoreElements();
    }

    public Object next() {
        Object nextElement = this.enumeration.nextElement();
        this.last = nextElement;
        return nextElement;
    }

    public void remove() {
        Collection collection2 = this.collection;
        if (collection2 != null) {
            Object obj = this.last;
            if (obj != null) {
                collection2.remove(obj);
                return;
            }
            throw new IllegalStateException("next() must have been called for remove() to function");
        }
        throw new UnsupportedOperationException("No Collection associated with this Iterator");
    }

    public void setEnumeration(Enumeration enumeration2) {
        this.enumeration = enumeration2;
    }

    public EnumerationIterator(Enumeration enumeration2) {
        this(enumeration2, (Collection) null);
    }

    public EnumerationIterator(Enumeration enumeration2, Collection collection2) {
        this.enumeration = enumeration2;
        this.collection = collection2;
        this.last = null;
    }
}

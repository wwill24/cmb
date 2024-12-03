package org.apache.commons.collections;

import java.util.Iterator;

public interface MapIterator extends Iterator {
    Object getKey();

    Object getValue();

    boolean hasNext();

    Object next();

    void remove();

    Object setValue(Object obj);
}

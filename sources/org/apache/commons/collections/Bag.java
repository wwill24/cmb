package org.apache.commons.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public interface Bag extends Collection {
    boolean add(Object obj);

    boolean add(Object obj, int i10);

    boolean containsAll(Collection collection);

    int getCount(Object obj);

    Iterator iterator();

    boolean remove(Object obj);

    boolean remove(Object obj, int i10);

    boolean removeAll(Collection collection);

    boolean retainAll(Collection collection);

    int size();

    Set uniqueSet();
}

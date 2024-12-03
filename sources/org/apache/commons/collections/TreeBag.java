package org.apache.commons.collections;

import java.util.Collection;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreeBag extends DefaultMapBag implements SortedBag {
    public TreeBag() {
        super(new TreeMap());
    }

    public Comparator comparator() {
        return ((SortedMap) getMap()).comparator();
    }

    public Object first() {
        return ((SortedMap) getMap()).firstKey();
    }

    public Object last() {
        return ((SortedMap) getMap()).lastKey();
    }

    public TreeBag(Comparator comparator) {
        super(new TreeMap(comparator));
    }

    public TreeBag(Collection collection) {
        this();
        addAll(collection);
    }
}

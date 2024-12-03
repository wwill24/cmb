package org.apache.commons.collections;

public interface PriorityQueue {
    void clear();

    void insert(Object obj);

    boolean isEmpty();

    Object peek();

    Object pop();
}

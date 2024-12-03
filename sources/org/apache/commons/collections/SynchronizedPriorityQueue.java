package org.apache.commons.collections;

import java.util.NoSuchElementException;

public final class SynchronizedPriorityQueue implements PriorityQueue {
    protected final PriorityQueue m_priorityQueue;

    public SynchronizedPriorityQueue(PriorityQueue priorityQueue) {
        this.m_priorityQueue = priorityQueue;
    }

    public synchronized void clear() {
        this.m_priorityQueue.clear();
    }

    public synchronized void insert(Object obj) {
        this.m_priorityQueue.insert(obj);
    }

    public synchronized boolean isEmpty() {
        return this.m_priorityQueue.isEmpty();
    }

    public synchronized Object peek() throws NoSuchElementException {
        return this.m_priorityQueue.peek();
    }

    public synchronized Object pop() throws NoSuchElementException {
        return this.m_priorityQueue.pop();
    }

    public synchronized String toString() {
        return this.m_priorityQueue.toString();
    }
}

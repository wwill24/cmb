package com.google.firebase.database.collection;

import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

public class ImmutableSortedMapIterator<K, V> implements Iterator<Map.Entry<K, V>> {
    private final boolean isReverse;
    private final ArrayDeque<LLRBValueNode<K, V>> nodeStack = new ArrayDeque<>();

    ImmutableSortedMapIterator(LLRBNode<K, V> lLRBNode, K k10, Comparator<K> comparator, boolean z10) {
        int i10;
        this.isReverse = z10;
        while (!lLRBNode.isEmpty()) {
            if (k10 == null) {
                i10 = 1;
            } else if (z10) {
                i10 = comparator.compare(k10, lLRBNode.getKey());
            } else {
                i10 = comparator.compare(lLRBNode.getKey(), k10);
            }
            if (i10 < 0) {
                if (z10) {
                    lLRBNode = lLRBNode.getLeft();
                } else {
                    lLRBNode = lLRBNode.getRight();
                }
            } else if (i10 == 0) {
                this.nodeStack.push((LLRBValueNode) lLRBNode);
                return;
            } else {
                this.nodeStack.push((LLRBValueNode) lLRBNode);
                if (z10) {
                    lLRBNode = lLRBNode.getRight();
                } else {
                    lLRBNode = lLRBNode.getLeft();
                }
            }
        }
    }

    public boolean hasNext() {
        return this.nodeStack.size() > 0;
    }

    public void remove() {
        throw new UnsupportedOperationException("remove called on immutable collection");
    }

    public Map.Entry<K, V> next() {
        try {
            LLRBValueNode pop = this.nodeStack.pop();
            AbstractMap.SimpleEntry simpleEntry = new AbstractMap.SimpleEntry(pop.getKey(), pop.getValue());
            if (this.isReverse) {
                for (LLRBNode left = pop.getLeft(); !left.isEmpty(); left = left.getRight()) {
                    this.nodeStack.push((LLRBValueNode) left);
                }
            } else {
                for (LLRBNode right = pop.getRight(); !right.isEmpty(); right = right.getLeft()) {
                    this.nodeStack.push((LLRBValueNode) right);
                }
            }
            return simpleEntry;
        } catch (EmptyStackException unused) {
            throw new NoSuchElementException();
        }
    }
}

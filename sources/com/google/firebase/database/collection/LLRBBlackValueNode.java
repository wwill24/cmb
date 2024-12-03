package com.google.firebase.database.collection;

import com.google.firebase.database.collection.LLRBNode;

public class LLRBBlackValueNode<K, V> extends LLRBValueNode<K, V> {
    private int size = -1;

    LLRBBlackValueNode(K k10, V v10, LLRBNode<K, V> lLRBNode, LLRBNode<K, V> lLRBNode2) {
        super(k10, v10, lLRBNode, lLRBNode2);
    }

    /* access modifiers changed from: protected */
    public LLRBValueNode<K, V> copy(K k10, V v10, LLRBNode<K, V> lLRBNode, LLRBNode<K, V> lLRBNode2) {
        if (k10 == null) {
            k10 = getKey();
        }
        if (v10 == null) {
            v10 = getValue();
        }
        if (lLRBNode == null) {
            lLRBNode = getLeft();
        }
        if (lLRBNode2 == null) {
            lLRBNode2 = getRight();
        }
        return new LLRBBlackValueNode(k10, v10, lLRBNode, lLRBNode2);
    }

    /* access modifiers changed from: protected */
    public LLRBNode.Color getColor() {
        return LLRBNode.Color.BLACK;
    }

    public boolean isRed() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public void setLeft(LLRBNode<K, V> lLRBNode) {
        if (this.size == -1) {
            super.setLeft(lLRBNode);
            return;
        }
        throw new IllegalStateException("Can't set left after using size");
    }

    public int size() {
        if (this.size == -1) {
            this.size = getLeft().size() + 1 + getRight().size();
        }
        return this.size;
    }
}

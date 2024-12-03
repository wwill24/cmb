package com.google.firebase.database.collection;

import com.google.firebase.database.collection.LLRBNode;

public class LLRBRedValueNode<K, V> extends LLRBValueNode<K, V> {
    LLRBRedValueNode(K k10, V v10) {
        super(k10, v10, LLRBEmptyNode.getInstance(), LLRBEmptyNode.getInstance());
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
        return new LLRBRedValueNode(k10, v10, lLRBNode, lLRBNode2);
    }

    /* access modifiers changed from: protected */
    public LLRBNode.Color getColor() {
        return LLRBNode.Color.RED;
    }

    public boolean isRed() {
        return true;
    }

    public int size() {
        return getLeft().size() + 1 + getRight().size();
    }

    LLRBRedValueNode(K k10, V v10, LLRBNode<K, V> lLRBNode, LLRBNode<K, V> lLRBNode2) {
        super(k10, v10, lLRBNode, lLRBNode2);
    }
}

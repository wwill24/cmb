package com.google.firebase.database.collection;

import com.google.firebase.database.collection.LLRBNode;
import java.util.Comparator;

public abstract class LLRBValueNode<K, V> implements LLRBNode<K, V> {
    private final K key;
    private LLRBNode<K, V> left;
    private final LLRBNode<K, V> right;
    private final V value;

    LLRBValueNode(K k10, V v10, LLRBNode<K, V> lLRBNode, LLRBNode<K, V> lLRBNode2) {
        this.key = k10;
        this.value = v10;
        this.left = lLRBNode == null ? LLRBEmptyNode.getInstance() : lLRBNode;
        this.right = lLRBNode2 == null ? LLRBEmptyNode.getInstance() : lLRBNode2;
    }

    private LLRBValueNode<K, V> colorFlip() {
        LLRBNode<K, V> lLRBNode = this.left;
        LLRBNode<K, V> copy = lLRBNode.copy(null, null, oppositeColor(lLRBNode), (LLRBNode<K, V>) null, (LLRBNode<K, V>) null);
        LLRBNode<K, V> lLRBNode2 = this.right;
        return copy((Object) null, (Object) null, oppositeColor(this), (LLRBNode) copy, (LLRBNode) lLRBNode2.copy(null, null, oppositeColor(lLRBNode2), (LLRBNode<K, V>) null, (LLRBNode<K, V>) null));
    }

    private LLRBValueNode<K, V> fixUp() {
        LLRBValueNode lLRBValueNode;
        if (!this.right.isRed() || this.left.isRed()) {
            lLRBValueNode = this;
        } else {
            lLRBValueNode = rotateLeft();
        }
        if (lLRBValueNode.left.isRed() && ((LLRBValueNode) lLRBValueNode.left).left.isRed()) {
            lLRBValueNode = lLRBValueNode.rotateRight();
        }
        if (!lLRBValueNode.left.isRed() || !lLRBValueNode.right.isRed()) {
            return lLRBValueNode;
        }
        return lLRBValueNode.colorFlip();
    }

    private LLRBValueNode<K, V> moveRedLeft() {
        LLRBValueNode<K, V> colorFlip = colorFlip();
        if (colorFlip.getRight().getLeft().isRed()) {
            return colorFlip.copy((K) null, (V) null, (LLRBNode<K, V>) null, ((LLRBValueNode) colorFlip.getRight()).rotateRight()).rotateLeft().colorFlip();
        }
        return colorFlip;
    }

    private LLRBValueNode<K, V> moveRedRight() {
        LLRBValueNode<K, V> colorFlip = colorFlip();
        if (colorFlip.getLeft().getLeft().isRed()) {
            return colorFlip.rotateRight().colorFlip();
        }
        return colorFlip;
    }

    private static LLRBNode.Color oppositeColor(LLRBNode lLRBNode) {
        return lLRBNode.isRed() ? LLRBNode.Color.BLACK : LLRBNode.Color.RED;
    }

    private LLRBNode<K, V> removeMin() {
        LLRBValueNode lLRBValueNode;
        if (this.left.isEmpty()) {
            return LLRBEmptyNode.getInstance();
        }
        if (getLeft().isRed() || getLeft().getLeft().isRed()) {
            lLRBValueNode = this;
        } else {
            lLRBValueNode = moveRedLeft();
        }
        return lLRBValueNode.copy((Object) null, (Object) null, ((LLRBValueNode) lLRBValueNode.left).removeMin(), (LLRBNode) null).fixUp();
    }

    private LLRBValueNode<K, V> rotateLeft() {
        return (LLRBValueNode) this.right.copy(null, null, getColor(), copy((Object) null, (Object) null, LLRBNode.Color.RED, (LLRBNode) null, (LLRBNode) ((LLRBValueNode) this.right).left), (LLRBValueNode) null);
    }

    private LLRBValueNode<K, V> rotateRight() {
        return (LLRBValueNode) this.left.copy(null, null, getColor(), (LLRBNode) null, copy((Object) null, (Object) null, LLRBNode.Color.RED, (LLRBNode) ((LLRBValueNode) this.left).right, (LLRBNode) null));
    }

    /* access modifiers changed from: protected */
    public abstract LLRBValueNode<K, V> copy(K k10, V v10, LLRBNode<K, V> lLRBNode, LLRBNode<K, V> lLRBNode2);

    /* access modifiers changed from: protected */
    public abstract LLRBNode.Color getColor();

    public K getKey() {
        return this.key;
    }

    public LLRBNode<K, V> getLeft() {
        return this.left;
    }

    public LLRBNode<K, V> getMax() {
        if (this.right.isEmpty()) {
            return this;
        }
        return this.right.getMax();
    }

    public LLRBNode<K, V> getMin() {
        if (this.left.isEmpty()) {
            return this;
        }
        return this.left.getMin();
    }

    public LLRBNode<K, V> getRight() {
        return this.right;
    }

    public V getValue() {
        return this.value;
    }

    public void inOrderTraversal(LLRBNode.NodeVisitor<K, V> nodeVisitor) {
        this.left.inOrderTraversal(nodeVisitor);
        nodeVisitor.visitEntry(this.key, this.value);
        this.right.inOrderTraversal(nodeVisitor);
    }

    public LLRBNode<K, V> insert(K k10, V v10, Comparator<K> comparator) {
        LLRBValueNode<K, V> lLRBValueNode;
        int compare = comparator.compare(k10, this.key);
        if (compare < 0) {
            lLRBValueNode = copy((Object) null, (Object) null, this.left.insert(k10, v10, comparator), (LLRBNode<K, V>) null);
        } else if (compare == 0) {
            lLRBValueNode = copy(k10, v10, (LLRBNode) null, (LLRBNode) null);
        } else {
            lLRBValueNode = copy((Object) null, (Object) null, (LLRBNode) null, this.right.insert(k10, v10, comparator));
        }
        return lLRBValueNode.fixUp();
    }

    public boolean isEmpty() {
        return false;
    }

    public LLRBNode<K, V> remove(K k10, Comparator<K> comparator) {
        LLRBValueNode<K, V> lLRBValueNode;
        LLRBValueNode lLRBValueNode2;
        LLRBValueNode lLRBValueNode3;
        if (comparator.compare(k10, this.key) < 0) {
            if (this.left.isEmpty() || this.left.isRed() || ((LLRBValueNode) this.left).left.isRed()) {
                lLRBValueNode3 = this;
            } else {
                lLRBValueNode3 = moveRedLeft();
            }
            lLRBValueNode = lLRBValueNode3.copy((Object) null, (Object) null, lLRBValueNode3.left.remove(k10, comparator), (LLRBNode<K, V>) null);
        } else {
            if (this.left.isRed()) {
                lLRBValueNode2 = rotateRight();
            } else {
                lLRBValueNode2 = this;
            }
            if (!lLRBValueNode2.right.isEmpty() && !lLRBValueNode2.right.isRed() && !((LLRBValueNode) lLRBValueNode2.right).left.isRed()) {
                lLRBValueNode2 = lLRBValueNode2.moveRedRight();
            }
            if (comparator.compare(k10, lLRBValueNode2.key) == 0) {
                if (lLRBValueNode2.right.isEmpty()) {
                    return LLRBEmptyNode.getInstance();
                }
                LLRBNode<K, V> min = lLRBValueNode2.right.getMin();
                lLRBValueNode2 = lLRBValueNode2.copy(min.getKey(), min.getValue(), (LLRBNode) null, ((LLRBValueNode) lLRBValueNode2.right).removeMin());
            }
            lLRBValueNode = lLRBValueNode2.copy((Object) null, (Object) null, (LLRBNode) null, lLRBValueNode2.right.remove(k10, comparator));
        }
        return lLRBValueNode.fixUp();
    }

    /* access modifiers changed from: package-private */
    public void setLeft(LLRBNode<K, V> lLRBNode) {
        this.left = lLRBNode;
    }

    public boolean shortCircuitingInOrderTraversal(LLRBNode.ShortCircuitingNodeVisitor<K, V> shortCircuitingNodeVisitor) {
        if (!this.left.shortCircuitingInOrderTraversal(shortCircuitingNodeVisitor) || !shortCircuitingNodeVisitor.shouldContinue(this.key, this.value)) {
            return false;
        }
        return this.right.shortCircuitingInOrderTraversal(shortCircuitingNodeVisitor);
    }

    public boolean shortCircuitingReverseOrderTraversal(LLRBNode.ShortCircuitingNodeVisitor<K, V> shortCircuitingNodeVisitor) {
        if (!this.right.shortCircuitingReverseOrderTraversal(shortCircuitingNodeVisitor) || !shortCircuitingNodeVisitor.shouldContinue(this.key, this.value)) {
            return false;
        }
        return this.left.shortCircuitingReverseOrderTraversal(shortCircuitingNodeVisitor);
    }

    public LLRBValueNode<K, V> copy(K k10, V v10, LLRBNode.Color color, LLRBNode<K, V> lLRBNode, LLRBNode<K, V> lLRBNode2) {
        if (k10 == null) {
            k10 = this.key;
        }
        if (v10 == null) {
            v10 = this.value;
        }
        if (lLRBNode == null) {
            lLRBNode = this.left;
        }
        if (lLRBNode2 == null) {
            lLRBNode2 = this.right;
        }
        if (color == LLRBNode.Color.RED) {
            return new LLRBRedValueNode(k10, v10, lLRBNode, lLRBNode2);
        }
        return new LLRBBlackValueNode(k10, v10, lLRBNode, lLRBNode2);
    }
}

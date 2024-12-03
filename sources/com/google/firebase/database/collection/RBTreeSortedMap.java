package com.google.firebase.database.collection;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.LLRBNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RBTreeSortedMap<K, V> extends ImmutableSortedMap<K, V> {
    private Comparator<K> comparator;
    private LLRBNode<K, V> root;

    private static class Builder<A, B, C> {
        private final ImmutableSortedMap.Builder.KeyTranslator<A, B> keyTranslator;
        private final List<A> keys;
        private LLRBValueNode<A, C> leaf;
        private LLRBValueNode<A, C> root;
        private final Map<B, C> values;

        static class Base1_2 implements Iterable<BooleanChunk> {
            /* access modifiers changed from: private */
            public final int length;
            /* access modifiers changed from: private */
            public long value;

            public Base1_2(int i10) {
                int i11 = i10 + 1;
                int floor = (int) Math.floor(Math.log((double) i11) / Math.log(2.0d));
                this.length = floor;
                this.value = (((long) Math.pow(2.0d, (double) floor)) - 1) & ((long) i11);
            }

            public Iterator<BooleanChunk> iterator() {
                return new Iterator<BooleanChunk>() {
                    private int current;

                    {
                        this.current = Base1_2.this.length - 1;
                    }

                    public boolean hasNext() {
                        return this.current >= 0;
                    }

                    public void remove() {
                    }

                    public BooleanChunk next() {
                        BooleanChunk booleanChunk = new BooleanChunk();
                        booleanChunk.isOne = (Base1_2.this.value & ((long) (1 << this.current))) == 0;
                        booleanChunk.chunkSize = (int) Math.pow(2.0d, (double) this.current);
                        this.current--;
                        return booleanChunk;
                    }
                };
            }
        }

        static class BooleanChunk {
            public int chunkSize;
            public boolean isOne;

            BooleanChunk() {
            }
        }

        private Builder(List<A> list, Map<B, C> map, ImmutableSortedMap.Builder.KeyTranslator<A, B> keyTranslator2) {
            this.keys = list;
            this.values = map;
            this.keyTranslator = keyTranslator2;
        }

        private LLRBNode<A, C> buildBalancedTree(int i10, int i11) {
            if (i11 == 0) {
                return LLRBEmptyNode.getInstance();
            }
            if (i11 == 1) {
                A a10 = this.keys.get(i10);
                return new LLRBBlackValueNode(a10, getValue(a10), (LLRBNode) null, (LLRBNode) null);
            }
            int i12 = i11 / 2;
            int i13 = i10 + i12;
            LLRBNode buildBalancedTree = buildBalancedTree(i10, i12);
            LLRBNode buildBalancedTree2 = buildBalancedTree(i13 + 1, i12);
            A a11 = this.keys.get(i13);
            return new LLRBBlackValueNode(a11, getValue(a11), buildBalancedTree, buildBalancedTree2);
        }

        public static <A, B, C> RBTreeSortedMap<A, C> buildFrom(List<A> list, Map<B, C> map, ImmutableSortedMap.Builder.KeyTranslator<A, B> keyTranslator2, Comparator<A> comparator) {
            Builder builder = new Builder(list, map, keyTranslator2);
            Collections.sort(list, comparator);
            Iterator<BooleanChunk> it = new Base1_2(list.size()).iterator();
            int size = list.size();
            while (it.hasNext()) {
                BooleanChunk next = it.next();
                int i10 = next.chunkSize;
                size -= i10;
                if (next.isOne) {
                    builder.buildPennant(LLRBNode.Color.BLACK, i10, size);
                } else {
                    builder.buildPennant(LLRBNode.Color.BLACK, i10, size);
                    int i11 = next.chunkSize;
                    size -= i11;
                    builder.buildPennant(LLRBNode.Color.RED, i11, size);
                }
            }
            LLRBNode lLRBNode = builder.root;
            if (lLRBNode == null) {
                lLRBNode = LLRBEmptyNode.getInstance();
            }
            return new RBTreeSortedMap<>(lLRBNode, comparator);
        }

        private void buildPennant(LLRBNode.Color color, int i10, int i11) {
            LLRBValueNode<A, C> lLRBValueNode;
            LLRBNode buildBalancedTree = buildBalancedTree(i11 + 1, i10 - 1);
            A a10 = this.keys.get(i11);
            if (color == LLRBNode.Color.RED) {
                lLRBValueNode = new LLRBRedValueNode<>(a10, getValue(a10), (LLRBNode) null, buildBalancedTree);
            } else {
                lLRBValueNode = new LLRBBlackValueNode<>(a10, getValue(a10), (LLRBNode) null, buildBalancedTree);
            }
            if (this.root == null) {
                this.root = lLRBValueNode;
                this.leaf = lLRBValueNode;
                return;
            }
            this.leaf.setLeft(lLRBValueNode);
            this.leaf = lLRBValueNode;
        }

        private C getValue(A a10) {
            return this.values.get(this.keyTranslator.translate(a10));
        }
    }

    public static <A, B, C> RBTreeSortedMap<A, C> buildFrom(List<A> list, Map<B, C> map, ImmutableSortedMap.Builder.KeyTranslator<A, B> keyTranslator, Comparator<A> comparator2) {
        return Builder.buildFrom(list, map, keyTranslator, comparator2);
    }

    public static <A, B> RBTreeSortedMap<A, B> fromMap(Map<A, B> map, Comparator<A> comparator2) {
        return Builder.buildFrom(new ArrayList(map.keySet()), map, ImmutableSortedMap.Builder.identityTranslator(), comparator2);
    }

    private LLRBNode<K, V> getNode(K k10) {
        LLRBNode<K, V> lLRBNode = this.root;
        while (!lLRBNode.isEmpty()) {
            int compare = this.comparator.compare(k10, lLRBNode.getKey());
            if (compare < 0) {
                lLRBNode = lLRBNode.getLeft();
            } else if (compare == 0) {
                return lLRBNode;
            } else {
                lLRBNode = lLRBNode.getRight();
            }
        }
        return null;
    }

    public boolean containsKey(K k10) {
        return getNode(k10) != null;
    }

    public V get(K k10) {
        LLRBNode node = getNode(k10);
        if (node != null) {
            return node.getValue();
        }
        return null;
    }

    public Comparator<K> getComparator() {
        return this.comparator;
    }

    public K getMaxKey() {
        return this.root.getMax().getKey();
    }

    public K getMinKey() {
        return this.root.getMin().getKey();
    }

    public K getPredecessorKey(K k10) {
        LLRBNode<K, V> lLRBNode = this.root;
        LLRBNode<K, V> lLRBNode2 = null;
        while (!lLRBNode.isEmpty()) {
            int compare = this.comparator.compare(k10, lLRBNode.getKey());
            if (compare == 0) {
                if (!lLRBNode.getLeft().isEmpty()) {
                    LLRBNode<K, V> left = lLRBNode.getLeft();
                    while (!left.getRight().isEmpty()) {
                        left = left.getRight();
                    }
                    return left.getKey();
                } else if (lLRBNode2 != null) {
                    return lLRBNode2.getKey();
                } else {
                    return null;
                }
            } else if (compare < 0) {
                lLRBNode = lLRBNode.getLeft();
            } else {
                lLRBNode2 = lLRBNode;
                lLRBNode = lLRBNode.getRight();
            }
        }
        throw new IllegalArgumentException("Couldn't find predecessor key of non-present key: " + k10);
    }

    /* access modifiers changed from: package-private */
    public LLRBNode<K, V> getRoot() {
        return this.root;
    }

    public K getSuccessorKey(K k10) {
        LLRBNode<K, V> lLRBNode = this.root;
        LLRBNode<K, V> lLRBNode2 = null;
        while (!lLRBNode.isEmpty()) {
            int compare = this.comparator.compare(lLRBNode.getKey(), k10);
            if (compare == 0) {
                if (!lLRBNode.getRight().isEmpty()) {
                    LLRBNode<K, V> right = lLRBNode.getRight();
                    while (!right.getLeft().isEmpty()) {
                        right = right.getLeft();
                    }
                    return right.getKey();
                } else if (lLRBNode2 != null) {
                    return lLRBNode2.getKey();
                } else {
                    return null;
                }
            } else if (compare < 0) {
                lLRBNode = lLRBNode.getRight();
            } else {
                lLRBNode2 = lLRBNode;
                lLRBNode = lLRBNode.getLeft();
            }
        }
        throw new IllegalArgumentException("Couldn't find successor key of non-present key: " + k10);
    }

    public void inOrderTraversal(LLRBNode.NodeVisitor<K, V> nodeVisitor) {
        this.root.inOrderTraversal(nodeVisitor);
    }

    public int indexOf(K k10) {
        LLRBNode<K, V> lLRBNode = this.root;
        int i10 = 0;
        while (!lLRBNode.isEmpty()) {
            int compare = this.comparator.compare(k10, lLRBNode.getKey());
            if (compare == 0) {
                return i10 + lLRBNode.getLeft().size();
            }
            if (compare < 0) {
                lLRBNode = lLRBNode.getLeft();
            } else {
                i10 += lLRBNode.getLeft().size() + 1;
                lLRBNode = lLRBNode.getRight();
            }
        }
        return -1;
    }

    public ImmutableSortedMap<K, V> insert(K k10, V v10) {
        return new RBTreeSortedMap(this.root.insert(k10, v10, this.comparator).copy(null, null, LLRBNode.Color.BLACK, (LLRBNode) null, (LLRBNode) null), this.comparator);
    }

    public boolean isEmpty() {
        return this.root.isEmpty();
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        return new ImmutableSortedMapIterator(this.root, null, this.comparator, false);
    }

    public Iterator<Map.Entry<K, V>> iteratorFrom(K k10) {
        return new ImmutableSortedMapIterator(this.root, k10, this.comparator, false);
    }

    public ImmutableSortedMap<K, V> remove(K k10) {
        if (!containsKey(k10)) {
            return this;
        }
        return new RBTreeSortedMap(this.root.remove(k10, this.comparator).copy(null, null, LLRBNode.Color.BLACK, (LLRBNode) null, (LLRBNode) null), this.comparator);
    }

    public Iterator<Map.Entry<K, V>> reverseIterator() {
        return new ImmutableSortedMapIterator(this.root, null, this.comparator, true);
    }

    public Iterator<Map.Entry<K, V>> reverseIteratorFrom(K k10) {
        return new ImmutableSortedMapIterator(this.root, k10, this.comparator, true);
    }

    public int size() {
        return this.root.size();
    }

    RBTreeSortedMap(Comparator<K> comparator2) {
        this.root = LLRBEmptyNode.getInstance();
        this.comparator = comparator2;
    }

    private RBTreeSortedMap(LLRBNode<K, V> lLRBNode, Comparator<K> comparator2) {
        this.root = lLRBNode;
        this.comparator = comparator2;
    }
}

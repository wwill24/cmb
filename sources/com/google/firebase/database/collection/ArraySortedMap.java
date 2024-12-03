package com.google.firebase.database.collection;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.LLRBNode;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ArraySortedMap<K, V> extends ImmutableSortedMap<K, V> {
    private final Comparator<K> comparator;
    /* access modifiers changed from: private */
    public final K[] keys;
    /* access modifiers changed from: private */
    public final V[] values;

    public ArraySortedMap(Comparator<K> comparator2) {
        this.keys = new Object[0];
        this.values = new Object[0];
        this.comparator = comparator2;
    }

    private static <T> T[] addToArray(T[] tArr, int i10, T t10) {
        int length = tArr.length + 1;
        T[] tArr2 = new Object[length];
        System.arraycopy(tArr, 0, tArr2, 0, i10);
        tArr2[i10] = t10;
        System.arraycopy(tArr, i10, tArr2, i10 + 1, (length - i10) - 1);
        return tArr2;
    }

    public static <A, B, C> ArraySortedMap<A, C> buildFrom(List<A> list, Map<B, C> map, ImmutableSortedMap.Builder.KeyTranslator<A, B> keyTranslator, Comparator<A> comparator2) {
        Collections.sort(list, comparator2);
        int size = list.size();
        Object[] objArr = new Object[size];
        Object[] objArr2 = new Object[size];
        int i10 = 0;
        for (A next : list) {
            objArr[i10] = next;
            objArr2[i10] = map.get(keyTranslator.translate(next));
            i10++;
        }
        return new ArraySortedMap<>(comparator2, objArr, objArr2);
    }

    private int findKey(K k10) {
        int i10 = 0;
        for (K compare : this.keys) {
            if (this.comparator.compare(k10, compare) == 0) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    private int findKeyOrInsertPosition(K k10) {
        int i10 = 0;
        while (true) {
            K[] kArr = this.keys;
            if (i10 >= kArr.length || this.comparator.compare(kArr[i10], k10) >= 0) {
                return i10;
            }
            i10++;
        }
        return i10;
    }

    public static <K, V> ArraySortedMap<K, V> fromMap(Map<K, V> map, Comparator<K> comparator2) {
        return buildFrom(new ArrayList(map.keySet()), map, ImmutableSortedMap.Builder.identityTranslator(), comparator2);
    }

    private Iterator<Map.Entry<K, V>> iterator(int i10, boolean z10) {
        return new Iterator<Map.Entry<K, V>>(i10, z10) {
            int currentPos;
            final /* synthetic */ int val$pos;
            final /* synthetic */ boolean val$reverse;

            {
                this.val$pos = r2;
                this.val$reverse = r3;
                this.currentPos = r2;
            }

            public boolean hasNext() {
                if (this.val$reverse) {
                    if (this.currentPos >= 0) {
                        return true;
                    }
                } else if (this.currentPos < ArraySortedMap.this.keys.length) {
                    return true;
                }
                return false;
            }

            public void remove() {
                throw new UnsupportedOperationException("Can't remove elements from ImmutableSortedMap");
            }

            public Map.Entry<K, V> next() {
                Object obj = ArraySortedMap.this.keys[this.currentPos];
                Object[] access$100 = ArraySortedMap.this.values;
                int i10 = this.currentPos;
                Object obj2 = access$100[i10];
                this.currentPos = this.val$reverse ? i10 - 1 : i10 + 1;
                return new AbstractMap.SimpleImmutableEntry(obj, obj2);
            }
        };
    }

    private static <T> T[] removeFromArray(T[] tArr, int i10) {
        int length = tArr.length - 1;
        T[] tArr2 = new Object[length];
        System.arraycopy(tArr, 0, tArr2, 0, i10);
        System.arraycopy(tArr, i10 + 1, tArr2, i10, length - i10);
        return tArr2;
    }

    private static <T> T[] replaceInArray(T[] tArr, int i10, T t10) {
        int length = tArr.length;
        T[] tArr2 = new Object[length];
        System.arraycopy(tArr, 0, tArr2, 0, length);
        tArr2[i10] = t10;
        return tArr2;
    }

    public boolean containsKey(K k10) {
        return findKey(k10) != -1;
    }

    public V get(K k10) {
        int findKey = findKey(k10);
        if (findKey != -1) {
            return this.values[findKey];
        }
        return null;
    }

    public Comparator<K> getComparator() {
        return this.comparator;
    }

    public K getMaxKey() {
        K[] kArr = this.keys;
        if (kArr.length > 0) {
            return kArr[kArr.length - 1];
        }
        return null;
    }

    public K getMinKey() {
        K[] kArr = this.keys;
        if (kArr.length > 0) {
            return kArr[0];
        }
        return null;
    }

    public K getPredecessorKey(K k10) {
        int findKey = findKey(k10);
        if (findKey == -1) {
            throw new IllegalArgumentException("Can't find predecessor of nonexistent key");
        } else if (findKey > 0) {
            return this.keys[findKey - 1];
        } else {
            return null;
        }
    }

    public K getSuccessorKey(K k10) {
        int findKey = findKey(k10);
        if (findKey != -1) {
            K[] kArr = this.keys;
            if (findKey < kArr.length - 1) {
                return kArr[findKey + 1];
            }
            return null;
        }
        throw new IllegalArgumentException("Can't find successor of nonexistent key");
    }

    public void inOrderTraversal(LLRBNode.NodeVisitor<K, V> nodeVisitor) {
        int i10 = 0;
        while (true) {
            K[] kArr = this.keys;
            if (i10 < kArr.length) {
                nodeVisitor.visitEntry(kArr[i10], this.values[i10]);
                i10++;
            } else {
                return;
            }
        }
    }

    public int indexOf(K k10) {
        return findKey(k10);
    }

    public ImmutableSortedMap<K, V> insert(K k10, V v10) {
        int findKey = findKey(k10);
        if (findKey != -1) {
            K[] kArr = this.keys;
            if (kArr[findKey] == k10 && this.values[findKey] == v10) {
                return this;
            }
            return new ArraySortedMap(this.comparator, replaceInArray(kArr, findKey, k10), replaceInArray(this.values, findKey, v10));
        } else if (this.keys.length > 25) {
            HashMap hashMap = new HashMap(this.keys.length + 1);
            int i10 = 0;
            while (true) {
                K[] kArr2 = this.keys;
                if (i10 < kArr2.length) {
                    hashMap.put(kArr2[i10], this.values[i10]);
                    i10++;
                } else {
                    hashMap.put(k10, v10);
                    return RBTreeSortedMap.fromMap(hashMap, this.comparator);
                }
            }
        } else {
            int findKeyOrInsertPosition = findKeyOrInsertPosition(k10);
            return new ArraySortedMap(this.comparator, addToArray(this.keys, findKeyOrInsertPosition, k10), addToArray(this.values, findKeyOrInsertPosition, v10));
        }
    }

    public boolean isEmpty() {
        return this.keys.length == 0;
    }

    public Iterator<Map.Entry<K, V>> iteratorFrom(K k10) {
        return iterator(findKeyOrInsertPosition(k10), false);
    }

    public ImmutableSortedMap<K, V> remove(K k10) {
        int findKey = findKey(k10);
        if (findKey == -1) {
            return this;
        }
        return new ArraySortedMap(this.comparator, removeFromArray(this.keys, findKey), removeFromArray(this.values, findKey));
    }

    public Iterator<Map.Entry<K, V>> reverseIterator() {
        return iterator(this.keys.length - 1, true);
    }

    public Iterator<Map.Entry<K, V>> reverseIteratorFrom(K k10) {
        int findKeyOrInsertPosition = findKeyOrInsertPosition(k10);
        K[] kArr = this.keys;
        if (findKeyOrInsertPosition >= kArr.length || this.comparator.compare(kArr[findKeyOrInsertPosition], k10) != 0) {
            return iterator(findKeyOrInsertPosition - 1, true);
        }
        return iterator(findKeyOrInsertPosition, true);
    }

    public int size() {
        return this.keys.length;
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        return iterator(0, false);
    }

    private ArraySortedMap(Comparator<K> comparator2, K[] kArr, V[] vArr) {
        this.keys = kArr;
        this.values = vArr;
        this.comparator = comparator2;
    }
}

package com.google.firebase.database.collection;

import com.google.firebase.database.collection.ImmutableSortedMap;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ImmutableSortedSet<T> implements Iterable<T> {
    private final ImmutableSortedMap<T, Void> map;

    private static class WrappedEntryIterator<T> implements Iterator<T> {
        final Iterator<Map.Entry<T, Void>> iterator;

        public WrappedEntryIterator(Iterator<Map.Entry<T, Void>> it) {
            this.iterator = it;
        }

        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        public T next() {
            return this.iterator.next().getKey();
        }

        public void remove() {
            this.iterator.remove();
        }
    }

    public ImmutableSortedSet(List<T> list, Comparator<T> comparator) {
        this.map = ImmutableSortedMap.Builder.buildFrom(list, Collections.emptyMap(), ImmutableSortedMap.Builder.identityTranslator(), comparator);
    }

    public boolean contains(T t10) {
        return this.map.containsKey(t10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImmutableSortedSet)) {
            return false;
        }
        return this.map.equals(((ImmutableSortedSet) obj).map);
    }

    public T getMaxEntry() {
        return this.map.getMaxKey();
    }

    public T getMinEntry() {
        return this.map.getMinKey();
    }

    public T getPredecessorEntry(T t10) {
        return this.map.getPredecessorKey(t10);
    }

    public int hashCode() {
        return this.map.hashCode();
    }

    public int indexOf(T t10) {
        return this.map.indexOf(t10);
    }

    public ImmutableSortedSet<T> insert(T t10) {
        return new ImmutableSortedSet<>(this.map.insert(t10, null));
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public Iterator<T> iterator() {
        return new WrappedEntryIterator(this.map.iterator());
    }

    public Iterator<T> iteratorFrom(T t10) {
        return new WrappedEntryIterator(this.map.iteratorFrom(t10));
    }

    public ImmutableSortedSet<T> remove(T t10) {
        ImmutableSortedMap<T, Void> remove = this.map.remove(t10);
        if (remove == this.map) {
            return this;
        }
        return new ImmutableSortedSet<>(remove);
    }

    public Iterator<T> reverseIterator() {
        return new WrappedEntryIterator(this.map.reverseIterator());
    }

    public Iterator<T> reverseIteratorFrom(T t10) {
        return new WrappedEntryIterator(this.map.reverseIteratorFrom(t10));
    }

    public int size() {
        return this.map.size();
    }

    public ImmutableSortedSet<T> unionWith(ImmutableSortedSet<T> immutableSortedSet) {
        ImmutableSortedSet<T> immutableSortedSet2;
        ImmutableSortedSet<T> immutableSortedSet3;
        if (size() < immutableSortedSet.size()) {
            immutableSortedSet3 = immutableSortedSet;
            immutableSortedSet2 = this;
        } else {
            immutableSortedSet3 = this;
            immutableSortedSet2 = immutableSortedSet;
        }
        Iterator it = immutableSortedSet2.iterator();
        while (it.hasNext()) {
            immutableSortedSet3 = immutableSortedSet3.insert(it.next());
        }
        return immutableSortedSet3;
    }

    private ImmutableSortedSet(ImmutableSortedMap<T, Void> immutableSortedMap) {
        this.map = immutableSortedMap;
    }
}

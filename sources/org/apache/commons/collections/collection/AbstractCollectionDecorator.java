package org.apache.commons.collections.collection;

import java.util.Collection;
import java.util.Iterator;

public abstract class AbstractCollectionDecorator implements Collection {
    protected Collection collection;

    protected AbstractCollectionDecorator() {
    }

    public boolean add(Object obj) {
        return this.collection.add(obj);
    }

    public boolean addAll(Collection collection2) {
        return this.collection.addAll(collection2);
    }

    public void clear() {
        this.collection.clear();
    }

    public boolean contains(Object obj) {
        return this.collection.contains(obj);
    }

    public boolean containsAll(Collection collection2) {
        return this.collection.containsAll(collection2);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return this.collection.equals(obj);
    }

    /* access modifiers changed from: protected */
    public Collection getCollection() {
        return this.collection;
    }

    public int hashCode() {
        return this.collection.hashCode();
    }

    public boolean isEmpty() {
        return this.collection.isEmpty();
    }

    public Iterator iterator() {
        return this.collection.iterator();
    }

    public boolean remove(Object obj) {
        return this.collection.remove(obj);
    }

    public boolean removeAll(Collection collection2) {
        return this.collection.removeAll(collection2);
    }

    public boolean retainAll(Collection collection2) {
        return this.collection.retainAll(collection2);
    }

    public int size() {
        return this.collection.size();
    }

    public Object[] toArray() {
        return this.collection.toArray();
    }

    public String toString() {
        return this.collection.toString();
    }

    protected AbstractCollectionDecorator(Collection collection2) {
        if (collection2 != null) {
            this.collection = collection2;
            return;
        }
        throw new IllegalArgumentException("Collection must not be null");
    }

    public Object[] toArray(Object[] objArr) {
        return this.collection.toArray(objArr);
    }
}

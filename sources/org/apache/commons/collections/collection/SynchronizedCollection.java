package org.apache.commons.collections.collection;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

public class SynchronizedCollection implements Collection, Serializable {
    private static final long serialVersionUID = 2412805092710877986L;
    protected final Collection collection;
    /* access modifiers changed from: protected */
    public final Object lock;

    protected SynchronizedCollection(Collection collection2) {
        if (collection2 != null) {
            this.collection = collection2;
            this.lock = this;
            return;
        }
        throw new IllegalArgumentException("Collection must not be null");
    }

    public static Collection decorate(Collection collection2) {
        return new SynchronizedCollection(collection2);
    }

    public boolean add(Object obj) {
        boolean add;
        synchronized (this.lock) {
            add = this.collection.add(obj);
        }
        return add;
    }

    public boolean addAll(Collection collection2) {
        boolean addAll;
        synchronized (this.lock) {
            addAll = this.collection.addAll(collection2);
        }
        return addAll;
    }

    public void clear() {
        synchronized (this.lock) {
            this.collection.clear();
        }
    }

    public boolean contains(Object obj) {
        boolean contains;
        synchronized (this.lock) {
            contains = this.collection.contains(obj);
        }
        return contains;
    }

    public boolean containsAll(Collection collection2) {
        boolean containsAll;
        synchronized (this.lock) {
            containsAll = this.collection.containsAll(collection2);
        }
        return containsAll;
    }

    public boolean equals(Object obj) {
        synchronized (this.lock) {
            if (obj == this) {
                return true;
            }
            boolean equals = this.collection.equals(obj);
            return equals;
        }
    }

    public int hashCode() {
        int hashCode;
        synchronized (this.lock) {
            hashCode = this.collection.hashCode();
        }
        return hashCode;
    }

    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.lock) {
            isEmpty = this.collection.isEmpty();
        }
        return isEmpty;
    }

    public Iterator iterator() {
        return this.collection.iterator();
    }

    public boolean remove(Object obj) {
        boolean remove;
        synchronized (this.lock) {
            remove = this.collection.remove(obj);
        }
        return remove;
    }

    public boolean removeAll(Collection collection2) {
        boolean removeAll;
        synchronized (this.lock) {
            removeAll = this.collection.removeAll(collection2);
        }
        return removeAll;
    }

    public boolean retainAll(Collection collection2) {
        boolean retainAll;
        synchronized (this.lock) {
            retainAll = this.collection.retainAll(collection2);
        }
        return retainAll;
    }

    public int size() {
        int size;
        synchronized (this.lock) {
            size = this.collection.size();
        }
        return size;
    }

    public Object[] toArray() {
        Object[] array2;
        synchronized (this.lock) {
            array2 = this.collection.toArray();
        }
        return array2;
    }

    public String toString() {
        String obj;
        synchronized (this.lock) {
            obj = this.collection.toString();
        }
        return obj;
    }

    public Object[] toArray(Object[] objArr) {
        Object[] array2;
        synchronized (this.lock) {
            array2 = this.collection.toArray(objArr);
        }
        return array2;
    }

    protected SynchronizedCollection(Collection collection2, Object obj) {
        if (collection2 != null) {
            this.collection = collection2;
            this.lock = obj;
            return;
        }
        throw new IllegalArgumentException("Collection must not be null");
    }
}

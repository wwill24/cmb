package io.sentry;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

class SynchronizedCollection<E> implements Collection<E>, Serializable {
    private static final long serialVersionUID = 2412805092710877986L;
    private final Collection<E> collection;
    final Object lock;

    SynchronizedCollection(Collection<E> collection2) {
        if (collection2 != null) {
            this.collection = collection2;
            this.lock = this;
            return;
        }
        throw new NullPointerException("Collection must not be null.");
    }

    public boolean add(E e10) {
        boolean add;
        synchronized (this.lock) {
            add = b().add(e10);
        }
        return add;
    }

    public boolean addAll(Collection<? extends E> collection2) {
        boolean addAll;
        synchronized (this.lock) {
            addAll = b().addAll(collection2);
        }
        return addAll;
    }

    /* access modifiers changed from: protected */
    public Collection<E> b() {
        return this.collection;
    }

    public void clear() {
        synchronized (this.lock) {
            b().clear();
        }
    }

    public boolean contains(Object obj) {
        boolean contains;
        synchronized (this.lock) {
            contains = b().contains(obj);
        }
        return contains;
    }

    public boolean containsAll(Collection<?> collection2) {
        boolean containsAll;
        synchronized (this.lock) {
            containsAll = b().containsAll(collection2);
        }
        return containsAll;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0019, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.lock
            monitor-enter(r0)
            r1 = 1
            if (r4 != r3) goto L_0x000a
            monitor-exit(r0)     // Catch:{ all -> 0x0008 }
            return r1
        L_0x0008:
            r4 = move-exception
            goto L_0x001a
        L_0x000a:
            if (r4 == r3) goto L_0x0018
            java.util.Collection r2 = r3.b()     // Catch:{ all -> 0x0008 }
            boolean r4 = r2.equals(r4)     // Catch:{ all -> 0x0008 }
            if (r4 == 0) goto L_0x0017
            goto L_0x0018
        L_0x0017:
            r1 = 0
        L_0x0018:
            monitor-exit(r0)     // Catch:{ all -> 0x0008 }
            return r1
        L_0x001a:
            monitor-exit(r0)     // Catch:{ all -> 0x0008 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.SynchronizedCollection.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int hashCode;
        synchronized (this.lock) {
            hashCode = b().hashCode();
        }
        return hashCode;
    }

    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.lock) {
            isEmpty = b().isEmpty();
        }
        return isEmpty;
    }

    public Iterator<E> iterator() {
        return b().iterator();
    }

    public boolean remove(Object obj) {
        boolean remove;
        synchronized (this.lock) {
            remove = b().remove(obj);
        }
        return remove;
    }

    public boolean removeAll(Collection<?> collection2) {
        boolean removeAll;
        synchronized (this.lock) {
            removeAll = b().removeAll(collection2);
        }
        return removeAll;
    }

    public boolean retainAll(Collection<?> collection2) {
        boolean retainAll;
        synchronized (this.lock) {
            retainAll = b().retainAll(collection2);
        }
        return retainAll;
    }

    public int size() {
        int size;
        synchronized (this.lock) {
            size = b().size();
        }
        return size;
    }

    public Object[] toArray() {
        Object[] array2;
        synchronized (this.lock) {
            array2 = b().toArray();
        }
        return array2;
    }

    public String toString() {
        String obj;
        synchronized (this.lock) {
            obj = b().toString();
        }
        return obj;
    }

    public <T> T[] toArray(T[] tArr) {
        T[] array2;
        synchronized (this.lock) {
            array2 = b().toArray(tArr);
        }
        return array2;
    }
}

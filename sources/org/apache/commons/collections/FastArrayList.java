package org.apache.commons.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class FastArrayList extends ArrayList {
    protected boolean fast;
    protected ArrayList list;

    private class ListIter implements ListIterator {
        private List expected;
        private ListIterator iter;
        private int lastReturnedIndex = -1;

        public ListIter(int i10) {
            this.expected = FastArrayList.this.list;
            this.iter = get().listIterator(i10);
        }

        private void checkMod() {
            if (FastArrayList.this.list != this.expected) {
                throw new ConcurrentModificationException();
            }
        }

        public void add(Object obj) {
            checkMod();
            int nextIndex = nextIndex();
            get().add(nextIndex, obj);
            this.expected = FastArrayList.this.list;
            this.iter = get().listIterator(nextIndex + 1);
            this.lastReturnedIndex = -1;
        }

        /* access modifiers changed from: package-private */
        public List get() {
            return this.expected;
        }

        public boolean hasNext() {
            return this.iter.hasNext();
        }

        public boolean hasPrevious() {
            return this.iter.hasPrevious();
        }

        public Object next() {
            this.lastReturnedIndex = this.iter.nextIndex();
            return this.iter.next();
        }

        public int nextIndex() {
            return this.iter.nextIndex();
        }

        public Object previous() {
            this.lastReturnedIndex = this.iter.previousIndex();
            return this.iter.previous();
        }

        public int previousIndex() {
            return this.iter.previousIndex();
        }

        public void remove() {
            checkMod();
            if (this.lastReturnedIndex >= 0) {
                get().remove(this.lastReturnedIndex);
                this.expected = FastArrayList.this.list;
                this.iter = get().listIterator(this.lastReturnedIndex);
                this.lastReturnedIndex = -1;
                return;
            }
            throw new IllegalStateException();
        }

        public void set(Object obj) {
            checkMod();
            if (this.lastReturnedIndex >= 0) {
                get().set(this.lastReturnedIndex, obj);
                this.expected = FastArrayList.this.list;
                this.iter = get().listIterator(previousIndex() + 1);
                return;
            }
            throw new IllegalStateException();
        }
    }

    private class SubList implements List {
        private List expected;
        private int first;
        private int last;

        private class SubListIter implements ListIterator {
            private List expected;
            private ListIterator iter;
            private int lastReturnedIndex = -1;

            public SubListIter(int i10) {
                ArrayList arrayList = FastArrayList.this.list;
                this.expected = arrayList;
                this.iter = SubList.this.get((List) arrayList).listIterator(i10);
            }

            private void checkMod() {
                if (FastArrayList.this.list != this.expected) {
                    throw new ConcurrentModificationException();
                }
            }

            public void add(Object obj) {
                checkMod();
                int nextIndex = nextIndex();
                get().add(nextIndex, obj);
                SubList.access$208(SubList.this);
                this.expected = FastArrayList.this.list;
                this.iter = get().listIterator(nextIndex + 1);
                this.lastReturnedIndex = -1;
            }

            /* access modifiers changed from: package-private */
            public List get() {
                return SubList.this.get(this.expected);
            }

            public boolean hasNext() {
                checkMod();
                return this.iter.hasNext();
            }

            public boolean hasPrevious() {
                checkMod();
                return this.iter.hasPrevious();
            }

            public Object next() {
                checkMod();
                this.lastReturnedIndex = this.iter.nextIndex();
                return this.iter.next();
            }

            public int nextIndex() {
                checkMod();
                return this.iter.nextIndex();
            }

            public Object previous() {
                checkMod();
                this.lastReturnedIndex = this.iter.previousIndex();
                return this.iter.previous();
            }

            public int previousIndex() {
                checkMod();
                return this.iter.previousIndex();
            }

            public void remove() {
                checkMod();
                if (this.lastReturnedIndex >= 0) {
                    get().remove(this.lastReturnedIndex);
                    SubList.access$210(SubList.this);
                    this.expected = FastArrayList.this.list;
                    this.iter = get().listIterator(this.lastReturnedIndex);
                    this.lastReturnedIndex = -1;
                    return;
                }
                throw new IllegalStateException();
            }

            public void set(Object obj) {
                checkMod();
                if (this.lastReturnedIndex >= 0) {
                    get().set(this.lastReturnedIndex, obj);
                    this.expected = FastArrayList.this.list;
                    this.iter = get().listIterator(previousIndex() + 1);
                    return;
                }
                throw new IllegalStateException();
            }
        }

        public SubList(int i10, int i11) {
            this.first = i10;
            this.last = i11;
            this.expected = FastArrayList.this.list;
        }

        static /* synthetic */ int access$208(SubList subList) {
            int i10 = subList.last;
            subList.last = i10 + 1;
            return i10;
        }

        static /* synthetic */ int access$210(SubList subList) {
            int i10 = subList.last;
            subList.last = i10 - 1;
            return i10;
        }

        /* access modifiers changed from: private */
        public List get(List list) {
            if (FastArrayList.this.list == this.expected) {
                return list.subList(this.first, this.last);
            }
            throw new ConcurrentModificationException();
        }

        public boolean add(Object obj) {
            boolean add;
            boolean add2;
            FastArrayList fastArrayList = FastArrayList.this;
            if (fastArrayList.fast) {
                synchronized (fastArrayList) {
                    ArrayList arrayList = (ArrayList) FastArrayList.this.list.clone();
                    add2 = get((List) arrayList).add(obj);
                    if (add2) {
                        this.last++;
                    }
                    FastArrayList.this.list = arrayList;
                    this.expected = arrayList;
                }
                return add2;
            }
            synchronized (fastArrayList.list) {
                add = get(this.expected).add(obj);
            }
            return add;
        }

        public boolean addAll(Collection collection) {
            boolean addAll;
            boolean addAll2;
            FastArrayList fastArrayList = FastArrayList.this;
            if (fastArrayList.fast) {
                synchronized (fastArrayList) {
                    ArrayList arrayList = (ArrayList) FastArrayList.this.list.clone();
                    addAll2 = get((List) arrayList).addAll(collection);
                    if (addAll2) {
                        this.last += collection.size();
                    }
                    FastArrayList.this.list = arrayList;
                    this.expected = arrayList;
                }
                return addAll2;
            }
            synchronized (fastArrayList.list) {
                addAll = get(this.expected).addAll(collection);
            }
            return addAll;
        }

        public void clear() {
            FastArrayList fastArrayList = FastArrayList.this;
            if (fastArrayList.fast) {
                synchronized (fastArrayList) {
                    ArrayList arrayList = (ArrayList) FastArrayList.this.list.clone();
                    get((List) arrayList).clear();
                    this.last = this.first;
                    FastArrayList.this.list = arrayList;
                    this.expected = arrayList;
                }
                return;
            }
            synchronized (fastArrayList.list) {
                get(this.expected).clear();
            }
        }

        public boolean contains(Object obj) {
            boolean contains;
            FastArrayList fastArrayList = FastArrayList.this;
            if (fastArrayList.fast) {
                return get(this.expected).contains(obj);
            }
            synchronized (fastArrayList.list) {
                contains = get(this.expected).contains(obj);
            }
            return contains;
        }

        public boolean containsAll(Collection collection) {
            boolean containsAll;
            FastArrayList fastArrayList = FastArrayList.this;
            if (fastArrayList.fast) {
                return get(this.expected).containsAll(collection);
            }
            synchronized (fastArrayList.list) {
                containsAll = get(this.expected).containsAll(collection);
            }
            return containsAll;
        }

        public boolean equals(Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            FastArrayList fastArrayList = FastArrayList.this;
            if (fastArrayList.fast) {
                return get(this.expected).equals(obj);
            }
            synchronized (fastArrayList.list) {
                equals = get(this.expected).equals(obj);
            }
            return equals;
        }

        public int hashCode() {
            int hashCode;
            FastArrayList fastArrayList = FastArrayList.this;
            if (fastArrayList.fast) {
                return get(this.expected).hashCode();
            }
            synchronized (fastArrayList.list) {
                hashCode = get(this.expected).hashCode();
            }
            return hashCode;
        }

        public int indexOf(Object obj) {
            int indexOf;
            FastArrayList fastArrayList = FastArrayList.this;
            if (fastArrayList.fast) {
                return get(this.expected).indexOf(obj);
            }
            synchronized (fastArrayList.list) {
                indexOf = get(this.expected).indexOf(obj);
            }
            return indexOf;
        }

        public boolean isEmpty() {
            boolean isEmpty;
            FastArrayList fastArrayList = FastArrayList.this;
            if (fastArrayList.fast) {
                return get(this.expected).isEmpty();
            }
            synchronized (fastArrayList.list) {
                isEmpty = get(this.expected).isEmpty();
            }
            return isEmpty;
        }

        public Iterator iterator() {
            return new SubListIter(0);
        }

        public int lastIndexOf(Object obj) {
            int lastIndexOf;
            FastArrayList fastArrayList = FastArrayList.this;
            if (fastArrayList.fast) {
                return get(this.expected).lastIndexOf(obj);
            }
            synchronized (fastArrayList.list) {
                lastIndexOf = get(this.expected).lastIndexOf(obj);
            }
            return lastIndexOf;
        }

        public ListIterator listIterator() {
            return new SubListIter(0);
        }

        public boolean remove(Object obj) {
            boolean remove;
            boolean remove2;
            FastArrayList fastArrayList = FastArrayList.this;
            if (fastArrayList.fast) {
                synchronized (fastArrayList) {
                    ArrayList arrayList = (ArrayList) FastArrayList.this.list.clone();
                    remove2 = get((List) arrayList).remove(obj);
                    if (remove2) {
                        this.last--;
                    }
                    FastArrayList.this.list = arrayList;
                    this.expected = arrayList;
                }
                return remove2;
            }
            synchronized (fastArrayList.list) {
                remove = get(this.expected).remove(obj);
            }
            return remove;
        }

        public boolean removeAll(Collection collection) {
            boolean removeAll;
            boolean removeAll2;
            FastArrayList fastArrayList = FastArrayList.this;
            if (fastArrayList.fast) {
                synchronized (fastArrayList) {
                    ArrayList arrayList = (ArrayList) FastArrayList.this.list.clone();
                    List list = get((List) arrayList);
                    removeAll2 = list.removeAll(collection);
                    if (removeAll2) {
                        this.last = this.first + list.size();
                    }
                    FastArrayList.this.list = arrayList;
                    this.expected = arrayList;
                }
                return removeAll2;
            }
            synchronized (fastArrayList.list) {
                removeAll = get(this.expected).removeAll(collection);
            }
            return removeAll;
        }

        public boolean retainAll(Collection collection) {
            boolean retainAll;
            boolean retainAll2;
            FastArrayList fastArrayList = FastArrayList.this;
            if (fastArrayList.fast) {
                synchronized (fastArrayList) {
                    ArrayList arrayList = (ArrayList) FastArrayList.this.list.clone();
                    List list = get((List) arrayList);
                    retainAll2 = list.retainAll(collection);
                    if (retainAll2) {
                        this.last = this.first + list.size();
                    }
                    FastArrayList.this.list = arrayList;
                    this.expected = arrayList;
                }
                return retainAll2;
            }
            synchronized (fastArrayList.list) {
                retainAll = get(this.expected).retainAll(collection);
            }
            return retainAll;
        }

        public Object set(int i10, Object obj) {
            Object obj2;
            Object obj3;
            FastArrayList fastArrayList = FastArrayList.this;
            if (fastArrayList.fast) {
                synchronized (fastArrayList) {
                    ArrayList arrayList = (ArrayList) FastArrayList.this.list.clone();
                    obj3 = get((List) arrayList).set(i10, obj);
                    FastArrayList.this.list = arrayList;
                    this.expected = arrayList;
                }
                return obj3;
            }
            synchronized (fastArrayList.list) {
                obj2 = get(this.expected).set(i10, obj);
            }
            return obj2;
        }

        public int size() {
            int size;
            FastArrayList fastArrayList = FastArrayList.this;
            if (fastArrayList.fast) {
                return get(this.expected).size();
            }
            synchronized (fastArrayList.list) {
                size = get(this.expected).size();
            }
            return size;
        }

        public List subList(int i10, int i11) {
            FastArrayList fastArrayList = FastArrayList.this;
            if (fastArrayList.list == this.expected) {
                return new SubList(this.first + i10, i10 + i11);
            }
            throw new ConcurrentModificationException();
        }

        public Object[] toArray(Object[] objArr) {
            Object[] array2;
            FastArrayList fastArrayList = FastArrayList.this;
            if (fastArrayList.fast) {
                return get(this.expected).toArray(objArr);
            }
            synchronized (fastArrayList.list) {
                array2 = get(this.expected).toArray(objArr);
            }
            return array2;
        }

        public ListIterator listIterator(int i10) {
            return new SubListIter(i10);
        }

        public Object get(int i10) {
            Object obj;
            FastArrayList fastArrayList = FastArrayList.this;
            if (fastArrayList.fast) {
                return get(this.expected).get(i10);
            }
            synchronized (fastArrayList.list) {
                obj = get(this.expected).get(i10);
            }
            return obj;
        }

        public Object[] toArray() {
            Object[] array2;
            FastArrayList fastArrayList = FastArrayList.this;
            if (fastArrayList.fast) {
                return get(this.expected).toArray();
            }
            synchronized (fastArrayList.list) {
                array2 = get(this.expected).toArray();
            }
            return array2;
        }

        public void add(int i10, Object obj) {
            FastArrayList fastArrayList = FastArrayList.this;
            if (fastArrayList.fast) {
                synchronized (fastArrayList) {
                    ArrayList arrayList = (ArrayList) FastArrayList.this.list.clone();
                    get((List) arrayList).add(i10, obj);
                    this.last++;
                    FastArrayList.this.list = arrayList;
                    this.expected = arrayList;
                }
                return;
            }
            synchronized (fastArrayList.list) {
                get(this.expected).add(i10, obj);
            }
        }

        public boolean addAll(int i10, Collection collection) {
            boolean addAll;
            boolean addAll2;
            FastArrayList fastArrayList = FastArrayList.this;
            if (fastArrayList.fast) {
                synchronized (fastArrayList) {
                    ArrayList arrayList = (ArrayList) FastArrayList.this.list.clone();
                    addAll2 = get((List) arrayList).addAll(i10, collection);
                    FastArrayList.this.list = arrayList;
                    if (addAll2) {
                        this.last += collection.size();
                    }
                    this.expected = arrayList;
                }
                return addAll2;
            }
            synchronized (fastArrayList.list) {
                addAll = get(this.expected).addAll(i10, collection);
            }
            return addAll;
        }

        public Object remove(int i10) {
            Object remove;
            Object remove2;
            FastArrayList fastArrayList = FastArrayList.this;
            if (fastArrayList.fast) {
                synchronized (fastArrayList) {
                    ArrayList arrayList = (ArrayList) FastArrayList.this.list.clone();
                    remove2 = get((List) arrayList).remove(i10);
                    this.last--;
                    FastArrayList.this.list = arrayList;
                    this.expected = arrayList;
                }
                return remove2;
            }
            synchronized (fastArrayList.list) {
                remove = get(this.expected).remove(i10);
            }
            return remove;
        }
    }

    public FastArrayList() {
        this.list = null;
        this.fast = false;
        this.list = new ArrayList();
    }

    public boolean add(Object obj) {
        boolean add;
        boolean add2;
        if (this.fast) {
            synchronized (this) {
                ArrayList arrayList = (ArrayList) this.list.clone();
                add2 = arrayList.add(obj);
                this.list = arrayList;
            }
            return add2;
        }
        synchronized (this.list) {
            add = this.list.add(obj);
        }
        return add;
    }

    public boolean addAll(Collection collection) {
        boolean addAll;
        boolean addAll2;
        if (this.fast) {
            synchronized (this) {
                ArrayList arrayList = (ArrayList) this.list.clone();
                addAll2 = arrayList.addAll(collection);
                this.list = arrayList;
            }
            return addAll2;
        }
        synchronized (this.list) {
            addAll = this.list.addAll(collection);
        }
        return addAll;
    }

    public void clear() {
        if (this.fast) {
            synchronized (this) {
                ArrayList arrayList = (ArrayList) this.list.clone();
                arrayList.clear();
                this.list = arrayList;
            }
            return;
        }
        synchronized (this.list) {
            this.list.clear();
        }
    }

    public Object clone() {
        FastArrayList fastArrayList;
        FastArrayList fastArrayList2;
        if (this.fast) {
            fastArrayList = new FastArrayList((Collection) this.list);
        } else {
            synchronized (this.list) {
                fastArrayList2 = new FastArrayList((Collection) this.list);
            }
            fastArrayList = fastArrayList2;
        }
        fastArrayList.setFast(getFast());
        return fastArrayList;
    }

    public boolean contains(Object obj) {
        boolean contains;
        if (this.fast) {
            return this.list.contains(obj);
        }
        synchronized (this.list) {
            contains = this.list.contains(obj);
        }
        return contains;
    }

    public boolean containsAll(Collection collection) {
        boolean containsAll;
        if (this.fast) {
            return this.list.containsAll(collection);
        }
        synchronized (this.list) {
            containsAll = this.list.containsAll(collection);
        }
        return containsAll;
    }

    public void ensureCapacity(int i10) {
        if (this.fast) {
            synchronized (this) {
                ArrayList arrayList = (ArrayList) this.list.clone();
                arrayList.ensureCapacity(i10);
                this.list = arrayList;
            }
            return;
        }
        synchronized (this.list) {
            this.list.ensureCapacity(i10);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0076, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0086, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            if (r7 != r6) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r7 instanceof java.util.List
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            java.util.List r7 = (java.util.List) r7
            boolean r1 = r6.fast
            if (r1 == 0) goto L_0x0049
            java.util.ArrayList r1 = r6.list
            java.util.ListIterator r1 = r1.listIterator()
            java.util.ListIterator r7 = r7.listIterator()
        L_0x001a:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x003a
            boolean r3 = r7.hasNext()
            if (r3 == 0) goto L_0x003a
            java.lang.Object r3 = r1.next()
            java.lang.Object r4 = r7.next()
            if (r3 != 0) goto L_0x0033
            if (r4 != 0) goto L_0x0039
            goto L_0x001a
        L_0x0033:
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x001a
        L_0x0039:
            return r2
        L_0x003a:
            boolean r1 = r1.hasNext()
            if (r1 != 0) goto L_0x0047
            boolean r7 = r7.hasNext()
            if (r7 != 0) goto L_0x0047
            goto L_0x0048
        L_0x0047:
            r0 = r2
        L_0x0048:
            return r0
        L_0x0049:
            java.util.ArrayList r1 = r6.list
            monitor-enter(r1)
            java.util.ArrayList r3 = r6.list     // Catch:{ all -> 0x0087 }
            java.util.ListIterator r3 = r3.listIterator()     // Catch:{ all -> 0x0087 }
            java.util.ListIterator r7 = r7.listIterator()     // Catch:{ all -> 0x0087 }
        L_0x0056:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x0087 }
            if (r4 == 0) goto L_0x0077
            boolean r4 = r7.hasNext()     // Catch:{ all -> 0x0087 }
            if (r4 == 0) goto L_0x0077
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x0087 }
            java.lang.Object r5 = r7.next()     // Catch:{ all -> 0x0087 }
            if (r4 != 0) goto L_0x006f
            if (r5 != 0) goto L_0x0075
            goto L_0x0056
        L_0x006f:
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x0087 }
            if (r4 != 0) goto L_0x0056
        L_0x0075:
            monitor-exit(r1)     // Catch:{ all -> 0x0087 }
            return r2
        L_0x0077:
            boolean r3 = r3.hasNext()     // Catch:{ all -> 0x0087 }
            if (r3 != 0) goto L_0x0084
            boolean r7 = r7.hasNext()     // Catch:{ all -> 0x0087 }
            if (r7 != 0) goto L_0x0084
            goto L_0x0085
        L_0x0084:
            r0 = r2
        L_0x0085:
            monitor-exit(r1)     // Catch:{ all -> 0x0087 }
            return r0
        L_0x0087:
            r7 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0087 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.collections.FastArrayList.equals(java.lang.Object):boolean");
    }

    public Object get(int i10) {
        Object obj;
        if (this.fast) {
            return this.list.get(i10);
        }
        synchronized (this.list) {
            obj = this.list.get(i10);
        }
        return obj;
    }

    public boolean getFast() {
        return this.fast;
    }

    public int hashCode() {
        int i10;
        int i11;
        int i12 = 1;
        if (this.fast) {
            Iterator it = this.list.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                int i13 = i12 * 31;
                if (next == null) {
                    i11 = 0;
                } else {
                    i11 = next.hashCode();
                }
                i12 = i13 + i11;
            }
            return i12;
        }
        synchronized (this.list) {
            Iterator it2 = this.list.iterator();
            while (it2.hasNext()) {
                Object next2 = it2.next();
                int i14 = i12 * 31;
                if (next2 == null) {
                    i10 = 0;
                } else {
                    i10 = next2.hashCode();
                }
                i12 = i14 + i10;
            }
        }
        return i12;
    }

    public int indexOf(Object obj) {
        int indexOf;
        if (this.fast) {
            return this.list.indexOf(obj);
        }
        synchronized (this.list) {
            indexOf = this.list.indexOf(obj);
        }
        return indexOf;
    }

    public boolean isEmpty() {
        boolean isEmpty;
        if (this.fast) {
            return this.list.isEmpty();
        }
        synchronized (this.list) {
            isEmpty = this.list.isEmpty();
        }
        return isEmpty;
    }

    public Iterator iterator() {
        if (this.fast) {
            return new ListIter(0);
        }
        return this.list.iterator();
    }

    public int lastIndexOf(Object obj) {
        int lastIndexOf;
        if (this.fast) {
            return this.list.lastIndexOf(obj);
        }
        synchronized (this.list) {
            lastIndexOf = this.list.lastIndexOf(obj);
        }
        return lastIndexOf;
    }

    public ListIterator listIterator() {
        if (this.fast) {
            return new ListIter(0);
        }
        return this.list.listIterator();
    }

    public Object remove(int i10) {
        Object remove;
        Object remove2;
        if (this.fast) {
            synchronized (this) {
                ArrayList arrayList = (ArrayList) this.list.clone();
                remove2 = arrayList.remove(i10);
                this.list = arrayList;
            }
            return remove2;
        }
        synchronized (this.list) {
            remove = this.list.remove(i10);
        }
        return remove;
    }

    public boolean removeAll(Collection collection) {
        boolean removeAll;
        boolean removeAll2;
        if (this.fast) {
            synchronized (this) {
                ArrayList arrayList = (ArrayList) this.list.clone();
                removeAll2 = arrayList.removeAll(collection);
                this.list = arrayList;
            }
            return removeAll2;
        }
        synchronized (this.list) {
            removeAll = this.list.removeAll(collection);
        }
        return removeAll;
    }

    public boolean retainAll(Collection collection) {
        boolean retainAll;
        boolean retainAll2;
        if (this.fast) {
            synchronized (this) {
                ArrayList arrayList = (ArrayList) this.list.clone();
                retainAll2 = arrayList.retainAll(collection);
                this.list = arrayList;
            }
            return retainAll2;
        }
        synchronized (this.list) {
            retainAll = this.list.retainAll(collection);
        }
        return retainAll;
    }

    public Object set(int i10, Object obj) {
        Object obj2;
        if (this.fast) {
            return this.list.set(i10, obj);
        }
        synchronized (this.list) {
            obj2 = this.list.set(i10, obj);
        }
        return obj2;
    }

    public void setFast(boolean z10) {
        this.fast = z10;
    }

    public int size() {
        int size;
        if (this.fast) {
            return this.list.size();
        }
        synchronized (this.list) {
            size = this.list.size();
        }
        return size;
    }

    public List subList(int i10, int i11) {
        if (this.fast) {
            return new SubList(i10, i11);
        }
        return this.list.subList(i10, i11);
    }

    public Object[] toArray() {
        Object[] array2;
        if (this.fast) {
            return this.list.toArray();
        }
        synchronized (this.list) {
            array2 = this.list.toArray();
        }
        return array2;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("FastArrayList[");
        stringBuffer.append(this.list.toString());
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public void trimToSize() {
        if (this.fast) {
            synchronized (this) {
                ArrayList arrayList = (ArrayList) this.list.clone();
                arrayList.trimToSize();
                this.list = arrayList;
            }
            return;
        }
        synchronized (this.list) {
            this.list.trimToSize();
        }
    }

    public ListIterator listIterator(int i10) {
        if (this.fast) {
            return new ListIter(i10);
        }
        return this.list.listIterator(i10);
    }

    public FastArrayList(int i10) {
        this.list = null;
        this.fast = false;
        this.list = new ArrayList(i10);
    }

    public Object[] toArray(Object[] objArr) {
        Object[] array2;
        if (this.fast) {
            return this.list.toArray(objArr);
        }
        synchronized (this.list) {
            array2 = this.list.toArray(objArr);
        }
        return array2;
    }

    public FastArrayList(Collection collection) {
        this.list = null;
        this.fast = false;
        this.list = new ArrayList(collection);
    }

    public void add(int i10, Object obj) {
        if (this.fast) {
            synchronized (this) {
                ArrayList arrayList = (ArrayList) this.list.clone();
                arrayList.add(i10, obj);
                this.list = arrayList;
            }
            return;
        }
        synchronized (this.list) {
            this.list.add(i10, obj);
        }
    }

    public boolean addAll(int i10, Collection collection) {
        boolean addAll;
        boolean addAll2;
        if (this.fast) {
            synchronized (this) {
                ArrayList arrayList = (ArrayList) this.list.clone();
                addAll2 = arrayList.addAll(i10, collection);
                this.list = arrayList;
            }
            return addAll2;
        }
        synchronized (this.list) {
            addAll = this.list.addAll(i10, collection);
        }
        return addAll;
    }

    public boolean remove(Object obj) {
        boolean remove;
        boolean remove2;
        if (this.fast) {
            synchronized (this) {
                ArrayList arrayList = (ArrayList) this.list.clone();
                remove2 = arrayList.remove(obj);
                this.list = arrayList;
            }
            return remove2;
        }
        synchronized (this.list) {
            remove = this.list.remove(obj);
        }
        return remove;
    }
}

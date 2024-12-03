package org.apache.commons.collections.iterators;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.apache.commons.collections.list.UnmodifiableList;

public class CollatingIterator implements Iterator {
    private Comparator comparator;
    private ArrayList iterators;
    private int lastReturned;
    private BitSet valueSet;
    private ArrayList values;

    public CollatingIterator() {
        this((Comparator) null, 2);
    }

    private boolean anyHasNext(ArrayList arrayList) {
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            if (((Iterator) arrayList.get(i10)).hasNext()) {
                return true;
            }
        }
        return false;
    }

    private boolean anyValueSet(BitSet bitSet) {
        for (int i10 = 0; i10 < bitSet.size(); i10++) {
            if (bitSet.get(i10)) {
                return true;
            }
        }
        return false;
    }

    private void checkNotStarted() throws IllegalStateException {
        if (this.values != null) {
            throw new IllegalStateException("Can't do that after next or hasNext has been called.");
        }
    }

    private void clear(int i10) {
        this.values.set(i10, (Object) null);
        this.valueSet.clear(i10);
    }

    private int least() {
        Object obj = null;
        int i10 = -1;
        for (int i11 = 0; i11 < this.values.size(); i11++) {
            if (!this.valueSet.get(i11)) {
                set(i11);
            }
            if (this.valueSet.get(i11)) {
                if (i10 == -1) {
                    obj = this.values.get(i11);
                    i10 = i11;
                } else {
                    Object obj2 = this.values.get(i11);
                    if (this.comparator.compare(obj2, obj) < 0) {
                        i10 = i11;
                        obj = obj2;
                    }
                }
            }
        }
        return i10;
    }

    private boolean set(int i10) {
        Iterator it = (Iterator) this.iterators.get(i10);
        if (it.hasNext()) {
            this.values.set(i10, it.next());
            this.valueSet.set(i10);
            return true;
        }
        this.values.set(i10, (Object) null);
        this.valueSet.clear(i10);
        return false;
    }

    private void start() {
        if (this.values == null) {
            this.values = new ArrayList(this.iterators.size());
            this.valueSet = new BitSet(this.iterators.size());
            for (int i10 = 0; i10 < this.iterators.size(); i10++) {
                this.values.add((Object) null);
                this.valueSet.clear(i10);
            }
        }
    }

    public void addIterator(Iterator it) {
        checkNotStarted();
        if (it != null) {
            this.iterators.add(it);
            return;
        }
        throw new NullPointerException("Iterator must not be null");
    }

    public Comparator getComparator() {
        return this.comparator;
    }

    public List getIterators() {
        return UnmodifiableList.decorate(this.iterators);
    }

    public boolean hasNext() {
        start();
        if (anyValueSet(this.valueSet) || anyHasNext(this.iterators)) {
            return true;
        }
        return false;
    }

    public Object next() throws NoSuchElementException {
        if (hasNext()) {
            int least = least();
            if (least != -1) {
                Object obj = this.values.get(least);
                clear(least);
                this.lastReturned = least;
                return obj;
            }
            throw new NoSuchElementException();
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        int i10 = this.lastReturned;
        if (i10 != -1) {
            ((Iterator) this.iterators.get(i10)).remove();
            return;
        }
        throw new IllegalStateException("No value can be removed at present");
    }

    public void setComparator(Comparator comparator2) {
        checkNotStarted();
        this.comparator = comparator2;
    }

    public void setIterator(int i10, Iterator it) {
        checkNotStarted();
        if (it != null) {
            this.iterators.set(i10, it);
            return;
        }
        throw new NullPointerException("Iterator must not be null");
    }

    public CollatingIterator(Comparator comparator2) {
        this(comparator2, 2);
    }

    public CollatingIterator(Comparator comparator2, int i10) {
        this.comparator = null;
        this.iterators = null;
        this.values = null;
        this.valueSet = null;
        this.lastReturned = -1;
        this.iterators = new ArrayList(i10);
        setComparator(comparator2);
    }

    public CollatingIterator(Comparator comparator2, Iterator it, Iterator it2) {
        this(comparator2, 2);
        addIterator(it);
        addIterator(it2);
    }

    public CollatingIterator(Comparator comparator2, Iterator[] itArr) {
        this(comparator2, itArr.length);
        for (Iterator addIterator : itArr) {
            addIterator(addIterator);
        }
    }

    public CollatingIterator(Comparator comparator2, Collection collection) {
        this(comparator2, collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            addIterator((Iterator) it.next());
        }
    }
}

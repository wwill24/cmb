package org.apache.commons.collections.iterators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.collections.list.UnmodifiableList;

public class IteratorChain implements Iterator {
    protected Iterator currentIterator;
    protected int currentIteratorIndex;
    protected boolean isLocked;
    protected final List iteratorChain;
    protected Iterator lastUsedIterator;

    public IteratorChain() {
        this.iteratorChain = new ArrayList();
        this.currentIteratorIndex = 0;
        this.currentIterator = null;
        this.lastUsedIterator = null;
        this.isLocked = false;
    }

    private void checkLocked() {
        if (this.isLocked) {
            throw new UnsupportedOperationException("IteratorChain cannot be changed after the first use of a method from the Iterator interface");
        }
    }

    private void lockChain() {
        if (!this.isLocked) {
            this.isLocked = true;
        }
    }

    public void addIterator(Iterator it) {
        checkLocked();
        if (it != null) {
            this.iteratorChain.add(it);
            return;
        }
        throw new NullPointerException("Iterator must not be null");
    }

    public List getIterators() {
        return UnmodifiableList.decorate(this.iteratorChain);
    }

    public boolean hasNext() {
        lockChain();
        updateCurrentIterator();
        Iterator it = this.currentIterator;
        this.lastUsedIterator = it;
        return it.hasNext();
    }

    public boolean isLocked() {
        return this.isLocked;
    }

    public Object next() {
        lockChain();
        updateCurrentIterator();
        Iterator it = this.currentIterator;
        this.lastUsedIterator = it;
        return it.next();
    }

    public void remove() {
        lockChain();
        if (this.currentIterator == null) {
            updateCurrentIterator();
        }
        this.lastUsedIterator.remove();
    }

    public void setIterator(int i10, Iterator it) throws IndexOutOfBoundsException {
        checkLocked();
        if (it != null) {
            this.iteratorChain.set(i10, it);
            return;
        }
        throw new NullPointerException("Iterator must not be null");
    }

    public int size() {
        return this.iteratorChain.size();
    }

    /* access modifiers changed from: protected */
    public void updateCurrentIterator() {
        if (this.currentIterator == null) {
            if (this.iteratorChain.isEmpty()) {
                this.currentIterator = EmptyIterator.INSTANCE;
            } else {
                this.currentIterator = (Iterator) this.iteratorChain.get(0);
            }
            this.lastUsedIterator = this.currentIterator;
        }
        while (!this.currentIterator.hasNext() && this.currentIteratorIndex < this.iteratorChain.size() - 1) {
            int i10 = this.currentIteratorIndex + 1;
            this.currentIteratorIndex = i10;
            this.currentIterator = (Iterator) this.iteratorChain.get(i10);
        }
    }

    public IteratorChain(Iterator it) {
        this.iteratorChain = new ArrayList();
        this.currentIteratorIndex = 0;
        this.currentIterator = null;
        this.lastUsedIterator = null;
        this.isLocked = false;
        addIterator(it);
    }

    public IteratorChain(Iterator it, Iterator it2) {
        this.iteratorChain = new ArrayList();
        this.currentIteratorIndex = 0;
        this.currentIterator = null;
        this.lastUsedIterator = null;
        this.isLocked = false;
        addIterator(it);
        addIterator(it2);
    }

    public IteratorChain(Iterator[] itArr) {
        this.iteratorChain = new ArrayList();
        this.currentIteratorIndex = 0;
        this.currentIterator = null;
        this.lastUsedIterator = null;
        this.isLocked = false;
        for (Iterator addIterator : itArr) {
            addIterator(addIterator);
        }
    }

    public IteratorChain(Collection collection) {
        this.iteratorChain = new ArrayList();
        this.currentIteratorIndex = 0;
        this.currentIterator = null;
        this.lastUsedIterator = null;
        this.isLocked = false;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            addIterator((Iterator) it.next());
        }
    }
}

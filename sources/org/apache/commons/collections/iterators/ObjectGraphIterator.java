package org.apache.commons.collections.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections.ArrayStack;
import org.apache.commons.collections.Transformer;

public class ObjectGraphIterator implements Iterator {
    protected Iterator currentIterator;
    protected Object currentValue;
    protected boolean hasNext = false;
    protected Iterator lastUsedIterator;
    protected Object root;
    protected final ArrayStack stack = new ArrayStack(8);
    protected Transformer transformer;

    public ObjectGraphIterator(Object obj, Transformer transformer2) {
        if (obj instanceof Iterator) {
            this.currentIterator = (Iterator) obj;
        } else {
            this.root = obj;
        }
        this.transformer = transformer2;
    }

    /* access modifiers changed from: protected */
    public void findNext(Object obj) {
        if (obj instanceof Iterator) {
            findNextByIterator((Iterator) obj);
            return;
        }
        this.currentValue = obj;
        this.hasNext = true;
    }

    /* access modifiers changed from: protected */
    public void findNextByIterator(Iterator it) {
        Iterator it2 = this.currentIterator;
        if (it != it2) {
            if (it2 != null) {
                this.stack.push(it2);
            }
            this.currentIterator = it;
        }
        while (this.currentIterator.hasNext() && !this.hasNext) {
            Object next = this.currentIterator.next();
            Transformer transformer2 = this.transformer;
            if (transformer2 != null) {
                next = transformer2.transform(next);
            }
            findNext(next);
        }
        if (!this.hasNext && !this.stack.isEmpty()) {
            Iterator it3 = (Iterator) this.stack.pop();
            this.currentIterator = it3;
            findNextByIterator(it3);
        }
    }

    public boolean hasNext() {
        updateCurrentIterator();
        return this.hasNext;
    }

    public Object next() {
        updateCurrentIterator();
        if (this.hasNext) {
            this.lastUsedIterator = this.currentIterator;
            Object obj = this.currentValue;
            this.currentValue = null;
            this.hasNext = false;
            return obj;
        }
        throw new NoSuchElementException("No more elements in the iteration");
    }

    public void remove() {
        Iterator it = this.lastUsedIterator;
        if (it != null) {
            it.remove();
            this.lastUsedIterator = null;
            return;
        }
        throw new IllegalStateException("Iterator remove() cannot be called at this time");
    }

    /* access modifiers changed from: protected */
    public void updateCurrentIterator() {
        if (!this.hasNext) {
            Iterator it = this.currentIterator;
            if (it == null) {
                Object obj = this.root;
                if (obj != null) {
                    Transformer transformer2 = this.transformer;
                    if (transformer2 == null) {
                        findNext(obj);
                    } else {
                        findNext(transformer2.transform(obj));
                    }
                    this.root = null;
                    return;
                }
                return;
            }
            findNextByIterator(it);
        }
    }

    public ObjectGraphIterator(Iterator it) {
        this.currentIterator = it;
        this.transformer = null;
    }
}

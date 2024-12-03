package org.apache.commons.collections.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections.Predicate;

public class FilterIterator implements Iterator {
    private Iterator iterator;
    private Object nextObject;
    private boolean nextObjectSet = false;
    private Predicate predicate;

    public FilterIterator() {
    }

    private boolean setNextObject() {
        while (this.iterator.hasNext()) {
            Object next = this.iterator.next();
            if (this.predicate.evaluate(next)) {
                this.nextObject = next;
                this.nextObjectSet = true;
                return true;
            }
        }
        return false;
    }

    public Iterator getIterator() {
        return this.iterator;
    }

    public Predicate getPredicate() {
        return this.predicate;
    }

    public boolean hasNext() {
        if (this.nextObjectSet) {
            return true;
        }
        return setNextObject();
    }

    public Object next() {
        if (this.nextObjectSet || setNextObject()) {
            this.nextObjectSet = false;
            return this.nextObject;
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        if (!this.nextObjectSet) {
            this.iterator.remove();
            return;
        }
        throw new IllegalStateException("remove() cannot be called");
    }

    public void setIterator(Iterator it) {
        this.iterator = it;
        this.nextObject = null;
        this.nextObjectSet = false;
    }

    public void setPredicate(Predicate predicate2) {
        this.predicate = predicate2;
        this.nextObject = null;
        this.nextObjectSet = false;
    }

    public FilterIterator(Iterator it) {
        this.iterator = it;
    }

    public FilterIterator(Iterator it, Predicate predicate2) {
        this.iterator = it;
        this.predicate = predicate2;
    }
}

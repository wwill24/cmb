package org.apache.commons.collections.iterators;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections.Predicate;

public class FilterListIterator implements ListIterator {
    private ListIterator iterator;
    private int nextIndex = 0;
    private Object nextObject;
    private boolean nextObjectSet = false;
    private Predicate predicate;
    private Object previousObject;
    private boolean previousObjectSet = false;

    public FilterListIterator() {
    }

    private void clearNextObject() {
        this.nextObject = null;
        this.nextObjectSet = false;
    }

    private void clearPreviousObject() {
        this.previousObject = null;
        this.previousObjectSet = false;
    }

    private boolean setNextObject() {
        if (this.previousObjectSet) {
            clearPreviousObject();
            if (!setNextObject()) {
                return false;
            }
            clearNextObject();
        }
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

    private boolean setPreviousObject() {
        if (this.nextObjectSet) {
            clearNextObject();
            if (!setPreviousObject()) {
                return false;
            }
            clearPreviousObject();
        }
        while (this.iterator.hasPrevious()) {
            Object previous = this.iterator.previous();
            if (this.predicate.evaluate(previous)) {
                this.previousObject = previous;
                this.previousObjectSet = true;
                return true;
            }
        }
        return false;
    }

    public void add(Object obj) {
        throw new UnsupportedOperationException("FilterListIterator.add(Object) is not supported.");
    }

    public ListIterator getListIterator() {
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

    public boolean hasPrevious() {
        if (this.previousObjectSet) {
            return true;
        }
        return setPreviousObject();
    }

    public Object next() {
        if (this.nextObjectSet || setNextObject()) {
            this.nextIndex++;
            Object obj = this.nextObject;
            clearNextObject();
            return obj;
        }
        throw new NoSuchElementException();
    }

    public int nextIndex() {
        return this.nextIndex;
    }

    public Object previous() {
        if (this.previousObjectSet || setPreviousObject()) {
            this.nextIndex--;
            Object obj = this.previousObject;
            clearPreviousObject();
            return obj;
        }
        throw new NoSuchElementException();
    }

    public int previousIndex() {
        return this.nextIndex - 1;
    }

    public void remove() {
        throw new UnsupportedOperationException("FilterListIterator.remove() is not supported.");
    }

    public void set(Object obj) {
        throw new UnsupportedOperationException("FilterListIterator.set(Object) is not supported.");
    }

    public void setListIterator(ListIterator listIterator) {
        this.iterator = listIterator;
    }

    public void setPredicate(Predicate predicate2) {
        this.predicate = predicate2;
    }

    public FilterListIterator(ListIterator listIterator) {
        this.iterator = listIterator;
    }

    public FilterListIterator(ListIterator listIterator, Predicate predicate2) {
        this.iterator = listIterator;
        this.predicate = predicate2;
    }

    public FilterListIterator(Predicate predicate2) {
        this.predicate = predicate2;
    }
}

package org.apache.commons.collections.bag;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.collections.SortedBag;
import org.apache.commons.collections.Unmodifiable;
import org.apache.commons.collections.iterators.UnmodifiableIterator;
import org.apache.commons.collections.set.UnmodifiableSet;

public final class UnmodifiableSortedBag extends AbstractSortedBagDecorator implements Unmodifiable, Serializable {
    private static final long serialVersionUID = -3190437252665717841L;

    private UnmodifiableSortedBag(SortedBag sortedBag) {
        super(sortedBag);
    }

    public static SortedBag decorate(SortedBag sortedBag) {
        if (sortedBag instanceof Unmodifiable) {
            return sortedBag;
        }
        return new UnmodifiableSortedBag(sortedBag);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.collection = (Collection) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.collection);
    }

    public boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        throw new UnsupportedOperationException();
    }

    public Iterator iterator() {
        return UnmodifiableIterator.decorate(getCollection().iterator());
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public Set uniqueSet() {
        return UnmodifiableSet.decorate(getBag().uniqueSet());
    }

    public boolean add(Object obj, int i10) {
        throw new UnsupportedOperationException();
    }

    public boolean remove(Object obj, int i10) {
        throw new UnsupportedOperationException();
    }
}

package org.apache.commons.collections.bag;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.collections.Bag;
import org.apache.commons.collections.Unmodifiable;
import org.apache.commons.collections.iterators.UnmodifiableIterator;
import org.apache.commons.collections.set.UnmodifiableSet;

public final class UnmodifiableBag extends AbstractBagDecorator implements Unmodifiable, Serializable {
    private static final long serialVersionUID = -1873799975157099624L;

    private UnmodifiableBag(Bag bag) {
        super(bag);
    }

    public static Bag decorate(Bag bag) {
        if (bag instanceof Unmodifiable) {
            return bag;
        }
        return new UnmodifiableBag(bag);
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

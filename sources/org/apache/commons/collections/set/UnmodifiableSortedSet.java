package org.apache.commons.collections.set;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.SortedSet;
import org.apache.commons.collections.Unmodifiable;
import org.apache.commons.collections.iterators.UnmodifiableIterator;

public final class UnmodifiableSortedSet extends AbstractSortedSetDecorator implements Unmodifiable, Serializable {
    private static final long serialVersionUID = -725356885467962424L;

    private UnmodifiableSortedSet(SortedSet sortedSet) {
        super(sortedSet);
    }

    public static SortedSet decorate(SortedSet sortedSet) {
        if (sortedSet instanceof Unmodifiable) {
            return sortedSet;
        }
        return new UnmodifiableSortedSet(sortedSet);
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

    public SortedSet headSet(Object obj) {
        return new UnmodifiableSortedSet(getSortedSet().headSet(obj));
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

    public SortedSet subSet(Object obj, Object obj2) {
        return new UnmodifiableSortedSet(getSortedSet().subSet(obj, obj2));
    }

    public SortedSet tailSet(Object obj) {
        return new UnmodifiableSortedSet(getSortedSet().tailSet(obj));
    }
}

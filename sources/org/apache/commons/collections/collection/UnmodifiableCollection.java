package org.apache.commons.collections.collection;

import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.collections.Unmodifiable;
import org.apache.commons.collections.iterators.UnmodifiableIterator;

public final class UnmodifiableCollection extends AbstractSerializableCollectionDecorator implements Unmodifiable {
    private static final long serialVersionUID = -239892006883819945L;

    private UnmodifiableCollection(Collection collection) {
        super(collection);
    }

    public static Collection decorate(Collection collection) {
        if (collection instanceof Unmodifiable) {
            return collection;
        }
        return new UnmodifiableCollection(collection);
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
}

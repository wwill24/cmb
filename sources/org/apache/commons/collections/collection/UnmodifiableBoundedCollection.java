package org.apache.commons.collections.collection;

import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.collections.BoundedCollection;
import org.apache.commons.collections.iterators.UnmodifiableIterator;

public final class UnmodifiableBoundedCollection extends AbstractSerializableCollectionDecorator implements BoundedCollection {
    private static final long serialVersionUID = -7112672385450340330L;

    private UnmodifiableBoundedCollection(BoundedCollection boundedCollection) {
        super(boundedCollection);
    }

    public static BoundedCollection decorate(BoundedCollection boundedCollection) {
        return new UnmodifiableBoundedCollection(boundedCollection);
    }

    public static BoundedCollection decorateUsing(Collection collection) {
        if (collection != null) {
            for (int i10 = 0; i10 < 1000 && !(collection instanceof BoundedCollection); i10++) {
                if (!(collection instanceof AbstractCollectionDecorator)) {
                    if (!(collection instanceof SynchronizedCollection)) {
                        break;
                    }
                    collection = ((SynchronizedCollection) collection).collection;
                } else {
                    collection = ((AbstractCollectionDecorator) collection).collection;
                }
            }
            if (collection instanceof BoundedCollection) {
                return new UnmodifiableBoundedCollection((BoundedCollection) collection);
            }
            throw new IllegalArgumentException("The collection is not a bounded collection");
        }
        throw new IllegalArgumentException("The collection must not be null");
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

    public boolean isFull() {
        return ((BoundedCollection) this.collection).isFull();
    }

    public Iterator iterator() {
        return UnmodifiableIterator.decorate(getCollection().iterator());
    }

    public int maxSize() {
        return ((BoundedCollection) this.collection).maxSize();
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

package org.apache.commons.collections.set;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.collection.CompositeCollection;

public class CompositeSet extends CompositeCollection implements Set {

    public interface SetMutator extends CompositeCollection.CollectionMutator {
        void resolveCollision(CompositeSet compositeSet, Set set, Set set2, Collection collection);
    }

    public CompositeSet() {
    }

    public synchronized void addComposited(Collection collection) {
        if (collection instanceof Set) {
            for (Set set : getCollections()) {
                Collection intersection = CollectionUtils.intersection(set, collection);
                if (intersection.size() > 0) {
                    CompositeCollection.CollectionMutator collectionMutator = this.mutator;
                    if (collectionMutator == null) {
                        throw new UnsupportedOperationException("Collision adding composited collection with no SetMutator set");
                    } else if (collectionMutator instanceof SetMutator) {
                        ((SetMutator) collectionMutator).resolveCollision(this, set, (Set) collection, intersection);
                        if (CollectionUtils.intersection(set, collection).size() > 0) {
                            throw new IllegalArgumentException("Attempt to add illegal entry unresolved by SetMutator.resolveCollision()");
                        }
                    } else {
                        throw new UnsupportedOperationException("Collision adding composited collection to a CompositeSet with a CollectionMutator instead of a SetMutator");
                    }
                }
            }
            super.addComposited(new Collection[]{collection});
        } else {
            throw new IllegalArgumentException("Collections added must implement java.util.Set");
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (!set.containsAll(this) || set.size() != size()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i10;
        Iterator it = iterator();
        int i11 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            if (next != null) {
                i10 = next.hashCode();
            } else {
                i10 = 0;
            }
            i11 += i10;
        }
        return i11;
    }

    public boolean remove(Object obj) {
        for (Set set : getCollections()) {
            if (set.contains(obj)) {
                return set.remove(obj);
            }
        }
        return false;
    }

    public void setMutator(CompositeCollection.CollectionMutator collectionMutator) {
        super.setMutator(collectionMutator);
    }

    public CompositeSet(Set set) {
        super((Collection) set);
    }

    public CompositeSet(Set[] setArr) {
        super((Collection[]) setArr);
    }

    public synchronized void addComposited(Collection collection, Collection collection2) {
        if (!(collection instanceof Set)) {
            throw new IllegalArgumentException("Argument must implement java.util.Set");
        } else if (collection2 instanceof Set) {
            addComposited((Collection[]) new Set[]{(Set) collection, (Set) collection2});
        } else {
            throw new IllegalArgumentException("Argument must implement java.util.Set");
        }
    }

    public synchronized void addComposited(Collection[] collectionArr) {
        for (int length = collectionArr.length - 1; length >= 0; length--) {
            addComposited(collectionArr[length]);
        }
    }
}

package org.apache.commons.collections.collection;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.collections.iterators.EmptyIterator;
import org.apache.commons.collections.iterators.IteratorChain;
import org.apache.commons.collections.list.UnmodifiableList;

public class CompositeCollection implements Collection {
    protected Collection[] all;
    protected CollectionMutator mutator;

    public interface CollectionMutator {
        boolean add(CompositeCollection compositeCollection, Collection[] collectionArr, Object obj);

        boolean addAll(CompositeCollection compositeCollection, Collection[] collectionArr, Collection collection);

        boolean remove(CompositeCollection compositeCollection, Collection[] collectionArr, Object obj);
    }

    public CompositeCollection() {
        this.all = new Collection[0];
    }

    public boolean add(Object obj) {
        CollectionMutator collectionMutator = this.mutator;
        if (collectionMutator != null) {
            return collectionMutator.add(this, this.all, obj);
        }
        throw new UnsupportedOperationException("add() is not supported on CompositeCollection without a CollectionMutator strategy");
    }

    public boolean addAll(Collection collection) {
        CollectionMutator collectionMutator = this.mutator;
        if (collectionMutator != null) {
            return collectionMutator.addAll(this, this.all, collection);
        }
        throw new UnsupportedOperationException("addAll() is not supported on CompositeCollection without a CollectionMutator strategy");
    }

    public void addComposited(Collection[] collectionArr) {
        ArrayList arrayList = new ArrayList(Arrays.asList(this.all));
        arrayList.addAll(Arrays.asList(collectionArr));
        this.all = (Collection[]) arrayList.toArray(new Collection[arrayList.size()]);
    }

    public void clear() {
        int i10 = 0;
        while (true) {
            Collection[] collectionArr = this.all;
            if (i10 < collectionArr.length) {
                collectionArr[i10].clear();
                i10++;
            } else {
                return;
            }
        }
    }

    public boolean contains(Object obj) {
        for (int length = this.all.length - 1; length >= 0; length--) {
            if (this.all[length].contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsAll(Collection collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public Collection getCollections() {
        return UnmodifiableList.decorate(Arrays.asList(this.all));
    }

    public boolean isEmpty() {
        for (int length = this.all.length - 1; length >= 0; length--) {
            if (!this.all[length].isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public Iterator iterator() {
        if (this.all.length == 0) {
            return EmptyIterator.INSTANCE;
        }
        IteratorChain iteratorChain = new IteratorChain();
        int i10 = 0;
        while (true) {
            Collection[] collectionArr = this.all;
            if (i10 >= collectionArr.length) {
                return iteratorChain;
            }
            iteratorChain.addIterator(collectionArr[i10].iterator());
            i10++;
        }
    }

    public boolean remove(Object obj) {
        CollectionMutator collectionMutator = this.mutator;
        if (collectionMutator != null) {
            return collectionMutator.remove(this, this.all, obj);
        }
        throw new UnsupportedOperationException("remove() is not supported on CompositeCollection without a CollectionMutator strategy");
    }

    public boolean removeAll(Collection collection) {
        if (collection.size() == 0) {
            return false;
        }
        boolean z10 = false;
        for (int length = this.all.length - 1; length >= 0; length--) {
            if (this.all[length].removeAll(collection) || z10) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    public void removeComposited(Collection collection) {
        ArrayList arrayList = new ArrayList(this.all.length);
        arrayList.addAll(Arrays.asList(this.all));
        arrayList.remove(collection);
        this.all = (Collection[]) arrayList.toArray(new Collection[arrayList.size()]);
    }

    public boolean retainAll(Collection collection) {
        boolean z10 = false;
        for (int length = this.all.length - 1; length >= 0; length--) {
            if (this.all[length].retainAll(collection) || z10) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    public void setMutator(CollectionMutator collectionMutator) {
        this.mutator = collectionMutator;
    }

    public int size() {
        int i10 = 0;
        for (int length = this.all.length - 1; length >= 0; length--) {
            i10 += this.all[length].size();
        }
        return i10;
    }

    public Object[] toArray() {
        Object[] objArr = new Object[size()];
        Iterator it = iterator();
        int i10 = 0;
        while (it.hasNext()) {
            objArr[i10] = it.next();
            i10++;
        }
        return objArr;
    }

    public Collection toCollection() {
        return new ArrayList(this);
    }

    public CompositeCollection(Collection collection) {
        this();
        addComposited(collection);
    }

    public void addComposited(Collection collection) {
        addComposited(new Collection[]{collection});
    }

    public Object[] toArray(Object[] objArr) {
        int size = size();
        if (objArr.length < size) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), size);
        }
        int i10 = 0;
        int i11 = 0;
        while (true) {
            Collection[] collectionArr = this.all;
            if (i10 >= collectionArr.length) {
                break;
            }
            for (Object obj : collectionArr[i10]) {
                objArr[i11] = obj;
                i11++;
            }
            i10++;
        }
        if (objArr.length > size) {
            objArr[size] = null;
        }
        return objArr;
    }

    public CompositeCollection(Collection[] collectionArr) {
        this();
        addComposited(collectionArr);
    }

    public void addComposited(Collection collection, Collection collection2) {
        addComposited(new Collection[]{collection, collection2});
    }
}

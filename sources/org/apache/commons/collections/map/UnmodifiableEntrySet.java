package org.apache.commons.collections.map;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections.Unmodifiable;
import org.apache.commons.collections.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections.keyvalue.AbstractMapEntryDecorator;
import org.apache.commons.collections.set.AbstractSetDecorator;

public final class UnmodifiableEntrySet extends AbstractSetDecorator implements Unmodifiable {

    static final class UnmodifiableEntry extends AbstractMapEntryDecorator {
        protected UnmodifiableEntry(Map.Entry entry) {
            super(entry);
        }

        public Object setValue(Object obj) {
            throw new UnsupportedOperationException();
        }
    }

    static final class UnmodifiableEntrySetIterator extends AbstractIteratorDecorator {
        protected UnmodifiableEntrySetIterator(Iterator it) {
            super(it);
        }

        public Object next() {
            return new UnmodifiableEntry((Map.Entry) this.iterator.next());
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private UnmodifiableEntrySet(Set set) {
        super(set);
    }

    public static Set decorate(Set set) {
        if (set instanceof Unmodifiable) {
            return set;
        }
        return new UnmodifiableEntrySet(set);
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
        return new UnmodifiableEntrySetIterator(this.collection.iterator());
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

    public Object[] toArray() {
        Object[] array2 = this.collection.toArray();
        for (int i10 = 0; i10 < array2.length; i10++) {
            array2[i10] = new UnmodifiableEntry((Map.Entry) array2[i10]);
        }
        return array2;
    }

    public Object[] toArray(Object[] objArr) {
        Object[] array2 = this.collection.toArray(objArr.length > 0 ? (Object[]) Array.newInstance(objArr.getClass().getComponentType(), 0) : objArr);
        for (int i10 = 0; i10 < array2.length; i10++) {
            array2[i10] = new UnmodifiableEntry((Map.Entry) array2[i10]);
        }
        if (array2.length > objArr.length) {
            return array2;
        }
        System.arraycopy(array2, 0, objArr, 0, array2.length);
        if (objArr.length > array2.length) {
            objArr[array2.length] = null;
        }
        return objArr;
    }
}

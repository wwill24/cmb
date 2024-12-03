package org.apache.commons.collections.list;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.apache.commons.collections.BoundedCollection;
import org.apache.commons.collections.iterators.AbstractListIteratorDecorator;
import org.apache.commons.collections.iterators.UnmodifiableIterator;

public class FixedSizeList extends AbstractSerializableListDecorator implements BoundedCollection {
    private static final long serialVersionUID = -2218010673611160319L;

    static class FixedSizeListIterator extends AbstractListIteratorDecorator {
        protected FixedSizeListIterator(ListIterator listIterator) {
            super(listIterator);
        }

        public void add(Object obj) {
            throw new UnsupportedOperationException("List is fixed size");
        }

        public void remove() {
            throw new UnsupportedOperationException("List is fixed size");
        }
    }

    protected FixedSizeList(List list) {
        super(list);
    }

    public static List decorate(List list) {
        return new FixedSizeList(list);
    }

    public boolean add(Object obj) {
        throw new UnsupportedOperationException("List is fixed size");
    }

    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("List is fixed size");
    }

    public void clear() {
        throw new UnsupportedOperationException("List is fixed size");
    }

    public Object get(int i10) {
        return getList().get(i10);
    }

    public int indexOf(Object obj) {
        return getList().indexOf(obj);
    }

    public boolean isFull() {
        return true;
    }

    public Iterator iterator() {
        return UnmodifiableIterator.decorate(getCollection().iterator());
    }

    public int lastIndexOf(Object obj) {
        return getList().lastIndexOf(obj);
    }

    public ListIterator listIterator() {
        return new FixedSizeListIterator(getList().listIterator(0));
    }

    public int maxSize() {
        return size();
    }

    public Object remove(int i10) {
        throw new UnsupportedOperationException("List is fixed size");
    }

    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("List is fixed size");
    }

    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("List is fixed size");
    }

    public Object set(int i10, Object obj) {
        return getList().set(i10, obj);
    }

    public List subList(int i10, int i11) {
        return new FixedSizeList(getList().subList(i10, i11));
    }

    public void add(int i10, Object obj) {
        throw new UnsupportedOperationException("List is fixed size");
    }

    public boolean addAll(int i10, Collection collection) {
        throw new UnsupportedOperationException("List is fixed size");
    }

    public ListIterator listIterator(int i10) {
        return new FixedSizeListIterator(getList().listIterator(i10));
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("List is fixed size");
    }
}

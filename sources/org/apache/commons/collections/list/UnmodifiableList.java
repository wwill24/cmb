package org.apache.commons.collections.list;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.apache.commons.collections.Unmodifiable;
import org.apache.commons.collections.iterators.UnmodifiableIterator;
import org.apache.commons.collections.iterators.UnmodifiableListIterator;

public final class UnmodifiableList extends AbstractSerializableListDecorator implements Unmodifiable {
    private static final long serialVersionUID = 6595182819922443652L;

    private UnmodifiableList(List list) {
        super(list);
    }

    public static List decorate(List list) {
        if (list instanceof Unmodifiable) {
            return list;
        }
        return new UnmodifiableList(list);
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

    public ListIterator listIterator() {
        return UnmodifiableListIterator.decorate(getList().listIterator());
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

    public Object set(int i10, Object obj) {
        throw new UnsupportedOperationException();
    }

    public List subList(int i10, int i11) {
        return new UnmodifiableList(getList().subList(i10, i11));
    }

    public void add(int i10, Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(int i10, Collection collection) {
        throw new UnsupportedOperationException();
    }

    public ListIterator listIterator(int i10) {
        return UnmodifiableListIterator.decorate(getList().listIterator(i10));
    }

    public Object remove(int i10) {
        throw new UnsupportedOperationException();
    }
}

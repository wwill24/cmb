package org.apache.commons.collections.list;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import org.apache.commons.collections.collection.AbstractCollectionDecorator;

public abstract class AbstractListDecorator extends AbstractCollectionDecorator implements List {
    protected AbstractListDecorator() {
    }

    public void add(int i10, Object obj) {
        getList().add(i10, obj);
    }

    public boolean addAll(int i10, Collection collection) {
        return getList().addAll(i10, collection);
    }

    public Object get(int i10) {
        return getList().get(i10);
    }

    /* access modifiers changed from: protected */
    public List getList() {
        return (List) getCollection();
    }

    public int indexOf(Object obj) {
        return getList().indexOf(obj);
    }

    public int lastIndexOf(Object obj) {
        return getList().lastIndexOf(obj);
    }

    public ListIterator listIterator() {
        return getList().listIterator();
    }

    public Object remove(int i10) {
        return getList().remove(i10);
    }

    public Object set(int i10, Object obj) {
        return getList().set(i10, obj);
    }

    public List subList(int i10, int i11) {
        return getList().subList(i10, i11);
    }

    protected AbstractListDecorator(List list) {
        super(list);
    }

    public ListIterator listIterator(int i10) {
        return getList().listIterator(i10);
    }
}

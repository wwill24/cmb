package org.apache.commons.collections.list;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import org.apache.commons.collections.collection.SynchronizedCollection;

public class SynchronizedList extends SynchronizedCollection implements List {
    private static final long serialVersionUID = -1403835447328619437L;

    protected SynchronizedList(List list) {
        super(list);
    }

    public static List decorate(List list) {
        return new SynchronizedList(list);
    }

    public void add(int i10, Object obj) {
        synchronized (this.lock) {
            getList().add(i10, obj);
        }
    }

    public boolean addAll(int i10, Collection collection) {
        boolean addAll;
        synchronized (this.lock) {
            addAll = getList().addAll(i10, collection);
        }
        return addAll;
    }

    public Object get(int i10) {
        Object obj;
        synchronized (this.lock) {
            obj = getList().get(i10);
        }
        return obj;
    }

    /* access modifiers changed from: protected */
    public List getList() {
        return (List) this.collection;
    }

    public int indexOf(Object obj) {
        int indexOf;
        synchronized (this.lock) {
            indexOf = getList().indexOf(obj);
        }
        return indexOf;
    }

    public int lastIndexOf(Object obj) {
        int lastIndexOf;
        synchronized (this.lock) {
            lastIndexOf = getList().lastIndexOf(obj);
        }
        return lastIndexOf;
    }

    public ListIterator listIterator() {
        return getList().listIterator();
    }

    public Object remove(int i10) {
        Object remove;
        synchronized (this.lock) {
            remove = getList().remove(i10);
        }
        return remove;
    }

    public Object set(int i10, Object obj) {
        Object obj2;
        synchronized (this.lock) {
            obj2 = getList().set(i10, obj);
        }
        return obj2;
    }

    public List subList(int i10, int i11) {
        SynchronizedList synchronizedList;
        synchronized (this.lock) {
            synchronizedList = new SynchronizedList(getList().subList(i10, i11), this.lock);
        }
        return synchronizedList;
    }

    protected SynchronizedList(List list, Object obj) {
        super(list, obj);
    }

    public ListIterator listIterator(int i10) {
        return getList().listIterator(i10);
    }
}

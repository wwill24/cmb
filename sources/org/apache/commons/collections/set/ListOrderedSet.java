package org.apache.commons.collections.set;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.collections.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections.list.UnmodifiableList;

public class ListOrderedSet extends AbstractSerializableSetDecorator {
    private static final long serialVersionUID = -228664372470420141L;
    protected final List setOrder;

    static class OrderedSetIterator extends AbstractIteratorDecorator {
        protected Object last;
        protected final Collection set;

        public Object next() {
            Object next = this.iterator.next();
            this.last = next;
            return next;
        }

        public void remove() {
            this.set.remove(this.last);
            this.iterator.remove();
            this.last = null;
        }

        private OrderedSetIterator(Iterator it, Collection collection) {
            super(it);
            this.set = collection;
        }
    }

    public ListOrderedSet() {
        super(new HashSet());
        this.setOrder = new ArrayList();
    }

    public static ListOrderedSet decorate(Set set, List list) {
        if (set == null) {
            throw new IllegalArgumentException("Set must not be null");
        } else if (list == null) {
            throw new IllegalArgumentException("List must not be null");
        } else if (set.size() <= 0 && list.size() <= 0) {
            return new ListOrderedSet(set, list);
        } else {
            throw new IllegalArgumentException("Set and List must be empty");
        }
    }

    public boolean add(Object obj) {
        if (this.collection.contains(obj)) {
            return this.collection.add(obj);
        }
        boolean add = this.collection.add(obj);
        this.setOrder.add(obj);
        return add;
    }

    public boolean addAll(Collection collection) {
        boolean z10 = false;
        for (Object add : collection) {
            z10 |= add(add);
        }
        return z10;
    }

    public List asList() {
        return UnmodifiableList.decorate(this.setOrder);
    }

    public void clear() {
        this.collection.clear();
        this.setOrder.clear();
    }

    public Object get(int i10) {
        return this.setOrder.get(i10);
    }

    public int indexOf(Object obj) {
        return this.setOrder.indexOf(obj);
    }

    public Iterator iterator() {
        return new OrderedSetIterator(this.setOrder.iterator(), this.collection);
    }

    public boolean remove(Object obj) {
        boolean remove = this.collection.remove(obj);
        this.setOrder.remove(obj);
        return remove;
    }

    public boolean removeAll(Collection collection) {
        boolean z10 = false;
        for (Object remove : collection) {
            z10 |= remove(remove);
        }
        return z10;
    }

    public boolean retainAll(Collection collection) {
        boolean retainAll = this.collection.retainAll(collection);
        if (!retainAll) {
            return false;
        }
        if (this.collection.size() == 0) {
            this.setOrder.clear();
        } else {
            Iterator it = this.setOrder.iterator();
            while (it.hasNext()) {
                if (!this.collection.contains(it.next())) {
                    it.remove();
                }
            }
        }
        return retainAll;
    }

    public Object[] toArray() {
        return this.setOrder.toArray();
    }

    public String toString() {
        return this.setOrder.toString();
    }

    public Object[] toArray(Object[] objArr) {
        return this.setOrder.toArray(objArr);
    }

    protected ListOrderedSet(Set set) {
        super(set);
        this.setOrder = new ArrayList(set);
    }

    public Object remove(int i10) {
        Object remove = this.setOrder.remove(i10);
        remove(remove);
        return remove;
    }

    public boolean addAll(int i10, Collection collection) {
        boolean z10 = false;
        for (Object next : collection) {
            if (!contains(next)) {
                this.collection.add(next);
                this.setOrder.add(i10, next);
                i10++;
                z10 = true;
            }
        }
        return z10;
    }

    protected ListOrderedSet(Set set, List list) {
        super(set);
        if (list != null) {
            this.setOrder = list;
            return;
        }
        throw new IllegalArgumentException("List must not be null");
    }

    public void add(int i10, Object obj) {
        if (!contains(obj)) {
            this.collection.add(obj);
            this.setOrder.add(i10, obj);
        }
    }

    public static ListOrderedSet decorate(Set set) {
        return new ListOrderedSet(set);
    }

    public static ListOrderedSet decorate(List list) {
        if (list != null) {
            HashSet hashSet = new HashSet(list);
            list.retainAll(hashSet);
            return new ListOrderedSet(hashSet, list);
        }
        throw new IllegalArgumentException("List must not be null");
    }
}

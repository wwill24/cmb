package org.apache.commons.collections.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import org.apache.commons.collections.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections.iterators.AbstractListIteratorDecorator;
import org.apache.commons.collections.set.UnmodifiableSet;

public class SetUniqueList extends AbstractSerializableListDecorator {
    static /* synthetic */ Class class$java$util$HashSet = null;
    private static final long serialVersionUID = 7196982186153478694L;
    protected final Set set;

    static class SetListIterator extends AbstractIteratorDecorator {
        protected Object last = null;
        protected final Set set;

        protected SetListIterator(Iterator it, Set set2) {
            super(it);
            this.set = set2;
        }

        public Object next() {
            Object next = super.next();
            this.last = next;
            return next;
        }

        public void remove() {
            super.remove();
            this.set.remove(this.last);
            this.last = null;
        }
    }

    static class SetListListIterator extends AbstractListIteratorDecorator {
        protected Object last = null;
        protected final Set set;

        protected SetListListIterator(ListIterator listIterator, Set set2) {
            super(listIterator);
            this.set = set2;
        }

        public void add(Object obj) {
            if (!this.set.contains(obj)) {
                super.add(obj);
                this.set.add(obj);
            }
        }

        public Object next() {
            Object next = super.next();
            this.last = next;
            return next;
        }

        public Object previous() {
            Object previous = super.previous();
            this.last = previous;
            return previous;
        }

        public void remove() {
            super.remove();
            this.set.remove(this.last);
            this.last = null;
        }

        public void set(Object obj) {
            throw new UnsupportedOperationException("ListIterator does not support set");
        }
    }

    protected SetUniqueList(List list, Set set2) {
        super(list);
        if (set2 != null) {
            this.set = set2;
            return;
        }
        throw new IllegalArgumentException("Set must not be null");
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new NoClassDefFoundError(e10.getMessage());
        }
    }

    public static SetUniqueList decorate(List list) {
        if (list == null) {
            throw new IllegalArgumentException("List must not be null");
        } else if (list.isEmpty()) {
            return new SetUniqueList(list, new HashSet());
        } else {
            ArrayList arrayList = new ArrayList(list);
            list.clear();
            SetUniqueList setUniqueList = new SetUniqueList(list, new HashSet());
            setUniqueList.addAll(arrayList);
            return setUniqueList;
        }
    }

    public boolean add(Object obj) {
        int size = size();
        add(size(), obj);
        return size != size();
    }

    public boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }

    public Set asSet() {
        return UnmodifiableSet.decorate(this.set);
    }

    public void clear() {
        super.clear();
        this.set.clear();
    }

    public boolean contains(Object obj) {
        return this.set.contains(obj);
    }

    public boolean containsAll(Collection collection) {
        return this.set.containsAll(collection);
    }

    /* access modifiers changed from: protected */
    public Set createSetBasedOnList(Set set2, List list) {
        Set set3;
        Class<?> cls = set2.getClass();
        Class cls2 = class$java$util$HashSet;
        if (cls2 == null) {
            cls2 = class$("java.util.HashSet");
            class$java$util$HashSet = cls2;
        }
        if (cls.equals(cls2)) {
            set3 = new HashSet();
        } else {
            try {
                set3 = (Set) set2.getClass().newInstance();
            } catch (InstantiationException unused) {
                set3 = new HashSet();
            } catch (IllegalAccessException unused2) {
                set3 = new HashSet();
            }
        }
        set3.addAll(list);
        return set3;
    }

    public Iterator iterator() {
        return new SetListIterator(super.iterator(), this.set);
    }

    public ListIterator listIterator() {
        return new SetListListIterator(super.listIterator(), this.set);
    }

    public boolean remove(Object obj) {
        boolean remove = super.remove(obj);
        this.set.remove(obj);
        return remove;
    }

    public boolean removeAll(Collection collection) {
        boolean removeAll = super.removeAll(collection);
        this.set.removeAll(collection);
        return removeAll;
    }

    public boolean retainAll(Collection collection) {
        boolean retainAll = super.retainAll(collection);
        this.set.retainAll(collection);
        return retainAll;
    }

    public Object set(int i10, Object obj) {
        int indexOf = indexOf(obj);
        Object obj2 = super.set(i10, obj);
        if (!(indexOf == -1 || indexOf == i10)) {
            super.remove(indexOf);
        }
        this.set.remove(obj2);
        this.set.add(obj);
        return obj2;
    }

    public List subList(int i10, int i11) {
        List subList = super.subList(i10, i11);
        return new SetUniqueList(subList, createSetBasedOnList(this.set, subList));
    }

    public boolean addAll(int i10, Collection collection) {
        int size = size();
        for (Object add : collection) {
            int size2 = size();
            add(i10, add);
            if (size2 != size()) {
                i10++;
            }
        }
        return size != size();
    }

    public ListIterator listIterator(int i10) {
        return new SetListListIterator(super.listIterator(i10), this.set);
    }

    public Object remove(int i10) {
        Object remove = super.remove(i10);
        this.set.remove(remove);
        return remove;
    }

    public void add(int i10, Object obj) {
        if (!this.set.contains(obj)) {
            super.add(i10, obj);
            this.set.add(obj);
        }
    }
}

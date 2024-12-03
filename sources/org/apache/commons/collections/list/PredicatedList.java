package org.apache.commons.collections.list;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.collection.PredicatedCollection;
import org.apache.commons.collections.iterators.AbstractListIteratorDecorator;

public class PredicatedList extends PredicatedCollection implements List {
    private static final long serialVersionUID = -5722039223898659102L;

    protected class PredicatedListIterator extends AbstractListIteratorDecorator {
        private final /* synthetic */ PredicatedList this$0;

        protected PredicatedListIterator(PredicatedList predicatedList, ListIterator listIterator) {
            super(listIterator);
            this.this$0 = predicatedList;
        }

        public void add(Object obj) {
            this.this$0.validate(obj);
            this.iterator.add(obj);
        }

        public void set(Object obj) {
            this.this$0.validate(obj);
            this.iterator.set(obj);
        }
    }

    protected PredicatedList(List list, Predicate predicate) {
        super(list, predicate);
    }

    public static List decorate(List list, Predicate predicate) {
        return new PredicatedList(list, predicate);
    }

    public void add(int i10, Object obj) {
        validate(obj);
        getList().add(i10, obj);
    }

    public boolean addAll(int i10, Collection collection) {
        for (Object validate : collection) {
            validate(validate);
        }
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
        return listIterator(0);
    }

    public Object remove(int i10) {
        return getList().remove(i10);
    }

    public Object set(int i10, Object obj) {
        validate(obj);
        return getList().set(i10, obj);
    }

    public List subList(int i10, int i11) {
        return new PredicatedList(getList().subList(i10, i11), this.predicate);
    }

    public ListIterator listIterator(int i10) {
        return new PredicatedListIterator(this, getList().listIterator(i10));
    }
}

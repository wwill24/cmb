package org.apache.commons.collections.list;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.collection.TransformedCollection;
import org.apache.commons.collections.iterators.AbstractListIteratorDecorator;

public class TransformedList extends TransformedCollection implements List {
    private static final long serialVersionUID = 1077193035000013141L;

    protected class TransformedListIterator extends AbstractListIteratorDecorator {
        private final /* synthetic */ TransformedList this$0;

        protected TransformedListIterator(TransformedList transformedList, ListIterator listIterator) {
            super(listIterator);
            this.this$0 = transformedList;
        }

        public void add(Object obj) {
            this.iterator.add(this.this$0.transform(obj));
        }

        public void set(Object obj) {
            this.iterator.set(this.this$0.transform(obj));
        }
    }

    protected TransformedList(List list, Transformer transformer) {
        super(list, transformer);
    }

    public static List decorate(List list, Transformer transformer) {
        return new TransformedList(list, transformer);
    }

    public void add(int i10, Object obj) {
        getList().add(i10, transform(obj));
    }

    public boolean addAll(int i10, Collection collection) {
        return getList().addAll(i10, transform(collection));
    }

    public Object get(int i10) {
        return getList().get(i10);
    }

    /* access modifiers changed from: protected */
    public List getList() {
        return (List) this.collection;
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
        return getList().set(i10, transform(obj));
    }

    public List subList(int i10, int i11) {
        return new TransformedList(getList().subList(i10, i11), this.transformer);
    }

    public ListIterator listIterator(int i10) {
        return new TransformedListIterator(this, getList().listIterator(i10));
    }
}

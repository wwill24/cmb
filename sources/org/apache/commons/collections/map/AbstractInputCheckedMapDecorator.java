package org.apache.commons.collections.map;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections.keyvalue.AbstractMapEntryDecorator;
import org.apache.commons.collections.set.AbstractSetDecorator;

abstract class AbstractInputCheckedMapDecorator extends AbstractMapDecorator {

    static class EntrySetIterator extends AbstractIteratorDecorator {
        private final AbstractInputCheckedMapDecorator parent;

        protected EntrySetIterator(Iterator it, AbstractInputCheckedMapDecorator abstractInputCheckedMapDecorator) {
            super(it);
            this.parent = abstractInputCheckedMapDecorator;
        }

        public Object next() {
            return new MapEntry((Map.Entry) this.iterator.next(), this.parent);
        }
    }

    static class MapEntry extends AbstractMapEntryDecorator {
        private final AbstractInputCheckedMapDecorator parent;

        protected MapEntry(Map.Entry entry, AbstractInputCheckedMapDecorator abstractInputCheckedMapDecorator) {
            super(entry);
            this.parent = abstractInputCheckedMapDecorator;
        }

        public Object setValue(Object obj) {
            return this.entry.setValue(this.parent.checkSetValue(obj));
        }
    }

    protected AbstractInputCheckedMapDecorator() {
    }

    /* access modifiers changed from: protected */
    public abstract Object checkSetValue(Object obj);

    public Set entrySet() {
        if (isSetValueChecking()) {
            return new EntrySet(this.map.entrySet(), this);
        }
        return this.map.entrySet();
    }

    /* access modifiers changed from: protected */
    public boolean isSetValueChecking() {
        return true;
    }

    protected AbstractInputCheckedMapDecorator(Map map) {
        super(map);
    }

    static class EntrySet extends AbstractSetDecorator {
        private final AbstractInputCheckedMapDecorator parent;

        protected EntrySet(Set set, AbstractInputCheckedMapDecorator abstractInputCheckedMapDecorator) {
            super(set);
            this.parent = abstractInputCheckedMapDecorator;
        }

        public Iterator iterator() {
            return new EntrySetIterator(this.collection.iterator(), this.parent);
        }

        public Object[] toArray() {
            Object[] array2 = this.collection.toArray();
            for (int i10 = 0; i10 < array2.length; i10++) {
                array2[i10] = new MapEntry((Map.Entry) array2[i10], this.parent);
            }
            return array2;
        }

        public Object[] toArray(Object[] objArr) {
            Object[] array2 = this.collection.toArray(objArr.length > 0 ? (Object[]) Array.newInstance(objArr.getClass().getComponentType(), 0) : objArr);
            for (int i10 = 0; i10 < array2.length; i10++) {
                array2[i10] = new MapEntry((Map.Entry) array2[i10], this.parent);
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
}

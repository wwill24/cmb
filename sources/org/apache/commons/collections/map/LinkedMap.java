package org.apache.commons.collections.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import org.apache.commons.collections.iterators.UnmodifiableIterator;
import org.apache.commons.collections.iterators.UnmodifiableListIterator;
import org.apache.commons.collections.list.UnmodifiableList;
import org.apache.commons.collections.map.AbstractLinkedMap;

public class LinkedMap extends AbstractLinkedMap implements Serializable, Cloneable {
    private static final long serialVersionUID = 9077234323521161066L;

    static class LinkedMapList extends AbstractList {
        final LinkedMap parent;

        LinkedMapList(LinkedMap linkedMap) {
            this.parent = linkedMap;
        }

        public void clear() {
            throw new UnsupportedOperationException();
        }

        public boolean contains(Object obj) {
            return this.parent.containsKey(obj);
        }

        public boolean containsAll(Collection collection) {
            return this.parent.keySet().containsAll(collection);
        }

        public Object get(int i10) {
            return this.parent.get(i10);
        }

        public int indexOf(Object obj) {
            return this.parent.indexOf(obj);
        }

        public Iterator iterator() {
            return UnmodifiableIterator.decorate(this.parent.keySet().iterator());
        }

        public int lastIndexOf(Object obj) {
            return this.parent.indexOf(obj);
        }

        public ListIterator listIterator() {
            return UnmodifiableListIterator.decorate(super.listIterator());
        }

        public Object remove(int i10) {
            throw new UnsupportedOperationException();
        }

        public boolean removeAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        public boolean retainAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            return this.parent.size();
        }

        public List subList(int i10, int i11) {
            return UnmodifiableList.decorate(super.subList(i10, i11));
        }

        public Object[] toArray() {
            return this.parent.keySet().toArray();
        }

        public ListIterator listIterator(int i10) {
            return UnmodifiableListIterator.decorate(super.listIterator(i10));
        }

        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public Object[] toArray(Object[] objArr) {
            return this.parent.keySet().toArray(objArr);
        }
    }

    public LinkedMap() {
        super(16, 0.75f, 12);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        doReadObject(objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        doWriteObject(objectOutputStream);
    }

    public List asList() {
        return new LinkedMapList(this);
    }

    public Object clone() {
        return super.clone();
    }

    public Object get(int i10) {
        return getEntry(i10).getKey();
    }

    public Object getValue(int i10) {
        return getEntry(i10).getValue();
    }

    public int indexOf(Object obj) {
        Object convertKey = convertKey(obj);
        AbstractLinkedMap.LinkEntry linkEntry = this.header.after;
        int i10 = 0;
        while (linkEntry != this.header) {
            if (isEqualKey(convertKey, linkEntry.key)) {
                return i10;
            }
            linkEntry = linkEntry.after;
            i10++;
        }
        return -1;
    }

    public Object remove(int i10) {
        return remove(get(i10));
    }

    public LinkedMap(int i10) {
        super(i10);
    }

    public LinkedMap(int i10, float f10) {
        super(i10, f10);
    }

    public LinkedMap(Map map) {
        super(map);
    }
}

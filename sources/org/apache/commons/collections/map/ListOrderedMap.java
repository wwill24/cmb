package org.apache.commons.collections.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.OrderedMap;
import org.apache.commons.collections.OrderedMapIterator;
import org.apache.commons.collections.ResettableIterator;
import org.apache.commons.collections.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections.keyvalue.AbstractMapEntry;
import org.apache.commons.collections.list.UnmodifiableList;

public class ListOrderedMap extends AbstractMapDecorator implements OrderedMap, Serializable {
    private static final long serialVersionUID = 2728177751851003750L;
    protected final List insertOrder;

    static class EntrySetView extends AbstractSet {
        private Set entrySet;
        private final List insertOrder;
        private final ListOrderedMap parent;

        public EntrySetView(ListOrderedMap listOrderedMap, List list) {
            this.parent = listOrderedMap;
            this.insertOrder = list;
        }

        private Set getEntrySet() {
            if (this.entrySet == null) {
                this.entrySet = this.parent.getMap().entrySet();
            }
            return this.entrySet;
        }

        public void clear() {
            this.parent.clear();
        }

        public boolean contains(Object obj) {
            return getEntrySet().contains(obj);
        }

        public boolean containsAll(Collection collection) {
            return getEntrySet().containsAll(collection);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            return getEntrySet().equals(obj);
        }

        public int hashCode() {
            return getEntrySet().hashCode();
        }

        public boolean isEmpty() {
            return this.parent.isEmpty();
        }

        public Iterator iterator() {
            return new ListOrderedIterator(this.parent, this.insertOrder);
        }

        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry) || !getEntrySet().contains(obj)) {
                return false;
            }
            this.parent.remove(((Map.Entry) obj).getKey());
            return true;
        }

        public int size() {
            return this.parent.size();
        }

        public String toString() {
            return getEntrySet().toString();
        }
    }

    static class KeySetView extends AbstractSet {
        private final ListOrderedMap parent;

        KeySetView(ListOrderedMap listOrderedMap) {
            this.parent = listOrderedMap;
        }

        public void clear() {
            this.parent.clear();
        }

        public boolean contains(Object obj) {
            return this.parent.containsKey(obj);
        }

        public Iterator iterator() {
            return new AbstractIteratorDecorator(this, this.parent.entrySet().iterator()) {
                private final /* synthetic */ KeySetView this$0;

                {
                    this.this$0 = r1;
                }

                public Object next() {
                    return ((Map.Entry) super.next()).getKey();
                }
            };
        }

        public int size() {
            return this.parent.size();
        }
    }

    static class ListOrderedIterator extends AbstractIteratorDecorator {
        private Object last = null;
        private final ListOrderedMap parent;

        ListOrderedIterator(ListOrderedMap listOrderedMap, List list) {
            super(list.iterator());
            this.parent = listOrderedMap;
        }

        public Object next() {
            Object next = super.next();
            this.last = next;
            return new ListOrderedMapEntry(this.parent, next);
        }

        public void remove() {
            super.remove();
            this.parent.getMap().remove(this.last);
        }
    }

    static class ListOrderedMapEntry extends AbstractMapEntry {
        private final ListOrderedMap parent;

        ListOrderedMapEntry(ListOrderedMap listOrderedMap, Object obj) {
            super(obj, (Object) null);
            this.parent = listOrderedMap;
        }

        public Object getValue() {
            return this.parent.get(this.key);
        }

        public Object setValue(Object obj) {
            return this.parent.getMap().put(this.key, obj);
        }
    }

    static class ListOrderedMapIterator implements OrderedMapIterator, ResettableIterator {
        private ListIterator iterator;
        private Object last = null;
        private final ListOrderedMap parent;
        private boolean readable = false;

        ListOrderedMapIterator(ListOrderedMap listOrderedMap) {
            this.parent = listOrderedMap;
            this.iterator = listOrderedMap.insertOrder.listIterator();
        }

        public Object getKey() {
            if (this.readable) {
                return this.last;
            }
            throw new IllegalStateException("getKey() can only be called after next() and before remove()");
        }

        public Object getValue() {
            if (this.readable) {
                return this.parent.get(this.last);
            }
            throw new IllegalStateException("getValue() can only be called after next() and before remove()");
        }

        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        public boolean hasPrevious() {
            return this.iterator.hasPrevious();
        }

        public Object next() {
            Object next = this.iterator.next();
            this.last = next;
            this.readable = true;
            return next;
        }

        public Object previous() {
            Object previous = this.iterator.previous();
            this.last = previous;
            this.readable = true;
            return previous;
        }

        public void remove() {
            if (this.readable) {
                this.iterator.remove();
                this.parent.map.remove(this.last);
                this.readable = false;
                return;
            }
            throw new IllegalStateException("remove() can only be called once after next()");
        }

        public void reset() {
            this.iterator = this.parent.insertOrder.listIterator();
            this.last = null;
            this.readable = false;
        }

        public Object setValue(Object obj) {
            if (this.readable) {
                return this.parent.map.put(this.last, obj);
            }
            throw new IllegalStateException("setValue() can only be called after next() and before remove()");
        }

        public String toString() {
            if (!this.readable) {
                return "Iterator[]";
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Iterator[");
            stringBuffer.append(getKey());
            stringBuffer.append("=");
            stringBuffer.append(getValue());
            stringBuffer.append("]");
            return stringBuffer.toString();
        }
    }

    static class ValuesView extends AbstractList {
        private final ListOrderedMap parent;

        ValuesView(ListOrderedMap listOrderedMap) {
            this.parent = listOrderedMap;
        }

        public void clear() {
            this.parent.clear();
        }

        public boolean contains(Object obj) {
            return this.parent.containsValue(obj);
        }

        public Object get(int i10) {
            return this.parent.getValue(i10);
        }

        public Iterator iterator() {
            return new AbstractIteratorDecorator(this, this.parent.entrySet().iterator()) {
                private final /* synthetic */ ValuesView this$0;

                {
                    this.this$0 = r1;
                }

                public Object next() {
                    return ((Map.Entry) this.iterator.next()).getValue();
                }
            };
        }

        public Object remove(int i10) {
            return this.parent.remove(i10);
        }

        public Object set(int i10, Object obj) {
            return this.parent.setValue(i10, obj);
        }

        public int size() {
            return this.parent.size();
        }
    }

    public ListOrderedMap() {
        this(new HashMap());
    }

    public static OrderedMap decorate(Map map) {
        return new ListOrderedMap(map);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.map = (Map) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.map);
    }

    public List asList() {
        return keyList();
    }

    public void clear() {
        getMap().clear();
        this.insertOrder.clear();
    }

    public Set entrySet() {
        return new EntrySetView(this, this.insertOrder);
    }

    public Object firstKey() {
        if (size() != 0) {
            return this.insertOrder.get(0);
        }
        throw new NoSuchElementException("Map is empty");
    }

    public Object get(int i10) {
        return this.insertOrder.get(i10);
    }

    public Object getValue(int i10) {
        return get(this.insertOrder.get(i10));
    }

    public int indexOf(Object obj) {
        return this.insertOrder.indexOf(obj);
    }

    public List keyList() {
        return UnmodifiableList.decorate(this.insertOrder);
    }

    public Set keySet() {
        return new KeySetView(this);
    }

    public Object lastKey() {
        if (size() != 0) {
            return this.insertOrder.get(size() - 1);
        }
        throw new NoSuchElementException("Map is empty");
    }

    public MapIterator mapIterator() {
        return orderedMapIterator();
    }

    public Object nextKey(Object obj) {
        int indexOf = this.insertOrder.indexOf(obj);
        if (indexOf < 0 || indexOf >= size() - 1) {
            return null;
        }
        return this.insertOrder.get(indexOf + 1);
    }

    public OrderedMapIterator orderedMapIterator() {
        return new ListOrderedMapIterator(this);
    }

    public Object previousKey(Object obj) {
        int indexOf = this.insertOrder.indexOf(obj);
        if (indexOf > 0) {
            return this.insertOrder.get(indexOf - 1);
        }
        return null;
    }

    public Object put(Object obj, Object obj2) {
        if (getMap().containsKey(obj)) {
            return getMap().put(obj, obj2);
        }
        Object put = getMap().put(obj, obj2);
        this.insertOrder.add(obj);
        return put;
    }

    public void putAll(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public Object remove(Object obj) {
        Object remove = getMap().remove(obj);
        this.insertOrder.remove(obj);
        return remove;
    }

    public Object setValue(int i10, Object obj) {
        return put(this.insertOrder.get(i10), obj);
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('{');
        boolean z10 = true;
        for (Map.Entry entry : entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (z10) {
                z10 = false;
            } else {
                stringBuffer.append(", ");
            }
            if (key == this) {
                key = "(this Map)";
            }
            stringBuffer.append(key);
            stringBuffer.append(SignatureVisitor.INSTANCEOF);
            if (value == this) {
                value = "(this Map)";
            }
            stringBuffer.append(value);
        }
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public List valueList() {
        return new ValuesView(this);
    }

    public Collection values() {
        return new ValuesView(this);
    }

    protected ListOrderedMap(Map map) {
        super(map);
        ArrayList arrayList = new ArrayList();
        this.insertOrder = arrayList;
        arrayList.addAll(getMap().keySet());
    }

    public Object remove(int i10) {
        return remove(get(i10));
    }

    public Object put(int i10, Object obj, Object obj2) {
        Map map = getMap();
        if (map.containsKey(obj)) {
            Object remove = map.remove(obj);
            int indexOf = this.insertOrder.indexOf(obj);
            this.insertOrder.remove(indexOf);
            if (indexOf < i10) {
                i10--;
            }
            this.insertOrder.add(i10, obj);
            map.put(obj, obj2);
            return remove;
        }
        this.insertOrder.add(i10, obj);
        map.put(obj, obj2);
        return null;
    }
}

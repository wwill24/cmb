package org.apache.commons.collections.bidimap;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.commons.collections.BidiMap;
import org.apache.commons.collections.OrderedBidiMap;
import org.apache.commons.collections.OrderedMap;
import org.apache.commons.collections.OrderedMapIterator;
import org.apache.commons.collections.ResettableIterator;
import org.apache.commons.collections.SortedBidiMap;
import org.apache.commons.collections.map.AbstractSortedMapDecorator;

public class DualTreeBidiMap extends AbstractDualBidiMap implements SortedBidiMap, Serializable {
    private static final long serialVersionUID = 721969328361809L;
    protected final Comparator comparator;

    protected static class BidiOrderedMapIterator implements OrderedMapIterator, ResettableIterator {
        protected ListIterator iterator;
        private Map.Entry last = null;
        protected final AbstractDualBidiMap parent;

        protected BidiOrderedMapIterator(AbstractDualBidiMap abstractDualBidiMap) {
            this.parent = abstractDualBidiMap;
            this.iterator = new ArrayList(abstractDualBidiMap.entrySet()).listIterator();
        }

        public Object getKey() {
            Map.Entry entry = this.last;
            if (entry != null) {
                return entry.getKey();
            }
            throw new IllegalStateException("Iterator getKey() can only be called after next() and before remove()");
        }

        public Object getValue() {
            Map.Entry entry = this.last;
            if (entry != null) {
                return entry.getValue();
            }
            throw new IllegalStateException("Iterator getValue() can only be called after next() and before remove()");
        }

        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        public boolean hasPrevious() {
            return this.iterator.hasPrevious();
        }

        public Object next() {
            Map.Entry entry = (Map.Entry) this.iterator.next();
            this.last = entry;
            return entry.getKey();
        }

        public Object previous() {
            Map.Entry entry = (Map.Entry) this.iterator.previous();
            this.last = entry;
            return entry.getKey();
        }

        public void remove() {
            this.iterator.remove();
            this.parent.remove(this.last.getKey());
            this.last = null;
        }

        public void reset() {
            this.iterator = new ArrayList(this.parent.entrySet()).listIterator();
            this.last = null;
        }

        public Object setValue(Object obj) {
            if (this.last == null) {
                throw new IllegalStateException("Iterator setValue() can only be called after next() and before remove()");
            } else if (!this.parent.maps[1].containsKey(obj) || this.parent.maps[1].get(obj) == this.last.getKey()) {
                return this.parent.put(this.last.getKey(), obj);
            } else {
                throw new IllegalArgumentException("Cannot use setValue() when the object being set is already in the map");
            }
        }

        public String toString() {
            if (this.last == null) {
                return "MapIterator[]";
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("MapIterator[");
            stringBuffer.append(getKey());
            stringBuffer.append("=");
            stringBuffer.append(getValue());
            stringBuffer.append("]");
            return stringBuffer.toString();
        }
    }

    protected static class ViewMap extends AbstractSortedMapDecorator {
        final DualTreeBidiMap bidi = ((DualTreeBidiMap) this.map);

        protected ViewMap(DualTreeBidiMap dualTreeBidiMap, SortedMap sortedMap) {
            super((SortedMap) dualTreeBidiMap.createBidiMap(sortedMap, dualTreeBidiMap.maps[1], dualTreeBidiMap.inverseBidiMap));
        }

        public void clear() {
            Iterator it = keySet().iterator();
            while (it.hasNext()) {
                it.next();
                it.remove();
            }
        }

        public boolean containsValue(Object obj) {
            return this.bidi.maps[0].containsValue(obj);
        }

        public SortedMap headMap(Object obj) {
            return new ViewMap(this.bidi, super.headMap(obj));
        }

        public SortedMap subMap(Object obj, Object obj2) {
            return new ViewMap(this.bidi, super.subMap(obj, obj2));
        }

        public SortedMap tailMap(Object obj) {
            return new ViewMap(this.bidi, super.tailMap(obj));
        }
    }

    public DualTreeBidiMap() {
        super(new TreeMap(), new TreeMap());
        this.comparator = null;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.maps[0] = new TreeMap(this.comparator);
        this.maps[1] = new TreeMap(this.comparator);
        putAll((Map) objectInputStream.readObject());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.maps[0]);
    }

    public Comparator comparator() {
        return ((SortedMap) this.maps[0]).comparator();
    }

    /* access modifiers changed from: protected */
    public BidiMap createBidiMap(Map map, Map map2, BidiMap bidiMap) {
        return new DualTreeBidiMap(map, map2, bidiMap);
    }

    public Object firstKey() {
        return ((SortedMap) this.maps[0]).firstKey();
    }

    public SortedMap headMap(Object obj) {
        return new ViewMap(this, ((SortedMap) this.maps[0]).headMap(obj));
    }

    public OrderedBidiMap inverseOrderedBidiMap() {
        return (OrderedBidiMap) inverseBidiMap();
    }

    public SortedBidiMap inverseSortedBidiMap() {
        return (SortedBidiMap) inverseBidiMap();
    }

    public Object lastKey() {
        return ((SortedMap) this.maps[0]).lastKey();
    }

    public Object nextKey(Object obj) {
        if (isEmpty()) {
            return null;
        }
        Map map = this.maps[0];
        if (map instanceof OrderedMap) {
            return ((OrderedMap) map).nextKey(obj);
        }
        Iterator it = ((SortedMap) map).tailMap(obj).keySet().iterator();
        it.next();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public OrderedMapIterator orderedMapIterator() {
        return new BidiOrderedMapIterator(this);
    }

    public Object previousKey(Object obj) {
        if (isEmpty()) {
            return null;
        }
        Map map = this.maps[0];
        if (map instanceof OrderedMap) {
            return ((OrderedMap) map).previousKey(obj);
        }
        SortedMap headMap = ((SortedMap) map).headMap(obj);
        if (headMap.isEmpty()) {
            return null;
        }
        return headMap.lastKey();
    }

    public SortedMap subMap(Object obj, Object obj2) {
        return new ViewMap(this, ((SortedMap) this.maps[0]).subMap(obj, obj2));
    }

    public SortedMap tailMap(Object obj) {
        return new ViewMap(this, ((SortedMap) this.maps[0]).tailMap(obj));
    }

    public DualTreeBidiMap(Map map) {
        super(new TreeMap(), new TreeMap());
        putAll(map);
        this.comparator = null;
    }

    public DualTreeBidiMap(Comparator comparator2) {
        super(new TreeMap(comparator2), new TreeMap(comparator2));
        this.comparator = comparator2;
    }

    protected DualTreeBidiMap(Map map, Map map2, BidiMap bidiMap) {
        super(map, map2, bidiMap);
        this.comparator = ((SortedMap) map).comparator();
    }
}

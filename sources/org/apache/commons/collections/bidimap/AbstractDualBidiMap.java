package org.apache.commons.collections.bidimap;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections.BidiMap;
import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.ResettableIterator;
import org.apache.commons.collections.collection.AbstractCollectionDecorator;
import org.apache.commons.collections.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections.keyvalue.AbstractMapEntryDecorator;

public abstract class AbstractDualBidiMap implements BidiMap {
    protected transient Set entrySet;
    protected transient BidiMap inverseBidiMap;
    protected transient Set keySet;
    protected final transient Map[] maps;
    protected transient Collection values;

    protected static class BidiMapIterator implements MapIterator, ResettableIterator {
        protected boolean canRemove = false;
        protected Iterator iterator;
        protected Map.Entry last = null;
        protected final AbstractDualBidiMap parent;

        protected BidiMapIterator(AbstractDualBidiMap abstractDualBidiMap) {
            this.parent = abstractDualBidiMap;
            this.iterator = abstractDualBidiMap.maps[0].entrySet().iterator();
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

        public Object next() {
            Map.Entry entry = (Map.Entry) this.iterator.next();
            this.last = entry;
            this.canRemove = true;
            return entry.getKey();
        }

        public void remove() {
            if (this.canRemove) {
                Object value = this.last.getValue();
                this.iterator.remove();
                this.parent.maps[1].remove(value);
                this.last = null;
                this.canRemove = false;
                return;
            }
            throw new IllegalStateException("Iterator remove() can only be called once after next()");
        }

        public void reset() {
            this.iterator = this.parent.maps[0].entrySet().iterator();
            this.last = null;
            this.canRemove = false;
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

    protected static class EntrySet extends View implements Set {
        protected EntrySet(AbstractDualBidiMap abstractDualBidiMap) {
            super(abstractDualBidiMap.maps[0].entrySet(), abstractDualBidiMap);
        }

        public Iterator iterator() {
            return this.parent.createEntrySetIterator(super.iterator());
        }

        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            if (this.parent.containsKey(key)) {
                Object obj2 = this.parent.maps[0].get(key);
                Object value = entry.getValue();
                if (obj2 != null ? obj2.equals(value) : value == null) {
                    this.parent.maps[0].remove(key);
                    this.parent.maps[1].remove(obj2);
                    return true;
                }
            }
            return false;
        }
    }

    protected static class EntrySetIterator extends AbstractIteratorDecorator {
        protected boolean canRemove = false;
        protected Map.Entry last = null;
        protected final AbstractDualBidiMap parent;

        protected EntrySetIterator(Iterator it, AbstractDualBidiMap abstractDualBidiMap) {
            super(it);
            this.parent = abstractDualBidiMap;
        }

        public Object next() {
            MapEntry mapEntry = new MapEntry((Map.Entry) super.next(), this.parent);
            this.last = mapEntry;
            this.canRemove = true;
            return mapEntry;
        }

        public void remove() {
            if (this.canRemove) {
                Object value = this.last.getValue();
                super.remove();
                this.parent.maps[1].remove(value);
                this.last = null;
                this.canRemove = false;
                return;
            }
            throw new IllegalStateException("Iterator remove() can only be called once after next()");
        }
    }

    protected static class KeySet extends View implements Set {
        protected KeySet(AbstractDualBidiMap abstractDualBidiMap) {
            super(abstractDualBidiMap.maps[0].keySet(), abstractDualBidiMap);
        }

        public boolean contains(Object obj) {
            return this.parent.maps[0].containsKey(obj);
        }

        public Iterator iterator() {
            return this.parent.createKeySetIterator(super.iterator());
        }

        public boolean remove(Object obj) {
            if (!this.parent.maps[0].containsKey(obj)) {
                return false;
            }
            this.parent.maps[1].remove(this.parent.maps[0].remove(obj));
            return true;
        }
    }

    protected static class KeySetIterator extends AbstractIteratorDecorator {
        protected boolean canRemove = false;
        protected Object lastKey = null;
        protected final AbstractDualBidiMap parent;

        protected KeySetIterator(Iterator it, AbstractDualBidiMap abstractDualBidiMap) {
            super(it);
            this.parent = abstractDualBidiMap;
        }

        public Object next() {
            Object next = super.next();
            this.lastKey = next;
            this.canRemove = true;
            return next;
        }

        public void remove() {
            if (this.canRemove) {
                Object obj = this.parent.maps[0].get(this.lastKey);
                super.remove();
                this.parent.maps[1].remove(obj);
                this.lastKey = null;
                this.canRemove = false;
                return;
            }
            throw new IllegalStateException("Iterator remove() can only be called once after next()");
        }
    }

    protected static class MapEntry extends AbstractMapEntryDecorator {
        protected final AbstractDualBidiMap parent;

        protected MapEntry(Map.Entry entry, AbstractDualBidiMap abstractDualBidiMap) {
            super(entry);
            this.parent = abstractDualBidiMap;
        }

        public Object setValue(Object obj) {
            Object key = getKey();
            if (!this.parent.maps[1].containsKey(obj) || this.parent.maps[1].get(obj) == key) {
                this.parent.put(key, obj);
                return super.setValue(obj);
            }
            throw new IllegalArgumentException("Cannot use setValue() when the object being set is already in the map");
        }
    }

    protected static class Values extends View implements Set {
        protected Values(AbstractDualBidiMap abstractDualBidiMap) {
            super(abstractDualBidiMap.maps[0].values(), abstractDualBidiMap);
        }

        public boolean contains(Object obj) {
            return this.parent.maps[1].containsKey(obj);
        }

        public Iterator iterator() {
            return this.parent.createValuesIterator(super.iterator());
        }

        public boolean remove(Object obj) {
            if (!this.parent.maps[1].containsKey(obj)) {
                return false;
            }
            this.parent.maps[0].remove(this.parent.maps[1].remove(obj));
            return true;
        }
    }

    protected static class ValuesIterator extends AbstractIteratorDecorator {
        protected boolean canRemove = false;
        protected Object lastValue = null;
        protected final AbstractDualBidiMap parent;

        protected ValuesIterator(Iterator it, AbstractDualBidiMap abstractDualBidiMap) {
            super(it);
            this.parent = abstractDualBidiMap;
        }

        public Object next() {
            Object next = super.next();
            this.lastValue = next;
            this.canRemove = true;
            return next;
        }

        public void remove() {
            if (this.canRemove) {
                super.remove();
                this.parent.maps[1].remove(this.lastValue);
                this.lastValue = null;
                this.canRemove = false;
                return;
            }
            throw new IllegalStateException("Iterator remove() can only be called once after next()");
        }
    }

    protected static abstract class View extends AbstractCollectionDecorator {
        protected final AbstractDualBidiMap parent;

        protected View(Collection collection, AbstractDualBidiMap abstractDualBidiMap) {
            super(collection);
            this.parent = abstractDualBidiMap;
        }

        public void clear() {
            this.parent.clear();
        }

        public boolean removeAll(Collection collection) {
            boolean z10 = false;
            if (!this.parent.isEmpty() && !collection.isEmpty()) {
                Iterator it = iterator();
                while (it.hasNext()) {
                    if (collection.contains(it.next())) {
                        it.remove();
                        z10 = true;
                    }
                }
            }
            return z10;
        }

        public boolean retainAll(Collection collection) {
            boolean z10 = false;
            if (this.parent.isEmpty()) {
                return false;
            }
            if (collection.isEmpty()) {
                this.parent.clear();
                return true;
            }
            Iterator it = iterator();
            while (it.hasNext()) {
                if (!collection.contains(it.next())) {
                    it.remove();
                    z10 = true;
                }
            }
            return z10;
        }
    }

    protected AbstractDualBidiMap() {
        Map[] mapArr = new Map[2];
        this.maps = mapArr;
        this.inverseBidiMap = null;
        this.keySet = null;
        this.values = null;
        this.entrySet = null;
        mapArr[0] = createMap();
        mapArr[1] = createMap();
    }

    public void clear() {
        this.maps[0].clear();
        this.maps[1].clear();
    }

    public boolean containsKey(Object obj) {
        return this.maps[0].containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return this.maps[1].containsKey(obj);
    }

    /* access modifiers changed from: protected */
    public abstract BidiMap createBidiMap(Map map, Map map2, BidiMap bidiMap);

    /* access modifiers changed from: protected */
    public Iterator createEntrySetIterator(Iterator it) {
        return new EntrySetIterator(it, this);
    }

    /* access modifiers changed from: protected */
    public Iterator createKeySetIterator(Iterator it) {
        return new KeySetIterator(it, this);
    }

    /* access modifiers changed from: protected */
    public Map createMap() {
        return null;
    }

    /* access modifiers changed from: protected */
    public Iterator createValuesIterator(Iterator it) {
        return new ValuesIterator(it, this);
    }

    public Set entrySet() {
        if (this.entrySet == null) {
            this.entrySet = new EntrySet(this);
        }
        return this.entrySet;
    }

    public boolean equals(Object obj) {
        return this.maps[0].equals(obj);
    }

    public Object get(Object obj) {
        return this.maps[0].get(obj);
    }

    public Object getKey(Object obj) {
        return this.maps[1].get(obj);
    }

    public int hashCode() {
        return this.maps[0].hashCode();
    }

    public BidiMap inverseBidiMap() {
        if (this.inverseBidiMap == null) {
            Map[] mapArr = this.maps;
            this.inverseBidiMap = createBidiMap(mapArr[1], mapArr[0], this);
        }
        return this.inverseBidiMap;
    }

    public boolean isEmpty() {
        return this.maps[0].isEmpty();
    }

    public Set keySet() {
        if (this.keySet == null) {
            this.keySet = new KeySet(this);
        }
        return this.keySet;
    }

    public MapIterator mapIterator() {
        return new BidiMapIterator(this);
    }

    public Object put(Object obj, Object obj2) {
        if (this.maps[0].containsKey(obj)) {
            Map[] mapArr = this.maps;
            mapArr[1].remove(mapArr[0].get(obj));
        }
        if (this.maps[1].containsKey(obj2)) {
            Map[] mapArr2 = this.maps;
            mapArr2[0].remove(mapArr2[1].get(obj2));
        }
        Object put = this.maps[0].put(obj, obj2);
        this.maps[1].put(obj2, obj);
        return put;
    }

    public void putAll(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public Object remove(Object obj) {
        if (!this.maps[0].containsKey(obj)) {
            return null;
        }
        Object remove = this.maps[0].remove(obj);
        this.maps[1].remove(remove);
        return remove;
    }

    public Object removeValue(Object obj) {
        if (!this.maps[1].containsKey(obj)) {
            return null;
        }
        Object remove = this.maps[1].remove(obj);
        this.maps[0].remove(remove);
        return remove;
    }

    public int size() {
        return this.maps[0].size();
    }

    public String toString() {
        return this.maps[0].toString();
    }

    public Collection values() {
        if (this.values == null) {
            this.values = new Values(this);
        }
        return this.values;
    }

    protected AbstractDualBidiMap(Map map, Map map2) {
        Map[] mapArr = new Map[2];
        this.maps = mapArr;
        this.inverseBidiMap = null;
        this.keySet = null;
        this.values = null;
        this.entrySet = null;
        mapArr[0] = map;
        mapArr[1] = map2;
    }

    protected AbstractDualBidiMap(Map map, Map map2, BidiMap bidiMap) {
        Map[] mapArr = new Map[2];
        this.maps = mapArr;
        this.keySet = null;
        this.values = null;
        this.entrySet = null;
        mapArr[0] = map;
        mapArr[1] = map2;
        this.inverseBidiMap = bidiMap;
    }
}

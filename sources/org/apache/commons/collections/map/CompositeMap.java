package org.apache.commons.collections.map;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.collection.CompositeCollection;
import org.apache.commons.collections.set.CompositeSet;

public class CompositeMap implements Map {
    private Map[] composite;
    private MapMutator mutator;

    public interface MapMutator {
        Object put(CompositeMap compositeMap, Map[] mapArr, Object obj, Object obj2);

        void putAll(CompositeMap compositeMap, Map[] mapArr, Map map);

        void resolveCollision(CompositeMap compositeMap, Map map, Map map2, Collection collection);
    }

    public CompositeMap() {
        this(new Map[0], (MapMutator) null);
    }

    public synchronized void addComposited(Map map) throws IllegalArgumentException {
        for (int length = this.composite.length - 1; length >= 0; length--) {
            Collection intersection = CollectionUtils.intersection(this.composite[length].keySet(), map.keySet());
            if (intersection.size() != 0) {
                MapMutator mapMutator = this.mutator;
                if (mapMutator != null) {
                    mapMutator.resolveCollision(this, this.composite[length], map, intersection);
                } else {
                    throw new IllegalArgumentException("Key collision adding Map to CompositeMap");
                }
            }
        }
        Map[] mapArr = this.composite;
        int length2 = mapArr.length + 1;
        Map[] mapArr2 = new Map[length2];
        System.arraycopy(mapArr, 0, mapArr2, 0, mapArr.length);
        mapArr2[length2 - 1] = map;
        this.composite = mapArr2;
    }

    public void clear() {
        for (int length = this.composite.length - 1; length >= 0; length--) {
            this.composite[length].clear();
        }
    }

    public boolean containsKey(Object obj) {
        for (int length = this.composite.length - 1; length >= 0; length--) {
            if (this.composite[length].containsKey(obj)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(Object obj) {
        for (int length = this.composite.length - 1; length >= 0; length--) {
            if (this.composite[length].containsValue(obj)) {
                return true;
            }
        }
        return false;
    }

    public Set entrySet() {
        CompositeSet compositeSet = new CompositeSet();
        for (int length = this.composite.length - 1; length >= 0; length--) {
            compositeSet.addComposited((Collection) this.composite[length].entrySet());
        }
        return compositeSet;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public Object get(Object obj) {
        for (int length = this.composite.length - 1; length >= 0; length--) {
            if (this.composite[length].containsKey(obj)) {
                return this.composite[length].get(obj);
            }
        }
        return null;
    }

    public int hashCode() {
        int i10 = 0;
        for (Object hashCode : entrySet()) {
            i10 += hashCode.hashCode();
        }
        return i10;
    }

    public boolean isEmpty() {
        for (int length = this.composite.length - 1; length >= 0; length--) {
            if (!this.composite[length].isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public Set keySet() {
        CompositeSet compositeSet = new CompositeSet();
        for (int length = this.composite.length - 1; length >= 0; length--) {
            compositeSet.addComposited((Collection) this.composite[length].keySet());
        }
        return compositeSet;
    }

    public Object put(Object obj, Object obj2) {
        MapMutator mapMutator = this.mutator;
        if (mapMutator != null) {
            return mapMutator.put(this, this.composite, obj, obj2);
        }
        throw new UnsupportedOperationException("No mutator specified");
    }

    public void putAll(Map map) {
        MapMutator mapMutator = this.mutator;
        if (mapMutator != null) {
            mapMutator.putAll(this, this.composite, map);
            return;
        }
        throw new UnsupportedOperationException("No mutator specified");
    }

    public Object remove(Object obj) {
        for (int length = this.composite.length - 1; length >= 0; length--) {
            if (this.composite[length].containsKey(obj)) {
                return this.composite[length].remove(obj);
            }
        }
        return null;
    }

    public synchronized Map removeComposited(Map map) {
        int length = this.composite.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (this.composite[i10].equals(map)) {
                Map[] mapArr = new Map[(length - 1)];
                System.arraycopy(this.composite, 0, mapArr, 0, i10);
                System.arraycopy(this.composite, i10 + 1, mapArr, i10, (length - i10) - 1);
                this.composite = mapArr;
                return map;
            }
        }
        return null;
    }

    public void setMutator(MapMutator mapMutator) {
        this.mutator = mapMutator;
    }

    public int size() {
        int i10 = 0;
        for (int length = this.composite.length - 1; length >= 0; length--) {
            i10 += this.composite[length].size();
        }
        return i10;
    }

    public Collection values() {
        CompositeCollection compositeCollection = new CompositeCollection();
        for (int length = this.composite.length - 1; length >= 0; length--) {
            compositeCollection.addComposited(this.composite[length].values());
        }
        return compositeCollection;
    }

    public CompositeMap(Map map, Map map2) {
        this(new Map[]{map, map2}, (MapMutator) null);
    }

    public CompositeMap(Map map, Map map2, MapMutator mapMutator) {
        this(new Map[]{map, map2}, mapMutator);
    }

    public CompositeMap(Map[] mapArr) {
        this(mapArr, (MapMutator) null);
    }

    public CompositeMap(Map[] mapArr, MapMutator mapMutator) {
        this.mutator = mapMutator;
        this.composite = new Map[0];
        for (int length = mapArr.length - 1; length >= 0; length--) {
            addComposited(mapArr[length]);
        }
    }
}

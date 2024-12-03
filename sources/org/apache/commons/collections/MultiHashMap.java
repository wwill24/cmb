package org.apache.commons.collections;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import net.bytebuddy.ClassFileVersion;
import org.apache.commons.collections.iterators.EmptyIterator;

public class MultiHashMap extends HashMap implements MultiMap {
    private static final long serialVersionUID = 1943563828307035349L;
    private transient Collection values = null;

    private class ValueIterator implements Iterator {
        private Iterator backedIterator;
        private Iterator tempIterator;

        private boolean searchNextIterator() {
            while (true) {
                Iterator it = this.tempIterator;
                if (it != null && it.hasNext()) {
                    return true;
                }
                if (!this.backedIterator.hasNext()) {
                    return false;
                }
                this.tempIterator = ((Collection) this.backedIterator.next()).iterator();
            }
        }

        public boolean hasNext() {
            return searchNextIterator();
        }

        public Object next() {
            if (searchNextIterator()) {
                return this.tempIterator.next();
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            Iterator it = this.tempIterator;
            if (it != null) {
                it.remove();
                return;
            }
            throw new IllegalStateException();
        }

        private ValueIterator() {
            this.backedIterator = MultiHashMap.this.superValuesIterator();
        }
    }

    private class Values extends AbstractCollection {
        private Values() {
        }

        public void clear() {
            MultiHashMap.this.clear();
        }

        public Iterator iterator() {
            return new ValueIterator();
        }

        public int size() {
            Iterator it = iterator();
            int i10 = 0;
            while (it.hasNext()) {
                it.next();
                i10++;
            }
            return i10;
        }
    }

    public MultiHashMap() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        String str;
        objectInputStream.defaultReadObject();
        try {
            str = System.getProperty(ClassFileVersion.VersionLocator.JAVA_VERSION);
        } catch (SecurityException unused) {
            str = "1.2";
        }
        if (str.startsWith("1.2") || str.startsWith("1.3")) {
            for (Map.Entry entry : entrySet()) {
                super.put(entry.getKey(), ((Collection) entry.getValue()).iterator().next());
            }
        }
    }

    public void clear() {
        for (Map.Entry value : super.entrySet()) {
            ((Collection) value.getValue()).clear();
        }
        super.clear();
    }

    public Object clone() {
        MultiHashMap multiHashMap = (MultiHashMap) super.clone();
        for (Map.Entry entry : multiHashMap.entrySet()) {
            entry.setValue(createCollection((Collection) entry.getValue()));
        }
        return multiHashMap;
    }

    public boolean containsValue(Object obj) {
        Set<Map.Entry> entrySet = super.entrySet();
        if (entrySet == null) {
            return false;
        }
        for (Map.Entry value : entrySet) {
            if (((Collection) value.getValue()).contains(obj)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public Collection createCollection(Collection collection) {
        if (collection == null) {
            return new ArrayList();
        }
        return new ArrayList(collection);
    }

    public Collection getCollection(Object obj) {
        return (Collection) get(obj);
    }

    public Iterator iterator(Object obj) {
        Collection collection = getCollection(obj);
        if (collection == null) {
            return EmptyIterator.INSTANCE;
        }
        return collection.iterator();
    }

    public Object put(Object obj, Object obj2) {
        Collection collection = getCollection(obj);
        if (collection == null) {
            collection = createCollection((Collection) null);
            super.put(obj, collection);
        }
        if (collection.add(obj2)) {
            return obj2;
        }
        return null;
    }

    public void putAll(Map map) {
        if (map instanceof MultiMap) {
            for (Map.Entry entry : map.entrySet()) {
                putAll(entry.getKey(), (Collection) entry.getValue());
            }
            return;
        }
        for (Map.Entry entry2 : map.entrySet()) {
            put(entry2.getKey(), entry2.getValue());
        }
    }

    public Object remove(Object obj, Object obj2) {
        Collection collection = getCollection(obj);
        if (collection == null || !collection.remove(obj2)) {
            return null;
        }
        if (collection.isEmpty()) {
            remove(obj);
        }
        return obj2;
    }

    public int size(Object obj) {
        Collection collection = getCollection(obj);
        if (collection == null) {
            return 0;
        }
        return collection.size();
    }

    /* access modifiers changed from: package-private */
    public Iterator superValuesIterator() {
        return super.values().iterator();
    }

    public int totalSize() {
        int i10 = 0;
        for (Collection size : super.values()) {
            i10 += size.size();
        }
        return i10;
    }

    public Collection values() {
        Collection collection = this.values;
        if (collection != null) {
            return collection;
        }
        Values values2 = new Values();
        this.values = values2;
        return values2;
    }

    public MultiHashMap(int i10) {
        super(i10);
    }

    public MultiHashMap(int i10, float f10) {
        super(i10, f10);
    }

    public MultiHashMap(Map map) {
        super((int) (((float) map.size()) * 1.4f));
        putAll(map);
    }

    public boolean containsValue(Object obj, Object obj2) {
        Collection collection = getCollection(obj);
        if (collection == null) {
            return false;
        }
        return collection.contains(obj2);
    }

    public boolean putAll(Object obj, Collection collection) {
        if (collection == null || collection.size() == 0) {
            return false;
        }
        Collection collection2 = getCollection(obj);
        if (collection2 != null) {
            return collection2.addAll(collection);
        }
        Collection createCollection = createCollection(collection);
        if (createCollection.size() == 0) {
            return false;
        }
        super.put(obj, createCollection);
        return true;
    }
}

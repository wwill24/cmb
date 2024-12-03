package org.apache.commons.collections.map;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections.Factory;
import org.apache.commons.collections.FunctorException;
import org.apache.commons.collections.MultiMap;
import org.apache.commons.collections.iterators.EmptyIterator;
import org.apache.commons.collections.iterators.IteratorChain;

public class MultiValueMap extends AbstractMapDecorator implements MultiMap {
    static /* synthetic */ Class class$java$util$ArrayList;
    private final Factory collectionFactory;
    private transient Collection values;

    private static class ReflectionFactory implements Factory {
        private final Class clazz;

        public ReflectionFactory(Class cls) {
            this.clazz = cls;
        }

        public Object create() {
            try {
                return this.clazz.newInstance();
            } catch (Exception e10) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Cannot instantiate class: ");
                stringBuffer.append(this.clazz);
                throw new FunctorException(stringBuffer.toString(), e10);
            }
        }
    }

    private class Values extends AbstractCollection {
        private Values() {
        }

        public void clear() {
            MultiValueMap.this.clear();
        }

        public Iterator iterator() {
            IteratorChain iteratorChain = new IteratorChain();
            for (Object valuesIterator : MultiValueMap.this.keySet()) {
                iteratorChain.addIterator(new ValuesIterator(valuesIterator));
            }
            return iteratorChain;
        }

        public int size() {
            return MultiValueMap.this.totalSize();
        }
    }

    private class ValuesIterator implements Iterator {
        private final Iterator iterator;
        private final Object key;
        private final Collection values;

        public ValuesIterator(Object obj) {
            this.key = obj;
            Collection collection = MultiValueMap.this.getCollection(obj);
            this.values = collection;
            this.iterator = collection.iterator();
        }

        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        public Object next() {
            return this.iterator.next();
        }

        public void remove() {
            this.iterator.remove();
            if (this.values.isEmpty()) {
                MultiValueMap.this.remove(this.key);
            }
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MultiValueMap() {
        /*
            r3 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            org.apache.commons.collections.map.MultiValueMap$ReflectionFactory r1 = new org.apache.commons.collections.map.MultiValueMap$ReflectionFactory
            java.lang.Class r2 = class$java$util$ArrayList
            if (r2 != 0) goto L_0x0013
            java.lang.String r2 = "java.util.ArrayList"
            java.lang.Class r2 = class$(r2)
            class$java$util$ArrayList = r2
        L_0x0013:
            r1.<init>(r2)
            r3.<init>(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.collections.map.MultiValueMap.<init>():void");
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new NoClassDefFoundError(e10.getMessage());
        }
    }

    public static MultiValueMap decorate(Map map) {
        Class cls = class$java$util$ArrayList;
        if (cls == null) {
            cls = class$("java.util.ArrayList");
            class$java$util$ArrayList = cls;
        }
        return new MultiValueMap(map, new ReflectionFactory(cls));
    }

    public void clear() {
        getMap().clear();
    }

    public boolean containsValue(Object obj) {
        Set<Map.Entry> entrySet = getMap().entrySet();
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
    public Collection createCollection(int i10) {
        return (Collection) this.collectionFactory.create();
    }

    public Collection getCollection(Object obj) {
        return (Collection) getMap().get(obj);
    }

    public Iterator iterator(Object obj) {
        if (!containsKey(obj)) {
            return EmptyIterator.INSTANCE;
        }
        return new ValuesIterator(obj);
    }

    public Object put(Object obj, Object obj2) {
        Collection collection = getCollection(obj);
        boolean z10 = true;
        if (collection == null) {
            Collection createCollection = createCollection(1);
            boolean add = createCollection.add(obj2);
            if (createCollection.size() > 0) {
                getMap().put(obj, createCollection);
            } else {
                z10 = add;
            }
        } else {
            z10 = collection.add(obj2);
        }
        if (z10) {
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

    public int totalSize() {
        int i10 = 0;
        for (Collection size : getMap().values()) {
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

    protected MultiValueMap(Map map, Factory factory) {
        super(map);
        if (factory != null) {
            this.collectionFactory = factory;
            return;
        }
        throw new IllegalArgumentException("The factory must not be null");
    }

    public static MultiValueMap decorate(Map map, Class cls) {
        return new MultiValueMap(map, new ReflectionFactory(cls));
    }

    public static MultiValueMap decorate(Map map, Factory factory) {
        return new MultiValueMap(map, factory);
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
        Collection createCollection = createCollection(collection.size());
        createCollection.addAll(collection);
        if (createCollection.size() <= 0) {
            return false;
        }
        getMap().put(obj, createCollection);
        return true;
    }
}

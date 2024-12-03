package org.apache.commons.beanutils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class BaseDynaBeanMapDecorator<K> implements Map<K, Object> {
    private final DynaBean dynaBean;
    private transient Set<K> keySet;
    private final boolean readOnly;

    private static class MapEntry<K> implements Map.Entry<K, Object> {
        private final K key;
        private final Object value;

        MapEntry(K k10, Object obj) {
            this.key = k10;
            this.value = obj;
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0025 A[ORIG_RETURN, RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                boolean r0 = r4 instanceof java.util.Map.Entry
                r1 = 0
                if (r0 != 0) goto L_0x0006
                return r1
            L_0x0006:
                java.util.Map$Entry r4 = (java.util.Map.Entry) r4
                K r0 = r3.key
                java.lang.Object r2 = r4.getKey()
                boolean r0 = r0.equals(r2)
                if (r0 == 0) goto L_0x0026
                java.lang.Object r0 = r3.value
                java.lang.Object r4 = r4.getValue()
                if (r0 != 0) goto L_0x001f
                if (r4 != 0) goto L_0x0026
                goto L_0x0025
            L_0x001f:
                boolean r4 = r0.equals(r4)
                if (r4 == 0) goto L_0x0026
            L_0x0025:
                r1 = 1
            L_0x0026:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.beanutils.BaseDynaBeanMapDecorator.MapEntry.equals(java.lang.Object):boolean");
        }

        public K getKey() {
            return this.key;
        }

        public Object getValue() {
            return this.value;
        }

        public int hashCode() {
            int hashCode = this.key.hashCode();
            Object obj = this.value;
            return hashCode + (obj == null ? 0 : obj.hashCode());
        }

        public Object setValue(Object obj) {
            throw new UnsupportedOperationException();
        }
    }

    public BaseDynaBeanMapDecorator(DynaBean dynaBean2) {
        this(dynaBean2, true);
    }

    private DynaProperty[] getDynaProperties() {
        return getDynaBean().getDynaClass().getDynaProperties();
    }

    private String toString(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean containsKey(Object obj) {
        if (getDynaBean().getDynaClass().getDynaProperty(toString(obj)) == null) {
            return false;
        }
        return true;
    }

    public boolean containsValue(Object obj) {
        DynaProperty[] dynaProperties = getDynaProperties();
        for (DynaProperty name : dynaProperties) {
            Object obj2 = getDynaBean().get(name.getName());
            if (obj == null) {
                if (obj2 == null) {
                    return true;
                }
            } else if (obj.equals(obj2)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract K convertKey(String str);

    public Set<Map.Entry<K, Object>> entrySet() {
        DynaProperty[] dynaProperties = getDynaProperties();
        HashSet hashSet = new HashSet(dynaProperties.length);
        for (int i10 = 0; i10 < dynaProperties.length; i10++) {
            hashSet.add(new MapEntry(convertKey(dynaProperties[i10].getName()), getDynaBean().get(dynaProperties[i10].getName())));
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public Object get(Object obj) {
        return getDynaBean().get(toString(obj));
    }

    public DynaBean getDynaBean() {
        return this.dynaBean;
    }

    public boolean isEmpty() {
        return getDynaProperties().length == 0;
    }

    public boolean isReadOnly() {
        return this.readOnly;
    }

    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        DynaProperty[] dynaProperties = getDynaProperties();
        HashSet hashSet = new HashSet(dynaProperties.length);
        for (DynaProperty name : dynaProperties) {
            hashSet.add(convertKey(name.getName()));
        }
        Set<K> unmodifiableSet = Collections.unmodifiableSet(hashSet);
        if (!(getDynaBean().getDynaClass() instanceof MutableDynaClass)) {
            this.keySet = unmodifiableSet;
        }
        return unmodifiableSet;
    }

    public Object put(K k10, Object obj) {
        if (!isReadOnly()) {
            String baseDynaBeanMapDecorator = toString(k10);
            Object obj2 = getDynaBean().get(baseDynaBeanMapDecorator);
            getDynaBean().set(baseDynaBeanMapDecorator, obj);
            return obj2;
        }
        throw new UnsupportedOperationException("Map is read only");
    }

    public void putAll(Map<? extends K, ? extends Object> map) {
        if (!isReadOnly()) {
            for (Map.Entry next : map.entrySet()) {
                put(next.getKey(), next.getValue());
            }
            return;
        }
        throw new UnsupportedOperationException("Map is read only");
    }

    public Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public int size() {
        return getDynaProperties().length;
    }

    public Collection<Object> values() {
        DynaProperty[] dynaProperties = getDynaProperties();
        ArrayList arrayList = new ArrayList(dynaProperties.length);
        for (DynaProperty name : dynaProperties) {
            arrayList.add(getDynaBean().get(name.getName()));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public BaseDynaBeanMapDecorator(DynaBean dynaBean2, boolean z10) {
        if (dynaBean2 != null) {
            this.dynaBean = dynaBean2;
            this.readOnly = z10;
            return;
        }
        throw new IllegalArgumentException("DynaBean is null");
    }
}

package org.apache.commons.beanutils;

import java.util.Map;

public class LazyDynaMap extends LazyDynaBean implements MutableDynaClass {
    protected String name;
    protected boolean restricted;
    protected boolean returnNull;

    public LazyDynaMap() {
        this((String) null, (Map<String, Object>) null);
    }

    public void add(String str) {
        add(str, (Class<?>) null);
    }

    public DynaProperty[] getDynaProperties() {
        Class<?> cls;
        DynaProperty[] dynaPropertyArr = new DynaProperty[this.values.size()];
        int i10 = 0;
        for (Map.Entry<String, Object> key : this.values.entrySet()) {
            String str = (String) key.getKey();
            Object obj = this.values.get(str);
            int i11 = i10 + 1;
            if (obj == null) {
                cls = null;
            } else {
                cls = obj.getClass();
            }
            dynaPropertyArr[i10] = new DynaProperty(str, cls);
            i10 = i11;
        }
        return dynaPropertyArr;
    }

    public DynaProperty getDynaProperty(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Property name is missing.");
        } else if (!this.values.containsKey(str) && isReturnNull()) {
            return null;
        } else {
            Object obj = this.values.get(str);
            if (obj == null) {
                return new DynaProperty(str);
            }
            return new DynaProperty(str, obj.getClass());
        }
    }

    public Map<String, Object> getMap() {
        return this.values;
    }

    public String getName() {
        return this.name;
    }

    /* access modifiers changed from: protected */
    public boolean isDynaProperty(String str) {
        if (str != null) {
            return this.values.containsKey(str);
        }
        throw new IllegalArgumentException("Property name is missing.");
    }

    public boolean isRestricted() {
        return this.restricted;
    }

    public boolean isReturnNull() {
        return this.returnNull;
    }

    public DynaBean newInstance() {
        Map<String, Object> map;
        try {
            map = (Map) getMap().getClass().newInstance();
        } catch (Exception unused) {
            map = newMap();
        }
        LazyDynaMap lazyDynaMap = new LazyDynaMap(map);
        DynaProperty[] dynaProperties = getDynaProperties();
        if (dynaProperties != null) {
            for (DynaProperty add : dynaProperties) {
                lazyDynaMap.add(add);
            }
        }
        return lazyDynaMap;
    }

    public void remove(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Property name is missing.");
        } else if (isRestricted()) {
            throw new IllegalStateException("DynaClass is currently restricted. No properties can be removed.");
        } else if (this.values.containsKey(str)) {
            this.values.remove(str);
        }
    }

    public void set(String str, Object obj) {
        if (!isRestricted() || this.values.containsKey(str)) {
            this.values.put(str, obj);
            return;
        }
        throw new IllegalArgumentException("Invalid property name '" + str + "' (DynaClass is restricted)");
    }

    public void setMap(Map<String, Object> map) {
        this.values = map;
    }

    public void setRestricted(boolean z10) {
        this.restricted = z10;
    }

    public void setReturnNull(boolean z10) {
        this.returnNull = z10;
    }

    public LazyDynaMap(String str) {
        this(str, (Map<String, Object>) null);
    }

    public void add(String str, Class<?> cls) {
        if (str == null) {
            throw new IllegalArgumentException("Property name is missing.");
        } else if (isRestricted()) {
            throw new IllegalStateException("DynaClass is currently restricted. No new properties can be added.");
        } else if (this.values.get(str) == null) {
            this.values.put(str, cls == null ? null : createProperty(str, cls));
        }
    }

    public LazyDynaMap(Map<String, Object> map) {
        this((String) null, map);
    }

    public LazyDynaMap(String str, Map<String, Object> map) {
        this.returnNull = false;
        this.name = str == null ? "LazyDynaMap" : str;
        this.values = map == null ? newMap() : map;
        this.dynaClass = this;
    }

    public void add(String str, Class<?> cls, boolean z10, boolean z11) {
        throw new UnsupportedOperationException("readable/writable properties not supported");
    }

    /* access modifiers changed from: protected */
    public void add(DynaProperty dynaProperty) {
        add(dynaProperty.getName(), dynaProperty.getType());
    }

    public LazyDynaMap(DynaProperty[] dynaPropertyArr) {
        this((String) null, dynaPropertyArr);
    }

    public LazyDynaMap(String str, DynaProperty[] dynaPropertyArr) {
        this(str, (Map<String, Object>) null);
        if (dynaPropertyArr != null) {
            for (DynaProperty add : dynaPropertyArr) {
                add(add);
            }
        }
    }

    public LazyDynaMap(DynaClass dynaClass) {
        this(dynaClass.getName(), dynaClass.getDynaProperties());
    }
}

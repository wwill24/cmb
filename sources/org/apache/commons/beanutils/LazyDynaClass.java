package org.apache.commons.beanutils;

public class LazyDynaClass extends BasicDynaClass implements MutableDynaClass {
    protected boolean restricted;
    protected boolean returnNull;

    public LazyDynaClass() {
        this((String) null, (DynaProperty[]) null);
    }

    public void add(String str) {
        add(new DynaProperty(str));
    }

    public DynaProperty getDynaProperty(String str) {
        if (str != null) {
            DynaProperty dynaProperty = this.propertiesMap.get(str);
            if (dynaProperty != null || isReturnNull() || isRestricted()) {
                return dynaProperty;
            }
            return new DynaProperty(str);
        }
        throw new IllegalArgumentException("Property name is missing.");
    }

    public boolean isDynaProperty(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Property name is missing.");
        } else if (this.propertiesMap.get(str) == null) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isRestricted() {
        return this.restricted;
    }

    public boolean isReturnNull() {
        return this.returnNull;
    }

    public void remove(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Property name is missing.");
        } else if (isRestricted()) {
            throw new IllegalStateException("DynaClass is currently restricted. No properties can be removed.");
        } else if (this.propertiesMap.get(str) != null) {
            DynaProperty[] dynaProperties = getDynaProperties();
            DynaProperty[] dynaPropertyArr = new DynaProperty[(dynaProperties.length - 1)];
            int i10 = 0;
            for (int i11 = 0; i11 < dynaProperties.length; i11++) {
                if (!str.equals(dynaProperties[i11].getName())) {
                    dynaPropertyArr[i10] = dynaProperties[i11];
                    i10++;
                }
            }
            setProperties(dynaPropertyArr);
        }
    }

    public void setRestricted(boolean z10) {
        this.restricted = z10;
    }

    public void setReturnNull(boolean z10) {
        this.returnNull = z10;
    }

    public LazyDynaClass(String str) {
        this(str, (DynaProperty[]) null);
    }

    public void add(String str, Class<?> cls) {
        if (cls == null) {
            add(str);
        } else {
            add(new DynaProperty(str, cls));
        }
    }

    public LazyDynaClass(String str, Class<?> cls) {
        this(str, cls, (DynaProperty[]) null);
    }

    public LazyDynaClass(String str, DynaProperty[] dynaPropertyArr) {
        this(str, LazyDynaBean.class, dynaPropertyArr);
    }

    public void add(String str, Class<?> cls, boolean z10, boolean z11) {
        throw new UnsupportedOperationException("readable/writable properties not supported");
    }

    public LazyDynaClass(String str, Class<?> cls, DynaProperty[] dynaPropertyArr) {
        super(str, cls, dynaPropertyArr);
        this.returnNull = false;
    }

    /* access modifiers changed from: protected */
    public void add(DynaProperty dynaProperty) {
        if (dynaProperty.getName() == null) {
            throw new IllegalArgumentException("Property name is missing.");
        } else if (isRestricted()) {
            throw new IllegalStateException("DynaClass is currently restricted. No new properties can be added.");
        } else if (this.propertiesMap.get(dynaProperty.getName()) == null) {
            DynaProperty[] dynaProperties = getDynaProperties();
            DynaProperty[] dynaPropertyArr = new DynaProperty[(dynaProperties.length + 1)];
            System.arraycopy(dynaProperties, 0, dynaPropertyArr, 0, dynaProperties.length);
            dynaPropertyArr[dynaProperties.length] = dynaProperty;
            setProperties(dynaPropertyArr);
        }
    }
}

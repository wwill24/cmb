package org.apache.commons.beanutils;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class BasicDynaClass implements DynaClass, Serializable {
    protected static Class<?>[] constructorTypes = {DynaClass.class};
    protected transient Constructor<?> constructor;
    protected Object[] constructorValues;
    protected Class<?> dynaBeanClass;
    protected String name;
    protected DynaProperty[] properties;
    protected HashMap<String, DynaProperty> propertiesMap;

    public BasicDynaClass() {
        this((String) null, (Class<?>) null, (DynaProperty[]) null);
    }

    public Class<?> getDynaBeanClass() {
        return this.dynaBeanClass;
    }

    public DynaProperty[] getDynaProperties() {
        return this.properties;
    }

    public DynaProperty getDynaProperty(String str) {
        if (str != null) {
            return this.propertiesMap.get(str);
        }
        throw new IllegalArgumentException("No property name specified");
    }

    public String getName() {
        return this.name;
    }

    public DynaBean newInstance() throws IllegalAccessException, InstantiationException {
        try {
            if (this.constructor == null) {
                setDynaBeanClass(this.dynaBeanClass);
            }
            return (DynaBean) this.constructor.newInstance(this.constructorValues);
        } catch (InvocationTargetException e10) {
            throw new InstantiationException(e10.getTargetException().getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public void setDynaBeanClass(Class<?> cls) {
        if (cls.isInterface()) {
            throw new IllegalArgumentException("Class " + cls.getName() + " is an interface, not a class");
        } else if (DynaBean.class.isAssignableFrom(cls)) {
            try {
                this.constructor = cls.getConstructor(constructorTypes);
                this.dynaBeanClass = cls;
            } catch (NoSuchMethodException unused) {
                throw new IllegalArgumentException("Class " + cls.getName() + " does not have an appropriate constructor");
            }
        } else {
            throw new IllegalArgumentException("Class " + cls.getName() + " does not implement DynaBean");
        }
    }

    /* access modifiers changed from: protected */
    public void setProperties(DynaProperty[] dynaPropertyArr) {
        this.properties = dynaPropertyArr;
        this.propertiesMap.clear();
        for (int i10 = 0; i10 < dynaPropertyArr.length; i10++) {
            this.propertiesMap.put(dynaPropertyArr[i10].getName(), dynaPropertyArr[i10]);
        }
    }

    public BasicDynaClass(String str, Class<?> cls) {
        this(str, cls, (DynaProperty[]) null);
    }

    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.Class<?>, code=java.lang.Class, for r4v0, types: [java.lang.Class<?>] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public BasicDynaClass(java.lang.String r3, java.lang.Class r4, org.apache.commons.beanutils.DynaProperty[] r5) {
        /*
            r2 = this;
            r2.<init>()
            r0 = 0
            r2.constructor = r0
            r0 = 1
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r1 = 0
            r0[r1] = r2
            r2.constructorValues = r0
            java.lang.Class<org.apache.commons.beanutils.BasicDynaBean> r0 = org.apache.commons.beanutils.BasicDynaBean.class
            r2.dynaBeanClass = r0
            java.lang.Class r0 = r2.getClass()
            java.lang.String r0 = r0.getName()
            r2.name = r0
            org.apache.commons.beanutils.DynaProperty[] r0 = new org.apache.commons.beanutils.DynaProperty[r1]
            r2.properties = r0
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r2.propertiesMap = r0
            if (r3 == 0) goto L_0x002b
            r2.name = r3
        L_0x002b:
            if (r4 != 0) goto L_0x002f
            java.lang.Class<org.apache.commons.beanutils.BasicDynaBean> r4 = org.apache.commons.beanutils.BasicDynaBean.class
        L_0x002f:
            r2.setDynaBeanClass(r4)
            if (r5 == 0) goto L_0x0037
            r2.setProperties(r5)
        L_0x0037:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.beanutils.BasicDynaClass.<init>(java.lang.String, java.lang.Class, org.apache.commons.beanutils.DynaProperty[]):void");
    }
}

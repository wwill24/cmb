package org.apache.commons.beanutils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

public class WrapDynaBean implements DynaBean, Serializable {
    protected transient WrapDynaClass dynaClass;
    protected Object instance;

    public WrapDynaBean(Object obj) {
        this(obj, (WrapDynaClass) null);
    }

    private PropertyUtilsBean getPropertyUtils() {
        PropertyUtilsBean propertyUtilsBean;
        WrapDynaClass wrapDynaClass = this.dynaClass;
        if (wrapDynaClass != null) {
            propertyUtilsBean = wrapDynaClass.getPropertyUtilsBean();
        } else {
            propertyUtilsBean = null;
        }
        if (propertyUtilsBean != null) {
            return propertyUtilsBean;
        }
        return PropertyUtilsBean.getInstance();
    }

    public boolean contains(String str, String str2) {
        throw new UnsupportedOperationException("WrapDynaBean does not support contains()");
    }

    public Object get(String str) {
        try {
            return getPropertyUtils().getSimpleProperty(this.instance, str);
        } catch (InvocationTargetException e10) {
            Throwable targetException = e10.getTargetException();
            throw new IllegalArgumentException("Error reading property '" + str + "' nested exception - " + targetException);
        } catch (Throwable th2) {
            throw new IllegalArgumentException("Error reading property '" + str + "', exception - " + th2);
        }
    }

    public DynaClass getDynaClass() {
        if (this.dynaClass == null) {
            this.dynaClass = WrapDynaClass.createDynaClass(this.instance.getClass());
        }
        return this.dynaClass;
    }

    /* access modifiers changed from: protected */
    public DynaProperty getDynaProperty(String str) {
        DynaProperty dynaProperty = getDynaClass().getDynaProperty(str);
        if (dynaProperty != null) {
            return dynaProperty;
        }
        throw new IllegalArgumentException("Invalid property name '" + str + "'");
    }

    public Object getInstance() {
        return this.instance;
    }

    public void remove(String str, String str2) {
        throw new UnsupportedOperationException("WrapDynaBean does not support remove()");
    }

    public void set(String str, Object obj) {
        try {
            getPropertyUtils().setSimpleProperty(this.instance, str, obj);
        } catch (InvocationTargetException e10) {
            Throwable targetException = e10.getTargetException();
            throw new IllegalArgumentException("Error setting property '" + str + "' nested exception -" + targetException);
        } catch (Throwable th2) {
            throw new IllegalArgumentException("Error setting property '" + str + "', exception - " + th2);
        }
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [org.apache.commons.beanutils.DynaClass] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public WrapDynaBean(java.lang.Object r2, org.apache.commons.beanutils.WrapDynaClass r3) {
        /*
            r1 = this;
            r1.<init>()
            r0 = 0
            r1.dynaClass = r0
            r1.instance = r2
            if (r3 == 0) goto L_0x000b
            goto L_0x0012
        L_0x000b:
            org.apache.commons.beanutils.DynaClass r2 = r1.getDynaClass()
            r3 = r2
            org.apache.commons.beanutils.WrapDynaClass r3 = (org.apache.commons.beanutils.WrapDynaClass) r3
        L_0x0012:
            r1.dynaClass = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.beanutils.WrapDynaBean.<init>(java.lang.Object, org.apache.commons.beanutils.WrapDynaClass):void");
    }

    public Object get(String str, int i10) {
        try {
            return getPropertyUtils().getIndexedProperty(this.instance, str, i10);
        } catch (IndexOutOfBoundsException e10) {
            throw e10;
        } catch (InvocationTargetException e11) {
            Throwable targetException = e11.getTargetException();
            throw new IllegalArgumentException("Error reading indexed property '" + str + "' nested exception - " + targetException);
        } catch (Throwable th2) {
            throw new IllegalArgumentException("Error reading indexed property '" + str + "', exception - " + th2);
        }
    }

    public void set(String str, int i10, Object obj) {
        try {
            getPropertyUtils().setIndexedProperty(this.instance, str, i10, obj);
        } catch (IndexOutOfBoundsException e10) {
            throw e10;
        } catch (InvocationTargetException e11) {
            Throwable targetException = e11.getTargetException();
            throw new IllegalArgumentException("Error setting indexed property '" + str + "' nested exception - " + targetException);
        } catch (Throwable th2) {
            throw new IllegalArgumentException("Error setting indexed property '" + str + "', exception - " + th2);
        }
    }

    public Object get(String str, String str2) {
        try {
            return getPropertyUtils().getMappedProperty(this.instance, str, str2);
        } catch (InvocationTargetException e10) {
            Throwable targetException = e10.getTargetException();
            throw new IllegalArgumentException("Error reading mapped property '" + str + "' nested exception - " + targetException);
        } catch (Throwable th2) {
            throw new IllegalArgumentException("Error reading mapped property '" + str + "', exception - " + th2);
        }
    }

    public void set(String str, String str2, Object obj) {
        try {
            getPropertyUtils().setMappedProperty(this.instance, str, str2, obj);
        } catch (InvocationTargetException e10) {
            Throwable targetException = e10.getTargetException();
            throw new IllegalArgumentException("Error setting mapped property '" + str + "' nested exception - " + targetException);
        } catch (Throwable th2) {
            throw new IllegalArgumentException("Error setting mapped property '" + str + "', exception - " + th2);
        }
    }
}

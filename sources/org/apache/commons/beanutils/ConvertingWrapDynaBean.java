package org.apache.commons.beanutils;

import java.lang.reflect.InvocationTargetException;

public class ConvertingWrapDynaBean extends WrapDynaBean {
    public ConvertingWrapDynaBean(Object obj) {
        super(obj);
    }

    public void set(String str, Object obj) {
        try {
            BeanUtils.copyProperty(this.instance, str, obj);
        } catch (InvocationTargetException e10) {
            Throwable targetException = e10.getTargetException();
            throw new IllegalArgumentException("Error setting property '" + str + "' nested exception - " + targetException);
        } catch (Throwable th2) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Error setting property '" + str + "', exception - " + th2);
            BeanUtils.initCause(illegalArgumentException, th2);
            throw illegalArgumentException;
        }
    }
}

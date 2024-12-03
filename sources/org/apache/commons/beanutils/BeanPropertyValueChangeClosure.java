package org.apache.commons.beanutils;

import java.lang.reflect.InvocationTargetException;
import org.apache.commons.collections.Closure;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BeanPropertyValueChangeClosure implements Closure {
    private boolean ignoreNull;
    private final Log log;
    private String propertyName;
    private Object propertyValue;

    public BeanPropertyValueChangeClosure(String str, Object obj) {
        this(str, obj, false);
    }

    public void execute(Object obj) {
        try {
            PropertyUtils.setProperty(obj, this.propertyName, this.propertyValue);
        } catch (IllegalArgumentException e10) {
            if (this.ignoreNull) {
                Log log2 = this.log;
                log2.warn("WARNING: Unable to execute Closure. Null value encountered in property path..." + e10);
                return;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unable to execute Closure. Null value encountered in property path...");
            if (!BeanUtils.initCause(illegalArgumentException, e10)) {
                this.log.error("Unable to execute Closure. Null value encountered in property path...", e10);
            }
            throw illegalArgumentException;
        } catch (IllegalAccessException e11) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Unable to access the property provided.");
            if (!BeanUtils.initCause(illegalArgumentException2, e11)) {
                this.log.error("Unable to access the property provided.", e11);
            }
            throw illegalArgumentException2;
        } catch (InvocationTargetException e12) {
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Exception occurred in property's getter");
            if (!BeanUtils.initCause(illegalArgumentException3, e12)) {
                this.log.error("Exception occurred in property's getter", e12);
            }
            throw illegalArgumentException3;
        } catch (NoSuchMethodException e13) {
            IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("Property not found");
            if (!BeanUtils.initCause(illegalArgumentException4, e13)) {
                this.log.error("Property not found", e13);
            }
            throw illegalArgumentException4;
        }
    }

    public String getPropertyName() {
        return this.propertyName;
    }

    public Object getPropertyValue() {
        return this.propertyValue;
    }

    public boolean isIgnoreNull() {
        return this.ignoreNull;
    }

    public BeanPropertyValueChangeClosure(String str, Object obj, boolean z10) {
        this.log = LogFactory.getLog(getClass());
        if (str == null || str.length() <= 0) {
            throw new IllegalArgumentException("propertyName cannot be null or empty");
        }
        this.propertyName = str;
        this.propertyValue = obj;
        this.ignoreNull = z10;
    }
}

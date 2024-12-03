package org.apache.commons.beanutils;

import java.lang.reflect.InvocationTargetException;
import org.apache.commons.collections.Predicate;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BeanPropertyValueEqualsPredicate implements Predicate {
    private boolean ignoreNull;
    private final Log log;
    private String propertyName;
    private Object propertyValue;

    public BeanPropertyValueEqualsPredicate(String str, Object obj) {
        this(str, obj, false);
    }

    public boolean evaluate(Object obj) {
        try {
            return evaluateValue(this.propertyValue, PropertyUtils.getProperty(obj, this.propertyName));
        } catch (IllegalArgumentException e10) {
            if (this.ignoreNull) {
                Log log2 = this.log;
                log2.warn("WARNING: Problem during evaluation. Null value encountered in property path..." + e10);
                return false;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Problem during evaluation. Null value encountered in property path...");
            if (!BeanUtils.initCause(illegalArgumentException, e10)) {
                this.log.error("Problem during evaluation. Null value encountered in property path...", e10);
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
            IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("Property not found.");
            if (!BeanUtils.initCause(illegalArgumentException4, e13)) {
                this.log.error("Property not found.", e13);
            }
            throw illegalArgumentException4;
        }
    }

    /* access modifiers changed from: protected */
    public boolean evaluateValue(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
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

    public BeanPropertyValueEqualsPredicate(String str, Object obj, boolean z10) {
        this.log = LogFactory.getLog(getClass());
        if (str == null || str.length() <= 0) {
            throw new IllegalArgumentException("propertyName cannot be null or empty");
        }
        this.propertyName = str;
        this.propertyValue = obj;
        this.ignoreNull = z10;
    }
}

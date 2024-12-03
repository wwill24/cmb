package org.apache.commons.beanutils;

import java.lang.reflect.InvocationTargetException;
import org.apache.commons.collections.Transformer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BeanToPropertyValueTransformer implements Transformer {
    private boolean ignoreNull;
    private final Log log;
    private String propertyName;

    public BeanToPropertyValueTransformer(String str) {
        this(str, false);
    }

    public String getPropertyName() {
        return this.propertyName;
    }

    public boolean isIgnoreNull() {
        return this.ignoreNull;
    }

    public Object transform(Object obj) {
        try {
            return PropertyUtils.getProperty(obj, this.propertyName);
        } catch (IllegalArgumentException e10) {
            if (this.ignoreNull) {
                this.log.warn("WARNING: Problem during transformation. Null value encountered in property path..." + e10);
                return null;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Problem during transformation. Null value encountered in property path...");
            if (!BeanUtils.initCause(illegalArgumentException, e10)) {
                this.log.error("Problem during transformation. Null value encountered in property path...", e10);
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
            String str = "No property found for name [" + this.propertyName + "]";
            IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException(str);
            if (!BeanUtils.initCause(illegalArgumentException4, e13)) {
                this.log.error(str, e13);
            }
            throw illegalArgumentException4;
        }
    }

    public BeanToPropertyValueTransformer(String str, boolean z10) {
        this.log = LogFactory.getLog(getClass());
        if (str == null || str.length() <= 0) {
            throw new IllegalArgumentException("propertyName cannot be null or empty");
        }
        this.propertyName = str;
        this.ignoreNull = z10;
    }
}

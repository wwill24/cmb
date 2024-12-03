package org.apache.commons.beanutils.converters;

import java.lang.reflect.Array;
import java.util.Collection;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.validator.Field;

public abstract class AbstractConverter implements Converter {
    private static final String DEFAULT_CONFIG_MSG = "(N.B. Converters can be configured to use default values to avoid throwing exceptions)";
    private static final String PACKAGE = "org.apache.commons.beanutils.converters.";
    private Object defaultValue = null;
    private transient Log log;
    private boolean useDefault = false;

    public AbstractConverter() {
    }

    private <T> T convertToDefaultType(Class<T> cls, Object obj) {
        return convert(getDefaultType(), obj);
    }

    /* access modifiers changed from: protected */
    public ConversionException conversionException(Class<?> cls, Object obj) {
        return new ConversionException("Can't convert value '" + obj + "' to type " + cls);
    }

    public <T> T convert(Class<T> cls, Object obj) {
        Class<?> cls2;
        String str;
        if (cls == null) {
            return convertToDefaultType(cls, obj);
        }
        if (obj == null) {
            cls2 = null;
        } else {
            cls2 = obj.getClass();
        }
        Class<T> primitiveToWrapper = ConvertUtils.primitiveToWrapper(cls);
        if (log().isDebugEnabled()) {
            Log log2 = log();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Converting");
            if (obj == null) {
                str = "";
            } else {
                str = " '" + toString(cls2) + "'";
            }
            sb2.append(str);
            sb2.append(" value '");
            sb2.append(obj);
            sb2.append("' to type '");
            sb2.append(toString(primitiveToWrapper));
            sb2.append("'");
            log2.debug(sb2.toString());
        }
        Object convertArray = convertArray(obj);
        if (convertArray == null) {
            return handleMissing(primitiveToWrapper);
        }
        Class<?> cls3 = convertArray.getClass();
        try {
            if (primitiveToWrapper.equals(String.class)) {
                return primitiveToWrapper.cast(convertToString(convertArray));
            }
            if (primitiveToWrapper.equals(cls3)) {
                if (log().isDebugEnabled()) {
                    log().debug("    No conversion required, value is already a " + toString(primitiveToWrapper));
                }
                return primitiveToWrapper.cast(convertArray);
            }
            T convertToType = convertToType(primitiveToWrapper, convertArray);
            if (log().isDebugEnabled()) {
                log().debug("    Converted to " + toString(primitiveToWrapper) + " value '" + convertToType + "'");
            }
            return primitiveToWrapper.cast(convertToType);
        } catch (Throwable th2) {
            return handleError(primitiveToWrapper, convertArray, th2);
        }
    }

    /* access modifiers changed from: protected */
    public Object convertArray(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj.getClass().isArray()) {
            if (Array.getLength(obj) > 0) {
                return Array.get(obj, 0);
            }
            return null;
        } else if (!(obj instanceof Collection)) {
            return obj;
        } else {
            Collection collection = (Collection) obj;
            if (collection.size() > 0) {
                return collection.iterator().next();
            }
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public String convertToString(Object obj) throws Throwable {
        return obj.toString();
    }

    /* access modifiers changed from: protected */
    public abstract <T> T convertToType(Class<T> cls, Object obj) throws Throwable;

    /* access modifiers changed from: protected */
    public Object getDefault(Class<?> cls) {
        if (cls.equals(String.class)) {
            return null;
        }
        return this.defaultValue;
    }

    /* access modifiers changed from: protected */
    public abstract Class<?> getDefaultType();

    /* access modifiers changed from: protected */
    public <T> T handleError(Class<T> cls, Object obj, Throwable th2) {
        ConversionException conversionException;
        if (log().isDebugEnabled()) {
            if (th2 instanceof ConversionException) {
                log().debug("    Conversion threw ConversionException: " + th2.getMessage());
            } else {
                log().debug("    Conversion threw " + th2);
            }
        }
        if (this.useDefault) {
            return handleMissing(cls);
        }
        if (th2 instanceof ConversionException) {
            conversionException = (ConversionException) th2;
            if (log().isDebugEnabled()) {
                log().debug("    Re-throwing ConversionException: " + conversionException.getMessage());
                log().debug("    (N.B. Converters can be configured to use default values to avoid throwing exceptions)");
            }
        } else {
            String str = "Error converting from '" + toString(obj.getClass()) + "' to '" + toString(cls) + "' " + th2.getMessage();
            ConversionException conversionException2 = new ConversionException(str, th2);
            if (log().isDebugEnabled()) {
                log().debug("    Throwing ConversionException: " + str);
                log().debug("    (N.B. Converters can be configured to use default values to avoid throwing exceptions)");
            }
            BeanUtils.initCause(conversionException2, th2);
            conversionException = conversionException2;
        }
        throw conversionException;
    }

    /* access modifiers changed from: protected */
    public <T> T handleMissing(Class<T> cls) {
        String str;
        if (this.useDefault || cls.equals(String.class)) {
            T t10 = getDefault(cls);
            if (this.useDefault && t10 != null && !cls.equals(t10.getClass())) {
                try {
                    t10 = convertToType(cls, this.defaultValue);
                } catch (Throwable th2) {
                    throw new ConversionException("Default conversion to " + toString(cls) + " failed.", th2);
                }
            }
            if (log().isDebugEnabled()) {
                Log log2 = log();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("    Using default ");
                if (t10 == null) {
                    str = "";
                } else {
                    str = toString(t10.getClass()) + " ";
                }
                sb2.append(str);
                sb2.append("value '");
                sb2.append(this.defaultValue);
                sb2.append("'");
                log2.debug(sb2.toString());
            }
            return cls.cast(t10);
        }
        ConversionException conversionException = new ConversionException("No value specified for '" + toString(cls) + "'");
        if (log().isDebugEnabled()) {
            log().debug("    Throwing ConversionException: " + conversionException.getMessage());
            log().debug("    (N.B. Converters can be configured to use default values to avoid throwing exceptions)");
        }
        throw conversionException;
    }

    public boolean isUseDefault() {
        return this.useDefault;
    }

    /* access modifiers changed from: package-private */
    public Log log() {
        if (this.log == null) {
            this.log = LogFactory.getLog(getClass());
        }
        return this.log;
    }

    /* access modifiers changed from: protected */
    public void setDefaultValue(Object obj) {
        this.useDefault = false;
        if (log().isDebugEnabled()) {
            Log log2 = log();
            log2.debug("Setting default value: " + obj);
        }
        if (obj == null) {
            this.defaultValue = null;
        } else {
            this.defaultValue = convert(getDefaultType(), obj);
        }
        this.useDefault = true;
    }

    public String toString() {
        return toString(getClass()) + "[UseDefault=" + this.useDefault + "]";
    }

    /* access modifiers changed from: package-private */
    public String toString(Class<?> cls) {
        String str;
        if (cls == null) {
            str = "null";
        } else if (cls.isArray()) {
            Class<?> componentType = cls.getComponentType();
            int i10 = 1;
            while (componentType.isArray()) {
                componentType = componentType.getComponentType();
                i10++;
            }
            str = componentType.getName();
            for (int i11 = 0; i11 < i10; i11++) {
                str = str + Field.TOKEN_INDEXED;
            }
        } else {
            str = cls.getName();
        }
        if (str.startsWith("java.lang.") || str.startsWith("java.util.") || str.startsWith("java.math.")) {
            return str.substring(10);
        }
        if (str.startsWith(PACKAGE)) {
            return str.substring(40);
        }
        return str;
    }

    public AbstractConverter(Object obj) {
        setDefaultValue(obj);
    }
}

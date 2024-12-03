package org.apache.commons.beanutils.locale;

import java.text.ParseException;
import java.util.Locale;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class BaseLocaleConverter implements LocaleConverter {
    private Object defaultValue;
    protected boolean locPattern;
    protected Locale locale;
    private final Log log;
    protected String pattern;
    protected boolean useDefault;

    protected BaseLocaleConverter(Locale locale2, String str) {
        this((Object) null, locale2, str, false, false);
    }

    private static <T> T checkConversionResult(Class<T> cls, Object obj) {
        if (cls == null) {
            return obj;
        }
        if (obj == null) {
            return null;
        }
        if (cls.isInstance(obj)) {
            return cls.cast(obj);
        }
        throw new ConversionException("Unsupported target type: " + cls);
    }

    private <T> T getDefaultAs(Class<T> cls) {
        return checkConversionResult(cls, this.defaultValue);
    }

    public Object convert(Object obj) {
        return convert(obj, (String) null);
    }

    /* access modifiers changed from: protected */
    public abstract Object parse(Object obj, String str) throws ParseException;

    protected BaseLocaleConverter(Locale locale2, String str, boolean z10) {
        this((Object) null, locale2, str, false, z10);
    }

    public Object convert(Object obj, String str) {
        return convert((Class) null, obj, str);
    }

    protected BaseLocaleConverter(Object obj, Locale locale2, String str) {
        this(obj, locale2, str, false);
    }

    public <T> T convert(Class<T> cls, Object obj) {
        return convert(cls, obj, (String) null);
    }

    protected BaseLocaleConverter(Object obj, Locale locale2, String str, boolean z10) {
        this(obj, locale2, str, true, z10);
    }

    public <T> T convert(Class<T> cls, Object obj, String str) {
        Class<T> primitiveToWrapper = ConvertUtils.primitiveToWrapper(cls);
        if (obj == null) {
            if (this.useDefault) {
                return getDefaultAs(primitiveToWrapper);
            }
            this.log.debug("Null value specified for conversion, returing null");
            return null;
        } else if (str == null) {
            return checkConversionResult(primitiveToWrapper, parse(obj, this.pattern));
        } else {
            try {
                return checkConversionResult(primitiveToWrapper, parse(obj, str));
            } catch (Exception e10) {
                if (this.useDefault) {
                    return getDefaultAs(primitiveToWrapper);
                }
                if (e10 instanceof ConversionException) {
                    throw ((ConversionException) e10);
                }
                throw new ConversionException((Throwable) e10);
            }
        }
    }

    private BaseLocaleConverter(Object obj, Locale locale2, String str, boolean z10, boolean z11) {
        this.log = LogFactory.getLog(BaseLocaleConverter.class);
        this.defaultValue = null;
        this.useDefault = false;
        this.locale = Locale.getDefault();
        this.pattern = null;
        this.locPattern = false;
        if (z10) {
            this.defaultValue = obj;
            this.useDefault = true;
        }
        if (locale2 != null) {
            this.locale = locale2;
        }
        this.pattern = str;
        this.locPattern = z11;
    }
}

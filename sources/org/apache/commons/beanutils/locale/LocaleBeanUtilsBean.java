package org.apache.commons.beanutils.locale;

import java.beans.IndexedPropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ContextClassLoaderLocal;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaProperty;
import org.apache.commons.beanutils.MappedPropertyDescriptor;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.commons.beanutils.expression.Resolver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LocaleBeanUtilsBean extends BeanUtilsBean {
    private static final ContextClassLoaderLocal<LocaleBeanUtilsBean> LOCALE_BEANS_BY_CLASSLOADER = new ContextClassLoaderLocal<LocaleBeanUtilsBean>() {
        /* access modifiers changed from: protected */
        public LocaleBeanUtilsBean initialValue() {
            return new LocaleBeanUtilsBean();
        }
    };
    private final LocaleConvertUtilsBean localeConvertUtils;
    private final Log log;

    @Deprecated
    protected class Descriptor {
        private int index = -1;
        private String key;
        private String name;
        private String propName;
        private Object target;

        public Descriptor(Object obj, String str, String str2, String str3, int i10) {
            setTarget(obj);
            setName(str);
            setPropName(str2);
            setKey(str3);
            setIndex(i10);
        }

        public int getIndex() {
            return this.index;
        }

        public String getKey() {
            return this.key;
        }

        public String getName() {
            return this.name;
        }

        public String getPropName() {
            return this.propName;
        }

        public Object getTarget() {
            return this.target;
        }

        public void setIndex(int i10) {
            this.index = i10;
        }

        public void setKey(String str) {
            this.key = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setPropName(String str) {
            this.propName = str;
        }

        public void setTarget(Object obj) {
            this.target = obj;
        }
    }

    public LocaleBeanUtilsBean() {
        this.log = LogFactory.getLog(LocaleBeanUtilsBean.class);
        this.localeConvertUtils = new LocaleConvertUtilsBean();
    }

    public static LocaleBeanUtilsBean getLocaleBeanUtilsInstance() {
        return LOCALE_BEANS_BY_CLASSLOADER.get();
    }

    public static void setInstance(LocaleBeanUtilsBean localeBeanUtilsBean) {
        LOCALE_BEANS_BY_CLASSLOADER.set(localeBeanUtilsBean);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public Descriptor calculate(Object obj, String str) throws IllegalAccessException, InvocationTargetException {
        Resolver resolver = getPropertyUtils().getResolver();
        Object obj2 = obj;
        String str2 = str;
        while (resolver.hasNested(str2)) {
            try {
                obj2 = getPropertyUtils().getProperty(obj2, resolver.next(str2));
                str2 = resolver.remove(str2);
            } catch (NoSuchMethodException unused) {
                return null;
            }
        }
        if (this.log.isTraceEnabled()) {
            Log log2 = this.log;
            log2.trace("    Target bean = " + obj2);
            Log log3 = this.log;
            log3.trace("    Target name = " + str2);
        }
        return new Descriptor(obj2, str2, resolver.getProperty(str2), resolver.getKey(str2), resolver.getIndex(str2));
    }

    /* access modifiers changed from: protected */
    public Object convert(Class<?> cls, int i10, Object obj, String str) {
        if (this.log.isTraceEnabled()) {
            Log log2 = this.log;
            log2.trace("Converting value '" + obj + "' to type:" + cls);
        }
        if (!cls.isArray() || i10 >= 0) {
            if (cls.isArray()) {
                if (obj instanceof String) {
                    return getLocaleConvertUtils().convert((String) obj, cls.getComponentType(), str);
                }
                if (obj instanceof String[]) {
                    return getLocaleConvertUtils().convert(((String[]) obj)[0], cls.getComponentType(), str);
                }
                return obj;
            } else if (obj instanceof String) {
                return getLocaleConvertUtils().convert((String) obj, cls, str);
            } else {
                return obj instanceof String[] ? getLocaleConvertUtils().convert(((String[]) obj)[0], cls, str) : obj;
            }
        } else if (obj instanceof String) {
            return getLocaleConvertUtils().convert(new String[]{(String) obj}, cls, str);
        } else if (obj instanceof String[]) {
            return getLocaleConvertUtils().convert((String[]) obj, cls, str);
        } else {
            return obj;
        }
    }

    /* access modifiers changed from: protected */
    public Class<?> definePropertyType(Object obj, String str, String str2) throws IllegalAccessException, InvocationTargetException {
        if (obj instanceof DynaBean) {
            DynaProperty dynaProperty = ((DynaBean) obj).getDynaClass().getDynaProperty(str2);
            if (dynaProperty == null) {
                return null;
            }
            return dynaProperty.getType();
        }
        try {
            MappedPropertyDescriptor propertyDescriptor = getPropertyUtils().getPropertyDescriptor(obj, str);
            if (propertyDescriptor == null) {
                return null;
            }
            if (propertyDescriptor instanceof MappedPropertyDescriptor) {
                return propertyDescriptor.getMappedPropertyType();
            }
            if (propertyDescriptor instanceof IndexedPropertyDescriptor) {
                return ((IndexedPropertyDescriptor) propertyDescriptor).getIndexedPropertyType();
            }
            return propertyDescriptor.getPropertyType();
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public boolean getApplyLocalized() {
        return getLocaleConvertUtils().getApplyLocalized();
    }

    public Locale getDefaultLocale() {
        return getLocaleConvertUtils().getDefaultLocale();
    }

    public String getIndexedProperty(Object obj, String str, String str2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return getLocaleConvertUtils().convert(getPropertyUtils().getIndexedProperty(obj, str), str2);
    }

    public LocaleConvertUtilsBean getLocaleConvertUtils() {
        return this.localeConvertUtils;
    }

    public String getMappedProperty(Object obj, String str, String str2, String str3) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return getLocaleConvertUtils().convert(getPropertyUtils().getMappedProperty(obj, str, str2), str3);
    }

    public String getMappedPropertyLocale(Object obj, String str, String str2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return getLocaleConvertUtils().convert(getPropertyUtils().getMappedProperty(obj, str), str2);
    }

    public String getNestedProperty(Object obj, String str, String str2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return getLocaleConvertUtils().convert(getPropertyUtils().getNestedProperty(obj, str), str2);
    }

    public String getProperty(Object obj, String str, String str2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return getNestedProperty(obj, str, str2);
    }

    public String getSimpleProperty(Object obj, String str, String str2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return getLocaleConvertUtils().convert(getPropertyUtils().getSimpleProperty(obj, str), str2);
    }

    /* access modifiers changed from: protected */
    public void invokeSetter(Object obj, String str, String str2, int i10, Object obj2) throws IllegalAccessException, InvocationTargetException {
        if (i10 >= 0) {
            try {
                getPropertyUtils().setIndexedProperty(obj, str, i10, obj2);
            } catch (NoSuchMethodException e10) {
                throw new InvocationTargetException(e10, "Cannot set " + str);
            }
        } else if (str2 != null) {
            getPropertyUtils().setMappedProperty(obj, str, str2, obj2);
        } else {
            getPropertyUtils().setProperty(obj, str, obj2);
        }
    }

    public void setApplyLocalized(boolean z10) {
        getLocaleConvertUtils().setApplyLocalized(z10);
    }

    public void setDefaultLocale(Locale locale) {
        getLocaleConvertUtils().setDefaultLocale(locale);
    }

    public void setProperty(Object obj, String str, Object obj2) throws IllegalAccessException, InvocationTargetException {
        setProperty(obj, str, obj2, (String) null);
    }

    public String getProperty(Object obj, String str) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return getNestedProperty(obj, str);
    }

    public void setProperty(Object obj, String str, Object obj2, String str2) throws IllegalAccessException, InvocationTargetException {
        if (this.log.isTraceEnabled()) {
            StringBuilder sb2 = new StringBuilder("  setProperty(");
            sb2.append(obj);
            sb2.append(", ");
            sb2.append(str);
            sb2.append(", ");
            if (obj2 == null) {
                sb2.append("<NULL>");
            } else if (obj2 instanceof String) {
                sb2.append((String) obj2);
            } else if (obj2 instanceof String[]) {
                String[] strArr = (String[]) obj2;
                sb2.append('[');
                for (int i10 = 0; i10 < strArr.length; i10++) {
                    if (i10 > 0) {
                        sb2.append(',');
                    }
                    sb2.append(strArr[i10]);
                }
                sb2.append(PropertyUtils.INDEXED_DELIM2);
            } else {
                sb2.append(obj2.toString());
            }
            sb2.append(PropertyUtils.MAPPED_DELIM2);
            this.log.trace(sb2.toString());
        }
        Resolver resolver = getPropertyUtils().getResolver();
        Object obj3 = obj;
        while (resolver.hasNested(str)) {
            try {
                obj3 = getPropertyUtils().getProperty(obj3, resolver.next(str));
                str = resolver.remove(str);
            } catch (NoSuchMethodException unused) {
                return;
            }
        }
        if (this.log.isTraceEnabled()) {
            Log log2 = this.log;
            log2.trace("    Target bean = " + obj3);
            Log log3 = this.log;
            log3.trace("    Target name = " + str);
        }
        String property = resolver.getProperty(str);
        int index = resolver.getIndex(str);
        String key = resolver.getKey(str);
        Class<?> definePropertyType = definePropertyType(obj3, str, property);
        if (definePropertyType != null) {
            invokeSetter(obj3, property, key, index, convert(definePropertyType, index, obj2, str2));
        }
    }

    public String getIndexedProperty(Object obj, String str) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return getIndexedProperty(obj, str, (String) null);
    }

    public String getMappedProperty(Object obj, String str, String str2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return getMappedProperty(obj, str, str2, (String) null);
    }

    public String getNestedProperty(Object obj, String str) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return getNestedProperty(obj, str, (String) null);
    }

    public String getSimpleProperty(Object obj, String str) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return getSimpleProperty(obj, str, (String) null);
    }

    public LocaleBeanUtilsBean(LocaleConvertUtilsBean localeConvertUtilsBean, ConvertUtilsBean convertUtilsBean, PropertyUtilsBean propertyUtilsBean) {
        super(convertUtilsBean, propertyUtilsBean);
        this.log = LogFactory.getLog(LocaleBeanUtilsBean.class);
        this.localeConvertUtils = localeConvertUtilsBean;
    }

    public String getIndexedProperty(Object obj, String str, int i10, String str2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return getLocaleConvertUtils().convert(getPropertyUtils().getIndexedProperty(obj, str, i10), str2);
    }

    public String getMappedProperty(Object obj, String str) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return getMappedPropertyLocale(obj, str, (String) null);
    }

    public String getIndexedProperty(Object obj, String str, int i10) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return getIndexedProperty(obj, str, i10, (String) null);
    }

    public LocaleBeanUtilsBean(LocaleConvertUtilsBean localeConvertUtilsBean) {
        this.log = LogFactory.getLog(LocaleBeanUtilsBean.class);
        this.localeConvertUtils = localeConvertUtilsBean;
    }

    /* access modifiers changed from: protected */
    public Object convert(Class<?> cls, int i10, Object obj) {
        if (!cls.isArray() || i10 >= 0) {
            if (cls.isArray()) {
                if (obj instanceof String) {
                    return ConvertUtils.convert((String) obj, cls.getComponentType());
                }
                if (obj instanceof String[]) {
                    return ConvertUtils.convert(((String[]) obj)[0], cls.getComponentType());
                }
                return obj;
            } else if (obj instanceof String) {
                return ConvertUtils.convert((String) obj, cls);
            } else {
                return obj instanceof String[] ? ConvertUtils.convert(((String[]) obj)[0], cls) : obj;
            }
        } else if (obj instanceof String) {
            return ConvertUtils.convert(new String[]{(String) obj}, cls);
        } else if (obj instanceof String[]) {
            return ConvertUtils.convert((String[]) obj, cls);
        } else {
            return obj;
        }
    }
}

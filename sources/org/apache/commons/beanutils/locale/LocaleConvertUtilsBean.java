package org.apache.commons.beanutils.locale;

import com.coffeemeetsbagel.models.util.DateUtils;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.locale.converters.BigDecimalLocaleConverter;
import org.apache.commons.beanutils.locale.converters.BigIntegerLocaleConverter;
import org.apache.commons.beanutils.locale.converters.ByteLocaleConverter;
import org.apache.commons.beanutils.locale.converters.DoubleLocaleConverter;
import org.apache.commons.beanutils.locale.converters.FloatLocaleConverter;
import org.apache.commons.beanutils.locale.converters.IntegerLocaleConverter;
import org.apache.commons.beanutils.locale.converters.LongLocaleConverter;
import org.apache.commons.beanutils.locale.converters.ShortLocaleConverter;
import org.apache.commons.beanutils.locale.converters.SqlDateLocaleConverter;
import org.apache.commons.beanutils.locale.converters.SqlTimeLocaleConverter;
import org.apache.commons.beanutils.locale.converters.SqlTimestampLocaleConverter;
import org.apache.commons.beanutils.locale.converters.StringLocaleConverter;
import org.apache.commons.collections.FastHashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LocaleConvertUtilsBean {
    private boolean applyLocalized = false;
    private Locale defaultLocale = Locale.getDefault();
    private final Log log = LogFactory.getLog(LocaleConvertUtils.class);
    private final FastHashMap mapConverters;

    private static class DelegateFastHashMap extends FastHashMap {
        private final Map<Object, Object> map;

        public void clear() {
            this.map.clear();
        }

        public boolean containsKey(Object obj) {
            return this.map.containsKey(obj);
        }

        public boolean containsValue(Object obj) {
            return this.map.containsValue(obj);
        }

        public Set<Map.Entry<Object, Object>> entrySet() {
            return this.map.entrySet();
        }

        public boolean equals(Object obj) {
            return this.map.equals(obj);
        }

        public Object get(Object obj) {
            return this.map.get(obj);
        }

        public boolean getFast() {
            return BeanUtils.getCacheFast(this.map);
        }

        public int hashCode() {
            return this.map.hashCode();
        }

        public boolean isEmpty() {
            return this.map.isEmpty();
        }

        public Set<Object> keySet() {
            return this.map.keySet();
        }

        public Object put(Object obj, Object obj2) {
            return this.map.put(obj, obj2);
        }

        public void putAll(Map map2) {
            this.map.putAll(map2);
        }

        public Object remove(Object obj) {
            return this.map.remove(obj);
        }

        public void setFast(boolean z10) {
            BeanUtils.setCacheFast(this.map, z10);
        }

        public int size() {
            return this.map.size();
        }

        public Collection<Object> values() {
            return this.map.values();
        }

        private DelegateFastHashMap(Map<Object, Object> map2) {
            this.map = map2;
        }
    }

    public LocaleConvertUtilsBean() {
        DelegateFastHashMap delegateFastHashMap = new DelegateFastHashMap(BeanUtils.createCache());
        this.mapConverters = delegateFastHashMap;
        delegateFastHashMap.setFast(false);
        deregister();
        delegateFastHashMap.setFast(true);
    }

    public static LocaleConvertUtilsBean getInstance() {
        return LocaleBeanUtilsBean.getLocaleBeanUtilsInstance().getLocaleConvertUtils();
    }

    public String convert(Object obj) {
        return convert(obj, this.defaultLocale, (String) null);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public FastHashMap create(Locale locale) {
        DelegateFastHashMap delegateFastHashMap = new DelegateFastHashMap(BeanUtils.createCache());
        delegateFastHashMap.setFast(false);
        delegateFastHashMap.put(BigDecimal.class, new BigDecimalLocaleConverter(locale, this.applyLocalized));
        delegateFastHashMap.put(BigInteger.class, new BigIntegerLocaleConverter(locale, this.applyLocalized));
        delegateFastHashMap.put(Byte.class, new ByteLocaleConverter(locale, this.applyLocalized));
        delegateFastHashMap.put(Byte.TYPE, new ByteLocaleConverter(locale, this.applyLocalized));
        delegateFastHashMap.put(Double.class, new DoubleLocaleConverter(locale, this.applyLocalized));
        delegateFastHashMap.put(Double.TYPE, new DoubleLocaleConverter(locale, this.applyLocalized));
        delegateFastHashMap.put(Float.class, new FloatLocaleConverter(locale, this.applyLocalized));
        delegateFastHashMap.put(Float.TYPE, new FloatLocaleConverter(locale, this.applyLocalized));
        delegateFastHashMap.put(Integer.class, new IntegerLocaleConverter(locale, this.applyLocalized));
        delegateFastHashMap.put(Integer.TYPE, new IntegerLocaleConverter(locale, this.applyLocalized));
        delegateFastHashMap.put(Long.class, new LongLocaleConverter(locale, this.applyLocalized));
        delegateFastHashMap.put(Long.TYPE, new LongLocaleConverter(locale, this.applyLocalized));
        delegateFastHashMap.put(Short.class, new ShortLocaleConverter(locale, this.applyLocalized));
        delegateFastHashMap.put(Short.TYPE, new ShortLocaleConverter(locale, this.applyLocalized));
        delegateFastHashMap.put(String.class, new StringLocaleConverter(locale, this.applyLocalized));
        delegateFastHashMap.put(Date.class, new SqlDateLocaleConverter(locale, DateUtils.DATE_PATTERN));
        delegateFastHashMap.put(Time.class, new SqlTimeLocaleConverter(locale, "HH:mm:ss"));
        delegateFastHashMap.put(Timestamp.class, new SqlTimestampLocaleConverter(locale, "yyyy-MM-dd HH:mm:ss.S"));
        delegateFastHashMap.setFast(true);
        return delegateFastHashMap;
    }

    public void deregister() {
        FastHashMap lookup = lookup(this.defaultLocale);
        this.mapConverters.setFast(false);
        this.mapConverters.clear();
        this.mapConverters.put(this.defaultLocale, lookup);
        this.mapConverters.setFast(true);
    }

    public boolean getApplyLocalized() {
        return this.applyLocalized;
    }

    public Locale getDefaultLocale() {
        return this.defaultLocale;
    }

    public LocaleConverter lookup(Class<?> cls, Locale locale) {
        LocaleConverter localeConverter = (LocaleConverter) lookup(locale).get(cls);
        if (this.log.isTraceEnabled()) {
            Log log2 = this.log;
            log2.trace("LocaleConverter:" + localeConverter);
        }
        return localeConverter;
    }

    public void register(LocaleConverter localeConverter, Class<?> cls, Locale locale) {
        lookup(locale).put(cls, localeConverter);
    }

    public void setApplyLocalized(boolean z10) {
        this.applyLocalized = z10;
    }

    public void setDefaultLocale(Locale locale) {
        if (locale == null) {
            this.defaultLocale = Locale.getDefault();
        } else {
            this.defaultLocale = locale;
        }
    }

    public String convert(Object obj, String str) {
        return convert(obj, this.defaultLocale, str);
    }

    public String convert(Object obj, Locale locale, String str) {
        Class cls = String.class;
        return (String) lookup(cls, locale).convert(cls, obj, str);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public FastHashMap lookup(Locale locale) {
        if (locale == null) {
            return (FastHashMap) this.mapConverters.get(this.defaultLocale);
        }
        FastHashMap fastHashMap = (FastHashMap) this.mapConverters.get(locale);
        if (fastHashMap == null) {
            fastHashMap = create(locale);
            this.mapConverters.put(locale, fastHashMap);
        }
        return fastHashMap;
    }

    public Object convert(String str, Class<?> cls) {
        return convert(str, cls, this.defaultLocale, (String) null);
    }

    public Object convert(String str, Class<?> cls, String str2) {
        return convert(str, cls, this.defaultLocale, str2);
    }

    public void deregister(Locale locale) {
        this.mapConverters.remove(locale);
    }

    public Object convert(String str, Class<?> cls, Locale locale, String str2) {
        Class<String> cls2 = String.class;
        if (this.log.isDebugEnabled()) {
            Log log2 = this.log;
            log2.debug("Convert string " + str + " to class " + cls.getName() + " using " + locale + " locale and " + str2 + " pattern");
        }
        LocaleConverter lookup = lookup(cls, locale);
        if (lookup == null) {
            lookup = lookup(cls2, locale);
            cls = cls2;
        }
        if (this.log.isTraceEnabled()) {
            Log log3 = this.log;
            log3.trace("  Using converter " + lookup);
        }
        return lookup.convert(cls, str, str2);
    }

    public void deregister(Class<?> cls, Locale locale) {
        lookup(locale).remove(cls);
    }

    public Object convert(String[] strArr, Class<?> cls, String str) {
        return convert(strArr, cls, getDefaultLocale(), str);
    }

    public Object convert(String[] strArr, Class<?> cls) {
        return convert(strArr, cls, getDefaultLocale(), (String) null);
    }

    public Object convert(String[] strArr, Class<?> cls, Locale locale, String str) {
        if (cls.isArray()) {
            cls = cls.getComponentType();
        }
        if (this.log.isDebugEnabled()) {
            Log log2 = this.log;
            log2.debug("Convert String[" + strArr.length + "] to class " + cls.getName() + "[] using " + locale + " locale and " + str + " pattern");
        }
        Object newInstance = Array.newInstance(cls, strArr.length);
        for (int i10 = 0; i10 < strArr.length; i10++) {
            Array.set(newInstance, i10, convert(strArr[i10], cls, locale, str));
        }
        return newInstance;
    }
}

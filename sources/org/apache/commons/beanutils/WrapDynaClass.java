package org.apache.commons.beanutils;

import java.beans.PropertyDescriptor;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class WrapDynaClass implements DynaClass {
    private static final ContextClassLoaderLocal<Map<CacheKey, WrapDynaClass>> CLASSLOADER_CACHE = new ContextClassLoaderLocal<Map<CacheKey, WrapDynaClass>>() {
        /* access modifiers changed from: protected */
        public Map<CacheKey, WrapDynaClass> initialValue() {
            return new WeakHashMap();
        }
    };
    @Deprecated
    protected static HashMap<Object, Object> dynaClasses = new HashMap<Object, Object>() {
        public void clear() {
            WrapDynaClass.getDynaClassesMap().clear();
        }

        public boolean containsKey(Object obj) {
            return WrapDynaClass.getDynaClassesMap().containsKey(obj);
        }

        public boolean containsValue(Object obj) {
            return WrapDynaClass.getDynaClassesMap().containsValue(obj);
        }

        public Set<Map.Entry<Object, Object>> entrySet() {
            return WrapDynaClass.getDynaClassesMap().entrySet();
        }

        public boolean equals(Object obj) {
            return WrapDynaClass.getDynaClassesMap().equals(obj);
        }

        public Object get(Object obj) {
            return WrapDynaClass.getDynaClassesMap().get(obj);
        }

        public int hashCode() {
            return WrapDynaClass.getDynaClassesMap().hashCode();
        }

        public boolean isEmpty() {
            return WrapDynaClass.getDynaClassesMap().isEmpty();
        }

        public Set<Object> keySet() {
            HashSet hashSet = new HashSet();
            for (CacheKey access$200 : WrapDynaClass.getClassesCache().keySet()) {
                hashSet.add(access$200.beanClass);
            }
            return hashSet;
        }

        public Object put(Object obj, Object obj2) {
            return WrapDynaClass.getClassesCache().put(new CacheKey((Class) obj, PropertyUtilsBean.getInstance()), (WrapDynaClass) obj2);
        }

        public void putAll(Map<? extends Object, ? extends Object> map) {
            for (Map.Entry next : map.entrySet()) {
                put(next.getKey(), next.getValue());
            }
        }

        public Object remove(Object obj) {
            return WrapDynaClass.getDynaClassesMap().remove(obj);
        }

        public int size() {
            return WrapDynaClass.getDynaClassesMap().size();
        }

        public Collection<Object> values() {
            return WrapDynaClass.getDynaClassesMap().values();
        }
    };
    @Deprecated
    protected Class<?> beanClass = null;
    private String beanClassName = null;
    private Reference<Class<?>> beanClassRef = null;
    protected PropertyDescriptor[] descriptors = null;
    protected HashMap<String, PropertyDescriptor> descriptorsMap = new HashMap<>();
    protected DynaProperty[] properties = null;
    protected HashMap<String, DynaProperty> propertiesMap = new HashMap<>();
    private final PropertyUtilsBean propertyUtilsBean;

    private static class CacheKey {
        /* access modifiers changed from: private */
        public final Class<?> beanClass;
        private final PropertyUtilsBean propUtils;

        public CacheKey(Class<?> cls, PropertyUtilsBean propertyUtilsBean) {
            this.beanClass = cls;
            this.propUtils = propertyUtilsBean;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CacheKey)) {
                return false;
            }
            CacheKey cacheKey = (CacheKey) obj;
            if (!this.beanClass.equals(cacheKey.beanClass) || !this.propUtils.equals(cacheKey.propUtils)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.propUtils.hashCode() * 31) + (this.beanClass.hashCode() * 31) + 17;
        }
    }

    private WrapDynaClass(Class<?> cls, PropertyUtilsBean propertyUtilsBean2) {
        this.beanClassRef = new SoftReference(cls);
        this.beanClassName = cls.getName();
        this.propertyUtilsBean = propertyUtilsBean2;
        introspect();
    }

    public static void clear() {
        getClassesCache().clear();
    }

    public static WrapDynaClass createDynaClass(Class<?> cls) {
        return createDynaClass(cls, (PropertyUtilsBean) null);
    }

    /* access modifiers changed from: private */
    public static Map<CacheKey, WrapDynaClass> getClassesCache() {
        return CLASSLOADER_CACHE.get();
    }

    /* access modifiers changed from: private */
    public static Map<Object, Object> getDynaClassesMap() {
        return CLASSLOADER_CACHE.get();
    }

    /* access modifiers changed from: protected */
    public Class<?> getBeanClass() {
        return this.beanClassRef.get();
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
        return this.beanClassName;
    }

    public PropertyDescriptor getPropertyDescriptor(String str) {
        return this.descriptorsMap.get(str);
    }

    /* access modifiers changed from: protected */
    public PropertyUtilsBean getPropertyUtilsBean() {
        return this.propertyUtilsBean;
    }

    /* access modifiers changed from: protected */
    public void introspect() {
        Class<?> beanClass2 = getBeanClass();
        PropertyDescriptor[] propertyDescriptors = getPropertyUtilsBean().getPropertyDescriptors(beanClass2);
        if (propertyDescriptors == null) {
            propertyDescriptors = new PropertyDescriptor[0];
        }
        Map mappedPropertyDescriptors = PropertyUtils.getMappedPropertyDescriptors(beanClass2);
        if (mappedPropertyDescriptors == null) {
            mappedPropertyDescriptors = new HashMap();
        }
        this.properties = new DynaProperty[(propertyDescriptors.length + mappedPropertyDescriptors.size())];
        for (int i10 = 0; i10 < propertyDescriptors.length; i10++) {
            this.descriptorsMap.put(propertyDescriptors[i10].getName(), propertyDescriptors[i10]);
            this.properties[i10] = new DynaProperty(propertyDescriptors[i10].getName(), propertyDescriptors[i10].getPropertyType());
            this.propertiesMap.put(this.properties[i10].getName(), this.properties[i10]);
        }
        int length = propertyDescriptors.length;
        for (String str : mappedPropertyDescriptors.keySet()) {
            this.properties[length] = new DynaProperty(((PropertyDescriptor) mappedPropertyDescriptors.get(str)).getName(), Map.class);
            this.propertiesMap.put(this.properties[length].getName(), this.properties[length]);
            length++;
        }
    }

    public DynaBean newInstance() throws IllegalAccessException, InstantiationException {
        return new WrapDynaBean(getBeanClass().newInstance());
    }

    public static WrapDynaClass createDynaClass(Class<?> cls, PropertyUtilsBean propertyUtilsBean2) {
        if (propertyUtilsBean2 == null) {
            propertyUtilsBean2 = PropertyUtilsBean.getInstance();
        }
        CacheKey cacheKey = new CacheKey(cls, propertyUtilsBean2);
        WrapDynaClass wrapDynaClass = getClassesCache().get(cacheKey);
        if (wrapDynaClass != null) {
            return wrapDynaClass;
        }
        WrapDynaClass wrapDynaClass2 = new WrapDynaClass(cls, propertyUtilsBean2);
        getClassesCache().put(cacheKey, wrapDynaClass2);
        return wrapDynaClass2;
    }
}

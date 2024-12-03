package org.apache.commons.beanutils;

import java.beans.IndexedPropertyDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.beanutils.expression.Resolver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BeanUtilsBean {
    private static final ContextClassLoaderLocal<BeanUtilsBean> BEANS_BY_CLASSLOADER = new ContextClassLoaderLocal<BeanUtilsBean>() {
        /* access modifiers changed from: protected */
        public BeanUtilsBean initialValue() {
            return new BeanUtilsBean();
        }
    };
    private static final Method INIT_CAUSE_METHOD = getInitCauseMethod();
    private final ConvertUtilsBean convertUtilsBean;
    private final Log log;
    private final PropertyUtilsBean propertyUtilsBean;

    public BeanUtilsBean() {
        this(new ConvertUtilsBean(), new PropertyUtilsBean());
    }

    private Object convertForCopy(Object obj, Class<?> cls) {
        return obj != null ? convert(obj, cls) : obj;
    }

    private static Class<?> dynaPropertyType(DynaProperty dynaProperty, Object obj) {
        if (!dynaProperty.isMapped()) {
            return dynaProperty.getType();
        }
        if (obj == null) {
            return String.class;
        }
        return obj.getClass();
    }

    private static Method getInitCauseMethod() {
        Class<BeanUtils> cls = BeanUtils.class;
        try {
            return Throwable.class.getMethod("initCause", new Class[]{Throwable.class});
        } catch (NoSuchMethodException unused) {
            Log log2 = LogFactory.getLog(cls);
            if (log2.isWarnEnabled()) {
                log2.warn("Throwable does not have initCause() method in JDK 1.3");
            }
            return null;
        } catch (Throwable th2) {
            Log log3 = LogFactory.getLog(cls);
            if (log3.isWarnEnabled()) {
                log3.warn("Error getting the Throwable initCause() method", th2);
            }
            return null;
        }
    }

    public static BeanUtilsBean getInstance() {
        return BEANS_BY_CLASSLOADER.get();
    }

    public static void setInstance(BeanUtilsBean beanUtilsBean) {
        BEANS_BY_CLASSLOADER.set(beanUtilsBean);
    }

    public Object cloneBean(Object obj) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        Object obj2;
        if (this.log.isDebugEnabled()) {
            Log log2 = this.log;
            log2.debug("Cloning bean: " + obj.getClass().getName());
        }
        if (obj instanceof DynaBean) {
            obj2 = ((DynaBean) obj).getDynaClass().newInstance();
        } else {
            obj2 = obj.getClass().newInstance();
        }
        getPropertyUtils().copyProperties(obj2, obj);
        return obj2;
    }

    /* access modifiers changed from: protected */
    public Object convert(Object obj, Class<?> cls) {
        Converter lookup = getConvertUtils().lookup(cls);
        if (lookup == null) {
            return obj;
        }
        Log log2 = this.log;
        log2.trace("        USING CONVERTER " + lookup);
        return lookup.convert(cls, obj);
    }

    public void copyProperties(Object obj, Object obj2) throws IllegalAccessException, InvocationTargetException {
        if (obj == null) {
            throw new IllegalArgumentException("No destination bean specified");
        } else if (obj2 != null) {
            if (this.log.isDebugEnabled()) {
                Log log2 = this.log;
                log2.debug("BeanUtils.copyProperties(" + obj + ", " + obj2 + ")");
            }
            int i10 = 0;
            if (obj2 instanceof DynaBean) {
                DynaBean dynaBean = (DynaBean) obj2;
                DynaProperty[] dynaProperties = dynaBean.getDynaClass().getDynaProperties();
                while (i10 < dynaProperties.length) {
                    String name = dynaProperties[i10].getName();
                    if (getPropertyUtils().isReadable(obj2, name) && getPropertyUtils().isWriteable(obj, name)) {
                        copyProperty(obj, name, dynaBean.get(name));
                    }
                    i10++;
                }
            } else if (obj2 instanceof Map) {
                for (Map.Entry entry : ((Map) obj2).entrySet()) {
                    String str = (String) entry.getKey();
                    if (getPropertyUtils().isWriteable(obj, str)) {
                        copyProperty(obj, str, entry.getValue());
                    }
                }
            } else {
                PropertyDescriptor[] propertyDescriptors = getPropertyUtils().getPropertyDescriptors(obj2);
                while (i10 < propertyDescriptors.length) {
                    String name2 = propertyDescriptors[i10].getName();
                    if (!"class".equals(name2) && getPropertyUtils().isReadable(obj2, name2) && getPropertyUtils().isWriteable(obj, name2)) {
                        try {
                            copyProperty(obj, name2, getPropertyUtils().getSimpleProperty(obj2, name2));
                        } catch (NoSuchMethodException unused) {
                        }
                    }
                    i10++;
                }
            }
        } else {
            throw new IllegalArgumentException("No origin bean specified");
        }
    }

    public void copyProperty(Object obj, String str, Object obj2) throws IllegalAccessException, InvocationTargetException {
        Class<?> cls;
        if (this.log.isTraceEnabled()) {
            StringBuilder sb2 = new StringBuilder("  copyProperty(");
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
        while (resolver.hasNested(str)) {
            try {
                obj = getPropertyUtils().getProperty(obj, resolver.next(str));
                str = resolver.remove(str);
            } catch (NoSuchMethodException unused) {
                return;
            }
        }
        if (this.log.isTraceEnabled()) {
            Log log2 = this.log;
            log2.trace("    Target bean = " + obj);
            Log log3 = this.log;
            log3.trace("    Target name = " + str);
        }
        String property = resolver.getProperty(str);
        int index = resolver.getIndex(str);
        String key = resolver.getKey(str);
        if (obj instanceof DynaBean) {
            DynaProperty dynaProperty = ((DynaBean) obj).getDynaClass().getDynaProperty(property);
            if (dynaProperty != null) {
                cls = dynaPropertyType(dynaProperty, obj2);
            } else {
                return;
            }
        } else {
            try {
                PropertyDescriptor propertyDescriptor = getPropertyUtils().getPropertyDescriptor(obj, str);
                if (propertyDescriptor != null) {
                    cls = propertyDescriptor.getPropertyType();
                    if (cls == null) {
                        if (this.log.isTraceEnabled()) {
                            Log log4 = this.log;
                            log4.trace("    target type for property '" + property + "' is null, so skipping ths setter");
                            return;
                        }
                        return;
                    }
                } else {
                    return;
                }
            } catch (NoSuchMethodException unused2) {
                return;
            }
        }
        if (this.log.isTraceEnabled()) {
            Log log5 = this.log;
            log5.trace("    target propName=" + property + ", type=" + cls + ", index=" + index + ", key=" + key);
        }
        if (index >= 0) {
            try {
                getPropertyUtils().setIndexedProperty(obj, property, index, convertForCopy(obj2, cls.getComponentType()));
            } catch (NoSuchMethodException e10) {
                throw new InvocationTargetException(e10, "Cannot set " + property);
            }
        } else if (key != null) {
            try {
                getPropertyUtils().setMappedProperty(obj, property, key, obj2);
            } catch (NoSuchMethodException e11) {
                throw new InvocationTargetException(e11, "Cannot set " + property);
            }
        } else {
            try {
                getPropertyUtils().setSimpleProperty(obj, property, convertForCopy(obj2, cls));
            } catch (NoSuchMethodException e12) {
                throw new InvocationTargetException(e12, "Cannot set " + property);
            }
        }
    }

    public Map<String, String> describe(Object obj) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        if (obj == null) {
            return new HashMap();
        }
        if (this.log.isDebugEnabled()) {
            Log log2 = this.log;
            log2.debug("Describing bean: " + obj.getClass().getName());
        }
        HashMap hashMap = new HashMap();
        int i10 = 0;
        if (obj instanceof DynaBean) {
            DynaProperty[] dynaProperties = ((DynaBean) obj).getDynaClass().getDynaProperties();
            while (i10 < dynaProperties.length) {
                String name = dynaProperties[i10].getName();
                hashMap.put(name, getProperty(obj, name));
                i10++;
            }
        } else {
            PropertyDescriptor[] propertyDescriptors = getPropertyUtils().getPropertyDescriptors(obj);
            Class<?> cls = obj.getClass();
            while (i10 < propertyDescriptors.length) {
                String name2 = propertyDescriptors[i10].getName();
                if (getPropertyUtils().getReadMethod(cls, propertyDescriptors[i10]) != null) {
                    hashMap.put(name2, getProperty(obj, name2));
                }
                i10++;
            }
        }
        return hashMap;
    }

    public String[] getArrayProperty(Object obj, String str) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Object property = getPropertyUtils().getProperty(obj, str);
        if (property == null) {
            return null;
        }
        if (property instanceof Collection) {
            ArrayList arrayList = new ArrayList();
            for (Object next : (Collection) property) {
                if (next == null) {
                    arrayList.add((Object) null);
                } else {
                    arrayList.add(getConvertUtils().convert(next));
                }
            }
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        if (property.getClass().isArray()) {
            int length = Array.getLength(property);
            String[] strArr = new String[length];
            for (int i10 = 0; i10 < length; i10++) {
                Object obj2 = Array.get(property, i10);
                if (obj2 == null) {
                    strArr[i10] = null;
                } else {
                    strArr[i10] = getConvertUtils().convert(obj2);
                }
            }
            return strArr;
        }
        return new String[]{getConvertUtils().convert(property)};
    }

    public ConvertUtilsBean getConvertUtils() {
        return this.convertUtilsBean;
    }

    public String getIndexedProperty(Object obj, String str) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return getConvertUtils().convert(getPropertyUtils().getIndexedProperty(obj, str));
    }

    public String getMappedProperty(Object obj, String str) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return getConvertUtils().convert(getPropertyUtils().getMappedProperty(obj, str));
    }

    public String getNestedProperty(Object obj, String str) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return getConvertUtils().convert(getPropertyUtils().getNestedProperty(obj, str));
    }

    public String getProperty(Object obj, String str) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return getNestedProperty(obj, str);
    }

    public PropertyUtilsBean getPropertyUtils() {
        return this.propertyUtilsBean;
    }

    public String getSimpleProperty(Object obj, String str) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return getConvertUtils().convert(getPropertyUtils().getSimpleProperty(obj, str));
    }

    public boolean initCause(Throwable th2, Throwable th3) {
        Method method = INIT_CAUSE_METHOD;
        if (!(method == null || th3 == null)) {
            try {
                method.invoke(th2, new Object[]{th3});
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public void populate(Object obj, Map<String, ? extends Object> map) throws IllegalAccessException, InvocationTargetException {
        if (obj != null && map != null) {
            if (this.log.isDebugEnabled()) {
                Log log2 = this.log;
                log2.debug("BeanUtils.populate(" + obj + ", " + map + ")");
            }
            for (Map.Entry next : map.entrySet()) {
                String str = (String) next.getKey();
                if (str != null) {
                    setProperty(obj, str, next.getValue());
                }
            }
        }
    }

    public void setProperty(Object obj, String str, Object obj2) throws IllegalAccessException, InvocationTargetException {
        Object obj3;
        Class cls = Object.class;
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
        while (resolver.hasNested(str)) {
            try {
                obj = getPropertyUtils().getProperty(obj, resolver.next(str));
                if (obj != null) {
                    str = resolver.remove(str);
                } else {
                    return;
                }
            } catch (NoSuchMethodException unused) {
                return;
            }
        }
        if (this.log.isTraceEnabled()) {
            this.log.trace("    Target bean = " + obj);
            this.log.trace("    Target name = " + str);
        }
        String property = resolver.getProperty(str);
        int index = resolver.getIndex(str);
        String key = resolver.getKey(str);
        if (obj instanceof DynaBean) {
            DynaProperty dynaProperty = ((DynaBean) obj).getDynaClass().getDynaProperty(property);
            if (dynaProperty != null) {
                cls = dynaPropertyType(dynaProperty, obj2);
            } else {
                return;
            }
        } else if (!(obj instanceof Map)) {
            if (obj == null || !obj.getClass().isArray() || index < 0) {
                try {
                    MappedPropertyDescriptor propertyDescriptor = getPropertyUtils().getPropertyDescriptor(obj, str);
                    if (propertyDescriptor != null) {
                        if (propertyDescriptor instanceof MappedPropertyDescriptor) {
                            MappedPropertyDescriptor mappedPropertyDescriptor = propertyDescriptor;
                            if (mappedPropertyDescriptor.getMappedWriteMethod() != null) {
                                cls = mappedPropertyDescriptor.getMappedPropertyType();
                            } else if (this.log.isDebugEnabled()) {
                                this.log.debug("Skipping read-only property");
                                return;
                            } else {
                                return;
                            }
                        } else if (index >= 0 && (propertyDescriptor instanceof IndexedPropertyDescriptor)) {
                            IndexedPropertyDescriptor indexedPropertyDescriptor = (IndexedPropertyDescriptor) propertyDescriptor;
                            if (indexedPropertyDescriptor.getIndexedWriteMethod() != null) {
                                cls = indexedPropertyDescriptor.getIndexedPropertyType();
                            } else if (this.log.isDebugEnabled()) {
                                this.log.debug("Skipping read-only property");
                                return;
                            } else {
                                return;
                            }
                        } else if (key != null) {
                            if (propertyDescriptor.getReadMethod() == null) {
                                if (this.log.isDebugEnabled()) {
                                    this.log.debug("Skipping read-only property");
                                    return;
                                }
                                return;
                            } else if (obj2 != null) {
                                cls = obj2.getClass();
                            }
                        } else if (propertyDescriptor.getWriteMethod() != null) {
                            cls = propertyDescriptor.getPropertyType();
                        } else if (this.log.isDebugEnabled()) {
                            this.log.debug("Skipping read-only property");
                            return;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (NoSuchMethodException unused2) {
                    return;
                }
            } else {
                cls = Array.get(obj, index).getClass();
            }
        }
        if (!cls.isArray() || index >= 0) {
            if (cls.isArray()) {
                if ((obj2 instanceof String) || obj2 == null) {
                    obj3 = getConvertUtils().convert((String) obj2, cls.getComponentType());
                } else if (obj2 instanceof String[]) {
                    obj3 = getConvertUtils().convert(((String[]) obj2)[0], cls.getComponentType());
                } else {
                    obj3 = convert(obj2, cls.getComponentType());
                }
            } else if (obj2 instanceof String) {
                obj3 = getConvertUtils().convert((String) obj2, (Class<?>) cls);
            } else if (obj2 instanceof String[]) {
                obj3 = getConvertUtils().convert(((String[]) obj2)[0], (Class<?>) cls);
            } else {
                obj3 = convert(obj2, cls);
            }
        } else if (obj2 == null) {
            obj3 = getConvertUtils().convert(new String[]{null}, (Class<?>) cls);
        } else if (obj2 instanceof String) {
            obj3 = getConvertUtils().convert(obj2, (Class<?>) cls);
        } else if (obj2 instanceof String[]) {
            obj3 = getConvertUtils().convert((String[]) obj2, (Class<?>) cls);
        } else {
            obj3 = convert(obj2, cls);
        }
        try {
            getPropertyUtils().setProperty(obj, str, obj3);
        } catch (NoSuchMethodException e10) {
            throw new InvocationTargetException(e10, "Cannot set " + property);
        }
    }

    public BeanUtilsBean(ConvertUtilsBean convertUtilsBean2) {
        this(convertUtilsBean2, new PropertyUtilsBean());
    }

    public BeanUtilsBean(ConvertUtilsBean convertUtilsBean2, PropertyUtilsBean propertyUtilsBean2) {
        this.log = LogFactory.getLog(BeanUtils.class);
        this.convertUtilsBean = convertUtilsBean2;
        this.propertyUtilsBean = propertyUtilsBean2;
    }

    public String getIndexedProperty(Object obj, String str, int i10) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return getConvertUtils().convert(getPropertyUtils().getIndexedProperty(obj, str, i10));
    }

    public String getMappedProperty(Object obj, String str, String str2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return getConvertUtils().convert(getPropertyUtils().getMappedProperty(obj, str, str2));
    }
}

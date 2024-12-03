package org.apache.commons.beanutils;

import java.beans.IndexedPropertyDescriptor;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.commons.beanutils.expression.DefaultResolver;
import org.apache.commons.beanutils.expression.Resolver;
import org.apache.commons.collections.FastHashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PropertyUtilsBean {
    private static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];
    private WeakFastHashMap<Class<?>, BeanIntrospectionData> descriptorsCache = null;
    private final List<BeanIntrospector> introspectors;
    private final Log log = LogFactory.getLog(PropertyUtils.class);
    private WeakFastHashMap<Class<?>, FastHashMap> mappedDescriptorsCache = null;
    private Resolver resolver = new DefaultResolver();

    public PropertyUtilsBean() {
        WeakFastHashMap<Class<?>, BeanIntrospectionData> weakFastHashMap = new WeakFastHashMap<>();
        this.descriptorsCache = weakFastHashMap;
        weakFastHashMap.setFast(true);
        WeakFastHashMap<Class<?>, FastHashMap> weakFastHashMap2 = new WeakFastHashMap<>();
        this.mappedDescriptorsCache = weakFastHashMap2;
        weakFastHashMap2.setFast(true);
        this.introspectors = new CopyOnWriteArrayList();
        resetBeanIntrospectors();
    }

    private BeanIntrospectionData fetchIntrospectionData(Class<?> cls) {
        DefaultIntrospectionContext defaultIntrospectionContext = new DefaultIntrospectionContext(cls);
        for (BeanIntrospector introspect : this.introspectors) {
            try {
                introspect.introspect(defaultIntrospectionContext);
            } catch (IntrospectionException e10) {
                this.log.error("Exception during introspection", e10);
            }
        }
        return new BeanIntrospectionData(defaultIntrospectionContext.getPropertyDescriptors());
    }

    protected static PropertyUtilsBean getInstance() {
        return BeanUtilsBean.getInstance().getPropertyUtils();
    }

    private BeanIntrospectionData getIntrospectionData(Class<?> cls) {
        if (cls != null) {
            BeanIntrospectionData beanIntrospectionData = this.descriptorsCache.get(cls);
            if (beanIntrospectionData != null) {
                return beanIntrospectionData;
            }
            BeanIntrospectionData fetchIntrospectionData = fetchIntrospectionData(cls);
            this.descriptorsCache.put(cls, fetchIntrospectionData);
            return fetchIntrospectionData;
        }
        throw new IllegalArgumentException("No bean class specified");
    }

    private Object invokeMethod(Method method, Object obj, Object[] objArr) throws IllegalAccessException, InvocationTargetException {
        String str;
        String str2;
        String str3;
        Object[] objArr2 = objArr;
        if (obj != null) {
            try {
                return method.invoke(obj, objArr);
            } catch (NullPointerException e10) {
                String str4 = "";
                NullPointerException nullPointerException = e10;
                String str5 = str4;
                if (objArr2 != null) {
                    for (int i10 = 0; i10 < objArr2.length; i10++) {
                        if (i10 > 0) {
                            str5 = str5 + ", ";
                        }
                        if (objArr2[i10] == null) {
                            str5 = str5 + "<null>";
                        } else {
                            str5 = str5 + objArr2[i10].getClass().getName();
                        }
                    }
                }
                Class[] parameterTypes = method.getParameterTypes();
                String str6 = str4;
                if (parameterTypes != null) {
                    for (int i11 = 0; i11 < parameterTypes.length; i11++) {
                        if (i11 > 0) {
                            str6 = str6 + ", ";
                        }
                        str6 = str6 + parameterTypes[i11].getName();
                    }
                }
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Cannot invoke " + method.getDeclaringClass().getName() + "." + method.getName() + " on bean class '" + obj.getClass() + "' - " + nullPointerException.getMessage() + " - had objects of type \"" + str5 + "\" but expected signature \"" + str6 + "\"");
                if (!BeanUtils.initCause(illegalArgumentException, nullPointerException)) {
                    this.log.error("Method invocation failed", nullPointerException);
                }
                throw illegalArgumentException;
            } catch (IllegalArgumentException e11) {
                IllegalArgumentException illegalArgumentException2 = e11;
                if (objArr2 != null) {
                    str2 = "";
                    str = str2;
                    for (int i12 = 0; i12 < objArr2.length; i12++) {
                        if (i12 > 0) {
                            str2 = str2 + ", ";
                        }
                        if (objArr2[i12] == null) {
                            str3 = str2 + "<null>";
                        } else {
                            str3 = str2 + objArr2[i12].getClass().getName();
                        }
                        str2 = str3;
                    }
                } else {
                    str = "";
                    str2 = str;
                }
                Class[] parameterTypes2 = method.getParameterTypes();
                String str7 = str;
                if (parameterTypes2 != null) {
                    for (int i13 = 0; i13 < parameterTypes2.length; i13++) {
                        if (i13 > 0) {
                            str7 = str7 + ", ";
                        }
                        str7 = str7 + parameterTypes2[i13].getName();
                    }
                }
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Cannot invoke " + method.getDeclaringClass().getName() + "." + method.getName() + " on bean class '" + obj.getClass() + "' - " + illegalArgumentException2.getMessage() + " - had objects of type \"" + str2 + "\" but expected signature \"" + str7 + "\"");
                if (!BeanUtils.initCause(illegalArgumentException3, illegalArgumentException2)) {
                    this.log.error("Method invocation failed", illegalArgumentException2);
                }
                throw illegalArgumentException3;
            }
        } else {
            throw new IllegalArgumentException("No bean specified - this should have been checked before reaching this method");
        }
    }

    private static List<Object> toObjectList(Object obj) {
        return (List) obj;
    }

    private static Map<String, Object> toPropertyMap(Object obj) {
        return (Map) obj;
    }

    public void addBeanIntrospector(BeanIntrospector beanIntrospector) {
        if (beanIntrospector != null) {
            this.introspectors.add(beanIntrospector);
            return;
        }
        throw new IllegalArgumentException("BeanIntrospector must not be null!");
    }

    public void clearDescriptors() {
        this.descriptorsCache.clear();
        this.mappedDescriptorsCache.clear();
        Introspector.flushCaches();
    }

    public void copyProperties(Object obj, Object obj2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        if (obj == null) {
            throw new IllegalArgumentException("No destination bean specified");
        } else if (obj2 != null) {
            int i10 = 0;
            if (obj2 instanceof DynaBean) {
                DynaProperty[] dynaProperties = ((DynaBean) obj2).getDynaClass().getDynaProperties();
                while (i10 < dynaProperties.length) {
                    String name = dynaProperties[i10].getName();
                    if (isReadable(obj2, name) && isWriteable(obj, name)) {
                        try {
                            Object obj3 = ((DynaBean) obj2).get(name);
                            if (obj instanceof DynaBean) {
                                ((DynaBean) obj).set(name, obj3);
                            } else {
                                setSimpleProperty(obj, name, obj3);
                            }
                        } catch (NoSuchMethodException e10) {
                            if (this.log.isDebugEnabled()) {
                                Log log2 = this.log;
                                log2.debug("Error writing to '" + name + "' on class '" + obj.getClass() + "'", e10);
                            }
                        }
                    }
                    i10++;
                }
            } else if (obj2 instanceof Map) {
                for (Map.Entry entry : ((Map) obj2).entrySet()) {
                    String str = (String) entry.getKey();
                    if (isWriteable(obj, str)) {
                        try {
                            if (obj instanceof DynaBean) {
                                ((DynaBean) obj).set(str, entry.getValue());
                            } else {
                                setSimpleProperty(obj, str, entry.getValue());
                            }
                        } catch (NoSuchMethodException e11) {
                            if (this.log.isDebugEnabled()) {
                                Log log3 = this.log;
                                log3.debug("Error writing to '" + str + "' on class '" + obj.getClass() + "'", e11);
                            }
                        }
                    }
                }
            } else {
                PropertyDescriptor[] propertyDescriptors = getPropertyDescriptors(obj2);
                while (i10 < propertyDescriptors.length) {
                    String name2 = propertyDescriptors[i10].getName();
                    if (isReadable(obj2, name2) && isWriteable(obj, name2)) {
                        try {
                            Object simpleProperty = getSimpleProperty(obj2, name2);
                            if (obj instanceof DynaBean) {
                                ((DynaBean) obj).set(name2, simpleProperty);
                            } else {
                                setSimpleProperty(obj, name2, simpleProperty);
                            }
                        } catch (NoSuchMethodException e12) {
                            if (this.log.isDebugEnabled()) {
                                Log log4 = this.log;
                                log4.debug("Error writing to '" + name2 + "' on class '" + obj.getClass() + "'", e12);
                            }
                        }
                    }
                    i10++;
                }
            }
        } else {
            throw new IllegalArgumentException("No origin bean specified");
        }
    }

    public Map<String, Object> describe(Object obj) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        if (obj != null) {
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
                PropertyDescriptor[] propertyDescriptors = getPropertyDescriptors(obj);
                while (i10 < propertyDescriptors.length) {
                    String name2 = propertyDescriptors[i10].getName();
                    if (propertyDescriptors[i10].getReadMethod() != null) {
                        hashMap.put(name2, getProperty(obj, name2));
                    }
                    i10++;
                }
            }
            return hashMap;
        }
        throw new IllegalArgumentException("No bean specified");
    }

    public Object getIndexedProperty(Object obj, String str) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        if (obj == null) {
            throw new IllegalArgumentException("No bean specified");
        } else if (str != null) {
            try {
                int index = this.resolver.getIndex(str);
                if (index >= 0) {
                    return getIndexedProperty(obj, this.resolver.getProperty(str), index);
                }
                throw new IllegalArgumentException("Invalid indexed property '" + str + "' on bean class '" + obj.getClass() + "'");
            } catch (IllegalArgumentException e10) {
                throw new IllegalArgumentException("Invalid indexed property '" + str + "' on bean class '" + obj.getClass() + "' " + e10.getMessage());
            }
        } else {
            throw new IllegalArgumentException("No name specified for bean class '" + obj.getClass() + "'");
        }
    }

    public Object getMappedProperty(Object obj, String str) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        if (obj == null) {
            throw new IllegalArgumentException("No bean specified");
        } else if (str != null) {
            try {
                String key = this.resolver.getKey(str);
                if (key != null) {
                    return getMappedProperty(obj, this.resolver.getProperty(str), key);
                }
                throw new IllegalArgumentException("Invalid mapped property '" + str + "' on bean class '" + obj.getClass() + "'");
            } catch (IllegalArgumentException e10) {
                throw new IllegalArgumentException("Invalid mapped property '" + str + "' on bean class '" + obj.getClass() + "' " + e10.getMessage());
            }
        } else {
            throw new IllegalArgumentException("No name specified for bean class '" + obj.getClass() + "'");
        }
    }

    @Deprecated
    public FastHashMap getMappedPropertyDescriptors(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        return this.mappedDescriptorsCache.get(cls);
    }

    public Object getNestedProperty(Object obj, String str) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Object obj2;
        if (obj == null) {
            throw new IllegalArgumentException("No bean specified");
        } else if (str != null) {
            while (this.resolver.hasNested(str)) {
                String next = this.resolver.next(str);
                if (obj instanceof Map) {
                    obj2 = getPropertyOfMapBean((Map) obj, next);
                } else if (this.resolver.isMapped(next)) {
                    obj2 = getMappedProperty(obj, next);
                } else if (this.resolver.isIndexed(next)) {
                    obj2 = getIndexedProperty(obj, next);
                } else {
                    obj2 = getSimpleProperty(obj, next);
                }
                if (obj2 != null) {
                    str = this.resolver.remove(str);
                    obj = obj2;
                } else {
                    throw new NestedNullException("Null property value for '" + str + "' on bean class '" + obj.getClass() + "'");
                }
            }
            if (obj instanceof Map) {
                return getPropertyOfMapBean((Map) obj, str);
            }
            if (this.resolver.isMapped(str)) {
                return getMappedProperty(obj, str);
            }
            if (this.resolver.isIndexed(str)) {
                return getIndexedProperty(obj, str);
            }
            return getSimpleProperty(obj, str);
        } else {
            throw new IllegalArgumentException("No name specified for bean class '" + obj.getClass() + "'");
        }
    }

    public Object getProperty(Object obj, String str) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return getNestedProperty(obj, str);
    }

    public PropertyDescriptor getPropertyDescriptor(Object obj, String str) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        if (obj == null) {
            throw new IllegalArgumentException("No bean specified");
        } else if (str != null) {
            while (this.resolver.hasNested(str)) {
                String next = this.resolver.next(str);
                Object property = getProperty(obj, next);
                if (property != null) {
                    str = this.resolver.remove(str);
                    obj = property;
                } else {
                    throw new NestedNullException("Null property value for '" + next + "' on bean class '" + obj.getClass() + "'");
                }
            }
            String property2 = this.resolver.getProperty(str);
            if (property2 == null) {
                return null;
            }
            PropertyDescriptor descriptor = getIntrospectionData(obj.getClass()).getDescriptor(property2);
            if (descriptor != null) {
                return descriptor;
            }
            FastHashMap mappedPropertyDescriptors = getMappedPropertyDescriptors(obj);
            if (mappedPropertyDescriptors == null) {
                mappedPropertyDescriptors = new FastHashMap();
                mappedPropertyDescriptors.setFast(true);
                this.mappedDescriptorsCache.put(obj.getClass(), mappedPropertyDescriptors);
            }
            PropertyDescriptor propertyDescriptor = (PropertyDescriptor) mappedPropertyDescriptors.get(property2);
            if (propertyDescriptor == null) {
                try {
                    propertyDescriptor = new MappedPropertyDescriptor(property2, obj.getClass());
                } catch (IntrospectionException unused) {
                }
                if (propertyDescriptor != null) {
                    mappedPropertyDescriptors.put(property2, propertyDescriptor);
                }
            }
            return propertyDescriptor;
        } else {
            throw new IllegalArgumentException("No name specified for bean class '" + obj.getClass() + "'");
        }
    }

    public PropertyDescriptor[] getPropertyDescriptors(Class<?> cls) {
        return getIntrospectionData(cls).getDescriptors();
    }

    public Class<?> getPropertyEditorClass(Object obj, String str) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        if (obj == null) {
            throw new IllegalArgumentException("No bean specified");
        } else if (str != null) {
            PropertyDescriptor propertyDescriptor = getPropertyDescriptor(obj, str);
            if (propertyDescriptor != null) {
                return propertyDescriptor.getPropertyEditorClass();
            }
            return null;
        } else {
            throw new IllegalArgumentException("No name specified for bean class '" + obj.getClass() + "'");
        }
    }

    /* access modifiers changed from: protected */
    public Object getPropertyOfMapBean(Map<?, ?> map, String str) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        String property;
        if (this.resolver.isMapped(str) && ((property = this.resolver.getProperty(str)) == null || property.length() == 0)) {
            str = this.resolver.getKey(str);
        }
        if (!this.resolver.isIndexed(str) && !this.resolver.isMapped(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Indexed or mapped properties are not supported on objects of type Map: " + str);
    }

    public Class<?> getPropertyType(Object obj, String str) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Class<?> type;
        if (obj == null) {
            throw new IllegalArgumentException("No bean specified");
        } else if (str != null) {
            while (this.resolver.hasNested(str)) {
                String next = this.resolver.next(str);
                Object property = getProperty(obj, next);
                if (property != null) {
                    str = this.resolver.remove(str);
                    obj = property;
                } else {
                    throw new NestedNullException("Null property value for '" + next + "' on bean class '" + obj.getClass() + "'");
                }
            }
            String property2 = this.resolver.getProperty(str);
            if (obj instanceof DynaBean) {
                DynaProperty dynaProperty = ((DynaBean) obj).getDynaClass().getDynaProperty(property2);
                if (dynaProperty == null || (type = dynaProperty.getType()) == null) {
                    return null;
                }
                if (type.isArray()) {
                    return type.getComponentType();
                }
                return type;
            }
            IndexedPropertyDescriptor propertyDescriptor = getPropertyDescriptor(obj, property2);
            if (propertyDescriptor == null) {
                return null;
            }
            if (propertyDescriptor instanceof IndexedPropertyDescriptor) {
                return propertyDescriptor.getIndexedPropertyType();
            }
            if (propertyDescriptor instanceof MappedPropertyDescriptor) {
                return ((MappedPropertyDescriptor) propertyDescriptor).getMappedPropertyType();
            }
            return propertyDescriptor.getPropertyType();
        } else {
            throw new IllegalArgumentException("No name specified for bean class '" + obj.getClass() + "'");
        }
    }

    public Method getReadMethod(PropertyDescriptor propertyDescriptor) {
        return MethodUtils.getAccessibleMethod(propertyDescriptor.getReadMethod());
    }

    public Resolver getResolver() {
        return this.resolver;
    }

    public Object getSimpleProperty(Object obj, String str) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        if (obj == null) {
            throw new IllegalArgumentException("No bean specified");
        } else if (str == null) {
            throw new IllegalArgumentException("No name specified for bean class '" + obj.getClass() + "'");
        } else if (this.resolver.hasNested(str)) {
            throw new IllegalArgumentException("Nested property names are not allowed: Property '" + str + "' on bean class '" + obj.getClass() + "'");
        } else if (this.resolver.isIndexed(str)) {
            throw new IllegalArgumentException("Indexed property names are not allowed: Property '" + str + "' on bean class '" + obj.getClass() + "'");
        } else if (this.resolver.isMapped(str)) {
            throw new IllegalArgumentException("Mapped property names are not allowed: Property '" + str + "' on bean class '" + obj.getClass() + "'");
        } else if (obj instanceof DynaBean) {
            DynaBean dynaBean = (DynaBean) obj;
            if (dynaBean.getDynaClass().getDynaProperty(str) != null) {
                return dynaBean.get(str);
            }
            throw new NoSuchMethodException("Unknown property '" + str + "' on dynaclass '" + dynaBean.getDynaClass() + "'");
        } else {
            PropertyDescriptor propertyDescriptor = getPropertyDescriptor(obj, str);
            if (propertyDescriptor != null) {
                Method readMethod = getReadMethod(obj.getClass(), propertyDescriptor);
                if (readMethod != null) {
                    return invokeMethod(readMethod, obj, EMPTY_OBJECT_ARRAY);
                }
                throw new NoSuchMethodException("Property '" + str + "' has no getter method in class '" + obj.getClass() + "'");
            }
            throw new NoSuchMethodException("Unknown property '" + str + "' on class '" + obj.getClass() + "'");
        }
    }

    public Method getWriteMethod(PropertyDescriptor propertyDescriptor) {
        return MethodUtils.getAccessibleMethod(propertyDescriptor.getWriteMethod());
    }

    public boolean isReadable(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException("No bean specified");
        } else if (str != null) {
            while (this.resolver.hasNested(str)) {
                String next = this.resolver.next(str);
                try {
                    Object property = getProperty(obj, next);
                    if (property != null) {
                        str = this.resolver.remove(str);
                        obj = property;
                    } else {
                        throw new NestedNullException("Null property value for '" + next + "' on bean class '" + obj.getClass() + "'");
                    }
                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                    return false;
                }
            }
            String property2 = this.resolver.getProperty(str);
            if (obj instanceof WrapDynaBean) {
                obj = ((WrapDynaBean) obj).getInstance();
            }
            if (!(obj instanceof DynaBean)) {
                try {
                    IndexedPropertyDescriptor propertyDescriptor = getPropertyDescriptor(obj, property2);
                    if (propertyDescriptor == null) {
                        return false;
                    }
                    Method readMethod = getReadMethod(obj.getClass(), propertyDescriptor);
                    if (readMethod == null) {
                        if (propertyDescriptor instanceof IndexedPropertyDescriptor) {
                            readMethod = propertyDescriptor.getIndexedReadMethod();
                        } else if (propertyDescriptor instanceof MappedPropertyDescriptor) {
                            readMethod = ((MappedPropertyDescriptor) propertyDescriptor).getMappedReadMethod();
                        }
                        readMethod = MethodUtils.getAccessibleMethod(obj.getClass(), readMethod);
                    }
                    if (readMethod != null) {
                        return true;
                    }
                    return false;
                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
                    return false;
                }
            } else if (((DynaBean) obj).getDynaClass().getDynaProperty(property2) != null) {
                return true;
            } else {
                return false;
            }
        } else {
            throw new IllegalArgumentException("No name specified for bean class '" + obj.getClass() + "'");
        }
    }

    public boolean isWriteable(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException("No bean specified");
        } else if (str != null) {
            while (this.resolver.hasNested(str)) {
                String next = this.resolver.next(str);
                try {
                    Object property = getProperty(obj, next);
                    if (property != null) {
                        str = this.resolver.remove(str);
                        obj = property;
                    } else {
                        throw new NestedNullException("Null property value for '" + next + "' on bean class '" + obj.getClass() + "'");
                    }
                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                    return false;
                }
            }
            String property2 = this.resolver.getProperty(str);
            if (obj instanceof WrapDynaBean) {
                obj = ((WrapDynaBean) obj).getInstance();
            }
            if (!(obj instanceof DynaBean)) {
                try {
                    IndexedPropertyDescriptor propertyDescriptor = getPropertyDescriptor(obj, property2);
                    if (propertyDescriptor == null) {
                        return false;
                    }
                    Method writeMethod = getWriteMethod(obj.getClass(), propertyDescriptor);
                    if (writeMethod == null) {
                        if (propertyDescriptor instanceof IndexedPropertyDescriptor) {
                            writeMethod = propertyDescriptor.getIndexedWriteMethod();
                        } else if (propertyDescriptor instanceof MappedPropertyDescriptor) {
                            writeMethod = ((MappedPropertyDescriptor) propertyDescriptor).getMappedWriteMethod();
                        }
                        writeMethod = MethodUtils.getAccessibleMethod(obj.getClass(), writeMethod);
                    }
                    if (writeMethod != null) {
                        return true;
                    }
                    return false;
                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
                    return false;
                }
            } else if (((DynaBean) obj).getDynaClass().getDynaProperty(property2) != null) {
                return true;
            } else {
                return false;
            }
        } else {
            throw new IllegalArgumentException("No name specified for bean class '" + obj.getClass() + "'");
        }
    }

    public boolean removeBeanIntrospector(BeanIntrospector beanIntrospector) {
        return this.introspectors.remove(beanIntrospector);
    }

    public final void resetBeanIntrospectors() {
        this.introspectors.clear();
        this.introspectors.add(DefaultBeanIntrospector.INSTANCE);
    }

    public void setIndexedProperty(Object obj, String str, Object obj2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        if (obj == null) {
            throw new IllegalArgumentException("No bean specified");
        } else if (str != null) {
            try {
                int index = this.resolver.getIndex(str);
                if (index >= 0) {
                    setIndexedProperty(obj, this.resolver.getProperty(str), index, obj2);
                    return;
                }
                throw new IllegalArgumentException("Invalid indexed property '" + str + "' on bean class '" + obj.getClass() + "'");
            } catch (IllegalArgumentException unused) {
                throw new IllegalArgumentException("Invalid indexed property '" + str + "' on bean class '" + obj.getClass() + "'");
            }
        } else {
            throw new IllegalArgumentException("No name specified for bean class '" + obj.getClass() + "'");
        }
    }

    public void setMappedProperty(Object obj, String str, Object obj2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        if (obj == null) {
            throw new IllegalArgumentException("No bean specified");
        } else if (str != null) {
            try {
                String key = this.resolver.getKey(str);
                if (key != null) {
                    setMappedProperty(obj, this.resolver.getProperty(str), key, obj2);
                    return;
                }
                throw new IllegalArgumentException("Invalid mapped property '" + str + "' on bean class '" + obj.getClass() + "'");
            } catch (IllegalArgumentException unused) {
                throw new IllegalArgumentException("Invalid mapped property '" + str + "' on bean class '" + obj.getClass() + "'");
            }
        } else {
            throw new IllegalArgumentException("No name specified for bean class '" + obj.getClass() + "'");
        }
    }

    public void setNestedProperty(Object obj, String str, Object obj2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Object obj3;
        if (obj == null) {
            throw new IllegalArgumentException("No bean specified");
        } else if (str != null) {
            while (this.resolver.hasNested(str)) {
                String next = this.resolver.next(str);
                if (obj instanceof Map) {
                    obj3 = getPropertyOfMapBean((Map) obj, next);
                } else if (this.resolver.isMapped(next)) {
                    obj3 = getMappedProperty(obj, next);
                } else if (this.resolver.isIndexed(next)) {
                    obj3 = getIndexedProperty(obj, next);
                } else {
                    obj3 = getSimpleProperty(obj, next);
                }
                if (obj3 != null) {
                    str = this.resolver.remove(str);
                    obj = obj3;
                } else {
                    throw new NestedNullException("Null property value for '" + str + "' on bean class '" + obj.getClass() + "'");
                }
            }
            if (obj instanceof Map) {
                setPropertyOfMapBean(toPropertyMap(obj), str, obj2);
            } else if (this.resolver.isMapped(str)) {
                setMappedProperty(obj, str, obj2);
            } else if (this.resolver.isIndexed(str)) {
                setIndexedProperty(obj, str, obj2);
            } else {
                setSimpleProperty(obj, str, obj2);
            }
        } else {
            throw new IllegalArgumentException("No name specified for bean class '" + obj.getClass() + "'");
        }
    }

    public void setProperty(Object obj, String str, Object obj2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        setNestedProperty(obj, str, obj2);
    }

    /* access modifiers changed from: protected */
    public void setPropertyOfMapBean(Map<String, Object> map, String str, Object obj) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        String property;
        if (this.resolver.isMapped(str) && ((property = this.resolver.getProperty(str)) == null || property.length() == 0)) {
            str = this.resolver.getKey(str);
        }
        if (this.resolver.isIndexed(str) || this.resolver.isMapped(str)) {
            throw new IllegalArgumentException("Indexed or mapped properties are not supported on objects of type Map: " + str);
        }
        map.put(str, obj);
    }

    public void setResolver(Resolver resolver2) {
        if (resolver2 == null) {
            this.resolver = new DefaultResolver();
        } else {
            this.resolver = resolver2;
        }
    }

    public void setSimpleProperty(Object obj, String str, Object obj2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        String str2;
        if (obj == null) {
            throw new IllegalArgumentException("No bean specified");
        } else if (str == null) {
            throw new IllegalArgumentException("No name specified for bean class '" + obj.getClass() + "'");
        } else if (this.resolver.hasNested(str)) {
            throw new IllegalArgumentException("Nested property names are not allowed: Property '" + str + "' on bean class '" + obj.getClass() + "'");
        } else if (this.resolver.isIndexed(str)) {
            throw new IllegalArgumentException("Indexed property names are not allowed: Property '" + str + "' on bean class '" + obj.getClass() + "'");
        } else if (this.resolver.isMapped(str)) {
            throw new IllegalArgumentException("Mapped property names are not allowed: Property '" + str + "' on bean class '" + obj.getClass() + "'");
        } else if (obj instanceof DynaBean) {
            DynaBean dynaBean = (DynaBean) obj;
            if (dynaBean.getDynaClass().getDynaProperty(str) != null) {
                dynaBean.set(str, obj2);
                return;
            }
            throw new NoSuchMethodException("Unknown property '" + str + "' on dynaclass '" + dynaBean.getDynaClass() + "'");
        } else {
            PropertyDescriptor propertyDescriptor = getPropertyDescriptor(obj, str);
            if (propertyDescriptor != null) {
                Method writeMethod = getWriteMethod(obj.getClass(), propertyDescriptor);
                if (writeMethod != null) {
                    Object[] objArr = {obj2};
                    if (this.log.isTraceEnabled()) {
                        if (obj2 == null) {
                            str2 = "<null>";
                        } else {
                            str2 = obj2.getClass().getName();
                        }
                        Log log2 = this.log;
                        log2.trace("setSimpleProperty: Invoking method " + writeMethod + " with value " + obj2 + " (class " + str2 + ")");
                    }
                    invokeMethod(writeMethod, obj, objArr);
                    return;
                }
                throw new NoSuchMethodException("Property '" + str + "' has no setter method in class '" + obj.getClass() + "'");
            }
            throw new NoSuchMethodException("Unknown property '" + str + "' on class '" + obj.getClass() + "'");
        }
    }

    @Deprecated
    public FastHashMap getMappedPropertyDescriptors(Object obj) {
        if (obj == null) {
            return null;
        }
        return getMappedPropertyDescriptors(obj.getClass());
    }

    public PropertyDescriptor[] getPropertyDescriptors(Object obj) {
        if (obj != null) {
            return getPropertyDescriptors(obj.getClass());
        }
        throw new IllegalArgumentException("No bean specified");
    }

    /* access modifiers changed from: package-private */
    public Method getReadMethod(Class<?> cls, PropertyDescriptor propertyDescriptor) {
        return MethodUtils.getAccessibleMethod(cls, propertyDescriptor.getReadMethod());
    }

    public Method getWriteMethod(Class<?> cls, PropertyDescriptor propertyDescriptor) {
        return MethodUtils.getAccessibleMethod(cls, getIntrospectionData(cls).getWriteMethod(cls, propertyDescriptor));
    }

    public Object getIndexedProperty(Object obj, String str, int i10) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Method accessibleMethod;
        if (obj != null) {
            if (str == null || str.length() == 0) {
                if (obj.getClass().isArray()) {
                    return Array.get(obj, i10);
                }
                if (obj instanceof List) {
                    return ((List) obj).get(i10);
                }
            }
            if (str == null) {
                throw new IllegalArgumentException("No name specified for bean class '" + obj.getClass() + "'");
            } else if (obj instanceof DynaBean) {
                DynaBean dynaBean = (DynaBean) obj;
                if (dynaBean.getDynaClass().getDynaProperty(str) != null) {
                    return dynaBean.get(str, i10);
                }
                throw new NoSuchMethodException("Unknown property '" + str + "' on bean class '" + obj.getClass() + "'");
            } else {
                IndexedPropertyDescriptor propertyDescriptor = getPropertyDescriptor(obj, str);
                if (propertyDescriptor == null) {
                    throw new NoSuchMethodException("Unknown property '" + str + "' on bean class '" + obj.getClass() + "'");
                } else if (!(propertyDescriptor instanceof IndexedPropertyDescriptor) || (accessibleMethod = MethodUtils.getAccessibleMethod(obj.getClass(), propertyDescriptor.getIndexedReadMethod())) == null) {
                    Method readMethod = getReadMethod(obj.getClass(), propertyDescriptor);
                    if (readMethod != null) {
                        Object invokeMethod = invokeMethod(readMethod, obj, EMPTY_OBJECT_ARRAY);
                        if (invokeMethod.getClass().isArray()) {
                            try {
                                return Array.get(invokeMethod, i10);
                            } catch (ArrayIndexOutOfBoundsException unused) {
                                throw new ArrayIndexOutOfBoundsException("Index: " + i10 + ", Size: " + Array.getLength(invokeMethod) + " for property '" + str + "'");
                            }
                        } else if (invokeMethod instanceof List) {
                            return ((List) invokeMethod).get(i10);
                        } else {
                            throw new IllegalArgumentException("Property '" + str + "' is not indexed on bean class '" + obj.getClass() + "'");
                        }
                    } else {
                        throw new NoSuchMethodException("Property '" + str + "' has no " + "getter method on bean class '" + obj.getClass() + "'");
                    }
                } else {
                    try {
                        return invokeMethod(accessibleMethod, obj, new Object[]{new Integer(i10)});
                    } catch (InvocationTargetException e10) {
                        if (e10.getTargetException() instanceof IndexOutOfBoundsException) {
                            throw ((IndexOutOfBoundsException) e10.getTargetException());
                        }
                        throw e10;
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("No bean specified");
        }
    }

    public Object getMappedProperty(Object obj, String str, String str2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        if (obj == null) {
            throw new IllegalArgumentException("No bean specified");
        } else if (str == null) {
            throw new IllegalArgumentException("No name specified for bean class '" + obj.getClass() + "'");
        } else if (str2 == null) {
            throw new IllegalArgumentException("No key specified for property '" + str + "' on bean class " + obj.getClass() + "'");
        } else if (obj instanceof DynaBean) {
            DynaBean dynaBean = (DynaBean) obj;
            if (dynaBean.getDynaClass().getDynaProperty(str) != null) {
                return dynaBean.get(str, str2);
            }
            throw new NoSuchMethodException("Unknown property '" + str + "'+ on bean class '" + obj.getClass() + "'");
        } else {
            Object obj2 = null;
            MappedPropertyDescriptor propertyDescriptor = getPropertyDescriptor(obj, str);
            if (propertyDescriptor == null) {
                throw new NoSuchMethodException("Unknown property '" + str + "'+ on bean class '" + obj.getClass() + "'");
            } else if (propertyDescriptor instanceof MappedPropertyDescriptor) {
                Method accessibleMethod = MethodUtils.getAccessibleMethod(obj.getClass(), propertyDescriptor.getMappedReadMethod());
                if (accessibleMethod != null) {
                    return invokeMethod(accessibleMethod, obj, new Object[]{str2});
                }
                throw new NoSuchMethodException("Property '" + str + "' has no mapped getter method on bean class '" + obj.getClass() + "'");
            } else {
                Method readMethod = getReadMethod(obj.getClass(), propertyDescriptor);
                if (readMethod != null) {
                    Object invokeMethod = invokeMethod(readMethod, obj, EMPTY_OBJECT_ARRAY);
                    if (invokeMethod instanceof Map) {
                        obj2 = ((Map) invokeMethod).get(str2);
                    }
                    return obj2;
                }
                throw new NoSuchMethodException("Property '" + str + "' has no mapped getter method on bean class '" + obj.getClass() + "'");
            }
        }
    }

    public void setIndexedProperty(Object obj, String str, int i10, Object obj2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Method accessibleMethod;
        String str2;
        if (obj != null) {
            if (str == null || str.length() == 0) {
                if (obj.getClass().isArray()) {
                    Array.set(obj, i10, obj2);
                    return;
                } else if (obj instanceof List) {
                    toObjectList(obj).set(i10, obj2);
                    return;
                }
            }
            if (str == null) {
                throw new IllegalArgumentException("No name specified for bean class '" + obj.getClass() + "'");
            } else if (obj instanceof DynaBean) {
                DynaBean dynaBean = (DynaBean) obj;
                if (dynaBean.getDynaClass().getDynaProperty(str) != null) {
                    dynaBean.set(str, i10, obj2);
                    return;
                }
                throw new NoSuchMethodException("Unknown property '" + str + "' on bean class '" + obj.getClass() + "'");
            } else {
                IndexedPropertyDescriptor propertyDescriptor = getPropertyDescriptor(obj, str);
                if (propertyDescriptor == null) {
                    throw new NoSuchMethodException("Unknown property '" + str + "' on bean class '" + obj.getClass() + "'");
                } else if (!(propertyDescriptor instanceof IndexedPropertyDescriptor) || (accessibleMethod = MethodUtils.getAccessibleMethod(obj.getClass(), propertyDescriptor.getIndexedWriteMethod())) == null) {
                    Method readMethod = getReadMethod(obj.getClass(), propertyDescriptor);
                    if (readMethod != null) {
                        Object invokeMethod = invokeMethod(readMethod, obj, EMPTY_OBJECT_ARRAY);
                        if (invokeMethod.getClass().isArray()) {
                            Array.set(invokeMethod, i10, obj2);
                        } else if (invokeMethod instanceof List) {
                            toObjectList(invokeMethod).set(i10, obj2);
                        } else {
                            throw new IllegalArgumentException("Property '" + str + "' is not indexed on bean class '" + obj.getClass() + "'");
                        }
                    } else {
                        throw new NoSuchMethodException("Property '" + str + "' has no getter method on bean class '" + obj.getClass() + "'");
                    }
                } else {
                    Object[] objArr = {new Integer(i10), obj2};
                    try {
                        if (this.log.isTraceEnabled()) {
                            if (obj2 == null) {
                                str2 = "<null>";
                            } else {
                                str2 = obj2.getClass().getName();
                            }
                            Log log2 = this.log;
                            log2.trace("setSimpleProperty: Invoking method " + accessibleMethod + " with index=" + i10 + ", value=" + obj2 + " (class " + str2 + ")");
                        }
                        invokeMethod(accessibleMethod, obj, objArr);
                    } catch (InvocationTargetException e10) {
                        if (e10.getTargetException() instanceof IndexOutOfBoundsException) {
                            throw ((IndexOutOfBoundsException) e10.getTargetException());
                        }
                        throw e10;
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("No bean specified");
        }
    }

    public void setMappedProperty(Object obj, String str, String str2, Object obj2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        String str3;
        if (obj == null) {
            throw new IllegalArgumentException("No bean specified");
        } else if (str == null) {
            throw new IllegalArgumentException("No name specified for bean class '" + obj.getClass() + "'");
        } else if (str2 == null) {
            throw new IllegalArgumentException("No key specified for property '" + str + "' on bean class '" + obj.getClass() + "'");
        } else if (obj instanceof DynaBean) {
            DynaBean dynaBean = (DynaBean) obj;
            if (dynaBean.getDynaClass().getDynaProperty(str) != null) {
                dynaBean.set(str, str2, obj2);
                return;
            }
            throw new NoSuchMethodException("Unknown property '" + str + "' on bean class '" + obj.getClass() + "'");
        } else {
            MappedPropertyDescriptor propertyDescriptor = getPropertyDescriptor(obj, str);
            if (propertyDescriptor == null) {
                throw new NoSuchMethodException("Unknown property '" + str + "' on bean class '" + obj.getClass() + "'");
            } else if (propertyDescriptor instanceof MappedPropertyDescriptor) {
                Method accessibleMethod = MethodUtils.getAccessibleMethod(obj.getClass(), propertyDescriptor.getMappedWriteMethod());
                if (accessibleMethod != null) {
                    Object[] objArr = {str2, obj2};
                    if (this.log.isTraceEnabled()) {
                        if (obj2 == null) {
                            str3 = "<null>";
                        } else {
                            str3 = obj2.getClass().getName();
                        }
                        Log log2 = this.log;
                        log2.trace("setSimpleProperty: Invoking method " + accessibleMethod + " with key=" + str2 + ", value=" + obj2 + " (class " + str3 + ")");
                    }
                    invokeMethod(accessibleMethod, obj, objArr);
                    return;
                }
                throw new NoSuchMethodException("Property '" + str + "' has no mapped setter method" + "on bean class '" + obj.getClass() + "'");
            } else {
                Method readMethod = getReadMethod(obj.getClass(), propertyDescriptor);
                if (readMethod != null) {
                    Object invokeMethod = invokeMethod(readMethod, obj, EMPTY_OBJECT_ARRAY);
                    if (invokeMethod instanceof Map) {
                        toPropertyMap(invokeMethod).put(str2, obj2);
                        return;
                    }
                    return;
                }
                throw new NoSuchMethodException("Property '" + str + "' has no mapped getter method on bean class '" + obj.getClass() + "'");
            }
        }
    }
}

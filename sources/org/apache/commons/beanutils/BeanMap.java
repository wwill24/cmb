package org.apache.commons.beanutils;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.keyvalue.AbstractMapEntry;

public class BeanMap extends AbstractMap<Object, Object> implements Cloneable {
    public static final Object[] NULL_ARGUMENTS = new Object[0];
    @Deprecated
    public static HashMap defaultTransformers = new HashMap() {
        public void clear() {
            throw new UnsupportedOperationException();
        }

        public boolean containsKey(Object obj) {
            return BeanMap.typeTransformers.containsKey(obj);
        }

        public boolean containsValue(Object obj) {
            return BeanMap.typeTransformers.containsValue(obj);
        }

        public Set entrySet() {
            return BeanMap.typeTransformers.entrySet();
        }

        public Object get(Object obj) {
            return BeanMap.typeTransformers.get(obj);
        }

        public boolean isEmpty() {
            return false;
        }

        public Set keySet() {
            return BeanMap.typeTransformers.keySet();
        }

        public Object put(Object obj, Object obj2) {
            throw new UnsupportedOperationException();
        }

        public void putAll(Map map) {
            throw new UnsupportedOperationException();
        }

        public Object remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            return BeanMap.typeTransformers.size();
        }

        public Collection values() {
            return BeanMap.typeTransformers.values();
        }
    };
    /* access modifiers changed from: private */
    public static final Map<Class<? extends Object>, Transformer> typeTransformers = Collections.unmodifiableMap(createTypeTransformers());
    private transient Object bean;
    /* access modifiers changed from: private */
    public transient HashMap<String, Method> readMethods = new HashMap<>();
    private transient HashMap<String, Class<? extends Object>> types = new HashMap<>();
    private transient HashMap<String, Method> writeMethods = new HashMap<>();

    protected static class Entry extends AbstractMapEntry {
        private final BeanMap owner;

        protected Entry(BeanMap beanMap, Object obj, Object obj2) {
            super(obj, obj2);
            this.owner = beanMap;
        }

        public Object setValue(Object obj) {
            Object key = getKey();
            Object obj2 = this.owner.get(key);
            this.owner.put(key, obj);
            super.setValue(this.owner.get(key));
            return obj2;
        }
    }

    public BeanMap() {
    }

    private static Map<Class<? extends Object>, Transformer> createTypeTransformers() {
        HashMap hashMap = new HashMap();
        hashMap.put(Boolean.TYPE, new Transformer() {
            public Object transform(Object obj) {
                return Boolean.valueOf(obj.toString());
            }
        });
        hashMap.put(Character.TYPE, new Transformer() {
            public Object transform(Object obj) {
                return new Character(obj.toString().charAt(0));
            }
        });
        hashMap.put(Byte.TYPE, new Transformer() {
            public Object transform(Object obj) {
                return Byte.valueOf(obj.toString());
            }
        });
        hashMap.put(Short.TYPE, new Transformer() {
            public Object transform(Object obj) {
                return Short.valueOf(obj.toString());
            }
        });
        hashMap.put(Integer.TYPE, new Transformer() {
            public Object transform(Object obj) {
                return Integer.valueOf(obj.toString());
            }
        });
        hashMap.put(Long.TYPE, new Transformer() {
            public Object transform(Object obj) {
                return Long.valueOf(obj.toString());
            }
        });
        hashMap.put(Float.TYPE, new Transformer() {
            public Object transform(Object obj) {
                return Float.valueOf(obj.toString());
            }
        });
        hashMap.put(Double.TYPE, new Transformer() {
            public Object transform(Object obj) {
                return Double.valueOf(obj.toString());
            }
        });
        return hashMap;
    }

    private void initialise() {
        if (getBean() != null) {
            try {
                PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(getBean().getClass()).getPropertyDescriptors();
                if (propertyDescriptors != null) {
                    for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                        if (propertyDescriptor != null) {
                            String name = propertyDescriptor.getName();
                            Method readMethod = propertyDescriptor.getReadMethod();
                            Method writeMethod = propertyDescriptor.getWriteMethod();
                            Class propertyType = propertyDescriptor.getPropertyType();
                            if (readMethod != null) {
                                this.readMethods.put(name, readMethod);
                            }
                            if (writeMethod != null) {
                                this.writeMethods.put(name, writeMethod);
                            }
                            this.types.put(name, propertyType);
                        }
                    }
                }
            } catch (IntrospectionException e10) {
                logWarn(e10);
            }
        }
    }

    public void clear() {
        Object obj = this.bean;
        if (obj != null) {
            Class<?> cls = null;
            try {
                cls = obj.getClass();
                this.bean = cls.newInstance();
            } catch (Exception e10) {
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Could not create new instance of class: " + cls);
                BeanUtils.initCause(unsupportedOperationException, e10);
                throw unsupportedOperationException;
            }
        }
    }

    public Object clone() throws CloneNotSupportedException {
        BeanMap beanMap = (BeanMap) super.clone();
        Object obj = this.bean;
        if (obj == null) {
            return beanMap;
        }
        Class<?> cls = obj.getClass();
        try {
            try {
                beanMap.setBean(cls.newInstance());
                try {
                    for (String next : this.readMethods.keySet()) {
                        if (getWriteMethod((Object) next) != null) {
                            beanMap.put(next, get(next));
                        }
                    }
                    return beanMap;
                } catch (Exception e10) {
                    CloneNotSupportedException cloneNotSupportedException = new CloneNotSupportedException("Unable to copy bean values to cloned bean map: " + e10);
                    BeanUtils.initCause(cloneNotSupportedException, e10);
                    throw cloneNotSupportedException;
                }
            } catch (Exception e11) {
                CloneNotSupportedException cloneNotSupportedException2 = new CloneNotSupportedException("Unable to set bean in the cloned bean map: " + e11);
                BeanUtils.initCause(cloneNotSupportedException2, e11);
                throw cloneNotSupportedException2;
            }
        } catch (Exception e12) {
            CloneNotSupportedException cloneNotSupportedException3 = new CloneNotSupportedException("Unable to instantiate the underlying bean \"" + cls.getName() + "\": " + e12);
            BeanUtils.initCause(cloneNotSupportedException3, e12);
            throw cloneNotSupportedException3;
        }
    }

    public boolean containsKey(Object obj) {
        return getReadMethod(obj) != null;
    }

    public boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    /* access modifiers changed from: protected */
    public Object convertType(Class<?> cls, Object obj) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            return cls.getConstructor(new Class[]{obj.getClass()}).newInstance(new Object[]{obj});
        } catch (NoSuchMethodException unused) {
            Transformer typeTransformer = getTypeTransformer(cls);
            if (typeTransformer != null) {
                return typeTransformer.transform(obj);
            }
            return obj;
        }
    }

    /* access modifiers changed from: protected */
    public Object[] createWriteMethodArguments(Method method, Object obj) throws IllegalAccessException, ClassCastException {
        if (obj != null) {
            try {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes != null && parameterTypes.length > 0) {
                    Class cls = parameterTypes[0];
                    if (!cls.isAssignableFrom(obj.getClass())) {
                        obj = convertType(cls, obj);
                    }
                }
            } catch (InvocationTargetException e10) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(e10.getMessage());
                if (!BeanUtils.initCause(illegalArgumentException, e10)) {
                    logInfo(e10);
                }
                throw illegalArgumentException;
            } catch (InstantiationException e11) {
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(e11.getMessage());
                if (!BeanUtils.initCause(illegalArgumentException2, e11)) {
                    logInfo(e11);
                }
                BeanUtils.initCause(illegalArgumentException2, e11);
                throw illegalArgumentException2;
            }
        }
        return new Object[]{obj};
    }

    public Iterator<Map.Entry<Object, Object>> entryIterator() {
        final Iterator<String> keyIterator = keyIterator();
        return new Iterator<Map.Entry<Object, Object>>() {
            public boolean hasNext() {
                return keyIterator.hasNext();
            }

            public void remove() {
                throw new UnsupportedOperationException("remove() not supported for BeanMap");
            }

            public Map.Entry<Object, Object> next() {
                Object next = keyIterator.next();
                return new Entry(BeanMap.this, next, BeanMap.this.get(next));
            }
        };
    }

    public Set<Map.Entry<Object, Object>> entrySet() {
        return Collections.unmodifiableSet(new AbstractSet<Map.Entry<Object, Object>>() {
            public Iterator<Map.Entry<Object, Object>> iterator() {
                return BeanMap.this.entryIterator();
            }

            public int size() {
                return BeanMap.this.readMethods.size();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void firePropertyChange(Object obj, Object obj2, Object obj3) {
    }

    public Object get(Object obj) {
        Method readMethod;
        if (this.bean == null || (readMethod = getReadMethod(obj)) == null) {
            return null;
        }
        try {
            return readMethod.invoke(this.bean, NULL_ARGUMENTS);
        } catch (IllegalAccessException e10) {
            logWarn(e10);
            return null;
        } catch (IllegalArgumentException e11) {
            logWarn(e11);
            return null;
        } catch (InvocationTargetException e12) {
            logWarn(e12);
            return null;
        } catch (NullPointerException e13) {
            logWarn(e13);
            return null;
        }
    }

    public Object getBean() {
        return this.bean;
    }

    public Method getReadMethod(String str) {
        return this.readMethods.get(str);
    }

    public Class<?> getType(String str) {
        return this.types.get(str);
    }

    /* access modifiers changed from: protected */
    public Transformer getTypeTransformer(Class<?> cls) {
        return typeTransformers.get(cls);
    }

    public Method getWriteMethod(String str) {
        return this.writeMethods.get(str);
    }

    public Iterator<String> keyIterator() {
        return this.readMethods.keySet().iterator();
    }

    public Set<Object> keySet() {
        return Collections.unmodifiableSet(this.readMethods.keySet());
    }

    /* access modifiers changed from: protected */
    public void logInfo(Exception exc) {
        PrintStream printStream = System.out;
        printStream.println("INFO: Exception: " + exc);
    }

    /* access modifiers changed from: protected */
    public void logWarn(Exception exc) {
        PrintStream printStream = System.out;
        printStream.println("WARN: Exception: " + exc);
        exc.printStackTrace();
    }

    public Object put(Object obj, Object obj2) throws IllegalArgumentException, ClassCastException {
        if (this.bean == null) {
            return null;
        }
        Object obj3 = get(obj);
        Method writeMethod = getWriteMethod(obj);
        if (writeMethod != null) {
            try {
                writeMethod.invoke(this.bean, createWriteMethodArguments(writeMethod, obj2));
                firePropertyChange(obj, obj3, get(obj));
                return obj3;
            } catch (InvocationTargetException e10) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(e10.getMessage());
                if (!BeanUtils.initCause(illegalArgumentException, e10)) {
                    logInfo(e10);
                }
                throw illegalArgumentException;
            } catch (IllegalAccessException e11) {
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(e11.getMessage());
                if (!BeanUtils.initCause(illegalArgumentException2, e11)) {
                    logInfo(e11);
                }
                throw illegalArgumentException2;
            }
        } else {
            throw new IllegalArgumentException("The bean of type: " + this.bean.getClass().getName() + " has no property called: " + obj);
        }
    }

    public void putAllWriteable(BeanMap beanMap) {
        for (String next : beanMap.readMethods.keySet()) {
            if (getWriteMethod((Object) next) != null) {
                put(next, beanMap.get(next));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void reinitialise() {
        this.readMethods.clear();
        this.writeMethods.clear();
        this.types.clear();
        initialise();
    }

    public void setBean(Object obj) {
        this.bean = obj;
        reinitialise();
    }

    public int size() {
        return this.readMethods.size();
    }

    public String toString() {
        return "BeanMap<" + String.valueOf(this.bean) + ">";
    }

    public Iterator<Object> valueIterator() {
        final Iterator<String> keyIterator = keyIterator();
        return new Iterator<Object>() {
            public boolean hasNext() {
                return keyIterator.hasNext();
            }

            public Object next() {
                return BeanMap.this.get(keyIterator.next());
            }

            public void remove() {
                throw new UnsupportedOperationException("remove() not supported for BeanMap");
            }
        };
    }

    public Collection<Object> values() {
        ArrayList arrayList = new ArrayList(this.readMethods.size());
        Iterator<Object> valueIterator = valueIterator();
        while (valueIterator.hasNext()) {
            arrayList.add(valueIterator.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* access modifiers changed from: protected */
    public Method getReadMethod(Object obj) {
        return this.readMethods.get(obj);
    }

    /* access modifiers changed from: protected */
    public Method getWriteMethod(Object obj) {
        return this.writeMethods.get(obj);
    }

    public BeanMap(Object obj) {
        this.bean = obj;
        initialise();
    }
}

package org.apache.commons.collections;

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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.collections.keyvalue.AbstractMapEntry;
import org.apache.commons.collections.list.UnmodifiableList;
import org.apache.commons.collections.set.UnmodifiableSet;

public class BeanMap extends AbstractMap implements Cloneable {
    public static final Object[] NULL_ARGUMENTS = new Object[0];
    public static HashMap defaultTransformers;
    private transient Object bean;
    /* access modifiers changed from: private */
    public transient HashMap readMethods = new HashMap();
    private transient HashMap types = new HashMap();
    private transient HashMap writeMethods = new HashMap();

    protected static class MyMapEntry extends AbstractMapEntry {
        private BeanMap owner;

        protected MyMapEntry(BeanMap beanMap, Object obj, Object obj2) {
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

    static {
        HashMap hashMap = new HashMap();
        defaultTransformers = hashMap;
        hashMap.put(Boolean.TYPE, new Transformer() {
            public Object transform(Object obj) {
                return Boolean.valueOf(obj.toString());
            }
        });
        defaultTransformers.put(Character.TYPE, new Transformer() {
            public Object transform(Object obj) {
                return new Character(obj.toString().charAt(0));
            }
        });
        defaultTransformers.put(Byte.TYPE, new Transformer() {
            public Object transform(Object obj) {
                return Byte.valueOf(obj.toString());
            }
        });
        defaultTransformers.put(Short.TYPE, new Transformer() {
            public Object transform(Object obj) {
                return Short.valueOf(obj.toString());
            }
        });
        defaultTransformers.put(Integer.TYPE, new Transformer() {
            public Object transform(Object obj) {
                return Integer.valueOf(obj.toString());
            }
        });
        defaultTransformers.put(Long.TYPE, new Transformer() {
            public Object transform(Object obj) {
                return Long.valueOf(obj.toString());
            }
        });
        defaultTransformers.put(Float.TYPE, new Transformer() {
            public Object transform(Object obj) {
                return Float.valueOf(obj.toString());
            }
        });
        defaultTransformers.put(Double.TYPE, new Transformer() {
            public Object transform(Object obj) {
                return Double.valueOf(obj.toString());
            }
        });
    }

    public BeanMap() {
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
            } catch (Exception unused) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Could not create new instance of class: ");
                stringBuffer.append(cls);
                throw new UnsupportedOperationException(stringBuffer.toString());
            }
        }
    }

    public Object clone() throws CloneNotSupportedException {
        BeanMap beanMap = (BeanMap) super.clone();
        Object obj = this.bean;
        if (obj == null) {
            return beanMap;
        }
        Class cls = null;
        try {
            try {
                beanMap.setBean(obj.getClass().newInstance());
                try {
                    for (Object next : this.readMethods.keySet()) {
                        if (getWriteMethod(next) != null) {
                            beanMap.put(next, get(next));
                        }
                    }
                    return beanMap;
                } catch (Exception e10) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Unable to copy bean values to cloned bean map: ");
                    stringBuffer.append(e10);
                    throw new CloneNotSupportedException(stringBuffer.toString());
                }
            } catch (Exception e11) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Unable to set bean in the cloned bean map: ");
                stringBuffer2.append(e11);
                throw new CloneNotSupportedException(stringBuffer2.toString());
            }
        } catch (Exception e12) {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("Unable to instantiate the underlying bean \"");
            stringBuffer3.append(cls.getName());
            stringBuffer3.append("\": ");
            stringBuffer3.append(e12);
            throw new CloneNotSupportedException(stringBuffer3.toString());
        }
    }

    public boolean containsKey(Object obj) {
        return getReadMethod(obj) != null;
    }

    public boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    /* access modifiers changed from: protected */
    public Object convertType(Class cls, Object obj) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
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
                logInfo(e10);
                throw new IllegalArgumentException(e10.getMessage());
            } catch (InstantiationException e11) {
                logInfo(e11);
                throw new IllegalArgumentException(e11.getMessage());
            }
        }
        return new Object[]{obj};
    }

    public Iterator entryIterator() {
        final Iterator keyIterator = keyIterator();
        return new Iterator() {
            public boolean hasNext() {
                return keyIterator.hasNext();
            }

            public Object next() {
                Object next = keyIterator.next();
                return new MyMapEntry(BeanMap.this, next, BeanMap.this.get(next));
            }

            public void remove() {
                throw new UnsupportedOperationException("remove() not supported for BeanMap");
            }
        };
    }

    public Set entrySet() {
        return UnmodifiableSet.decorate(new AbstractSet() {
            public Iterator iterator() {
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
        return (Method) this.readMethods.get(str);
    }

    public Class getType(String str) {
        return (Class) this.types.get(str);
    }

    /* access modifiers changed from: protected */
    public Transformer getTypeTransformer(Class cls) {
        return (Transformer) defaultTransformers.get(cls);
    }

    public Method getWriteMethod(String str) {
        return (Method) this.writeMethods.get(str);
    }

    public Iterator keyIterator() {
        return this.readMethods.keySet().iterator();
    }

    public Set keySet() {
        return UnmodifiableSet.decorate(this.readMethods.keySet());
    }

    /* access modifiers changed from: protected */
    public void logInfo(Exception exc) {
        PrintStream printStream = System.out;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("INFO: Exception: ");
        stringBuffer.append(exc);
        printStream.println(stringBuffer.toString());
    }

    /* access modifiers changed from: protected */
    public void logWarn(Exception exc) {
        PrintStream printStream = System.out;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("WARN: Exception: ");
        stringBuffer.append(exc);
        printStream.println(stringBuffer.toString());
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
                logInfo(e10);
                throw new IllegalArgumentException(e10.getMessage());
            } catch (IllegalAccessException e11) {
                logInfo(e11);
                throw new IllegalArgumentException(e11.getMessage());
            }
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("The bean of type: ");
            stringBuffer.append(this.bean.getClass().getName());
            stringBuffer.append(" has no property called: ");
            stringBuffer.append(obj);
            throw new IllegalArgumentException(stringBuffer.toString());
        }
    }

    public void putAllWriteable(BeanMap beanMap) {
        for (Object next : beanMap.readMethods.keySet()) {
            if (getWriteMethod(next) != null) {
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
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("BeanMap<");
        stringBuffer.append(String.valueOf(this.bean));
        stringBuffer.append(">");
        return stringBuffer.toString();
    }

    public Iterator valueIterator() {
        final Iterator keyIterator = keyIterator();
        return new Iterator() {
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

    public Collection values() {
        ArrayList arrayList = new ArrayList(this.readMethods.size());
        Iterator valueIterator = valueIterator();
        while (valueIterator.hasNext()) {
            arrayList.add(valueIterator.next());
        }
        return UnmodifiableList.decorate(arrayList);
    }

    /* access modifiers changed from: protected */
    public Method getReadMethod(Object obj) {
        return (Method) this.readMethods.get(obj);
    }

    /* access modifiers changed from: protected */
    public Method getWriteMethod(Object obj) {
        return (Method) this.writeMethods.get(obj);
    }

    public BeanMap(Object obj) {
        this.bean = obj;
        initialise();
    }
}

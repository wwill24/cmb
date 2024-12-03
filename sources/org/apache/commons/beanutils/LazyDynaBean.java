package org.apache.commons.beanutils;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LazyDynaBean implements DynaBean, Serializable {
    protected static final BigDecimal BigDecimal_ZERO = new BigDecimal("0");
    protected static final BigInteger BigInteger_ZERO = new BigInteger("0");
    protected static final Byte Byte_ZERO = new Byte((byte) 0);
    protected static final Character Character_SPACE = new Character(' ');
    protected static final Double Double_ZERO = new Double(0.0d);
    protected static final Float Float_ZERO = new Float(0.0f);
    protected static final Integer Integer_ZERO = new Integer(0);
    protected static final Long Long_ZERO = new Long(0);
    protected static final Short Short_ZERO = new Short(0);
    protected MutableDynaClass dynaClass;
    private transient Log logger;
    private transient Map<String, Object> mapDecorator;
    protected Map<String, Object> values;

    public LazyDynaBean() {
        this((DynaClass) new LazyDynaClass());
    }

    private Log logger() {
        if (this.logger == null) {
            this.logger = LogFactory.getLog(LazyDynaBean.class);
        }
        return this.logger;
    }

    public boolean contains(String str, String str2) {
        if (str != null) {
            Object obj = this.values.get(str);
            if (obj != null && (obj instanceof Map)) {
                return ((Map) obj).containsKey(str2);
            }
            return false;
        }
        throw new IllegalArgumentException("No property name specified");
    }

    /* access modifiers changed from: protected */
    public Object createDynaBeanProperty(String str, Class<?> cls) {
        try {
            return cls.newInstance();
        } catch (Exception e10) {
            if (!logger().isWarnEnabled()) {
                return null;
            }
            Log logger2 = logger();
            logger2.warn("Error instantiating DynaBean property of type '" + cls.getName() + "' for '" + str + "' " + e10);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public Object createIndexedProperty(String str, Class<?> cls) {
        if (cls == null) {
            return defaultIndexedProperty(str);
        }
        if (cls.isArray()) {
            return Array.newInstance(cls.getComponentType(), 0);
        }
        if (!List.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Non-indexed property of type '" + cls.getName() + "' for '" + str + "'");
        } else if (cls.isInterface()) {
            return defaultIndexedProperty(str);
        } else {
            try {
                return cls.newInstance();
            } catch (Exception e10) {
                throw new IllegalArgumentException("Error instantiating indexed property of type '" + cls.getName() + "' for '" + str + "' " + e10);
            }
        }
    }

    /* access modifiers changed from: protected */
    public Object createMappedProperty(String str, Class<?> cls) {
        if (cls == null) {
            return defaultMappedProperty(str);
        }
        if (cls.isInterface()) {
            return defaultMappedProperty(str);
        }
        if (Map.class.isAssignableFrom(cls)) {
            try {
                return cls.newInstance();
            } catch (Exception e10) {
                throw new IllegalArgumentException("Error instantiating mapped property of type '" + cls.getName() + "' for '" + str + "' " + e10);
            }
        } else {
            throw new IllegalArgumentException("Non-mapped property of type '" + cls.getName() + "' for '" + str + "'");
        }
    }

    /* access modifiers changed from: protected */
    public Object createNumberProperty(String str, Class<?> cls) {
        return null;
    }

    /* access modifiers changed from: protected */
    public Object createOtherProperty(String str, Class<?> cls) {
        if (!(cls == Object.class || cls == String.class || cls == Boolean.class || cls == Character.class || Date.class.isAssignableFrom(cls))) {
            try {
                return cls.newInstance();
            } catch (Exception e10) {
                if (logger().isWarnEnabled()) {
                    Log logger2 = logger();
                    logger2.warn("Error instantiating property of type '" + cls.getName() + "' for '" + str + "' " + e10);
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public Object createPrimitiveProperty(String str, Class<?> cls) {
        if (cls == Boolean.TYPE) {
            return Boolean.FALSE;
        }
        if (cls == Integer.TYPE) {
            return Integer_ZERO;
        }
        if (cls == Long.TYPE) {
            return Long_ZERO;
        }
        if (cls == Double.TYPE) {
            return Double_ZERO;
        }
        if (cls == Float.TYPE) {
            return Float_ZERO;
        }
        if (cls == Byte.TYPE) {
            return Byte_ZERO;
        }
        if (cls == Short.TYPE) {
            return Short_ZERO;
        }
        if (cls == Character.TYPE) {
            return Character_SPACE;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public Object createProperty(String str, Class<?> cls) {
        if (cls == null) {
            return null;
        }
        if (cls.isArray() || List.class.isAssignableFrom(cls)) {
            return createIndexedProperty(str, cls);
        }
        if (Map.class.isAssignableFrom(cls)) {
            return createMappedProperty(str, cls);
        }
        if (DynaBean.class.isAssignableFrom(cls)) {
            return createDynaBeanProperty(str, cls);
        }
        if (cls.isPrimitive()) {
            return createPrimitiveProperty(str, cls);
        }
        if (Number.class.isAssignableFrom(cls)) {
            return createNumberProperty(str, cls);
        }
        return createOtherProperty(str, cls);
    }

    /* access modifiers changed from: protected */
    public Object defaultIndexedProperty(String str) {
        return new ArrayList();
    }

    /* access modifiers changed from: protected */
    public Map<String, Object> defaultMappedProperty(String str) {
        return new HashMap();
    }

    public Object get(String str) {
        if (str != null) {
            Object obj = this.values.get(str);
            if (obj != null) {
                return obj;
            }
            if (!isDynaProperty(str)) {
                return null;
            }
            Object createProperty = createProperty(str, this.dynaClass.getDynaProperty(str).getType());
            if (createProperty != null) {
                set(str, createProperty);
            }
            return createProperty;
        }
        throw new IllegalArgumentException("No property name specified");
    }

    public DynaClass getDynaClass() {
        return this.dynaClass;
    }

    public Map<String, Object> getMap() {
        if (this.mapDecorator == null) {
            this.mapDecorator = new DynaBeanPropertyMapDecorator(this);
        }
        return this.mapDecorator;
    }

    /* access modifiers changed from: protected */
    public Object growIndexedProperty(String str, Object obj, int i10) {
        int length;
        if (obj instanceof List) {
            List list = (List) obj;
            while (i10 >= list.size()) {
                Class<?> contentType = getDynaClass().getDynaProperty(str).getContentType();
                Object obj2 = null;
                if (contentType != null) {
                    obj2 = createProperty(str + "[" + list.size() + "]", contentType);
                }
                list.add(obj2);
            }
        }
        if (!obj.getClass().isArray() || i10 < (length = Array.getLength(obj))) {
            return obj;
        }
        Class<?> componentType = obj.getClass().getComponentType();
        Object newInstance = Array.newInstance(componentType, i10 + 1);
        System.arraycopy(obj, 0, newInstance, 0, length);
        set(str, newInstance);
        int length2 = Array.getLength(newInstance);
        while (length < length2) {
            Array.set(newInstance, length, createProperty(str + "[" + length + "]", componentType));
            length++;
        }
        return newInstance;
    }

    /* access modifiers changed from: protected */
    public boolean isAssignable(Class<?> cls, Class<?> cls2) {
        if (cls.isAssignableFrom(cls2)) {
            return true;
        }
        if (cls == Boolean.TYPE && cls2 == Boolean.class) {
            return true;
        }
        if (cls == Byte.TYPE && cls2 == Byte.class) {
            return true;
        }
        if (cls == Character.TYPE && cls2 == Character.class) {
            return true;
        }
        if (cls == Double.TYPE && cls2 == Double.class) {
            return true;
        }
        if (cls == Float.TYPE && cls2 == Float.class) {
            return true;
        }
        if (cls == Integer.TYPE && cls2 == Integer.class) {
            return true;
        }
        if (cls == Long.TYPE && cls2 == Long.class) {
            return true;
        }
        return cls == Short.TYPE && cls2 == Short.class;
    }

    /* access modifiers changed from: protected */
    public boolean isDynaProperty(String str) {
        if (str != null) {
            MutableDynaClass mutableDynaClass = this.dynaClass;
            if (mutableDynaClass instanceof LazyDynaClass) {
                return ((LazyDynaClass) mutableDynaClass).isDynaProperty(str);
            }
            if (mutableDynaClass.getDynaProperty(str) == null) {
                return false;
            }
            return true;
        }
        throw new IllegalArgumentException("No property name specified");
    }

    /* access modifiers changed from: protected */
    public Map<String, Object> newMap() {
        return new HashMap();
    }

    public void remove(String str, String str2) {
        if (str != null) {
            Object obj = this.values.get(str);
            if (obj != null) {
                if (obj instanceof Map) {
                    ((Map) obj).remove(str2);
                    return;
                }
                throw new IllegalArgumentException("Non-mapped property for '" + str + "(" + str2 + ")'" + obj.getClass().getName());
            }
            return;
        }
        throw new IllegalArgumentException("No property name specified");
    }

    public void set(String str, Object obj) {
        if (!isDynaProperty(str)) {
            if (this.dynaClass.isRestricted()) {
                throw new IllegalArgumentException("Invalid property name '" + str + "' (DynaClass is restricted)");
            } else if (obj == null) {
                this.dynaClass.add(str);
            } else {
                this.dynaClass.add(str, obj.getClass());
            }
        }
        DynaProperty dynaProperty = this.dynaClass.getDynaProperty(str);
        if (obj == null) {
            if (dynaProperty.getType().isPrimitive()) {
                throw new NullPointerException("Primitive value for '" + str + "'");
            }
        } else if (!isAssignable(dynaProperty.getType(), obj.getClass())) {
            throw new ConversionException("Cannot assign value of type '" + obj.getClass().getName() + "' to property '" + str + "' of type '" + dynaProperty.getType().getName() + "'");
        }
        this.values.put(str, obj);
    }

    public int size(String str) {
        if (str != null) {
            Object obj = this.values.get(str);
            if (obj == null) {
                return 0;
            }
            if (obj instanceof Map) {
                return ((Map) obj).size();
            }
            if (obj instanceof List) {
                return ((List) obj).size();
            }
            if (obj.getClass().isArray()) {
                return Array.getLength(obj);
            }
            return 0;
        }
        throw new IllegalArgumentException("No property name specified");
    }

    public LazyDynaBean(String str) {
        this((DynaClass) new LazyDynaClass(str));
    }

    public LazyDynaBean(DynaClass dynaClass2) {
        this.logger = LogFactory.getLog(LazyDynaBean.class);
        this.values = newMap();
        if (dynaClass2 instanceof MutableDynaClass) {
            this.dynaClass = (MutableDynaClass) dynaClass2;
        } else {
            this.dynaClass = new LazyDynaClass(dynaClass2.getName(), dynaClass2.getDynaProperties());
        }
    }

    public Object get(String str, int i10) {
        if (!isDynaProperty(str)) {
            set(str, defaultIndexedProperty(str));
        }
        Object obj = get(str);
        if (this.dynaClass.getDynaProperty(str).isIndexed()) {
            Object growIndexedProperty = growIndexedProperty(str, obj, i10);
            if (growIndexedProperty.getClass().isArray()) {
                return Array.get(growIndexedProperty, i10);
            }
            if (growIndexedProperty instanceof List) {
                return ((List) growIndexedProperty).get(i10);
            }
            throw new IllegalArgumentException("Non-indexed property for '" + str + "[" + i10 + "]' " + growIndexedProperty.getClass().getName());
        }
        throw new IllegalArgumentException("Non-indexed property for '" + str + "[" + i10 + "]' " + this.dynaClass.getDynaProperty(str).getName());
    }

    public void set(String str, int i10, Object obj) {
        if (!isDynaProperty(str)) {
            set(str, defaultIndexedProperty(str));
        }
        Object obj2 = get(str);
        if (this.dynaClass.getDynaProperty(str).isIndexed()) {
            Object growIndexedProperty = growIndexedProperty(str, obj2, i10);
            if (growIndexedProperty.getClass().isArray()) {
                Array.set(growIndexedProperty, i10, obj);
            } else if (growIndexedProperty instanceof List) {
                ((List) growIndexedProperty).set(i10, obj);
            } else {
                throw new IllegalArgumentException("Non-indexed property for '" + str + "[" + i10 + "]' " + growIndexedProperty.getClass().getName());
            }
        } else {
            throw new IllegalArgumentException("Non-indexed property for '" + str + "[" + i10 + "]'" + this.dynaClass.getDynaProperty(str).getType().getName());
        }
    }

    public Object get(String str, String str2) {
        if (!isDynaProperty(str)) {
            set(str, defaultMappedProperty(str));
        }
        Object obj = get(str);
        if (!this.dynaClass.getDynaProperty(str).isMapped()) {
            throw new IllegalArgumentException("Non-mapped property for '" + str + "(" + str2 + ")' " + this.dynaClass.getDynaProperty(str).getType().getName());
        } else if (obj instanceof Map) {
            return ((Map) obj).get(str2);
        } else {
            throw new IllegalArgumentException("Non-mapped property for '" + str + "(" + str2 + ")'" + obj.getClass().getName());
        }
    }

    public void set(String str, String str2, Object obj) {
        if (!isDynaProperty(str)) {
            set(str, defaultMappedProperty(str));
        }
        Object obj2 = get(str);
        if (this.dynaClass.getDynaProperty(str).isMapped()) {
            ((Map) obj2).put(str2, obj);
            return;
        }
        throw new IllegalArgumentException("Non-mapped property for '" + str + "(" + str2 + ")'" + this.dynaClass.getDynaProperty(str).getType().getName());
    }
}

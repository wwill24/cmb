package org.apache.commons.beanutils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class LazyDynaList extends ArrayList<Object> {
    private Class<?> elementDynaBeanType;
    private DynaClass elementDynaClass;
    private Class<?> elementType;
    private transient WrapDynaClass wrapDynaClass;

    public LazyDynaList() {
    }

    private LazyDynaMap createDynaBeanForMapProperty(Object obj) {
        return new LazyDynaMap((Map<String, Object>) (Map) obj);
    }

    private DynaClass getDynaClass() {
        DynaClass dynaClass = this.elementDynaClass;
        return dynaClass == null ? this.wrapDynaClass : dynaClass;
    }

    private void growList(int i10) {
        if (i10 >= size()) {
            ensureCapacity(i10 + 1);
            for (int size = size(); size < i10; size++) {
                super.add(transform((Object) null));
            }
        }
    }

    private DynaBean transform(Object obj) {
        DynaBean dynaBean;
        Class<?> cls;
        if (obj == null) {
            if (this.elementType == null) {
                setElementDynaClass(new LazyDynaClass());
            }
            if (getDynaClass() == null) {
                setElementType(this.elementType);
            }
            try {
                dynaBean = getDynaClass().newInstance();
                cls = dynaBean.getClass();
            } catch (Exception e10) {
                throw new IllegalArgumentException("Error creating DynaBean: " + getDynaClass().getClass().getName() + " - " + e10);
            }
        } else {
            if (Map.class.isAssignableFrom(obj.getClass())) {
                dynaBean = createDynaBeanForMapProperty(obj);
            } else if (DynaBean.class.isAssignableFrom(obj.getClass())) {
                dynaBean = (DynaBean) obj;
            } else {
                dynaBean = new WrapDynaBean(obj);
            }
            cls = dynaBean.getClass();
        }
        Class<?> cls2 = dynaBean.getClass();
        if (WrapDynaBean.class.isAssignableFrom(cls)) {
            cls2 = ((WrapDynaBean) dynaBean).getInstance().getClass();
        } else if (LazyDynaMap.class.isAssignableFrom(cls)) {
            cls2 = ((LazyDynaMap) dynaBean).getMap().getClass();
        }
        Class<?> cls3 = this.elementType;
        if (cls3 == null || cls2.equals(cls3)) {
            return dynaBean;
        }
        throw new IllegalArgumentException("Element Type " + cls2 + " doesn't match other elements " + this.elementType);
    }

    public void add(int i10, Object obj) {
        DynaBean transform = transform(obj);
        growList(i10);
        super.add(i10, transform);
    }

    public boolean addAll(Collection<?> collection) {
        if (collection == null || collection.size() == 0) {
            return false;
        }
        ensureCapacity(size() + collection.size());
        for (Object add : collection) {
            add(add);
        }
        return true;
    }

    public Object get(int i10) {
        growList(i10 + 1);
        return super.get(i10);
    }

    public Object set(int i10, Object obj) {
        DynaBean transform = transform(obj);
        growList(i10 + 1);
        return super.set(i10, transform);
    }

    public void setElementDynaClass(DynaClass dynaClass) {
        if (dynaClass == null) {
            throw new IllegalArgumentException("Element DynaClass is missing");
        } else if (size() <= 0) {
            try {
                DynaBean newInstance = dynaClass.newInstance();
                Class<?> cls = newInstance.getClass();
                this.elementDynaBeanType = cls;
                if (WrapDynaBean.class.isAssignableFrom(cls)) {
                    this.elementType = ((WrapDynaBean) newInstance).getInstance().getClass();
                    this.wrapDynaClass = (WrapDynaClass) dynaClass;
                } else if (LazyDynaMap.class.isAssignableFrom(this.elementDynaBeanType)) {
                    this.elementType = ((LazyDynaMap) newInstance).getMap().getClass();
                    this.elementDynaClass = dynaClass;
                } else {
                    this.elementType = newInstance.getClass();
                    this.elementDynaClass = dynaClass;
                }
            } catch (Exception e10) {
                throw new IllegalArgumentException("Error creating DynaBean from " + dynaClass.getClass().getName() + " - " + e10);
            }
        } else {
            throw new IllegalStateException("Element DynaClass cannot be reset");
        }
    }

    public void setElementType(Class<?> cls) {
        boolean z10;
        DynaBean dynaBean;
        if (cls != null) {
            Class<?> cls2 = this.elementType;
            if (cls2 == null || cls2.equals(cls)) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (!z10 || size() <= 0) {
                this.elementType = cls;
                try {
                    Object newInstance = cls.newInstance();
                    if (Map.class.isAssignableFrom(cls)) {
                        dynaBean = createDynaBeanForMapProperty(newInstance);
                        this.elementDynaClass = dynaBean.getDynaClass();
                    } else if (DynaBean.class.isAssignableFrom(cls)) {
                        dynaBean = (DynaBean) newInstance;
                        this.elementDynaClass = dynaBean.getDynaClass();
                    } else {
                        dynaBean = new WrapDynaBean(newInstance);
                        this.wrapDynaClass = (WrapDynaClass) dynaBean.getDynaClass();
                    }
                    Class<?> cls3 = dynaBean.getClass();
                    this.elementDynaBeanType = cls3;
                    if (WrapDynaBean.class.isAssignableFrom(cls3)) {
                        this.elementType = ((WrapDynaBean) dynaBean).getInstance().getClass();
                    } else if (LazyDynaMap.class.isAssignableFrom(this.elementDynaBeanType)) {
                        this.elementType = ((LazyDynaMap) dynaBean).getMap().getClass();
                    }
                } catch (Exception e10) {
                    throw new IllegalArgumentException("Error creating type: " + cls.getName() + " - " + e10);
                }
            } else {
                throw new IllegalStateException("Element Type cannot be reset");
            }
        } else {
            throw new IllegalArgumentException("Element Type is missing");
        }
    }

    public Object[] toArray() {
        if (size() == 0 && this.elementType == null) {
            return new LazyDynaBean[0];
        }
        Object[] objArr = (Object[]) Array.newInstance(this.elementType, size());
        for (int i10 = 0; i10 < size(); i10++) {
            if (Map.class.isAssignableFrom(this.elementType)) {
                objArr[i10] = ((LazyDynaMap) get(i10)).getMap();
            } else if (DynaBean.class.isAssignableFrom(this.elementType)) {
                objArr[i10] = get(i10);
            } else {
                objArr[i10] = ((WrapDynaBean) get(i10)).getInstance();
            }
        }
        return objArr;
    }

    public DynaBean[] toDynaBeanArray() {
        if (size() == 0 && this.elementDynaBeanType == null) {
            return new LazyDynaBean[0];
        }
        DynaBean[] dynaBeanArr = (DynaBean[]) Array.newInstance(this.elementDynaBeanType, size());
        for (int i10 = 0; i10 < size(); i10++) {
            dynaBeanArr[i10] = (DynaBean) get(i10);
        }
        return dynaBeanArr;
    }

    public LazyDynaList(int i10) {
        super(i10);
    }

    public LazyDynaList(DynaClass dynaClass) {
        setElementDynaClass(dynaClass);
    }

    public boolean add(Object obj) {
        return super.add(transform(obj));
    }

    public LazyDynaList(Class<?> cls) {
        setElementType(cls);
    }

    public boolean addAll(int i10, Collection<?> collection) {
        if (collection == null || collection.size() == 0) {
            return false;
        }
        ensureCapacity((i10 > size() ? i10 : size()) + collection.size());
        if (size() == 0) {
            transform(collection.iterator().next());
        }
        growList(i10);
        for (Object add : collection) {
            add(i10, add);
            i10++;
        }
        return true;
    }

    public LazyDynaList(Collection<?> collection) {
        super(collection.size());
        addAll(collection);
    }

    public LazyDynaList(Object[] objArr) {
        super(objArr.length);
        for (Object add : objArr) {
            add(add);
        }
    }

    public <T> T[] toArray(T[] tArr) {
        Object obj;
        Class<DynaBean> cls = DynaBean.class;
        Class<?> componentType = tArr.getClass().getComponentType();
        if (cls.isAssignableFrom(componentType) || (size() == 0 && this.elementType == null)) {
            return super.toArray(tArr);
        }
        if (componentType.isAssignableFrom(this.elementType)) {
            if (tArr.length < size()) {
                tArr = (Object[]) Array.newInstance(componentType, size());
            }
            for (int i10 = 0; i10 < size(); i10++) {
                if (Map.class.isAssignableFrom(this.elementType)) {
                    obj = ((LazyDynaMap) get(i10)).getMap();
                } else if (cls.isAssignableFrom(this.elementType)) {
                    obj = get(i10);
                } else {
                    obj = ((WrapDynaBean) get(i10)).getInstance();
                }
                Array.set(tArr, i10, obj);
            }
            return tArr;
        }
        throw new IllegalArgumentException("Invalid array type: " + componentType.getName() + " - not compatible with '" + this.elementType.getName());
    }
}

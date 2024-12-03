package org.apache.commons.beanutils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;
import org.apache.commons.collections.comparators.ComparableComparator;

public class BeanComparator<T> implements Comparator<T>, Serializable {
    private final Comparator<?> comparator;
    private String property;

    public BeanComparator() {
        this((String) null);
    }

    private int internalCompare(Object obj, Object obj2) {
        return this.comparator.compare(obj, obj2);
    }

    public int compare(T t10, T t11) {
        String str = this.property;
        if (str == null) {
            return internalCompare(t10, t11);
        }
        try {
            return internalCompare(PropertyUtils.getProperty(t10, str), PropertyUtils.getProperty(t11, this.property));
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("IllegalAccessException: " + e10.toString());
        } catch (InvocationTargetException e11) {
            throw new RuntimeException("InvocationTargetException: " + e11.toString());
        } catch (NoSuchMethodException e12) {
            throw new RuntimeException("NoSuchMethodException: " + e12.toString());
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BeanComparator)) {
            return false;
        }
        BeanComparator beanComparator = (BeanComparator) obj;
        if (!this.comparator.equals(beanComparator.comparator)) {
            return false;
        }
        String str = this.property;
        if (str != null) {
            if (!str.equals(beanComparator.property)) {
                return false;
            }
            return true;
        } else if (beanComparator.property == null) {
            return true;
        } else {
            return false;
        }
    }

    public Comparator<?> getComparator() {
        return this.comparator;
    }

    public String getProperty() {
        return this.property;
    }

    public int hashCode() {
        return this.comparator.hashCode();
    }

    public void setProperty(String str) {
        this.property = str;
    }

    public BeanComparator(String str) {
        this(str, ComparableComparator.getInstance());
    }

    public BeanComparator(String str, Comparator<?> comparator2) {
        setProperty(str);
        if (comparator2 != null) {
            this.comparator = comparator2;
        } else {
            this.comparator = ComparableComparator.getInstance();
        }
    }
}

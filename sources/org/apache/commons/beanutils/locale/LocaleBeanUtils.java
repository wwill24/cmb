package org.apache.commons.beanutils.locale;

import java.lang.reflect.InvocationTargetException;
import java.util.Locale;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.locale.LocaleBeanUtilsBean;

public class LocaleBeanUtils extends BeanUtils {

    @Deprecated
    protected static class Descriptor {
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

    @Deprecated
    protected static Descriptor calculate(Object obj, String str) throws IllegalAccessException, InvocationTargetException {
        LocaleBeanUtilsBean.Descriptor calculate = LocaleBeanUtilsBean.getLocaleBeanUtilsInstance().calculate(obj, str);
        return new Descriptor(calculate.getTarget(), calculate.getName(), calculate.getPropName(), calculate.getKey(), calculate.getIndex());
    }

    protected static Object convert(Class<?> cls, int i10, Object obj, String str) {
        return LocaleBeanUtilsBean.getLocaleBeanUtilsInstance().convert(cls, i10, obj, str);
    }

    protected static Class<?> definePropertyType(Object obj, String str, String str2) throws IllegalAccessException, InvocationTargetException {
        return LocaleBeanUtilsBean.getLocaleBeanUtilsInstance().definePropertyType(obj, str, str2);
    }

    public static boolean getApplyLocalized() {
        return LocaleBeanUtilsBean.getLocaleBeanUtilsInstance().getApplyLocalized();
    }

    public static Locale getDefaultLocale() {
        return LocaleBeanUtilsBean.getLocaleBeanUtilsInstance().getDefaultLocale();
    }

    public static String getIndexedProperty(Object obj, String str, String str2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return LocaleBeanUtilsBean.getLocaleBeanUtilsInstance().getIndexedProperty(obj, str, str2);
    }

    public static String getMappedProperty(Object obj, String str, String str2, String str3) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return LocaleBeanUtilsBean.getLocaleBeanUtilsInstance().getMappedProperty(obj, str, str2, str3);
    }

    public static String getMappedPropertyLocale(Object obj, String str, String str2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return LocaleBeanUtilsBean.getLocaleBeanUtilsInstance().getMappedPropertyLocale(obj, str, str2);
    }

    public static String getNestedProperty(Object obj, String str, String str2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return LocaleBeanUtilsBean.getLocaleBeanUtilsInstance().getNestedProperty(obj, str, str2);
    }

    public static String getProperty(Object obj, String str, String str2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return LocaleBeanUtilsBean.getLocaleBeanUtilsInstance().getProperty(obj, str, str2);
    }

    public static String getSimpleProperty(Object obj, String str, String str2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return LocaleBeanUtilsBean.getLocaleBeanUtilsInstance().getSimpleProperty(obj, str, str2);
    }

    protected static void invokeSetter(Object obj, String str, String str2, int i10, Object obj2) throws IllegalAccessException, InvocationTargetException {
        LocaleBeanUtilsBean.getLocaleBeanUtilsInstance().invokeSetter(obj, str, str2, i10, obj2);
    }

    public static void setApplyLocalized(boolean z10) {
        LocaleBeanUtilsBean.getLocaleBeanUtilsInstance().setApplyLocalized(z10);
    }

    public static void setDefaultLocale(Locale locale) {
        LocaleBeanUtilsBean.getLocaleBeanUtilsInstance().setDefaultLocale(locale);
    }

    public static void setProperty(Object obj, String str, Object obj2) throws IllegalAccessException, InvocationTargetException {
        LocaleBeanUtilsBean.getLocaleBeanUtilsInstance().setProperty(obj, str, obj2);
    }

    protected static Object convert(Class<?> cls, int i10, Object obj) {
        return LocaleBeanUtilsBean.getLocaleBeanUtilsInstance().convert(cls, i10, obj);
    }

    public static String getIndexedProperty(Object obj, String str) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return LocaleBeanUtilsBean.getLocaleBeanUtilsInstance().getIndexedProperty(obj, str);
    }

    public static String getMappedProperty(Object obj, String str, String str2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return LocaleBeanUtilsBean.getLocaleBeanUtilsInstance().getMappedProperty(obj, str, str2);
    }

    public static String getNestedProperty(Object obj, String str) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return LocaleBeanUtilsBean.getLocaleBeanUtilsInstance().getNestedProperty(obj, str);
    }

    public static String getProperty(Object obj, String str) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return LocaleBeanUtilsBean.getLocaleBeanUtilsInstance().getProperty(obj, str);
    }

    public static String getSimpleProperty(Object obj, String str) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return LocaleBeanUtilsBean.getLocaleBeanUtilsInstance().getSimpleProperty(obj, str);
    }

    public static void setProperty(Object obj, String str, Object obj2, String str2) throws IllegalAccessException, InvocationTargetException {
        LocaleBeanUtilsBean.getLocaleBeanUtilsInstance().setProperty(obj, str, obj2, str2);
    }

    public static String getIndexedProperty(Object obj, String str, int i10, String str2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return LocaleBeanUtilsBean.getLocaleBeanUtilsInstance().getIndexedProperty(obj, str, i10, str2);
    }

    public static String getMappedProperty(Object obj, String str) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return LocaleBeanUtilsBean.getLocaleBeanUtilsInstance().getMappedProperty(obj, str);
    }

    public static String getIndexedProperty(Object obj, String str, int i10) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return LocaleBeanUtilsBean.getLocaleBeanUtilsInstance().getIndexedProperty(obj, str, i10);
    }
}

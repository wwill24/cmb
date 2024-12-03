package org.apache.commons.beanutils;

public class ConvertUtilsBean2 extends ConvertUtilsBean {
    public String convert(Object obj) {
        return (String) convert(obj, (Class<?>) String.class);
    }

    public Object convert(String str, Class<?> cls) {
        return convert((Object) str, cls);
    }

    public Object convert(String[] strArr, Class<?> cls) {
        return convert((Object) strArr, cls);
    }
}

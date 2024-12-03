package org.apache.commons.beanutils;

public class BeanUtilsBean2 extends BeanUtilsBean {
    public BeanUtilsBean2() {
        super(new ConvertUtilsBean2());
    }

    /* access modifiers changed from: protected */
    public Object convert(Object obj, Class<?> cls) {
        return getConvertUtils().convert(obj, cls);
    }
}

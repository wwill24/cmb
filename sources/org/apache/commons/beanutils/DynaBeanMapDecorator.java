package org.apache.commons.beanutils;

@Deprecated
public class DynaBeanMapDecorator extends BaseDynaBeanMapDecorator<Object> {
    public DynaBeanMapDecorator(DynaBean dynaBean, boolean z10) {
        super(dynaBean, z10);
    }

    /* access modifiers changed from: protected */
    public Object convertKey(String str) {
        return str;
    }

    public DynaBeanMapDecorator(DynaBean dynaBean) {
        super(dynaBean);
    }
}

package org.apache.commons.beanutils;

public class DynaBeanPropertyMapDecorator extends BaseDynaBeanMapDecorator<String> {
    public DynaBeanPropertyMapDecorator(DynaBean dynaBean, boolean z10) {
        super(dynaBean, z10);
    }

    /* access modifiers changed from: protected */
    public String convertKey(String str) {
        return str;
    }

    public DynaBeanPropertyMapDecorator(DynaBean dynaBean) {
        super(dynaBean);
    }
}

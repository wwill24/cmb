package org.apache.commons.beanutils;

public interface MutableDynaClass extends DynaClass {
    void add(String str);

    void add(String str, Class<?> cls);

    void add(String str, Class<?> cls, boolean z10, boolean z11);

    boolean isRestricted();

    void remove(String str);

    void setRestricted(boolean z10);
}

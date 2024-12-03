package org.apache.commons.beanutils;

public interface DynaBean {
    boolean contains(String str, String str2);

    Object get(String str);

    Object get(String str, int i10);

    Object get(String str, String str2);

    DynaClass getDynaClass();

    void remove(String str, String str2);

    void set(String str, int i10, Object obj);

    void set(String str, Object obj);

    void set(String str, String str2, Object obj);
}

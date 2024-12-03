package org.apache.commons.beanutils;

public interface DynaClass {
    DynaProperty[] getDynaProperties();

    DynaProperty getDynaProperty(String str);

    String getName();

    DynaBean newInstance() throws IllegalAccessException, InstantiationException;
}

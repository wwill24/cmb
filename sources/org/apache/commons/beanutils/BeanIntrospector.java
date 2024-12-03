package org.apache.commons.beanutils;

import java.beans.IntrospectionException;

public interface BeanIntrospector {
    void introspect(IntrospectionContext introspectionContext) throws IntrospectionException;
}

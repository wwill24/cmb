package org.apache.commons.beanutils;

import java.beans.IntrospectionException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SuppressPropertiesBeanIntrospector implements BeanIntrospector {
    public static final SuppressPropertiesBeanIntrospector SUPPRESS_CLASS = new SuppressPropertiesBeanIntrospector(Collections.singleton("class"));
    private final Set<String> propertyNames;

    public SuppressPropertiesBeanIntrospector(Collection<String> collection) {
        if (collection != null) {
            this.propertyNames = Collections.unmodifiableSet(new HashSet(collection));
            return;
        }
        throw new IllegalArgumentException("Property names must not be null!");
    }

    public Set<String> getSuppressedProperties() {
        return this.propertyNames;
    }

    public void introspect(IntrospectionContext introspectionContext) throws IntrospectionException {
        for (String removePropertyDescriptor : getSuppressedProperties()) {
            introspectionContext.removePropertyDescriptor(removePropertyDescriptor);
        }
    }
}

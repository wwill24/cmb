package org.apache.commons.beanutils;

import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class DefaultIntrospectionContext implements IntrospectionContext {
    private static final PropertyDescriptor[] EMPTY_DESCRIPTORS = new PropertyDescriptor[0];
    private final Class<?> currentClass;
    private final Map<String, PropertyDescriptor> descriptors = new HashMap();

    public DefaultIntrospectionContext(Class<?> cls) {
        this.currentClass = cls;
    }

    public void addPropertyDescriptor(PropertyDescriptor propertyDescriptor) {
        if (propertyDescriptor != null) {
            this.descriptors.put(propertyDescriptor.getName(), propertyDescriptor);
            return;
        }
        throw new IllegalArgumentException("Property descriptor must not be null!");
    }

    public void addPropertyDescriptors(PropertyDescriptor[] propertyDescriptorArr) {
        if (propertyDescriptorArr != null) {
            for (PropertyDescriptor addPropertyDescriptor : propertyDescriptorArr) {
                addPropertyDescriptor(addPropertyDescriptor);
            }
            return;
        }
        throw new IllegalArgumentException("Array with descriptors must not be null!");
    }

    public PropertyDescriptor getPropertyDescriptor(String str) {
        return this.descriptors.get(str);
    }

    public PropertyDescriptor[] getPropertyDescriptors() {
        return (PropertyDescriptor[]) this.descriptors.values().toArray(EMPTY_DESCRIPTORS);
    }

    public Class<?> getTargetClass() {
        return this.currentClass;
    }

    public boolean hasProperty(String str) {
        return this.descriptors.containsKey(str);
    }

    public Set<String> propertyNames() {
        return this.descriptors.keySet();
    }

    public void removePropertyDescriptor(String str) {
        this.descriptors.remove(str);
    }
}

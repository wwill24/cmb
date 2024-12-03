package org.apache.commons.beanutils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Locale;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FluentPropertyBeanIntrospector implements BeanIntrospector {
    public static final String DEFAULT_WRITE_METHOD_PREFIX = "set";
    private final Log log;
    private final String writeMethodPrefix;

    public FluentPropertyBeanIntrospector(String str) {
        this.log = LogFactory.getLog(getClass());
        if (str != null) {
            this.writeMethodPrefix = str;
            return;
        }
        throw new IllegalArgumentException("Prefix for write methods must not be null!");
    }

    private PropertyDescriptor createFluentPropertyDescritor(Method method, String str) throws IntrospectionException {
        return new PropertyDescriptor(propertyName(method), (Method) null, method);
    }

    private String propertyName(Method method) {
        String substring = method.getName().substring(getWriteMethodPrefix().length());
        if (substring.length() <= 1) {
            return substring.toLowerCase(Locale.ENGLISH);
        }
        return Character.toLowerCase(substring.charAt(0)) + substring.substring(1);
    }

    public String getWriteMethodPrefix() {
        return this.writeMethodPrefix;
    }

    public void introspect(IntrospectionContext introspectionContext) throws IntrospectionException {
        for (Method method : introspectionContext.getTargetClass().getMethods()) {
            if (method.getName().startsWith(getWriteMethodPrefix())) {
                String propertyName = propertyName(method);
                PropertyDescriptor propertyDescriptor = introspectionContext.getPropertyDescriptor(propertyName);
                if (propertyDescriptor == null) {
                    try {
                        introspectionContext.addPropertyDescriptor(createFluentPropertyDescritor(method, propertyName));
                    } catch (IntrospectionException e10) {
                        this.log.warn("Error when creating PropertyDescriptor for " + method + "! Ignoring this property.", e10);
                    }
                } else if (propertyDescriptor.getWriteMethod() == null) {
                    propertyDescriptor.setWriteMethod(method);
                }
            }
        }
    }

    public FluentPropertyBeanIntrospector() {
        this("set");
    }
}

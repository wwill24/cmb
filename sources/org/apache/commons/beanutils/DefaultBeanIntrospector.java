package org.apache.commons.beanutils;

import java.beans.IndexedPropertyDescriptor;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DefaultBeanIntrospector implements BeanIntrospector {
    private static final Class<?>[] EMPTY_CLASS_PARAMETERS = new Class[0];
    public static final BeanIntrospector INSTANCE = new DefaultBeanIntrospector();
    private static final Class<?>[] LIST_CLASS_PARAMETER = {List.class};
    private final Log log = LogFactory.getLog(getClass());

    private DefaultBeanIntrospector() {
    }

    private void handleIndexedPropertyDescriptors(Class<?> cls, PropertyDescriptor[] propertyDescriptorArr) {
        String str;
        String str2;
        for (IndexedPropertyDescriptor indexedPropertyDescriptor : propertyDescriptorArr) {
            if (indexedPropertyDescriptor instanceof IndexedPropertyDescriptor) {
                IndexedPropertyDescriptor indexedPropertyDescriptor2 = indexedPropertyDescriptor;
                String str3 = indexedPropertyDescriptor2.getName().substring(0, 1).toUpperCase() + indexedPropertyDescriptor2.getName().substring(1);
                if (indexedPropertyDescriptor2.getReadMethod() == null) {
                    if (indexedPropertyDescriptor2.getIndexedReadMethod() != null) {
                        str2 = indexedPropertyDescriptor2.getIndexedReadMethod().getName();
                    } else {
                        str2 = "get" + str3;
                    }
                    Method matchingAccessibleMethod = MethodUtils.getMatchingAccessibleMethod(cls, str2, EMPTY_CLASS_PARAMETERS);
                    if (matchingAccessibleMethod != null) {
                        try {
                            indexedPropertyDescriptor2.setReadMethod(matchingAccessibleMethod);
                        } catch (Exception e10) {
                            this.log.error("Error setting indexed property read method", e10);
                        }
                    }
                }
                if (indexedPropertyDescriptor2.getWriteMethod() == null) {
                    if (indexedPropertyDescriptor2.getIndexedWriteMethod() != null) {
                        str = indexedPropertyDescriptor2.getIndexedWriteMethod().getName();
                    } else {
                        str = "set" + str3;
                    }
                    Method matchingAccessibleMethod2 = MethodUtils.getMatchingAccessibleMethod(cls, str, LIST_CLASS_PARAMETER);
                    if (matchingAccessibleMethod2 == null) {
                        Method[] methods = cls.getMethods();
                        int length = methods.length;
                        int i10 = 0;
                        while (true) {
                            if (i10 >= length) {
                                break;
                            }
                            Method method = methods[i10];
                            if (method.getName().equals(str)) {
                                Class[] parameterTypes = method.getParameterTypes();
                                if (parameterTypes.length == 1 && List.class.isAssignableFrom(parameterTypes[0])) {
                                    matchingAccessibleMethod2 = method;
                                    break;
                                }
                            }
                            i10++;
                        }
                    }
                    if (matchingAccessibleMethod2 != null) {
                        try {
                            indexedPropertyDescriptor2.setWriteMethod(matchingAccessibleMethod2);
                        } catch (Exception e11) {
                            this.log.error("Error setting indexed property write method", e11);
                        }
                    }
                }
            }
        }
    }

    public void introspect(IntrospectionContext introspectionContext) {
        try {
            PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(introspectionContext.getTargetClass()).getPropertyDescriptors();
            if (propertyDescriptors == null) {
                propertyDescriptors = new PropertyDescriptor[0];
            }
            handleIndexedPropertyDescriptors(introspectionContext.getTargetClass(), propertyDescriptors);
            introspectionContext.addPropertyDescriptors(propertyDescriptors);
        } catch (IntrospectionException e10) {
            Log log2 = this.log;
            log2.error("Error when inspecting class " + introspectionContext.getTargetClass(), e10);
        }
    }
}

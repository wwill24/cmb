package net.bytebuddy.utility;

import java.lang.reflect.Method;
import java.util.Comparator;

public enum MethodComparator implements Comparator<Method> {
    INSTANCE;

    public int compare(Method method, Method method2) {
        if (method == method2) {
            return 0;
        }
        int compareTo = method.getName().compareTo(method2.getName());
        if (compareTo != 0) {
            return compareTo;
        }
        Class[] parameterTypes = method.getParameterTypes();
        Class[] parameterTypes2 = method2.getParameterTypes();
        if (parameterTypes.length < parameterTypes2.length) {
            return -1;
        }
        if (parameterTypes.length > parameterTypes2.length) {
            return 1;
        }
        for (int i10 = 0; i10 < parameterTypes.length; i10++) {
            int compareTo2 = parameterTypes[i10].getName().compareTo(parameterTypes2[i10].getName());
            if (compareTo2 != 0) {
                return compareTo2;
            }
        }
        return method.getReturnType().getName().compareTo(method2.getReturnType().getName());
    }
}

package net.bytebuddy.utility;

import java.lang.reflect.Constructor;
import java.util.Comparator;

public enum ConstructorComparator implements Comparator<Constructor<?>> {
    INSTANCE;

    public int compare(Constructor<?> constructor, Constructor<?> constructor2) {
        if (constructor == constructor2) {
            return 0;
        }
        int compareTo = constructor.getName().compareTo(constructor2.getName());
        if (compareTo != 0) {
            return compareTo;
        }
        Class[] parameterTypes = constructor.getParameterTypes();
        Class[] parameterTypes2 = constructor2.getParameterTypes();
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
        return 0;
    }
}

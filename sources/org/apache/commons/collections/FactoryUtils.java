package org.apache.commons.collections;

import org.apache.commons.collections.functors.ConstantFactory;
import org.apache.commons.collections.functors.ExceptionFactory;
import org.apache.commons.collections.functors.InstantiateFactory;
import org.apache.commons.collections.functors.PrototypeFactory;

public class FactoryUtils {
    public static Factory constantFactory(Object obj) {
        return ConstantFactory.getInstance(obj);
    }

    public static Factory exceptionFactory() {
        return ExceptionFactory.INSTANCE;
    }

    public static Factory instantiateFactory(Class cls) {
        return InstantiateFactory.getInstance(cls, (Class[]) null, (Object[]) null);
    }

    public static Factory nullFactory() {
        return ConstantFactory.NULL_INSTANCE;
    }

    public static Factory prototypeFactory(Object obj) {
        return PrototypeFactory.getInstance(obj);
    }

    public static Factory instantiateFactory(Class cls, Class[] clsArr, Object[] objArr) {
        return InstantiateFactory.getInstance(cls, clsArr, objArr);
    }
}

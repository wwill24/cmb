package org.apache.commons.beanutils.converters;

public final class ClassConverter extends AbstractConverter {
    public ClassConverter() {
    }

    /* access modifiers changed from: protected */
    public String convertToString(Object obj) {
        return obj instanceof Class ? ((Class) obj).getName() : obj.toString();
    }

    /* access modifiers changed from: protected */
    public <T> T convertToType(Class<T> cls, Object obj) throws Throwable {
        if (Class.class.equals(cls)) {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader != null) {
                try {
                    return cls.cast(contextClassLoader.loadClass(obj.toString()));
                } catch (ClassNotFoundException unused) {
                }
            }
            return cls.cast(ClassConverter.class.getClassLoader().loadClass(obj.toString()));
        }
        throw conversionException(cls, obj);
    }

    /* access modifiers changed from: protected */
    public Class<?> getDefaultType() {
        return Class.class;
    }

    public ClassConverter(Object obj) {
        super(obj);
    }
}

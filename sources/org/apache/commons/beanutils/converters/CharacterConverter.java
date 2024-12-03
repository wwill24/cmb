package org.apache.commons.beanutils.converters;

public final class CharacterConverter extends AbstractConverter {
    public CharacterConverter() {
    }

    /* access modifiers changed from: protected */
    public String convertToString(Object obj) {
        String obj2 = obj.toString();
        if (obj2.length() == 0) {
            return "";
        }
        return obj2.substring(0, 1);
    }

    /* access modifiers changed from: protected */
    public <T> T convertToType(Class<T> cls, Object obj) throws Exception {
        if (Character.class.equals(cls) || Character.TYPE.equals(cls)) {
            return cls.cast(new Character(obj.toString().charAt(0)));
        }
        throw conversionException(cls, obj);
    }

    /* access modifiers changed from: protected */
    public Class<?> getDefaultType() {
        return Character.class;
    }

    public CharacterConverter(Object obj) {
        super(obj);
    }
}

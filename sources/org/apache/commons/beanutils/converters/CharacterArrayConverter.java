package org.apache.commons.beanutils.converters;

import java.util.List;
import org.apache.commons.beanutils.ConversionException;

@Deprecated
public final class CharacterArrayConverter extends AbstractArrayConverter {
    private static final char[] MODEL = new char[0];

    public CharacterArrayConverter() {
        this.defaultValue = null;
        this.useDefault = false;
    }

    public Object convert(Class cls, Object obj) {
        if (obj == null) {
            if (this.useDefault) {
                return this.defaultValue;
            }
            throw new ConversionException("No value specified");
        } else if (MODEL.getClass() == obj.getClass()) {
            return obj;
        } else {
            if (AbstractArrayConverter.strings.getClass() == obj.getClass()) {
                try {
                    String[] strArr = (String[]) obj;
                    char[] cArr = new char[strArr.length];
                    for (int i10 = 0; i10 < strArr.length; i10++) {
                        cArr[i10] = strArr[i10].charAt(0);
                    }
                    return cArr;
                } catch (Exception e10) {
                    if (this.useDefault) {
                        return this.defaultValue;
                    }
                    throw new ConversionException(obj.toString(), e10);
                }
            } else {
                try {
                    List parseElements = parseElements(obj.toString());
                    int size = parseElements.size();
                    char[] cArr2 = new char[size];
                    for (int i11 = 0; i11 < size; i11++) {
                        cArr2[i11] = ((String) parseElements.get(i11)).charAt(0);
                    }
                    return cArr2;
                } catch (Exception e11) {
                    if (this.useDefault) {
                        return this.defaultValue;
                    }
                    throw new ConversionException(obj.toString(), e11);
                }
            }
        }
    }

    public CharacterArrayConverter(Object obj) {
        this.defaultValue = obj;
        this.useDefault = true;
    }
}

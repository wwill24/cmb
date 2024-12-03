package org.apache.commons.beanutils.converters;

import java.util.List;
import org.apache.commons.beanutils.ConversionException;

@Deprecated
public final class ShortArrayConverter extends AbstractArrayConverter {
    private static final short[] MODEL = new short[0];

    public ShortArrayConverter() {
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
            int i10 = 0;
            if (AbstractArrayConverter.strings.getClass() == obj.getClass()) {
                try {
                    String[] strArr = (String[]) obj;
                    short[] sArr = new short[strArr.length];
                    while (i10 < strArr.length) {
                        sArr[i10] = Short.parseShort(strArr[i10]);
                        i10++;
                    }
                    return sArr;
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
                    short[] sArr2 = new short[size];
                    while (i10 < size) {
                        sArr2[i10] = Short.parseShort((String) parseElements.get(i10));
                        i10++;
                    }
                    return sArr2;
                } catch (Exception e11) {
                    if (this.useDefault) {
                        return this.defaultValue;
                    }
                    throw new ConversionException(obj.toString(), e11);
                }
            }
        }
    }

    public ShortArrayConverter(Object obj) {
        this.defaultValue = obj;
        this.useDefault = true;
    }
}

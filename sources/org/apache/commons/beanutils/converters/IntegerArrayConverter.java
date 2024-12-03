package org.apache.commons.beanutils.converters;

import java.util.List;
import org.apache.commons.beanutils.ConversionException;

@Deprecated
public final class IntegerArrayConverter extends AbstractArrayConverter {
    private static final int[] MODEL = new int[0];

    public IntegerArrayConverter() {
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
                    int[] iArr = new int[strArr.length];
                    while (i10 < strArr.length) {
                        iArr[i10] = Integer.parseInt(strArr[i10]);
                        i10++;
                    }
                    return iArr;
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
                    int[] iArr2 = new int[size];
                    while (i10 < size) {
                        iArr2[i10] = Integer.parseInt((String) parseElements.get(i10));
                        i10++;
                    }
                    return iArr2;
                } catch (Exception e11) {
                    if (this.useDefault) {
                        return this.defaultValue;
                    }
                    throw new ConversionException(obj.toString(), e11);
                }
            }
        }
    }

    public IntegerArrayConverter(Object obj) {
        this.defaultValue = obj;
        this.useDefault = true;
    }
}

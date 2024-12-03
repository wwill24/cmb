package org.apache.commons.beanutils.converters;

import java.util.List;
import org.apache.commons.beanutils.ConversionException;

@Deprecated
public final class LongArrayConverter extends AbstractArrayConverter {
    private static final long[] MODEL = new long[0];

    public LongArrayConverter() {
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
                    long[] jArr = new long[strArr.length];
                    while (i10 < strArr.length) {
                        jArr[i10] = Long.parseLong(strArr[i10]);
                        i10++;
                    }
                    return jArr;
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
                    long[] jArr2 = new long[size];
                    while (i10 < size) {
                        jArr2[i10] = Long.parseLong((String) parseElements.get(i10));
                        i10++;
                    }
                    return jArr2;
                } catch (Exception e11) {
                    if (this.useDefault) {
                        return this.defaultValue;
                    }
                    throw new ConversionException(obj.toString(), e11);
                }
            }
        }
    }

    public LongArrayConverter(Object obj) {
        this.defaultValue = obj;
        this.useDefault = true;
    }
}

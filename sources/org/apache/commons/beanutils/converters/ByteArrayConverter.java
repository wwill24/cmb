package org.apache.commons.beanutils.converters;

import java.util.List;
import org.apache.commons.beanutils.ConversionException;

@Deprecated
public final class ByteArrayConverter extends AbstractArrayConverter {
    private static final byte[] MODEL = new byte[0];

    public ByteArrayConverter() {
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
                    byte[] bArr = new byte[strArr.length];
                    while (i10 < strArr.length) {
                        bArr[i10] = Byte.parseByte(strArr[i10]);
                        i10++;
                    }
                    return bArr;
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
                    byte[] bArr2 = new byte[size];
                    while (i10 < size) {
                        bArr2[i10] = Byte.parseByte((String) parseElements.get(i10));
                        i10++;
                    }
                    return bArr2;
                } catch (Exception e11) {
                    if (this.useDefault) {
                        return this.defaultValue;
                    }
                    throw new ConversionException(obj.toString(), e11);
                }
            }
        }
    }

    public ByteArrayConverter(Object obj) {
        this.defaultValue = obj;
        this.useDefault = true;
    }
}

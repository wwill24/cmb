package org.apache.commons.beanutils.converters;

import java.util.List;
import org.apache.commons.beanutils.ConversionException;

@Deprecated
public final class FloatArrayConverter extends AbstractArrayConverter {
    private static final float[] MODEL = new float[0];

    public FloatArrayConverter() {
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
                    float[] fArr = new float[strArr.length];
                    while (i10 < strArr.length) {
                        fArr[i10] = Float.parseFloat(strArr[i10]);
                        i10++;
                    }
                    return fArr;
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
                    float[] fArr2 = new float[size];
                    while (i10 < size) {
                        fArr2[i10] = Float.parseFloat((String) parseElements.get(i10));
                        i10++;
                    }
                    return fArr2;
                } catch (Exception e11) {
                    if (this.useDefault) {
                        return this.defaultValue;
                    }
                    throw new ConversionException(obj.toString(), e11);
                }
            }
        }
    }

    public FloatArrayConverter(Object obj) {
        this.defaultValue = obj;
        this.useDefault = true;
    }
}

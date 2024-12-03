package org.apache.commons.beanutils.converters;

import java.util.List;
import org.apache.commons.beanutils.ConversionException;

@Deprecated
public final class DoubleArrayConverter extends AbstractArrayConverter {
    private static final double[] MODEL = new double[0];

    public DoubleArrayConverter() {
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
                    double[] dArr = new double[strArr.length];
                    while (i10 < strArr.length) {
                        dArr[i10] = Double.parseDouble(strArr[i10]);
                        i10++;
                    }
                    return dArr;
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
                    double[] dArr2 = new double[size];
                    while (i10 < size) {
                        dArr2[i10] = Double.parseDouble((String) parseElements.get(i10));
                        i10++;
                    }
                    return dArr2;
                } catch (Exception e11) {
                    if (this.useDefault) {
                        return this.defaultValue;
                    }
                    throw new ConversionException(obj.toString(), e11);
                }
            }
        }
    }

    public DoubleArrayConverter(Object obj) {
        this.defaultValue = obj;
        this.useDefault = true;
    }
}

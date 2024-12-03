package org.apache.commons.beanutils.converters;

import java.util.List;
import org.apache.commons.beanutils.ConversionException;

@Deprecated
public final class StringArrayConverter extends AbstractArrayConverter {
    private static final int[] INT_MODEL = new int[0];
    private static final String[] MODEL = new String[0];

    public StringArrayConverter() {
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
            if (INT_MODEL.getClass() == obj.getClass()) {
                int[] iArr = (int[]) obj;
                String[] strArr = new String[iArr.length];
                while (i10 < iArr.length) {
                    strArr[i10] = Integer.toString(iArr[i10]);
                    i10++;
                }
                return strArr;
            }
            try {
                List parseElements = parseElements(obj.toString());
                int size = parseElements.size();
                String[] strArr2 = new String[size];
                while (i10 < size) {
                    strArr2[i10] = (String) parseElements.get(i10);
                    i10++;
                }
                return strArr2;
            } catch (Exception e10) {
                if (this.useDefault) {
                    return this.defaultValue;
                }
                throw new ConversionException(obj.toString(), e10);
            }
        }
    }

    public StringArrayConverter(Object obj) {
        this.defaultValue = obj;
        this.useDefault = true;
    }
}

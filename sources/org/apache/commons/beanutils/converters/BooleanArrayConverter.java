package org.apache.commons.beanutils.converters;

import java.util.List;
import org.apache.commons.beanutils.ConversionException;

@Deprecated
public final class BooleanArrayConverter extends AbstractArrayConverter {
    private static final BooleanConverter DEFAULT_CONVERTER = new BooleanConverter();
    public static final Class MODEL = new boolean[0].getClass();
    protected final BooleanConverter booleanConverter;

    public BooleanArrayConverter() {
        this.booleanConverter = DEFAULT_CONVERTER;
    }

    public Object convert(Class cls, Object obj) {
        Class cls2 = Boolean.class;
        if (obj == null) {
            if (this.useDefault) {
                return this.defaultValue;
            }
            throw new ConversionException("No value specified");
        } else if (MODEL == obj.getClass()) {
            return obj;
        } else {
            int i10 = 0;
            if (AbstractArrayConverter.strings.getClass() == obj.getClass()) {
                try {
                    String[] strArr = (String[]) obj;
                    boolean[] zArr = new boolean[strArr.length];
                    while (i10 < strArr.length) {
                        zArr[i10] = ((Boolean) this.booleanConverter.convert(cls2, strArr[i10])).booleanValue();
                        i10++;
                    }
                    return zArr;
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
                    boolean[] zArr2 = new boolean[size];
                    while (i10 < size) {
                        zArr2[i10] = ((Boolean) this.booleanConverter.convert(cls2, (String) parseElements.get(i10))).booleanValue();
                        i10++;
                    }
                    return zArr2;
                } catch (Exception e11) {
                    if (this.useDefault) {
                        return this.defaultValue;
                    }
                    throw new ConversionException(obj.toString(), e11);
                }
            }
        }
    }

    public BooleanArrayConverter(Object obj) {
        super(obj);
        this.booleanConverter = DEFAULT_CONVERTER;
    }

    public BooleanArrayConverter(BooleanConverter booleanConverter2, Object obj) {
        super(obj);
        this.booleanConverter = booleanConverter2;
    }
}

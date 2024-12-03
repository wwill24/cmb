package org.apache.commons.beanutils.converters;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;

public class ArrayConverter extends AbstractConverter {
    private char[] allowedChars;
    private int defaultSize;
    private final Class<?> defaultType;
    private char delimiter;
    private final Converter elementConverter;
    private boolean onlyFirstToString;

    public ArrayConverter(Class<?> cls, Converter converter) {
        this.delimiter = ',';
        this.allowedChars = new char[]{'.', SignatureVisitor.SUPER};
        this.onlyFirstToString = true;
        if (cls == null) {
            throw new IllegalArgumentException("Default type is missing");
        } else if (!cls.isArray()) {
            throw new IllegalArgumentException("Default type must be an array.");
        } else if (converter != null) {
            this.defaultType = cls;
            this.elementConverter = converter;
        } else {
            throw new IllegalArgumentException("Component Converter is missing.");
        }
    }

    private List<String> parseElements(Class<?> cls, String str) {
        int nextToken;
        if (log().isDebugEnabled()) {
            Log log = log();
            log.debug("Parsing elements, delimiter=[" + this.delimiter + "], value=[" + str + "]");
        }
        String trim = str.trim();
        if (trim.startsWith("{") && trim.endsWith("}")) {
            trim = trim.substring(1, trim.length() - 1);
        }
        try {
            StreamTokenizer streamTokenizer = new StreamTokenizer(new StringReader(trim));
            char c10 = this.delimiter;
            streamTokenizer.whitespaceChars(c10, c10);
            streamTokenizer.ordinaryChars(48, 57);
            streamTokenizer.wordChars(48, 57);
            int i10 = 0;
            while (true) {
                char[] cArr = this.allowedChars;
                if (i10 >= cArr.length) {
                    break;
                }
                char c11 = cArr[i10];
                streamTokenizer.ordinaryChars(c11, c11);
                char c12 = this.allowedChars[i10];
                streamTokenizer.wordChars(c12, c12);
                i10++;
            }
            List<String> list = null;
            while (true) {
                nextToken = streamTokenizer.nextToken();
                if (nextToken != -3) {
                    if (nextToken <= 0) {
                        break;
                    }
                }
                if (streamTokenizer.sval != null) {
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    list.add(streamTokenizer.sval);
                }
            }
            if (nextToken == -1) {
                if (list == null) {
                    list = Collections.emptyList();
                }
                if (log().isDebugEnabled()) {
                    Log log2 = log();
                    log2.debug(list.size() + " elements parsed");
                }
                return list;
            }
            throw new ConversionException("Encountered token of type " + nextToken + " parsing elements to '" + toString(cls) + ".");
        } catch (IOException e10) {
            throw new ConversionException("Error converting from String to '" + toString(cls) + "': " + e10.getMessage(), e10);
        }
    }

    /* access modifiers changed from: protected */
    public Object convertArray(Object obj) {
        return obj;
    }

    /* access modifiers changed from: protected */
    public Collection<?> convertToCollection(Class<?> cls, Object obj) {
        if (obj instanceof Collection) {
            return (Collection) obj;
        }
        if (!(obj instanceof Number) && !(obj instanceof Boolean) && !(obj instanceof Date)) {
            return parseElements(cls, obj.toString());
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(obj);
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public String convertToString(Object obj) throws Throwable {
        Iterator<?> it;
        int i10;
        Object obj2;
        Class cls = String.class;
        Class<?> cls2 = obj.getClass();
        if (cls2.isArray()) {
            i10 = Array.getLength(obj);
            it = null;
        } else {
            Collection<?> convertToCollection = convertToCollection(cls2, obj);
            int size = convertToCollection.size();
            it = convertToCollection.iterator();
            i10 = size;
        }
        if (i10 == 0) {
            return (String) getDefault(cls);
        }
        if (this.onlyFirstToString) {
            i10 = 1;
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < i10; i11++) {
            if (i11 > 0) {
                sb2.append(this.delimiter);
            }
            if (it == null) {
                obj2 = Array.get(obj, i11);
            } else {
                obj2 = it.next();
            }
            Object convert = this.elementConverter.convert(cls, obj2);
            if (convert != null) {
                sb2.append(convert);
            }
        }
        return sb2.toString();
    }

    /* access modifiers changed from: protected */
    public <T> T convertToType(Class<T> cls, Object obj) throws Throwable {
        int i10;
        Object obj2;
        if (cls.isArray()) {
            Iterator<?> it = null;
            if (obj.getClass().isArray()) {
                i10 = Array.getLength(obj);
            } else {
                Collection<?> convertToCollection = convertToCollection(cls, obj);
                i10 = convertToCollection.size();
                it = convertToCollection.iterator();
            }
            Class<?> componentType = cls.getComponentType();
            T newInstance = Array.newInstance(componentType, i10);
            for (int i11 = 0; i11 < i10; i11++) {
                if (it == null) {
                    obj2 = Array.get(obj, i11);
                } else {
                    obj2 = it.next();
                }
                Array.set(newInstance, i11, this.elementConverter.convert(componentType, obj2));
            }
            return newInstance;
        }
        throw new ConversionException(toString(getClass()) + " cannot handle conversion to '" + toString(cls) + "' (not an array).");
    }

    /* access modifiers changed from: protected */
    public Object getDefault(Class<?> cls) {
        Object obj;
        if (cls.equals(String.class) || (obj = super.getDefault(cls)) == null) {
            return null;
        }
        if (obj.getClass().equals(cls)) {
            return obj;
        }
        return Array.newInstance(cls.getComponentType(), this.defaultSize);
    }

    /* access modifiers changed from: protected */
    public Class<?> getDefaultType() {
        return this.defaultType;
    }

    public void setAllowedChars(char[] cArr) {
        this.allowedChars = cArr;
    }

    public void setDelimiter(char c10) {
        this.delimiter = c10;
    }

    public void setOnlyFirstToString(boolean z10) {
        this.onlyFirstToString = z10;
    }

    public String toString() {
        return toString(getClass()) + "[UseDefault=" + isUseDefault() + ", " + this.elementConverter.toString() + PropertyUtils.INDEXED_DELIM2;
    }

    public ArrayConverter(Class<?> cls, Converter converter, int i10) {
        this(cls, converter);
        this.defaultSize = i10;
        setDefaultValue(i10 >= 0 ? Array.newInstance(cls.getComponentType(), i10) : null);
    }
}

package org.apache.commons.beanutils.converters;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.Converter;

@Deprecated
public abstract class AbstractArrayConverter implements Converter {
    public static final Object NO_DEFAULT = new Object();
    protected static String[] strings = new String[0];
    protected Object defaultValue = null;
    protected boolean useDefault = false;

    public AbstractArrayConverter() {
    }

    public abstract Object convert(Class cls, Object obj);

    /* access modifiers changed from: protected */
    public List parseElements(String str) {
        int nextToken;
        str.getClass();
        String trim = str.trim();
        if (trim.startsWith("{") && trim.endsWith("}")) {
            trim = trim.substring(1, trim.length() - 1);
        }
        try {
            StreamTokenizer streamTokenizer = new StreamTokenizer(new StringReader(trim));
            streamTokenizer.whitespaceChars(44, 44);
            streamTokenizer.ordinaryChars(48, 57);
            streamTokenizer.ordinaryChars(46, 46);
            streamTokenizer.ordinaryChars(45, 45);
            streamTokenizer.wordChars(48, 57);
            streamTokenizer.wordChars(46, 46);
            streamTokenizer.wordChars(45, 45);
            ArrayList arrayList = new ArrayList();
            while (true) {
                nextToken = streamTokenizer.nextToken();
                if (nextToken != -3) {
                    if (nextToken <= 0) {
                        break;
                    }
                }
                arrayList.add(streamTokenizer.sval);
            }
            if (nextToken == -1) {
                return arrayList;
            }
            throw new ConversionException("Encountered token of type " + nextToken);
        } catch (IOException e10) {
            throw new ConversionException((Throwable) e10);
        }
    }

    public AbstractArrayConverter(Object obj) {
        if (obj == NO_DEFAULT) {
            this.useDefault = false;
            return;
        }
        this.defaultValue = obj;
        this.useDefault = true;
    }
}

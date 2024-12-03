package org.apache.commons.beanutils.converters;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;

public final class BooleanConverter extends AbstractConverter {
    @Deprecated
    public static final Object NO_DEFAULT = new Object();
    private String[] falseStrings = {"false", "no", "n", "off", "0"};
    private String[] trueStrings = {ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, "yes", "y", "on", AppEventsConstants.EVENT_PARAM_VALUE_YES};

    public BooleanConverter() {
    }

    private static String[] copyStrings(String[] strArr) {
        String[] strArr2 = new String[strArr.length];
        for (int i10 = 0; i10 < strArr.length; i10++) {
            strArr2[i10] = strArr[i10].toLowerCase();
        }
        return strArr2;
    }

    /* access modifiers changed from: protected */
    public <T> T convertToType(Class<T> cls, Object obj) throws Throwable {
        if (Boolean.class.equals(cls) || Boolean.TYPE.equals(cls)) {
            String lowerCase = obj.toString().toLowerCase();
            int i10 = 0;
            int i11 = 0;
            while (true) {
                String[] strArr = this.trueStrings;
                if (i11 >= strArr.length) {
                    while (true) {
                        String[] strArr2 = this.falseStrings;
                        if (i10 >= strArr2.length) {
                            break;
                        } else if (strArr2[i10].equals(lowerCase)) {
                            return cls.cast(Boolean.FALSE);
                        } else {
                            i10++;
                        }
                    }
                } else if (strArr[i11].equals(lowerCase)) {
                    return cls.cast(Boolean.TRUE);
                } else {
                    i11++;
                }
            }
        }
        throw conversionException(cls, obj);
    }

    /* access modifiers changed from: protected */
    public Class<Boolean> getDefaultType() {
        return Boolean.class;
    }

    public BooleanConverter(Object obj) {
        if (obj != NO_DEFAULT) {
            setDefaultValue(obj);
        }
    }

    public BooleanConverter(String[] strArr, String[] strArr2) {
        this.trueStrings = copyStrings(strArr);
        this.falseStrings = copyStrings(strArr2);
    }

    public BooleanConverter(String[] strArr, String[] strArr2, Object obj) {
        this.trueStrings = copyStrings(strArr);
        this.falseStrings = copyStrings(strArr2);
        if (obj != NO_DEFAULT) {
            setDefaultValue(obj);
        }
    }
}

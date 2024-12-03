package org.apache.commons.validator.util;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.collections.FastHashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.validator.Arg;
import org.apache.commons.validator.Msg;
import org.apache.commons.validator.Var;

public class ValidatorUtils {
    private static final Log LOG = LogFactory.getLog(ValidatorUtils.class);

    public static FastHashMap copyFastHashMap(FastHashMap fastHashMap) {
        FastHashMap fastHashMap2 = new FastHashMap();
        for (Map.Entry entry : fastHashMap.entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Msg) {
                fastHashMap2.put(str, ((Msg) value).clone());
            } else if (value instanceof Arg) {
                fastHashMap2.put(str, ((Arg) value).clone());
            } else if (value instanceof Var) {
                fastHashMap2.put(str, ((Var) value).clone());
            } else {
                fastHashMap2.put(str, value);
            }
        }
        fastHashMap2.setFast(true);
        return fastHashMap2;
    }

    public static Map<String, Object> copyMap(Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            Object value = next.getValue();
            if (value instanceof Msg) {
                hashMap.put(str, ((Msg) value).clone());
            } else if (value instanceof Arg) {
                hashMap.put(str, ((Arg) value).clone());
            } else if (value instanceof Var) {
                hashMap.put(str, ((Var) value).clone());
            } else {
                hashMap.put(str, value);
            }
        }
        return hashMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0029 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getValueAsString(java.lang.Object r2, java.lang.String r3) {
        /*
            r0 = 0
            java.lang.Object r2 = org.apache.commons.beanutils.PropertyUtils.getProperty(r2, r3)     // Catch:{ IllegalAccessException -> 0x001c, InvocationTargetException -> 0x0011, NoSuchMethodException -> 0x0006 }
            goto L_0x0027
        L_0x0006:
            r2 = move-exception
            org.apache.commons.logging.Log r3 = LOG
            java.lang.String r1 = r2.getMessage()
            r3.error(r1, r2)
            goto L_0x0026
        L_0x0011:
            r2 = move-exception
            org.apache.commons.logging.Log r3 = LOG
            java.lang.String r1 = r2.getMessage()
            r3.error(r1, r2)
            goto L_0x0026
        L_0x001c:
            r2 = move-exception
            org.apache.commons.logging.Log r3 = LOG
            java.lang.String r1 = r2.getMessage()
            r3.error(r1, r2)
        L_0x0026:
            r2 = r0
        L_0x0027:
            if (r2 != 0) goto L_0x002a
            return r0
        L_0x002a:
            boolean r3 = r2 instanceof java.lang.String[]
            java.lang.String r0 = ""
            if (r3 == 0) goto L_0x003b
            r3 = r2
            java.lang.String[] r3 = (java.lang.String[]) r3
            int r3 = r3.length
            if (r3 <= 0) goto L_0x003a
            java.lang.String r0 = r2.toString()
        L_0x003a:
            return r0
        L_0x003b:
            boolean r3 = r2 instanceof java.util.Collection
            if (r3 == 0) goto L_0x004e
            r3 = r2
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x0049
            goto L_0x004d
        L_0x0049:
            java.lang.String r0 = r2.toString()
        L_0x004d:
            return r0
        L_0x004e:
            java.lang.String r2 = r2.toString()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.validator.util.ValidatorUtils.getValueAsString(java.lang.Object, java.lang.String):java.lang.String");
    }

    public static String replace(String str, String str2, String str3) {
        int indexOf;
        if (str == null || str2 == null || str3 == null || (indexOf = str.indexOf(str2)) < 0) {
            return str;
        }
        int length = str.length();
        int length2 = str2.length() + indexOf;
        if (length == str2.length()) {
            return str3;
        }
        if (length2 == length) {
            return str.substring(0, indexOf) + str3;
        }
        return str.substring(0, indexOf) + str3 + replace(str.substring(length2), str2, str3);
    }
}

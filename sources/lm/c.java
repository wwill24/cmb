package lm;

import org.jxmpp.util.cache.LruCache;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final LruCache<String, String> f23634a = new LruCache<>(100);

    /* renamed from: b  reason: collision with root package name */
    private static final LruCache<String, String> f23635b = new LruCache<>(100);

    public static String a(CharSequence charSequence, CharSequence charSequence2) {
        return b(charSequence != null ? charSequence.toString() : null, charSequence2.toString());
    }

    public static String b(String str, String str2) {
        return c(str, str2, (String) null);
    }

    public static String c(String str, String str2, String str3) {
        int i10;
        if (str2 != null) {
            int i11 = 0;
            if (str != null) {
                i10 = str.length();
            } else {
                i10 = 0;
            }
            int length = str2.length();
            if (str3 != null) {
                i11 = str3.length();
            }
            StringBuilder sb2 = new StringBuilder(length + i10 + i11 + 2);
            if (i10 > 0) {
                sb2.append(str);
                sb2.append('@');
            }
            sb2.append(str2);
            if (i11 > 0) {
                sb2.append('/');
                sb2.append(str3);
            }
            return sb2.toString();
        }
        throw new IllegalArgumentException("domainpart must not be null");
    }

    public static String d(String str, String str2) {
        return str + 9 + str2;
    }

    public static String e(String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(64);
        int indexOf2 = str.indexOf(47);
        if (indexOf2 < 0) {
            return str.substring(indexOf + 1);
        }
        if (indexOf2 > indexOf) {
            return str.substring(indexOf + 1, indexOf2);
        }
        return str.substring(0, indexOf2);
    }

    public static String f(String str) {
        int indexOf = str.indexOf(64);
        if (indexOf < 0) {
            return null;
        }
        if (indexOf == 0) {
            return "";
        }
        int indexOf2 = str.indexOf(47);
        if (indexOf2 < 0 || indexOf2 >= indexOf) {
            return str.substring(0, indexOf);
        }
        return null;
    }

    public static String g(String str) {
        int indexOf = str.indexOf(47);
        if (indexOf < 0) {
            return null;
        }
        int i10 = indexOf + 1;
        if (i10 > str.length()) {
            return "";
        }
        return str.substring(i10);
    }
}

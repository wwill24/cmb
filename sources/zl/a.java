package zl;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f24819a = Pattern.compile("[\\\\&]");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f24820b = Pattern.compile("\\\\[!\"#$%&'()*+,./:;<=>?@\\[\\\\\\]^_`{|}~-]|&(?:#x[a-f0-9]{1,6}|#[0-9]{1,7}|[a-z][a-z0-9]{1,31});", 2);

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f24821c = Pattern.compile("(%[a-fA-F0-9]{0,2}|[^:/?#@!$&'()*+,;=a-zA-Z0-9\\-._~])");
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final char[] f24822d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: e  reason: collision with root package name */
    private static final Pattern f24823e = Pattern.compile("[ \t\r\n]+");

    /* renamed from: f  reason: collision with root package name */
    private static final c f24824f = new C0296a();

    /* renamed from: g  reason: collision with root package name */
    private static final c f24825g = new b();

    /* renamed from: zl.a$a  reason: collision with other inner class name */
    static class C0296a implements c {
        C0296a() {
        }

        public void a(String str, StringBuilder sb2) {
            if (str.charAt(0) == '\\') {
                sb2.append(str, 1, str.length());
            } else {
                sb2.append(b.a(str));
            }
        }
    }

    static class b implements c {
        b() {
        }

        public void a(String str, StringBuilder sb2) {
            if (!str.startsWith("%")) {
                for (byte b10 : str.getBytes(Charset.forName("UTF-8"))) {
                    sb2.append('%');
                    sb2.append(a.f24822d[(b10 >> 4) & 15]);
                    sb2.append(a.f24822d[b10 & 15]);
                }
            } else if (str.length() == 3) {
                sb2.append(str);
            } else {
                sb2.append("%25");
                sb2.append(str, 1, str.length());
            }
        }
    }

    private interface c {
        void a(String str, StringBuilder sb2);
    }

    public static String b(String str) {
        return f24823e.matcher(str.trim().toLowerCase(Locale.ROOT)).replaceAll(" ");
    }

    public static String c(String str) {
        return b(str.substring(1, str.length() - 1));
    }

    private static String d(Pattern pattern, String str, c cVar) {
        Matcher matcher = pattern.matcher(str);
        if (!matcher.find()) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder(str.length() + 16);
        int i10 = 0;
        do {
            sb2.append(str, i10, matcher.start());
            cVar.a(matcher.group(), sb2);
            i10 = matcher.end();
        } while (matcher.find());
        if (i10 != str.length()) {
            sb2.append(str, i10, str.length());
        }
        return sb2.toString();
    }

    public static String e(String str) {
        if (f24819a.matcher(str).find()) {
            return d(f24820b, str, f24824f);
        }
        return str;
    }
}

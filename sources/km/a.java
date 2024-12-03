package km;

import java.util.Arrays;
import java.util.Locale;
import jm.b;
import org.jxmpp.XmppAddressParttype;
import org.jxmpp.stringprep.XmppStringprepException;

public final class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private static a f23627a;

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f23628b;

    /* renamed from: c  reason: collision with root package name */
    private static final char[] f23629c;

    /* renamed from: d  reason: collision with root package name */
    private static final char[] f23630d;

    static {
        char[] cArr = {'\"', '&', '\'', '/', ':', '<', '>', '@'};
        f23628b = cArr;
        char[] cArr2 = {' '};
        f23629c = cArr2;
        Arrays.sort(cArr);
        char[] cArr3 = (char[]) lm.a.a(cArr, cArr2);
        f23630d = cArr3;
        Arrays.sort(cArr3);
    }

    private a() {
    }

    private static void d(XmppAddressParttype xmppAddressParttype, String str, char[] cArr) throws XmppStringprepException {
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        int i10 = 0;
        while (i10 < length) {
            int binarySearch = Arrays.binarySearch(cArr, charArray[i10]);
            if (binarySearch < 0) {
                i10++;
            } else {
                throw new XmppStringprepException(str, xmppAddressParttype.a() + " must not contain '" + cArr[binarySearch] + "'");
            }
        }
    }

    public static a e() {
        if (f23627a == null) {
            f23627a = new a();
        }
        return f23627a;
    }

    public static void f() {
        org.jxmpp.a.d(e());
    }

    private static String g(String str) {
        return str.toLowerCase(Locale.US);
    }

    public String a(String str) throws XmppStringprepException {
        String g10 = g(str);
        d(XmppAddressParttype.localpart, g10, f23630d);
        return g10;
    }

    public String b(String str) throws XmppStringprepException {
        return str;
    }

    public String c(String str) throws XmppStringprepException {
        return g(str);
    }
}

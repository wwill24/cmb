package rd;

import com.google.android.gms.internal.gtm.zzfa;
import com.mparticle.kits.ReportingMessage;

public final class g {
    public static String a(int i10) {
        return g("cd", i10);
    }

    public static String b(int i10) {
        return g(ReportingMessage.MessageType.COMMERCE_EVENT, i10);
    }

    public static String c(int i10) {
        return g("il", i10);
    }

    public static String d(int i10) {
        return g("pi", i10);
    }

    public static String e(int i10) {
        return g(ReportingMessage.MessageType.PUSH_REGISTRATION, i10);
    }

    public static String f(int i10) {
        return g("promo", i10);
    }

    private static String g(String str, int i10) {
        if (i10 <= 0) {
            zzfa.zzb("index out of range for prefix", str);
            return "";
        }
        StringBuilder sb2 = new StringBuilder(str.length() + 11);
        sb2.append(str);
        sb2.append(i10);
        return sb2.toString();
    }
}

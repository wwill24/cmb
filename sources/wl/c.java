package wl;

import com.mparticle.kits.AppsFlyerKit;
import gk.g;
import java.util.List;
import kotlin.Result;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import ml.b;
import p004do.a;
import p004do.d;
import wl.b;

public final class c implements b, b {

    /* renamed from: a  reason: collision with root package name */
    public static final c f33960a = new c();

    private c() {
    }

    private final int a(String str, int i10) {
        Integer valueOf = Integer.valueOf(str.length() + i10);
        if (!(valueOf.intValue() >= 0)) {
            valueOf = null;
        }
        if (valueOf != null) {
            return valueOf.intValue();
        }
        return 0;
    }

    private final int b(int i10, int i11) {
        Integer valueOf = Integer.valueOf(i10);
        if (!(valueOf.intValue() <= i11)) {
            valueOf = null;
        }
        return valueOf != null ? valueOf.intValue() : i11;
    }

    private final String d(String str, int i10, int i11) {
        if (i10 >= 0 && i11 > 0) {
            return h(str, i10, i11);
        }
        if (i10 >= 0 && i11 < 0) {
            String substring = str.substring(i10, str.length() + i11);
            j.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        } else if (i10 < 0 && i11 < 0) {
            return e(str, i10, i11);
        } else {
            if (i10 >= 0 || i11 <= 0) {
                return null;
            }
            return g(str, i10, i11);
        }
    }

    private final String e(String str, int i10, int i11) {
        String substring = str.substring(a(str, i10), b(str.length() + i11, str.length()));
        j.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    private final String g(String str, int i10, int i11) {
        int a10 = a(str, i10);
        String substring = str.substring(a10, b(i11 + a10, str.length()));
        j.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    private final String h(String str, int i10, int i11) {
        String substring = str.substring(i10, b(i11 + i10, str.length()));
        j.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    private final String i(String str, int i10) {
        if (i10 >= 0) {
            String substring = str.substring(i10);
            j.f(substring, "this as java.lang.String).substring(startIndex)");
            return substring;
        } else if (Math.abs(i10) > str.length()) {
            return str;
        } else {
            String substring2 = str.substring(str.length() + i10);
            j.f(substring2, "this as java.lang.String).substring(startIndex)");
            return substring2;
        }
    }

    private final String j(List<? extends Object> list, int i10, int i11) {
        Object obj;
        String W = CollectionsKt___CollectionsKt.W(k(CollectionsKt___CollectionsKt.P(list)), AppsFlyerKit.COMMA, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        try {
            Result.a aVar = Result.f32010a;
            if (list.size() == 2) {
                W = f33960a.i(W, i10);
            } else if (list.size() > 2) {
                W = f33960a.d(W, i10, i11);
            }
            obj = Result.b(W);
        } catch (Throwable th2) {
            Result.a aVar2 = Result.f32010a;
            obj = Result.b(g.a(th2));
        }
        if (Result.g(obj)) {
            obj = null;
        }
        String str = (String) obj;
        if (str == null) {
            return "";
        }
        return str;
    }

    /* renamed from: c */
    public String f(Object obj, Object obj2) {
        List<Object> c10 = a.c(obj);
        return f33960a.j(c10, d.b(String.valueOf(p004do.c.b(c10))), d.b(String.valueOf(p004do.c.c(c10))));
    }

    public List<String> k(Object obj) {
        return b.a.d(this, obj);
    }
}

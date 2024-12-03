package wn;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Result;
import kotlin.jvm.internal.j;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import ml.b;
import p004do.a;

public final class g implements b, m {

    /* renamed from: a  reason: collision with root package name */
    public static final g f42492a = new g();

    private g() {
    }

    private final Set<RegexOption> a(List<? extends Object> list) {
        ArrayList arrayList = new ArrayList(r.t(list, 10));
        for (T next : list) {
            j.e(next, "null cannot be cast to non-null type kotlin.String");
            arrayList.add(RegexOption.valueOf((String) next));
        }
        return CollectionsKt___CollectionsKt.B0(arrayList);
    }

    private final boolean b(h hVar) {
        boolean z10;
        List<Object> a10 = hVar.a();
        if (a10 == null || a10.isEmpty()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return c(hVar.b(), hVar.c());
        }
        return d(hVar.a(), hVar.b(), hVar.c());
    }

    private final boolean c(String str, String str2) {
        return new Regex(str).e(str2);
    }

    private final boolean d(List<? extends Object> list, String str, String str2) {
        boolean z10;
        boolean z11;
        Set<RegexOption> a10 = a(list);
        Regex regex = new Regex(str, (Set<? extends RegexOption>) a10);
        if (!(a10 instanceof Collection) || !a10.isEmpty()) {
            Iterator<T> it = a10.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (((RegexOption) it.next()) == RegexOption.MULTILINE) {
                    z11 = true;
                    continue;
                } else {
                    z11 = false;
                    continue;
                }
                if (z11) {
                    z10 = true;
                    break;
                }
            }
        }
        z10 = false;
        if (!z10) {
            return regex.e(str2);
        }
        List<String> C0 = StringsKt__StringsKt.C0(str2, new String[]{"\n"}, false, 0, 6, (Object) null);
        if ((C0 instanceof Collection) && C0.isEmpty()) {
            return true;
        }
        for (String e10 : C0) {
            if (!regex.e(e10)) {
                return false;
            }
        }
        return true;
    }

    private final h e(List<? extends Object> list) {
        Object obj;
        try {
            Result.a aVar = Result.f32010a;
            Object obj2 = list.get(0);
            j.e(obj2, "null cannot be cast to non-null type kotlin.String");
            Object obj3 = list.get(1);
            j.e(obj3, "null cannot be cast to non-null type kotlin.String");
            Object obj4 = list.get(2);
            j.e(obj4, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            obj = Result.b(new h((String) obj2, (String) obj3, (List) obj4));
        } catch (Throwable th2) {
            Result.a aVar2 = Result.f32010a;
            obj = Result.b(gk.g.a(th2));
        }
        if (Result.e(obj) == null) {
            return (h) obj;
        }
        return null;
    }

    public Object f(Object obj, Object obj2) {
        h e10 = e(a.c(obj));
        if (e10 != null) {
            return Boolean.valueOf(b(e10));
        }
        return null;
    }
}

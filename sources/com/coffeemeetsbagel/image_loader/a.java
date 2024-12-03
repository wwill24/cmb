package com.coffeemeetsbagel.image_loader;

import androidx.collection.f;
import gk.h;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final C0147a f13965a = new C0147a((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    private static final f<String, String> f13966b = new f<>(400);

    /* renamed from: com.coffeemeetsbagel.image_loader.a$a  reason: collision with other inner class name */
    public static final class C0147a {
        private C0147a() {
        }

        public /* synthetic */ C0147a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Map<String, String> a(Map<String, String> map, int i10) {
            j.g(map, "extraParams");
            return h0.o(h0.o(w9.a.f18327a.a(), map), h0.l(h.a("w", String.valueOf(i10)), h.a("h", String.valueOf(i10))));
        }
    }

    private final String a(th.a aVar, Map<String, String> map, String str) {
        String c10 = c(str);
        String d10 = d(c10, map);
        f<String, String> fVar = f13966b;
        String str2 = fVar.get(d10);
        if (str2 != null) {
            return str2;
        }
        aVar.b(true);
        String a10 = aVar.a(c10, map);
        fVar.put(d10, a10);
        return a10;
    }

    private final String c(String str) {
        if (!StringsKt__StringsKt.O(str, "d1ghufavkue0e7.cloudfront.net", false, 2, (Object) null)) {
            return null;
        }
        String substring = str.substring(StringsKt__StringsKt.b0(str, "d1ghufavkue0e7.cloudfront.net", 0, false, 6, (Object) null) + 29);
        j.f(substring, "this as java.lang.String).substring(startIndex)");
        return substring;
    }

    private final String d(String str, Map<String, String> map) {
        j.d(str);
        StringBuilder sb2 = new StringBuilder(str);
        for (String str2 : map.keySet()) {
            sb2.append(str2);
            sb2.append(map.get(str2));
        }
        String sb3 = sb2.toString();
        j.f(sb3, "stringBuilder.toString()");
        return sb3;
    }

    public final String b(Map<String, String> map, String str) {
        j.g(map, "parameters");
        j.g(str, "originalUrl");
        if (!StringsKt__StringsKt.O(str, "d1ghufavkue0e7.cloudfront.net", false, 2, (Object) null)) {
            return str;
        }
        return a(new th.a("cdn.coffeemeetsbagel.com", true, "", false), map, str);
    }
}

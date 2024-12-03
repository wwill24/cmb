package na;

import com.jakewharton.rxrelay2.b;
import j5.x;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.j;
import lc.v;
import qj.q;

public final class c implements a, b {

    /* renamed from: a  reason: collision with root package name */
    private final b<Map<String, String>> f41290a;

    /* renamed from: b  reason: collision with root package name */
    private final b<x> f41291b;

    /* renamed from: c  reason: collision with root package name */
    private final b<x> f41292c;

    /* renamed from: d  reason: collision with root package name */
    private final b<String> f41293d;

    public c() {
        b<Map<String, String>> C0 = b.C0();
        j.f(C0, "create()");
        this.f41290a = C0;
        b<x> C02 = b.C0();
        j.f(C02, "create()");
        this.f41291b = C02;
        b<x> C03 = b.C0();
        j.f(C03, "create()");
        this.f41292c = C03;
        b<String> C04 = b.C0();
        j.f(C04, "create()");
        this.f41293d = C04;
    }

    public q<x> a() {
        return v.b(this.f41291b);
    }

    public q<Map<String, String>> b() {
        return v.b(this.f41290a);
    }

    public void c() {
        this.f41293d.accept("");
    }

    public void d() {
        v.a(this.f41291b);
    }

    public void e(Map<String, String> map) {
        b<Map<String, String>> bVar = this.f41290a;
        if (map == null) {
            map = new HashMap<>();
        }
        bVar.accept(map);
    }

    public q<x> g() {
        return v.b(this.f41292c);
    }

    public q<String> j() {
        return v.b(this.f41293d);
    }

    public void onError(String str) {
        j.g(str, "message");
        this.f41293d.accept(str);
    }
}

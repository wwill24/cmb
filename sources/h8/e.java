package h8;

import a7.a;
import b7.c;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.match.j;
import java.util.HashMap;
import k7.b;
import l8.h;

public class e implements b {

    /* renamed from: a  reason: collision with root package name */
    private final c f15410a;

    /* renamed from: b  reason: collision with root package name */
    private final a f15411b;

    /* renamed from: c  reason: collision with root package name */
    private final b f15412c;

    /* renamed from: d  reason: collision with root package name */
    private final j f15413d;

    /* renamed from: e  reason: collision with root package name */
    private final h f15414e;

    /* renamed from: f  reason: collision with root package name */
    private String f15415f;

    /* renamed from: g  reason: collision with root package name */
    private long f15416g;

    public e(c cVar, a aVar, b bVar, h hVar, j jVar) {
        this.f15410a = cVar;
        this.f15411b = aVar;
        this.f15412c = bVar;
        this.f15414e = hVar;
        this.f15413d = jVar;
    }

    public void K(String str) {
        this.f15411b.b(str);
        Bakery.w().H().d();
        Bakery.w().G().start();
    }

    public void M() {
        this.f15410a.f();
    }

    public void R() {
        if (this.f15415f != null && this.f15416g > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.f15416g;
            HashMap hashMap = new HashMap();
            hashMap.put("source", this.f15415f);
            hashMap.put("transition", "transition out");
            hashMap.put("duration", Long.toString(currentTimeMillis));
            this.f15411b.trackEvent("Logo Spinner", hashMap);
        }
    }

    public void d(String str) {
        this.f15416g = System.currentTimeMillis();
        this.f15415f = str;
        HashMap hashMap = new HashMap();
        hashMap.put("source", str);
        hashMap.put("transition", "transition in");
        this.f15411b.trackEvent("Logo Spinner", hashMap);
    }

    public void start() {
    }

    public void stop() {
    }

    public void z() {
        this.f15412c.b();
        this.f15414e.b((h.c) this.f15413d);
    }
}

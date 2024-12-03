package u2;

import android.graphics.Color;
import android.graphics.Paint;
import b3.j;
import u2.a;

public class c implements a.b {

    /* renamed from: a  reason: collision with root package name */
    private final a.b f17963a;

    /* renamed from: b  reason: collision with root package name */
    private final a<Integer, Integer> f17964b;

    /* renamed from: c  reason: collision with root package name */
    private final a<Float, Float> f17965c;

    /* renamed from: d  reason: collision with root package name */
    private final a<Float, Float> f17966d;

    /* renamed from: e  reason: collision with root package name */
    private final a<Float, Float> f17967e;

    /* renamed from: f  reason: collision with root package name */
    private final a<Float, Float> f17968f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f17969g = true;

    class a extends d3.c<Float> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ d3.c f17970d;

        a(d3.c cVar) {
            this.f17970d = cVar;
        }

        /* JADX WARNING: type inference failed for: r2v0, types: [d3.b<java.lang.Float>, d3.b] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* renamed from: d */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Float a(d3.b<java.lang.Float> r2) {
            /*
                r1 = this;
                d3.c r0 = r1.f17970d
                java.lang.Object r2 = r0.a(r2)
                java.lang.Float r2 = (java.lang.Float) r2
                if (r2 != 0) goto L_0x000c
                r2 = 0
                return r2
            L_0x000c:
                float r2 = r2.floatValue()
                r0 = 1076048691(0x40233333, float:2.55)
                float r2 = r2 * r0
                java.lang.Float r2 = java.lang.Float.valueOf(r2)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: u2.c.a.a(d3.b):java.lang.Float");
        }
    }

    public c(a.b bVar, com.airbnb.lottie.model.layer.a aVar, j jVar) {
        this.f17963a = bVar;
        a<Integer, Integer> a10 = jVar.a().a();
        this.f17964b = a10;
        a10.a(this);
        aVar.i(a10);
        a<Float, Float> a11 = jVar.d().a();
        this.f17965c = a11;
        a11.a(this);
        aVar.i(a11);
        a<Float, Float> a12 = jVar.b().a();
        this.f17966d = a12;
        a12.a(this);
        aVar.i(a12);
        a<Float, Float> a13 = jVar.c().a();
        this.f17967e = a13;
        a13.a(this);
        aVar.i(a13);
        a<Float, Float> a14 = jVar.e().a();
        this.f17968f = a14;
        a14.a(this);
        aVar.i(a14);
    }

    public void a() {
        this.f17969g = true;
        this.f17963a.a();
    }

    public void b(Paint paint) {
        if (this.f17969g) {
            this.f17969g = false;
            double floatValue = ((double) this.f17966d.h().floatValue()) * 0.017453292519943295d;
            float floatValue2 = this.f17967e.h().floatValue();
            float sin = ((float) Math.sin(floatValue)) * floatValue2;
            float cos = ((float) Math.cos(floatValue + 3.141592653589793d)) * floatValue2;
            int intValue = this.f17964b.h().intValue();
            paint.setShadowLayer(this.f17968f.h().floatValue(), sin, cos, Color.argb(Math.round(this.f17965c.h().floatValue()), Color.red(intValue), Color.green(intValue), Color.blue(intValue)));
        }
    }

    public void c(d3.c<Integer> cVar) {
        this.f17964b.n(cVar);
    }

    public void d(d3.c<Float> cVar) {
        this.f17966d.n(cVar);
    }

    public void e(d3.c<Float> cVar) {
        this.f17967e.n(cVar);
    }

    public void f(d3.c<Float> cVar) {
        if (cVar == null) {
            this.f17965c.n((d3.c) null);
        } else {
            this.f17965c.n(new a(cVar));
        }
    }

    public void g(d3.c<Float> cVar) {
        this.f17968f.n(cVar);
    }
}

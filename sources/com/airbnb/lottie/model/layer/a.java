package com.airbnb.lottie.model.layer;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import c3.f;
import c3.j;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.c;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.layer.Layer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import t2.e;
import u2.a;
import u2.d;
import u2.h;
import u2.p;
import y2.i;

public abstract class a implements e, a.b, w2.e {
    private Paint A;
    float B;
    BlurMaskFilter C;

    /* renamed from: a  reason: collision with root package name */
    private final Path f8748a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final Matrix f8749b = new Matrix();

    /* renamed from: c  reason: collision with root package name */
    private final Matrix f8750c = new Matrix();

    /* renamed from: d  reason: collision with root package name */
    private final Paint f8751d = new s2.a(1);

    /* renamed from: e  reason: collision with root package name */
    private final Paint f8752e = new s2.a(1, PorterDuff.Mode.DST_IN);

    /* renamed from: f  reason: collision with root package name */
    private final Paint f8753f = new s2.a(1, PorterDuff.Mode.DST_OUT);

    /* renamed from: g  reason: collision with root package name */
    private final Paint f8754g;

    /* renamed from: h  reason: collision with root package name */
    private final Paint f8755h;

    /* renamed from: i  reason: collision with root package name */
    private final RectF f8756i;

    /* renamed from: j  reason: collision with root package name */
    private final RectF f8757j;

    /* renamed from: k  reason: collision with root package name */
    private final RectF f8758k;

    /* renamed from: l  reason: collision with root package name */
    private final RectF f8759l;

    /* renamed from: m  reason: collision with root package name */
    private final RectF f8760m;

    /* renamed from: n  reason: collision with root package name */
    private final String f8761n;

    /* renamed from: o  reason: collision with root package name */
    final Matrix f8762o;

    /* renamed from: p  reason: collision with root package name */
    final LottieDrawable f8763p;

    /* renamed from: q  reason: collision with root package name */
    final Layer f8764q;

    /* renamed from: r  reason: collision with root package name */
    private h f8765r;

    /* renamed from: s  reason: collision with root package name */
    private d f8766s;

    /* renamed from: t  reason: collision with root package name */
    private a f8767t;

    /* renamed from: u  reason: collision with root package name */
    private a f8768u;

    /* renamed from: v  reason: collision with root package name */
    private List<a> f8769v;

    /* renamed from: w  reason: collision with root package name */
    private final List<u2.a<?, ?>> f8770w;

    /* renamed from: x  reason: collision with root package name */
    final p f8771x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f8772y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f8773z;

    /* renamed from: com.airbnb.lottie.model.layer.a$a  reason: collision with other inner class name */
    static /* synthetic */ class C0106a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f8774a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f8775b;

        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|(3:29|30|32)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0078 */
        static {
            /*
                com.airbnb.lottie.model.content.Mask$MaskMode[] r0 = com.airbnb.lottie.model.content.Mask.MaskMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8775b = r0
                r1 = 1
                com.airbnb.lottie.model.content.Mask$MaskMode r2 = com.airbnb.lottie.model.content.Mask.MaskMode.MASK_MODE_NONE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f8775b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.airbnb.lottie.model.content.Mask$MaskMode r3 = com.airbnb.lottie.model.content.Mask.MaskMode.MASK_MODE_SUBTRACT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f8775b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.airbnb.lottie.model.content.Mask$MaskMode r4 = com.airbnb.lottie.model.content.Mask.MaskMode.MASK_MODE_INTERSECT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f8775b     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.airbnb.lottie.model.content.Mask$MaskMode r5 = com.airbnb.lottie.model.content.Mask.MaskMode.MASK_MODE_ADD     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.airbnb.lottie.model.layer.Layer$LayerType[] r4 = com.airbnb.lottie.model.layer.Layer.LayerType.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f8774a = r4
                com.airbnb.lottie.model.layer.Layer$LayerType r5 = com.airbnb.lottie.model.layer.Layer.LayerType.SHAPE     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r1 = f8774a     // Catch:{ NoSuchFieldError -> 0x004e }
                com.airbnb.lottie.model.layer.Layer$LayerType r4 = com.airbnb.lottie.model.layer.Layer.LayerType.PRE_COMP     // Catch:{ NoSuchFieldError -> 0x004e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = f8774a     // Catch:{ NoSuchFieldError -> 0x0058 }
                com.airbnb.lottie.model.layer.Layer$LayerType r1 = com.airbnb.lottie.model.layer.Layer.LayerType.SOLID     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r0 = f8774a     // Catch:{ NoSuchFieldError -> 0x0062 }
                com.airbnb.lottie.model.layer.Layer$LayerType r1 = com.airbnb.lottie.model.layer.Layer.LayerType.IMAGE     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                int[] r0 = f8774a     // Catch:{ NoSuchFieldError -> 0x006d }
                com.airbnb.lottie.model.layer.Layer$LayerType r1 = com.airbnb.lottie.model.layer.Layer.LayerType.NULL     // Catch:{ NoSuchFieldError -> 0x006d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                int[] r0 = f8774a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.airbnb.lottie.model.layer.Layer$LayerType r1 = com.airbnb.lottie.model.layer.Layer.LayerType.TEXT     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f8774a     // Catch:{ NoSuchFieldError -> 0x0083 }
                com.airbnb.lottie.model.layer.Layer$LayerType r1 = com.airbnb.lottie.model.layer.Layer.LayerType.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0083 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0083 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0083 }
            L_0x0083:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.model.layer.a.C0106a.<clinit>():void");
        }
    }

    a(LottieDrawable lottieDrawable, Layer layer) {
        s2.a aVar = new s2.a(1);
        this.f8754g = aVar;
        this.f8755h = new s2.a(PorterDuff.Mode.CLEAR);
        this.f8756i = new RectF();
        this.f8757j = new RectF();
        this.f8758k = new RectF();
        this.f8759l = new RectF();
        this.f8760m = new RectF();
        this.f8762o = new Matrix();
        this.f8770w = new ArrayList();
        this.f8772y = true;
        this.B = 0.0f;
        this.f8763p = lottieDrawable;
        this.f8764q = layer;
        this.f8761n = layer.i() + "#draw";
        if (layer.h() == Layer.MatteType.INVERT) {
            aVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            aVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        p b10 = layer.w().b();
        this.f8771x = b10;
        b10.b(this);
        if (layer.g() != null && !layer.g().isEmpty()) {
            h hVar = new h(layer.g());
            this.f8765r = hVar;
            for (u2.a<i, Path> a10 : hVar.a()) {
                a10.a(this);
            }
            for (u2.a next : this.f8765r.c()) {
                i(next);
                next.a(this);
            }
        }
        N();
    }

    private void B(RectF rectF, Matrix matrix) {
        this.f8758k.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (z()) {
            int size = this.f8765r.b().size();
            for (int i10 = 0; i10 < size; i10++) {
                Mask mask = this.f8765r.b().get(i10);
                Path path = (Path) this.f8765r.a().get(i10).h();
                if (path != null) {
                    this.f8748a.set(path);
                    this.f8748a.transform(matrix);
                    int i11 = C0106a.f8775b[mask.a().ordinal()];
                    if (i11 != 1 && i11 != 2) {
                        if ((i11 != 3 && i11 != 4) || !mask.d()) {
                            this.f8748a.computeBounds(this.f8760m, false);
                            if (i10 == 0) {
                                this.f8758k.set(this.f8760m);
                            } else {
                                RectF rectF2 = this.f8758k;
                                rectF2.set(Math.min(rectF2.left, this.f8760m.left), Math.min(this.f8758k.top, this.f8760m.top), Math.max(this.f8758k.right, this.f8760m.right), Math.max(this.f8758k.bottom, this.f8760m.bottom));
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
            if (!rectF.intersect(this.f8758k)) {
                rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
        }
    }

    private void C(RectF rectF, Matrix matrix) {
        if (A() && this.f8764q.h() != Layer.MatteType.INVERT) {
            this.f8759l.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.f8767t.f(this.f8759l, matrix, true);
            if (!rectF.intersect(this.f8759l)) {
                rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
        }
    }

    private void D() {
        this.f8763p.invalidateSelf();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void E() {
        M(this.f8766s.p() == 1.0f);
    }

    private void F(float f10) {
        this.f8763p.G().n().a(this.f8764q.i(), f10);
    }

    private void M(boolean z10) {
        if (z10 != this.f8772y) {
            this.f8772y = z10;
            D();
        }
    }

    private void N() {
        boolean z10 = true;
        if (!this.f8764q.e().isEmpty()) {
            d dVar = new d(this.f8764q.e());
            this.f8766s = dVar;
            dVar.l();
            this.f8766s.a(new z2.a(this));
            if (((Float) this.f8766s.h()).floatValue() != 1.0f) {
                z10 = false;
            }
            M(z10);
            i(this.f8766s);
            return;
        }
        M(true);
    }

    private void j(Canvas canvas, Matrix matrix, u2.a<i, Path> aVar, u2.a<Integer, Integer> aVar2) {
        this.f8748a.set(aVar.h());
        this.f8748a.transform(matrix);
        this.f8751d.setAlpha((int) (((float) aVar2.h().intValue()) * 2.55f));
        canvas.drawPath(this.f8748a, this.f8751d);
    }

    private void k(Canvas canvas, Matrix matrix, u2.a<i, Path> aVar, u2.a<Integer, Integer> aVar2) {
        j.m(canvas, this.f8756i, this.f8752e);
        this.f8748a.set(aVar.h());
        this.f8748a.transform(matrix);
        this.f8751d.setAlpha((int) (((float) aVar2.h().intValue()) * 2.55f));
        canvas.drawPath(this.f8748a, this.f8751d);
        canvas.restore();
    }

    private void l(Canvas canvas, Matrix matrix, u2.a<i, Path> aVar, u2.a<Integer, Integer> aVar2) {
        j.m(canvas, this.f8756i, this.f8751d);
        canvas.drawRect(this.f8756i, this.f8751d);
        this.f8748a.set(aVar.h());
        this.f8748a.transform(matrix);
        this.f8751d.setAlpha((int) (((float) aVar2.h().intValue()) * 2.55f));
        canvas.drawPath(this.f8748a, this.f8753f);
        canvas.restore();
    }

    private void m(Canvas canvas, Matrix matrix, u2.a<i, Path> aVar, u2.a<Integer, Integer> aVar2) {
        j.m(canvas, this.f8756i, this.f8752e);
        canvas.drawRect(this.f8756i, this.f8751d);
        this.f8753f.setAlpha((int) (((float) aVar2.h().intValue()) * 2.55f));
        this.f8748a.set(aVar.h());
        this.f8748a.transform(matrix);
        canvas.drawPath(this.f8748a, this.f8753f);
        canvas.restore();
    }

    private void n(Canvas canvas, Matrix matrix, u2.a<i, Path> aVar, u2.a<Integer, Integer> aVar2) {
        j.m(canvas, this.f8756i, this.f8753f);
        canvas.drawRect(this.f8756i, this.f8751d);
        this.f8753f.setAlpha((int) (((float) aVar2.h().intValue()) * 2.55f));
        this.f8748a.set(aVar.h());
        this.f8748a.transform(matrix);
        canvas.drawPath(this.f8748a, this.f8753f);
        canvas.restore();
    }

    private void o(Canvas canvas, Matrix matrix) {
        c.a("Layer#saveLayer");
        j.n(canvas, this.f8756i, this.f8752e, 19);
        if (Build.VERSION.SDK_INT < 28) {
            s(canvas);
        }
        c.b("Layer#saveLayer");
        for (int i10 = 0; i10 < this.f8765r.b().size(); i10++) {
            Mask mask = this.f8765r.b().get(i10);
            u2.a aVar = this.f8765r.a().get(i10);
            u2.a aVar2 = this.f8765r.c().get(i10);
            int i11 = C0106a.f8775b[mask.a().ordinal()];
            if (i11 != 1) {
                if (i11 == 2) {
                    if (i10 == 0) {
                        this.f8751d.setColor(-16777216);
                        this.f8751d.setAlpha(255);
                        canvas.drawRect(this.f8756i, this.f8751d);
                    }
                    if (mask.d()) {
                        n(canvas, matrix, aVar, aVar2);
                    } else {
                        p(canvas, matrix, aVar);
                    }
                } else if (i11 != 3) {
                    if (i11 == 4) {
                        if (mask.d()) {
                            l(canvas, matrix, aVar, aVar2);
                        } else {
                            j(canvas, matrix, aVar, aVar2);
                        }
                    }
                } else if (mask.d()) {
                    m(canvas, matrix, aVar, aVar2);
                } else {
                    k(canvas, matrix, aVar, aVar2);
                }
            } else if (q()) {
                this.f8751d.setAlpha(255);
                canvas.drawRect(this.f8756i, this.f8751d);
            }
        }
        c.a("Layer#restoreLayer");
        canvas.restore();
        c.b("Layer#restoreLayer");
    }

    private void p(Canvas canvas, Matrix matrix, u2.a<i, Path> aVar) {
        this.f8748a.set(aVar.h());
        this.f8748a.transform(matrix);
        canvas.drawPath(this.f8748a, this.f8753f);
    }

    private boolean q() {
        if (this.f8765r.a().isEmpty()) {
            return false;
        }
        for (int i10 = 0; i10 < this.f8765r.b().size(); i10++) {
            if (this.f8765r.b().get(i10).a() != Mask.MaskMode.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    private void r() {
        if (this.f8769v == null) {
            if (this.f8768u == null) {
                this.f8769v = Collections.emptyList();
                return;
            }
            this.f8769v = new ArrayList();
            for (a aVar = this.f8768u; aVar != null; aVar = aVar.f8768u) {
                this.f8769v.add(aVar);
            }
        }
    }

    private void s(Canvas canvas) {
        c.a("Layer#clearLayer");
        RectF rectF = this.f8756i;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.f8755h);
        c.b("Layer#clearLayer");
    }

    static a u(b bVar, Layer layer, LottieDrawable lottieDrawable, com.airbnb.lottie.h hVar) {
        switch (C0106a.f8774a[layer.f().ordinal()]) {
            case 1:
                return new e(lottieDrawable, layer, bVar, hVar);
            case 2:
                return new b(lottieDrawable, layer, hVar.o(layer.m()), hVar);
            case 3:
                return new f(lottieDrawable, layer);
            case 4:
                return new c(lottieDrawable, layer);
            case 5:
                return new d(lottieDrawable, layer);
            case 6:
                return new g(lottieDrawable, layer);
            default:
                f.c("Unknown layer type " + layer.f());
                return null;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean A() {
        return this.f8767t != null;
    }

    public void G(u2.a<?, ?> aVar) {
        this.f8770w.remove(aVar);
    }

    /* access modifiers changed from: package-private */
    public void H(w2.d dVar, int i10, List<w2.d> list, w2.d dVar2) {
    }

    /* access modifiers changed from: package-private */
    public void I(a aVar) {
        this.f8767t = aVar;
    }

    /* access modifiers changed from: package-private */
    public void J(boolean z10) {
        if (z10 && this.A == null) {
            this.A = new s2.a();
        }
        this.f8773z = z10;
    }

    /* access modifiers changed from: package-private */
    public void K(a aVar) {
        this.f8768u = aVar;
    }

    /* access modifiers changed from: package-private */
    public void L(float f10) {
        this.f8771x.j(f10);
        if (this.f8765r != null) {
            for (int i10 = 0; i10 < this.f8765r.a().size(); i10++) {
                this.f8765r.a().get(i10).m(f10);
            }
        }
        d dVar = this.f8766s;
        if (dVar != null) {
            dVar.m(f10);
        }
        a aVar = this.f8767t;
        if (aVar != null) {
            aVar.L(f10);
        }
        for (int i11 = 0; i11 < this.f8770w.size(); i11++) {
            this.f8770w.get(i11).m(f10);
        }
    }

    public void a() {
        D();
    }

    public void b(List<t2.c> list, List<t2.c> list2) {
    }

    public <T> void c(T t10, d3.c<T> cVar) {
        this.f8771x.c(t10, cVar);
    }

    public void e(w2.d dVar, int i10, List<w2.d> list, w2.d dVar2) {
        a aVar = this.f8767t;
        if (aVar != null) {
            w2.d a10 = dVar2.a(aVar.getName());
            if (dVar.c(this.f8767t.getName(), i10)) {
                list.add(a10.i(this.f8767t));
            }
            if (dVar.h(getName(), i10)) {
                this.f8767t.H(dVar, dVar.e(this.f8767t.getName(), i10) + i10, list, a10);
            }
        }
        if (dVar.g(getName(), i10)) {
            if (!"__container".equals(getName())) {
                dVar2 = dVar2.a(getName());
                if (dVar.c(getName(), i10)) {
                    list.add(dVar2.i(this));
                }
            }
            if (dVar.h(getName(), i10)) {
                H(dVar, i10 + dVar.e(getName(), i10), list, dVar2);
            }
        }
    }

    public void f(RectF rectF, Matrix matrix, boolean z10) {
        this.f8756i.set(0.0f, 0.0f, 0.0f, 0.0f);
        r();
        this.f8762o.set(matrix);
        if (z10) {
            List<a> list = this.f8769v;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f8762o.preConcat(this.f8769v.get(size).f8771x.f());
                }
            } else {
                a aVar = this.f8768u;
                if (aVar != null) {
                    this.f8762o.preConcat(aVar.f8771x.f());
                }
            }
        }
        this.f8762o.preConcat(this.f8771x.f());
    }

    public String getName() {
        return this.f8764q.i();
    }

    public void h(Canvas canvas, Matrix matrix, int i10) {
        Paint paint;
        Integer h10;
        c.a(this.f8761n);
        if (!this.f8772y || this.f8764q.x()) {
            c.b(this.f8761n);
            return;
        }
        r();
        c.a("Layer#parentMatrix");
        this.f8749b.reset();
        this.f8749b.set(matrix);
        for (int size = this.f8769v.size() - 1; size >= 0; size--) {
            this.f8749b.preConcat(this.f8769v.get(size).f8771x.f());
        }
        c.b("Layer#parentMatrix");
        int i11 = 100;
        u2.a<?, Integer> h11 = this.f8771x.h();
        if (!(h11 == null || (h10 = h11.h()) == null)) {
            i11 = h10.intValue();
        }
        int i12 = (int) ((((((float) i10) / 255.0f) * ((float) i11)) / 100.0f) * 255.0f);
        if (A() || z()) {
            c.a("Layer#computeBounds");
            f(this.f8756i, this.f8749b, false);
            C(this.f8756i, matrix);
            this.f8749b.preConcat(this.f8771x.f());
            B(this.f8756i, this.f8749b);
            this.f8757j.set(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight());
            canvas.getMatrix(this.f8750c);
            if (!this.f8750c.isIdentity()) {
                Matrix matrix2 = this.f8750c;
                matrix2.invert(matrix2);
                this.f8750c.mapRect(this.f8757j);
            }
            if (!this.f8756i.intersect(this.f8757j)) {
                this.f8756i.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
            c.b("Layer#computeBounds");
            if (this.f8756i.width() >= 1.0f && this.f8756i.height() >= 1.0f) {
                c.a("Layer#saveLayer");
                this.f8751d.setAlpha(255);
                j.m(canvas, this.f8756i, this.f8751d);
                c.b("Layer#saveLayer");
                s(canvas);
                c.a("Layer#drawLayer");
                t(canvas, this.f8749b, i12);
                c.b("Layer#drawLayer");
                if (z()) {
                    o(canvas, this.f8749b);
                }
                if (A()) {
                    c.a("Layer#drawMatte");
                    c.a("Layer#saveLayer");
                    j.n(canvas, this.f8756i, this.f8754g, 19);
                    c.b("Layer#saveLayer");
                    s(canvas);
                    this.f8767t.h(canvas, matrix, i12);
                    c.a("Layer#restoreLayer");
                    canvas.restore();
                    c.b("Layer#restoreLayer");
                    c.b("Layer#drawMatte");
                }
                c.a("Layer#restoreLayer");
                canvas.restore();
                c.b("Layer#restoreLayer");
            }
            if (this.f8773z && (paint = this.A) != null) {
                paint.setStyle(Paint.Style.STROKE);
                this.A.setColor(-251901);
                this.A.setStrokeWidth(4.0f);
                canvas.drawRect(this.f8756i, this.A);
                this.A.setStyle(Paint.Style.FILL);
                this.A.setColor(1357638635);
                canvas.drawRect(this.f8756i, this.A);
            }
            F(c.b(this.f8761n));
            return;
        }
        this.f8749b.preConcat(this.f8771x.f());
        c.a("Layer#drawLayer");
        t(canvas, this.f8749b, i12);
        c.b("Layer#drawLayer");
        F(c.b(this.f8761n));
    }

    public void i(u2.a<?, ?> aVar) {
        if (aVar != null) {
            this.f8770w.add(aVar);
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void t(Canvas canvas, Matrix matrix, int i10);

    public y2.a v() {
        return this.f8764q.a();
    }

    public BlurMaskFilter w(float f10) {
        if (this.B == f10) {
            return this.C;
        }
        BlurMaskFilter blurMaskFilter = new BlurMaskFilter(f10 / 2.0f, BlurMaskFilter.Blur.NORMAL);
        this.C = blurMaskFilter;
        this.B = f10;
        return blurMaskFilter;
    }

    public b3.j x() {
        return this.f8764q.c();
    }

    /* access modifiers changed from: package-private */
    public Layer y() {
        return this.f8764q;
    }

    /* access modifiers changed from: package-private */
    public boolean z() {
        h hVar = this.f8765r;
        return hVar != null && !hVar.a().isEmpty();
    }
}

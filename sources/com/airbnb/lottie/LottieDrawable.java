package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import b3.v;
import c3.f;
import c3.g;
import c3.i;
import d3.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.cli.HelpFormatter;
import w2.d;

public class LottieDrawable extends Drawable implements Drawable.Callback, Animatable {
    private boolean B;
    private boolean C;
    private RenderMode D;
    private boolean E;
    private final Matrix F;
    private Bitmap G;
    private Canvas H;
    private Rect I;
    private RectF J;
    private Paint K;
    private Rect L;
    private Rect M;
    private RectF N;
    private RectF O;
    private Matrix P;
    private Matrix Q;
    private boolean R;

    /* renamed from: a  reason: collision with root package name */
    private h f8491a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final g f8492b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f8493c = true;

    /* renamed from: d  reason: collision with root package name */
    private boolean f8494d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f8495e = false;

    /* renamed from: f  reason: collision with root package name */
    private OnVisibleAction f8496f = OnVisibleAction.NONE;

    /* renamed from: g  reason: collision with root package name */
    private final ArrayList<b> f8497g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    private final ValueAnimator.AnimatorUpdateListener f8498h;

    /* renamed from: j  reason: collision with root package name */
    private v2.b f8499j;

    /* renamed from: k  reason: collision with root package name */
    private String f8500k;

    /* renamed from: l  reason: collision with root package name */
    private b f8501l;

    /* renamed from: m  reason: collision with root package name */
    private v2.a f8502m;

    /* renamed from: n  reason: collision with root package name */
    private Map<String, Typeface> f8503n;

    /* renamed from: p  reason: collision with root package name */
    String f8504p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f8505q;

    /* renamed from: t  reason: collision with root package name */
    private boolean f8506t;

    /* renamed from: w  reason: collision with root package name */
    private boolean f8507w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public com.airbnb.lottie.model.layer.b f8508x;

    /* renamed from: y  reason: collision with root package name */
    private int f8509y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f8510z;

    private enum OnVisibleAction {
        NONE,
        PLAY,
        RESUME
    }

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (LottieDrawable.this.f8508x != null) {
                LottieDrawable.this.f8508x.L(LottieDrawable.this.f8492b.l());
            }
        }
    }

    private interface b {
        void a(h hVar);
    }

    public LottieDrawable() {
        g gVar = new g();
        this.f8492b = gVar;
        a aVar = new a();
        this.f8498h = aVar;
        this.f8506t = false;
        this.f8507w = true;
        this.f8509y = 255;
        this.D = RenderMode.AUTOMATIC;
        this.E = false;
        this.F = new Matrix();
        this.R = false;
        gVar.addUpdateListener(aVar);
    }

    private void C(int i10, int i11) {
        Bitmap bitmap = this.G;
        if (bitmap == null || bitmap.getWidth() < i10 || this.G.getHeight() < i11) {
            Bitmap createBitmap = Bitmap.createBitmap(i10, i11, Bitmap.Config.ARGB_8888);
            this.G = createBitmap;
            this.H.setBitmap(createBitmap);
            this.R = true;
        } else if (this.G.getWidth() > i10 || this.G.getHeight() > i11) {
            Bitmap createBitmap2 = Bitmap.createBitmap(this.G, 0, 0, i10, i11);
            this.G = createBitmap2;
            this.H.setBitmap(createBitmap2);
            this.R = true;
        }
    }

    private void D() {
        if (this.H == null) {
            this.H = new Canvas();
            this.O = new RectF();
            this.P = new Matrix();
            this.Q = new Matrix();
            this.I = new Rect();
            this.J = new RectF();
            this.K = new s2.a();
            this.L = new Rect();
            this.M = new Rect();
            this.N = new RectF();
        }
    }

    private Context H() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    private v2.a I() {
        if (getCallback() == null) {
            return null;
        }
        if (this.f8502m == null) {
            v2.a aVar = new v2.a(getCallback(), (a) null);
            this.f8502m = aVar;
            String str = this.f8504p;
            if (str != null) {
                aVar.c(str);
            }
        }
        return this.f8502m;
    }

    private v2.b K() {
        v2.b bVar = this.f8499j;
        if (bVar != null && !bVar.b(H())) {
            this.f8499j = null;
        }
        if (this.f8499j == null) {
            this.f8499j = new v2.b(getCallback(), this.f8500k, this.f8501l, this.f8491a.j());
        }
        return this.f8499j;
    }

    private boolean Y() {
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof View)) {
            return false;
        }
        ViewParent parent = ((View) callback).getParent();
        if (parent instanceof ViewGroup) {
            return !((ViewGroup) parent).getClipChildren();
        }
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c0(d dVar, Object obj, c cVar, h hVar) {
        q(dVar, obj, cVar);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d0(h hVar) {
        q0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e0(h hVar) {
        v0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f0(int i10, h hVar) {
        D0(i10);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g0(int i10, h hVar) {
        I0(i10);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h0(String str, h hVar) {
        J0(str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i0(float f10, h hVar) {
        K0(f10);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j0(int i10, int i11, h hVar) {
        L0(i10, i11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k0(String str, h hVar) {
        M0(str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l0(int i10, h hVar) {
        N0(i10);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m0(String str, h hVar) {
        O0(str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n0(float f10, h hVar) {
        P0(f10);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o0(float f10, h hVar) {
        S0(f10);
    }

    private boolean r() {
        return this.f8493c || this.f8494d;
    }

    private void s() {
        h hVar = this.f8491a;
        if (hVar != null) {
            com.airbnb.lottie.model.layer.b bVar = new com.airbnb.lottie.model.layer.b(this, v.a(hVar), hVar.k(), hVar);
            this.f8508x = bVar;
            if (this.B) {
                bVar.J(true);
            }
            this.f8508x.O(this.f8507w);
        }
    }

    private void t0(Canvas canvas, com.airbnb.lottie.model.layer.b bVar) {
        if (this.f8491a != null && bVar != null) {
            D();
            canvas.getMatrix(this.P);
            canvas.getClipBounds(this.I);
            w(this.I, this.J);
            this.P.mapRect(this.J);
            x(this.J, this.I);
            if (this.f8507w) {
                this.O.set(0.0f, 0.0f, (float) getIntrinsicWidth(), (float) getIntrinsicHeight());
            } else {
                bVar.f(this.O, (Matrix) null, false);
            }
            this.P.mapRect(this.O);
            Rect bounds = getBounds();
            float width = ((float) bounds.width()) / ((float) getIntrinsicWidth());
            float height = ((float) bounds.height()) / ((float) getIntrinsicHeight());
            w0(this.O, width, height);
            if (!Y()) {
                RectF rectF = this.O;
                Rect rect = this.I;
                rectF.intersect((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom);
            }
            int ceil = (int) Math.ceil((double) this.O.width());
            int ceil2 = (int) Math.ceil((double) this.O.height());
            if (ceil != 0 && ceil2 != 0) {
                C(ceil, ceil2);
                if (this.R) {
                    this.F.set(this.P);
                    this.F.preScale(width, height);
                    Matrix matrix = this.F;
                    RectF rectF2 = this.O;
                    matrix.postTranslate(-rectF2.left, -rectF2.top);
                    this.G.eraseColor(0);
                    bVar.h(this.H, this.F, this.f8509y);
                    this.P.invert(this.Q);
                    this.Q.mapRect(this.N, this.O);
                    x(this.N, this.M);
                }
                this.L.set(0, 0, ceil, ceil2);
                canvas.drawBitmap(this.G, this.L, this.M, this.K);
            }
        }
    }

    private void v() {
        h hVar = this.f8491a;
        if (hVar != null) {
            this.E = this.D.b(Build.VERSION.SDK_INT, hVar.q(), hVar.m());
        }
    }

    private void w(Rect rect, RectF rectF) {
        rectF.set((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom);
    }

    private void w0(RectF rectF, float f10, float f11) {
        rectF.set(rectF.left * f10, rectF.top * f11, rectF.right * f10, rectF.bottom * f11);
    }

    private void x(RectF rectF, Rect rect) {
        rect.set((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
    }

    private void y(Canvas canvas) {
        com.airbnb.lottie.model.layer.b bVar = this.f8508x;
        h hVar = this.f8491a;
        if (bVar != null && hVar != null) {
            this.F.reset();
            Rect bounds = getBounds();
            if (!bounds.isEmpty()) {
                this.F.preScale(((float) bounds.width()) / ((float) hVar.b().width()), ((float) bounds.height()) / ((float) hVar.b().height()));
                this.F.preTranslate((float) bounds.left, (float) bounds.top);
            }
            bVar.h(canvas, this.F, this.f8509y);
        }
    }

    public boolean A() {
        return this.f8505q;
    }

    public void A0(String str) {
        this.f8504p = str;
        v2.a I2 = I();
        if (I2 != null) {
            I2.c(str);
        }
    }

    public void B() {
        this.f8497g.clear();
        this.f8492b.k();
        if (!isVisible()) {
            this.f8496f = OnVisibleAction.NONE;
        }
    }

    public void B0(a aVar) {
        v2.a aVar2 = this.f8502m;
        if (aVar2 != null) {
            aVar2.d(aVar);
        }
    }

    public void C0(Map<String, Typeface> map) {
        if (map != this.f8503n) {
            this.f8503n = map;
            invalidateSelf();
        }
    }

    public void D0(int i10) {
        if (this.f8491a == null) {
            this.f8497g.add(new c0(this, i10));
        } else {
            this.f8492b.C((float) i10);
        }
    }

    public Bitmap E(String str) {
        v2.b K2 = K();
        if (K2 != null) {
            return K2.a(str);
        }
        return null;
    }

    public void E0(boolean z10) {
        this.f8494d = z10;
    }

    public boolean F() {
        return this.f8507w;
    }

    public void F0(b bVar) {
        this.f8501l = bVar;
        v2.b bVar2 = this.f8499j;
        if (bVar2 != null) {
            bVar2.d(bVar);
        }
    }

    public h G() {
        return this.f8491a;
    }

    public void G0(String str) {
        this.f8500k = str;
    }

    public void H0(boolean z10) {
        this.f8506t = z10;
    }

    public void I0(int i10) {
        if (this.f8491a == null) {
            this.f8497g.add(new w(this, i10));
        } else {
            this.f8492b.D(((float) i10) + 0.99f);
        }
    }

    public int J() {
        return (int) this.f8492b.o();
    }

    public void J0(String str) {
        h hVar = this.f8491a;
        if (hVar == null) {
            this.f8497g.add(new y(this, str));
            return;
        }
        w2.g l10 = hVar.l(str);
        if (l10 != null) {
            I0((int) (l10.f18184b + l10.f18185c));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void K0(float f10) {
        h hVar = this.f8491a;
        if (hVar == null) {
            this.f8497g.add(new a0(this, f10));
        } else {
            this.f8492b.D(i.i(hVar.p(), this.f8491a.f(), f10));
        }
    }

    public String L() {
        return this.f8500k;
    }

    public void L0(int i10, int i11) {
        if (this.f8491a == null) {
            this.f8497g.add(new t(this, i10, i11));
        } else {
            this.f8492b.E((float) i10, ((float) i11) + 0.99f);
        }
    }

    public d0 M(String str) {
        h hVar = this.f8491a;
        if (hVar == null) {
            return null;
        }
        return hVar.j().get(str);
    }

    public void M0(String str) {
        h hVar = this.f8491a;
        if (hVar == null) {
            this.f8497g.add(new r(this, str));
            return;
        }
        w2.g l10 = hVar.l(str);
        if (l10 != null) {
            int i10 = (int) l10.f18184b;
            L0(i10, ((int) l10.f18185c) + i10);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public boolean N() {
        return this.f8506t;
    }

    public void N0(int i10) {
        if (this.f8491a == null) {
            this.f8497g.add(new u(this, i10));
        } else {
            this.f8492b.F(i10);
        }
    }

    public float O() {
        return this.f8492b.q();
    }

    public void O0(String str) {
        h hVar = this.f8491a;
        if (hVar == null) {
            this.f8497g.add(new z(this, str));
            return;
        }
        w2.g l10 = hVar.l(str);
        if (l10 != null) {
            N0((int) l10.f18184b);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public float P() {
        return this.f8492b.r();
    }

    public void P0(float f10) {
        h hVar = this.f8491a;
        if (hVar == null) {
            this.f8497g.add(new v(this, f10));
        } else {
            N0((int) i.i(hVar.p(), this.f8491a.f(), f10));
        }
    }

    public m0 Q() {
        h hVar = this.f8491a;
        if (hVar != null) {
            return hVar.n();
        }
        return null;
    }

    public void Q0(boolean z10) {
        if (this.B != z10) {
            this.B = z10;
            com.airbnb.lottie.model.layer.b bVar = this.f8508x;
            if (bVar != null) {
                bVar.J(z10);
            }
        }
    }

    public float R() {
        return this.f8492b.l();
    }

    public void R0(boolean z10) {
        this.f8510z = z10;
        h hVar = this.f8491a;
        if (hVar != null) {
            hVar.v(z10);
        }
    }

    public RenderMode S() {
        return this.E ? RenderMode.SOFTWARE : RenderMode.HARDWARE;
    }

    public void S0(float f10) {
        if (this.f8491a == null) {
            this.f8497g.add(new q(this, f10));
            return;
        }
        c.a("Drawable#setProgress");
        this.f8492b.C(this.f8491a.h(f10));
        c.b("Drawable#setProgress");
    }

    public int T() {
        return this.f8492b.getRepeatCount();
    }

    public void T0(RenderMode renderMode) {
        this.D = renderMode;
        v();
    }

    @SuppressLint({"WrongConstant"})
    public int U() {
        return this.f8492b.getRepeatMode();
    }

    public void U0(int i10) {
        this.f8492b.setRepeatCount(i10);
    }

    public float V() {
        return this.f8492b.s();
    }

    public void V0(int i10) {
        this.f8492b.setRepeatMode(i10);
    }

    public q0 W() {
        return null;
    }

    public void W0(boolean z10) {
        this.f8495e = z10;
    }

    public Typeface X(w2.b bVar) {
        Map<String, Typeface> map = this.f8503n;
        if (map != null) {
            String a10 = bVar.a();
            if (map.containsKey(a10)) {
                return map.get(a10);
            }
            String b10 = bVar.b();
            if (map.containsKey(b10)) {
                return map.get(b10);
            }
            String str = bVar.a() + HelpFormatter.DEFAULT_OPT_PREFIX + bVar.c();
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        v2.a I2 = I();
        if (I2 != null) {
            return I2.b(bVar);
        }
        return null;
    }

    public void X0(float f10) {
        this.f8492b.G(f10);
    }

    public void Y0(Boolean bool) {
        this.f8493c = bool.booleanValue();
    }

    public boolean Z() {
        g gVar = this.f8492b;
        if (gVar == null) {
            return false;
        }
        return gVar.isRunning();
    }

    public void Z0(q0 q0Var) {
    }

    /* access modifiers changed from: package-private */
    public boolean a0() {
        if (isVisible()) {
            return this.f8492b.isRunning();
        }
        OnVisibleAction onVisibleAction = this.f8496f;
        if (onVisibleAction == OnVisibleAction.PLAY || onVisibleAction == OnVisibleAction.RESUME) {
            return true;
        }
        return false;
    }

    public void a1(boolean z10) {
        this.f8492b.H(z10);
    }

    public boolean b0() {
        return this.C;
    }

    public boolean b1() {
        return this.f8503n == null && this.f8491a.c().o() > 0;
    }

    public void draw(@NonNull Canvas canvas) {
        c.a("Drawable#draw");
        if (this.f8495e) {
            try {
                if (this.E) {
                    t0(canvas, this.f8508x);
                } else {
                    y(canvas);
                }
            } catch (Throwable th2) {
                f.b("Lottie crashed in draw!", th2);
            }
        } else if (this.E) {
            t0(canvas, this.f8508x);
        } else {
            y(canvas);
        }
        this.R = false;
        c.b("Drawable#draw");
    }

    public int getAlpha() {
        return this.f8509y;
    }

    public int getIntrinsicHeight() {
        h hVar = this.f8491a;
        if (hVar == null) {
            return -1;
        }
        return hVar.b().height();
    }

    public int getIntrinsicWidth() {
        h hVar = this.f8491a;
        if (hVar == null) {
            return -1;
        }
        return hVar.b().width();
    }

    public int getOpacity() {
        return -3;
    }

    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public void invalidateSelf() {
        if (!this.R) {
            this.R = true;
            Drawable.Callback callback = getCallback();
            if (callback != null) {
                callback.invalidateDrawable(this);
            }
        }
    }

    public boolean isRunning() {
        return Z();
    }

    public void p(Animator.AnimatorListener animatorListener) {
        this.f8492b.addListener(animatorListener);
    }

    public void p0() {
        this.f8497g.clear();
        this.f8492b.u();
        if (!isVisible()) {
            this.f8496f = OnVisibleAction.NONE;
        }
    }

    public <T> void q(d dVar, T t10, c<T> cVar) {
        com.airbnb.lottie.model.layer.b bVar = this.f8508x;
        if (bVar == null) {
            this.f8497g.add(new s(this, dVar, t10, cVar));
            return;
        }
        boolean z10 = true;
        if (dVar == d.f18178c) {
            bVar.c(t10, cVar);
        } else if (dVar.d() != null) {
            dVar.d().c(t10, cVar);
        } else {
            List<d> u02 = u0(dVar);
            for (int i10 = 0; i10 < u02.size(); i10++) {
                u02.get(i10).d().c(t10, cVar);
            }
            z10 = true ^ u02.isEmpty();
        }
        if (z10) {
            invalidateSelf();
            if (t10 == h0.E) {
                S0(R());
            }
        }
    }

    public void q0() {
        float f10;
        if (this.f8508x == null) {
            this.f8497g.add(new b0(this));
            return;
        }
        v();
        if (r() || T() == 0) {
            if (isVisible()) {
                this.f8492b.v();
                this.f8496f = OnVisibleAction.NONE;
            } else {
                this.f8496f = OnVisibleAction.PLAY;
            }
        }
        if (!r()) {
            if (V() < 0.0f) {
                f10 = P();
            } else {
                f10 = O();
            }
            D0((int) f10);
            this.f8492b.k();
            if (!isVisible()) {
                this.f8496f = OnVisibleAction.NONE;
            }
        }
    }

    public void r0() {
        this.f8492b.removeAllListeners();
    }

    public void s0() {
        this.f8492b.removeAllUpdateListeners();
        this.f8492b.addUpdateListener(this.f8498h);
    }

    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j10) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j10);
        }
    }

    public void setAlpha(int i10) {
        this.f8509y = i10;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        f.c("Use addColorFilter instead.");
    }

    public boolean setVisible(boolean z10, boolean z11) {
        boolean z12 = !isVisible();
        boolean visible = super.setVisible(z10, z11);
        if (z10) {
            OnVisibleAction onVisibleAction = this.f8496f;
            if (onVisibleAction == OnVisibleAction.PLAY) {
                q0();
            } else if (onVisibleAction == OnVisibleAction.RESUME) {
                v0();
            }
        } else if (this.f8492b.isRunning()) {
            p0();
            this.f8496f = OnVisibleAction.RESUME;
        } else if (!z12) {
            this.f8496f = OnVisibleAction.NONE;
        }
        return visible;
    }

    public void start() {
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof View) || !((View) callback).isInEditMode()) {
            q0();
        }
    }

    public void stop() {
        B();
    }

    public void t() {
        this.f8497g.clear();
        this.f8492b.cancel();
        if (!isVisible()) {
            this.f8496f = OnVisibleAction.NONE;
        }
    }

    public void u() {
        if (this.f8492b.isRunning()) {
            this.f8492b.cancel();
            if (!isVisible()) {
                this.f8496f = OnVisibleAction.NONE;
            }
        }
        this.f8491a = null;
        this.f8508x = null;
        this.f8499j = null;
        this.f8492b.j();
        invalidateSelf();
    }

    public List<d> u0(d dVar) {
        if (this.f8508x == null) {
            f.c("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.f8508x.e(dVar, 0, arrayList, new d(new String[0]));
        return arrayList;
    }

    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public void v0() {
        float f10;
        if (this.f8508x == null) {
            this.f8497g.add(new x(this));
            return;
        }
        v();
        if (r() || T() == 0) {
            if (isVisible()) {
                this.f8492b.z();
                this.f8496f = OnVisibleAction.NONE;
            } else {
                this.f8496f = OnVisibleAction.RESUME;
            }
        }
        if (!r()) {
            if (V() < 0.0f) {
                f10 = P();
            } else {
                f10 = O();
            }
            D0((int) f10);
            this.f8492b.k();
            if (!isVisible()) {
                this.f8496f = OnVisibleAction.NONE;
            }
        }
    }

    public void x0(boolean z10) {
        this.C = z10;
    }

    public void y0(boolean z10) {
        if (z10 != this.f8507w) {
            this.f8507w = z10;
            com.airbnb.lottie.model.layer.b bVar = this.f8508x;
            if (bVar != null) {
                bVar.O(z10);
            }
            invalidateSelf();
        }
    }

    public void z(boolean z10) {
        if (this.f8505q != z10) {
            this.f8505q = z10;
            if (this.f8491a != null) {
                s();
            }
        }
    }

    public boolean z0(h hVar) {
        if (this.f8491a == hVar) {
            return false;
        }
        this.R = true;
        u();
        this.f8491a = hVar;
        s();
        this.f8492b.B(hVar);
        S0(this.f8492b.getAnimatedFraction());
        Iterator it = new ArrayList(this.f8497g).iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar != null) {
                bVar.a(hVar);
            }
            it.remove();
        }
        this.f8497g.clear();
        hVar.v(this.f8510z);
        v();
        Drawable.Callback callback = getCallback();
        if (callback instanceof ImageView) {
            ImageView imageView = (ImageView) callback;
            imageView.setImageDrawable((Drawable) null);
            imageView.setImageDrawable(this);
        }
        return true;
    }
}

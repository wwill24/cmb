package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.core.view.n0;
import java.util.ArrayList;
import java.util.Iterator;
import tf.n;

class b {
    static final TimeInterpolator D = cf.a.f18979c;
    private static final int E = bf.b.motionDurationLong2;
    private static final int F = bf.b.motionEasingEmphasizedInterpolator;
    private static final int G = bf.b.motionDurationMedium1;
    private static final int H = bf.b.motionEasingEmphasizedAccelerateInterpolator;
    static final int[] I = {16842919, 16842910};
    static final int[] J = {16843623, 16842908, 16842910};
    static final int[] K = {16842908, 16842910};
    static final int[] L = {16843623, 16842910};
    static final int[] M = {16842910};
    static final int[] N = new int[0];
    private final RectF A = new RectF();
    private final Matrix B = new Matrix();
    private ViewTreeObserver.OnPreDrawListener C;

    /* renamed from: a  reason: collision with root package name */
    tf.k f19729a;

    /* renamed from: b  reason: collision with root package name */
    tf.g f19730b;

    /* renamed from: c  reason: collision with root package name */
    Drawable f19731c;

    /* renamed from: d  reason: collision with root package name */
    a f19732d;

    /* renamed from: e  reason: collision with root package name */
    Drawable f19733e;

    /* renamed from: f  reason: collision with root package name */
    boolean f19734f;

    /* renamed from: g  reason: collision with root package name */
    boolean f19735g = true;

    /* renamed from: h  reason: collision with root package name */
    float f19736h;

    /* renamed from: i  reason: collision with root package name */
    float f19737i;

    /* renamed from: j  reason: collision with root package name */
    float f19738j;

    /* renamed from: k  reason: collision with root package name */
    int f19739k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    private final com.google.android.material.internal.l f19740l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public Animator f19741m;

    /* renamed from: n  reason: collision with root package name */
    private cf.h f19742n;

    /* renamed from: o  reason: collision with root package name */
    private cf.h f19743o;

    /* renamed from: p  reason: collision with root package name */
    private float f19744p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public float f19745q = 1.0f;

    /* renamed from: r  reason: collision with root package name */
    private int f19746r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public int f19747s = 0;

    /* renamed from: t  reason: collision with root package name */
    private ArrayList<Animator.AnimatorListener> f19748t;

    /* renamed from: u  reason: collision with root package name */
    private ArrayList<Animator.AnimatorListener> f19749u;

    /* renamed from: v  reason: collision with root package name */
    private ArrayList<j> f19750v;

    /* renamed from: w  reason: collision with root package name */
    final FloatingActionButton f19751w;

    /* renamed from: x  reason: collision with root package name */
    final sf.b f19752x;

    /* renamed from: y  reason: collision with root package name */
    private final Rect f19753y = new Rect();

    /* renamed from: z  reason: collision with root package name */
    private final RectF f19754z = new RectF();

    class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private boolean f19755a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f19756b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ k f19757c;

        a(boolean z10, k kVar) {
            this.f19756b = z10;
            this.f19757c = kVar;
        }

        public void onAnimationCancel(Animator animator) {
            this.f19755a = true;
        }

        public void onAnimationEnd(Animator animator) {
            int i10;
            int unused = b.this.f19747s = 0;
            Animator unused2 = b.this.f19741m = null;
            if (!this.f19755a) {
                FloatingActionButton floatingActionButton = b.this.f19751w;
                boolean z10 = this.f19756b;
                if (z10) {
                    i10 = 8;
                } else {
                    i10 = 4;
                }
                floatingActionButton.d(i10, z10);
                k kVar = this.f19757c;
                if (kVar != null) {
                    kVar.b();
                }
            }
        }

        public void onAnimationStart(Animator animator) {
            b.this.f19751w.d(0, this.f19756b);
            int unused = b.this.f19747s = 1;
            Animator unused2 = b.this.f19741m = animator;
            this.f19755a = false;
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.b$b  reason: collision with other inner class name */
    class C0236b extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f19759a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ k f19760b;

        C0236b(boolean z10, k kVar) {
            this.f19759a = z10;
            this.f19760b = kVar;
        }

        public void onAnimationEnd(Animator animator) {
            int unused = b.this.f19747s = 0;
            Animator unused2 = b.this.f19741m = null;
            k kVar = this.f19760b;
            if (kVar != null) {
                kVar.a();
            }
        }

        public void onAnimationStart(Animator animator) {
            b.this.f19751w.d(0, this.f19759a);
            int unused = b.this.f19747s = 2;
            Animator unused2 = b.this.f19741m = animator;
        }
    }

    class c extends cf.g {
        c() {
        }

        /* renamed from: a */
        public Matrix evaluate(float f10, @NonNull Matrix matrix, @NonNull Matrix matrix2) {
            float unused = b.this.f19745q = f10;
            return super.a(f10, matrix, matrix2);
        }
    }

    class d implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ float f19763a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ float f19764b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ float f19765c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ float f19766d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ float f19767e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ float f19768f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ float f19769g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ Matrix f19770h;

        d(float f10, float f11, float f12, float f13, float f14, float f15, float f16, Matrix matrix) {
            this.f19763a = f10;
            this.f19764b = f11;
            this.f19765c = f12;
            this.f19766d = f13;
            this.f19767e = f14;
            this.f19768f = f15;
            this.f19769g = f16;
            this.f19770h = matrix;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            b.this.f19751w.setAlpha(cf.a.b(this.f19763a, this.f19764b, 0.0f, 0.2f, floatValue));
            b.this.f19751w.setScaleX(cf.a.a(this.f19765c, this.f19766d, floatValue));
            b.this.f19751w.setScaleY(cf.a.a(this.f19767e, this.f19766d, floatValue));
            float unused = b.this.f19745q = cf.a.a(this.f19768f, this.f19769g, floatValue);
            b.this.h(cf.a.a(this.f19768f, this.f19769g, floatValue), this.f19770h);
            b.this.f19751w.setImageMatrix(this.f19770h);
        }
    }

    class e implements TypeEvaluator<Float> {

        /* renamed from: a  reason: collision with root package name */
        FloatEvaluator f19772a = new FloatEvaluator();

        e() {
        }

        /* renamed from: a */
        public Float evaluate(float f10, Float f11, Float f12) {
            float floatValue = this.f19772a.evaluate(f10, f11, f12).floatValue();
            if (floatValue < 0.1f) {
                floatValue = 0.0f;
            }
            return Float.valueOf(floatValue);
        }
    }

    class f implements ViewTreeObserver.OnPreDrawListener {
        f() {
        }

        public boolean onPreDraw() {
            b.this.G();
            return true;
        }
    }

    private class g extends m {
        g() {
            super(b.this, (a) null);
        }

        /* access modifiers changed from: protected */
        public float a() {
            return 0.0f;
        }
    }

    private class h extends m {
        h() {
            super(b.this, (a) null);
        }

        /* access modifiers changed from: protected */
        public float a() {
            b bVar = b.this;
            return bVar.f19736h + bVar.f19737i;
        }
    }

    private class i extends m {
        i() {
            super(b.this, (a) null);
        }

        /* access modifiers changed from: protected */
        public float a() {
            b bVar = b.this;
            return bVar.f19736h + bVar.f19738j;
        }
    }

    interface j {
        void a();

        void b();
    }

    interface k {
        void a();

        void b();
    }

    private class l extends m {
        l() {
            super(b.this, (a) null);
        }

        /* access modifiers changed from: protected */
        public float a() {
            return b.this.f19736h;
        }
    }

    private abstract class m extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        private boolean f19779a;

        /* renamed from: b  reason: collision with root package name */
        private float f19780b;

        /* renamed from: c  reason: collision with root package name */
        private float f19781c;

        private m() {
        }

        /* access modifiers changed from: protected */
        public abstract float a();

        public void onAnimationEnd(Animator animator) {
            b.this.f0((float) ((int) this.f19781c));
            this.f19779a = false;
        }

        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            float f10;
            if (!this.f19779a) {
                tf.g gVar = b.this.f19730b;
                if (gVar == null) {
                    f10 = 0.0f;
                } else {
                    f10 = gVar.w();
                }
                this.f19780b = f10;
                this.f19781c = a();
                this.f19779a = true;
            }
            b bVar = b.this;
            float f11 = this.f19780b;
            bVar.f0((float) ((int) (f11 + ((this.f19781c - f11) * valueAnimator.getAnimatedFraction()))));
        }

        /* synthetic */ m(b bVar, a aVar) {
            this();
        }
    }

    b(FloatingActionButton floatingActionButton, sf.b bVar) {
        this.f19751w = floatingActionButton;
        this.f19752x = bVar;
        com.google.android.material.internal.l lVar = new com.google.android.material.internal.l();
        this.f19740l = lVar;
        lVar.a(I, k(new i()));
        lVar.a(J, k(new h()));
        lVar.a(K, k(new h()));
        lVar.a(L, k(new h()));
        lVar.a(M, k(new l()));
        lVar.a(N, k(new g()));
        this.f19744p = floatingActionButton.getRotation();
    }

    private boolean Z() {
        return n0.W(this.f19751w) && !this.f19751w.isInEditMode();
    }

    private void g0(ObjectAnimator objectAnimator) {
        if (Build.VERSION.SDK_INT == 26) {
            objectAnimator.setEvaluator(new e());
        }
    }

    /* access modifiers changed from: private */
    public void h(float f10, @NonNull Matrix matrix) {
        matrix.reset();
        Drawable drawable = this.f19751w.getDrawable();
        if (drawable != null && this.f19746r != 0) {
            RectF rectF = this.f19754z;
            RectF rectF2 = this.A;
            rectF.set(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
            int i10 = this.f19746r;
            rectF2.set(0.0f, 0.0f, (float) i10, (float) i10);
            matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            int i11 = this.f19746r;
            matrix.postScale(f10, f10, ((float) i11) / 2.0f, ((float) i11) / 2.0f);
        }
    }

    @NonNull
    private AnimatorSet i(@NonNull cf.h hVar, float f10, float f11, float f12) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f19751w, View.ALPHA, new float[]{f10});
        hVar.e("opacity").a(ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f19751w, View.SCALE_X, new float[]{f11});
        hVar.e("scale").a(ofFloat2);
        g0(ofFloat2);
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f19751w, View.SCALE_Y, new float[]{f11});
        hVar.e("scale").a(ofFloat3);
        g0(ofFloat3);
        arrayList.add(ofFloat3);
        h(f12, this.B);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.f19751w, new cf.f(), new c(), new Matrix[]{new Matrix(this.B)});
        hVar.e("iconScale").a(ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        cf.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    private AnimatorSet j(float f10, float f11, float f12, int i10, int i11) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(new d(this.f19751w.getAlpha(), f10, this.f19751w.getScaleX(), f11, this.f19751w.getScaleY(), this.f19745q, f12, new Matrix(this.B)));
        arrayList.add(ofFloat);
        cf.b.a(animatorSet, arrayList);
        animatorSet.setDuration((long) of.a.f(this.f19751w.getContext(), i10, this.f19751w.getContext().getResources().getInteger(bf.g.material_motion_duration_long_1)));
        animatorSet.setInterpolator(of.a.g(this.f19751w.getContext(), i11, cf.a.f18978b));
        return animatorSet;
    }

    @NonNull
    private ValueAnimator k(@NonNull m mVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(D);
        valueAnimator.setDuration(100);
        valueAnimator.addListener(mVar);
        valueAnimator.addUpdateListener(mVar);
        valueAnimator.setFloatValues(new float[]{0.0f, 1.0f});
        return valueAnimator;
    }

    @NonNull
    private ViewTreeObserver.OnPreDrawListener q() {
        if (this.C == null) {
            this.C = new f();
        }
        return this.C;
    }

    /* access modifiers changed from: package-private */
    public void A() {
        tf.g gVar = this.f19730b;
        if (gVar != null) {
            tf.h.f(this.f19751w, gVar);
        }
        if (J()) {
            this.f19751w.getViewTreeObserver().addOnPreDrawListener(q());
        }
    }

    /* access modifiers changed from: package-private */
    public void B() {
        throw null;
    }

    /* access modifiers changed from: package-private */
    public void C() {
        ViewTreeObserver viewTreeObserver = this.f19751w.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.C;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            this.C = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void D(int[] iArr) {
        throw null;
    }

    /* access modifiers changed from: package-private */
    public void E(float f10, float f11, float f12) {
        throw null;
    }

    /* access modifiers changed from: package-private */
    public void F(@NonNull Rect rect) {
        androidx.core.util.h.h(this.f19733e, "Didn't initialize content background");
        if (Y()) {
            this.f19752x.c(new InsetDrawable(this.f19733e, rect.left, rect.top, rect.right, rect.bottom));
            return;
        }
        this.f19752x.c(this.f19733e);
    }

    /* access modifiers changed from: package-private */
    public void G() {
        float rotation = this.f19751w.getRotation();
        if (this.f19744p != rotation) {
            this.f19744p = rotation;
            c0();
        }
    }

    /* access modifiers changed from: package-private */
    public void H() {
        ArrayList<j> arrayList = this.f19750v;
        if (arrayList != null) {
            Iterator<j> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void I() {
        ArrayList<j> arrayList = this.f19750v;
        if (arrayList != null) {
            Iterator<j> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean J() {
        throw null;
    }

    /* access modifiers changed from: package-private */
    public void K(ColorStateList colorStateList) {
        tf.g gVar = this.f19730b;
        if (gVar != null) {
            gVar.setTintList(colorStateList);
        }
        a aVar = this.f19732d;
        if (aVar != null) {
            aVar.c(colorStateList);
        }
    }

    /* access modifiers changed from: package-private */
    public void L(PorterDuff.Mode mode) {
        tf.g gVar = this.f19730b;
        if (gVar != null) {
            gVar.setTintMode(mode);
        }
    }

    /* access modifiers changed from: package-private */
    public final void M(float f10) {
        if (this.f19736h != f10) {
            this.f19736h = f10;
            E(f10, this.f19737i, this.f19738j);
        }
    }

    /* access modifiers changed from: package-private */
    public void N(boolean z10) {
        this.f19734f = z10;
    }

    /* access modifiers changed from: package-private */
    public final void O(cf.h hVar) {
        this.f19743o = hVar;
    }

    /* access modifiers changed from: package-private */
    public final void P(float f10) {
        if (this.f19737i != f10) {
            this.f19737i = f10;
            E(this.f19736h, f10, this.f19738j);
        }
    }

    /* access modifiers changed from: package-private */
    public final void Q(float f10) {
        this.f19745q = f10;
        Matrix matrix = this.B;
        h(f10, matrix);
        this.f19751w.setImageMatrix(matrix);
    }

    /* access modifiers changed from: package-private */
    public final void R(int i10) {
        if (this.f19746r != i10) {
            this.f19746r = i10;
            d0();
        }
    }

    /* access modifiers changed from: package-private */
    public void S(int i10) {
        this.f19739k = i10;
    }

    /* access modifiers changed from: package-private */
    public final void T(float f10) {
        if (this.f19738j != f10) {
            this.f19738j = f10;
            E(this.f19736h, this.f19737i, f10);
        }
    }

    /* access modifiers changed from: package-private */
    public void U(ColorStateList colorStateList) {
        Drawable drawable = this.f19731c;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.o(drawable, rf.b.d(colorStateList));
        }
    }

    /* access modifiers changed from: package-private */
    public void V(boolean z10) {
        this.f19735g = z10;
        e0();
    }

    /* access modifiers changed from: package-private */
    public final void W(@NonNull tf.k kVar) {
        this.f19729a = kVar;
        tf.g gVar = this.f19730b;
        if (gVar != null) {
            gVar.setShapeAppearanceModel(kVar);
        }
        Drawable drawable = this.f19731c;
        if (drawable instanceof n) {
            ((n) drawable).setShapeAppearanceModel(kVar);
        }
        a aVar = this.f19732d;
        if (aVar != null) {
            aVar.f(kVar);
        }
    }

    /* access modifiers changed from: package-private */
    public final void X(cf.h hVar) {
        this.f19742n = hVar;
    }

    /* access modifiers changed from: package-private */
    public boolean Y() {
        throw null;
    }

    /* access modifiers changed from: package-private */
    public final boolean a0() {
        return !this.f19734f || this.f19751w.getSizeDimension() >= this.f19739k;
    }

    /* access modifiers changed from: package-private */
    public void b0(k kVar, boolean z10) {
        boolean z11;
        AnimatorSet animatorSet;
        float f10;
        float f11;
        if (!y()) {
            Animator animator = this.f19741m;
            if (animator != null) {
                animator.cancel();
            }
            if (this.f19742n == null) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (Z()) {
                if (this.f19751w.getVisibility() != 0) {
                    float f12 = 0.0f;
                    this.f19751w.setAlpha(0.0f);
                    FloatingActionButton floatingActionButton = this.f19751w;
                    if (z11) {
                        f10 = 0.4f;
                    } else {
                        f10 = 0.0f;
                    }
                    floatingActionButton.setScaleY(f10);
                    FloatingActionButton floatingActionButton2 = this.f19751w;
                    if (z11) {
                        f11 = 0.4f;
                    } else {
                        f11 = 0.0f;
                    }
                    floatingActionButton2.setScaleX(f11);
                    if (z11) {
                        f12 = 0.4f;
                    }
                    Q(f12);
                }
                cf.h hVar = this.f19742n;
                if (hVar != null) {
                    animatorSet = i(hVar, 1.0f, 1.0f, 1.0f);
                } else {
                    animatorSet = j(1.0f, 1.0f, 1.0f, E, F);
                }
                animatorSet.addListener(new C0236b(z10, kVar));
                ArrayList<Animator.AnimatorListener> arrayList = this.f19748t;
                if (arrayList != null) {
                    Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                    while (it.hasNext()) {
                        animatorSet.addListener(it.next());
                    }
                }
                animatorSet.start();
                return;
            }
            this.f19751w.d(0, z10);
            this.f19751w.setAlpha(1.0f);
            this.f19751w.setScaleY(1.0f);
            this.f19751w.setScaleX(1.0f);
            Q(1.0f);
            if (kVar != null) {
                kVar.a();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c0() {
        throw null;
    }

    /* access modifiers changed from: package-private */
    public final void d0() {
        Q(this.f19745q);
    }

    public void e(@NonNull Animator.AnimatorListener animatorListener) {
        if (this.f19749u == null) {
            this.f19749u = new ArrayList<>();
        }
        this.f19749u.add(animatorListener);
    }

    /* access modifiers changed from: package-private */
    public final void e0() {
        Rect rect = this.f19753y;
        r(rect);
        F(rect);
        this.f19752x.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* access modifiers changed from: package-private */
    public void f(@NonNull Animator.AnimatorListener animatorListener) {
        if (this.f19748t == null) {
            this.f19748t = new ArrayList<>();
        }
        this.f19748t.add(animatorListener);
    }

    /* access modifiers changed from: package-private */
    public void f0(float f10) {
        tf.g gVar = this.f19730b;
        if (gVar != null) {
            gVar.a0(f10);
        }
    }

    /* access modifiers changed from: package-private */
    public void g(@NonNull j jVar) {
        if (this.f19750v == null) {
            this.f19750v = new ArrayList<>();
        }
        this.f19750v.add(jVar);
    }

    /* access modifiers changed from: package-private */
    public final Drawable l() {
        return this.f19733e;
    }

    /* access modifiers changed from: package-private */
    public float m() {
        throw null;
    }

    /* access modifiers changed from: package-private */
    public boolean n() {
        return this.f19734f;
    }

    /* access modifiers changed from: package-private */
    public final cf.h o() {
        return this.f19743o;
    }

    /* access modifiers changed from: package-private */
    public float p() {
        return this.f19737i;
    }

    /* access modifiers changed from: package-private */
    public void r(@NonNull Rect rect) {
        int i10;
        float f10;
        if (this.f19734f) {
            i10 = (this.f19739k - this.f19751w.getSizeDimension()) / 2;
        } else {
            i10 = 0;
        }
        if (this.f19735g) {
            f10 = m() + this.f19738j;
        } else {
            f10 = 0.0f;
        }
        int max = Math.max(i10, (int) Math.ceil((double) f10));
        int max2 = Math.max(i10, (int) Math.ceil((double) (f10 * 1.5f)));
        rect.set(max, max2, max, max2);
    }

    /* access modifiers changed from: package-private */
    public float s() {
        return this.f19738j;
    }

    /* access modifiers changed from: package-private */
    public final tf.k t() {
        return this.f19729a;
    }

    /* access modifiers changed from: package-private */
    public final cf.h u() {
        return this.f19742n;
    }

    /* access modifiers changed from: package-private */
    public void v(k kVar, boolean z10) {
        int i10;
        AnimatorSet animatorSet;
        if (!x()) {
            Animator animator = this.f19741m;
            if (animator != null) {
                animator.cancel();
            }
            if (Z()) {
                cf.h hVar = this.f19743o;
                if (hVar != null) {
                    animatorSet = i(hVar, 0.0f, 0.0f, 0.0f);
                } else {
                    animatorSet = j(0.0f, 0.4f, 0.4f, G, H);
                }
                animatorSet.addListener(new a(z10, kVar));
                ArrayList<Animator.AnimatorListener> arrayList = this.f19749u;
                if (arrayList != null) {
                    Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                    while (it.hasNext()) {
                        animatorSet.addListener(it.next());
                    }
                }
                animatorSet.start();
                return;
            }
            FloatingActionButton floatingActionButton = this.f19751w;
            if (z10) {
                i10 = 8;
            } else {
                i10 = 4;
            }
            floatingActionButton.d(i10, z10);
            if (kVar != null) {
                kVar.b();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void w(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i10) {
        throw null;
    }

    /* access modifiers changed from: package-private */
    public boolean x() {
        if (this.f19751w.getVisibility() == 0) {
            if (this.f19747s == 1) {
                return true;
            }
            return false;
        } else if (this.f19747s != 2) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean y() {
        if (this.f19751w.getVisibility() != 0) {
            if (this.f19747s == 2) {
                return true;
            }
            return false;
        } else if (this.f19747s != 1) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public void z() {
        throw null;
    }
}

package com.google.android.material.snackbar;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.h0;
import androidx.core.view.k2;
import androidx.core.view.n0;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.c;
import com.leanplum.messagetemplates.MessageTemplateConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import net.bytebuddy.jar.asm.Opcodes;

public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {
    private static final TimeInterpolator A = cf.a.f18977a;
    private static final TimeInterpolator B = cf.a.f18980d;
    @NonNull
    static final Handler C = new Handler(Looper.getMainLooper(), new h());
    /* access modifiers changed from: private */
    public static final boolean D = false;
    private static final int[] E = {bf.b.snackbarStyle};
    /* access modifiers changed from: private */
    public static final String F = BaseTransientBottomBar.class.getSimpleName();

    /* renamed from: z  reason: collision with root package name */
    private static final TimeInterpolator f20070z = cf.a.f18978b;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final int f20071a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final int f20072b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final int f20073c;

    /* renamed from: d  reason: collision with root package name */
    private final TimeInterpolator f20074d;

    /* renamed from: e  reason: collision with root package name */
    private final TimeInterpolator f20075e;

    /* renamed from: f  reason: collision with root package name */
    private final TimeInterpolator f20076f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final ViewGroup f20077g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final Context f20078h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    protected final t f20079i;
    /* access modifiers changed from: private */
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final a f20080j;

    /* renamed from: k  reason: collision with root package name */
    private int f20081k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f20082l;

    /* renamed from: m  reason: collision with root package name */
    private q f20083m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public boolean f20084n = false;

    /* renamed from: o  reason: collision with root package name */
    private final Runnable f20085o = new i();
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public int f20086p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public int f20087q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public int f20088r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public int f20089s;

    /* renamed from: t  reason: collision with root package name */
    private int f20090t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f20091u;

    /* renamed from: v  reason: collision with root package name */
    private List<r<B>> f20092v;

    /* renamed from: w  reason: collision with root package name */
    private Behavior f20093w;

    /* renamed from: x  reason: collision with root package name */
    private final AccessibilityManager f20094x;
    @NonNull

    /* renamed from: y  reason: collision with root package name */
    c.b f20095y = new l();

    public static class Behavior extends SwipeDismissBehavior<View> {
        @NonNull

        /* renamed from: l  reason: collision with root package name */
        private final s f20096l = new s(this);

        /* access modifiers changed from: private */
        public void Q(@NonNull BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f20096l.c(baseTransientBottomBar);
        }

        public boolean F(View view) {
            return this.f20096l.a(view);
        }

        public boolean k(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
            this.f20096l.b(coordinatorLayout, view, motionEvent);
            return super.k(coordinatorLayout, view, motionEvent);
        }
    }

    class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f20097a;

        a(int i10) {
            this.f20097a = i10;
        }

        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.T(this.f20097a);
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            BaseTransientBottomBar.this.f20079i.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            BaseTransientBottomBar.this.f20079i.setScaleX(floatValue);
            BaseTransientBottomBar.this.f20079i.setScaleY(floatValue);
        }
    }

    class d extends AnimatorListenerAdapter {
        d() {
        }

        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.U();
        }

        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.f20080j.a(BaseTransientBottomBar.this.f20073c - BaseTransientBottomBar.this.f20071a, BaseTransientBottomBar.this.f20071a);
        }
    }

    class e implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        private int f20102a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f20103b;

        e(int i10) {
            this.f20103b = i10;
            this.f20102a = i10;
        }

        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.D) {
                n0.d0(BaseTransientBottomBar.this.f20079i, intValue - this.f20102a);
            } else {
                BaseTransientBottomBar.this.f20079i.setTranslationY((float) intValue);
            }
            this.f20102a = intValue;
        }
    }

    class f extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f20105a;

        f(int i10) {
            this.f20105a = i10;
        }

        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.T(this.f20105a);
        }

        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.f20080j.b(0, BaseTransientBottomBar.this.f20072b);
        }
    }

    class g implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        private int f20107a = 0;

        g() {
        }

        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.D) {
                n0.d0(BaseTransientBottomBar.this.f20079i, intValue - this.f20107a);
            } else {
                BaseTransientBottomBar.this.f20079i.setTranslationY((float) intValue);
            }
            this.f20107a = intValue;
        }
    }

    class h implements Handler.Callback {
        h() {
        }

        public boolean handleMessage(@NonNull Message message) {
            int i10 = message.what;
            if (i10 == 0) {
                ((BaseTransientBottomBar) message.obj).c0();
                return true;
            } else if (i10 != 1) {
                return false;
            } else {
                ((BaseTransientBottomBar) message.obj).N(message.arg1);
                return true;
            }
        }
    }

    class i implements Runnable {
        i() {
        }

        public void run() {
            int b10;
            BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
            if (baseTransientBottomBar.f20079i != null && baseTransientBottomBar.f20078h != null && (b10 = (BaseTransientBottomBar.this.H() - BaseTransientBottomBar.this.L()) + ((int) BaseTransientBottomBar.this.f20079i.getTranslationY())) < BaseTransientBottomBar.this.f20089s) {
                ViewGroup.LayoutParams layoutParams = BaseTransientBottomBar.this.f20079i.getLayoutParams();
                if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                    String unused = BaseTransientBottomBar.F;
                    return;
                }
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin += BaseTransientBottomBar.this.f20089s - b10;
                BaseTransientBottomBar.this.f20079i.requestLayout();
            }
        }
    }

    class j implements h0 {
        j() {
        }

        @NonNull
        public k2 a(View view, @NonNull k2 k2Var) {
            int unused = BaseTransientBottomBar.this.f20086p = k2Var.h();
            int unused2 = BaseTransientBottomBar.this.f20087q = k2Var.i();
            int unused3 = BaseTransientBottomBar.this.f20088r = k2Var.j();
            BaseTransientBottomBar.this.i0();
            return k2Var;
        }
    }

    class k extends androidx.core.view.a {
        k() {
        }

        public void g(View view, @NonNull androidx.core.view.accessibility.k kVar) {
            super.g(view, kVar);
            kVar.a(1048576);
            kVar.f0(true);
        }

        public boolean j(View view, int i10, Bundle bundle) {
            if (i10 != 1048576) {
                return super.j(view, i10, bundle);
            }
            BaseTransientBottomBar.this.A();
            return true;
        }
    }

    class l implements c.b {
        l() {
        }

        public void a() {
            Handler handler = BaseTransientBottomBar.C;
            handler.sendMessage(handler.obtainMessage(0, BaseTransientBottomBar.this));
        }

        public void b(int i10) {
            Handler handler = BaseTransientBottomBar.C;
            handler.sendMessage(handler.obtainMessage(1, i10, 0, BaseTransientBottomBar.this));
        }
    }

    class m implements Runnable {
        m() {
        }

        public void run() {
            BaseTransientBottomBar.this.T(3);
        }
    }

    class n implements SwipeDismissBehavior.c {
        n() {
        }

        public void a(@NonNull View view) {
            if (view.getParent() != null) {
                view.setVisibility(8);
            }
            BaseTransientBottomBar.this.B(0);
        }

        public void b(int i10) {
            if (i10 == 0) {
                c.c().k(BaseTransientBottomBar.this.f20095y);
            } else if (i10 == 1 || i10 == 2) {
                c.c().j(BaseTransientBottomBar.this.f20095y);
            }
        }
    }

    class o implements Runnable {
        o() {
        }

        public void run() {
            t tVar = BaseTransientBottomBar.this.f20079i;
            if (tVar != null) {
                if (tVar.getParent() != null) {
                    BaseTransientBottomBar.this.f20079i.setVisibility(0);
                }
                if (BaseTransientBottomBar.this.f20079i.getAnimationMode() == 1) {
                    BaseTransientBottomBar.this.e0();
                } else {
                    BaseTransientBottomBar.this.g0();
                }
            }
        }
    }

    class p extends AnimatorListenerAdapter {
        p() {
        }

        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.U();
        }
    }

    static class q implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<BaseTransientBottomBar> f20117a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        private final WeakReference<View> f20118b;

        private q(@NonNull BaseTransientBottomBar baseTransientBottomBar, @NonNull View view) {
            this.f20117a = new WeakReference<>(baseTransientBottomBar);
            this.f20118b = new WeakReference<>(view);
        }

        static q a(@NonNull BaseTransientBottomBar baseTransientBottomBar, @NonNull View view) {
            q qVar = new q(baseTransientBottomBar, view);
            if (n0.V(view)) {
                com.google.android.material.internal.r.a(view, qVar);
            }
            view.addOnAttachStateChangeListener(qVar);
            return qVar;
        }

        private boolean d() {
            if (this.f20117a.get() != null) {
                return false;
            }
            c();
            return true;
        }

        /* access modifiers changed from: package-private */
        public View b() {
            return this.f20118b.get();
        }

        /* access modifiers changed from: package-private */
        public void c() {
            if (this.f20118b.get() != null) {
                this.f20118b.get().removeOnAttachStateChangeListener(this);
                com.google.android.material.internal.r.k(this.f20118b.get(), this);
            }
            this.f20118b.clear();
            this.f20117a.clear();
        }

        public void onGlobalLayout() {
            if (!d() && this.f20117a.get().f20084n) {
                this.f20117a.get().V();
            }
        }

        public void onViewAttachedToWindow(View view) {
            if (!d()) {
                com.google.android.material.internal.r.a(view, this);
            }
        }

        public void onViewDetachedFromWindow(View view) {
            if (!d()) {
                com.google.android.material.internal.r.k(view, this);
            }
        }
    }

    public static abstract class r<B> {
        public void a(B b10, int i10) {
        }

        public void b(B b10) {
        }
    }

    public static class s {

        /* renamed from: a  reason: collision with root package name */
        private c.b f20119a;

        public s(@NonNull SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.M(0.1f);
            swipeDismissBehavior.K(0.6f);
            swipeDismissBehavior.N(0);
        }

        public boolean a(View view) {
            return view instanceof t;
        }

        public void b(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 1 || actionMasked == 3) {
                    c.c().k(this.f20119a);
                }
            } else if (coordinatorLayout.B(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                c.c().j(this.f20119a);
            }
        }

        public void c(@NonNull BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f20119a = baseTransientBottomBar.f20095y;
        }
    }

    protected static class t extends FrameLayout {

        /* renamed from: m  reason: collision with root package name */
        private static final View.OnTouchListener f20120m = new a();

        /* renamed from: a  reason: collision with root package name */
        private BaseTransientBottomBar<?> f20121a;

        /* renamed from: b  reason: collision with root package name */
        tf.k f20122b;

        /* renamed from: c  reason: collision with root package name */
        private int f20123c;

        /* renamed from: d  reason: collision with root package name */
        private final float f20124d;

        /* renamed from: e  reason: collision with root package name */
        private final float f20125e;

        /* renamed from: f  reason: collision with root package name */
        private final int f20126f;

        /* renamed from: g  reason: collision with root package name */
        private final int f20127g;

        /* renamed from: h  reason: collision with root package name */
        private ColorStateList f20128h;

        /* renamed from: j  reason: collision with root package name */
        private PorterDuff.Mode f20129j;
        /* access modifiers changed from: private */

        /* renamed from: k  reason: collision with root package name */
        public Rect f20130k;

        /* renamed from: l  reason: collision with root package name */
        private boolean f20131l;

        class a implements View.OnTouchListener {
            a() {
            }

            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        }

        protected t(@NonNull Context context, AttributeSet attributeSet) {
            super(wf.a.c(context, attributeSet, 0, 0), attributeSet);
            Context context2 = getContext();
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, bf.l.SnackbarLayout);
            int i10 = bf.l.SnackbarLayout_elevation;
            if (obtainStyledAttributes.hasValue(i10)) {
                n0.A0(this, (float) obtainStyledAttributes.getDimensionPixelSize(i10, 0));
            }
            this.f20123c = obtainStyledAttributes.getInt(bf.l.SnackbarLayout_animationMode, 0);
            if (obtainStyledAttributes.hasValue(bf.l.SnackbarLayout_shapeAppearance) || obtainStyledAttributes.hasValue(bf.l.SnackbarLayout_shapeAppearanceOverlay)) {
                this.f20122b = tf.k.e(context2, attributeSet, 0, 0).m();
            }
            this.f20124d = obtainStyledAttributes.getFloat(bf.l.SnackbarLayout_backgroundOverlayColorAlpha, 1.0f);
            setBackgroundTintList(qf.c.a(context2, obtainStyledAttributes, bf.l.SnackbarLayout_backgroundTint));
            setBackgroundTintMode(com.google.android.material.internal.r.j(obtainStyledAttributes.getInt(bf.l.SnackbarLayout_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN));
            this.f20125e = obtainStyledAttributes.getFloat(bf.l.SnackbarLayout_actionTextColorAlpha, 1.0f);
            this.f20126f = obtainStyledAttributes.getDimensionPixelSize(bf.l.SnackbarLayout_android_maxWidth, -1);
            this.f20127g = obtainStyledAttributes.getDimensionPixelSize(bf.l.SnackbarLayout_maxActionInlineWidth, -1);
            obtainStyledAttributes.recycle();
            setOnTouchListener(f20120m);
            setFocusable(true);
            if (getBackground() == null) {
                n0.w0(this, d());
            }
        }

        @NonNull
        private Drawable d() {
            Drawable drawable;
            int j10 = hf.a.j(this, bf.b.colorSurface, bf.b.colorOnSurface, getBackgroundOverlayColorAlpha());
            tf.k kVar = this.f20122b;
            if (kVar != null) {
                drawable = BaseTransientBottomBar.z(j10, kVar);
            } else {
                drawable = BaseTransientBottomBar.y(j10, getResources());
            }
            if (this.f20128h == null) {
                return androidx.core.graphics.drawable.a.r(drawable);
            }
            Drawable r10 = androidx.core.graphics.drawable.a.r(drawable);
            androidx.core.graphics.drawable.a.o(r10, this.f20128h);
            return r10;
        }

        private void e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.f20130k = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }

        /* access modifiers changed from: private */
        public void setBaseTransientBottomBar(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f20121a = baseTransientBottomBar;
        }

        /* access modifiers changed from: package-private */
        public void c(ViewGroup viewGroup) {
            this.f20131l = true;
            viewGroup.addView(this);
            this.f20131l = false;
        }

        /* access modifiers changed from: package-private */
        public float getActionTextColorAlpha() {
            return this.f20125e;
        }

        /* access modifiers changed from: package-private */
        public int getAnimationMode() {
            return this.f20123c;
        }

        /* access modifiers changed from: package-private */
        public float getBackgroundOverlayColorAlpha() {
            return this.f20124d;
        }

        /* access modifiers changed from: package-private */
        public int getMaxInlineActionWidth() {
            return this.f20127g;
        }

        /* access modifiers changed from: package-private */
        public int getMaxWidth() {
            return this.f20126f;
        }

        /* access modifiers changed from: protected */
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            BaseTransientBottomBar<?> baseTransientBottomBar = this.f20121a;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.Q();
            }
            n0.p0(this);
        }

        /* access modifiers changed from: protected */
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            BaseTransientBottomBar<?> baseTransientBottomBar = this.f20121a;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.R();
            }
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
            super.onLayout(z10, i10, i11, i12, i13);
            BaseTransientBottomBar<?> baseTransientBottomBar = this.f20121a;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.S();
            }
        }

        /* access modifiers changed from: protected */
        public void onMeasure(int i10, int i11) {
            int i12;
            super.onMeasure(i10, i11);
            if (this.f20126f > 0 && getMeasuredWidth() > (i12 = this.f20126f)) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(i12, 1073741824), i11);
            }
        }

        /* access modifiers changed from: package-private */
        public void setAnimationMode(int i10) {
            this.f20123c = i10;
        }

        public void setBackground(Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        public void setBackgroundDrawable(Drawable drawable) {
            if (!(drawable == null || this.f20128h == null)) {
                drawable = androidx.core.graphics.drawable.a.r(drawable.mutate());
                androidx.core.graphics.drawable.a.o(drawable, this.f20128h);
                androidx.core.graphics.drawable.a.p(drawable, this.f20129j);
            }
            super.setBackgroundDrawable(drawable);
        }

        public void setBackgroundTintList(ColorStateList colorStateList) {
            this.f20128h = colorStateList;
            if (getBackground() != null) {
                Drawable r10 = androidx.core.graphics.drawable.a.r(getBackground().mutate());
                androidx.core.graphics.drawable.a.o(r10, colorStateList);
                androidx.core.graphics.drawable.a.p(r10, this.f20129j);
                if (r10 != getBackground()) {
                    super.setBackgroundDrawable(r10);
                }
            }
        }

        public void setBackgroundTintMode(PorterDuff.Mode mode) {
            this.f20129j = mode;
            if (getBackground() != null) {
                Drawable r10 = androidx.core.graphics.drawable.a.r(getBackground().mutate());
                androidx.core.graphics.drawable.a.p(r10, mode);
                if (r10 != getBackground()) {
                    super.setBackgroundDrawable(r10);
                }
            }
        }

        public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            super.setLayoutParams(layoutParams);
            if (!this.f20131l && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                e((ViewGroup.MarginLayoutParams) layoutParams);
                BaseTransientBottomBar<?> baseTransientBottomBar = this.f20121a;
                if (baseTransientBottomBar != null) {
                    baseTransientBottomBar.i0();
                }
            }
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            View.OnTouchListener onTouchListener;
            if (onClickListener != null) {
                onTouchListener = null;
            } else {
                onTouchListener = f20120m;
            }
            setOnTouchListener(onTouchListener);
            super.setOnClickListener(onClickListener);
        }
    }

    protected BaseTransientBottomBar(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull View view, @NonNull a aVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
        } else if (view == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        } else if (aVar != null) {
            this.f20077g = viewGroup;
            this.f20080j = aVar;
            this.f20078h = context;
            com.google.android.material.internal.p.a(context);
            t tVar = (t) LayoutInflater.from(context).inflate(I(), viewGroup, false);
            this.f20079i = tVar;
            tVar.setBaseTransientBottomBar(this);
            if (view instanceof SnackbarContentLayout) {
                SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) view;
                snackbarContentLayout.c(tVar.getActionTextColorAlpha());
                snackbarContentLayout.setMaxInlineActionWidth(tVar.getMaxInlineActionWidth());
            }
            tVar.addView(view);
            n0.u0(tVar, 1);
            n0.D0(tVar, 1);
            n0.B0(tVar, true);
            n0.H0(tVar, new j());
            n0.s0(tVar, new k());
            this.f20094x = (AccessibilityManager) context.getSystemService("accessibility");
            int i10 = bf.b.motionDurationLong2;
            this.f20073c = of.a.f(context, i10, MessageTemplateConstants.Values.CENTER_POPUP_HEIGHT);
            this.f20071a = of.a.f(context, i10, Opcodes.FCMPG);
            this.f20072b = of.a.f(context, bf.b.motionDurationMedium1, 75);
            int i11 = bf.b.motionEasingEmphasizedInterpolator;
            this.f20074d = of.a.g(context, i11, A);
            this.f20076f = of.a.g(context, i11, B);
            this.f20075e = of.a.g(context, i11, f20070z);
        } else {
            throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
        }
    }

    private ValueAnimator C(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(this.f20074d);
        ofFloat.addUpdateListener(new b());
        return ofFloat;
    }

    private ValueAnimator G(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(this.f20076f);
        ofFloat.addUpdateListener(new c());
        return ofFloat;
    }

    /* access modifiers changed from: private */
    public int H() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.f20078h.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    private int J() {
        int height = this.f20079i.getHeight();
        ViewGroup.LayoutParams layoutParams = this.f20079i.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return height + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }
        return height;
    }

    /* access modifiers changed from: private */
    public int L() {
        int[] iArr = new int[2];
        this.f20079i.getLocationOnScreen(iArr);
        return iArr[1] + this.f20079i.getHeight();
    }

    private boolean P() {
        ViewGroup.LayoutParams layoutParams = this.f20079i.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.f) || !(((CoordinatorLayout.f) layoutParams).f() instanceof SwipeDismissBehavior)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void V() {
        int x10 = x();
        if (x10 != this.f20090t) {
            this.f20090t = x10;
            i0();
        }
    }

    private void Y(CoordinatorLayout.f fVar) {
        SwipeDismissBehavior swipeDismissBehavior = this.f20093w;
        if (swipeDismissBehavior == null) {
            swipeDismissBehavior = F();
        }
        if (swipeDismissBehavior instanceof Behavior) {
            ((Behavior) swipeDismissBehavior).Q(this);
        }
        swipeDismissBehavior.L(new n());
        fVar.o(swipeDismissBehavior);
        if (D() == null) {
            fVar.f4368g = 80;
        }
    }

    private boolean a0() {
        return this.f20089s > 0 && !this.f20082l && P();
    }

    private void d0() {
        if (Z()) {
            v();
            return;
        }
        if (this.f20079i.getParent() != null) {
            this.f20079i.setVisibility(0);
        }
        U();
    }

    /* access modifiers changed from: private */
    public void e0() {
        ValueAnimator C2 = C(0.0f, 1.0f);
        ValueAnimator G = G(0.8f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{C2, G});
        animatorSet.setDuration((long) this.f20071a);
        animatorSet.addListener(new p());
        animatorSet.start();
    }

    private void f0(int i10) {
        ValueAnimator C2 = C(1.0f, 0.0f);
        C2.setDuration((long) this.f20072b);
        C2.addListener(new a(i10));
        C2.start();
    }

    /* access modifiers changed from: private */
    public void g0() {
        int J = J();
        if (D) {
            n0.d0(this.f20079i, J);
        } else {
            this.f20079i.setTranslationY((float) J);
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(new int[]{J, 0});
        valueAnimator.setInterpolator(this.f20075e);
        valueAnimator.setDuration((long) this.f20073c);
        valueAnimator.addListener(new d());
        valueAnimator.addUpdateListener(new e(J));
        valueAnimator.start();
    }

    private void h0(int i10) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(new int[]{0, J()});
        valueAnimator.setInterpolator(this.f20075e);
        valueAnimator.setDuration((long) this.f20073c);
        valueAnimator.addListener(new f(i10));
        valueAnimator.addUpdateListener(new g());
        valueAnimator.start();
    }

    /* access modifiers changed from: private */
    public void i0() {
        int i10;
        ViewGroup.LayoutParams layoutParams = this.f20079i.getLayoutParams();
        if ((layoutParams instanceof ViewGroup.MarginLayoutParams) && this.f20079i.f20130k != null && this.f20079i.getParent() != null) {
            if (D() != null) {
                i10 = this.f20090t;
            } else {
                i10 = this.f20086p;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = this.f20079i.f20130k.bottom + i10;
            marginLayoutParams.leftMargin = this.f20079i.f20130k.left + this.f20087q;
            marginLayoutParams.rightMargin = this.f20079i.f20130k.right + this.f20088r;
            marginLayoutParams.topMargin = this.f20079i.f20130k.top;
            this.f20079i.requestLayout();
            if (Build.VERSION.SDK_INT >= 29 && a0()) {
                this.f20079i.removeCallbacks(this.f20085o);
                this.f20079i.post(this.f20085o);
            }
        }
    }

    private void w(int i10) {
        if (this.f20079i.getAnimationMode() == 1) {
            f0(i10);
        } else {
            h0(i10);
        }
    }

    private int x() {
        if (D() == null) {
            return 0;
        }
        int[] iArr = new int[2];
        D().getLocationOnScreen(iArr);
        int i10 = iArr[1];
        int[] iArr2 = new int[2];
        this.f20077g.getLocationOnScreen(iArr2);
        return (iArr2[1] + this.f20077g.getHeight()) - i10;
    }

    /* access modifiers changed from: private */
    @NonNull
    public static GradientDrawable y(int i10, @NonNull Resources resources) {
        float dimension = resources.getDimension(bf.d.mtrl_snackbar_background_corner_radius);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(dimension);
        gradientDrawable.setColor(i10);
        return gradientDrawable;
    }

    /* access modifiers changed from: private */
    @NonNull
    public static tf.g z(int i10, @NonNull tf.k kVar) {
        tf.g gVar = new tf.g(kVar);
        gVar.b0(ColorStateList.valueOf(i10));
        return gVar;
    }

    public void A() {
        B(3);
    }

    /* access modifiers changed from: protected */
    public void B(int i10) {
        c.c().b(this.f20095y, i10);
    }

    public View D() {
        q qVar = this.f20083m;
        if (qVar == null) {
            return null;
        }
        return qVar.b();
    }

    public int E() {
        return this.f20081k;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public SwipeDismissBehavior<? extends View> F() {
        return new Behavior();
    }

    /* access modifiers changed from: protected */
    public int I() {
        return M() ? bf.h.mtrl_layout_snackbar : bf.h.design_layout_snackbar;
    }

    @NonNull
    public View K() {
        return this.f20079i;
    }

    /* access modifiers changed from: protected */
    public boolean M() {
        TypedArray obtainStyledAttributes = this.f20078h.obtainStyledAttributes(E);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        if (resourceId != -1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void N(int i10) {
        if (!Z() || this.f20079i.getVisibility() != 0) {
            T(i10);
        } else {
            w(i10);
        }
    }

    public boolean O() {
        return c.c().e(this.f20095y);
    }

    /* access modifiers changed from: package-private */
    public void Q() {
        WindowInsets rootWindowInsets;
        if (Build.VERSION.SDK_INT >= 29 && (rootWindowInsets = this.f20079i.getRootWindowInsets()) != null) {
            this.f20089s = rootWindowInsets.getMandatorySystemGestureInsets().bottom;
            i0();
        }
    }

    /* access modifiers changed from: package-private */
    public void R() {
        if (O()) {
            C.post(new m());
        }
    }

    /* access modifiers changed from: package-private */
    public void S() {
        if (this.f20091u) {
            d0();
            this.f20091u = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void T(int i10) {
        c.c().h(this.f20095y);
        List<r<B>> list = this.f20092v;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f20092v.get(size).a(this, i10);
            }
        }
        ViewParent parent = this.f20079i.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f20079i);
        }
    }

    /* access modifiers changed from: package-private */
    public void U() {
        c.c().i(this.f20095y);
        List<r<B>> list = this.f20092v;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f20092v.get(size).b(this);
            }
        }
    }

    @NonNull
    public B W(View view) {
        q qVar;
        q qVar2 = this.f20083m;
        if (qVar2 != null) {
            qVar2.c();
        }
        if (view == null) {
            qVar = null;
        } else {
            qVar = q.a(this, view);
        }
        this.f20083m = qVar;
        return this;
    }

    @NonNull
    public B X(int i10) {
        this.f20081k = i10;
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean Z() {
        AccessibilityManager accessibilityManager = this.f20094x;
        if (accessibilityManager == null) {
            return true;
        }
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(1);
        if (enabledAccessibilityServiceList == null || !enabledAccessibilityServiceList.isEmpty()) {
            return false;
        }
        return true;
    }

    public void b0() {
        c.c().m(E(), this.f20095y);
    }

    /* access modifiers changed from: package-private */
    public final void c0() {
        if (this.f20079i.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.f20079i.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                Y((CoordinatorLayout.f) layoutParams);
            }
            this.f20079i.c(this.f20077g);
            V();
            this.f20079i.setVisibility(4);
        }
        if (n0.W(this.f20079i)) {
            d0();
        } else {
            this.f20091u = true;
        }
    }

    @NonNull
    public B u(r<B> rVar) {
        if (rVar == null) {
            return this;
        }
        if (this.f20092v == null) {
            this.f20092v = new ArrayList();
        }
        this.f20092v.add(rVar);
        return this;
    }

    /* access modifiers changed from: package-private */
    public void v() {
        this.f20079i.post(new o());
    }
}

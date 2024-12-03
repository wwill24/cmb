package com.skydoves.balloon;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.method.MovementMethod;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.n0;
import androidx.core.widget.h;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.k;
import androidx.lifecycle.l;
import com.mparticle.identity.IdentityHttpResponse;
import com.skydoves.balloon.l;
import com.skydoves.balloon.overlay.BalloonAnchorOverlayView;
import com.skydoves.balloon.overlay.BalloonOverlayAnimation;
import com.skydoves.balloon.radius.RadiusLayout;
import com.skydoves.balloon.vectortext.VectorTextView;
import com.skydoves.balloon.w;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.LazyThreadSafetyMode;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.b0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.o;
import kotlin.ranges.IntRange;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;
import org.jivesoftware.smackx.reference.element.ReferenceElement;

public final class Balloon implements DefaultLifecycleObserver {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f22668a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final a f22669b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final wh.a f22670c;

    /* renamed from: d  reason: collision with root package name */
    private final wh.b f22671d;

    /* renamed from: e  reason: collision with root package name */
    private final PopupWindow f22672e;

    /* renamed from: f  reason: collision with root package name */
    private final PopupWindow f22673f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f22674g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f22675h;

    /* renamed from: j  reason: collision with root package name */
    public o f22676j;

    /* renamed from: k  reason: collision with root package name */
    private final gk.f f22677k;

    /* renamed from: l  reason: collision with root package name */
    private final gk.f f22678l;

    /* renamed from: m  reason: collision with root package name */
    private final gk.f f22679m;

    public static final class a {
        private int A;
        private l A0;
        private int B;
        private k B0;
        private int C;
        private int C0;
        private int D;
        private int D0;
        private float E = 2.5f;
        private BalloonAnimation E0;
        private float F;
        private BalloonOverlayAnimation F0;
        private int G = -16777216;
        private long G0;
        private Drawable H;
        private BalloonHighlightAnimation H0;
        private float I = TypedValue.applyDimension(1, 5.0f, Resources.getSystem().getDisplayMetrics());
        private int I0;
        private CharSequence J;
        private long J0;
        private int K;
        private String K0;
        private boolean L;
        private int L0;
        private MovementMethod M;
        private Function0<Unit> M0;
        private float N;
        private boolean N0;
        private int O;
        private int O0;
        private Typeface P;
        private boolean P0;
        private Float Q;
        private boolean Q0;
        private int R;
        private boolean R0;
        private w S;
        private boolean S0;
        private Drawable T;
        private IconGravity U;
        private int V;
        private int W;
        private int X;
        private int Y;
        private l Z;

        /* renamed from: a  reason: collision with root package name */
        private final Context f22680a;

        /* renamed from: a0  reason: collision with root package name */
        private CharSequence f22681a0;

        /* renamed from: b  reason: collision with root package name */
        private int f22682b = Integer.MIN_VALUE;

        /* renamed from: b0  reason: collision with root package name */
        private float f22683b0;

        /* renamed from: c  reason: collision with root package name */
        private int f22684c;

        /* renamed from: c0  reason: collision with root package name */
        private float f22685c0;

        /* renamed from: d  reason: collision with root package name */
        private int f22686d = new Point(Resources.getSystem().getDisplayMetrics().widthPixels, Resources.getSystem().getDisplayMetrics().heightPixels).x;

        /* renamed from: d0  reason: collision with root package name */
        private View f22687d0;

        /* renamed from: e  reason: collision with root package name */
        private float f22688e;

        /* renamed from: e0  reason: collision with root package name */
        private Integer f22689e0;

        /* renamed from: f  reason: collision with root package name */
        private float f22690f;

        /* renamed from: f0  reason: collision with root package name */
        private boolean f22691f0;

        /* renamed from: g  reason: collision with root package name */
        private float f22692g;

        /* renamed from: g0  reason: collision with root package name */
        private int f22693g0;

        /* renamed from: h  reason: collision with root package name */
        private int f22694h = Integer.MIN_VALUE;

        /* renamed from: h0  reason: collision with root package name */
        private float f22695h0;

        /* renamed from: i  reason: collision with root package name */
        private int f22696i;

        /* renamed from: i0  reason: collision with root package name */
        private int f22697i0;

        /* renamed from: j  reason: collision with root package name */
        private int f22698j;

        /* renamed from: j0  reason: collision with root package name */
        private Point f22699j0;

        /* renamed from: k  reason: collision with root package name */
        private int f22700k;

        /* renamed from: k0  reason: collision with root package name */
        private yh.d f22701k0;

        /* renamed from: l  reason: collision with root package name */
        private int f22702l;

        /* renamed from: l0  reason: collision with root package name */
        private int f22703l0;

        /* renamed from: m  reason: collision with root package name */
        private int f22704m;

        /* renamed from: m0  reason: collision with root package name */
        private m f22705m0;

        /* renamed from: n  reason: collision with root package name */
        private int f22706n;

        /* renamed from: n0  reason: collision with root package name */
        private n f22707n0;

        /* renamed from: o  reason: collision with root package name */
        private int f22708o;

        /* renamed from: o0  reason: collision with root package name */
        private o f22709o0;

        /* renamed from: p  reason: collision with root package name */
        private int f22710p;

        /* renamed from: p0  reason: collision with root package name */
        private p f22711p0;

        /* renamed from: q  reason: collision with root package name */
        private boolean f22712q = true;

        /* renamed from: q0  reason: collision with root package name */
        private View.OnTouchListener f22713q0;

        /* renamed from: r  reason: collision with root package name */
        private int f22714r = Integer.MIN_VALUE;

        /* renamed from: r0  reason: collision with root package name */
        private View.OnTouchListener f22715r0;

        /* renamed from: s  reason: collision with root package name */
        private boolean f22716s;

        /* renamed from: s0  reason: collision with root package name */
        private q f22717s0;

        /* renamed from: t  reason: collision with root package name */
        private int f22718t = c.b(TypedValue.applyDimension(1, (float) 12, Resources.getSystem().getDisplayMetrics()));

        /* renamed from: t0  reason: collision with root package name */
        private boolean f22719t0;

        /* renamed from: u  reason: collision with root package name */
        private float f22720u = 0.5f;

        /* renamed from: u0  reason: collision with root package name */
        private boolean f22721u0;

        /* renamed from: v  reason: collision with root package name */
        private ArrowPositionRules f22722v = ArrowPositionRules.ALIGN_BALLOON;

        /* renamed from: v0  reason: collision with root package name */
        private boolean f22723v0;

        /* renamed from: w  reason: collision with root package name */
        private ArrowOrientationRules f22724w = ArrowOrientationRules.ALIGN_ANCHOR;

        /* renamed from: w0  reason: collision with root package name */
        private boolean f22725w0;

        /* renamed from: x  reason: collision with root package name */
        private ArrowOrientation f22726x = ArrowOrientation.BOTTOM;

        /* renamed from: x0  reason: collision with root package name */
        private boolean f22727x0;

        /* renamed from: y  reason: collision with root package name */
        private Drawable f22728y;

        /* renamed from: y0  reason: collision with root package name */
        private boolean f22729y0;

        /* renamed from: z  reason: collision with root package name */
        private int f22730z;

        /* renamed from: z0  reason: collision with root package name */
        private long f22731z0;

        public a(Context context) {
            boolean z10;
            j.g(context, IdentityHttpResponse.CONTEXT);
            this.f22680a = context;
            o oVar = o.f32141a;
            this.J = "";
            this.K = -1;
            this.N = 12.0f;
            this.R = 17;
            this.U = IconGravity.START;
            float f10 = (float) 28;
            this.V = c.b(TypedValue.applyDimension(1, f10, Resources.getSystem().getDisplayMetrics()));
            this.W = c.b(TypedValue.applyDimension(1, f10, Resources.getSystem().getDisplayMetrics()));
            this.X = c.b(TypedValue.applyDimension(1, (float) 8, Resources.getSystem().getDisplayMetrics()));
            this.Y = Integer.MIN_VALUE;
            this.f22681a0 = "";
            this.f22683b0 = 1.0f;
            this.f22685c0 = TypedValue.applyDimension(1, 2.0f, Resources.getSystem().getDisplayMetrics());
            this.f22701k0 = yh.b.f24788a;
            this.f22703l0 = 17;
            this.f22719t0 = true;
            this.f22725w0 = true;
            this.f22731z0 = -1;
            this.C0 = Integer.MIN_VALUE;
            this.D0 = Integer.MIN_VALUE;
            this.E0 = BalloonAnimation.FADE;
            this.F0 = BalloonOverlayAnimation.FADE;
            this.G0 = 500;
            this.H0 = BalloonHighlightAnimation.NONE;
            this.I0 = Integer.MIN_VALUE;
            this.L0 = 1;
            if (context.getResources().getConfiguration().getLayoutDirection() == 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.N0 = z10;
            this.O0 = com.skydoves.balloon.internals.a.b(1, z10);
            this.P0 = true;
            this.Q0 = true;
            this.R0 = true;
        }

        public final int A() {
            return this.D0;
        }

        public final int A0() {
            return this.O0;
        }

        public final a A1(int i10) {
            this.f22698j = c.b(TypedValue.applyDimension(1, (float) i10, Resources.getSystem().getDisplayMetrics()));
            return this;
        }

        public final vh.a B() {
            return null;
        }

        public final CharSequence B0() {
            return this.J;
        }

        public final a B1(int i10) {
            this.K = j.g(this.f22680a, "<this>");
            return this;
        }

        public final long C() {
            return this.G0;
        }

        public final int C0() {
            return this.K;
        }

        public final a C1(int i10) {
            this.R = i10;
            return this;
        }

        public final float D() {
            return this.I;
        }

        public final w D0() {
            return this.S;
        }

        public final a D1(boolean z10) {
            this.L = z10;
            return this;
        }

        public final boolean E() {
            return this.f22723v0;
        }

        public final int E0() {
            return this.R;
        }

        public final a E1(int i10) {
            String string = this.f22680a.getString(i10);
            j.f(string, "context.getString(value)");
            this.J = string;
            return this;
        }

        public final boolean F() {
            return this.f22727x0;
        }

        public final boolean F0() {
            return this.L;
        }

        public final a F1(float f10) {
            this.N = f10;
            return this;
        }

        public final boolean G() {
            return this.f22725w0;
        }

        public final Float G0() {
            return this.Q;
        }

        public final a G1(float f10) {
            this.f22688e = f10;
            return this;
        }

        public final boolean H() {
            return this.f22721u0;
        }

        public final float H0() {
            return this.N;
        }

        public final boolean I() {
            return this.f22719t0;
        }

        public final int I0() {
            return this.O;
        }

        public final float J() {
            return this.f22685c0;
        }

        public final Typeface J0() {
            return this.P;
        }

        public final int K() {
            return this.f22694h;
        }

        public final int K0() {
            return this.f22682b;
        }

        public final int L() {
            return this.Y;
        }

        public final float L0() {
            return this.f22688e;
        }

        public final Drawable M() {
            return this.T;
        }

        public final boolean M0() {
            return this.R0;
        }

        public final l N() {
            return this.Z;
        }

        public final boolean N0() {
            return this.S0;
        }

        public final IconGravity O() {
            return this.U;
        }

        public final boolean O0() {
            return this.P0;
        }

        public final int P() {
            return this.W;
        }

        public final boolean P0() {
            return this.N0;
        }

        public final int Q() {
            return this.X;
        }

        public final boolean Q0() {
            return this.Q0;
        }

        public final int R() {
            return this.V;
        }

        public final boolean R0() {
            return this.f22712q;
        }

        public final View S() {
            return this.f22687d0;
        }

        public final boolean S0() {
            return this.f22691f0;
        }

        public final Integer T() {
            return this.f22689e0;
        }

        public final a T0(Drawable drawable) {
            Drawable drawable2;
            if (drawable != null) {
                drawable2 = drawable.mutate();
            } else {
                drawable2 = null;
            }
            this.f22728y = drawable2;
            if (drawable != null && this.f22718t == Integer.MIN_VALUE) {
                this.f22718t = Math.max(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            }
            return this;
        }

        public final k U() {
            return this.B0;
        }

        public final a U0(int i10) {
            T0(j.g(this.f22680a, "<this>"));
            return this;
        }

        public final l V() {
            return this.A0;
        }

        public final a V0(int i10) {
            this.F = (float) c.b(TypedValue.applyDimension(1, (float) i10, Resources.getSystem().getDisplayMetrics()));
            return this;
        }

        public final int W() {
            return this.f22710p;
        }

        public final a W0(ArrowOrientation arrowOrientation) {
            j.g(arrowOrientation, "value");
            this.f22726x = arrowOrientation;
            return this;
        }

        public final int X() {
            return this.f22706n;
        }

        public final a X0(float f10) {
            this.f22720u = f10;
            return this;
        }

        public final int Y() {
            return this.f22704m;
        }

        public final a Y0(ArrowPositionRules arrowPositionRules) {
            j.g(arrowPositionRules, "value");
            this.f22722v = arrowPositionRules;
            return this;
        }

        public final int Z() {
            return this.f22708o;
        }

        public final a Z0(int i10) {
            int i11 = Integer.MIN_VALUE;
            if (i10 != Integer.MIN_VALUE) {
                i11 = c.b(TypedValue.applyDimension(1, (float) i10, Resources.getSystem().getDisplayMetrics()));
            }
            this.f22718t = i11;
            return this;
        }

        public final Balloon a() {
            return new Balloon(this.f22680a, this, (DefaultConstructorMarker) null);
        }

        public final int a0() {
            return this.f22686d;
        }

        public final a a1(int i10) {
            this.f22718t = j.g(this.f22680a, "<this>");
            return this;
        }

        public final float b() {
            return this.f22683b0;
        }

        public final float b0() {
            return this.f22692g;
        }

        public final a b1(int i10) {
            this.G = j.g(this.f22680a, "<this>");
            return this;
        }

        public final int c() {
            return this.D;
        }

        public final int c0() {
            return this.f22684c;
        }

        public final a c1(BalloonAnimation balloonAnimation) {
            j.g(balloonAnimation, "value");
            this.E0 = balloonAnimation;
            if (balloonAnimation == BalloonAnimation.CIRCULAR) {
                f1(false);
            }
            return this;
        }

        public final float d() {
            return this.E;
        }

        public final float d0() {
            return this.f22690f;
        }

        public final a d1(float f10) {
            this.I = TypedValue.applyDimension(1, f10, Resources.getSystem().getDisplayMetrics());
            return this;
        }

        public final int e() {
            return this.C;
        }

        public final MovementMethod e0() {
            return this.M;
        }

        public final a e1(int i10) {
            this.f22685c0 = (float) c.b(TypedValue.applyDimension(1, (float) i10, Resources.getSystem().getDisplayMetrics()));
            return this;
        }

        public final int f() {
            return this.f22714r;
        }

        public final m f0() {
            return this.f22705m0;
        }

        public final a f1(boolean z10) {
            this.P0 = z10;
            return this;
        }

        public final boolean g() {
            return this.f22716s;
        }

        public final n g0() {
            return this.f22707n0;
        }

        public final a g1(int i10) {
            boolean z10;
            if (i10 > 0 || i10 == Integer.MIN_VALUE) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                this.f22694h = c.b(TypedValue.applyDimension(1, (float) i10, Resources.getSystem().getDisplayMetrics()));
                return this;
            }
            throw new IllegalArgumentException("The height of the balloon must bigger than zero.".toString());
        }

        public final Drawable h() {
            return this.f22728y;
        }

        public final o h0() {
            return this.f22709o0;
        }

        public final a h1(Drawable drawable) {
            this.T = drawable != null ? drawable.mutate() : null;
            return this;
        }

        public final float i() {
            return this.F;
        }

        public final p i0() {
            return this.f22711p0;
        }

        public final a i1(int i10) {
            this.W = c.b(TypedValue.applyDimension(1, (float) i10, Resources.getSystem().getDisplayMetrics()));
            return this;
        }

        public final int j() {
            return this.f22730z;
        }

        public final q j0() {
            return this.f22717s0;
        }

        public final a j1(int i10) {
            this.V = c.b(TypedValue.applyDimension(1, (float) i10, Resources.getSystem().getDisplayMetrics()));
            return this;
        }

        public final ArrowOrientation k() {
            return this.f22726x;
        }

        public final View.OnTouchListener k0() {
            return this.f22715r0;
        }

        public final a k1(boolean z10) {
            this.f22712q = z10;
            return this;
        }

        public final ArrowOrientationRules l() {
            return this.f22724w;
        }

        public final View.OnTouchListener l0() {
            return this.f22713q0;
        }

        public final a l1(int i10) {
            this.f22689e0 = Integer.valueOf(i10);
            return this;
        }

        public final float m() {
            return this.f22720u;
        }

        public final int m0() {
            return this.f22693g0;
        }

        public final a m1(l lVar) {
            this.A0 = lVar;
            return this;
        }

        public final ArrowPositionRules n() {
            return this.f22722v;
        }

        public final int n0() {
            return this.f22703l0;
        }

        public final a n1(int i10) {
            this.f22710p = j.g(this.f22680a, "<this>");
            return this;
        }

        public final int o() {
            return this.A;
        }

        public final float o0() {
            return this.f22695h0;
        }

        public final a o1(int i10) {
            p1(i10);
            q1(i10);
            return this;
        }

        public final int p() {
            return this.f22718t;
        }

        public final int p0() {
            return this.f22697i0;
        }

        public final a p1(int i10) {
            this.f22706n = j.g(this.f22680a, "<this>");
            return this;
        }

        public final int q() {
            return this.B;
        }

        public final Point q0() {
            return this.f22699j0;
        }

        public final a q1(int i10) {
            this.f22704m = j.g(this.f22680a, "<this>");
            return this;
        }

        public final long r() {
            return this.f22731z0;
        }

        public final yh.d r0() {
            return this.f22701k0;
        }

        public final a r1(int i10) {
            this.f22708o = j.g(this.f22680a, "<this>");
            return this;
        }

        public final int s() {
            return this.G;
        }

        public final int s0() {
            return this.f22702l;
        }

        public final /* synthetic */ a s1(Function0 function0) {
            j.g(function0, BlockContactsIQ.ELEMENT);
            this.f22707n0 = new i(function0);
            return this;
        }

        public final Drawable t() {
            return this.H;
        }

        public final int t0() {
            return this.f22696i;
        }

        public final /* synthetic */ a t1(Function1 function1) {
            j.g(function1, BlockContactsIQ.ELEMENT);
            this.f22709o0 = new j(function1);
            return this;
        }

        public final BalloonAnimation u() {
            return this.E0;
        }

        public final int u0() {
            return this.f22700k;
        }

        public final a u1(int i10) {
            this.f22693g0 = j.g(this.f22680a, "<this>");
            return this;
        }

        public final int v() {
            return this.C0;
        }

        public final int v0() {
            return this.f22698j;
        }

        public final a v1(int i10) {
            x1(i10);
            A1(i10);
            z1(i10);
            w1(i10);
            return this;
        }

        public final BalloonHighlightAnimation w() {
            return this.H0;
        }

        public final boolean w0() {
            return this.f22729y0;
        }

        public final a w1(int i10) {
            this.f22702l = c.b(TypedValue.applyDimension(1, (float) i10, Resources.getSystem().getDisplayMetrics()));
            return this;
        }

        public final long x() {
            return this.J0;
        }

        public final String x0() {
            return this.K0;
        }

        public final a x1(int i10) {
            this.f22696i = c.b(TypedValue.applyDimension(1, (float) i10, Resources.getSystem().getDisplayMetrics()));
            return this;
        }

        public final int y() {
            return this.I0;
        }

        public final Function0<Unit> y0() {
            return this.M0;
        }

        public final a y1(int i10) {
            int d10 = j.g(this.f22680a, "<this>");
            this.f22696i = d10;
            this.f22698j = d10;
            this.f22700k = d10;
            this.f22702l = d10;
            return this;
        }

        public final BalloonOverlayAnimation z() {
            return this.F0;
        }

        public final int z0() {
            return this.L0;
        }

        public final a z1(int i10) {
            this.f22700k = c.b(TypedValue.applyDimension(1, (float) i10, Resources.getSystem().getDisplayMetrics()));
            return this;
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f22732a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f22733b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ int[] f22734c;

        /* renamed from: d  reason: collision with root package name */
        public static final /* synthetic */ int[] f22735d;

        /* renamed from: e  reason: collision with root package name */
        public static final /* synthetic */ int[] f22736e;

        /* renamed from: f  reason: collision with root package name */
        public static final /* synthetic */ int[] f22737f;

        /* renamed from: g  reason: collision with root package name */
        public static final /* synthetic */ int[] f22738g;

        /* JADX WARNING: Can't wrap try/catch for region: R(52:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|(2:19|20)|21|23|24|25|26|27|28|29|30|(2:31|32)|33|35|36|37|39|40|41|42|43|44|45|46|47|49|50|51|52|53|54|(2:55|56)|57|59|60|61|62|63|64|(2:65|66)|67|69) */
        /* JADX WARNING: Can't wrap try/catch for region: R(55:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|23|24|25|26|27|28|29|30|(2:31|32)|33|35|36|37|39|40|41|42|43|44|45|46|47|49|50|51|52|53|54|(2:55|56)|57|59|60|61|62|63|64|65|66|67|69) */
        /* JADX WARNING: Can't wrap try/catch for region: R(58:0|(2:1|2)|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|20|21|23|24|25|26|27|28|29|30|31|32|33|35|36|37|39|40|41|42|43|44|45|46|47|49|50|51|52|53|54|55|56|57|59|60|61|62|63|64|65|66|67|69) */
        /* JADX WARNING: Can't wrap try/catch for region: R(59:0|1|2|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|20|21|23|24|25|26|27|28|29|30|31|32|33|35|36|37|39|40|41|42|43|44|45|46|47|49|50|51|52|53|54|55|56|57|59|60|61|62|63|64|65|66|67|69) */
        /* JADX WARNING: Can't wrap try/catch for region: R(60:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|23|24|25|26|27|28|29|30|31|32|33|35|36|37|39|40|41|42|43|44|45|46|47|49|50|51|52|53|54|55|56|57|59|60|61|62|63|64|65|66|67|69) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x003c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0055 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x005d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0065 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x006d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x0098 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00a0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00c1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x00c9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x00d1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x00ea */
        /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x00f2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x00fa */
        static {
            /*
                com.skydoves.balloon.ArrowOrientation[] r0 = com.skydoves.balloon.ArrowOrientation.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.skydoves.balloon.ArrowOrientation r2 = com.skydoves.balloon.ArrowOrientation.BOTTOM     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.skydoves.balloon.ArrowOrientation r3 = com.skydoves.balloon.ArrowOrientation.TOP     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                r3 = 3
                com.skydoves.balloon.ArrowOrientation r4 = com.skydoves.balloon.ArrowOrientation.START     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                r4 = 4
                com.skydoves.balloon.ArrowOrientation r5 = com.skydoves.balloon.ArrowOrientation.END     // Catch:{ NoSuchFieldError -> 0x002b }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r0[r5] = r4     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                f22732a = r0
                com.skydoves.balloon.ArrowPositionRules[] r0 = com.skydoves.balloon.ArrowPositionRules.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.skydoves.balloon.ArrowPositionRules r5 = com.skydoves.balloon.ArrowPositionRules.ALIGN_BALLOON     // Catch:{ NoSuchFieldError -> 0x003c }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x003c }
                r0[r5] = r1     // Catch:{ NoSuchFieldError -> 0x003c }
            L_0x003c:
                com.skydoves.balloon.ArrowPositionRules r5 = com.skydoves.balloon.ArrowPositionRules.ALIGN_ANCHOR     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r0[r5] = r2     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                f22733b = r0
                com.skydoves.balloon.BalloonAnimation[] r0 = com.skydoves.balloon.BalloonAnimation.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.skydoves.balloon.BalloonAnimation r5 = com.skydoves.balloon.BalloonAnimation.ELASTIC     // Catch:{ NoSuchFieldError -> 0x0055 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0055 }
                r0[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0055 }
            L_0x0055:
                com.skydoves.balloon.BalloonAnimation r5 = com.skydoves.balloon.BalloonAnimation.CIRCULAR     // Catch:{ NoSuchFieldError -> 0x005d }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x005d }
                r0[r5] = r2     // Catch:{ NoSuchFieldError -> 0x005d }
            L_0x005d:
                com.skydoves.balloon.BalloonAnimation r5 = com.skydoves.balloon.BalloonAnimation.FADE     // Catch:{ NoSuchFieldError -> 0x0065 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0065 }
                r0[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0065 }
            L_0x0065:
                com.skydoves.balloon.BalloonAnimation r5 = com.skydoves.balloon.BalloonAnimation.OVERSHOOT     // Catch:{ NoSuchFieldError -> 0x006d }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r0[r5] = r4     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                com.skydoves.balloon.BalloonAnimation r5 = com.skydoves.balloon.BalloonAnimation.NONE     // Catch:{ NoSuchFieldError -> 0x0076 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0076 }
                r6 = 5
                r0[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0076 }
            L_0x0076:
                f22734c = r0
                com.skydoves.balloon.overlay.BalloonOverlayAnimation[] r0 = com.skydoves.balloon.overlay.BalloonOverlayAnimation.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.skydoves.balloon.overlay.BalloonOverlayAnimation r5 = com.skydoves.balloon.overlay.BalloonOverlayAnimation.FADE     // Catch:{ NoSuchFieldError -> 0x0087 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0087 }
                r0[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0087 }
            L_0x0087:
                f22735d = r0
                com.skydoves.balloon.BalloonHighlightAnimation[] r0 = com.skydoves.balloon.BalloonHighlightAnimation.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.skydoves.balloon.BalloonHighlightAnimation r5 = com.skydoves.balloon.BalloonHighlightAnimation.HEARTBEAT     // Catch:{ NoSuchFieldError -> 0x0098 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0098 }
                r0[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0098 }
            L_0x0098:
                com.skydoves.balloon.BalloonHighlightAnimation r5 = com.skydoves.balloon.BalloonHighlightAnimation.SHAKE     // Catch:{ NoSuchFieldError -> 0x00a0 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a0 }
                r0[r5] = r2     // Catch:{ NoSuchFieldError -> 0x00a0 }
            L_0x00a0:
                com.skydoves.balloon.BalloonHighlightAnimation r5 = com.skydoves.balloon.BalloonHighlightAnimation.BREATH     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r0[r5] = r3     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                com.skydoves.balloon.BalloonHighlightAnimation r5 = com.skydoves.balloon.BalloonHighlightAnimation.ROTATE     // Catch:{ NoSuchFieldError -> 0x00b0 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b0 }
                r0[r5] = r4     // Catch:{ NoSuchFieldError -> 0x00b0 }
            L_0x00b0:
                f22736e = r0
                com.skydoves.balloon.BalloonCenterAlign[] r0 = com.skydoves.balloon.BalloonCenterAlign.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.skydoves.balloon.BalloonCenterAlign r5 = com.skydoves.balloon.BalloonCenterAlign.TOP     // Catch:{ NoSuchFieldError -> 0x00c1 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c1 }
                r0[r5] = r1     // Catch:{ NoSuchFieldError -> 0x00c1 }
            L_0x00c1:
                com.skydoves.balloon.BalloonCenterAlign r5 = com.skydoves.balloon.BalloonCenterAlign.BOTTOM     // Catch:{ NoSuchFieldError -> 0x00c9 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c9 }
                r0[r5] = r2     // Catch:{ NoSuchFieldError -> 0x00c9 }
            L_0x00c9:
                com.skydoves.balloon.BalloonCenterAlign r5 = com.skydoves.balloon.BalloonCenterAlign.START     // Catch:{ NoSuchFieldError -> 0x00d1 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d1 }
                r0[r5] = r3     // Catch:{ NoSuchFieldError -> 0x00d1 }
            L_0x00d1:
                com.skydoves.balloon.BalloonCenterAlign r5 = com.skydoves.balloon.BalloonCenterAlign.END     // Catch:{ NoSuchFieldError -> 0x00d9 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d9 }
                r0[r5] = r4     // Catch:{ NoSuchFieldError -> 0x00d9 }
            L_0x00d9:
                f22737f = r0
                com.skydoves.balloon.BalloonAlign[] r0 = com.skydoves.balloon.BalloonAlign.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.skydoves.balloon.BalloonAlign r5 = com.skydoves.balloon.BalloonAlign.TOP     // Catch:{ NoSuchFieldError -> 0x00ea }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ea }
                r0[r5] = r1     // Catch:{ NoSuchFieldError -> 0x00ea }
            L_0x00ea:
                com.skydoves.balloon.BalloonAlign r1 = com.skydoves.balloon.BalloonAlign.BOTTOM     // Catch:{ NoSuchFieldError -> 0x00f2 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f2 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f2 }
            L_0x00f2:
                com.skydoves.balloon.BalloonAlign r1 = com.skydoves.balloon.BalloonAlign.END     // Catch:{ NoSuchFieldError -> 0x00fa }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fa }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x00fa }
            L_0x00fa:
                com.skydoves.balloon.BalloonAlign r1 = com.skydoves.balloon.BalloonAlign.START     // Catch:{ NoSuchFieldError -> 0x0102 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0102 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0102 }
            L_0x0102:
                f22738g = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.skydoves.balloon.Balloon.b.<clinit>():void");
        }
    }

    public static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f22739a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f22740b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Function0 f22741c;

        public static final class a extends AnimatorListenerAdapter {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Function0 f22742a;

            public a(Function0 function0) {
                this.f22742a = function0;
            }

            public void onAnimationEnd(Animator animator) {
                j.g(animator, "animation");
                super.onAnimationEnd(animator);
                this.f22742a.invoke();
            }
        }

        public c(View view, long j10, Function0 function0) {
            this.f22739a = view;
            this.f22740b = j10;
            this.f22741c = function0;
        }

        public final void run() {
            if (this.f22739a.isAttachedToWindow()) {
                View view = this.f22739a;
                Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, (view.getLeft() + this.f22739a.getRight()) / 2, (this.f22739a.getTop() + this.f22739a.getBottom()) / 2, (float) Math.max(this.f22739a.getWidth(), this.f22739a.getHeight()), 0.0f);
                createCircularReveal.setDuration(this.f22740b);
                createCircularReveal.start();
                createCircularReveal.addListener(new a(this.f22741c));
            }
        }
    }

    public static final class d implements View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Balloon f22743a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ p f22744b;

        d(Balloon balloon, p pVar) {
            this.f22743a = balloon;
            this.f22744b = pVar;
        }

        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            j.g(view, "view");
            j.g(motionEvent, "event");
            if (motionEvent.getAction() != 4) {
                return false;
            }
            if (this.f22743a.f22669b.I()) {
                this.f22743a.I();
            }
            p pVar = this.f22744b;
            if (pVar == null) {
                return true;
            }
            pVar.a(view, motionEvent);
            return true;
        }
    }

    public static final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Balloon f22745a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f22746b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View[] f22747c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Balloon f22748d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ View f22749e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f22750f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ int f22751g;

        public e(Balloon balloon, View view, View[] viewArr, Balloon balloon2, View view2, int i10, int i11) {
            this.f22745a = balloon;
            this.f22746b = view;
            this.f22747c = viewArr;
            this.f22748d = balloon2;
            this.f22749e = view2;
            this.f22750f = i10;
            this.f22751g = i11;
        }

        public final void run() {
            Boolean valueOf = Boolean.valueOf(this.f22745a.G(this.f22746b));
            if (!valueOf.booleanValue()) {
                valueOf = null;
            }
            if (valueOf != null) {
                valueOf.booleanValue();
                String x02 = this.f22745a.f22669b.x0();
                if (x02 != null) {
                    Balloon balloon = this.f22745a;
                    if (balloon.Q().g(x02, balloon.f22669b.z0())) {
                        balloon.Q().f(x02);
                    } else {
                        Function0<Unit> y02 = balloon.f22669b.y0();
                        if (y02 != null) {
                            y02.invoke();
                            return;
                        }
                        return;
                    }
                }
                this.f22745a.f22674g = true;
                long r10 = this.f22745a.f22669b.r();
                if (r10 != -1) {
                    this.f22745a.J(r10);
                }
                if (this.f22745a.b0()) {
                    Balloon balloon2 = this.f22745a;
                    RadiusLayout radiusLayout = balloon2.f22670c.f24678d;
                    j.f(radiusLayout, "binding.balloonCard");
                    balloon2.M0(radiusLayout);
                } else {
                    Balloon balloon3 = this.f22745a;
                    VectorTextView vectorTextView = balloon3.f22670c.f24680f;
                    j.f(vectorTextView, "binding.balloonText");
                    RadiusLayout radiusLayout2 = this.f22745a.f22670c.f24678d;
                    j.f(radiusLayout2, "binding.balloonCard");
                    balloon3.o0(vectorTextView, radiusLayout2);
                }
                this.f22745a.f22670c.getRoot().measure(0, 0);
                if (!this.f22745a.f22669b.N0()) {
                    this.f22745a.R().setWidth(this.f22745a.Y());
                    this.f22745a.R().setHeight(this.f22745a.W());
                }
                this.f22745a.f22670c.f24680f.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                this.f22745a.c0(this.f22746b);
                this.f22745a.f0();
                this.f22745a.F();
                Balloon balloon4 = this.f22745a;
                View[] viewArr = this.f22747c;
                balloon4.H0((View[]) Arrays.copyOf(viewArr, viewArr.length));
                this.f22745a.p0(this.f22746b);
                this.f22745a.E();
                this.f22745a.I0();
                this.f22748d.R().showAsDropDown(this.f22749e, this.f22748d.f22669b.A0() * (((this.f22749e.getMeasuredWidth() / 2) - (this.f22748d.Y() / 2)) + this.f22750f), this.f22751g);
            }
        }
    }

    public static final class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Balloon f22752a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f22753b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View[] f22754c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Balloon f22755d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ View f22756e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f22757f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ int f22758g;

        public f(Balloon balloon, View view, View[] viewArr, Balloon balloon2, View view2, int i10, int i11) {
            this.f22752a = balloon;
            this.f22753b = view;
            this.f22754c = viewArr;
            this.f22755d = balloon2;
            this.f22756e = view2;
            this.f22757f = i10;
            this.f22758g = i11;
        }

        public final void run() {
            Boolean valueOf = Boolean.valueOf(this.f22752a.G(this.f22753b));
            if (!valueOf.booleanValue()) {
                valueOf = null;
            }
            if (valueOf != null) {
                valueOf.booleanValue();
                String x02 = this.f22752a.f22669b.x0();
                if (x02 != null) {
                    Balloon balloon = this.f22752a;
                    if (balloon.Q().g(x02, balloon.f22669b.z0())) {
                        balloon.Q().f(x02);
                    } else {
                        Function0<Unit> y02 = balloon.f22669b.y0();
                        if (y02 != null) {
                            y02.invoke();
                            return;
                        }
                        return;
                    }
                }
                this.f22752a.f22674g = true;
                long r10 = this.f22752a.f22669b.r();
                if (r10 != -1) {
                    this.f22752a.J(r10);
                }
                if (this.f22752a.b0()) {
                    Balloon balloon2 = this.f22752a;
                    RadiusLayout radiusLayout = balloon2.f22670c.f24678d;
                    j.f(radiusLayout, "binding.balloonCard");
                    balloon2.M0(radiusLayout);
                } else {
                    Balloon balloon3 = this.f22752a;
                    VectorTextView vectorTextView = balloon3.f22670c.f24680f;
                    j.f(vectorTextView, "binding.balloonText");
                    RadiusLayout radiusLayout2 = this.f22752a.f22670c.f24678d;
                    j.f(radiusLayout2, "binding.balloonCard");
                    balloon3.o0(vectorTextView, radiusLayout2);
                }
                this.f22752a.f22670c.getRoot().measure(0, 0);
                if (!this.f22752a.f22669b.N0()) {
                    this.f22752a.R().setWidth(this.f22752a.Y());
                    this.f22752a.R().setHeight(this.f22752a.W());
                }
                this.f22752a.f22670c.f24680f.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                this.f22752a.c0(this.f22753b);
                this.f22752a.f0();
                this.f22752a.F();
                Balloon balloon4 = this.f22752a;
                View[] viewArr = this.f22754c;
                balloon4.H0((View[]) Arrays.copyOf(viewArr, viewArr.length));
                this.f22752a.p0(this.f22753b);
                this.f22752a.E();
                this.f22752a.I0();
                this.f22755d.R().showAsDropDown(this.f22756e, this.f22755d.f22669b.A0() * (((this.f22756e.getMeasuredWidth() / 2) - (this.f22755d.Y() / 2)) + this.f22757f), ((-this.f22755d.W()) - this.f22756e.getMeasuredHeight()) + this.f22758g);
            }
        }
    }

    private Balloon(Context context, a aVar) {
        this.f22668a = context;
        this.f22669b = aVar;
        wh.a c10 = wh.a.c(LayoutInflater.from(context), (ViewGroup) null, false);
        j.f(c10, "inflate(LayoutInflater.from(context), null, false)");
        this.f22670c = c10;
        wh.b c11 = wh.b.c(LayoutInflater.from(context), (ViewGroup) null, false);
        j.f(c11, "inflate(LayoutInflater.from(context), null, false)");
        this.f22671d = c11;
        this.f22672e = new PopupWindow(c10.getRoot(), -2, -2);
        this.f22673f = new PopupWindow(c11.getRoot(), -1, -1);
        this.f22676j = aVar.h0();
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.f22677k = b.a(lazyThreadSafetyMode, Balloon$handler$2.f22759a);
        this.f22678l = b.a(lazyThreadSafetyMode, new Balloon$autoDismissRunnable$2(this));
        this.f22679m = b.a(lazyThreadSafetyMode, new Balloon$balloonPersistence$2(this));
        H();
    }

    public /* synthetic */ Balloon(Context context, a aVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, aVar);
    }

    /* access modifiers changed from: private */
    public static final boolean A0(Function2 function2, View view, MotionEvent motionEvent) {
        j.g(function2, "$tmp0");
        return ((Boolean) function2.invoke(view, motionEvent)).booleanValue();
    }

    private final Bitmap B(ImageView imageView, float f10, float f11) {
        LinearGradient linearGradient;
        ImageView imageView2 = imageView;
        imageView2.setColorFilter(this.f22669b.s(), PorterDuff.Mode.SRC_IN);
        Drawable drawable = imageView.getDrawable();
        j.f(drawable, "imageView.drawable");
        Bitmap K = K(drawable, imageView.getDrawable().getIntrinsicWidth(), imageView.getDrawable().getIntrinsicHeight());
        try {
            Pair<Integer, Integer> S = S(f10, f11);
            int intValue = S.c().intValue();
            int intValue2 = S.d().intValue();
            Bitmap createBitmap = Bitmap.createBitmap(K.getWidth(), K.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawBitmap(K, 0.0f, 0.0f, (Paint) null);
            Paint paint = new Paint();
            int i10 = b.f22732a[this.f22669b.k().ordinal()];
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        if (i10 != 4) {
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                }
                linearGradient = new LinearGradient((((float) this.f22669b.p()) * 0.5f) + (((float) K.getWidth()) / ((float) 2)), 0.0f, 0.0f, 0.0f, intValue, intValue2, Shader.TileMode.CLAMP);
                paint.setShader(linearGradient);
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                canvas.drawRect(0.0f, 0.0f, (float) K.getWidth(), (float) K.getHeight(), paint);
                imageView2.setColorFilter(0, PorterDuff.Mode.SRC_IN);
                j.f(createBitmap, "updatedBitmap");
                return createBitmap;
            }
            linearGradient = new LinearGradient((((float) K.getWidth()) / ((float) 2)) - (((float) this.f22669b.p()) * 0.5f), 0.0f, (float) K.getWidth(), 0.0f, intValue, intValue2, Shader.TileMode.CLAMP);
            paint.setShader(linearGradient);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawRect(0.0f, 0.0f, (float) K.getWidth(), (float) K.getHeight(), paint);
            imageView2.setColorFilter(0, PorterDuff.Mode.SRC_IN);
            j.f(createBitmap, "updatedBitmap");
            return createBitmap;
        } catch (IllegalArgumentException unused) {
            throw new IllegalArgumentException("Arrow attached outside balloon. Could not get a matching color.");
        }
    }

    private final void C(View view) {
        if (this.f22669b.l() != ArrowOrientationRules.ALIGN_FIXED) {
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            int[] iArr = {0, 0};
            this.f22672e.getContentView().getLocationOnScreen(iArr);
            ArrowOrientation k10 = this.f22669b.k();
            ArrowOrientation arrowOrientation = ArrowOrientation.TOP;
            if (k10 == arrowOrientation && iArr[1] < rect.bottom) {
                this.f22669b.W0(ArrowOrientation.BOTTOM);
            } else if (this.f22669b.k() == ArrowOrientation.BOTTOM && iArr[1] > rect.top) {
                this.f22669b.W0(arrowOrientation);
            }
            ArrowOrientation k11 = this.f22669b.k();
            ArrowOrientation arrowOrientation2 = ArrowOrientation.START;
            if (k11 == arrowOrientation2 && iArr[0] < rect.right) {
                this.f22669b.W0(ArrowOrientation.END);
            } else if (this.f22669b.k() == ArrowOrientation.END && iArr[0] > rect.left) {
                this.f22669b.W0(arrowOrientation2);
            }
            f0();
        }
    }

    private final void D(ViewGroup viewGroup) {
        viewGroup.setFitsSystemWindows(false);
        IntRange o10 = j.o(0, viewGroup.getChildCount());
        ArrayList<View> arrayList = new ArrayList<>(r.t(o10, 10));
        Iterator it = o10.iterator();
        while (it.hasNext()) {
            arrayList.add(viewGroup.getChildAt(((b0) it).nextInt()));
        }
        for (View view : arrayList) {
            view.setFitsSystemWindows(false);
            if (view instanceof ViewGroup) {
                D((ViewGroup) view);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void E() {
        if (this.f22669b.v() == Integer.MIN_VALUE) {
            int i10 = b.f22734c[this.f22669b.u().ordinal()];
            if (i10 == 1) {
                this.f22672e.setAnimationStyle(u.Balloon_Elastic_Anim);
            } else if (i10 == 2) {
                View contentView = this.f22672e.getContentView();
                j.f(contentView, "bodyWindow.contentView");
                xh.f.b(contentView, this.f22669b.C());
                this.f22672e.setAnimationStyle(u.Balloon_Normal_Dispose_Anim);
            } else if (i10 == 3) {
                this.f22672e.setAnimationStyle(u.Balloon_Fade_Anim);
            } else if (i10 == 4) {
                this.f22672e.setAnimationStyle(u.Balloon_Overshoot_Anim);
            } else if (i10 == 5) {
                this.f22672e.setAnimationStyle(u.Balloon_Normal_Anim);
            }
        } else {
            this.f22672e.setAnimationStyle(this.f22669b.v());
        }
    }

    public static /* synthetic */ void E0(Balloon balloon, View view, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = 0;
        }
        balloon.D0(view, i10, i11);
    }

    /* access modifiers changed from: private */
    public final void F() {
        if (this.f22669b.A() == Integer.MIN_VALUE) {
            if (b.f22735d[this.f22669b.z().ordinal()] == 1) {
                this.f22673f.setAnimationStyle(u.Balloon_Fade_Anim);
            } else {
                this.f22673f.setAnimationStyle(u.Balloon_Normal_Anim);
            }
        } else {
            this.f22673f.setAnimationStyle(this.f22669b.v());
        }
    }

    /* access modifiers changed from: private */
    public final boolean G(View view) {
        boolean z10;
        if (!this.f22674g && !this.f22675h) {
            Context context = this.f22668a;
            if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (!z10 && this.f22672e.getContentView().getParent() == null && n0.V(view)) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ void G0(Balloon balloon, View view, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = 0;
        }
        balloon.F0(view, i10, i11);
    }

    private final void H() {
        Lifecycle lifecycle;
        e0();
        j0();
        k0();
        g0();
        f0();
        i0();
        h0();
        FrameLayout b10 = this.f22670c.getRoot();
        j.f(b10, "binding.root");
        D(b10);
        if (this.f22669b.V() == null) {
            Context context = this.f22668a;
            if (context instanceof l) {
                this.f22669b.m1((l) context);
                Lifecycle lifecycle2 = ((l) this.f22668a).getLifecycle();
                k U = this.f22669b.U();
                if (U == null) {
                    U = this;
                }
                lifecycle2.a(U);
                return;
            }
        }
        l V = this.f22669b.V();
        if (V != null && (lifecycle = V.getLifecycle()) != null) {
            k U2 = this.f22669b.U();
            if (U2 == null) {
                U2 = this;
            }
            lifecycle.a(U2);
        }
    }

    /* access modifiers changed from: private */
    public final void H0(View... viewArr) {
        if (this.f22669b.S0()) {
            View view = viewArr[0];
            if (viewArr.length == 1) {
                this.f22671d.f24683b.setAnchorView(view);
            } else {
                this.f22671d.f24683b.setAnchorViewList(l.p0(viewArr));
            }
            this.f22673f.showAtLocation(view, this.f22669b.n0(), 0, 0);
        }
    }

    /* access modifiers changed from: private */
    public final void I0() {
        this.f22670c.f24676b.post(new f(this));
    }

    /* access modifiers changed from: private */
    public static final void J0(Balloon balloon) {
        j.g(balloon, "this$0");
        new Handler(Looper.getMainLooper()).postDelayed(new h(balloon), balloon.f22669b.x());
    }

    private final Bitmap K(Drawable drawable, int i10, int i11) {
        Bitmap createBitmap = Bitmap.createBitmap(i10, i11, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        j.f(createBitmap, "bitmap");
        return createBitmap;
    }

    /* access modifiers changed from: private */
    public static final void K0(Balloon balloon) {
        j.g(balloon, "this$0");
        Animation P = balloon.P();
        if (P != null) {
            balloon.f22670c.f24676b.startAnimation(P);
        }
    }

    private final float L(View view) {
        FrameLayout frameLayout = this.f22670c.f24679e;
        j.f(frameLayout, "binding.balloonContent");
        int i10 = xh.f.e(frameLayout).x;
        int i11 = xh.f.e(view).x;
        float Z = Z();
        float Y = ((((float) Y()) - Z) - ((float) this.f22669b.Y())) - ((float) this.f22669b.X());
        int i12 = b.f22733b[this.f22669b.n().ordinal()];
        if (i12 == 1) {
            return (((float) this.f22670c.f24681g.getWidth()) * this.f22669b.m()) - (((float) this.f22669b.p()) * 0.5f);
        }
        if (i12 != 2) {
            throw new NoWhenBranchMatchedException();
        } else if (view.getWidth() + i11 < i10) {
            return Z;
        } else {
            if (Y() + i10 >= i11) {
                float width = (((((float) view.getWidth()) * this.f22669b.m()) + ((float) i11)) - ((float) i10)) - (((float) this.f22669b.p()) * 0.5f);
                if (width <= ((float) U())) {
                    return Z;
                }
                if (width <= ((float) (Y() - U()))) {
                    return width;
                }
            }
            return Y;
        }
    }

    private final void L0() {
        FrameLayout frameLayout = this.f22670c.f24676b;
        Animation animation = frameLayout.getAnimation();
        if (animation != null) {
            j.f(animation, "animation");
            animation.cancel();
            animation.reset();
        }
        frameLayout.clearAnimation();
    }

    private final float M(View view) {
        int d10 = xh.f.d(view, this.f22669b.Q0());
        FrameLayout frameLayout = this.f22670c.f24679e;
        j.f(frameLayout, "binding.balloonContent");
        int i10 = xh.f.e(frameLayout).y - d10;
        int i11 = xh.f.e(view).y - d10;
        float Z = Z();
        float W = ((((float) W()) - Z) - ((float) this.f22669b.Z())) - ((float) this.f22669b.W());
        int p10 = this.f22669b.p() / 2;
        int i12 = b.f22733b[this.f22669b.n().ordinal()];
        if (i12 == 1) {
            return (((float) this.f22670c.f24681g.getHeight()) * this.f22669b.m()) - ((float) p10);
        }
        if (i12 != 2) {
            throw new NoWhenBranchMatchedException();
        } else if (view.getHeight() + i11 < i10) {
            return Z;
        } else {
            if (W() + i10 >= i11) {
                float height = (((((float) view.getHeight()) * this.f22669b.m()) + ((float) i11)) - ((float) i10)) - ((float) p10);
                if (height <= ((float) U())) {
                    return Z;
                }
                if (height <= ((float) (W() - U()))) {
                    return height;
                }
            }
            return W;
        }
    }

    /* access modifiers changed from: private */
    public final void M0(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            j.f(childAt, "getChildAt(index)");
            if (childAt instanceof TextView) {
                o0((TextView) childAt, viewGroup);
            } else if (childAt instanceof ViewGroup) {
                M0((ViewGroup) childAt);
            }
        }
    }

    private final BitmapDrawable N(ImageView imageView, float f10, float f11) {
        if (!this.f22669b.g() || !xh.c.a()) {
            return null;
        }
        return new BitmapDrawable(imageView.getResources(), B(imageView, f10, f11));
    }

    /* access modifiers changed from: private */
    public final a O() {
        return (a) this.f22678l.getValue();
    }

    private final Animation P() {
        int i10;
        if (this.f22669b.y() == Integer.MIN_VALUE) {
            int i11 = b.f22736e[this.f22669b.w().ordinal()];
            if (i11 != 1) {
                if (i11 == 2) {
                    int i12 = b.f22732a[this.f22669b.k().ordinal()];
                    if (i12 == 1) {
                        i10 = r.balloon_shake_top;
                    } else if (i12 == 2) {
                        i10 = r.balloon_shake_bottom;
                    } else if (i12 == 3) {
                        i10 = r.balloon_shake_right;
                    } else if (i12 == 4) {
                        i10 = r.balloon_shake_left;
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else if (i11 == 3) {
                    i10 = r.balloon_fade;
                } else if (i11 != 4) {
                    return null;
                } else {
                    this.f22669b.B();
                    return null;
                }
            } else if (this.f22669b.R0()) {
                int i13 = b.f22732a[this.f22669b.k().ordinal()];
                if (i13 == 1) {
                    i10 = r.balloon_heartbeat_top;
                } else if (i13 == 2) {
                    i10 = r.balloon_heartbeat_bottom;
                } else if (i13 == 3) {
                    i10 = r.balloon_heartbeat_right;
                } else if (i13 == 4) {
                    i10 = r.balloon_heartbeat_left;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                i10 = r.balloon_heartbeat_center;
            }
        } else {
            i10 = this.f22669b.y();
        }
        return AnimationUtils.loadAnimation(this.f22668a, i10);
    }

    /* access modifiers changed from: private */
    public final k Q() {
        return (k) this.f22679m.getValue();
    }

    private final Pair<Integer, Integer> S(float f10, float f11) {
        int i10;
        int i11;
        Drawable background = this.f22670c.f24678d.getBackground();
        j.f(background, "binding.balloonCard.background");
        Bitmap K = K(background, this.f22670c.f24678d.getWidth() + 1, this.f22670c.f24678d.getHeight() + 1);
        int i12 = b.f22732a[this.f22669b.k().ordinal()];
        if (i12 == 1 || i12 == 2) {
            int i13 = (int) f11;
            i11 = K.getPixel((int) ((((float) this.f22669b.p()) * 0.5f) + f10), i13);
            i10 = K.getPixel((int) (f10 - (((float) this.f22669b.p()) * 0.5f)), i13);
        } else if (i12 == 3 || i12 == 4) {
            int i14 = (int) f10;
            i11 = K.getPixel(i14, (int) ((((float) this.f22669b.p()) * 0.5f) + f11));
            i10 = K.getPixel(i14, (int) (f11 - (((float) this.f22669b.p()) * 0.5f)));
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return new Pair<>(Integer.valueOf(i11), Integer.valueOf(i10));
    }

    private final int U() {
        return this.f22669b.p() * 2;
    }

    /* access modifiers changed from: private */
    public final Handler V() {
        return (Handler) this.f22677k.getValue();
    }

    private final int X(int i10, View view) {
        int i11;
        int i12;
        boolean z10;
        boolean z11;
        float f10;
        boolean z12;
        int K0;
        int i13 = new Point(Resources.getSystem().getDisplayMetrics().widthPixels, Resources.getSystem().getDisplayMetrics().heightPixels).x;
        int paddingLeft = view.getPaddingLeft() + view.getPaddingRight();
        boolean z13 = false;
        if (this.f22669b.M() != null) {
            i11 = this.f22669b.R();
            i12 = this.f22669b.Q();
        } else {
            i11 = this.f22669b.Y() + 0 + this.f22669b.X();
            i12 = this.f22669b.p() * 2;
        }
        int i14 = paddingLeft + i11 + i12;
        int a02 = this.f22669b.a0() - i14;
        if (this.f22669b.L0() == 0.0f) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            K0 = (int) (((float) i13) * this.f22669b.L0());
        } else {
            if (this.f22669b.d0() == 0.0f) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                if (this.f22669b.b0() == 0.0f) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (z12) {
                    if (this.f22669b.K0() == Integer.MIN_VALUE || this.f22669b.K0() > i13) {
                        return j.g(i10, a02);
                    }
                    K0 = this.f22669b.K0();
                }
            }
            if (this.f22669b.b0() == 0.0f) {
                z13 = true;
            }
            if (!z13) {
                f10 = this.f22669b.b0();
            } else {
                f10 = 1.0f;
            }
            return j.g(i10, ((int) (((float) i13) * f10)) - i14);
        }
        return K0 - i14;
    }

    private final float Z() {
        return (((float) this.f22669b.p()) * this.f22669b.d()) + ((float) this.f22669b.c());
    }

    /* access modifiers changed from: private */
    public final boolean b0() {
        return (this.f22669b.T() == null && this.f22669b.S() == null) ? false : true;
    }

    /* access modifiers changed from: private */
    public final void c0(View view) {
        ImageView imageView = this.f22670c.f24677c;
        imageView.setLayoutParams(new FrameLayout.LayoutParams(this.f22669b.p(), this.f22669b.p()));
        imageView.setAlpha(this.f22669b.b());
        Drawable h10 = this.f22669b.h();
        if (h10 != null) {
            imageView.setImageDrawable(h10);
        }
        imageView.setPadding(this.f22669b.j(), this.f22669b.q(), this.f22669b.o(), this.f22669b.e());
        if (this.f22669b.f() != Integer.MIN_VALUE) {
            h.c(imageView, ColorStateList.valueOf(this.f22669b.f()));
        } else {
            h.c(imageView, ColorStateList.valueOf(this.f22669b.s()));
        }
        imageView.setOutlineProvider(ViewOutlineProvider.BOUNDS);
        this.f22670c.f24678d.post(new c(this, view, imageView));
    }

    /* access modifiers changed from: private */
    public static final void d0(Balloon balloon, View view, ImageView imageView) {
        j.g(balloon, "this$0");
        j.g(view, "$anchor");
        j.g(imageView, "$this_with");
        o oVar = balloon.f22676j;
        if (oVar != null) {
            oVar.b(balloon.T());
        }
        balloon.C(view);
        int i10 = b.f22732a[ArrowOrientation.f22655a.a(balloon.f22669b.k(), balloon.f22669b.P0()).ordinal()];
        if (i10 == 1) {
            imageView.setRotation(180.0f);
            imageView.setX(balloon.L(view));
            imageView.setY((balloon.f22670c.f24678d.getY() + ((float) balloon.f22670c.f24678d.getHeight())) - ((float) 1));
            n0.A0(imageView, balloon.f22669b.i());
            imageView.setForeground(balloon.N(imageView, imageView.getX(), (float) balloon.f22670c.f24678d.getHeight()));
        } else if (i10 == 2) {
            imageView.setRotation(0.0f);
            imageView.setX(balloon.L(view));
            imageView.setY((balloon.f22670c.f24678d.getY() - ((float) balloon.f22669b.p())) + ((float) 1));
            imageView.setForeground(balloon.N(imageView, imageView.getX(), 0.0f));
        } else if (i10 == 3) {
            imageView.setRotation(-90.0f);
            imageView.setX((balloon.f22670c.f24678d.getX() - ((float) balloon.f22669b.p())) + ((float) 1));
            imageView.setY(balloon.M(view));
            imageView.setForeground(balloon.N(imageView, 0.0f, imageView.getY()));
        } else if (i10 == 4) {
            imageView.setRotation(90.0f);
            imageView.setX((balloon.f22670c.f24678d.getX() + ((float) balloon.f22670c.f24678d.getWidth())) - ((float) 1));
            imageView.setY(balloon.M(view));
            imageView.setForeground(balloon.N(imageView, (float) balloon.f22670c.f24678d.getWidth(), imageView.getY()));
        }
        xh.f.f(imageView, balloon.f22669b.R0());
    }

    private final void e0() {
        RadiusLayout radiusLayout = this.f22670c.f24678d;
        radiusLayout.setAlpha(this.f22669b.b());
        radiusLayout.setRadius(this.f22669b.D());
        n0.A0(radiusLayout, this.f22669b.J());
        Drawable t10 = this.f22669b.t();
        GradientDrawable gradientDrawable = t10;
        if (t10 == null) {
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setColor(this.f22669b.s());
            gradientDrawable2.setCornerRadius(this.f22669b.D());
            gradientDrawable = gradientDrawable2;
        }
        radiusLayout.setBackground(gradientDrawable);
        radiusLayout.setPadding(this.f22669b.t0(), this.f22669b.v0(), this.f22669b.u0(), this.f22669b.s0());
    }

    /* access modifiers changed from: private */
    public final void f0() {
        int p10 = this.f22669b.p() - 1;
        int J = (int) this.f22669b.J();
        FrameLayout frameLayout = this.f22670c.f24679e;
        int i10 = b.f22732a[this.f22669b.k().ordinal()];
        if (i10 == 1) {
            frameLayout.setPadding(J, p10, J, j.c(p10, J));
        } else if (i10 == 2) {
            frameLayout.setPadding(J, p10, J, j.c(p10, J));
        } else if (i10 == 3) {
            frameLayout.setPadding(p10, J, p10, J);
        } else if (i10 == 4) {
            frameLayout.setPadding(p10, J, p10, J);
        }
    }

    private final void g0() {
        if (b0()) {
            l0();
            return;
        }
        m0();
        n0();
    }

    private final void h0() {
        r0(this.f22669b.f0());
        t0(this.f22669b.g0());
        v0(this.f22669b.i0());
        B0(this.f22669b.l0());
        w0(this.f22669b.j0());
        y0(this.f22669b.k0());
    }

    private final void i0() {
        if (this.f22669b.S0()) {
            BalloonAnchorOverlayView balloonAnchorOverlayView = this.f22671d.f24683b;
            balloonAnchorOverlayView.setOverlayColor(this.f22669b.m0());
            balloonAnchorOverlayView.setOverlayPadding(this.f22669b.o0());
            balloonAnchorOverlayView.setOverlayPosition(this.f22669b.q0());
            balloonAnchorOverlayView.setBalloonOverlayShape(this.f22669b.r0());
            balloonAnchorOverlayView.setOverlayPaddingColor(this.f22669b.p0());
            this.f22673f.setClippingEnabled(false);
        }
    }

    private final void j0() {
        ViewGroup.LayoutParams layoutParams = this.f22670c.f24681g.getLayoutParams();
        j.e(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(this.f22669b.X(), this.f22669b.Z(), this.f22669b.Y(), this.f22669b.W());
    }

    private final void k0() {
        PopupWindow popupWindow = this.f22672e;
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(this.f22669b.O0());
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setElevation(this.f22669b.J());
        q0(this.f22669b.M0());
    }

    private final void l0() {
        View view;
        ViewGroup viewGroup;
        Integer T = this.f22669b.T();
        if ((T == null || (view = LayoutInflater.from(this.f22668a).inflate(T.intValue(), this.f22670c.f24678d, false)) == null) && (view = this.f22669b.S()) == null) {
            throw new IllegalArgumentException("The custom layout is null.");
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        this.f22670c.f24678d.removeAllViews();
        this.f22670c.f24678d.addView(view);
        RadiusLayout radiusLayout = this.f22670c.f24678d;
        j.f(radiusLayout, "binding.balloonCard");
        M0(radiusLayout);
    }

    private final void m0() {
        Unit unit;
        VectorTextView vectorTextView = this.f22670c.f24680f;
        l N = this.f22669b.N();
        if (N != null) {
            j.f(vectorTextView, "initializeIcon$lambda$16$lambda$14");
            xh.d.b(vectorTextView, N);
            unit = Unit.f32013a;
        } else {
            unit = null;
        }
        if (unit == null) {
            j.f(vectorTextView, "initializeIcon$lambda$16");
            Context context = vectorTextView.getContext();
            j.f(context, IdentityHttpResponse.CONTEXT);
            l.a aVar = new l.a(context);
            aVar.j(this.f22669b.M());
            aVar.o(this.f22669b.R());
            aVar.m(this.f22669b.P());
            aVar.l(this.f22669b.L());
            aVar.n(this.f22669b.Q());
            aVar.k(this.f22669b.O());
            xh.d.b(vectorTextView, aVar.a());
        }
        vectorTextView.s(this.f22669b.P0());
    }

    private final void n0() {
        Unit unit;
        VectorTextView vectorTextView = this.f22670c.f24680f;
        w D0 = this.f22669b.D0();
        if (D0 != null) {
            j.f(vectorTextView, "initializeText$lambda$19$lambda$17");
            xh.d.c(vectorTextView, D0);
            unit = Unit.f32013a;
        } else {
            unit = null;
        }
        if (unit == null) {
            j.f(vectorTextView, "initializeText$lambda$19");
            Context context = vectorTextView.getContext();
            j.f(context, IdentityHttpResponse.CONTEXT);
            w.a aVar = new w.a(context);
            aVar.k(this.f22669b.B0());
            aVar.p(this.f22669b.H0());
            aVar.l(this.f22669b.C0());
            aVar.n(this.f22669b.F0());
            aVar.m(this.f22669b.E0());
            aVar.q(this.f22669b.I0());
            aVar.r(this.f22669b.J0());
            aVar.o(this.f22669b.G0());
            vectorTextView.setMovementMethod(this.f22669b.e0());
            xh.d.c(vectorTextView, aVar.a());
        }
        j.f(vectorTextView, "this");
        RadiusLayout radiusLayout = this.f22670c.f24678d;
        j.f(radiusLayout, "binding.balloonCard");
        o0(vectorTextView, radiusLayout);
    }

    /* access modifiers changed from: private */
    public final void o0(TextView textView, View view) {
        int c10;
        int compoundPaddingStart;
        int compoundPaddingEnd;
        int measureText = (int) textView.getPaint().measureText(textView.getText().toString());
        Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
        j.f(compoundDrawablesRelative, "compoundDrawablesRelative");
        if (xh.b.e(compoundDrawablesRelative)) {
            Drawable[] compoundDrawablesRelative2 = textView.getCompoundDrawablesRelative();
            j.f(compoundDrawablesRelative2, "compoundDrawablesRelative");
            textView.setMinHeight(j.g(compoundDrawablesRelative2, "<this>"));
            Drawable[] compoundDrawablesRelative3 = textView.getCompoundDrawablesRelative();
            j.f(compoundDrawablesRelative3, "compoundDrawablesRelative");
            c10 = j.g(compoundDrawablesRelative3, "<this>");
            compoundPaddingStart = textView.getCompoundPaddingStart();
            compoundPaddingEnd = textView.getCompoundPaddingEnd();
        } else {
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            j.f(compoundDrawables, "compoundDrawables");
            if (xh.b.e(compoundDrawables)) {
                Drawable[] compoundDrawables2 = textView.getCompoundDrawables();
                j.f(compoundDrawables2, "compoundDrawables");
                textView.setMinHeight(j.g(compoundDrawables2, "<this>"));
                Drawable[] compoundDrawables3 = textView.getCompoundDrawables();
                j.f(compoundDrawables3, "compoundDrawables");
                c10 = j.g(compoundDrawables3, "<this>");
                compoundPaddingStart = textView.getCompoundPaddingStart();
                compoundPaddingEnd = textView.getCompoundPaddingEnd();
            }
            textView.setMaxWidth(X(measureText, view));
        }
        measureText += c10 + compoundPaddingStart + compoundPaddingEnd;
        textView.setMaxWidth(X(measureText, view));
    }

    /* access modifiers changed from: private */
    public final void p0(View view) {
        if (this.f22669b.w0()) {
            z0(new Balloon$passTouchEventToAnchor$1(view));
        }
    }

    /* access modifiers changed from: private */
    public static final void s0(m mVar, Balloon balloon, View view) {
        j.g(balloon, "this$0");
        if (mVar != null) {
            j.f(view, "it");
            mVar.a(view);
        }
        if (balloon.f22669b.E()) {
            balloon.I();
        }
    }

    /* access modifiers changed from: private */
    public static final void u0(Balloon balloon, n nVar) {
        j.g(balloon, "this$0");
        balloon.L0();
        balloon.I();
        if (nVar != null) {
            nVar.b();
        }
    }

    /* access modifiers changed from: private */
    public static final void x0(q qVar, Balloon balloon, View view) {
        j.g(balloon, "this$0");
        if (qVar != null) {
            qVar.a();
        }
        if (balloon.f22669b.G()) {
            balloon.I();
        }
    }

    public final void B0(View.OnTouchListener onTouchListener) {
        if (onTouchListener != null) {
            this.f22672e.setTouchInterceptor(onTouchListener);
        }
    }

    public final void C0(View view) {
        j.g(view, ReferenceElement.ATTR_ANCHOR);
        E0(this, view, 0, 0, 6, (Object) null);
    }

    public final void D0(View view, int i10, int i11) {
        j.g(view, ReferenceElement.ATTR_ANCHOR);
        View[] viewArr = {view};
        if (G(view)) {
            view.post(new e(this, view, viewArr, this, view, i10, i11));
        } else if (this.f22669b.H()) {
            I();
        }
    }

    public final void F0(View view, int i10, int i11) {
        j.g(view, ReferenceElement.ATTR_ANCHOR);
        View[] viewArr = {view};
        if (G(view)) {
            view.post(new f(this, view, viewArr, this, view, i10, i11));
        } else if (this.f22669b.H()) {
            I();
        }
    }

    public final void I() {
        if (this.f22674g) {
            Balloon$dismiss$dismissWindow$1 balloon$dismiss$dismissWindow$1 = new Balloon$dismiss$dismissWindow$1(this);
            if (this.f22669b.u() == BalloonAnimation.CIRCULAR) {
                View contentView = this.f22672e.getContentView();
                j.f(contentView, "this.bodyWindow.contentView");
                contentView.post(new c(contentView, this.f22669b.C(), balloon$dismiss$dismissWindow$1));
                return;
            }
            balloon$dismiss$dismissWindow$1.invoke();
        }
    }

    public final boolean J(long j10) {
        return V().postDelayed(O(), j10);
    }

    public final PopupWindow R() {
        return this.f22672e;
    }

    public final ViewGroup T() {
        RadiusLayout radiusLayout = this.f22670c.f24678d;
        j.f(radiusLayout, "binding.balloonCard");
        return radiusLayout;
    }

    public final int W() {
        if (this.f22669b.K() != Integer.MIN_VALUE) {
            return this.f22669b.K();
        }
        return this.f22670c.getRoot().getMeasuredHeight();
    }

    public final int Y() {
        boolean z10;
        boolean z11;
        float f10;
        boolean z12;
        int i10 = new Point(Resources.getSystem().getDisplayMetrics().widthPixels, Resources.getSystem().getDisplayMetrics().heightPixels).x;
        boolean z13 = true;
        if (this.f22669b.L0() == 0.0f) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            return (int) (((float) i10) * this.f22669b.L0());
        }
        if (this.f22669b.d0() == 0.0f) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (this.f22669b.b0() == 0.0f) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                if (this.f22669b.K0() != Integer.MIN_VALUE) {
                    return j.g(this.f22669b.K0(), i10);
                }
                return j.j(this.f22670c.getRoot().getMeasuredWidth(), this.f22669b.c0(), this.f22669b.a0());
            }
        }
        if (this.f22669b.b0() != 0.0f) {
            z13 = false;
        }
        if (!z13) {
            f10 = this.f22669b.b0();
        } else {
            f10 = 1.0f;
        }
        float f11 = (float) i10;
        return j.j(this.f22670c.getRoot().getMeasuredWidth(), (int) (this.f22669b.d0() * f11), (int) (f11 * f10));
    }

    public final PopupWindow a0() {
        return this.f22673f;
    }

    public void onDestroy(androidx.lifecycle.l lVar) {
        Lifecycle lifecycle;
        j.g(lVar, "owner");
        super.onDestroy(lVar);
        this.f22675h = true;
        this.f22673f.dismiss();
        this.f22672e.dismiss();
        androidx.lifecycle.l V = this.f22669b.V();
        if (V != null && (lifecycle = V.getLifecycle()) != null) {
            lifecycle.d(this);
        }
    }

    public void onPause(androidx.lifecycle.l lVar) {
        j.g(lVar, "owner");
        super.onPause(lVar);
        if (this.f22669b.F()) {
            I();
        }
    }

    public final Balloon q0(boolean z10) {
        this.f22672e.setAttachedInDecor(z10);
        return this;
    }

    public final void r0(m mVar) {
        if (mVar != null || this.f22669b.E()) {
            this.f22670c.f24681g.setOnClickListener(new b(mVar, this));
        }
    }

    public final void t0(n nVar) {
        this.f22672e.setOnDismissListener(new e(this, nVar));
    }

    public final void v0(p pVar) {
        this.f22672e.setTouchInterceptor(new d(this, pVar));
    }

    public final void w0(q qVar) {
        this.f22671d.getRoot().setOnClickListener(new d(qVar, this));
    }

    public final void y0(View.OnTouchListener onTouchListener) {
        if (onTouchListener != null) {
            this.f22673f.setTouchInterceptor(onTouchListener);
        }
    }

    public final void z0(Function2<? super View, ? super MotionEvent, Boolean> function2) {
        j.g(function2, BlockContactsIQ.ELEMENT);
        y0(new g(function2));
    }
}

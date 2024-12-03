package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.n0;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class l extends RecyclerView.n implements RecyclerView.q {
    private f A;
    private final RecyclerView.s B = new b();
    private Rect C;
    private long D;

    /* renamed from: a  reason: collision with root package name */
    final List<View> f6631a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final float[] f6632b = new float[2];

    /* renamed from: c  reason: collision with root package name */
    RecyclerView.d0 f6633c = null;

    /* renamed from: d  reason: collision with root package name */
    float f6634d;

    /* renamed from: e  reason: collision with root package name */
    float f6635e;

    /* renamed from: f  reason: collision with root package name */
    private float f6636f;

    /* renamed from: g  reason: collision with root package name */
    private float f6637g;

    /* renamed from: h  reason: collision with root package name */
    float f6638h;

    /* renamed from: i  reason: collision with root package name */
    float f6639i;

    /* renamed from: j  reason: collision with root package name */
    private float f6640j;

    /* renamed from: k  reason: collision with root package name */
    private float f6641k;

    /* renamed from: l  reason: collision with root package name */
    int f6642l = -1;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    e f6643m;

    /* renamed from: n  reason: collision with root package name */
    private int f6644n = 0;

    /* renamed from: o  reason: collision with root package name */
    int f6645o;

    /* renamed from: p  reason: collision with root package name */
    List<g> f6646p = new ArrayList();

    /* renamed from: q  reason: collision with root package name */
    private int f6647q;

    /* renamed from: r  reason: collision with root package name */
    RecyclerView f6648r;

    /* renamed from: s  reason: collision with root package name */
    final Runnable f6649s = new a();

    /* renamed from: t  reason: collision with root package name */
    VelocityTracker f6650t;

    /* renamed from: u  reason: collision with root package name */
    private List<RecyclerView.d0> f6651u;

    /* renamed from: v  reason: collision with root package name */
    private List<Integer> f6652v;

    /* renamed from: w  reason: collision with root package name */
    private RecyclerView.j f6653w = null;

    /* renamed from: x  reason: collision with root package name */
    View f6654x = null;

    /* renamed from: y  reason: collision with root package name */
    int f6655y = -1;

    /* renamed from: z  reason: collision with root package name */
    GestureDetectorCompat f6656z;

    class a implements Runnable {
        a() {
        }

        public void run() {
            l lVar = l.this;
            if (lVar.f6633c != null && lVar.E()) {
                l lVar2 = l.this;
                RecyclerView.d0 d0Var = lVar2.f6633c;
                if (d0Var != null) {
                    lVar2.z(d0Var);
                }
                l lVar3 = l.this;
                lVar3.f6648r.removeCallbacks(lVar3.f6649s);
                n0.k0(l.this.f6648r, this);
            }
        }
    }

    class b implements RecyclerView.s {
        b() {
        }

        public void a(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
            l.this.f6656z.a(motionEvent);
            VelocityTracker velocityTracker = l.this.f6650t;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            if (l.this.f6642l != -1) {
                int actionMasked = motionEvent.getActionMasked();
                int findPointerIndex = motionEvent.findPointerIndex(l.this.f6642l);
                if (findPointerIndex >= 0) {
                    l.this.o(actionMasked, motionEvent, findPointerIndex);
                }
                l lVar = l.this;
                RecyclerView.d0 d0Var = lVar.f6633c;
                if (d0Var != null) {
                    int i10 = 0;
                    if (actionMasked != 1) {
                        if (actionMasked != 2) {
                            if (actionMasked == 3) {
                                VelocityTracker velocityTracker2 = lVar.f6650t;
                                if (velocityTracker2 != null) {
                                    velocityTracker2.clear();
                                }
                            } else if (actionMasked == 6) {
                                int actionIndex = motionEvent.getActionIndex();
                                int pointerId = motionEvent.getPointerId(actionIndex);
                                l lVar2 = l.this;
                                if (pointerId == lVar2.f6642l) {
                                    if (actionIndex == 0) {
                                        i10 = 1;
                                    }
                                    lVar2.f6642l = motionEvent.getPointerId(i10);
                                    l lVar3 = l.this;
                                    lVar3.K(motionEvent, lVar3.f6645o, actionIndex);
                                    return;
                                }
                                return;
                            } else {
                                return;
                            }
                        } else if (findPointerIndex >= 0) {
                            lVar.K(motionEvent, lVar.f6645o, findPointerIndex);
                            l.this.z(d0Var);
                            l lVar4 = l.this;
                            lVar4.f6648r.removeCallbacks(lVar4.f6649s);
                            l.this.f6649s.run();
                            l.this.f6648r.invalidate();
                            return;
                        } else {
                            return;
                        }
                    }
                    l.this.F((RecyclerView.d0) null, 0);
                    l.this.f6642l = -1;
                }
            }
        }

        public boolean c(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
            int findPointerIndex;
            g s10;
            l.this.f6656z.a(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                l.this.f6642l = motionEvent.getPointerId(0);
                l.this.f6634d = motionEvent.getX();
                l.this.f6635e = motionEvent.getY();
                l.this.A();
                l lVar = l.this;
                if (lVar.f6633c == null && (s10 = lVar.s(motionEvent)) != null) {
                    l lVar2 = l.this;
                    lVar2.f6634d -= s10.f6679k;
                    lVar2.f6635e -= s10.f6680l;
                    lVar2.r(s10.f6674e, true);
                    if (l.this.f6631a.remove(s10.f6674e.f6302a)) {
                        l lVar3 = l.this;
                        lVar3.f6643m.c(lVar3.f6648r, s10.f6674e);
                    }
                    l.this.F(s10.f6674e, s10.f6675f);
                    l lVar4 = l.this;
                    lVar4.K(motionEvent, lVar4.f6645o, 0);
                }
            } else if (actionMasked == 3 || actionMasked == 1) {
                l lVar5 = l.this;
                lVar5.f6642l = -1;
                lVar5.F((RecyclerView.d0) null, 0);
            } else {
                int i10 = l.this.f6642l;
                if (i10 != -1 && (findPointerIndex = motionEvent.findPointerIndex(i10)) >= 0) {
                    l.this.o(actionMasked, motionEvent, findPointerIndex);
                }
            }
            VelocityTracker velocityTracker = l.this.f6650t;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            if (l.this.f6633c != null) {
                return true;
            }
            return false;
        }

        public void e(boolean z10) {
            if (z10) {
                l.this.F((RecyclerView.d0) null, 0);
            }
        }
    }

    class c extends g {

        /* renamed from: q  reason: collision with root package name */
        final /* synthetic */ int f6659q;

        /* renamed from: t  reason: collision with root package name */
        final /* synthetic */ RecyclerView.d0 f6660t;

        /* renamed from: w  reason: collision with root package name */
        final /* synthetic */ l f6661w;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(l lVar, RecyclerView.d0 d0Var, int i10, int i11, float f10, float f11, float f12, float f13, int i12, RecyclerView.d0 d0Var2) {
            super(d0Var, i10, i11, f10, f11, f12, f13);
            this.f6661w = lVar;
            this.f6659q = i12;
            this.f6660t = d0Var2;
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (!this.f6681m) {
                if (this.f6659q <= 0) {
                    l lVar = this.f6661w;
                    lVar.f6643m.c(lVar.f6648r, this.f6660t);
                } else {
                    this.f6661w.f6631a.add(this.f6660t.f6302a);
                    this.f6678j = true;
                    int i10 = this.f6659q;
                    if (i10 > 0) {
                        this.f6661w.B(this, i10);
                    }
                }
                l lVar2 = this.f6661w;
                View view = lVar2.f6654x;
                View view2 = this.f6660t.f6302a;
                if (view == view2) {
                    lVar2.D(view2);
                }
            }
        }
    }

    class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f6662a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f6663b;

        d(g gVar, int i10) {
            this.f6662a = gVar;
            this.f6663b = i10;
        }

        public void run() {
            RecyclerView recyclerView = l.this.f6648r;
            if (recyclerView != null && recyclerView.isAttachedToWindow()) {
                g gVar = this.f6662a;
                if (!gVar.f6681m && gVar.f6674e.o() != -1) {
                    RecyclerView.l itemAnimator = l.this.f6648r.getItemAnimator();
                    if ((itemAnimator == null || !itemAnimator.q((RecyclerView.l.a) null)) && !l.this.x()) {
                        l.this.f6643m.B(this.f6662a.f6674e, this.f6663b);
                    } else {
                        l.this.f6648r.post(this);
                    }
                }
            }
        }
    }

    public static abstract class e {

        /* renamed from: b  reason: collision with root package name */
        private static final Interpolator f6665b = new a();

        /* renamed from: c  reason: collision with root package name */
        private static final Interpolator f6666c = new b();

        /* renamed from: a  reason: collision with root package name */
        private int f6667a = -1;

        class a implements Interpolator {
            a() {
            }

            public float getInterpolation(float f10) {
                return f10 * f10 * f10 * f10 * f10;
            }
        }

        class b implements Interpolator {
            b() {
            }

            public float getInterpolation(float f10) {
                float f11 = f10 - 1.0f;
                return (f11 * f11 * f11 * f11 * f11) + 1.0f;
            }
        }

        public static int e(int i10, int i11) {
            int i12;
            int i13 = i10 & 789516;
            if (i13 == 0) {
                return i10;
            }
            int i14 = i10 & (~i13);
            if (i11 == 0) {
                i12 = i13 << 2;
            } else {
                int i15 = i13 << 1;
                i14 |= -789517 & i15;
                i12 = (i15 & 789516) << 2;
            }
            return i14 | i12;
        }

        private int i(RecyclerView recyclerView) {
            if (this.f6667a == -1) {
                this.f6667a = recyclerView.getResources().getDimensionPixelSize(o1.b.item_touch_helper_max_drag_scroll_per_frame);
            }
            return this.f6667a;
        }

        public static int s(int i10, int i11) {
            return i11 << (i10 * 8);
        }

        public static int t(int i10, int i11) {
            int s10 = s(0, i11 | i10);
            return s(2, i10) | s(1, i11) | s10;
        }

        public void A(RecyclerView.d0 d0Var, int i10) {
            if (d0Var != null) {
                n.f6685a.b(d0Var.f6302a);
            }
        }

        public abstract void B(@NonNull RecyclerView.d0 d0Var, int i10);

        public boolean a(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.d0 d0Var, @NonNull RecyclerView.d0 d0Var2) {
            return true;
        }

        @SuppressLint({"UnknownNullness"})
        public RecyclerView.d0 b(@NonNull RecyclerView.d0 d0Var, @NonNull List<RecyclerView.d0> list, int i10, int i11) {
            int bottom;
            int abs;
            int top;
            int abs2;
            int left;
            int abs3;
            int right;
            int abs4;
            RecyclerView.d0 d0Var2 = d0Var;
            int width = i10 + d0Var2.f6302a.getWidth();
            int height = i11 + d0Var2.f6302a.getHeight();
            int left2 = i10 - d0Var2.f6302a.getLeft();
            int top2 = i11 - d0Var2.f6302a.getTop();
            int size = list.size();
            RecyclerView.d0 d0Var3 = null;
            int i12 = -1;
            for (int i13 = 0; i13 < size; i13++) {
                RecyclerView.d0 d0Var4 = list.get(i13);
                if (left2 > 0 && (right = d0Var4.f6302a.getRight() - width) < 0 && d0Var4.f6302a.getRight() > d0Var2.f6302a.getRight() && (abs4 = Math.abs(right)) > i12) {
                    d0Var3 = d0Var4;
                    i12 = abs4;
                }
                if (left2 < 0 && (left = d0Var4.f6302a.getLeft() - i10) > 0 && d0Var4.f6302a.getLeft() < d0Var2.f6302a.getLeft() && (abs3 = Math.abs(left)) > i12) {
                    d0Var3 = d0Var4;
                    i12 = abs3;
                }
                if (top2 < 0 && (top = d0Var4.f6302a.getTop() - i11) > 0 && d0Var4.f6302a.getTop() < d0Var2.f6302a.getTop() && (abs2 = Math.abs(top)) > i12) {
                    d0Var3 = d0Var4;
                    i12 = abs2;
                }
                if (top2 > 0 && (bottom = d0Var4.f6302a.getBottom() - height) < 0 && d0Var4.f6302a.getBottom() > d0Var2.f6302a.getBottom() && (abs = Math.abs(bottom)) > i12) {
                    d0Var3 = d0Var4;
                    i12 = abs;
                }
            }
            return d0Var3;
        }

        public void c(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.d0 d0Var) {
            n.f6685a.a(d0Var.f6302a);
        }

        public int d(int i10, int i11) {
            int i12;
            int i13 = i10 & 3158064;
            if (i13 == 0) {
                return i10;
            }
            int i14 = i10 & (~i13);
            if (i11 == 0) {
                i12 = i13 >> 2;
            } else {
                int i15 = i13 >> 1;
                i14 |= -3158065 & i15;
                i12 = (i15 & 3158064) >> 2;
            }
            return i14 | i12;
        }

        /* access modifiers changed from: package-private */
        public final int f(RecyclerView recyclerView, RecyclerView.d0 d0Var) {
            return d(k(recyclerView, d0Var), n0.B(recyclerView));
        }

        public long g(@NonNull RecyclerView recyclerView, int i10, float f10, float f11) {
            RecyclerView.l itemAnimator = recyclerView.getItemAnimator();
            if (itemAnimator == null) {
                if (i10 == 8) {
                    return 200;
                }
                return 250;
            } else if (i10 == 8) {
                return itemAnimator.n();
            } else {
                return itemAnimator.o();
            }
        }

        public int h() {
            return 0;
        }

        public float j(@NonNull RecyclerView.d0 d0Var) {
            return 0.5f;
        }

        public abstract int k(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.d0 d0Var);

        public float l(float f10) {
            return f10;
        }

        public float m(@NonNull RecyclerView.d0 d0Var) {
            return 0.5f;
        }

        public float n(float f10) {
            return f10;
        }

        /* access modifiers changed from: package-private */
        public boolean o(RecyclerView recyclerView, RecyclerView.d0 d0Var) {
            return (f(recyclerView, d0Var) & 16711680) != 0;
        }

        public int p(@NonNull RecyclerView recyclerView, int i10, int i11, int i12, long j10) {
            float f10 = 1.0f;
            int signum = (int) (((float) (((int) Math.signum((float) i11)) * i(recyclerView))) * f6666c.getInterpolation(Math.min(1.0f, (((float) Math.abs(i11)) * 1.0f) / ((float) i10))));
            if (j10 <= 2000) {
                f10 = ((float) j10) / 2000.0f;
            }
            int interpolation = (int) (((float) signum) * f6665b.getInterpolation(f10));
            if (interpolation != 0) {
                return interpolation;
            }
            if (i11 > 0) {
                return 1;
            }
            return -1;
        }

        public abstract boolean q();

        public abstract boolean r();

        public void u(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.d0 d0Var, float f10, float f11, int i10, boolean z10) {
            n.f6685a.c(canvas, recyclerView, d0Var.f6302a, f10, f11, i10, z10);
        }

        public void v(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @SuppressLint({"UnknownNullness"}) RecyclerView.d0 d0Var, float f10, float f11, int i10, boolean z10) {
            n.f6685a.d(canvas, recyclerView, d0Var.f6302a, f10, f11, i10, z10);
        }

        /* access modifiers changed from: package-private */
        public void w(Canvas canvas, RecyclerView recyclerView, RecyclerView.d0 d0Var, List<g> list, int i10, float f10, float f11) {
            Canvas canvas2 = canvas;
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                g gVar = list.get(i11);
                gVar.e();
                int save = canvas.save();
                u(canvas, recyclerView, gVar.f6674e, gVar.f6679k, gVar.f6680l, gVar.f6675f, false);
                canvas.restoreToCount(save);
            }
            if (d0Var != null) {
                int save2 = canvas.save();
                u(canvas, recyclerView, d0Var, f10, f11, i10, true);
                canvas.restoreToCount(save2);
            }
        }

        /* access modifiers changed from: package-private */
        public void x(Canvas canvas, RecyclerView recyclerView, RecyclerView.d0 d0Var, List<g> list, int i10, float f10, float f11) {
            Canvas canvas2 = canvas;
            List<g> list2 = list;
            int size = list.size();
            boolean z10 = false;
            for (int i11 = 0; i11 < size; i11++) {
                g gVar = list2.get(i11);
                int save = canvas.save();
                v(canvas, recyclerView, gVar.f6674e, gVar.f6679k, gVar.f6680l, gVar.f6675f, false);
                canvas.restoreToCount(save);
            }
            if (d0Var != null) {
                int save2 = canvas.save();
                v(canvas, recyclerView, d0Var, f10, f11, i10, true);
                canvas.restoreToCount(save2);
            }
            for (int i12 = size - 1; i12 >= 0; i12--) {
                g gVar2 = list2.get(i12);
                boolean z11 = gVar2.f6682n;
                if (z11 && !gVar2.f6678j) {
                    list2.remove(i12);
                } else if (!z11) {
                    z10 = true;
                }
            }
            if (z10) {
                recyclerView.invalidate();
            }
        }

        public abstract boolean y(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.d0 d0Var, @NonNull RecyclerView.d0 d0Var2);

        public void z(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.d0 d0Var, int i10, @NonNull RecyclerView.d0 d0Var2, int i11, int i12, int i13) {
            RecyclerView.o layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof h) {
                ((h) layoutManager).b(d0Var.f6302a, d0Var2.f6302a, i12, i13);
                return;
            }
            if (layoutManager.l()) {
                if (layoutManager.R(d0Var2.f6302a) <= recyclerView.getPaddingLeft()) {
                    recyclerView.s1(i11);
                }
                if (layoutManager.U(d0Var2.f6302a) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                    recyclerView.s1(i11);
                }
            }
            if (layoutManager.m()) {
                if (layoutManager.V(d0Var2.f6302a) <= recyclerView.getPaddingTop()) {
                    recyclerView.s1(i11);
                }
                if (layoutManager.P(d0Var2.f6302a) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                    recyclerView.s1(i11);
                }
            }
        }
    }

    private class f extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: a  reason: collision with root package name */
        private boolean f6668a = true;

        f() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f6668a = false;
        }

        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public void onLongPress(MotionEvent motionEvent) {
            View t10;
            RecyclerView.d0 k02;
            int i10;
            if (this.f6668a && (t10 = l.this.t(motionEvent)) != null && (k02 = l.this.f6648r.k0(t10)) != null) {
                l lVar = l.this;
                if (lVar.f6643m.o(lVar.f6648r, k02) && motionEvent.getPointerId(0) == (i10 = l.this.f6642l)) {
                    int findPointerIndex = motionEvent.findPointerIndex(i10);
                    float x10 = motionEvent.getX(findPointerIndex);
                    float y10 = motionEvent.getY(findPointerIndex);
                    l lVar2 = l.this;
                    lVar2.f6634d = x10;
                    lVar2.f6635e = y10;
                    lVar2.f6639i = 0.0f;
                    lVar2.f6638h = 0.0f;
                    if (lVar2.f6643m.r()) {
                        l.this.F(k02, 2);
                    }
                }
            }
        }
    }

    static class g implements Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        final float f6670a;

        /* renamed from: b  reason: collision with root package name */
        final float f6671b;

        /* renamed from: c  reason: collision with root package name */
        final float f6672c;

        /* renamed from: d  reason: collision with root package name */
        final float f6673d;

        /* renamed from: e  reason: collision with root package name */
        final RecyclerView.d0 f6674e;

        /* renamed from: f  reason: collision with root package name */
        final int f6675f;

        /* renamed from: g  reason: collision with root package name */
        final ValueAnimator f6676g;

        /* renamed from: h  reason: collision with root package name */
        final int f6677h;

        /* renamed from: j  reason: collision with root package name */
        boolean f6678j;

        /* renamed from: k  reason: collision with root package name */
        float f6679k;

        /* renamed from: l  reason: collision with root package name */
        float f6680l;

        /* renamed from: m  reason: collision with root package name */
        boolean f6681m = false;

        /* renamed from: n  reason: collision with root package name */
        boolean f6682n = false;

        /* renamed from: p  reason: collision with root package name */
        private float f6683p;

        class a implements ValueAnimator.AnimatorUpdateListener {
            a() {
            }

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                g.this.c(valueAnimator.getAnimatedFraction());
            }
        }

        g(RecyclerView.d0 d0Var, int i10, int i11, float f10, float f11, float f12, float f13) {
            this.f6675f = i11;
            this.f6677h = i10;
            this.f6674e = d0Var;
            this.f6670a = f10;
            this.f6671b = f11;
            this.f6672c = f12;
            this.f6673d = f13;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.f6676g = ofFloat;
            ofFloat.addUpdateListener(new a());
            ofFloat.setTarget(d0Var.f6302a);
            ofFloat.addListener(this);
            c(0.0f);
        }

        public void a() {
            this.f6676g.cancel();
        }

        public void b(long j10) {
            this.f6676g.setDuration(j10);
        }

        public void c(float f10) {
            this.f6683p = f10;
        }

        public void d() {
            this.f6674e.P(false);
            this.f6676g.start();
        }

        public void e() {
            float f10 = this.f6670a;
            float f11 = this.f6672c;
            if (f10 == f11) {
                this.f6679k = this.f6674e.f6302a.getTranslationX();
            } else {
                this.f6679k = f10 + (this.f6683p * (f11 - f10));
            }
            float f12 = this.f6671b;
            float f13 = this.f6673d;
            if (f12 == f13) {
                this.f6680l = this.f6674e.f6302a.getTranslationY();
            } else {
                this.f6680l = f12 + (this.f6683p * (f13 - f12));
            }
        }

        public void onAnimationCancel(Animator animator) {
            c(1.0f);
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f6682n) {
                this.f6674e.P(true);
            }
            this.f6682n = true;
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    public interface h {
        void b(@NonNull View view, @NonNull View view2, int i10, int i11);
    }

    public l(@NonNull e eVar) {
        this.f6643m = eVar;
    }

    private void C() {
        VelocityTracker velocityTracker = this.f6650t;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f6650t = null;
        }
    }

    private void G() {
        this.f6647q = ViewConfiguration.get(this.f6648r.getContext()).getScaledTouchSlop();
        this.f6648r.h(this);
        this.f6648r.k(this.B);
        this.f6648r.j(this);
        H();
    }

    private void H() {
        this.A = new f();
        this.f6656z = new GestureDetectorCompat(this.f6648r.getContext(), this.A);
    }

    private void I() {
        f fVar = this.A;
        if (fVar != null) {
            fVar.a();
            this.A = null;
        }
        if (this.f6656z != null) {
            this.f6656z = null;
        }
    }

    private int J(RecyclerView.d0 d0Var) {
        if (this.f6644n == 2) {
            return 0;
        }
        int k10 = this.f6643m.k(this.f6648r, d0Var);
        int d10 = (this.f6643m.d(k10, n0.B(this.f6648r)) & 65280) >> 8;
        if (d10 == 0) {
            return 0;
        }
        int i10 = (k10 & 65280) >> 8;
        if (Math.abs(this.f6638h) > Math.abs(this.f6639i)) {
            int n10 = n(d0Var, d10);
            if (n10 <= 0) {
                int p10 = p(d0Var, d10);
                if (p10 > 0) {
                    return p10;
                }
            } else if ((i10 & n10) == 0) {
                return e.e(n10, n0.B(this.f6648r));
            } else {
                return n10;
            }
        } else {
            int p11 = p(d0Var, d10);
            if (p11 > 0) {
                return p11;
            }
            int n11 = n(d0Var, d10);
            if (n11 > 0) {
                if ((i10 & n11) == 0) {
                    return e.e(n11, n0.B(this.f6648r));
                }
                return n11;
            }
        }
        return 0;
    }

    private void l() {
    }

    private int n(RecyclerView.d0 d0Var, int i10) {
        int i11;
        if ((i10 & 12) == 0) {
            return 0;
        }
        int i12 = 8;
        if (this.f6638h > 0.0f) {
            i11 = 8;
        } else {
            i11 = 4;
        }
        VelocityTracker velocityTracker = this.f6650t;
        if (velocityTracker != null && this.f6642l > -1) {
            velocityTracker.computeCurrentVelocity(1000, this.f6643m.n(this.f6637g));
            float xVelocity = this.f6650t.getXVelocity(this.f6642l);
            float yVelocity = this.f6650t.getYVelocity(this.f6642l);
            if (xVelocity <= 0.0f) {
                i12 = 4;
            }
            float abs = Math.abs(xVelocity);
            if ((i12 & i10) != 0 && i11 == i12 && abs >= this.f6643m.l(this.f6636f) && abs > Math.abs(yVelocity)) {
                return i12;
            }
        }
        float width = ((float) this.f6648r.getWidth()) * this.f6643m.m(d0Var);
        if ((i10 & i11) == 0 || Math.abs(this.f6638h) <= width) {
            return 0;
        }
        return i11;
    }

    private int p(RecyclerView.d0 d0Var, int i10) {
        int i11;
        if ((i10 & 3) == 0) {
            return 0;
        }
        int i12 = 2;
        if (this.f6639i > 0.0f) {
            i11 = 2;
        } else {
            i11 = 1;
        }
        VelocityTracker velocityTracker = this.f6650t;
        if (velocityTracker != null && this.f6642l > -1) {
            velocityTracker.computeCurrentVelocity(1000, this.f6643m.n(this.f6637g));
            float xVelocity = this.f6650t.getXVelocity(this.f6642l);
            float yVelocity = this.f6650t.getYVelocity(this.f6642l);
            if (yVelocity <= 0.0f) {
                i12 = 1;
            }
            float abs = Math.abs(yVelocity);
            if ((i12 & i10) != 0 && i12 == i11 && abs >= this.f6643m.l(this.f6636f) && abs > Math.abs(xVelocity)) {
                return i12;
            }
        }
        float height = ((float) this.f6648r.getHeight()) * this.f6643m.m(d0Var);
        if ((i10 & i11) == 0 || Math.abs(this.f6639i) <= height) {
            return 0;
        }
        return i11;
    }

    private void q() {
        this.f6648r.g1(this);
        this.f6648r.i1(this.B);
        this.f6648r.h1(this);
        for (int size = this.f6646p.size() - 1; size >= 0; size--) {
            g gVar = this.f6646p.get(0);
            gVar.a();
            this.f6643m.c(this.f6648r, gVar.f6674e);
        }
        this.f6646p.clear();
        this.f6654x = null;
        this.f6655y = -1;
        C();
        I();
    }

    private List<RecyclerView.d0> u(RecyclerView.d0 d0Var) {
        RecyclerView.d0 d0Var2 = d0Var;
        List<RecyclerView.d0> list = this.f6651u;
        if (list == null) {
            this.f6651u = new ArrayList();
            this.f6652v = new ArrayList();
        } else {
            list.clear();
            this.f6652v.clear();
        }
        int h10 = this.f6643m.h();
        int round = Math.round(this.f6640j + this.f6638h) - h10;
        int round2 = Math.round(this.f6641k + this.f6639i) - h10;
        int i10 = h10 * 2;
        int width = d0Var2.f6302a.getWidth() + round + i10;
        int height = d0Var2.f6302a.getHeight() + round2 + i10;
        int i11 = (round + width) / 2;
        int i12 = (round2 + height) / 2;
        RecyclerView.o layoutManager = this.f6648r.getLayoutManager();
        int K = layoutManager.K();
        int i13 = 0;
        while (i13 < K) {
            View J = layoutManager.J(i13);
            if (J != d0Var2.f6302a && J.getBottom() >= round2 && J.getTop() <= height && J.getRight() >= round && J.getLeft() <= width) {
                RecyclerView.d0 k02 = this.f6648r.k0(J);
                if (this.f6643m.a(this.f6648r, this.f6633c, k02)) {
                    int abs = Math.abs(i11 - ((J.getLeft() + J.getRight()) / 2));
                    int abs2 = Math.abs(i12 - ((J.getTop() + J.getBottom()) / 2));
                    int i14 = (abs * abs) + (abs2 * abs2);
                    int size = this.f6651u.size();
                    int i15 = 0;
                    int i16 = 0;
                    while (i15 < size && i14 > this.f6652v.get(i15).intValue()) {
                        i16++;
                        i15++;
                        RecyclerView.d0 d0Var3 = d0Var;
                    }
                    this.f6651u.add(i16, k02);
                    this.f6652v.add(i16, Integer.valueOf(i14));
                }
            }
            i13++;
            d0Var2 = d0Var;
        }
        return this.f6651u;
    }

    private RecyclerView.d0 v(MotionEvent motionEvent) {
        View t10;
        RecyclerView.o layoutManager = this.f6648r.getLayoutManager();
        int i10 = this.f6642l;
        if (i10 == -1) {
            return null;
        }
        int findPointerIndex = motionEvent.findPointerIndex(i10);
        float abs = Math.abs(motionEvent.getX(findPointerIndex) - this.f6634d);
        float abs2 = Math.abs(motionEvent.getY(findPointerIndex) - this.f6635e);
        int i11 = this.f6647q;
        if (abs < ((float) i11) && abs2 < ((float) i11)) {
            return null;
        }
        if (abs > abs2 && layoutManager.l()) {
            return null;
        }
        if ((abs2 <= abs || !layoutManager.m()) && (t10 = t(motionEvent)) != null) {
            return this.f6648r.k0(t10);
        }
        return null;
    }

    private void w(float[] fArr) {
        if ((this.f6645o & 12) != 0) {
            fArr[0] = (this.f6640j + this.f6638h) - ((float) this.f6633c.f6302a.getLeft());
        } else {
            fArr[0] = this.f6633c.f6302a.getTranslationX();
        }
        if ((this.f6645o & 3) != 0) {
            fArr[1] = (this.f6641k + this.f6639i) - ((float) this.f6633c.f6302a.getTop());
        } else {
            fArr[1] = this.f6633c.f6302a.getTranslationY();
        }
    }

    private static boolean y(View view, float f10, float f11, float f12, float f13) {
        if (f10 < f12 || f10 > f12 + ((float) view.getWidth()) || f11 < f13 || f11 > f13 + ((float) view.getHeight())) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void A() {
        VelocityTracker velocityTracker = this.f6650t;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.f6650t = VelocityTracker.obtain();
    }

    /* access modifiers changed from: package-private */
    public void B(g gVar, int i10) {
        this.f6648r.post(new d(gVar, i10));
    }

    /* access modifiers changed from: package-private */
    public void D(View view) {
        if (view == this.f6654x) {
            this.f6654x = null;
            if (this.f6653w != null) {
                this.f6648r.setChildDrawingOrderCallback((RecyclerView.j) null);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c1, code lost:
        if (r1 > 0) goto L_0x00c5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0100 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x010c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean E() {
        /*
            r16 = this;
            r0 = r16
            androidx.recyclerview.widget.RecyclerView$d0 r1 = r0.f6633c
            r2 = 0
            r3 = -9223372036854775808
            if (r1 != 0) goto L_0x000c
            r0.D = r3
            return r2
        L_0x000c:
            long r5 = java.lang.System.currentTimeMillis()
            long r7 = r0.D
            int r1 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x0019
            r7 = 0
            goto L_0x001b
        L_0x0019:
            long r7 = r5 - r7
        L_0x001b:
            androidx.recyclerview.widget.RecyclerView r1 = r0.f6648r
            androidx.recyclerview.widget.RecyclerView$o r1 = r1.getLayoutManager()
            android.graphics.Rect r9 = r0.C
            if (r9 != 0) goto L_0x002c
            android.graphics.Rect r9 = new android.graphics.Rect
            r9.<init>()
            r0.C = r9
        L_0x002c:
            androidx.recyclerview.widget.RecyclerView$d0 r9 = r0.f6633c
            android.view.View r9 = r9.f6302a
            android.graphics.Rect r10 = r0.C
            r1.k(r9, r10)
            boolean r9 = r1.l()
            r10 = 0
            if (r9 == 0) goto L_0x007d
            float r9 = r0.f6640j
            float r11 = r0.f6638h
            float r9 = r9 + r11
            int r9 = (int) r9
            android.graphics.Rect r11 = r0.C
            int r11 = r11.left
            int r11 = r9 - r11
            androidx.recyclerview.widget.RecyclerView r12 = r0.f6648r
            int r12 = r12.getPaddingLeft()
            int r11 = r11 - r12
            float r12 = r0.f6638h
            int r13 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r13 >= 0) goto L_0x0059
            if (r11 >= 0) goto L_0x0059
            r12 = r11
            goto L_0x007e
        L_0x0059:
            int r11 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r11 <= 0) goto L_0x007d
            androidx.recyclerview.widget.RecyclerView$d0 r11 = r0.f6633c
            android.view.View r11 = r11.f6302a
            int r11 = r11.getWidth()
            int r9 = r9 + r11
            android.graphics.Rect r11 = r0.C
            int r11 = r11.right
            int r9 = r9 + r11
            androidx.recyclerview.widget.RecyclerView r11 = r0.f6648r
            int r11 = r11.getWidth()
            androidx.recyclerview.widget.RecyclerView r12 = r0.f6648r
            int r12 = r12.getPaddingRight()
            int r11 = r11 - r12
            int r9 = r9 - r11
            if (r9 <= 0) goto L_0x007d
            r12 = r9
            goto L_0x007e
        L_0x007d:
            r12 = r2
        L_0x007e:
            boolean r1 = r1.m()
            if (r1 == 0) goto L_0x00c4
            float r1 = r0.f6641k
            float r9 = r0.f6639i
            float r1 = r1 + r9
            int r1 = (int) r1
            android.graphics.Rect r9 = r0.C
            int r9 = r9.top
            int r9 = r1 - r9
            androidx.recyclerview.widget.RecyclerView r11 = r0.f6648r
            int r11 = r11.getPaddingTop()
            int r9 = r9 - r11
            float r11 = r0.f6639i
            int r13 = (r11 > r10 ? 1 : (r11 == r10 ? 0 : -1))
            if (r13 >= 0) goto L_0x00a1
            if (r9 >= 0) goto L_0x00a1
            r1 = r9
            goto L_0x00c5
        L_0x00a1:
            int r9 = (r11 > r10 ? 1 : (r11 == r10 ? 0 : -1))
            if (r9 <= 0) goto L_0x00c4
            androidx.recyclerview.widget.RecyclerView$d0 r9 = r0.f6633c
            android.view.View r9 = r9.f6302a
            int r9 = r9.getHeight()
            int r1 = r1 + r9
            android.graphics.Rect r9 = r0.C
            int r9 = r9.bottom
            int r1 = r1 + r9
            androidx.recyclerview.widget.RecyclerView r9 = r0.f6648r
            int r9 = r9.getHeight()
            androidx.recyclerview.widget.RecyclerView r10 = r0.f6648r
            int r10 = r10.getPaddingBottom()
            int r9 = r9 - r10
            int r1 = r1 - r9
            if (r1 <= 0) goto L_0x00c4
            goto L_0x00c5
        L_0x00c4:
            r1 = r2
        L_0x00c5:
            if (r12 == 0) goto L_0x00de
            androidx.recyclerview.widget.l$e r9 = r0.f6643m
            androidx.recyclerview.widget.RecyclerView r10 = r0.f6648r
            androidx.recyclerview.widget.RecyclerView$d0 r11 = r0.f6633c
            android.view.View r11 = r11.f6302a
            int r11 = r11.getWidth()
            androidx.recyclerview.widget.RecyclerView r13 = r0.f6648r
            int r13 = r13.getWidth()
            r14 = r7
            int r12 = r9.p(r10, r11, r12, r13, r14)
        L_0x00de:
            r14 = r12
            if (r1 == 0) goto L_0x00fd
            androidx.recyclerview.widget.l$e r9 = r0.f6643m
            androidx.recyclerview.widget.RecyclerView r10 = r0.f6648r
            androidx.recyclerview.widget.RecyclerView$d0 r11 = r0.f6633c
            android.view.View r11 = r11.f6302a
            int r11 = r11.getHeight()
            androidx.recyclerview.widget.RecyclerView r12 = r0.f6648r
            int r13 = r12.getHeight()
            r12 = r1
            r1 = r14
            r14 = r7
            int r7 = r9.p(r10, r11, r12, r13, r14)
            r12 = r1
            r1 = r7
            goto L_0x00fe
        L_0x00fd:
            r12 = r14
        L_0x00fe:
            if (r12 != 0) goto L_0x0106
            if (r1 == 0) goto L_0x0103
            goto L_0x0106
        L_0x0103:
            r0.D = r3
            return r2
        L_0x0106:
            long r7 = r0.D
            int r2 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r2 != 0) goto L_0x010e
            r0.D = r5
        L_0x010e:
            androidx.recyclerview.widget.RecyclerView r2 = r0.f6648r
            r2.scrollBy(r12, r1)
            r1 = 1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.l.E():boolean");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0136  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void F(androidx.recyclerview.widget.RecyclerView.d0 r24, int r25) {
        /*
            r23 = this;
            r11 = r23
            r12 = r24
            r13 = r25
            androidx.recyclerview.widget.RecyclerView$d0 r0 = r11.f6633c
            if (r12 != r0) goto L_0x000f
            int r0 = r11.f6644n
            if (r13 != r0) goto L_0x000f
            return
        L_0x000f:
            r0 = -9223372036854775808
            r11.D = r0
            int r4 = r11.f6644n
            r14 = 1
            r11.r(r12, r14)
            r11.f6644n = r13
            r15 = 2
            if (r13 != r15) goto L_0x0030
            if (r12 == 0) goto L_0x0028
            android.view.View r0 = r12.f6302a
            r11.f6654x = r0
            r23.l()
            goto L_0x0030
        L_0x0028:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Must pass a ViewHolder when dragging"
            r0.<init>(r1)
            throw r0
        L_0x0030:
            int r0 = r13 * 8
            r10 = 8
            int r0 = r0 + r10
            int r0 = r14 << r0
            int r16 = r0 + -1
            androidx.recyclerview.widget.RecyclerView$d0 r9 = r11.f6633c
            r8 = 0
            if (r9 == 0) goto L_0x00ed
            android.view.View r0 = r9.f6302a
            android.view.ViewParent r0 = r0.getParent()
            if (r0 == 0) goto L_0x00d9
            if (r4 != r15) goto L_0x004a
            r7 = r8
            goto L_0x004f
        L_0x004a:
            int r0 = r11.J(r9)
            r7 = r0
        L_0x004f:
            r23.C()
            r0 = 4
            r1 = 0
            if (r7 == r14) goto L_0x007c
            if (r7 == r15) goto L_0x007c
            if (r7 == r0) goto L_0x0069
            if (r7 == r10) goto L_0x0069
            r2 = 16
            if (r7 == r2) goto L_0x0069
            r2 = 32
            if (r7 == r2) goto L_0x0069
            r17 = r1
            r18 = r17
            goto L_0x008e
        L_0x0069:
            float r2 = r11.f6638h
            float r2 = java.lang.Math.signum(r2)
            androidx.recyclerview.widget.RecyclerView r3 = r11.f6648r
            int r3 = r3.getWidth()
            float r3 = (float) r3
            float r2 = r2 * r3
            r18 = r1
            r17 = r2
            goto L_0x008e
        L_0x007c:
            float r2 = r11.f6639i
            float r2 = java.lang.Math.signum(r2)
            androidx.recyclerview.widget.RecyclerView r3 = r11.f6648r
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r2 = r2 * r3
            r17 = r1
            r18 = r2
        L_0x008e:
            if (r4 != r15) goto L_0x0092
            r6 = r10
            goto L_0x0097
        L_0x0092:
            if (r7 <= 0) goto L_0x0096
            r6 = r15
            goto L_0x0097
        L_0x0096:
            r6 = r0
        L_0x0097:
            float[] r0 = r11.f6632b
            r11.w(r0)
            float[] r0 = r11.f6632b
            r19 = r0[r8]
            r20 = r0[r14]
            androidx.recyclerview.widget.l$c r5 = new androidx.recyclerview.widget.l$c
            r0 = r5
            r1 = r23
            r2 = r9
            r3 = r6
            r14 = r5
            r5 = r19
            r15 = r6
            r6 = r20
            r21 = r7
            r7 = r17
            r8 = r18
            r22 = r9
            r9 = r21
            r21 = r10
            r10 = r22
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            androidx.recyclerview.widget.l$e r0 = r11.f6643m
            androidx.recyclerview.widget.RecyclerView r1 = r11.f6648r
            float r2 = r17 - r19
            float r3 = r18 - r20
            long r0 = r0.g(r1, r15, r2, r3)
            r14.b(r0)
            java.util.List<androidx.recyclerview.widget.l$g> r0 = r11.f6646p
            r0.add(r14)
            r14.d()
            r8 = 1
            goto L_0x00e9
        L_0x00d9:
            r0 = r9
            r21 = r10
            android.view.View r1 = r0.f6302a
            r11.D(r1)
            androidx.recyclerview.widget.l$e r1 = r11.f6643m
            androidx.recyclerview.widget.RecyclerView r2 = r11.f6648r
            r1.c(r2, r0)
            r8 = 0
        L_0x00e9:
            r0 = 0
            r11.f6633c = r0
            goto L_0x00f0
        L_0x00ed:
            r21 = r10
            r8 = 0
        L_0x00f0:
            if (r12 == 0) goto L_0x0121
            androidx.recyclerview.widget.l$e r0 = r11.f6643m
            androidx.recyclerview.widget.RecyclerView r1 = r11.f6648r
            int r0 = r0.f(r1, r12)
            r0 = r0 & r16
            int r1 = r11.f6644n
            int r1 = r1 * 8
            int r0 = r0 >> r1
            r11.f6645o = r0
            android.view.View r0 = r12.f6302a
            int r0 = r0.getLeft()
            float r0 = (float) r0
            r11.f6640j = r0
            android.view.View r0 = r12.f6302a
            int r0 = r0.getTop()
            float r0 = (float) r0
            r11.f6641k = r0
            r11.f6633c = r12
            r0 = 2
            if (r13 != r0) goto L_0x0121
            android.view.View r0 = r12.f6302a
            r1 = 0
            r0.performHapticFeedback(r1)
            goto L_0x0122
        L_0x0121:
            r1 = 0
        L_0x0122:
            androidx.recyclerview.widget.RecyclerView r0 = r11.f6648r
            android.view.ViewParent r0 = r0.getParent()
            if (r0 == 0) goto L_0x0134
            androidx.recyclerview.widget.RecyclerView$d0 r2 = r11.f6633c
            if (r2 == 0) goto L_0x0130
            r14 = 1
            goto L_0x0131
        L_0x0130:
            r14 = r1
        L_0x0131:
            r0.requestDisallowInterceptTouchEvent(r14)
        L_0x0134:
            if (r8 != 0) goto L_0x013f
            androidx.recyclerview.widget.RecyclerView r0 = r11.f6648r
            androidx.recyclerview.widget.RecyclerView$o r0 = r0.getLayoutManager()
            r0.v1()
        L_0x013f:
            androidx.recyclerview.widget.l$e r0 = r11.f6643m
            androidx.recyclerview.widget.RecyclerView$d0 r1 = r11.f6633c
            int r2 = r11.f6644n
            r0.A(r1, r2)
            androidx.recyclerview.widget.RecyclerView r0 = r11.f6648r
            r0.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.l.F(androidx.recyclerview.widget.RecyclerView$d0, int):void");
    }

    /* access modifiers changed from: package-private */
    public void K(MotionEvent motionEvent, int i10, int i11) {
        float x10 = motionEvent.getX(i11);
        float y10 = motionEvent.getY(i11);
        float f10 = x10 - this.f6634d;
        this.f6638h = f10;
        this.f6639i = y10 - this.f6635e;
        if ((i10 & 4) == 0) {
            this.f6638h = Math.max(0.0f, f10);
        }
        if ((i10 & 8) == 0) {
            this.f6638h = Math.min(0.0f, this.f6638h);
        }
        if ((i10 & 1) == 0) {
            this.f6639i = Math.max(0.0f, this.f6639i);
        }
        if ((i10 & 2) == 0) {
            this.f6639i = Math.min(0.0f, this.f6639i);
        }
    }

    public void b(@NonNull View view) {
        D(view);
        RecyclerView.d0 k02 = this.f6648r.k0(view);
        if (k02 != null) {
            RecyclerView.d0 d0Var = this.f6633c;
            if (d0Var == null || k02 != d0Var) {
                r(k02, false);
                if (this.f6631a.remove(k02.f6302a)) {
                    this.f6643m.c(this.f6648r, k02);
                    return;
                }
                return;
            }
            F((RecyclerView.d0) null, 0);
        }
    }

    public void d(@NonNull View view) {
    }

    @SuppressLint({"UnknownNullness"})
    public void g(Rect rect, View view, RecyclerView recyclerView, RecyclerView.z zVar) {
        rect.setEmpty();
    }

    @SuppressLint({"UnknownNullness"})
    public void i(Canvas canvas, RecyclerView recyclerView, RecyclerView.z zVar) {
        float f10;
        float f11;
        this.f6655y = -1;
        if (this.f6633c != null) {
            w(this.f6632b);
            float[] fArr = this.f6632b;
            float f12 = fArr[0];
            f10 = fArr[1];
            f11 = f12;
        } else {
            f11 = 0.0f;
            f10 = 0.0f;
        }
        this.f6643m.w(canvas, recyclerView, this.f6633c, this.f6646p, this.f6644n, f11, f10);
    }

    public void k(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.z zVar) {
        float f10;
        float f11;
        if (this.f6633c != null) {
            w(this.f6632b);
            float[] fArr = this.f6632b;
            float f12 = fArr[0];
            f10 = fArr[1];
            f11 = f12;
        } else {
            f11 = 0.0f;
            f10 = 0.0f;
        }
        this.f6643m.x(canvas, recyclerView, this.f6633c, this.f6646p, this.f6644n, f11, f10);
    }

    public void m(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f6648r;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                q();
            }
            this.f6648r = recyclerView;
            if (recyclerView != null) {
                Resources resources = recyclerView.getResources();
                this.f6636f = resources.getDimension(o1.b.item_touch_helper_swipe_escape_velocity);
                this.f6637g = resources.getDimension(o1.b.item_touch_helper_swipe_escape_max_velocity);
                G();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void o(int i10, MotionEvent motionEvent, int i11) {
        RecyclerView.d0 v10;
        int f10;
        if (this.f6633c == null && i10 == 2 && this.f6644n != 2 && this.f6643m.q() && this.f6648r.getScrollState() != 1 && (v10 = v(motionEvent)) != null && (f10 = (this.f6643m.f(this.f6648r, v10) & 65280) >> 8) != 0) {
            float x10 = motionEvent.getX(i11);
            float y10 = motionEvent.getY(i11);
            float f11 = x10 - this.f6634d;
            float f12 = y10 - this.f6635e;
            float abs = Math.abs(f11);
            float abs2 = Math.abs(f12);
            int i12 = this.f6647q;
            if (abs >= ((float) i12) || abs2 >= ((float) i12)) {
                if (abs > abs2) {
                    if (f11 < 0.0f && (f10 & 4) == 0) {
                        return;
                    }
                    if (f11 > 0.0f && (f10 & 8) == 0) {
                        return;
                    }
                } else if (f12 < 0.0f && (f10 & 1) == 0) {
                    return;
                } else {
                    if (f12 > 0.0f && (f10 & 2) == 0) {
                        return;
                    }
                }
                this.f6639i = 0.0f;
                this.f6638h = 0.0f;
                this.f6642l = motionEvent.getPointerId(0);
                F(v10, 1);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void r(RecyclerView.d0 d0Var, boolean z10) {
        for (int size = this.f6646p.size() - 1; size >= 0; size--) {
            g gVar = this.f6646p.get(size);
            if (gVar.f6674e == d0Var) {
                gVar.f6681m |= z10;
                if (!gVar.f6682n) {
                    gVar.a();
                }
                this.f6646p.remove(size);
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public g s(MotionEvent motionEvent) {
        if (this.f6646p.isEmpty()) {
            return null;
        }
        View t10 = t(motionEvent);
        for (int size = this.f6646p.size() - 1; size >= 0; size--) {
            g gVar = this.f6646p.get(size);
            if (gVar.f6674e.f6302a == t10) {
                return gVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public View t(MotionEvent motionEvent) {
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        RecyclerView.d0 d0Var = this.f6633c;
        if (d0Var != null) {
            View view = d0Var.f6302a;
            if (y(view, x10, y10, this.f6640j + this.f6638h, this.f6641k + this.f6639i)) {
                return view;
            }
        }
        for (int size = this.f6646p.size() - 1; size >= 0; size--) {
            g gVar = this.f6646p.get(size);
            View view2 = gVar.f6674e.f6302a;
            if (y(view2, x10, y10, gVar.f6679k, gVar.f6680l)) {
                return view2;
            }
        }
        return this.f6648r.W(x10, y10);
    }

    /* access modifiers changed from: package-private */
    public boolean x() {
        int size = this.f6646p.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (!this.f6646p.get(i10).f6682n) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void z(RecyclerView.d0 d0Var) {
        if (!this.f6648r.isLayoutRequested() && this.f6644n == 2) {
            float j10 = this.f6643m.j(d0Var);
            int i10 = (int) (this.f6640j + this.f6638h);
            int i11 = (int) (this.f6641k + this.f6639i);
            if (((float) Math.abs(i11 - d0Var.f6302a.getTop())) >= ((float) d0Var.f6302a.getHeight()) * j10 || ((float) Math.abs(i10 - d0Var.f6302a.getLeft())) >= ((float) d0Var.f6302a.getWidth()) * j10) {
                List<RecyclerView.d0> u10 = u(d0Var);
                if (u10.size() != 0) {
                    RecyclerView.d0 b10 = this.f6643m.b(d0Var, u10, i10, i11);
                    if (b10 == null) {
                        this.f6651u.clear();
                        this.f6652v.clear();
                        return;
                    }
                    int o10 = b10.o();
                    int o11 = d0Var.o();
                    if (this.f6643m.y(this.f6648r, d0Var, b10)) {
                        this.f6643m.z(this.f6648r, d0Var, o11, b10, o10, i10, i11);
                    }
                }
            }
        }
    }
}

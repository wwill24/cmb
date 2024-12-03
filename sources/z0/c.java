package z0;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.core.view.n0;
import java.util.Arrays;

public class c {

    /* renamed from: x  reason: collision with root package name */
    private static final Interpolator f18805x = new a();

    /* renamed from: a  reason: collision with root package name */
    private int f18806a;

    /* renamed from: b  reason: collision with root package name */
    private int f18807b;

    /* renamed from: c  reason: collision with root package name */
    private int f18808c = -1;

    /* renamed from: d  reason: collision with root package name */
    private float[] f18809d;

    /* renamed from: e  reason: collision with root package name */
    private float[] f18810e;

    /* renamed from: f  reason: collision with root package name */
    private float[] f18811f;

    /* renamed from: g  reason: collision with root package name */
    private float[] f18812g;

    /* renamed from: h  reason: collision with root package name */
    private int[] f18813h;

    /* renamed from: i  reason: collision with root package name */
    private int[] f18814i;

    /* renamed from: j  reason: collision with root package name */
    private int[] f18815j;

    /* renamed from: k  reason: collision with root package name */
    private int f18816k;

    /* renamed from: l  reason: collision with root package name */
    private VelocityTracker f18817l;

    /* renamed from: m  reason: collision with root package name */
    private float f18818m;

    /* renamed from: n  reason: collision with root package name */
    private float f18819n;

    /* renamed from: o  reason: collision with root package name */
    private int f18820o;

    /* renamed from: p  reason: collision with root package name */
    private final int f18821p;

    /* renamed from: q  reason: collision with root package name */
    private int f18822q;

    /* renamed from: r  reason: collision with root package name */
    private OverScroller f18823r;

    /* renamed from: s  reason: collision with root package name */
    private final C0226c f18824s;

    /* renamed from: t  reason: collision with root package name */
    private View f18825t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f18826u;

    /* renamed from: v  reason: collision with root package name */
    private final ViewGroup f18827v;

    /* renamed from: w  reason: collision with root package name */
    private final Runnable f18828w = new b();

    class a implements Interpolator {
        a() {
        }

        public float getInterpolation(float f10) {
            float f11 = f10 - 1.0f;
            return (f11 * f11 * f11 * f11 * f11) + 1.0f;
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            c.this.E(0);
        }
    }

    /* renamed from: z0.c$c  reason: collision with other inner class name */
    public static abstract class C0226c {
        public abstract int a(@NonNull View view, int i10, int i11);

        public abstract int b(@NonNull View view, int i10, int i11);

        public int c(int i10) {
            return i10;
        }

        public int d(@NonNull View view) {
            return 0;
        }

        public int e(@NonNull View view) {
            return 0;
        }

        public void f(int i10, int i11) {
        }

        public boolean g(int i10) {
            return false;
        }

        public void h(int i10, int i11) {
        }

        public void i(@NonNull View view, int i10) {
        }

        public abstract void j(int i10);

        public abstract void k(@NonNull View view, int i10, int i11, int i12, int i13);

        public abstract void l(@NonNull View view, float f10, float f11);

        public abstract boolean m(@NonNull View view, int i10);
    }

    private c(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull C0226c cVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (cVar != null) {
            this.f18827v = viewGroup;
            this.f18824s = cVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            int i10 = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.f18821p = i10;
            this.f18820o = i10;
            this.f18807b = viewConfiguration.getScaledTouchSlop();
            this.f18818m = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.f18819n = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.f18823r = new OverScroller(context, f18805x);
        } else {
            throw new IllegalArgumentException("Callback may not be null");
        }
    }

    private void A() {
        this.f18817l.computeCurrentVelocity(1000, this.f18818m);
        n(e(this.f18817l.getXVelocity(this.f18808c), this.f18819n, this.f18818m), e(this.f18817l.getYVelocity(this.f18808c), this.f18819n, this.f18818m));
    }

    private void B(float f10, float f11, int i10) {
        boolean c10 = c(f10, f11, i10, 1);
        if (c(f11, f10, i10, 4)) {
            c10 |= true;
        }
        if (c(f10, f11, i10, 2)) {
            c10 |= true;
        }
        if (c(f11, f10, i10, 8)) {
            c10 |= true;
        }
        if (c10) {
            int[] iArr = this.f18814i;
            iArr[i10] = iArr[i10] | c10;
            this.f18824s.f(c10 ? 1 : 0, i10);
        }
    }

    private void C(float f10, float f11, int i10) {
        q(i10);
        float[] fArr = this.f18809d;
        this.f18811f[i10] = f10;
        fArr[i10] = f10;
        float[] fArr2 = this.f18810e;
        this.f18812g[i10] = f11;
        fArr2[i10] = f11;
        this.f18813h[i10] = t((int) f10, (int) f11);
        this.f18816k |= 1 << i10;
    }

    private void D(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i10 = 0; i10 < pointerCount; i10++) {
            int pointerId = motionEvent.getPointerId(i10);
            if (x(pointerId)) {
                float x10 = motionEvent.getX(i10);
                float y10 = motionEvent.getY(i10);
                this.f18811f[pointerId] = x10;
                this.f18812g[pointerId] = y10;
            }
        }
    }

    private boolean c(float f10, float f11, int i10, int i11) {
        float abs = Math.abs(f10);
        float abs2 = Math.abs(f11);
        if ((this.f18813h[i10] & i11) != i11 || (this.f18822q & i11) == 0 || (this.f18815j[i10] & i11) == i11 || (this.f18814i[i10] & i11) == i11) {
            return false;
        }
        int i12 = this.f18807b;
        if (abs <= ((float) i12) && abs2 <= ((float) i12)) {
            return false;
        }
        if (abs < abs2 * 0.5f && this.f18824s.g(i11)) {
            int[] iArr = this.f18815j;
            iArr[i10] = iArr[i10] | i11;
            return false;
        } else if ((this.f18814i[i10] & i11) != 0 || abs <= ((float) this.f18807b)) {
            return false;
        } else {
            return true;
        }
    }

    private boolean d(View view, float f10, float f11) {
        boolean z10;
        boolean z11;
        if (view == null) {
            return false;
        }
        if (this.f18824s.d(view) > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.f18824s.e(view) > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 && z11) {
            int i10 = this.f18807b;
            if ((f10 * f10) + (f11 * f11) > ((float) (i10 * i10))) {
                return true;
            }
            return false;
        } else if (z10) {
            if (Math.abs(f10) > ((float) this.f18807b)) {
                return true;
            }
            return false;
        } else if (!z11 || Math.abs(f11) <= ((float) this.f18807b)) {
            return false;
        } else {
            return true;
        }
    }

    private float e(float f10, float f11, float f12) {
        float abs = Math.abs(f10);
        if (abs < f11) {
            return 0.0f;
        }
        return abs > f12 ? f10 > 0.0f ? f12 : -f12 : f10;
    }

    private int f(int i10, int i11, int i12) {
        int abs = Math.abs(i10);
        if (abs < i11) {
            return 0;
        }
        return abs > i12 ? i10 > 0 ? i12 : -i12 : i10;
    }

    private void g() {
        float[] fArr = this.f18809d;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.f18810e, 0.0f);
            Arrays.fill(this.f18811f, 0.0f);
            Arrays.fill(this.f18812g, 0.0f);
            Arrays.fill(this.f18813h, 0);
            Arrays.fill(this.f18814i, 0);
            Arrays.fill(this.f18815j, 0);
            this.f18816k = 0;
        }
    }

    private void h(int i10) {
        if (this.f18809d != null && w(i10)) {
            this.f18809d[i10] = 0.0f;
            this.f18810e[i10] = 0.0f;
            this.f18811f[i10] = 0.0f;
            this.f18812g[i10] = 0.0f;
            this.f18813h[i10] = 0;
            this.f18814i[i10] = 0;
            this.f18815j[i10] = 0;
            this.f18816k = (~(1 << i10)) & this.f18816k;
        }
    }

    private int i(int i10, int i11, int i12) {
        int i13;
        if (i10 == 0) {
            return 0;
        }
        int width = this.f18827v.getWidth();
        float f10 = (float) (width / 2);
        float o10 = f10 + (o(Math.min(1.0f, ((float) Math.abs(i10)) / ((float) width))) * f10);
        int abs = Math.abs(i11);
        if (abs > 0) {
            i13 = Math.round(Math.abs(o10 / ((float) abs)) * 1000.0f) * 4;
        } else {
            i13 = (int) (((((float) Math.abs(i10)) / ((float) i12)) + 1.0f) * 256.0f);
        }
        return Math.min(i13, 600);
    }

    private int j(View view, int i10, int i11, int i12, int i13) {
        float f10;
        float f11;
        float f12;
        float f13;
        int f14 = f(i12, (int) this.f18819n, (int) this.f18818m);
        int f15 = f(i13, (int) this.f18819n, (int) this.f18818m);
        int abs = Math.abs(i10);
        int abs2 = Math.abs(i11);
        int abs3 = Math.abs(f14);
        int abs4 = Math.abs(f15);
        int i14 = abs3 + abs4;
        int i15 = abs + abs2;
        if (f14 != 0) {
            f11 = (float) abs3;
            f10 = (float) i14;
        } else {
            f11 = (float) abs;
            f10 = (float) i15;
        }
        float f16 = f11 / f10;
        if (f15 != 0) {
            f13 = (float) abs4;
            f12 = (float) i14;
        } else {
            f13 = (float) abs2;
            f12 = (float) i15;
        }
        float f17 = f13 / f12;
        return (int) ((((float) i(i10, f14, this.f18824s.d(view))) * f16) + (((float) i(i11, f15, this.f18824s.e(view))) * f17));
    }

    public static c l(@NonNull ViewGroup viewGroup, float f10, @NonNull C0226c cVar) {
        c m10 = m(viewGroup, cVar);
        m10.f18807b = (int) (((float) m10.f18807b) * (1.0f / f10));
        return m10;
    }

    public static c m(@NonNull ViewGroup viewGroup, @NonNull C0226c cVar) {
        return new c(viewGroup.getContext(), viewGroup, cVar);
    }

    private void n(float f10, float f11) {
        this.f18826u = true;
        this.f18824s.l(this.f18825t, f10, f11);
        this.f18826u = false;
        if (this.f18806a == 1) {
            E(0);
        }
    }

    private float o(float f10) {
        return (float) Math.sin((double) ((f10 - 0.5f) * 0.47123894f));
    }

    private void p(int i10, int i11, int i12, int i13) {
        int left = this.f18825t.getLeft();
        int top = this.f18825t.getTop();
        if (i12 != 0) {
            i10 = this.f18824s.a(this.f18825t, i10, i12);
            n0.c0(this.f18825t, i10 - left);
        }
        int i14 = i10;
        if (i13 != 0) {
            i11 = this.f18824s.b(this.f18825t, i11, i13);
            n0.d0(this.f18825t, i11 - top);
        }
        int i15 = i11;
        if (i12 != 0 || i13 != 0) {
            this.f18824s.k(this.f18825t, i14, i15, i14 - left, i15 - top);
        }
    }

    private void q(int i10) {
        float[] fArr = this.f18809d;
        if (fArr == null || fArr.length <= i10) {
            int i11 = i10 + 1;
            float[] fArr2 = new float[i11];
            float[] fArr3 = new float[i11];
            float[] fArr4 = new float[i11];
            float[] fArr5 = new float[i11];
            int[] iArr = new int[i11];
            int[] iArr2 = new int[i11];
            int[] iArr3 = new int[i11];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f18810e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f18811f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f18812g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f18813h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f18814i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f18815j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f18809d = fArr2;
            this.f18810e = fArr3;
            this.f18811f = fArr4;
            this.f18812g = fArr5;
            this.f18813h = iArr;
            this.f18814i = iArr2;
            this.f18815j = iArr3;
        }
    }

    private boolean s(int i10, int i11, int i12, int i13) {
        int left = this.f18825t.getLeft();
        int top = this.f18825t.getTop();
        int i14 = i10 - left;
        int i15 = i11 - top;
        if (i14 == 0 && i15 == 0) {
            this.f18823r.abortAnimation();
            E(0);
            return false;
        }
        this.f18823r.startScroll(left, top, i14, i15, j(this.f18825t, i14, i15, i12, i13));
        E(2);
        return true;
    }

    private int t(int i10, int i11) {
        int i12;
        if (i10 < this.f18827v.getLeft() + this.f18820o) {
            i12 = 1;
        } else {
            i12 = 0;
        }
        if (i11 < this.f18827v.getTop() + this.f18820o) {
            i12 |= 4;
        }
        if (i10 > this.f18827v.getRight() - this.f18820o) {
            i12 |= 2;
        }
        if (i11 > this.f18827v.getBottom() - this.f18820o) {
            return i12 | 8;
        }
        return i12;
    }

    private boolean x(int i10) {
        if (w(i10)) {
            return true;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Ignoring pointerId=");
        sb2.append(i10);
        sb2.append(" because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    /* access modifiers changed from: package-private */
    public void E(int i10) {
        this.f18827v.removeCallbacks(this.f18828w);
        if (this.f18806a != i10) {
            this.f18806a = i10;
            this.f18824s.j(i10);
            if (this.f18806a == 0) {
                this.f18825t = null;
            }
        }
    }

    public boolean F(int i10, int i11) {
        if (this.f18826u) {
            return s(i10, i11, (int) this.f18817l.getXVelocity(this.f18808c), (int) this.f18817l.getYVelocity(this.f18808c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00dd, code lost:
        if (r12 != r11) goto L_0x00e6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean G(@androidx.annotation.NonNull android.view.MotionEvent r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            int r2 = r17.getActionMasked()
            int r3 = r17.getActionIndex()
            if (r2 != 0) goto L_0x0011
            r16.a()
        L_0x0011:
            android.view.VelocityTracker r4 = r0.f18817l
            if (r4 != 0) goto L_0x001b
            android.view.VelocityTracker r4 = android.view.VelocityTracker.obtain()
            r0.f18817l = r4
        L_0x001b:
            android.view.VelocityTracker r4 = r0.f18817l
            r4.addMovement(r1)
            r4 = 2
            r6 = 1
            if (r2 == 0) goto L_0x0104
            if (r2 == r6) goto L_0x00ff
            if (r2 == r4) goto L_0x0070
            r7 = 3
            if (r2 == r7) goto L_0x00ff
            r7 = 5
            if (r2 == r7) goto L_0x003c
            r4 = 6
            if (r2 == r4) goto L_0x0034
        L_0x0031:
            r5 = 0
            goto L_0x0135
        L_0x0034:
            int r1 = r1.getPointerId(r3)
            r0.h(r1)
            goto L_0x0031
        L_0x003c:
            int r2 = r1.getPointerId(r3)
            float r7 = r1.getX(r3)
            float r1 = r1.getY(r3)
            r0.C(r7, r1, r2)
            int r3 = r0.f18806a
            if (r3 != 0) goto L_0x0060
            int[] r1 = r0.f18813h
            r1 = r1[r2]
            int r3 = r0.f18822q
            r4 = r1 & r3
            if (r4 == 0) goto L_0x0031
            z0.c$c r4 = r0.f18824s
            r1 = r1 & r3
            r4.h(r1, r2)
            goto L_0x0031
        L_0x0060:
            if (r3 != r4) goto L_0x0031
            int r3 = (int) r7
            int r1 = (int) r1
            android.view.View r1 = r0.r(r3, r1)
            android.view.View r3 = r0.f18825t
            if (r1 != r3) goto L_0x0031
            r0.I(r1, r2)
            goto L_0x0031
        L_0x0070:
            float[] r2 = r0.f18809d
            if (r2 == 0) goto L_0x0031
            float[] r2 = r0.f18810e
            if (r2 != 0) goto L_0x0079
            goto L_0x0031
        L_0x0079:
            int r2 = r17.getPointerCount()
            r3 = 0
        L_0x007e:
            if (r3 >= r2) goto L_0x00fa
            int r4 = r1.getPointerId(r3)
            boolean r7 = r0.x(r4)
            if (r7 != 0) goto L_0x008c
            goto L_0x00f7
        L_0x008c:
            float r7 = r1.getX(r3)
            float r8 = r1.getY(r3)
            float[] r9 = r0.f18809d
            r9 = r9[r4]
            float r9 = r7 - r9
            float[] r10 = r0.f18810e
            r10 = r10[r4]
            float r10 = r8 - r10
            int r7 = (int) r7
            int r8 = (int) r8
            android.view.View r7 = r0.r(r7, r8)
            if (r7 == 0) goto L_0x00b0
            boolean r8 = r0.d(r7, r9, r10)
            if (r8 == 0) goto L_0x00b0
            r8 = r6
            goto L_0x00b1
        L_0x00b0:
            r8 = 0
        L_0x00b1:
            if (r8 == 0) goto L_0x00e6
            int r11 = r7.getLeft()
            int r12 = (int) r9
            int r13 = r11 + r12
            z0.c$c r14 = r0.f18824s
            int r12 = r14.a(r7, r13, r12)
            int r13 = r7.getTop()
            int r14 = (int) r10
            int r15 = r13 + r14
            z0.c$c r5 = r0.f18824s
            int r5 = r5.b(r7, r15, r14)
            z0.c$c r14 = r0.f18824s
            int r14 = r14.d(r7)
            z0.c$c r15 = r0.f18824s
            int r15 = r15.e(r7)
            if (r14 == 0) goto L_0x00df
            if (r14 <= 0) goto L_0x00e6
            if (r12 != r11) goto L_0x00e6
        L_0x00df:
            if (r15 == 0) goto L_0x00fa
            if (r15 <= 0) goto L_0x00e6
            if (r5 != r13) goto L_0x00e6
            goto L_0x00fa
        L_0x00e6:
            r0.B(r9, r10, r4)
            int r5 = r0.f18806a
            if (r5 != r6) goto L_0x00ee
            goto L_0x00fa
        L_0x00ee:
            if (r8 == 0) goto L_0x00f7
            boolean r4 = r0.I(r7, r4)
            if (r4 == 0) goto L_0x00f7
            goto L_0x00fa
        L_0x00f7:
            int r3 = r3 + 1
            goto L_0x007e
        L_0x00fa:
            r16.D(r17)
            goto L_0x0031
        L_0x00ff:
            r16.a()
            goto L_0x0031
        L_0x0104:
            float r2 = r17.getX()
            float r3 = r17.getY()
            r5 = 0
            int r1 = r1.getPointerId(r5)
            r0.C(r2, r3, r1)
            int r2 = (int) r2
            int r3 = (int) r3
            android.view.View r2 = r0.r(r2, r3)
            android.view.View r3 = r0.f18825t
            if (r2 != r3) goto L_0x0125
            int r3 = r0.f18806a
            if (r3 != r4) goto L_0x0125
            r0.I(r2, r1)
        L_0x0125:
            int[] r2 = r0.f18813h
            r2 = r2[r1]
            int r3 = r0.f18822q
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0135
            z0.c$c r4 = r0.f18824s
            r2 = r2 & r3
            r4.h(r2, r1)
        L_0x0135:
            int r1 = r0.f18806a
            if (r1 != r6) goto L_0x013a
            r5 = r6
        L_0x013a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: z0.c.G(android.view.MotionEvent):boolean");
    }

    public boolean H(@NonNull View view, int i10, int i11) {
        this.f18825t = view;
        this.f18808c = -1;
        boolean s10 = s(i10, i11, 0, 0);
        if (!s10 && this.f18806a == 0 && this.f18825t != null) {
            this.f18825t = null;
        }
        return s10;
    }

    /* access modifiers changed from: package-private */
    public boolean I(View view, int i10) {
        if (view == this.f18825t && this.f18808c == i10) {
            return true;
        }
        if (view == null || !this.f18824s.m(view, i10)) {
            return false;
        }
        this.f18808c = i10;
        b(view, i10);
        return true;
    }

    public void a() {
        this.f18808c = -1;
        g();
        VelocityTracker velocityTracker = this.f18817l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f18817l = null;
        }
    }

    public void b(@NonNull View view, int i10) {
        if (view.getParent() == this.f18827v) {
            this.f18825t = view;
            this.f18808c = i10;
            this.f18824s.i(view, i10);
            E(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f18827v + ")");
    }

    public boolean k(boolean z10) {
        if (this.f18806a == 2) {
            boolean computeScrollOffset = this.f18823r.computeScrollOffset();
            int currX = this.f18823r.getCurrX();
            int currY = this.f18823r.getCurrY();
            int left = currX - this.f18825t.getLeft();
            int top = currY - this.f18825t.getTop();
            if (left != 0) {
                n0.c0(this.f18825t, left);
            }
            if (top != 0) {
                n0.d0(this.f18825t, top);
            }
            if (!(left == 0 && top == 0)) {
                this.f18824s.k(this.f18825t, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.f18823r.getFinalX() && currY == this.f18823r.getFinalY()) {
                this.f18823r.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                if (z10) {
                    this.f18827v.post(this.f18828w);
                } else {
                    E(0);
                }
            }
        }
        if (this.f18806a == 2) {
            return true;
        }
        return false;
    }

    public View r(int i10, int i11) {
        for (int childCount = this.f18827v.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f18827v.getChildAt(this.f18824s.c(childCount));
            if (i10 >= childAt.getLeft() && i10 < childAt.getRight() && i11 >= childAt.getTop() && i11 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public int u() {
        return this.f18807b;
    }

    public boolean v(int i10, int i11) {
        return y(this.f18825t, i10, i11);
    }

    public boolean w(int i10) {
        return ((1 << i10) & this.f18816k) != 0;
    }

    public boolean y(View view, int i10, int i11) {
        if (view != null && i10 >= view.getLeft() && i10 < view.getRight() && i11 >= view.getTop() && i11 < view.getBottom()) {
            return true;
        }
        return false;
    }

    public void z(@NonNull MotionEvent motionEvent) {
        int i10;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.f18817l == null) {
            this.f18817l = VelocityTracker.obtain();
        }
        this.f18817l.addMovement(motionEvent);
        int i11 = 0;
        if (actionMasked == 0) {
            float x10 = motionEvent.getX();
            float y10 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View r10 = r((int) x10, (int) y10);
            C(x10, y10, pointerId);
            I(r10, pointerId);
            int i12 = this.f18813h[pointerId];
            int i13 = this.f18822q;
            if ((i12 & i13) != 0) {
                this.f18824s.h(i12 & i13, pointerId);
            }
        } else if (actionMasked == 1) {
            if (this.f18806a == 1) {
                A();
            }
            a();
        } else if (actionMasked != 2) {
            if (actionMasked == 3) {
                if (this.f18806a == 1) {
                    n(0.0f, 0.0f);
                }
                a();
            } else if (actionMasked == 5) {
                int pointerId2 = motionEvent.getPointerId(actionIndex);
                float x11 = motionEvent.getX(actionIndex);
                float y11 = motionEvent.getY(actionIndex);
                C(x11, y11, pointerId2);
                if (this.f18806a == 0) {
                    I(r((int) x11, (int) y11), pointerId2);
                    int i14 = this.f18813h[pointerId2];
                    int i15 = this.f18822q;
                    if ((i14 & i15) != 0) {
                        this.f18824s.h(i14 & i15, pointerId2);
                    }
                } else if (v((int) x11, (int) y11)) {
                    I(this.f18825t, pointerId2);
                }
            } else if (actionMasked == 6) {
                int pointerId3 = motionEvent.getPointerId(actionIndex);
                if (this.f18806a == 1 && pointerId3 == this.f18808c) {
                    int pointerCount = motionEvent.getPointerCount();
                    while (true) {
                        if (i11 >= pointerCount) {
                            i10 = -1;
                            break;
                        }
                        int pointerId4 = motionEvent.getPointerId(i11);
                        if (pointerId4 != this.f18808c) {
                            View r11 = r((int) motionEvent.getX(i11), (int) motionEvent.getY(i11));
                            View view = this.f18825t;
                            if (r11 == view && I(view, pointerId4)) {
                                i10 = this.f18808c;
                                break;
                            }
                        }
                        i11++;
                    }
                    if (i10 == -1) {
                        A();
                    }
                }
                h(pointerId3);
            }
        } else if (this.f18806a != 1) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (i11 < pointerCount2) {
                int pointerId5 = motionEvent.getPointerId(i11);
                if (x(pointerId5)) {
                    float x12 = motionEvent.getX(i11);
                    float y12 = motionEvent.getY(i11);
                    float f10 = x12 - this.f18809d[pointerId5];
                    float f11 = y12 - this.f18810e[pointerId5];
                    B(f10, f11, pointerId5);
                    if (this.f18806a != 1) {
                        View r12 = r((int) x12, (int) y12);
                        if (d(r12, f10, f11) && I(r12, pointerId5)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i11++;
            }
            D(motionEvent);
        } else if (x(this.f18808c)) {
            int findPointerIndex = motionEvent.findPointerIndex(this.f18808c);
            float x13 = motionEvent.getX(findPointerIndex);
            float y13 = motionEvent.getY(findPointerIndex);
            float[] fArr = this.f18811f;
            int i16 = this.f18808c;
            int i17 = (int) (x13 - fArr[i16]);
            int i18 = (int) (y13 - this.f18812g[i16]);
            p(this.f18825t.getLeft() + i17, this.f18825t.getTop() + i18, i17, i18);
            D(motionEvent);
        }
    }
}

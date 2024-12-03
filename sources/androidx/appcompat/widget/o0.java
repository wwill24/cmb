package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.appcompat.view.menu.p;

public abstract class o0 implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private final float f1372a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1373b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1374c;

    /* renamed from: d  reason: collision with root package name */
    final View f1375d;

    /* renamed from: e  reason: collision with root package name */
    private Runnable f1376e;

    /* renamed from: f  reason: collision with root package name */
    private Runnable f1377f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1378g;

    /* renamed from: h  reason: collision with root package name */
    private int f1379h;

    /* renamed from: j  reason: collision with root package name */
    private final int[] f1380j = new int[2];

    private class a implements Runnable {
        a() {
        }

        public void run() {
            ViewParent parent = o0.this.f1375d.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    private class b implements Runnable {
        b() {
        }

        public void run() {
            o0.this.e();
        }
    }

    public o0(View view) {
        this.f1375d = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f1372a = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f1373b = tapTimeout;
        this.f1374c = (tapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    private void a() {
        Runnable runnable = this.f1377f;
        if (runnable != null) {
            this.f1375d.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f1376e;
        if (runnable2 != null) {
            this.f1375d.removeCallbacks(runnable2);
        }
    }

    private boolean f(MotionEvent motionEvent) {
        m0 m0Var;
        boolean z10;
        View view = this.f1375d;
        p b10 = b();
        if (b10 == null || !b10.b() || (m0Var = (m0) b10.p()) == null || !m0Var.isShown()) {
            return false;
        }
        MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        i(view, obtainNoHistory);
        j(m0Var, obtainNoHistory);
        boolean e10 = m0Var.e(obtainNoHistory, this.f1379h);
        obtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 3) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!e10 || !z10) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
        if (r1 != 3) goto L_0x006d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean g(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.view.View r0 = r5.f1375d
            boolean r1 = r0.isEnabled()
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            int r1 = r6.getActionMasked()
            if (r1 == 0) goto L_0x0041
            r3 = 1
            if (r1 == r3) goto L_0x003d
            r4 = 2
            if (r1 == r4) goto L_0x001a
            r6 = 3
            if (r1 == r6) goto L_0x003d
            goto L_0x006d
        L_0x001a:
            int r1 = r5.f1379h
            int r1 = r6.findPointerIndex(r1)
            if (r1 < 0) goto L_0x006d
            float r4 = r6.getX(r1)
            float r6 = r6.getY(r1)
            float r1 = r5.f1372a
            boolean r6 = h(r0, r4, r6, r1)
            if (r6 != 0) goto L_0x006d
            r5.a()
            android.view.ViewParent r6 = r0.getParent()
            r6.requestDisallowInterceptTouchEvent(r3)
            return r3
        L_0x003d:
            r5.a()
            goto L_0x006d
        L_0x0041:
            int r6 = r6.getPointerId(r2)
            r5.f1379h = r6
            java.lang.Runnable r6 = r5.f1376e
            if (r6 != 0) goto L_0x0052
            androidx.appcompat.widget.o0$a r6 = new androidx.appcompat.widget.o0$a
            r6.<init>()
            r5.f1376e = r6
        L_0x0052:
            java.lang.Runnable r6 = r5.f1376e
            int r1 = r5.f1373b
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
            java.lang.Runnable r6 = r5.f1377f
            if (r6 != 0) goto L_0x0065
            androidx.appcompat.widget.o0$b r6 = new androidx.appcompat.widget.o0$b
            r6.<init>()
            r5.f1377f = r6
        L_0x0065:
            java.lang.Runnable r6 = r5.f1377f
            int r1 = r5.f1374c
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
        L_0x006d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.o0.g(android.view.MotionEvent):boolean");
    }

    private static boolean h(View view, float f10, float f11, float f12) {
        float f13 = -f12;
        if (f10 < f13 || f11 < f13 || f10 >= ((float) (view.getRight() - view.getLeft())) + f12 || f11 >= ((float) (view.getBottom() - view.getTop())) + f12) {
            return false;
        }
        return true;
    }

    private boolean i(View view, MotionEvent motionEvent) {
        int[] iArr = this.f1380j;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) iArr[0], (float) iArr[1]);
        return true;
    }

    private boolean j(View view, MotionEvent motionEvent) {
        int[] iArr = this.f1380j;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) (-iArr[0]), (float) (-iArr[1]));
        return true;
    }

    public abstract p b();

    /* access modifiers changed from: protected */
    public abstract boolean c();

    /* access modifiers changed from: protected */
    public boolean d() {
        p b10 = b();
        if (b10 == null || !b10.b()) {
            return true;
        }
        b10.dismiss();
        return true;
    }

    /* access modifiers changed from: package-private */
    public void e() {
        a();
        View view = this.f1375d;
        if (view.isEnabled() && !view.isLongClickable() && c()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
            this.f1378g = true;
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z10;
        boolean z11 = this.f1378g;
        if (!z11) {
            if (!g(motionEvent) || !c()) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f1375d.onTouchEvent(obtain);
                obtain.recycle();
            }
        } else if (f(motionEvent) || !d()) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f1378g = z10;
        if (z10 || z11) {
            return true;
        }
        return false;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        this.f1378g = false;
        this.f1379h = -1;
        Runnable runnable = this.f1376e;
        if (runnable != null) {
            this.f1375d.removeCallbacks(runnable);
        }
    }
}

package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.n0;
import com.google.android.gms.common.api.a;

abstract class e<V extends View> extends g<V> {

    /* renamed from: d  reason: collision with root package name */
    private Runnable f19101d;

    /* renamed from: e  reason: collision with root package name */
    OverScroller f19102e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f19103f;

    /* renamed from: g  reason: collision with root package name */
    private int f19104g = -1;

    /* renamed from: h  reason: collision with root package name */
    private int f19105h;

    /* renamed from: i  reason: collision with root package name */
    private int f19106i = -1;

    /* renamed from: j  reason: collision with root package name */
    private VelocityTracker f19107j;

    private class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final CoordinatorLayout f19108a;

        /* renamed from: b  reason: collision with root package name */
        private final V f19109b;

        a(CoordinatorLayout coordinatorLayout, V v10) {
            this.f19108a = coordinatorLayout;
            this.f19109b = v10;
        }

        public void run() {
            OverScroller overScroller;
            if (this.f19109b != null && (overScroller = e.this.f19102e) != null) {
                if (overScroller.computeScrollOffset()) {
                    e eVar = e.this;
                    eVar.P(this.f19108a, this.f19109b, eVar.f19102e.getCurrY());
                    n0.k0(this.f19109b, this);
                    return;
                }
                e.this.N(this.f19108a, this.f19109b);
            }
        }
    }

    public e() {
    }

    private void I() {
        if (this.f19107j == null) {
            this.f19107j = VelocityTracker.obtain();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008c A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean D(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout r12, @androidx.annotation.NonNull V r13, @androidx.annotation.NonNull android.view.MotionEvent r14) {
        /*
            r11 = this;
            int r0 = r14.getActionMasked()
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 == r2) goto L_0x004e
            r4 = 2
            if (r0 == r4) goto L_0x002d
            r12 = 3
            if (r0 == r12) goto L_0x0072
            r12 = 6
            if (r0 == r12) goto L_0x0013
            goto L_0x004c
        L_0x0013:
            int r12 = r14.getActionIndex()
            if (r12 != 0) goto L_0x001b
            r12 = r2
            goto L_0x001c
        L_0x001b:
            r12 = r3
        L_0x001c:
            int r13 = r14.getPointerId(r12)
            r11.f19104g = r13
            float r12 = r14.getY(r12)
            r13 = 1056964608(0x3f000000, float:0.5)
            float r12 = r12 + r13
            int r12 = (int) r12
            r11.f19105h = r12
            goto L_0x004c
        L_0x002d:
            int r0 = r11.f19104g
            int r0 = r14.findPointerIndex(r0)
            if (r0 != r1) goto L_0x0036
            return r3
        L_0x0036:
            float r0 = r14.getY(r0)
            int r0 = (int) r0
            int r1 = r11.f19105h
            int r7 = r1 - r0
            r11.f19105h = r0
            int r8 = r11.K(r13)
            r9 = 0
            r4 = r11
            r5 = r12
            r6 = r13
            r4.O(r5, r6, r7, r8, r9)
        L_0x004c:
            r12 = r3
            goto L_0x0081
        L_0x004e:
            android.view.VelocityTracker r0 = r11.f19107j
            if (r0 == 0) goto L_0x0072
            r0.addMovement(r14)
            android.view.VelocityTracker r0 = r11.f19107j
            r4 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r4)
            android.view.VelocityTracker r0 = r11.f19107j
            int r4 = r11.f19104g
            float r10 = r0.getYVelocity(r4)
            int r0 = r11.L(r13)
            int r8 = -r0
            r9 = 0
            r5 = r11
            r6 = r12
            r7 = r13
            r5.J(r6, r7, r8, r9, r10)
            r12 = r2
            goto L_0x0073
        L_0x0072:
            r12 = r3
        L_0x0073:
            r11.f19103f = r3
            r11.f19104g = r1
            android.view.VelocityTracker r13 = r11.f19107j
            if (r13 == 0) goto L_0x0081
            r13.recycle()
            r13 = 0
            r11.f19107j = r13
        L_0x0081:
            android.view.VelocityTracker r13 = r11.f19107j
            if (r13 == 0) goto L_0x0088
            r13.addMovement(r14)
        L_0x0088:
            boolean r13 = r11.f19103f
            if (r13 != 0) goto L_0x0090
            if (r12 == 0) goto L_0x008f
            goto L_0x0090
        L_0x008f:
            r2 = r3
        L_0x0090:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.e.D(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: package-private */
    public boolean H(V v10) {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean J(CoordinatorLayout coordinatorLayout, @NonNull V v10, int i10, int i11, float f10) {
        V v11 = v10;
        Runnable runnable = this.f19101d;
        if (runnable != null) {
            v10.removeCallbacks(runnable);
            this.f19101d = null;
        }
        if (this.f19102e == null) {
            this.f19102e = new OverScroller(v10.getContext());
        }
        this.f19102e.fling(0, E(), 0, Math.round(f10), 0, 0, i10, i11);
        if (this.f19102e.computeScrollOffset()) {
            CoordinatorLayout coordinatorLayout2 = coordinatorLayout;
            a aVar = new a(coordinatorLayout, v10);
            this.f19101d = aVar;
            n0.k0(v10, aVar);
            return true;
        }
        CoordinatorLayout coordinatorLayout3 = coordinatorLayout;
        N(coordinatorLayout, v10);
        return false;
    }

    /* access modifiers changed from: package-private */
    public int K(@NonNull V v10) {
        return -v10.getHeight();
    }

    /* access modifiers changed from: package-private */
    public int L(@NonNull V v10) {
        return v10.getHeight();
    }

    /* access modifiers changed from: package-private */
    public int M() {
        return E();
    }

    /* access modifiers changed from: package-private */
    public void N(CoordinatorLayout coordinatorLayout, V v10) {
    }

    /* access modifiers changed from: package-private */
    public final int O(CoordinatorLayout coordinatorLayout, V v10, int i10, int i11, int i12) {
        return Q(coordinatorLayout, v10, M() - i10, i11, i12);
    }

    /* access modifiers changed from: package-private */
    public int P(CoordinatorLayout coordinatorLayout, V v10, int i10) {
        return Q(coordinatorLayout, v10, i10, Integer.MIN_VALUE, a.e.API_PRIORITY_OTHER);
    }

    /* access modifiers changed from: package-private */
    public int Q(CoordinatorLayout coordinatorLayout, V v10, int i10, int i11, int i12) {
        int b10;
        int E = E();
        if (i11 == 0 || E < i11 || E > i12 || E == (b10 = v0.a.b(i10, i11, i12))) {
            return 0;
        }
        G(b10);
        return E - b10;
    }

    public boolean k(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull MotionEvent motionEvent) {
        boolean z10;
        int findPointerIndex;
        if (this.f19106i < 0) {
            this.f19106i = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.f19103f) {
            int i10 = this.f19104g;
            if (i10 == -1 || (findPointerIndex = motionEvent.findPointerIndex(i10)) == -1) {
                return false;
            }
            int y10 = (int) motionEvent.getY(findPointerIndex);
            if (Math.abs(y10 - this.f19105h) > this.f19106i) {
                this.f19105h = y10;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f19104g = -1;
            int x10 = (int) motionEvent.getX();
            int y11 = (int) motionEvent.getY();
            if (!H(v10) || !coordinatorLayout.B(v10, x10, y11)) {
                z10 = false;
            } else {
                z10 = true;
            }
            this.f19103f = z10;
            if (z10) {
                this.f19105h = y11;
                this.f19104g = motionEvent.getPointerId(0);
                I();
                OverScroller overScroller = this.f19102e;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.f19102e.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.f19107j;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }

    public e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}

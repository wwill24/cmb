package z0;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.NonNull;
import androidx.collection.h;
import androidx.core.view.accessibility.k;
import androidx.core.view.accessibility.l;
import androidx.core.view.accessibility.m;
import androidx.core.view.n0;
import com.google.android.gms.common.api.a;
import java.util.ArrayList;
import java.util.List;
import net.bytebuddy.jar.asm.Opcodes;
import z0.b;

public abstract class a extends androidx.core.view.a {

    /* renamed from: n  reason: collision with root package name */
    private static final Rect f18787n = new Rect(a.e.API_PRIORITY_OTHER, a.e.API_PRIORITY_OTHER, Integer.MIN_VALUE, Integer.MIN_VALUE);

    /* renamed from: o  reason: collision with root package name */
    private static final b.a<k> f18788o = new C0224a();

    /* renamed from: p  reason: collision with root package name */
    private static final b.C0225b<h<k>, k> f18789p = new b();

    /* renamed from: d  reason: collision with root package name */
    private final Rect f18790d = new Rect();

    /* renamed from: e  reason: collision with root package name */
    private final Rect f18791e = new Rect();

    /* renamed from: f  reason: collision with root package name */
    private final Rect f18792f = new Rect();

    /* renamed from: g  reason: collision with root package name */
    private final int[] f18793g = new int[2];

    /* renamed from: h  reason: collision with root package name */
    private final AccessibilityManager f18794h;

    /* renamed from: i  reason: collision with root package name */
    private final View f18795i;

    /* renamed from: j  reason: collision with root package name */
    private c f18796j;

    /* renamed from: k  reason: collision with root package name */
    int f18797k = Integer.MIN_VALUE;

    /* renamed from: l  reason: collision with root package name */
    int f18798l = Integer.MIN_VALUE;

    /* renamed from: m  reason: collision with root package name */
    private int f18799m = Integer.MIN_VALUE;

    /* renamed from: z0.a$a  reason: collision with other inner class name */
    class C0224a implements b.a<k> {
        C0224a() {
        }

        /* renamed from: b */
        public void a(k kVar, Rect rect) {
            kVar.l(rect);
        }
    }

    class b implements b.C0225b<h<k>, k> {
        b() {
        }

        /* renamed from: c */
        public k a(h<k> hVar, int i10) {
            return hVar.p(i10);
        }

        /* renamed from: d */
        public int b(h<k> hVar) {
            return hVar.o();
        }
    }

    private class c extends l {
        c() {
        }

        public k b(int i10) {
            return k.P(a.this.H(i10));
        }

        public k d(int i10) {
            int i11;
            if (i10 == 2) {
                i11 = a.this.f18797k;
            } else {
                i11 = a.this.f18798l;
            }
            if (i11 == Integer.MIN_VALUE) {
                return null;
            }
            return b(i11);
        }

        public boolean f(int i10, int i11, Bundle bundle) {
            return a.this.P(i10, i11, bundle);
        }
    }

    public a(@NonNull View view) {
        if (view != null) {
            this.f18795i = view;
            this.f18794h = (AccessibilityManager) view.getContext().getSystemService("accessibility");
            view.setFocusable(true);
            if (n0.z(view) == 0) {
                n0.D0(view, 1);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("View may not be null");
    }

    private static Rect D(@NonNull View view, int i10, @NonNull Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i10 == 17) {
            rect.set(width, 0, width, height);
        } else if (i10 == 33) {
            rect.set(0, height, width, height);
        } else if (i10 == 66) {
            rect.set(-1, 0, -1, height);
        } else if (i10 == 130) {
            rect.set(0, -1, width, -1);
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return rect;
    }

    private boolean E(Rect rect) {
        if (rect == null || rect.isEmpty() || this.f18795i.getWindowVisibility() != 0) {
            return false;
        }
        ViewParent parent = this.f18795i.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        if (parent != null) {
            return true;
        }
        return false;
    }

    private static int F(int i10) {
        if (i10 == 19) {
            return 33;
        }
        if (i10 == 21) {
            return 17;
        }
        if (i10 != 22) {
            return Opcodes.IXOR;
        }
        return 66;
    }

    private boolean G(int i10, Rect rect) {
        k kVar;
        k kVar2;
        boolean z10;
        h<k> y10 = y();
        int i11 = this.f18798l;
        int i12 = Integer.MIN_VALUE;
        if (i11 == Integer.MIN_VALUE) {
            kVar = null;
        } else {
            kVar = y10.e(i11);
        }
        k kVar3 = kVar;
        if (i10 == 1 || i10 == 2) {
            if (n0.B(this.f18795i) == 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            kVar2 = (k) b.d(y10, f18789p, f18788o, kVar3, i10, z10, false);
        } else if (i10 == 17 || i10 == 33 || i10 == 66 || i10 == 130) {
            Rect rect2 = new Rect();
            int i13 = this.f18798l;
            if (i13 != Integer.MIN_VALUE) {
                z(i13, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                D(this.f18795i, i10, rect2);
            }
            kVar2 = (k) b.c(y10, f18789p, f18788o, kVar3, rect2, i10);
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        if (kVar2 != null) {
            i12 = y10.j(y10.i(kVar2));
        }
        return T(i12);
    }

    private boolean Q(int i10, int i11, Bundle bundle) {
        if (i11 == 1) {
            return T(i10);
        }
        if (i11 == 2) {
            return o(i10);
        }
        if (i11 == 64) {
            return S(i10);
        }
        if (i11 != 128) {
            return J(i10, i11, bundle);
        }
        return n(i10);
    }

    private boolean R(int i10, Bundle bundle) {
        return n0.h0(this.f18795i, i10, bundle);
    }

    private boolean S(int i10) {
        int i11;
        if (!this.f18794h.isEnabled() || !this.f18794h.isTouchExplorationEnabled() || (i11 = this.f18797k) == i10) {
            return false;
        }
        if (i11 != Integer.MIN_VALUE) {
            n(i11);
        }
        this.f18797k = i10;
        this.f18795i.invalidate();
        U(i10, 32768);
        return true;
    }

    private void V(int i10) {
        int i11 = this.f18799m;
        if (i11 != i10) {
            this.f18799m = i10;
            U(i10, 128);
            U(i11, 256);
        }
    }

    private boolean n(int i10) {
        if (this.f18797k != i10) {
            return false;
        }
        this.f18797k = Integer.MIN_VALUE;
        this.f18795i.invalidate();
        U(i10, 65536);
        return true;
    }

    private boolean p() {
        int i10 = this.f18798l;
        return i10 != Integer.MIN_VALUE && J(i10, 16, (Bundle) null);
    }

    private AccessibilityEvent q(int i10, int i11) {
        if (i10 != -1) {
            return r(i10, i11);
        }
        return s(i11);
    }

    private AccessibilityEvent r(int i10, int i11) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i11);
        k H = H(i10);
        obtain.getText().add(H.v());
        obtain.setContentDescription(H.q());
        obtain.setScrollable(H.J());
        obtain.setPassword(H.I());
        obtain.setEnabled(H.E());
        obtain.setChecked(H.C());
        L(i10, obtain);
        if (!obtain.getText().isEmpty() || obtain.getContentDescription() != null) {
            obtain.setClassName(H.o());
            m.c(obtain, this.f18795i, i10);
            obtain.setPackageName(this.f18795i.getContext().getPackageName());
            return obtain;
        }
        throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
    }

    private AccessibilityEvent s(int i10) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i10);
        this.f18795i.onInitializeAccessibilityEvent(obtain);
        return obtain;
    }

    @NonNull
    private k t(int i10) {
        boolean z10;
        k N = k.N();
        N.g0(true);
        N.i0(true);
        N.a0("android.view.View");
        Rect rect = f18787n;
        N.W(rect);
        N.X(rect);
        N.q0(this.f18795i);
        N(i10, N);
        if (N.v() == null && N.q() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        N.l(this.f18791e);
        if (!this.f18791e.equals(rect)) {
            int j10 = N.j();
            if ((j10 & 64) != 0) {
                throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            } else if ((j10 & 128) == 0) {
                N.o0(this.f18795i.getContext().getPackageName());
                N.w0(this.f18795i, i10);
                if (this.f18797k == i10) {
                    N.U(true);
                    N.a(128);
                } else {
                    N.U(false);
                    N.a(64);
                }
                if (this.f18798l == i10) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    N.a(2);
                } else if (N.F()) {
                    N.a(1);
                }
                N.j0(z10);
                this.f18795i.getLocationOnScreen(this.f18793g);
                N.m(this.f18790d);
                if (this.f18790d.equals(rect)) {
                    N.l(this.f18790d);
                    if (N.f4757b != -1) {
                        k N2 = k.N();
                        for (int i11 = N.f4757b; i11 != -1; i11 = N2.f4757b) {
                            N2.r0(this.f18795i, -1);
                            N2.W(f18787n);
                            N(i11, N2);
                            N2.l(this.f18791e);
                            Rect rect2 = this.f18790d;
                            Rect rect3 = this.f18791e;
                            rect2.offset(rect3.left, rect3.top);
                        }
                        N2.R();
                    }
                    this.f18790d.offset(this.f18793g[0] - this.f18795i.getScrollX(), this.f18793g[1] - this.f18795i.getScrollY());
                }
                if (this.f18795i.getLocalVisibleRect(this.f18792f)) {
                    this.f18792f.offset(this.f18793g[0] - this.f18795i.getScrollX(), this.f18793g[1] - this.f18795i.getScrollY());
                    if (this.f18790d.intersect(this.f18792f)) {
                        N.X(this.f18790d);
                        if (E(this.f18790d)) {
                            N.A0(true);
                        }
                    }
                }
                return N;
            } else {
                throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            }
        } else {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
    }

    @NonNull
    private k u() {
        k O = k.O(this.f18795i);
        n0.f0(this.f18795i, O);
        ArrayList arrayList = new ArrayList();
        C(arrayList);
        if (O.n() <= 0 || arrayList.size() <= 0) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                O.c(this.f18795i, ((Integer) arrayList.get(i10)).intValue());
            }
            return O;
        }
        throw new RuntimeException("Views cannot have both real and virtual children");
    }

    private h<k> y() {
        ArrayList arrayList = new ArrayList();
        C(arrayList);
        h<k> hVar = new h<>();
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            hVar.k(((Integer) arrayList.get(i10)).intValue(), t(((Integer) arrayList.get(i10)).intValue()));
        }
        return hVar;
    }

    private void z(int i10, Rect rect) {
        H(i10).l(rect);
    }

    public final int A() {
        return this.f18798l;
    }

    /* access modifiers changed from: protected */
    public abstract int B(float f10, float f11);

    /* access modifiers changed from: protected */
    public abstract void C(List<Integer> list);

    /* access modifiers changed from: package-private */
    @NonNull
    public k H(int i10) {
        if (i10 == -1) {
            return u();
        }
        return t(i10);
    }

    public final void I(boolean z10, int i10, Rect rect) {
        int i11 = this.f18798l;
        if (i11 != Integer.MIN_VALUE) {
            o(i11);
        }
        if (z10) {
            G(i10, rect);
        }
    }

    /* access modifiers changed from: protected */
    public abstract boolean J(int i10, int i11, Bundle bundle);

    /* access modifiers changed from: protected */
    public void K(@NonNull AccessibilityEvent accessibilityEvent) {
    }

    /* access modifiers changed from: protected */
    public void L(int i10, @NonNull AccessibilityEvent accessibilityEvent) {
    }

    /* access modifiers changed from: protected */
    public abstract void M(@NonNull k kVar);

    /* access modifiers changed from: protected */
    public abstract void N(int i10, @NonNull k kVar);

    /* access modifiers changed from: protected */
    public abstract void O(int i10, boolean z10);

    /* access modifiers changed from: package-private */
    public boolean P(int i10, int i11, Bundle bundle) {
        if (i10 != -1) {
            return Q(i10, i11, bundle);
        }
        return R(i11, bundle);
    }

    public final boolean T(int i10) {
        int i11;
        if ((!this.f18795i.isFocused() && !this.f18795i.requestFocus()) || (i11 = this.f18798l) == i10) {
            return false;
        }
        if (i11 != Integer.MIN_VALUE) {
            o(i11);
        }
        if (i10 == Integer.MIN_VALUE) {
            return false;
        }
        this.f18798l = i10;
        O(i10, true);
        U(i10, 8);
        return true;
    }

    public final boolean U(int i10, int i11) {
        ViewParent parent;
        if (i10 == Integer.MIN_VALUE || !this.f18794h.isEnabled() || (parent = this.f18795i.getParent()) == null) {
            return false;
        }
        return parent.requestSendAccessibilityEvent(this.f18795i, q(i10, i11));
    }

    public l b(View view) {
        if (this.f18796j == null) {
            this.f18796j = new c();
        }
        return this.f18796j;
    }

    public void f(View view, AccessibilityEvent accessibilityEvent) {
        super.f(view, accessibilityEvent);
        K(accessibilityEvent);
    }

    public void g(View view, k kVar) {
        super.g(view, kVar);
        M(kVar);
    }

    public final boolean o(int i10) {
        if (this.f18798l != i10) {
            return false;
        }
        this.f18798l = Integer.MIN_VALUE;
        O(i10, false);
        U(i10, 8);
        return true;
    }

    public final boolean v(@NonNull MotionEvent motionEvent) {
        if (!this.f18794h.isEnabled() || !this.f18794h.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            int B = B(motionEvent.getX(), motionEvent.getY());
            V(B);
            if (B != Integer.MIN_VALUE) {
                return true;
            }
            return false;
        } else if (action != 10 || this.f18799m == Integer.MIN_VALUE) {
            return false;
        } else {
            V(Integer.MIN_VALUE);
            return true;
        }
    }

    public final boolean w(@NonNull KeyEvent keyEvent) {
        int i10 = 0;
        if (keyEvent.getAction() == 1) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 61) {
            if (keyCode != 66) {
                switch (keyCode) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                        if (!keyEvent.hasNoModifiers()) {
                            return false;
                        }
                        int F = F(keyCode);
                        int repeatCount = keyEvent.getRepeatCount() + 1;
                        boolean z10 = false;
                        while (i10 < repeatCount && G(F, (Rect) null)) {
                            i10++;
                            z10 = true;
                        }
                        return z10;
                    case 23:
                        break;
                    default:
                        return false;
                }
            }
            if (!keyEvent.hasNoModifiers() || keyEvent.getRepeatCount() != 0) {
                return false;
            }
            p();
            return true;
        } else if (keyEvent.hasNoModifiers()) {
            return G(2, (Rect) null);
        } else {
            if (keyEvent.hasModifiers(1)) {
                return G(1, (Rect) null);
            }
            return false;
        }
    }

    public final int x() {
        return this.f18797k;
    }
}

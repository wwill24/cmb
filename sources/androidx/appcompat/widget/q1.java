package androidx.appcompat.widget;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.n0;
import androidx.core.view.y1;

class q1 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* renamed from: l  reason: collision with root package name */
    private static q1 f1417l;

    /* renamed from: m  reason: collision with root package name */
    private static q1 f1418m;

    /* renamed from: a  reason: collision with root package name */
    private final View f1419a;

    /* renamed from: b  reason: collision with root package name */
    private final CharSequence f1420b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1421c;

    /* renamed from: d  reason: collision with root package name */
    private final Runnable f1422d = new o1(this);

    /* renamed from: e  reason: collision with root package name */
    private final Runnable f1423e = new p1(this);

    /* renamed from: f  reason: collision with root package name */
    private int f1424f;

    /* renamed from: g  reason: collision with root package name */
    private int f1425g;

    /* renamed from: h  reason: collision with root package name */
    private r1 f1426h;

    /* renamed from: j  reason: collision with root package name */
    private boolean f1427j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f1428k;

    private q1(View view, CharSequence charSequence) {
        this.f1419a = view;
        this.f1420b = charSequence;
        this.f1421c = y1.c(ViewConfiguration.get(view.getContext()));
        c();
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    private void b() {
        this.f1419a.removeCallbacks(this.f1422d);
    }

    private void c() {
        this.f1428k = true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e() {
        i(false);
    }

    private void f() {
        this.f1419a.postDelayed(this.f1422d, (long) ViewConfiguration.getLongPressTimeout());
    }

    private static void g(q1 q1Var) {
        q1 q1Var2 = f1417l;
        if (q1Var2 != null) {
            q1Var2.b();
        }
        f1417l = q1Var;
        if (q1Var != null) {
            q1Var.f();
        }
    }

    public static void h(View view, CharSequence charSequence) {
        q1 q1Var = f1417l;
        if (q1Var != null && q1Var.f1419a == view) {
            g((q1) null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            q1 q1Var2 = f1418m;
            if (q1Var2 != null && q1Var2.f1419a == view) {
                q1Var2.d();
            }
            view.setOnLongClickListener((View.OnLongClickListener) null);
            view.setLongClickable(false);
            view.setOnHoverListener((View.OnHoverListener) null);
            return;
        }
        new q1(view, charSequence);
    }

    private boolean j(MotionEvent motionEvent) {
        int x10 = (int) motionEvent.getX();
        int y10 = (int) motionEvent.getY();
        if (!this.f1428k && Math.abs(x10 - this.f1424f) <= this.f1421c && Math.abs(y10 - this.f1425g) <= this.f1421c) {
            return false;
        }
        this.f1424f = x10;
        this.f1425g = y10;
        this.f1428k = false;
        return true;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        if (f1418m == this) {
            f1418m = null;
            r1 r1Var = this.f1426h;
            if (r1Var != null) {
                r1Var.c();
                this.f1426h = null;
                c();
                this.f1419a.removeOnAttachStateChangeListener(this);
            }
        }
        if (f1417l == this) {
            g((q1) null);
        }
        this.f1419a.removeCallbacks(this.f1423e);
    }

    /* access modifiers changed from: package-private */
    public void i(boolean z10) {
        long j10;
        int i10;
        long j11;
        if (n0.V(this.f1419a)) {
            g((q1) null);
            q1 q1Var = f1418m;
            if (q1Var != null) {
                q1Var.d();
            }
            f1418m = this;
            this.f1427j = z10;
            r1 r1Var = new r1(this.f1419a.getContext());
            this.f1426h = r1Var;
            r1Var.e(this.f1419a, this.f1424f, this.f1425g, this.f1427j, this.f1420b);
            this.f1419a.addOnAttachStateChangeListener(this);
            if (this.f1427j) {
                j10 = 2500;
            } else {
                if ((n0.O(this.f1419a) & 1) == 1) {
                    j11 = 3000;
                    i10 = ViewConfiguration.getLongPressTimeout();
                } else {
                    j11 = 15000;
                    i10 = ViewConfiguration.getLongPressTimeout();
                }
                j10 = j11 - ((long) i10);
            }
            this.f1419a.removeCallbacks(this.f1423e);
            this.f1419a.postDelayed(this.f1423e, j10);
        }
    }

    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f1426h != null && this.f1427j) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f1419a.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                c();
                d();
            }
        } else if (this.f1419a.isEnabled() && this.f1426h == null && j(motionEvent)) {
            g(this);
        }
        return false;
    }

    public boolean onLongClick(View view) {
        this.f1424f = view.getWidth() / 2;
        this.f1425g = view.getHeight() / 2;
        i(true);
        return true;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        d();
    }
}

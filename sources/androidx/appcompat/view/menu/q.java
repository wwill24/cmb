package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.t0;
import androidx.core.view.n0;
import d.d;
import d.g;

final class q extends k implements PopupWindow.OnDismissListener, View.OnKeyListener {
    private static final int C = g.abc_popup_menu_item_layout;
    private boolean B;

    /* renamed from: b  reason: collision with root package name */
    private final Context f907b;

    /* renamed from: c  reason: collision with root package name */
    private final g f908c;

    /* renamed from: d  reason: collision with root package name */
    private final f f909d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f910e;

    /* renamed from: f  reason: collision with root package name */
    private final int f911f;

    /* renamed from: g  reason: collision with root package name */
    private final int f912g;

    /* renamed from: h  reason: collision with root package name */
    private final int f913h;

    /* renamed from: j  reason: collision with root package name */
    final t0 f914j;

    /* renamed from: k  reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f915k = new a();

    /* renamed from: l  reason: collision with root package name */
    private final View.OnAttachStateChangeListener f916l = new b();

    /* renamed from: m  reason: collision with root package name */
    private PopupWindow.OnDismissListener f917m;

    /* renamed from: n  reason: collision with root package name */
    private View f918n;

    /* renamed from: p  reason: collision with root package name */
    View f919p;

    /* renamed from: q  reason: collision with root package name */
    private m.a f920q;

    /* renamed from: t  reason: collision with root package name */
    ViewTreeObserver f921t;

    /* renamed from: w  reason: collision with root package name */
    private boolean f922w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f923x;

    /* renamed from: y  reason: collision with root package name */
    private int f924y;

    /* renamed from: z  reason: collision with root package name */
    private int f925z = 0;

    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        public void onGlobalLayout() {
            if (q.this.b() && !q.this.f914j.B()) {
                View view = q.this.f919p;
                if (view == null || !view.isShown()) {
                    q.this.dismiss();
                } else {
                    q.this.f914j.a();
                }
            }
        }
    }

    class b implements View.OnAttachStateChangeListener {
        b() {
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = q.this.f921t;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    q.this.f921t = view.getViewTreeObserver();
                }
                q qVar = q.this;
                qVar.f921t.removeGlobalOnLayoutListener(qVar.f915k);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public q(Context context, g gVar, View view, int i10, int i11, boolean z10) {
        this.f907b = context;
        this.f908c = gVar;
        this.f910e = z10;
        this.f909d = new f(gVar, LayoutInflater.from(context), z10, C);
        this.f912g = i10;
        this.f913h = i11;
        Resources resources = context.getResources();
        this.f911f = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(d.abc_config_prefDialogWidth));
        this.f918n = view;
        this.f914j = new t0(context, (AttributeSet) null, i10, i11);
        gVar.c(this, context);
    }

    private boolean z() {
        View view;
        boolean z10;
        if (b()) {
            return true;
        }
        if (this.f922w || (view = this.f918n) == null) {
            return false;
        }
        this.f919p = view;
        this.f914j.K(this);
        this.f914j.L(this);
        this.f914j.J(true);
        View view2 = this.f919p;
        if (this.f921t == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.f921t = viewTreeObserver;
        if (z10) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f915k);
        }
        view2.addOnAttachStateChangeListener(this.f916l);
        this.f914j.D(view2);
        this.f914j.G(this.f925z);
        if (!this.f923x) {
            this.f924y = k.n(this.f909d, (ViewGroup) null, this.f907b, this.f911f);
            this.f923x = true;
        }
        this.f914j.F(this.f924y);
        this.f914j.I(2);
        this.f914j.H(m());
        this.f914j.a();
        ListView p10 = this.f914j.p();
        p10.setOnKeyListener(this);
        if (this.B && this.f908c.x() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f907b).inflate(g.abc_popup_menu_header_item_layout, p10, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            if (textView != null) {
                textView.setText(this.f908c.x());
            }
            frameLayout.setEnabled(false);
            p10.addHeaderView(frameLayout, (Object) null, false);
        }
        this.f914j.n(this.f909d);
        this.f914j.a();
        return true;
    }

    public void a() {
        if (!z()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    public boolean b() {
        return !this.f922w && this.f914j.b();
    }

    public void c(g gVar, boolean z10) {
        if (gVar == this.f908c) {
            dismiss();
            m.a aVar = this.f920q;
            if (aVar != null) {
                aVar.c(gVar, z10);
            }
        }
    }

    public void dismiss() {
        if (b()) {
            this.f914j.dismiss();
        }
    }

    public void e(m.a aVar) {
        this.f920q = aVar;
    }

    public boolean f(r rVar) {
        if (rVar.hasVisibleItems()) {
            l lVar = new l(this.f907b, rVar, this.f919p, this.f910e, this.f912g, this.f913h);
            lVar.j(this.f920q);
            lVar.g(k.x(rVar));
            lVar.i(this.f917m);
            this.f917m = null;
            this.f908c.e(false);
            int d10 = this.f914j.d();
            int m10 = this.f914j.m();
            if ((Gravity.getAbsoluteGravity(this.f925z, n0.B(this.f918n)) & 7) == 5) {
                d10 += this.f918n.getWidth();
            }
            if (lVar.n(d10, m10)) {
                m.a aVar = this.f920q;
                if (aVar == null) {
                    return true;
                }
                aVar.d(rVar);
                return true;
            }
        }
        return false;
    }

    public void g(boolean z10) {
        this.f923x = false;
        f fVar = this.f909d;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
    }

    public boolean h() {
        return false;
    }

    public void k(g gVar) {
    }

    public void o(View view) {
        this.f918n = view;
    }

    public void onDismiss() {
        this.f922w = true;
        this.f908c.close();
        ViewTreeObserver viewTreeObserver = this.f921t;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f921t = this.f919p.getViewTreeObserver();
            }
            this.f921t.removeGlobalOnLayoutListener(this.f915k);
            this.f921t = null;
        }
        this.f919p.removeOnAttachStateChangeListener(this.f916l);
        PopupWindow.OnDismissListener onDismissListener = this.f917m;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public boolean onKey(View view, int i10, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i10 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    public ListView p() {
        return this.f914j.p();
    }

    public void r(boolean z10) {
        this.f909d.d(z10);
    }

    public void s(int i10) {
        this.f925z = i10;
    }

    public void t(int i10) {
        this.f914j.f(i10);
    }

    public void u(PopupWindow.OnDismissListener onDismissListener) {
        this.f917m = onDismissListener;
    }

    public void v(boolean z10) {
        this.B = z10;
    }

    public void w(int i10) {
        this.f914j.j(i10);
    }
}

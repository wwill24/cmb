package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.appcompat.app.a;
import androidx.appcompat.view.b;
import androidx.appcompat.view.h;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.j0;
import androidx.appcompat.widget.z0;
import androidx.core.view.e2;
import androidx.core.view.f2;
import androidx.core.view.g2;
import androidx.core.view.h2;
import androidx.core.view.n0;
import d.f;
import d.j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class u extends a implements ActionBarOverlayLayout.d {
    private static final Interpolator E = new AccelerateInterpolator();
    private static final Interpolator F = new DecelerateInterpolator();
    boolean A;
    final f2 B = new a();
    final f2 C = new b();
    final h2 D = new c();

    /* renamed from: a  reason: collision with root package name */
    Context f612a;

    /* renamed from: b  reason: collision with root package name */
    private Context f613b;

    /* renamed from: c  reason: collision with root package name */
    private Activity f614c;

    /* renamed from: d  reason: collision with root package name */
    ActionBarOverlayLayout f615d;

    /* renamed from: e  reason: collision with root package name */
    ActionBarContainer f616e;

    /* renamed from: f  reason: collision with root package name */
    j0 f617f;

    /* renamed from: g  reason: collision with root package name */
    ActionBarContextView f618g;

    /* renamed from: h  reason: collision with root package name */
    View f619h;

    /* renamed from: i  reason: collision with root package name */
    z0 f620i;

    /* renamed from: j  reason: collision with root package name */
    private ArrayList<Object> f621j = new ArrayList<>();

    /* renamed from: k  reason: collision with root package name */
    private int f622k = -1;

    /* renamed from: l  reason: collision with root package name */
    private boolean f623l;

    /* renamed from: m  reason: collision with root package name */
    d f624m;

    /* renamed from: n  reason: collision with root package name */
    androidx.appcompat.view.b f625n;

    /* renamed from: o  reason: collision with root package name */
    b.a f626o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f627p;

    /* renamed from: q  reason: collision with root package name */
    private ArrayList<a.b> f628q = new ArrayList<>();

    /* renamed from: r  reason: collision with root package name */
    private boolean f629r;

    /* renamed from: s  reason: collision with root package name */
    private int f630s = 0;

    /* renamed from: t  reason: collision with root package name */
    boolean f631t = true;

    /* renamed from: u  reason: collision with root package name */
    boolean f632u;

    /* renamed from: v  reason: collision with root package name */
    boolean f633v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f634w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f635x = true;

    /* renamed from: y  reason: collision with root package name */
    h f636y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f637z;

    class a extends g2 {
        a() {
        }

        public void b(View view) {
            View view2;
            u uVar = u.this;
            if (uVar.f631t && (view2 = uVar.f619h) != null) {
                view2.setTranslationY(0.0f);
                u.this.f616e.setTranslationY(0.0f);
            }
            u.this.f616e.setVisibility(8);
            u.this.f616e.setTransitioning(false);
            u uVar2 = u.this;
            uVar2.f636y = null;
            uVar2.F();
            ActionBarOverlayLayout actionBarOverlayLayout = u.this.f615d;
            if (actionBarOverlayLayout != null) {
                n0.p0(actionBarOverlayLayout);
            }
        }
    }

    class b extends g2 {
        b() {
        }

        public void b(View view) {
            u uVar = u.this;
            uVar.f636y = null;
            uVar.f616e.requestLayout();
        }
    }

    class c implements h2 {
        c() {
        }

        public void a(View view) {
            ((View) u.this.f616e.getParent()).invalidate();
        }
    }

    public class d extends androidx.appcompat.view.b implements g.a {

        /* renamed from: c  reason: collision with root package name */
        private final Context f641c;

        /* renamed from: d  reason: collision with root package name */
        private final g f642d;

        /* renamed from: e  reason: collision with root package name */
        private b.a f643e;

        /* renamed from: f  reason: collision with root package name */
        private WeakReference<View> f644f;

        public d(Context context, b.a aVar) {
            this.f641c = context;
            this.f643e = aVar;
            g S = new g(context).S(1);
            this.f642d = S;
            S.R(this);
        }

        public boolean a(@NonNull g gVar, @NonNull MenuItem menuItem) {
            b.a aVar = this.f643e;
            if (aVar != null) {
                return aVar.c(this, menuItem);
            }
            return false;
        }

        public void b(@NonNull g gVar) {
            if (this.f643e != null) {
                k();
                u.this.f618g.l();
            }
        }

        public void c() {
            u uVar = u.this;
            if (uVar.f624m == this) {
                if (!u.E(uVar.f632u, uVar.f633v, false)) {
                    u uVar2 = u.this;
                    uVar2.f625n = this;
                    uVar2.f626o = this.f643e;
                } else {
                    this.f643e.a(this);
                }
                this.f643e = null;
                u.this.D(false);
                u.this.f618g.g();
                u uVar3 = u.this;
                uVar3.f615d.setHideOnContentScrollEnabled(uVar3.A);
                u.this.f624m = null;
            }
        }

        public View d() {
            WeakReference<View> weakReference = this.f644f;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        public Menu e() {
            return this.f642d;
        }

        public MenuInflater f() {
            return new androidx.appcompat.view.g(this.f641c);
        }

        public CharSequence g() {
            return u.this.f618g.getSubtitle();
        }

        public CharSequence i() {
            return u.this.f618g.getTitle();
        }

        public void k() {
            if (u.this.f624m == this) {
                this.f642d.d0();
                try {
                    this.f643e.d(this, this.f642d);
                } finally {
                    this.f642d.c0();
                }
            }
        }

        public boolean l() {
            return u.this.f618g.j();
        }

        public void m(View view) {
            u.this.f618g.setCustomView(view);
            this.f644f = new WeakReference<>(view);
        }

        public void n(int i10) {
            o(u.this.f612a.getResources().getString(i10));
        }

        public void o(CharSequence charSequence) {
            u.this.f618g.setSubtitle(charSequence);
        }

        public void q(int i10) {
            r(u.this.f612a.getResources().getString(i10));
        }

        public void r(CharSequence charSequence) {
            u.this.f618g.setTitle(charSequence);
        }

        public void s(boolean z10) {
            super.s(z10);
            u.this.f618g.setTitleOptional(z10);
        }

        public boolean t() {
            this.f642d.d0();
            try {
                return this.f643e.b(this, this.f642d);
            } finally {
                this.f642d.c0();
            }
        }
    }

    public u(Activity activity, boolean z10) {
        this.f614c = activity;
        View decorView = activity.getWindow().getDecorView();
        L(decorView);
        if (!z10) {
            this.f619h = decorView.findViewById(16908290);
        }
    }

    static boolean E(boolean z10, boolean z11, boolean z12) {
        if (z12) {
            return true;
        }
        return !z10 && !z11;
    }

    private j0 I(View view) {
        String str;
        if (view instanceof j0) {
            return (j0) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Can't make a decor toolbar out of ");
        if (view != null) {
            str = view.getClass().getSimpleName();
        } else {
            str = "null";
        }
        sb2.append(str);
        throw new IllegalStateException(sb2.toString());
    }

    private void K() {
        if (this.f634w) {
            this.f634w = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f615d;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            S(false);
        }
    }

    private void L(View view) {
        boolean z10;
        boolean z11;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(f.decor_content_parent);
        this.f615d = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f617f = I(view.findViewById(f.action_bar));
        this.f618g = (ActionBarContextView) view.findViewById(f.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(f.action_bar_container);
        this.f616e = actionBarContainer;
        j0 j0Var = this.f617f;
        if (j0Var == null || this.f618g == null || actionBarContainer == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f612a = j0Var.getContext();
        if ((this.f617f.w() & 4) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            this.f623l = true;
        }
        androidx.appcompat.view.a b10 = androidx.appcompat.view.a.b(this.f612a);
        if (b10.a() || z10) {
            z11 = true;
        } else {
            z11 = false;
        }
        x(z11);
        O(b10.g());
        TypedArray obtainStyledAttributes = this.f612a.obtainStyledAttributes((AttributeSet) null, j.ActionBar, d.a.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(j.ActionBar_hideOnContentScroll, false)) {
            P(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(j.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            N((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    private void O(boolean z10) {
        boolean z11;
        boolean z12;
        this.f629r = z10;
        if (!z10) {
            this.f617f.r((z0) null);
            this.f616e.setTabContainer(this.f620i);
        } else {
            this.f616e.setTabContainer((z0) null);
            this.f617f.r(this.f620i);
        }
        boolean z13 = true;
        if (J() == 2) {
            z11 = true;
        } else {
            z11 = false;
        }
        z0 z0Var = this.f620i;
        if (z0Var != null) {
            if (z11) {
                z0Var.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f615d;
                if (actionBarOverlayLayout != null) {
                    n0.p0(actionBarOverlayLayout);
                }
            } else {
                z0Var.setVisibility(8);
            }
        }
        j0 j0Var = this.f617f;
        if (this.f629r || !z11) {
            z12 = false;
        } else {
            z12 = true;
        }
        j0Var.p(z12);
        ActionBarOverlayLayout actionBarOverlayLayout2 = this.f615d;
        if (this.f629r || !z11) {
            z13 = false;
        }
        actionBarOverlayLayout2.setHasNonEmbeddedTabs(z13);
    }

    private boolean Q() {
        return n0.W(this.f616e);
    }

    private void R() {
        if (!this.f634w) {
            this.f634w = true;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f615d;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(true);
            }
            S(false);
        }
    }

    private void S(boolean z10) {
        if (E(this.f632u, this.f633v, this.f634w)) {
            if (!this.f635x) {
                this.f635x = true;
                H(z10);
            }
        } else if (this.f635x) {
            this.f635x = false;
            G(z10);
        }
    }

    public void A(CharSequence charSequence) {
        this.f617f.setTitle(charSequence);
    }

    public void B(CharSequence charSequence) {
        this.f617f.setWindowTitle(charSequence);
    }

    public androidx.appcompat.view.b C(b.a aVar) {
        d dVar = this.f624m;
        if (dVar != null) {
            dVar.c();
        }
        this.f615d.setHideOnContentScrollEnabled(false);
        this.f618g.k();
        d dVar2 = new d(this.f618g.getContext(), aVar);
        if (!dVar2.t()) {
            return null;
        }
        this.f624m = dVar2;
        dVar2.k();
        this.f618g.h(dVar2);
        D(true);
        return dVar2;
    }

    public void D(boolean z10) {
        e2 e2Var;
        e2 e2Var2;
        if (z10) {
            R();
        } else {
            K();
        }
        if (Q()) {
            if (z10) {
                e2Var = this.f617f.l(4, 100);
                e2Var2 = this.f618g.f(0, 200);
            } else {
                e2Var2 = this.f617f.l(0, 200);
                e2Var = this.f618g.f(8, 100);
            }
            h hVar = new h();
            hVar.d(e2Var, e2Var2);
            hVar.h();
        } else if (z10) {
            this.f617f.v(4);
            this.f618g.setVisibility(0);
        } else {
            this.f617f.v(0);
            this.f618g.setVisibility(8);
        }
    }

    /* access modifiers changed from: package-private */
    public void F() {
        b.a aVar = this.f626o;
        if (aVar != null) {
            aVar.a(this.f625n);
            this.f625n = null;
            this.f626o = null;
        }
    }

    public void G(boolean z10) {
        View view;
        h hVar = this.f636y;
        if (hVar != null) {
            hVar.a();
        }
        if (this.f630s != 0 || (!this.f637z && !z10)) {
            this.B.b((View) null);
            return;
        }
        this.f616e.setAlpha(1.0f);
        this.f616e.setTransitioning(true);
        h hVar2 = new h();
        float f10 = (float) (-this.f616e.getHeight());
        if (z10) {
            int[] iArr = {0, 0};
            this.f616e.getLocationInWindow(iArr);
            f10 -= (float) iArr[1];
        }
        e2 m10 = n0.e(this.f616e).m(f10);
        m10.k(this.D);
        hVar2.c(m10);
        if (this.f631t && (view = this.f619h) != null) {
            hVar2.c(n0.e(view).m(f10));
        }
        hVar2.f(E);
        hVar2.e(250);
        hVar2.g(this.B);
        this.f636y = hVar2;
        hVar2.h();
    }

    public void H(boolean z10) {
        View view;
        View view2;
        h hVar = this.f636y;
        if (hVar != null) {
            hVar.a();
        }
        this.f616e.setVisibility(0);
        if (this.f630s != 0 || (!this.f637z && !z10)) {
            this.f616e.setAlpha(1.0f);
            this.f616e.setTranslationY(0.0f);
            if (this.f631t && (view = this.f619h) != null) {
                view.setTranslationY(0.0f);
            }
            this.C.b((View) null);
        } else {
            this.f616e.setTranslationY(0.0f);
            float f10 = (float) (-this.f616e.getHeight());
            if (z10) {
                int[] iArr = {0, 0};
                this.f616e.getLocationInWindow(iArr);
                f10 -= (float) iArr[1];
            }
            this.f616e.setTranslationY(f10);
            h hVar2 = new h();
            e2 m10 = n0.e(this.f616e).m(0.0f);
            m10.k(this.D);
            hVar2.c(m10);
            if (this.f631t && (view2 = this.f619h) != null) {
                view2.setTranslationY(f10);
                hVar2.c(n0.e(this.f619h).m(0.0f));
            }
            hVar2.f(F);
            hVar2.e(250);
            hVar2.g(this.C);
            this.f636y = hVar2;
            hVar2.h();
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f615d;
        if (actionBarOverlayLayout != null) {
            n0.p0(actionBarOverlayLayout);
        }
    }

    public int J() {
        return this.f617f.k();
    }

    public void M(int i10, int i11) {
        int w10 = this.f617f.w();
        if ((i11 & 4) != 0) {
            this.f623l = true;
        }
        this.f617f.i((i10 & i11) | ((~i11) & w10));
    }

    public void N(float f10) {
        n0.A0(this.f616e, f10);
    }

    public void P(boolean z10) {
        if (!z10 || this.f615d.w()) {
            this.A = z10;
            this.f615d.setHideOnContentScrollEnabled(z10);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    public void a() {
        if (this.f633v) {
            this.f633v = false;
            S(true);
        }
    }

    public void b(int i10) {
        this.f630s = i10;
    }

    public void c() {
    }

    public void d(boolean z10) {
        this.f631t = z10;
    }

    public void e() {
        if (!this.f633v) {
            this.f633v = true;
            S(true);
        }
    }

    public void f() {
        h hVar = this.f636y;
        if (hVar != null) {
            hVar.a();
            this.f636y = null;
        }
    }

    public boolean h() {
        j0 j0Var = this.f617f;
        if (j0Var == null || !j0Var.h()) {
            return false;
        }
        this.f617f.collapseActionView();
        return true;
    }

    public void i(boolean z10) {
        if (z10 != this.f627p) {
            this.f627p = z10;
            int size = this.f628q.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f628q.get(i10).onMenuVisibilityChanged(z10);
            }
        }
    }

    public int j() {
        return this.f617f.w();
    }

    public Context k() {
        if (this.f613b == null) {
            TypedValue typedValue = new TypedValue();
            this.f612a.getTheme().resolveAttribute(d.a.actionBarWidgetTheme, typedValue, true);
            int i10 = typedValue.resourceId;
            if (i10 != 0) {
                this.f613b = new ContextThemeWrapper(this.f612a, i10);
            } else {
                this.f613b = this.f612a;
            }
        }
        return this.f613b;
    }

    public void l() {
        if (!this.f632u) {
            this.f632u = true;
            S(false);
        }
    }

    public void n(Configuration configuration) {
        O(androidx.appcompat.view.a.b(this.f612a).g());
    }

    public boolean p(int i10, KeyEvent keyEvent) {
        Menu e10;
        int i11;
        d dVar = this.f624m;
        if (dVar == null || (e10 = dVar.e()) == null) {
            return false;
        }
        if (keyEvent != null) {
            i11 = keyEvent.getDeviceId();
        } else {
            i11 = -1;
        }
        boolean z10 = true;
        if (KeyCharacterMap.load(i11).getKeyboardType() == 1) {
            z10 = false;
        }
        e10.setQwertyMode(z10);
        return e10.performShortcut(i10, keyEvent, 0);
    }

    public void s(View view) {
        this.f617f.x(view);
    }

    public void t(boolean z10) {
        if (!this.f623l) {
            u(z10);
        }
    }

    public void u(boolean z10) {
        M(z10 ? 4 : 0, 4);
    }

    public void v(int i10) {
        if ((i10 & 4) != 0) {
            this.f623l = true;
        }
        this.f617f.i(i10);
    }

    public void w(boolean z10) {
        M(z10 ? 2 : 0, 2);
    }

    public void x(boolean z10) {
        this.f617f.n(z10);
    }

    public void y(Drawable drawable) {
        this.f617f.s(drawable);
    }

    public void z(boolean z10) {
        h hVar;
        this.f637z = z10;
        if (!z10 && (hVar = this.f636y) != null) {
            hVar.a();
        }
    }

    public u(Dialog dialog) {
        L(dialog.getWindow().getDecorView());
    }
}

package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.e2;
import androidx.core.view.g2;
import androidx.core.view.n0;
import d.e;
import d.f;
import d.h;
import d.j;

public class l1 implements j0 {

    /* renamed from: a  reason: collision with root package name */
    Toolbar f1318a;

    /* renamed from: b  reason: collision with root package name */
    private int f1319b;

    /* renamed from: c  reason: collision with root package name */
    private View f1320c;

    /* renamed from: d  reason: collision with root package name */
    private View f1321d;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f1322e;

    /* renamed from: f  reason: collision with root package name */
    private Drawable f1323f;

    /* renamed from: g  reason: collision with root package name */
    private Drawable f1324g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1325h;

    /* renamed from: i  reason: collision with root package name */
    CharSequence f1326i;

    /* renamed from: j  reason: collision with root package name */
    private CharSequence f1327j;

    /* renamed from: k  reason: collision with root package name */
    private CharSequence f1328k;

    /* renamed from: l  reason: collision with root package name */
    Window.Callback f1329l;

    /* renamed from: m  reason: collision with root package name */
    boolean f1330m;

    /* renamed from: n  reason: collision with root package name */
    private ActionMenuPresenter f1331n;

    /* renamed from: o  reason: collision with root package name */
    private int f1332o;

    /* renamed from: p  reason: collision with root package name */
    private int f1333p;

    /* renamed from: q  reason: collision with root package name */
    private Drawable f1334q;

    class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final androidx.appcompat.view.menu.a f1335a;

        a() {
            this.f1335a = new androidx.appcompat.view.menu.a(l1.this.f1318a.getContext(), 0, 16908332, 0, 0, l1.this.f1326i);
        }

        public void onClick(View view) {
            l1 l1Var = l1.this;
            Window.Callback callback = l1Var.f1329l;
            if (callback != null && l1Var.f1330m) {
                callback.onMenuItemSelected(0, this.f1335a);
            }
        }
    }

    class b extends g2 {

        /* renamed from: a  reason: collision with root package name */
        private boolean f1337a = false;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f1338b;

        b(int i10) {
            this.f1338b = i10;
        }

        public void a(View view) {
            this.f1337a = true;
        }

        public void b(View view) {
            if (!this.f1337a) {
                l1.this.f1318a.setVisibility(this.f1338b);
            }
        }

        public void c(View view) {
            l1.this.f1318a.setVisibility(0);
        }
    }

    public l1(Toolbar toolbar, boolean z10) {
        this(toolbar, z10, h.abc_action_bar_up_description, e.abc_ic_ab_back_material);
    }

    private void F(CharSequence charSequence) {
        this.f1326i = charSequence;
        if ((this.f1319b & 8) != 0) {
            this.f1318a.setTitle(charSequence);
            if (this.f1325h) {
                n0.v0(this.f1318a.getRootView(), charSequence);
            }
        }
    }

    private void G() {
        if ((this.f1319b & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.f1328k)) {
            this.f1318a.setNavigationContentDescription(this.f1333p);
        } else {
            this.f1318a.setNavigationContentDescription(this.f1328k);
        }
    }

    private void H() {
        if ((this.f1319b & 4) != 0) {
            Toolbar toolbar = this.f1318a;
            Drawable drawable = this.f1324g;
            if (drawable == null) {
                drawable = this.f1334q;
            }
            toolbar.setNavigationIcon(drawable);
            return;
        }
        this.f1318a.setNavigationIcon((Drawable) null);
    }

    private void I() {
        Drawable drawable;
        int i10 = this.f1319b;
        if ((i10 & 2) == 0) {
            drawable = null;
        } else if ((i10 & 1) != 0) {
            drawable = this.f1323f;
            if (drawable == null) {
                drawable = this.f1322e;
            }
        } else {
            drawable = this.f1322e;
        }
        this.f1318a.setLogo(drawable);
    }

    private int z() {
        if (this.f1318a.getNavigationIcon() == null) {
            return 11;
        }
        this.f1334q = this.f1318a.getNavigationIcon();
        return 15;
    }

    public void A(int i10) {
        if (i10 != this.f1333p) {
            this.f1333p = i10;
            if (TextUtils.isEmpty(this.f1318a.getNavigationContentDescription())) {
                B(this.f1333p);
            }
        }
    }

    public void B(int i10) {
        C(i10 == 0 ? null : getContext().getString(i10));
    }

    public void C(CharSequence charSequence) {
        this.f1328k = charSequence;
        G();
    }

    public void D(Drawable drawable) {
        this.f1324g = drawable;
        H();
    }

    public void E(CharSequence charSequence) {
        this.f1327j = charSequence;
        if ((this.f1319b & 8) != 0) {
            this.f1318a.setSubtitle(charSequence);
        }
    }

    public boolean a() {
        return this.f1318a.d();
    }

    public boolean b() {
        return this.f1318a.w();
    }

    public boolean c() {
        return this.f1318a.R();
    }

    public void collapseActionView() {
        this.f1318a.e();
    }

    public void d(Menu menu, m.a aVar) {
        if (this.f1331n == null) {
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(this.f1318a.getContext());
            this.f1331n = actionMenuPresenter;
            actionMenuPresenter.p(f.action_menu_presenter);
        }
        this.f1331n.e(aVar);
        this.f1318a.L((g) menu, this.f1331n);
    }

    public boolean e() {
        return this.f1318a.B();
    }

    public void f() {
        this.f1330m = true;
    }

    public boolean g() {
        return this.f1318a.A();
    }

    public Context getContext() {
        return this.f1318a.getContext();
    }

    public CharSequence getTitle() {
        return this.f1318a.getTitle();
    }

    public boolean h() {
        return this.f1318a.v();
    }

    public void i(int i10) {
        View view;
        int i11 = this.f1319b ^ i10;
        this.f1319b = i10;
        if (i11 != 0) {
            if ((i11 & 4) != 0) {
                if ((i10 & 4) != 0) {
                    G();
                }
                H();
            }
            if ((i11 & 3) != 0) {
                I();
            }
            if ((i11 & 8) != 0) {
                if ((i10 & 8) != 0) {
                    this.f1318a.setTitle(this.f1326i);
                    this.f1318a.setSubtitle(this.f1327j);
                } else {
                    this.f1318a.setTitle((CharSequence) null);
                    this.f1318a.setSubtitle((CharSequence) null);
                }
            }
            if ((i11 & 16) != 0 && (view = this.f1321d) != null) {
                if ((i10 & 16) != 0) {
                    this.f1318a.addView(view);
                } else {
                    this.f1318a.removeView(view);
                }
            }
        }
    }

    public Menu j() {
        return this.f1318a.getMenu();
    }

    public int k() {
        return this.f1332o;
    }

    public e2 l(int i10, long j10) {
        float f10;
        e2 e10 = n0.e(this.f1318a);
        if (i10 == 0) {
            f10 = 1.0f;
        } else {
            f10 = 0.0f;
        }
        return e10.b(f10).f(j10).h(new b(i10));
    }

    public ViewGroup m() {
        return this.f1318a;
    }

    public void n(boolean z10) {
    }

    public void o() {
    }

    public void p(boolean z10) {
        this.f1318a.setCollapsible(z10);
    }

    public void q() {
        this.f1318a.f();
    }

    public void r(z0 z0Var) {
        Toolbar toolbar;
        View view = this.f1320c;
        if (view != null && view.getParent() == (toolbar = this.f1318a)) {
            toolbar.removeView(this.f1320c);
        }
        this.f1320c = z0Var;
        if (z0Var != null && this.f1332o == 2) {
            this.f1318a.addView(z0Var, 0);
            Toolbar.g gVar = (Toolbar.g) this.f1320c.getLayoutParams();
            gVar.width = -2;
            gVar.height = -2;
            gVar.f538a = 8388691;
            z0Var.setAllowCollapse(true);
        }
    }

    public void s(Drawable drawable) {
        this.f1323f = drawable;
        I();
    }

    public void setIcon(int i10) {
        setIcon(i10 != 0 ? e.a.b(getContext(), i10) : null);
    }

    public void setTitle(CharSequence charSequence) {
        this.f1325h = true;
        F(charSequence);
    }

    public void setWindowCallback(Window.Callback callback) {
        this.f1329l = callback;
    }

    public void setWindowTitle(CharSequence charSequence) {
        if (!this.f1325h) {
            F(charSequence);
        }
    }

    public void t(int i10) {
        s(i10 != 0 ? e.a.b(getContext(), i10) : null);
    }

    public void u(m.a aVar, g.a aVar2) {
        this.f1318a.M(aVar, aVar2);
    }

    public void v(int i10) {
        this.f1318a.setVisibility(i10);
    }

    public int w() {
        return this.f1319b;
    }

    public void x(View view) {
        View view2 = this.f1321d;
        if (!(view2 == null || (this.f1319b & 16) == 0)) {
            this.f1318a.removeView(view2);
        }
        this.f1321d = view;
        if (view != null && (this.f1319b & 16) != 0) {
            this.f1318a.addView(view);
        }
    }

    public void y() {
    }

    public l1(Toolbar toolbar, boolean z10, int i10, int i11) {
        Drawable drawable;
        this.f1332o = 0;
        this.f1333p = 0;
        this.f1318a = toolbar;
        this.f1326i = toolbar.getTitle();
        this.f1327j = toolbar.getSubtitle();
        this.f1325h = this.f1326i != null;
        this.f1324g = toolbar.getNavigationIcon();
        h1 v10 = h1.v(toolbar.getContext(), (AttributeSet) null, j.ActionBar, d.a.actionBarStyle, 0);
        this.f1334q = v10.g(j.ActionBar_homeAsUpIndicator);
        if (z10) {
            CharSequence p10 = v10.p(j.ActionBar_title);
            if (!TextUtils.isEmpty(p10)) {
                setTitle(p10);
            }
            CharSequence p11 = v10.p(j.ActionBar_subtitle);
            if (!TextUtils.isEmpty(p11)) {
                E(p11);
            }
            Drawable g10 = v10.g(j.ActionBar_logo);
            if (g10 != null) {
                s(g10);
            }
            Drawable g11 = v10.g(j.ActionBar_icon);
            if (g11 != null) {
                setIcon(g11);
            }
            if (this.f1324g == null && (drawable = this.f1334q) != null) {
                D(drawable);
            }
            i(v10.k(j.ActionBar_displayOptions, 0));
            int n10 = v10.n(j.ActionBar_customNavigationLayout, 0);
            if (n10 != 0) {
                x(LayoutInflater.from(this.f1318a.getContext()).inflate(n10, this.f1318a, false));
                i(this.f1319b | 16);
            }
            int m10 = v10.m(j.ActionBar_height, 0);
            if (m10 > 0) {
                ViewGroup.LayoutParams layoutParams = this.f1318a.getLayoutParams();
                layoutParams.height = m10;
                this.f1318a.setLayoutParams(layoutParams);
            }
            int e10 = v10.e(j.ActionBar_contentInsetStart, -1);
            int e11 = v10.e(j.ActionBar_contentInsetEnd, -1);
            if (e10 >= 0 || e11 >= 0) {
                this.f1318a.K(Math.max(e10, 0), Math.max(e11, 0));
            }
            int n11 = v10.n(j.ActionBar_titleTextStyle, 0);
            if (n11 != 0) {
                Toolbar toolbar2 = this.f1318a;
                toolbar2.O(toolbar2.getContext(), n11);
            }
            int n12 = v10.n(j.ActionBar_subtitleTextStyle, 0);
            if (n12 != 0) {
                Toolbar toolbar3 = this.f1318a;
                toolbar3.N(toolbar3.getContext(), n12);
            }
            int n13 = v10.n(j.ActionBar_popupTheme, 0);
            if (n13 != 0) {
                this.f1318a.setPopupTheme(n13);
            }
        } else {
            this.f1319b = z();
        }
        v10.w();
        A(i10);
        this.f1328k = this.f1318a.getNavigationContentDescription();
        this.f1318a.setNavigationOnClickListener(new a());
    }

    public void setIcon(Drawable drawable) {
        this.f1322e = drawable;
        I();
    }
}

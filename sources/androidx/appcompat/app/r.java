package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.j0;
import androidx.appcompat.widget.l1;
import androidx.core.util.h;
import androidx.core.view.n0;
import java.util.ArrayList;

class r extends a {

    /* renamed from: a  reason: collision with root package name */
    final j0 f587a;

    /* renamed from: b  reason: collision with root package name */
    final Window.Callback f588b;

    /* renamed from: c  reason: collision with root package name */
    final AppCompatDelegateImpl.f f589c;

    /* renamed from: d  reason: collision with root package name */
    boolean f590d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f591e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f592f;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<a.b> f593g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    private final Runnable f594h = new a();

    /* renamed from: i  reason: collision with root package name */
    private final Toolbar.h f595i;

    class a implements Runnable {
        a() {
        }

        public void run() {
            r.this.E();
        }
    }

    class b implements Toolbar.h {
        b() {
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return r.this.f588b.onMenuItemSelected(0, menuItem);
        }
    }

    private final class c implements m.a {

        /* renamed from: a  reason: collision with root package name */
        private boolean f598a;

        c() {
        }

        public void c(@NonNull g gVar, boolean z10) {
            if (!this.f598a) {
                this.f598a = true;
                r.this.f587a.q();
                r.this.f588b.onPanelClosed(108, gVar);
                this.f598a = false;
            }
        }

        public boolean d(@NonNull g gVar) {
            r.this.f588b.onMenuOpened(108, gVar);
            return true;
        }
    }

    private final class d implements g.a {
        d() {
        }

        public boolean a(@NonNull g gVar, @NonNull MenuItem menuItem) {
            return false;
        }

        public void b(@NonNull g gVar) {
            if (r.this.f587a.e()) {
                r.this.f588b.onPanelClosed(108, gVar);
            } else if (r.this.f588b.onPreparePanel(0, (View) null, gVar)) {
                r.this.f588b.onMenuOpened(108, gVar);
            }
        }
    }

    private class e implements AppCompatDelegateImpl.f {
        e() {
        }

        public boolean a(int i10) {
            if (i10 != 0) {
                return false;
            }
            r rVar = r.this;
            if (rVar.f590d) {
                return false;
            }
            rVar.f587a.f();
            r.this.f590d = true;
            return false;
        }

        public View onCreatePanelView(int i10) {
            if (i10 == 0) {
                return new View(r.this.f587a.getContext());
            }
            return null;
        }
    }

    r(@NonNull Toolbar toolbar, CharSequence charSequence, @NonNull Window.Callback callback) {
        b bVar = new b();
        this.f595i = bVar;
        h.g(toolbar);
        l1 l1Var = new l1(toolbar, false);
        this.f587a = l1Var;
        this.f588b = (Window.Callback) h.g(callback);
        l1Var.setWindowCallback(callback);
        toolbar.setOnMenuItemClickListener(bVar);
        l1Var.setWindowTitle(charSequence);
        this.f589c = new e();
    }

    private Menu D() {
        if (!this.f591e) {
            this.f587a.u(new c(), new d());
            this.f591e = true;
        }
        return this.f587a.j();
    }

    public void A(CharSequence charSequence) {
        this.f587a.setTitle(charSequence);
    }

    public void B(CharSequence charSequence) {
        this.f587a.setWindowTitle(charSequence);
    }

    /* access modifiers changed from: package-private */
    public void E() {
        g gVar;
        Menu D = D();
        if (D instanceof g) {
            gVar = (g) D;
        } else {
            gVar = null;
        }
        if (gVar != null) {
            gVar.d0();
        }
        try {
            D.clear();
            if (!this.f588b.onCreatePanelMenu(0, D) || !this.f588b.onPreparePanel(0, (View) null, D)) {
                D.clear();
            }
        } finally {
            if (gVar != null) {
                gVar.c0();
            }
        }
    }

    public void F(View view, a.C0012a aVar) {
        if (view != null) {
            view.setLayoutParams(aVar);
        }
        this.f587a.x(view);
    }

    public void G(int i10, int i11) {
        this.f587a.i((i10 & i11) | ((~i11) & this.f587a.w()));
    }

    public boolean g() {
        return this.f587a.b();
    }

    public boolean h() {
        if (!this.f587a.h()) {
            return false;
        }
        this.f587a.collapseActionView();
        return true;
    }

    public void i(boolean z10) {
        if (z10 != this.f592f) {
            this.f592f = z10;
            int size = this.f593g.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f593g.get(i10).onMenuVisibilityChanged(z10);
            }
        }
    }

    public int j() {
        return this.f587a.w();
    }

    public Context k() {
        return this.f587a.getContext();
    }

    public void l() {
        this.f587a.v(8);
    }

    public boolean m() {
        this.f587a.m().removeCallbacks(this.f594h);
        n0.k0(this.f587a.m(), this.f594h);
        return true;
    }

    public void n(Configuration configuration) {
        super.n(configuration);
    }

    /* access modifiers changed from: package-private */
    public void o() {
        this.f587a.m().removeCallbacks(this.f594h);
    }

    public boolean p(int i10, KeyEvent keyEvent) {
        int i11;
        Menu D = D();
        if (D == null) {
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
        D.setQwertyMode(z10);
        return D.performShortcut(i10, keyEvent, 0);
    }

    public boolean q(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            r();
        }
        return true;
    }

    public boolean r() {
        return this.f587a.c();
    }

    public void s(View view) {
        F(view, new a.C0012a(-2, -2));
    }

    public void t(boolean z10) {
    }

    public void u(boolean z10) {
        G(z10 ? 4 : 0, 4);
    }

    @SuppressLint({"WrongConstant"})
    public void v(int i10) {
        G(i10, -1);
    }

    public void w(boolean z10) {
        G(z10 ? 2 : 0, 2);
    }

    public void x(boolean z10) {
    }

    public void y(Drawable drawable) {
        this.f587a.s(drawable);
    }

    public void z(boolean z10) {
    }
}

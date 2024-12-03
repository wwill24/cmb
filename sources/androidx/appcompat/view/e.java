package androidx.appcompat.view;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.view.b;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

public class e extends b implements g.a {

    /* renamed from: c  reason: collision with root package name */
    private Context f655c;

    /* renamed from: d  reason: collision with root package name */
    private ActionBarContextView f656d;

    /* renamed from: e  reason: collision with root package name */
    private b.a f657e;

    /* renamed from: f  reason: collision with root package name */
    private WeakReference<View> f658f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f659g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f660h;

    /* renamed from: j  reason: collision with root package name */
    private g f661j;

    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar, boolean z10) {
        this.f655c = context;
        this.f656d = actionBarContextView;
        this.f657e = aVar;
        g S = new g(actionBarContextView.getContext()).S(1);
        this.f661j = S;
        S.R(this);
        this.f660h = z10;
    }

    public boolean a(@NonNull g gVar, @NonNull MenuItem menuItem) {
        return this.f657e.c(this, menuItem);
    }

    public void b(@NonNull g gVar) {
        k();
        this.f656d.l();
    }

    public void c() {
        if (!this.f659g) {
            this.f659g = true;
            this.f657e.a(this);
        }
    }

    public View d() {
        WeakReference<View> weakReference = this.f658f;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public Menu e() {
        return this.f661j;
    }

    public MenuInflater f() {
        return new g(this.f656d.getContext());
    }

    public CharSequence g() {
        return this.f656d.getSubtitle();
    }

    public CharSequence i() {
        return this.f656d.getTitle();
    }

    public void k() {
        this.f657e.d(this, this.f661j);
    }

    public boolean l() {
        return this.f656d.j();
    }

    public void m(View view) {
        WeakReference<View> weakReference;
        this.f656d.setCustomView(view);
        if (view != null) {
            weakReference = new WeakReference<>(view);
        } else {
            weakReference = null;
        }
        this.f658f = weakReference;
    }

    public void n(int i10) {
        o(this.f655c.getString(i10));
    }

    public void o(CharSequence charSequence) {
        this.f656d.setSubtitle(charSequence);
    }

    public void q(int i10) {
        r(this.f655c.getString(i10));
    }

    public void r(CharSequence charSequence) {
        this.f656d.setTitle(charSequence);
    }

    public void s(boolean z10) {
        super.s(z10);
        this.f656d.setTitleOptional(z10);
    }
}

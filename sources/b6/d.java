package b6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import b6.f;
import b6.q;
import c6.b;
import d6.a;

public abstract class d<D extends f, R extends q> extends l {

    /* renamed from: e  reason: collision with root package name */
    protected D f7848e;

    /* renamed from: f  reason: collision with root package name */
    protected R f7849f;

    /* renamed from: g  reason: collision with root package name */
    protected ViewGroup f7850g;

    /* renamed from: h  reason: collision with root package name */
    protected final b f7851h = new b();

    public b F0() {
        return this.f7851h;
    }

    /* access modifiers changed from: protected */
    public abstract D G0();

    /* access modifiers changed from: protected */
    public abstract R H0(ViewGroup viewGroup);

    public a I0() {
        return this.f7861c;
    }

    public ViewGroup J0() {
        return this.f7850g;
    }

    /* access modifiers changed from: protected */
    public abstract String K0();

    /* access modifiers changed from: protected */
    public int L0() {
        return 16908290;
    }

    /* access modifiers changed from: package-private */
    public void M0() {
        View l10;
        ViewGroup viewGroup = (ViewGroup) findViewById(L0());
        this.f7850g = viewGroup;
        R H0 = H0(viewGroup);
        this.f7849f = H0;
        if ((H0 instanceof u) && (l10 = ((u) H0).l()) != null) {
            this.f7850g.addView(l10);
        }
        this.f7849f.c();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        this.f7851h.b(new c6.a(i10, i11, intent));
    }

    public void onBackPressed() {
        R r10 = this.f7849f;
        if (r10 == null || !r10.h()) {
            super.onBackPressed();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        D d10 = (f) supportFragmentManager.j0(K0());
        this.f7848e = d10;
        if (d10 == null) {
            this.f7848e = G0();
            supportFragmentManager.p().e(this.f7848e, K0()).i();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        R r10 = this.f7849f;
        if (r10 != null) {
            r10.d();
        }
        this.f7849f = null;
    }
}

package androidx.fragment.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.util.h;

public class k {

    /* renamed from: a  reason: collision with root package name */
    private final m<?> f5859a;

    private k(m<?> mVar) {
        this.f5859a = mVar;
    }

    @NonNull
    public static k b(@NonNull m<?> mVar) {
        return new k((m) h.h(mVar, "callbacks == null"));
    }

    public void a(Fragment fragment) {
        m<?> mVar = this.f5859a;
        mVar.f5865e.n(mVar, mVar, fragment);
    }

    public void c() {
        this.f5859a.f5865e.z();
    }

    public boolean d(@NonNull MenuItem menuItem) {
        return this.f5859a.f5865e.C(menuItem);
    }

    public void e() {
        this.f5859a.f5865e.D();
    }

    public void f() {
        this.f5859a.f5865e.F();
    }

    public void g() {
        this.f5859a.f5865e.O();
    }

    public void h() {
        this.f5859a.f5865e.S();
    }

    public void i() {
        this.f5859a.f5865e.T();
    }

    public void j() {
        this.f5859a.f5865e.V();
    }

    public boolean k() {
        return this.f5859a.f5865e.c0(true);
    }

    @NonNull
    public FragmentManager l() {
        return this.f5859a.f5865e;
    }

    public void m() {
        this.f5859a.f5865e.a1();
    }

    public View n(View view, @NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        return this.f5859a.f5865e.x0().onCreateView(view, str, context, attributeSet);
    }
}

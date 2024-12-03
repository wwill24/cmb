package androidx.appcompat.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.q;
import androidx.annotation.NonNull;
import androidx.appcompat.view.b;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.s1;
import androidx.core.app.n;
import androidx.core.app.q0;
import androidx.core.os.j;
import androidx.fragment.app.h;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.m0;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import androidx.savedstate.a;

public class c extends h implements d, q0.b {

    /* renamed from: a  reason: collision with root package name */
    private f f542a;

    /* renamed from: b  reason: collision with root package name */
    private Resources f543b;

    class a implements a.c {
        a() {
        }

        @NonNull
        public Bundle a() {
            Bundle bundle = new Bundle();
            c.this.k0().B(bundle);
            return bundle;
        }
    }

    class b implements b.b {
        b() {
        }

        public void a(@NonNull Context context) {
            f k02 = c.this.k0();
            k02.s();
            k02.x(c.this.getSavedStateRegistry().b("androidx:appcompat"));
        }
    }

    public c() {
        q0();
    }

    private void initViewTreeOwners() {
        ViewTreeLifecycleOwner.b(getWindow().getDecorView(), this);
        m0.a(getWindow().getDecorView(), this);
        ViewTreeSavedStateRegistryOwner.b(getWindow().getDecorView(), this);
        q.a(getWindow().getDecorView(), this);
    }

    private void q0() {
        getSavedStateRegistry().h("androidx:appcompat", new a());
        addOnContextAvailableListener(new b());
    }

    private boolean y0(KeyEvent keyEvent) {
        Window window;
        if (Build.VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()) || (window = getWindow()) == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) {
            return false;
        }
        return true;
    }

    public void A0(@NonNull Intent intent) {
        n.e(this, intent);
    }

    public boolean B0(@NonNull Intent intent) {
        return n.f(this, intent);
    }

    public void F(@NonNull androidx.appcompat.view.b bVar) {
    }

    public void H(@NonNull androidx.appcompat.view.b bVar) {
    }

    public androidx.appcompat.view.b O(@NonNull b.a aVar) {
        return null;
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        k0().e(view, layoutParams);
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(k0().g(context));
    }

    public void closeOptionsMenu() {
        a p02 = p0();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (p02 == null || !p02.g()) {
            super.closeOptionsMenu();
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        a p02 = p0();
        if (keyCode != 82 || p02 == null || !p02.q(keyEvent)) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    public <T extends View> T findViewById(int i10) {
        return k0().j(i10);
    }

    @NonNull
    public MenuInflater getMenuInflater() {
        return k0().p();
    }

    public Resources getResources() {
        if (this.f543b == null && s1.d()) {
            this.f543b = new s1(this, super.getResources());
        }
        Resources resources = this.f543b;
        if (resources == null) {
            return super.getResources();
        }
        return resources;
    }

    public void invalidateOptionsMenu() {
        k0().t();
    }

    @NonNull
    public f k0() {
        if (this.f542a == null) {
            this.f542a = f.h(this, this);
        }
        return this.f542a;
    }

    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        k0().w(configuration);
        if (this.f543b != null) {
            this.f543b.updateConfiguration(super.getResources().getConfiguration(), super.getResources().getDisplayMetrics());
        }
    }

    public void onContentChanged() {
        v0();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        k0().y();
    }

    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (y0(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i10, keyEvent);
    }

    public final boolean onMenuItemSelected(int i10, @NonNull MenuItem menuItem) {
        if (super.onMenuItemSelected(i10, menuItem)) {
            return true;
        }
        a p02 = p0();
        if (menuItem.getItemId() != 16908332 || p02 == null || (p02.j() & 4) == 0) {
            return false;
        }
        return w0();
    }

    public boolean onMenuOpened(int i10, Menu menu) {
        return super.onMenuOpened(i10, menu);
    }

    public void onPanelClosed(int i10, @NonNull Menu menu) {
        super.onPanelClosed(i10, menu);
    }

    /* access modifiers changed from: protected */
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        k0().z(bundle);
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        super.onPostResume();
        k0().A();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        k0().C();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        k0().D();
    }

    /* access modifiers changed from: protected */
    public void onTitleChanged(CharSequence charSequence, int i10) {
        super.onTitleChanged(charSequence, i10);
        k0().O(charSequence);
    }

    public void openOptionsMenu() {
        a p02 = p0();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (p02 == null || !p02.r()) {
            super.openOptionsMenu();
        }
    }

    public Intent p() {
        return n.a(this);
    }

    public a p0() {
        return k0().r();
    }

    public void r0(@NonNull q0 q0Var) {
        q0Var.f(this);
    }

    /* access modifiers changed from: protected */
    public void s0(@NonNull j jVar) {
    }

    public void setContentView(int i10) {
        initViewTreeOwners();
        k0().I(i10);
    }

    public void setTheme(int i10) {
        super.setTheme(i10);
        k0().N(i10);
    }

    public void supportInvalidateOptionsMenu() {
        k0().t();
    }

    /* access modifiers changed from: protected */
    public void t0(int i10) {
    }

    public void u0(@NonNull q0 q0Var) {
    }

    @Deprecated
    public void v0() {
    }

    public boolean w0() {
        Intent p10 = p();
        if (p10 == null) {
            return false;
        }
        if (B0(p10)) {
            q0 j10 = q0.j(this);
            r0(j10);
            u0(j10);
            j10.o();
            try {
                androidx.core.app.b.b(this);
                return true;
            } catch (IllegalStateException unused) {
                finish();
                return true;
            }
        } else {
            A0(p10);
            return true;
        }
    }

    public void z0(Toolbar toolbar) {
        k0().M(toolbar);
    }

    public void setContentView(View view) {
        initViewTreeOwners();
        k0().J(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        k0().K(view, layoutParams);
    }
}

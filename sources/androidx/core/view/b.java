package androidx.core.view;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.NonNull;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f4790a;

    /* renamed from: b  reason: collision with root package name */
    private a f4791b;

    /* renamed from: c  reason: collision with root package name */
    private C0047b f4792c;

    public interface a {
    }

    /* renamed from: androidx.core.view.b$b  reason: collision with other inner class name */
    public interface C0047b {
        void onActionProviderVisibilityChanged(boolean z10);
    }

    public b(@NonNull Context context) {
        this.f4790a = context;
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return true;
    }

    @NonNull
    public abstract View c();

    @NonNull
    public View d(@NonNull MenuItem menuItem) {
        return c();
    }

    public boolean e() {
        return false;
    }

    public void f(@NonNull SubMenu subMenu) {
    }

    public boolean g() {
        return false;
    }

    public void h() {
        this.f4792c = null;
        this.f4791b = null;
    }

    public void i(a aVar) {
        this.f4791b = aVar;
    }

    public void j(C0047b bVar) {
        if (!(this.f4792c == null || bVar == null)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this ");
            sb2.append(getClass().getSimpleName());
            sb2.append(" instance while it is still in use somewhere else?");
        }
        this.f4792c = bVar;
    }
}

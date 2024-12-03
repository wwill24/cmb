package lf;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

public final class b {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final View f23631a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f23632b = false;

    /* renamed from: c  reason: collision with root package name */
    private int f23633c = 0;

    public b(a aVar) {
        this.f23631a = (View) aVar;
    }

    private void a() {
        ViewParent parent = this.f23631a.getParent();
        if (parent instanceof CoordinatorLayout) {
            ((CoordinatorLayout) parent).f(this.f23631a);
        }
    }

    public int b() {
        return this.f23633c;
    }

    public boolean c() {
        return this.f23632b;
    }

    public void d(@NonNull Bundle bundle) {
        this.f23632b = bundle.getBoolean("expanded", false);
        this.f23633c = bundle.getInt("expandedComponentIdHint", 0);
        if (this.f23632b) {
            a();
        }
    }

    @NonNull
    public Bundle e() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", this.f23632b);
        bundle.putInt("expandedComponentIdHint", this.f23633c);
        return bundle;
    }

    public void f(int i10) {
        this.f23633c = i10;
    }
}

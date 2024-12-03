package androidx.appcompat.app;

import android.window.OnBackInvokedCallback;

public final /* synthetic */ class g implements OnBackInvokedCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppCompatDelegateImpl f556a;

    public /* synthetic */ g(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.f556a = appCompatDelegateImpl;
    }

    public final void onBackInvoked() {
        this.f556a.C0();
    }
}

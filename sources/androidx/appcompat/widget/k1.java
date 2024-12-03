package androidx.appcompat.widget;

import android.window.OnBackInvokedCallback;

public final /* synthetic */ class k1 implements OnBackInvokedCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f1317a;

    public /* synthetic */ k1(Runnable runnable) {
        this.f1317a = runnable;
    }

    public final void onBackInvoked() {
        this.f1317a.run();
    }
}

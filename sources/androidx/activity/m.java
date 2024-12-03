package androidx.activity;

import android.window.OnBackInvokedCallback;
import androidx.activity.OnBackPressedDispatcher;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class m implements OnBackInvokedCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function0 f356a;

    public /* synthetic */ m(Function0 function0) {
        this.f356a = function0;
    }

    public final void onBackInvoked() {
        OnBackPressedDispatcher.a.c(this.f356a);
    }
}

package androidx.core.view;

import android.view.KeyEvent;
import android.view.View;
import android.view.View$OnUnhandledKeyEventListener;
import androidx.core.view.n0;

public final /* synthetic */ class l1 implements View$OnUnhandledKeyEventListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ n0.v f4875a;

    public /* synthetic */ l1(n0.v vVar) {
        this.f4875a = vVar;
    }

    public final boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent) {
        return this.f4875a.onUnhandledKeyEvent(view, keyEvent);
    }
}

package com.coffeemeetsbagel.suggested_history;

import android.view.View;
import b6.p;
import com.coffeemeetsbagel.view.CmbToolbar;
import gk.f;
import kotlin.jvm.internal.j;
import zb.d;

public final class SuggestedHistoryCompPresenter extends p<View> {

    /* renamed from: e  reason: collision with root package name */
    private final d f37107e;

    /* renamed from: f  reason: collision with root package name */
    private final f f37108f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuggestedHistoryCompPresenter(d dVar, b6.d<?, ?> dVar2) {
        super(dVar.getRoot());
        j.g(dVar, "binding");
        j.g(dVar2, "activity");
        this.f37107e = dVar;
        this.f37108f = b.b(new SuggestedHistoryCompPresenter$cmbToolbar$2(dVar2));
    }

    private final CmbToolbar j() {
        return (CmbToolbar) this.f37108f.getValue();
    }

    /* access modifiers changed from: protected */
    public void d() {
        super.d();
        j().d0();
    }

    public final void k(String str) {
        j.g(str, "timeLeft");
        j().setSubtitle(str);
    }
}

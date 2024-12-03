package com.coffeemeetsbagel.deactivate;

import b6.d;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.view.CmbToolbar;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class DeactivateCompPresenter$cmbToolbar$2 extends Lambda implements Function0<CmbToolbar> {
    final /* synthetic */ d<?, ?> $activity;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeactivateCompPresenter$cmbToolbar$2(d<?, ?> dVar) {
        super(0);
        this.$activity = dVar;
    }

    /* renamed from: a */
    public final CmbToolbar invoke() {
        return (CmbToolbar) this.$activity.findViewById(R.id.cmb_toolbar);
    }
}

package com.coffeemeetsbagel.deactivate;

import android.view.LayoutInflater;
import android.view.View;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbLinearLayout;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class DeactivateCompPresenter$doneActionBarView$2 extends Lambda implements Function0<CmbLinearLayout> {
    final /* synthetic */ DeactivateCompPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeactivateCompPresenter$doneActionBarView$2(DeactivateCompPresenter deactivateCompPresenter) {
        super(0);
        this.this$0 = deactivateCompPresenter;
    }

    /* renamed from: a */
    public final CmbLinearLayout invoke() {
        View inflate = LayoutInflater.from(this.this$0.f7869c.getContext()).inflate(R.layout.done_menu_item, this.this$0.n(), false);
        j.e(inflate, "null cannot be cast to non-null type com.coffeemeetsbagel.cmb_views.CmbLinearLayout");
        return (CmbLinearLayout) inflate;
    }
}

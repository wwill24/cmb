package com.coffeemeetsbagel.activities;

import android.widget.ImageView;
import com.coffeemeetsbagel.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class OutageModeActivity$displayVariables$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ImageView $outageIconView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OutageModeActivity$displayVariables$1(ImageView imageView) {
        super(0);
        this.$outageIconView = imageView;
    }

    public final void invoke() {
        this.$outageIconView.setImageResource(R.drawable.ic_outage);
    }
}

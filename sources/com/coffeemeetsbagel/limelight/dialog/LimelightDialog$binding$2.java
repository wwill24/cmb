package com.coffeemeetsbagel.limelight.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import k6.w;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class LimelightDialog$binding$2 extends Lambda implements Function0<w> {
    final /* synthetic */ Context $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LimelightDialog$binding$2(Context context) {
        super(0);
        this.$context = context;
    }

    /* renamed from: a */
    public final w invoke() {
        return w.c(LayoutInflater.from(this.$context));
    }
}

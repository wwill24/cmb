package com.withpersona.sdk2.inquiry.governmentid.capture_tips;

import android.view.LayoutInflater;
import ki.b;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class CaptureTipsBottomSheetController$binding$2 extends Lambda implements Function0<b> {
    final /* synthetic */ CaptureTipsBottomSheetController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CaptureTipsBottomSheetController$binding$2(CaptureTipsBottomSheetController captureTipsBottomSheetController) {
        super(0);
        this.this$0 = captureTipsBottomSheetController;
    }

    /* renamed from: a */
    public final b invoke() {
        b c10 = b.c(LayoutInflater.from(this.this$0.f25752a.getContext()), this.this$0.f25752a, true);
        j.f(c10, "inflate(\n      LayoutInf…ntView,\n      true,\n    )");
        return c10;
    }
}

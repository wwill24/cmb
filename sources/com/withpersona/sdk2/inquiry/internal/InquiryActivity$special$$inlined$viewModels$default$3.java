package com.withpersona.sdk2.inquiry.internal;

import androidx.activity.ComponentActivity;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import m1.a;

public final class InquiryActivity$special$$inlined$viewModels$default$3 extends Lambda implements Function0<a> {
    final /* synthetic */ Function0 $extrasProducer;
    final /* synthetic */ ComponentActivity $this_viewModels;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InquiryActivity$special$$inlined$viewModels$default$3(Function0 function0, ComponentActivity componentActivity) {
        super(0);
        this.$extrasProducer = function0;
        this.$this_viewModels = componentActivity;
    }

    /* renamed from: a */
    public final a invoke() {
        a aVar;
        Function0 function0 = this.$extrasProducer;
        if (function0 != null && (aVar = (a) function0.invoke()) != null) {
            return aVar;
        }
        a defaultViewModelCreationExtras = this.$this_viewModels.getDefaultViewModelCreationExtras();
        j.f(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
        return defaultViewModelCreationExtras;
    }
}

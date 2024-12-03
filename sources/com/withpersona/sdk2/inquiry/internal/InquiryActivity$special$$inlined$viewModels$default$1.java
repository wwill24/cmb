package com.withpersona.sdk2.inquiry.internal;

import androidx.activity.ComponentActivity;
import androidx.lifecycle.i0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

public final class InquiryActivity$special$$inlined$viewModels$default$1 extends Lambda implements Function0<i0.b> {
    final /* synthetic */ ComponentActivity $this_viewModels;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InquiryActivity$special$$inlined$viewModels$default$1(ComponentActivity componentActivity) {
        super(0);
        this.$this_viewModels = componentActivity;
    }

    /* renamed from: a */
    public final i0.b invoke() {
        i0.b defaultViewModelProviderFactory = this.$this_viewModels.getDefaultViewModelProviderFactory();
        j.f(defaultViewModelProviderFactory, "defaultViewModelProviderFactory");
        return defaultViewModelProviderFactory;
    }
}

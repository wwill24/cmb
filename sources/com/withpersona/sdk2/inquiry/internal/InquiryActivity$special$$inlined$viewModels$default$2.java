package com.withpersona.sdk2.inquiry.internal;

import androidx.activity.ComponentActivity;
import androidx.lifecycle.k0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

public final class InquiryActivity$special$$inlined$viewModels$default$2 extends Lambda implements Function0<k0> {
    final /* synthetic */ ComponentActivity $this_viewModels;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InquiryActivity$special$$inlined$viewModels$default$2(ComponentActivity componentActivity) {
        super(0);
        this.$this_viewModels = componentActivity;
    }

    /* renamed from: a */
    public final k0 invoke() {
        k0 viewModelStore = this.$this_viewModels.getViewModelStore();
        j.f(viewModelStore, "viewModelStore");
        return viewModelStore;
    }
}

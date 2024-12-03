package com.withpersona.sdk2.inquiry.shared.ui;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class Pi2NavigationBar$setState$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ NavigationUiState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Pi2NavigationBar$setState$3(NavigationUiState navigationUiState) {
        super(0);
        this.$state = navigationUiState;
    }

    public final void invoke() {
        if (this.$state.d()) {
            Function0<Unit> a10 = this.$state.a();
            if (a10 != null) {
                a10.invoke();
                return;
            }
            return;
        }
        Function0<Unit> c10 = this.$state.c();
        if (c10 != null) {
            c10.invoke();
        }
    }
}

package com.withpersona.sdk2.inquiry.ui;

import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class UiWorkflow$recurse$1 extends Lambda implements Function1<UiComponent, Unit> {
    final /* synthetic */ Function1<UiComponent, Unit> $action;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UiWorkflow$recurse$1(Function1<? super UiComponent, Unit> function1) {
        super(1);
        this.$action = function1;
    }

    public final void a(UiComponent uiComponent) {
        j.g(uiComponent, "it");
        this.$action.invoke(uiComponent);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((UiComponent) obj);
        return Unit.f32013a;
    }
}

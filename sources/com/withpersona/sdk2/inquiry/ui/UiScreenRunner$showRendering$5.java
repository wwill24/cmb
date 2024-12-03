package com.withpersona.sdk2.inquiry.ui;

import com.withpersona.sdk2.inquiry.steps.ui.a;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.ui.UiWorkflow;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class UiScreenRunner$showRendering$5 extends Lambda implements Function1<UiComponent, Unit> {
    final /* synthetic */ List<a> $componentViews;
    final /* synthetic */ UiWorkflow.c.a $rendering;
    final /* synthetic */ UiScreenRunner this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UiScreenRunner$showRendering$5(UiWorkflow.c.a aVar, UiScreenRunner uiScreenRunner, List<a> list) {
        super(1);
        this.$rendering = aVar;
        this.this$0 = uiScreenRunner;
        this.$componentViews = list;
    }

    public final void a(UiComponent uiComponent) {
        j.g(uiComponent, "it");
        this.$rendering.k().invoke(uiComponent, this.this$0.w(this.$componentViews));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((UiComponent) obj);
        return Unit.f32013a;
    }
}

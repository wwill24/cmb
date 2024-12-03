package com.withpersona.sdk2.inquiry.shared.ui;

import com.squareup.workflow1.ui.p;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.j;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;

/* synthetic */ class ScreenWithTransitionContainer$Companion$1$1$1 extends FunctionReferenceImpl implements Function2<e, p, Unit> {
    ScreenWithTransitionContainer$Companion$1$1$1(Object obj) {
        super(2, obj, ScreenWithTransitionContainer.class, DiscoverItems.Item.UPDATE_ACTION, "update(Lcom/withpersona/sdk2/inquiry/shared/ui/ScreenWithTransition;Lcom/squareup/workflow1/ui/ViewEnvironment;)V", 0);
    }

    public final void c(e eVar, p pVar) {
        j.g(eVar, "p0");
        j.g(pVar, "p1");
        ((ScreenWithTransitionContainer) this.receiver).c(eVar, pVar);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        c((e) obj, (p) obj2);
        return Unit.f32013a;
    }
}

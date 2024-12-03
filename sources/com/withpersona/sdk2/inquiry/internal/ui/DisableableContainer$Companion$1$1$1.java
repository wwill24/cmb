package com.withpersona.sdk2.inquiry.internal.ui;

import com.squareup.workflow1.ui.p;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.j;
import ni.b;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;

/* synthetic */ class DisableableContainer$Companion$1$1$1 extends FunctionReferenceImpl implements Function2<b, p, Unit> {
    DisableableContainer$Companion$1$1$1(Object obj) {
        super(2, obj, DisableableContainer.class, DiscoverItems.Item.UPDATE_ACTION, "update(Lcom/withpersona/sdk2/inquiry/internal/ui/DisableableScreen;Lcom/squareup/workflow1/ui/ViewEnvironment;)V", 0);
    }

    public final void c(b bVar, p pVar) {
        j.g(bVar, "p0");
        j.g(pVar, "p1");
        ((DisableableContainer) this.receiver).d(bVar, pVar);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        c((b) obj, (p) obj2);
        return Unit.f32013a;
    }
}

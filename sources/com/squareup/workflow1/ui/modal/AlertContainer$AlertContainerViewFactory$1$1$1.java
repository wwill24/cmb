package com.squareup.workflow1.ui.modal;

import com.squareup.workflow1.ui.p;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.j;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* synthetic */ class AlertContainer$AlertContainerViewFactory$1$1$1 extends FunctionReferenceImpl implements Function2<d<?, ? extends AlertScreen>, p, Unit> {
    AlertContainer$AlertContainerViewFactory$1$1$1(Object obj) {
        super(2, obj, AlertContainer.class, DiscoverItems.Item.UPDATE_ACTION, "update(Lcom/squareup/workflow1/ui/modal/HasModals;Lcom/squareup/workflow1/ui/ViewEnvironment;)V", 0);
    }

    public final void c(d<?, AlertScreen> dVar, p pVar) {
        j.g(dVar, "p0");
        j.g(pVar, "p1");
        ((AlertContainer) this.receiver).c(dVar, pVar);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        c((d) obj, (p) obj2);
        return Unit.f32013a;
    }
}

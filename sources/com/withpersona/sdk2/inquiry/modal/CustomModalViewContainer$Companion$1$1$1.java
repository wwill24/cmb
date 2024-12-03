package com.withpersona.sdk2.inquiry.modal;

import com.squareup.workflow1.ui.modal.d;
import com.squareup.workflow1.ui.p;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.j;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;

/* synthetic */ class CustomModalViewContainer$Companion$1$1$1 extends FunctionReferenceImpl implements Function2<d<?, ? extends Object>, p, Unit> {
    CustomModalViewContainer$Companion$1$1$1(Object obj) {
        super(2, obj, CustomModalViewContainer.class, DiscoverItems.Item.UPDATE_ACTION, "update(Lcom/squareup/workflow1/ui/modal/HasModals;Lcom/squareup/workflow1/ui/ViewEnvironment;)V", 0);
    }

    public final void c(d<?, ? extends Object> dVar, p pVar) {
        j.g(dVar, "p0");
        j.g(pVar, "p1");
        ((CustomModalViewContainer) this.receiver).c(dVar, pVar);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        c((d) obj, (p) obj2);
        return Unit.f32013a;
    }
}

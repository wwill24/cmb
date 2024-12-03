package com.squareup.workflow1.ui.backstack;

import com.squareup.workflow1.ui.p;
import di.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.j;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* synthetic */ class BackStackContainer$Companion$1$1$1 extends FunctionReferenceImpl implements Function2<b<?>, p, Unit> {
    BackStackContainer$Companion$1$1$1(Object obj) {
        super(2, obj, BackStackContainer.class, DiscoverItems.Item.UPDATE_ACTION, "update(Lcom/squareup/workflow1/ui/backstack/BackStackScreen;Lcom/squareup/workflow1/ui/ViewEnvironment;)V", 0);
    }

    public final void c(b<?> bVar, p pVar) {
        j.g(bVar, "p0");
        j.g(pVar, "p1");
        ((BackStackContainer) this.receiver).c(bVar, pVar);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        c((b) obj, (p) obj2);
        return Unit.f32013a;
    }
}

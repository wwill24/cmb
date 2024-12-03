package com.coffeemeetsbagel.feature.chat.header;

import com.coffeemeetsbagel.models.Bagel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.j;

/* synthetic */ class ChatHeaderInteractor$didBecomeActive$4 extends FunctionReferenceImpl implements Function1<Bagel, Unit> {
    ChatHeaderInteractor$didBecomeActive$4(Object obj) {
        super(1, obj, ChatHeaderInteractor.class, "setupHeadline", "setupHeadline(Lcom/coffeemeetsbagel/models/Bagel;)V", 0);
    }

    public final void c(Bagel bagel) {
        j.g(bagel, "p0");
        ((ChatHeaderInteractor) this.receiver).a2(bagel);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        c((Bagel) obj);
        return Unit.f32013a;
    }
}

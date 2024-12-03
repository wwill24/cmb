package com.coffeemeetsbagel.feature.chat.header;

import com.coffeemeetsbagel.models.Bagel;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class ChatHeaderInteractor$didBecomeActive$3 extends Lambda implements Function1<Bagel, Boolean> {
    final /* synthetic */ ChatHeaderInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChatHeaderInteractor$didBecomeActive$3(ChatHeaderInteractor chatHeaderInteractor) {
        super(1);
        this.this$0 = chatHeaderInteractor;
    }

    /* renamed from: a */
    public final Boolean invoke(Bagel bagel) {
        j.g(bagel, "freshBagel");
        return Boolean.valueOf(j.b(this.this$0.f12840f, bagel.getId()));
    }
}

package com.coffeemeetsbagel.feature.chat.header;

import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.constants.Extra;
import com.uber.autodispose.a;
import com.uber.autodispose.p;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class ChatHeaderInteractor$didBecomeActive$2 extends Lambda implements Function1<Bagel, Unit> {
    final /* synthetic */ ChatHeaderInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChatHeaderInteractor$didBecomeActive$2(ChatHeaderInteractor chatHeaderInteractor) {
        super(1);
        this.this$0 = chatHeaderInteractor;
    }

    /* access modifiers changed from: private */
    public static final void d(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    public final void c(final Bagel bagel) {
        this.this$0.f12843j = bagel.getProfile();
        ChatHeaderInteractor chatHeaderInteractor = this.this$0;
        j.f(bagel, Extra.BAGEL);
        chatHeaderInteractor.b2(bagel);
        this.this$0.Z1(bagel);
        final ChatHeaderInteractor chatHeaderInteractor2 = this.this$0;
        ((p) ((j) this.this$0.f7875e).l().g(a.a(this.this$0))).c(new g(new Function1<Unit, Unit>() {
            public final void a(Unit unit) {
                Bagel bagel = bagel;
                j.f(bagel, Extra.BAGEL);
                ((k) chatHeaderInteractor2.B1()).m(bagel);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((Unit) obj);
                return Unit.f32013a;
            }
        }));
        this.this$0.a2(bagel);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        c((Bagel) obj);
        return Unit.f32013a;
    }
}

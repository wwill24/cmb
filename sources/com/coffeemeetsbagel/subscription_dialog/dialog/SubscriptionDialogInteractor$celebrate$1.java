package com.coffeemeetsbagel.subscription_dialog.dialog;

import com.coffeemeetsbagel.photo.Photo;
import com.coffeemeetsbagel.profile.l;
import ja.b;
import java.util.List;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class SubscriptionDialogInteractor$celebrate$1 extends Lambda implements Function1<Triple<? extends b, ? extends l, ? extends List<? extends Photo>>, Unit> {
    final /* synthetic */ SubscriptionDialogInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubscriptionDialogInteractor$celebrate$1(SubscriptionDialogInteractor subscriptionDialogInteractor) {
        super(1);
        this.this$0 = subscriptionDialogInteractor;
    }

    public final void a(Triple<b, l, ? extends List<Photo>> triple) {
        ((v) this.this$0.f7875e).q(triple.b().g());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Triple) obj);
        return Unit.f32013a;
    }
}

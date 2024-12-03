package com.coffeemeetsbagel.today_view.today_bagel;

import com.coffeemeetsbagel.models.Price;
import com.coffeemeetsbagel.utils.model.Optional;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import vb.a;

final class SuggestedMatchContainerInteractor$startOutOfBeansFlow$1 extends Lambda implements Function1<Optional<a>, Unit> {
    final /* synthetic */ Price $price;
    final /* synthetic */ SuggestedMatchContainerInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuggestedMatchContainerInteractor$startOutOfBeansFlow$1(SuggestedMatchContainerInteractor suggestedMatchContainerInteractor, Price price) {
        super(1);
        this.this$0 = suggestedMatchContainerInteractor;
        this.$price = price;
    }

    public final void a(Optional<a> optional) {
        if (optional.d()) {
            this.this$0.q4();
            ((a1) this.this$0.f7875e).P();
            return;
        }
        SuggestedMatchContainerInteractor suggestedMatchContainerInteractor = this.this$0;
        Price price = this.$price;
        j.d(price);
        suggestedMatchContainerInteractor.c4(true, price);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Optional) obj);
        return Unit.f32013a;
    }
}

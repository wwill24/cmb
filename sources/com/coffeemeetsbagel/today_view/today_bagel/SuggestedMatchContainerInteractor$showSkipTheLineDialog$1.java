package com.coffeemeetsbagel.today_view.today_bagel;

import b6.p;
import com.coffeemeetsbagel.models.Price;
import com.coffeemeetsbagel.store.domain.BenefitKeys;
import com.coffeemeetsbagel.today_view.today_bagel.SuggestedMatchContainerInteractor;
import com.coffeemeetsbagel.utils.model.Optional;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import vb.a;

final class SuggestedMatchContainerInteractor$showSkipTheLineDialog$1 extends Lambda implements Function1<Optional<a>, Unit> {
    final /* synthetic */ SuggestedMatchContainerInteractor.i $clickListener;
    final /* synthetic */ Price $price;
    final /* synthetic */ SuggestedMatchContainerInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuggestedMatchContainerInteractor$showSkipTheLineDialog$1(SuggestedMatchContainerInteractor suggestedMatchContainerInteractor, Price price, SuggestedMatchContainerInteractor.i iVar) {
        super(1);
        this.this$0 = suggestedMatchContainerInteractor;
        this.$price = price;
        this.$clickListener = iVar;
    }

    public final void a(Optional<a> optional) {
        boolean z10;
        this.this$0.Z3(1);
        boolean z11 = false;
        if (!optional.d() || !optional.c().h(BenefitKeys.PAID_LIKE)) {
            z10 = false;
        } else {
            z10 = true;
        }
        Price price = this.$price;
        j.d(price);
        if (price.getFreeItemCount() == 0 && !z10) {
            z11 = true;
        }
        int beanCost = this.$price.getBeanCost(1);
        p o22 = this.this$0.f7875e;
        j.d(o22);
        SuggestedMatchContainerInteractor.i iVar = this.$clickListener;
        Boolean valueOf = Boolean.valueOf(z11);
        int risingBagelCount = this.this$0.f37389f.getRisingBagelCount();
        final SuggestedMatchContainerInteractor suggestedMatchContainerInteractor = this.this$0;
        ((a1) o22).S(iVar, valueOf, risingBagelCount, beanCost, new Function0<Unit>() {
            public final void invoke() {
                suggestedMatchContainerInteractor.m3();
            }
        });
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Optional) obj);
        return Unit.f32013a;
    }
}

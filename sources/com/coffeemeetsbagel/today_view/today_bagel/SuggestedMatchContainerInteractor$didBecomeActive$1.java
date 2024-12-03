package com.coffeemeetsbagel.today_view.today_bagel;

import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.models.util.DateUtils;
import com.coffeemeetsbagel.utils.model.Optional;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class SuggestedMatchContainerInteractor$didBecomeActive$1 extends Lambda implements Function1<Optional<Integer>, Unit> {
    final /* synthetic */ SuggestedMatchContainerInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuggestedMatchContainerInteractor$didBecomeActive$1(SuggestedMatchContainerInteractor suggestedMatchContainerInteractor) {
        super(1);
        this.this$0 = suggestedMatchContainerInteractor;
    }

    public final void a(Optional<Integer> optional) {
        Integer c10;
        if (optional.d() && (c10 = optional.c()) != null && c10.intValue() == R.id.bottom_nav_item_bagels) {
            this.this$0.d4();
            SuggestedMatchContainerInteractor suggestedMatchContainerInteractor = this.this$0;
            suggestedMatchContainerInteractor.v3(suggestedMatchContainerInteractor.f37389f);
            this.this$0.c3().k(DateUtils.getMillisFromUtc(this.this$0.f37389f.getEndDate()));
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Optional) obj);
        return Unit.f32013a;
    }
}

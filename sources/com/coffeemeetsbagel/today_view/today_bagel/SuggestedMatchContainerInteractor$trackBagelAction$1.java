package com.coffeemeetsbagel.today_view.today_bagel;

import com.coffeemeetsbagel.models.ModelDeeplinkData;
import com.coffeemeetsbagel.utils.model.Optional;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import vb.a;

final class SuggestedMatchContainerInteractor$trackBagelAction$1 extends Lambda implements Function1<Optional<a>, Unit> {
    final /* synthetic */ String $bagelAction;
    final /* synthetic */ SuggestedMatchContainerInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuggestedMatchContainerInteractor$trackBagelAction$1(SuggestedMatchContainerInteractor suggestedMatchContainerInteractor, String str) {
        super(1);
        this.this$0 = suggestedMatchContainerInteractor;
        this.$bagelAction = str;
    }

    public final void a(Optional<a> optional) {
        this.this$0.Y2().a(optional.d(), this.this$0.f37389f, this.$bagelAction, ModelDeeplinkData.VALUE_PAGE_SUGGESTED);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Optional) obj);
        return Unit.f32013a;
    }
}

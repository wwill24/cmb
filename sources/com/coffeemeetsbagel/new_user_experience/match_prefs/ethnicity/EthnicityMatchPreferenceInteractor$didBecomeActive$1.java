package com.coffeemeetsbagel.new_user_experience.match_prefs.ethnicity;

import com.coffeemeetsbagel.models.Resource;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class EthnicityMatchPreferenceInteractor$didBecomeActive$1 extends Lambda implements Function1<List<? extends Resource>, Unit> {
    final /* synthetic */ List<String> $selected;
    final /* synthetic */ EthnicityMatchPreferenceInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EthnicityMatchPreferenceInteractor$didBecomeActive$1(EthnicityMatchPreferenceInteractor ethnicityMatchPreferenceInteractor, List<String> list) {
        super(1);
        this.this$0 = ethnicityMatchPreferenceInteractor;
        this.$selected = list;
    }

    public final void a(List<Resource> list) {
        ((k) this.this$0.f7875e).n(list, this.$selected);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((List) obj);
        return Unit.f32013a;
    }
}

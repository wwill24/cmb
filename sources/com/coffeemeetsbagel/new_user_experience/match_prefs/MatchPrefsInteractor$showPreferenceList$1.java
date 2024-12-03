package com.coffeemeetsbagel.new_user_experience.match_prefs;

import com.coffeemeetsbagel.match_prefs.GetMatchPreferencesUseCase;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class MatchPrefsInteractor$showPreferenceList$1 extends Lambda implements Function1<GetMatchPreferencesUseCase.a, Unit> {
    final /* synthetic */ MatchPrefsInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MatchPrefsInteractor$showPreferenceList$1(MatchPrefsInteractor matchPrefsInteractor) {
        super(1);
        this.this$0 = matchPrefsInteractor;
    }

    public final void a(GetMatchPreferencesUseCase.a aVar) {
        ((h0) this.this$0.B1()).p(CollectionsKt___CollectionsKt.h0(aVar.a(), aVar.c()));
        ((MatchPrefsPresenter) this.this$0.f7875e).A(aVar.a(), aVar.d(), this.this$0.X1().a("DealbreakersV2.VariantA.Android"), this.this$0.X1().a("ProfileMigration.Enabled.Android"));
        ((MatchPrefsPresenter) this.this$0.f7875e).B(aVar.c(), aVar.d(), aVar.b(), this.this$0.X1().a("DealbreakersV2.VariantA.Android"));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((GetMatchPreferencesUseCase.a) obj);
        return Unit.f32013a;
    }
}

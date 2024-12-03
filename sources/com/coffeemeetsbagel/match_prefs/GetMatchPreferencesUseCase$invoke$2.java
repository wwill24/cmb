package com.coffeemeetsbagel.match_prefs;

import com.coffeemeetsbagel.match_prefs.GetMatchPreferencesUseCase;
import com.coffeemeetsbagel.models.entities.CapabilityType;
import com.coffeemeetsbagel.models.enums.QuestionGroupType;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import ja.b;
import java.util.List;
import java.util.Optional;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import pk.n;
import qj.h;
import rn.a;

final class GetMatchPreferencesUseCase$invoke$2 extends Lambda implements Function1<b, a<? extends GetMatchPreferencesUseCase.a>> {
    final /* synthetic */ boolean $profileMigrationEnabled;
    final /* synthetic */ GetMatchPreferencesUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GetMatchPreferencesUseCase$invoke$2(GetMatchPreferencesUseCase getMatchPreferencesUseCase, boolean z10) {
        super(1);
        this.this$0 = getMatchPreferencesUseCase;
        this.$profileMigrationEnabled = z10;
    }

    /* access modifiers changed from: private */
    public static final GetMatchPreferencesUseCase.a d(n nVar, Object obj, Object obj2, Object obj3) {
        j.g(nVar, "$tmp0");
        return (GetMatchPreferencesUseCase.a) nVar.l(obj, obj2, obj3);
    }

    /* renamed from: c */
    public final a<? extends GetMatchPreferencesUseCase.a> invoke(final b bVar) {
        j.g(bVar, "user");
        h<Boolean> v10 = this.this$0.f34530d.c(CapabilityType.PREMIUM_PREFERENCES).v();
        h y10 = QuestionRepository.y(this.this$0.f34528b, QuestionGroupType.MATCH_PREFERENCES, bVar.u(), false, false, 8, (Object) null);
        h e10 = this.this$0.j(bVar.u(), QuestionGroupType.FREE_PREFERENCES, this.$profileMigrationEnabled);
        final boolean z10 = this.$profileMigrationEnabled;
        final GetMatchPreferencesUseCase getMatchPreferencesUseCase = this.this$0;
        return h.m(v10, y10, e10, new d(new n<Boolean, ab.a, Optional<ab.a>, GetMatchPreferencesUseCase.a>() {
            /* renamed from: a */
            public final GetMatchPreferencesUseCase.a l(Boolean bool, ab.a aVar, Optional<ab.a> optional) {
                List list;
                j.g(bool, "hasPremium");
                j.g(aVar, "premiumGroup");
                j.g(optional, "freeGroup");
                f fVar = new f(MatchPreference$Type.SECTION_HEADER_BASIC, (QuestionWAnswers) null, false, 6, (DefaultConstructorMarker) null);
                if (!z10 || !optional.isPresent()) {
                    GetMatchPreferencesUseCase getMatchPreferencesUseCase = getMatchPreferencesUseCase;
                    b bVar = bVar;
                    j.f(bVar, "user");
                    list = getMatchPreferencesUseCase.l(bVar);
                } else {
                    GetMatchPreferencesUseCase getMatchPreferencesUseCase2 = getMatchPreferencesUseCase;
                    ab.a aVar2 = optional.get();
                    j.f(aVar2, "freeGroup.get()");
                    list = getMatchPreferencesUseCase2.p(aVar2, bVar.x());
                }
                f fVar2 = new f(MatchPreference$Type.SECTION_HEADER_PREMIUM, (QuestionWAnswers) null, false, 6, (DefaultConstructorMarker) null);
                List i10 = getMatchPreferencesUseCase.q(aVar, bVar.x(), bool.booleanValue());
                b bVar2 = bVar;
                j.f(bVar2, "user");
                return new GetMatchPreferencesUseCase.a(bVar2, CollectionsKt___CollectionsKt.h0(p.e(fVar), list), CollectionsKt___CollectionsKt.h0(p.e(fVar2), i10), !bool.booleanValue());
            }
        }));
    }
}

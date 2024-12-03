package com.coffeemeetsbagel.new_user_experience.match_prefs.age;

import com.coffeemeetsbagel.models.entities.GenderType;
import com.coffeemeetsbagel.new_user_experience.match_prefs.age.LoadAgePreferenceUseCase;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import ja.b;
import java.util.Optional;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import rk.a;

final class LoadAgePreferenceUseCase$loadAnswer$2 extends Lambda implements Function1<Pair<? extends Optional<QuestionWAnswers>, ? extends Optional<QuestionWAnswers>>, LoadAgePreferenceUseCase.a> {
    final /* synthetic */ b $user;
    final /* synthetic */ LoadAgePreferenceUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LoadAgePreferenceUseCase$loadAnswer$2(LoadAgePreferenceUseCase loadAgePreferenceUseCase, b bVar) {
        super(1);
        this.this$0 = loadAgePreferenceUseCase;
        this.$user = bVar;
    }

    /* renamed from: a */
    public final LoadAgePreferenceUseCase.a invoke(Pair<Optional<QuestionWAnswers>, Optional<QuestionWAnswers>> pair) {
        j.g(pair, "pair");
        LoadAgePreferenceUseCase loadAgePreferenceUseCase = this.this$0;
        Optional<QuestionWAnswers> c10 = pair.c();
        j.f(c10, "pair.first");
        LoadAgePreferenceUseCase.a o10 = loadAgePreferenceUseCase.B((QuestionWAnswers) a.a(c10), this.this$0.A(this.$user));
        if (o10 != null) {
            return o10;
        }
        LoadAgePreferenceUseCase loadAgePreferenceUseCase2 = this.this$0;
        Optional<QuestionWAnswers> d10 = pair.d();
        j.f(d10, "pair.second");
        GenderType p10 = loadAgePreferenceUseCase2.C((QuestionWAnswers) a.a(d10));
        LoadAgePreferenceUseCase loadAgePreferenceUseCase3 = this.this$0;
        int f10 = loadAgePreferenceUseCase3.r(p10, loadAgePreferenceUseCase3.A(this.$user));
        LoadAgePreferenceUseCase loadAgePreferenceUseCase4 = this.this$0;
        int g10 = loadAgePreferenceUseCase4.s(p10, loadAgePreferenceUseCase4.A(this.$user));
        LoadAgePreferenceUseCase loadAgePreferenceUseCase5 = this.this$0;
        return new LoadAgePreferenceUseCase.a(f10, g10, false, loadAgePreferenceUseCase5.z(loadAgePreferenceUseCase5.f35169f), 4, (DefaultConstructorMarker) null);
    }
}

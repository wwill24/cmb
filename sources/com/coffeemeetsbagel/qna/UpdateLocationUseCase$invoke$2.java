package com.coffeemeetsbagel.qna;

import com.coffeemeetsbagel.models.dto.Location;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import java.util.List;
import java.util.Optional;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.b0;

final class UpdateLocationUseCase$invoke$2 extends Lambda implements Function1<Pair<? extends String, ? extends Optional<QuestionWAnswers>>, b0<? extends String>> {
    final /* synthetic */ String $city;
    final /* synthetic */ String $country;
    final /* synthetic */ Float $latitude;
    final /* synthetic */ Float $longitude;
    final /* synthetic */ String $state;
    final /* synthetic */ String $zip;
    final /* synthetic */ UpdateLocationUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UpdateLocationUseCase$invoke$2(String str, String str2, String str3, String str4, Float f10, Float f11, UpdateLocationUseCase updateLocationUseCase) {
        super(1);
        this.$city = str;
        this.$state = str2;
        this.$country = str3;
        this.$zip = str4;
        this.$latitude = f10;
        this.$longitude = f11;
        this.this$0 = updateLocationUseCase;
    }

    /* renamed from: a */
    public final b0<? extends String> invoke(Pair<String, Optional<QuestionWAnswers>> pair) {
        j.g(pair, "pair");
        if (pair.d().isPresent()) {
            return QuestionRepository.V(this.this$0.f36225b, pair.c(), (List) null, (String) null, (Integer) null, (Float) null, ((QuestionWAnswers) pair.d().get()).e().getId(), ((QuestionWAnswers) pair.d().get()).e().getGroup().getQuestionGroupApiString(), (Float) null, (Float) null, false, new Location(this.$city, this.$state, this.$country, this.$zip, this.$latitude, this.$longitude), 926, (Object) null).J(pair.c());
        }
        throw new IllegalStateException("Missing profile_location: need info to update.");
    }
}

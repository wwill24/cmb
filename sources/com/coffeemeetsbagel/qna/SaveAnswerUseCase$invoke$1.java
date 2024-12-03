package com.coffeemeetsbagel.qna;

import com.coffeemeetsbagel.models.dto.Location;
import com.leanplum.internal.Constants;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.f;

final class SaveAnswerUseCase$invoke$1 extends Lambda implements Function1<String, f> {
    final /* synthetic */ Float $floatValue;
    final /* synthetic */ String $group;
    final /* synthetic */ Integer $integerValue;
    final /* synthetic */ boolean $isDealbreaker;
    final /* synthetic */ Location $location;
    final /* synthetic */ Float $maxValue;
    final /* synthetic */ Float $minValue;
    final /* synthetic */ List<String> $optionIds;
    final /* synthetic */ String $questionId;
    final /* synthetic */ String $textValue;
    final /* synthetic */ SaveAnswerUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SaveAnswerUseCase$invoke$1(SaveAnswerUseCase saveAnswerUseCase, List<String> list, String str, Integer num, Float f10, String str2, String str3, Float f11, Float f12, boolean z10, Location location) {
        super(1);
        this.this$0 = saveAnswerUseCase;
        this.$optionIds = list;
        this.$textValue = str;
        this.$integerValue = num;
        this.$floatValue = f10;
        this.$questionId = str2;
        this.$group = str3;
        this.$minValue = f11;
        this.$maxValue = f12;
        this.$isDealbreaker = z10;
        this.$location = location;
    }

    /* renamed from: a */
    public final f invoke(String str) {
        j.g(str, Constants.Params.USER_ID);
        return this.this$0.f36223b.U(str, this.$optionIds, this.$textValue, this.$integerValue, this.$floatValue, this.$questionId, this.$group, this.$minValue, this.$maxValue, this.$isDealbreaker, this.$location);
    }
}

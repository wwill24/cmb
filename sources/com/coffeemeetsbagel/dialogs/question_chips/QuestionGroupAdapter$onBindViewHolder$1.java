package com.coffeemeetsbagel.dialogs.question_chips;

import com.coffeemeetsbagel.models.dto.Answer;
import com.coffeemeetsbagel.models.dto.Option;
import java.util.Map;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

final class QuestionGroupAdapter$onBindViewHolder$1 extends Lambda implements Function2<Option, Option, Integer> {
    final /* synthetic */ Map<String, Answer> $selectedOptionsMap;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    QuestionGroupAdapter$onBindViewHolder$1(Map<String, Answer> map) {
        super(2);
        this.$selectedOptionsMap = map;
    }

    /* renamed from: a */
    public final Integer invoke(Option option, Option option2) {
        int i10;
        if (this.$selectedOptionsMap.containsKey(option.getId())) {
            i10 = -1;
        } else if (this.$selectedOptionsMap.containsKey(option2.getId())) {
            i10 = 1;
        } else {
            i10 = 0;
        }
        return Integer.valueOf(i10);
    }
}

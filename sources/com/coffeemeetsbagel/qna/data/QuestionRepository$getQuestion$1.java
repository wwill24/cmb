package com.coffeemeetsbagel.qna.data;

import com.coffeemeetsbagel.models.dto.Question;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import com.coffeemeetsbagel.qna.r;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import za.b;
import za.c;
import za.i;

final class QuestionRepository$getQuestion$1 extends Lambda implements Function1<Map<i, ? extends List<? extends b>>, Optional<QuestionWAnswers>> {

    /* renamed from: a  reason: collision with root package name */
    public static final QuestionRepository$getQuestion$1 f36243a = new QuestionRepository$getQuestion$1();

    QuestionRepository$getQuestion$1() {
        super(1);
    }

    /* renamed from: a */
    public final Optional<QuestionWAnswers> invoke(Map<i, ? extends List<b>> map) {
        j.g(map, "map");
        if (map.isEmpty()) {
            return Optional.empty();
        }
        Map.Entry entry = (Map.Entry) CollectionsKt___CollectionsKt.M(map.entrySet());
        List<c> a10 = ((i) entry.getKey()).a();
        ArrayList arrayList = new ArrayList(r.t(a10, 10));
        for (c g10 : a10) {
            arrayList.add(r.g(g10, ((i) entry.getKey()).b().b()));
        }
        Question i10 = r.i(((i) entry.getKey()).b(), arrayList);
        Iterable<b> iterable = (Iterable) entry.getValue();
        ArrayList arrayList2 = new ArrayList(r.t(iterable, 10));
        for (b e10 : iterable) {
            arrayList2.add(r.e(e10));
        }
        return Optional.of(new QuestionWAnswers(i10, arrayList2));
    }
}

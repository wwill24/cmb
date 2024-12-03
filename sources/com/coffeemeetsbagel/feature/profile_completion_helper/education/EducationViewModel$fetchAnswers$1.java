package com.coffeemeetsbagel.feature.profile_completion_helper.education;

import ab.a;
import com.coffeemeetsbagel.models.enums.ProfileQuestion;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class EducationViewModel$fetchAnswers$1 extends Lambda implements Function2<a, a, Pair<? extends List<? extends QuestionWAnswers>, ? extends List<? extends QuestionWAnswers>>> {

    /* renamed from: a  reason: collision with root package name */
    public static final EducationViewModel$fetchAnswers$1 f13220a = new EducationViewModel$fetchAnswers$1();

    EducationViewModel$fetchAnswers$1() {
        super(2);
    }

    /* renamed from: a */
    public final Pair<List<QuestionWAnswers>, List<QuestionWAnswers>> invoke(a aVar, a aVar2) {
        boolean z10;
        j.g(aVar, "one");
        j.g(aVar2, "two");
        List h02 = CollectionsKt___CollectionsKt.h0(aVar.b(), aVar2.b());
        ArrayList arrayList = new ArrayList();
        Iterator it = h02.iterator();
        while (true) {
            boolean z11 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            QuestionWAnswers questionWAnswers = (QuestionWAnswers) next;
            if (j.b(questionWAnswers.e().getName(), ProfileQuestion.SCHOOL_ONE.getApiKey()) || j.b(questionWAnswers.e().getName(), ProfileQuestion.SCHOOL_TWO.getApiKey())) {
                z11 = true;
            }
            if (z11) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object next2 : h02) {
            QuestionWAnswers questionWAnswers2 = (QuestionWAnswers) next2;
            if (j.b(questionWAnswers2.e().getName(), ProfileQuestion.DEGREE_ONE.getApiKey()) || j.b(questionWAnswers2.e().getName(), ProfileQuestion.DEGREE_TWO.getApiKey())) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                arrayList2.add(next2);
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }
}

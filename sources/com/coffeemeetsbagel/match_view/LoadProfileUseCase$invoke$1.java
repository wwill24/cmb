package com.coffeemeetsbagel.match_view;

import com.coffeemeetsbagel.match_view.LoadProfileUseCase;
import com.coffeemeetsbagel.models.Resource;
import com.coffeemeetsbagel.photo.Photo;
import com.coffeemeetsbagel.profile.l;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import ja.b;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import pk.t;

final class LoadProfileUseCase$invoke$1 extends Lambda implements t<b, Pair<? extends l, ? extends List<? extends Photo>>, List<? extends QuestionWAnswers>, List<? extends QuestionWAnswers>, List<? extends QuestionWAnswers>, List<? extends QuestionWAnswers>, List<? extends QuestionWAnswers>, List<? extends QuestionWAnswers>, List<? extends Resource>, LoadProfileUseCase.a> {

    /* renamed from: a  reason: collision with root package name */
    public static final LoadProfileUseCase$invoke$1 f34619a = new LoadProfileUseCase$invoke$1();

    LoadProfileUseCase$invoke$1() {
        super(9);
    }

    /* renamed from: a */
    public final LoadProfileUseCase.a t(b bVar, Pair<l, ? extends List<Photo>> pair, List<QuestionWAnswers> list, List<QuestionWAnswers> list2, List<QuestionWAnswers> list3, List<QuestionWAnswers> list4, List<QuestionWAnswers> list5, List<QuestionWAnswers> list6, List<Resource> list7) {
        j.g(bVar, "user");
        Pair<l, ? extends List<Photo>> pair2 = pair;
        j.g(pair, "profile");
        j.g(list, "original");
        List<QuestionWAnswers> list8 = list2;
        j.g(list8, "eduOne");
        List<QuestionWAnswers> list9 = list3;
        j.g(list9, "eduTwo");
        List<QuestionWAnswers> list10 = list4;
        j.g(list10, "prompts");
        List<QuestionWAnswers> list11 = list5;
        j.g(list11, "coreProfile");
        List<QuestionWAnswers> list12 = list6;
        j.g(list12, "identity");
        List<Resource> list13 = list7;
        j.g(list13, "degrees");
        return new LoadProfileUseCase.a(bVar, pair.c(), (List) pair.d(), list, list8, list9, list10, list11, list12, list13);
    }
}

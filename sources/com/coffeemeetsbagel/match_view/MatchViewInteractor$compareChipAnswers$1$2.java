package com.coffeemeetsbagel.match_view;

import com.coffeemeetsbagel.models.enums.QuestionGroupType;
import com.coffeemeetsbagel.profile.m;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class MatchViewInteractor$compareChipAnswers$1$2 extends Lambda implements Function1<Pair<? extends List<? extends String>, ? extends List<? extends String>>, Unit> {
    final /* synthetic */ String $displayProfileId;
    final /* synthetic */ QuestionGroupType $questionType;
    final /* synthetic */ String $selfProfileId;
    final /* synthetic */ MatchViewInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MatchViewInteractor$compareChipAnswers$1$2(String str, String str2, MatchViewInteractor matchViewInteractor, QuestionGroupType questionGroupType) {
        super(1);
        this.$displayProfileId = str;
        this.$selfProfileId = str2;
        this.this$0 = matchViewInteractor;
        this.$questionType = questionGroupType;
    }

    public final void a(Pair<? extends List<String>, ? extends List<String>> pair) {
        Object c10 = pair.c();
        j.f(c10, "pair.first");
        List<String> list = (List) c10;
        Object d10 = pair.d();
        j.f(d10, "pair.second");
        List<String> list2 = (List) d10;
        if (j.b(this.$displayProfileId, this.$selfProfileId)) {
            MatchViewInteractor matchViewInteractor = this.this$0;
            ArrayList arrayList = new ArrayList(r.t(list2, 10));
            for (String mVar : list2) {
                arrayList.add(new m(mVar, false));
            }
            matchViewInteractor.R2(arrayList, this.$questionType);
            return;
        }
        MatchViewInteractor matchViewInteractor2 = this.this$0;
        ArrayList arrayList2 = new ArrayList(r.t(list, 10));
        for (String str : list) {
            arrayList2.add(new m(str, list2.contains(str)));
        }
        matchViewInteractor2.R2(arrayList2, this.$questionType);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Pair) obj);
        return Unit.f32013a;
    }
}

package com.coffeemeetsbagel.likes_you;

import com.coffeemeetsbagel.likesyou.db.LikesYouGroupWithCards;
import ea.a;
import ea.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class LikesYouViewModel$trackLimelight$2 extends Lambda implements Function1<List<? extends LikesYouGroupWithCards>, Pair<? extends List<? extends a>, ? extends List<? extends b>>> {

    /* renamed from: a  reason: collision with root package name */
    public static final LikesYouViewModel$trackLimelight$2 f34164a = new LikesYouViewModel$trackLimelight$2();

    LikesYouViewModel$trackLimelight$2() {
        super(1);
    }

    /* renamed from: a */
    public final Pair<List<a>, List<b>> invoke(List<LikesYouGroupWithCards> list) {
        j.g(list, "groups");
        ArrayList arrayList = new ArrayList(r.t(list, 10));
        for (LikesYouGroupWithCards likesYouGroupWithCards : list) {
            arrayList.add(new a(String.valueOf(likesYouGroupWithCards.getGroup().getCount()), likesYouGroupWithCards.getGroup().getName()));
        }
        ArrayList arrayList2 = new ArrayList(r.t(list, 10));
        for (LikesYouGroupWithCards likesYouGroupWithCards2 : list) {
            arrayList2.add(new b(String.valueOf(likesYouGroupWithCards2.getCards().size() + likesYouGroupWithCards2.getPaywallCards().size()), likesYouGroupWithCards2.getGroup().getName()));
        }
        return new Pair<>(arrayList, arrayList2);
    }
}

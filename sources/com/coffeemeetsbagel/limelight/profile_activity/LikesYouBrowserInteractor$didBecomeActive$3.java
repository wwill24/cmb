package com.coffeemeetsbagel.limelight.profile_activity;

import b6.u;
import com.coffeemeetsbagel.likes_you.a;
import com.coffeemeetsbagel.likesyou.db.LikesYouGroupWithCards;
import com.coffeemeetsbagel.match.MatchIdAttribution;
import com.coffeemeetsbagel.models.entities.LikesYouCardEntity;
import com.coffeemeetsbagel.models.enums.PurchaseAttribution;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class LikesYouBrowserInteractor$didBecomeActive$3 extends Lambda implements Function1<LikesYouGroupWithCards, Unit> {
    final /* synthetic */ LikesYouBrowserInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LikesYouBrowserInteractor$didBecomeActive$3(LikesYouBrowserInteractor likesYouBrowserInteractor) {
        super(1);
        this.this$0 = likesYouBrowserInteractor;
    }

    public final void a(LikesYouGroupWithCards likesYouGroupWithCards) {
        Integer num;
        LikesYouBrowserInteractor likesYouBrowserInteractor = this.this$0;
        List<LikesYouCardEntity> cards = likesYouGroupWithCards.getCards();
        ArrayList arrayList = new ArrayList(r.t(cards, 10));
        for (LikesYouCardEntity profileId : cards) {
            arrayList.add(profileId.getProfileId());
        }
        likesYouBrowserInteractor.X1(arrayList);
        List<LikesYouCardEntity> cards2 = likesYouGroupWithCards.getCards();
        ArrayList arrayList2 = new ArrayList(r.t(cards2, 10));
        for (LikesYouCardEntity likesYouCardEntity : cards2) {
            String bagelId = likesYouCardEntity.getBagelId();
            String profileId2 = likesYouCardEntity.getProfileId();
            PurchaseAttribution purchaseAttribution = likesYouCardEntity.getPurchaseAttribution();
            if (purchaseAttribution != null) {
                num = Integer.valueOf(purchaseAttribution.getPurchaseAttributionInteger());
            } else {
                num = null;
            }
            arrayList2.add(new MatchIdAttribution(bagelId, profileId2, num));
        }
        List<LikesYouCardEntity> cards3 = likesYouGroupWithCards.getCards();
        LikesYouBrowserInteractor likesYouBrowserInteractor2 = this.this$0;
        Iterator<LikesYouCardEntity> it = cards3.iterator();
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                i10 = -1;
                break;
            } else if (j.b(it.next().getBagelId(), likesYouBrowserInteractor2.f34393g)) {
                break;
            } else {
                i10++;
            }
        }
        if (i10 >= 0) {
            this.this$0.Y1(new a(arrayList2.toArray(new MatchIdAttribution[0]), i10));
            String M1 = this.this$0.f34391e;
            List<String> U1 = this.this$0.U1();
            a<MatchIdAttribution> V1 = this.this$0.V1();
            j.d(V1);
            MatchIdAttribution d10 = V1.d();
            j.d(d10);
            ((q) this.this$0.B1()).n(M1, U1, d10, this.this$0.f34394h, (u<?, ?, ?>) null);
            return;
        }
        throw new IllegalStateException("selected match with id " + this.this$0.f34393g + " not found in list");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((LikesYouGroupWithCards) obj);
        return Unit.f32013a;
    }
}

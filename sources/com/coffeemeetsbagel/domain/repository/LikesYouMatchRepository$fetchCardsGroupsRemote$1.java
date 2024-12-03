package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.likes_you.c;
import com.coffeemeetsbagel.likes_you.i;
import com.coffeemeetsbagel.likes_you.n;
import com.coffeemeetsbagel.likesyou.LikesYouDataNetworkResponseV5;
import com.coffeemeetsbagel.likesyou.LikesYouNetworkGroup;
import com.coffeemeetsbagel.likesyou.LikesYouNetworkPaywallCard;
import com.coffeemeetsbagel.likesyou.LikesYouNetworkResponseV5;
import com.coffeemeetsbagel.likesyou.db.LikesYouGroupCardCrossRef;
import com.coffeemeetsbagel.likesyou.db.LikesYouGroupPaywallCardCrossRef;
import com.coffeemeetsbagel.models.entities.LikesYouCardEntity;
import com.coffeemeetsbagel.models.entities.LikesYouGroupEntity;
import com.coffeemeetsbagel.models.entities.LikesYouPaywallCard;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.a;
import qj.f;
import x4.r;

final class LikesYouMatchRepository$fetchCardsGroupsRemote$1 extends Lambda implements Function1<LikesYouNetworkResponseV5, f> {
    final /* synthetic */ r $transactionRunner;
    final /* synthetic */ LikesYouMatchRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LikesYouMatchRepository$fetchCardsGroupsRemote$1(LikesYouMatchRepository likesYouMatchRepository, r rVar) {
        super(1);
        this.this$0 = likesYouMatchRepository;
        this.$transactionRunner = rVar;
    }

    /* access modifiers changed from: private */
    public static final void d(LikesYouNetworkResponseV5 likesYouNetworkResponseV5, LikesYouMatchRepository likesYouMatchRepository, r rVar) {
        List<LikesYouPaywallCard> list;
        List list2;
        j.g(likesYouNetworkResponseV5, "$cardsAndGroups");
        j.g(likesYouMatchRepository, "this$0");
        j.g(rVar, "$transactionRunner");
        LikesYouDataNetworkResponseV5 data = likesYouNetworkResponseV5.getData();
        List<LikesYouCardEntity> a10 = c.f34171a.a(data);
        List<LikesYouGroupEntity> a11 = i.f34204a.a(data.getGroups());
        List<LikesYouNetworkGroup> groups = data.getGroups();
        ArrayList arrayList = new ArrayList(r.t(groups, 10));
        for (LikesYouNetworkGroup next : groups) {
            List<String> freeProfileIds = next.getFreeProfileIds();
            ArrayList arrayList2 = new ArrayList(r.t(freeProfileIds, 10));
            for (String likesYouGroupCardCrossRef : freeProfileIds) {
                arrayList2.add(new LikesYouGroupCardCrossRef(next.getId(), likesYouGroupCardCrossRef));
            }
            arrayList.add(arrayList2);
        }
        List F = CollectionsKt___CollectionsKt.F(r.u(arrayList));
        likesYouMatchRepository.f12402l.a(F);
        if (data.getPaywallCards() != null) {
            n nVar = n.f34243a;
            List<LikesYouNetworkPaywallCard> paywallCards = data.getPaywallCards();
            j.d(paywallCards);
            list = nVar.a(paywallCards);
        } else {
            list = null;
        }
        List<LikesYouNetworkGroup> groups2 = data.getGroups();
        ArrayList arrayList3 = new ArrayList(r.t(groups2, 10));
        for (LikesYouNetworkGroup next2 : groups2) {
            List<String> paywallProfileIds = next2.getPaywallProfileIds();
            if (paywallProfileIds != null) {
                list2 = new ArrayList(r.t(paywallProfileIds, 10));
                for (String likesYouGroupPaywallCardCrossRef : paywallProfileIds) {
                    list2.add(new LikesYouGroupPaywallCardCrossRef(next2.getId(), likesYouGroupPaywallCardCrossRef));
                }
            } else {
                list2 = q.j();
            }
            arrayList3.add(list2);
        }
        List F2 = CollectionsKt___CollectionsKt.F(r.u(arrayList3));
        likesYouMatchRepository.f12399i.c(a10);
        likesYouMatchRepository.f12400j.c(a11);
        likesYouMatchRepository.f12402l.a(F);
        if (list != null) {
            likesYouMatchRepository.f12401k.c(list);
        }
        likesYouMatchRepository.f12402l.b(F2);
    }

    /* renamed from: c */
    public final f invoke(LikesYouNetworkResponseV5 likesYouNetworkResponseV5) {
        j.g(likesYouNetworkResponseV5, "cardsAndGroups");
        return a.w(new y(likesYouNetworkResponseV5, this.this$0, this.$transactionRunner));
    }
}

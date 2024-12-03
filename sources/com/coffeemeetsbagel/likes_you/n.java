package com.coffeemeetsbagel.likes_you;

import com.coffeemeetsbagel.likesyou.LikesYouNetworkPaywallCard;
import com.coffeemeetsbagel.models.entities.LikesYouPaywallCard;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.j;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    public static final n f34243a = new n();

    private n() {
    }

    public final List<LikesYouPaywallCard> a(List<LikesYouNetworkPaywallCard> list) {
        j.g(list, "networkPaywallCards");
        ArrayList arrayList = new ArrayList(r.t(list, 10));
        for (LikesYouNetworkPaywallCard likesYouNetworkPaywallCard : list) {
            arrayList.add(new LikesYouPaywallCard(likesYouNetworkPaywallCard.getProfileId(), likesYouNetworkPaywallCard.getImageUrl(), likesYouNetworkPaywallCard.getPurchaseAttribution()));
        }
        return arrayList;
    }
}

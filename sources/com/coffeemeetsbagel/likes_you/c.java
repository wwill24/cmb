package com.coffeemeetsbagel.likes_you;

import com.coffeemeetsbagel.likesyou.LikesYouDataNetworkResponseV5;
import com.coffeemeetsbagel.likesyou.LikesYouNetworkCard;
import com.coffeemeetsbagel.likesyou.LikesYouNetworkGroup;
import com.coffeemeetsbagel.models.entities.LikesYouCardEntity;
import com.coffeemeetsbagel.models.enums.PurchaseAttribution;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.j;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f34171a = new c();

    private c() {
    }

    public final List<LikesYouCardEntity> a(LikesYouDataNetworkResponseV5 likesYouDataNetworkResponseV5) {
        String str;
        j.g(likesYouDataNetworkResponseV5, "networkResponse");
        List<LikesYouNetworkGroup> groups = likesYouDataNetworkResponseV5.getGroups();
        List<LikesYouNetworkCard> cards = likesYouDataNetworkResponseV5.getCards();
        ArrayList arrayList = new ArrayList(r.t(cards, 10));
        for (LikesYouNetworkCard likesYouNetworkCard : cards) {
            ArrayList<LikesYouNetworkGroup> arrayList2 = new ArrayList<>();
            for (T next : groups) {
                if (((LikesYouNetworkGroup) next).getFreeProfileIds().contains(likesYouNetworkCard.getProfileId())) {
                    arrayList2.add(next);
                }
            }
            ArrayList arrayList3 = new ArrayList(r.t(arrayList2, 10));
            for (LikesYouNetworkGroup id2 : arrayList2) {
                arrayList3.add(id2.getId());
            }
            String profileId = likesYouNetworkCard.getProfileId();
            int age = likesYouNetworkCard.getAge();
            String bagelId = likesYouNetworkCard.getBagelId();
            String city = likesYouNetworkCard.getCity();
            List<String> education = likesYouNetworkCard.getEducation();
            if (education != null) {
                str = (String) CollectionsKt___CollectionsKt.Q(education, 0);
            } else {
                str = null;
            }
            arrayList.add(new LikesYouCardEntity(profileId, arrayList3, age, bagelId, city, str, likesYouNetworkCard.getOccupation(), likesYouNetworkCard.getPairLikeComment(), likesYouNetworkCard.getImageUrl(), PurchaseAttribution.purchaseAttributionFromInteger(likesYouNetworkCard.getPurchaseAttribution())));
        }
        return arrayList;
    }
}

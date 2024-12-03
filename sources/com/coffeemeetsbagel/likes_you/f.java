package com.coffeemeetsbagel.likes_you;

import com.coffeemeetsbagel.likesyou.db.LikesYouGroupCardCrossRef;
import com.coffeemeetsbagel.likesyou.db.LikesYouGroupPaywallCardCrossRef;
import com.coffeemeetsbagel.likesyou.db.LikesYouGroupWithCards;
import java.util.List;
import qj.h;

public interface f {
    void a(List<LikesYouGroupCardCrossRef> list);

    void b(List<LikesYouGroupPaywallCardCrossRef> list);

    h<List<LikesYouGroupWithCards>> c();

    h<List<LikesYouGroupWithCards>> d(String str);
}

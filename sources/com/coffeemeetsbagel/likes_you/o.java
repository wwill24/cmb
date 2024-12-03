package com.coffeemeetsbagel.likes_you;

import com.coffeemeetsbagel.database.daos.l;
import com.coffeemeetsbagel.models.entities.LikesYouPaywallCard;
import java.util.List;
import kotlin.jvm.internal.j;
import qj.w;

public abstract class o implements l<LikesYouPaywallCard>, m {
    public w<List<LikesYouPaywallCard>> a() {
        return g();
    }

    public void c(List<LikesYouPaywallCard> list) {
        j.g(list, "paywallCards");
        f();
        s(list);
    }

    public abstract void f();

    public abstract w<List<LikesYouPaywallCard>> g();
}

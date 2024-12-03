package com.coffeemeetsbagel.likes_you;

import com.coffeemeetsbagel.database.daos.l;
import com.coffeemeetsbagel.models.entities.LikesYouCardEntity;
import java.util.List;
import kotlin.jvm.internal.j;
import qj.h;
import qj.w;

public abstract class d implements l<LikesYouCardEntity>, b {
    public w<Integer> a(String str) {
        j.g(str, "profileId");
        return j(str);
    }

    public void c(List<LikesYouCardEntity> list) {
        j.g(list, "cards");
        i();
        s(list);
    }

    public h<LikesYouCardEntity> f(String str) {
        j.g(str, "profileId");
        return t(str);
    }

    public w<List<LikesYouCardEntity>> g() {
        return n();
    }

    public abstract void i();

    public abstract w<Integer> j(String str);

    public abstract w<List<LikesYouCardEntity>> n();

    public abstract h<LikesYouCardEntity> t(String str);
}

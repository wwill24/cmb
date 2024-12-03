package com.coffeemeetsbagel.likes_you;

import com.coffeemeetsbagel.database.daos.l;
import com.coffeemeetsbagel.models.entities.LikesYouGroupEntity;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import qj.h;
import qj.w;

public abstract class LikesYouGroupRoomDao implements l<LikesYouGroupEntity>, h {
    /* access modifiers changed from: private */
    public static final List w(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (List) function1.invoke(obj);
    }

    public abstract h<Integer> A(String str);

    public h<List<s>> a() {
        h<R> Y = v().Y(new j(LikesYouGroupRoomDao$getTabs$1.f34122a));
        j.f(Y, "getGroups().map { groups…)\n            }\n        }");
        return Y;
    }

    public void c(List<LikesYouGroupEntity> list) {
        j.g(list, "groups");
        u();
        s(list);
    }

    public w<Integer> f(LikesYouGroupEntity likesYouGroupEntity) {
        j.g(likesYouGroupEntity, "groupEntity");
        return b(likesYouGroupEntity);
    }

    public h<LikesYouGroupEntity> g(String str) {
        j.g(str, "groupId");
        return y(str);
    }

    public h<Integer> i(String str) {
        j.g(str, "groupId");
        return A(str);
    }

    public h<Integer> j(String str) {
        j.g(str, "groupId");
        return x(str);
    }

    public w<List<String>> n(List<String> list) {
        j.g(list, "idsList");
        return z(list);
    }

    public abstract void u();

    public abstract h<List<LikesYouGroupEntity>> v();

    public abstract h<Integer> x(String str);

    public abstract h<LikesYouGroupEntity> y(String str);

    public abstract w<List<String>> z(List<String> list);
}

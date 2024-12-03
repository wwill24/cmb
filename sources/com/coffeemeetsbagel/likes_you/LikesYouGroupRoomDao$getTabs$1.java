package com.coffeemeetsbagel.likes_you;

import com.coffeemeetsbagel.models.entities.LikesYouGroupEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class LikesYouGroupRoomDao$getTabs$1 extends Lambda implements Function1<List<? extends LikesYouGroupEntity>, List<? extends s>> {

    /* renamed from: a  reason: collision with root package name */
    public static final LikesYouGroupRoomDao$getTabs$1 f34122a = new LikesYouGroupRoomDao$getTabs$1();

    LikesYouGroupRoomDao$getTabs$1() {
        super(1);
    }

    /* renamed from: a */
    public final List<s> invoke(List<LikesYouGroupEntity> list) {
        j.g(list, "groups");
        ArrayList arrayList = new ArrayList(r.t(list, 10));
        for (LikesYouGroupEntity likesYouGroupEntity : list) {
            arrayList.add(new s(likesYouGroupEntity.getId(), likesYouGroupEntity.getName(), likesYouGroupEntity.getCount(), likesYouGroupEntity.getMaxDisplayCounts(), likesYouGroupEntity.getGroupOrdinal(), likesYouGroupEntity.getFreeProfileIds().size()));
        }
        return arrayList;
    }
}

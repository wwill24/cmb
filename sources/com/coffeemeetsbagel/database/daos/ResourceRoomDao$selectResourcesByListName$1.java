package com.coffeemeetsbagel.database.daos;

import c9.c;
import com.coffeemeetsbagel.models.Resource;
import com.coffeemeetsbagel.models.entities.ResourceEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class ResourceRoomDao$selectResourcesByListName$1 extends Lambda implements Function1<List<? extends ResourceEntity>, List<? extends Resource>> {

    /* renamed from: a  reason: collision with root package name */
    public static final ResourceRoomDao$selectResourcesByListName$1 f11613a = new ResourceRoomDao$selectResourcesByListName$1();

    ResourceRoomDao$selectResourcesByListName$1() {
        super(1);
    }

    /* renamed from: a */
    public final List<Resource> invoke(List<ResourceEntity> list) {
        j.g(list, "entities");
        ArrayList arrayList = new ArrayList(r.t(list, 10));
        for (ResourceEntity a10 : list) {
            arrayList.add(c.f7996a.a(a10));
        }
        return arrayList;
    }
}

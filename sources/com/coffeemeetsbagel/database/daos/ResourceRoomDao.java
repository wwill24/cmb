package com.coffeemeetsbagel.database.daos;

import c9.c;
import com.coffeemeetsbagel.models.Resource;
import com.coffeemeetsbagel.models.entities.ResourceEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import qj.w;
import u6.l;

public abstract class ResourceRoomDao implements l<ResourceEntity>, l {
    /* access modifiers changed from: private */
    public static final List j(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (List) function1.invoke(obj);
    }

    public List<Long> a(List<Resource> list) {
        j.g(list, "resources");
        g();
        ArrayList arrayList = new ArrayList(r.t(list, 10));
        for (Resource b10 : list) {
            arrayList.add(c.f7996a.b(b10));
        }
        return s(arrayList);
    }

    public w<List<Resource>> c(String str) {
        j.g(str, "listName");
        w<R> D = i(str).D(new m0(ResourceRoomDao$selectResourcesByListName$1.f11613a));
        j.f(D, "selectResourcesByList(li…)\n            }\n        }");
        return D;
    }

    public abstract void g();

    public abstract w<List<ResourceEntity>> i(String str);
}

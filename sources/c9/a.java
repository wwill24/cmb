package c9;

import com.coffeemeetsbagel.models.Resource;
import com.coffeemeetsbagel.models.enums.ResourceType;
import java.util.List;
import kotlin.jvm.internal.j;
import qj.w;
import u6.l;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final l f7994a;

    public a(l lVar) {
        j.g(lVar, "resourceDao");
        this.f7994a = lVar;
    }

    public final w<List<Resource>> a(ResourceType resourceType) {
        j.g(resourceType, "resourceType");
        l lVar = this.f7994a;
        String listName = resourceType.getListName();
        j.f(listName, "resourceType.listName");
        w<List<Resource>> K = lVar.c(listName).K(dk.a.c());
        j.f(K, "resourceDao.selectResour…scribeOn(Schedulers.io())");
        return K;
    }
}

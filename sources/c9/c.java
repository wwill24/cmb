package c9;

import com.coffeemeetsbagel.models.Resource;
import com.coffeemeetsbagel.models.entities.ResourceEntity;
import kotlin.jvm.internal.j;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f7996a = new c();

    private c() {
    }

    public final Resource a(ResourceEntity resourceEntity) {
        j.g(resourceEntity, "entity");
        return new Resource(resourceEntity.getKey(), resourceEntity.getValue(), resourceEntity.getListName());
    }

    public final ResourceEntity b(Resource resource) {
        j.g(resource, "resource");
        return new ResourceEntity(resource.getKey(), resource.getValue(), resource.getListName());
    }
}

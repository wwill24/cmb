package l5;

import com.coffeemeetsbagel.domain.repository.m;
import com.coffeemeetsbagel.models.entities.CapabilityType;
import kotlin.jvm.internal.j;
import qj.h;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final m f16039a;

    public a(m mVar) {
        j.g(mVar, "capabilityRepository");
        this.f16039a = mVar;
    }

    public final h<Boolean> a(CapabilityType capabilityType) {
        j.g(capabilityType, "capability");
        return this.f16039a.c(capabilityType);
    }
}

package com.coffeemeetsbagel.database.daos;

import com.coffeemeetsbagel.models.dto.Capability;
import com.coffeemeetsbagel.models.entities.CapabilityEntity;
import com.coffeemeetsbagel.models.entities.CapabilityType;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import qj.h;
import u6.d;

public abstract class CapabilityRoomDao implements l<CapabilityEntity>, d {
    /* access modifiers changed from: private */
    public static final List i(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (List) function1.invoke(obj);
    }

    public List<Long> a(List<CapabilityEntity> list) {
        j.g(list, "capabilities");
        return p(list);
    }

    public h<Boolean> c(CapabilityType capabilityType) {
        j.g(capabilityType, "capability");
        return j(capabilityType);
    }

    public h<List<Capability>> f() {
        h<R> Y = n().Y(new p(CapabilityRoomDao$getAllCapabilities$1.f11606a));
        j.f(Y, "internalGetAllCapabiliti…}\n            }\n        }");
        return Y;
    }

    public abstract h<Boolean> j(CapabilityType capabilityType);

    public abstract h<List<CapabilityEntity>> n();
}

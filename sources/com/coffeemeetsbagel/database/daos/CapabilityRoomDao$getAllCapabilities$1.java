package com.coffeemeetsbagel.database.daos;

import com.coffeemeetsbagel.models.dto.Capability;
import com.coffeemeetsbagel.models.entities.CapabilityEntity;
import com.coffeemeetsbagel.models.entities.CapabilityType;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class CapabilityRoomDao$getAllCapabilities$1 extends Lambda implements Function1<List<? extends CapabilityEntity>, List<? extends Capability>> {

    /* renamed from: a  reason: collision with root package name */
    public static final CapabilityRoomDao$getAllCapabilities$1 f11606a = new CapabilityRoomDao$getAllCapabilities$1();

    public static final class a implements Capability {

        /* renamed from: a  reason: collision with root package name */
        private final CapabilityType f11607a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f11608b;

        a(CapabilityEntity capabilityEntity) {
            this.f11607a = capabilityEntity.getCapability();
            this.f11608b = capabilityEntity.getEnabled();
        }

        public CapabilityType getCapability() {
            return this.f11607a;
        }

        public boolean getEnabled() {
            return this.f11608b;
        }
    }

    CapabilityRoomDao$getAllCapabilities$1() {
        super(1);
    }

    /* renamed from: a */
    public final List<Capability> invoke(List<CapabilityEntity> list) {
        j.g(list, "list");
        ArrayList arrayList = new ArrayList(r.t(list, 10));
        for (CapabilityEntity aVar : list) {
            arrayList.add(new a(aVar));
        }
        return arrayList;
    }
}

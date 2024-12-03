package com.coffeemeetsbagel.experiment;

import fa.a;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class FeatureFlagRepository$populateOverrideMemCache$2 extends Lambda implements Function1<Map<String, ?>, Unit> {
    final /* synthetic */ FeatureFlagRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeatureFlagRepository$populateOverrideMemCache$2(FeatureFlagRepository featureFlagRepository) {
        super(1);
        this.this$0 = featureFlagRepository;
    }

    public final void a(Map<String, ?> map) {
        j.f(map, "map");
        FeatureFlagRepository featureFlagRepository = this.this$0;
        for (Map.Entry next : map.entrySet()) {
            Object value = next.getValue();
            j.e(value, "null cannot be cast to non-null type kotlin.Boolean");
            boolean booleanValue = ((Boolean) value).booleanValue();
            a.C0491a aVar = a.f40771d;
            String o10 = featureFlagRepository.f12632d;
            aVar.a(o10, "overriding " + ((String) next.getKey()) + " to " + booleanValue);
            Map m10 = featureFlagRepository.f12637i;
            Object key = next.getKey();
            j.f(key, "entry.key");
            m10.put(key, Boolean.valueOf(booleanValue));
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Map) obj);
        return Unit.f32013a;
    }
}

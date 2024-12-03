package g6;

import com.coffeemeetsbagel.models.entities.CapabilityType;
import kotlin.jvm.internal.j;

public final class a {
    public final String a(CapabilityType capabilityType) {
        j.g(capabilityType, "capability");
        return capabilityType.getApiKey();
    }

    public final CapabilityType b(String str) {
        j.g(str, "capability");
        return CapabilityType.Companion.fromApiKey(str);
    }
}

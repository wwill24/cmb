package com.coffeemeetsbagel.likesyou;

import java.util.List;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class EncountersRequestBody {
    private final List<ProfileRequestData> profiles;

    public EncountersRequestBody(List<ProfileRequestData> list) {
        j.g(list, "profiles");
        this.profiles = list;
    }

    public static /* synthetic */ EncountersRequestBody copy$default(EncountersRequestBody encountersRequestBody, List<ProfileRequestData> list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = encountersRequestBody.profiles;
        }
        return encountersRequestBody.copy(list);
    }

    public final List<ProfileRequestData> component1() {
        return this.profiles;
    }

    public final EncountersRequestBody copy(List<ProfileRequestData> list) {
        j.g(list, "profiles");
        return new EncountersRequestBody(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof EncountersRequestBody) && j.b(this.profiles, ((EncountersRequestBody) obj).profiles);
    }

    public final List<ProfileRequestData> getProfiles() {
        return this.profiles;
    }

    public int hashCode() {
        return this.profiles.hashCode();
    }

    public String toString() {
        return "EncountersRequestBody(profiles=" + this.profiles + PropertyUtils.MAPPED_DELIM2;
    }
}

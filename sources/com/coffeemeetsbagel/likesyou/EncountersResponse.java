package com.coffeemeetsbagel.likesyou;

import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class EncountersResponse {
    private final EncountersDataResponse data;

    public EncountersResponse(EncountersDataResponse encountersDataResponse) {
        j.g(encountersDataResponse, "data");
        this.data = encountersDataResponse;
    }

    public static /* synthetic */ EncountersResponse copy$default(EncountersResponse encountersResponse, EncountersDataResponse encountersDataResponse, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            encountersDataResponse = encountersResponse.data;
        }
        return encountersResponse.copy(encountersDataResponse);
    }

    public final EncountersDataResponse component1() {
        return this.data;
    }

    public final EncountersResponse copy(EncountersDataResponse encountersDataResponse) {
        j.g(encountersDataResponse, "data");
        return new EncountersResponse(encountersDataResponse);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof EncountersResponse) && j.b(this.data, ((EncountersResponse) obj).data);
    }

    public final EncountersDataResponse getData() {
        return this.data;
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    public String toString() {
        return "EncountersResponse(data=" + this.data + PropertyUtils.MAPPED_DELIM2;
    }
}

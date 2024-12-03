package com.coffeemeetsbagel.likesyou;

import com.coffeemeetsbagel.models.Bagel;
import java.util.List;
import kotlin.jvm.internal.j;
import lg.c;
import org.apache.commons.beanutils.PropertyUtils;

public final class EncountersDataResponse {
    private final List<Bagel> encounters;
    @c("fetch_errors")
    private final List<FetchError> fetchErrors;

    public EncountersDataResponse(List<? extends Bagel> list, List<FetchError> list2) {
        j.g(list, "encounters");
        j.g(list2, "fetchErrors");
        this.encounters = list;
        this.fetchErrors = list2;
    }

    public static /* synthetic */ EncountersDataResponse copy$default(EncountersDataResponse encountersDataResponse, List<Bagel> list, List<FetchError> list2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = encountersDataResponse.encounters;
        }
        if ((i10 & 2) != 0) {
            list2 = encountersDataResponse.fetchErrors;
        }
        return encountersDataResponse.copy(list, list2);
    }

    public final List<Bagel> component1() {
        return this.encounters;
    }

    public final List<FetchError> component2() {
        return this.fetchErrors;
    }

    public final EncountersDataResponse copy(List<? extends Bagel> list, List<FetchError> list2) {
        j.g(list, "encounters");
        j.g(list2, "fetchErrors");
        return new EncountersDataResponse(list, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EncountersDataResponse)) {
            return false;
        }
        EncountersDataResponse encountersDataResponse = (EncountersDataResponse) obj;
        return j.b(this.encounters, encountersDataResponse.encounters) && j.b(this.fetchErrors, encountersDataResponse.fetchErrors);
    }

    public final List<Bagel> getEncounters() {
        return this.encounters;
    }

    public final List<FetchError> getFetchErrors() {
        return this.fetchErrors;
    }

    public int hashCode() {
        return (this.encounters.hashCode() * 31) + this.fetchErrors.hashCode();
    }

    public String toString() {
        return "EncountersDataResponse(encounters=" + this.encounters + ", fetchErrors=" + this.fetchErrors + PropertyUtils.MAPPED_DELIM2;
    }
}

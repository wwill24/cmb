package com.coffeemeetsbagel.subscription.network.models;

import com.coffeemeetsbagel.models.responses.ResponseGeneric;
import java.util.Map;
import kotlin.jvm.internal.j;
import lg.c;
import org.apache.commons.beanutils.PropertyUtils;

public final class BenefitsResponse extends ResponseGeneric {
    @c("data")
    private final Map<String, NetworkBenefit> data;

    public BenefitsResponse(Map<String, NetworkBenefit> map) {
        j.g(map, "data");
        this.data = map;
    }

    public static /* synthetic */ BenefitsResponse copy$default(BenefitsResponse benefitsResponse, Map<String, NetworkBenefit> map, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            map = benefitsResponse.data;
        }
        return benefitsResponse.copy(map);
    }

    public final Map<String, NetworkBenefit> component1() {
        return this.data;
    }

    public final BenefitsResponse copy(Map<String, NetworkBenefit> map) {
        j.g(map, "data");
        return new BenefitsResponse(map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BenefitsResponse) && j.b(this.data, ((BenefitsResponse) obj).data);
    }

    public final Map<String, NetworkBenefit> getData() {
        return this.data;
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    public String toString() {
        return "BenefitsResponse(data=" + this.data + PropertyUtils.MAPPED_DELIM2;
    }
}

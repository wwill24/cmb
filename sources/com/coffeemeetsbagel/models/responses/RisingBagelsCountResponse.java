package com.coffeemeetsbagel.models.responses;

import lg.c;
import org.apache.commons.beanutils.PropertyUtils;

public final class RisingBagelsCountResponse {
    private final int count;
    @c("count_my_type")
    private final int countMyType;

    public RisingBagelsCountResponse(int i10, int i11) {
        this.count = i10;
        this.countMyType = i11;
    }

    public static /* synthetic */ RisingBagelsCountResponse copy$default(RisingBagelsCountResponse risingBagelsCountResponse, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = risingBagelsCountResponse.count;
        }
        if ((i12 & 2) != 0) {
            i11 = risingBagelsCountResponse.countMyType;
        }
        return risingBagelsCountResponse.copy(i10, i11);
    }

    public final int component1() {
        return this.count;
    }

    public final int component2() {
        return this.countMyType;
    }

    public final RisingBagelsCountResponse copy(int i10, int i11) {
        return new RisingBagelsCountResponse(i10, i11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RisingBagelsCountResponse)) {
            return false;
        }
        RisingBagelsCountResponse risingBagelsCountResponse = (RisingBagelsCountResponse) obj;
        return this.count == risingBagelsCountResponse.count && this.countMyType == risingBagelsCountResponse.countMyType;
    }

    public final int getCount() {
        return this.count;
    }

    public final int getCountMyType() {
        return this.countMyType;
    }

    public int hashCode() {
        return (Integer.hashCode(this.count) * 31) + Integer.hashCode(this.countMyType);
    }

    public String toString() {
        return "RisingBagelsCountResponse(count=" + this.count + ", countMyType=" + this.countMyType + PropertyUtils.MAPPED_DELIM2;
    }
}

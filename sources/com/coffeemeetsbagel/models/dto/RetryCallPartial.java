package com.coffeemeetsbagel.models.dto;

import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class RetryCallPartial {
    private final String internalTag;
    private final long lastTimeTried;
    private final String payloadObject;
    private final int timesTriedSoFar;

    public RetryCallPartial(String str, String str2, long j10, int i10) {
        j.g(str, "internalTag");
        j.g(str2, "payloadObject");
        this.internalTag = str;
        this.payloadObject = str2;
        this.lastTimeTried = j10;
        this.timesTriedSoFar = i10;
    }

    public static /* synthetic */ RetryCallPartial copy$default(RetryCallPartial retryCallPartial, String str, String str2, long j10, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = retryCallPartial.internalTag;
        }
        if ((i11 & 2) != 0) {
            str2 = retryCallPartial.payloadObject;
        }
        String str3 = str2;
        if ((i11 & 4) != 0) {
            j10 = retryCallPartial.lastTimeTried;
        }
        long j11 = j10;
        if ((i11 & 8) != 0) {
            i10 = retryCallPartial.timesTriedSoFar;
        }
        return retryCallPartial.copy(str, str3, j11, i10);
    }

    public final String component1() {
        return this.internalTag;
    }

    public final String component2() {
        return this.payloadObject;
    }

    public final long component3() {
        return this.lastTimeTried;
    }

    public final int component4() {
        return this.timesTriedSoFar;
    }

    public final RetryCallPartial copy(String str, String str2, long j10, int i10) {
        j.g(str, "internalTag");
        j.g(str2, "payloadObject");
        return new RetryCallPartial(str, str2, j10, i10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RetryCallPartial)) {
            return false;
        }
        RetryCallPartial retryCallPartial = (RetryCallPartial) obj;
        return j.b(this.internalTag, retryCallPartial.internalTag) && j.b(this.payloadObject, retryCallPartial.payloadObject) && this.lastTimeTried == retryCallPartial.lastTimeTried && this.timesTriedSoFar == retryCallPartial.timesTriedSoFar;
    }

    public final String getInternalTag() {
        return this.internalTag;
    }

    public final long getLastTimeTried() {
        return this.lastTimeTried;
    }

    public final String getPayloadObject() {
        return this.payloadObject;
    }

    public final int getTimesTriedSoFar() {
        return this.timesTriedSoFar;
    }

    public int hashCode() {
        return (((((this.internalTag.hashCode() * 31) + this.payloadObject.hashCode()) * 31) + Long.hashCode(this.lastTimeTried)) * 31) + Integer.hashCode(this.timesTriedSoFar);
    }

    public String toString() {
        return "RetryCallPartial(internalTag=" + this.internalTag + ", payloadObject=" + this.payloadObject + ", lastTimeTried=" + this.lastTimeTried + ", timesTriedSoFar=" + this.timesTriedSoFar + PropertyUtils.MAPPED_DELIM2;
    }
}

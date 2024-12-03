package com.coffeemeetsbagel.models.dto;

import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class RetryCall {

    /* renamed from: id  reason: collision with root package name */
    private final long f34719id;
    private final String internalTag;
    private final long lastTimeTried;
    private final String payloadObject;
    private final int timesTriedSoFar;

    public RetryCall(long j10, String str, String str2, long j11, int i10) {
        j.g(str, "internalTag");
        j.g(str2, "payloadObject");
        this.f34719id = j10;
        this.internalTag = str;
        this.payloadObject = str2;
        this.lastTimeTried = j11;
        this.timesTriedSoFar = i10;
    }

    public static /* synthetic */ RetryCall copy$default(RetryCall retryCall, long j10, String str, String str2, long j11, int i10, int i11, Object obj) {
        RetryCall retryCall2 = retryCall;
        return retryCall.copy((i11 & 1) != 0 ? retryCall2.f34719id : j10, (i11 & 2) != 0 ? retryCall2.internalTag : str, (i11 & 4) != 0 ? retryCall2.payloadObject : str2, (i11 & 8) != 0 ? retryCall2.lastTimeTried : j11, (i11 & 16) != 0 ? retryCall2.timesTriedSoFar : i10);
    }

    public final long component1() {
        return this.f34719id;
    }

    public final String component2() {
        return this.internalTag;
    }

    public final String component3() {
        return this.payloadObject;
    }

    public final long component4() {
        return this.lastTimeTried;
    }

    public final int component5() {
        return this.timesTriedSoFar;
    }

    public final RetryCall copy(long j10, String str, String str2, long j11, int i10) {
        j.g(str, "internalTag");
        j.g(str2, "payloadObject");
        return new RetryCall(j10, str, str2, j11, i10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RetryCall)) {
            return false;
        }
        RetryCall retryCall = (RetryCall) obj;
        return this.f34719id == retryCall.f34719id && j.b(this.internalTag, retryCall.internalTag) && j.b(this.payloadObject, retryCall.payloadObject) && this.lastTimeTried == retryCall.lastTimeTried && this.timesTriedSoFar == retryCall.timesTriedSoFar;
    }

    public final long getId() {
        return this.f34719id;
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
        return (((((((Long.hashCode(this.f34719id) * 31) + this.internalTag.hashCode()) * 31) + this.payloadObject.hashCode()) * 31) + Long.hashCode(this.lastTimeTried)) * 31) + Integer.hashCode(this.timesTriedSoFar);
    }

    public String toString() {
        return "RetryCall(id=" + this.f34719id + ", internalTag=" + this.internalTag + ", payloadObject=" + this.payloadObject + ", lastTimeTried=" + this.lastTimeTried + ", timesTriedSoFar=" + this.timesTriedSoFar + PropertyUtils.MAPPED_DELIM2;
    }
}

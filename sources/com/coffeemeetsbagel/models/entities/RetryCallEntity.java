package com.coffeemeetsbagel.models.entities;

import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class RetryCallEntity {

    /* renamed from: id  reason: collision with root package name */
    private final long f34725id;
    private final String internalTag;
    private final long lastTimeTried;
    private final String payloadObject;
    private final int timesTriedSoFar;

    public RetryCallEntity(String str, String str2, long j10, int i10, long j11) {
        j.g(str, "internalTag");
        j.g(str2, "payloadObject");
        this.internalTag = str;
        this.payloadObject = str2;
        this.lastTimeTried = j10;
        this.timesTriedSoFar = i10;
        this.f34725id = j11;
    }

    public static /* synthetic */ RetryCallEntity copy$default(RetryCallEntity retryCallEntity, String str, String str2, long j10, int i10, long j11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = retryCallEntity.internalTag;
        }
        if ((i11 & 2) != 0) {
            str2 = retryCallEntity.payloadObject;
        }
        String str3 = str2;
        if ((i11 & 4) != 0) {
            j10 = retryCallEntity.lastTimeTried;
        }
        long j12 = j10;
        if ((i11 & 8) != 0) {
            i10 = retryCallEntity.timesTriedSoFar;
        }
        int i12 = i10;
        if ((i11 & 16) != 0) {
            j11 = retryCallEntity.f34725id;
        }
        return retryCallEntity.copy(str, str3, j12, i12, j11);
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

    public final long component5() {
        return this.f34725id;
    }

    public final RetryCallEntity copy(String str, String str2, long j10, int i10, long j11) {
        j.g(str, "internalTag");
        j.g(str2, "payloadObject");
        return new RetryCallEntity(str, str2, j10, i10, j11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RetryCallEntity)) {
            return false;
        }
        RetryCallEntity retryCallEntity = (RetryCallEntity) obj;
        return j.b(this.internalTag, retryCallEntity.internalTag) && j.b(this.payloadObject, retryCallEntity.payloadObject) && this.lastTimeTried == retryCallEntity.lastTimeTried && this.timesTriedSoFar == retryCallEntity.timesTriedSoFar && this.f34725id == retryCallEntity.f34725id;
    }

    public final long getId() {
        return this.f34725id;
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
        return (((((((this.internalTag.hashCode() * 31) + this.payloadObject.hashCode()) * 31) + Long.hashCode(this.lastTimeTried)) * 31) + Integer.hashCode(this.timesTriedSoFar)) * 31) + Long.hashCode(this.f34725id);
    }

    public String toString() {
        return "RetryCallEntity(internalTag=" + this.internalTag + ", payloadObject=" + this.payloadObject + ", lastTimeTried=" + this.lastTimeTried + ", timesTriedSoFar=" + this.timesTriedSoFar + ", id=" + this.f34725id + PropertyUtils.MAPPED_DELIM2;
    }
}

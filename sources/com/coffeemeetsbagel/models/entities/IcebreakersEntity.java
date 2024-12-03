package com.coffeemeetsbagel.models.entities;

import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class IcebreakersEntity {
    private final String firstIcebreaker;
    private final String secondIcebreaker;
    private final String thirdIcebreaker;

    public IcebreakersEntity(String str, String str2, String str3) {
        j.g(str, "firstIcebreaker");
        j.g(str2, "secondIcebreaker");
        j.g(str3, "thirdIcebreaker");
        this.firstIcebreaker = str;
        this.secondIcebreaker = str2;
        this.thirdIcebreaker = str3;
    }

    public static /* synthetic */ IcebreakersEntity copy$default(IcebreakersEntity icebreakersEntity, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = icebreakersEntity.firstIcebreaker;
        }
        if ((i10 & 2) != 0) {
            str2 = icebreakersEntity.secondIcebreaker;
        }
        if ((i10 & 4) != 0) {
            str3 = icebreakersEntity.thirdIcebreaker;
        }
        return icebreakersEntity.copy(str, str2, str3);
    }

    public final String component1() {
        return this.firstIcebreaker;
    }

    public final String component2() {
        return this.secondIcebreaker;
    }

    public final String component3() {
        return this.thirdIcebreaker;
    }

    public final IcebreakersEntity copy(String str, String str2, String str3) {
        j.g(str, "firstIcebreaker");
        j.g(str2, "secondIcebreaker");
        j.g(str3, "thirdIcebreaker");
        return new IcebreakersEntity(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IcebreakersEntity)) {
            return false;
        }
        IcebreakersEntity icebreakersEntity = (IcebreakersEntity) obj;
        return j.b(this.firstIcebreaker, icebreakersEntity.firstIcebreaker) && j.b(this.secondIcebreaker, icebreakersEntity.secondIcebreaker) && j.b(this.thirdIcebreaker, icebreakersEntity.thirdIcebreaker);
    }

    public final String getFirstIcebreaker() {
        return this.firstIcebreaker;
    }

    public final String getSecondIcebreaker() {
        return this.secondIcebreaker;
    }

    public final String getThirdIcebreaker() {
        return this.thirdIcebreaker;
    }

    public int hashCode() {
        return (((this.firstIcebreaker.hashCode() * 31) + this.secondIcebreaker.hashCode()) * 31) + this.thirdIcebreaker.hashCode();
    }

    public String toString() {
        return "IcebreakersEntity(firstIcebreaker=" + this.firstIcebreaker + ", secondIcebreaker=" + this.secondIcebreaker + ", thirdIcebreaker=" + this.thirdIcebreaker + PropertyUtils.MAPPED_DELIM2;
    }
}

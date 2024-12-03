package com.coffeemeetsbagel.models.entities;

import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class PriceEntity {
    private final int beans;
    private final int freeItemCount;
    private final String imageUrl;
    private final boolean isUnlimited;
    private final String name;
    private final String tintColor;

    public PriceEntity(String str, int i10, int i11, String str2, String str3, boolean z10) {
        j.g(str, "name");
        j.g(str2, "imageUrl");
        j.g(str3, "tintColor");
        this.name = str;
        this.beans = i10;
        this.freeItemCount = i11;
        this.imageUrl = str2;
        this.tintColor = str3;
        this.isUnlimited = z10;
    }

    public static /* synthetic */ PriceEntity copy$default(PriceEntity priceEntity, String str, int i10, int i11, String str2, String str3, boolean z10, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = priceEntity.name;
        }
        if ((i12 & 2) != 0) {
            i10 = priceEntity.beans;
        }
        int i13 = i10;
        if ((i12 & 4) != 0) {
            i11 = priceEntity.freeItemCount;
        }
        int i14 = i11;
        if ((i12 & 8) != 0) {
            str2 = priceEntity.imageUrl;
        }
        String str4 = str2;
        if ((i12 & 16) != 0) {
            str3 = priceEntity.tintColor;
        }
        String str5 = str3;
        if ((i12 & 32) != 0) {
            z10 = priceEntity.isUnlimited;
        }
        return priceEntity.copy(str, i13, i14, str4, str5, z10);
    }

    public final String component1() {
        return this.name;
    }

    public final int component2() {
        return this.beans;
    }

    public final int component3() {
        return this.freeItemCount;
    }

    public final String component4() {
        return this.imageUrl;
    }

    public final String component5() {
        return this.tintColor;
    }

    public final boolean component6() {
        return this.isUnlimited;
    }

    public final PriceEntity copy(String str, int i10, int i11, String str2, String str3, boolean z10) {
        j.g(str, "name");
        j.g(str2, "imageUrl");
        j.g(str3, "tintColor");
        return new PriceEntity(str, i10, i11, str2, str3, z10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PriceEntity)) {
            return false;
        }
        PriceEntity priceEntity = (PriceEntity) obj;
        return j.b(this.name, priceEntity.name) && this.beans == priceEntity.beans && this.freeItemCount == priceEntity.freeItemCount && j.b(this.imageUrl, priceEntity.imageUrl) && j.b(this.tintColor, priceEntity.tintColor) && this.isUnlimited == priceEntity.isUnlimited;
    }

    public final int getBeans() {
        return this.beans;
    }

    public final int getFreeItemCount() {
        return this.freeItemCount;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getName() {
        return this.name;
    }

    public final String getTintColor() {
        return this.tintColor;
    }

    public int hashCode() {
        int hashCode = ((((((((this.name.hashCode() * 31) + Integer.hashCode(this.beans)) * 31) + Integer.hashCode(this.freeItemCount)) * 31) + this.imageUrl.hashCode()) * 31) + this.tintColor.hashCode()) * 31;
        boolean z10 = this.isUnlimited;
        if (z10) {
            z10 = true;
        }
        return hashCode + (z10 ? 1 : 0);
    }

    public final boolean isUnlimited() {
        return this.isUnlimited;
    }

    public String toString() {
        return "PriceEntity(name=" + this.name + ", beans=" + this.beans + ", freeItemCount=" + this.freeItemCount + ", imageUrl=" + this.imageUrl + ", tintColor=" + this.tintColor + ", isUnlimited=" + this.isUnlimited + PropertyUtils.MAPPED_DELIM2;
    }
}

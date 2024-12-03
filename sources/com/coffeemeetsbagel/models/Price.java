package com.coffeemeetsbagel.models;

import com.coffeemeetsbagel.models.entities.PriceEntity;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class Price implements Serializable, Comparable<Price> {
    private int beans;
    private String displayName;
    private int freeItemCount;
    private String imageUrl;
    private boolean isUnlimited;
    private String name;
    private String tintColor;

    public Price(int i10, int i11, boolean z10, String str, String str2, String str3, String str4) {
        j.g(str, "name");
        j.g(str2, "imageUrl");
        j.g(str3, "tintColor");
        this.beans = i10;
        this.freeItemCount = i11;
        this.isUnlimited = z10;
        this.name = str;
        this.imageUrl = str2;
        this.tintColor = str3;
        this.displayName = str4;
    }

    public static /* synthetic */ Price copy$default(Price price, int i10, int i11, boolean z10, String str, String str2, String str3, String str4, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = price.beans;
        }
        if ((i12 & 2) != 0) {
            i11 = price.freeItemCount;
        }
        int i13 = i11;
        if ((i12 & 4) != 0) {
            z10 = price.isUnlimited;
        }
        boolean z11 = z10;
        if ((i12 & 8) != 0) {
            str = price.name;
        }
        String str5 = str;
        if ((i12 & 16) != 0) {
            str2 = price.imageUrl;
        }
        String str6 = str2;
        if ((i12 & 32) != 0) {
            str3 = price.tintColor;
        }
        String str7 = str3;
        if ((i12 & 64) != 0) {
            str4 = price.displayName;
        }
        return price.copy(i10, i13, z11, str5, str6, str7, str4);
    }

    public final int component1() {
        return this.beans;
    }

    public final int component2() {
        return this.freeItemCount;
    }

    public final boolean component3() {
        return this.isUnlimited;
    }

    public final String component4() {
        return this.name;
    }

    public final String component5() {
        return this.imageUrl;
    }

    public final String component6() {
        return this.tintColor;
    }

    public final String component7() {
        return this.displayName;
    }

    public final Price copy(int i10, int i11, boolean z10, String str, String str2, String str3, String str4) {
        j.g(str, "name");
        j.g(str2, "imageUrl");
        j.g(str3, "tintColor");
        return new Price(i10, i11, z10, str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Price)) {
            return false;
        }
        Price price = (Price) obj;
        return this.beans == price.beans && this.freeItemCount == price.freeItemCount && this.isUnlimited == price.isUnlimited && j.b(this.name, price.name) && j.b(this.imageUrl, price.imageUrl) && j.b(this.tintColor, price.tintColor) && j.b(this.displayName, price.displayName);
    }

    public final int getBeanCost(int i10) {
        int max;
        if (!this.isUnlimited && (max = Integer.max(i10 - this.freeItemCount, 0)) != 0) {
            return max * this.beans;
        }
        return 0;
    }

    public final int getBeans() {
        return this.beans;
    }

    public final String getDisplayName() {
        return this.displayName;
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
        int hashCode = ((Integer.hashCode(this.beans) * 31) + Integer.hashCode(this.freeItemCount)) * 31;
        boolean z10 = this.isUnlimited;
        if (z10) {
            z10 = true;
        }
        int hashCode2 = (((((((hashCode + (z10 ? 1 : 0)) * 31) + this.name.hashCode()) * 31) + this.imageUrl.hashCode()) * 31) + this.tintColor.hashCode()) * 31;
        String str = this.displayName;
        return hashCode2 + (str == null ? 0 : str.hashCode());
    }

    public final boolean isUnlimited() {
        return this.isUnlimited;
    }

    public final void setBeans(int i10) {
        this.beans = i10;
    }

    public final void setDisplayName(String str) {
        this.displayName = str;
    }

    public final void setFreeItemCount(int i10) {
        this.freeItemCount = i10;
    }

    public final void setImageUrl(String str) {
        j.g(str, "<set-?>");
        this.imageUrl = str;
    }

    public final void setName(String str) {
        j.g(str, "<set-?>");
        this.name = str;
    }

    public final void setTintColor(String str) {
        j.g(str, "<set-?>");
        this.tintColor = str;
    }

    public final void setUnlimited(boolean z10) {
        this.isUnlimited = z10;
    }

    public final PriceEntity toRoomEntity() {
        return new PriceEntity(this.name, this.beans, this.freeItemCount, this.imageUrl, this.tintColor, this.isUnlimited);
    }

    public String toString() {
        return "name: " + this.name + " beans:" + this.beans + " free:" + this.freeItemCount;
    }

    public int compareTo(Price price) {
        String str;
        j.g(price, "other");
        String str2 = price.displayName;
        if (str2 == null || (str = this.displayName) == null) {
            return -1;
        }
        return str.compareTo(str2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Price(int i10, int i11, boolean z10, String str, String str2, String str3, String str4, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(i10, i11, z10, str, str2, str3, (i12 & 64) != 0 ? null : str4);
    }
}

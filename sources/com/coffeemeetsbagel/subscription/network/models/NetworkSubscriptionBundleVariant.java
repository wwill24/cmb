package com.coffeemeetsbagel.subscription.network.models;

import kotlin.jvm.internal.j;
import lg.c;
import org.apache.commons.beanutils.PropertyUtils;

public final class NetworkSubscriptionBundleVariant {
    @c("marketing_type")
    private final String marketingType;
    @c("number_of_units")
    private final int numberOfUnits;
    @c("sale_full_price_comparison_sku")
    private final String saleComparisonSku;
    @c("sale_end_time_local")
    private final String saleEndTimeLocal;
    @c("sale_sku_type")
    private final String saleSkuType;
    @c("sale_start_time_local")
    private final String saleStartTimeLocal;
    @c("sku")
    private final String sku;
    @c("unit")
    private final String unit;

    public NetworkSubscriptionBundleVariant(String str, int i10, String str2, String str3, String str4, String str5, String str6, String str7) {
        j.g(str, "marketingType");
        j.g(str2, "sku");
        j.g(str3, "unit");
        this.marketingType = str;
        this.numberOfUnits = i10;
        this.sku = str2;
        this.unit = str3;
        this.saleComparisonSku = str4;
        this.saleSkuType = str5;
        this.saleStartTimeLocal = str6;
        this.saleEndTimeLocal = str7;
    }

    public static /* synthetic */ NetworkSubscriptionBundleVariant copy$default(NetworkSubscriptionBundleVariant networkSubscriptionBundleVariant, String str, int i10, String str2, String str3, String str4, String str5, String str6, String str7, int i11, Object obj) {
        NetworkSubscriptionBundleVariant networkSubscriptionBundleVariant2 = networkSubscriptionBundleVariant;
        int i12 = i11;
        return networkSubscriptionBundleVariant.copy((i12 & 1) != 0 ? networkSubscriptionBundleVariant2.marketingType : str, (i12 & 2) != 0 ? networkSubscriptionBundleVariant2.numberOfUnits : i10, (i12 & 4) != 0 ? networkSubscriptionBundleVariant2.sku : str2, (i12 & 8) != 0 ? networkSubscriptionBundleVariant2.unit : str3, (i12 & 16) != 0 ? networkSubscriptionBundleVariant2.saleComparisonSku : str4, (i12 & 32) != 0 ? networkSubscriptionBundleVariant2.saleSkuType : str5, (i12 & 64) != 0 ? networkSubscriptionBundleVariant2.saleStartTimeLocal : str6, (i12 & 128) != 0 ? networkSubscriptionBundleVariant2.saleEndTimeLocal : str7);
    }

    public final String component1() {
        return this.marketingType;
    }

    public final int component2() {
        return this.numberOfUnits;
    }

    public final String component3() {
        return this.sku;
    }

    public final String component4() {
        return this.unit;
    }

    public final String component5() {
        return this.saleComparisonSku;
    }

    public final String component6() {
        return this.saleSkuType;
    }

    public final String component7() {
        return this.saleStartTimeLocal;
    }

    public final String component8() {
        return this.saleEndTimeLocal;
    }

    public final NetworkSubscriptionBundleVariant copy(String str, int i10, String str2, String str3, String str4, String str5, String str6, String str7) {
        j.g(str, "marketingType");
        j.g(str2, "sku");
        j.g(str3, "unit");
        return new NetworkSubscriptionBundleVariant(str, i10, str2, str3, str4, str5, str6, str7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkSubscriptionBundleVariant)) {
            return false;
        }
        NetworkSubscriptionBundleVariant networkSubscriptionBundleVariant = (NetworkSubscriptionBundleVariant) obj;
        return j.b(this.marketingType, networkSubscriptionBundleVariant.marketingType) && this.numberOfUnits == networkSubscriptionBundleVariant.numberOfUnits && j.b(this.sku, networkSubscriptionBundleVariant.sku) && j.b(this.unit, networkSubscriptionBundleVariant.unit) && j.b(this.saleComparisonSku, networkSubscriptionBundleVariant.saleComparisonSku) && j.b(this.saleSkuType, networkSubscriptionBundleVariant.saleSkuType) && j.b(this.saleStartTimeLocal, networkSubscriptionBundleVariant.saleStartTimeLocal) && j.b(this.saleEndTimeLocal, networkSubscriptionBundleVariant.saleEndTimeLocal);
    }

    public final String getMarketingType() {
        return this.marketingType;
    }

    public final int getNumberOfUnits() {
        return this.numberOfUnits;
    }

    public final String getSaleComparisonSku() {
        return this.saleComparisonSku;
    }

    public final String getSaleEndTimeLocal() {
        return this.saleEndTimeLocal;
    }

    public final String getSaleSkuType() {
        return this.saleSkuType;
    }

    public final String getSaleStartTimeLocal() {
        return this.saleStartTimeLocal;
    }

    public final String getSku() {
        return this.sku;
    }

    public final String getUnit() {
        return this.unit;
    }

    public int hashCode() {
        int hashCode = ((((((this.marketingType.hashCode() * 31) + Integer.hashCode(this.numberOfUnits)) * 31) + this.sku.hashCode()) * 31) + this.unit.hashCode()) * 31;
        String str = this.saleComparisonSku;
        int i10 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.saleSkuType;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.saleStartTimeLocal;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.saleEndTimeLocal;
        if (str4 != null) {
            i10 = str4.hashCode();
        }
        return hashCode4 + i10;
    }

    public String toString() {
        return "NetworkSubscriptionBundleVariant(marketingType=" + this.marketingType + ", numberOfUnits=" + this.numberOfUnits + ", sku=" + this.sku + ", unit=" + this.unit + ", saleComparisonSku=" + this.saleComparisonSku + ", saleSkuType=" + this.saleSkuType + ", saleStartTimeLocal=" + this.saleStartTimeLocal + ", saleEndTimeLocal=" + this.saleEndTimeLocal + PropertyUtils.MAPPED_DELIM2;
    }
}

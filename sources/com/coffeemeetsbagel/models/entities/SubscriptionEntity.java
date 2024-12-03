package com.coffeemeetsbagel.models.entities;

import kotlin.jvm.internal.j;

public final class SubscriptionEntity {
    private final String bundleId;
    private final String marketingType;
    private final int numberOfUnits;
    private final String saleComparisonSku;
    private final long saleEndTimeLocal;
    private final String saleSkuType;
    private final long saleStartTimeLocal;
    private final String savingsComparisonSku;
    private final String sku;
    private final String unit;

    public SubscriptionEntity(String str, String str2, int i10, String str3, String str4, String str5, String str6, long j10, long j11, String str7) {
        j.g(str, "bundleId");
        j.g(str3, "unit");
        j.g(str7, "sku");
        this.bundleId = str;
        this.marketingType = str2;
        this.numberOfUnits = i10;
        this.unit = str3;
        this.savingsComparisonSku = str4;
        this.saleComparisonSku = str5;
        this.saleSkuType = str6;
        this.saleStartTimeLocal = j10;
        this.saleEndTimeLocal = j11;
        this.sku = str7;
    }

    public final String getBundleId() {
        return this.bundleId;
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

    public final long getSaleEndTimeLocal() {
        return this.saleEndTimeLocal;
    }

    public final String getSaleSkuType() {
        return this.saleSkuType;
    }

    public final long getSaleStartTimeLocal() {
        return this.saleStartTimeLocal;
    }

    public final String getSavingsComparisonSku() {
        return this.savingsComparisonSku;
    }

    public final String getSku() {
        return this.sku;
    }

    public final String getUnit() {
        return this.unit;
    }
}

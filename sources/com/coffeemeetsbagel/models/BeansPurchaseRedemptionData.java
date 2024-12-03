package com.coffeemeetsbagel.models;

import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class BeansPurchaseRedemptionData {
    private final String redemption_code_identifier;
    private final String sku;

    public BeansPurchaseRedemptionData(String str, String str2) {
        this.redemption_code_identifier = str;
        this.sku = str2;
    }

    public static /* synthetic */ BeansPurchaseRedemptionData copy$default(BeansPurchaseRedemptionData beansPurchaseRedemptionData, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = beansPurchaseRedemptionData.redemption_code_identifier;
        }
        if ((i10 & 2) != 0) {
            str2 = beansPurchaseRedemptionData.sku;
        }
        return beansPurchaseRedemptionData.copy(str, str2);
    }

    public final String component1() {
        return this.redemption_code_identifier;
    }

    public final String component2() {
        return this.sku;
    }

    public final BeansPurchaseRedemptionData copy(String str, String str2) {
        return new BeansPurchaseRedemptionData(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BeansPurchaseRedemptionData)) {
            return false;
        }
        BeansPurchaseRedemptionData beansPurchaseRedemptionData = (BeansPurchaseRedemptionData) obj;
        return j.b(this.redemption_code_identifier, beansPurchaseRedemptionData.redemption_code_identifier) && j.b(this.sku, beansPurchaseRedemptionData.sku);
    }

    public final String getRedemption_code_identifier() {
        return this.redemption_code_identifier;
    }

    public final String getSku() {
        return this.sku;
    }

    public int hashCode() {
        String str = this.redemption_code_identifier;
        int i10 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.sku;
        if (str2 != null) {
            i10 = str2.hashCode();
        }
        return hashCode + i10;
    }

    public String toString() {
        return "BeansPurchaseRedemptionData(redemption_code_identifier=" + this.redemption_code_identifier + ", sku=" + this.sku + PropertyUtils.MAPPED_DELIM2;
    }
}

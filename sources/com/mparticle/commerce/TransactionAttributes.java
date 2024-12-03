package com.mparticle.commerce;

import androidx.annotation.NonNull;

public class TransactionAttributes {
    private String mAffiliation = null;
    private String mCouponCode = null;
    private String mId = null;
    private Double mRevenue;
    private Double mShipping;
    private Double mTax;

    public TransactionAttributes(@NonNull TransactionAttributes transactionAttributes) {
        this.mAffiliation = transactionAttributes.mAffiliation;
        this.mRevenue = transactionAttributes.mRevenue;
        this.mShipping = transactionAttributes.mShipping;
        this.mTax = transactionAttributes.mTax;
        this.mCouponCode = transactionAttributes.mCouponCode;
        this.mId = transactionAttributes.mId;
    }

    public String getAffiliation() {
        return this.mAffiliation;
    }

    public String getCouponCode() {
        return this.mCouponCode;
    }

    @NonNull
    public String getId() {
        return this.mId;
    }

    public Double getRevenue() {
        return this.mRevenue;
    }

    public Double getShipping() {
        return this.mShipping;
    }

    public Double getTax() {
        return this.mTax;
    }

    @NonNull
    public TransactionAttributes setAffiliation(String str) {
        this.mAffiliation = str;
        return this;
    }

    @NonNull
    public TransactionAttributes setCouponCode(String str) {
        this.mCouponCode = str;
        return this;
    }

    @NonNull
    public TransactionAttributes setId(@NonNull String str) {
        this.mId = str;
        return this;
    }

    @NonNull
    public TransactionAttributes setRevenue(Double d10) {
        if (d10 != null && d10.equals(Double.valueOf(Double.NaN))) {
            d10 = null;
        }
        this.mRevenue = d10;
        return this;
    }

    @NonNull
    public TransactionAttributes setShipping(Double d10) {
        if (d10 != null && d10.equals(Double.valueOf(Double.NaN))) {
            d10 = null;
        }
        this.mShipping = d10;
        return this;
    }

    @NonNull
    public TransactionAttributes setTax(Double d10) {
        if (d10 != null && d10.equals(Double.valueOf(Double.NaN))) {
            d10 = null;
        }
        this.mTax = d10;
        return this;
    }

    public TransactionAttributes() {
    }

    public TransactionAttributes(@NonNull String str) {
        setId(str);
    }
}

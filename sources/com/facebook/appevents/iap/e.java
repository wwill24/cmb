package com.facebook.appevents.iap;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InAppPurchaseBillingClientWrapper f37755a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f37756b;

    public /* synthetic */ e(InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper, Runnable runnable) {
        this.f37755a = inAppPurchaseBillingClientWrapper;
        this.f37756b = runnable;
    }

    public final void run() {
        InAppPurchaseBillingClientWrapper.m70queryPurchaseHistory$lambda0(this.f37755a, this.f37756b);
    }
}

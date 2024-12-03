package com.facebook.appevents.iap;

import com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseAutoLogger;", "", "()V", "BILLING_CLIENT_PURCHASE_NAME", "", "logPurchase", "", "startIapLogging", "context", "Landroid/content/Context;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class InAppPurchaseAutoLogger {
    private static final String BILLING_CLIENT_PURCHASE_NAME = "com.android.billingclient.api.Purchase";
    public static final InAppPurchaseAutoLogger INSTANCE = new InAppPurchaseAutoLogger();

    private InAppPurchaseAutoLogger() {
    }

    private final void logPurchase() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                InAppPurchaseLoggerManager inAppPurchaseLoggerManager = InAppPurchaseLoggerManager.INSTANCE;
                InAppPurchaseBillingClientWrapper.Companion companion = InAppPurchaseBillingClientWrapper.Companion;
                InAppPurchaseLoggerManager.filterPurchaseLogging(companion.getPurchaseDetailsMap(), companion.getSkuDetailsMap());
                companion.getPurchaseDetailsMap().clear();
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0017, code lost:
        r1 = com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper.Companion;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void startIapLogging(android.content.Context r3) {
        /*
            java.lang.Class<com.facebook.appevents.iap.InAppPurchaseAutoLogger> r0 = com.facebook.appevents.iap.InAppPurchaseAutoLogger.class
            boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)
            if (r1 == 0) goto L_0x0009
            return
        L_0x0009:
            java.lang.String r1 = "context"
            kotlin.jvm.internal.j.g(r3, r1)     // Catch:{ all -> 0x0044 }
            java.lang.String r1 = "com.android.billingclient.api.Purchase"
            java.lang.Class r1 = com.facebook.appevents.iap.InAppPurchaseUtils.getClass(r1)     // Catch:{ all -> 0x0044 }
            if (r1 != 0) goto L_0x0017
            return
        L_0x0017:
            com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper$Companion r1 = com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper.Companion     // Catch:{ all -> 0x0044 }
            com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper r3 = r1.getOrCreateInstance(r3)     // Catch:{ all -> 0x0044 }
            if (r3 != 0) goto L_0x0020
            return
        L_0x0020:
            java.util.concurrent.atomic.AtomicBoolean r1 = r1.isServiceConnected()     // Catch:{ all -> 0x0044 }
            boolean r1 = r1.get()     // Catch:{ all -> 0x0044 }
            if (r1 == 0) goto L_0x0043
            boolean r1 = com.facebook.appevents.iap.InAppPurchaseLoggerManager.eligibleQueryPurchaseHistory()     // Catch:{ all -> 0x0044 }
            java.lang.String r2 = "inapp"
            if (r1 == 0) goto L_0x003b
            com.facebook.appevents.iap.c r1 = new com.facebook.appevents.iap.c     // Catch:{ all -> 0x0044 }
            r1.<init>()     // Catch:{ all -> 0x0044 }
            r3.queryPurchaseHistory(r2, r1)     // Catch:{ all -> 0x0044 }
            goto L_0x0043
        L_0x003b:
            com.facebook.appevents.iap.d r1 = new com.facebook.appevents.iap.d     // Catch:{ all -> 0x0044 }
            r1.<init>()     // Catch:{ all -> 0x0044 }
            r3.queryPurchase(r2, r1)     // Catch:{ all -> 0x0044 }
        L_0x0043:
            return
        L_0x0044:
            r3 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.iap.InAppPurchaseAutoLogger.startIapLogging(android.content.Context):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: startIapLogging$lambda-0  reason: not valid java name */
    public static final void m68startIapLogging$lambda0() {
        Class<InAppPurchaseAutoLogger> cls = InAppPurchaseAutoLogger.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                INSTANCE.logPurchase();
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: startIapLogging$lambda-1  reason: not valid java name */
    public static final void m69startIapLogging$lambda1() {
        Class<InAppPurchaseAutoLogger> cls = InAppPurchaseAutoLogger.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                INSTANCE.logPurchase();
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }
}

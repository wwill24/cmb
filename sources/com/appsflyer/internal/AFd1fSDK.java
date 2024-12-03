package com.appsflyer.internal;

import android.util.Base64;
import com.appsflyer.AFLogger;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import java.net.MalformedURLException;
import java.net.URL;

public final class AFd1fSDK extends AFd1kSDK<String> {
    private final AFe1fSDK AFLogger;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AFd1fSDK(@androidx.annotation.NonNull com.appsflyer.internal.AFe1fSDK r8, @androidx.annotation.NonNull com.appsflyer.internal.AFc1xSDK r9) {
        /*
            r7 = this;
            com.appsflyer.internal.AFd1wSDK r0 = r8.afWarnLog
            if (r0 == 0) goto L_0x0005
            goto L_0x0007
        L_0x0005:
            com.appsflyer.internal.AFd1wSDK r0 = com.appsflyer.internal.AFd1wSDK.CACHED_EVENT
        L_0x0007:
            r2 = r0
            r0 = 1
            com.appsflyer.internal.AFd1wSDK[] r3 = new com.appsflyer.internal.AFd1wSDK[r0]
            r0 = 0
            com.appsflyer.internal.AFd1wSDK r1 = com.appsflyer.internal.AFd1wSDK.RC_CDN
            r3[r0] = r1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r8.afErrorLog
            r0.append(r1)
            java.lang.String r1 = "-"
            r0.append(r1)
            java.lang.String r1 = values(r8)
            r0.append(r1)
            java.lang.String r5 = r0.toString()
            java.lang.String r6 = r8.afErrorLog
            r1 = r7
            r4 = r9
            r1.<init>(r2, r3, r4, r5, r6)
            r7.AFLogger = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1fSDK.<init>(com.appsflyer.internal.AFe1fSDK, com.appsflyer.internal.AFc1xSDK):void");
    }

    private static String values(AFe1fSDK aFe1fSDK) {
        try {
            return new URL(aFe1fSDK.AFLogger).getHost();
        } catch (MalformedURLException unused) {
            return "";
        }
    }

    /* access modifiers changed from: protected */
    public final AFc1oSDK<String> AFInAppEventParameterName(String str) {
        String encodeToString = Base64.encodeToString(this.AFLogger.valueOf(), 2);
        AFLogger.afInfoLog("cached data: ".concat(String.valueOf(encodeToString)));
        this.afInfoLog.valueOf(this.AFLogger.AFLogger, encodeToString);
        return this.afErrorLog.values(this.AFLogger);
    }

    /* access modifiers changed from: protected */
    public final boolean AFLogger() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final AppsFlyerRequestListener afErrorLog() {
        return this.AFLogger.AFInAppEventType;
    }
}

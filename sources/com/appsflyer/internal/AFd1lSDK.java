package com.appsflyer.internal;

import androidx.annotation.NonNull;
import com.appsflyer.deeplink.DeepLinkResult;

public final class AFd1lSDK extends AFd1tSDK<DeepLinkResult> {
    private final AFb1pSDK AFLogger;
    private DeepLinkResult afDebugLog;

    /* renamed from: com.appsflyer.internal.AFd1lSDK$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] values;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.appsflyer.deeplink.DeepLinkResult$Status[] r0 = com.appsflyer.deeplink.DeepLinkResult.Status.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                values = r0
                com.appsflyer.deeplink.DeepLinkResult$Status r1 = com.appsflyer.deeplink.DeepLinkResult.Status.FOUND     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = values     // Catch:{ NoSuchFieldError -> 0x001d }
                com.appsflyer.deeplink.DeepLinkResult$Status r1 = com.appsflyer.deeplink.DeepLinkResult.Status.NOT_FOUND     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = values     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.appsflyer.deeplink.DeepLinkResult$Status r1 = com.appsflyer.deeplink.DeepLinkResult.Status.ERROR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1lSDK.AnonymousClass3.<clinit>():void");
        }
    }

    public AFd1lSDK(@NonNull AFb1pSDK aFb1pSDK) {
        super(AFd1wSDK.DLSDK, new AFd1wSDK[]{AFd1wSDK.RC_CDN}, "DdlSdk");
        this.AFLogger = aFb1pSDK;
    }

    @NonNull
    public final AFc1aSDK AFInAppEventParameterName() throws Exception {
        DeepLinkResult AFLogger2 = this.AFLogger.AFLogger();
        this.afDebugLog = AFLogger2;
        if (AnonymousClass3.values[AFLogger2.getStatus().ordinal()] == 1) {
            return AFc1aSDK.SUCCESS;
        }
        if (this.afDebugLog.getError() == DeepLinkResult.Error.TIMEOUT) {
            return AFc1aSDK.TIMEOUT;
        }
        return AFc1aSDK.FAILURE;
    }

    public final long AFInAppEventType() {
        return 90000;
    }

    public final boolean valueOf() {
        return false;
    }
}

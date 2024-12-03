package com.appsflyer.internal;

import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.apache.commons.cli.HelpFormatter;

public final class AFe1sSDK extends AFd1kSDK<Map<String, Object>> {
    private static final List<String> AFLogger = Arrays.asList(new String[]{"googleplay", "playstore", "googleplaystore"});
    private final AFc1pSDK AFLogger$LogLevel;
    private final AFe1nSDK AFVersionDeclaration;
    private final AFb1gSDK afErrorLogForExcManagerOnly;
    private Map<String, Object> afWarnLog;
    private final AFb1fSDK getLevel;
    private String onAppOpenAttributionNative;

    public AFe1sSDK(@NonNull AFc1xSDK aFc1xSDK) {
        super(AFd1wSDK.GCDSDK, new AFd1wSDK[]{AFd1wSDK.RC_CDN}, aFc1xSDK, "GCD-FETCH");
        this.AFLogger$LogLevel = aFc1xSDK.AFKeystoreWrapper();
        this.afErrorLogForExcManagerOnly = aFc1xSDK.afErrorLog();
        this.AFVersionDeclaration = aFc1xSDK.afRDLog();
        this.getLevel = aFc1xSDK.values();
        this.AFInAppEventParameterName.add(AFd1wSDK.CONVERSION);
        this.AFInAppEventParameterName.add(AFd1wSDK.LAUNCH);
    }

    public final AFc1oSDK<Map<String, Object>> AFInAppEventParameterName(@NonNull String str) {
        String str2;
        String AFKeystoreWrapper = AFb1zSDK.AFKeystoreWrapper(this.afErrorLogForExcManagerOnly, this.getLevel.values());
        if (AFKeystoreWrapper != null && !AFKeystoreWrapper.trim().isEmpty()) {
            if (!AFLogger.contains(AFKeystoreWrapper.toLowerCase())) {
                str2 = HelpFormatter.DEFAULT_OPT_PREFIX.concat(AFKeystoreWrapper);
                AFc1oSDK<Map<String, Object>> valueOf = this.AFLogger$LogLevel.valueOf(str2, str);
                StringBuilder sb2 = new StringBuilder("[GCD-B01] URL: ");
                sb2.append(valueOf.AFKeystoreWrapper.values());
                AFc1sSDK.valueOf(sb2.toString());
                return valueOf;
            }
            AFLogger.afWarnLog(String.format("[GCD] AF detected using redundant Google-Play channel for attribution - %s. Using without channel postfix.", new Object[]{AFKeystoreWrapper}));
        }
        str2 = "";
        AFc1oSDK<Map<String, Object>> valueOf2 = this.AFLogger$LogLevel.valueOf(str2, str);
        StringBuilder sb22 = new StringBuilder("[GCD-B01] URL: ");
        sb22.append(valueOf2.AFKeystoreWrapper.values());
        AFc1sSDK.valueOf(sb22.toString());
        return valueOf2;
    }

    public final void AFKeystoreWrapper() {
        super.AFKeystoreWrapper();
        Map<String, Object> map = this.afWarnLog;
        String str = this.onAppOpenAttributionNative;
        if (map != null) {
            AFe1tSDK.AFInAppEventParameterName(map);
        } else if (str == null || str.isEmpty()) {
            AFe1tSDK.AFInAppEventType("Unknown error");
        } else {
            AFe1tSDK.AFInAppEventType(str);
        }
    }

    public final boolean AFLogger() {
        return false;
    }

    public final AppsFlyerRequestListener afErrorLog() {
        return null;
    }

    public final boolean valueOf() {
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0047 A[Catch:{ AFd1uSDK -> 0x0136, Exception -> 0x0107, all -> 0x0105 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007d A[Catch:{ AFd1uSDK -> 0x0136, Exception -> 0x0107, all -> 0x0105 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ae A[Catch:{ AFd1uSDK -> 0x0136, Exception -> 0x0107, all -> 0x0105 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00fa A[Catch:{ AFd1uSDK -> 0x0136, Exception -> 0x0107, all -> 0x0105 }] */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.appsflyer.internal.AFc1aSDK AFInAppEventParameterName() throws java.lang.Exception {
        /*
            r14 = this;
            java.lang.String r0 = "af_channel"
            java.lang.String r1 = "is_first_launch"
            java.lang.String r2 = "af_siteid"
            java.lang.String r3 = "[GCD-A03] Server retrieving attempt finished"
            com.appsflyer.internal.AFe1xSDK r4 = r14.afRDLog
            boolean r4 = r4.AFKeystoreWrapper()
            if (r4 != 0) goto L_0x014b
            com.appsflyer.internal.AFc1aSDK r4 = com.appsflyer.internal.AFc1aSDK.FAILURE
            r5 = 0
            r6 = r5
        L_0x0014:
            r7 = 2
            if (r6 > r7) goto L_0x014a
            r4 = 1
            if (r6 < r7) goto L_0x001c
            r7 = r4
            goto L_0x001d
        L_0x001c:
            r7 = r5
        L_0x001d:
            com.appsflyer.internal.AFe1nSDK r8 = r14.AFVersionDeclaration
            long r9 = java.lang.System.currentTimeMillis()
            r8.afWarnLog = r9
            com.appsflyer.internal.AFc1aSDK r8 = super.AFInAppEventParameterName()     // Catch:{ AFd1uSDK -> 0x0136, Exception -> 0x0107 }
            com.appsflyer.internal.AFc1dSDK<Result> r9 = r14.afDebugLog     // Catch:{ AFd1uSDK -> 0x0136, Exception -> 0x0107 }
            if (r9 != 0) goto L_0x002f
            goto L_0x0121
        L_0x002f:
            int r10 = r9.getStatusCode()     // Catch:{ AFd1uSDK -> 0x0136, Exception -> 0x0107 }
            r11 = 403(0x193, float:5.65E-43)
            if (r10 == r11) goto L_0x003e
            r11 = 500(0x1f4, float:7.0E-43)
            if (r10 < r11) goto L_0x003c
            goto L_0x003e
        L_0x003c:
            r11 = r5
            goto L_0x003f
        L_0x003e:
            r11 = r4
        L_0x003f:
            boolean r12 = r9.isSuccessful()     // Catch:{ AFd1uSDK -> 0x0136, Exception -> 0x0107 }
            r13 = 404(0x194, float:5.66E-43)
            if (r12 != 0) goto L_0x0069
            if (r10 != r13) goto L_0x004a
            goto L_0x0069
        L_0x004a:
            if (r7 != 0) goto L_0x0052
            if (r11 != 0) goto L_0x0121
            goto L_0x0052
        L_0x004f:
            r4 = r8
            goto L_0x012b
        L_0x0052:
            java.lang.String r4 = "Error connection to server: "
            java.lang.String r8 = java.lang.String.valueOf(r10)     // Catch:{ AFd1uSDK -> 0x0136, Exception -> 0x0107 }
            java.lang.String r4 = r4.concat(r8)     // Catch:{ AFd1uSDK -> 0x0136, Exception -> 0x0107 }
            r14.onAppOpenAttributionNative = r4     // Catch:{ AFd1uSDK -> 0x0136, Exception -> 0x0107 }
            com.appsflyer.internal.AFc1aSDK r0 = com.appsflyer.internal.AFc1aSDK.FAILURE     // Catch:{ AFd1uSDK -> 0x0136, Exception -> 0x0107 }
        L_0x0060:
            com.appsflyer.internal.AFe1nSDK r1 = r14.AFVersionDeclaration
            r1.AFKeystoreWrapper(r6)
            com.appsflyer.AFLogger.afDebugLog(r3)
            return r0
        L_0x0069:
            java.lang.Object r8 = r9.getBody()     // Catch:{ AFd1uSDK -> 0x0136, Exception -> 0x0107 }
            java.util.Map r8 = (java.util.Map) r8     // Catch:{ AFd1uSDK -> 0x0136, Exception -> 0x0107 }
            int r9 = r9.getStatusCode()     // Catch:{ AFd1uSDK -> 0x0136, Exception -> 0x0107 }
            java.lang.String r10 = "iscache"
            java.lang.Object r10 = r8.get(r10)     // Catch:{ AFd1uSDK -> 0x0136, Exception -> 0x0107 }
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch:{ AFd1uSDK -> 0x0136, Exception -> 0x0107 }
            if (r9 != r13) goto L_0x0095
            java.lang.String r9 = "error_reason"
            r8.remove(r9)     // Catch:{ AFd1uSDK -> 0x0136, Exception -> 0x0107 }
            java.lang.String r9 = "status_code"
            r8.remove(r9)     // Catch:{ AFd1uSDK -> 0x0136, Exception -> 0x0107 }
            java.lang.String r9 = "af_status"
            java.lang.String r11 = "Organic"
            r8.put(r9, r11)     // Catch:{ AFd1uSDK -> 0x0136, Exception -> 0x0107 }
            java.lang.String r9 = "af_message"
            java.lang.String r11 = "organic install"
            r8.put(r9, r11)     // Catch:{ AFd1uSDK -> 0x0136, Exception -> 0x0107 }
        L_0x0095:
            if (r10 == 0) goto L_0x00a8
            boolean r9 = r10.booleanValue()     // Catch:{ AFd1uSDK -> 0x0136, Exception -> 0x0107 }
            if (r9 != 0) goto L_0x00a8
            com.appsflyer.internal.AFb1gSDK r9 = r14.afErrorLogForExcManagerOnly     // Catch:{ AFd1uSDK -> 0x0136, Exception -> 0x0107 }
            java.lang.String r10 = "appsflyerConversionDataCacheExpiration"
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ AFd1uSDK -> 0x0136, Exception -> 0x0107 }
            r9.AFInAppEventType((java.lang.String) r10, (long) r11)     // Catch:{ AFd1uSDK -> 0x0136, Exception -> 0x0107 }
        L_0x00a8:
            boolean r9 = r8.containsKey(r2)     // Catch:{ AFd1uSDK -> 0x0136, Exception -> 0x0107 }
            if (r9 == 0) goto L_0x00db
            boolean r9 = r8.containsKey(r0)     // Catch:{ AFd1uSDK -> 0x0136, Exception -> 0x0107 }
            if (r9 == 0) goto L_0x00ca
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ AFd1uSDK -> 0x0136, Exception -> 0x0107 }
            java.lang.String r9 = "[Invite] Detected App-Invite via channel: "
            r4.<init>(r9)     // Catch:{ AFd1uSDK -> 0x0136, Exception -> 0x0107 }
            java.lang.Object r9 = r8.get(r0)     // Catch:{ AFd1uSDK -> 0x0136, Exception -> 0x0107 }
            r4.append(r9)     // Catch:{ AFd1uSDK -> 0x0136, Exception -> 0x0107 }
            java.lang.String r4 = r4.toString()     // Catch:{ AFd1uSDK -> 0x0136, Exception -> 0x0107 }
            com.appsflyer.AFLogger.afDebugLog(r4)     // Catch:{ AFd1uSDK -> 0x0136, Exception -> 0x0107 }
            goto L_0x00db
        L_0x00ca:
            java.lang.String r9 = "[CrossPromotion] App was installed via %s's Cross Promotion"
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ AFd1uSDK -> 0x0136, Exception -> 0x0107 }
            java.lang.Object r10 = r8.get(r2)     // Catch:{ AFd1uSDK -> 0x0136, Exception -> 0x0107 }
            r4[r5] = r10     // Catch:{ AFd1uSDK -> 0x0136, Exception -> 0x0107 }
            java.lang.String r4 = java.lang.String.format(r9, r4)     // Catch:{ AFd1uSDK -> 0x0136, Exception -> 0x0107 }
            com.appsflyer.AFLogger.afDebugLog(r4)     // Catch:{ AFd1uSDK -> 0x0136, Exception -> 0x0107 }
        L_0x00db:
            java.lang.Boolean r4 = java.lang.Boolean.FALSE     // Catch:{ AFd1uSDK -> 0x0136, Exception -> 0x0107 }
            r8.put(r1, r4)     // Catch:{ AFd1uSDK -> 0x0136, Exception -> 0x0107 }
            org.json.b r4 = new org.json.b     // Catch:{ AFd1uSDK -> 0x0136, Exception -> 0x0107 }
            r4.<init>((java.util.Map<?, ?>) r8)     // Catch:{ AFd1uSDK -> 0x0136, Exception -> 0x0107 }
            java.lang.String r4 = r4.toString()     // Catch:{ AFd1uSDK -> 0x0136, Exception -> 0x0107 }
            com.appsflyer.internal.AFb1gSDK r9 = r14.afErrorLogForExcManagerOnly     // Catch:{ AFd1uSDK -> 0x0136, Exception -> 0x0107 }
            java.lang.String r10 = "attributionId"
            r9.AFInAppEventParameterName((java.lang.String) r10, (java.lang.String) r4)     // Catch:{ AFd1uSDK -> 0x0136, Exception -> 0x0107 }
            com.appsflyer.internal.AFb1gSDK r4 = r14.afErrorLogForExcManagerOnly     // Catch:{ AFd1uSDK -> 0x0136, Exception -> 0x0107 }
            java.lang.String r9 = "sixtyDayConversionData"
            boolean r4 = r4.valueOf(r9)     // Catch:{ AFd1uSDK -> 0x0136, Exception -> 0x0107 }
            if (r4 != 0) goto L_0x00ff
            java.lang.Boolean r4 = java.lang.Boolean.TRUE     // Catch:{ AFd1uSDK -> 0x0136, Exception -> 0x0107 }
            r8.put(r1, r4)     // Catch:{ AFd1uSDK -> 0x0136, Exception -> 0x0107 }
        L_0x00ff:
            r14.afWarnLog = r8     // Catch:{ AFd1uSDK -> 0x0136, Exception -> 0x0107 }
            com.appsflyer.internal.AFc1aSDK r0 = com.appsflyer.internal.AFc1aSDK.SUCCESS     // Catch:{ AFd1uSDK -> 0x0136, Exception -> 0x0107 }
            goto L_0x0060
        L_0x0105:
            r0 = move-exception
            goto L_0x0141
        L_0x0107:
            r4 = move-exception
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0105 }
            java.lang.String r9 = "[GCD] Error: "
            r8.<init>(r9)     // Catch:{ all -> 0x0105 }
            java.lang.String r9 = r4.getMessage()     // Catch:{ all -> 0x0105 }
            r8.append(r9)     // Catch:{ all -> 0x0105 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0105 }
            com.appsflyer.AFLogger.afErrorLog(r8, r4)     // Catch:{ all -> 0x0105 }
            com.appsflyer.internal.AFc1aSDK r8 = com.appsflyer.internal.AFc1aSDK.FAILURE     // Catch:{ all -> 0x0105 }
            if (r7 != 0) goto L_0x012f
        L_0x0121:
            com.appsflyer.internal.AFe1nSDK r4 = r14.AFVersionDeclaration
            r4.AFKeystoreWrapper(r6)
            com.appsflyer.AFLogger.afDebugLog(r3)
            goto L_0x004f
        L_0x012b:
            int r6 = r6 + 1
            goto L_0x0014
        L_0x012f:
            java.lang.String r0 = r4.getMessage()     // Catch:{ all -> 0x0105 }
            r14.onAppOpenAttributionNative = r0     // Catch:{ all -> 0x0105 }
            throw r4     // Catch:{ all -> 0x0105 }
        L_0x0136:
            r0 = move-exception
            java.lang.String r1 = "[GCD-E05] AppsFlyer dev key is missing"
            com.appsflyer.AFLogger.afDebugLog(r1)     // Catch:{ all -> 0x0105 }
            java.lang.String r1 = "AppsFlyer dev key is missing"
            r14.onAppOpenAttributionNative = r1     // Catch:{ all -> 0x0105 }
            throw r0     // Catch:{ all -> 0x0105 }
        L_0x0141:
            com.appsflyer.internal.AFe1nSDK r1 = r14.AFVersionDeclaration
            r1.AFKeystoreWrapper(r6)
            com.appsflyer.AFLogger.afDebugLog(r3)
            throw r0
        L_0x014a:
            return r4
        L_0x014b:
            java.lang.String r0 = "[GCD-E03] 'isStopTracking' enabled"
            com.appsflyer.AFLogger.afDebugLog(r0)
            java.lang.String r0 = "'isStopTracking' enabled"
            r14.onAppOpenAttributionNative = r0
            com.appsflyer.internal.AFd1pSDK r0 = new com.appsflyer.internal.AFd1pSDK
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFe1sSDK.AFInAppEventParameterName():com.appsflyer.internal.AFc1aSDK");
    }
}

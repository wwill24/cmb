package com.appsflyer.internal;

import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;

public final class AFd1gSDK extends AFd1eSDK {
    private static char AFVersionDeclaration = '灖';
    private static int AppsFlyer2dXConversionCallback = 0;
    private static char afWarnLog = '넩';
    private static char init = '虊';
    private static int onAppOpenAttributionNative = 1;
    private static char onInstallConversionDataLoadedNative = '';
    private final String afErrorLogForExcManagerOnly;
    private final AFc1ySDK getLevel;

    public AFd1gSDK(@NonNull String str, @NonNull AFc1xSDK aFc1xSDK) {
        super(new AFe1rSDK(aFc1xSDK.afErrorLogForExcManagerOnly().values), aFc1xSDK, str);
        this.getLevel = aFc1xSDK.afErrorLogForExcManagerOnly();
        this.afErrorLogForExcManagerOnly = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v5, resolved type: char[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v6, resolved type: java.lang.String} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void AFInAppEventType(java.lang.String r12, int r13, java.lang.Object[] r14) {
        /*
            if (r12 == 0) goto L_0x0006
            char[] r12 = r12.toCharArray()
        L_0x0006:
            char[] r12 = (char[]) r12
            java.lang.Object r0 = com.appsflyer.internal.AFf1dSDK.values
            monitor-enter(r0)
            int r1 = r12.length     // Catch:{ all -> 0x0075 }
            char[] r1 = new char[r1]     // Catch:{ all -> 0x0075 }
            r2 = 0
            com.appsflyer.internal.AFf1dSDK.AFKeystoreWrapper = r2     // Catch:{ all -> 0x0075 }
            r3 = 2
            char[] r3 = new char[r3]     // Catch:{ all -> 0x0075 }
        L_0x0014:
            int r4 = com.appsflyer.internal.AFf1dSDK.AFKeystoreWrapper     // Catch:{ all -> 0x0075 }
            int r5 = r12.length     // Catch:{ all -> 0x0075 }
            if (r4 >= r5) goto L_0x006c
            char r5 = r12[r4]     // Catch:{ all -> 0x0075 }
            r3[r2] = r5     // Catch:{ all -> 0x0075 }
            int r4 = r4 + 1
            char r4 = r12[r4]     // Catch:{ all -> 0x0075 }
            r5 = 1
            r3[r5] = r4     // Catch:{ all -> 0x0075 }
            r4 = 58224(0xe370, float:8.1589E-41)
            r6 = r2
        L_0x0028:
            r7 = 16
            if (r6 >= r7) goto L_0x005b
            char r7 = r3[r5]     // Catch:{ all -> 0x0075 }
            char r8 = r3[r2]     // Catch:{ all -> 0x0075 }
            int r9 = r8 + r4
            int r10 = r8 << 4
            char r11 = onInstallConversionDataLoadedNative     // Catch:{ all -> 0x0075 }
            int r10 = r10 + r11
            r9 = r9 ^ r10
            int r10 = r8 >>> 5
            char r11 = init     // Catch:{ all -> 0x0075 }
            int r10 = r10 + r11
            r9 = r9 ^ r10
            int r7 = r7 - r9
            char r7 = (char) r7     // Catch:{ all -> 0x0075 }
            r3[r5] = r7     // Catch:{ all -> 0x0075 }
            int r9 = r7 + r4
            int r10 = r7 << 4
            char r11 = afWarnLog     // Catch:{ all -> 0x0075 }
            int r10 = r10 + r11
            r9 = r9 ^ r10
            int r7 = r7 >>> 5
            char r10 = AFVersionDeclaration     // Catch:{ all -> 0x0075 }
            int r7 = r7 + r10
            r7 = r7 ^ r9
            int r8 = r8 - r7
            char r7 = (char) r8     // Catch:{ all -> 0x0075 }
            r3[r2] = r7     // Catch:{ all -> 0x0075 }
            r7 = 40503(0x9e37, float:5.6757E-41)
            int r4 = r4 - r7
            int r6 = r6 + 1
            goto L_0x0028
        L_0x005b:
            int r4 = com.appsflyer.internal.AFf1dSDK.AFKeystoreWrapper     // Catch:{ all -> 0x0075 }
            char r6 = r3[r2]     // Catch:{ all -> 0x0075 }
            r1[r4] = r6     // Catch:{ all -> 0x0075 }
            int r6 = r4 + 1
            char r5 = r3[r5]     // Catch:{ all -> 0x0075 }
            r1[r6] = r5     // Catch:{ all -> 0x0075 }
            int r4 = r4 + 2
            com.appsflyer.internal.AFf1dSDK.AFKeystoreWrapper = r4     // Catch:{ all -> 0x0075 }
            goto L_0x0014
        L_0x006c:
            java.lang.String r12 = new java.lang.String     // Catch:{ all -> 0x0075 }
            r12.<init>(r1, r2, r13)     // Catch:{ all -> 0x0075 }
            monitor-exit(r0)     // Catch:{ all -> 0x0075 }
            r14[r2] = r12
            return
        L_0x0075:
            r12 = move-exception
            monitor-exit(r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1gSDK.AFInAppEventType(java.lang.String, int, java.lang.Object[]):void");
    }

    private void AFLogger$LogLevel() {
        int i10 = AppsFlyer2dXConversionCallback + 39;
        onAppOpenAttributionNative = i10 % 128;
        int i11 = i10 % 2;
        this.AFLogger$LogLevel.valueOf("sentRegisterRequestToAF", true);
        AFLogger.afDebugLog("[register] Successfully registered for Uninstall Tracking");
        int i12 = AppsFlyer2dXConversionCallback + 25;
        onAppOpenAttributionNative = i12 % 128;
        int i13 = i12 % 2;
    }

    public final void AFKeystoreWrapper() {
        char c10;
        char c11;
        int i10 = AppsFlyer2dXConversionCallback + 123;
        onAppOpenAttributionNative = i10 % 128;
        if (i10 % 2 == 0) {
            c10 = 7;
        } else {
            c10 = '>';
        }
        if (c10 != 7) {
            super.AFKeystoreWrapper();
            AFc1dSDK<Result> aFc1dSDK = this.afDebugLog;
            if (aFc1dSDK != null) {
                c11 = '0';
            } else {
                c11 = 'B';
            }
            if (c11 == '0' && aFc1dSDK.isSuccessful()) {
                AFLogger$LogLevel();
            }
            int i11 = AppsFlyer2dXConversionCallback + 65;
            onAppOpenAttributionNative = i11 % 128;
            int i12 = i11 % 2;
            return;
        }
        super.AFKeystoreWrapper();
        throw null;
    }

    /* access modifiers changed from: protected */
    public final boolean AFLogger() {
        int i10 = AppsFlyer2dXConversionCallback;
        int i11 = i10 + 85;
        onAppOpenAttributionNative = i11 % 128;
        int i12 = i11 % 2;
        int i13 = i10 + 17;
        onAppOpenAttributionNative = i13 % 128;
        int i14 = i13 % 2;
        return false;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0033, code lost:
        if (r0 != null) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0185, code lost:
        throw new java.lang.IllegalStateException("Context is not provided, can't send register request");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0023, code lost:
        if (r0 != null) goto L_0x0035;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void values(com.appsflyer.internal.AFa1sSDK r10) {
        /*
            r9 = this;
            int r0 = AppsFlyer2dXConversionCallback
            int r0 = r0 + 61
            int r1 = r0 % 128
            onAppOpenAttributionNative = r1
            int r0 = r0 % 2
            r1 = 77
            if (r0 != 0) goto L_0x0011
            r0 = 37
            goto L_0x0012
        L_0x0011:
            r0 = r1
        L_0x0012:
            r2 = 0
            if (r0 == r1) goto L_0x0028
            super.values(r10)
            com.appsflyer.internal.AFc1ySDK r0 = r9.getLevel
            android.content.Context r0 = r0.values
            com.appsflyer.internal.AFb1zSDK r1 = com.appsflyer.internal.AFb1zSDK.AFInAppEventType()
            r3 = 17
            int r3 = r3 / r2
            if (r0 == 0) goto L_0x017e
            goto L_0x0035
        L_0x0026:
            r10 = move-exception
            throw r10
        L_0x0028:
            super.values(r10)
            com.appsflyer.internal.AFc1ySDK r0 = r9.getLevel
            android.content.Context r0 = r0.values
            com.appsflyer.internal.AFb1zSDK r1 = com.appsflyer.internal.AFb1zSDK.AFInAppEventType()
            if (r0 == 0) goto L_0x017e
        L_0x0035:
            boolean r3 = r1.values()
            r4 = 1
            if (r3 != 0) goto L_0x0171
            android.content.pm.PackageManager r3 = r0.getPackageManager()
            java.lang.String r5 = r0.getPackageName()
            android.content.pm.PackageInfo r5 = r3.getPackageInfo(r5, r2)     // Catch:{ all -> 0x007e }
            java.lang.String r6 = "app_version_code"
            int r7 = r5.versionCode     // Catch:{ all -> 0x007e }
            java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x007e }
            r10.valueOf(r6, r7)     // Catch:{ all -> 0x007e }
            java.lang.String r6 = "app_version_name"
            java.lang.String r7 = r5.versionName     // Catch:{ all -> 0x007e }
            r10.valueOf(r6, r7)     // Catch:{ all -> 0x007e }
            android.content.pm.ApplicationInfo r6 = r5.applicationInfo     // Catch:{ all -> 0x007e }
            java.lang.CharSequence r3 = r3.getApplicationLabel(r6)     // Catch:{ all -> 0x007e }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x007e }
            java.lang.String r6 = "app_name"
            r10.valueOf(r6, r3)     // Catch:{ all -> 0x007e }
            long r5 = r5.firstInstallTime     // Catch:{ all -> 0x007e }
            java.lang.String r3 = "yyyy-MM-dd_HHmmssZ"
            java.text.SimpleDateFormat r7 = new java.text.SimpleDateFormat     // Catch:{ all -> 0x007e }
            java.util.Locale r8 = java.util.Locale.US     // Catch:{ all -> 0x007e }
            r7.<init>(r3, r8)     // Catch:{ all -> 0x007e }
            java.lang.String r3 = "installDate"
            java.lang.String r5 = com.appsflyer.internal.AFb1zSDK.AFKeystoreWrapper((java.text.SimpleDateFormat) r7, (long) r5)     // Catch:{ all -> 0x007e }
            r10.valueOf(r3, r5)     // Catch:{ all -> 0x007e }
            goto L_0x0084
        L_0x007e:
            r3 = move-exception
            java.lang.String r5 = "Exception while collecting application version info."
            com.appsflyer.AFLogger.afErrorLog(r5, r3)
        L_0x0084:
            java.util.Map r3 = r10.AFInAppEventType()
            com.appsflyer.internal.AFb1zSDK.AFKeystoreWrapper((android.content.Context) r0, (java.util.Map<java.lang.String, ? super java.lang.String>) r3)
            java.lang.String r3 = com.appsflyer.internal.AFb1zSDK.AFKeystoreWrapper()
            r5 = 25
            if (r3 == 0) goto L_0x0095
            r6 = r5
            goto L_0x0096
        L_0x0095:
            r6 = r2
        L_0x0096:
            if (r6 == r5) goto L_0x0099
            goto L_0x009e
        L_0x0099:
            java.lang.String r5 = "appUserId"
            r10.valueOf(r5, r3)
        L_0x009e:
            java.lang.String r3 = "model"
            java.lang.String r5 = android.os.Build.MODEL     // Catch:{ all -> 0x00c0 }
            r10.valueOf(r3, r5)     // Catch:{ all -> 0x00c0 }
            java.lang.String r3 = "틺똾瓓솰Ⲙ"
            int r5 = android.view.KeyEvent.getDeadChar(r2, r2)     // Catch:{ all -> 0x00c0 }
            int r5 = r5 + 5
            java.lang.Object[] r6 = new java.lang.Object[r4]     // Catch:{ all -> 0x00c0 }
            AFInAppEventType(r3, r5, r6)     // Catch:{ all -> 0x00c0 }
            r3 = r6[r2]     // Catch:{ all -> 0x00c0 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x00c0 }
            java.lang.String r3 = r3.intern()     // Catch:{ all -> 0x00c0 }
            java.lang.String r5 = android.os.Build.BRAND     // Catch:{ all -> 0x00c0 }
            r10.valueOf(r3, r5)     // Catch:{ all -> 0x00c0 }
            goto L_0x00c6
        L_0x00c0:
            r3 = move-exception
            java.lang.String r5 = "Exception while collecting device brand and model."
            com.appsflyer.AFLogger.afErrorLog(r5, r3)
        L_0x00c6:
            com.appsflyer.AppsFlyerProperties r3 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r5 = "deviceTrackingDisabled"
            boolean r3 = r3.getBoolean(r5, r2)
            if (r3 == 0) goto L_0x00d4
            r3 = r4
            goto L_0x00d5
        L_0x00d4:
            r3 = r2
        L_0x00d5:
            if (r3 == r4) goto L_0x00d8
            goto L_0x00dd
        L_0x00d8:
            java.lang.String r3 = "true"
            r10.valueOf(r5, r3)
        L_0x00dd:
            android.content.ContentResolver r3 = r0.getContentResolver()
            com.appsflyer.internal.AFc1vSDK$AFa1wSDK r3 = com.appsflyer.internal.AFa1bSDK.values((android.content.ContentResolver) r3)
            if (r3 == 0) goto L_0x0103
            int r5 = onAppOpenAttributionNative
            int r5 = r5 + 9
            int r6 = r5 % 128
            AppsFlyer2dXConversionCallback = r6
            int r5 = r5 % 2
            java.lang.String r5 = r3.AFInAppEventType
            java.lang.String r6 = "amazon_aid"
            r10.valueOf(r6, r5)
            java.lang.Boolean r3 = r3.valueOf
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r5 = "amazon_aid_limit"
            r10.valueOf(r5, r3)
        L_0x0103:
            com.appsflyer.AppsFlyerProperties r3 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r5 = "advertiserId"
            java.lang.String r3 = r3.getString(r5)
            if (r3 == 0) goto L_0x0111
            r6 = r4
            goto L_0x0112
        L_0x0111:
            r6 = r2
        L_0x0112:
            if (r6 == r4) goto L_0x0115
            goto L_0x0124
        L_0x0115:
            int r4 = AppsFlyer2dXConversionCallback
            int r4 = r4 + 67
            int r6 = r4 % 128
            onAppOpenAttributionNative = r6
            int r4 = r4 % 2
            if (r4 == 0) goto L_0x016a
            r10.valueOf(r5, r3)
        L_0x0124:
            com.appsflyer.internal.AFe1xSDK r3 = r9.afRDLog
            java.lang.String r3 = r3.AFInAppEventType
            java.lang.String r4 = "devkey"
            r10.valueOf(r4, r3)
            java.lang.ref.WeakReference r3 = new java.lang.ref.WeakReference
            r3.<init>(r0)
            java.lang.String r3 = com.appsflyer.internal.AFb1xSDK.AFInAppEventParameterName(r3)
            java.lang.String r4 = "uid"
            r10.valueOf(r4, r3)
            java.lang.String r3 = r9.afErrorLogForExcManagerOnly
            java.lang.String r4 = "af_gcm_token"
            r10.valueOf(r4, r3)
            com.appsflyer.internal.AFb1gSDK r3 = r9.AFLogger$LogLevel
            java.lang.String r4 = "appsFlyerCount"
            int r2 = r3.AFInAppEventType((java.lang.String) r4, (int) r2)
            java.lang.String r2 = java.lang.Integer.toString(r2)
            java.lang.String r3 = "launch_counter"
            r10.valueOf(r3, r2)
            int r2 = android.os.Build.VERSION.SDK_INT
            java.lang.String r2 = java.lang.Integer.toString(r2)
            java.lang.String r3 = "sdk"
            r10.valueOf(r3, r2)
            java.lang.String r0 = r1.valueOf((android.content.Context) r0)
            if (r0 == 0) goto L_0x0169
            java.lang.String r1 = "channel"
            r10.valueOf(r1, r0)
        L_0x0169:
            return
        L_0x016a:
            r10.valueOf(r5, r3)
            r10 = 0
            throw r10     // Catch:{ all -> 0x016f }
        L_0x016f:
            r10 = move-exception
            throw r10
        L_0x0171:
            java.lang.String r10 = "CustomerUserId not set, Tracking is disabled"
            com.appsflyer.AFLogger.afInfoLog(r10, r4)
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "CustomerUserId not set, register is not sent"
            r10.<init>(r0)
            throw r10
        L_0x017e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "Context is not provided, can't send register request"
            r10.<init>(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1gSDK.values(com.appsflyer.internal.AFa1sSDK):void");
    }
}

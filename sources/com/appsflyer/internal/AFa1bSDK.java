package com.appsflyer.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.AFb1aSDK;
import com.appsflyer.internal.AFc1rSDK;
import com.appsflyer.internal.AFc1vSDK;
import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class AFa1bSDK implements AFc1zSDK {
    static Boolean AFInAppEventParameterName;
    static String valueOf;
    private final AFc1ySDK AFKeystoreWrapper;

    public AFa1bSDK() {
    }

    public AFa1bSDK(AFc1ySDK aFc1ySDK) {
        j.g(aFc1ySDK, "");
        this.AFKeystoreWrapper = aFc1ySDK;
    }

    private File AFInAppEventType() {
        Context context = this.AFKeystoreWrapper.values;
        if (context == null) {
            return null;
        }
        File file = new File(context.getFilesDir(), "AFExceptionsCache");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v12, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v13, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v15, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v16, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v17, resolved type: java.lang.Object} */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0040, code lost:
        if (r8.length() == 0) goto L_0x0042;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008d A[SYNTHETIC, Splitter:B:34:0x008d] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0126  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.appsflyer.internal.AFc1vSDK.AFa1wSDK AFKeystoreWrapper(android.content.Context r13, java.util.Map<java.lang.String, java.lang.Object> r14) {
        /*
            java.lang.String r0 = "advertiserIdEnabled"
            java.lang.String r1 = "advertiserId"
            boolean r2 = values()
            r3 = 0
            if (r2 != 0) goto L_0x000c
            return r3
        L_0x000c:
            java.lang.String r2 = "Trying to fetch GAID.."
            com.appsflyer.AFLogger.afInfoLog(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r4 = -1
            com.google.android.gms.common.c r5 = com.google.android.gms.common.c.p()     // Catch:{ all -> 0x0020 }
            int r4 = r5.i(r13)     // Catch:{ all -> 0x0020 }
            goto L_0x0026
        L_0x0020:
            r5 = move-exception
            java.lang.String r6 = "isGooglePlayServicesAvailable error"
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r6, r5)
        L_0x0026:
            r5 = 0
            r6 = 1
            com.google.android.gms.ads.identifier.AdvertisingIdClient$Info r7 = com.google.android.gms.ads.identifier.AdvertisingIdClient.getAdvertisingIdInfo(r13)     // Catch:{ all -> 0x0061 }
            if (r7 == 0) goto L_0x0054
            java.lang.String r8 = r7.getId()     // Catch:{ all -> 0x0061 }
            boolean r7 = r7.isLimitAdTrackingEnabled()     // Catch:{ all -> 0x004d }
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r7)     // Catch:{ all -> 0x004d }
            if (r8 == 0) goto L_0x0042
            int r7 = r8.length()     // Catch:{ all -> 0x004a }
            if (r7 != 0) goto L_0x0047
        L_0x0042:
            java.lang.String r7 = "emptyOrNull |"
            r2.append(r7)     // Catch:{ all -> 0x004a }
        L_0x0047:
            r9 = r6
            goto L_0x00f2
        L_0x004a:
            r7 = move-exception
            r9 = r6
            goto L_0x004f
        L_0x004d:
            r7 = move-exception
            r9 = r5
        L_0x004f:
            r12 = r7
            r7 = r3
            r3 = r8
            r8 = r12
            goto L_0x0065
        L_0x0054:
            java.lang.String r7 = "gpsAdInfo-null |"
            r2.append(r7)     // Catch:{ all -> 0x0061 }
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0061 }
            java.lang.String r8 = "GpsAdIndo is null"
            r7.<init>(r8)     // Catch:{ all -> 0x0061 }
            throw r7     // Catch:{ all -> 0x0061 }
        L_0x0061:
            r7 = move-exception
            r9 = r5
            r8 = r7
            r7 = r3
        L_0x0065:
            java.lang.String r10 = r8.getMessage()
            com.appsflyer.AFLogger.afErrorLog(r10, r8)
            java.lang.Class r8 = r8.getClass()
            java.lang.String r8 = r8.getSimpleName()
            r2.append(r8)
            java.lang.String r8 = " |"
            r2.append(r8)
            java.lang.String r10 = "WARNING: Google Play Services is missing."
            com.appsflyer.AFLogger.afInfoLog(r10)
            com.appsflyer.AppsFlyerProperties r10 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r11 = "enableGpsFallback"
            boolean r10 = r10.getBoolean(r11, r6)
            if (r10 == 0) goto L_0x00f0
            com.appsflyer.internal.AFa1fSDK$AFa1vSDK r3 = com.appsflyer.internal.AFa1fSDK.AFInAppEventType(r13)     // Catch:{ all -> 0x00aa }
            java.lang.String r7 = r3.AFKeystoreWrapper     // Catch:{ all -> 0x00aa }
            boolean r3 = r3.AFKeystoreWrapper()     // Catch:{ all -> 0x00aa }
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ all -> 0x00aa }
            if (r7 == 0) goto L_0x00a3
            int r10 = r7.length()     // Catch:{ all -> 0x00aa }
            if (r10 != 0) goto L_0x00a8
        L_0x00a3:
            java.lang.String r10 = "emptyOrNull (bypass) |"
            r2.append(r10)     // Catch:{ all -> 0x00aa }
        L_0x00a8:
            r8 = r7
            goto L_0x00f2
        L_0x00aa:
            r3 = move-exception
            java.lang.String r7 = r3.getMessage()
            com.appsflyer.AFLogger.afErrorLog(r7, r3, r6, r5, r5)
            java.lang.Class r5 = r3.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r2.append(r5)
            r2.append(r8)
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r8 = r5.getString(r1)
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r5 = r5.getString(r0)
            boolean r5 = java.lang.Boolean.parseBoolean(r5)
            r5 = r5 ^ r6
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            java.lang.String r7 = r3.getLocalizedMessage()
            if (r7 == 0) goto L_0x00e7
            java.lang.String r3 = r3.getLocalizedMessage()
            com.appsflyer.AFLogger.afInfoLog(r3)
            goto L_0x00ee
        L_0x00e7:
            java.lang.String r3 = r3.toString()
            com.appsflyer.AFLogger.afInfoLog(r3)
        L_0x00ee:
            r3 = r5
            goto L_0x00f2
        L_0x00f0:
            r8 = r3
            r3 = r7
        L_0x00f2:
            java.lang.Class r13 = r13.getClass()
            java.lang.String r13 = r13.getName()
            java.lang.String r5 = "android.app.ReceiverRestrictedContext"
            boolean r13 = r13.equals(r5)
            if (r13 == 0) goto L_0x0120
            com.appsflyer.AppsFlyerProperties r13 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r8 = r13.getString(r1)
            com.appsflyer.AppsFlyerProperties r13 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r13 = r13.getString(r0)
            boolean r13 = java.lang.Boolean.parseBoolean(r13)
            r13 = r13 ^ r6
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r13)
            java.lang.String r13 = "context = android.app.ReceiverRestrictedContext |"
            r2.append(r13)
        L_0x0120:
            int r13 = r2.length()
            if (r13 <= 0) goto L_0x013f
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r4)
            java.lang.String r4 = ": "
            r13.append(r4)
            r13.append(r2)
            java.lang.String r13 = r13.toString()
            java.lang.String r2 = "gaidError"
            r14.put(r2, r13)
        L_0x013f:
            if (r8 == 0) goto L_0x0172
            if (r3 == 0) goto L_0x0172
            r14.put(r1, r8)
            boolean r13 = r3.booleanValue()
            r13 = r13 ^ r6
            java.lang.String r13 = java.lang.String.valueOf(r13)
            r14.put(r0, r13)
            com.appsflyer.AppsFlyerProperties r13 = com.appsflyer.AppsFlyerProperties.getInstance()
            r13.set((java.lang.String) r1, (java.lang.String) r8)
            com.appsflyer.AppsFlyerProperties r13 = com.appsflyer.AppsFlyerProperties.getInstance()
            boolean r1 = r3.booleanValue()
            r1 = r1 ^ r6
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r13.set((java.lang.String) r0, (java.lang.String) r1)
            java.lang.String r13 = java.lang.String.valueOf(r9)
            java.lang.String r0 = "isGaidWithGps"
            r14.put(r0, r13)
        L_0x0172:
            com.appsflyer.internal.AFc1vSDK$AFa1wSDK r13 = new com.appsflyer.internal.AFc1vSDK$AFa1wSDK
            r13.<init>(r8, r3)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1bSDK.AFKeystoreWrapper(android.content.Context, java.util.Map):com.appsflyer.internal.AFc1vSDK$AFa1wSDK");
    }

    private File afRDLog() {
        File AFInAppEventType = AFInAppEventType();
        if (AFInAppEventType == null) {
            return null;
        }
        File file = new File(AFInAppEventType, "6.10.0");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static AFc1vSDK.AFa1wSDK values(ContentResolver contentResolver) {
        String str;
        if (!values() || contentResolver == null || AppsFlyerProperties.getInstance().getString("amazon_aid") != null || !"Amazon".equals(Build.MANUFACTURER)) {
            return null;
        }
        int i10 = Settings.Secure.getInt(contentResolver, "limit_ad_tracking", 2);
        if (i10 == 0) {
            return new AFc1vSDK.AFa1wSDK(Settings.Secure.getString(contentResolver, "advertising_id"), Boolean.FALSE);
        }
        if (i10 == 2) {
            return null;
        }
        try {
            str = Settings.Secure.getString(contentResolver, "advertising_id");
        } catch (Throwable th2) {
            AFLogger.afErrorLog("Couldn't fetch Amazon Advertising ID (Ad-Tracking is limited!)", th2);
            str = "";
        }
        return new AFc1vSDK.AFa1wSDK(str, Boolean.TRUE);
    }

    public final boolean AFInAppEventParameterName() {
        return AFInAppEventType(new String[0]);
    }

    public final int valueOf() {
        int i10 = 0;
        for (AFb1aSDK aFb1aSDK : AFKeystoreWrapper()) {
            i10 += aFb1aSDK.AFInAppEventParameterName;
        }
        return i10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00cd, code lost:
        if (((java.lang.Boolean) kotlin.collections.CollectionsKt___CollectionsKt.M(r15)).booleanValue() != false) goto L_0x00cf;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean AFInAppEventType(java.lang.String... r15) {
        /*
            r14 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.j.g(r15, r0)
            monitor-enter(r14)
            java.io.File r0 = r14.AFInAppEventType()     // Catch:{ all -> 0x00d2 }
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x00cf
            int r3 = r15.length     // Catch:{ all -> 0x00d2 }
            if (r3 != 0) goto L_0x0013
            r3 = r2
            goto L_0x0014
        L_0x0013:
            r3 = r1
        L_0x0014:
            if (r3 == 0) goto L_0x002c
            java.lang.String r15 = "delete all exceptions"
            java.lang.String r1 = ""
            kotlin.jvm.internal.j.g(r15, r1)     // Catch:{ all -> 0x00d2 }
            java.lang.String r1 = "[Exception Manager]: "
            java.lang.String r15 = r1.concat(r15)     // Catch:{ all -> 0x00d2 }
            com.appsflyer.AFLogger.afRDLog(r15)     // Catch:{ all -> 0x00d2 }
            boolean r1 = kotlin.io.j.k(r0)     // Catch:{ all -> 0x00d2 }
            goto L_0x00d0
        L_0x002c:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d2 }
            java.lang.String r4 = "delete all exceptions except for: "
            r3.<init>(r4)     // Catch:{ all -> 0x00d2 }
            java.lang.String r6 = ", "
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 62
            r13 = 0
            r5 = r15
            java.lang.String r4 = kotlin.collections.l.c0(r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x00d2 }
            r3.append(r4)     // Catch:{ all -> 0x00d2 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00d2 }
            java.lang.String r4 = ""
            kotlin.jvm.internal.j.g(r3, r4)     // Catch:{ all -> 0x00d2 }
            java.lang.String r4 = "[Exception Manager]: "
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x00d2 }
            java.lang.String r3 = r4.concat(r3)     // Catch:{ all -> 0x00d2 }
            com.appsflyer.AFLogger.afRDLog(r3)     // Catch:{ all -> 0x00d2 }
            java.io.File[] r0 = r0.listFiles()     // Catch:{ all -> 0x00d2 }
            if (r0 == 0) goto L_0x00cf
            java.lang.String r3 = ""
            kotlin.jvm.internal.j.f(r0, r3)     // Catch:{ all -> 0x00d2 }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x00d2 }
            r3.<init>()     // Catch:{ all -> 0x00d2 }
            int r4 = r0.length     // Catch:{ all -> 0x00d2 }
            r5 = r1
        L_0x006d:
            if (r5 >= r4) goto L_0x0081
            r6 = r0[r5]     // Catch:{ all -> 0x00d2 }
            java.lang.String r7 = r6.getName()     // Catch:{ all -> 0x00d2 }
            boolean r7 = kotlin.collections.l.v(r15, r7)     // Catch:{ all -> 0x00d2 }
            if (r7 != 0) goto L_0x007e
            r3.add(r6)     // Catch:{ all -> 0x00d2 }
        L_0x007e:
            int r5 = r5 + 1
            goto L_0x006d
        L_0x0081:
            java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ all -> 0x00d2 }
            r0 = 10
            int r0 = kotlin.collections.r.t(r3, r0)     // Catch:{ all -> 0x00d2 }
            r15.<init>(r0)     // Catch:{ all -> 0x00d2 }
            java.util.Iterator r0 = r3.iterator()     // Catch:{ all -> 0x00d2 }
        L_0x0090:
            boolean r3 = r0.hasNext()     // Catch:{ all -> 0x00d2 }
            if (r3 == 0) goto L_0x00ad
            java.lang.Object r3 = r0.next()     // Catch:{ all -> 0x00d2 }
            java.io.File r3 = (java.io.File) r3     // Catch:{ all -> 0x00d2 }
            java.lang.String r4 = ""
            kotlin.jvm.internal.j.f(r3, r4)     // Catch:{ all -> 0x00d2 }
            boolean r3 = kotlin.io.j.k(r3)     // Catch:{ all -> 0x00d2 }
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ all -> 0x00d2 }
            r15.add(r3)     // Catch:{ all -> 0x00d2 }
            goto L_0x0090
        L_0x00ad:
            java.util.Set r15 = kotlin.collections.CollectionsKt___CollectionsKt.B0(r15)     // Catch:{ all -> 0x00d2 }
            boolean r0 = r15.isEmpty()     // Catch:{ all -> 0x00d2 }
            if (r0 == 0) goto L_0x00bd
            java.lang.Boolean r15 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00d2 }
            java.util.Set r15 = kotlin.collections.m0.d(r15)     // Catch:{ all -> 0x00d2 }
        L_0x00bd:
            int r0 = r15.size()     // Catch:{ all -> 0x00d2 }
            if (r0 != r2) goto L_0x00d0
            java.lang.Object r15 = kotlin.collections.CollectionsKt___CollectionsKt.M(r15)     // Catch:{ all -> 0x00d2 }
            java.lang.Boolean r15 = (java.lang.Boolean) r15     // Catch:{ all -> 0x00d2 }
            boolean r15 = r15.booleanValue()     // Catch:{ all -> 0x00d2 }
            if (r15 == 0) goto L_0x00d0
        L_0x00cf:
            r1 = r2
        L_0x00d0:
            monitor-exit(r14)
            return r1
        L_0x00d2:
            r15 = move-exception
            monitor-exit(r14)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1bSDK.AFInAppEventType(java.lang.String[]):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0061 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.appsflyer.internal.AFc1vSDK.AFa1wSDK values(android.content.Context r5) {
        /*
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r1 = valueOf
            r2 = 1
            if (r1 == 0) goto L_0x000b
            r3 = r2
            goto L_0x000c
        L_0x000b:
            r3 = 0
        L_0x000c:
            r4 = 0
            if (r3 == 0) goto L_0x0011
        L_0x000f:
            r5 = r4
            goto L_0x0053
        L_0x0011:
            java.lang.Boolean r1 = AFInAppEventParameterName
            if (r1 == 0) goto L_0x001b
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x0027
        L_0x001b:
            java.lang.Boolean r1 = AFInAppEventParameterName
            if (r1 != 0) goto L_0x0051
            java.lang.String r1 = "collectOAID"
            boolean r1 = r0.getBoolean(r1, r2)
            if (r1 == 0) goto L_0x0051
        L_0x0027:
            com.appsflyer.oaid.OaidClient r1 = new com.appsflyer.oaid.OaidClient     // Catch:{ all -> 0x0046 }
            r1.<init>(r5)     // Catch:{ all -> 0x0046 }
            boolean r5 = r0.isEnableLog()     // Catch:{ all -> 0x0046 }
            r1.setLogging(r5)     // Catch:{ all -> 0x0046 }
            com.appsflyer.oaid.OaidClient$Info r5 = r1.fetch()     // Catch:{ all -> 0x0046 }
            if (r5 == 0) goto L_0x0051
            java.lang.String r0 = r5.getId()     // Catch:{ all -> 0x0046 }
            java.lang.Boolean r5 = r5.getLat()     // Catch:{ all -> 0x0043 }
            r1 = r0
            goto L_0x0053
        L_0x0043:
            r5 = move-exception
            r1 = r0
            goto L_0x0048
        L_0x0046:
            r5 = move-exception
            r1 = r4
        L_0x0048:
            java.lang.String r0 = "No OAID library"
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r0, r5)
            com.appsflyer.AFLogger.afDebugLog(r0)
            goto L_0x000f
        L_0x0051:
            r5 = r4
            r1 = r5
        L_0x0053:
            if (r1 == 0) goto L_0x0061
            com.appsflyer.internal.AFc1vSDK$AFa1wSDK r0 = new com.appsflyer.internal.AFc1vSDK$AFa1wSDK
            r0.<init>(r1, r5)
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r3)
            r0.values = r5
            return r0
        L_0x0061:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1bSDK.values(android.content.Context):com.appsflyer.internal.AFc1vSDK$AFa1wSDK");
    }

    private static boolean values() {
        Boolean bool = AFInAppEventParameterName;
        return bool == null || bool.booleanValue();
    }

    public final String values(Throwable th2, String str) {
        String str2;
        AFb1aSDK values;
        Throwable th3 = th2;
        String str3 = str;
        j.g(th3, "");
        j.g(str3, "");
        synchronized (this) {
            File afRDLog = afRDLog();
            str2 = null;
            if (afRDLog != null) {
                try {
                    j.g(th3, "");
                    j.g(str3, "");
                    StringBuilder sb2 = new StringBuilder();
                    j.g(th3, "");
                    String name = th2.getClass().getName();
                    j.f(name, "");
                    sb2.append(name);
                    sb2.append(": ");
                    sb2.append(str3);
                    String obj = sb2.toString();
                    j.g(th3, "");
                    j.g(th3, "");
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(th3);
                    sb3.append(10);
                    sb3.append(CollectionsKt___CollectionsKt.W(AFc1rSDK.values(th2), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, AFc1rSDK.AnonymousClass5.AFKeystoreWrapper, 30, (Object) null));
                    AFb1aSDK aFb1aSDK = new AFb1aSDK(obj, AFc1vSDK.AFa1wSDK.AFKeystoreWrapper(sb3.toString()), b.b(th2), 0, 8, (DefaultConstructorMarker) null);
                    String str4 = aFb1aSDK.valueOf;
                    File file = new File(afRDLog, str4);
                    if (file.exists() && (values = AFb1aSDK.AFa1zSDK.values(h.e(file, (Charset) null, 1, (Object) null))) != null) {
                        values.AFInAppEventParameterName++;
                        aFb1aSDK = values;
                    }
                    StringBuilder sb4 = new StringBuilder("label=");
                    sb4.append(AFc1vSDK.AFa1wSDK.AFInAppEventType(aFb1aSDK.AFInAppEventType));
                    sb4.append("\nhashName=");
                    sb4.append(AFc1vSDK.AFa1wSDK.AFInAppEventType(aFb1aSDK.valueOf));
                    sb4.append("\nstackTrace=");
                    sb4.append(AFc1vSDK.AFa1wSDK.AFInAppEventType(aFb1aSDK.AFKeystoreWrapper));
                    sb4.append("\nc=");
                    sb4.append(aFb1aSDK.AFInAppEventParameterName);
                    h.h(file, sb4.toString(), (Charset) null, 2, (Object) null);
                    str2 = str4;
                } catch (Exception e10) {
                    StringBuilder sb5 = new StringBuilder("Could not cache exception\n");
                    StringBuilder sb6 = new StringBuilder(" ");
                    sb6.append(e10.getMessage());
                    String obj2 = sb6.toString();
                    j.g(obj2, "");
                    sb5.append("[Exception Manager]: ".concat(String.valueOf(obj2)));
                    AFLogger.afRDLog(sb5.toString());
                }
            }
        }
        return str2;
    }

    public final List<AFb1aSDK> AFKeystoreWrapper() {
        List<AFb1aSDK> list;
        synchronized (this) {
            File afRDLog = afRDLog();
            list = null;
            if (afRDLog != null) {
                try {
                    File[] listFiles = afRDLog.listFiles();
                    if (listFiles != null) {
                        j.f(listFiles, "");
                        ArrayList arrayList = new ArrayList();
                        for (File file : listFiles) {
                            AFb1aSDK.AFa1zSDK aFa1zSDK = AFb1aSDK.AFa1zSDK;
                            j.f(file, "");
                            AFb1aSDK values = AFb1aSDK.AFa1zSDK.values(h.e(file, (Charset) null, 1, (Object) null));
                            if (values != null) {
                                arrayList.add(values);
                            }
                        }
                        list = arrayList;
                    }
                } catch (Throwable th2) {
                    StringBuilder sb2 = new StringBuilder("Could not get stored exceptions\n ");
                    sb2.append(th2.getMessage());
                    String obj = sb2.toString();
                    j.g(obj, "");
                    AFLogger.afRDLog("[Exception Manager]: ".concat(String.valueOf(obj)));
                }
            }
            if (list == null) {
                list = q.j();
            }
        }
        return list;
    }
}

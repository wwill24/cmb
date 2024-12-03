package com.appsflyer.internal;

import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.components.network.http.exceptions.HttpException;
import java.io.InterruptedIOException;

public final class AFd1cSDK extends AFd1tSDK<AFd1aSDK> {
    private final AFb1fSDK AFLogger;
    private final AFc1pSDK AFLogger$LogLevel;
    private final AFe1wSDK AFVersionDeclaration;
    public AFb1kSDK afDebugLog;
    public final AFd1dSDK afErrorLog;
    private final AFe1xSDK afErrorLogForExcManagerOnly;
    private final AFe1zSDK afInfoLog;
    public AFd1aSDK afRDLog = null;
    private final String afWarnLog;
    private final AFe1uSDK getLevel;

    public AFd1cSDK(@NonNull AFe1zSDK aFe1zSDK, @NonNull AFb1fSDK aFb1fSDK, @NonNull AFe1xSDK aFe1xSDK, @NonNull AFe1wSDK aFe1wSDK, @NonNull AFc1pSDK aFc1pSDK, @NonNull AFe1uSDK aFe1uSDK, @NonNull String str, AFd1dSDK aFd1dSDK) {
        super(AFd1wSDK.RC_CDN, new AFd1wSDK[0], "UpdateRemoteConfiguration");
        this.afInfoLog = aFe1zSDK;
        this.AFLogger = aFb1fSDK;
        this.afErrorLogForExcManagerOnly = aFe1xSDK;
        this.AFVersionDeclaration = aFe1wSDK;
        this.AFLogger$LogLevel = aFc1pSDK;
        this.getLevel = aFe1uSDK;
        this.afWarnLog = str;
        this.afErrorLog = aFd1dSDK;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0055 A[SYNTHETIC, Splitter:B:12:0x0055] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.appsflyer.internal.AFd1aSDK afErrorLog() throws java.lang.InterruptedException, java.io.InterruptedIOException {
        /*
            r16 = this;
            r10 = r16
            java.lang.String r0 = " seconds"
            long r8 = java.lang.System.currentTimeMillis()
            java.lang.String r1 = r10.afWarnLog
            com.appsflyer.internal.AFe1xSDK r2 = r10.afErrorLogForExcManagerOnly
            java.lang.String r2 = r2.AFInAppEventType
            r3 = 2
            java.lang.String r4 = "CFG: Dev key is not set, SDK is not started."
            r11 = 1
            r13 = 0
            if (r2 == 0) goto L_0x0047
            java.lang.String r5 = r2.trim()
            int r5 = r5.length()
            if (r5 != 0) goto L_0x0020
            goto L_0x0047
        L_0x0020:
            if (r1 != 0) goto L_0x0028
            java.lang.String r1 = "CFG: Can't create CDN token, domain or version is not provided."
            com.appsflyer.AFLogger.afWarnLog(r1)
            goto L_0x004a
        L_0x0028:
            r5 = 3
            java.lang.String[] r5 = new java.lang.String[r5]
            java.lang.String r6 = "appsflyersdk.com"
            r5[r13] = r6
            r5[r11] = r1
            com.appsflyer.internal.AFb1fSDK r1 = r10.AFLogger
            com.appsflyer.internal.AFc1ySDK r1 = r1.valueOf
            android.content.Context r1 = r1.values
            java.lang.String r1 = r1.getPackageName()
            r5[r3] = r1
            java.lang.String r1 = com.appsflyer.internal.AFa1aSDK.values((java.lang.String[]) r5)
            java.lang.String r1 = com.appsflyer.internal.AFa1aSDK.values(r1, r2)
            r14 = r1
            goto L_0x004b
        L_0x0047:
            com.appsflyer.AFLogger.afWarnLog(r4)
        L_0x004a:
            r14 = 0
        L_0x004b:
            if (r14 != 0) goto L_0x0055
            java.lang.String r0 = "CFG: can't create CDN token, skipping fetch config"
            com.appsflyer.AFLogger.afRDLog(r0)
            com.appsflyer.internal.AFd1aSDK r0 = com.appsflyer.internal.AFd1aSDK.FAILURE
            return r0
        L_0x0055:
            com.appsflyer.internal.AFe1uSDK r1 = r10.getLevel     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            boolean r1 = r1.valueOf()     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            if (r1 == 0) goto L_0x0153
            java.lang.String r1 = "CFG: Cached config is expired, updating..."
            com.appsflyer.AFLogger.afInfoLog(r1)     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            com.appsflyer.internal.AFe1uSDK r1 = r10.getLevel     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            boolean r1 = r1.AFKeystoreWrapper()     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            com.appsflyer.internal.AFe1uSDK r2 = r10.getLevel     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            boolean r2 = r2.AFInAppEventType()     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            com.appsflyer.internal.AFc1pSDK r5 = r10.AFLogger$LogLevel     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            r6 = 1500(0x5dc, float:2.102E-42)
            com.appsflyer.internal.AFc1oSDK r1 = r5.AFInAppEventParameterName(r1, r2, r14, r6)     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            com.appsflyer.internal.AFc1dSDK r15 = r1.values()     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            boolean r1 = r15.isSuccessful()     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            if (r1 == 0) goto L_0x0131
            java.lang.Object r1 = r15.getBody()     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            com.appsflyer.internal.AFb1oSDK r1 = (com.appsflyer.internal.AFb1oSDK) r1     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            java.lang.String r2 = "x-amz-meta-af-auth-v1"
            java.lang.String r2 = r15.AFInAppEventType(r2)     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            java.lang.String r5 = "CF-Cache-Status"
            java.lang.String r6 = r15.AFInAppEventType(r5)     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            com.appsflyer.internal.AFe1xSDK r5 = r10.afErrorLogForExcManagerOnly     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            java.lang.String r5 = r5.AFInAppEventType     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            if (r5 == 0) goto L_0x012b
            java.lang.String r7 = r5.trim()     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            int r7 = r7.length()     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            if (r7 != 0) goto L_0x00a4
            goto L_0x012b
        L_0x00a4:
            com.appsflyer.internal.AFe1zSDK r4 = r10.afInfoLog     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            com.appsflyer.internal.AFb1iSDK r2 = r4.AFInAppEventType(r1, r2, r14, r5)     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            boolean r4 = r2.AFKeystoreWrapper()     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            if (r4 == 0) goto L_0x0119
            com.appsflyer.internal.AFe1uSDK r4 = r10.getLevel     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            long r4 = r4.values()     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            java.lang.String r12 = "CFG: using max-age fallback: "
            r7.<init>(r12)     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            r7.append(r4)     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            r7.append(r0)     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            java.lang.String r7 = r7.toString()     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            com.appsflyer.AFLogger.afRDLog(r7)     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            com.appsflyer.internal.AFe1wSDK r7 = r10.AFVersionDeclaration     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            java.lang.String r13 = r1.AFKeystoreWrapper     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            java.nio.charset.Charset r3 = com.appsflyer.internal.AFe1wSDK.AFInAppEventType     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            byte[] r3 = r13.getBytes(r3)     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            r13 = 2
            java.lang.String r3 = android.util.Base64.encodeToString(r3, r13)     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            com.appsflyer.internal.AFb1gSDK r13 = r7.valueOf     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            java.lang.String r10 = "af_remote_config"
            r13.AFInAppEventParameterName((java.lang.String) r10, (java.lang.String) r3)     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            com.appsflyer.internal.AFb1gSDK r3 = r7.valueOf     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            java.lang.String r10 = "af_rc_timestamp"
            r3.AFInAppEventType((java.lang.String) r10, (long) r11)     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            com.appsflyer.internal.AFb1gSDK r3 = r7.valueOf     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            java.lang.String r10 = "af_rc_max_age"
            r3.AFInAppEventType((java.lang.String) r10, (long) r4)     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            r7.AFInAppEventParameterName = r1     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            r7.AFKeystoreWrapper = r11     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            r7.values = r4     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            java.lang.String r3 = "CFG: Config successfully updated, timeToLive: "
            r1.<init>(r3)     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            r1.append(r4)     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            r1.append(r0)     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            java.lang.String r0 = r1.toString()     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            com.appsflyer.AFLogger.afDebugLog(r0)     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            com.appsflyer.internal.AFf1xSDK r5 = r2.AFInAppEventParameterName     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            r1 = r16
            r2 = r14
            r3 = r8
            r7 = r15
            r1.valueOf(r2, r3, r5, r6, r7)     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            com.appsflyer.internal.AFd1aSDK r0 = com.appsflyer.internal.AFd1aSDK.SUCCESS     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            return r0
        L_0x0119:
            com.appsflyer.internal.AFf1xSDK r5 = r2.AFInAppEventParameterName     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            r1 = r16
            r2 = r14
            r3 = r8
            r7 = r15
            r1.valueOf(r2, r3, r5, r6, r7)     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            java.lang.String r0 = "CFG: fetched config is not valid (MITM?) refuse to use it."
            com.appsflyer.AFLogger.afWarnLog(r0)     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            com.appsflyer.internal.AFd1aSDK r0 = com.appsflyer.internal.AFd1aSDK.FAILURE     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            return r0
        L_0x012b:
            com.appsflyer.AFLogger.afWarnLog(r4)     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            com.appsflyer.internal.AFd1aSDK r0 = com.appsflyer.internal.AFd1aSDK.FAILURE     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            return r0
        L_0x0131:
            r5 = 0
            r6 = 0
            r1 = r16
            r2 = r14
            r3 = r8
            r7 = r15
            r1.valueOf(r2, r3, r5, r6, r7)     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            java.lang.String r1 = "CFG: failed to fetch remote config from CDN with status code: "
            r0.<init>(r1)     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            int r1 = r15.getStatusCode()     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            r0.append(r1)     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            com.appsflyer.AFLogger.afWarnLog(r0)     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            com.appsflyer.internal.AFd1aSDK r0 = com.appsflyer.internal.AFd1aSDK.FAILURE     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            return r0
        L_0x0153:
            java.lang.String r0 = "CFG: active config is valid, skipping fetch"
            com.appsflyer.AFLogger.afDebugLog(r0)     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            com.appsflyer.internal.AFd1aSDK r0 = com.appsflyer.internal.AFd1aSDK.USE_CACHED     // Catch:{ IOException -> 0x0192, all -> 0x015b }
            return r0
        L_0x015b:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "CFG: failed to update remote config: "
            r1.<init>(r2)
            java.lang.String r2 = r0.getMessage()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r2 = 1
            r3 = 0
            com.appsflyer.AFLogger.afErrorLog(r1, r0, r2, r3, r3)
            r5 = 0
            r6 = 0
            r7 = 0
            r10 = 0
            r1 = r16
            r2 = r14
            r3 = r8
            r8 = r10
            r9 = r0
            r1.AFInAppEventParameterName(r2, r3, r5, r6, r7, r8, r9)
            java.lang.Throwable r1 = r0.getCause()
            boolean r1 = r1 instanceof java.lang.InterruptedException
            if (r1 != 0) goto L_0x018b
            com.appsflyer.internal.AFd1aSDK r0 = com.appsflyer.internal.AFd1aSDK.FAILURE
            return r0
        L_0x018b:
            java.lang.Throwable r0 = r0.getCause()
            java.lang.InterruptedException r0 = (java.lang.InterruptedException) r0
            throw r0
        L_0x0192:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "CFG: failed to fetch remote config: "
            r1.<init>(r2)
            java.lang.String r2 = r0.getMessage()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r2 = 1
            r3 = 0
            com.appsflyer.AFLogger.afErrorLog(r1, r0, r2, r3, r3)
            boolean r1 = r0 instanceof com.appsflyer.internal.components.network.http.exceptions.ParsingException
            if (r1 == 0) goto L_0x01b7
            r1 = r0
            com.appsflyer.internal.components.network.http.exceptions.ParsingException r1 = (com.appsflyer.internal.components.network.http.exceptions.ParsingException) r1
            com.appsflyer.internal.AFc1dSDK r1 = r1.getRawResponse()
            r5 = r1
            goto L_0x01b8
        L_0x01b7:
            r5 = 0
        L_0x01b8:
            r6 = 0
            r7 = 0
            r10 = 0
            r1 = r16
            r2 = r14
            r3 = r8
            r8 = r10
            r9 = r0
            r1.AFInAppEventParameterName(r2, r3, r5, r6, r7, r8, r9)
            java.lang.Throwable r1 = r0.getCause()
            boolean r1 = r1 instanceof java.io.InterruptedIOException
            if (r1 != 0) goto L_0x01cf
            com.appsflyer.internal.AFd1aSDK r0 = com.appsflyer.internal.AFd1aSDK.FAILURE
            return r0
        L_0x01cf:
            java.lang.Throwable r0 = r0.getCause()
            java.io.InterruptedIOException r0 = (java.io.InterruptedIOException) r0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1cSDK.afErrorLog():com.appsflyer.internal.AFd1aSDK");
    }

    private void valueOf(String str, long j10, AFf1xSDK aFf1xSDK, String str2, AFc1dSDK<AFb1oSDK> aFc1dSDK) {
        AFb1oSDK aFb1oSDK;
        String str3;
        if (aFc1dSDK != null) {
            aFb1oSDK = aFc1dSDK.getBody();
        } else {
            aFb1oSDK = null;
        }
        if (str2 != null) {
            str3 = str2;
        } else {
            str3 = null;
        }
        AFInAppEventParameterName(str, j10, aFc1dSDK, aFb1oSDK, aFf1xSDK, str3, (Throwable) null);
    }

    @NonNull
    public final AFc1aSDK AFInAppEventParameterName() throws Exception {
        try {
            AFd1aSDK afErrorLog2 = afErrorLog();
            this.afRDLog = afErrorLog2;
            if (afErrorLog2 == AFd1aSDK.FAILURE) {
                return AFc1aSDK.FAILURE;
            }
            return AFc1aSDK.SUCCESS;
        } catch (InterruptedIOException | InterruptedException e10) {
            AFLogger.afErrorLogForExcManagerOnly("RC update config failed", e10);
            this.afRDLog = AFd1aSDK.FAILURE;
            return AFc1aSDK.TIMEOUT;
        }
    }

    public final long AFInAppEventType() {
        return 1500;
    }

    public final boolean valueOf() {
        return false;
    }

    private void AFInAppEventParameterName(String str, long j10, AFc1dSDK<?> aFc1dSDK, AFb1oSDK aFb1oSDK, AFf1xSDK aFf1xSDK, String str2, Throwable th2) {
        long j11;
        int i10;
        Throwable th3;
        long j12;
        AFc1dSDK<?> aFc1dSDK2 = aFc1dSDK;
        AFb1oSDK aFb1oSDK2 = aFb1oSDK;
        Throwable th4 = th2;
        if (aFc1dSDK2 != null) {
            j11 = aFc1dSDK2.AFInAppEventType.values;
            i10 = aFc1dSDK.getStatusCode();
        } else {
            j11 = 0;
            i10 = 0;
        }
        int i11 = i10;
        if (th4 instanceof HttpException) {
            th3 = th2.getCause();
            j12 = ((HttpException) th4).getMetrics().values;
        } else {
            th3 = th4;
            j12 = j11;
        }
        this.afDebugLog = new AFb1kSDK(aFb1oSDK2 != null ? aFb1oSDK2.AFInAppEventType : null, str, j12, System.currentTimeMillis() - j10, i11, aFf1xSDK, str2, th3);
    }
}

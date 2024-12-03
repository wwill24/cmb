package com.appsflyer.internal;

import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.internal.AFa1xSDK;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransportCandidate;
import org.json.b;

public class AFd1eSDK extends AFd1kSDK<String> {
    private static final AFd1wSDK[] afWarnLog = {AFd1wSDK.DLSDK, AFd1wSDK.ONELINK, AFd1wSDK.MONITORSDK, AFd1wSDK.REGISTER};
    public final AFa1sSDK AFLogger;
    protected final AFb1gSDK AFLogger$LogLevel;
    private final AFc1cSDK AFVersionDeclaration;

    public AFd1eSDK(@NonNull AFa1sSDK aFa1sSDK, @NonNull AFc1xSDK aFc1xSDK) {
        this(aFa1sSDK, aFc1xSDK, (String) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: java.lang.String} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x007a A[SYNTHETIC, Splitter:B:19:0x007a] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0080 A[Catch:{ NullPointerException -> 0x0089, all -> 0x0086 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.appsflyer.internal.AFc1oSDK<java.lang.String> AFInAppEventParameterName(java.lang.String r17) {
        /*
            r16 = this;
            r1 = r16
            java.lang.String r2 = "JSON toString of eventParams map returns null"
            java.lang.String r3 = "*Non-printing character*"
            java.lang.String r4 = "\\p{C}"
            java.lang.String r5 = "Unexpected error"
            java.lang.String r6 = ""
            com.appsflyer.internal.AFa1sSDK r0 = r1.AFLogger
            r1.values(r0)
            com.appsflyer.internal.AFa1sSDK r0 = r1.AFLogger
            java.lang.String r7 = r0.AFLogger
            java.util.Map r8 = r0.AFInAppEventType()
            r9 = 0
            r10 = 1
            org.json.b r0 = new org.json.b     // Catch:{ NullPointerException -> 0x003e, all -> 0x0037 }
            r0.<init>((java.util.Map<?, ?>) r8)     // Catch:{ NullPointerException -> 0x003e, all -> 0x0037 }
            java.lang.String r11 = r0.toString()     // Catch:{ NullPointerException -> 0x003e, all -> 0x0037 }
            if (r11 == 0) goto L_0x002c
            java.lang.String r0 = r11.replaceAll(r4, r3)     // Catch:{ NullPointerException -> 0x0035, all -> 0x0032 }
            goto L_0x00a1
        L_0x002c:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch:{ NullPointerException -> 0x0035, all -> 0x0032 }
            r0.<init>(r2)     // Catch:{ NullPointerException -> 0x0035, all -> 0x0032 }
            throw r0     // Catch:{ NullPointerException -> 0x0035, all -> 0x0032 }
        L_0x0032:
            r0 = move-exception
            r9 = r11
            goto L_0x0038
        L_0x0035:
            r0 = move-exception
            goto L_0x0040
        L_0x0037:
            r0 = move-exception
        L_0x0038:
            com.appsflyer.AFLogger.afErrorLog(r5, r0, r10)
            r0 = r6
            r11 = r9
            goto L_0x00a1
        L_0x003e:
            r0 = move-exception
            r11 = r9
        L_0x0040:
            java.lang.String r12 = "JSONObject return null String object. Trying to create AFJsonObject."
            com.appsflyer.AFLogger.afErrorLog(r12, r0, r10)
            java.lang.Object[] r0 = new java.lang.Object[r10]     // Catch:{ all -> 0x008c }
            r12 = 0
            r0[r12] = r8     // Catch:{ all -> 0x008c }
            int r8 = android.text.TextUtils.getOffsetBefore(r6, r12)     // Catch:{ all -> 0x008c }
            int r8 = r8 + 37
            int r13 = android.view.Gravity.getAbsoluteGravity(r12, r12)     // Catch:{ all -> 0x008c }
            int r13 = 74 - r13
            int r14 = android.view.KeyEvent.getMaxKeyCode()     // Catch:{ all -> 0x008c }
            int r14 = r14 >> 16
            int r14 = 17157 - r14
            char r14 = (char) r14     // Catch:{ all -> 0x008c }
            java.lang.Object r8 = com.appsflyer.internal.AFa1vSDK.AFInAppEventType(r8, r13, r14)     // Catch:{ all -> 0x008c }
            java.lang.Class r8 = (java.lang.Class) r8     // Catch:{ all -> 0x008c }
            java.lang.String r13 = "AFInAppEventParameterName"
            java.lang.Class[] r14 = new java.lang.Class[r10]     // Catch:{ all -> 0x008c }
            java.lang.Class<java.util.Map> r15 = java.util.Map.class
            r14[r12] = r15     // Catch:{ all -> 0x008c }
            java.lang.reflect.Method r8 = r8.getMethod(r13, r14)     // Catch:{ all -> 0x008c }
            java.lang.Object r0 = r8.invoke(r9, r0)     // Catch:{ all -> 0x008c }
            r8 = r0
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x008c }
            if (r8 == 0) goto L_0x0080
            java.lang.String r0 = r8.replaceAll(r4, r3)     // Catch:{ NullPointerException -> 0x0089, all -> 0x0086 }
            r11 = r8
            goto L_0x00a1
        L_0x0080:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch:{ NullPointerException -> 0x0089, all -> 0x0086 }
            r0.<init>(r2)     // Catch:{ NullPointerException -> 0x0089, all -> 0x0086 }
            throw r0     // Catch:{ NullPointerException -> 0x0089, all -> 0x0086 }
        L_0x0086:
            r0 = move-exception
            r11 = r8
            goto L_0x0096
        L_0x0089:
            r0 = move-exception
            r11 = r8
            goto L_0x009b
        L_0x008c:
            r0 = move-exception
            java.lang.Throwable r2 = r0.getCause()     // Catch:{ NullPointerException -> 0x009a, all -> 0x0095 }
            if (r2 == 0) goto L_0x0094
            throw r2     // Catch:{ NullPointerException -> 0x009a, all -> 0x0095 }
        L_0x0094:
            throw r0     // Catch:{ NullPointerException -> 0x009a, all -> 0x0095 }
        L_0x0095:
            r0 = move-exception
        L_0x0096:
            com.appsflyer.AFLogger.afErrorLog(r5, r0, r10)
            goto L_0x00a0
        L_0x009a:
            r0 = move-exception
        L_0x009b:
            java.lang.String r2 = "AFJsonObject return null String object."
            com.appsflyer.AFLogger.afErrorLog(r2, r0, r10)
        L_0x00a0:
            r0 = r6
        L_0x00a1:
            if (r11 != 0) goto L_0x00a4
            goto L_0x00a5
        L_0x00a4:
            r6 = r11
        L_0x00a5:
            boolean r2 = r0.equals(r6)
            if (r2 != 0) goto L_0x00b1
            java.lang.String r2 = "Payload contains non-printing characters"
            com.appsflyer.AFLogger.afWarnLog(r2)
            goto L_0x00b2
        L_0x00b1:
            r0 = r6
        L_0x00b2:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            java.lang.String r3 = ": preparing data: "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            com.appsflyer.internal.AFc1sSDK.valueOf((java.lang.String) r2)
            com.appsflyer.internal.AFb1uSDK r2 = r1.afInfoLog
            r2.valueOf((java.lang.String) r7, (java.lang.String) r0)
            com.appsflyer.internal.AFc1pSDK r0 = r1.afErrorLog
            com.appsflyer.internal.AFa1sSDK r2 = r1.AFLogger
            r3 = r17
            com.appsflyer.internal.AFc1oSDK r0 = r0.values(r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1eSDK.AFInAppEventParameterName(java.lang.String):com.appsflyer.internal.AFc1oSDK");
    }

    /* access modifiers changed from: protected */
    public boolean AFLogger() {
        return true;
    }

    /* access modifiers changed from: protected */
    public final AppsFlyerRequestListener afErrorLog() {
        return this.AFLogger.AFInAppEventType;
    }

    /* access modifiers changed from: protected */
    public void values(AFa1sSDK aFa1sSDK) {
        boolean z10;
        AFd1ySDK aFd1ySDK;
        if (aFa1sSDK.afErrorLog()) {
            aFa1sSDK.AFInAppEventType((Map<String, ?>) new AFa1xSDK.AFa1wSDK(aFa1sSDK.AFInAppEventType(), this.afRDLog.AFKeystoreWrapper.values));
        }
        if (aFa1sSDK.afDebugLog()) {
            aFa1sSDK.AFInAppEventType((Map<String, ?>) this.afRDLog.values());
        }
        Set<AFd1wSDK> set = this.values;
        boolean z11 = true;
        if (set.contains(AFd1wSDK.LAUNCH) || set.contains(AFd1wSDK.CONVERSION)) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (afRDLog() && z10) {
            aFa1sSDK.AFInAppEventParameterName(this.AFLogger$LogLevel.AFInAppEventType("appsFlyerCount", 0));
        }
        try {
            if (aFa1sSDK.AFInAppEventType().containsKey("appsflyerKey") && aFa1sSDK.afErrorLog()) {
                new AFa1aSDK();
                aFa1sSDK.valueOf("af_v", AFa1aSDK.valueOf(aFa1sSDK.AFInAppEventType()));
                new AFa1aSDK();
                aFa1sSDK.valueOf("af_v2", AFa1aSDK.values(aFa1sSDK.AFInAppEventType()));
            }
        } catch (Throwable th2) {
            AFLogger.afErrorLog("QUEUE: failed to update the event, is missing DevKey? Error: ".concat(String.valueOf(th2)), th2);
        }
        if (aFa1sSDK.afInfoLog()) {
            Map map = (Map) aFa1sSDK.AFInAppEventType().get("meta");
            if (map == null) {
                map = new HashMap();
                aFa1sSDK.AFInAppEventType().put("meta", map);
            }
            AFc1cSDK aFc1cSDK = this.AFVersionDeclaration;
            String AFKeystoreWrapper = aFc1cSDK.AFKeystoreWrapper();
            String AFInAppEventParameterName = aFc1cSDK.AFInAppEventParameterName();
            if (AFc1cSDK.AFInAppEventType()) {
                aFd1ySDK = AFd1ySDK.DEFAULT;
            } else {
                aFd1ySDK = AFd1ySDK.API;
            }
            AFc1bSDK aFc1bSDK = new AFc1bSDK(AFKeystoreWrapper, AFInAppEventParameterName, aFd1ySDK);
            b bVar = new b();
            bVar.put("name", (Object) aFc1bSDK.AFInAppEventType);
            AFd1ySDK aFd1ySDK2 = aFc1bSDK.AFKeystoreWrapper;
            if (aFd1ySDK2 != AFd1ySDK.DEFAULT) {
                bVar.put(FirebaseAnalytics.Param.METHOD, (Object) aFd1ySDK2.values);
            }
            String str = aFc1bSDK.valueOf;
            if (str != null && !r.w(str)) {
                z11 = false;
            }
            if (!z11) {
                bVar.put("prefix", (Object) aFc1bSDK.valueOf);
            }
            map.put(JingleS5BTransportCandidate.ATTR_HOST, bVar);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AFd1eSDK(@NonNull AFa1sSDK aFa1sSDK, @NonNull AFc1xSDK aFc1xSDK, String str) {
        super(aFa1sSDK.values(), new AFd1wSDK[]{AFd1wSDK.RC_CDN}, aFc1xSDK, str);
        int i10 = 0;
        this.AFLogger = aFa1sSDK;
        this.AFVersionDeclaration = aFc1xSDK.AppsFlyer2dXConversionCallback();
        this.AFLogger$LogLevel = aFc1xSDK.afErrorLog();
        AFd1wSDK[] aFd1wSDKArr = afWarnLog;
        int length = aFd1wSDKArr.length;
        while (i10 < length) {
            if (this.AFKeystoreWrapper != aFd1wSDKArr[i10]) {
                i10++;
            } else {
                return;
            }
        }
        int i11 = this.AFLogger.afDebugLog;
        AFd1wSDK aFd1wSDK = this.AFKeystoreWrapper;
        if (i11 <= 0) {
            AFd1wSDK aFd1wSDK2 = AFd1wSDK.CONVERSION;
            if (aFd1wSDK != aFd1wSDK2) {
                this.values.add(aFd1wSDK2);
                return;
            }
            return;
        }
        this.AFInAppEventParameterName.add(AFd1wSDK.CONVERSION);
    }
}

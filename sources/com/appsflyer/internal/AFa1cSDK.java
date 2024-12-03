package com.appsflyer.internal;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerInAppPurchaseValidatorListener;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.attribution.RequestError;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.jivesoftware.smackx.mam.element.MamElements;
import org.json.b;

public final class AFa1cSDK implements Runnable {
    private static String valueOf = "https://%ssdk-services.%s/validate-android-signature";
    private static String values;
    private String AFInAppEventParameterName;
    private WeakReference<Context> AFInAppEventType;
    private final Intent AFKeystoreWrapper;
    private String AFLogger;
    private Map<String, String> AFVersionDeclaration;
    private String afDebugLog;
    /* access modifiers changed from: private */
    public String afErrorLog;
    /* access modifiers changed from: private */
    public String afInfoLog;
    /* access modifiers changed from: private */
    public String afRDLog;

    static {
        StringBuilder sb2 = new StringBuilder("https://%svalidate.%s/api/v");
        sb2.append(AFb1zSDK.AFKeystoreWrapper);
        sb2.append("/androidevent?buildnumber=6.10.0&app_id=");
        values = sb2.toString();
    }

    AFa1cSDK(Context context, String str, String str2, String str3, String str4, String str5, String str6, Map<String, String> map, Intent intent) {
        this.AFInAppEventType = new WeakReference<>(context);
        this.AFInAppEventParameterName = str;
        this.afDebugLog = str2;
        this.afRDLog = str4;
        this.afInfoLog = str5;
        this.afErrorLog = str6;
        this.AFVersionDeclaration = map;
        this.AFLogger = str3;
        this.AFKeystoreWrapper = intent;
    }

    private static AFd1eSDK valueOf(Context context, @NonNull AFe1aSDK aFe1aSDK) {
        AFb1zSDK.AFInAppEventType().AFKeystoreWrapper(context);
        AFc1xSDK AFInAppEventParameterName2 = AFb1zSDK.AFInAppEventType().AFInAppEventParameterName();
        aFe1aSDK.AFInAppEventParameterName(AFInAppEventParameterName2.values().values.AFInAppEventType("appsFlyerCount", 0));
        AFd1eSDK aFd1eSDK = new AFd1eSDK(aFe1aSDK, AFInAppEventParameterName2);
        AFd1xSDK afDebugLog2 = AFInAppEventParameterName2.afDebugLog();
        afDebugLog2.AFKeystoreWrapper.execute(new Runnable(aFd1eSDK) {
            private /* synthetic */ AFd1tSDK AFInAppEventParameterName;

            {
                this.AFInAppEventParameterName = r2;
            }

            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                    r6 = this;
                    com.appsflyer.internal.AFd1xSDK r0 = com.appsflyer.internal.AFd1xSDK.this
                    java.util.NavigableSet<com.appsflyer.internal.AFd1tSDK<?>> r0 = r0.afInfoLog
                    monitor-enter(r0)
                    com.appsflyer.internal.AFd1xSDK r1 = com.appsflyer.internal.AFd1xSDK.this     // Catch:{ all -> 0x018f }
                    java.util.Set<com.appsflyer.internal.AFd1tSDK<?>> r1 = r1.afErrorLog     // Catch:{ all -> 0x018f }
                    com.appsflyer.internal.AFd1tSDK r2 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x018f }
                    boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x018f }
                    if (r1 == 0) goto L_0x0026
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x018f }
                    java.lang.String r2 = "QUEUE: tried to add already running task: "
                    r1.<init>(r2)     // Catch:{ all -> 0x018f }
                    com.appsflyer.internal.AFd1tSDK r2 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x018f }
                    r1.append(r2)     // Catch:{ all -> 0x018f }
                    java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x018f }
                    com.appsflyer.AFLogger.afDebugLog(r1)     // Catch:{ all -> 0x018f }
                    monitor-exit(r0)     // Catch:{ all -> 0x018f }
                    return
                L_0x0026:
                    com.appsflyer.internal.AFd1xSDK r1 = com.appsflyer.internal.AFd1xSDK.this     // Catch:{ all -> 0x018f }
                    java.util.NavigableSet<com.appsflyer.internal.AFd1tSDK<?>> r1 = r1.afInfoLog     // Catch:{ all -> 0x018f }
                    com.appsflyer.internal.AFd1tSDK r2 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x018f }
                    boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x018f }
                    if (r1 != 0) goto L_0x017a
                    com.appsflyer.internal.AFd1xSDK r1 = com.appsflyer.internal.AFd1xSDK.this     // Catch:{ all -> 0x018f }
                    java.util.NavigableSet<com.appsflyer.internal.AFd1tSDK<?>> r1 = r1.AFLogger     // Catch:{ all -> 0x018f }
                    com.appsflyer.internal.AFd1tSDK r2 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x018f }
                    boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x018f }
                    if (r1 == 0) goto L_0x0040
                    goto L_0x017a
                L_0x0040:
                    com.appsflyer.internal.AFd1xSDK r1 = com.appsflyer.internal.AFd1xSDK.this     // Catch:{ all -> 0x018f }
                    com.appsflyer.internal.AFd1tSDK r2 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x018f }
                    java.util.Set<com.appsflyer.internal.AFd1wSDK> r3 = r2.AFInAppEventParameterName     // Catch:{ all -> 0x018f }
                    java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x018f }
                L_0x004a:
                    boolean r4 = r3.hasNext()     // Catch:{ all -> 0x018f }
                    if (r4 == 0) goto L_0x0064
                    java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x018f }
                    com.appsflyer.internal.AFd1wSDK r4 = (com.appsflyer.internal.AFd1wSDK) r4     // Catch:{ all -> 0x018f }
                    java.util.Set<com.appsflyer.internal.AFd1wSDK> r5 = r1.values     // Catch:{ all -> 0x018f }
                    boolean r5 = r5.contains(r4)     // Catch:{ all -> 0x018f }
                    if (r5 == 0) goto L_0x004a
                    java.util.Set<com.appsflyer.internal.AFd1wSDK> r5 = r2.values     // Catch:{ all -> 0x018f }
                    r5.add(r4)     // Catch:{ all -> 0x018f }
                    goto L_0x004a
                L_0x0064:
                    com.appsflyer.internal.AFd1xSDK r1 = com.appsflyer.internal.AFd1xSDK.this     // Catch:{ all -> 0x018f }
                    com.appsflyer.internal.AFd1tSDK r2 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x018f }
                    boolean r1 = r1.AFInAppEventParameterName((com.appsflyer.internal.AFd1tSDK<?>) r2)     // Catch:{ all -> 0x018f }
                    if (r1 == 0) goto L_0x0079
                    com.appsflyer.internal.AFd1xSDK r1 = com.appsflyer.internal.AFd1xSDK.this     // Catch:{ all -> 0x018f }
                    java.util.NavigableSet<com.appsflyer.internal.AFd1tSDK<?>> r1 = r1.afInfoLog     // Catch:{ all -> 0x018f }
                    com.appsflyer.internal.AFd1tSDK r2 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x018f }
                    boolean r1 = r1.add(r2)     // Catch:{ all -> 0x018f }
                    goto L_0x009d
                L_0x0079:
                    com.appsflyer.internal.AFd1xSDK r1 = com.appsflyer.internal.AFd1xSDK.this     // Catch:{ all -> 0x018f }
                    java.util.NavigableSet<com.appsflyer.internal.AFd1tSDK<?>> r1 = r1.AFLogger     // Catch:{ all -> 0x018f }
                    com.appsflyer.internal.AFd1tSDK r2 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x018f }
                    boolean r1 = r1.add(r2)     // Catch:{ all -> 0x018f }
                    if (r1 == 0) goto L_0x009d
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x018f }
                    java.lang.String r3 = "QUEUE: new task was blocked: "
                    r2.<init>(r3)     // Catch:{ all -> 0x018f }
                    com.appsflyer.internal.AFd1tSDK r3 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x018f }
                    r2.append(r3)     // Catch:{ all -> 0x018f }
                    java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x018f }
                    com.appsflyer.AFLogger.afDebugLog(r2)     // Catch:{ all -> 0x018f }
                    com.appsflyer.internal.AFd1tSDK r2 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x018f }
                    r2.values()     // Catch:{ all -> 0x018f }
                L_0x009d:
                    if (r1 == 0) goto L_0x00b0
                    com.appsflyer.internal.AFd1xSDK r2 = com.appsflyer.internal.AFd1xSDK.this     // Catch:{ all -> 0x018f }
                    java.util.NavigableSet<com.appsflyer.internal.AFd1tSDK<?>> r3 = r2.afInfoLog     // Catch:{ all -> 0x018f }
                    java.util.List<com.appsflyer.internal.AFd1tSDK<?>> r2 = r2.afDebugLog     // Catch:{ all -> 0x018f }
                    r3.addAll(r2)     // Catch:{ all -> 0x018f }
                    com.appsflyer.internal.AFd1xSDK r2 = com.appsflyer.internal.AFd1xSDK.this     // Catch:{ all -> 0x018f }
                    java.util.List<com.appsflyer.internal.AFd1tSDK<?>> r2 = r2.afDebugLog     // Catch:{ all -> 0x018f }
                    r2.clear()     // Catch:{ all -> 0x018f }
                    goto L_0x00c3
                L_0x00b0:
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x018f }
                    java.lang.String r3 = "QUEUE: task not added, it's already in the queue: "
                    r2.<init>(r3)     // Catch:{ all -> 0x018f }
                    com.appsflyer.internal.AFd1tSDK r3 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x018f }
                    r2.append(r3)     // Catch:{ all -> 0x018f }
                    java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x018f }
                    com.appsflyer.AFLogger.afDebugLog(r2)     // Catch:{ all -> 0x018f }
                L_0x00c3:
                    monitor-exit(r0)     // Catch:{ all -> 0x018f }
                    if (r1 == 0) goto L_0x0166
                    com.appsflyer.internal.AFd1xSDK r0 = com.appsflyer.internal.AFd1xSDK.this
                    java.util.Set<com.appsflyer.internal.AFd1wSDK> r0 = r0.values
                    com.appsflyer.internal.AFd1tSDK r1 = r6.AFInAppEventParameterName
                    com.appsflyer.internal.AFd1wSDK r1 = r1.AFKeystoreWrapper
                    r0.add(r1)
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    java.lang.String r1 = "QUEUE: new task added: "
                    r0.<init>(r1)
                    com.appsflyer.internal.AFd1tSDK r1 = r6.AFInAppEventParameterName
                    r0.append(r1)
                    java.lang.String r0 = r0.toString()
                    com.appsflyer.AFLogger.afDebugLog(r0)
                    com.appsflyer.internal.AFd1xSDK r0 = com.appsflyer.internal.AFd1xSDK.this
                    java.util.List<com.appsflyer.internal.AFd1zSDK> r0 = r0.AFInAppEventParameterName
                    java.util.Iterator r0 = r0.iterator()
                L_0x00ec:
                    boolean r1 = r0.hasNext()
                    if (r1 == 0) goto L_0x00f9
                    java.lang.Object r1 = r0.next()
                    com.appsflyer.internal.AFd1zSDK r1 = (com.appsflyer.internal.AFd1zSDK) r1
                    goto L_0x00ec
                L_0x00f9:
                    com.appsflyer.internal.AFd1xSDK r0 = com.appsflyer.internal.AFd1xSDK.this
                    java.util.concurrent.ExecutorService r1 = r0.valueOf
                    r1.submit(r0)
                    com.appsflyer.internal.AFd1xSDK r0 = com.appsflyer.internal.AFd1xSDK.this
                    java.util.NavigableSet<com.appsflyer.internal.AFd1tSDK<?>> r1 = r0.afInfoLog
                    monitor-enter(r1)
                    java.util.NavigableSet<com.appsflyer.internal.AFd1tSDK<?>> r2 = r0.afInfoLog     // Catch:{ all -> 0x0163 }
                    int r2 = r2.size()     // Catch:{ all -> 0x0163 }
                    java.util.NavigableSet<com.appsflyer.internal.AFd1tSDK<?>> r3 = r0.AFLogger     // Catch:{ all -> 0x0163 }
                    int r3 = r3.size()     // Catch:{ all -> 0x0163 }
                    int r2 = r2 + r3
                    int r2 = r2 + -40
                L_0x0114:
                    if (r2 <= 0) goto L_0x0161
                    java.util.NavigableSet<com.appsflyer.internal.AFd1tSDK<?>> r3 = r0.AFLogger     // Catch:{ all -> 0x0163 }
                    boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x0163 }
                    r4 = 1
                    if (r3 != 0) goto L_0x0121
                    r3 = r4
                    goto L_0x0122
                L_0x0121:
                    r3 = 0
                L_0x0122:
                    java.util.NavigableSet<com.appsflyer.internal.AFd1tSDK<?>> r5 = r0.afInfoLog     // Catch:{ all -> 0x0163 }
                    boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x0163 }
                    r4 = r4 ^ r5
                    if (r4 == 0) goto L_0x014f
                    if (r3 == 0) goto L_0x014f
                    java.util.NavigableSet<com.appsflyer.internal.AFd1tSDK<?>> r3 = r0.afInfoLog     // Catch:{ all -> 0x0163 }
                    java.lang.Object r3 = r3.first()     // Catch:{ all -> 0x0163 }
                    com.appsflyer.internal.AFd1tSDK r3 = (com.appsflyer.internal.AFd1tSDK) r3     // Catch:{ all -> 0x0163 }
                    java.util.NavigableSet<com.appsflyer.internal.AFd1tSDK<?>> r4 = r0.AFLogger     // Catch:{ all -> 0x0163 }
                    java.lang.Object r4 = r4.first()     // Catch:{ all -> 0x0163 }
                    com.appsflyer.internal.AFd1tSDK r4 = (com.appsflyer.internal.AFd1tSDK) r4     // Catch:{ all -> 0x0163 }
                    int r3 = r3.AFInAppEventParameterName(r4)     // Catch:{ all -> 0x0163 }
                    if (r3 <= 0) goto L_0x0149
                    java.util.NavigableSet<com.appsflyer.internal.AFd1tSDK<?>> r3 = r0.afInfoLog     // Catch:{ all -> 0x0163 }
                    r0.values(r3)     // Catch:{ all -> 0x0163 }
                    goto L_0x015e
                L_0x0149:
                    java.util.NavigableSet<com.appsflyer.internal.AFd1tSDK<?>> r3 = r0.AFLogger     // Catch:{ all -> 0x0163 }
                    r0.values(r3)     // Catch:{ all -> 0x0163 }
                    goto L_0x015e
                L_0x014f:
                    if (r4 == 0) goto L_0x0157
                    java.util.NavigableSet<com.appsflyer.internal.AFd1tSDK<?>> r3 = r0.afInfoLog     // Catch:{ all -> 0x0163 }
                    r0.values(r3)     // Catch:{ all -> 0x0163 }
                    goto L_0x015e
                L_0x0157:
                    if (r3 == 0) goto L_0x015e
                    java.util.NavigableSet<com.appsflyer.internal.AFd1tSDK<?>> r3 = r0.AFLogger     // Catch:{ all -> 0x0163 }
                    r0.values(r3)     // Catch:{ all -> 0x0163 }
                L_0x015e:
                    int r2 = r2 + -1
                    goto L_0x0114
                L_0x0161:
                    monitor-exit(r1)     // Catch:{ all -> 0x0163 }
                    return
                L_0x0163:
                    r0 = move-exception
                    monitor-exit(r1)
                    throw r0
                L_0x0166:
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    java.lang.String r1 = "QUEUE: tried to add already pending task: "
                    r0.<init>(r1)
                    com.appsflyer.internal.AFd1tSDK r1 = r6.AFInAppEventParameterName
                    r0.append(r1)
                    java.lang.String r0 = r0.toString()
                    com.appsflyer.AFLogger.afWarnLog(r0)
                    return
                L_0x017a:
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x018f }
                    java.lang.String r2 = "QUEUE: tried to add already scheduled task: "
                    r1.<init>(r2)     // Catch:{ all -> 0x018f }
                    com.appsflyer.internal.AFd1tSDK r2 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x018f }
                    r1.append(r2)     // Catch:{ all -> 0x018f }
                    java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x018f }
                    com.appsflyer.AFLogger.afDebugLog(r1)     // Catch:{ all -> 0x018f }
                    monitor-exit(r0)     // Catch:{ all -> 0x018f }
                    return
                L_0x018f:
                    r1 = move-exception
                    monitor-exit(r0)
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1xSDK.AnonymousClass2.run():void");
            }
        });
        return aFd1eSDK;
    }

    /* access modifiers changed from: private */
    public static void values(boolean z10, String str, String str2, String str3, String str4) {
        if (AFb1zSDK.values != null) {
            StringBuilder sb2 = new StringBuilder("Validate callback parameters: ");
            sb2.append(str);
            sb2.append(" ");
            sb2.append(str2);
            sb2.append(" ");
            sb2.append(str3);
            AFLogger.afDebugLog(sb2.toString());
            if (z10) {
                AFLogger.afDebugLog("Validate in app purchase success: ".concat(String.valueOf(str4)));
                AFb1zSDK.values.onValidateInApp();
                return;
            }
            AFLogger.afDebugLog("Validate in app purchase failed: ".concat(String.valueOf(str4)));
            AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener = AFb1zSDK.values;
            if (str4 == null) {
                str4 = "Failed validating";
            }
            appsFlyerInAppPurchaseValidatorListener.onValidateInAppFailure(str4);
        }
    }

    public final void run() {
        String str = this.AFInAppEventParameterName;
        if (str != null && str.length() != 0 && !AppsFlyerLib.getInstance().isStopped()) {
            try {
                Context context = this.AFInAppEventType.get();
                if (context != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("public-key", this.afDebugLog);
                    hashMap.put("sig-data", this.afRDLog);
                    hashMap.put("signature", this.AFLogger);
                    HashMap hashMap2 = new HashMap(hashMap);
                    Map<String, String> map = this.AFVersionDeclaration;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(String.format(values, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), AFb1zSDK.AFInAppEventType().getHostName()}));
                    sb2.append(context.getPackageName());
                    String obj = sb2.toString();
                    String string = AFb1zSDK.AFInAppEventType(context).getString("referrer", "");
                    AFe1dSDK aFe1dSDK = new AFe1dSDK(context);
                    aFe1dSDK.afInfoLog = string;
                    AFb1zSDK AFInAppEventType2 = AFb1zSDK.AFInAppEventType();
                    Map<String, Object> AFInAppEventType3 = AFInAppEventType2.AFInAppEventType((AFa1sSDK) aFe1dSDK);
                    AFInAppEventType3.put(FirebaseAnalytics.Param.PRICE, this.afInfoLog);
                    AFInAppEventType3.put(FirebaseAnalytics.Param.CURRENCY, this.afErrorLog);
                    AFInAppEventType3.put("receipt_data", hashMap2);
                    if (map != null) {
                        AFInAppEventType3.put("extra_prms", map);
                    }
                    AFInAppEventType3.putAll(AFInAppEventType2.AFInAppEventParameterName().AFVersionDeclaration().values());
                    valueOf(context, (AFe1dSDK) aFe1dSDK.AFInAppEventType((Map<String, ?>) AFInAppEventType3).AFInAppEventType(obj));
                    hashMap.put("dev_key", this.AFInAppEventParameterName);
                    hashMap.put("app_id", context.getPackageName());
                    hashMap.put("uid", AppsFlyerLib.getInstance().getAppsFlyerUID(context));
                    String string2 = AppsFlyerProperties.getInstance().getString("advertiserId");
                    if (string2 != null) {
                        hashMap.put("advertiserId", string2);
                    }
                    AFe1cSDK aFe1cSDK = (AFe1cSDK) new AFe1cSDK().AFInAppEventType((Map<String, ?>) hashMap).AFInAppEventType(String.format(valueOf, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), AFb1zSDK.AFInAppEventType().getHostName()}));
                    final AFd1eSDK valueOf2 = valueOf(context, aFe1cSDK);
                    aFe1cSDK.AFInAppEventType = new AppsFlyerRequestListener() {
                        public final void onError(int i10, @NonNull String str) {
                            AFc1dSDK<Result> aFc1dSDK;
                            if (i10 == RequestError.RESPONSE_CODE_FAILURE && (aFc1dSDK = valueOf2.afDebugLog) != null) {
                                str = aFc1dSDK.toString();
                            }
                            AFa1cSDK.values(false, AFa1cSDK.this.afRDLog, AFa1cSDK.this.afInfoLog, AFa1cSDK.this.afErrorLog, str);
                        }

                        public final void onSuccess() {
                            try {
                                b bVar = new b((String) valueOf2.afDebugLog.getBody());
                                AFLogger.afInfoLog("Validate response ok: ".concat(String.valueOf(bVar)));
                                AFa1cSDK.values(bVar.optBoolean(MamElements.MamResultExtension.ELEMENT), AFa1cSDK.this.afRDLog, AFa1cSDK.this.afInfoLog, AFa1cSDK.this.afErrorLog, bVar.toString());
                            } catch (Exception e10) {
                                AFLogger.afErrorLog("Failed Validate request: ".concat(String.valueOf(e10)), e10);
                                AFa1cSDK.values(false, AFa1cSDK.this.afRDLog, AFa1cSDK.this.afInfoLog, AFa1cSDK.this.afErrorLog, e10.getMessage());
                            }
                        }
                    };
                }
            } catch (Throwable th2) {
                if (AFb1zSDK.values != null) {
                    AFLogger.afErrorLog("Failed Validate request + ex", th2);
                    values(false, this.afRDLog, this.afInfoLog, this.afErrorLog, th2.getMessage());
                }
                AFLogger.afErrorLog(th2.getMessage(), th2);
            }
        }
    }
}

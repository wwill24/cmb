package com.appsflyer.internal;

import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.jivesoftware.smackx.delay.packet.DelayInformation;
import org.json.b;

public final class AFd1iSDK extends AFd1eSDK {
    public Map<String, Object> AFVersionDeclaration;
    @NonNull
    private final AFb1vSDK AppsFlyer2dXConversionCallback;
    @NonNull
    private final AFf1sSDK afErrorLogForExcManagerOnly;
    @NonNull
    private final AFe1nSDK afWarnLog;
    @NonNull
    private final AFb1gSDK getLevel;
    @NonNull
    private final AppsFlyerProperties init = AppsFlyerProperties.getInstance();

    /* renamed from: com.appsflyer.internal.AFd1iSDK$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] AFKeystoreWrapper;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.appsflyer.internal.AFf1uSDK$AFa1ySDK[] r0 = com.appsflyer.internal.AFf1uSDK.AFa1ySDK.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                AFKeystoreWrapper = r0
                com.appsflyer.internal.AFf1uSDK$AFa1ySDK r1 = com.appsflyer.internal.AFf1uSDK.AFa1ySDK.FINISHED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = AFKeystoreWrapper     // Catch:{ NoSuchFieldError -> 0x001d }
                com.appsflyer.internal.AFf1uSDK$AFa1ySDK r1 = com.appsflyer.internal.AFf1uSDK.AFa1ySDK.STARTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1iSDK.AnonymousClass2.<clinit>():void");
        }
    }

    public AFd1iSDK(@NonNull AFa1sSDK aFa1sSDK, @NonNull AFc1xSDK aFc1xSDK) {
        super(aFa1sSDK, aFc1xSDK);
        this.afErrorLogForExcManagerOnly = aFc1xSDK.getLevel();
        this.getLevel = aFc1xSDK.afErrorLog();
        this.afWarnLog = aFc1xSDK.afRDLog();
        this.AppsFlyer2dXConversionCallback = aFc1xSDK.afInfoLog();
        this.AFInAppEventParameterName.add(AFd1wSDK.RESOLVE_ESP);
        this.AFInAppEventParameterName.add(AFd1wSDK.DLSDK);
    }

    public final void AFKeystoreWrapper() {
        super.AFKeystoreWrapper();
        AFe1nSDK aFe1nSDK = this.afWarnLog;
        int i10 = this.AFLogger.afDebugLog;
        long currentTimeMillis = System.currentTimeMillis();
        if (i10 == 1) {
            long j10 = aFe1nSDK.afRDLog;
            if (j10 != 0) {
                aFe1nSDK.values.put("net", Long.valueOf(currentTimeMillis - j10));
                aFe1nSDK.AFInAppEventParameterName.AFInAppEventParameterName("first_launch", new b((Map<?, ?>) aFe1nSDK.values).toString());
                return;
            }
            AFLogger.afInfoLog("Metrics: launch start ts is missing");
        }
    }

    /* access modifiers changed from: protected */
    public final void values(AFa1sSDK aFa1sSDK) {
        super.values(aFa1sSDK);
        int i10 = aFa1sSDK.afDebugLog;
        this.afWarnLog.AFInAppEventParameterName(i10);
        Map map = (Map) aFa1sSDK.AFInAppEventType().get("meta");
        if (map == null) {
            map = new HashMap();
            aFa1sSDK.AFInAppEventType().put("meta", map);
        }
        AFb1kSDK valueOf = this.AppsFlyer2dXConversionCallback.valueOf();
        if (valueOf != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("cdn_token", valueOf.valueOf);
            String str = valueOf.AFInAppEventType;
            if (str != null) {
                hashMap.put("c_ver", str);
            }
            long j10 = valueOf.values;
            if (j10 > 0) {
                hashMap.put("latency", Long.valueOf(j10));
            }
            long j11 = valueOf.AFKeystoreWrapper;
            if (j11 > 0) {
                hashMap.put(DelayInformation.ELEMENT, Long.valueOf(j11));
            }
            int i11 = valueOf.AFInAppEventParameterName;
            if (i11 > 0) {
                hashMap.put("res_code", Integer.valueOf(i11));
            }
            if (valueOf.afInfoLog != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(valueOf.afInfoLog.getClass().getSimpleName());
                sb2.append(": ");
                sb2.append(valueOf.afInfoLog.getMessage());
                hashMap.put("error", sb2.toString());
            }
            AFf1xSDK aFf1xSDK = valueOf.afRDLog;
            if (aFf1xSDK != null) {
                hashMap.put("sig", aFf1xSDK.toString());
            }
            String str2 = valueOf.afErrorLog;
            if (str2 != null) {
                hashMap.put("cdn_cache_status", str2);
            }
            map.put("rc", hashMap);
        }
        if (i10 == 1) {
            if (this.init.getBoolean(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false)) {
                aFa1sSDK.AFInAppEventType().put("wait_cid", Boolean.toString(true));
            }
            HashMap hashMap2 = new HashMap(this.afWarnLog.AFKeystoreWrapper);
            this.afWarnLog.AFInAppEventParameterName.AFKeystoreWrapper("ddl");
            if (!hashMap2.isEmpty()) {
                map.put("ddl", hashMap2);
            }
            HashMap hashMap3 = new HashMap(this.afWarnLog.values);
            if (!hashMap3.isEmpty()) {
                map.put("first_launch", hashMap3);
            }
        } else if (i10 == 2) {
            HashMap hashMap4 = new HashMap(this.afWarnLog.values);
            if (!hashMap4.isEmpty()) {
                map.put("first_launch", hashMap4);
            }
            this.afWarnLog.AFInAppEventParameterName.AFKeystoreWrapper("first_launch");
        }
        if (map.isEmpty()) {
            aFa1sSDK.AFInAppEventType().remove("meta");
        }
        if (i10 <= 2) {
            ArrayList arrayList = new ArrayList();
            for (AFf1uSDK aFf1uSDK : this.afErrorLogForExcManagerOnly.values()) {
                boolean z10 = aFf1uSDK instanceof AFf1ySDK;
                int i12 = AnonymousClass2.AFKeystoreWrapper[aFf1uSDK.afDebugLog.ordinal()];
                if (i12 == 1) {
                    if (z10) {
                        aFa1sSDK.valueOf("rfr", ((AFf1ySDK) aFf1uSDK).AFInAppEventParameterName);
                        this.getLevel.valueOf(AppsFlyerProperties.NEW_REFERRER_SENT, true);
                    }
                    arrayList.add(aFf1uSDK.values);
                } else if (i12 == 2 && i10 == 2 && !z10) {
                    HashMap hashMap5 = new HashMap();
                    hashMap5.put("source", aFf1uSDK.AFKeystoreWrapper);
                    hashMap5.put("response", "TIMEOUT");
                    hashMap5.put("type", aFf1uSDK.afInfoLog);
                    arrayList.add(hashMap5);
                }
            }
            if (!arrayList.isEmpty()) {
                aFa1sSDK.valueOf("referrers", arrayList);
            }
            Map<String, Object> map2 = this.AFVersionDeclaration;
            if (map2 != null) {
                aFa1sSDK.valueOf("fb_ddl", map2);
            }
        }
    }
}

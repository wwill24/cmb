package com.appsflyer.internal;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.deeplink.DeepLink;
import com.appsflyer.deeplink.DeepLinkResult;
import com.appsflyer.internal.AFc1vSDK;
import com.appsflyer.internal.AFf1uSDK;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.mparticle.kits.LeanplumKit;
import j$.util.DesugarTimeZone;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.commons.cli.HelpFormatter;
import org.jivesoftware.smackx.softwareinfo.form.SoftwareInfoForm;
import org.json.JSONException;
import org.json.b;

public final class AFb1pSDK extends AFe1jSDK {
    private static String AFLogger$LogLevel = "https://%sdlsdk.%s/v1.0/android/";
    public static long getLevel;
    private final AFe1nSDK AppsFlyer2dXConversionCallback;
    private final List<AFf1uSDK> afErrorLogForExcManagerOnly = new ArrayList();
    private final CountDownLatch afWarnLog = new CountDownLatch(1);
    private final AFf1sSDK init;
    private final AFe1xSDK onAppOpenAttributionNative;
    private boolean onAttributionFailureNative;
    private int onDeepLinkingNative;
    private final AFb1fSDK onInstallConversionDataLoadedNative;
    private final ExecutorService onInstallConversionFailureNative;
    private int onResponseErrorNative;
    private int onResponseNative;

    /* renamed from: com.appsflyer.internal.AFb1pSDK$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] values;

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
                values = r0
                com.appsflyer.internal.AFf1uSDK$AFa1ySDK r1 = com.appsflyer.internal.AFf1uSDK.AFa1ySDK.FINISHED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = values     // Catch:{ NoSuchFieldError -> 0x001d }
                com.appsflyer.internal.AFf1uSDK$AFa1ySDK r1 = com.appsflyer.internal.AFf1uSDK.AFa1ySDK.STARTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1pSDK.AnonymousClass1.<clinit>():void");
        }
    }

    public AFb1pSDK(Context context, AFc1xSDK aFc1xSDK) {
        super((String) null, AFLogger$LogLevel, Boolean.FALSE, Boolean.TRUE, (Boolean) null, context);
        this.AppsFlyer2dXConversionCallback = aFc1xSDK.afRDLog();
        this.onInstallConversionDataLoadedNative = aFc1xSDK.values();
        this.onAppOpenAttributionNative = aFc1xSDK.AFVersionDeclaration();
        this.init = aFc1xSDK.getLevel();
        this.onInstallConversionFailureNative = aFc1xSDK.AFInAppEventParameterName();
    }

    static /* synthetic */ DeepLinkResult AFKeystoreWrapper(AFb1pSDK aFb1pSDK, Context context) throws IOException, JSONException, InterruptedException {
        DeepLink deepLink;
        while (true) {
            AFe1nSDK aFe1nSDK = aFb1pSDK.AppsFlyer2dXConversionCallback;
            int i10 = aFb1pSDK.onResponseErrorNative;
            if (i10 <= 0 || i10 > 2) {
                AFLogger.afErrorLogForExcManagerOnly("Unexpected ddl requestCount - start", new IllegalStateException("Metrics: Unexpected ddl requestCount = ".concat(String.valueOf(i10))));
            } else {
                int i11 = i10 - 1;
                aFe1nSDK.afInfoLog[i11] = System.currentTimeMillis();
                if (i11 == 0) {
                    long j10 = aFe1nSDK.afDebugLog;
                    if (j10 != 0) {
                        aFe1nSDK.AFKeystoreWrapper.put("from_fg", Long.valueOf(aFe1nSDK.afInfoLog[i11] - j10));
                        aFe1nSDK.AFInAppEventParameterName.AFInAppEventParameterName("ddl", new b((Map<?, ?>) aFe1nSDK.AFKeystoreWrapper).toString());
                    } else {
                        AFLogger.afInfoLog("Metrics: fg ts is missing");
                    }
                }
            }
            HttpURLConnection AFKeystoreWrapper = new AFa1rSDK(aFb1pSDK).AFKeystoreWrapper(aFb1pSDK.onAppOpenAttributionNative.AFInAppEventType);
            AFe1nSDK aFe1nSDK2 = aFb1pSDK.AppsFlyer2dXConversionCallback;
            int i12 = aFb1pSDK.onResponseErrorNative;
            if (i12 <= 0 || i12 > 2) {
                AFLogger.afErrorLogForExcManagerOnly("Unexpected ddl requestCount - end", new IllegalStateException("Metrics: Unexpected ddl requestCount = ".concat(String.valueOf(i12))));
            } else {
                int i13 = i12 - 1;
                aFe1nSDK2.AFLogger[i13] = System.currentTimeMillis();
                long j11 = aFe1nSDK2.afInfoLog[i13];
                if (j11 != 0) {
                    long[] jArr = aFe1nSDK2.afErrorLog;
                    jArr[i13] = aFe1nSDK2.AFLogger[i13] - j11;
                    aFe1nSDK2.AFKeystoreWrapper.put("net", jArr);
                    aFe1nSDK2.AFInAppEventParameterName.AFInAppEventParameterName("ddl", new b((Map<?, ?>) aFe1nSDK2.AFKeystoreWrapper).toString());
                } else {
                    StringBuilder sb2 = new StringBuilder("Metrics: ddlStart[");
                    sb2.append(i13);
                    sb2.append("] ts is missing");
                    AFLogger.afInfoLog(sb2.toString());
                }
            }
            if (AFKeystoreWrapper.getResponseCode() == 200) {
                b bVar = new b(AFb1zSDK.AFInAppEventParameterName(AFKeystoreWrapper));
                aFb1pSDK.onAttributionFailureNative = bVar.optBoolean("is_second_ping", true);
                if (!bVar.optBoolean("found")) {
                    deepLink = null;
                } else {
                    deepLink = DeepLink.AFInAppEventParameterName(bVar.optJSONObject("click_event"));
                    deepLink.AFInAppEventType.put("is_deferred", true);
                }
                if (deepLink != null) {
                    return new DeepLinkResult(deepLink, (DeepLinkResult.Error) null);
                }
                if (aFb1pSDK.onResponseErrorNative <= 1 && aFb1pSDK.getLevel() && aFb1pSDK.onAttributionFailureNative) {
                    AFLogger.afDebugLog("[DDL] Waiting for referrers...");
                    aFb1pSDK.afWarnLog.await();
                    AFe1nSDK aFe1nSDK3 = aFb1pSDK.AppsFlyer2dXConversionCallback;
                    long currentTimeMillis = System.currentTimeMillis();
                    long j12 = aFe1nSDK3.AFLogger[0];
                    if (j12 != 0) {
                        aFe1nSDK3.AFKeystoreWrapper.put("rfr_wait", Long.valueOf(currentTimeMillis - j12));
                        aFe1nSDK3.AFInAppEventParameterName.AFInAppEventParameterName("ddl", new b((Map<?, ?>) aFe1nSDK3.AFKeystoreWrapper).toString());
                    } else {
                        AFLogger.afInfoLog("Metrics: ddlEnd[0] ts is missing");
                    }
                    if (aFb1pSDK.onResponseNative == aFb1pSDK.onDeepLinkingNative) {
                        return new DeepLinkResult((DeepLink) null, (DeepLinkResult.Error) null);
                    }
                    aFb1pSDK.AFLogger$LogLevel();
                }
            } else {
                StringBuilder sb3 = new StringBuilder("[DDL] Error occurred. Server response code = ");
                sb3.append(AFKeystoreWrapper.getResponseCode());
                AFLogger.afDebugLog(sb3.toString());
                return new DeepLinkResult((DeepLink) null, DeepLinkResult.Error.HTTP_STATUS_CODE);
            }
        }
        return new DeepLinkResult((DeepLink) null, (DeepLinkResult.Error) null);
    }

    /* access modifiers changed from: private */
    public void AFLogger$LogLevel() {
        String[] strArr;
        boolean z10 = true;
        this.onResponseErrorNative++;
        StringBuilder sb2 = new StringBuilder("[DDL] Preparing request ");
        sb2.append(this.onResponseErrorNative);
        AFLogger.afDebugLog(sb2.toString());
        if (this.onResponseErrorNative == 1) {
            AFb1zSDK AFInAppEventType = AFb1zSDK.AFInAppEventType();
            Map<String, Object> map = this.valueOf;
            if (this.onInstallConversionDataLoadedNative.values.AFInAppEventType("appsFlyerCount", 0) != 0) {
                z10 = false;
            }
            map.put("is_first", Boolean.valueOf(z10));
            Map<String, Object> map2 = this.valueOf;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(Locale.getDefault().getLanguage());
            sb3.append(HelpFormatter.DEFAULT_OPT_PREFIX);
            sb3.append(Locale.getDefault().getCountry());
            map2.put("lang", sb3.toString());
            this.valueOf.put(SoftwareInfoForm.OS, Build.VERSION.RELEASE);
            this.valueOf.put("type", Build.MODEL);
            this.valueOf.put(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, AFb1xSDK.AFInAppEventParameterName(new WeakReference(this.onInstallConversionDataLoadedNative.valueOf.values)));
            AFa1fSDK aFa1fSDK = AFInAppEventType.afRDLog;
            if (!(aFa1fSDK == null || (strArr = aFa1fSDK.valueOf) == null)) {
                this.valueOf.put("sharing_filter", strArr);
            }
            Map<String, Object> AFInAppEventParameterName = AFInAppEventParameterName(AFa1bSDK.AFKeystoreWrapper(this.onInstallConversionDataLoadedNative.valueOf.values, new HashMap()));
            Map<String, Object> AFInAppEventParameterName2 = AFInAppEventParameterName(AFa1bSDK.values(this.onInstallConversionDataLoadedNative.valueOf.values));
            if (AFInAppEventParameterName != null) {
                this.valueOf.put(LeanplumKit.DEVICE_ID_TYPE_GOOGLE_AD_ID, AFInAppEventParameterName);
            }
            if (AFInAppEventParameterName2 != null) {
                this.valueOf.put("oaid", AFInAppEventParameterName2);
            }
        }
        Map<String, Object> map3 = this.valueOf;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.US);
        long currentTimeMillis = System.currentTimeMillis();
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        map3.put("timestamp", simpleDateFormat.format(new Date(currentTimeMillis)));
        this.valueOf.put("request_count", Integer.valueOf(this.onResponseErrorNative));
        ArrayList arrayList = new ArrayList();
        for (AFf1uSDK values : this.afErrorLogForExcManagerOnly) {
            Map<String, String> values2 = values(values);
            if (values2 != null) {
                arrayList.add(values2);
            }
        }
        if (!arrayList.isEmpty()) {
            this.valueOf.put("referrers", arrayList);
        }
        AFInAppEventType(onAppOpenAttributionNative());
    }

    private boolean getLevel() {
        int i10;
        List list = (List) this.valueOf.get("referrers");
        if (list != null) {
            i10 = list.size();
        } else {
            i10 = 0;
        }
        if (i10 >= this.onDeepLinkingNative || this.valueOf.containsKey("referrers")) {
            return false;
        }
        return true;
    }

    private String onAppOpenAttributionNative() {
        String str;
        String str2 = this.onAppOpenAttributionNative.AFInAppEventType;
        String packageName = this.onInstallConversionDataLoadedNative.valueOf.values.getPackageName();
        String values = this.onInstallConversionDataLoadedNative.values();
        if (values == null || values.trim().isEmpty()) {
            str = "";
        } else {
            str = HelpFormatter.DEFAULT_OPT_PREFIX.concat(values);
        }
        Uri.Builder buildUpon = Uri.parse(String.format(AFLogger$LogLevel, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), AFb1zSDK.AFInAppEventType().getHostName()})).buildUpon();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(packageName);
        sb2.append(str);
        Uri.Builder appendPath = buildUpon.appendPath(sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(this.valueOf.get("timestamp"));
        sb3.append(str2);
        return appendPath.appendQueryParameter("af_sig", AFa1aSDK.values(sb3.toString(), str2)).appendQueryParameter("sdk_version", AFb1zSDK.AFKeystoreWrapper).build().toString();
    }

    private static boolean valueOf(AFf1uSDK aFf1uSDK) {
        Long l10 = (Long) aFf1uSDK.values.get("click_ts");
        if (l10 != null && System.currentTimeMillis() - TimeUnit.SECONDS.toMillis(l10.longValue()) < TimeUnit.DAYS.toMillis(1)) {
            return true;
        }
        return false;
    }

    public final DeepLinkResult AFLogger() {
        DeepLinkResult.Error error;
        AFLogger.afDebugLog("[DDL] start");
        FutureTask futureTask = new FutureTask(new Callable<DeepLinkResult>() {
            public final /* synthetic */ Object call() throws Exception {
                Application valueOf = AFb1pSDK.this.AFKeystoreWrapper;
                AFb1pSDK.AFInAppEventParameterName(AFb1pSDK.this);
                AFb1pSDK.this.AFLogger$LogLevel();
                return AFb1pSDK.AFKeystoreWrapper(AFb1pSDK.this, valueOf);
            }
        });
        this.onInstallConversionFailureNative.execute(futureTask);
        try {
            DeepLinkResult deepLinkResult = (DeepLinkResult) futureTask.get(getLevel, TimeUnit.MILLISECONDS);
            this.AppsFlyer2dXConversionCallback.AFKeystoreWrapper(deepLinkResult, getLevel);
            AFb1oSDK.AFInAppEventParameterName(deepLinkResult);
            return deepLinkResult;
        } catch (InterruptedException | ExecutionException e10) {
            AFLogger.afErrorLog("[DDL] Error occurred", e10, true);
            if (e10.getCause() instanceof IOException) {
                error = DeepLinkResult.Error.NETWORK;
            } else {
                error = DeepLinkResult.Error.UNEXPECTED;
            }
            DeepLinkResult deepLinkResult2 = new DeepLinkResult((DeepLink) null, error);
            this.AppsFlyer2dXConversionCallback.AFKeystoreWrapper(deepLinkResult2, getLevel);
            AFb1oSDK.AFInAppEventParameterName(deepLinkResult2);
            return deepLinkResult2;
        } catch (TimeoutException e11) {
            AFLogger.afErrorLogForExcManagerOnly("[DDL] Timeout", e11);
            StringBuilder sb2 = new StringBuilder("[DDL] Timeout, didn't manage to find deferred deep link after ");
            sb2.append(this.onResponseErrorNative);
            sb2.append(" attempt(s) within ");
            sb2.append(getLevel);
            sb2.append(" milliseconds");
            AFLogger.afDebugLog(sb2.toString());
            DeepLinkResult deepLinkResult3 = new DeepLinkResult((DeepLink) null, DeepLinkResult.Error.TIMEOUT);
            this.AppsFlyer2dXConversionCallback.AFKeystoreWrapper(deepLinkResult3, getLevel);
            AFb1oSDK.AFInAppEventParameterName(deepLinkResult3);
            return deepLinkResult3;
        }
    }

    public final AFd1wSDK values() {
        return AFd1wSDK.DLSDK;
    }

    /* access modifiers changed from: private */
    public void AFInAppEventParameterName(AFf1uSDK aFf1uSDK) {
        if (valueOf(aFf1uSDK)) {
            this.afErrorLogForExcManagerOnly.add(aFf1uSDK);
            this.afWarnLog.countDown();
            StringBuilder sb2 = new StringBuilder("[DDL] Added non-organic ");
            sb2.append(aFf1uSDK.getClass().getSimpleName());
            AFLogger.afDebugLog(sb2.toString());
            return;
        }
        int i10 = this.onResponseNative + 1;
        this.onResponseNative = i10;
        if (i10 == this.onDeepLinkingNative) {
            this.afWarnLog.countDown();
        }
    }

    private static Map<String, String> values(AFf1uSDK aFf1uSDK) {
        if (aFf1uSDK.afDebugLog != AFf1uSDK.AFa1ySDK.FINISHED) {
            return null;
        }
        HashMap hashMap = new HashMap();
        String str = (String) aFf1uSDK.values.get("referrer");
        if (str == null) {
            return null;
        }
        hashMap.put("source", (String) aFf1uSDK.values.get("source"));
        hashMap.put("value", str);
        return hashMap;
    }

    private Map<String, Object> AFInAppEventParameterName(final AFc1vSDK.AFa1wSDK aFa1wSDK) {
        Boolean bool;
        boolean z10 = false;
        if (!(aFa1wSDK == null || aFa1wSDK.AFInAppEventType == null || ((bool = aFa1wSDK.valueOf) != null && bool.booleanValue()))) {
            z10 = true;
        }
        if (z10) {
            return new HashMap<String, Object>() {
                {
                    put("type", "unhashed");
                    put("value", aFa1wSDK.AFInAppEventType);
                }
            };
        }
        return null;
    }

    static /* synthetic */ void AFInAppEventParameterName(AFb1pSDK aFb1pSDK) {
        ArrayList<AFf1uSDK> arrayList = new ArrayList<>();
        for (AFf1uSDK aFf1uSDK : aFb1pSDK.init.values()) {
            if (!(aFf1uSDK == null || aFf1uSDK.afDebugLog == AFf1uSDK.AFa1ySDK.NOT_STARTED)) {
                arrayList.add(aFf1uSDK);
            }
        }
        aFb1pSDK.onDeepLinkingNative = arrayList.size();
        for (final AFf1uSDK aFf1uSDK2 : arrayList) {
            int i10 = AnonymousClass1.values[aFf1uSDK2.afDebugLog.ordinal()];
            if (i10 == 1) {
                StringBuilder sb2 = new StringBuilder("[DDL] ");
                sb2.append(aFf1uSDK2.values.get("source"));
                sb2.append(" referrer collected earlier");
                AFLogger.afDebugLog(sb2.toString());
                aFb1pSDK.AFInAppEventParameterName(aFf1uSDK2);
            } else if (i10 == 2) {
                aFf1uSDK2.addObserver(new Observer() {
                    public final void update(Observable observable, Object obj) {
                        StringBuilder sb2 = new StringBuilder("[DDL] ");
                        sb2.append(aFf1uSDK2.values.get("source"));
                        sb2.append(" referrer collected via observer");
                        AFLogger.afDebugLog(sb2.toString());
                        AFb1pSDK.this.AFInAppEventParameterName((AFf1uSDK) observable);
                    }
                });
            }
        }
    }
}

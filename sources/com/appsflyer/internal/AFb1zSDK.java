package com.appsflyer.internal;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.graphics.PointF;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import com.appsflyer.AFInAppEventParameterName;
import com.appsflyer.AFInAppEventType;
import com.appsflyer.AFLogger;
import com.appsflyer.AFVersionDeclaration;
import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerInAppPurchaseValidatorListener;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.PurchaseHandler;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.attribution.RequestError;
import com.appsflyer.deeplink.DeepLinkListener;
import com.appsflyer.deeplink.DeepLinkResult;
import com.appsflyer.internal.AFa1gSDK;
import com.appsflyer.internal.AFa1rSDK;
import com.appsflyer.internal.AFa1zSDK;
import com.appsflyer.internal.AFb1wSDK;
import com.appsflyer.internal.AFc1vSDK;
import com.appsflyer.internal.AFd1hSDK;
import com.appsflyer.internal.AFf1uSDK;
import com.facebook.FacebookSdk;
import com.facebook.applinks.AppLinkData;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.c;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.leanplum.internal.RequestBuilder;
import j$.util.DesugarTimeZone;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.apache.commons.beanutils.PropertyUtils;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;
import org.jivesoftware.smackx.hoxt.packet.AbstractHttpOverXmpp;
import org.json.JSONException;
import org.json.a;
import org.json.b;

public final class AFb1zSDK extends AppsFlyerLib {
    public static final String AFInAppEventParameterName;
    static final String AFInAppEventType = "228";
    public static final String AFKeystoreWrapper;
    private static String AFLogger = "https://%sstats.%s/stats";
    private static String AFLogger$LogLevel = null;
    private static String AFVersionDeclaration = null;
    private static char[] AppsFlyerConversionListener = null;
    private static String afErrorLog = "https://%sadrevenue.%s/api/v2/generic/v6.10.0/android?app_id=";
    private static AFb1zSDK afErrorLogForExcManagerOnly = new AFb1zSDK();
    private static final String afInfoLog;
    private static String afWarnLog = null;
    private static String getLevel = null;
    private static int getSdkVersion = 1;
    private static int onPause;
    private static long onValidateInAppFailure;
    public static volatile AppsFlyerConversionListener valueOf = null;
    static AppsFlyerInAppPurchaseValidatorListener values = null;
    private boolean AppsFlyer2dXConversionCallback = false;
    private AFb1cSDK AppsFlyerInAppPurchaseValidatorListener;
    String afDebugLog;
    public AFa1fSDK afRDLog;
    private long init = -1;
    private SharedPreferences onAppOpenAttribution;
    private String onAppOpenAttributionNative;
    private Map<String, Object> onAttributionFailure;
    private boolean onAttributionFailureNative;
    private boolean onConversionDataFail = false;
    private boolean onConversionDataSuccess = false;
    private Application onDeepLinking;
    private Map<Long, String> onDeepLinkingNative;
    private long onInstallConversionDataLoadedNative = TimeUnit.SECONDS.toMillis(5);
    private long onInstallConversionFailureNative = -1;
    private String onResponse;
    @NonNull
    private final AFb1bSDK onResponseError;
    private final AFb1rSDK onResponseErrorNative = new AFb1rSDK();
    private boolean onResponseNative;
    private final Executor onValidateInApp = Executors.newSingleThreadExecutor();

    /* renamed from: com.appsflyer.internal.AFb1zSDK$10  reason: invalid class name */
    static /* synthetic */ class AnonymousClass10 {
        static final /* synthetic */ int[] values;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.appsflyer.AppsFlyerProperties$EmailsCryptType[] r0 = com.appsflyer.AppsFlyerProperties.EmailsCryptType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                values = r0
                com.appsflyer.AppsFlyerProperties$EmailsCryptType r1 = com.appsflyer.AppsFlyerProperties.EmailsCryptType.SHA256     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = values     // Catch:{ NoSuchFieldError -> 0x001d }
                com.appsflyer.AppsFlyerProperties$EmailsCryptType r1 = com.appsflyer.AppsFlyerProperties.EmailsCryptType.NONE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1zSDK.AnonymousClass10.<clinit>():void");
        }
    }

    class AFa1vSDK implements AFd1zSDK {
        private AFa1vSDK() {
        }

        private static boolean AFInAppEventParameterName() {
            return AFb1zSDK.valueOf != null;
        }

        public final void AFInAppEventType(AFd1tSDK<?> aFd1tSDK, AFc1aSDK aFc1aSDK) {
            b AFKeystoreWrapper;
            AFb1sSDK valueOf;
            if (aFd1tSDK instanceof AFd1eSDK) {
                AFd1eSDK aFd1eSDK = (AFd1eSDK) aFd1tSDK;
                boolean z10 = aFd1tSDK instanceof AFd1iSDK;
                if (z10 && AFInAppEventParameterName()) {
                    AFd1iSDK aFd1iSDK = (AFd1iSDK) aFd1tSDK;
                    boolean z11 = true;
                    if (!(aFd1iSDK.AFInAppEventType == AFc1aSDK.SUCCESS || aFd1iSDK.valueOf == 1)) {
                        z11 = false;
                    }
                    if (z11) {
                        Context context = AFb1zSDK.valueOf(AFb1zSDK.this).valueOf.values;
                        if (context != null) {
                            AFe1qSDK aFe1qSDK = new AFe1qSDK(aFd1iSDK, new AFb1eSDK(AFb1zSDK.AFInAppEventType(context)));
                            AFd1xSDK afDebugLog = AFb1zSDK.valueOf(AFb1zSDK.this).afDebugLog();
                            afDebugLog.AFKeystoreWrapper.execute(new Runnable(aFe1qSDK) {
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
                                        int r3 = r3.compareTo(r4)     // Catch:{ all -> 0x0163 }
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
                        } else {
                            throw new IllegalStateException("Context must be set via setContext method before calling this dependency.");
                        }
                    }
                }
                if (aFc1aSDK == AFc1aSDK.SUCCESS) {
                    AFb1zSDK aFb1zSDK = AFb1zSDK.this;
                    aFb1zSDK.AFInAppEventParameterName((Context) AFb1zSDK.values(aFb1zSDK)).AFInAppEventParameterName("sentSuccessfully", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                    if (!(aFd1tSDK instanceof AFd1gSDK) && (valueOf = new AFe1pSDK(AFb1zSDK.values(AFb1zSDK.this)).valueOf()) != null && valueOf.AFInAppEventType()) {
                        String str = valueOf.AFInAppEventParameterName;
                        AFLogger.afDebugLog("Resending Uninstall token to AF servers: ".concat(String.valueOf(str)));
                        AFe1pSDK.valueOf(str);
                    }
                    AFc1dSDK<Result> aFc1dSDK = aFd1eSDK.afDebugLog;
                    if (!(aFc1dSDK == null || (AFKeystoreWrapper = AFb1tSDK.AFKeystoreWrapper((String) aFc1dSDK.getBody())) == null)) {
                        AFb1zSDK.valueOf(AFb1zSDK.this, AFKeystoreWrapper.optBoolean("send_background", false));
                    }
                    if (z10) {
                        AFb1zSDK.AFInAppEventType(AFb1zSDK.this, System.currentTimeMillis());
                    }
                }
            } else if ((aFd1tSDK instanceof AFe1qSDK) && aFc1aSDK != AFc1aSDK.SUCCESS) {
                AFe1sSDK aFe1sSDK = new AFe1sSDK(AFb1zSDK.valueOf(AFb1zSDK.this));
                AFd1xSDK afDebugLog2 = AFb1zSDK.valueOf(AFb1zSDK.this).afDebugLog();
                afDebugLog2.AFKeystoreWrapper.execute(new Runnable(aFe1sSDK) {
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
                            int r3 = r3.compareTo(r4)     // Catch:{ all -> 0x0163 }
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
            }
        }

        public final void AFKeystoreWrapper(AFd1tSDK<?> aFd1tSDK) {
            if (aFd1tSDK instanceof AFd1iSDK) {
                AFb1zSDK.this.AFInAppEventParameterName().afRDLog().AFInAppEventParameterName(((AFd1eSDK) aFd1tSDK).AFLogger.afDebugLog);
            }
        }

        public final void valueOf(AFd1tSDK<?> aFd1tSDK) {
        }

        /* synthetic */ AFa1vSDK(AFb1zSDK aFb1zSDK, byte b10) {
            this();
        }
    }

    class AFa1xSDK implements Runnable {
        private final AFa1sSDK valueOf;

        /* synthetic */ AFa1xSDK(AFb1zSDK aFb1zSDK, AFa1sSDK aFa1sSDK, byte b10) {
            this(aFa1sSDK);
        }

        public final void run() {
            AFb1zSDK.AFInAppEventType(AFb1zSDK.this, this.valueOf);
        }

        private AFa1xSDK(AFa1sSDK aFa1sSDK) {
            this.valueOf = aFa1sSDK;
        }
    }

    class AFa1zSDK implements Runnable {
        private final AFa1sSDK values;

        /* synthetic */ AFa1zSDK(AFb1zSDK aFb1zSDK, AFa1sSDK aFa1sSDK, byte b10) {
            this(aFa1sSDK);
        }

        public final void run() {
            AFd1iSDK aFd1iSDK;
            if (this.values.AFKeystoreWrapper()) {
                AFd1iSDK aFd1iSDK2 = new AFd1iSDK(this.values, AFb1zSDK.this.AFInAppEventParameterName());
                aFd1iSDK2.AFVersionDeclaration = AFb1zSDK.AFInAppEventParameterName(AFb1zSDK.this);
                aFd1iSDK = aFd1iSDK2;
            } else {
                aFd1iSDK = new AFd1eSDK(this.values, AFb1zSDK.this.AFInAppEventParameterName());
            }
            AFd1xSDK afDebugLog = AFb1zSDK.this.AFInAppEventParameterName().afDebugLog();
            afDebugLog.AFKeystoreWrapper.execute(new Runnable(aFd1iSDK) {
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
                        int r3 = r3.compareTo(r4)     // Catch:{ all -> 0x0163 }
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
        }

        private AFa1zSDK(AFa1sSDK aFa1sSDK) {
            this.values = aFa1sSDK;
        }
    }

    static {
        char c10;
        valueOf();
        Object[] objArr = new Object[1];
        AFInAppEventParameterName((char) ((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 36816), 1 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), 33 - ((Process.getThreadPriority(0) + 20) >> 6), objArr);
        String substring = "6.10.0".substring(0, "6.10.0".lastIndexOf(((String) objArr[0]).intern()));
        AFKeystoreWrapper = substring;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(substring);
        sb2.append("/androidevent?buildnumber=6.10.0&app_id=");
        AFInAppEventParameterName = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(substring);
        sb3.append("/androidevent?app_id=");
        String obj = sb3.toString();
        afInfoLog = obj;
        StringBuilder sb4 = new StringBuilder("https://%sconversions.%s/api/v");
        sb4.append(obj);
        AFVersionDeclaration = sb4.toString();
        StringBuilder sb5 = new StringBuilder("https://%slaunches.%s/api/v");
        sb5.append(obj);
        AFLogger$LogLevel = sb5.toString();
        StringBuilder sb6 = new StringBuilder("https://%sinapps.%s/api/v");
        sb6.append(obj);
        getLevel = sb6.toString();
        StringBuilder sb7 = new StringBuilder("https://%sattr.%s/api/v");
        sb7.append(obj);
        afWarnLog = sb7.toString();
        int i10 = getSdkVersion + 43;
        onPause = i10 % 128;
        if (i10 % 2 != 0) {
            c10 = 5;
        } else {
            c10 = 'I';
        }
        if (c10 == 5) {
            throw null;
        }
    }

    public AFb1zSDK() {
        AFVersionDeclaration.init();
        AFb1bSDK aFb1bSDK = new AFb1bSDK();
        this.onResponseError = aFb1bSDK;
        AFd1xSDK afDebugLog2 = aFb1bSDK.afDebugLog();
        afDebugLog2.AFInAppEventParameterName.add(new AFa1vSDK(this, (byte) 0));
    }

    static /* synthetic */ Map AFInAppEventParameterName(AFb1zSDK aFb1zSDK) {
        int i10 = onPause + 7;
        getSdkVersion = i10 % 128;
        boolean z10 = i10 % 2 != 0;
        Map<String, Object> map = aFb1zSDK.onAttributionFailure;
        if (z10) {
            return map;
        }
        throw null;
    }

    static /* synthetic */ long AFInAppEventType(AFb1zSDK aFb1zSDK, long j10) {
        int i10 = onPause;
        int i11 = i10 + 35;
        getSdkVersion = i11 % 128;
        char c10 = i11 % 2 == 0 ? 24 : 'Y';
        aFb1zSDK.init = j10;
        if (c10 == 24) {
            int i12 = 20 / 0;
        }
        int i13 = i10 + 49;
        getSdkVersion = i13 % 128;
        if ((i13 % 2 == 0 ? '\"' : 'Q') != '\"') {
            return j10;
        }
        throw null;
    }

    static /* synthetic */ void AFKeystoreWrapper(AFb1zSDK aFb1zSDK) {
        int i10 = onPause + 45;
        getSdkVersion = i10 % 128;
        char c10 = i10 % 2 == 0 ? 25 : 'Y';
        aFb1zSDK.afInfoLog();
        if (c10 == 25) {
            int i11 = 39 / 0;
        }
    }

    private void AFLogger(Context context) {
        this.onAttributionFailure = new HashMap();
        final long currentTimeMillis = System.currentTimeMillis();
        AnonymousClass3 r22 = new AFa1rSDK.AFa1vSDK() {
            public final void AFKeystoreWrapper(String str) {
                AFb1zSDK.AFInAppEventParameterName(AFb1zSDK.this).put("error", str);
            }

            public final void values(String str, String str2, String str3) {
                if (str != null) {
                    AFLogger.afInfoLog("Facebook Deferred AppLink data received: ".concat(str));
                    AFb1zSDK.AFInAppEventParameterName(AFb1zSDK.this).put("link", str);
                    if (str2 != null) {
                        AFb1zSDK.AFInAppEventParameterName(AFb1zSDK.this).put("target_url", str2);
                    }
                    if (str3 != null) {
                        HashMap hashMap = new HashMap();
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put(ShareConstants.PROMO_CODE, str3);
                        hashMap.put(ShareConstants.DEEPLINK_CONTEXT, hashMap2);
                        AFb1zSDK.AFInAppEventParameterName(AFb1zSDK.this).put("extras", hashMap);
                    }
                } else {
                    AFb1zSDK.AFInAppEventParameterName(AFb1zSDK.this).put("link", "");
                }
                AFb1zSDK.AFInAppEventParameterName(AFb1zSDK.this).put("ttr", String.valueOf(System.currentTimeMillis() - currentTimeMillis));
            }
        };
        Class<FacebookSdk> cls = FacebookSdk.class;
        try {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            cls.getMethod("sdkInitialize", new Class[]{Context.class}).invoke((Object) null, new Object[]{context});
            Class<AppLinkData> cls2 = AppLinkData.class;
            String str = AppLinkData.ARGUMENTS_TAPTIME_KEY;
            Class<AppLinkData.CompletionHandler> cls3 = AppLinkData.CompletionHandler.class;
            Method method = cls2.getMethod("fetchDeferredAppLinkData", new Class[]{Context.class, String.class, cls3});
            Object newProxyInstance = Proxy.newProxyInstance(cls3.getClassLoader(), new Class[]{cls3}, new InvocationHandler(cls2, r22) {
                private /* synthetic */ Class AFInAppEventType;
                private /* synthetic */ AFa1vSDK valueOf;

                {
                    this.AFInAppEventType = r1;
                    this.valueOf = r2;
                }

                public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                    String str;
                    String str2;
                    String str3;
                    Bundle bundle;
                    if (method.getName().equals("onDeferredAppLinkDataFetched")) {
                        Object obj2 = objArr[0];
                        if (obj2 != null) {
                            Bundle cast = Bundle.class.cast(this.AFInAppEventType.getMethod("getArgumentBundle", new Class[0]).invoke(this.AFInAppEventType.cast(obj2), new Object[0]));
                            if (cast != null) {
                                str = cast.getString(AppLinkData.ARGUMENTS_NATIVE_URL);
                                str3 = cast.getString("target_url");
                                Bundle bundle2 = cast.getBundle("extras");
                                if (bundle2 == null || (bundle = bundle2.getBundle(ShareConstants.DEEPLINK_CONTEXT)) == null) {
                                    str2 = null;
                                } else {
                                    str2 = bundle.getString(ShareConstants.PROMO_CODE);
                                }
                            } else {
                                str2 = null;
                                str = null;
                                str3 = null;
                            }
                            AFa1vSDK aFa1vSDK = this.valueOf;
                            if (aFa1vSDK != null) {
                                aFa1vSDK.values(str, str3, str2);
                            }
                        } else {
                            AFa1vSDK aFa1vSDK2 = this.valueOf;
                            if (aFa1vSDK2 != null) {
                                aFa1vSDK2.values((String) null, (String) null, (String) null);
                            }
                        }
                        return null;
                    }
                    AFa1vSDK aFa1vSDK3 = this.valueOf;
                    if (aFa1vSDK3 != null) {
                        aFa1vSDK3.AFKeystoreWrapper("onDeferredAppLinkDataFetched invocation failed");
                    }
                    return null;
                }
            });
            String string = context.getString(context.getResources().getIdentifier("facebook_app_id", "string", context.getPackageName()));
            if ((TextUtils.isEmpty(string) ? 'V' : '-') != '-') {
                int i10 = onPause + 89;
                getSdkVersion = i10 % 128;
                if (!(i10 % 2 == 0)) {
                    r22.AFKeystoreWrapper("Facebook app id not defined in resources");
                    return;
                }
                r22.AFKeystoreWrapper("Facebook app id not defined in resources");
                int i11 = 67 / 0;
                return;
            }
            method.invoke((Object) null, new Object[]{context, string, newProxyInstance});
            int i12 = getSdkVersion + 55;
            onPause = i12 % 128;
            int i13 = i12 % 2;
        } catch (NoSuchMethodException e10) {
            AFLogger.afErrorLogForExcManagerOnly("FB method missing error", e10);
            r22.AFKeystoreWrapper(e10.toString());
        } catch (InvocationTargetException e11) {
            AFLogger.afErrorLogForExcManagerOnly("FB invocation error", e11);
            r22.AFKeystoreWrapper(e11.toString());
        } catch (ClassNotFoundException e12) {
            AFLogger.afErrorLogForExcManagerOnly("FB class missing error", e12);
            r22.AFKeystoreWrapper(e12.toString());
        } catch (IllegalAccessException e13) {
            AFLogger.afErrorLogForExcManagerOnly("FB illegal access", e13);
            r22.AFKeystoreWrapper(e13.toString());
        }
    }

    private String AFLogger$LogLevel(Context context) {
        char c10;
        char c11;
        SharedPreferences AFInAppEventType2 = AFInAppEventType(context);
        if (AFInAppEventType2.contains("INSTALL_STORE")) {
            c10 = 'K';
        } else {
            c10 = ']';
        }
        String str = null;
        if (c10 != ']') {
            int i10 = getSdkVersion + 93;
            onPause = i10 % 128;
            int i11 = i10 % 2;
            return AFInAppEventType2.getString("INSTALL_STORE", (String) null);
        }
        if (afRDLog(context)) {
            c11 = '?';
        } else {
            c11 = '2';
        }
        if (c11 == '?') {
            int i12 = getSdkVersion + 89;
            onPause = i12 % 128;
            int i13 = i12 % 2;
            str = AFVersionDeclaration(context);
        }
        AFInAppEventParameterName(context).AFInAppEventParameterName("INSTALL_STORE", str);
        return str;
    }

    private String AFVersionDeclaration(Context context) {
        char c10;
        char c11;
        int i10 = getSdkVersion + 99;
        onPause = i10 % 128;
        int i11 = i10 % 2;
        String string = AppsFlyerProperties.getInstance().getString("api_store_value");
        if (string != null) {
            c10 = 15;
        } else {
            c10 = 'a';
        }
        if (c10 != 'a') {
            int i12 = getSdkVersion + 59;
            onPause = i12 % 128;
            if (i12 % 2 != 0) {
                c11 = 24;
            } else {
                c11 = 3;
            }
            if (c11 == 3) {
                return string;
            }
            throw null;
        }
        String AFInAppEventType2 = AFInAppEventType(context, "AF_STORE");
        int i13 = getSdkVersion + 59;
        onPause = i13 % 128;
        int i14 = i13 % 2;
        return AFInAppEventType2;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    private static void afDebugLog(android.content.Context r4) {
        /*
            boolean r0 = com.appsflyer.internal.AFa1dSDK.values()
            if (r0 == 0) goto L_0x000e
            r0 = 23
            java.lang.String r1 = "OPPO device found"
            com.appsflyer.AFLogger.afRDLog(r1)
            goto L_0x0010
        L_0x000e:
            r0 = 18
        L_0x0010:
            int r1 = android.os.Build.VERSION.SDK_INT
            if (r1 < r0) goto L_0x00b7
            java.lang.String r0 = "keyPropDisableAFKeystore"
            r2 = 1
            boolean r0 = AFInAppEventParameterName((java.lang.String) r0, (boolean) r2)
            if (r0 != 0) goto L_0x00b7
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "OS SDK is="
            r0.<init>(r3)
            r0.append(r1)
            java.lang.String r1 = "; use KeyStore"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.appsflyer.AFLogger.afRDLog(r0)
            com.appsflyer.AFKeystoreWrapper r0 = new com.appsflyer.AFKeystoreWrapper
            r0.<init>(r4)
            boolean r1 = r0.AFKeystoreWrapper()
            if (r1 != 0) goto L_0x0054
            java.lang.ref.WeakReference r1 = new java.lang.ref.WeakReference
            r1.<init>(r4)
            java.lang.String r4 = com.appsflyer.internal.AFb1xSDK.AFInAppEventParameterName(r1)
            r0.AFInAppEventParameterName = r4
            r4 = 0
            r0.AFKeystoreWrapper = r4
            java.lang.String r4 = r0.AFInAppEventParameterName()
            r0.AFKeystoreWrapper(r4)
            goto L_0x009d
        L_0x0054:
            java.lang.String r4 = r0.AFInAppEventParameterName()
            java.lang.Object r1 = r0.valueOf
            monitor-enter(r1)
            int r3 = r0.AFKeystoreWrapper     // Catch:{ all -> 0x00b4 }
            int r3 = r3 + r2
            r0.AFKeystoreWrapper = r3     // Catch:{ all -> 0x00b4 }
            java.lang.String r2 = "Deleting key with alias: "
            java.lang.String r3 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x00b4 }
            java.lang.String r2 = r2.concat(r3)     // Catch:{ all -> 0x00b4 }
            com.appsflyer.AFLogger.afInfoLog(r2)     // Catch:{ all -> 0x00b4 }
            java.lang.Object r2 = r0.valueOf     // Catch:{ KeyStoreException -> 0x007a }
            monitor-enter(r2)     // Catch:{ KeyStoreException -> 0x007a }
            java.security.KeyStore r3 = r0.AFInAppEventType     // Catch:{ all -> 0x0077 }
            r3.deleteEntry(r4)     // Catch:{ all -> 0x0077 }
            monitor-exit(r2)     // Catch:{ all -> 0x0077 }
            goto L_0x0095
        L_0x0077:
            r4 = move-exception
            monitor-exit(r2)     // Catch:{ KeyStoreException -> 0x007a }
            throw r4     // Catch:{ KeyStoreException -> 0x007a }
        L_0x007a:
            r4 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b4 }
            java.lang.String r3 = "Exception "
            r2.<init>(r3)     // Catch:{ all -> 0x00b4 }
            java.lang.String r3 = r4.getMessage()     // Catch:{ all -> 0x00b4 }
            r2.append(r3)     // Catch:{ all -> 0x00b4 }
            java.lang.String r3 = " occurred"
            r2.append(r3)     // Catch:{ all -> 0x00b4 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00b4 }
            com.appsflyer.AFLogger.afErrorLog(r2, r4)     // Catch:{ all -> 0x00b4 }
        L_0x0095:
            monitor-exit(r1)     // Catch:{ all -> 0x00b4 }
            java.lang.String r4 = r0.AFInAppEventParameterName()
            r0.AFKeystoreWrapper(r4)
        L_0x009d:
            java.lang.String r4 = "KSAppsFlyerId"
            java.lang.String r1 = r0.valueOf()
            AFKeystoreWrapper((java.lang.String) r4, (java.lang.String) r1)
            java.lang.String r4 = "KSAppsFlyerRICounter"
            int r0 = r0.AFInAppEventType()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            AFKeystoreWrapper((java.lang.String) r4, (java.lang.String) r0)
            return
        L_0x00b4:
            r4 = move-exception
            monitor-exit(r1)
            throw r4
        L_0x00b7:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r0 = "OS SDK is="
            r4.<init>(r0)
            r4.append(r1)
            java.lang.String r0 = "; no KeyStore usage"
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            com.appsflyer.AFLogger.afRDLog(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1zSDK.afDebugLog(android.content.Context):void");
    }

    private static void afErrorLog(Context context) {
        int i10 = onPause + 71;
        getSdkVersion = i10 % 128;
        int i11 = i10 % 2;
        try {
            boolean z10 = false;
            if ((context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.flags & 32768) != 0) {
                if (context.getResources().getIdentifier("appsflyer_backup_rules", AbstractHttpOverXmpp.Xml.ELEMENT, context.getPackageName()) != 0) {
                    z10 = true;
                }
                if (z10) {
                    int i12 = onPause + 111;
                    getSdkVersion = i12 % 128;
                    int i13 = i12 % 2;
                    AFLogger.afInfoLog("appsflyer_backup_rules.xml detected, using AppsFlyer defined backup rules for AppsFlyer SDK data", true);
                    return;
                }
                AFLogger.values("'allowBackup' is set to true; appsflyer_backup_rules.xml not detected.\nAppsFlyer shared preferences should be excluded from auto backup by adding: <exclude domain=\"sharedpref\" path=\"appsflyer-data\"/> to the Application's <full-backup-content> rules");
            }
            int i14 = getSdkVersion + 73;
            onPause = i14 % 128;
            int i15 = i14 % 2;
        } catch (Exception e10) {
            AFLogger.afErrorLogForExcManagerOnly("checkBackupRules Exception", e10);
            AFLogger.afRDLog("checkBackupRules Exception: ".concat(String.valueOf(e10)));
        }
    }

    private String afErrorLogForExcManagerOnly(Context context) {
        boolean z10;
        char c10;
        File afDebugLog2 = afDebugLog(AFKeystoreWrapper("ro.appsflyer.preinstall.path"));
        boolean z11 = false;
        if (AFInAppEventParameterName(afDebugLog2)) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!z10) {
            afDebugLog2 = afDebugLog(AFInAppEventType(context, "AF_PRE_INSTALL_PATH"));
        }
        if (AFInAppEventParameterName(afDebugLog2)) {
            c10 = 0;
        } else {
            c10 = '0';
        }
        if (c10 == 0) {
            afDebugLog2 = afDebugLog("/data/local/tmp/pre_install.appsflyer");
            int i10 = onPause + 79;
            getSdkVersion = i10 % 128;
            int i11 = i10 % 2;
        }
        if (AFInAppEventParameterName(afDebugLog2)) {
            int i12 = onPause + 17;
            getSdkVersion = i12 % 128;
            if (i12 % 2 == 0) {
                z11 = true;
            }
            if (!z11) {
                afDebugLog2 = afDebugLog("/etc/pre_install.appsflyer");
            } else {
                afDebugLog("/etc/pre_install.appsflyer");
                throw null;
            }
        }
        if (!AFInAppEventParameterName(afDebugLog2)) {
            return AFKeystoreWrapper(afDebugLog2, context.getPackageName());
        }
        int i13 = onPause + 61;
        getSdkVersion = i13 % 128;
        int i14 = i13 % 2;
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
        if ((!com.appsflyer.AppsFlyerProperties.getInstance().getBoolean(com.appsflyer.AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, true) ? 'W' : '/') != '/') goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0038, code lost:
        if ((!com.appsflyer.AppsFlyerProperties.getInstance().getBoolean(com.appsflyer.AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, false) ? '`' : org.bouncycastle.pqc.math.linearalgebra.Matrix.MATRIX_TYPE_RANDOM_REGULAR) != '`') goto L_0x0051;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0062 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0063  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean afInfoLog(android.content.Context r4) {
        /*
            int r0 = onPause
            int r0 = r0 + 19
            int r1 = r0 % 128
            getSdkVersion = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0010
            r0 = r1
            goto L_0x0011
        L_0x0010:
            r0 = r2
        L_0x0011:
            java.lang.String r3 = "collectAndroidIdForceByUser"
            if (r0 == r2) goto L_0x0028
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            boolean r0 = r0.getBoolean(r3, r2)
            r3 = 47
            if (r0 != 0) goto L_0x0024
            r0 = 87
            goto L_0x0025
        L_0x0024:
            r0 = r3
        L_0x0025:
            if (r0 == r3) goto L_0x0051
            goto L_0x003b
        L_0x0028:
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            boolean r0 = r0.getBoolean(r3, r1)
            r3 = 96
            if (r0 != 0) goto L_0x0036
            r0 = r3
            goto L_0x0038
        L_0x0036:
            r0 = 82
        L_0x0038:
            if (r0 == r3) goto L_0x003b
            goto L_0x0051
        L_0x003b:
            int r0 = onPause
            int r0 = r0 + 103
            int r3 = r0 % 128
            getSdkVersion = r3
            int r0 = r0 % 2
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r3 = "collectIMEIForceByUser"
            boolean r0 = r0.getBoolean(r3, r1)
            if (r0 == 0) goto L_0x0053
        L_0x0051:
            r0 = r2
            goto L_0x0054
        L_0x0053:
            r0 = r1
        L_0x0054:
            if (r0 != 0) goto L_0x0058
            r0 = r2
            goto L_0x0059
        L_0x0058:
            r0 = r1
        L_0x0059:
            if (r0 == 0) goto L_0x0063
            boolean r4 = values((android.content.Context) r4)
            if (r4 != 0) goto L_0x0062
            goto L_0x0063
        L_0x0062:
            return r1
        L_0x0063:
            int r4 = onPause
            int r4 = r4 + r2
            int r0 = r4 % 128
            getSdkVersion = r0
            int r4 = r4 % 2
            if (r4 == 0) goto L_0x006f
            return r2
        L_0x006f:
            r4 = 0
            throw r4     // Catch:{ all -> 0x0071 }
        L_0x0071:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1zSDK.afInfoLog(android.content.Context):boolean");
    }

    private static boolean afRDLog(Context context) {
        if (AFInAppEventType(context).contains("appsFlyerCount")) {
            return false;
        }
        int i10 = getSdkVersion;
        int i11 = i10 + 67;
        onPause = i11 % 128;
        int i12 = i11 % 2;
        int i13 = i10 + 55;
        onPause = i13 % 128;
        if (!(i13 % 2 != 0)) {
            return true;
        }
        int i14 = 30 / 0;
        return true;
    }

    private String afWarnLog(Context context) {
        boolean z10;
        String str;
        boolean z11;
        char c10;
        SharedPreferences AFInAppEventType2 = AFInAppEventType(context);
        String AFInAppEventParameterName2 = AFInAppEventParameterName("preInstallName");
        if (AFInAppEventParameterName2 != null) {
            return AFInAppEventParameterName2;
        }
        boolean z12 = false;
        if (AFInAppEventType2.contains("preInstallName")) {
            z10 = true;
        } else {
            z10 = false;
        }
        char c11 = 'Q';
        if (z10) {
            str = AFInAppEventType2.getString("preInstallName", (String) null);
        } else {
            if (afRDLog(context)) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (!z11) {
                int i10 = onPause + 119;
                getSdkVersion = i10 % 128;
                int i11 = i10 % 2;
                AFInAppEventParameterName2 = afErrorLogForExcManagerOnly(context);
                if (AFInAppEventParameterName2 == null) {
                    AFInAppEventParameterName2 = AFInAppEventType(context, "AF_PRE_INSTALL_NAME");
                    int i12 = onPause + 61;
                    getSdkVersion = i12 % 128;
                    int i13 = i12 % 2;
                }
            }
            if (AFInAppEventParameterName2 != null) {
                c10 = 'a';
            } else {
                c10 = 'A';
            }
            if (c10 != 'A') {
                int i14 = onPause + 81;
                getSdkVersion = i14 % 128;
                int i15 = i14 % 2;
                AFInAppEventParameterName(context).AFInAppEventParameterName("preInstallName", AFInAppEventParameterName2);
            }
            str = AFInAppEventParameterName2;
        }
        if (str == null) {
            c11 = 5;
        }
        if (c11 != 5) {
            int i16 = onPause + 45;
            getSdkVersion = i16 % 128;
            if (i16 % 2 != 0) {
                z12 = true;
            }
            AFKeystoreWrapper("preInstallName", str);
            if (!z12) {
                throw null;
            }
        }
        return str;
    }

    private long getLevel(Context context) {
        boolean z10;
        char c10;
        int i10 = onPause + 89;
        getSdkVersion = i10 % 128;
        int i11 = i10 % 2;
        long j10 = AFInAppEventType(context).getLong("AppsFlyerTimePassedSincePrevLaunch", 0);
        long currentTimeMillis = System.currentTimeMillis();
        AFInAppEventParameterName(context).AFInAppEventType("AppsFlyerTimePassedSincePrevLaunch", currentTimeMillis);
        if (j10 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            return -1;
        }
        long j11 = currentTimeMillis - j10;
        int i12 = onPause + 101;
        getSdkVersion = i12 % 128;
        if (i12 % 2 == 0) {
            c10 = '=';
        } else {
            c10 = 4;
        }
        if (c10 != '=') {
            return j11 / 1000;
        }
        return j11 * 1000;
    }

    private static boolean onInstallConversionDataLoadedNative(Context context) {
        ConnectivityManager connectivityManager;
        int i10;
        int i11;
        Network[] networkArr;
        boolean z10;
        NetworkCapabilities networkCapabilities;
        char c10;
        if (context != null) {
            int i12 = getSdkVersion + 59;
            onPause = i12 % 128;
            if (i12 % 2 != 0) {
                try {
                    connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                    networkArr = connectivityManager.getAllNetworks();
                    i11 = networkArr.length;
                    i10 = 1;
                } catch (Exception e10) {
                    AFLogger.afErrorLog("Failed collecting ivc data", e10);
                }
            } else {
                connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                networkArr = connectivityManager.getAllNetworks();
                i11 = networkArr.length;
                i10 = 0;
            }
            int i13 = getSdkVersion + 101;
            onPause = i13 % 128;
            int i14 = i13 % 2;
            while (i10 < i11) {
                int i15 = getSdkVersion + 91;
                onPause = i15 % 128;
                if (i15 % 2 != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!z10) {
                    networkCapabilities = connectivityManager.getNetworkCapabilities(networkArr[i10]);
                    if (networkCapabilities.hasTransport(4)) {
                        c10 = 'F';
                    } else {
                        c10 = '5';
                    }
                    if (c10 == '5') {
                        continue;
                        i10++;
                    }
                } else {
                    networkCapabilities = connectivityManager.getNetworkCapabilities(networkArr[i10]);
                    if (!networkCapabilities.hasTransport(3)) {
                        continue;
                        i10++;
                    }
                }
                if (!networkCapabilities.hasCapability(15)) {
                    int i16 = onPause + 5;
                    getSdkVersion = i16 % 128;
                    int i17 = i16 % 2;
                    return true;
                }
                i10++;
            }
            return false;
        }
        return false;
    }

    private static float onInstallConversionFailureNative(Context context) {
        boolean z10;
        char c10;
        try {
            Intent registerReceiver = context.getApplicationContext().registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int intExtra = registerReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1);
            int intExtra2 = registerReceiver.getIntExtra("scale", -1);
            if (intExtra != -1) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                return 50.0f;
            }
            int i10 = onPause + 73;
            int i11 = i10 % 128;
            getSdkVersion = i11;
            int i12 = i10 % 2;
            if (intExtra2 == -1) {
                c10 = 'J';
            } else {
                c10 = 23;
            }
            if (c10 == 'J') {
                return 50.0f;
            }
            float f10 = (((float) intExtra) / ((float) intExtra2)) * 100.0f;
            int i13 = i11 + 67;
            onPause = i13 % 128;
            int i14 = i13 % 2;
            return f10;
        } catch (Throwable th2) {
            AFLogger.afErrorLog(th2.getMessage(), th2);
            return 1.0f;
        }
    }

    static /* synthetic */ AFb1bSDK valueOf(AFb1zSDK aFb1zSDK) {
        int i10 = getSdkVersion;
        int i11 = i10 + 11;
        onPause = i11 % 128;
        boolean z10 = i11 % 2 != 0;
        AFb1bSDK aFb1bSDK = aFb1zSDK.onResponseError;
        if (!z10) {
            int i12 = i10 + 101;
            onPause = i12 % 128;
            int i13 = i12 % 2;
            return aFb1bSDK;
        }
        throw null;
    }

    static void valueOf() {
        AppsFlyerConversionListener = new char[]{'a', 23681, 47505, 5825, 29685, 53486, 11535, 35362, 59212, 17534, 41323, 64925, '1', 'b', 23701, 47535, 5851, 29688, 3581, 20757, 46119, 7005, 32371, 56660, 8336, 34751, 60109, 18919, 44277, 61490, 22318, 47700, 6492, 36862};
        onValidateInAppFailure = 1358861828806499559L;
    }

    static /* synthetic */ Application values(AFb1zSDK aFb1zSDK) {
        int i10 = getSdkVersion + 71;
        onPause = i10 % 128;
        char c10 = i10 % 2 != 0 ? 'Q' : 16;
        Application application = aFb1zSDK.onDeepLinking;
        if (c10 == 16) {
            return application;
        }
        throw null;
    }

    public final void addPushNotificationDeepLinkPath(String... strArr) {
        char c10;
        int i10 = onPause + 107;
        getSdkVersion = i10 % 128;
        if (i10 % 2 != 0) {
            List asList = Arrays.asList(strArr);
            List<List<String>> list = AFa1qSDK.AFInAppEventParameterName().afDebugLog;
            if (!list.contains(asList)) {
                c10 = 'E';
            } else {
                c10 = ',';
            }
            if (c10 != ',') {
                list.add(asList);
                int i11 = getSdkVersion + 109;
                onPause = i11 % 128;
                int i12 = i11 % 2;
                return;
            }
            return;
        }
        AFa1qSDK.AFInAppEventParameterName().afDebugLog.contains(Arrays.asList(strArr));
        throw null;
    }

    public final void anonymizeUser(boolean z10) {
        boolean z11;
        int i10 = onPause + 69;
        getSdkVersion = i10 % 128;
        if (i10 % 2 == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            AFb1uSDK.AFInAppEventType().AFKeystoreWrapper("anonymizeUser", String.valueOf(z10));
        } else {
            AFb1uSDK AFInAppEventType2 = AFb1uSDK.AFInAppEventType();
            String[] strArr = new String[0];
            strArr[1] = String.valueOf(z10);
            AFInAppEventType2.AFKeystoreWrapper("anonymizeUser", strArr);
        }
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, z10);
    }

    public final void appendParametersToDeepLinkingURL(String str, Map<String, String> map) {
        char c10;
        int i10 = getSdkVersion + 93;
        onPause = i10 % 128;
        if (i10 % 2 != 0) {
            c10 = 'M';
        } else {
            c10 = '6';
        }
        if (c10 != '6') {
            AFa1qSDK AFInAppEventParameterName2 = AFa1qSDK.AFInAppEventParameterName();
            AFInAppEventParameterName2.valueOf = str;
            AFInAppEventParameterName2.afErrorLog = map;
            int i11 = 61 / 0;
        } else {
            AFa1qSDK AFInAppEventParameterName3 = AFa1qSDK.AFInAppEventParameterName();
            AFInAppEventParameterName3.valueOf = str;
            AFInAppEventParameterName3.afErrorLog = map;
        }
        int i12 = onPause + 39;
        getSdkVersion = i12 % 128;
        int i13 = i12 % 2;
    }

    public final void enableFacebookDeferredApplinks(boolean z10) {
        int i10 = onPause + 45;
        getSdkVersion = i10 % 128;
        char c10 = i10 % 2 == 0 ? 'A' : 'C';
        this.onConversionDataFail = z10;
        if (c10 == 'A') {
            throw null;
        }
    }

    public final String getAppsFlyerUID(@NonNull Context context) {
        boolean z10;
        char c10;
        int i10 = onPause + 5;
        getSdkVersion = i10 % 128;
        int i11 = i10 % 2;
        boolean z11 = false;
        AFb1uSDK.AFInAppEventType().AFKeystoreWrapper("getAppsFlyerUID", new String[0]);
        if (context == null) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            AFb1bSDK aFb1bSDK = this.onResponseError;
            if (context != null) {
                c10 = 9;
            } else {
                c10 = '>';
            }
            if (c10 == 9) {
                AFc1ySDK aFc1ySDK = aFb1bSDK.valueOf;
                if (context == null) {
                    z11 = true;
                }
                if (!z11) {
                    aFc1ySDK.values = context.getApplicationContext();
                }
            }
            return AFb1xSDK.AFInAppEventParameterName(new WeakReference(this.onResponseError.values().valueOf.values));
        }
        int i12 = onPause + 119;
        getSdkVersion = i12 % 128;
        int i13 = i12 % 2;
        return null;
    }

    public final String getAttributionId(Context context) {
        try {
            String AFInAppEventParameterName2 = new AFb1ySDK(context, AFInAppEventParameterName()).AFInAppEventParameterName();
            int i10 = getSdkVersion + 103;
            onPause = i10 % 128;
            int i11 = i10 % 2;
            return AFInAppEventParameterName2;
        } catch (Throwable th2) {
            AFLogger.afErrorLog("Could not collect facebook attribution id. ", th2);
            return null;
        }
    }

    public final String getHostName() {
        int i10 = getSdkVersion + 91;
        onPause = i10 % 128;
        if (!(i10 % 2 != 0)) {
            return AFInAppEventParameterName().AppsFlyer2dXConversionCallback().AFKeystoreWrapper();
        }
        AFInAppEventParameterName().AppsFlyer2dXConversionCallback().AFKeystoreWrapper();
        throw null;
    }

    public final String getHostPrefix() {
        int i10 = onPause + 53;
        getSdkVersion = i10 % 128;
        boolean z10 = false;
        if (!(i10 % 2 == 0)) {
            String AFInAppEventParameterName2 = AFInAppEventParameterName().AppsFlyer2dXConversionCallback().AFInAppEventParameterName();
            int i11 = onPause + 83;
            getSdkVersion = i11 % 128;
            if (i11 % 2 == 0) {
                z10 = true;
            }
            if (!z10) {
                return AFInAppEventParameterName2;
            }
            throw null;
        }
        AFInAppEventParameterName().AppsFlyer2dXConversionCallback().AFInAppEventParameterName();
        throw null;
    }

    public final String getOutOfStore(Context context) {
        char c10;
        boolean z10;
        int i10 = onPause + 25;
        getSdkVersion = i10 % 128;
        if (i10 % 2 == 0) {
            c10 = 6;
        } else {
            c10 = 'Y';
        }
        if (c10 != 6) {
            String string = AppsFlyerProperties.getInstance().getString("api_store_value");
            if (string != null) {
                int i11 = getSdkVersion + 43;
                int i12 = i11 % 128;
                onPause = i12;
                if (i11 % 2 == 0) {
                    int i13 = i12 + 61;
                    getSdkVersion = i13 % 128;
                    int i14 = i13 % 2;
                    return string;
                }
                throw null;
            }
            String AFInAppEventType2 = AFInAppEventType(context, "AF_STORE");
            if (AFInAppEventType2 != null) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (!z10) {
                return AFInAppEventType2;
            }
            AFLogger.afInfoLog("No out-of-store value set");
            return null;
        }
        AppsFlyerProperties.getInstance().getString("api_store_value");
        throw null;
    }

    public final String getSdkVersion() {
        boolean z10;
        AFc1xSDK aFc1xSDK;
        int i10 = getSdkVersion + 45;
        onPause = i10 % 128;
        if (i10 % 2 != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            aFc1xSDK = AFInAppEventParameterName();
            aFc1xSDK.AFLogger$LogLevel().AFKeystoreWrapper("getSdkVersion", new String[1]);
        } else {
            aFc1xSDK = AFInAppEventParameterName();
            aFc1xSDK.AFLogger$LogLevel().AFKeystoreWrapper("getSdkVersion", new String[0]);
        }
        aFc1xSDK.values();
        return AFb1fSDK.valueOf();
    }

    public final AppsFlyerLib init(@NonNull String str, AppsFlyerConversionListener appsFlyerConversionListener, @NonNull Context context) {
        char c10;
        boolean z10;
        String str2;
        char c11;
        boolean z11;
        if (this.onAttributionFailureNative) {
            c10 = 8;
        } else {
            c10 = 'G';
        }
        if (c10 != 8) {
            this.onAttributionFailureNative = true;
            this.onResponseError.AFVersionDeclaration().AFInAppEventType = str;
            AFc1sSDK.values(str);
            if (context != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                this.onDeepLinking = (Application) context.getApplicationContext();
                AFb1bSDK aFb1bSDK = this.onResponseError;
                int i10 = getSdkVersion + 103;
                onPause = i10 % 128;
                int i11 = i10 % 2;
                aFb1bSDK.valueOf.values = context.getApplicationContext();
                AFInAppEventParameterName().afRDLog().AFInAppEventType = System.currentTimeMillis();
                AFInAppEventParameterName().onInstallConversionDataLoadedNative().valueOf();
                AFInAppEventParameterName().afInfoLog().AFInAppEventType(new d(this));
                AFf1sSDK level = AFInAppEventParameterName().getLevel();
                final AFf1ySDK aFf1ySDK = new AFf1ySDK(new Runnable() {
                    /* access modifiers changed from: private */
                    public /* synthetic */ void AFInAppEventParameterName() {
                        try {
                            AFe1hSDK aFe1hSDK = new AFe1hSDK();
                            Application values = AFb1zSDK.values(AFb1zSDK.this);
                            if (values != null) {
                                aFe1hSDK.AFKeystoreWrapper = (Application) values.getApplicationContext();
                            }
                            AFb1zSDK aFb1zSDK = AFb1zSDK.this;
                            if (AFb1zSDK.AFInAppEventParameterName(aFb1zSDK, (AFa1sSDK) aFe1hSDK, AFb1zSDK.AFInAppEventType((Context) AFb1zSDK.values(aFb1zSDK)))) {
                                AFb1zSDK.AFInAppEventType(AFb1zSDK.this, (AFa1sSDK) aFe1hSDK);
                            }
                        } catch (Throwable th2) {
                            AFLogger.afErrorLog(th2.getMessage(), th2);
                        }
                    }

                    public final void run() {
                        AFb1zSDK.AFInAppEventType(AFb1zSDK.valueOf(AFb1zSDK.this).AFInAppEventType(), (Runnable) new e(this), TimeUnit.MILLISECONDS);
                    }
                });
                AnonymousClass2 r42 = new Runnable() {
                    public final void run() {
                        SharedPreferences AFInAppEventType2 = AFb1zSDK.AFInAppEventType((Context) AFb1zSDK.values(AFb1zSDK.this));
                        boolean z10 = false;
                        int AFInAppEventParameterName = AFb1zSDK.AFInAppEventParameterName(AFInAppEventType2, false);
                        boolean z11 = AFInAppEventType2.getBoolean(AppsFlyerProperties.NEW_REFERRER_SENT, false);
                        if (aFf1ySDK.afDebugLog == AFf1uSDK.AFa1ySDK.NOT_STARTED) {
                            z10 = true;
                        }
                        if (AFInAppEventParameterName != 1) {
                            return;
                        }
                        if (z10 || z11) {
                            AFb1zSDK aFb1zSDK = AFb1zSDK.this;
                            AFe1hSDK aFe1hSDK = new AFe1hSDK();
                            Application values2 = AFb1zSDK.values(AFb1zSDK.this);
                            if (values2 != null) {
                                aFe1hSDK.AFKeystoreWrapper = (Application) values2.getApplicationContext();
                            }
                            AFb1zSDK.AFInAppEventType(aFb1zSDK, (AFa1sSDK) aFe1hSDK);
                        }
                    }
                };
                level.AFKeystoreWrapper(aFf1ySDK);
                level.AFKeystoreWrapper(new AFf1oSDK(r42));
                level.AFKeystoreWrapper(new AFf1tSDK(r42, AFInAppEventParameterName()));
                level.AFKeystoreWrapper(new AFf1qSDK(r42, AFInAppEventParameterName()));
                Application application = this.onDeepLinking;
                AFc1xSDK AFInAppEventParameterName2 = AFInAppEventParameterName();
                List<ResolveInfo> queryIntentContentProviders = application.getPackageManager().queryIntentContentProviders(new Intent("com.appsflyer.referrer.INSTALL_PROVIDER"), 0);
                if (queryIntentContentProviders != null) {
                    c11 = 'a';
                } else {
                    c11 = '+';
                }
                if (c11 == '+' || queryIntentContentProviders.isEmpty()) {
                    int i12 = onPause + 69;
                    getSdkVersion = i12 % 128;
                    int i13 = i12 % 2;
                } else {
                    ArrayList arrayList = new ArrayList();
                    Iterator<ResolveInfo> it = queryIntentContentProviders.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (!z11) {
                            break;
                        }
                        ProviderInfo providerInfo = it.next().providerInfo;
                        if (providerInfo != null) {
                            arrayList.add(new AFf1rSDK(providerInfo, r42, AFInAppEventParameterName2));
                        } else {
                            AFLogger.afWarnLog("[Preinstall]: com.appsflyer.referrer.INSTALL_PROVIDER Action is set for non ContentProvider component");
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        level.values.addAll(arrayList);
                        StringBuilder sb2 = new StringBuilder("[Preinstall]: Detected ");
                        sb2.append(arrayList.size());
                        sb2.append(" valid preinstall provider(s)");
                        AFLogger.afDebugLog(sb2.toString());
                    }
                }
                for (AFf1uSDK AFInAppEventType2 : level.values()) {
                    AFInAppEventType2.AFInAppEventType(this.onDeepLinking);
                }
                this.onResponseError.AFVersionDeclaration().valueOf();
                AFb1iSDK.AFKeystoreWrapper = this.onDeepLinking;
            } else {
                AFLogger.afWarnLog("context is null, Google Install Referrer will be not initialized");
            }
            AFb1uSDK AFInAppEventType3 = AFb1uSDK.AFInAppEventType();
            String[] strArr = new String[2];
            strArr[0] = str;
            if (appsFlyerConversionListener == null) {
                int i14 = onPause + 93;
                getSdkVersion = i14 % 128;
                int i15 = i14 % 2;
                str2 = "null";
            } else {
                str2 = "conversionDataListener";
            }
            strArr[1] = str2;
            AFInAppEventType3.AFKeystoreWrapper("init", strArr);
            AFLogger.valueOf(String.format("Initializing AppsFlyer SDK: (v%s.%s)", new Object[]{"6.10.0", AFInAppEventType}));
            valueOf = appsFlyerConversionListener;
            int i16 = onPause + 77;
            getSdkVersion = i16 % 128;
            int i17 = i16 % 2;
        }
        return this;
    }

    public final boolean isPreInstalledApp(Context context) {
        boolean z10;
        char c10;
        int i10 = getSdkVersion + 91;
        onPause = i10 % 128;
        int i11 = i10 % 2;
        try {
            if ((context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).flags & 1) != 0) {
                c10 = PropertyUtils.MAPPED_DELIM2;
            } else {
                c10 = 'E';
            }
            if (c10 != 'E') {
                return true;
            }
            int i12 = getSdkVersion + 29;
            onPause = i12 % 128;
            int i13 = i12 % 2;
            int i14 = onPause + 29;
            getSdkVersion = i14 % 128;
            if (i14 % 2 == 0) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                return false;
            }
            throw null;
        } catch (PackageManager.NameNotFoundException e10) {
            AFLogger.afErrorLog("Could not check if app is pre installed", e10);
        }
    }

    @Deprecated
    public final boolean isStopped() {
        int i10 = getSdkVersion + 69;
        onPause = i10 % 128;
        int i11 = i10 % 2;
        boolean AFKeystoreWrapper2 = this.onResponseError.AFVersionDeclaration().AFKeystoreWrapper();
        int i12 = onPause + 63;
        getSdkVersion = i12 % 128;
        int i13 = i12 % 2;
        return AFKeystoreWrapper2;
    }

    public final void logEvent(Context context, String str, Map<String, Object> map) {
        int i10 = getSdkVersion + 11;
        onPause = i10 % 128;
        char c10 = i10 % 2 != 0 ? '\"' : 'Q';
        logEvent(context, str, map, (AppsFlyerRequestListener) null);
        if (c10 != 'Q') {
            int i11 = 46 / 0;
        }
        int i12 = onPause + 71;
        getSdkVersion = i12 % 128;
        int i13 = i12 % 2;
    }

    public final void logLocation(Context context, double d10, double d11) {
        char c10;
        AFb1uSDK.AFInAppEventType().AFKeystoreWrapper("logLocation", String.valueOf(d10), String.valueOf(d11));
        HashMap hashMap = new HashMap();
        hashMap.put(AFInAppEventParameterName.LONGTITUDE, Double.toString(d11));
        hashMap.put(AFInAppEventParameterName.LATITUDE, Double.toString(d10));
        values(context, AFInAppEventType.LOCATION_COORDINATES, hashMap);
        int i10 = onPause + 85;
        getSdkVersion = i10 % 128;
        if (i10 % 2 == 0) {
            c10 = 'b';
        } else {
            c10 = 'K';
        }
        if (c10 != 'K') {
            int i11 = 86 / 0;
        }
    }

    public final void logSession(Context context) {
        boolean z10;
        int i10 = onPause + 121;
        getSdkVersion = i10 % 128;
        if (i10 % 2 == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            AFb1uSDK.AFInAppEventType().AFKeystoreWrapper("logSession", new String[0]);
        } else {
            AFb1uSDK.AFInAppEventType().AFKeystoreWrapper("logSession", new String[0]);
        }
        AFb1uSDK.AFInAppEventType().afRDLog();
        AFKeystoreWrapper(context, AFe1lSDK.logSession);
        values(context, (String) null, (Map<String, Object>) null);
        int i11 = onPause + 87;
        getSdkVersion = i11 % 128;
        int i12 = i11 % 2;
    }

    public final void onPause(Context context) {
        char c10;
        char c11;
        int i10 = onPause + 5;
        getSdkVersion = i10 % 128;
        int i11 = i10 % 2;
        AFb1wSDK.AFa1xSDK aFa1xSDK = AFb1wSDK.values;
        if (aFa1xSDK != null) {
            c10 = '#';
        } else {
            c10 = 28;
        }
        if (c10 != 28) {
            int i12 = getSdkVersion + 5;
            onPause = i12 % 128;
            if (i12 % 2 != 0) {
                c11 = 'K';
            } else {
                c11 = '*';
            }
            aFa1xSDK.values(context);
            if (c11 != '*') {
                throw null;
            }
        }
    }

    @Deprecated
    public final void performOnAppAttribution(@NonNull Context context, @NonNull URI uri) {
        char c10;
        int i10 = onPause + 107;
        int i11 = i10 % 128;
        getSdkVersion = i11;
        int i12 = i10 % 2;
        if (uri != null) {
            c10 = 19;
        } else {
            c10 = 23;
        }
        if (c10 == 19) {
            int i13 = i11 + 19;
            onPause = i13 % 128;
            int i14 = i13 % 2;
            if (!uri.toString().isEmpty()) {
                if (context == null) {
                    StringBuilder sb2 = new StringBuilder("Context is \"");
                    sb2.append(context);
                    sb2.append("\"");
                    AFb1oSDK.AFInAppEventType(sb2.toString(), DeepLinkResult.Error.NETWORK);
                    return;
                }
                AFa1qSDK.AFInAppEventParameterName();
                AFa1qSDK.valueOf(context, new HashMap(), Uri.parse(uri.toString()));
                int i15 = getSdkVersion + 117;
                onPause = i15 % 128;
                int i16 = i15 % 2;
                return;
            }
        }
        StringBuilder sb3 = new StringBuilder("Link is \"");
        sb3.append(uri);
        sb3.append("\"");
        AFb1oSDK.AFInAppEventType(sb3.toString(), DeepLinkResult.Error.NETWORK);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0056, code lost:
        if (r2 != false) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005d, code lost:
        if (r5 != null) goto L_0x005f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void performOnDeepLinking(@androidx.annotation.NonNull android.content.Intent r4, @androidx.annotation.NonNull android.content.Context r5) {
        /*
            r3 = this;
            int r0 = onPause
            int r1 = r0 + 37
            int r2 = r1 % 128
            getSdkVersion = r2
            int r1 = r1 % 2
            r2 = 59
            if (r1 != 0) goto L_0x0011
            r1 = 62
            goto L_0x0012
        L_0x0011:
            r1 = r2
        L_0x0012:
            if (r1 != r2) goto L_0x0074
            if (r4 != 0) goto L_0x001e
            com.appsflyer.deeplink.DeepLinkResult$Error r4 = com.appsflyer.deeplink.DeepLinkResult.Error.DEVELOPER_ERROR
            java.lang.String r5 = "performOnDeepLinking was called with null intent"
            com.appsflyer.internal.AFb1oSDK.AFInAppEventType(r5, r4)
            return
        L_0x001e:
            if (r5 != 0) goto L_0x0030
            int r0 = r0 + 117
            int r4 = r0 % 128
            getSdkVersion = r4
            int r0 = r0 % 2
            com.appsflyer.deeplink.DeepLinkResult$Error r4 = com.appsflyer.deeplink.DeepLinkResult.Error.DEVELOPER_ERROR
            java.lang.String r5 = "performOnDeepLinking was called with null context"
            com.appsflyer.internal.AFb1oSDK.AFInAppEventType(r5, r4)
            return
        L_0x0030:
            android.content.Context r5 = r5.getApplicationContext()
            com.appsflyer.internal.AFb1bSDK r0 = r3.onResponseError
            r1 = 66
            if (r5 == 0) goto L_0x003d
            r2 = 47
            goto L_0x003e
        L_0x003d:
            r2 = r1
        L_0x003e:
            if (r2 == r1) goto L_0x0065
            int r1 = onPause
            int r1 = r1 + 105
            int r2 = r1 % 128
            getSdkVersion = r2
            int r1 = r1 % 2
            if (r1 != 0) goto L_0x005b
            com.appsflyer.internal.AFc1ySDK r0 = r0.valueOf
            r1 = 42
            r2 = 0
            int r1 = r1 / r2
            if (r5 == 0) goto L_0x0055
            goto L_0x0056
        L_0x0055:
            r2 = 1
        L_0x0056:
            if (r2 == 0) goto L_0x005f
            goto L_0x0065
        L_0x0059:
            r4 = move-exception
            throw r4
        L_0x005b:
            com.appsflyer.internal.AFc1ySDK r0 = r0.valueOf
            if (r5 == 0) goto L_0x0065
        L_0x005f:
            android.content.Context r1 = r5.getApplicationContext()
            r0.values = r1
        L_0x0065:
            com.appsflyer.internal.AFb1bSDK r0 = r3.onResponseError
            java.util.concurrent.ExecutorService r0 = r0.AFInAppEventParameterName()
            com.appsflyer.internal.c r1 = new com.appsflyer.internal.c
            r1.<init>(r3, r5, r4)
            r0.execute(r1)
            return
        L_0x0074:
            r4 = 0
            throw r4     // Catch:{ all -> 0x0076 }
        L_0x0076:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1zSDK.performOnDeepLinking(android.content.Intent, android.content.Context):void");
    }

    public final void registerConversionListener(Context context, AppsFlyerConversionListener appsFlyerConversionListener) {
        char c10;
        int i10 = getSdkVersion + 53;
        onPause = i10 % 128;
        if (i10 % 2 != 0) {
            c10 = '#';
        } else {
            c10 = '=';
        }
        if (c10 != '=') {
            AFb1uSDK.AFInAppEventType().AFKeystoreWrapper("registerConversionListener", new String[1]);
        } else {
            AFb1uSDK.AFInAppEventType().AFKeystoreWrapper("registerConversionListener", new String[0]);
        }
        AFInAppEventType(appsFlyerConversionListener);
    }

    public final void registerValidatorListener(Context context, AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener) {
        char c10;
        AFb1uSDK.AFInAppEventType().AFKeystoreWrapper("registerValidatorListener", new String[0]);
        AFLogger.afDebugLog("registerValidatorListener called");
        if (appsFlyerInAppPurchaseValidatorListener == null) {
            c10 = 'E';
        } else {
            c10 = 'H';
        }
        if (c10 != 'H') {
            int i10 = getSdkVersion + 7;
            onPause = i10 % 128;
            int i11 = i10 % 2;
            AFLogger.afDebugLog("registerValidatorListener null listener");
            int i12 = onPause + 19;
            getSdkVersion = i12 % 128;
            int i13 = i12 % 2;
            return;
        }
        values = appsFlyerInAppPurchaseValidatorListener;
    }

    public final void sendAdRevenue(Context context, Map<String, Object> map) {
        boolean z10;
        int i10 = getSdkVersion + 51;
        onPause = i10 % 128;
        Activity activity = null;
        if (i10 % 2 == 0) {
            AFb1bSDK aFb1bSDK = this.onResponseError;
            boolean z11 = false;
            if (context != null) {
                AFc1ySDK aFc1ySDK = aFb1bSDK.valueOf;
                if (context != null) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                if (!z10) {
                    aFc1ySDK.values = context.getApplicationContext();
                    int i11 = onPause + 65;
                    getSdkVersion = i11 % 128;
                    int i12 = i11 % 2;
                }
            }
            AFe1kSDK aFe1kSDK = new AFe1kSDK();
            if (context == null) {
                z11 = true;
            }
            if (!z11) {
                int i13 = getSdkVersion + 15;
                onPause = i13 % 128;
                int i14 = i13 % 2;
                aFe1kSDK.AFKeystoreWrapper = (Application) context.getApplicationContext();
            }
            int AFInAppEventParameterName2 = AFInAppEventParameterName(AFInAppEventType(context));
            aFe1kSDK.AFInAppEventType().put("ad_network", map);
            aFe1kSDK.AFInAppEventType().put("adrevenue_counter", Integer.valueOf(AFInAppEventParameterName2));
            if (context instanceof Activity) {
                activity = (Activity) context;
            }
            values((AFa1sSDK) aFe1kSDK, activity);
            return;
        }
        throw null;
    }

    public final void sendInAppPurchaseData(Context context, Map<String, Object> map, PurchaseHandler.PurchaseValidationCallback purchaseValidationCallback) {
        boolean z10;
        AFc1ySDK aFc1ySDK;
        char c10;
        int i10 = getSdkVersion + 3;
        onPause = i10 % 128;
        int i11 = i10 % 2;
        AFb1bSDK aFb1bSDK = this.onResponseError;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            int i12 = onPause;
            int i13 = i12 + 85;
            getSdkVersion = i13 % 128;
            if (i13 % 2 == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                aFc1ySDK = aFb1bSDK.valueOf;
            } else {
                aFc1ySDK = aFb1bSDK.valueOf;
                int i14 = 35 / 0;
            }
            int i15 = i12 + 43;
            getSdkVersion = i15 % 128;
            if (i15 % 2 == 0) {
                c10 = '2';
            } else {
                c10 = 14;
            }
            if (c10 == 14) {
                aFc1ySDK.values = applicationContext.getApplicationContext();
            } else {
                aFc1ySDK.values = applicationContext.getApplicationContext();
                throw null;
            }
        }
        PurchaseHandler AFLogger2 = AFInAppEventParameterName().AFLogger();
        if (AFLogger2.valueOf(map, purchaseValidationCallback, "purchases")) {
            AFd1jSDK aFd1jSDK = new AFd1jSDK(map, purchaseValidationCallback, AFLogger2.AFInAppEventType);
            AFd1xSDK aFd1xSDK = AFLogger2.values;
            aFd1xSDK.AFKeystoreWrapper.execute(new Runnable(aFd1jSDK) {
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
                        int r3 = r3.compareTo(r4)     // Catch:{ all -> 0x0163 }
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
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002f, code lost:
        if (r1 != true) goto L_0x0038;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0036, code lost:
        if (r6 != null) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void sendPurchaseData(android.content.Context r6, java.util.Map<java.lang.String, java.lang.Object> r7, com.appsflyer.PurchaseHandler.PurchaseValidationCallback r8) {
        /*
            r5 = this;
            int r0 = getSdkVersion
            int r0 = r0 + 59
            int r1 = r0 % 128
            onPause = r1
            int r0 = r0 % 2
            com.appsflyer.internal.AFb1bSDK r0 = r5.onResponseError
            android.content.Context r6 = r6.getApplicationContext()
            r1 = 0
            r2 = 1
            if (r6 == 0) goto L_0x0016
            r3 = r2
            goto L_0x0017
        L_0x0016:
            r3 = r1
        L_0x0017:
            if (r3 == r2) goto L_0x001a
            goto L_0x003e
        L_0x001a:
            int r3 = getSdkVersion
            int r3 = r3 + 21
            int r4 = r3 % 128
            onPause = r4
            int r3 = r3 % 2
            if (r3 == 0) goto L_0x0034
            com.appsflyer.internal.AFc1ySDK r0 = r0.valueOf
            r3 = 48
            int r3 = r3 / r1
            if (r6 == 0) goto L_0x002e
            goto L_0x002f
        L_0x002e:
            r1 = r2
        L_0x002f:
            if (r1 == r2) goto L_0x003e
            goto L_0x0038
        L_0x0032:
            r6 = move-exception
            throw r6
        L_0x0034:
            com.appsflyer.internal.AFc1ySDK r0 = r0.valueOf
            if (r6 == 0) goto L_0x003e
        L_0x0038:
            android.content.Context r6 = r6.getApplicationContext()
            r0.values = r6
        L_0x003e:
            com.appsflyer.internal.AFc1xSDK r6 = r5.AFInAppEventParameterName()
            com.appsflyer.PurchaseHandler r6 = r6.AFLogger()
            java.lang.String r0 = "subscriptions"
            java.lang.String[] r0 = new java.lang.String[]{r0}
            boolean r0 = r6.valueOf(r7, r8, r0)
            if (r0 == 0) goto L_0x0065
            com.appsflyer.internal.AFd1rSDK r0 = new com.appsflyer.internal.AFd1rSDK
            com.appsflyer.internal.AFc1xSDK r1 = r6.AFInAppEventType
            r0.<init>(r7, r8, r1)
            com.appsflyer.internal.AFd1xSDK r6 = r6.values
            java.util.concurrent.Executor r7 = r6.AFKeystoreWrapper
            com.appsflyer.internal.AFd1xSDK$2 r8 = new com.appsflyer.internal.AFd1xSDK$2
            r8.<init>(r0)
            r7.execute(r8)
        L_0x0065:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1zSDK.sendPurchaseData(android.content.Context, java.util.Map, com.appsflyer.PurchaseHandler$PurchaseValidationCallback):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0190  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void sendPushNotificationData(@androidx.annotation.NonNull android.app.Activity r17) {
        /*
            r16 = this;
            r1 = r16
            java.lang.String r0 = "c"
            java.lang.String r2 = "pid"
            int r3 = onPause
            int r4 = r3 + 31
            int r5 = r4 % 128
            getSdkVersion = r5
            r5 = 2
            int r4 = r4 % r5
            r6 = 75
            if (r4 != 0) goto L_0x0017
            r4 = 21
            goto L_0x0018
        L_0x0017:
            r4 = r6
        L_0x0018:
            if (r4 != r6) goto L_0x01c6
            r4 = 0
            java.lang.String r6 = "sendPushNotificationData"
            r8 = 1
            if (r17 == 0) goto L_0x0055
            int r3 = r3 + 35
            int r9 = r3 % 128
            getSdkVersion = r9
            int r3 = r3 % r5
            android.content.Intent r3 = r17.getIntent()
            if (r3 == 0) goto L_0x0055
            com.appsflyer.internal.AFb1uSDK r3 = com.appsflyer.internal.AFb1uSDK.AFInAppEventType()
            java.lang.String[] r9 = new java.lang.String[r5]
            java.lang.String r10 = r17.getLocalClassName()
            r9[r4] = r10
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "activity_intent_"
            r10.<init>(r11)
            android.content.Intent r11 = r17.getIntent()
            java.lang.String r11 = r11.toString()
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            r9[r8] = r10
            r3.AFKeystoreWrapper(r6, r9)
            goto L_0x0081
        L_0x0055:
            if (r17 == 0) goto L_0x006b
            com.appsflyer.internal.AFb1uSDK r3 = com.appsflyer.internal.AFb1uSDK.AFInAppEventType()
            java.lang.String[] r9 = new java.lang.String[r5]
            java.lang.String r10 = r17.getLocalClassName()
            r9[r4] = r10
            java.lang.String r10 = "activity_intent_null"
            r9[r8] = r10
            r3.AFKeystoreWrapper(r6, r9)
            goto L_0x0081
        L_0x006b:
            com.appsflyer.internal.AFb1uSDK r3 = com.appsflyer.internal.AFb1uSDK.AFInAppEventType()
            java.lang.String r9 = "activity_null"
            java.lang.String[] r9 = new java.lang.String[]{r9}
            r3.AFKeystoreWrapper(r6, r9)
            int r3 = getSdkVersion
            int r3 = r3 + 19
            int r6 = r3 % 128
            onPause = r6
            int r3 = r3 % r5
        L_0x0081:
            java.lang.String r3 = valueOf((android.app.Activity) r17)
            r1.onAppOpenAttributionNative = r3
            if (r3 == 0) goto L_0x008a
            r4 = r8
        L_0x008a:
            if (r4 == r8) goto L_0x008e
            goto L_0x01bb
        L_0x008e:
            int r3 = onPause
            int r3 = r3 + 111
            int r4 = r3 % 128
            getSdkVersion = r4
            int r3 = r3 % r5
            long r3 = java.lang.System.currentTimeMillis()
            java.util.Map<java.lang.Long, java.lang.String> r6 = r1.onDeepLinkingNative
            java.lang.String r8 = ")"
            if (r6 != 0) goto L_0x00b0
            java.lang.String r0 = "pushes: initializing pushes history.."
            com.appsflyer.AFLogger.afInfoLog(r0)
            java.util.concurrent.ConcurrentHashMap r0 = new java.util.concurrent.ConcurrentHashMap
            r0.<init>()
            r1.onDeepLinkingNative = r0
            r11 = r3
            goto L_0x017d
        L_0x00b0:
            com.appsflyer.AppsFlyerProperties r6 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0162 }
            java.lang.String r9 = "pushPayloadMaxAging"
            r10 = 1800000(0x1b7740, double:8.89318E-318)
            long r9 = r6.getLong(r9, r10)     // Catch:{ all -> 0x0162 }
            java.util.Map<java.lang.Long, java.lang.String> r6 = r1.onDeepLinkingNative     // Catch:{ all -> 0x0162 }
            java.util.Set r6 = r6.keySet()     // Catch:{ all -> 0x0162 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x0162 }
            r11 = r3
        L_0x00c8:
            boolean r13 = r6.hasNext()     // Catch:{ all -> 0x0160 }
            if (r13 == 0) goto L_0x0155
            java.lang.Object r13 = r6.next()     // Catch:{ all -> 0x0160 }
            java.lang.Long r13 = (java.lang.Long) r13     // Catch:{ all -> 0x0160 }
            org.json.b r14 = new org.json.b     // Catch:{ all -> 0x0160 }
            java.lang.String r15 = r1.onAppOpenAttributionNative     // Catch:{ all -> 0x0160 }
            r14.<init>((java.lang.String) r15)     // Catch:{ all -> 0x0160 }
            org.json.b r15 = new org.json.b     // Catch:{ all -> 0x0160 }
            java.util.Map<java.lang.Long, java.lang.String> r5 = r1.onDeepLinkingNative     // Catch:{ all -> 0x0160 }
            java.lang.Object r5 = r5.get(r13)     // Catch:{ all -> 0x0160 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0160 }
            r15.<init>((java.lang.String) r5)     // Catch:{ all -> 0x0160 }
            java.lang.Object r5 = r14.opt(r2)     // Catch:{ all -> 0x0160 }
            java.lang.Object r7 = r15.opt(r2)     // Catch:{ all -> 0x0160 }
            boolean r5 = r5.equals(r7)     // Catch:{ all -> 0x0160 }
            r7 = 30
            if (r5 == 0) goto L_0x00fa
            r5 = r7
            goto L_0x00fc
        L_0x00fa:
            r5 = 88
        L_0x00fc:
            if (r5 == r7) goto L_0x00ff
            goto L_0x012d
        L_0x00ff:
            java.lang.Object r5 = r14.opt(r0)     // Catch:{ all -> 0x0160 }
            java.lang.Object r7 = r15.opt(r0)     // Catch:{ all -> 0x0160 }
            boolean r5 = r5.equals(r7)     // Catch:{ all -> 0x0160 }
            if (r5 == 0) goto L_0x012d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0160 }
            java.lang.String r2 = "PushNotificationMeasurement: A previous payload with same PID and campaign was already acknowledged! (old: "
            r0.<init>(r2)     // Catch:{ all -> 0x0160 }
            r0.append(r15)     // Catch:{ all -> 0x0160 }
            java.lang.String r2 = ", new: "
            r0.append(r2)     // Catch:{ all -> 0x0160 }
            r0.append(r14)     // Catch:{ all -> 0x0160 }
            r0.append(r8)     // Catch:{ all -> 0x0160 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0160 }
            com.appsflyer.AFLogger.afInfoLog(r0)     // Catch:{ all -> 0x0160 }
            r0 = 0
            r1.onAppOpenAttributionNative = r0     // Catch:{ all -> 0x0160 }
            return
        L_0x012d:
            long r14 = r13.longValue()     // Catch:{ all -> 0x0160 }
            long r14 = r3 - r14
            int r5 = (r14 > r9 ? 1 : (r14 == r9 ? 0 : -1))
            if (r5 <= 0) goto L_0x0146
            int r5 = onPause
            int r5 = r5 + 101
            int r7 = r5 % 128
            getSdkVersion = r7
            r7 = 2
            int r5 = r5 % r7
            java.util.Map<java.lang.Long, java.lang.String> r5 = r1.onDeepLinkingNative     // Catch:{ all -> 0x0160 }
            r5.remove(r13)     // Catch:{ all -> 0x0160 }
        L_0x0146:
            long r14 = r13.longValue()     // Catch:{ all -> 0x0160 }
            int r5 = (r14 > r11 ? 1 : (r14 == r11 ? 0 : -1))
            if (r5 > 0) goto L_0x0152
            long r11 = r13.longValue()     // Catch:{ all -> 0x0160 }
        L_0x0152:
            r5 = 2
            goto L_0x00c8
        L_0x0155:
            int r0 = onPause
            int r0 = r0 + 99
            int r2 = r0 % 128
            getSdkVersion = r2
            r2 = 2
            int r0 = r0 % r2
            goto L_0x017d
        L_0x0160:
            r0 = move-exception
            goto L_0x0164
        L_0x0162:
            r0 = move-exception
            r11 = r3
        L_0x0164:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r5 = "Error while handling push notification measurement: "
            r2.<init>(r5)
            java.lang.Class r5 = r0.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            com.appsflyer.AFLogger.afErrorLog(r2, r0)
        L_0x017d:
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r2 = "pushPayloadHistorySize"
            r5 = 2
            int r0 = r0.getInt(r2, r5)
            java.util.Map<java.lang.Long, java.lang.String> r2 = r1.onDeepLinkingNative
            int r2 = r2.size()
            if (r2 != r0) goto L_0x01ad
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "pushes: removing oldest overflowing push (oldest push:"
            r0.<init>(r2)
            r0.append(r11)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            com.appsflyer.AFLogger.afInfoLog(r0)
            java.util.Map<java.lang.Long, java.lang.String> r0 = r1.onDeepLinkingNative
            java.lang.Long r2 = java.lang.Long.valueOf(r11)
            r0.remove(r2)
        L_0x01ad:
            java.util.Map<java.lang.Long, java.lang.String> r0 = r1.onDeepLinkingNative
            java.lang.Long r2 = java.lang.Long.valueOf(r3)
            java.lang.String r3 = r1.onAppOpenAttributionNative
            r0.put(r2, r3)
            r16.start(r17)
        L_0x01bb:
            int r0 = onPause
            int r0 = r0 + 41
            int r2 = r0 % 128
            getSdkVersion = r2
            r2 = 2
            int r0 = r0 % r2
            return
        L_0x01c6:
            r0 = 0
            throw r0     // Catch:{ all -> 0x01c8 }
        L_0x01c8:
            r0 = move-exception
            r2 = r0
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1zSDK.sendPushNotificationData(android.app.Activity):void");
    }

    public final void setAdditionalData(Map<String, Object> map) {
        boolean z10;
        int i10 = getSdkVersion + 103;
        onPause = i10 % 128;
        int i11 = i10 % 2;
        if (map != null) {
            AFb1uSDK.AFInAppEventType().AFKeystoreWrapper("setAdditionalData", map.toString());
            AppsFlyerProperties.getInstance().setCustomData(new b((Map<?, ?>) map).toString());
        }
        int i12 = getSdkVersion + 31;
        onPause = i12 % 128;
        if (i12 % 2 != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            int i13 = 76 / 0;
        }
    }

    public final void setAndroidIdData(String str) {
        boolean z10;
        int i10 = onPause + 23;
        getSdkVersion = i10 % 128;
        if (i10 % 2 == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            AFb1uSDK.AFInAppEventType().AFKeystoreWrapper("setAndroidIdData", str);
        } else {
            AFb1uSDK.AFInAppEventType().AFKeystoreWrapper("setAndroidIdData", str);
        }
        this.afDebugLog = str;
        int i11 = onPause + 105;
        getSdkVersion = i11 % 128;
        int i12 = i11 % 2;
    }

    public final void setAppId(String str) {
        boolean z10;
        int i10 = onPause + 93;
        getSdkVersion = i10 % 128;
        if (i10 % 2 == 0) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!z10) {
            AFb1uSDK AFInAppEventType2 = AFb1uSDK.AFInAppEventType();
            String[] strArr = new String[0];
            strArr[0] = str;
            AFInAppEventType2.AFKeystoreWrapper("setAppId", strArr);
        } else {
            AFb1uSDK.AFInAppEventType().AFKeystoreWrapper("setAppId", str);
        }
        AFKeystoreWrapper(AppsFlyerProperties.APP_ID, str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004d, code lost:
        if (r0 != false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005f, code lost:
        if (r4 != false) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0062, code lost:
        com.appsflyer.AppsFlyerProperties.getInstance().remove(com.appsflyer.AppsFlyerProperties.ONELINK_DOMAIN);
        com.appsflyer.AppsFlyerProperties.getInstance().remove("onelinkVersion");
        com.appsflyer.AppsFlyerProperties.getInstance().remove(com.appsflyer.AppsFlyerProperties.ONELINK_SCHEME);
        r0 = onPause + 113;
        getSdkVersion = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0087, code lost:
        AFKeystoreWrapper(com.appsflyer.AppsFlyerProperties.ONELINK_ID, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x008a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002f, code lost:
        if (r0 != true) goto L_0x004f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setAppInviteOneLink(java.lang.String r8) {
        /*
            r7 = this;
            int r0 = getSdkVersion
            int r0 = r0 + 113
            int r1 = r0 % 128
            onPause = r1
            int r0 = r0 % 2
            java.lang.String r1 = "oneLinkSlug"
            java.lang.String r2 = "setAppInviteOneLink = "
            java.lang.String r3 = "setAppInviteOneLink"
            r4 = 0
            r5 = 1
            if (r0 == 0) goto L_0x0032
            com.appsflyer.internal.AFb1uSDK r0 = com.appsflyer.internal.AFb1uSDK.AFInAppEventType()
            java.lang.String[] r6 = new java.lang.String[r4]
            r6[r5] = r8
            r0.AFKeystoreWrapper(r3, r6)
            java.lang.String r0 = java.lang.String.valueOf(r8)
            java.lang.String r0 = r2.concat(r0)
            com.appsflyer.AFLogger.afInfoLog(r0)
            if (r8 == 0) goto L_0x002e
            r0 = r4
            goto L_0x002f
        L_0x002e:
            r0 = r5
        L_0x002f:
            if (r0 == r5) goto L_0x0062
            goto L_0x004f
        L_0x0032:
            com.appsflyer.internal.AFb1uSDK r0 = com.appsflyer.internal.AFb1uSDK.AFInAppEventType()
            java.lang.String[] r6 = new java.lang.String[r5]
            r6[r4] = r8
            r0.AFKeystoreWrapper(r3, r6)
            java.lang.String r0 = java.lang.String.valueOf(r8)
            java.lang.String r0 = r2.concat(r0)
            com.appsflyer.AFLogger.afInfoLog(r0)
            if (r8 == 0) goto L_0x004c
            r0 = r5
            goto L_0x004d
        L_0x004c:
            r0 = r4
        L_0x004d:
            if (r0 == 0) goto L_0x0062
        L_0x004f:
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r0 = r0.getString(r1)
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x005e
            goto L_0x005f
        L_0x005e:
            r4 = r5
        L_0x005f:
            if (r4 == 0) goto L_0x0062
            goto L_0x0087
        L_0x0062:
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r2 = "onelinkDomain"
            r0.remove(r2)
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r2 = "onelinkVersion"
            r0.remove(r2)
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r2 = "onelinkScheme"
            r0.remove(r2)
            int r0 = onPause
            int r0 = r0 + 113
            int r2 = r0 % 128
            getSdkVersion = r2
            int r0 = r0 % 2
        L_0x0087:
            AFKeystoreWrapper((java.lang.String) r1, (java.lang.String) r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1zSDK.setAppInviteOneLink(java.lang.String):void");
    }

    public final void setCollectAndroidID(boolean z10) {
        int i10 = getSdkVersion + 17;
        onPause = i10 % 128;
        int i11 = i10 % 2;
        boolean z11 = true;
        AFb1uSDK.AFInAppEventType().AFKeystoreWrapper("setCollectAndroidID", String.valueOf(z10));
        AFKeystoreWrapper(AppsFlyerProperties.COLLECT_ANDROID_ID, Boolean.toString(z10));
        AFKeystoreWrapper(AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, Boolean.toString(z10));
        int i12 = getSdkVersion + 49;
        onPause = i12 % 128;
        if (i12 % 2 != 0) {
            z11 = false;
        }
        if (!z11) {
            throw null;
        }
    }

    public final void setCollectIMEI(boolean z10) {
        boolean z11;
        int i10 = getSdkVersion + 33;
        onPause = i10 % 128;
        if (i10 % 2 != 0) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11) {
            AFb1uSDK.AFInAppEventType().AFKeystoreWrapper("setCollectIMEI", String.valueOf(z10));
        } else {
            AFb1uSDK.AFInAppEventType().AFKeystoreWrapper("setCollectIMEI", String.valueOf(z10));
        }
        AFKeystoreWrapper(AppsFlyerProperties.COLLECT_IMEI, Boolean.toString(z10));
        AFKeystoreWrapper(AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, Boolean.toString(z10));
    }

    @Deprecated
    public final void setCollectOaid(boolean z10) {
        char c10;
        char c11;
        int i10 = getSdkVersion + 77;
        onPause = i10 % 128;
        if (i10 % 2 != 0) {
            c10 = 11;
        } else {
            c10 = 'O';
        }
        if (c10 != 11) {
            AFb1uSDK.AFInAppEventType().AFKeystoreWrapper("setCollectOaid", String.valueOf(z10));
        } else {
            AFb1uSDK AFInAppEventType2 = AFb1uSDK.AFInAppEventType();
            String[] strArr = new String[1];
            strArr[1] = String.valueOf(z10);
            AFInAppEventType2.AFKeystoreWrapper("setCollectOaid", strArr);
        }
        AFKeystoreWrapper(AppsFlyerProperties.COLLECT_OAID, Boolean.toString(z10));
        int i11 = onPause + 125;
        getSdkVersion = i11 % 128;
        if (i11 % 2 == 0) {
            c11 = '9';
        } else {
            c11 = 16;
        }
        if (c11 == '9') {
            int i12 = 26 / 0;
        }
    }

    public final void setCurrencyCode(String str) {
        boolean z10;
        int i10 = getSdkVersion + 13;
        onPause = i10 % 128;
        int i11 = i10 % 2;
        AFb1uSDK.AFInAppEventType().AFKeystoreWrapper("setCurrencyCode", str);
        AppsFlyerProperties.getInstance().set("currencyCode", str);
        int i12 = getSdkVersion + 31;
        onPause = i12 % 128;
        if (i12 % 2 != 0) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!z10) {
            int i13 = 91 / 0;
        }
    }

    public final void setCustomerIdAndLogSession(String str, @NonNull Context context) {
        char c10;
        char c11;
        if (context != null) {
            int i10 = onPause + 73;
            getSdkVersion = i10 % 128;
            if (i10 % 2 == 0) {
                c10 = 6;
            } else {
                c10 = 30;
            }
            if (c10 != 30) {
                values();
                throw null;
            } else if (values()) {
                setCustomerUserId(str);
                StringBuilder sb2 = new StringBuilder("CustomerUserId set: ");
                sb2.append(str);
                sb2.append(" - Initializing AppsFlyer Tacking");
                AFLogger.afInfoLog(sb2.toString(), true);
                String referrer = AppsFlyerProperties.getInstance().getReferrer(context);
                AFKeystoreWrapper(context, AFe1lSDK.setCustomerIdAndLogSession);
                String str2 = this.onResponseError.AFVersionDeclaration().AFInAppEventType;
                if (referrer == null) {
                    referrer = "";
                } else {
                    int i11 = onPause + 53;
                    getSdkVersion = i11 % 128;
                    int i12 = i11 % 2;
                }
                String str3 = referrer;
                if (context instanceof Activity) {
                    c11 = '&';
                } else {
                    c11 = '^';
                }
                if (c11 != '^') {
                    int i13 = onPause + 73;
                    getSdkVersion = i13 % 128;
                    int i14 = i13 % 2;
                    ((Activity) context).getIntent();
                }
                AFKeystoreWrapper(context, (String) null, (Map<String, Object>) null, str3, (String) null);
            } else {
                setCustomerUserId(str);
                AFLogger.afInfoLog("waitForCustomerUserId is false; setting CustomerUserID: ".concat(String.valueOf(str)), true);
            }
        }
    }

    public final void setCustomerUserId(String str) {
        int i10 = onPause + 7;
        getSdkVersion = i10 % 128;
        int i11 = i10 % 2;
        AFb1uSDK.AFInAppEventType().AFKeystoreWrapper("setCustomerUserId", str);
        AFLogger.afInfoLog("setCustomerUserId = ".concat(String.valueOf(str)));
        AFKeystoreWrapper(AppsFlyerProperties.APP_USER_ID, str);
        AFKeystoreWrapper(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false);
        int i12 = onPause + 123;
        getSdkVersion = i12 % 128;
        int i13 = i12 % 2;
    }

    public final void setDebugLog(boolean z10) {
        AFLogger.LogLevel logLevel;
        int i10 = onPause + 103;
        int i11 = i10 % 128;
        getSdkVersion = i11;
        int i12 = i10 % 2;
        if (z10) {
            int i13 = i11 + 79;
            onPause = i13 % 128;
            if (!(i13 % 2 != 0)) {
                logLevel = AFLogger.LogLevel.DEBUG;
            } else {
                logLevel = AFLogger.LogLevel.DEBUG;
                int i14 = 7 / 0;
            }
        } else {
            logLevel = AFLogger.LogLevel.NONE;
            int i15 = onPause + 31;
            getSdkVersion = i15 % 128;
            int i16 = i15 % 2;
        }
        setLogLevel(logLevel);
    }

    public final void setDisableAdvertisingIdentifiers(boolean z10) {
        boolean z11;
        int i10 = getSdkVersion + 27;
        onPause = i10 % 128;
        int i11 = i10 % 2;
        AFLogger.afDebugLog("setDisableAdvertisingIdentifiers: ".concat(String.valueOf(z10)));
        boolean z12 = false;
        if (!z10) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11) {
            int i12 = getSdkVersion + 125;
            onPause = i12 % 128;
            int i13 = i12 % 2;
            z12 = true;
        }
        AFa1bSDK.AFInAppEventParameterName = Boolean.valueOf(z12);
        AppsFlyerProperties.getInstance().remove("advertiserIdEnabled");
        AppsFlyerProperties.getInstance().remove("advertiserId");
    }

    public final void setDisableNetworkData(boolean z10) {
        char c10;
        int i10 = onPause + 35;
        getSdkVersion = i10 % 128;
        if (i10 % 2 == 0) {
            c10 = 21;
        } else {
            c10 = '0';
        }
        if (c10 != '0') {
            AFLogger.afDebugLog("setDisableNetworkData: ".concat(String.valueOf(z10)));
            AFKeystoreWrapper(AppsFlyerProperties.DISABLE_NETWORK_DATA, z10);
            int i11 = 62 / 0;
            return;
        }
        AFLogger.afDebugLog("setDisableNetworkData: ".concat(String.valueOf(z10)));
        AFKeystoreWrapper(AppsFlyerProperties.DISABLE_NETWORK_DATA, z10);
    }

    public final void setExtension(String str) {
        int i10 = onPause + 21;
        getSdkVersion = i10 % 128;
        int i11 = i10 % 2;
        AFb1uSDK.AFInAppEventType().AFKeystoreWrapper("setExtension", str);
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.EXTENSION, str);
        int i12 = onPause + 15;
        getSdkVersion = i12 % 128;
        int i13 = i12 % 2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001e, code lost:
        if (r2 != true) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002b, code lost:
        if (r1 != false) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0053, code lost:
        com.appsflyer.AFLogger.afWarnLog("hostname was empty or null - call for setHost is skipped");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0058, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setHost(java.lang.String r5, @androidx.annotation.NonNull java.lang.String r6) {
        /*
            r4 = this;
            int r0 = getSdkVersion
            int r0 = r0 + 103
            int r1 = r0 % 128
            onPause = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0010
            r0 = r1
            goto L_0x0011
        L_0x0010:
            r0 = r2
        L_0x0011:
            if (r0 == 0) goto L_0x0023
            boolean r0 = com.appsflyer.internal.AFb1nSDK.valueOf(r6)
            r3 = 77
            int r3 = r3 / r2
            if (r0 != 0) goto L_0x001d
            goto L_0x001e
        L_0x001d:
            r2 = r1
        L_0x001e:
            if (r2 == r1) goto L_0x0053
            goto L_0x002d
        L_0x0021:
            r5 = move-exception
            throw r5
        L_0x0023:
            boolean r0 = com.appsflyer.internal.AFb1nSDK.valueOf(r6)
            if (r0 != 0) goto L_0x002a
            goto L_0x002b
        L_0x002a:
            r1 = r2
        L_0x002b:
            if (r1 == 0) goto L_0x0053
        L_0x002d:
            if (r5 == 0) goto L_0x0044
            int r0 = getSdkVersion
            int r0 = r0 + 91
            int r1 = r0 % 128
            onPause = r1
            int r0 = r0 % 2
            if (r0 != 0) goto L_0x0040
            java.lang.String r5 = r5.trim()
            goto L_0x0046
        L_0x0040:
            r5 = 0
            throw r5     // Catch:{ all -> 0x0042 }
        L_0x0042:
            r5 = move-exception
            throw r5
        L_0x0044:
            java.lang.String r5 = ""
        L_0x0046:
            com.appsflyer.internal.AFc1eSDK r0 = new com.appsflyer.internal.AFc1eSDK
            java.lang.String r6 = r6.trim()
            r0.<init>(r5, r6)
            com.appsflyer.internal.AFc1cSDK.values((com.appsflyer.internal.AFc1eSDK) r0)
            return
        L_0x0053:
            java.lang.String r5 = "hostname was empty or null - call for setHost is skipped"
            com.appsflyer.AFLogger.afWarnLog(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1zSDK.setHost(java.lang.String, java.lang.String):void");
    }

    public final void setImeiData(String str) {
        boolean z10;
        int i10 = getSdkVersion + 1;
        onPause = i10 % 128;
        if (i10 % 2 != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            AFb1uSDK.AFInAppEventType().AFKeystoreWrapper("setImeiData", str);
        } else {
            AFb1uSDK AFInAppEventType2 = AFb1uSDK.AFInAppEventType();
            String[] strArr = new String[1];
            strArr[1] = str;
            AFInAppEventType2.AFKeystoreWrapper("setImeiData", strArr);
        }
        this.onResponseError.AFVersionDeclaration().valueOf = str;
    }

    public final void setIsUpdate(boolean z10) {
        boolean z11;
        boolean z12;
        int i10 = getSdkVersion + 59;
        onPause = i10 % 128;
        if (i10 % 2 != 0) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            AFb1uSDK.AFInAppEventType().AFKeystoreWrapper("setIsUpdate", String.valueOf(z10));
        } else {
            AFb1uSDK AFInAppEventType2 = AFb1uSDK.AFInAppEventType();
            String[] strArr = new String[1];
            strArr[1] = String.valueOf(z10);
            AFInAppEventType2.AFKeystoreWrapper("setIsUpdate", strArr);
        }
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.IS_UPDATE, z10);
        int i11 = getSdkVersion + 41;
        onPause = i11 % 128;
        if (i11 % 2 != 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12) {
            int i12 = 26 / 0;
        }
    }

    public final void setLogLevel(@NonNull AFLogger.LogLevel logLevel) {
        char c10;
        boolean z10;
        if (logLevel.getLevel() > AFLogger.LogLevel.NONE.getLevel()) {
            c10 = 'A';
        } else {
            c10 = 11;
        }
        if (c10 != 11) {
            int i10 = getSdkVersion + 107;
            onPause = i10 % 128;
            int i11 = i10 % 2;
            z10 = true;
        } else {
            int i12 = getSdkVersion + 71;
            onPause = i12 % 128;
            int i13 = i12 % 2;
            z10 = false;
        }
        this.onResponseError.AFLogger$LogLevel().AFKeystoreWrapper(RequestBuilder.ACTION_LOG, String.valueOf(z10));
        AppsFlyerProperties.getInstance().set("logLevel", logLevel.getLevel());
    }

    public final void setMinTimeBetweenSessions(int i10) {
        int i11 = getSdkVersion + 23;
        onPause = i11 % 128;
        int i12 = i11 % 2;
        this.onInstallConversionDataLoadedNative = TimeUnit.SECONDS.toMillis((long) i10);
        int i13 = onPause + 9;
        getSdkVersion = i13 % 128;
        if ((i13 % 2 == 0 ? '=' : '1') == '=') {
            throw null;
        }
    }

    public final void setOaidData(String str) {
        int i10 = getSdkVersion + 47;
        onPause = i10 % 128;
        int i11 = i10 % 2;
        boolean z10 = false;
        AFb1uSDK.AFInAppEventType().AFKeystoreWrapper("setOaidData", str);
        AFa1bSDK.valueOf = str;
        int i12 = getSdkVersion + 25;
        onPause = i12 % 128;
        if (i12 % 2 == 0) {
            z10 = true;
        }
        if (!z10) {
            throw null;
        }
    }

    public final void setOneLinkCustomDomain(String... strArr) {
        int i10 = getSdkVersion + 87;
        onPause = i10 % 128;
        int i11 = i10 % 2;
        AFLogger.afDebugLog(String.format("setOneLinkCustomDomain %s", new Object[]{Arrays.toString(strArr)}));
        AFa1qSDK.AFKeystoreWrapper = strArr;
        int i12 = getSdkVersion + 19;
        onPause = i12 % 128;
        int i13 = i12 % 2;
    }

    public final void setOutOfStore(String str) {
        char c10;
        int i10 = onPause;
        int i11 = i10 + 115;
        getSdkVersion = i11 % 128;
        int i12 = i11 % 2;
        if (str != null) {
            c10 = 'E';
        } else {
            c10 = 'I';
        }
        if (c10 != 'E') {
            AFLogger.values("Cannot set setOutOfStore with null");
            int i13 = onPause + 19;
            getSdkVersion = i13 % 128;
            int i14 = i13 % 2;
            return;
        }
        int i15 = i10 + 85;
        getSdkVersion = i15 % 128;
        int i16 = i15 % 2;
        String lowerCase = str.toLowerCase();
        AppsFlyerProperties.getInstance().set("api_store_value", lowerCase);
        AFLogger.afInfoLog("Store API set with value: ".concat(String.valueOf(lowerCase)), true);
        int i17 = onPause + 29;
        getSdkVersion = i17 % 128;
        int i18 = i17 % 2;
    }

    public final void setPartnerData(@NonNull String str, Map<String, Object> map) {
        String str2;
        char c10;
        int i10 = getSdkVersion + 77;
        onPause = i10 % 128;
        if (i10 % 2 == 0) {
            if (this.AppsFlyerInAppPurchaseValidatorListener == null) {
                this.AppsFlyerInAppPurchaseValidatorListener = new AFb1cSDK();
                int i11 = getSdkVersion + 119;
                onPause = i11 % 128;
                int i12 = i11 % 2;
            }
            AFb1cSDK aFb1cSDK = this.AppsFlyerInAppPurchaseValidatorListener;
            if (str != null) {
                int i13 = getSdkVersion + 87;
                onPause = i13 % 128;
                int i14 = i13 % 2;
                if (!str.isEmpty()) {
                    if (map != null) {
                        int i15 = getSdkVersion + 43;
                        onPause = i15 % 128;
                        if (i15 % 2 == 0) {
                            if (map.isEmpty()) {
                                c10 = Matrix.MATRIX_TYPE_RANDOM_REGULAR;
                            } else {
                                c10 = 23;
                            }
                            if (c10 == 23) {
                                StringBuilder sb2 = new StringBuilder("Setting partner data for ");
                                sb2.append(str);
                                sb2.append(": ");
                                sb2.append(map);
                                AFLogger.afDebugLog(sb2.toString());
                                int length = new b((Map<?, ?>) map).toString().length();
                                if (length > 1000) {
                                    AFLogger.afWarnLog("Partner data 1000 characters limit exceeded");
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("error", "limit exceeded: ".concat(String.valueOf(length)));
                                    aFb1cSDK.AFInAppEventParameterName.put(str, hashMap);
                                    return;
                                }
                                aFb1cSDK.values.put(str, map);
                                aFb1cSDK.AFInAppEventParameterName.remove(str);
                                return;
                            }
                        } else {
                            map.isEmpty();
                            throw null;
                        }
                    }
                    if (aFb1cSDK.values.remove(str) == null) {
                        int i16 = getSdkVersion + 19;
                        onPause = i16 % 128;
                        int i17 = i16 % 2;
                        str2 = "Partner data is missing or `null`";
                    } else {
                        str2 = "Cleared partner data for ".concat(str);
                    }
                    AFLogger.afWarnLog(str2);
                    return;
                }
            }
            AFLogger.afWarnLog("Partner ID is missing or `null`");
            return;
        }
        throw null;
    }

    public final void setPhoneNumber(String str) {
        int i10 = onPause + 29;
        getSdkVersion = i10 % 128;
        int i11 = i10 % 2;
        this.onResponse = AFa1aSDK.values(str);
        int i12 = getSdkVersion + 83;
        onPause = i12 % 128;
        if (i12 % 2 != 0) {
            throw null;
        }
    }

    public final void setPreinstallAttribution(String str, String str2, String str3) {
        char c10;
        boolean z10;
        AFLogger.afDebugLog("setPreinstallAttribution API called");
        b bVar = new b();
        if (str != null) {
            c10 = 'H';
        } else {
            c10 = '!';
        }
        if (c10 == 'H') {
            try {
                bVar.put("pid", (Object) str);
            } catch (JSONException e10) {
                AFLogger.afErrorLog(e10.getMessage(), e10);
            }
        }
        boolean z11 = false;
        if (str2 != null) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!z10) {
            int i10 = onPause + 63;
            getSdkVersion = i10 % 128;
            if (i10 % 2 == 0) {
                bVar.put("c", (Object) str2);
                int i11 = 70 / 0;
            } else {
                bVar.put("c", (Object) str2);
            }
        }
        if (str3 == null) {
            z11 = true;
        }
        if (!z11) {
            bVar.put("af_siteid", (Object) str3);
        }
        if (bVar.has("pid")) {
            int i12 = getSdkVersion + 47;
            onPause = i12 % 128;
            int i13 = i12 % 2;
            AFKeystoreWrapper("preInstallName", bVar.toString());
            int i14 = getSdkVersion + 35;
            onPause = i14 % 128;
            int i15 = i14 % 2;
            return;
        }
        AFLogger.afWarnLog("Cannot set preinstall attribution data without a media source");
    }

    public final void setResolveDeepLinkURLs(String... strArr) {
        char c10;
        String format2;
        int i10 = getSdkVersion + 111;
        onPause = i10 % 128;
        if (i10 % 2 != 0) {
            c10 = SignatureVisitor.INSTANCEOF;
        } else {
            c10 = 'H';
        }
        if (c10 != 'H') {
            format2 = String.format("setResolveDeepLinkURLs %s", new Object[]{Arrays.toString(strArr)});
        } else {
            format2 = String.format("setResolveDeepLinkURLs %s", new Object[]{Arrays.toString(strArr)});
        }
        AFLogger.afDebugLog(format2);
        List<String> list = AFa1qSDK.AFInAppEventParameterName;
        list.clear();
        list.addAll(Arrays.asList(strArr));
    }

    @Deprecated
    public final void setSharingFilter(@NonNull String... strArr) {
        int i10 = getSdkVersion + 73;
        onPause = i10 % 128;
        int i11 = i10 % 2;
        setSharingFilterForPartners(strArr);
        int i12 = getSdkVersion + 11;
        onPause = i12 % 128;
        if (i12 % 2 != 0) {
            throw null;
        }
    }

    @Deprecated
    public final void setSharingFilterForAllPartners() {
        int i10 = getSdkVersion + 125;
        onPause = i10 % 128;
        int i11 = i10 % 2;
        setSharingFilterForPartners("all");
        int i12 = getSdkVersion + 79;
        onPause = i12 % 128;
        if (!(i12 % 2 == 0)) {
            throw null;
        }
    }

    public final void setSharingFilterForPartners(String... strArr) {
        this.afRDLog = new AFa1fSDK(strArr);
        int i10 = onPause + 121;
        getSdkVersion = i10 % 128;
        if (i10 % 2 == 0) {
            throw null;
        }
    }

    public final void setUserEmails(String... strArr) {
        int i10 = getSdkVersion + 47;
        onPause = i10 % 128;
        if ((i10 % 2 != 0 ? 'c' : 'C') != 'c') {
            AFb1uSDK.AFInAppEventType().AFKeystoreWrapper("setUserEmails", strArr);
            setUserEmails(AppsFlyerProperties.EmailsCryptType.NONE, strArr);
            return;
        }
        AFb1uSDK.AFInAppEventType().AFKeystoreWrapper("setUserEmails", strArr);
        setUserEmails(AppsFlyerProperties.EmailsCryptType.NONE, strArr);
        throw null;
    }

    public final void start(@NonNull Context context) {
        int i10 = onPause + 39;
        getSdkVersion = i10 % 128;
        int i11 = i10 % 2;
        start(context, (String) null);
        int i12 = getSdkVersion + 123;
        onPause = i12 % 128;
        if (!(i12 % 2 == 0)) {
            throw null;
        }
    }

    public final void stop(boolean z10, Context context) {
        char c10;
        char c11;
        int i10 = onPause;
        int i11 = i10 + 81;
        getSdkVersion = i11 % 128;
        if (i11 % 2 == 0) {
            c10 = '?';
        } else {
            c10 = 18;
        }
        if (c10 != '?') {
            AFb1bSDK aFb1bSDK = this.onResponseError;
            if (context != null) {
                c11 = '[';
            } else {
                c11 = 'V';
            }
            if (c11 == '[') {
                AFc1ySDK aFc1ySDK = aFb1bSDK.valueOf;
                if (context != null) {
                    int i12 = i10 + 87;
                    getSdkVersion = i12 % 128;
                    int i13 = i12 % 2;
                    aFc1ySDK.values = context.getApplicationContext();
                }
            }
            this.onResponseError.AFVersionDeclaration().AFInAppEventParameterName = z10;
            try {
                File file = new File(this.onResponseError.afWarnLog().AFInAppEventType.values.getFilesDir(), "AFRequestCache");
                if (file.exists()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null) {
                        int length = listFiles.length;
                        int i14 = 0;
                        int i15 = onPause + 115;
                        getSdkVersion = i15 % 128;
                        while (true) {
                            int i16 = i15 % 2;
                            if (i14 >= length) {
                                break;
                            }
                            File file2 = listFiles[i14];
                            StringBuilder sb2 = new StringBuilder("CACHE: Found cached request");
                            sb2.append(file2.getName());
                            AFLogger.afInfoLog(sb2.toString());
                            StringBuilder sb3 = new StringBuilder("CACHE: Deleting ");
                            sb3.append(file2.getName());
                            sb3.append(" from cache");
                            AFLogger.afInfoLog(sb3.toString());
                            file2.delete();
                            i14++;
                            i15 = getSdkVersion + 33;
                            onPause = i15 % 128;
                        }
                    }
                } else {
                    file.mkdir();
                }
            } catch (Exception e10) {
                AFLogger.afErrorLog("CACHE: Could not cache request", e10);
            }
            if (z10) {
                AFInAppEventParameterName(context).valueOf("is_stop_tracking_used", true);
                return;
            }
            return;
        }
        throw null;
    }

    public final void subscribeForDeepLink(@NonNull DeepLinkListener deepLinkListener) {
        int i10 = onPause + 71;
        getSdkVersion = i10 % 128;
        int i11 = i10 % 2;
        subscribeForDeepLink(deepLinkListener, TimeUnit.SECONDS.toMillis(3));
        int i12 = onPause + 95;
        getSdkVersion = i12 % 128;
        int i13 = i12 % 2;
    }

    public final void unregisterConversionListener() {
        int i10 = getSdkVersion + 79;
        onPause = i10 % 128;
        int i11 = i10 % 2;
        AFb1uSDK.AFInAppEventType().AFKeystoreWrapper("unregisterConversionListener", new String[0]);
        valueOf = null;
        int i12 = onPause + 121;
        getSdkVersion = i12 % 128;
        int i13 = i12 % 2;
    }

    public final void updateServerUninstallToken(Context context, String str) {
        boolean z10;
        AFb1bSDK aFb1bSDK = this.onResponseError;
        if (context != null) {
            aFb1bSDK.valueOf.values = context.getApplicationContext();
        }
        AFe1pSDK aFe1pSDK = new AFe1pSDK(context);
        if (str == null || str.trim().isEmpty()) {
            AFLogger.afWarnLog("[register] Firebase Token is either empty or null and was not registered.");
            return;
        }
        AFLogger.afInfoLog("[register] Firebase Refreshed Token = ".concat(str));
        AFb1sSDK valueOf2 = aFe1pSDK.valueOf();
        if (valueOf2 == null || !str.equals(valueOf2.AFInAppEventParameterName)) {
            long currentTimeMillis = System.currentTimeMillis();
            if (valueOf2 == null || currentTimeMillis - valueOf2.values > TimeUnit.SECONDS.toMillis(2)) {
                z10 = true;
            } else {
                z10 = false;
            }
            AFb1sSDK aFb1sSDK = new AFb1sSDK(str, currentTimeMillis, !z10);
            aFe1pSDK.AFInAppEventType.AFInAppEventParameterName("afUninstallToken", aFb1sSDK.AFInAppEventParameterName);
            aFe1pSDK.AFInAppEventType.AFInAppEventType("afUninstallToken_received_time", aFb1sSDK.values);
            aFe1pSDK.AFInAppEventType.valueOf("afUninstallToken_queued", aFb1sSDK.AFInAppEventType());
            if (z10) {
                AFe1pSDK.valueOf(str);
            }
        }
    }

    public final void validateAndLogInAppPurchase(Context context, String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        String str6;
        Intent intent;
        Context context2 = context;
        String str7 = str3;
        String str8 = str4;
        String str9 = str5;
        AFb1uSDK AFInAppEventType2 = AFb1uSDK.AFInAppEventType();
        String[] strArr = new String[6];
        strArr[0] = str;
        strArr[1] = str2;
        strArr[2] = str7;
        strArr[3] = str8;
        strArr[4] = str9;
        if (map == null) {
            str6 = "";
        } else {
            str6 = map.toString();
        }
        strArr[5] = str6;
        AFInAppEventType2.AFKeystoreWrapper("validateAndTrackInAppPurchase", strArr);
        if (!isStopped()) {
            StringBuilder sb2 = new StringBuilder("Validate in app called with parameters: ");
            sb2.append(str7);
            sb2.append(" ");
            sb2.append(str8);
            sb2.append(" ");
            sb2.append(str9);
            AFLogger.afInfoLog(sb2.toString());
        }
        if (str == null || str8 == null || str2 == null || str9 == null || str7 == null) {
            AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener = values;
            if (appsFlyerInAppPurchaseValidatorListener != null) {
                appsFlyerInAppPurchaseValidatorListener.onValidateInAppFailure("Please provide purchase parameters");
                return;
            }
            return;
        }
        Context applicationContext = context.getApplicationContext();
        String str10 = this.onResponseError.AFVersionDeclaration().AFInAppEventType;
        if (context2 instanceof Activity) {
            intent = ((Activity) context2).getIntent();
        } else {
            intent = null;
        }
        new Thread(new AFa1cSDK(applicationContext, str10, str, str2, str3, str4, str5, map, intent)).start();
    }

    public final void waitForCustomerUserId(boolean z10) {
        boolean z11;
        String str;
        char c10 = 'E';
        int i10 = getSdkVersion + 69;
        onPause = i10 % 128;
        if (i10 % 2 == 0) {
            c10 = 20;
        }
        if (c10 != 20) {
            str = "initAfterCustomerUserID: ".concat(String.valueOf(z10));
            z11 = false;
        } else {
            str = "initAfterCustomerUserID: ".concat(String.valueOf(z10));
            z11 = true;
        }
        AFLogger.afInfoLog(str, z11);
        AFKeystoreWrapper(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, z10);
        int i11 = getSdkVersion + 85;
        onPause = i11 % 128;
        int i12 = i11 % 2;
    }

    static /* synthetic */ boolean AFInAppEventParameterName(AFb1zSDK aFb1zSDK, AFa1sSDK aFa1sSDK, SharedPreferences sharedPreferences) {
        int i10 = onPause + 77;
        getSdkVersion = i10 % 128;
        int i11 = i10 % 2;
        boolean AFKeystoreWrapper2 = aFb1zSDK.AFKeystoreWrapper(aFa1sSDK, sharedPreferences);
        int i12 = getSdkVersion + 9;
        onPause = i12 % 128;
        int i13 = i12 % 2;
        return AFKeystoreWrapper2;
    }

    static /* synthetic */ void AFInAppEventType(AFb1zSDK aFb1zSDK, AFa1sSDK aFa1sSDK) {
        int i10 = onPause + 47;
        getSdkVersion = i10 % 128;
        int i11 = i10 % 2;
        aFb1zSDK.AFInAppEventParameterName(aFa1sSDK);
        int i12 = getSdkVersion + 105;
        onPause = i12 % 128;
        if ((i12 % 2 != 0 ? 'Q' : 'S') == 'Q') {
            int i13 = 28 / 0;
        }
    }

    static /* synthetic */ boolean valueOf(AFb1zSDK aFb1zSDK, boolean z10) {
        int i10 = getSdkVersion + 97;
        onPause = i10 % 128;
        char c10 = i10 % 2 != 0 ? '7' : '!';
        aFb1zSDK.onConversionDataSuccess = z10;
        if (c10 != '!') {
            int i11 = 77 / 0;
        }
        return z10;
    }

    public final void AFKeystoreWrapper(@NonNull Context context) {
        AFb1bSDK aFb1bSDK = this.onResponseError;
        if ((context != null ? Matrix.MATRIX_TYPE_RANDOM_LT : '^') != '^') {
            int i10 = onPause + 85;
            int i11 = i10 % 128;
            getSdkVersion = i11;
            if ((i10 % 2 == 0 ? 'c' : ' ') == ' ') {
                AFc1ySDK aFc1ySDK = aFb1bSDK.valueOf;
                if (context != null) {
                    int i12 = i11 + 61;
                    onPause = i12 % 128;
                    int i13 = i12 % 2;
                    aFc1ySDK.values = context.getApplicationContext();
                    if (i13 != 0) {
                        throw null;
                    }
                }
            } else {
                AFc1ySDK aFc1ySDK2 = aFb1bSDK.valueOf;
                throw null;
            }
        }
        int i14 = onPause + 21;
        getSdkVersion = i14 % 128;
        int i15 = i14 % 2;
    }

    public final void logEvent(@NonNull Context context, String str, Map<String, Object> map, AppsFlyerRequestListener appsFlyerRequestListener) {
        Activity activity = null;
        HashMap hashMap = map == null ? null : new HashMap(map);
        AFb1bSDK aFb1bSDK = this.onResponseError;
        if (context != null) {
            aFb1bSDK.valueOf.values = context.getApplicationContext();
        }
        AFe1iSDK aFe1iSDK = new AFe1iSDK();
        if (context != null) {
            aFe1iSDK.AFKeystoreWrapper = (Application) context.getApplicationContext();
        }
        aFe1iSDK.afRDLog = str;
        aFe1iSDK.AFInAppEventType = appsFlyerRequestListener;
        if (hashMap != null && hashMap.containsKey(AFInAppEventParameterName.TOUCH_OBJ)) {
            HashMap hashMap2 = new HashMap();
            Object obj = hashMap.get(AFInAppEventParameterName.TOUCH_OBJ);
            if (obj instanceof MotionEvent) {
                MotionEvent motionEvent = (MotionEvent) obj;
                HashMap hashMap3 = new HashMap();
                hashMap3.put("x", Float.valueOf(motionEvent.getX()));
                hashMap3.put("y", Float.valueOf(motionEvent.getY()));
                hashMap2.put("loc", hashMap3);
                hashMap2.put("pf", Float.valueOf(motionEvent.getPressure()));
                hashMap2.put("rad", Float.valueOf(motionEvent.getTouchMajor() / 2.0f));
            } else {
                hashMap2.put("error", "Parsing failed due to invalid input in 'af_touch_obj'.");
                AFLogger.values("Parsing failed due to invalid input in 'af_touch_obj'.");
            }
            Map singletonMap = Collections.singletonMap("tch_data", hashMap2);
            hashMap.remove(AFInAppEventParameterName.TOUCH_OBJ);
            aFe1iSDK.AFInAppEventType((Map<String, ?>) singletonMap);
        }
        aFe1iSDK.values = hashMap;
        AFb1uSDK AFLogger$LogLevel2 = AFInAppEventParameterName().AFLogger$LogLevel();
        String[] strArr = new String[2];
        strArr[0] = str;
        Map map2 = aFe1iSDK.values;
        if (map2 == null) {
            map2 = new HashMap();
        }
        strArr[1] = new b((Map<?, ?>) map2).toString();
        AFLogger$LogLevel2.AFKeystoreWrapper("logEvent", strArr);
        if (str == null) {
            AFKeystoreWrapper(context, AFe1lSDK.logEvent);
        }
        if (context instanceof Activity) {
            activity = (Activity) context;
        }
        values((AFa1sSDK) aFe1iSDK, activity);
    }

    public final void start(@NonNull Context context, String str) {
        int i10 = getSdkVersion + 125;
        onPause = i10 % 128;
        int i11 = i10 % 2;
        start(context, str, (AppsFlyerRequestListener) null);
        int i12 = onPause + 67;
        getSdkVersion = i12 % 128;
        if (i12 % 2 == 0) {
            throw null;
        }
    }

    public final void subscribeForDeepLink(@NonNull DeepLinkListener deepLinkListener, long j10) {
        int i10 = onPause + 67;
        getSdkVersion = i10 % 128;
        if ((i10 % 2 == 0 ? 4 : 'B') != 4) {
            AFa1qSDK.AFInAppEventParameterName().AFInAppEventType = deepLinkListener;
            AFb1pSDK.getLevel = j10;
        } else {
            AFa1qSDK.AFInAppEventParameterName().AFInAppEventType = deepLinkListener;
            AFb1pSDK.getLevel = j10;
            int i11 = 54 / 0;
        }
        int i12 = onPause + 55;
        getSdkVersion = i12 % 128;
        if ((i12 % 2 == 0 ? 13 : 'E') != 'E') {
            int i13 = 48 / 0;
        }
    }

    public final void values(Context context, Intent intent) {
        int i10 = getSdkVersion + 63;
        onPause = i10 % 128;
        int i11 = i10 % 2;
        if (intent.getStringExtra("appsflyer_preinstall") != null) {
            AFInAppEventType(intent.getStringExtra("appsflyer_preinstall"));
        }
        AFLogger.afInfoLog("****** onReceive called *******");
        AppsFlyerProperties.getInstance();
        String stringExtra = intent.getStringExtra("referrer");
        AFLogger.afInfoLog("Play store referrer: ".concat(String.valueOf(stringExtra)));
        boolean z10 = false;
        if (!(stringExtra == null)) {
            int i12 = onPause + 67;
            getSdkVersion = i12 % 128;
            if (i12 % 2 != 0) {
                z10 = true;
            }
            if (z10) {
                AFInAppEventParameterName(context).AFInAppEventParameterName("referrer", stringExtra);
                AppsFlyerProperties instance = AppsFlyerProperties.getInstance();
                instance.set("AF_REFERRER", stringExtra);
                instance.AFKeystoreWrapper = stringExtra;
                if ((AppsFlyerProperties.getInstance().AFKeystoreWrapper() ? 'c' : '5') != '5') {
                    AFLogger.afInfoLog("onReceive: isLaunchCalled");
                    AFKeystoreWrapper(context, AFe1lSDK.onReceive);
                    values(context, stringExtra);
                    return;
                }
                return;
            }
            AFInAppEventParameterName(context).AFInAppEventParameterName("referrer", stringExtra);
            AppsFlyerProperties instance2 = AppsFlyerProperties.getInstance();
            instance2.set("AF_REFERRER", stringExtra);
            instance2.AFKeystoreWrapper = stringExtra;
            AppsFlyerProperties.getInstance().AFKeystoreWrapper();
            throw null;
        }
    }

    static /* synthetic */ void AFInAppEventType(ScheduledExecutorService scheduledExecutorService, Runnable runnable, TimeUnit timeUnit) {
        int i10 = onPause + 53;
        getSdkVersion = i10 % 128;
        if (i10 % 2 == 0) {
        }
        AFInAppEventParameterName(scheduledExecutorService, runnable, 0, timeUnit);
        int i11 = onPause + 57;
        getSdkVersion = i11 % 128;
        if (!(i11 % 2 != 0)) {
            int i12 = 39 / 0;
        }
    }

    @NonNull
    private AFf1uSDK[] afRDLog() {
        boolean z10 = true;
        int i10 = onPause + 1;
        getSdkVersion = i10 % 128;
        if ((i10 % 2 == 0 ? '2' : 5) == 5) {
            AFf1uSDK[] values2 = AFInAppEventParameterName().getLevel().values();
            int i11 = onPause + 29;
            getSdkVersion = i11 % 128;
            if (i11 % 2 == 0) {
                z10 = false;
            }
            if (z10) {
                return values2;
            }
            throw null;
        }
        AFInAppEventParameterName().getLevel().values();
        throw null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void valueOf(Context context, Intent intent) {
        AFb1bSDK aFb1bSDK = this.onResponseError;
        if (context != null) {
            aFb1bSDK.valueOf.values = context.getApplicationContext();
        }
        AFa1qSDK.AFInAppEventParameterName();
        Context context2 = this.onResponseError.valueOf.values;
        if (context2 != null) {
            AFb1eSDK aFb1eSDK = new AFb1eSDK(AFInAppEventType(context2));
            Uri valueOf2 = AFa1qSDK.valueOf(intent);
            boolean z10 = valueOf2 != null && !valueOf2.toString().isEmpty();
            if (!aFb1eSDK.valueOf("ddl_sent") || z10) {
                AFa1qSDK.AFInAppEventParameterName().AFInAppEventType(new HashMap(), intent, context);
            } else {
                AFb1oSDK.AFInAppEventType("No direct deep link", (DeepLinkResult.Error) null);
            }
        } else {
            throw new IllegalStateException("Context must be set via setContext method before calling this dependency.");
        }
    }

    public final AFc1xSDK AFInAppEventParameterName() {
        int i10 = onPause + 57;
        int i11 = i10 % 128;
        getSdkVersion = i11;
        int i12 = i10 % 2;
        AFb1bSDK aFb1bSDK = this.onResponseError;
        int i13 = i11 + 73;
        onPause = i13 % 128;
        int i14 = i13 % 2;
        return aFb1bSDK;
    }

    public final void start(@NonNull Context context, String str, final AppsFlyerRequestListener appsFlyerRequestListener) {
        int i10 = onPause + 89;
        getSdkVersion = i10 % 128;
        if ((i10 % 2 == 0 ? 12 : 'B') == 12) {
            AFb1wSDK.AFa1xSDK aFa1xSDK = AFb1wSDK.values;
            throw null;
        } else if (AFb1wSDK.values == null) {
            boolean z10 = false;
            if ((!this.onAttributionFailureNative ? '1' : '.') == '1') {
                int i11 = getSdkVersion + 71;
                onPause = i11 % 128;
                int i12 = i11 % 2;
                AFLogger.afWarnLog("ERROR: AppsFlyer SDK is not initialized! The API call 'start()' must be called after the 'init(String, AppsFlyerConversionListener)' API method, which should be called on the Application's onCreate.");
                if (!(str != null)) {
                    if (appsFlyerRequestListener != null) {
                        appsFlyerRequestListener.onError(RequestError.NO_DEV_KEY, AFb1dSDK.AFKeystoreWrapper);
                        int i13 = getSdkVersion + 119;
                        onPause = i13 % 128;
                        int i14 = i13 % 2;
                        return;
                    }
                    return;
                }
            }
            AFb1bSDK aFb1bSDK = this.onResponseError;
            if (context != null) {
                aFb1bSDK.valueOf.values = context.getApplicationContext();
                int i15 = onPause + 95;
                getSdkVersion = i15 % 128;
                int i16 = i15 % 2;
            }
            final AFe1nSDK afRDLog2 = AFInAppEventParameterName().afRDLog();
            afRDLog2.AFInAppEventParameterName(AFa1lSDK.AFInAppEventParameterName(context));
            this.onDeepLinking = (Application) context.getApplicationContext();
            AFb1uSDK.AFInAppEventType().AFKeystoreWrapper("start", str);
            String str2 = AFInAppEventType;
            AFLogger.afInfoLog(String.format("Starting AppsFlyer: (v%s.%s)", new Object[]{"6.10.0", str2}));
            StringBuilder sb2 = new StringBuilder("Build Number: ");
            sb2.append(str2);
            AFLogger.afInfoLog(sb2.toString());
            AppsFlyerProperties.getInstance().loadProperties(this.onDeepLinking.getApplicationContext());
            if ((!TextUtils.isEmpty(str) ? '@' : 'U') != 'U') {
                int i17 = getSdkVersion + 109;
                onPause = i17 % 128;
                int i18 = i17 % 2;
                this.onResponseError.AFVersionDeclaration().AFInAppEventType = str;
                AFc1sSDK.values(str);
            } else {
                if ((TextUtils.isEmpty(this.onResponseError.AFVersionDeclaration().AFInAppEventType) ? 'I' : '\'') != '\'') {
                    AFLogger.afWarnLog("ERROR: AppsFlyer SDK is not initialized! You must provide AppsFlyer Dev-Key either in the 'init' API method (should be called on Application's onCreate),or in the start() API (should be called on Activity's onCreate).");
                    if (appsFlyerRequestListener == null) {
                        z10 = true;
                    }
                    if (!z10) {
                        appsFlyerRequestListener.onError(RequestError.NO_DEV_KEY, AFb1dSDK.AFKeystoreWrapper);
                        return;
                    }
                    return;
                }
            }
            AFInAppEventParameterName().afInfoLog().AFInAppEventType((AFd1dSDK) null);
            afInfoLog();
            afErrorLog(this.onDeepLinking.getBaseContext());
            if (this.onConversionDataFail) {
                int i19 = onPause + 95;
                getSdkVersion = i19 % 128;
                int i20 = i19 % 2;
                AFLogger(this.onDeepLinking.getApplicationContext());
            }
            AFb1wSDK.values(context, new AFb1wSDK.AFa1xSDK() {
                public final void valueOf(Activity activity) {
                    afRDLog2.AFKeystoreWrapper();
                    AFb1zSDK.this.AFInAppEventParameterName().afInfoLog().AFInAppEventType((AFd1dSDK) null);
                    AFb1zSDK.AFKeystoreWrapper(AFb1zSDK.this);
                    int AFInAppEventParameterName2 = AFb1zSDK.AFInAppEventParameterName(AFb1zSDK.AFInAppEventType((Context) activity), false);
                    AFLogger.afInfoLog("onBecameForeground");
                    if (AFInAppEventParameterName2 < 2) {
                        AFa1eSDK valueOf2 = AFa1eSDK.valueOf((Context) activity);
                        valueOf2.AFKeystoreWrapper.post(valueOf2.afInfoLog);
                        valueOf2.AFKeystoreWrapper.post(valueOf2.AFInAppEventParameterName);
                    }
                    AFe1bSDK aFe1bSDK = new AFe1bSDK();
                    AFa1qSDK.AFInAppEventParameterName().AFInAppEventType(aFe1bSDK.AFInAppEventType(), activity.getIntent(), activity.getApplication());
                    AFb1zSDK aFb1zSDK = AFb1zSDK.this;
                    aFe1bSDK.AFKeystoreWrapper = (Application) activity.getApplicationContext();
                    aFe1bSDK.AFInAppEventType = appsFlyerRequestListener;
                    aFb1zSDK.values((AFa1sSDK) aFe1bSDK, activity);
                }

                public final void values(Context context) {
                    AFLogger.afInfoLog("onBecameBackground");
                    AFe1nSDK aFe1nSDK = afRDLog2;
                    long currentTimeMillis = System.currentTimeMillis();
                    long j10 = aFe1nSDK.afDebugLog;
                    if (j10 != 0) {
                        long j11 = currentTimeMillis - j10;
                        if (j11 > 0 && j11 < 1000) {
                            j11 = 1000;
                        }
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(j11);
                        aFe1nSDK.AFLogger$LogLevel = seconds;
                        aFe1nSDK.AFInAppEventParameterName.AFInAppEventType("prev_session_dur", seconds);
                    } else {
                        AFLogger.afInfoLog("Metrics: fg ts is missing");
                    }
                    AFLogger.afInfoLog("callStatsBackground background call");
                    AFb1zSDK.this.valueOf((WeakReference<Context>) new WeakReference(context));
                    AFb1zSDK.this.AFInAppEventParameterName().onInstallConversionDataLoadedNative().AFInAppEventType();
                    AFb1uSDK AFInAppEventType2 = AFb1uSDK.AFInAppEventType();
                    if (AFInAppEventType2.afDebugLog()) {
                        AFInAppEventType2.AFInAppEventParameterName();
                        if (context != null && !AppsFlyerLib.getInstance().isStopped()) {
                            AFInAppEventType2.valueOf(context.getPackageName(), context.getPackageManager(), (AFc1xSDK) AFb1zSDK.valueOf(AFb1zSDK.this));
                        }
                        AFInAppEventType2.AFKeystoreWrapper();
                    } else {
                        AFLogger.afDebugLog("RD status is OFF");
                    }
                    AFa1eSDK.valueOf(context).AFKeystoreWrapper();
                }
            }, this.onResponseError.valueOf());
        }
    }

    public static AFb1zSDK AFInAppEventType() {
        int i10 = onPause + 21;
        int i11 = i10 % 128;
        getSdkVersion = i11;
        int i12 = i10 % 2;
        AFb1zSDK aFb1zSDK = afErrorLogForExcManagerOnly;
        int i13 = i11 + 25;
        onPause = i13 % 128;
        if (!(i13 % 2 != 0)) {
            return aFb1zSDK;
        }
        int i14 = 97 / 0;
        return aFb1zSDK;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0053, code lost:
        r2 = new org.json.b(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x005c, code lost:
        if (r2.has(r14) == false) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005e, code lost:
        r0 = new org.json.a((java.lang.String) r2.get(r14));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006a, code lost:
        r0 = new org.json.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006f, code lost:
        r11 = r2;
        r2 = r0;
        r0 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x002c, code lost:
        if (r0 == null) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0046, code lost:
        if (r0 == null) goto L_0x0048;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void AFInAppEventParameterName(android.content.Context r13, java.lang.String r14) {
        /*
            r12 = this;
            int r0 = getSdkVersion
            int r0 = r0 + 15
            int r1 = r0 % 128
            onPause = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 0
            java.lang.String r3 = "received a new (extra) referrer: "
            java.lang.String r4 = "extraReferrers"
            if (r0 == 0) goto L_0x002f
            java.lang.String r0 = java.lang.String.valueOf(r14)
            java.lang.String r0 = r3.concat(r0)
            com.appsflyer.AFLogger.afDebugLog(r0)
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x00da, all -> 0x00c2 }
            android.content.SharedPreferences r0 = AFInAppEventType((android.content.Context) r13)     // Catch:{ JSONException -> 0x00da, all -> 0x00c2 }
            java.lang.String r0 = r0.getString(r4, r2)     // Catch:{ JSONException -> 0x00da, all -> 0x00c2 }
            r2 = 70
            int r2 = r2 / r1
            if (r0 != 0) goto L_0x0053
            goto L_0x0048
        L_0x002f:
            java.lang.String r0 = java.lang.String.valueOf(r14)
            java.lang.String r0 = r3.concat(r0)
            com.appsflyer.AFLogger.afDebugLog(r0)
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x00da, all -> 0x00c2 }
            android.content.SharedPreferences r0 = AFInAppEventType((android.content.Context) r13)     // Catch:{ JSONException -> 0x00da, all -> 0x00c2 }
            java.lang.String r0 = r0.getString(r4, r2)     // Catch:{ JSONException -> 0x00da, all -> 0x00c2 }
            if (r0 != 0) goto L_0x0053
        L_0x0048:
            org.json.b r0 = new org.json.b     // Catch:{ JSONException -> 0x00da, all -> 0x00c2 }
            r0.<init>()     // Catch:{ JSONException -> 0x00da, all -> 0x00c2 }
            org.json.a r2 = new org.json.a     // Catch:{ JSONException -> 0x00da, all -> 0x00c2 }
            r2.<init>()     // Catch:{ JSONException -> 0x00da, all -> 0x00c2 }
            goto L_0x0072
        L_0x0053:
            org.json.b r2 = new org.json.b     // Catch:{ JSONException -> 0x00da, all -> 0x00c2 }
            r2.<init>((java.lang.String) r0)     // Catch:{ JSONException -> 0x00da, all -> 0x00c2 }
            boolean r0 = r2.has(r14)     // Catch:{ JSONException -> 0x00da, all -> 0x00c2 }
            if (r0 == 0) goto L_0x006a
            org.json.a r0 = new org.json.a     // Catch:{ JSONException -> 0x00da, all -> 0x00c2 }
            java.lang.Object r3 = r2.get(r14)     // Catch:{ JSONException -> 0x00da, all -> 0x00c2 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ JSONException -> 0x00da, all -> 0x00c2 }
            r0.<init>((java.lang.String) r3)     // Catch:{ JSONException -> 0x00da, all -> 0x00c2 }
            goto L_0x006f
        L_0x006a:
            org.json.a r0 = new org.json.a     // Catch:{ JSONException -> 0x00da, all -> 0x00c2 }
            r0.<init>()     // Catch:{ JSONException -> 0x00da, all -> 0x00c2 }
        L_0x006f:
            r11 = r2
            r2 = r0
            r0 = r11
        L_0x0072:
            int r3 = r2.o()     // Catch:{ JSONException -> 0x00da, all -> 0x00c2 }
            long r7 = (long) r3
            r9 = 5
            int r3 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            r7 = 1
            if (r3 >= 0) goto L_0x007f
            goto L_0x0080
        L_0x007f:
            r1 = r7
        L_0x0080:
            if (r1 == r7) goto L_0x008f
            int r1 = onPause
            int r1 = r1 + 117
            int r3 = r1 % 128
            getSdkVersion = r3
            int r1 = r1 % 2
            r2.D(r5)     // Catch:{ JSONException -> 0x00da, all -> 0x00c2 }
        L_0x008f:
            int r1 = r0.length()     // Catch:{ JSONException -> 0x00da, all -> 0x00c2 }
            long r5 = (long) r1     // Catch:{ JSONException -> 0x00da, all -> 0x00c2 }
            r7 = 4
            int r1 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            r3 = 25
            if (r1 < 0) goto L_0x009f
            r1 = 10
            goto L_0x00a0
        L_0x009f:
            r1 = r3
        L_0x00a0:
            if (r1 == r3) goto L_0x00af
            AFKeystoreWrapper((org.json.b) r0)     // Catch:{ JSONException -> 0x00da, all -> 0x00c2 }
            int r1 = getSdkVersion
            int r1 = r1 + 107
            int r3 = r1 % 128
            onPause = r3
            int r1 = r1 % 2
        L_0x00af:
            java.lang.String r1 = r2.toString()     // Catch:{ JSONException -> 0x00da, all -> 0x00c2 }
            r0.put((java.lang.String) r14, (java.lang.Object) r1)     // Catch:{ JSONException -> 0x00da, all -> 0x00c2 }
            com.appsflyer.internal.AFb1gSDK r13 = r12.AFInAppEventParameterName((android.content.Context) r13)     // Catch:{ JSONException -> 0x00da, all -> 0x00c2 }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x00da, all -> 0x00c2 }
            r13.AFInAppEventParameterName((java.lang.String) r4, (java.lang.String) r0)     // Catch:{ JSONException -> 0x00da, all -> 0x00c2 }
            return
        L_0x00c2:
            r13 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Couldn't save referrer - "
            r0.<init>(r1)
            r0.append(r14)
            java.lang.String r14 = ": "
            r0.append(r14)
            java.lang.String r14 = r0.toString()
            com.appsflyer.AFLogger.afErrorLog(r14, r13)
            return
        L_0x00da:
            r13 = move-exception
            java.lang.String r14 = "error at addReferrer"
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r14, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1zSDK.AFInAppEventParameterName(android.content.Context, java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void AFInAppEventType(AFd1aSDK aFd1aSDK) {
        int i10 = onPause + 13;
        getSdkVersion = i10 % 128;
        int i11 = i10 % 2;
        if (!(aFd1aSDK != AFd1aSDK.SUCCESS)) {
            int i12 = getSdkVersion + 1;
            onPause = i12 % 128;
            int i13 = i12 % 2;
            AFInAppEventParameterName().onInstallConversionDataLoadedNative().AFInAppEventParameterName();
        }
        int i14 = getSdkVersion + 51;
        onPause = i14 % 128;
        if ((i14 % 2 != 0 ? 26 : 'Q') != 'Q') {
            int i15 = 51 / 0;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x008d, code lost:
        if (com.appsflyer.internal.AFb1zSDK.AnonymousClass10.values[r10.ordinal()] != 2) goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x009c, code lost:
        if (com.appsflyer.internal.AFb1zSDK.AnonymousClass10.values[r10.ordinal()] != 2) goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00a8, code lost:
        r2.add(r1);
        r1 = "plain_el_arr";
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setUserEmails(com.appsflyer.AppsFlyerProperties.EmailsCryptType r10, java.lang.String... r11) {
        /*
            r9 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r11.length
            int r1 = r1 + 1
            r0.<init>(r1)
            java.lang.String r1 = r10.toString()
            r0.add(r1)
            java.util.List r1 = java.util.Arrays.asList(r11)
            r0.addAll(r1)
            com.appsflyer.internal.AFb1uSDK r1 = com.appsflyer.internal.AFb1uSDK.AFInAppEventType()
            int r2 = r11.length
            int r2 = r2 + 1
            java.lang.String[] r2 = new java.lang.String[r2]
            java.lang.Object[] r0 = r0.toArray(r2)
            java.lang.String[] r0 = (java.lang.String[]) r0
            java.lang.String r2 = "setUserEmails"
            r1.AFKeystoreWrapper(r2, r0)
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            int r1 = r10.getValue()
            java.lang.String r2 = "userEmailsCryptType"
            r0.set((java.lang.String) r2, (int) r1)
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r1 = 0
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            int r3 = r11.length
            int r4 = onPause
            int r4 = r4 + 117
            int r5 = r4 % 128
            getSdkVersion = r5
            r5 = 2
            int r4 = r4 % r5
            r4 = 0
            r6 = r4
        L_0x004f:
            r7 = 87
            if (r6 >= r3) goto L_0x0055
            r8 = r7
            goto L_0x0057
        L_0x0055:
            r8 = 41
        L_0x0057:
            if (r8 == r7) goto L_0x006d
            r0.put(r1, r2)
            org.json.b r10 = new org.json.b
            r10.<init>((java.util.Map<?, ?>) r0)
            com.appsflyer.AppsFlyerProperties r11 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r10 = r10.toString()
            r11.setUserEmails(r10)
            return
        L_0x006d:
            int r1 = onPause
            int r1 = r1 + 5
            int r7 = r1 % 128
            getSdkVersion = r7
            int r1 = r1 % r5
            r7 = 78
            if (r1 != 0) goto L_0x007d
            r1 = 45
            goto L_0x007e
        L_0x007d:
            r1 = r7
        L_0x007e:
            if (r1 == r7) goto L_0x0092
            r1 = r11[r6]
            int[] r7 = com.appsflyer.internal.AFb1zSDK.AnonymousClass10.values
            int r8 = r10.ordinal()
            r7 = r7[r8]
            r8 = 22
            int r8 = r8 / r4
            if (r7 == r5) goto L_0x00a8
            goto L_0x009e
        L_0x0090:
            r10 = move-exception
            throw r10
        L_0x0092:
            r1 = r11[r6]
            int[] r7 = com.appsflyer.internal.AFb1zSDK.AnonymousClass10.values
            int r8 = r10.ordinal()
            r7 = r7[r8]
            if (r7 == r5) goto L_0x00a8
        L_0x009e:
            java.lang.String r1 = com.appsflyer.internal.AFa1aSDK.values((java.lang.String) r1)
            r2.add(r1)
            java.lang.String r1 = "sha256_el_arr"
            goto L_0x00ad
        L_0x00a8:
            r2.add(r1)
            java.lang.String r1 = "plain_el_arr"
        L_0x00ad:
            int r6 = r6 + 1
            int r7 = getSdkVersion
            int r7 = r7 + 111
            int r8 = r7 % 128
            onPause = r8
            int r7 = r7 % r5
            goto L_0x004f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1zSDK.setUserEmails(com.appsflyer.AppsFlyerProperties$EmailsCryptType, java.lang.String[]):void");
    }

    private static void AFInAppEventType(AppsFlyerConversionListener appsFlyerConversionListener) {
        int i10 = onPause + 107;
        int i11 = i10 % 128;
        getSdkVersion = i11;
        int i12 = i10 % 2;
        if (appsFlyerConversionListener == null) {
            int i13 = i11 + 15;
            onPause = i13 % 128;
            if ((i13 % 2 != 0 ? 10 : '_') != '_') {
                throw null;
            }
            return;
        }
        valueOf = appsFlyerConversionListener;
    }

    private static boolean AFInAppEventType(@NonNull SharedPreferences sharedPreferences) {
        int i10 = getSdkVersion + 53;
        onPause = i10 % 128;
        char c10 = i10 % 2 != 0 ? 'c' : 22;
        String string = sharedPreferences.getString("sentSuccessfully", (String) null);
        if (c10 != 'c') {
            boolean parseBoolean = Boolean.parseBoolean(string);
            int i11 = getSdkVersion + 117;
            onPause = i11 % 128;
            int i12 = i11 % 2;
            return parseBoolean;
        }
        Boolean.parseBoolean(string);
        throw null;
    }

    private static void AFKeystoreWrapper(b bVar) {
        String str;
        ArrayList arrayList = new ArrayList();
        Iterator<String> keys = bVar.keys();
        while (true) {
            if (!keys.hasNext()) {
                break;
            }
            try {
                a aVar = new a((String) bVar.get(keys.next()));
                for (int i10 = 0; i10 < aVar.o(); i10++) {
                    arrayList.add(Long.valueOf(aVar.m(i10)));
                }
            } catch (JSONException e10) {
                AFLogger.afErrorLogForExcManagerOnly("error at timeStampArr", e10);
            }
        }
        Collections.sort(arrayList);
        Iterator<String> keys2 = bVar.keys();
        loop2:
        while (true) {
            str = null;
            while (true) {
                if (!(!keys2.hasNext()) && str == null) {
                    String next = keys2.next();
                    try {
                        a aVar2 = new a((String) bVar.get(next));
                        int i11 = 0;
                        while (true) {
                            if (!(i11 < aVar2.o())) {
                                continue;
                                break;
                            }
                            int i12 = onPause + 99;
                            getSdkVersion = i12 % 128;
                            if (i12 % 2 == 0) {
                                if (aVar2.m(i11) == ((Long) arrayList.get(1)).longValue()) {
                                    break;
                                }
                            } else if (aVar2.m(i11) == ((Long) arrayList.get(0)).longValue()) {
                                break;
                            }
                            int i13 = onPause + 115;
                            getSdkVersion = i13 % 128;
                            int i14 = i13 % 2;
                            if (aVar2.m(i11) == ((Long) arrayList.get(1)).longValue()) {
                                break;
                            }
                            if (aVar2.m(i11) == ((Long) arrayList.get(arrayList.size() - 1)).longValue()) {
                                break;
                            }
                            i11++;
                            int i15 = onPause + 77;
                            getSdkVersion = i15 % 128;
                            int i16 = i15 % 2;
                            str = next;
                        }
                    } catch (JSONException e11) {
                        AFLogger.afErrorLogForExcManagerOnly("error at manageExtraReferrers", e11);
                    }
                }
            }
        }
        if ((str != null ? ' ' : 'L') != 'L') {
            int i17 = onPause + 65;
            getSdkVersion = i17 % 128;
            int i18 = i17 % 2;
            bVar.remove(str);
            if (i18 == 0) {
                int i19 = 10 / 0;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0021, code lost:
        if (com.appsflyer.internal.AFd1nSDK.AFLogger() != false) goto L_0x0023;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0037, code lost:
        r0 = AFInAppEventParameterName();
        r1 = r0.afDebugLog();
        r1.AFKeystoreWrapper.execute(new com.appsflyer.internal.AFd1xSDK.AnonymousClass2(new com.appsflyer.internal.AFd1nSDK(r0)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004e, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0017, code lost:
        if (com.appsflyer.internal.AFd1nSDK.AFLogger() != false) goto L_0x0023;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void afInfoLog() {
        /*
            r4 = this;
            int r0 = getSdkVersion
            int r0 = r0 + 107
            int r1 = r0 % 128
            onPause = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0010
            r0 = r1
            goto L_0x0011
        L_0x0010:
            r0 = r2
        L_0x0011:
            if (r0 == 0) goto L_0x001a
            boolean r0 = com.appsflyer.internal.AFd1nSDK.AFLogger()
            if (r0 == 0) goto L_0x0037
            goto L_0x0023
        L_0x001a:
            boolean r0 = com.appsflyer.internal.AFd1nSDK.AFLogger()
            r3 = 31
            int r3 = r3 / r1
            if (r0 == 0) goto L_0x0037
        L_0x0023:
            int r0 = getSdkVersion
            int r0 = r0 + 7
            int r3 = r0 % 128
            onPause = r3
            int r0 = r0 % 2
            if (r0 == 0) goto L_0x0030
            r1 = r2
        L_0x0030:
            if (r1 == r2) goto L_0x0033
            return
        L_0x0033:
            r0 = 0
            throw r0     // Catch:{ all -> 0x0035 }
        L_0x0035:
            r0 = move-exception
            throw r0
        L_0x0037:
            com.appsflyer.internal.AFc1xSDK r0 = r4.AFInAppEventParameterName()
            com.appsflyer.internal.AFd1xSDK r1 = r0.afDebugLog()
            com.appsflyer.internal.AFd1nSDK r2 = new com.appsflyer.internal.AFd1nSDK
            r2.<init>(r0)
            java.util.concurrent.Executor r0 = r1.AFKeystoreWrapper
            com.appsflyer.internal.AFd1xSDK$2 r3 = new com.appsflyer.internal.AFd1xSDK$2
            r3.<init>(r2)
            r0.execute(r3)
            return
        L_0x004f:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1zSDK.afInfoLog():void");
    }

    private static void AFInAppEventType(Context context, Map<String, Object> map, String str) {
        int i10 = onPause + 65;
        getSdkVersion = i10 % 128;
        if (!(i10 % 2 == 0)) {
            SharedPreferences AFInAppEventType2 = AFInAppEventType(context);
            SharedPreferences.Editor edit = AFInAppEventType2.edit();
            try {
                String string = AFInAppEventType2.getString("prev_event_name", (String) null);
                if (string != null) {
                    b bVar = new b();
                    bVar.put("prev_event_timestamp", AFInAppEventType2.getLong("prev_event_timestamp", -1));
                    bVar.put("prev_event_name", (Object) string);
                    map.put("prev_event", bVar);
                }
                edit.putString("prev_event_name", str).putLong("prev_event_timestamp", System.currentTimeMillis()).apply();
                int i11 = getSdkVersion + 99;
                onPause = i11 % 128;
                if ((i11 % 2 != 0 ? 'N' : 27) == 'N') {
                    int i12 = 21 / 0;
                }
            } catch (Exception e10) {
                AFLogger.afErrorLog("Error while processing previous event.", e10);
            }
        } else {
            SharedPreferences AFInAppEventType3 = AFInAppEventType(context);
            AFInAppEventType3.edit();
            AFInAppEventType3.getString("prev_event_name", (String) null);
            throw null;
        }
    }

    private boolean afErrorLog() {
        int i10 = onPause + 119;
        getSdkVersion = i10 % 128;
        if (!(i10 % 2 == 0)) {
            Map<String, Object> map = this.onAttributionFailure;
            if (map == null || map.isEmpty()) {
                int i11 = onPause + 9;
                getSdkVersion = i11 % 128;
                if ((i11 % 2 == 0 ? '$' : 29) != '$') {
                    return false;
                }
                throw null;
            }
            int i12 = getSdkVersion + 83;
            onPause = i12 % 128;
            int i13 = i12 % 2;
            return true;
        }
        throw null;
    }

    /* access modifiers changed from: package-private */
    public final void valueOf(WeakReference<Context> weakReference) {
        int i10 = onPause + 91;
        getSdkVersion = i10 % 128;
        int i11 = i10 % 2;
        if (weakReference.get() != null) {
            AFLogger.afInfoLog("app went to background");
            SharedPreferences AFInAppEventType2 = AFInAppEventType(weakReference.get());
            AppsFlyerProperties.getInstance().saveProperties(AFInAppEventType2);
            long j10 = AFInAppEventParameterName().afRDLog().AFLogger$LogLevel;
            HashMap hashMap = new HashMap();
            String str = this.onResponseError.AFVersionDeclaration().AFInAppEventType;
            boolean z10 = true;
            if (str == null) {
                int i12 = getSdkVersion + 35;
                onPause = i12 % 128;
                if (i12 % 2 == 0) {
                    z10 = false;
                }
                AFLogger.afWarnLog("[callStats] AppsFlyer's SDK cannot send any event without providing DevKey.");
                if (z10) {
                    throw null;
                }
                return;
            }
            String AFInAppEventParameterName2 = AFInAppEventParameterName("KSAppsFlyerId");
            if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, false)) {
                hashMap.put(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            }
            AFc1vSDK.AFa1wSDK values2 = AFa1bSDK.values(weakReference.get().getContentResolver());
            if ((values2 != null ? '<' : 29) == '<') {
                int i13 = onPause + 89;
                getSdkVersion = i13 % 128;
                int i14 = i13 % 2;
                hashMap.put("amazon_aid", values2.AFInAppEventType);
                hashMap.put("amazon_aid_limit", String.valueOf(values2.valueOf));
            }
            String string = AppsFlyerProperties.getInstance().getString("advertiserId");
            if (string != null) {
                hashMap.put("advertiserId", string);
            }
            hashMap.put("app_id", weakReference.get().getPackageName());
            hashMap.put("devkey", str);
            hashMap.put("uid", AFb1xSDK.AFInAppEventParameterName(weakReference));
            hashMap.put("time_in_app", String.valueOf(j10));
            hashMap.put("statType", "user_closed_app");
            hashMap.put("platform", "Android");
            hashMap.put("launch_counter", Integer.toString(AFInAppEventParameterName(AFInAppEventType2, false)));
            hashMap.put("channel", valueOf(weakReference.get()));
            if (AFInAppEventParameterName2 == null) {
                AFInAppEventParameterName2 = "";
            }
            hashMap.put("originalAppsflyerId", AFInAppEventParameterName2);
            if (this.onConversionDataSuccess) {
                AFe1eSDK aFe1eSDK = new AFe1eSDK();
                aFe1eSDK.AFVersionDeclaration = isStopped();
                AFd1eSDK aFd1eSDK = new AFd1eSDK((AFe1eSDK) aFe1eSDK.AFInAppEventParameterName(this.onResponseError.values().values.AFInAppEventType("appsFlyerCount", 0)).AFInAppEventType((Map<String, ?>) hashMap).AFInAppEventType(String.format(AFLogger, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), AFInAppEventType().getHostName()})), this.onResponseError);
                AFd1xSDK afDebugLog2 = this.onResponseError.afDebugLog();
                afDebugLog2.AFKeystoreWrapper.execute(new Runnable(aFd1eSDK) {
                    private /* synthetic */ AFd1tSDK AFInAppEventParameterName;

                    /*  JADX ERROR: Method generation error
                        jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFd1xSDK.2.run():void, class status: UNLOADED
                        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                        	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                        	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                        	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                        	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                        */
                    /*  JADX ERROR: Method generation error: Method args not loaded: com.appsflyer.internal.AFd1xSDK.2.run():void, class status: UNLOADED
                        jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFd1xSDK.2.run():void, class status: UNLOADED
                        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                        	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                        	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                        	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                        	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                        */
                    public final void run(
/*
Method generation error in method: com.appsflyer.internal.AFd1xSDK.2.run():void, dex: classes.dex
                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFd1xSDK.2.run():void, class status: UNLOADED
                    	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                    	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                    
*/
                });
                return;
            }
            AFLogger.afDebugLog("Stats call is disabled, ignore ...");
        }
    }

    public final boolean values() {
        int i10 = onPause + 65;
        getSdkVersion = i10 % 128;
        int i11 = i10 % 2;
        if (AFInAppEventParameterName(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false)) {
            if (!(AFKeystoreWrapper() != null)) {
                int i12 = onPause + 5;
                getSdkVersion = i12 % 128;
                int i13 = i12 % 2;
                return true;
            }
        }
        return false;
    }

    private boolean afDebugLog() {
        if (this.onInstallConversionFailureNative > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.onInstallConversionFailureNative;
            Locale locale = Locale.US;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS Z", locale);
            String AFKeystoreWrapper2 = AFKeystoreWrapper(simpleDateFormat, this.onInstallConversionFailureNative);
            String AFKeystoreWrapper3 = AFKeystoreWrapper(simpleDateFormat, this.init);
            char c10 = 23;
            if (!(currentTimeMillis >= this.onInstallConversionDataLoadedNative)) {
                int i10 = getSdkVersion + 23;
                onPause = i10 % 128;
                int i11 = i10 % 2;
                if ((!isStopped() ? 'I' : 20) != 20) {
                    int i12 = getSdkVersion + 61;
                    onPause = i12 % 128;
                    int i13 = i12 % 2;
                    AFLogger.afInfoLog(String.format(locale, "Last Launch attempt: %s;\nLast successful Launch event: %s;\nThis launch is blocked: %s ms < %s ms", new Object[]{AFKeystoreWrapper2, AFKeystoreWrapper3, Long.valueOf(currentTimeMillis), Long.valueOf(this.onInstallConversionDataLoadedNative)}));
                    return true;
                }
            }
            if (!isStopped()) {
                c10 = 'P';
            }
            if (c10 == 'P') {
                AFLogger.afInfoLog(String.format(locale, "Last Launch attempt: %s;\nLast successful Launch event: %s;\nSending launch (+%s ms)", new Object[]{AFKeystoreWrapper2, AFKeystoreWrapper3, Long.valueOf(currentTimeMillis)}));
            }
        } else {
            if (!isStopped()) {
                int i14 = getSdkVersion + 115;
                onPause = i14 % 128;
                if (i14 % 2 == 0) {
                    AFLogger.afInfoLog("Sending first launch for this session!");
                } else {
                    AFLogger.afInfoLog("Sending first launch for this session!");
                    throw null;
                }
            }
        }
        int i15 = getSdkVersion + 51;
        onPause = i15 % 128;
        int i16 = i15 % 2;
        return false;
    }

    private void values(Context context, String str, Map<String, Object> map) {
        Activity activity;
        AFe1iSDK aFe1iSDK = new AFe1iSDK();
        if ((context != null ? 'W' : '`') != '`') {
            aFe1iSDK.AFKeystoreWrapper = (Application) context.getApplicationContext();
            int i10 = onPause + 45;
            getSdkVersion = i10 % 128;
            int i11 = i10 % 2;
        }
        aFe1iSDK.afRDLog = str;
        aFe1iSDK.values = map;
        if ((context instanceof Activity ? 10 : 'R') != 'R') {
            int i12 = onPause;
            int i13 = i12 + 59;
            getSdkVersion = i13 % 128;
            int i14 = i13 % 2;
            activity = (Activity) context;
            int i15 = i12 + 111;
            getSdkVersion = i15 % 128;
            int i16 = i15 % 2;
        } else {
            activity = null;
        }
        values((AFa1sSDK) aFe1iSDK, activity);
    }

    private String AFInAppEventType(Context context, String str) {
        int i10 = getSdkVersion;
        int i11 = i10 + 51;
        onPause = i11 % 128;
        int i12 = i11 % 2;
        if ((context == null ? ' ' : '?') != ' ') {
            AFb1bSDK aFb1bSDK = this.onResponseError;
            if (context != null) {
                int i13 = i10 + 5;
                onPause = i13 % 128;
                if ((i13 % 2 != 0 ? 'B' : '4') != 'B') {
                    AFc1ySDK aFc1ySDK = aFb1bSDK.valueOf;
                    if (context != null) {
                        aFc1ySDK.values = context.getApplicationContext();
                    }
                } else {
                    AFc1ySDK aFc1ySDK2 = aFb1bSDK.valueOf;
                    throw null;
                }
            }
            return AFInAppEventParameterName().values().AFKeystoreWrapper(str);
        }
        int i14 = i10 + 9;
        onPause = i14 % 128;
        int i15 = i14 % 2;
        return null;
    }

    private static String AFLogger() {
        int i10 = onPause + 103;
        getSdkVersion = i10 % 128;
        int i11 = i10 % 2;
        String AFInAppEventParameterName2 = AFInAppEventParameterName(AppsFlyerProperties.APP_ID);
        int i12 = getSdkVersion + 119;
        onPause = i12 % 128;
        int i13 = i12 % 2;
        return AFInAppEventParameterName2;
    }

    private static String AFInAppEventParameterName(String str) {
        int i10 = getSdkVersion + 15;
        onPause = i10 % 128;
        if (i10 % 2 == 0) {
            return AppsFlyerProperties.getInstance().getString(str);
        }
        int i11 = 83 / 0;
        return AppsFlyerProperties.getInstance().getString(str);
    }

    private static boolean AFInAppEventParameterName(String str, boolean z10) {
        int i10 = getSdkVersion + 21;
        onPause = i10 % 128;
        if (i10 % 2 == 0) {
            return AppsFlyerProperties.getInstance().getBoolean(str, z10);
        }
        AppsFlyerProperties.getInstance().getBoolean(str, z10);
        throw null;
    }

    private static void AFKeystoreWrapper(String str, String str2) {
        int i10 = onPause + 13;
        getSdkVersion = i10 % 128;
        int i11 = i10 % 2;
        AppsFlyerProperties.getInstance().set(str, str2);
        int i12 = getSdkVersion + 57;
        onPause = i12 % 128;
        if ((i12 % 2 != 0 ? ' ' : '!') != '!') {
            throw null;
        }
    }

    private void AFInAppEventParameterName(Map<String, Object> map) {
        boolean z10 = false;
        if (!((!AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, false) ? 31 : '8') == '8' || AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, false))) {
            int i10 = getSdkVersion + 115;
            onPause = i10 % 128;
            int i11 = i10 % 2;
            if (map.get("advertiserId") != null) {
                try {
                    if (AFb1nSDK.AFInAppEventParameterName(this.afDebugLog)) {
                        if (map.remove("android_id") != null) {
                            AFLogger.afInfoLog("validateGaidAndIMEI :: removing: android_id");
                        }
                    }
                    if (AFb1nSDK.AFInAppEventParameterName(this.onResponseError.AFVersionDeclaration().valueOf)) {
                        int i12 = getSdkVersion + 99;
                        onPause = i12 % 128;
                        if (i12 % 2 != 0) {
                            int i13 = 55 / 0;
                            if (map.remove("imei") == null) {
                                return;
                            }
                        } else if (map.remove("imei") == null) {
                            return;
                        }
                        int i14 = onPause + 119;
                        getSdkVersion = i14 % 128;
                        if (i14 % 2 == 0) {
                            z10 = true;
                        }
                        if (!z10) {
                            AFLogger.afInfoLog("validateGaidAndIMEI :: removing: imei");
                        } else {
                            AFLogger.afInfoLog("validateGaidAndIMEI :: removing: imei");
                            throw null;
                        }
                    }
                } catch (Exception e10) {
                    AFLogger.afErrorLog("failed to remove IMEI or AndroidID key from params; ", e10);
                }
            }
        }
    }

    private static void AFKeystoreWrapper(String str, boolean z10) {
        int i10 = getSdkVersion + 17;
        onPause = i10 % 128;
        int i11 = i10 % 2;
        AppsFlyerProperties.getInstance().set(str, z10);
        int i12 = onPause + 115;
        getSdkVersion = i12 % 128;
        int i13 = i12 % 2;
    }

    public static String AFKeystoreWrapper() {
        int i10 = getSdkVersion + 123;
        onPause = i10 % 128;
        int i11 = i10 % 2;
        String AFInAppEventParameterName2 = AFInAppEventParameterName(AppsFlyerProperties.APP_USER_ID);
        int i12 = getSdkVersion + 123;
        onPause = i12 % 128;
        int i13 = i12 % 2;
        return AFInAppEventParameterName2;
    }

    private void AFKeystoreWrapper(Context context, AFe1lSDK aFe1lSDK) {
        int i10 = onPause + 9;
        getSdkVersion = i10 % 128;
        int i11 = i10 % 2;
        AFb1bSDK aFb1bSDK = this.onResponseError;
        if (context != null) {
            aFb1bSDK.valueOf.values = context.getApplicationContext();
        }
        AFe1nSDK afRDLog2 = AFInAppEventParameterName().afRDLog();
        AFe1oSDK AFInAppEventParameterName2 = AFa1lSDK.AFInAppEventParameterName(context);
        if (afRDLog2.AFInAppEventParameterName()) {
            int i12 = onPause + 7;
            getSdkVersion = i12 % 128;
            if (i12 % 2 != 0) {
                afRDLog2.values.put("api_name", aFe1lSDK.toString());
                afRDLog2.AFInAppEventParameterName(AFInAppEventParameterName2);
                int i13 = onPause + 73;
                getSdkVersion = i13 % 128;
                int i14 = i13 % 2;
            } else {
                afRDLog2.values.put("api_name", aFe1lSDK.toString());
                afRDLog2.AFInAppEventParameterName(AFInAppEventParameterName2);
                throw null;
            }
        }
        afRDLog2.AFKeystoreWrapper();
    }

    private void values(Context context, String str) {
        AFe1gSDK aFe1gSDK = new AFe1gSDK();
        boolean z10 = true;
        if (!(context == null)) {
            int i10 = onPause + 51;
            getSdkVersion = i10 % 128;
            int i11 = i10 % 2;
            aFe1gSDK.AFKeystoreWrapper = (Application) context.getApplicationContext();
        }
        AFa1sSDK AFInAppEventParameterName2 = aFe1gSDK.AFInAppEventParameterName(this.onResponseError.values().values.AFInAppEventType("appsFlyerCount", 0));
        AFInAppEventParameterName2.afInfoLog = str;
        if (str != null) {
            if (str.length() > 5) {
                z10 = false;
            }
            if (!z10) {
                int i12 = getSdkVersion + 81;
                onPause = i12 % 128;
                int i13 = i12 % 2;
                if (AFKeystoreWrapper(AFInAppEventParameterName2, AFInAppEventType(context))) {
                    AFInAppEventParameterName(this.onResponseError.AFInAppEventType(), (Runnable) new AFa1xSDK(this, AFInAppEventParameterName2, (byte) 0), 5, TimeUnit.MILLISECONDS);
                }
            }
        }
        int i14 = getSdkVersion + 21;
        onPause = i14 % 128;
        int i15 = i14 % 2;
    }

    private static void AFInAppEventType(String str) {
        try {
            if ((new b(str).has("pid") ? 15 : 'I') != 'I') {
                int i10 = getSdkVersion + 81;
                onPause = i10 % 128;
                int i11 = i10 % 2;
                AFKeystoreWrapper("preInstallName", str);
                int i12 = onPause + 99;
                getSdkVersion = i12 % 128;
                int i13 = i12 % 2;
                return;
            }
            AFLogger.afWarnLog("Cannot set preinstall attribution data without a media source");
        } catch (JSONException e10) {
            AFLogger.afErrorLog("Error parsing JSON for preinstall", e10);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0030, code lost:
        if (AFInAppEventType().onAppOpenAttribution == null) goto L_0x0032;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized android.content.SharedPreferences AFInAppEventType(android.content.Context r5) {
        /*
            java.lang.Class<com.appsflyer.internal.AFb1zSDK> r0 = com.appsflyer.internal.AFb1zSDK.class
            monitor-enter(r0)
            int r1 = onPause     // Catch:{ all -> 0x0055 }
            int r1 = r1 + 119
            int r2 = r1 % 128
            getSdkVersion = r2     // Catch:{ all -> 0x0055 }
            int r1 = r1 % 2
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0013
            r1 = r3
            goto L_0x0014
        L_0x0013:
            r1 = r2
        L_0x0014:
            if (r1 == 0) goto L_0x0027
            com.appsflyer.internal.AFb1zSDK r1 = AFInAppEventType()     // Catch:{ all -> 0x0055 }
            android.content.SharedPreferences r1 = r1.onAppOpenAttribution     // Catch:{ all -> 0x0055 }
            r4 = 61
            if (r1 != 0) goto L_0x0022
            r1 = r4
            goto L_0x0024
        L_0x0022:
            r1 = 90
        L_0x0024:
            if (r1 == r4) goto L_0x0032
            goto L_0x004b
        L_0x0027:
            com.appsflyer.internal.AFb1zSDK r1 = AFInAppEventType()     // Catch:{ all -> 0x0055 }
            android.content.SharedPreferences r1 = r1.onAppOpenAttribution     // Catch:{ all -> 0x0055 }
            r4 = 94
            int r4 = r4 / r3
            if (r1 != 0) goto L_0x004b
        L_0x0032:
            com.appsflyer.internal.AFb1zSDK r1 = AFInAppEventType()     // Catch:{ all -> 0x0055 }
            android.content.Context r5 = r5.getApplicationContext()     // Catch:{ all -> 0x0055 }
            java.lang.String r4 = "appsflyer-data"
            android.content.SharedPreferences r5 = r5.getSharedPreferences(r4, r3)     // Catch:{ all -> 0x0055 }
            r1.onAppOpenAttribution = r5     // Catch:{ all -> 0x0055 }
            int r5 = onPause     // Catch:{ all -> 0x0055 }
            int r5 = r5 + r2
            int r1 = r5 % 128
            getSdkVersion = r1     // Catch:{ all -> 0x0055 }
            int r5 = r5 % 2
        L_0x004b:
            com.appsflyer.internal.AFb1zSDK r5 = AFInAppEventType()     // Catch:{ all -> 0x0055 }
            android.content.SharedPreferences r5 = r5.onAppOpenAttribution     // Catch:{ all -> 0x0055 }
            monitor-exit(r0)
            return r5
        L_0x0053:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x0055 }
        L_0x0055:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1zSDK.AFInAppEventType(android.content.Context):android.content.SharedPreferences");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0021, code lost:
        if (r2 != true) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        if ((r3 != null ? 'F' : 'C') != 'C') goto L_0x0024;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.io.File afDebugLog(java.lang.String r3) {
        /*
            int r0 = getSdkVersion
            int r0 = r0 + 75
            int r1 = r0 % 128
            onPause = r1
            int r0 = r0 % 2
            r2 = 0
            if (r0 == 0) goto L_0x001d
            r0 = 36
            int r0 = r0 / r2
            r0 = 67
            if (r3 == 0) goto L_0x0017
            r2 = 70
            goto L_0x0018
        L_0x0017:
            r2 = r0
        L_0x0018:
            if (r2 == r0) goto L_0x0040
            goto L_0x0024
        L_0x001b:
            r3 = move-exception
            goto L_0x004b
        L_0x001d:
            r0 = 1
            if (r3 == 0) goto L_0x0021
            r2 = r0
        L_0x0021:
            if (r2 == r0) goto L_0x0024
            goto L_0x0040
        L_0x0024:
            int r1 = r1 + 77
            int r0 = r1 % 128
            getSdkVersion = r0
            int r1 = r1 % 2
            java.lang.String r0 = r3.trim()     // Catch:{ all -> 0x001b }
            int r0 = r0.length()     // Catch:{ all -> 0x001b }
            if (r0 <= 0) goto L_0x0040
            java.io.File r0 = new java.io.File     // Catch:{ all -> 0x001b }
            java.lang.String r3 = r3.trim()     // Catch:{ all -> 0x001b }
            r0.<init>(r3)     // Catch:{ all -> 0x001b }
            return r0
        L_0x0040:
            int r3 = onPause
            int r3 = r3 + 59
            int r0 = r3 % 128
            getSdkVersion = r0
            int r3 = r3 % 2
            goto L_0x0052
        L_0x004b:
            java.lang.String r0 = r3.getMessage()
            com.appsflyer.AFLogger.afErrorLog(r0, r3)
        L_0x0052:
            r3 = 0
            int r0 = getSdkVersion
            int r0 = r0 + 97
            int r1 = r0 % 128
            onPause = r1
            int r0 = r0 % 2
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1zSDK.afDebugLog(java.lang.String):java.io.File");
    }

    private static int AFInAppEventType(SharedPreferences sharedPreferences, boolean z10) {
        int i10 = getSdkVersion + 29;
        onPause = i10 % 128;
        int i11 = i10 % 2;
        int AFInAppEventParameterName2 = AFInAppEventParameterName(sharedPreferences, "appsFlyerInAppEventCount", z10);
        int i12 = onPause + 65;
        getSdkVersion = i12 % 128;
        int i13 = i12 % 2;
        return AFInAppEventParameterName2;
    }

    public static String AFKeystoreWrapper(SimpleDateFormat simpleDateFormat, long j10) {
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        String format2 = simpleDateFormat.format(new Date(j10));
        int i10 = onPause + 67;
        getSdkVersion = i10 % 128;
        int i11 = i10 % 2;
        return format2;
    }

    private static void values(Map<String, Object> map) {
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.ONELINK_ID);
        String string2 = AppsFlyerProperties.getInstance().getString("onelinkVersion");
        boolean z10 = true;
        if (string != null) {
            int i10 = onPause + 113;
            getSdkVersion = i10 % 128;
            if (i10 % 2 == 0) {
                map.put("onelink_id", string);
                int i11 = 13 / 0;
            } else {
                map.put("onelink_id", string);
            }
            int i12 = onPause + 81;
            getSdkVersion = i12 % 128;
            int i13 = i12 % 2;
        }
        if (string2 != null) {
            z10 = false;
        }
        if (!z10) {
            map.put("onelink_ver", string2);
            int i14 = onPause + 7;
            getSdkVersion = i14 % 128;
            int i15 = i14 % 2;
        }
    }

    /* JADX WARNING: type inference failed for: r28v8, types: [java.math.BigDecimal, java.lang.Number] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x033e, code lost:
        if (r14.equals(r8) != false) goto L_0x0340;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0342, code lost:
        if (r8 != null) goto L_0x0344;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0344, code lost:
        r2.put("af_latestchannel", r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x0440, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:?, code lost:
        com.appsflyer.AFLogger.afErrorLog(r18, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:376:0x07bc, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:390:0x0916, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:391:0x0917, code lost:
        r2 = r34;
        r3 = r0;
        r1 = r28;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:392:0x091e, code lost:
        r0 = e;
        r28 = r28;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:394:0x0923, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:395:0x0924, code lost:
        r3 = r0;
        r1 = r2;
        r2 = r34;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x039f  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x03ac  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x03b2  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x03c5 A[Catch:{ NameNotFoundException -> 0x043b, all -> 0x0440, all -> 0x00d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x03d7 A[SYNTHETIC, Splitter:B:198:0x03d7] */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x03e9 A[SYNTHETIC, Splitter:B:205:0x03e9] */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x0412  */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x042c A[SYNTHETIC, Splitter:B:220:0x042c] */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x0440 A[ExcHandler: all (r0v32 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:220:0x042c] */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x0458 A[Catch:{ NameNotFoundException -> 0x043b, all -> 0x0440, all -> 0x00d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x046b A[Catch:{ Exception -> 0x0471 }] */
    /* JADX WARNING: Removed duplicated region for block: B:278:0x0515 A[Catch:{ all -> 0x05a5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:307:0x05d2  */
    /* JADX WARNING: Removed duplicated region for block: B:311:0x05db A[Catch:{ NameNotFoundException -> 0x043b, all -> 0x0440, all -> 0x00d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:319:0x0610 A[SYNTHETIC, Splitter:B:319:0x0610] */
    /* JADX WARNING: Removed duplicated region for block: B:390:0x0916 A[ExcHandler: all (r0v16 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r28 
      PHI: (r28v11 java.util.Map<java.lang.String, java.lang.Object>) = (r28v14 java.util.Map<java.lang.String, java.lang.Object>), (r28v16 java.util.Map<java.lang.String, java.lang.Object>), (r28v21 java.util.Map<java.lang.String, java.lang.Object>) binds: [B:362:0x06d6, B:365:0x06dc, B:370:0x0749] A[DONT_GENERATE, DONT_INLINE], Splitter:B:365:0x06dc] */
    /* JADX WARNING: Removed duplicated region for block: B:394:0x0923 A[ExcHandler: all (r0v12 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r2 
      PHI: (r2v25 java.util.Map<java.lang.String, java.lang.Object>) = (r2v1 java.util.Map<java.lang.String, java.lang.Object>), (r2v27 java.util.Map<java.lang.String, java.lang.Object>), (r2v27 java.util.Map<java.lang.String, java.lang.Object>), (r2v27 java.util.Map<java.lang.String, java.lang.Object>), (r2v27 java.util.Map<java.lang.String, java.lang.Object>), (r2v27 java.util.Map<java.lang.String, java.lang.Object>), (r2v27 java.util.Map<java.lang.String, java.lang.Object>), (r2v27 java.util.Map<java.lang.String, java.lang.Object>) binds: [B:322:0x0623, B:355:0x06bb, B:356:?, B:359:0x06c1, B:360:?, B:362:0x06d6, B:348:0x068a, B:340:0x066c] A[DONT_GENERATE, DONT_INLINE], Splitter:B:322:0x0623] */
    /* JADX WARNING: Removed duplicated region for block: B:418:0x0975 A[Catch:{ all -> 0x0af4, all -> 0x0b09 }] */
    /* JADX WARNING: Removed duplicated region for block: B:421:0x0982 A[Catch:{ all -> 0x0af4, all -> 0x0b09 }] */
    /* JADX WARNING: Removed duplicated region for block: B:426:0x099c A[Catch:{ all -> 0x0af4, all -> 0x0b09 }] */
    /* JADX WARNING: Removed duplicated region for block: B:429:0x09a8 A[Catch:{ all -> 0x0af4, all -> 0x0b09 }] */
    /* JADX WARNING: Removed duplicated region for block: B:432:0x09dc A[Catch:{ all -> 0x0af4, all -> 0x0b09 }] */
    /* JADX WARNING: Removed duplicated region for block: B:433:0x09de A[Catch:{ all -> 0x0af4, all -> 0x0b09 }] */
    /* JADX WARNING: Removed duplicated region for block: B:441:0x09fb A[Catch:{ all -> 0x0af4, all -> 0x0b09 }] */
    /* JADX WARNING: Removed duplicated region for block: B:442:0x09fd A[Catch:{ all -> 0x0af4, all -> 0x0b09 }] */
    /* JADX WARNING: Removed duplicated region for block: B:445:0x0a39 A[Catch:{ all -> 0x0af4, all -> 0x0b09 }] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.String, java.lang.Object> AFInAppEventType(com.appsflyer.internal.AFa1sSDK r35) {
        /*
            r34 = this;
            r1 = r34
            r2 = r35
            java.lang.String r3 = "versionCode"
            java.lang.String r4 = "Exception while collecting facebook's attribution ID. "
            java.lang.String r5 = "appid"
            java.lang.String r6 = "sdkExtension"
            java.lang.String r7 = "extraReferrers"
            java.lang.String r8 = "AFRequestCache"
            java.lang.String r9 = "yyyy-MM-dd_HHmmssZ"
            java.lang.String r10 = ""
            android.app.Application r11 = r2.AFKeystoreWrapper
            com.appsflyer.internal.AFb1bSDK r12 = r1.onResponseError
            com.appsflyer.internal.AFe1xSDK r12 = r12.AFVersionDeclaration()
            java.lang.String r12 = r12.AFInAppEventType
            java.lang.String r13 = r2.afRDLog
            org.json.b r14 = new org.json.b
            java.util.Map<java.lang.String, java.lang.Object> r15 = r2.values
            if (r15 != 0) goto L_0x002b
            java.util.HashMap r15 = new java.util.HashMap
            r15.<init>()
        L_0x002b:
            r14.<init>((java.util.Map<?, ?>) r15)
            java.lang.String r14 = r14.toString()
            java.lang.String r15 = r2.afInfoLog
            r16 = r3
            android.content.SharedPreferences r3 = AFInAppEventType((android.content.Context) r11)
            r17 = r9
            boolean r9 = r35.AFKeystoreWrapper()
            r18 = r4
            java.lang.String r4 = r2.AFInAppEventParameterName
            java.util.Map<java.lang.String, java.lang.Object> r2 = r2.valueOf
            com.appsflyer.internal.AFa1bSDK.AFKeystoreWrapper(r11, r2)
            java.lang.Boolean r19 = com.appsflyer.internal.AFa1bSDK.AFInAppEventParameterName
            if (r19 == 0) goto L_0x0065
            boolean r19 = r19.booleanValue()
            if (r19 != 0) goto L_0x0065
            r19 = r4
            java.util.Map r4 = AFKeystoreWrapper((java.util.Map<java.lang.String, java.lang.Object>) r2)
            r20 = r5
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            r21 = r14
            java.lang.String r14 = "ad_ids_disabled"
            r4.put(r14, r5)
            goto L_0x006b
        L_0x0065:
            r19 = r4
            r20 = r5
            r21 = r14
        L_0x006b:
            java.util.Date r4 = new java.util.Date
            r4.<init>()
            long r4 = r4.getTime()
            int r14 = android.view.ViewConfiguration.getMaximumFlingVelocity()
            int r14 = r14 >> 16
            char r14 = (char) r14
            r22 = r12
            r12 = 0
            int r23 = android.view.View.MeasureSpec.getMode(r12)
            int r12 = r23 + 12
            long r23 = android.view.ViewConfiguration.getZoomControlsTimeout()
            r25 = r6
            r26 = r7
            r6 = 0
            int r23 = (r23 > r6 ? 1 : (r23 == r6 ? 0 : -1))
            int r6 = r23 + -1
            r7 = 1
            r23 = r13
            java.lang.Object[] r13 = new java.lang.Object[r7]
            AFInAppEventParameterName((char) r14, (int) r12, (int) r6, (java.lang.Object[]) r13)
            r6 = 0
            r12 = r13[r6]
            java.lang.String r12 = (java.lang.String) r12
            java.lang.String r6 = r12.intern()
            java.lang.String r12 = java.lang.Long.toString(r4)
            r2.put(r6, r12)
            java.lang.String r4 = com.appsflyer.internal.AFa1xSDK.values(r11, r4)
            if (r4 == 0) goto L_0x00b5
            java.lang.String r5 = "cksm_v1"
            r2.put(r5, r4)
        L_0x00b5:
            boolean r4 = r34.isStopped()     // Catch:{ all -> 0x0b0b }
            if (r4 != 0) goto L_0x00dd
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d4 }
            java.lang.String r5 = "******* sendTrackingWithEvent: "
            r4.<init>(r5)     // Catch:{ all -> 0x00d4 }
            if (r9 == 0) goto L_0x00c7
            java.lang.String r5 = "Launch"
            goto L_0x00c9
        L_0x00c7:
            r5 = r23
        L_0x00c9:
            r4.append(r5)     // Catch:{ all -> 0x00d4 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00d4 }
            com.appsflyer.AFLogger.afInfoLog(r4)     // Catch:{ all -> 0x00d4 }
            goto L_0x00e2
        L_0x00d4:
            r0 = move-exception
            r3 = r0
            r33 = r2
            r2 = r1
            r1 = r33
            goto L_0x0b12
        L_0x00dd:
            java.lang.String r4 = "Reporting has been stopped"
            com.appsflyer.AFLogger.afInfoLog(r4)     // Catch:{ all -> 0x0b0b }
        L_0x00e2:
            com.appsflyer.internal.AFc1xSDK r4 = r34.AFInAppEventParameterName()     // Catch:{ all -> 0x0b0b }
            com.appsflyer.internal.AFa1lSDK r4 = r4.afWarnLog()     // Catch:{ all -> 0x0b0b }
            java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x010e }
            com.appsflyer.internal.AFc1ySDK r6 = r4.AFInAppEventType     // Catch:{ Exception -> 0x010e }
            android.content.Context r6 = r6.values     // Catch:{ Exception -> 0x010e }
            java.io.File r6 = r6.getFilesDir()     // Catch:{ Exception -> 0x010e }
            r5.<init>(r6, r8)     // Catch:{ Exception -> 0x010e }
            boolean r5 = r5.exists()     // Catch:{ Exception -> 0x010e }
            if (r5 != 0) goto L_0x0115
            java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x010e }
            com.appsflyer.internal.AFc1ySDK r4 = r4.AFInAppEventType     // Catch:{ Exception -> 0x010e }
            android.content.Context r4 = r4.values     // Catch:{ Exception -> 0x010e }
            java.io.File r4 = r4.getFilesDir()     // Catch:{ Exception -> 0x010e }
            r5.<init>(r4, r8)     // Catch:{ Exception -> 0x010e }
            r5.mkdir()     // Catch:{ Exception -> 0x010e }
            goto L_0x0115
        L_0x010e:
            r0 = move-exception
            r4 = r0
            java.lang.String r5 = "CACHE: Could not create cache directory"
            com.appsflyer.AFLogger.afErrorLog(r5, r4)     // Catch:{ all -> 0x0b0b }
        L_0x0115:
            android.content.pm.PackageManager r4 = r11.getPackageManager()     // Catch:{ Exception -> 0x0157 }
            java.lang.String r5 = r11.getPackageName()     // Catch:{ Exception -> 0x0157 }
            r6 = 4096(0x1000, float:5.74E-42)
            android.content.pm.PackageInfo r4 = r4.getPackageInfo(r5, r6)     // Catch:{ Exception -> 0x0157 }
            java.lang.String[] r4 = r4.requestedPermissions     // Catch:{ Exception -> 0x0157 }
            java.util.List r4 = java.util.Arrays.asList(r4)     // Catch:{ Exception -> 0x0157 }
            java.lang.String r5 = "android.permission.INTERNET"
            boolean r5 = r4.contains(r5)     // Catch:{ Exception -> 0x0157 }
            if (r5 != 0) goto L_0x0136
            java.lang.String r5 = "Permission android.permission.INTERNET is missing in the AndroidManifest.xml"
            com.appsflyer.AFLogger.afWarnLog(r5)     // Catch:{ Exception -> 0x0157 }
        L_0x0136:
            java.lang.String r5 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r5 = r4.contains(r5)     // Catch:{ Exception -> 0x0157 }
            if (r5 != 0) goto L_0x0143
            java.lang.String r5 = "Permission android.permission.ACCESS_NETWORK_STATE is missing in the AndroidManifest.xml"
            com.appsflyer.AFLogger.afWarnLog(r5)     // Catch:{ Exception -> 0x0157 }
        L_0x0143:
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0157 }
            r6 = 32
            if (r5 <= r6) goto L_0x015e
            java.lang.String r5 = "com.google.android.gms.permission.AD_ID"
            boolean r4 = r4.contains(r5)     // Catch:{ Exception -> 0x0157 }
            if (r4 != 0) goto L_0x015e
            java.lang.String r4 = "Permission com.google.android.gms.permission.AD_ID is missing in the AndroidManifest.xml"
            com.appsflyer.AFLogger.afWarnLog(r4)     // Catch:{ Exception -> 0x0157 }
            goto L_0x015e
        L_0x0157:
            r0 = move-exception
            r4 = r0
            java.lang.String r5 = "Exception while validation permissions. "
            com.appsflyer.AFLogger.afErrorLog(r5, r4)     // Catch:{ all -> 0x0b0b }
        L_0x015e:
            java.lang.String r4 = "af_events_api"
            int r5 = android.view.ViewConfiguration.getWindowTouchSlop()     // Catch:{ all -> 0x0b0b }
            int r5 = r5 >> 8
            char r5 = (char) r5     // Catch:{ all -> 0x0b0b }
            long r12 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0b0b }
            r27 = 0
            int r6 = (r12 > r27 ? 1 : (r12 == r27 ? 0 : -1))
            r8 = 48
            r12 = 0
            int r8 = android.text.TextUtils.indexOf(r10, r8, r12)     // Catch:{ all -> 0x0b0b }
            int r8 = 11 - r8
            java.lang.Object[] r13 = new java.lang.Object[r7]     // Catch:{ all -> 0x0b0b }
            AFInAppEventParameterName((char) r5, (int) r6, (int) r8, (java.lang.Object[]) r13)     // Catch:{ all -> 0x0b0b }
            r5 = r13[r12]     // Catch:{ all -> 0x0b0b }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0b0b }
            java.lang.String r5 = r5.intern()     // Catch:{ all -> 0x0b0b }
            r2.put(r4, r5)     // Catch:{ all -> 0x0b0b }
            int r4 = android.os.Process.getGidForName(r10)     // Catch:{ all -> 0x0b0b }
            int r4 = r4 + r7
            char r4 = (char) r4     // Catch:{ all -> 0x0b0b }
            r5 = 0
            int r6 = android.view.View.getDefaultSize(r5, r5)     // Catch:{ all -> 0x0b0b }
            r8 = 5
            int r6 = r6 + r8
            int r12 = android.graphics.Color.alpha(r5)     // Catch:{ all -> 0x0b0b }
            int r12 = 13 - r12
            java.lang.Object[] r13 = new java.lang.Object[r7]     // Catch:{ all -> 0x0b0b }
            AFInAppEventParameterName((char) r4, (int) r6, (int) r12, (java.lang.Object[]) r13)     // Catch:{ all -> 0x0b0b }
            r4 = r13[r5]     // Catch:{ all -> 0x0b0b }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0b0b }
            java.lang.String r4 = r4.intern()     // Catch:{ all -> 0x0b0b }
            java.lang.String r5 = android.os.Build.BRAND     // Catch:{ all -> 0x0b0b }
            r2.put(r4, r5)     // Catch:{ all -> 0x0b0b }
            java.lang.String r4 = "device"
            java.lang.String r5 = android.os.Build.DEVICE     // Catch:{ all -> 0x0b0b }
            r2.put(r4, r5)     // Catch:{ all -> 0x0b0b }
            java.lang.String r4 = "product"
            java.lang.String r5 = android.os.Build.PRODUCT     // Catch:{ all -> 0x0b0b }
            r2.put(r4, r5)     // Catch:{ all -> 0x0b0b }
            java.lang.String r4 = "sdk"
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0b0b }
            java.lang.String r5 = java.lang.Integer.toString(r5)     // Catch:{ all -> 0x0b0b }
            r2.put(r4, r5)     // Catch:{ all -> 0x0b0b }
            java.lang.String r4 = "model"
            java.lang.String r5 = android.os.Build.MODEL     // Catch:{ all -> 0x0b0b }
            r2.put(r4, r5)     // Catch:{ all -> 0x0b0b }
            java.lang.String r4 = "deviceType"
            java.lang.String r5 = android.os.Build.TYPE     // Catch:{ all -> 0x0b0b }
            r2.put(r4, r5)     // Catch:{ all -> 0x0b0b }
            valueOf((android.content.Context) r11, (java.util.Map<java.lang.String, java.lang.Object>) r2)     // Catch:{ all -> 0x0b0b }
            com.appsflyer.AppsFlyerProperties r4 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0b0b }
            com.appsflyer.internal.AFb1hSDK r5 = new com.appsflyer.internal.AFb1hSDK     // Catch:{ all -> 0x0b0b }
            r5.<init>(r11)     // Catch:{ all -> 0x0b0b }
            com.appsflyer.internal.AFc1xSDK r6 = r34.AFInAppEventParameterName()     // Catch:{ all -> 0x0b0b }
            com.appsflyer.internal.AFe1nSDK r6 = r6.afRDLog()     // Catch:{ all -> 0x0b0b }
            r12 = 4
            r13 = 0
            if (r9 == 0) goto L_0x02ca
            boolean r14 = afRDLog(r11)     // Catch:{ all -> 0x00d4 }
            if (r14 == 0) goto L_0x022c
            boolean r14 = r4.isOtherSdkStringDisabled()     // Catch:{ all -> 0x00d4 }
            if (r14 != 0) goto L_0x0205
            float r14 = onInstallConversionFailureNative(r11)     // Catch:{ all -> 0x00d4 }
            java.lang.String r8 = "batteryLevel"
            java.lang.String r14 = java.lang.String.valueOf(r14)     // Catch:{ all -> 0x00d4 }
            r2.put(r8, r14)     // Catch:{ all -> 0x00d4 }
        L_0x0205:
            afDebugLog((android.content.Context) r11)     // Catch:{ all -> 0x00d4 }
            java.lang.Class<android.app.UiModeManager> r8 = android.app.UiModeManager.class
            java.lang.Object r8 = r11.getSystemService(r8)     // Catch:{ all -> 0x00d4 }
            android.app.UiModeManager r8 = (android.app.UiModeManager) r8     // Catch:{ all -> 0x00d4 }
            if (r8 == 0) goto L_0x021f
            int r8 = r8.getCurrentModeType()     // Catch:{ all -> 0x00d4 }
            if (r8 != r12) goto L_0x021f
            java.lang.String r8 = "tv"
            java.lang.Boolean r14 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00d4 }
            r2.put(r8, r14)     // Catch:{ all -> 0x00d4 }
        L_0x021f:
            boolean r8 = com.appsflyer.internal.AFe1mSDK.valueOf(r11)     // Catch:{ all -> 0x00d4 }
            if (r8 == 0) goto L_0x022c
            java.lang.String r8 = "inst_app"
            java.lang.Boolean r14 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00d4 }
            r2.put(r8, r14)     // Catch:{ all -> 0x00d4 }
        L_0x022c:
            java.lang.String r8 = "timepassedsincelastlaunch"
            long r29 = r1.getLevel(r11)     // Catch:{ all -> 0x00d4 }
            java.lang.String r14 = java.lang.Long.toString(r29)     // Catch:{ all -> 0x00d4 }
            r2.put(r8, r14)     // Catch:{ all -> 0x00d4 }
            values((java.util.Map<java.lang.String, java.lang.Object>) r2)     // Catch:{ all -> 0x00d4 }
            values((java.util.Map<java.lang.String, java.lang.Object>) r2, (com.appsflyer.internal.AFe1nSDK) r6)     // Catch:{ all -> 0x00d4 }
            java.lang.String r8 = r1.onResponse     // Catch:{ all -> 0x00d4 }
            if (r8 == 0) goto L_0x0248
            java.lang.String r14 = "phone"
            r2.put(r14, r8)     // Catch:{ all -> 0x00d4 }
        L_0x0248:
            boolean r8 = android.text.TextUtils.isEmpty(r15)     // Catch:{ all -> 0x00d4 }
            java.lang.String r14 = "referrer"
            if (r8 != 0) goto L_0x0253
            r2.put(r14, r15)     // Catch:{ all -> 0x00d4 }
        L_0x0253:
            r8 = r26
            java.lang.String r15 = r3.getString(r8, r13)     // Catch:{ all -> 0x00d4 }
            if (r15 == 0) goto L_0x025e
            r2.put(r8, r15)     // Catch:{ all -> 0x00d4 }
        L_0x025e:
            java.lang.String r8 = r4.getReferrer(r11)     // Catch:{ all -> 0x00d4 }
            boolean r15 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x00d4 }
            if (r15 != 0) goto L_0x0271
            java.lang.Object r15 = r2.get(r14)     // Catch:{ all -> 0x00d4 }
            if (r15 != 0) goto L_0x0271
            r2.put(r14, r8)     // Catch:{ all -> 0x00d4 }
        L_0x0271:
            long r14 = r6.AFLogger$LogLevel     // Catch:{ all -> 0x00d4 }
            r26 = 0
            int r6 = (r14 > r26 ? 1 : (r14 == r26 ? 0 : -1))
            if (r6 == 0) goto L_0x0282
            java.lang.String r6 = "prev_session_dur"
            java.lang.Long r8 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x00d4 }
            r2.put(r6, r8)     // Catch:{ all -> 0x00d4 }
        L_0x0282:
            android.app.Application r6 = com.appsflyer.internal.AFb1iSDK.AFKeystoreWrapper     // Catch:{ all -> 0x00d4 }
            java.lang.String r8 = "exception_number"
            if (r6 != 0) goto L_0x028b
            r14 = -1
            goto L_0x0295
        L_0x028b:
            android.content.SharedPreferences r6 = AFInAppEventType((android.content.Context) r6)     // Catch:{ all -> 0x00d4 }
            r14 = 0
            long r14 = r6.getLong(r8, r14)     // Catch:{ all -> 0x00d4 }
        L_0x0295:
            java.lang.Long r6 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x00d4 }
            r2.put(r8, r6)     // Catch:{ all -> 0x00d4 }
            com.appsflyer.internal.AFb1cSDK r6 = r1.AppsFlyerInAppPurchaseValidatorListener     // Catch:{ all -> 0x00d4 }
            if (r6 == 0) goto L_0x02c7
            java.util.Map<java.lang.String, java.lang.Object> r8 = r6.values     // Catch:{ all -> 0x00d4 }
            boolean r8 = r8.isEmpty()     // Catch:{ all -> 0x00d4 }
            java.lang.String r14 = "partner_data"
            if (r8 != 0) goto L_0x02af
            java.util.Map<java.lang.String, java.lang.Object> r8 = r6.values     // Catch:{ all -> 0x00d4 }
            r2.put(r14, r8)     // Catch:{ all -> 0x00d4 }
        L_0x02af:
            java.util.Map<java.lang.String, java.lang.Object> r8 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x00d4 }
            boolean r8 = r8.isEmpty()     // Catch:{ all -> 0x00d4 }
            if (r8 != 0) goto L_0x02c7
            java.util.Map r8 = AFKeystoreWrapper((java.util.Map<java.lang.String, java.lang.Object>) r2)     // Catch:{ all -> 0x00d4 }
            java.util.Map<java.lang.String, java.lang.Object> r15 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x00d4 }
            r8.put(r14, r15)     // Catch:{ all -> 0x00d4 }
            java.util.HashMap r8 = new java.util.HashMap     // Catch:{ all -> 0x00d4 }
            r8.<init>()     // Catch:{ all -> 0x00d4 }
            r6.AFInAppEventParameterName = r8     // Catch:{ all -> 0x00d4 }
        L_0x02c7:
            r6 = r23
            goto L_0x02cf
        L_0x02ca:
            r6 = r23
            AFInAppEventType((android.content.Context) r11, (java.util.Map<java.lang.String, java.lang.Object>) r2, (java.lang.String) r6)     // Catch:{ all -> 0x0b0b }
        L_0x02cf:
            java.lang.String r8 = "KSAppsFlyerId"
            java.lang.String r8 = AFInAppEventParameterName((java.lang.String) r8)     // Catch:{ all -> 0x0b0b }
            java.lang.String r14 = "KSAppsFlyerRICounter"
            java.lang.String r14 = AFInAppEventParameterName((java.lang.String) r14)     // Catch:{ all -> 0x0b0b }
            if (r8 == 0) goto L_0x02f3
            if (r14 == 0) goto L_0x02f3
            java.lang.Integer r15 = java.lang.Integer.valueOf(r14)     // Catch:{ all -> 0x00d4 }
            int r15 = r15.intValue()     // Catch:{ all -> 0x00d4 }
            if (r15 <= 0) goto L_0x02f3
            java.lang.String r15 = "reinstallCounter"
            r2.put(r15, r14)     // Catch:{ all -> 0x00d4 }
            java.lang.String r14 = "originalAppsflyerId"
            r2.put(r14, r8)     // Catch:{ all -> 0x00d4 }
        L_0x02f3:
            java.lang.String r8 = "additionalCustomData"
            java.lang.String r8 = AFInAppEventParameterName((java.lang.String) r8)     // Catch:{ all -> 0x0b0b }
            if (r8 == 0) goto L_0x0300
            java.lang.String r14 = "customData"
            r2.put(r14, r8)     // Catch:{ all -> 0x00d4 }
        L_0x0300:
            android.content.pm.PackageManager r8 = r11.getPackageManager()     // Catch:{ Exception -> 0x0314 }
            java.lang.String r14 = r11.getPackageName()     // Catch:{ Exception -> 0x0314 }
            java.lang.String r8 = r8.getInstallerPackageName(r14)     // Catch:{ Exception -> 0x0314 }
            if (r8 == 0) goto L_0x031b
            java.lang.String r14 = "installer_package"
            r2.put(r14, r8)     // Catch:{ Exception -> 0x0314 }
            goto L_0x031b
        L_0x0314:
            r0 = move-exception
            r8 = r0
            java.lang.String r14 = "Exception while getting the app's installer package. "
            com.appsflyer.AFLogger.afErrorLog(r14, r8)     // Catch:{ all -> 0x0b0b }
        L_0x031b:
            r8 = r25
            java.lang.String r14 = r4.getString(r8)     // Catch:{ all -> 0x0b0b }
            if (r14 == 0) goto L_0x032c
            int r15 = r14.length()     // Catch:{ all -> 0x00d4 }
            if (r15 <= 0) goto L_0x032c
            r2.put(r8, r14)     // Catch:{ all -> 0x00d4 }
        L_0x032c:
            java.lang.String r8 = r1.valueOf((android.content.Context) r11)     // Catch:{ all -> 0x0b0b }
            com.appsflyer.internal.AFb1gSDK r14 = r1.AFInAppEventParameterName((android.content.Context) r11)     // Catch:{ all -> 0x0b0b }
            java.lang.String r14 = AFKeystoreWrapper((com.appsflyer.internal.AFb1gSDK) r14, (java.lang.String) r8)     // Catch:{ all -> 0x0b0b }
            if (r14 == 0) goto L_0x0340
            boolean r15 = r14.equals(r8)     // Catch:{ all -> 0x00d4 }
            if (r15 == 0) goto L_0x0344
        L_0x0340:
            if (r14 != 0) goto L_0x0349
            if (r8 == 0) goto L_0x0349
        L_0x0344:
            java.lang.String r14 = "af_latestchannel"
            r2.put(r14, r8)     // Catch:{ all -> 0x00d4 }
        L_0x0349:
            java.lang.String r8 = r1.AFLogger$LogLevel(r11)     // Catch:{ all -> 0x0b0b }
            if (r8 == 0) goto L_0x0358
            java.lang.String r14 = "af_installstore"
            java.lang.String r8 = r8.toLowerCase()     // Catch:{ all -> 0x00d4 }
            r2.put(r14, r8)     // Catch:{ all -> 0x00d4 }
        L_0x0358:
            java.lang.String r8 = r1.afWarnLog(r11)     // Catch:{ all -> 0x0b0b }
            if (r8 == 0) goto L_0x0367
            java.lang.String r14 = "af_preinstall_name"
            java.lang.String r8 = r8.toLowerCase()     // Catch:{ all -> 0x00d4 }
            r2.put(r14, r8)     // Catch:{ all -> 0x00d4 }
        L_0x0367:
            java.lang.String r8 = r1.AFVersionDeclaration(r11)     // Catch:{ all -> 0x0b0b }
            if (r8 == 0) goto L_0x0376
            java.lang.String r14 = "af_currentstore"
            java.lang.String r8 = r8.toLowerCase()     // Catch:{ all -> 0x00d4 }
            r2.put(r14, r8)     // Catch:{ all -> 0x00d4 }
        L_0x0376:
            java.lang.String r8 = "appsflyerKey"
            if (r22 == 0) goto L_0x0386
            int r14 = r22.length()     // Catch:{ all -> 0x00d4 }
            if (r14 <= 0) goto L_0x0386
            r14 = r22
            r2.put(r8, r14)     // Catch:{ all -> 0x00d4 }
            goto L_0x0399
        L_0x0386:
            com.appsflyer.internal.AFb1bSDK r14 = r1.onResponseError     // Catch:{ all -> 0x0b0b }
            com.appsflyer.internal.AFe1xSDK r14 = r14.AFVersionDeclaration()     // Catch:{ all -> 0x0b0b }
            java.lang.String r14 = r14.AFInAppEventType     // Catch:{ all -> 0x0b0b }
            if (r14 == 0) goto L_0x0af8
            int r15 = r14.length()     // Catch:{ all -> 0x0b0b }
            if (r15 <= 0) goto L_0x0af8
            r2.put(r8, r14)     // Catch:{ all -> 0x0b0b }
        L_0x0399:
            java.lang.String r8 = AFKeystoreWrapper()     // Catch:{ all -> 0x0b0b }
            if (r8 == 0) goto L_0x03a4
            java.lang.String r14 = "appUserId"
            r2.put(r14, r8)     // Catch:{ all -> 0x00d4 }
        L_0x03a4:
            java.lang.String r8 = "userEmails"
            java.lang.String r8 = r4.getString(r8)     // Catch:{ all -> 0x0b0b }
            if (r8 == 0) goto L_0x03b2
            java.lang.String r14 = "user_emails"
            r2.put(r14, r8)     // Catch:{ all -> 0x00d4 }
            goto L_0x03c3
        L_0x03b2:
            java.lang.String r8 = "userEmail"
            java.lang.String r8 = AFInAppEventParameterName((java.lang.String) r8)     // Catch:{ all -> 0x0b0b }
            if (r8 == 0) goto L_0x03c3
            java.lang.String r14 = "sha1_el"
            java.lang.String r8 = com.appsflyer.internal.AFa1aSDK.valueOf((java.lang.String) r8)     // Catch:{ all -> 0x00d4 }
            r2.put(r14, r8)     // Catch:{ all -> 0x00d4 }
        L_0x03c3:
            if (r6 == 0) goto L_0x03d1
            java.lang.String r8 = "eventName"
            r2.put(r8, r6)     // Catch:{ all -> 0x00d4 }
            java.lang.String r8 = "eventValue"
            r14 = r21
            r2.put(r8, r14)     // Catch:{ all -> 0x00d4 }
        L_0x03d1:
            java.lang.String r8 = AFLogger()     // Catch:{ all -> 0x0b0b }
            if (r8 == 0) goto L_0x03e0
            java.lang.String r8 = AFInAppEventParameterName((java.lang.String) r20)     // Catch:{ all -> 0x00d4 }
            r14 = r20
            r2.put(r14, r8)     // Catch:{ all -> 0x00d4 }
        L_0x03e0:
            java.lang.String r8 = "currencyCode"
            java.lang.String r8 = AFInAppEventParameterName((java.lang.String) r8)     // Catch:{ all -> 0x0b0b }
            r14 = 3
            if (r8 == 0) goto L_0x040a
            int r15 = r8.length()     // Catch:{ all -> 0x00d4 }
            if (r15 == r14) goto L_0x0405
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d4 }
            java.lang.String r12 = "WARNING: currency code should be 3 characters!!! '"
            r15.<init>(r12)     // Catch:{ all -> 0x00d4 }
            r15.append(r8)     // Catch:{ all -> 0x00d4 }
            java.lang.String r12 = "' is not a legal value."
            r15.append(r12)     // Catch:{ all -> 0x00d4 }
            java.lang.String r12 = r15.toString()     // Catch:{ all -> 0x00d4 }
            com.appsflyer.AFLogger.afWarnLog(r12)     // Catch:{ all -> 0x00d4 }
        L_0x0405:
            java.lang.String r12 = "currency"
            r2.put(r12, r8)     // Catch:{ all -> 0x00d4 }
        L_0x040a:
            java.lang.String r8 = "IS_UPDATE"
            java.lang.String r8 = AFInAppEventParameterName((java.lang.String) r8)     // Catch:{ all -> 0x0b0b }
            if (r8 == 0) goto L_0x0417
            java.lang.String r12 = "isUpdate"
            r2.put(r12, r8)     // Catch:{ all -> 0x00d4 }
        L_0x0417:
            boolean r8 = r1.isPreInstalledApp(r11)     // Catch:{ all -> 0x0b0b }
            java.lang.String r12 = "af_preinstalled"
            java.lang.String r8 = java.lang.Boolean.toString(r8)     // Catch:{ all -> 0x0b0b }
            r2.put(r12, r8)     // Catch:{ all -> 0x0b0b }
            java.lang.String r8 = "collectFacebookAttrId"
            boolean r8 = r4.getBoolean(r8, r7)     // Catch:{ all -> 0x0b0b }
            if (r8 == 0) goto L_0x045d
            android.content.pm.PackageManager r8 = r11.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0449, all -> 0x0440 }
            java.lang.String r12 = "com.facebook.katana"
            r15 = 0
            r8.getApplicationInfo(r12, r15)     // Catch:{ NameNotFoundException -> 0x043b, all -> 0x0440 }
            java.lang.String r8 = r1.getAttributionId(r11)     // Catch:{ NameNotFoundException -> 0x043b, all -> 0x0440 }
            goto L_0x0456
        L_0x043b:
            r0 = move-exception
            r8 = r0
            r12 = r18
            goto L_0x044d
        L_0x0440:
            r0 = move-exception
            r8 = r0
            r12 = r18
            com.appsflyer.AFLogger.afErrorLog(r12, r8)     // Catch:{ all -> 0x00d4 }
        L_0x0447:
            r8 = r13
            goto L_0x0456
        L_0x0449:
            r0 = move-exception
            r12 = r18
            r8 = r0
        L_0x044d:
            java.lang.String r15 = "com.facebook.katana not found"
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r15, r8, r7)     // Catch:{ all -> 0x00d4 }
            com.appsflyer.AFLogger.afWarnLog(r12)     // Catch:{ all -> 0x00d4 }
            goto L_0x0447
        L_0x0456:
            if (r8 == 0) goto L_0x045d
            java.lang.String r12 = "fb"
            r2.put(r12, r8)     // Catch:{ all -> 0x00d4 }
        L_0x045d:
            r1.values((android.content.Context) r11, (java.util.Map<java.lang.String, java.lang.Object>) r2)     // Catch:{ all -> 0x0b0b }
            java.lang.ref.WeakReference r8 = new java.lang.ref.WeakReference     // Catch:{ Exception -> 0x0471 }
            r8.<init>(r11)     // Catch:{ Exception -> 0x0471 }
            java.lang.String r8 = com.appsflyer.internal.AFb1xSDK.AFInAppEventParameterName(r8)     // Catch:{ Exception -> 0x0471 }
            if (r8 == 0) goto L_0x0488
            java.lang.String r12 = "uid"
            r2.put(r12, r8)     // Catch:{ Exception -> 0x0471 }
            goto L_0x0488
        L_0x0471:
            r0 = move-exception
            r8 = r0
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0b0b }
            java.lang.String r15 = "ERROR: could not get uid "
            r12.<init>(r15)     // Catch:{ all -> 0x0b0b }
            java.lang.String r15 = r8.getMessage()     // Catch:{ all -> 0x0b0b }
            r12.append(r15)     // Catch:{ all -> 0x0b0b }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x0b0b }
            com.appsflyer.AFLogger.afErrorLog(r12, r8)     // Catch:{ all -> 0x0b0b }
        L_0x0488:
            java.lang.String r8 = "lang"
            java.util.Locale r12 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x0496 }
            java.lang.String r12 = r12.getDisplayLanguage()     // Catch:{ Exception -> 0x0496 }
            r2.put(r8, r12)     // Catch:{ Exception -> 0x0496 }
            goto L_0x049d
        L_0x0496:
            r0 = move-exception
            r8 = r0
            java.lang.String r12 = "Exception while collecting display language name. "
            com.appsflyer.AFLogger.afErrorLog(r12, r8)     // Catch:{ all -> 0x0b0b }
        L_0x049d:
            java.lang.String r8 = "lang_code"
            java.util.Locale r12 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x04ab }
            java.lang.String r12 = r12.getLanguage()     // Catch:{ Exception -> 0x04ab }
            r2.put(r8, r12)     // Catch:{ Exception -> 0x04ab }
            goto L_0x04b2
        L_0x04ab:
            r0 = move-exception
            r8 = r0
            java.lang.String r12 = "Exception while collecting display language code. "
            com.appsflyer.AFLogger.afErrorLog(r12, r8)     // Catch:{ all -> 0x0b0b }
        L_0x04b2:
            java.lang.String r8 = "country"
            java.util.Locale r12 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x04c0 }
            java.lang.String r12 = r12.getCountry()     // Catch:{ Exception -> 0x04c0 }
            r2.put(r8, r12)     // Catch:{ Exception -> 0x04c0 }
            goto L_0x04c7
        L_0x04c0:
            r0 = move-exception
            r8 = r0
            java.lang.String r12 = "Exception while collecting country name. "
            com.appsflyer.AFLogger.afErrorLog(r12, r8)     // Catch:{ all -> 0x0b0b }
        L_0x04c7:
            java.lang.String r8 = "platformextension"
            com.appsflyer.internal.AFb1rSDK r12 = r1.onResponseErrorNative     // Catch:{ all -> 0x0b0b }
            java.lang.String r12 = r12.values()     // Catch:{ all -> 0x0b0b }
            r2.put(r8, r12)     // Catch:{ all -> 0x0b0b }
            AFKeystoreWrapper((android.content.Context) r11, (java.util.Map<java.lang.String, ? super java.lang.String>) r2)     // Catch:{ all -> 0x0b0b }
            java.text.SimpleDateFormat r8 = new java.text.SimpleDateFormat     // Catch:{ all -> 0x0b0b }
            java.util.Locale r12 = java.util.Locale.US     // Catch:{ all -> 0x0b0b }
            r15 = r17
            r8.<init>(r15, r12)     // Catch:{ all -> 0x0b0b }
            android.content.pm.PackageManager r12 = r11.getPackageManager()     // Catch:{ Exception -> 0x04f7 }
            java.lang.String r14 = r11.getPackageName()     // Catch:{ Exception -> 0x04f7 }
            r13 = 0
            android.content.pm.PackageInfo r12 = r12.getPackageInfo(r14, r13)     // Catch:{ Exception -> 0x04f7 }
            long r12 = r12.firstInstallTime     // Catch:{ Exception -> 0x04f7 }
            java.lang.String r14 = "installDate"
            java.lang.String r12 = AFKeystoreWrapper((java.text.SimpleDateFormat) r8, (long) r12)     // Catch:{ Exception -> 0x04f7 }
            r2.put(r14, r12)     // Catch:{ Exception -> 0x04f7 }
            goto L_0x04fe
        L_0x04f7:
            r0 = move-exception
            r12 = r0
            java.lang.String r13 = "Exception while collecting install date. "
            com.appsflyer.AFLogger.afErrorLog(r13, r12)     // Catch:{ all -> 0x0b0b }
        L_0x04fe:
            android.content.pm.PackageManager r12 = r11.getPackageManager()     // Catch:{ all -> 0x05a5 }
            java.lang.String r13 = r11.getPackageName()     // Catch:{ all -> 0x05a5 }
            r14 = 0
            android.content.pm.PackageInfo r12 = r12.getPackageInfo(r13, r14)     // Catch:{ all -> 0x05a5 }
            r13 = r16
            int r7 = r3.getInt(r13, r14)     // Catch:{ all -> 0x05a5 }
            int r14 = r12.versionCode     // Catch:{ all -> 0x05a5 }
            if (r14 <= r7) goto L_0x051e
            com.appsflyer.internal.AFb1gSDK r7 = r1.AFInAppEventParameterName((android.content.Context) r11)     // Catch:{ all -> 0x05a5 }
            int r14 = r12.versionCode     // Catch:{ all -> 0x05a5 }
            r7.AFInAppEventParameterName((java.lang.String) r13, (int) r14)     // Catch:{ all -> 0x05a5 }
        L_0x051e:
            java.lang.String r7 = "app_version_code"
            int r13 = r12.versionCode     // Catch:{ all -> 0x05a5 }
            java.lang.String r13 = java.lang.Integer.toString(r13)     // Catch:{ all -> 0x05a5 }
            r2.put(r7, r13)     // Catch:{ all -> 0x05a5 }
            java.lang.String r7 = "app_version_name"
            java.lang.String r13 = r12.versionName     // Catch:{ all -> 0x05a5 }
            r2.put(r7, r13)     // Catch:{ all -> 0x05a5 }
            long r13 = r12.firstInstallTime     // Catch:{ all -> 0x05a5 }
            r7 = r4
            r21 = r5
            long r4 = r12.lastUpdateTime     // Catch:{ all -> 0x059d }
            java.lang.String r12 = "date1"
            r22 = r7
            java.text.SimpleDateFormat r7 = new java.text.SimpleDateFormat     // Catch:{ all -> 0x0599 }
            r23 = r6
            java.util.Locale r6 = java.util.Locale.US     // Catch:{ all -> 0x0595 }
            r7.<init>(r15, r6)     // Catch:{ all -> 0x0595 }
            r25 = r3
            java.util.Date r3 = new java.util.Date     // Catch:{ all -> 0x0593 }
            r3.<init>(r13)     // Catch:{ all -> 0x0593 }
            java.lang.String r3 = r7.format(r3)     // Catch:{ all -> 0x0593 }
            r2.put(r12, r3)     // Catch:{ all -> 0x0593 }
            java.lang.String r3 = "date2"
            java.text.SimpleDateFormat r7 = new java.text.SimpleDateFormat     // Catch:{ all -> 0x0593 }
            r7.<init>(r15, r6)     // Catch:{ all -> 0x0593 }
            java.util.Date r6 = new java.util.Date     // Catch:{ all -> 0x0593 }
            r6.<init>(r4)     // Catch:{ all -> 0x0593 }
            java.lang.String r4 = r7.format(r6)     // Catch:{ all -> 0x0593 }
            r2.put(r3, r4)     // Catch:{ all -> 0x0593 }
            java.lang.String r3 = r1.values((java.text.SimpleDateFormat) r8, (android.content.Context) r11)     // Catch:{ all -> 0x0593 }
            int r4 = android.os.Process.myTid()     // Catch:{ all -> 0x0593 }
            int r4 = r4 >> 22
            int r4 = r4 + 3483
            char r4 = (char) r4     // Catch:{ all -> 0x0593 }
            int r5 = android.view.ViewConfiguration.getLongPressTimeout()     // Catch:{ all -> 0x0593 }
            int r5 = r5 >> 16
            int r5 = r5 + 15
            int r6 = android.view.MotionEvent.axisFromString(r10)     // Catch:{ all -> 0x0593 }
            int r6 = r6 + 19
            r7 = 1
            java.lang.Object[] r8 = new java.lang.Object[r7]     // Catch:{ all -> 0x0593 }
            AFInAppEventParameterName((char) r4, (int) r5, (int) r6, (java.lang.Object[]) r8)     // Catch:{ all -> 0x0593 }
            r4 = 0
            r5 = r8[r4]     // Catch:{ all -> 0x0593 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0593 }
            java.lang.String r4 = r5.intern()     // Catch:{ all -> 0x0593 }
            r2.put(r4, r3)     // Catch:{ all -> 0x0593 }
            goto L_0x05b5
        L_0x0593:
            r0 = move-exception
            goto L_0x05ae
        L_0x0595:
            r0 = move-exception
            r25 = r3
            goto L_0x05ae
        L_0x0599:
            r0 = move-exception
            r25 = r3
            goto L_0x05ac
        L_0x059d:
            r0 = move-exception
            r25 = r3
            r23 = r6
            r22 = r7
            goto L_0x05ae
        L_0x05a5:
            r0 = move-exception
            r25 = r3
            r22 = r4
            r21 = r5
        L_0x05ac:
            r23 = r6
        L_0x05ae:
            r3 = r0
            java.lang.String r4 = "Exception while collecting app version data "
            r5 = 1
            com.appsflyer.AFLogger.afErrorLog(r4, r3, r5)     // Catch:{ all -> 0x0b0b }
        L_0x05b5:
            boolean r3 = com.appsflyer.internal.AFe1pSDK.valueOf((android.content.Context) r11)     // Catch:{ all -> 0x0b0b }
            r1.onResponseNative = r3     // Catch:{ all -> 0x0b0b }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0b0b }
            java.lang.String r4 = "didConfigureTokenRefreshService="
            r3.<init>(r4)     // Catch:{ all -> 0x0b0b }
            boolean r4 = r1.onResponseNative     // Catch:{ all -> 0x0b0b }
            r3.append(r4)     // Catch:{ all -> 0x0b0b }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0b0b }
            com.appsflyer.AFLogger.afDebugLog(r3)     // Catch:{ all -> 0x0b0b }
            boolean r3 = r1.onResponseNative     // Catch:{ all -> 0x0b0b }
            if (r3 != 0) goto L_0x05d9
            java.lang.String r3 = "tokenRefreshConfigured"
            java.lang.Boolean r4 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00d4 }
            r2.put(r3, r4)     // Catch:{ all -> 0x00d4 }
        L_0x05d9:
            if (r9 == 0) goto L_0x060e
            java.lang.String r3 = r1.onAppOpenAttributionNative     // Catch:{ all -> 0x00d4 }
            if (r3 == 0) goto L_0x0604
            java.lang.String r3 = "af_deeplink"
            java.lang.Object r3 = r2.get(r3)     // Catch:{ all -> 0x00d4 }
            if (r3 == 0) goto L_0x05ed
            java.lang.String r3 = "Skip 'af' payload as deeplink was found by path"
            com.appsflyer.AFLogger.afDebugLog(r3)     // Catch:{ all -> 0x00d4 }
            goto L_0x0604
        L_0x05ed:
            org.json.b r3 = new org.json.b     // Catch:{ all -> 0x00d4 }
            java.lang.String r4 = r1.onAppOpenAttributionNative     // Catch:{ all -> 0x00d4 }
            r3.<init>((java.lang.String) r4)     // Catch:{ all -> 0x00d4 }
            java.lang.String r4 = "isPush"
            java.lang.String r5 = "true"
            r3.put((java.lang.String) r4, (java.lang.Object) r5)     // Catch:{ all -> 0x00d4 }
            java.lang.String r4 = "af_deeplink"
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00d4 }
            r2.put(r4, r3)     // Catch:{ all -> 0x00d4 }
        L_0x0604:
            r3 = 0
            r1.onAppOpenAttributionNative = r3     // Catch:{ all -> 0x00d4 }
            java.lang.String r3 = "open_referrer"
            r4 = r19
            r2.put(r3, r4)     // Catch:{ all -> 0x00d4 }
        L_0x060e:
            if (r9 != 0) goto L_0x0975
            com.appsflyer.internal.AFa1eSDK r3 = com.appsflyer.internal.AFa1eSDK.valueOf((android.content.Context) r11)     // Catch:{ all -> 0x094f }
            java.util.concurrent.ConcurrentHashMap r4 = new java.util.concurrent.ConcurrentHashMap     // Catch:{ all -> 0x094f }
            r4.<init>()     // Catch:{ all -> 0x094f }
            java.util.List r3 = r3.values()     // Catch:{ all -> 0x094f }
            boolean r5 = r3.isEmpty()     // Catch:{ all -> 0x094f }
            if (r5 != 0) goto L_0x0931
            com.appsflyer.internal.AFa1tSDK r5 = new com.appsflyer.internal.AFa1tSDK     // Catch:{ Exception -> 0x092a, all -> 0x0923 }
            r5.<init>()     // Catch:{ Exception -> 0x092a, all -> 0x0923 }
            java.lang.String r5 = "n"
            java.lang.String r6 = "v"
            java.lang.String r7 = "er"
            java.lang.String r8 = "uk"
            java.util.HashMap r10 = new java.util.HashMap     // Catch:{ Exception -> 0x092a, all -> 0x0923 }
            r10.<init>()     // Catch:{ Exception -> 0x092a, all -> 0x0923 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x092a, all -> 0x0923 }
        L_0x0639:
            boolean r12 = r3.hasNext()     // Catch:{ Exception -> 0x092a, all -> 0x0923 }
            if (r12 == 0) goto L_0x0908
            java.lang.Object r12 = r3.next()     // Catch:{ Exception -> 0x092a, all -> 0x0923 }
            java.util.Map r12 = (java.util.Map) r12     // Catch:{ Exception -> 0x092a, all -> 0x0923 }
            java.util.HashMap r13 = new java.util.HashMap     // Catch:{ Exception -> 0x092a, all -> 0x0923 }
            r13.<init>()     // Catch:{ Exception -> 0x092a, all -> 0x0923 }
            java.lang.String r14 = "sVS"
            java.lang.Object r14 = r12.get(r14)     // Catch:{ Exception -> 0x092a, all -> 0x0923 }
            if (r14 == 0) goto L_0x0654
            r14 = 1
            goto L_0x0655
        L_0x0654:
            r14 = 0
        L_0x0655:
            java.lang.String r15 = "sVE"
            java.lang.Object r15 = r12.get(r15)     // Catch:{ Exception -> 0x092a, all -> 0x0923 }
            if (r15 == 0) goto L_0x065f
            r15 = 1
            goto L_0x0660
        L_0x065f:
            r15 = 0
        L_0x0660:
            if (r14 == 0) goto L_0x0667
            if (r15 == 0) goto L_0x0667
            com.appsflyer.internal.AFa1tSDK$AFa1xSDK r14 = com.appsflyer.internal.AFa1tSDK.AFa1xSDK.ALL     // Catch:{ Exception -> 0x0953 }
            goto L_0x066e
        L_0x0667:
            if (r14 == 0) goto L_0x066c
            com.appsflyer.internal.AFa1tSDK$AFa1xSDK r14 = com.appsflyer.internal.AFa1tSDK.AFa1xSDK.FIRST     // Catch:{ Exception -> 0x0953 }
            goto L_0x066e
        L_0x066c:
            com.appsflyer.internal.AFa1tSDK$AFa1xSDK r14 = com.appsflyer.internal.AFa1tSDK.AFa1xSDK.NONE     // Catch:{ Exception -> 0x092a, all -> 0x0923 }
        L_0x066e:
            com.appsflyer.internal.AFa1tSDK$AFa1xSDK r15 = com.appsflyer.internal.AFa1tSDK.AFa1xSDK.NONE     // Catch:{ Exception -> 0x092a, all -> 0x0923 }
            if (r14 == r15) goto L_0x08f7
            java.lang.String r15 = "sT"
            java.lang.Object r15 = r12.get(r15)     // Catch:{ Exception -> 0x092a, all -> 0x0923 }
            java.lang.Integer r15 = (java.lang.Integer) r15     // Catch:{ Exception -> 0x092a, all -> 0x0923 }
            r18 = r3
            java.lang.String r3 = "sN"
            java.lang.Object r3 = r12.get(r3)     // Catch:{ Exception -> 0x092a, all -> 0x0923 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x092a, all -> 0x0923 }
            if (r3 == 0) goto L_0x068a
            r13.put(r5, r3)     // Catch:{ Exception -> 0x0953 }
            goto L_0x068d
        L_0x068a:
            r13.put(r5, r8)     // Catch:{ Exception -> 0x092a, all -> 0x0923 }
        L_0x068d:
            com.appsflyer.internal.AFa1tSDK$AFa1ySDK[] r3 = com.appsflyer.internal.AFa1tSDK.AFa1ySDK.values()     // Catch:{ Exception -> 0x092a, all -> 0x0923 }
            int r19 = r15.intValue()     // Catch:{ Exception -> 0x092a, all -> 0x0923 }
            r3 = r3[r19]     // Catch:{ Exception -> 0x092a, all -> 0x0923 }
            r19 = r5
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ Exception -> 0x092a, all -> 0x0923 }
            r26 = r8
            java.lang.String r8 = "sVS"
            java.lang.Object r8 = r12.get(r8)     // Catch:{ Exception -> 0x092a, all -> 0x0923 }
            java.util.List r8 = com.appsflyer.internal.AFa1tSDK.AFInAppEventParameterName(r8)     // Catch:{ Exception -> 0x092a, all -> 0x0923 }
            r5.<init>(r8)     // Catch:{ Exception -> 0x092a, all -> 0x0923 }
            com.appsflyer.internal.AFa1tSDK$AFa1xSDK r8 = com.appsflyer.internal.AFa1tSDK.AFa1xSDK.ALL     // Catch:{ Exception -> 0x092a, all -> 0x0923 }
            if (r14 != r8) goto L_0x06bb
            java.lang.String r8 = "sVE"
            java.lang.Object r8 = r12.get(r8)     // Catch:{ Exception -> 0x0953 }
            java.util.List r8 = com.appsflyer.internal.AFa1tSDK.AFInAppEventParameterName(r8)     // Catch:{ Exception -> 0x0953 }
            r5.addAll(r8)     // Catch:{ Exception -> 0x0953 }
        L_0x06bb:
            com.appsflyer.internal.AFa1tSDK$AFa1ySDK r8 = com.appsflyer.internal.AFa1tSDK.AFa1ySDK.MAGNETOMETER     // Catch:{ Exception -> 0x092a, all -> 0x0923 }
            java.lang.String r12 = "##.#"
            if (r3 != r8) goto L_0x07bf
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x092a, all -> 0x0923 }
            r3.<init>()     // Catch:{ Exception -> 0x092a, all -> 0x0923 }
            r8 = 0
            java.lang.Object r28 = r5.get(r8)     // Catch:{ Exception -> 0x092a, all -> 0x0923 }
            java.math.BigDecimal r28 = (java.math.BigDecimal) r28     // Catch:{ Exception -> 0x092a, all -> 0x0923 }
            r8 = 1
            java.lang.Object r29 = r5.get(r8)     // Catch:{ Exception -> 0x092a, all -> 0x0923 }
            java.math.BigDecimal r29 = (java.math.BigDecimal) r29     // Catch:{ Exception -> 0x092a, all -> 0x0923 }
            r30 = r9
            double r8 = r28.doubleValue()     // Catch:{ Exception -> 0x07bc, all -> 0x0923 }
            r28 = r2
            double r1 = r29.doubleValue()     // Catch:{ Exception -> 0x07b7, all -> 0x0916 }
            double r1 = java.lang.Math.atan2(r1, r8)     // Catch:{ Exception -> 0x07b7, all -> 0x0916 }
            r8 = 4633260481411531256(0x404ca5dc1a63c1f8, double:57.29577951308232)
            double r1 = r1 * r8
            java.math.BigDecimal r1 = java.math.BigDecimal.valueOf(r1)     // Catch:{ Exception -> 0x07b7, all -> 0x0916 }
            java.text.DecimalFormat r2 = new java.text.DecimalFormat     // Catch:{ Exception -> 0x07b7, all -> 0x0916 }
            r2.<init>(r12)     // Catch:{ Exception -> 0x07b7, all -> 0x0916 }
            java.math.RoundingMode r8 = java.math.RoundingMode.DOWN     // Catch:{ Exception -> 0x07b7, all -> 0x0916 }
            r2.setRoundingMode(r8)     // Catch:{ Exception -> 0x07b7, all -> 0x0916 }
            java.lang.String r2 = r2.format(r1)     // Catch:{ Exception -> 0x07b7, all -> 0x0916 }
            double r8 = java.lang.Double.parseDouble(r2)     // Catch:{ Exception -> 0x07b7, all -> 0x0916 }
            java.lang.Double r2 = java.lang.Double.valueOf(r8)     // Catch:{ Exception -> 0x07b7, all -> 0x0916 }
            r3.add(r2)     // Catch:{ Exception -> 0x07b7, all -> 0x0916 }
            r2 = 2
            java.lang.Object r8 = r5.get(r2)     // Catch:{ Exception -> 0x07b7, all -> 0x0916 }
            java.math.BigDecimal r8 = (java.math.BigDecimal) r8     // Catch:{ Exception -> 0x07b7, all -> 0x0916 }
            java.text.DecimalFormat r2 = new java.text.DecimalFormat     // Catch:{ Exception -> 0x07b7, all -> 0x0916 }
            r2.<init>(r12)     // Catch:{ Exception -> 0x07b7, all -> 0x0916 }
            java.math.RoundingMode r9 = java.math.RoundingMode.DOWN     // Catch:{ Exception -> 0x07b7, all -> 0x0916 }
            r2.setRoundingMode(r9)     // Catch:{ Exception -> 0x07b7, all -> 0x0916 }
            java.lang.String r2 = r2.format(r8)     // Catch:{ Exception -> 0x07b7, all -> 0x0916 }
            double r8 = java.lang.Double.parseDouble(r2)     // Catch:{ Exception -> 0x07b7, all -> 0x0916 }
            java.lang.Double r2 = java.lang.Double.valueOf(r8)     // Catch:{ Exception -> 0x07b7, all -> 0x0916 }
            r3.add(r2)     // Catch:{ Exception -> 0x07b7, all -> 0x0916 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x07b7, all -> 0x0916 }
            r2.<init>()     // Catch:{ Exception -> 0x07b7, all -> 0x0916 }
            int r8 = r5.size()     // Catch:{ Exception -> 0x07b7, all -> 0x0916 }
            r9 = 5
            if (r8 <= r9) goto L_0x07a4
            r8 = 3
            java.lang.Object r9 = r5.get(r8)     // Catch:{ Exception -> 0x07b7, all -> 0x0916 }
            java.math.BigDecimal r9 = (java.math.BigDecimal) r9     // Catch:{ Exception -> 0x07b7, all -> 0x0916 }
            r8 = 4
            java.lang.Object r29 = r5.get(r8)     // Catch:{ Exception -> 0x07b7, all -> 0x0916 }
            java.math.BigDecimal r29 = (java.math.BigDecimal) r29     // Catch:{ Exception -> 0x07b7, all -> 0x0916 }
            double r8 = r9.doubleValue()     // Catch:{ Exception -> 0x07b7, all -> 0x0916 }
            r32 = r10
            r31 = r11
            double r10 = r29.doubleValue()     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            double r8 = java.lang.Math.atan2(r10, r8)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            r10 = 4633260481411531256(0x404ca5dc1a63c1f8, double:57.29577951308232)
            double r8 = r8 * r10
            java.math.BigDecimal r8 = java.math.BigDecimal.valueOf(r8)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            java.math.BigDecimal r1 = r8.subtract(r1)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            java.text.DecimalFormat r8 = new java.text.DecimalFormat     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            r8.<init>(r12)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            java.math.RoundingMode r9 = java.math.RoundingMode.DOWN     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            r8.setRoundingMode(r9)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            java.lang.String r1 = r8.format(r1)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            double r8 = java.lang.Double.parseDouble(r1)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            java.lang.Double r1 = java.lang.Double.valueOf(r8)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            r2.add(r1)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            r1 = 5
            java.lang.Object r8 = r5.get(r1)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            java.math.BigDecimal r8 = (java.math.BigDecimal) r8     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            r1 = 2
            java.lang.Object r1 = r5.get(r1)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            java.math.BigDecimal r1 = (java.math.BigDecimal) r1     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            java.math.BigDecimal r1 = r8.subtract(r1)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            java.text.DecimalFormat r5 = new java.text.DecimalFormat     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            r5.<init>(r12)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            java.math.RoundingMode r8 = java.math.RoundingMode.DOWN     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            r5.setRoundingMode(r8)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            java.lang.String r1 = r5.format(r1)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            double r8 = java.lang.Double.parseDouble(r1)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            java.lang.Double r1 = java.lang.Double.valueOf(r8)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            r2.add(r1)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            goto L_0x07a8
        L_0x07a4:
            r32 = r10
            r31 = r11
        L_0x07a8:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            r1.<init>()     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            r1.add(r3)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            r1.add(r2)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            r3 = 4
            r8 = 5
            goto L_0x08c9
        L_0x07b7:
            r0 = move-exception
            r31 = r11
            goto L_0x091f
        L_0x07bc:
            r0 = move-exception
            goto L_0x092d
        L_0x07bf:
            r28 = r2
            r30 = r9
            r32 = r10
            r31 = r11
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            r1.<init>()     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            int r2 = r5.size()     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            r3 = 5
            if (r2 <= r3) goto L_0x0855
            r2 = 3
            java.lang.Object r3 = r5.get(r2)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            java.math.BigDecimal r3 = (java.math.BigDecimal) r3     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            r8 = 0
            java.lang.Object r9 = r5.get(r8)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            java.math.BigDecimal r9 = (java.math.BigDecimal) r9     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            java.math.BigDecimal r3 = r3.subtract(r9)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            java.text.DecimalFormat r8 = new java.text.DecimalFormat     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            r8.<init>(r12)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            java.math.RoundingMode r9 = java.math.RoundingMode.DOWN     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            r8.setRoundingMode(r9)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            java.lang.String r3 = r8.format(r3)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            double r8 = java.lang.Double.parseDouble(r3)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            java.lang.Double r3 = java.lang.Double.valueOf(r8)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            r1.add(r3)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            r3 = 4
            java.lang.Object r8 = r5.get(r3)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            java.math.BigDecimal r8 = (java.math.BigDecimal) r8     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            r9 = 1
            java.lang.Object r10 = r5.get(r9)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            java.math.BigDecimal r10 = (java.math.BigDecimal) r10     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            java.math.BigDecimal r8 = r8.subtract(r10)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            java.text.DecimalFormat r9 = new java.text.DecimalFormat     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            r9.<init>(r12)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            java.math.RoundingMode r10 = java.math.RoundingMode.DOWN     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            r9.setRoundingMode(r10)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            java.lang.String r8 = r9.format(r8)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            double r8 = java.lang.Double.parseDouble(r8)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            java.lang.Double r8 = java.lang.Double.valueOf(r8)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            r1.add(r8)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            r8 = 5
            java.lang.Object r9 = r5.get(r8)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            java.math.BigDecimal r9 = (java.math.BigDecimal) r9     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            r10 = 2
            java.lang.Object r11 = r5.get(r10)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            java.math.BigDecimal r11 = (java.math.BigDecimal) r11     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            java.math.BigDecimal r9 = r9.subtract(r11)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            java.text.DecimalFormat r10 = new java.text.DecimalFormat     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            r10.<init>(r12)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            java.math.RoundingMode r11 = java.math.RoundingMode.DOWN     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            r10.setRoundingMode(r11)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            java.lang.String r9 = r10.format(r9)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            double r9 = java.lang.Double.parseDouble(r9)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            java.lang.Double r9 = java.lang.Double.valueOf(r9)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            r1.add(r9)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            goto L_0x0858
        L_0x0855:
            r8 = r3
            r2 = 3
            r3 = 4
        L_0x0858:
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            r9.<init>()     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            r10 = 0
            java.lang.Object r11 = r5.get(r10)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            java.math.BigDecimal r11 = (java.math.BigDecimal) r11     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            java.text.DecimalFormat r10 = new java.text.DecimalFormat     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            r10.<init>(r12)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            java.math.RoundingMode r2 = java.math.RoundingMode.DOWN     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            r10.setRoundingMode(r2)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            java.lang.String r2 = r10.format(r11)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            double r10 = java.lang.Double.parseDouble(r2)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            java.lang.Double r2 = java.lang.Double.valueOf(r10)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            r9.add(r2)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            r2 = 1
            java.lang.Object r10 = r5.get(r2)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            java.math.BigDecimal r10 = (java.math.BigDecimal) r10     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            java.text.DecimalFormat r2 = new java.text.DecimalFormat     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            r2.<init>(r12)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            java.math.RoundingMode r11 = java.math.RoundingMode.DOWN     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            r2.setRoundingMode(r11)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            java.lang.String r2 = r2.format(r10)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            double r10 = java.lang.Double.parseDouble(r2)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            java.lang.Double r2 = java.lang.Double.valueOf(r10)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            r9.add(r2)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            r2 = 2
            java.lang.Object r2 = r5.get(r2)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            java.math.BigDecimal r2 = (java.math.BigDecimal) r2     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            java.text.DecimalFormat r5 = new java.text.DecimalFormat     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            r5.<init>(r12)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            java.math.RoundingMode r10 = java.math.RoundingMode.DOWN     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            r5.setRoundingMode(r10)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            java.lang.String r2 = r5.format(r2)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            double r10 = java.lang.Double.parseDouble(r2)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            java.lang.Double r2 = java.lang.Double.valueOf(r10)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            r9.add(r2)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            r2.<init>()     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            r2.add(r9)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            r2.add(r1)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            r1 = r2
        L_0x08c9:
            r13.put(r6, r1)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            com.appsflyer.internal.AFa1tSDK$AFa1wSDK[] r1 = com.appsflyer.internal.AFa1tSDK.AFa1wSDK.values()     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            int r2 = r15.intValue()     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            r1 = r1[r2]     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            java.lang.String r1 = r1.AFKeystoreWrapper     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            r2 = r32
            r2.put(r1, r13)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            com.appsflyer.internal.AFa1tSDK$AFa1xSDK r1 = com.appsflyer.internal.AFa1tSDK.AFa1xSDK.FIRST     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            if (r14 != r1) goto L_0x08e6
            java.lang.String r1 = "no_svs"
            r2.put(r7, r1)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
        L_0x08e6:
            r1 = r34
            r10 = r2
            r3 = r18
            r5 = r19
            r8 = r26
            r2 = r28
            r9 = r30
            r11 = r31
            goto L_0x0639
        L_0x08f7:
            r28 = r2
            r30 = r9
            r31 = r11
            java.util.HashMap r10 = new java.util.HashMap     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            r10.<init>()     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            java.lang.String r1 = "na"
            r10.put(r7, r1)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            goto L_0x0910
        L_0x0908:
            r28 = r2
            r30 = r9
            r2 = r10
            r31 = r11
            r10 = r2
        L_0x0910:
            java.lang.String r1 = "sensors"
            r4.put(r1, r10)     // Catch:{ Exception -> 0x091e, all -> 0x0916 }
            goto L_0x093e
        L_0x0916:
            r0 = move-exception
            r2 = r34
            r3 = r0
            r1 = r28
            goto L_0x0b12
        L_0x091e:
            r0 = move-exception
        L_0x091f:
            r2 = r0
            r1 = r28
            goto L_0x095a
        L_0x0923:
            r0 = move-exception
            r3 = r0
            r1 = r2
            r2 = r34
            goto L_0x0b12
        L_0x092a:
            r0 = move-exception
            r30 = r9
        L_0x092d:
            r31 = r11
            r1 = r2
            goto L_0x0959
        L_0x0931:
            r28 = r2
            r30 = r9
            r31 = r11
            java.lang.String r1 = "sensors"
            java.lang.String r2 = "na"
            r4.put(r1, r2)     // Catch:{ Exception -> 0x094b, all -> 0x0946 }
        L_0x093e:
            r1 = r28
            r1.putAll(r4)     // Catch:{ Exception -> 0x0944 }
            goto L_0x097a
        L_0x0944:
            r0 = move-exception
            goto L_0x0959
        L_0x0946:
            r0 = move-exception
            r1 = r28
            goto L_0x0af5
        L_0x094b:
            r0 = move-exception
            r1 = r28
            goto L_0x0959
        L_0x094f:
            r0 = move-exception
            r1 = r2
            goto L_0x0af5
        L_0x0953:
            r0 = move-exception
            r1 = r2
            r30 = r9
            r31 = r11
        L_0x0959:
            r2 = r0
        L_0x095a:
            java.lang.String r3 = "error while getting sensors data"
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r3, r2)     // Catch:{ all -> 0x0af4 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0af4 }
            java.lang.String r4 = "Unexpected exception from AFSensorManager: "
            r3.<init>(r4)     // Catch:{ all -> 0x0af4 }
            java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x0af4 }
            r3.append(r2)     // Catch:{ all -> 0x0af4 }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0af4 }
            com.appsflyer.AFLogger.afRDLog(r2)     // Catch:{ all -> 0x0af4 }
            goto L_0x097a
        L_0x0975:
            r1 = r2
            r30 = r9
            r31 = r11
        L_0x097a:
            java.lang.String r2 = "advertiserId"
            java.lang.String r2 = AFInAppEventParameterName((java.lang.String) r2)     // Catch:{ all -> 0x0af4 }
            if (r2 != 0) goto L_0x099c
            r2 = r31
            com.appsflyer.internal.AFa1bSDK.AFKeystoreWrapper(r2, r1)     // Catch:{ all -> 0x0af4 }
            java.lang.String r3 = "GAID_retry"
            java.lang.String r4 = "advertiserId"
            java.lang.String r4 = AFInAppEventParameterName((java.lang.String) r4)     // Catch:{ all -> 0x0af4 }
            if (r4 == 0) goto L_0x0993
            r6 = 1
            goto L_0x0994
        L_0x0993:
            r6 = 0
        L_0x0994:
            java.lang.String r4 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x0af4 }
            r1.put(r3, r4)     // Catch:{ all -> 0x0af4 }
            goto L_0x099e
        L_0x099c:
            r2 = r31
        L_0x099e:
            android.content.ContentResolver r3 = r2.getContentResolver()     // Catch:{ all -> 0x0af4 }
            com.appsflyer.internal.AFc1vSDK$AFa1wSDK r3 = com.appsflyer.internal.AFa1bSDK.values((android.content.ContentResolver) r3)     // Catch:{ all -> 0x0af4 }
            if (r3 == 0) goto L_0x09ba
            java.lang.String r4 = "amazon_aid"
            java.lang.String r5 = r3.AFInAppEventType     // Catch:{ all -> 0x0af4 }
            r1.put(r4, r5)     // Catch:{ all -> 0x0af4 }
            java.lang.String r4 = "amazon_aid_limit"
            java.lang.Boolean r3 = r3.valueOf     // Catch:{ all -> 0x0af4 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0af4 }
            r1.put(r4, r3)     // Catch:{ all -> 0x0af4 }
        L_0x09ba:
            boolean r3 = com.appsflyer.internal.AFe1pSDK.AFInAppEventParameterName(r25)     // Catch:{ all -> 0x0af4 }
            java.lang.String r4 = "registeredUninstall"
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ all -> 0x0af4 }
            r1.put(r4, r3)     // Catch:{ all -> 0x0af4 }
            r3 = r25
            r4 = r30
            int r5 = AFInAppEventParameterName((android.content.SharedPreferences) r3, (boolean) r4)     // Catch:{ all -> 0x0af4 }
            java.lang.String r6 = "counter"
            java.lang.String r7 = java.lang.Integer.toString(r5)     // Catch:{ all -> 0x0af4 }
            r1.put(r6, r7)     // Catch:{ all -> 0x0af4 }
            java.lang.String r6 = "iaecounter"
            if (r23 == 0) goto L_0x09de
            r7 = 1
            goto L_0x09df
        L_0x09de:
            r7 = 0
        L_0x09df:
            int r7 = AFInAppEventType((android.content.SharedPreferences) r3, (boolean) r7)     // Catch:{ all -> 0x0af4 }
            java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x0af4 }
            r1.put(r6, r7)     // Catch:{ all -> 0x0af4 }
            if (r4 == 0) goto L_0x09f3
            r6 = 1
            if (r5 != r6) goto L_0x09f3
            r7 = r22
            r7.AFInAppEventType = r6     // Catch:{ all -> 0x0af4 }
        L_0x09f3:
            java.lang.String r6 = "isFirstCall"
            boolean r7 = AFInAppEventType((android.content.SharedPreferences) r3)     // Catch:{ all -> 0x0af4 }
            if (r7 != 0) goto L_0x09fd
            r7 = 1
            goto L_0x09fe
        L_0x09fd:
            r7 = 0
        L_0x09fe:
            java.lang.String r7 = java.lang.Boolean.toString(r7)     // Catch:{ all -> 0x0af4 }
            r1.put(r6, r7)     // Catch:{ all -> 0x0af4 }
            valueOf(r2, r4, r1, r5)     // Catch:{ all -> 0x0af4 }
            com.appsflyer.internal.AFa1aSDK r4 = new com.appsflyer.internal.AFa1aSDK     // Catch:{ all -> 0x0af4 }
            r4.<init>()     // Catch:{ all -> 0x0af4 }
            java.lang.String r4 = com.appsflyer.internal.AFa1aSDK.valueOf((java.util.Map<java.lang.String, java.lang.Object>) r1)     // Catch:{ all -> 0x0af4 }
            java.lang.String r5 = "af_v"
            r1.put(r5, r4)     // Catch:{ all -> 0x0af4 }
            com.appsflyer.internal.AFa1aSDK r4 = new com.appsflyer.internal.AFa1aSDK     // Catch:{ all -> 0x0af4 }
            r4.<init>()     // Catch:{ all -> 0x0af4 }
            java.lang.String r4 = com.appsflyer.internal.AFa1aSDK.values((java.util.Map<java.lang.String, java.lang.Object>) r1)     // Catch:{ all -> 0x0af4 }
            java.lang.String r5 = "af_v2"
            r1.put(r5, r4)     // Catch:{ all -> 0x0af4 }
            boolean r4 = onInstallConversionDataLoadedNative(r2)     // Catch:{ all -> 0x0af4 }
            java.lang.String r5 = "ivc"
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch:{ all -> 0x0af4 }
            r1.put(r5, r4)     // Catch:{ all -> 0x0af4 }
            java.lang.String r4 = "is_stop_tracking_used"
            boolean r4 = r3.contains(r4)     // Catch:{ all -> 0x0af4 }
            if (r4 == 0) goto L_0x0a49
            java.lang.String r4 = "istu"
            java.lang.String r5 = "is_stop_tracking_used"
            r6 = 0
            boolean r3 = r3.getBoolean(r5, r6)     // Catch:{ all -> 0x0af4 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0af4 }
            r1.put(r4, r3)     // Catch:{ all -> 0x0af4 }
        L_0x0a49:
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ all -> 0x0af4 }
            r3.<init>()     // Catch:{ all -> 0x0af4 }
            java.lang.String r4 = "mcc"
            android.content.res.Resources r5 = r2.getResources()     // Catch:{ all -> 0x0af4 }
            android.content.res.Configuration r5 = r5.getConfiguration()     // Catch:{ all -> 0x0af4 }
            int r5 = r5.mcc     // Catch:{ all -> 0x0af4 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0af4 }
            r3.put(r4, r5)     // Catch:{ all -> 0x0af4 }
            java.lang.String r4 = "mnc"
            android.content.res.Resources r2 = r2.getResources()     // Catch:{ all -> 0x0af4 }
            android.content.res.Configuration r2 = r2.getConfiguration()     // Catch:{ all -> 0x0af4 }
            int r2 = r2.mnc     // Catch:{ all -> 0x0af4 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0af4 }
            r3.put(r4, r2)     // Catch:{ all -> 0x0af4 }
            java.lang.String r2 = "cell"
            r1.put(r2, r3)     // Catch:{ all -> 0x0af4 }
            java.lang.String r2 = "sig"
            r3 = r21
            android.app.Application r4 = r3.AFKeystoreWrapper     // Catch:{ all -> 0x0af4 }
            android.content.pm.PackageManager r4 = r4.getPackageManager()     // Catch:{ all -> 0x0af4 }
            android.app.Application r3 = r3.AFKeystoreWrapper     // Catch:{ all -> 0x0af4 }
            java.lang.String r3 = r3.getPackageName()     // Catch:{ all -> 0x0af4 }
            java.lang.String r3 = com.appsflyer.internal.AFa1dSDK.AFKeystoreWrapper((android.content.pm.PackageManager) r4, (java.lang.String) r3)     // Catch:{ all -> 0x0af4 }
            r1.put(r2, r3)     // Catch:{ all -> 0x0af4 }
            java.lang.String r2 = "last_boot_time"
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0af4 }
            long r5 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0af4 }
            long r3 = r3 - r5
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x0af4 }
            r1.put(r2, r3)     // Catch:{ all -> 0x0af4 }
            java.lang.String r2 = "disk"
            android.os.StatFs r3 = new android.os.StatFs     // Catch:{ all -> 0x0af4 }
            java.io.File r4 = android.os.Environment.getDataDirectory()     // Catch:{ all -> 0x0af4 }
            java.lang.String r4 = r4.getAbsolutePath()     // Catch:{ all -> 0x0af4 }
            r3.<init>(r4)     // Catch:{ all -> 0x0af4 }
            long r4 = r3.getBlockSizeLong()     // Catch:{ all -> 0x0af4 }
            long r6 = r3.getAvailableBlocksLong()     // Catch:{ all -> 0x0af4 }
            long r6 = r6 * r4
            long r8 = r3.getBlockCountLong()     // Catch:{ all -> 0x0af4 }
            long r8 = r8 * r4
            r3 = 4611686018427387904(0x4000000000000000, double:2.0)
            r10 = 4626322717216342016(0x4034000000000000, double:20.0)
            double r3 = java.lang.Math.pow(r3, r10)     // Catch:{ all -> 0x0af4 }
            double r5 = (double) r6     // Catch:{ all -> 0x0af4 }
            double r5 = r5 / r3
            long r5 = (long) r5     // Catch:{ all -> 0x0af4 }
            double r7 = (double) r8     // Catch:{ all -> 0x0af4 }
            double r7 = r7 / r3
            long r3 = (long) r7     // Catch:{ all -> 0x0af4 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0af4 }
            r7.<init>()     // Catch:{ all -> 0x0af4 }
            r7.append(r5)     // Catch:{ all -> 0x0af4 }
            java.lang.String r5 = "/"
            r7.append(r5)     // Catch:{ all -> 0x0af4 }
            r7.append(r3)     // Catch:{ all -> 0x0af4 }
            java.lang.String r3 = r7.toString()     // Catch:{ all -> 0x0af4 }
            r1.put(r2, r3)     // Catch:{ all -> 0x0af4 }
            r2 = r34
            com.appsflyer.internal.AFa1fSDK r3 = r2.afRDLog     // Catch:{ all -> 0x0b09 }
            if (r3 == 0) goto L_0x0b1a
            java.lang.String[] r3 = r3.valueOf     // Catch:{ all -> 0x0b09 }
            if (r3 == 0) goto L_0x0b1a
            java.lang.String r4 = "sharing_filter"
            r1.put(r4, r3)     // Catch:{ all -> 0x0b09 }
            goto L_0x0b1a
        L_0x0af4:
            r0 = move-exception
        L_0x0af5:
            r2 = r34
            goto L_0x0b11
        L_0x0af8:
            r33 = r2
            r2 = r1
            r1 = r33
            java.lang.String r3 = "AppsFlyer dev key is missing!!! Please use  AppsFlyerLib.getInstance().setAppsFlyerKey(...) to set it. "
            com.appsflyer.AFLogger.afInfoLog(r3)     // Catch:{ all -> 0x0b09 }
            java.lang.String r3 = "AppsFlyer will not track this event."
            com.appsflyer.AFLogger.afInfoLog(r3)     // Catch:{ all -> 0x0b09 }
            r1 = 0
            return r1
        L_0x0b09:
            r0 = move-exception
            goto L_0x0b11
        L_0x0b0b:
            r0 = move-exception
            r33 = r2
            r2 = r1
            r1 = r33
        L_0x0b11:
            r3 = r0
        L_0x0b12:
            java.lang.String r4 = r3.getLocalizedMessage()
            r5 = 1
            com.appsflyer.AFLogger.afErrorLog(r4, r3, r5)
        L_0x0b1a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1zSDK.AFInAppEventType(com.appsflyer.internal.AFa1sSDK):java.util.Map");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001d, code lost:
        if (r5 != null) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        if ((r5 != null ? 'W' : 12) != 'W') goto L_0x0030;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0040  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void AFKeystoreWrapper(android.content.Context r4, java.lang.String r5, java.util.Map<java.lang.String, java.lang.Object> r6, java.lang.String r7, java.lang.String r8) {
        /*
            r3 = this;
            int r0 = getSdkVersion
            int r0 = r0 + 9
            int r1 = r0 % 128
            onPause = r1
            int r0 = r0 % 2
            if (r0 == 0) goto L_0x001d
            r0 = 23
            int r0 = r0 / 0
            r0 = 87
            if (r5 == 0) goto L_0x0016
            r1 = r0
            goto L_0x0018
        L_0x0016:
            r1 = 12
        L_0x0018:
            if (r1 == r0) goto L_0x001f
            goto L_0x0030
        L_0x001b:
            r4 = move-exception
            throw r4
        L_0x001d:
            if (r5 == 0) goto L_0x0030
        L_0x001f:
            java.lang.String r0 = r5.trim()
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x002a
            goto L_0x0030
        L_0x002a:
            com.appsflyer.internal.AFe1iSDK r0 = new com.appsflyer.internal.AFe1iSDK
            r0.<init>()
            goto L_0x0035
        L_0x0030:
            com.appsflyer.internal.AFe1bSDK r0 = new com.appsflyer.internal.AFe1bSDK
            r0.<init>()
        L_0x0035:
            r1 = 32
            if (r4 == 0) goto L_0x003b
            r2 = r1
            goto L_0x003d
        L_0x003b:
            r2 = 93
        L_0x003d:
            if (r2 == r1) goto L_0x0040
            goto L_0x0052
        L_0x0040:
            int r1 = onPause
            int r1 = r1 + 99
            int r2 = r1 % 128
            getSdkVersion = r2
            int r1 = r1 % 2
            android.content.Context r4 = r4.getApplicationContext()
            android.app.Application r4 = (android.app.Application) r4
            r0.AFKeystoreWrapper = r4
        L_0x0052:
            r0.afRDLog = r5
            r0.values = r6
            r0.afInfoLog = r7
            r0.AFInAppEventParameterName = r8
            r3.valueOf((com.appsflyer.internal.AFa1sSDK) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1zSDK.AFKeystoreWrapper(android.content.Context, java.lang.String, java.util.Map, java.lang.String, java.lang.String):void");
    }

    private static int AFInAppEventParameterName(SharedPreferences sharedPreferences) {
        int i10 = onPause + 103;
        getSdkVersion = i10 % 128;
        int i11 = i10 % 2;
        int AFInAppEventParameterName2 = AFInAppEventParameterName(sharedPreferences, "appsFlyerAdRevenueCount", true);
        int i12 = onPause + 31;
        getSdkVersion = i12 % 128;
        int i13 = i12 % 2;
        return AFInAppEventParameterName2;
    }

    private static boolean AFInAppEventParameterName(File file) {
        int i10 = getSdkVersion + 15;
        onPause = i10 % 128;
        if (!(i10 % 2 != 0)) {
            if (file != null) {
                if (file.exists()) {
                    return false;
                }
            }
            int i11 = onPause + 23;
            getSdkVersion = i11 % 128;
            int i12 = i11 % 2;
            return true;
        }
        throw null;
    }

    public final AFb1gSDK AFInAppEventParameterName(Context context) {
        AFb1bSDK aFb1bSDK = this.onResponseError;
        if (context != null) {
            aFb1bSDK.valueOf.values = context.getApplicationContext();
        }
        Context context2 = this.onResponseError.valueOf.values;
        if (context2 != null) {
            return new AFb1eSDK(AFInAppEventType(context2));
        }
        throw new IllegalStateException("Context must be set via setContext method before calling this dependency.");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0048, code lost:
        if (r3.length() == 0) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0055, code lost:
        if (r3.length() == 0) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0058, code lost:
        r6 = new java.util.ArrayList();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0063, code lost:
        if (r3.contains("&") == false) goto L_0x0073;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0065, code lost:
        r6 = new java.util.ArrayList(java.util.Arrays.asList(r3.split("&")));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0073, code lost:
        r6.add(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0076, code lost:
        r8 = new java.lang.StringBuilder();
        r6 = r6.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0083, code lost:
        if (r6.hasNext() == false) goto L_0x00e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0085, code lost:
        r9 = getSdkVersion + 113;
        onPause = r9 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008f, code lost:
        if ((r9 % 2) == 0) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0091, code lost:
        r9 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0093, code lost:
        r9 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0094, code lost:
        if (r9 != false) goto L_0x00d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0096, code lost:
        r9 = (java.lang.String) r6.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a0, code lost:
        if (r9.contains("access_token") == false) goto L_0x00a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a2, code lost:
        r6.remove();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ac, code lost:
        if (r8.length() == 0) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00ae, code lost:
        r10 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b0, code lost:
        r10 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b1, code lost:
        if (r10 == true) goto L_0x00d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00bb, code lost:
        if (r9.startsWith(net.bytebuddy.description.type.TypeDescription.Generic.OfWildcardType.SYMBOL) != false) goto L_0x00bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00bd, code lost:
        r11 = 28;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00bf, code lost:
        r11 = 27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00c1, code lost:
        if (r11 == 28) goto L_0x00c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00c4, code lost:
        r11 = getSdkVersion + 103;
        onPause = r11 % 128;
        r11 = r11 % 2;
        r8.append(net.bytebuddy.description.type.TypeDescription.Generic.OfWildcardType.SYMBOL);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d2, code lost:
        r8.append("&");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d5, code lost:
        r8.append(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00d9, code lost:
        ((java.lang.String) r6.next()).contains("access_token");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        throw null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        return r13.replace(r3, r8.toString());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String values(java.lang.String r13) {
        /*
            int r0 = onPause
            int r0 = r0 + 45
            int r1 = r0 % 128
            getSdkVersion = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 == 0) goto L_0x00ee
            if (r13 != 0) goto L_0x0010
            return r1
        L_0x0010:
            java.lang.String r0 = "fb\\d*?://authorize.*"
            boolean r0 = r13.matches(r0)
            if (r0 == 0) goto L_0x00ed
            int r0 = getSdkVersion
            r2 = 23
            int r0 = r0 + r2
            int r3 = r0 % 128
            onPause = r3
            int r0 = r0 % 2
            java.lang.String r0 = "access_token"
            boolean r3 = r13.contains(r0)
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L_0x002f
            r3 = r4
            goto L_0x0030
        L_0x002f:
            r3 = r5
        L_0x0030:
            if (r3 == 0) goto L_0x00ed
            int r3 = onPause
            int r3 = r3 + 43
            int r6 = r3 % 128
            getSdkVersion = r6
            int r3 = r3 % 2
            if (r3 != 0) goto L_0x004d
            java.lang.String r3 = valueOf((java.lang.String) r13)
            int r6 = r3.length()
            r7 = 7
            int r7 = r7 / r5
            if (r6 != 0) goto L_0x0058
            goto L_0x0057
        L_0x004b:
            r13 = move-exception
            throw r13
        L_0x004d:
            java.lang.String r3 = valueOf((java.lang.String) r13)
            int r6 = r3.length()
            if (r6 != 0) goto L_0x0058
        L_0x0057:
            return r13
        L_0x0058:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.lang.String r7 = "&"
            boolean r8 = r3.contains(r7)
            if (r8 == 0) goto L_0x0073
            java.util.ArrayList r6 = new java.util.ArrayList
            java.lang.String[] r8 = r3.split(r7)
            java.util.List r8 = java.util.Arrays.asList(r8)
            r6.<init>(r8)
            goto L_0x0076
        L_0x0073:
            r6.add(r3)
        L_0x0076:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.util.Iterator r6 = r6.iterator()
        L_0x007f:
            boolean r9 = r6.hasNext()
            if (r9 == 0) goto L_0x00e5
            int r9 = getSdkVersion
            int r9 = r9 + 113
            int r10 = r9 % 128
            onPause = r10
            int r9 = r9 % 2
            if (r9 == 0) goto L_0x0093
            r9 = r4
            goto L_0x0094
        L_0x0093:
            r9 = r5
        L_0x0094:
            if (r9 != 0) goto L_0x00d9
            java.lang.Object r9 = r6.next()
            java.lang.String r9 = (java.lang.String) r9
            boolean r10 = r9.contains(r0)
            if (r10 == 0) goto L_0x00a6
            r6.remove()
            goto L_0x007f
        L_0x00a6:
            int r10 = r8.length()
            r11 = 34
            if (r10 == 0) goto L_0x00b0
            r10 = r11
            goto L_0x00b1
        L_0x00b0:
            r10 = r2
        L_0x00b1:
            if (r10 == r11) goto L_0x00d2
            java.lang.String r10 = "?"
            boolean r11 = r9.startsWith(r10)
            r12 = 28
            if (r11 != 0) goto L_0x00bf
            r11 = r12
            goto L_0x00c1
        L_0x00bf:
            r11 = 27
        L_0x00c1:
            if (r11 == r12) goto L_0x00c4
            goto L_0x00d5
        L_0x00c4:
            int r11 = getSdkVersion
            int r11 = r11 + 103
            int r12 = r11 % 128
            onPause = r12
            int r11 = r11 % 2
            r8.append(r10)
            goto L_0x00d5
        L_0x00d2:
            r8.append(r7)
        L_0x00d5:
            r8.append(r9)
            goto L_0x007f
        L_0x00d9:
            java.lang.Object r13 = r6.next()
            java.lang.String r13 = (java.lang.String) r13
            r13.contains(r0)
            throw r1     // Catch:{ all -> 0x00e3 }
        L_0x00e3:
            r13 = move-exception
            throw r13
        L_0x00e5:
            java.lang.String r0 = r8.toString()
            java.lang.String r13 = r13.replace(r3, r0)
        L_0x00ed:
            return r13
        L_0x00ee:
            throw r1     // Catch:{ all -> 0x00ef }
        L_0x00ef:
            r13 = move-exception
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1zSDK.values(java.lang.String):java.lang.String");
    }

    public static int AFInAppEventParameterName(SharedPreferences sharedPreferences, boolean z10) {
        int i10 = getSdkVersion + 117;
        onPause = i10 % 128;
        boolean z11 = i10 % 2 != 0;
        int AFInAppEventParameterName2 = AFInAppEventParameterName(sharedPreferences, "appsFlyerCount", z10);
        if (z11) {
            int i11 = 9 / 0;
        }
        return AFInAppEventParameterName2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001f, code lost:
        if ((r6) != false) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0026, code lost:
        if (r6 != false) goto L_0x0028;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int AFInAppEventParameterName(android.content.SharedPreferences r4, java.lang.String r5, boolean r6) {
        /*
            int r0 = getSdkVersion
            int r0 = r0 + 43
            int r1 = r0 % 128
            onPause = r1
            int r0 = r0 % 2
            r1 = 24
            if (r0 == 0) goto L_0x0011
            r0 = 64
            goto L_0x0012
        L_0x0011:
            r0 = r1
        L_0x0012:
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L_0x0022
            int r0 = r4.getInt(r5, r3)
            if (r6 == 0) goto L_0x001e
            r6 = r3
            goto L_0x001f
        L_0x001e:
            r6 = r2
        L_0x001f:
            if (r6 == 0) goto L_0x003e
            goto L_0x0028
        L_0x0022:
            int r0 = r4.getInt(r5, r2)
            if (r6 == 0) goto L_0x003e
        L_0x0028:
            int r0 = r0 + r3
            android.content.SharedPreferences$Editor r4 = r4.edit()
            android.content.SharedPreferences$Editor r4 = r4.putInt(r5, r0)
            r4.apply()
            int r4 = onPause
            int r4 = r4 + 45
            int r5 = r4 % 128
            getSdkVersion = r5
            int r4 = r4 % 2
        L_0x003e:
            com.appsflyer.internal.AFb1uSDK r4 = com.appsflyer.internal.AFb1uSDK.AFInAppEventType()
            boolean r4 = r4.afDebugLog()
            if (r4 == 0) goto L_0x0075
            int r4 = getSdkVersion
            int r4 = r4 + r3
            int r5 = r4 % 128
            onPause = r5
            int r4 = r4 % 2
            if (r4 == 0) goto L_0x0055
            r4 = r3
            goto L_0x0056
        L_0x0055:
            r4 = r2
        L_0x0056:
            if (r4 == r3) goto L_0x0064
            com.appsflyer.internal.AFb1uSDK r4 = com.appsflyer.internal.AFb1uSDK.AFInAppEventType()
            java.lang.String r5 = java.lang.String.valueOf(r0)
            r4.values((java.lang.String) r5)
            goto L_0x0075
        L_0x0064:
            com.appsflyer.internal.AFb1uSDK r4 = com.appsflyer.internal.AFb1uSDK.AFInAppEventType()
            java.lang.String r5 = java.lang.String.valueOf(r0)
            r4.values((java.lang.String) r5)
            r4 = 10
            int r4 = r4 / r2
            goto L_0x0075
        L_0x0073:
            r4 = move-exception
            throw r4
        L_0x0075:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1zSDK.AFInAppEventParameterName(android.content.SharedPreferences, java.lang.String, boolean):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0046, code lost:
        if ((r1 == 1) != false) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0049, code lost:
        if (r1 == 1) goto L_0x004b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0058  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean AFKeystoreWrapper(com.appsflyer.internal.AFa1sSDK r5, android.content.SharedPreferences r6) {
        /*
            r4 = this;
            int r0 = getSdkVersion
            int r0 = r0 + 15
            int r1 = r0 % 128
            onPause = r1
            int r0 = r0 % 2
            r0 = 0
            int r1 = AFInAppEventParameterName((android.content.SharedPreferences) r6, (boolean) r0)
            r2 = 1
            if (r1 != r2) goto L_0x0022
            boolean r5 = r5 instanceof com.appsflyer.internal.AFe1hSDK
            if (r5 != 0) goto L_0x0022
            int r5 = onPause
            int r5 = r5 + 111
            int r3 = r5 % 128
            getSdkVersion = r3
            int r5 = r5 % 2
            r5 = r2
            goto L_0x0023
        L_0x0022:
            r5 = r0
        L_0x0023:
            java.lang.String r3 = "newGPReferrerSent"
            boolean r6 = r6.getBoolean(r3, r0)
            if (r6 != 0) goto L_0x002d
            r6 = r2
            goto L_0x002e
        L_0x002d:
            r6 = r0
        L_0x002e:
            if (r6 == 0) goto L_0x004d
            int r6 = onPause
            int r6 = r6 + 47
            int r3 = r6 % 128
            getSdkVersion = r3
            int r6 = r6 % 2
            if (r6 != 0) goto L_0x003e
            r6 = r2
            goto L_0x003f
        L_0x003e:
            r6 = r0
        L_0x003f:
            if (r6 == r2) goto L_0x0049
            if (r1 != r2) goto L_0x0045
            r6 = r2
            goto L_0x0046
        L_0x0045:
            r6 = r0
        L_0x0046:
            if (r6 == 0) goto L_0x004d
            goto L_0x004b
        L_0x0049:
            if (r1 != r2) goto L_0x004d
        L_0x004b:
            r6 = r2
            goto L_0x004e
        L_0x004d:
            r6 = r0
        L_0x004e:
            r1 = 13
            if (r6 != 0) goto L_0x0055
            r6 = 82
            goto L_0x0056
        L_0x0055:
            r6 = r1
        L_0x0056:
            if (r6 == r1) goto L_0x0064
            r6 = 81
            if (r5 == 0) goto L_0x005f
            r5 = 17
            goto L_0x0060
        L_0x005f:
            r5 = r6
        L_0x0060:
            if (r5 == r6) goto L_0x0063
            goto L_0x0064
        L_0x0063:
            return r0
        L_0x0064:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1zSDK.AFKeystoreWrapper(com.appsflyer.internal.AFa1sSDK, android.content.SharedPreferences):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0045, code lost:
        if (r6 != 3) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0058, code lost:
        if (r6 != 3) goto L_0x0066;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void valueOf(android.content.Context r6, java.util.Map<java.lang.String, java.lang.Object> r7) {
        /*
            int r0 = getSdkVersion
            int r0 = r0 + 85
            int r1 = r0 % 128
            onPause = r1
            r1 = 2
            int r0 = r0 % r1
            java.lang.String r0 = "window"
            java.lang.Object r6 = r6.getSystemService(r0)
            android.view.WindowManager r6 = (android.view.WindowManager) r6
            r0 = 10
            if (r6 == 0) goto L_0x0019
            r2 = 81
            goto L_0x001a
        L_0x0019:
            r2 = r0
        L_0x001a:
            if (r2 == r0) goto L_0x006b
            int r0 = onPause
            int r0 = r0 + 51
            int r2 = r0 % 128
            getSdkVersion = r2
            int r0 = r0 % r1
            r2 = 42
            if (r0 != 0) goto L_0x002c
            r0 = 40
            goto L_0x002d
        L_0x002c:
            r0 = r2
        L_0x002d:
            r3 = 3
            r4 = 1
            java.lang.String r5 = ""
            if (r0 == r2) goto L_0x004a
            android.view.Display r6 = r6.getDefaultDisplay()
            int r6 = r6.getRotation()
            r0 = 22
            int r0 = r0 / 0
            if (r6 == 0) goto L_0x0064
            if (r6 == r4) goto L_0x0061
            if (r6 == r1) goto L_0x005e
            if (r6 == r3) goto L_0x005b
            goto L_0x0066
        L_0x0048:
            r6 = move-exception
            throw r6
        L_0x004a:
            android.view.Display r6 = r6.getDefaultDisplay()
            int r6 = r6.getRotation()
            if (r6 == 0) goto L_0x0064
            if (r6 == r4) goto L_0x0061
            if (r6 == r1) goto L_0x005e
            if (r6 == r3) goto L_0x005b
            goto L_0x0066
        L_0x005b:
            java.lang.String r5 = "lr"
            goto L_0x0066
        L_0x005e:
            java.lang.String r5 = "pr"
            goto L_0x0066
        L_0x0061:
            java.lang.String r5 = "l"
            goto L_0x0066
        L_0x0064:
            java.lang.String r5 = "p"
        L_0x0066:
            java.lang.String r6 = "sc_o"
            r7.put(r6, r5)
        L_0x006b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1zSDK.valueOf(android.content.Context, java.util.Map):void");
    }

    public static Map<String, Object> AFKeystoreWrapper(Map<String, Object> map) {
        Map<String, Object> map2;
        int i10 = onPause + 47;
        getSdkVersion = i10 % 128;
        int i11 = i10 % 2;
        if (!(!map.containsKey("meta"))) {
            int i12 = onPause + 53;
            getSdkVersion = i12 % 128;
            int i13 = i12 % 2;
            map2 = (Map) map.get("meta");
        } else {
            HashMap hashMap = new HashMap();
            map.put("meta", hashMap);
            map2 = hashMap;
        }
        int i14 = getSdkVersion + 27;
        onPause = i14 % 128;
        int i15 = i14 % 2;
        return map2;
    }

    private static void AFInAppEventParameterName(@NonNull ScheduledExecutorService scheduledExecutorService, Runnable runnable, long j10, TimeUnit timeUnit) {
        int i10 = onPause + 69;
        getSdkVersion = i10 % 128;
        int i11 = i10 % 2;
        try {
            scheduledExecutorService.schedule(runnable, j10, timeUnit);
            int i12 = getSdkVersion + 123;
            onPause = i12 % 128;
            int i13 = i12 % 2;
        } catch (RejectedExecutionException e10) {
            AFLogger.afErrorLog("scheduleJob failed with RejectedExecutionException Exception", e10);
        } catch (Throwable th2) {
            AFLogger.afErrorLog("scheduleJob failed with Exception", th2);
        }
    }

    public static void AFKeystoreWrapper(Context context, Map<String, ? super String> map) {
        String str;
        int i10 = getSdkVersion + 121;
        onPause = i10 % 128;
        int i11 = i10 % 2;
        boolean z10 = false;
        boolean AFInAppEventParameterName2 = AFInAppEventParameterName(AppsFlyerProperties.DISABLE_NETWORK_DATA, false);
        AFa1gSDK aFa1gSDK = AFa1gSDK.AFa1vSDK.AFInAppEventType;
        AFa1gSDK.AFa1xSDK AFInAppEventType2 = AFa1gSDK.AFInAppEventType(context);
        map.put("network", AFInAppEventType2.AFKeystoreWrapper);
        if ((!AFInAppEventParameterName2 ? SignatureVisitor.SUPER : '[') != '[') {
            int i12 = onPause + 27;
            getSdkVersion = i12 % 128;
            if ((i12 % 2 == 0 ? 31 : 'Q') != 31) {
                String str2 = AFInAppEventType2.AFInAppEventType;
                if (!(str2 == null)) {
                    map.put("operator", str2);
                }
            } else {
                throw null;
            }
        }
        if (AFInAppEventParameterName2) {
            z10 = true;
        }
        if (!z10 && (str = AFInAppEventType2.values) != null) {
            map.put("carrier", str);
        }
        int i13 = getSdkVersion + 83;
        onPause = i13 % 128;
        int i14 = i13 % 2;
    }

    private static void valueOf(Context context, boolean z10, Map<String, Object> map, int i10) {
        HashMap hashMap = new HashMap();
        hashMap.put("cpu_abi", AFKeystoreWrapper("ro.product.cpu.abi"));
        hashMap.put("cpu_abi2", AFKeystoreWrapper("ro.product.cpu.abi2"));
        hashMap.put("arch", AFKeystoreWrapper("os.arch"));
        hashMap.put("build_display_id", AFKeystoreWrapper("ro.build.display.id"));
        if (z10) {
            int i11 = onPause + 93;
            getSdkVersion = i11 % 128;
            int i12 = i11 % 2;
            AFInAppEventParameterName(context, (Map<String, Object>) hashMap);
            if ((i10 <= 2 ? '>' : 13) == '>') {
                hashMap.putAll(AFa1eSDK.valueOf(context).AFInAppEventParameterName());
                int i13 = onPause + 85;
                getSdkVersion = i13 % 128;
                int i14 = i13 % 2;
            }
        }
        hashMap.put("dim", AFc1rSDK.values(context));
        map.put("deviceData", hashMap);
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x007a A[SYNTHETIC, Splitter:B:35:0x007a] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0082  */
    @androidx.annotation.NonNull
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String AFInAppEventParameterName(java.net.HttpURLConnection r11) {
        /*
            java.lang.String r0 = "readServerResponse error"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r2 = 0
            r3 = 1
            r4 = 0
            java.io.InputStream r5 = r11.getErrorStream()     // Catch:{ all -> 0x005d }
            if (r5 != 0) goto L_0x0012
            r6 = r3
            goto L_0x0013
        L_0x0012:
            r6 = r4
        L_0x0013:
            if (r6 == 0) goto L_0x0019
            java.io.InputStream r5 = r11.getInputStream()     // Catch:{ all -> 0x005d }
        L_0x0019:
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ all -> 0x005d }
            r6.<init>(r5)     // Catch:{ all -> 0x005d }
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ all -> 0x005b }
            r5.<init>(r6)     // Catch:{ all -> 0x005b }
            r2 = r4
        L_0x0024:
            java.lang.String r7 = r5.readLine()     // Catch:{ all -> 0x0056 }
            r8 = 20
            if (r7 == 0) goto L_0x002f
            r9 = 66
            goto L_0x0030
        L_0x002f:
            r9 = r8
        L_0x0030:
            if (r9 == r8) goto L_0x004f
            if (r2 == 0) goto L_0x0045
            r2 = 10
            java.lang.Character r2 = java.lang.Character.valueOf(r2)     // Catch:{ all -> 0x0056 }
            int r8 = onPause
            int r8 = r8 + 123
            int r9 = r8 % 128
            getSdkVersion = r9
            int r8 = r8 % 2
            goto L_0x0047
        L_0x0045:
            java.lang.String r2 = ""
        L_0x0047:
            r1.append(r2)     // Catch:{ all -> 0x0056 }
            r1.append(r7)     // Catch:{ all -> 0x0056 }
            r2 = r3
            goto L_0x0024
        L_0x004f:
            r5.close()     // Catch:{ all -> 0x007e }
            r6.close()     // Catch:{ all -> 0x007e }
            goto L_0x009b
        L_0x0056:
            r2 = move-exception
            r10 = r5
            r5 = r2
            r2 = r10
            goto L_0x005f
        L_0x005b:
            r5 = move-exception
            goto L_0x005f
        L_0x005d:
            r5 = move-exception
            r6 = r2
        L_0x005f:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ca }
            java.lang.String r8 = "Could not read connection response from: "
            r7.<init>(r8)     // Catch:{ all -> 0x00ca }
            java.net.URL r11 = r11.getURL()     // Catch:{ all -> 0x00ca }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x00ca }
            r7.append(r11)     // Catch:{ all -> 0x00ca }
            java.lang.String r11 = r7.toString()     // Catch:{ all -> 0x00ca }
            com.appsflyer.AFLogger.afErrorLog(r11, r5)     // Catch:{ all -> 0x00ca }
            if (r2 == 0) goto L_0x0080
            r2.close()     // Catch:{ all -> 0x007e }
            goto L_0x0080
        L_0x007e:
            r11 = move-exception
            goto L_0x0098
        L_0x0080:
            if (r6 == 0) goto L_0x009b
            int r11 = getSdkVersion
            int r11 = r11 + 101
            int r2 = r11 % 128
            onPause = r2
            int r11 = r11 % 2
            if (r11 == 0) goto L_0x0094
            r6.close()     // Catch:{ all -> 0x007e }
            r11 = 7
            int r11 = r11 / r4
            goto L_0x009b
        L_0x0094:
            r6.close()     // Catch:{ all -> 0x007e }
            goto L_0x009b
        L_0x0098:
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r0, r11)
        L_0x009b:
            java.lang.String r11 = r1.toString()
            org.json.b r0 = new org.json.b     // Catch:{ JSONException -> 0x00a5 }
            r0.<init>((java.lang.String) r11)     // Catch:{ JSONException -> 0x00a5 }
            return r11
        L_0x00a5:
            r0 = move-exception
            java.lang.String r1 = "error while parsing readServerResponse"
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r1, r0)
            org.json.b r0 = new org.json.b
            r0.<init>()
            java.lang.String r1 = "string_response"
            r0.put((java.lang.String) r1, (java.lang.Object) r11)     // Catch:{ JSONException -> 0x00ba }
            java.lang.String r11 = r0.toString()     // Catch:{ JSONException -> 0x00ba }
            return r11
        L_0x00ba:
            r11 = move-exception
            java.lang.String r0 = "RESPONSE_NOT_JSON error"
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r0, r11)
            org.json.b r11 = new org.json.b
            r11.<init>()
            java.lang.String r11 = r11.toString()
            return r11
        L_0x00ca:
            r11 = move-exception
            if (r2 == 0) goto L_0x00d3
            r2.close()     // Catch:{ all -> 0x00d1 }
            goto L_0x00d3
        L_0x00d1:
            r1 = move-exception
            goto L_0x00e7
        L_0x00d3:
            if (r6 == 0) goto L_0x00d6
            goto L_0x00d7
        L_0x00d6:
            r4 = r3
        L_0x00d7:
            if (r4 == r3) goto L_0x00ea
            r6.close()     // Catch:{ all -> 0x00d1 }
            int r0 = getSdkVersion
            int r0 = r0 + 53
            int r1 = r0 % 128
            onPause = r1
            int r0 = r0 % 2
            goto L_0x00ea
        L_0x00e7:
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r0, r1)
        L_0x00ea:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1zSDK.AFInAppEventParameterName(java.net.HttpURLConnection):java.lang.String");
    }

    private static String AFKeystoreWrapper(String str) {
        Object invoke;
        Class<String> cls = String.class;
        int i10 = onPause + 105;
        getSdkVersion = i10 % 128;
        if ((i10 % 2 == 0 ? 'a' : '5') != 'a') {
            try {
                invoke = Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{cls}).invoke((Object) null, new Object[]{str});
            } catch (Throwable th2) {
                AFLogger.afErrorLog(th2.getMessage(), th2);
                return null;
            }
        } else {
            Class<?> cls2 = Class.forName("android.os.SystemProperties");
            Class[] clsArr = new Class[0];
            clsArr[0] = cls;
            Method method = cls2.getMethod("get", clsArr);
            Object[] objArr = new Object[0];
            objArr[1] = str;
            invoke = method.invoke((Object) null, objArr);
        }
        return (String) invoke;
    }

    private static String valueOf(Activity activity) {
        String str = null;
        if (activity != null) {
            int i10 = onPause + 79;
            getSdkVersion = i10 % 128;
            boolean z10 = false;
            if (i10 % 2 != 0) {
                Intent intent = activity.getIntent();
                if (intent != null) {
                    z10 = true;
                }
                if (z10) {
                    try {
                        Bundle extras = intent.getExtras();
                        if (extras != null) {
                            String string = extras.getString("af");
                            if (string != null) {
                                int i11 = getSdkVersion + 87;
                                onPause = i11 % 128;
                                if ((i11 % 2 != 0 ? '\\' : 'P') == 'P') {
                                    try {
                                        AFLogger.afInfoLog("Push Notification received af payload = ".concat(string));
                                        extras.remove("af");
                                        activity.setIntent(intent.putExtras(extras));
                                    } catch (Throwable th2) {
                                        th = th2;
                                        str = string;
                                        AFLogger.afErrorLog(th.getMessage(), th);
                                        int i12 = getSdkVersion + 119;
                                        onPause = i12 % 128;
                                        int i13 = i12 % 2;
                                        return str;
                                    }
                                } else {
                                    AFLogger.afInfoLog("Push Notification received af payload = ".concat(string));
                                    extras.remove("af");
                                    activity.setIntent(intent.putExtras(extras));
                                    throw null;
                                }
                            }
                            str = string;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        AFLogger.afErrorLog(th.getMessage(), th);
                        int i122 = getSdkVersion + 119;
                        onPause = i122 % 128;
                        int i132 = i122 % 2;
                        return str;
                    }
                }
            } else {
                activity.getIntent();
                throw null;
            }
        }
        int i1222 = getSdkVersion + 119;
        onPause = i1222 % 128;
        int i1322 = i1222 % 2;
        return str;
    }

    public static boolean values(Context context) {
        try {
            if (c.p().i(context) != 0) {
                int i10 = getSdkVersion + 47;
                onPause = i10 % 128;
                int i11 = i10 % 2;
                try {
                    context.getPackageManager().getPackageInfo("com.google.android.gms", 0);
                    return true;
                } catch (PackageManager.NameNotFoundException e10) {
                    AFLogger.afErrorLog("WARNING:  Google Play Services is unavailable. ", e10);
                    return false;
                }
            } else {
                int i12 = onPause + 77;
                getSdkVersion = i12 % 128;
                int i13 = i12 % 2;
                return true;
            }
        } catch (Throwable th2) {
            AFLogger.afErrorLog("WARNING:  Google play services is unavailable. ", th2);
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0061 */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0049 A[SYNTHETIC, Splitter:B:27:0x0049] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:24:0x0040=Splitter:B:24:0x0040, B:35:0x0061=Splitter:B:35:0x0061} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String AFKeystoreWrapper(java.io.File r4, java.lang.String r5) {
        /*
            r0 = 0
            java.util.Properties r1 = new java.util.Properties     // Catch:{ FileNotFoundException -> 0x0060, all -> 0x003e }
            r1.<init>()     // Catch:{ FileNotFoundException -> 0x0060, all -> 0x003e }
            java.io.FileReader r2 = new java.io.FileReader     // Catch:{ FileNotFoundException -> 0x0060, all -> 0x003e }
            r2.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0060, all -> 0x003e }
            r1.load(r2)     // Catch:{ FileNotFoundException -> 0x0061, all -> 0x003c }
            java.lang.String r3 = "Found PreInstall property!"
            com.appsflyer.AFLogger.afInfoLog(r3)     // Catch:{ FileNotFoundException -> 0x0061, all -> 0x003c }
            java.lang.String r4 = r1.getProperty(r5)     // Catch:{ FileNotFoundException -> 0x0061, all -> 0x003c }
            r2.close()     // Catch:{ all -> 0x001b }
            goto L_0x0023
        L_0x001b:
            r5 = move-exception
            java.lang.String r0 = r5.getMessage()
            com.appsflyer.AFLogger.afErrorLog(r0, r5)
        L_0x0023:
            int r5 = getSdkVersion
            int r5 = r5 + 27
            int r0 = r5 % 128
            onPause = r0
            int r5 = r5 % 2
            r0 = 0
            if (r5 == 0) goto L_0x0032
            r5 = r0
            goto L_0x0033
        L_0x0032:
            r5 = 1
        L_0x0033:
            if (r5 == 0) goto L_0x0036
            return r4
        L_0x0036:
            r5 = 60
            int r5 = r5 / r0
            return r4
        L_0x003a:
            r4 = move-exception
            throw r4
        L_0x003c:
            r4 = move-exception
            goto L_0x0040
        L_0x003e:
            r4 = move-exception
            r2 = r0
        L_0x0040:
            java.lang.String r5 = r4.getMessage()     // Catch:{ all -> 0x0085 }
            com.appsflyer.AFLogger.afErrorLog(r5, r4)     // Catch:{ all -> 0x0085 }
            if (r2 == 0) goto L_0x0084
            r2.close()     // Catch:{ all -> 0x0057 }
            int r4 = onPause
            int r4 = r4 + 101
            int r5 = r4 % 128
            getSdkVersion = r5
        L_0x0054:
            int r4 = r4 % 2
            goto L_0x0084
        L_0x0057:
            r4 = move-exception
            java.lang.String r5 = r4.getMessage()
            com.appsflyer.AFLogger.afErrorLog(r5, r4)
            goto L_0x0084
        L_0x0060:
            r2 = r0
        L_0x0061:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0085 }
            java.lang.String r1 = "PreInstall file wasn't found: "
            r5.<init>(r1)     // Catch:{ all -> 0x0085 }
            java.lang.String r4 = r4.getAbsolutePath()     // Catch:{ all -> 0x0085 }
            r5.append(r4)     // Catch:{ all -> 0x0085 }
            java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x0085 }
            com.appsflyer.AFLogger.afDebugLog(r4)     // Catch:{ all -> 0x0085 }
            if (r2 == 0) goto L_0x0084
            r2.close()     // Catch:{ all -> 0x0057 }
            int r4 = getSdkVersion
            int r4 = r4 + 119
            int r5 = r4 % 128
            onPause = r5
            goto L_0x0054
        L_0x0084:
            return r0
        L_0x0085:
            r4 = move-exception
            if (r2 == 0) goto L_0x0094
            r2.close()     // Catch:{ all -> 0x008c }
            goto L_0x0094
        L_0x008c:
            r5 = move-exception
            java.lang.String r0 = r5.getMessage()
            com.appsflyer.AFLogger.afErrorLog(r0, r5)
        L_0x0094:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1zSDK.AFKeystoreWrapper(java.io.File, java.lang.String):java.lang.String");
    }

    private void values(Context context, Map<String, Object> map) {
        AppsFlyerProperties instance = AppsFlyerProperties.getInstance();
        if (instance.getBoolean(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, false)) {
            map.put(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            return;
        }
        Context context2 = this.onResponseError.valueOf.values;
        if (context2 != null) {
            AFb1eSDK aFb1eSDK = new AFb1eSDK(AFInAppEventType(context2));
            String AFInAppEventType2 = this.onResponseError.AFVersionDeclaration().AFInAppEventType(aFb1eSDK);
            if (!AFb1nSDK.AFInAppEventParameterName(AFInAppEventType2)) {
                map.put("imei", AFInAppEventType2);
            }
            boolean z10 = instance.getBoolean(AppsFlyerProperties.COLLECT_ANDROID_ID, false);
            String str = null;
            String valueOf2 = aFb1eSDK.valueOf("androidIdCached", (String) null);
            if (!z10 || !AFb1nSDK.AFInAppEventParameterName(this.afDebugLog)) {
                String str2 = this.afDebugLog;
                if (str2 != null) {
                    str = str2;
                }
            } else if (afInfoLog(context)) {
                try {
                    String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
                    if (string != null) {
                        str = string;
                    } else if (valueOf2 != null) {
                        AFLogger.afDebugLog("use cached AndroidId: ".concat(valueOf2));
                        str = valueOf2;
                    }
                } catch (Exception e10) {
                    if (valueOf2 != null) {
                        AFLogger.afDebugLog("use cached AndroidId: ".concat(valueOf2));
                        str = valueOf2;
                    }
                    AFLogger.afErrorLog(e10.getMessage(), e10);
                }
            }
            if (str != null) {
                aFb1eSDK.AFInAppEventParameterName("androidIdCached", str);
                map.put("android_id", str);
            } else {
                AFLogger.afInfoLog("Android ID was not collected.");
            }
            AFc1vSDK.AFa1wSDK values2 = AFa1bSDK.values(context);
            if (values2 != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("isManual", values2.values);
                hashMap.put("val", values2.AFInAppEventType);
                Boolean bool = values2.valueOf;
                if (bool != null) {
                    hashMap.put("isLat", bool);
                }
                map.put("oaid", hashMap);
                return;
            }
            return;
        }
        throw new IllegalStateException("Context must be set via setContext method before calling this dependency.");
    }

    public final void valueOf(Context context, Map<String, Object> map, Uri uri) {
        AFb1bSDK aFb1bSDK = this.onResponseError;
        if (context != null) {
            AFc1ySDK aFc1ySDK = aFb1bSDK.valueOf;
            if (context != null) {
                int i10 = onPause + 81;
                getSdkVersion = i10 % 128;
                if (i10 % 2 == 0) {
                    aFc1ySDK.values = context.getApplicationContext();
                    int i11 = 87 / 0;
                } else {
                    aFc1ySDK.values = context.getApplicationContext();
                }
            }
        }
        if ((!map.containsKey("af_deeplink") ? 'b' : '\'') == 'b') {
            int i12 = onPause + 75;
            getSdkVersion = i12 % 128;
            int i13 = i12 % 2;
            String values2 = values(uri.toString());
            AFa1qSDK AFInAppEventParameterName2 = AFa1qSDK.AFInAppEventParameterName();
            String str = AFInAppEventParameterName2.valueOf;
            if (str != null) {
                if (AFInAppEventParameterName2.afErrorLog != null) {
                    if (!(!values2.contains(str))) {
                        Uri.Builder buildUpon = Uri.parse(values2).buildUpon();
                        Uri.Builder buildUpon2 = Uri.EMPTY.buildUpon();
                        Iterator<Map.Entry<String, String>> it = AFInAppEventParameterName2.afErrorLog.entrySet().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            int i14 = getSdkVersion + 97;
                            onPause = i14 % 128;
                            int i15 = i14 % 2;
                            Map.Entry next = it.next();
                            buildUpon.appendQueryParameter((String) next.getKey(), (String) next.getValue());
                            buildUpon2.appendQueryParameter((String) next.getKey(), (String) next.getValue());
                        }
                        values2 = buildUpon.build().toString();
                        map.put("appended_query_params", buildUpon2.build().getEncodedQuery());
                    }
                }
            }
            map.put("af_deeplink", values2);
            int i16 = onPause + 81;
            getSdkVersion = i16 % 128;
            int i17 = i16 % 2;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("link", uri.toString());
        AFd1hSDK aFd1hSDK = new AFd1hSDK(AFInAppEventParameterName(), UUID.randomUUID(), uri);
        if ((aFd1hSDK.AFLogger$LogLevel() ? '!' : 24) == '!') {
            map.put("isBrandedDomain", Boolean.TRUE);
        }
        AFa1dSDK.AFKeystoreWrapper(context, hashMap, uri);
        if (aFd1hSDK.afWarnLog()) {
            aFd1hSDK.AFLogger = valueOf((Map<String, String>) hashMap);
            AFd1xSDK afDebugLog2 = this.onResponseError.afDebugLog();
            afDebugLog2.AFKeystoreWrapper.execute(new Runnable(aFd1hSDK) {
                private /* synthetic */ AFd1tSDK AFInAppEventParameterName;

                /*  JADX ERROR: Method generation error
                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFd1xSDK.2.run():void, class status: UNLOADED
                    	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                    	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                    */
                /*  JADX ERROR: Method generation error: Method args not loaded: com.appsflyer.internal.AFd1xSDK.2.run():void, class status: UNLOADED
                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFd1xSDK.2.run():void, class status: UNLOADED
                    	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                    	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                    */
                public final void run(
/*
Method generation error in method: com.appsflyer.internal.AFd1xSDK.2.run():void, dex: classes.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFd1xSDK.2.run():void, class status: UNLOADED
                	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                
*/
            });
            return;
        }
        AFb1oSDK.AFInAppEventParameterName((Map<String, String>) hashMap);
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0198  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0214  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0220  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void AFInAppEventParameterName(com.appsflyer.internal.AFa1sSDK r13) {
        /*
            r12 = this;
            android.app.Application r0 = r13.AFKeystoreWrapper
            if (r0 != 0) goto L_0x000a
            java.lang.String r13 = "sendWithEvent - got null context. skipping event/launch."
            com.appsflyer.AFLogger.afDebugLog(r13)
            return
        L_0x000a:
            android.content.SharedPreferences r1 = AFInAppEventType((android.content.Context) r0)
            com.appsflyer.AppsFlyerProperties r2 = com.appsflyer.AppsFlyerProperties.getInstance()
            r2.saveProperties(r1)
            com.appsflyer.internal.AFb1bSDK r2 = r12.onResponseError
            com.appsflyer.internal.AFe1xSDK r2 = r2.AFVersionDeclaration()
            boolean r2 = r2.AFKeystoreWrapper()
            if (r2 != 0) goto L_0x003a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "sendWithEvent from activity: "
            r2.<init>(r3)
            java.lang.Class r3 = r0.getClass()
            java.lang.String r3 = r3.getName()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.appsflyer.AFLogger.afInfoLog(r2)
        L_0x003a:
            boolean r2 = r13.AFKeystoreWrapper()
            boolean r3 = r13 instanceof com.appsflyer.internal.AFe1kSDK
            boolean r4 = r13 instanceof com.appsflyer.internal.AFe1gSDK
            boolean r5 = r13 instanceof com.appsflyer.internal.AFe1hSDK
            java.util.Map r6 = r12.AFInAppEventType((com.appsflyer.internal.AFa1sSDK) r13)
            java.lang.String r7 = "appsflyerKey"
            java.lang.Object r7 = r6.get(r7)
            java.lang.String r7 = (java.lang.String) r7
            if (r7 == 0) goto L_0x0228
            int r7 = r7.length()
            r8 = 0
            r9 = 1
            if (r7 != 0) goto L_0x005c
            r7 = r9
            goto L_0x005d
        L_0x005c:
            r7 = r8
        L_0x005d:
            if (r7 == 0) goto L_0x0061
            goto L_0x0228
        L_0x0061:
            boolean r7 = r12.isStopped()
            r10 = 12
            if (r7 != 0) goto L_0x006c
            r7 = 28
            goto L_0x006d
        L_0x006c:
            r7 = r10
        L_0x006d:
            r11 = 2
            if (r7 == r10) goto L_0x007e
            int r7 = getSdkVersion
            int r7 = r7 + 91
            int r10 = r7 % 128
            onPause = r10
            int r7 = r7 % r11
            java.lang.String r7 = "AppsFlyerLib.sendWithEvent"
            com.appsflyer.AFLogger.afInfoLog(r7)
        L_0x007e:
            int r1 = AFInAppEventParameterName((android.content.SharedPreferences) r1, (boolean) r8)
            if (r5 != 0) goto L_0x0086
            r5 = r9
            goto L_0x0088
        L_0x0086:
            r5 = 42
        L_0x0088:
            r7 = 27
            if (r5 == r9) goto L_0x008d
            goto L_0x0098
        L_0x008d:
            int r5 = onPause
            int r5 = r5 + 41
            int r10 = r5 % 128
            getSdkVersion = r10
            int r5 = r5 % r11
            if (r4 == 0) goto L_0x00b6
        L_0x0098:
            java.lang.String r4 = afWarnLog
            java.lang.Object[] r5 = new java.lang.Object[r11]
            com.appsflyer.AppsFlyerLib r10 = com.appsflyer.AppsFlyerLib.getInstance()
            java.lang.String r10 = r10.getHostPrefix()
            r5[r8] = r10
            com.appsflyer.internal.AFb1zSDK r10 = AFInAppEventType()
            java.lang.String r10 = r10.getHostName()
            r5[r9] = r10
            java.lang.String r4 = java.lang.String.format(r4, r5)
            goto L_0x013f
        L_0x00b6:
            if (r3 == 0) goto L_0x00db
            int r10 = r10 + r7
            int r4 = r10 % 128
            onPause = r4
            int r10 = r10 % r11
            java.lang.String r4 = afErrorLog
            java.lang.Object[] r5 = new java.lang.Object[r11]
            com.appsflyer.AppsFlyerLib r10 = com.appsflyer.AppsFlyerLib.getInstance()
            java.lang.String r10 = r10.getHostPrefix()
            r5[r8] = r10
            com.appsflyer.internal.AFb1zSDK r10 = AFInAppEventType()
            java.lang.String r10 = r10.getHostName()
            r5[r9] = r10
            java.lang.String r4 = java.lang.String.format(r4, r5)
            goto L_0x013f
        L_0x00db:
            if (r2 == 0) goto L_0x00df
            r4 = r9
            goto L_0x00e0
        L_0x00df:
            r4 = r8
        L_0x00e0:
            if (r4 == r9) goto L_0x00ff
            java.lang.String r4 = getLevel
            java.lang.Object[] r5 = new java.lang.Object[r11]
            com.appsflyer.AppsFlyerLib r10 = com.appsflyer.AppsFlyerLib.getInstance()
            java.lang.String r10 = r10.getHostPrefix()
            r5[r8] = r10
            com.appsflyer.internal.AFb1zSDK r10 = AFInAppEventType()
            java.lang.String r10 = r10.getHostName()
            r5[r9] = r10
            java.lang.String r4 = java.lang.String.format(r4, r5)
            goto L_0x013f
        L_0x00ff:
            if (r1 >= r11) goto L_0x0103
            r4 = r8
            goto L_0x0104
        L_0x0103:
            r4 = r9
        L_0x0104:
            if (r4 == r9) goto L_0x0123
            java.lang.String r4 = AFVersionDeclaration
            java.lang.Object[] r5 = new java.lang.Object[r11]
            com.appsflyer.AppsFlyerLib r10 = com.appsflyer.AppsFlyerLib.getInstance()
            java.lang.String r10 = r10.getHostPrefix()
            r5[r8] = r10
            com.appsflyer.internal.AFb1zSDK r10 = AFInAppEventType()
            java.lang.String r10 = r10.getHostName()
            r5[r9] = r10
            java.lang.String r4 = java.lang.String.format(r4, r5)
            goto L_0x013f
        L_0x0123:
            java.lang.String r4 = AFLogger$LogLevel
            java.lang.Object[] r5 = new java.lang.Object[r11]
            com.appsflyer.AppsFlyerLib r10 = com.appsflyer.AppsFlyerLib.getInstance()
            java.lang.String r10 = r10.getHostPrefix()
            r5[r8] = r10
            com.appsflyer.internal.AFb1zSDK r10 = AFInAppEventType()
            java.lang.String r10 = r10.getHostName()
            r5[r9] = r10
            java.lang.String r4 = java.lang.String.format(r4, r5)
        L_0x013f:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            java.lang.String r4 = r0.getPackageName()
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            java.lang.String r0 = r12.valueOf((android.content.Context) r0)
            if (r3 != 0) goto L_0x0169
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r4)
            java.lang.String r4 = "&buildnumber=6.10.0"
            r3.append(r4)
            java.lang.String r4 = r3.toString()
        L_0x0169:
            if (r0 == 0) goto L_0x017f
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r4)
            java.lang.String r4 = "&channel="
            r3.append(r4)
            r3.append(r0)
            java.lang.String r4 = r3.toString()
        L_0x017f:
            r12.AFInAppEventParameterName((java.util.Map<java.lang.String, java.lang.Object>) r6)
            com.appsflyer.internal.AFb1zSDK$AFa1zSDK r0 = new com.appsflyer.internal.AFb1zSDK$AFa1zSDK
            com.appsflyer.internal.AFa1sSDK r13 = r13.AFInAppEventType((java.lang.String) r4)
            com.appsflyer.internal.AFa1sSDK r13 = r13.AFInAppEventType((java.util.Map<java.lang.String, ?>) r6)
            com.appsflyer.internal.AFa1sSDK r13 = r13.AFInAppEventParameterName((int) r1)
            r0.<init>(r12, r13, r8)
            r13 = 17
            if (r2 == 0) goto L_0x0198
            goto L_0x0199
        L_0x0198:
            r7 = r13
        L_0x0199:
            if (r7 == r13) goto L_0x020c
            int r13 = getSdkVersion
            int r13 = r13 + 5
            int r1 = r13 % 128
            onPause = r1
            int r13 = r13 % r11
            com.appsflyer.internal.AFf1uSDK[] r13 = r12.afRDLog()
            int r1 = r13.length
            r2 = r8
            r3 = r2
        L_0x01ab:
            r4 = 95
            if (r2 >= r1) goto L_0x01db
            int r5 = onPause
            int r5 = r5 + r4
            int r4 = r5 % 128
            getSdkVersion = r4
            int r5 = r5 % r11
            r4 = r13[r2]
            com.appsflyer.internal.AFf1uSDK$AFa1ySDK r5 = r4.afDebugLog
            com.appsflyer.internal.AFf1uSDK$AFa1ySDK r6 = com.appsflyer.internal.AFf1uSDK.AFa1ySDK.STARTED
            if (r5 != r6) goto L_0x01d8
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r5 = "Failed to get "
            r3.<init>(r5)
            java.lang.String r4 = r4.AFKeystoreWrapper
            r3.append(r4)
            java.lang.String r4 = " referrer, wait ..."
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.appsflyer.AFLogger.afDebugLog(r3)
            r3 = r9
        L_0x01d8:
            int r2 = r2 + 1
            goto L_0x01ab
        L_0x01db:
            boolean r13 = r12.onConversionDataFail
            if (r13 == 0) goto L_0x01e2
            r13 = 74
            goto L_0x01e3
        L_0x01e2:
            r13 = r4
        L_0x01e3:
            if (r13 == r4) goto L_0x01fa
            int r13 = getSdkVersion
            int r13 = r13 + 117
            int r1 = r13 % 128
            onPause = r1
            int r13 = r13 % r11
            boolean r13 = r12.afErrorLog()
            if (r13 != 0) goto L_0x01fa
            java.lang.String r13 = "fetching Facebook deferred AppLink data, wait ..."
            com.appsflyer.AFLogger.afDebugLog(r13)
            r3 = r9
        L_0x01fa:
            com.appsflyer.internal.AFb1bSDK r13 = r12.onResponseError
            com.appsflyer.internal.AFe1xSDK r13 = r13.AFVersionDeclaration()
            boolean r13 = r13.AFInAppEventType()
            if (r13 == 0) goto L_0x0207
            r8 = r9
        L_0x0207:
            if (r8 == r9) goto L_0x020b
            r8 = r3
            goto L_0x020c
        L_0x020b:
            r8 = r9
        L_0x020c:
            com.appsflyer.internal.AFb1bSDK r13 = r12.onResponseError
            java.util.concurrent.ScheduledExecutorService r13 = r13.AFInAppEventType()
            if (r8 == 0) goto L_0x0220
            int r1 = getSdkVersion
            int r1 = r1 + 29
            int r2 = r1 % 128
            onPause = r2
            int r1 = r1 % r11
            r1 = 500(0x1f4, double:2.47E-321)
            goto L_0x0222
        L_0x0220:
            r1 = 0
        L_0x0222:
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS
            AFInAppEventParameterName((java.util.concurrent.ScheduledExecutorService) r13, (java.lang.Runnable) r0, (long) r1, (java.util.concurrent.TimeUnit) r3)
            return
        L_0x0228:
            java.lang.String r0 = "Not sending data yet, waiting for dev key"
            com.appsflyer.AFLogger.afDebugLog(r0)
            com.appsflyer.attribution.AppsFlyerRequestListener r13 = r13.AFInAppEventType
            if (r13 == 0) goto L_0x0238
            int r0 = com.appsflyer.attribution.RequestError.NO_DEV_KEY
            java.lang.String r1 = com.appsflyer.internal.AFb1dSDK.AFKeystoreWrapper
            r13.onError(r0, r1)
        L_0x0238:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1zSDK.AFInAppEventParameterName(com.appsflyer.internal.AFa1sSDK):void");
    }

    public static String AFKeystoreWrapper(AFb1gSDK aFb1gSDK, String str) {
        int i10 = onPause + 43;
        getSdkVersion = i10 % 128;
        int i11 = i10 % 2;
        String valueOf2 = aFb1gSDK.valueOf("CACHED_CHANNEL", (String) null);
        if ((valueOf2 != null ? 30 : '0') != '0') {
            int i12 = getSdkVersion + 69;
            onPause = i12 % 128;
            int i13 = i12 % 2;
            return valueOf2;
        }
        aFb1gSDK.AFInAppEventParameterName("CACHED_CHANNEL", str);
        int i14 = onPause + 105;
        getSdkVersion = i14 % 128;
        if (!(i14 % 2 == 0)) {
            return str;
        }
        throw null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0035, code lost:
        if (afRDLog(r6) != false) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003f, code lost:
        if (afRDLog(r6) != false) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0051, code lost:
        r5 = getSdkVersion + 99;
        onPause = r5 % 128;
        r5 = r5 % 2;
        r5 = "";
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String values(java.text.SimpleDateFormat r5, android.content.Context r6) {
        /*
            r4 = this;
            int r0 = onPause
            int r0 = r0 + 119
            int r1 = r0 % 128
            getSdkVersion = r1
            int r0 = r0 % 2
            android.content.SharedPreferences r0 = AFInAppEventType((android.content.Context) r6)
            r1 = 0
            java.lang.String r2 = "appsFlyerFirstInstall"
            java.lang.String r0 = r0.getString(r2, r1)
            r1 = 44
            if (r0 != 0) goto L_0x001c
            r3 = 76
            goto L_0x001d
        L_0x001c:
            r3 = r1
        L_0x001d:
            if (r3 == r1) goto L_0x0068
            int r0 = getSdkVersion
            int r0 = r0 + 21
            int r1 = r0 % 128
            onPause = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 == 0) goto L_0x002e
            r0 = r1
            goto L_0x002f
        L_0x002e:
            r0 = 1
        L_0x002f:
            if (r0 == 0) goto L_0x0038
            boolean r0 = afRDLog(r6)
            if (r0 == 0) goto L_0x0051
            goto L_0x0041
        L_0x0038:
            boolean r0 = afRDLog(r6)
            r3 = 87
            int r3 = r3 / r1
            if (r0 == 0) goto L_0x0051
        L_0x0041:
            java.lang.String r0 = "AppsFlyer: first launch detected"
            com.appsflyer.AFLogger.afDebugLog(r0)
            java.util.Date r0 = new java.util.Date
            r0.<init>()
            java.lang.String r5 = r5.format(r0)
        L_0x004f:
            r0 = r5
            goto L_0x005e
        L_0x0051:
            int r5 = getSdkVersion
            int r5 = r5 + 99
            int r0 = r5 % 128
            onPause = r0
            int r5 = r5 % 2
            java.lang.String r5 = ""
            goto L_0x004f
        L_0x005e:
            com.appsflyer.internal.AFb1gSDK r5 = r4.AFInAppEventParameterName((android.content.Context) r6)
            r5.AFInAppEventParameterName((java.lang.String) r2, (java.lang.String) r0)
            goto L_0x0068
        L_0x0066:
            r5 = move-exception
            throw r5
        L_0x0068:
            java.lang.String r5 = java.lang.String.valueOf(r0)
            java.lang.String r6 = "AppsFlyer: first launch date: "
            java.lang.String r5 = r6.concat(r5)
            com.appsflyer.AFLogger.afInfoLog(r5)
            int r5 = getSdkVersion
            int r5 = r5 + 37
            int r6 = r5 % 128
            onPause = r6
            int r5 = r5 % 2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1zSDK.values(java.text.SimpleDateFormat, android.content.Context):java.lang.String");
    }

    private static String valueOf(String str) {
        int indexOf = str.indexOf(63);
        if (indexOf == -1) {
            int i10 = onPause + 111;
            getSdkVersion = i10 % 128;
            if ((i10 % 2 == 0 ? (char) 30 : 12) == 12) {
                return "";
            }
            throw null;
        }
        String substring = str.substring(indexOf);
        int i11 = getSdkVersion + 83;
        onPause = i11 % 128;
        if ((i11 % 2 != 0 ? '1' : 18) == 18) {
            return substring;
        }
        throw null;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0059  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void values(@androidx.annotation.NonNull com.appsflyer.internal.AFa1sSDK r7, android.app.Activity r8) {
        /*
            r6 = this;
            android.app.Application r0 = r7.AFKeystoreWrapper
            r1 = 0
            java.lang.String r2 = ""
            r3 = 1
            if (r8 == 0) goto L_0x0029
            android.content.Intent r4 = r8.getIntent()
            if (r4 == 0) goto L_0x0029
            int r4 = getSdkVersion
            int r4 = r4 + 103
            int r5 = r4 % 128
            onPause = r5
            int r4 = r4 % 2
            android.net.Uri r8 = com.appsflyer.internal.AFb1kSDK.values(r8)
            if (r8 == 0) goto L_0x0020
            r4 = r3
            goto L_0x0021
        L_0x0020:
            r4 = r1
        L_0x0021:
            if (r4 == r3) goto L_0x0024
            goto L_0x0029
        L_0x0024:
            java.lang.String r8 = r8.toString()
            goto L_0x002a
        L_0x0029:
            r8 = r2
        L_0x002a:
            com.appsflyer.internal.AFb1bSDK r4 = r6.onResponseError
            com.appsflyer.internal.AFe1xSDK r4 = r4.AFVersionDeclaration()
            java.lang.String r4 = r4.AFInAppEventType
            if (r4 != 0) goto L_0x0059
            java.lang.String r8 = "[LogEvent/Launch] AppsFlyer's SDK cannot send any event without providing DevKey."
            com.appsflyer.AFLogger.afWarnLog(r8)
            com.appsflyer.attribution.AppsFlyerRequestListener r7 = r7.AFInAppEventType
            if (r7 == 0) goto L_0x0058
            int r8 = getSdkVersion
            int r8 = r8 + 27
            int r0 = r8 % 128
            onPause = r0
            int r8 = r8 % 2
            if (r8 == 0) goto L_0x004a
            r1 = r3
        L_0x004a:
            int r8 = com.appsflyer.attribution.RequestError.NO_DEV_KEY
            java.lang.String r0 = com.appsflyer.internal.AFb1dSDK.AFKeystoreWrapper
            r7.onError(r8, r0)
            if (r1 != 0) goto L_0x0054
            goto L_0x0058
        L_0x0054:
            r7 = 0
            throw r7     // Catch:{ all -> 0x0056 }
        L_0x0056:
            r7 = move-exception
            throw r7
        L_0x0058:
            return
        L_0x0059:
            com.appsflyer.AppsFlyerProperties r1 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r0 = r1.getReferrer(r0)
            if (r0 != 0) goto L_0x0064
            goto L_0x0065
        L_0x0064:
            r2 = r0
        L_0x0065:
            r7.afInfoLog = r2
            r7.AFInAppEventParameterName = r8
            r6.valueOf((com.appsflyer.internal.AFa1sSDK) r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1zSDK.values(com.appsflyer.internal.AFa1sSDK, android.app.Activity):void");
    }

    private AFd1hSDK.AFa1zSDK valueOf(final Map<String, String> map) {
        AnonymousClass4 r02 = new AFd1hSDK.AFa1zSDK() {
            public final void AFInAppEventParameterName(String str) {
                AFb1oSDK.AFInAppEventType(str, DeepLinkResult.Error.NETWORK);
            }

            public final void AFInAppEventType(Map<String, String> map) {
                for (String next : map.keySet()) {
                    map.put(next, map.get(next));
                }
                AFb1oSDK.AFInAppEventParameterName((Map<String, String>) map);
            }
        };
        int i10 = onPause + 95;
        getSdkVersion = i10 % 128;
        if (i10 % 2 != 0) {
            return r02;
        }
        int i11 = 42 / 0;
        return r02;
    }

    private void valueOf(AFa1sSDK aFa1sSDK) {
        boolean z10;
        if ((aFa1sSDK.afRDLog == null ? 11 : '_') != 11) {
            z10 = false;
        } else {
            int i10 = onPause + 85;
            int i11 = i10 % 128;
            getSdkVersion = i11;
            int i12 = i10 % 2;
            int i13 = i11 + 37;
            onPause = i13 % 128;
            int i14 = i13 % 2;
            z10 = true;
        }
        if ((values() ? 19 : ':') != 19) {
            if (z10) {
                if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.LAUNCH_PROTECT_ENABLED, true)) {
                    int i15 = onPause + 15;
                    getSdkVersion = i15 % 128;
                    int i16 = i15 % 2;
                    if (afDebugLog()) {
                        int i17 = onPause + 71;
                        getSdkVersion = i17 % 128;
                        if (i17 % 2 != 0) {
                            AppsFlyerRequestListener appsFlyerRequestListener = aFa1sSDK.AFInAppEventType;
                            if (appsFlyerRequestListener != null) {
                                appsFlyerRequestListener.onError(RequestError.EVENT_TIMEOUT, AFb1dSDK.valueOf);
                                return;
                            }
                            return;
                        }
                        throw null;
                    }
                } else {
                    AFLogger.afInfoLog("Allowing multiple launches within a 5 second time window.");
                }
                this.onInstallConversionFailureNative = System.currentTimeMillis();
            }
            AFInAppEventParameterName(this.onResponseError.AFInAppEventType(), (Runnable) new AFa1xSDK(this, aFa1sSDK, (byte) 0), 0, TimeUnit.MILLISECONDS);
            return;
        }
        int i18 = onPause + 35;
        getSdkVersion = i18 % 128;
        int i19 = i18 % 2;
        AFLogger.afInfoLog("CustomerUserId not set, reporting is disabled", true);
    }

    private static void values(Map<String, Object> map, AFe1nSDK aFe1nSDK) {
        HashMap hashMap = new HashMap(aFe1nSDK.valueOf);
        aFe1nSDK.valueOf.clear();
        aFe1nSDK.AFInAppEventParameterName.AFKeystoreWrapper("gcd");
        if ((!hashMap.isEmpty() ? 5 : '3') != '3') {
            int i10 = getSdkVersion + 95;
            onPause = i10 % 128;
            int i11 = i10 % 2;
            AFKeystoreWrapper(map).put("gcd", hashMap);
        }
        int i12 = onPause + 91;
        getSdkVersion = i12 % 128;
        if ((i12 % 2 == 0 ? '6' : 26) != 26) {
            throw null;
        }
    }

    @Deprecated
    public final String valueOf(Context context) {
        int i10 = onPause + 11;
        int i11 = i10 % 128;
        getSdkVersion = i11;
        int i12 = i10 % 2;
        AFb1bSDK aFb1bSDK = this.onResponseError;
        if (context != null) {
            AFc1ySDK aFc1ySDK = aFb1bSDK.valueOf;
            int i13 = i11 + 63;
            onPause = i13 % 128;
            boolean z10 = i13 % 2 != 0;
            aFc1ySDK.values = context.getApplicationContext();
            if (z10) {
                throw null;
            }
        }
        return this.onResponseError.values().values();
    }

    private static void AFInAppEventParameterName(Context context, Map<String, Object> map) {
        AFa1zSDK.AFa1wSDK values2 = AFa1zSDK.AFa1vSDK.AFKeystoreWrapper.values(context);
        map.put("btl", Float.toString(values2.AFInAppEventParameterName));
        String str = values2.AFInAppEventType;
        if ((str != null ? 'N' : '\'') == 'N') {
            int i10 = onPause + 19;
            getSdkVersion = i10 % 128;
            boolean z10 = i10 % 2 != 0;
            map.put("btch", str);
            if (!z10) {
                throw null;
            }
        }
        int i11 = onPause + 73;
        getSdkVersion = i11 % 128;
        int i12 = i11 % 2;
    }

    private static void AFInAppEventParameterName(char c10, int i10, int i11, Object[] objArr) {
        String str;
        synchronized (AFg1wSDK.AFInAppEventParameterName) {
            char[] cArr = new char[i10];
            AFg1wSDK.AFKeystoreWrapper = 0;
            while (true) {
                int i12 = AFg1wSDK.AFKeystoreWrapper;
                if (i12 < i10) {
                    cArr[i12] = (char) ((int) ((((long) AppsFlyerConversionListener[i11 + i12]) ^ (((long) i12) * onValidateInAppFailure)) ^ ((long) c10)));
                    AFg1wSDK.AFKeystoreWrapper = i12 + 1;
                } else {
                    str = new String(cArr);
                }
            }
        }
        objArr[0] = str;
    }
}

package com.appsflyer.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.appsflyer.AFLogger;
import com.appsflyer.deeplink.DeepLinkListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.b;

public final class AFa1qSDK {
    static final List<String> AFInAppEventParameterName = new ArrayList();
    public static String[] AFKeystoreWrapper;
    private static AFa1qSDK afInfoLog;
    public static Intent values;
    public DeepLinkListener AFInAppEventType;
    public List<List<String>> afDebugLog = new ArrayList();
    public Map<String, String> afErrorLog;
    public String valueOf;

    public static AFa1qSDK AFInAppEventParameterName() {
        if (afInfoLog == null) {
            afInfoLog = new AFa1qSDK();
        }
        return afInfoLog;
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x0076 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean AFKeystoreWrapper(android.content.Intent r9, android.content.Context r10, java.util.Map<java.lang.String, java.lang.Object> r11) {
        /*
            r8 = this;
            java.lang.String r0 = "android.intent.action.VIEW"
            r1 = 0
            if (r9 == 0) goto L_0x0014
            java.lang.String r2 = r9.getAction()
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x0014
            android.net.Uri r2 = r9.getData()
            goto L_0x0015
        L_0x0014:
            r2 = r1
        L_0x0015:
            android.content.Intent r3 = values
            if (r3 == 0) goto L_0x0028
            java.lang.String r4 = r3.getAction()
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0028
            android.net.Uri r0 = r3.getData()
            goto L_0x0029
        L_0x0028:
            r0 = r1
        L_0x0029:
            if (r9 != 0) goto L_0x0031
            java.lang.String r3 = "Could not extract deeplink from null intent"
            com.appsflyer.AFLogger.afDebugLog(r3)
            goto L_0x0097
        L_0x0031:
            android.os.Bundle r3 = r9.getExtras()
            java.util.List<java.util.List<java.lang.String>> r4 = r8.afDebugLog
            if (r4 == 0) goto L_0x0097
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L_0x0097
            if (r3 != 0) goto L_0x0042
            goto L_0x0097
        L_0x0042:
            java.util.List<java.util.List<java.lang.String>> r4 = r8.afDebugLog
            java.util.Iterator r4 = r4.iterator()
        L_0x0048:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0097
            java.lang.Object r5 = r4.next()
            java.util.List r5 = (java.util.List) r5
            if (r5 != 0) goto L_0x0058
        L_0x0056:
            r6 = r1
            goto L_0x0074
        L_0x0058:
            java.util.Iterator r6 = r5.iterator()
            boolean r7 = r6.hasNext()
            if (r7 != 0) goto L_0x0063
            goto L_0x0056
        L_0x0063:
            java.lang.Object r7 = r6.next()
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r7 = r3.getString(r7)
            if (r7 != 0) goto L_0x0070
            goto L_0x0056
        L_0x0070:
            android.net.Uri r6 = r8.AFInAppEventParameterName(r7, r6)
        L_0x0074:
            if (r6 == 0) goto L_0x0048
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "Found deeplink in push payload at "
            r1.<init>(r3)
            java.lang.String r3 = r5.toString()
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            com.appsflyer.AFLogger.afDebugLog(r1)
            java.util.Map r1 = com.appsflyer.internal.AFb1zSDK.AFKeystoreWrapper((java.util.Map<java.lang.String, java.lang.Object>) r11)
            java.util.List<java.util.List<java.lang.String>> r3 = r8.afDebugLog
            java.lang.String r4 = "payloadKey"
            r1.put(r4, r3)
            r1 = r6
        L_0x0097:
            r3 = 1
            java.lang.String r4 = " w/af_consumed"
            r5 = 0
            java.lang.String r6 = "af_consumed"
            if (r2 == 0) goto L_0x00c9
            boolean r0 = r9.hasExtra(r6)
            if (r0 != 0) goto L_0x00b0
            long r0 = java.lang.System.currentTimeMillis()
            r9.putExtra(r6, r0)
            valueOf(r10, r11, r2)
            return r3
        L_0x00b0:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "skipping re-use of previously consumed deep link: "
            r9.<init>(r10)
            java.lang.String r10 = r2.toString()
            r9.append(r10)
            r9.append(r4)
            java.lang.String r9 = r9.toString()
            com.appsflyer.AFLogger.afInfoLog(r9)
            return r5
        L_0x00c9:
            if (r0 == 0) goto L_0x00f9
            android.content.Intent r9 = values
            boolean r9 = r9.hasExtra(r6)
            if (r9 != 0) goto L_0x00e0
            android.content.Intent r9 = values
            long r1 = java.lang.System.currentTimeMillis()
            r9.putExtra(r6, r1)
            valueOf(r10, r11, r0)
            return r3
        L_0x00e0:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "skipping re-use of previously consumed trampoline deep link: "
            r9.<init>(r10)
            java.lang.String r10 = r0.toString()
            r9.append(r10)
            r9.append(r4)
            java.lang.String r9 = r9.toString()
            com.appsflyer.AFLogger.afInfoLog(r9)
            return r5
        L_0x00f9:
            if (r1 == 0) goto L_0x0125
            boolean r0 = r9.hasExtra(r6)
            if (r0 != 0) goto L_0x010c
            long r4 = java.lang.System.currentTimeMillis()
            r9.putExtra(r6, r4)
            valueOf(r10, r11, r1)
            return r3
        L_0x010c:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "skipping re-use of previously consumed deep link from push: "
            r9.<init>(r10)
            java.lang.String r10 = r1.toString()
            r9.append(r10)
            r9.append(r4)
            java.lang.String r9 = r9.toString()
            com.appsflyer.AFLogger.afInfoLog(r9)
            return r5
        L_0x0125:
            java.lang.String r9 = "No deep link detected"
            com.appsflyer.AFLogger.afDebugLog(r9)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1qSDK.AFKeystoreWrapper(android.content.Intent, android.content.Context, java.util.Map):boolean");
    }

    static void valueOf(Context context, Map<String, Object> map, Uri uri) {
        AFd1mSDK aFd1mSDK = new AFd1mSDK(context, map, uri, AFInAppEventParameterName);
        AFb1zSDK.AFInAppEventType().AFKeystoreWrapper(context);
        AFd1xSDK afDebugLog2 = AFb1zSDK.AFInAppEventType().AFInAppEventParameterName().afDebugLog();
        afDebugLog2.AFKeystoreWrapper.execute(new Runnable(aFd1mSDK) {
            private /* synthetic */ AFd1tSDK AFInAppEventParameterName;

            {
                this.AFInAppEventParameterName = r2;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:29:0x00c4, code lost:
                if (r1 == false) goto L_0x0166;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:30:0x00c6, code lost:
                r6.values.values.add(r6.AFInAppEventParameterName.AFKeystoreWrapper);
                r0 = new java.lang.StringBuilder("QUEUE: new task added: ");
                r0.append(r6.AFInAppEventParameterName);
                com.appsflyer.AFLogger.afDebugLog(r0.toString());
                r0 = r6.values.AFInAppEventParameterName.iterator();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:32:0x00f0, code lost:
                if (r0.hasNext() == false) goto L_0x00f9;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:33:0x00f2, code lost:
                r1 = r0.next();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:34:0x00f9, code lost:
                r0 = r6.values;
                r0.valueOf.submit(r0);
                r0 = r6.values;
                r1 = r0.afInfoLog;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:35:0x0104, code lost:
                monitor-enter(r1);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
                r2 = (r0.afInfoLog.size() + r0.AFLogger.size()) - 40;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:38:0x0114, code lost:
                if (r2 <= 0) goto L_0x0161;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:40:0x011d, code lost:
                if (r0.AFLogger.isEmpty() != false) goto L_0x0121;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:41:0x011f, code lost:
                r3 = true;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:42:0x0121, code lost:
                r3 = false;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:43:0x0122, code lost:
                r4 = true ^ r0.afInfoLog.isEmpty();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:44:0x0129, code lost:
                if (r4 == false) goto L_0x014f;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:45:0x012b, code lost:
                if (r3 == false) goto L_0x014f;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:47:0x0141, code lost:
                if (r0.afInfoLog.first().AFInAppEventParameterName(r0.AFLogger.first()) <= 0) goto L_0x0149;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:48:0x0143, code lost:
                r0.values(r0.afInfoLog);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:49:0x0149, code lost:
                r0.values(r0.AFLogger);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:50:0x014f, code lost:
                if (r4 == false) goto L_0x0157;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:51:0x0151, code lost:
                r0.values(r0.afInfoLog);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:52:0x0157, code lost:
                if (r3 == false) goto L_0x015e;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:53:0x0159, code lost:
                r0.values(r0.AFLogger);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:54:0x015e, code lost:
                r2 = r2 - 1;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:55:0x0161, code lost:
                monitor-exit(r1);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:56:0x0162, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:60:0x0166, code lost:
                r0 = new java.lang.StringBuilder("QUEUE: tried to add already pending task: ");
                r0.append(r6.AFInAppEventParameterName);
                com.appsflyer.AFLogger.afWarnLog(r0.toString());
             */
            /* JADX WARNING: Code restructure failed: missing block: B:61:0x0179, code lost:
                return;
             */
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
        values = null;
    }

    /* access modifiers changed from: package-private */
    public final void AFInAppEventType(Map<String, Object> map, Intent intent, Context context) {
        AFb1zSDK.AFInAppEventType().AFKeystoreWrapper(context);
        AFc1xSDK AFInAppEventParameterName2 = AFb1zSDK.AFInAppEventType().AFInAppEventParameterName();
        AFb1gSDK afErrorLog2 = AFInAppEventParameterName2.afErrorLog();
        if (!AFKeystoreWrapper(intent, context, map) && this.AFInAppEventType != null && AFInAppEventParameterName2.values().values.AFInAppEventType("appsFlyerCount", 0) == 0 && !afErrorLog2.valueOf("ddl_sent")) {
            AFb1pSDK aFb1pSDK = new AFb1pSDK(context, AFInAppEventParameterName2);
            AFd1xSDK afDebugLog2 = AFInAppEventParameterName2.afDebugLog();
            afDebugLog2.AFKeystoreWrapper.execute(new Runnable(new AFd1lSDK(aFb1pSDK)) {
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
        }
        afErrorLog2.valueOf("ddl_sent", true);
    }

    private Uri AFInAppEventParameterName(Object obj, Iterator<String> it) {
        while (obj != b.NULL) {
            if (!it.hasNext()) {
                Uri parse = Uri.parse(obj.toString());
                if (parse == null || parse.getScheme() == null || parse.getHost() == null) {
                    return null;
                }
                return parse;
            }
            try {
                obj = new b(obj.toString()).get(it.next());
            } catch (JSONException e10) {
                AFLogger.afErrorLogForExcManagerOnly("recursiveSearch error", e10);
                return null;
            }
        }
        return null;
    }

    static Uri valueOf(Intent intent) {
        if (intent == null || !"android.intent.action.VIEW".equals(intent.getAction())) {
            return null;
        }
        return intent.getData();
    }
}

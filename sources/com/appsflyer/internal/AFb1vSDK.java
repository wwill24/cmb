package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public final class AFb1vSDK implements AFd1zSDK {
    private final Object AFInAppEventParameterName;
    private final AFe1zSDK AFInAppEventType;
    private final AFe1xSDK AFKeystoreWrapper;
    private final AFc1pSDK AFLogger;
    private final AFd1xSDK afDebugLog;
    private AFd1aSDK afErrorLog;
    private final AFe1uSDK afInfoLog;
    private AFb1kSDK afRDLog;
    public final AFe1wSDK valueOf;
    private final AFb1fSDK values;

    public AFb1vSDK() {
    }

    public AFb1vSDK(AFe1zSDK aFe1zSDK, AFb1fSDK aFb1fSDK, AFe1xSDK aFe1xSDK, AFe1wSDK aFe1wSDK, AFc1pSDK aFc1pSDK, AFe1uSDK aFe1uSDK, AFd1xSDK aFd1xSDK) {
        this.AFInAppEventParameterName = new Object();
        this.AFInAppEventType = aFe1zSDK;
        this.values = aFb1fSDK;
        this.AFKeystoreWrapper = aFe1xSDK;
        this.valueOf = aFe1wSDK;
        this.AFLogger = aFc1pSDK;
        this.afInfoLog = aFe1uSDK;
        this.afDebugLog = aFd1xSDK;
        aFd1xSDK.AFInAppEventParameterName.add(this);
    }

    public static Map<String, String> AFInAppEventParameterName(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            try {
                hashMap.put(URLEncoder.encode((String) next.getKey(), "utf-8"), URLEncoder.encode((String) next.getValue(), "utf-8"));
            } catch (UnsupportedEncodingException e10) {
                AFLogger.afErrorLogForExcManagerOnly("failed to encode map", e10);
            }
        }
        return hashMap;
    }

    public final void AFInAppEventType(AFd1dSDK aFd1dSDK) {
        AFd1cSDK aFd1cSDK = new AFd1cSDK(this.AFInAppEventType, this.values, this.AFKeystoreWrapper, this.valueOf, this.AFLogger, this.afInfoLog, "v1", aFd1dSDK);
        AFd1xSDK aFd1xSDK = this.afDebugLog;
        aFd1xSDK.AFKeystoreWrapper.execute(new Runnable(aFd1cSDK) {
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

    public final void AFKeystoreWrapper(AFd1tSDK<?> aFd1tSDK) {
    }

    public final AFb1kSDK valueOf() {
        AFb1kSDK aFb1kSDK;
        synchronized (this.AFInAppEventParameterName) {
            aFb1kSDK = this.afRDLog;
            this.afRDLog = null;
        }
        return aFb1kSDK;
    }

    public final void AFInAppEventType(AFd1tSDK<?> aFd1tSDK, AFc1aSDK aFc1aSDK) {
        if (aFd1tSDK instanceof AFd1cSDK) {
            AFd1cSDK aFd1cSDK = (AFd1cSDK) aFd1tSDK;
            AFd1aSDK aFd1aSDK = aFd1cSDK.afRDLog;
            if (aFd1aSDK == null) {
                AFLogger.afWarnLog("CFG: update RC returned null result, something went wrong!");
                aFd1aSDK = AFd1aSDK.FAILURE;
            }
            if (aFd1aSDK != AFd1aSDK.USE_CACHED) {
                AFb1kSDK aFb1kSDK = aFd1cSDK.afDebugLog;
                synchronized (this.AFInAppEventParameterName) {
                    this.afRDLog = aFb1kSDK;
                }
            }
            valueOf(aFd1aSDK, aFd1cSDK.afErrorLog);
        }
    }

    private void valueOf(AFd1aSDK aFd1aSDK, AFd1dSDK aFd1dSDK) {
        synchronized (this.AFInAppEventParameterName) {
            this.afErrorLog = aFd1aSDK;
        }
        if (aFd1dSDK != null) {
            aFd1dSDK.onRemoteConfigUpdateFinished(aFd1aSDK);
        }
    }

    public final void valueOf(AFd1tSDK<?> aFd1tSDK) {
        if (aFd1tSDK instanceof AFd1cSDK) {
            AFd1cSDK aFd1cSDK = (AFd1cSDK) aFd1tSDK;
            synchronized (this.AFInAppEventParameterName) {
                this.afRDLog = null;
            }
            valueOf(AFd1aSDK.FAILURE, aFd1cSDK.afErrorLog);
        }
    }
}

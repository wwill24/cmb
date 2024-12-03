package com.appsflyer.internal;

import android.net.Uri;
import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;
import com.facebook.internal.ServerProtocol;

public final class AFd1nSDK extends AFd1tSDK<Boolean> {
    private static volatile boolean afRDLog = false;
    private final AFc1xSDK AFLogger;
    private Boolean afDebugLog;
    private final AFa1lSDK afErrorLog;
    private final AFd1xSDK afInfoLog;

    public AFd1nSDK(@NonNull AFc1xSDK aFc1xSDK) {
        super(AFd1wSDK.LOAD_CACHE, new AFd1wSDK[0], "LoadCachedRequests");
        this.afErrorLog = aFc1xSDK.afWarnLog();
        this.afInfoLog = aFc1xSDK.afDebugLog();
        this.AFLogger = aFc1xSDK;
    }

    private static String AFInAppEventType(AFc1rSDK aFc1rSDK) {
        long currentTimeMillis = System.currentTimeMillis();
        long parseLong = Long.parseLong(aFc1rSDK.values, 10);
        String str = aFc1rSDK.AFKeystoreWrapper;
        try {
            return Uri.parse(str).buildUpon().appendQueryParameter("isCachedRequest", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE).appendQueryParameter("timeincache", String.valueOf((currentTimeMillis - parseLong) / 1000)).toString();
        } catch (Exception e10) {
            AFLogger.afErrorLogForExcManagerOnly("Couldn't parse the uri", e10);
            return str;
        }
    }

    public static boolean AFLogger() {
        return afRDLog;
    }

    @NonNull
    public final AFc1aSDK AFInAppEventParameterName() throws Exception {
        for (AFc1rSDK next : this.afErrorLog.AFKeystoreWrapper()) {
            StringBuilder sb2 = new StringBuilder("CACHE: resending request: ");
            sb2.append(next.AFKeystoreWrapper);
            AFLogger.afInfoLog(sb2.toString());
            try {
                AFe1fSDK aFe1fSDK = new AFe1fSDK(AFInAppEventType(next), next.AFInAppEventParameterName(), next.values, next.valueOf);
                AFd1xSDK aFd1xSDK = this.afInfoLog;
                aFd1xSDK.AFKeystoreWrapper.execute(new Runnable(new AFd1fSDK(aFe1fSDK, this.AFLogger)) {
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
            } catch (Exception e10) {
                AFLogger.afErrorLog("QUEUE: Failed to resend cached request", e10);
            }
        }
        this.afDebugLog = Boolean.TRUE;
        afRDLog = true;
        return AFc1aSDK.SUCCESS;
    }

    public final long AFInAppEventType() {
        return 30000;
    }

    public final boolean valueOf() {
        return false;
    }
}

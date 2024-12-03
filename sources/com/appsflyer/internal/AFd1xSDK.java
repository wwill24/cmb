package com.appsflyer.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class AFd1xSDK implements Runnable {
    public final List<AFd1zSDK> AFInAppEventParameterName = new CopyOnWriteArrayList();
    final Set<AFd1wSDK> AFInAppEventType = new CopyOnWriteArraySet();
    public Executor AFKeystoreWrapper = Executors.newSingleThreadExecutor();
    final NavigableSet<AFd1tSDK<?>> AFLogger = new ConcurrentSkipListSet();
    final List<AFd1tSDK<?>> afDebugLog = new ArrayList();
    final Set<AFd1tSDK<?>> afErrorLog = Collections.newSetFromMap(new ConcurrentHashMap());
    final NavigableSet<AFd1tSDK<?>> afInfoLog = new ConcurrentSkipListSet();
    private Timer afRDLog = new Timer(true);
    final ExecutorService valueOf;
    final Set<AFd1wSDK> values = Collections.newSetFromMap(new ConcurrentHashMap());

    public AFd1xSDK(ExecutorService executorService) {
        this.valueOf = executorService;
    }

    /* access modifiers changed from: private */
    public boolean AFInAppEventParameterName(AFd1tSDK<?> aFd1tSDK) {
        return this.AFInAppEventType.containsAll(aFd1tSDK.values);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        if (r2 <= 0) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0028, code lost:
        r6.afRDLog.schedule(r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002d, code lost:
        r6.AFKeystoreWrapper.execute(new com.appsflyer.internal.AFd1xSDK.AnonymousClass5(r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003d, code lost:
        if (r6.afInfoLog.isEmpty() != false) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003f, code lost:
        r6.valueOf.submit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        com.appsflyer.AFLogger.afDebugLog("QUEUE: starting task execution: ".concat(java.lang.String.valueOf(r1)));
        r2 = r1.afInfoLog();
        r0.cancel();
        r6.AFKeystoreWrapper.execute(new com.appsflyer.internal.AFd1xSDK.AnonymousClass4(r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0062, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0063, code lost:
        r0.cancel();
        r0 = com.appsflyer.internal.AFc1aSDK.AFKeystoreWrapper;
        r6.AFKeystoreWrapper.execute(new com.appsflyer.internal.AFd1xSDK.AnonymousClass4(r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0072, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0073, code lost:
        com.appsflyer.AFLogger.afDebugLog("QUEUE: task was interrupted: ".concat(java.lang.String.valueOf(r1)));
        r0 = com.appsflyer.internal.AFc1aSDK.AFInAppEventParameterName;
        r1.AFInAppEventType = r0;
        r6.AFKeystoreWrapper.execute(new com.appsflyer.internal.AFd1xSDK.AnonymousClass4(r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008e, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        r2 = r1.AFInAppEventType();
        r0 = new com.appsflyer.internal.AFd1vSDK(java.lang.Thread.currentThread());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r6 = this;
            java.util.NavigableSet<com.appsflyer.internal.AFd1tSDK<?>> r0 = r6.afInfoLog
            monitor-enter(r0)
            java.util.NavigableSet<com.appsflyer.internal.AFd1tSDK<?>> r1 = r6.afInfoLog     // Catch:{ all -> 0x008f }
            java.lang.Object r1 = r1.pollFirst()     // Catch:{ all -> 0x008f }
            com.appsflyer.internal.AFd1tSDK r1 = (com.appsflyer.internal.AFd1tSDK) r1     // Catch:{ all -> 0x008f }
            if (r1 != 0) goto L_0x000f
            monitor-exit(r0)     // Catch:{ all -> 0x008f }
            return
        L_0x000f:
            java.util.Set<com.appsflyer.internal.AFd1tSDK<?>> r2 = r6.afErrorLog     // Catch:{ all -> 0x008f }
            r2.add(r1)     // Catch:{ all -> 0x008f }
            monitor-exit(r0)     // Catch:{ all -> 0x008f }
            long r2 = r1.AFInAppEventType()
            com.appsflyer.internal.AFd1vSDK r0 = new com.appsflyer.internal.AFd1vSDK
            java.lang.Thread r4 = java.lang.Thread.currentThread()
            r0.<init>(r4)
            r4 = 0
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x002d
            java.util.Timer r4 = r6.afRDLog
            r4.schedule(r0, r2)
        L_0x002d:
            java.util.concurrent.Executor r2 = r6.AFKeystoreWrapper
            com.appsflyer.internal.AFd1xSDK$5 r3 = new com.appsflyer.internal.AFd1xSDK$5
            r3.<init>(r1)
            r2.execute(r3)
            java.util.NavigableSet<com.appsflyer.internal.AFd1tSDK<?>> r2 = r6.afInfoLog
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x0044
            java.util.concurrent.ExecutorService r2 = r6.valueOf
            r2.submit(r6)
        L_0x0044:
            java.lang.String r2 = "QUEUE: starting task execution: "
            java.lang.String r3 = java.lang.String.valueOf(r1)     // Catch:{ InterruptedIOException | InterruptedException -> 0x0073, all -> 0x0063 }
            java.lang.String r2 = r2.concat(r3)     // Catch:{ InterruptedIOException | InterruptedException -> 0x0073, all -> 0x0063 }
            com.appsflyer.AFLogger.afDebugLog(r2)     // Catch:{ InterruptedIOException | InterruptedException -> 0x0073, all -> 0x0063 }
            com.appsflyer.internal.AFc1aSDK r2 = r1.call()     // Catch:{ InterruptedIOException | InterruptedException -> 0x0073, all -> 0x0063 }
            r0.cancel()     // Catch:{ InterruptedIOException | InterruptedException -> 0x0073, all -> 0x0063 }
            java.util.concurrent.Executor r3 = r6.AFKeystoreWrapper     // Catch:{ InterruptedIOException | InterruptedException -> 0x0073, all -> 0x0063 }
            com.appsflyer.internal.AFd1xSDK$4 r4 = new com.appsflyer.internal.AFd1xSDK$4     // Catch:{ InterruptedIOException | InterruptedException -> 0x0073, all -> 0x0063 }
            r4.<init>(r1, r2)     // Catch:{ InterruptedIOException | InterruptedException -> 0x0073, all -> 0x0063 }
            r3.execute(r4)     // Catch:{ InterruptedIOException | InterruptedException -> 0x0073, all -> 0x0063 }
            return
        L_0x0063:
            r0.cancel()
            com.appsflyer.internal.AFc1aSDK r0 = com.appsflyer.internal.AFc1aSDK.FAILURE
            java.util.concurrent.Executor r2 = r6.AFKeystoreWrapper
            com.appsflyer.internal.AFd1xSDK$4 r3 = new com.appsflyer.internal.AFd1xSDK$4
            r3.<init>(r1, r0)
            r2.execute(r3)
            return
        L_0x0073:
            java.lang.String r0 = "QUEUE: task was interrupted: "
            java.lang.String r2 = java.lang.String.valueOf(r1)
            java.lang.String r0 = r0.concat(r2)
            com.appsflyer.AFLogger.afDebugLog(r0)
            com.appsflyer.internal.AFc1aSDK r0 = com.appsflyer.internal.AFc1aSDK.TIMEOUT
            r1.AFInAppEventType = r0
            java.util.concurrent.Executor r2 = r6.AFKeystoreWrapper
            com.appsflyer.internal.AFd1xSDK$4 r3 = new com.appsflyer.internal.AFd1xSDK$4
            r3.<init>(r1, r0)
            r2.execute(r3)
            return
        L_0x008f:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1xSDK.run():void");
    }

    /* access modifiers changed from: package-private */
    public final void values(NavigableSet<AFd1tSDK<?>> navigableSet) {
        AFd1tSDK pollFirst = navigableSet.pollFirst();
        this.AFInAppEventType.add(pollFirst.AFKeystoreWrapper);
        for (AFd1zSDK valueOf2 : this.AFInAppEventParameterName) {
            valueOf2.valueOf(pollFirst);
        }
    }

    static /* synthetic */ void AFInAppEventParameterName(AFd1xSDK aFd1xSDK) {
        synchronized (aFd1xSDK.afInfoLog) {
            Iterator<AFd1tSDK<?>> it = aFd1xSDK.AFLogger.iterator();
            boolean z10 = false;
            while (it.hasNext()) {
                AFd1tSDK next = it.next();
                if (aFd1xSDK.AFInAppEventParameterName((AFd1tSDK<?>) next)) {
                    it.remove();
                    aFd1xSDK.afInfoLog.add(next);
                    z10 = true;
                }
            }
            if (z10) {
                aFd1xSDK.valueOf.submit(aFd1xSDK);
            }
        }
    }
}

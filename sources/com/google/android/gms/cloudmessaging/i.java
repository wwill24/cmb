package com.google.android.gms.cloudmessaging;

import android.os.Handler;

public final /* synthetic */ class i implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p f38448a;

    public /* synthetic */ i(p pVar) {
        this.f38448a = pVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0041, code lost:
        r5 = r5.getData();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004c, code lost:
        if (r5.getBoolean("unsupported", false) == false) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004e, code lost:
        r2.c(new com.google.android.gms.cloudmessaging.zzq(4, "Not supported by GmsCore", (java.lang.Throwable) null));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005b, code lost:
        r2.a(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean handleMessage(android.os.Message r5) {
        /*
            r4 = this;
            com.google.android.gms.cloudmessaging.p r0 = r4.f38448a
            int r1 = r5.arg1
            java.lang.String r2 = "MessengerIpcClient"
            r3 = 3
            boolean r2 = android.util.Log.isLoggable(r2, r3)
            if (r2 == 0) goto L_0x001c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = 41
            r2.<init>(r3)
            java.lang.String r3 = "Received response to request: "
            r2.append(r3)
            r2.append(r1)
        L_0x001c:
            monitor-enter(r0)
            android.util.SparseArray<com.google.android.gms.cloudmessaging.s<?>> r2 = r0.f38460e     // Catch:{ all -> 0x0060 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x0060 }
            com.google.android.gms.cloudmessaging.s r2 = (com.google.android.gms.cloudmessaging.s) r2     // Catch:{ all -> 0x0060 }
            if (r2 != 0) goto L_0x0038
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0060 }
            r2 = 50
            r5.<init>(r2)     // Catch:{ all -> 0x0060 }
            java.lang.String r2 = "Received response for unknown request: "
            r5.append(r2)     // Catch:{ all -> 0x0060 }
            r5.append(r1)     // Catch:{ all -> 0x0060 }
            monitor-exit(r0)     // Catch:{ all -> 0x0060 }
            goto L_0x005e
        L_0x0038:
            android.util.SparseArray<com.google.android.gms.cloudmessaging.s<?>> r3 = r0.f38460e     // Catch:{ all -> 0x0060 }
            r3.remove(r1)     // Catch:{ all -> 0x0060 }
            r0.f()     // Catch:{ all -> 0x0060 }
            monitor-exit(r0)     // Catch:{ all -> 0x0060 }
            android.os.Bundle r5 = r5.getData()
            java.lang.String r0 = "unsupported"
            r1 = 0
            boolean r0 = r5.getBoolean(r0, r1)
            if (r0 == 0) goto L_0x005b
            com.google.android.gms.cloudmessaging.zzq r5 = new com.google.android.gms.cloudmessaging.zzq
            r0 = 4
            java.lang.String r1 = "Not supported by GmsCore"
            r3 = 0
            r5.<init>(r0, r1, r3)
            r2.c(r5)
            goto L_0x005e
        L_0x005b:
            r2.a(r5)
        L_0x005e:
            r5 = 1
            return r5
        L_0x0060:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0060 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cloudmessaging.i.handleMessage(android.os.Message):boolean");
    }
}

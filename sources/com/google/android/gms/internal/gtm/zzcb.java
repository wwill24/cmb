package com.google.android.gms.internal.gtm;

import android.content.ComponentName;
import android.content.ServiceConnection;
import com.google.android.gms.common.internal.p;

public final class zzcb implements ServiceConnection {
    final /* synthetic */ zzcc zza;
    private volatile boolean zzb;
    private volatile zzey zzc;

    protected zzcb(zzcc zzcc) {
        this.zza = zzcc;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:13|(1:15)(1:16)|17|18|25|26) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:9|10|11|(6:13|(1:15)(1:16)|17|18|25|26)(3:19|20|21)|(2:28|29)(3:30|31|(1:33)(1:34))|35|36|37|38) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0047 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0080 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onServiceConnected(android.content.ComponentName r3, android.os.IBinder r4) {
        /*
            r2 = this;
            java.lang.String r3 = "AnalyticsServiceConnection.onServiceConnected"
            com.google.android.gms.common.internal.p.f(r3)
            monitor-enter(r2)
            if (r4 != 0) goto L_0x0014
            com.google.android.gms.internal.gtm.zzcc r3 = r2.zza     // Catch:{ all -> 0x0044 }
            java.lang.String r4 = "Service connected with null binder"
            r3.zzJ(r4)     // Catch:{ all -> 0x0044 }
            r2.notifyAll()     // Catch:{ all -> 0x0089 }
            monitor-exit(r2)     // Catch:{ all -> 0x0089 }
            return
        L_0x0014:
            r3 = 0
            java.lang.String r0 = r4.getInterfaceDescriptor()     // Catch:{ RemoteException -> 0x0046 }
            java.lang.String r1 = "com.google.android.gms.analytics.internal.IAnalyticsService"
            boolean r1 = r1.equals(r0)     // Catch:{ RemoteException -> 0x0046 }
            if (r1 == 0) goto L_0x003b
            java.lang.String r0 = "com.google.android.gms.analytics.internal.IAnalyticsService"
            android.os.IInterface r0 = r4.queryLocalInterface(r0)     // Catch:{ RemoteException -> 0x0046 }
            boolean r1 = r0 instanceof com.google.android.gms.internal.gtm.zzey     // Catch:{ RemoteException -> 0x0046 }
            if (r1 == 0) goto L_0x002e
            com.google.android.gms.internal.gtm.zzey r0 = (com.google.android.gms.internal.gtm.zzey) r0     // Catch:{ RemoteException -> 0x0046 }
            goto L_0x0033
        L_0x002e:
            com.google.android.gms.internal.gtm.zzey r0 = new com.google.android.gms.internal.gtm.zzey     // Catch:{ RemoteException -> 0x0046 }
            r0.<init>(r4)     // Catch:{ RemoteException -> 0x0046 }
        L_0x0033:
            com.google.android.gms.internal.gtm.zzcc r4 = r2.zza     // Catch:{ RemoteException -> 0x0047 }
            java.lang.String r1 = "Bound to IAnalyticsService interface"
            r4.zzO(r1)     // Catch:{ RemoteException -> 0x0047 }
            goto L_0x004e
        L_0x003b:
            com.google.android.gms.internal.gtm.zzcc r4 = r2.zza     // Catch:{ RemoteException -> 0x0046 }
            java.lang.String r1 = "Got binder with a wrong descriptor"
            r4.zzK(r1, r0)     // Catch:{ RemoteException -> 0x0046 }
            r0 = r3
            goto L_0x004e
        L_0x0044:
            r3 = move-exception
            goto L_0x0085
        L_0x0046:
            r0 = r3
        L_0x0047:
            com.google.android.gms.internal.gtm.zzcc r4 = r2.zza     // Catch:{ all -> 0x0044 }
            java.lang.String r1 = "Service connect failed to get IAnalyticsService"
            r4.zzJ(r1)     // Catch:{ all -> 0x0044 }
        L_0x004e:
            if (r0 != 0) goto L_0x0064
            le.b r3 = le.b.b()     // Catch:{ IllegalArgumentException -> 0x0080 }
            com.google.android.gms.internal.gtm.zzcc r4 = r2.zza     // Catch:{ IllegalArgumentException -> 0x0080 }
            android.content.Context r4 = r4.zzo()     // Catch:{ IllegalArgumentException -> 0x0080 }
            com.google.android.gms.internal.gtm.zzcc r0 = r2.zza     // Catch:{ IllegalArgumentException -> 0x0080 }
            com.google.android.gms.internal.gtm.zzcb r0 = r0.zza     // Catch:{ IllegalArgumentException -> 0x0080 }
            r3.c(r4, r0)     // Catch:{ IllegalArgumentException -> 0x0080 }
            goto L_0x0080
        L_0x0064:
            boolean r4 = r2.zzb     // Catch:{ all -> 0x0044 }
            if (r4 != 0) goto L_0x007e
            com.google.android.gms.internal.gtm.zzcc r4 = r2.zza     // Catch:{ all -> 0x0044 }
            java.lang.String r1 = "onServiceConnected received after the timeout limit"
            r4.zzR(r1)     // Catch:{ all -> 0x0044 }
            com.google.android.gms.internal.gtm.zzcc r4 = r2.zza     // Catch:{ all -> 0x0044 }
            rd.u r4 = r4.zzq()     // Catch:{ all -> 0x0044 }
            com.google.android.gms.internal.gtm.zzbz r1 = new com.google.android.gms.internal.gtm.zzbz     // Catch:{ all -> 0x0044 }
            r1.<init>(r2, r0, r3)     // Catch:{ all -> 0x0044 }
            r4.i(r1)     // Catch:{ all -> 0x0044 }
            goto L_0x0080
        L_0x007e:
            r2.zzc = r0     // Catch:{ all -> 0x0044 }
        L_0x0080:
            r2.notifyAll()     // Catch:{ all -> 0x0089 }
            monitor-exit(r2)     // Catch:{ all -> 0x0089 }
            return
        L_0x0085:
            r2.notifyAll()     // Catch:{ all -> 0x0089 }
            throw r3     // Catch:{ all -> 0x0089 }
        L_0x0089:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0089 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzcb.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        p.f("AnalyticsServiceConnection.onServiceDisconnected");
        this.zza.zzq().i(new zzca(this, componentName));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:9|10|11|12|13|(1:15)) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x007a, code lost:
        return r0;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0063 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.gtm.zzey zza() {
        /*
            r6 = this;
            rd.u.h()
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "com.google.android.gms.analytics.service.START"
            r0.<init>(r1)
            android.content.ComponentName r1 = new android.content.ComponentName
            java.lang.String r2 = "com.google.android.gms"
            java.lang.String r3 = "com.google.android.gms.analytics.service.AnalyticsService"
            r1.<init>(r2, r3)
            r0.setComponent(r1)
            com.google.android.gms.internal.gtm.zzcc r1 = r6.zza
            android.content.Context r1 = r1.zzo()
            java.lang.String r2 = "app_package_name"
            java.lang.String r3 = r1.getPackageName()
            r0.putExtra(r2, r3)
            le.b r2 = le.b.b()
            monitor-enter(r6)
            r3 = 0
            r6.zzc = r3     // Catch:{ all -> 0x007b }
            r4 = 1
            r6.zzb = r4     // Catch:{ all -> 0x007b }
            com.google.android.gms.internal.gtm.zzcc r4 = r6.zza     // Catch:{ all -> 0x007b }
            com.google.android.gms.internal.gtm.zzcb r4 = r4.zza     // Catch:{ all -> 0x007b }
            r5 = 129(0x81, float:1.81E-43)
            boolean r0 = r2.a(r1, r0, r4, r5)     // Catch:{ all -> 0x007b }
            com.google.android.gms.internal.gtm.zzcc r1 = r6.zza     // Catch:{ all -> 0x007b }
            java.lang.String r2 = "Bind to service requested"
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r0)     // Catch:{ all -> 0x007b }
            r1.zzP(r2, r4)     // Catch:{ all -> 0x007b }
            r1 = 0
            if (r0 != 0) goto L_0x004e
            r6.zzb = r1     // Catch:{ all -> 0x007b }
            monitor-exit(r6)     // Catch:{ all -> 0x007b }
            return r3
        L_0x004e:
            com.google.android.gms.internal.gtm.zzcc r0 = r6.zza     // Catch:{ InterruptedException -> 0x0063 }
            r0.zzw()     // Catch:{ InterruptedException -> 0x0063 }
            com.google.android.gms.internal.gtm.zzet<java.lang.Long> r0 = com.google.android.gms.internal.gtm.zzeu.zzL     // Catch:{ InterruptedException -> 0x0063 }
            java.lang.Object r0 = r0.zzb()     // Catch:{ InterruptedException -> 0x0063 }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ InterruptedException -> 0x0063 }
            long r4 = r0.longValue()     // Catch:{ InterruptedException -> 0x0063 }
            r6.wait(r4)     // Catch:{ InterruptedException -> 0x0063 }
            goto L_0x006a
        L_0x0063:
            com.google.android.gms.internal.gtm.zzcc r0 = r6.zza     // Catch:{ all -> 0x007b }
            java.lang.String r2 = "Wait for service connect was interrupted"
            r0.zzR(r2)     // Catch:{ all -> 0x007b }
        L_0x006a:
            r6.zzb = r1     // Catch:{ all -> 0x007b }
            com.google.android.gms.internal.gtm.zzey r0 = r6.zzc     // Catch:{ all -> 0x007b }
            r6.zzc = r3     // Catch:{ all -> 0x007b }
            if (r0 != 0) goto L_0x0079
            com.google.android.gms.internal.gtm.zzcc r1 = r6.zza     // Catch:{ all -> 0x007b }
            java.lang.String r2 = "Successfully bound to service but never got onServiceConnected callback"
            r1.zzJ(r2)     // Catch:{ all -> 0x007b }
        L_0x0079:
            monitor-exit(r6)     // Catch:{ all -> 0x007b }
            return r0
        L_0x007b:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x007b }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzcb.zza():com.google.android.gms.internal.gtm.zzey");
    }
}

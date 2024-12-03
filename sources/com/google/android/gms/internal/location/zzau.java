package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.internal.e;
import com.google.android.gms.common.api.internal.l;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.c;
import com.google.android.gms.location.h;
import com.google.android.gms.location.i;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzau implements c {
    static /* bridge */ /* synthetic */ TaskCompletionSource zza(e eVar) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.getTask().addOnCompleteListener(new zzah(eVar));
        return taskCompletionSource;
    }

    public final f<Status> flushLocations(d dVar) {
        return dVar.h(new zzaj(this, dVar));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006c, code lost:
        r11 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006d, code lost:
        r0 = true;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0064 */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0070  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.location.Location getLastLocation(com.google.android.gms.common.api.d r11) {
        /*
            r10 = this;
            r0 = 0
            r1 = 1
            if (r11 == 0) goto L_0x0006
            r2 = r1
            goto L_0x0007
        L_0x0006:
            r2 = r0
        L_0x0007:
            java.lang.String r3 = "GoogleApiClient parameter is required."
            com.google.android.gms.common.internal.p.b(r2, r3)
            com.google.android.gms.common.api.a$g r2 = com.google.android.gms.internal.location.zzbp.zza
            com.google.android.gms.common.api.a$f r11 = r11.j(r2)
            com.google.android.gms.internal.location.zzda r11 = (com.google.android.gms.internal.location.zzda) r11
            java.util.concurrent.atomic.AtomicReference r2 = new java.util.concurrent.atomic.AtomicReference
            r2.<init>()
            java.util.concurrent.CountDownLatch r3 = new java.util.concurrent.CountDownLatch
            r3.<init>(r1)
            com.google.android.gms.tasks.TaskCompletionSource r4 = new com.google.android.gms.tasks.TaskCompletionSource
            r4.<init>()
            r5 = 0
            com.google.android.gms.location.LastLocationRequest$a r6 = new com.google.android.gms.location.LastLocationRequest$a     // Catch:{ Exception -> 0x0078 }
            r6.<init>()     // Catch:{ Exception -> 0x0078 }
            com.google.android.gms.location.LastLocationRequest r6 = r6.a()     // Catch:{ Exception -> 0x0078 }
            r11.zzt(r6, r4)     // Catch:{ Exception -> 0x0078 }
            com.google.android.gms.tasks.Task r11 = r4.getTask()
            com.google.android.gms.internal.location.zzai r4 = new com.google.android.gms.internal.location.zzai
            r4.<init>(r2, r3)
            r11.addOnCompleteListener(r4)
            java.util.concurrent.TimeUnit r11 = java.util.concurrent.TimeUnit.SECONDS
            r6 = 30
            long r6 = r11.toNanos(r6)     // Catch:{ all -> 0x0062 }
            long r8 = java.lang.System.nanoTime()     // Catch:{ all -> 0x0062 }
            long r8 = r8 + r6
        L_0x0049:
            java.util.concurrent.TimeUnit r11 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch:{ InterruptedException -> 0x0064 }
            boolean r11 = r3.await(r6, r11)     // Catch:{ InterruptedException -> 0x0064 }
            if (r0 == 0) goto L_0x0058
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x0058:
            if (r11 == 0) goto L_0x0061
            java.lang.Object r11 = r2.get()
            android.location.Location r11 = (android.location.Location) r11
            return r11
        L_0x0061:
            return r5
        L_0x0062:
            r11 = move-exception
            goto L_0x006e
        L_0x0064:
            long r6 = java.lang.System.nanoTime()     // Catch:{ all -> 0x006c }
            long r6 = r8 - r6
            r0 = r1
            goto L_0x0049
        L_0x006c:
            r11 = move-exception
            r0 = r1
        L_0x006e:
            if (r0 == 0) goto L_0x0077
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x0077:
            throw r11
        L_0x0078:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.location.zzau.getLastLocation(com.google.android.gms.common.api.d):android.location.Location");
    }

    public final LocationAvailability getLocationAvailability(d dVar) {
        boolean z10;
        if (dVar != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        p.b(z10, "GoogleApiClient parameter is required.");
        try {
            return ((zzda) dVar.j(zzbp.zza)).zzp();
        } catch (RemoteException unused) {
            return null;
        }
    }

    public final f<Status> removeLocationUpdates(d dVar, PendingIntent pendingIntent) {
        return dVar.h(new zzao(this, dVar, pendingIntent));
    }

    public final f<Status> requestLocationUpdates(d dVar, LocationRequest locationRequest, PendingIntent pendingIntent) {
        return dVar.h(new zzam(this, dVar, pendingIntent, locationRequest));
    }

    public final f<Status> setMockLocation(d dVar, Location location) {
        return dVar.h(new zzar(this, dVar, location));
    }

    public final f<Status> setMockMode(d dVar, boolean z10) {
        return dVar.h(new zzaq(this, dVar, z10));
    }

    public final f<Status> removeLocationUpdates(d dVar, h hVar) {
        return dVar.h(new zzap(this, dVar, hVar));
    }

    public final f<Status> requestLocationUpdates(d dVar, LocationRequest locationRequest, h hVar, Looper looper) {
        if (looper == null) {
            looper = Looper.myLooper();
            p.l(looper, "invalid null looper");
        }
        return dVar.h(new zzal(this, dVar, l.a(hVar, looper, h.class.getSimpleName()), locationRequest));
    }

    public final f<Status> removeLocationUpdates(d dVar, i iVar) {
        return dVar.h(new zzan(this, dVar, iVar));
    }

    public final f<Status> requestLocationUpdates(d dVar, LocationRequest locationRequest, i iVar) {
        Looper myLooper = Looper.myLooper();
        p.l(myLooper, "invalid null looper");
        return dVar.h(new zzak(this, dVar, l.a(iVar, myLooper, i.class.getSimpleName()), locationRequest));
    }

    public final f<Status> requestLocationUpdates(d dVar, LocationRequest locationRequest, i iVar, Looper looper) {
        if (looper == null) {
            looper = Looper.myLooper();
            p.l(looper, "invalid null looper");
        }
        return dVar.h(new zzak(this, dVar, l.a(iVar, looper, i.class.getSimpleName()), locationRequest));
    }
}

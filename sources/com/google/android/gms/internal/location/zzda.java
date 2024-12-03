package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import androidx.collection.g;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.common.api.internal.l;
import com.google.android.gms.common.api.internal.n;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.j;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.location.CurrentLocationRequest;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LastLocationRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.h0;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;

public final class zzda extends f {
    public static final /* synthetic */ int zze = 0;
    private final g zzf = new g();
    private final g zzg = new g();
    private final g zzh = new g();

    public zzda(Context context, Looper looper, e eVar, com.google.android.gms.common.api.internal.f fVar, n nVar) {
        super(context, looper, 23, eVar, fVar, nVar);
    }

    private final boolean zzE(Feature feature) {
        Feature feature2;
        Feature[] availableFeatures = getAvailableFeatures();
        if (availableFeatures == null) {
            return false;
        }
        int length = availableFeatures.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                feature2 = null;
                break;
            }
            feature2 = availableFeatures[i10];
            if (feature.S().equals(feature2.S())) {
                break;
            }
            i10++;
        }
        if (feature2 != null && feature2.Y() >= feature.Y()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (queryLocalInterface instanceof zzo) {
            return (zzo) queryLocalInterface;
        }
        return new zzn(iBinder);
    }

    public final Feature[] getApiFeatures() {
        return h0.f39592l;
    }

    public final int getMinApkVersion() {
        return 11717000;
    }

    /* access modifiers changed from: protected */
    public final String getServiceDescriptor() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    /* access modifiers changed from: protected */
    public final String getStartServiceAction() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    public final void onConnectionSuspended(int i10) {
        super.onConnectionSuspended(i10);
        synchronized (this.zzf) {
            this.zzf.clear();
        }
        synchronized (this.zzg) {
            this.zzg.clear();
        }
        synchronized (this.zzh) {
            this.zzh.clear();
        }
    }

    public final boolean usesClientTelemetry() {
        return true;
    }

    public final void zzA(boolean z10, TaskCompletionSource taskCompletionSource) throws RemoteException {
        if (zzE(h0.f39587g)) {
            ((zzo) getService()).zzx(z10, new zzcl(this, (Object) null, taskCompletionSource));
            return;
        }
        ((zzo) getService()).zzw(z10);
        taskCompletionSource.setResult(null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzB(com.google.android.gms.common.api.internal.k.a r10, boolean r11, com.google.android.gms.tasks.TaskCompletionSource r12) throws android.os.RemoteException {
        /*
            r9 = this;
            androidx.collection.g r0 = r9.zzg
            monitor-enter(r0)
            androidx.collection.g r1 = r9.zzg     // Catch:{ all -> 0x005b }
            java.lang.Object r10 = r1.remove(r10)     // Catch:{ all -> 0x005b }
            r5 = r10
            com.google.android.gms.internal.location.zzcw r5 = (com.google.android.gms.internal.location.zzcw) r5     // Catch:{ all -> 0x005b }
            if (r5 != 0) goto L_0x0015
            java.lang.Boolean r10 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x005b }
            r12.setResult(r10)     // Catch:{ all -> 0x005b }
            monitor-exit(r0)     // Catch:{ all -> 0x005b }
            return
        L_0x0015:
            r5.zzh()     // Catch:{ all -> 0x005b }
            if (r11 == 0) goto L_0x0054
            com.google.android.gms.common.Feature r10 = com.google.android.gms.location.h0.f39590j     // Catch:{ all -> 0x005b }
            boolean r10 = r9.zzE(r10)     // Catch:{ all -> 0x005b }
            if (r10 == 0) goto L_0x0038
            android.os.IInterface r10 = r9.getService()     // Catch:{ all -> 0x005b }
            com.google.android.gms.internal.location.zzo r10 = (com.google.android.gms.internal.location.zzo) r10     // Catch:{ all -> 0x005b }
            r11 = 0
            com.google.android.gms.internal.location.zzdb r11 = com.google.android.gms.internal.location.zzdb.zzb(r11, r5, r11, r11)     // Catch:{ all -> 0x005b }
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x005b }
            com.google.android.gms.internal.location.zzcl r2 = new com.google.android.gms.internal.location.zzcl     // Catch:{ all -> 0x005b }
            r2.<init>(r9, r1, r12)     // Catch:{ all -> 0x005b }
            r10.zzy(r11, r2)     // Catch:{ all -> 0x005b }
            goto L_0x0059
        L_0x0038:
            android.os.IInterface r10 = r9.getService()     // Catch:{ all -> 0x005b }
            com.google.android.gms.internal.location.zzo r10 = (com.google.android.gms.internal.location.zzo) r10     // Catch:{ all -> 0x005b }
            java.lang.Boolean r11 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x005b }
            com.google.android.gms.internal.location.zzcn r7 = new com.google.android.gms.internal.location.zzcn     // Catch:{ all -> 0x005b }
            r7.<init>(r11, r12)     // Catch:{ all -> 0x005b }
            com.google.android.gms.internal.location.zzdf r11 = new com.google.android.gms.internal.location.zzdf     // Catch:{ all -> 0x005b }
            r2 = 2
            r3 = 0
            r4 = 0
            r6 = 0
            r8 = 0
            r1 = r11
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x005b }
            r10.zzz(r11)     // Catch:{ all -> 0x005b }
            goto L_0x0059
        L_0x0054:
            java.lang.Boolean r10 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x005b }
            r12.setResult(r10)     // Catch:{ all -> 0x005b }
        L_0x0059:
            monitor-exit(r0)     // Catch:{ all -> 0x005b }
            return
        L_0x005b:
            r10 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x005b }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.location.zzda.zzB(com.google.android.gms.common.api.internal.k$a, boolean, com.google.android.gms.tasks.TaskCompletionSource):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzC(com.google.android.gms.common.api.internal.k.a r10, boolean r11, com.google.android.gms.tasks.TaskCompletionSource r12) throws android.os.RemoteException {
        /*
            r9 = this;
            androidx.collection.g r0 = r9.zzf
            monitor-enter(r0)
            androidx.collection.g r1 = r9.zzf     // Catch:{ all -> 0x005b }
            java.lang.Object r10 = r1.remove(r10)     // Catch:{ all -> 0x005b }
            r4 = r10
            com.google.android.gms.internal.location.zzcz r4 = (com.google.android.gms.internal.location.zzcz) r4     // Catch:{ all -> 0x005b }
            if (r4 != 0) goto L_0x0015
            java.lang.Boolean r10 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x005b }
            r12.setResult(r10)     // Catch:{ all -> 0x005b }
            monitor-exit(r0)     // Catch:{ all -> 0x005b }
            return
        L_0x0015:
            r4.zzg()     // Catch:{ all -> 0x005b }
            if (r11 == 0) goto L_0x0054
            com.google.android.gms.common.Feature r10 = com.google.android.gms.location.h0.f39590j     // Catch:{ all -> 0x005b }
            boolean r10 = r9.zzE(r10)     // Catch:{ all -> 0x005b }
            if (r10 == 0) goto L_0x0038
            android.os.IInterface r10 = r9.getService()     // Catch:{ all -> 0x005b }
            com.google.android.gms.internal.location.zzo r10 = (com.google.android.gms.internal.location.zzo) r10     // Catch:{ all -> 0x005b }
            r11 = 0
            com.google.android.gms.internal.location.zzdb r11 = com.google.android.gms.internal.location.zzdb.zzc(r11, r4, r11, r11)     // Catch:{ all -> 0x005b }
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x005b }
            com.google.android.gms.internal.location.zzcl r2 = new com.google.android.gms.internal.location.zzcl     // Catch:{ all -> 0x005b }
            r2.<init>(r9, r1, r12)     // Catch:{ all -> 0x005b }
            r10.zzy(r11, r2)     // Catch:{ all -> 0x005b }
            goto L_0x0059
        L_0x0038:
            android.os.IInterface r10 = r9.getService()     // Catch:{ all -> 0x005b }
            com.google.android.gms.internal.location.zzo r10 = (com.google.android.gms.internal.location.zzo) r10     // Catch:{ all -> 0x005b }
            java.lang.Boolean r11 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x005b }
            com.google.android.gms.internal.location.zzcn r7 = new com.google.android.gms.internal.location.zzcn     // Catch:{ all -> 0x005b }
            r7.<init>(r11, r12)     // Catch:{ all -> 0x005b }
            com.google.android.gms.internal.location.zzdf r11 = new com.google.android.gms.internal.location.zzdf     // Catch:{ all -> 0x005b }
            r2 = 2
            r3 = 0
            r5 = 0
            r6 = 0
            r8 = 0
            r1 = r11
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x005b }
            r10.zzz(r11)     // Catch:{ all -> 0x005b }
            goto L_0x0059
        L_0x0054:
            java.lang.Boolean r10 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x005b }
            r12.setResult(r10)     // Catch:{ all -> 0x005b }
        L_0x0059:
            monitor-exit(r0)     // Catch:{ all -> 0x005b }
            return
        L_0x005b:
            r10 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x005b }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.location.zzda.zzC(com.google.android.gms.common.api.internal.k$a, boolean, com.google.android.gms.tasks.TaskCompletionSource):void");
    }

    public final void zzD(PendingIntent pendingIntent, TaskCompletionSource taskCompletionSource, Object obj) throws RemoteException {
        if (zzE(h0.f39590j)) {
            ((zzo) getService()).zzy(zzdb.zza(pendingIntent, (String) null, (String) null), new zzcl(this, (Object) null, taskCompletionSource));
            return;
        }
        ((zzo) getService()).zzz(new zzdf(2, (zzdd) null, (IBinder) null, (IBinder) null, pendingIntent, new zzcn((Object) null, taskCompletionSource), (String) null));
    }

    public final LocationAvailability zzp() throws RemoteException {
        return ((zzo) getService()).zzf(getContext().getPackageName());
    }

    public final void zzq(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, TaskCompletionSource taskCompletionSource) throws RemoteException {
        p.l(geofencingRequest, "geofencingRequest can't be null.");
        p.l(pendingIntent, "PendingIntent must be specified.");
        ((zzo) getService()).zzg(geofencingRequest, pendingIntent, new zzci(taskCompletionSource));
    }

    public final void zzr(TaskCompletionSource taskCompletionSource) throws RemoteException {
        ((zzo) getService()).zzi(new zzcn((Object) null, taskCompletionSource));
    }

    public final void zzs(CurrentLocationRequest currentLocationRequest, CancellationToken cancellationToken, TaskCompletionSource taskCompletionSource) throws RemoteException {
        getContext();
        if (zzE(h0.f39585e)) {
            j zze2 = ((zzo) getService()).zze(currentLocationRequest, new zzcm(this, taskCompletionSource));
            if (cancellationToken != null) {
                cancellationToken.onCanceledRequested(new zzcf(zze2));
                return;
            }
            return;
        }
        k b10 = l.b(new zzcj(this, taskCompletionSource), zzdx.zza(), "GetCurrentLocation");
        k.a b11 = b10.b();
        b11.getClass();
        zzck zzck = new zzck(this, b10, taskCompletionSource);
        TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
        LocationRequest.a aVar = new LocationRequest.a(currentLocationRequest.getPriority(), 0);
        aVar.e(0);
        aVar.b(currentLocationRequest.S());
        aVar.c(currentLocationRequest.Y());
        aVar.d(currentLocationRequest.c0());
        aVar.g(currentLocationRequest.i0());
        aVar.i(currentLocationRequest.zza());
        aVar.f(true);
        aVar.h(currentLocationRequest.zzd());
        aVar.j(currentLocationRequest.f0());
        zzu(zzck, aVar.a(), taskCompletionSource2);
        taskCompletionSource2.getTask().addOnCompleteListener(new zzcg(taskCompletionSource));
        if (cancellationToken != null) {
            cancellationToken.onCanceledRequested(new zzch(this, b11));
        }
    }

    public final void zzt(LastLocationRequest lastLocationRequest, TaskCompletionSource taskCompletionSource) throws RemoteException {
        getContext();
        if (zzE(h0.f39586f)) {
            ((zzo) getService()).zzj(lastLocationRequest, new zzcm(this, taskCompletionSource));
        } else {
            taskCompletionSource.setResult(((zzo) getService()).zzd());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0057  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzu(com.google.android.gms.internal.location.zzcs r18, com.google.android.gms.location.LocationRequest r19, com.google.android.gms.tasks.TaskCompletionSource r20) throws android.os.RemoteException {
        /*
            r17 = this;
            r1 = r17
            r0 = r19
            r2 = r20
            com.google.android.gms.common.api.internal.k r3 = r18.zza()
            com.google.android.gms.common.api.internal.k$a r4 = r3.b()
            r4.getClass()
            com.google.android.gms.common.Feature r5 = com.google.android.gms.location.h0.f39590j
            boolean r5 = r1.zzE(r5)
            androidx.collection.g r6 = r1.zzg
            monitor-enter(r6)
            androidx.collection.g r7 = r1.zzg     // Catch:{ all -> 0x0082 }
            java.lang.Object r7 = r7.get(r4)     // Catch:{ all -> 0x0082 }
            com.google.android.gms.internal.location.zzcw r7 = (com.google.android.gms.internal.location.zzcw) r7     // Catch:{ all -> 0x0082 }
            r8 = 0
            if (r7 == 0) goto L_0x002e
            if (r5 == 0) goto L_0x0028
            goto L_0x002e
        L_0x0028:
            r7.zzg(r3)     // Catch:{ all -> 0x0082 }
            r13 = r7
            r7 = r8
            goto L_0x003b
        L_0x002e:
            com.google.android.gms.internal.location.zzcw r3 = new com.google.android.gms.internal.location.zzcw     // Catch:{ all -> 0x0082 }
            r9 = r18
            r3.<init>(r9)     // Catch:{ all -> 0x0082 }
            androidx.collection.g r9 = r1.zzg     // Catch:{ all -> 0x0082 }
            r9.put(r4, r3)     // Catch:{ all -> 0x0082 }
            r13 = r3
        L_0x003b:
            r17.getContext()     // Catch:{ all -> 0x0082 }
            java.lang.String r3 = r4.a()     // Catch:{ all -> 0x0082 }
            if (r5 == 0) goto L_0x0057
            android.os.IInterface r4 = r17.getService()     // Catch:{ all -> 0x0082 }
            com.google.android.gms.internal.location.zzo r4 = (com.google.android.gms.internal.location.zzo) r4     // Catch:{ all -> 0x0082 }
            com.google.android.gms.internal.location.zzdb r3 = com.google.android.gms.internal.location.zzdb.zzb(r7, r13, r8, r3)     // Catch:{ all -> 0x0082 }
            com.google.android.gms.internal.location.zzcl r5 = new com.google.android.gms.internal.location.zzcl     // Catch:{ all -> 0x0082 }
            r5.<init>(r1, r8, r2)     // Catch:{ all -> 0x0082 }
            r4.zzk(r3, r0, r5)     // Catch:{ all -> 0x0082 }
            goto L_0x0080
        L_0x0057:
            android.os.IInterface r4 = r17.getService()     // Catch:{ all -> 0x0082 }
            com.google.android.gms.internal.location.zzo r4 = (com.google.android.gms.internal.location.zzo) r4     // Catch:{ all -> 0x0082 }
            com.google.android.gms.location.LocationRequest$a r5 = new com.google.android.gms.location.LocationRequest$a     // Catch:{ all -> 0x0082 }
            r5.<init>(r0)     // Catch:{ all -> 0x0082 }
            r5.h(r8)     // Catch:{ all -> 0x0082 }
            com.google.android.gms.location.LocationRequest r0 = r5.a()     // Catch:{ all -> 0x0082 }
            com.google.android.gms.internal.location.zzdd r11 = com.google.android.gms.internal.location.zzdd.zza(r8, r0)     // Catch:{ all -> 0x0082 }
            com.google.android.gms.internal.location.zzcp r15 = new com.google.android.gms.internal.location.zzcp     // Catch:{ all -> 0x0082 }
            r15.<init>(r2, r13)     // Catch:{ all -> 0x0082 }
            com.google.android.gms.internal.location.zzdf r0 = new com.google.android.gms.internal.location.zzdf     // Catch:{ all -> 0x0082 }
            r10 = 1
            r12 = 0
            r14 = 0
            r9 = r0
            r16 = r3
            r9.<init>(r10, r11, r12, r13, r14, r15, r16)     // Catch:{ all -> 0x0082 }
            r4.zzz(r0)     // Catch:{ all -> 0x0082 }
        L_0x0080:
            monitor-exit(r6)     // Catch:{ all -> 0x0082 }
            return
        L_0x0082:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0082 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.location.zzda.zzu(com.google.android.gms.internal.location.zzcs, com.google.android.gms.location.LocationRequest, com.google.android.gms.tasks.TaskCompletionSource):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0057  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzv(com.google.android.gms.internal.location.zzcs r18, com.google.android.gms.location.LocationRequest r19, com.google.android.gms.tasks.TaskCompletionSource r20) throws android.os.RemoteException {
        /*
            r17 = this;
            r1 = r17
            r0 = r19
            r2 = r20
            com.google.android.gms.common.api.internal.k r3 = r18.zza()
            com.google.android.gms.common.api.internal.k$a r4 = r3.b()
            r4.getClass()
            com.google.android.gms.common.Feature r5 = com.google.android.gms.location.h0.f39590j
            boolean r5 = r1.zzE(r5)
            androidx.collection.g r6 = r1.zzf
            monitor-enter(r6)
            androidx.collection.g r7 = r1.zzf     // Catch:{ all -> 0x0082 }
            java.lang.Object r7 = r7.get(r4)     // Catch:{ all -> 0x0082 }
            com.google.android.gms.internal.location.zzcz r7 = (com.google.android.gms.internal.location.zzcz) r7     // Catch:{ all -> 0x0082 }
            r8 = 0
            if (r7 == 0) goto L_0x002e
            if (r5 == 0) goto L_0x0028
            goto L_0x002e
        L_0x0028:
            r7.zzf(r3)     // Catch:{ all -> 0x0082 }
            r12 = r7
            r7 = r8
            goto L_0x003b
        L_0x002e:
            com.google.android.gms.internal.location.zzcz r3 = new com.google.android.gms.internal.location.zzcz     // Catch:{ all -> 0x0082 }
            r9 = r18
            r3.<init>(r9)     // Catch:{ all -> 0x0082 }
            androidx.collection.g r9 = r1.zzf     // Catch:{ all -> 0x0082 }
            r9.put(r4, r3)     // Catch:{ all -> 0x0082 }
            r12 = r3
        L_0x003b:
            r17.getContext()     // Catch:{ all -> 0x0082 }
            java.lang.String r3 = r4.a()     // Catch:{ all -> 0x0082 }
            if (r5 == 0) goto L_0x0057
            android.os.IInterface r4 = r17.getService()     // Catch:{ all -> 0x0082 }
            com.google.android.gms.internal.location.zzo r4 = (com.google.android.gms.internal.location.zzo) r4     // Catch:{ all -> 0x0082 }
            com.google.android.gms.internal.location.zzdb r3 = com.google.android.gms.internal.location.zzdb.zzc(r7, r12, r8, r3)     // Catch:{ all -> 0x0082 }
            com.google.android.gms.internal.location.zzcl r5 = new com.google.android.gms.internal.location.zzcl     // Catch:{ all -> 0x0082 }
            r5.<init>(r1, r8, r2)     // Catch:{ all -> 0x0082 }
            r4.zzk(r3, r0, r5)     // Catch:{ all -> 0x0082 }
            goto L_0x0080
        L_0x0057:
            android.os.IInterface r4 = r17.getService()     // Catch:{ all -> 0x0082 }
            com.google.android.gms.internal.location.zzo r4 = (com.google.android.gms.internal.location.zzo) r4     // Catch:{ all -> 0x0082 }
            com.google.android.gms.location.LocationRequest$a r5 = new com.google.android.gms.location.LocationRequest$a     // Catch:{ all -> 0x0082 }
            r5.<init>(r0)     // Catch:{ all -> 0x0082 }
            r5.h(r8)     // Catch:{ all -> 0x0082 }
            com.google.android.gms.location.LocationRequest r0 = r5.a()     // Catch:{ all -> 0x0082 }
            com.google.android.gms.internal.location.zzdd r11 = com.google.android.gms.internal.location.zzdd.zza(r8, r0)     // Catch:{ all -> 0x0082 }
            com.google.android.gms.internal.location.zzco r15 = new com.google.android.gms.internal.location.zzco     // Catch:{ all -> 0x0082 }
            r15.<init>(r2, r12)     // Catch:{ all -> 0x0082 }
            com.google.android.gms.internal.location.zzdf r0 = new com.google.android.gms.internal.location.zzdf     // Catch:{ all -> 0x0082 }
            r10 = 1
            r13 = 0
            r14 = 0
            r9 = r0
            r16 = r3
            r9.<init>(r10, r11, r12, r13, r14, r15, r16)     // Catch:{ all -> 0x0082 }
            r4.zzz(r0)     // Catch:{ all -> 0x0082 }
        L_0x0080:
            monitor-exit(r6)     // Catch:{ all -> 0x0082 }
            return
        L_0x0082:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0082 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.location.zzda.zzv(com.google.android.gms.internal.location.zzcs, com.google.android.gms.location.LocationRequest, com.google.android.gms.tasks.TaskCompletionSource):void");
    }

    public final void zzw(PendingIntent pendingIntent, LocationRequest locationRequest, TaskCompletionSource taskCompletionSource) throws RemoteException {
        getContext();
        if (zzE(h0.f39590j)) {
            ((zzo) getService()).zzk(zzdb.zza(pendingIntent, (String) null, (String) null), locationRequest, new zzcl(this, (Object) null, taskCompletionSource));
            return;
        }
        LocationRequest.a aVar = new LocationRequest.a(locationRequest);
        aVar.h((String) null);
        zzdd zza = zzdd.zza((String) null, aVar.a());
        zzcn zzcn = new zzcn((Object) null, taskCompletionSource);
        int hashCode = pendingIntent.hashCode();
        ((zzo) getService()).zzz(new zzdf(1, zza, (IBinder) null, (IBinder) null, pendingIntent, zzcn, "PendingIntent@" + hashCode));
    }

    public final void zzx(PendingIntent pendingIntent, TaskCompletionSource taskCompletionSource) throws RemoteException {
        p.l(pendingIntent, "PendingIntent must be specified.");
        ((zzo) getService()).zzn(pendingIntent, new zzci(taskCompletionSource), getContext().getPackageName());
    }

    public final void zzy(List list, TaskCompletionSource taskCompletionSource) throws RemoteException {
        boolean z10;
        if (list == null || list.isEmpty()) {
            z10 = false;
        } else {
            z10 = true;
        }
        p.b(z10, "geofenceRequestIds can't be null nor empty.");
        ((zzo) getService()).zzo((String[]) list.toArray(new String[0]), new zzci(taskCompletionSource), getContext().getPackageName());
    }

    public final void zzz(Location location, TaskCompletionSource taskCompletionSource) throws RemoteException {
        if (zzE(h0.f39588h)) {
            ((zzo) getService()).zzv(location, new zzcl(this, (Object) null, taskCompletionSource));
            return;
        }
        ((zzo) getService()).zzu(location);
        taskCompletionSource.setResult(null);
    }
}

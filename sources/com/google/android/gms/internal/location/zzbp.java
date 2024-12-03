package com.google.android.gms.internal.location;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.common.api.internal.l;
import com.google.android.gms.common.api.internal.p;
import com.google.android.gms.common.api.internal.v;
import com.google.android.gms.location.CurrentLocationRequest;
import com.google.android.gms.location.LastLocationRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.d;
import com.google.android.gms.location.h;
import com.google.android.gms.location.h0;
import com.google.android.gms.location.i;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.Executor;

public final class zzbp extends c implements d {
    static final a.g zza;
    public static final a zzb;

    static {
        a.g gVar = new a.g();
        zza = gVar;
        zzb = new a("LocationServices.API", new zzbm(), gVar);
    }

    public zzbp(Activity activity) {
        super(activity, zzb, a.d.f38515i, c.a.f38516c);
    }

    private final Task zza(LocationRequest locationRequest, k kVar) {
        zzbo zzbo = new zzbo(this, kVar, zzax.zza);
        return doRegisterEventListener(p.a().b(new zzay(zzbo, locationRequest)).f(zzbo).g(kVar).e(2436).a());
    }

    private final Task zzb(LocationRequest locationRequest, k kVar) {
        zzbo zzbo = new zzbo(this, kVar, zzbd.zza);
        return doRegisterEventListener(p.a().b(new zzbf(zzbo, locationRequest)).f(zzbo).g(kVar).e(2435).a());
    }

    public final Task<Void> flushLocations() {
        return doWrite(v.a().b(zzav.zza).e(2422).a());
    }

    public final Task<Location> getCurrentLocation(int i10, CancellationToken cancellationToken) {
        CurrentLocationRequest.a aVar = new CurrentLocationRequest.a();
        aVar.b(i10);
        CurrentLocationRequest a10 = aVar.a();
        if (cancellationToken != null) {
            com.google.android.gms.common.internal.p.b(!cancellationToken.isCancellationRequested(), "cancellationToken may not be already canceled");
        }
        Task<Location> doRead = doRead(v.a().b(new zzbh(a10, cancellationToken)).e(2415).a());
        if (cancellationToken == null) {
            return doRead;
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource(cancellationToken);
        doRead.continueWith(new zzbi(taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    public final Task<Location> getLastLocation() {
        return doRead(v.a().b(zzbe.zza).e(2414).a());
    }

    public final Task<LocationAvailability> getLocationAvailability() {
        return doRead(v.a().b(zzba.zza).e(2416).a());
    }

    public final Task<Void> removeLocationUpdates(PendingIntent pendingIntent) {
        return doWrite(v.a().b(new zzbg(pendingIntent)).e(2418).a());
    }

    public final Task<Void> requestLocationUpdates(LocationRequest locationRequest, PendingIntent pendingIntent) {
        return doWrite(v.a().b(new zzaz(pendingIntent, locationRequest)).e(2417).a());
    }

    public final Task<Void> setMockLocation(Location location) {
        boolean z10;
        if (location != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.android.gms.common.internal.p.a(z10);
        return doWrite(v.a().b(new zzaw(location)).e(2421).a());
    }

    public final Task<Void> setMockMode(boolean z10) {
        return doWrite(v.a().b(new zzbb(z10)).e(2420).a());
    }

    public zzbp(Context context) {
        super(context, zzb, a.d.f38515i, c.a.f38516c);
    }

    public final Task<Location> getLastLocation(LastLocationRequest lastLocationRequest) {
        return doRead(v.a().b(new zzbj(lastLocationRequest)).e(2414).d(h0.f39586f).a());
    }

    public final Task<Void> removeLocationUpdates(h hVar) {
        return doUnregisterEventListener(l.c(hVar, h.class.getSimpleName()), 2418).continueWith(zzbk.zza, zzbc.zza);
    }

    public final Task<Void> requestLocationUpdates(LocationRequest locationRequest, h hVar, Looper looper) {
        if (looper == null) {
            looper = Looper.myLooper();
            com.google.android.gms.common.internal.p.l(looper, "invalid null looper");
        }
        return zza(locationRequest, l.a(hVar, looper, h.class.getSimpleName()));
    }

    public final Task<Void> removeLocationUpdates(i iVar) {
        return doUnregisterEventListener(l.c(iVar, i.class.getSimpleName()), 2418).continueWith(zzbk.zza, zzbl.zza);
    }

    public final Task<Void> requestLocationUpdates(LocationRequest locationRequest, i iVar, Looper looper) {
        if (looper == null) {
            looper = Looper.myLooper();
            com.google.android.gms.common.internal.p.l(looper, "invalid null looper");
        }
        return zzb(locationRequest, l.a(iVar, looper, i.class.getSimpleName()));
    }

    public final Task<Location> getCurrentLocation(CurrentLocationRequest currentLocationRequest, CancellationToken cancellationToken) {
        if (cancellationToken != null) {
            com.google.android.gms.common.internal.p.b(!cancellationToken.isCancellationRequested(), "cancellationToken may not be already canceled");
        }
        Task<Location> doRead = doRead(v.a().b(new zzbh(currentLocationRequest, cancellationToken)).e(2415).a());
        if (cancellationToken == null) {
            return doRead;
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource(cancellationToken);
        doRead.continueWith(new zzbi(taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    public final Task<Void> requestLocationUpdates(LocationRequest locationRequest, Executor executor, h hVar) {
        return zza(locationRequest, l.b(hVar, executor, h.class.getSimpleName()));
    }

    public final Task<Void> requestLocationUpdates(LocationRequest locationRequest, Executor executor, i iVar) {
        return zzb(locationRequest, l.b(iVar, executor, i.class.getSimpleName()));
    }
}

package com.google.firebase.auth.internal;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import me.i;

public final class zzbz {
    private static final zzbz zza = new zzbz();
    private final zzbf zzb;
    private final zzax zzc;

    private zzbz() {
        zzbf zzc2 = zzbf.zzc();
        zzax zza2 = zzax.zza();
        this.zzb = zzc2;
        this.zzc = zza2;
    }

    public static zzbz zzc() {
        return zza;
    }

    public final Task zza() {
        return this.zzb.zza();
    }

    public final Task zzb() {
        return this.zzb.zzb();
    }

    public final void zzd(Context context) {
        this.zzb.zzd(context);
    }

    public final void zze(FirebaseAuth firebaseAuth) {
        this.zzb.zze(firebaseAuth);
    }

    public final void zzf(Context context, Status status) {
        SharedPreferences.Editor edit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        edit.putInt("statusCode", status.Y());
        edit.putString("statusMessage", status.c0());
        edit.putLong("timestamp", i.c().currentTimeMillis());
        edit.commit();
    }

    public final void zzg(Context context, FirebaseAuth firebaseAuth) {
        p.k(context);
        p.k(firebaseAuth);
        SharedPreferences.Editor edit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        edit.putString("firebaseAppName", firebaseAuth.getApp().getName());
        edit.commit();
    }

    public final void zzh(Context context, FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        p.k(context);
        p.k(firebaseAuth);
        p.k(firebaseUser);
        SharedPreferences.Editor edit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        edit.putString("firebaseAppName", firebaseAuth.getApp().getName());
        edit.putString("firebaseUserUid", firebaseUser.getUid());
        edit.commit();
    }

    public final boolean zzi(Activity activity, TaskCompletionSource taskCompletionSource, FirebaseAuth firebaseAuth) {
        return this.zzc.zzf(activity, taskCompletionSource, firebaseAuth, (FirebaseUser) null);
    }

    public final boolean zzj(Activity activity, TaskCompletionSource taskCompletionSource, FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        return this.zzc.zzf(activity, taskCompletionSource, firebaseAuth, firebaseUser);
    }
}

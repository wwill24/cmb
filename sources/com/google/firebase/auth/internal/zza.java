package com.google.firebase.auth.internal;

import android.app.Activity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseAuth;

public final /* synthetic */ class zza implements OnCompleteListener {
    public final /* synthetic */ zzf zza;
    public final /* synthetic */ TaskCompletionSource zzb;
    public final /* synthetic */ FirebaseAuth zzc;
    public final /* synthetic */ zzbz zzd;
    public final /* synthetic */ Activity zze;

    public /* synthetic */ zza(zzf zzf, TaskCompletionSource taskCompletionSource, FirebaseAuth firebaseAuth, zzbz zzbz, Activity activity) {
        this.zza = zzf;
        this.zzb = taskCompletionSource;
        this.zzc = firebaseAuth;
        this.zzd = zzbz;
        this.zze = activity;
    }

    public final void onComplete(Task task) {
        this.zza.zze(this.zzb, this.zzc, this.zzd, this.zze, task);
    }
}

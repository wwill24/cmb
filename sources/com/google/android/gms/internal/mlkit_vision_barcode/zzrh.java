package com.google.android.gms.internal.mlkit_vision_barcode;

public final /* synthetic */ class zzrh implements Runnable {
    public final /* synthetic */ zzrl zza;
    public final /* synthetic */ zzra zzb;
    public final /* synthetic */ zzne zzc;
    public final /* synthetic */ String zzd;

    public /* synthetic */ zzrh(zzrl zzrl, zzra zzra, zzne zzne, String str) {
        this.zza = zzrl;
        this.zzb = zzra;
        this.zzc = zzne;
        this.zzd = str;
    }

    public final void run() {
        this.zza.zzc(this.zzb, this.zzc, this.zzd);
    }
}

package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.mlkit.vision.barcode.internal.g;

public final /* synthetic */ class zzrj implements Runnable {
    public final /* synthetic */ zzrl zza;
    public final /* synthetic */ zzne zzb;
    public final /* synthetic */ g zzc;

    public /* synthetic */ zzrj(zzrl zzrl, zzne zzne, g gVar) {
        this.zza = zzrl;
        this.zzb = zzne;
        this.zzc = gVar;
    }

    public final void run() {
        this.zza.zzg(this.zzb, this.zzc);
    }
}

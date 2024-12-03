package com.google.mlkit.vision.barcode.internal;

import com.google.android.gms.internal.mlkit_vision_barcode.zznc;
import com.google.android.gms.internal.mlkit_vision_barcode.zznd;
import com.google.android.gms.internal.mlkit_vision_barcode.zznf;
import com.google.android.gms.internal.mlkit_vision_barcode.zznu;
import com.google.android.gms.internal.mlkit_vision_barcode.zzra;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrk;
import com.google.android.gms.internal.mlkit_vision_barcode.zzro;

public final /* synthetic */ class a implements zzrk {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ zznd f21478a;

    public /* synthetic */ a(zznd zznd) {
        this.f21478a = zznd;
    }

    public final zzra zza() {
        zznc zznc;
        zznd zznd = this.f21478a;
        zznf zznf = new zznf();
        if (b.f()) {
            zznc = zznc.TYPE_THICK;
        } else {
            zznc = zznc.TYPE_THIN;
        }
        zznf.zze(zznc);
        zznu zznu = new zznu();
        zznu.zzb(zznd);
        zznf.zzh(zznu.zzc());
        return zzro.zzf(zznf);
    }
}

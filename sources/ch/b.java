package ch;

import com.google.android.gms.internal.mlkit_vision_face.zzkr;
import com.google.android.gms.internal.mlkit_vision_face.zzks;
import com.google.android.gms.internal.mlkit_vision_face.zzku;
import com.google.android.gms.internal.mlkit_vision_face.zzlm;
import com.google.android.gms.internal.mlkit_vision_face.zznr;
import com.google.android.gms.internal.mlkit_vision_face.zzoa;
import com.google.android.gms.internal.mlkit_vision_face.zzof;

public final /* synthetic */ class b implements zzoa {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f19002a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ zzks f19003b;

    public /* synthetic */ b(boolean z10, zzks zzks) {
        this.f19002a = z10;
        this.f19003b = zzks;
    }

    public final zznr zza() {
        zzkr zzkr;
        boolean z10 = this.f19002a;
        zzks zzks = this.f19003b;
        zzku zzku = new zzku();
        if (z10) {
            zzkr = zzkr.TYPE_THICK;
        } else {
            zzkr = zzkr.TYPE_THIN;
        }
        zzku.zze(zzkr);
        zzlm zzlm = new zzlm();
        zzlm.zzb(zzks);
        zzku.zzh(zzlm.zzc());
        return zzof.zzf(zzku);
    }
}

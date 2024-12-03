package eh;

import com.google.android.gms.internal.mlkit_vision_text_common.zzkr;
import com.google.android.gms.internal.mlkit_vision_text_common.zzks;
import com.google.android.gms.internal.mlkit_vision_text_common.zzku;
import com.google.android.gms.internal.mlkit_vision_text_common.zzmh;
import com.google.android.gms.internal.mlkit_vision_text_common.zznv;
import com.google.android.gms.internal.mlkit_vision_text_common.zzoe;
import com.google.android.gms.internal.mlkit_vision_text_common.zzoj;

public final /* synthetic */ class d implements zzoe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f23397a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ zzks f23398b;

    public /* synthetic */ d(boolean z10, zzks zzks) {
        this.f23397a = z10;
        this.f23398b = zzks;
    }

    public final zznv zza() {
        zzkr zzkr;
        boolean z10 = this.f23397a;
        zzks zzks = this.f23398b;
        zzku zzku = new zzku();
        if (z10) {
            zzkr = zzkr.TYPE_THICK;
        } else {
            zzkr = zzkr.TYPE_THIN;
        }
        zzku.zze(zzkr);
        zzmh zzmh = new zzmh();
        zzmh.zzb(zzks);
        zzku.zzg(zzmh.zzc());
        return zzoj.zzf(zzku);
    }
}

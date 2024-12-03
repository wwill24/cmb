package com.google.mlkit.vision.barcode.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.Feature;
import com.google.android.gms.internal.mlkit_vision_barcode.zznc;
import com.google.android.gms.internal.mlkit_vision_barcode.zzne;
import com.google.android.gms.internal.mlkit_vision_barcode.zznf;
import com.google.android.gms.internal.mlkit_vision_barcode.zznr;
import com.google.android.gms.internal.mlkit_vision_barcode.zznt;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrl;
import com.google.android.gms.internal.mlkit_vision_barcode.zzro;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.common.sdkinternal.l;
import com.google.mlkit.vision.common.internal.MobileVisionBase;
import java.util.List;
import java.util.concurrent.Executor;
import vg.b;
import wg.a;

public class BarcodeScannerImpl extends MobileVisionBase<List<a>> implements vg.a {

    /* renamed from: j  reason: collision with root package name */
    private static final b f21476j = new b.a().a();

    /* renamed from: h  reason: collision with root package name */
    private final boolean f21477h;

    BarcodeScannerImpl(@NonNull b bVar, @NonNull h hVar, @NonNull Executor executor, @NonNull zzrl zzrl) {
        super(hVar, executor);
        zznc zznc;
        boolean f10 = b.f();
        this.f21477h = f10;
        zznr zznr = new zznr();
        zznr.zzi(b.c(bVar));
        zznt zzj = zznr.zzj();
        zznf zznf = new zznf();
        if (f10) {
            zznc = zznc.TYPE_THICK;
        } else {
            zznc = zznc.TYPE_THIN;
        }
        zznf.zze(zznc);
        zznf.zzg(zzj);
        zzrl.zzd(zzro.zzg(zznf, 1), zzne.ON_DEVICE_BARCODE_CREATE);
    }

    @NonNull
    public final Feature[] a() {
        if (this.f21477h) {
            return l.f21415a;
        }
        return new Feature[]{l.f21416b};
    }

    @NonNull
    public final Task<List<a>> i(@NonNull zg.a aVar) {
        return super.b(aVar);
    }
}

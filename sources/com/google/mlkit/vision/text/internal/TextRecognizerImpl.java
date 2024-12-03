package com.google.mlkit.vision.text.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.Feature;
import com.google.android.gms.internal.mlkit_vision_text_common.zzkr;
import com.google.android.gms.internal.mlkit_vision_text_common.zzkt;
import com.google.android.gms.internal.mlkit_vision_text_common.zzku;
import com.google.android.gms.internal.mlkit_vision_text_common.zzmk;
import com.google.android.gms.internal.mlkit_vision_text_common.zzmn;
import com.google.android.gms.internal.mlkit_vision_text_common.zzog;
import com.google.android.gms.internal.mlkit_vision_text_common.zzoj;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.common.sdkinternal.l;
import com.google.mlkit.vision.common.internal.MobileVisionBase;
import dh.a;
import dh.c;
import dh.d;
import java.util.concurrent.Executor;

public class TextRecognizerImpl extends MobileVisionBase<a> implements c {

    /* renamed from: h  reason: collision with root package name */
    private final boolean f21572h;

    TextRecognizerImpl(@NonNull b bVar, @NonNull Executor executor, @NonNull zzog zzog, @NonNull d dVar) {
        super(bVar, executor);
        zzkr zzkr;
        boolean c10 = dVar.c();
        this.f21572h = c10;
        zzku zzku = new zzku();
        if (c10) {
            zzkr = zzkr.TYPE_THICK;
        } else {
            zzkr = zzkr.TYPE_THIN;
        }
        zzku.zze(zzkr);
        zzmk zzmk = new zzmk();
        zzmn zzmn = new zzmn();
        zzmn.zza(a.a(dVar.e()));
        zzmk.zze(zzmn.zzc());
        zzku.zzh(zzmk.zzf());
        zzog.zzd(zzoj.zzg(zzku, 1), zzkt.ON_DEVICE_TEXT_CREATE);
    }

    @NonNull
    public final Feature[] a() {
        if (this.f21572h) {
            return l.f21415a;
        }
        return new Feature[]{l.f21420f};
    }

    @NonNull
    public final Task<a> i(@NonNull zg.a aVar) {
        return super.b(aVar);
    }
}

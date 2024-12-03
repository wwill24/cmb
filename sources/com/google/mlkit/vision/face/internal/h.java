package com.google.mlkit.vision.face.internal;

import bh.e;
import ch.b;
import com.google.android.gms.internal.mlkit_vision_face.zzjx;
import com.google.android.gms.internal.mlkit_vision_face.zzjy;
import com.google.android.gms.internal.mlkit_vision_face.zzjz;
import com.google.android.gms.internal.mlkit_vision_face.zzka;
import com.google.android.gms.internal.mlkit_vision_face.zzkb;
import com.google.android.gms.internal.mlkit_vision_face.zzkd;
import com.google.android.gms.internal.mlkit_vision_face.zzks;
import com.google.android.gms.internal.mlkit_vision_face.zzkt;
import com.google.android.gms.internal.mlkit_vision_face.zzoc;
import com.google.mlkit.common.sdkinternal.i;
import java.util.concurrent.atomic.AtomicReference;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    static final AtomicReference f21563a = new AtomicReference();

    public static zzkd a(e eVar) {
        zzka zzka;
        zzjy zzjy;
        zzkb zzkb;
        zzjz zzjz;
        zzjx zzjx = new zzjx();
        int d10 = eVar.d();
        if (d10 == 1) {
            zzka = zzka.NO_LANDMARKS;
        } else if (d10 != 2) {
            zzka = zzka.UNKNOWN_LANDMARKS;
        } else {
            zzka = zzka.ALL_LANDMARKS;
        }
        zzjx.zzd(zzka);
        int b10 = eVar.b();
        if (b10 == 1) {
            zzjy = zzjy.NO_CLASSIFICATIONS;
        } else if (b10 != 2) {
            zzjy = zzjy.UNKNOWN_CLASSIFICATIONS;
        } else {
            zzjy = zzjy.ALL_CLASSIFICATIONS;
        }
        zzjx.zza(zzjy);
        int e10 = eVar.e();
        if (e10 == 1) {
            zzkb = zzkb.FAST;
        } else if (e10 != 2) {
            zzkb = zzkb.UNKNOWN_PERFORMANCE;
        } else {
            zzkb = zzkb.ACCURATE;
        }
        zzjx.zzf(zzkb);
        int c10 = eVar.c();
        if (c10 == 1) {
            zzjz = zzjz.NO_CONTOURS;
        } else if (c10 != 2) {
            zzjz = zzjz.UNKNOWN_CONTOURS;
        } else {
            zzjz = zzjz.ALL_CONTOURS;
        }
        zzjx.zzb(zzjz);
        zzjx.zzc(Boolean.valueOf(eVar.g()));
        zzjx.zze(Float.valueOf(eVar.a()));
        return zzjx.zzk();
    }

    public static String b() {
        return true != d() ? "play-services-mlkit-face-detection" : "face-detection";
    }

    public static void c(zzoc zzoc, boolean z10, zzks zzks) {
        zzoc.zzf(new b(z10, zzks), zzkt.ON_DEVICE_FACE_LOAD);
    }

    static boolean d() {
        AtomicReference atomicReference = f21563a;
        if (atomicReference.get() != null) {
            return ((Boolean) atomicReference.get()).booleanValue();
        }
        boolean b10 = a.b(i.c().b());
        atomicReference.set(Boolean.valueOf(b10));
        return b10;
    }
}

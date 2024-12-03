package com.google.mlkit.vision.face.internal;

import androidx.annotation.NonNull;
import bh.a;
import bh.d;
import bh.e;
import com.google.android.gms.common.Feature;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.common.sdkinternal.l;
import com.google.mlkit.vision.common.internal.MobileVisionBase;
import java.util.List;

public class FaceDetectorImpl extends MobileVisionBase<List<a>> implements d {

    /* renamed from: j  reason: collision with root package name */
    static final e f21535j = new e.a().a();

    /* renamed from: h  reason: collision with root package name */
    private final boolean f21536h;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* synthetic */ FaceDetectorImpl(com.google.mlkit.vision.face.internal.g r1, com.google.mlkit.common.sdkinternal.d r2, bh.e r3, ch.a r4) {
        /*
            r0 = this;
            java.util.concurrent.Executor r4 = r3.f()
            java.util.concurrent.Executor r2 = r2.a(r4)
            java.lang.String r4 = com.google.mlkit.vision.face.internal.h.b()
            com.google.android.gms.internal.mlkit_vision_face.zzoc r4 = com.google.android.gms.internal.mlkit_vision_face.zzon.zzb(r4)
            r0.<init>(r1, r2)
            boolean r1 = com.google.mlkit.vision.face.internal.h.d()
            r0.f21536h = r1
            com.google.android.gms.internal.mlkit_vision_face.zzku r2 = new com.google.android.gms.internal.mlkit_vision_face.zzku
            r2.<init>()
            if (r1 == 0) goto L_0x0023
            com.google.android.gms.internal.mlkit_vision_face.zzkr r1 = com.google.android.gms.internal.mlkit_vision_face.zzkr.TYPE_THICK
            goto L_0x0025
        L_0x0023:
            com.google.android.gms.internal.mlkit_vision_face.zzkr r1 = com.google.android.gms.internal.mlkit_vision_face.zzkr.TYPE_THIN
        L_0x0025:
            r2.zze(r1)
            com.google.android.gms.internal.mlkit_vision_face.zzlj r1 = new com.google.android.gms.internal.mlkit_vision_face.zzlj
            r1.<init>()
            com.google.android.gms.internal.mlkit_vision_face.zzkd r3 = com.google.mlkit.vision.face.internal.h.a(r3)
            r1.zze(r3)
            com.google.android.gms.internal.mlkit_vision_face.zzll r1 = r1.zzi()
            r2.zzg(r1)
            r1 = 1
            com.google.android.gms.internal.mlkit_vision_face.zznr r1 = com.google.android.gms.internal.mlkit_vision_face.zzof.zzg(r2, r1)
            com.google.android.gms.internal.mlkit_vision_face.zzkt r2 = com.google.android.gms.internal.mlkit_vision_face.zzkt.ON_DEVICE_FACE_CREATE
            r4.zzd(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.vision.face.internal.FaceDetectorImpl.<init>(com.google.mlkit.vision.face.internal.g, com.google.mlkit.common.sdkinternal.d, bh.e, ch.a):void");
    }

    @NonNull
    public final Feature[] a() {
        if (this.f21536h) {
            return l.f21415a;
        }
        return new Feature[]{l.f21418d};
    }

    @NonNull
    public final Task<List<a>> i(@NonNull zg.a aVar) {
        return super.b(aVar);
    }
}

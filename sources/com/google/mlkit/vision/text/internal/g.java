package com.google.mlkit.vision.text.internal;

import android.graphics.Matrix;
import android.graphics.Rect;
import com.google.android.gms.internal.mlkit_vision_text_common.zzab;
import com.google.android.gms.internal.mlkit_vision_text_common.zzbm;
import com.google.android.gms.internal.mlkit_vision_text_common.zzr;
import com.google.android.gms.internal.mlkit_vision_text_common.zzu;
import dh.a;
import java.util.List;

public final /* synthetic */ class g implements zzu {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Matrix f21591a;

    public /* synthetic */ g(Matrix matrix) {
        this.f21591a = matrix;
    }

    public final Object zza(Object obj) {
        String str;
        String str2;
        Matrix matrix = this.f21591a;
        zzr zzr = (zzr) obj;
        List b10 = c.b(zzr.zzb);
        if (zzab.zzb(zzr.zzd)) {
            str = "";
        } else {
            str = zzr.zzd;
        }
        String str3 = str;
        Rect a10 = c.a(b10);
        if (zzab.zzb(zzr.zzf)) {
            str2 = "und";
        } else {
            str2 = zzr.zzf;
        }
        return new a.C0271a(str3, a10, b10, str2, matrix, zzr.zze, zzr.zzb.zze, zzbm.zzj());
    }
}

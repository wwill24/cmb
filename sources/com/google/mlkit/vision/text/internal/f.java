package com.google.mlkit.vision.text.internal;

import android.graphics.Matrix;
import android.graphics.Rect;
import com.google.android.gms.internal.mlkit_vision_text_common.zzab;
import com.google.android.gms.internal.mlkit_vision_text_common.zzbw;
import com.google.android.gms.internal.mlkit_vision_text_common.zzl;
import com.google.android.gms.internal.mlkit_vision_text_common.zzu;
import dh.a;
import java.util.Arrays;
import java.util.List;

public final /* synthetic */ class f implements zzu {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Matrix f21590a;

    public /* synthetic */ f(Matrix matrix) {
        this.f21590a = matrix;
    }

    public final Object zza(Object obj) {
        String str;
        String str2;
        Matrix matrix = this.f21590a;
        zzl zzl = (zzl) obj;
        List b10 = c.b(zzl.zzb);
        if (zzab.zzb(zzl.zze)) {
            str = "";
        } else {
            str = zzl.zze;
        }
        String str3 = str;
        Rect a10 = c.a(b10);
        if (zzab.zzb(zzl.zzg)) {
            str2 = "und";
        } else {
            str2 = zzl.zzg;
        }
        return new a.b(str3, a10, b10, str2, matrix, zzbw.zza(Arrays.asList(zzl.zza), new g(matrix)), zzl.zzf, zzl.zzb.zze);
    }
}

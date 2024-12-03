package com.google.android.gms.internal.mlkit_common;

import android.os.SystemClock;
import com.google.android.gms.common.internal.h;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.m;
import tg.b;

public final class zzpz {
    private static final h zza = new h("RemoteModelUtils", "");

    public static zzlk zza(b bVar, m mVar, zzpp zzpp) {
        zzlm zzlm;
        ModelType zzb = zzpp.zzb();
        String a10 = bVar.a();
        zzlq zzlq = new zzlq();
        zzll zzll = new zzll();
        zzll.zzc(bVar.b());
        zzll.zzd(zzln.CLOUD);
        zzll.zza(zzag.zzb(a10));
        int ordinal = zzb.ordinal();
        if (ordinal == 2) {
            zzlm = zzlm.BASE_TRANSLATE;
        } else if (ordinal == 4) {
            zzlm = zzlm.CUSTOM;
        } else if (ordinal != 5) {
            zzlm = zzlm.TYPE_UNKNOWN;
        } else {
            zzlm = zzlm.BASE_DIGITAL_INK;
        }
        zzll.zzb(zzlm);
        zzlq.zzb(zzll.zzg());
        zzlt zzc = zzlq.zzc();
        zzlh zzlh = new zzlh();
        zzlh.zzd(zzpp.zzc());
        zzlh.zzc(zzpp.zzd());
        zzlh.zzb(Long.valueOf((long) zzpp.zza()));
        zzlh.zzf(zzc);
        if (zzpp.zzg()) {
            long b10 = mVar.b(bVar);
            if (b10 == 0) {
                zza.f("RemoteModelUtils", "Model downloaded without its beginning time recorded.");
            } else {
                long c10 = mVar.c(bVar);
                if (c10 == 0) {
                    c10 = SystemClock.elapsedRealtime();
                    mVar.d(bVar, c10);
                }
                zzlh.zzg(Long.valueOf(c10 - b10));
            }
        }
        if (zzpp.zzf()) {
            long b11 = mVar.b(bVar);
            if (b11 == 0) {
                zza.f("RemoteModelUtils", "Model downloaded without its beginning time recorded.");
            } else {
                zzlh.zze(Long.valueOf(SystemClock.elapsedRealtime() - b11));
            }
        }
        return zzlh.zzi();
    }
}

package com.google.android.recaptcha.internal;

import android.content.ContentValues;
import com.mparticle.kits.ReportingMessage;
import gk.g;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

final class zzan extends SuspendLambda implements Function2 {
    final /* synthetic */ zzkx zza;
    final /* synthetic */ zzao zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzan(zzkx zzkx, zzao zzao, c cVar) {
        super(2, cVar);
        this.zza = zzkx;
        this.zzb = zzao;
    }

    public final c create(Object obj, c cVar) {
        return new zzan(this.zza, this.zzb, cVar);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzan) create((k0) obj, (c) obj2)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = b.d();
        g.b(obj);
        zzkx zzkx = this.zza;
        zzao zzao = this.zzb;
        synchronized (zzaj.class) {
            byte[] zzd = zzkx.zzd();
            zzae zzae = new zzae(zzeb.zzg().zzi(zzd, 0, zzd.length), System.currentTimeMillis(), 0);
            zzad zza2 = zzao.zze;
            ContentValues contentValues = new ContentValues();
            contentValues.put(ReportingMessage.MessageType.SESSION_START, zzae.zzc());
            contentValues.put("ts", Long.valueOf(zzae.zzb()));
            zza2.getWritableDatabase().insert("ce", (String) null, contentValues);
            int zzb2 = zzao.zze.zzb() - 500;
            if (zzb2 > 0) {
                zzao.zze.zza(CollectionsKt___CollectionsKt.s0(zzao.zze.zzd(), zzb2));
            }
            if (zzao.zze.zzb() >= 20) {
                zzao.zzg();
            }
        }
        return Unit.f32013a;
    }
}

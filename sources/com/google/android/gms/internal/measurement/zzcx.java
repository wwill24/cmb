package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import pe.b;
import we.k;

final class zzcx extends zzdu {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ Context zzc;
    final /* synthetic */ Bundle zzd;
    final /* synthetic */ zzef zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcx(zzef zzef, String str, String str2, Context context, Bundle bundle) {
        super(zzef, true);
        this.zze = zzef;
        this.zza = str;
        this.zzb = str2;
        this.zzc = context;
        this.zzd = bundle;
    }

    public final void zza() {
        String str;
        String str2;
        String str3;
        boolean z10;
        try {
            if (this.zze.zzW(this.zza, this.zzb)) {
                String str4 = this.zzb;
                str2 = this.zza;
                str = str4;
                str3 = this.zze.zzd;
            } else {
                str3 = null;
                str2 = null;
                str = null;
            }
            p.k(this.zzc);
            zzef zzef = this.zze;
            zzef.zzj = zzef.zzf(this.zzc, true);
            if (this.zze.zzj == null) {
                String unused = this.zze.zzd;
                return;
            }
            int a10 = DynamiteModule.a(this.zzc, ModuleDescriptor.MODULE_ID);
            int b10 = DynamiteModule.b(this.zzc, ModuleDescriptor.MODULE_ID);
            int max = Math.max(a10, b10);
            if (b10 < a10) {
                z10 = true;
            } else {
                z10 = false;
            }
            ((zzcc) p.k(this.zze.zzj)).initialize(b.g(this.zzc), new zzcl(79000, (long) max, z10, str3, str2, str, this.zzd, k.a(this.zzc)), this.zzh);
        } catch (Exception e10) {
            this.zze.zzT(e10, true, false);
        }
    }
}

package com.google.android.recaptcha.internal;

import android.os.Build;
import gk.g;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.a;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.s1;
import kotlinx.coroutines.w;

final class zzcz extends SuspendLambda implements Function2 {
    int zza;
    final /* synthetic */ zzda zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcz(zzda zzda, c cVar) {
        super(2, cVar);
        this.zzb = zzda;
    }

    public final c create(Object obj, c cVar) {
        return new zzcz(this.zzb, cVar);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzcz) create((k0) obj, (c) obj2)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.zza;
        g.b(obj);
        if (i10 == 0) {
            zzu zzu = zzu.zza;
            String zza2 = zzu.zza(this.zzb.zze);
            String zzj = this.zzb.zzd;
            String packageName = this.zzb.zze.getPackageName();
            String zzi = this.zzb.zzh;
            int i11 = Build.VERSION.SDK_INT;
            String encode = URLEncoder.encode(zzj, "UTF-8");
            String encode2 = URLEncoder.encode(packageName, "UTF-8");
            String encode3 = URLEncoder.encode(zza2, "UTF-8");
            String encode4 = URLEncoder.encode("18.1.2", "UTF-8");
            String encode5 = URLEncoder.encode(zzi, "UTF-8");
            byte[] bytes = ("k=" + encode + "&pk=" + encode2 + "&mst=" + encode3 + "&msv=" + encode4 + "&msi=" + encode5 + "&mov=" + i11).getBytes(Charset.forName("UTF-8"));
            zzai zzai = zzai.zza;
            zzai.zzc(new zzaf(zzkw.INIT_NATIVE, this.zzb.zzg, this.zzb.zzh, this.zzb.zzh, (String) null), this.zzb.zze, this.zzb.zzf);
            zzai.zzb(new zzaf(zzkw.INIT_NETWORK, this.zzb.zzg, this.zzb.zzh, this.zzb.zzh, (String) null), this.zzb.zzd, new zzs());
            s1 unused = j.d(zzp.zza(), (CoroutineContext) null, (CoroutineStart) null, new zzcy(this.zzb, zza2, (c) null), 3, (Object) null);
            this.zzb.zzn.zzd();
            this.zzb.zzn.zze();
            zzda zzda = this.zzb;
            zzda.zzb().postUrl(zzda.zzf.zza(), bytes);
            a.b(this.zzb.zzm().hashCode());
            w zzm = this.zzb.zzm();
            this.zza = 1;
            if (zzm.v(this) == d10) {
                return d10;
            }
        }
        return Result.a(Result.b(Unit.f32013a));
    }
}

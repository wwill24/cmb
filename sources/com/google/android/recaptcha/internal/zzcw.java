package com.google.android.recaptcha.internal;

import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.google.android.recaptcha.RecaptchaAction;
import gk.g;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.o;

final class zzcw extends SuspendLambda implements Function2 {
    Object zza;
    Object zzb;
    Object zzc;
    int zzd;
    final /* synthetic */ RecaptchaAction zze;
    final /* synthetic */ zzda zzf;
    final /* synthetic */ String zzg;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcw(RecaptchaAction recaptchaAction, zzda zzda, String str, c cVar) {
        super(2, cVar);
        this.zze = recaptchaAction;
        this.zzf = zzda;
        this.zzg = str;
    }

    public final c create(Object obj, c cVar) {
        return new zzcw(this.zze, this.zzf, this.zzg, cVar);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzcw) create((k0) obj, (c) obj2)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.zzd;
        g.b(obj);
        if (i10 == 0) {
            zzda zzda = this.zzf;
            String str = this.zzg;
            RecaptchaAction recaptchaAction = this.zze;
            this.zza = zzda;
            this.zzb = str;
            this.zzc = recaptchaAction;
            this.zzd = 1;
            o oVar = new o(IntrinsicsKt__IntrinsicsJvmKt.c(this), 1);
            oVar.y();
            zzda.zzk.put(str, oVar);
            zzma zzf2 = zzmb.zzf();
            zzf2.zze(str);
            zzf2.zzd(recaptchaAction.getAction());
            byte[] zzd2 = ((zzmb) zzf2.zzj()).zzd();
            String zzi = zzeb.zzh().zzi(zzd2, 0, zzd2.length);
            zzai zzai = zzai.zza;
            zzai.zzc(new zzaf(zzkw.EXECUTE_NATIVE, zzda.zzg, zzda.zzh, str, (String) null), zzda.zze, zzda.zzf);
            WebView zzb2 = zzda.zzb();
            zzb2.evaluateJavascript("recaptcha.m.Main.execute(\"" + zzi + "\")", (ValueCallback) null);
            obj = oVar.v();
            if (obj == b.d()) {
                f.c(this);
            }
            if (obj == d10) {
                return d10;
            }
        }
        return obj;
    }
}

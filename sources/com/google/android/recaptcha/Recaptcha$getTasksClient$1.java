package com.google.android.recaptcha;

import android.app.Application;
import android.webkit.WebView;
import com.google.android.recaptcha.internal.zzaa;
import com.google.android.recaptcha.internal.zzr;
import com.google.android.recaptcha.internal.zzw;
import gk.g;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.k0;

final class Recaptcha$getTasksClient$1 extends SuspendLambda implements Function2<k0, c<? super zzaa>, Object> {
    int zza;
    final /* synthetic */ Application zzb;
    final /* synthetic */ String zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Recaptcha$getTasksClient$1(Application application, String str, c cVar) {
        super(2, cVar);
        this.zzb = application;
        this.zzc = str;
    }

    public final c create(Object obj, c cVar) {
        return new Recaptcha$getTasksClient$1(this.zzb, this.zzc, cVar);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((Recaptcha$getTasksClient$1) create((k0) obj, (c) obj2)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.zza;
        g.b(obj);
        if (i10 == 0) {
            zzw zzw = zzaa.zza;
            Application application = this.zzb;
            String str = this.zzc;
            this.zza = 1;
            obj = zzw.zza(application, str, new zzr((String) null, 0, 0, 7, (DefaultConstructorMarker) null), (WebView) null, this);
            if (obj == d10) {
                return d10;
            }
        }
        return obj;
    }
}

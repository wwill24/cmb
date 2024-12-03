package com.google.android.recaptcha.internal;

import android.webkit.ValueCallback;
import com.mparticle.kits.AppsFlyerKit;
import gk.g;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

final class zzbb extends SuspendLambda implements Function2 {
    final /* synthetic */ String[] zza;
    final /* synthetic */ zzbc zzb;
    final /* synthetic */ String zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbb(String[] strArr, zzbc zzbc, String str, c cVar) {
        super(2, cVar);
        this.zza = strArr;
        this.zzb = zzbc;
        this.zzc = str;
    }

    public final c create(Object obj, c cVar) {
        return new zzbb(this.zza, this.zzb, this.zzc, cVar);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzbb) create((k0) obj, (c) obj2)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = b.d();
        g.b(obj);
        ArrayList arrayList = new ArrayList(r1);
        for (String str : this.zza) {
            arrayList.add("\"" + str + "\"");
        }
        this.zzb.zza.evaluateJavascript(this.zzc + "(" + CollectionsKt___CollectionsKt.W(arrayList, AppsFlyerKit.COMMA, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) + ")", (ValueCallback) null);
        return Unit.f32013a;
    }
}

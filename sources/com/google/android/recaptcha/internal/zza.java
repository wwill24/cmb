package com.google.android.recaptcha.internal;

import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.p0;

final class zza extends Lambda implements Function1 {
    final /* synthetic */ TaskCompletionSource zza;
    final /* synthetic */ p0 zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zza(TaskCompletionSource taskCompletionSource, p0 p0Var) {
        super(1);
        this.zza = taskCompletionSource;
        this.zzb = p0Var;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        Exception exc;
        Throwable th2 = (Throwable) obj;
        if (th2 instanceof CancellationException) {
            this.zza.setException((Exception) th2);
        } else {
            Throwable l10 = this.zzb.l();
            if (l10 == null) {
                this.zza.setResult(this.zzb.f());
            } else {
                TaskCompletionSource taskCompletionSource = this.zza;
                if (l10 instanceof Exception) {
                    exc = (Exception) l10;
                } else {
                    exc = null;
                }
                if (exc == null) {
                    exc = new RuntimeExecutionException(l10);
                }
                taskCompletionSource.setException(exc);
            }
        }
        return Unit.f32013a;
    }
}

package com.google.android.gms.tasks;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

final class zzw<TResult> extends Task<TResult> {
    private final Object zza = new Object();
    private final zzr zzb = new zzr();
    private boolean zzc;
    private volatile boolean zzd;
    private Object zze;
    private Exception zzf;

    zzw() {
    }

    private final void zzf() {
        p.p(this.zzc, "Task is not yet complete");
    }

    private final void zzg() {
        if (this.zzd) {
            throw new CancellationException("Task is already canceled.");
        }
    }

    private final void zzh() {
        if (this.zzc) {
            throw DuplicateTaskCompletionException.of(this);
        }
    }

    private final void zzi() {
        synchronized (this.zza) {
            if (this.zzc) {
                this.zzb.zzb(this);
            }
        }
    }

    @NonNull
    public final Task<TResult> addOnCanceledListener(@NonNull Activity activity, @NonNull OnCanceledListener onCanceledListener) {
        zzh zzh = new zzh(TaskExecutors.MAIN_THREAD, onCanceledListener);
        this.zzb.zza(zzh);
        zzv.zza(activity).zzb(zzh);
        zzi();
        return this;
    }

    @NonNull
    public final Task<TResult> addOnCompleteListener(@NonNull Activity activity, @NonNull OnCompleteListener<TResult> onCompleteListener) {
        zzj zzj = new zzj(TaskExecutors.MAIN_THREAD, onCompleteListener);
        this.zzb.zza(zzj);
        zzv.zza(activity).zzb(zzj);
        zzi();
        return this;
    }

    @NonNull
    public final Task<TResult> addOnFailureListener(@NonNull Activity activity, @NonNull OnFailureListener onFailureListener) {
        zzl zzl = new zzl(TaskExecutors.MAIN_THREAD, onFailureListener);
        this.zzb.zza(zzl);
        zzv.zza(activity).zzb(zzl);
        zzi();
        return this;
    }

    @NonNull
    public final Task<TResult> addOnSuccessListener(@NonNull Activity activity, @NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        zzn zzn = new zzn(TaskExecutors.MAIN_THREAD, onSuccessListener);
        this.zzb.zza(zzn);
        zzv.zza(activity).zzb(zzn);
        zzi();
        return this;
    }

    @NonNull
    public final <TContinuationResult> Task<TContinuationResult> continueWith(@NonNull Continuation<TResult, TContinuationResult> continuation) {
        return continueWith(TaskExecutors.MAIN_THREAD, continuation);
    }

    @NonNull
    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(@NonNull Continuation<TResult, Task<TContinuationResult>> continuation) {
        return continueWithTask(TaskExecutors.MAIN_THREAD, continuation);
    }

    public final Exception getException() {
        Exception exc;
        synchronized (this.zza) {
            exc = this.zzf;
        }
        return exc;
    }

    public final TResult getResult() {
        TResult tresult;
        synchronized (this.zza) {
            zzf();
            zzg();
            Exception exc = this.zzf;
            if (exc == null) {
                tresult = this.zze;
            } else {
                throw new RuntimeExecutionException(exc);
            }
        }
        return tresult;
    }

    public final boolean isCanceled() {
        return this.zzd;
    }

    public final boolean isComplete() {
        boolean z10;
        synchronized (this.zza) {
            z10 = this.zzc;
        }
        return z10;
    }

    public final boolean isSuccessful() {
        boolean z10;
        synchronized (this.zza) {
            z10 = false;
            if (this.zzc && !this.zzd && this.zzf == null) {
                z10 = true;
            }
        }
        return z10;
    }

    @NonNull
    public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(@NonNull SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        Executor executor = TaskExecutors.MAIN_THREAD;
        zzw zzw = new zzw();
        this.zzb.zza(new zzp(executor, successContinuation, zzw));
        zzi();
        return zzw;
    }

    public final void zza(@NonNull Exception exc) {
        p.l(exc, "Exception must not be null");
        synchronized (this.zza) {
            zzh();
            this.zzc = true;
            this.zzf = exc;
        }
        this.zzb.zzb(this);
    }

    public final void zzb(Object obj) {
        synchronized (this.zza) {
            zzh();
            this.zzc = true;
            this.zze = obj;
        }
        this.zzb.zzb(this);
    }

    public final boolean zzc() {
        synchronized (this.zza) {
            if (this.zzc) {
                return false;
            }
            this.zzc = true;
            this.zzd = true;
            this.zzb.zzb(this);
            return true;
        }
    }

    public final boolean zzd(@NonNull Exception exc) {
        p.l(exc, "Exception must not be null");
        synchronized (this.zza) {
            if (this.zzc) {
                return false;
            }
            this.zzc = true;
            this.zzf = exc;
            this.zzb.zzb(this);
            return true;
        }
    }

    public final boolean zze(Object obj) {
        synchronized (this.zza) {
            if (this.zzc) {
                return false;
            }
            this.zzc = true;
            this.zze = obj;
            this.zzb.zzb(this);
            return true;
        }
    }

    @NonNull
    public final <TContinuationResult> Task<TContinuationResult> continueWith(@NonNull Executor executor, @NonNull Continuation<TResult, TContinuationResult> continuation) {
        zzw zzw = new zzw();
        this.zzb.zza(new zzd(executor, continuation, zzw));
        zzi();
        return zzw;
    }

    @NonNull
    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(@NonNull Executor executor, @NonNull Continuation<TResult, Task<TContinuationResult>> continuation) {
        zzw zzw = new zzw();
        this.zzb.zza(new zzf(executor, continuation, zzw));
        zzi();
        return zzw;
    }

    @NonNull
    public final Task<TResult> addOnCanceledListener(@NonNull OnCanceledListener onCanceledListener) {
        addOnCanceledListener(TaskExecutors.MAIN_THREAD, onCanceledListener);
        return this;
    }

    @NonNull
    public final Task<TResult> addOnCompleteListener(@NonNull OnCompleteListener<TResult> onCompleteListener) {
        this.zzb.zza(new zzj(TaskExecutors.MAIN_THREAD, onCompleteListener));
        zzi();
        return this;
    }

    @NonNull
    public final Task<TResult> addOnFailureListener(@NonNull OnFailureListener onFailureListener) {
        addOnFailureListener(TaskExecutors.MAIN_THREAD, onFailureListener);
        return this;
    }

    @NonNull
    public final Task<TResult> addOnSuccessListener(@NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        addOnSuccessListener(TaskExecutors.MAIN_THREAD, onSuccessListener);
        return this;
    }

    @NonNull
    public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(Executor executor, SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        zzw zzw = new zzw();
        this.zzb.zza(new zzp(executor, successContinuation, zzw));
        zzi();
        return zzw;
    }

    @NonNull
    public final Task<TResult> addOnCanceledListener(@NonNull Executor executor, @NonNull OnCanceledListener onCanceledListener) {
        this.zzb.zza(new zzh(executor, onCanceledListener));
        zzi();
        return this;
    }

    @NonNull
    public final Task<TResult> addOnFailureListener(@NonNull Executor executor, @NonNull OnFailureListener onFailureListener) {
        this.zzb.zza(new zzl(executor, onFailureListener));
        zzi();
        return this;
    }

    @NonNull
    public final Task<TResult> addOnSuccessListener(@NonNull Executor executor, @NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        this.zzb.zza(new zzn(executor, onSuccessListener));
        zzi();
        return this;
    }

    @NonNull
    public final Task<TResult> addOnCompleteListener(@NonNull Executor executor, @NonNull OnCompleteListener<TResult> onCompleteListener) {
        this.zzb.zza(new zzj(executor, onCompleteListener));
        zzi();
        return this;
    }

    public final <X extends Throwable> TResult getResult(@NonNull Class<X> cls) throws Throwable {
        TResult tresult;
        synchronized (this.zza) {
            zzf();
            zzg();
            if (!cls.isInstance(this.zzf)) {
                Exception exc = this.zzf;
                if (exc == null) {
                    tresult = this.zze;
                } else {
                    throw new RuntimeExecutionException(exc);
                }
            } else {
                throw ((Throwable) cls.cast(this.zzf));
            }
        }
        return tresult;
    }
}

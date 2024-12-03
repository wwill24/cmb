package com.google.mlkit.common.sdkinternal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.mlkit_common.zzox;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.mlkit.common.MlKitException;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class k {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    protected final n f21412a;

    /* renamed from: b  reason: collision with root package name */
    private final AtomicInteger f21413b;

    /* renamed from: c  reason: collision with root package name */
    private final AtomicBoolean f21414c;

    public k() {
        this.f21413b = new AtomicInteger(0);
        this.f21414c = new AtomicBoolean(false);
        this.f21412a = new n();
    }

    @NonNull
    public <T> Task<T> a(@NonNull Executor executor, @NonNull Callable<T> callable, @NonNull CancellationToken cancellationToken) {
        boolean z10;
        if (this.f21413b.get() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        p.o(z10);
        if (cancellationToken.isCancellationRequested()) {
            return Tasks.forCanceled();
        }
        CancellationTokenSource cancellationTokenSource = new CancellationTokenSource();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource(cancellationTokenSource.getToken());
        this.f21412a.a(new x(executor, cancellationToken, cancellationTokenSource, taskCompletionSource), new y(this, cancellationToken, cancellationTokenSource, callable, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    public abstract void b() throws MlKitException;

    public void c() {
        this.f21413b.incrementAndGet();
    }

    /* access modifiers changed from: protected */
    public abstract void d();

    public void e(@NonNull Executor executor) {
        f(executor);
    }

    @NonNull
    public Task<Void> f(@NonNull Executor executor) {
        boolean z10;
        if (this.f21413b.get() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        p.o(z10);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f21412a.a(executor, new w(this, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void g(CancellationToken cancellationToken, CancellationTokenSource cancellationTokenSource, Callable callable, TaskCompletionSource taskCompletionSource) {
        if (cancellationToken.isCancellationRequested()) {
            cancellationTokenSource.cancel();
            return;
        }
        try {
            if (!this.f21414c.get()) {
                b();
                this.f21414c.set(true);
            }
            if (cancellationToken.isCancellationRequested()) {
                cancellationTokenSource.cancel();
                return;
            }
            Object call = callable.call();
            if (cancellationToken.isCancellationRequested()) {
                cancellationTokenSource.cancel();
            } else {
                taskCompletionSource.setResult(call);
            }
        } catch (RuntimeException e10) {
            throw new MlKitException("Internal error has occurred when executing ML Kit tasks", 13, e10);
        } catch (Exception e11) {
            if (cancellationToken.isCancellationRequested()) {
                cancellationTokenSource.cancel();
            } else {
                taskCompletionSource.setException(e11);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void h(TaskCompletionSource taskCompletionSource) {
        boolean z10;
        int decrementAndGet = this.f21413b.decrementAndGet();
        if (decrementAndGet >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        p.o(z10);
        if (decrementAndGet == 0) {
            d();
            this.f21414c.set(false);
        }
        zzox.zza();
        taskCompletionSource.setResult(null);
    }

    protected k(@NonNull n nVar) {
        this.f21413b = new AtomicInteger(0);
        this.f21414c = new AtomicBoolean(false);
        this.f21412a = nVar;
    }
}

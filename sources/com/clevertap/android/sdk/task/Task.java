package com.clevertap.android.sdk.task;

import androidx.annotation.NonNull;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.p;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import u4.c;
import u4.d;

public class Task<TResult> {

    /* renamed from: a  reason: collision with root package name */
    protected final CleverTapInstanceConfig f10778a;

    /* renamed from: b  reason: collision with root package name */
    protected final Executor f10779b;

    /* renamed from: c  reason: collision with root package name */
    protected final Executor f10780c;

    /* renamed from: d  reason: collision with root package name */
    protected final List<d<Exception>> f10781d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    protected TResult f10782e;

    /* renamed from: f  reason: collision with root package name */
    protected final List<g<TResult>> f10783f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    protected STATE f10784g = STATE.READY_TO_RUN;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final String f10785h;

    protected enum STATE {
        FAILED,
        SUCCESS,
        READY_TO_RUN,
        RUNNING
    }

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f10791a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Callable f10792b;

        a(String str, Callable callable) {
            this.f10791a = str;
            this.f10792b = callable;
        }

        public void run() {
            try {
                p n10 = Task.this.f10778a.n();
                n10.s(Task.this.f10785h + " Task: " + this.f10791a + " starting on..." + Thread.currentThread().getName());
                Object call = this.f10792b.call();
                p n11 = Task.this.f10778a.n();
                n11.s(Task.this.f10785h + " Task: " + this.f10791a + " executed successfully on..." + Thread.currentThread().getName());
                Task.this.i(call);
            } catch (Exception e10) {
                Task.this.h(e10);
                p n12 = Task.this.f10778a.n();
                n12.v(Task.this.f10785h + " Task: " + this.f10791a + " failed to execute on..." + Thread.currentThread().getName(), e10);
                e10.printStackTrace();
            }
        }
    }

    Task(CleverTapInstanceConfig cleverTapInstanceConfig, Executor executor, Executor executor2, String str) {
        this.f10780c = executor;
        this.f10779b = executor2;
        this.f10778a = cleverTapInstanceConfig;
        this.f10785h = str;
    }

    private Runnable g(String str, Callable<TResult> callable) {
        return new a(str, callable);
    }

    @NonNull
    public synchronized Task<TResult> b(@NonNull Executor executor, c<Exception> cVar) {
        if (cVar != null) {
            this.f10781d.add(new d(executor, cVar));
        }
        return this;
    }

    @NonNull
    public Task<TResult> c(@NonNull c<Exception> cVar) {
        return b(this.f10779b, cVar);
    }

    @NonNull
    public Task<TResult> d(@NonNull Executor executor, d<TResult> dVar) {
        if (dVar != null) {
            this.f10783f.add(new g(executor, dVar, this.f10778a));
        }
        return this;
    }

    @NonNull
    public Task<TResult> e(@NonNull d<TResult> dVar) {
        return d(this.f10779b, dVar);
    }

    public void f(String str, Callable<TResult> callable) {
        this.f10780c.execute(g(str, callable));
    }

    /* access modifiers changed from: package-private */
    public void h(Exception exc) {
        k(STATE.FAILED);
        for (d<Exception> a10 : this.f10781d) {
            a10.a(exc);
        }
    }

    /* access modifiers changed from: package-private */
    public void i(TResult tresult) {
        k(STATE.SUCCESS);
        j(tresult);
        for (g<TResult> a10 : this.f10783f) {
            a10.a(this.f10782e);
        }
    }

    /* access modifiers changed from: package-private */
    public void j(TResult tresult) {
        this.f10782e = tresult;
    }

    /* access modifiers changed from: package-private */
    public void k(STATE state) {
        this.f10784g = state;
    }

    public Future<?> l(String str, Callable<TResult> callable) {
        Executor executor = this.f10780c;
        if (executor instanceof ExecutorService) {
            return ((ExecutorService) executor).submit(g(str, callable));
        }
        throw new UnsupportedOperationException("Can't use this method without ExecutorService, Use Execute alternatively ");
    }
}

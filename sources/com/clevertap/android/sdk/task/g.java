package com.clevertap.android.sdk.task;

import com.clevertap.android.sdk.CleverTapInstanceConfig;
import java.util.concurrent.Executor;
import u4.d;

class g<TResult> extends c<TResult> {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final d<TResult> f10812b;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object f10813a;

        a(Object obj) {
            this.f10813a = obj;
        }

        public void run() {
            g.this.f10812b.onSuccess(this.f10813a);
        }
    }

    protected g(Executor executor, d<TResult> dVar, CleverTapInstanceConfig cleverTapInstanceConfig) {
        super(executor);
        this.f10812b = dVar;
    }

    /* access modifiers changed from: package-private */
    public void a(TResult tresult) {
        this.f10800a.execute(new a(tresult));
    }
}

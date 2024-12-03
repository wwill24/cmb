package com.clevertap.android.sdk.task;

import java.util.concurrent.Executor;
import u4.c;

class d<TResult> extends c<TResult> {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final c<TResult> f10801b;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object f10802a;

        a(Object obj) {
            this.f10802a = obj;
        }

        public void run() {
            d.this.f10801b.a(this.f10802a);
        }
    }

    public d(Executor executor, c<TResult> cVar) {
        super(executor);
        this.f10801b = cVar;
    }

    /* access modifiers changed from: package-private */
    public void a(TResult tresult) {
        this.f10800a.execute(new a(tresult));
    }
}

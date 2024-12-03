package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.tasks.TaskCompletionSource;

public abstract class v<A extends a.b, ResultT> {

    /* renamed from: a  reason: collision with root package name */
    private final Feature[] f38781a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f38782b;

    /* renamed from: c  reason: collision with root package name */
    private final int f38783c;

    public static class a<A extends a.b, ResultT> {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public q f38784a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f38785b = true;

        /* renamed from: c  reason: collision with root package name */
        private Feature[] f38786c;

        /* renamed from: d  reason: collision with root package name */
        private int f38787d = 0;

        /* synthetic */ a(q2 q2Var) {
        }

        @NonNull
        public v<A, ResultT> a() {
            p.b(this.f38784a != null, "execute parameter required");
            return new p2(this, this.f38786c, this.f38785b, this.f38787d);
        }

        @NonNull
        public a<A, ResultT> b(@NonNull q<A, TaskCompletionSource<ResultT>> qVar) {
            this.f38784a = qVar;
            return this;
        }

        @NonNull
        public a<A, ResultT> c(boolean z10) {
            this.f38785b = z10;
            return this;
        }

        @NonNull
        public a<A, ResultT> d(@NonNull Feature... featureArr) {
            this.f38786c = featureArr;
            return this;
        }

        @NonNull
        public a<A, ResultT> e(int i10) {
            this.f38787d = i10;
            return this;
        }
    }

    protected v(Feature[] featureArr, boolean z10, int i10) {
        this.f38781a = featureArr;
        boolean z11 = false;
        if (featureArr != null && z10) {
            z11 = true;
        }
        this.f38782b = z11;
        this.f38783c = i10;
    }

    @NonNull
    public static <A extends a.b, ResultT> a<A, ResultT> a() {
        return new a<>((q2) null);
    }

    /* access modifiers changed from: protected */
    public abstract void b(@NonNull A a10, @NonNull TaskCompletionSource<ResultT> taskCompletionSource) throws RemoteException;

    public boolean c() {
        return this.f38782b;
    }

    public final int d() {
        return this.f38783c;
    }

    public final Feature[] e() {
        return this.f38781a;
    }
}

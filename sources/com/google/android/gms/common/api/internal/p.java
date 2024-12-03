package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.tasks.TaskCompletionSource;

public class p<A extends a.b, L> {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final o<A, L> f38714a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final x f38715b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final Runnable f38716c;

    public static class a<A extends a.b, L> {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public q f38717a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public q f38718b;

        /* renamed from: c  reason: collision with root package name */
        private Runnable f38719c = e2.f38593a;

        /* renamed from: d  reason: collision with root package name */
        private k f38720d;

        /* renamed from: e  reason: collision with root package name */
        private Feature[] f38721e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f38722f = true;

        /* renamed from: g  reason: collision with root package name */
        private int f38723g;

        /* synthetic */ a(h2 h2Var) {
        }

        @NonNull
        public p<A, L> a() {
            boolean z10;
            boolean z11;
            boolean z12 = true;
            if (this.f38717a != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            com.google.android.gms.common.internal.p.b(z10, "Must set register function");
            if (this.f38718b != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            com.google.android.gms.common.internal.p.b(z11, "Must set unregister function");
            if (this.f38720d == null) {
                z12 = false;
            }
            com.google.android.gms.common.internal.p.b(z12, "Must set holder");
            return new p<>(new f2(this, this.f38720d, this.f38721e, this.f38722f, this.f38723g), new g2(this, (k.a) com.google.android.gms.common.internal.p.l(this.f38720d.b(), "Key must not be null")), this.f38719c, (i2) null);
        }

        @NonNull
        public a<A, L> b(@NonNull q<A, TaskCompletionSource<Void>> qVar) {
            this.f38717a = qVar;
            return this;
        }

        @NonNull
        public a<A, L> c(boolean z10) {
            this.f38722f = z10;
            return this;
        }

        @NonNull
        public a<A, L> d(@NonNull Feature... featureArr) {
            this.f38721e = featureArr;
            return this;
        }

        @NonNull
        public a<A, L> e(int i10) {
            this.f38723g = i10;
            return this;
        }

        @NonNull
        public a<A, L> f(@NonNull q<A, TaskCompletionSource<Boolean>> qVar) {
            this.f38718b = qVar;
            return this;
        }

        @NonNull
        public a<A, L> g(@NonNull k<L> kVar) {
            this.f38720d = kVar;
            return this;
        }
    }

    /* synthetic */ p(o oVar, x xVar, Runnable runnable, i2 i2Var) {
        this.f38714a = oVar;
        this.f38715b = xVar;
        this.f38716c = runnable;
    }

    @NonNull
    public static <A extends a.b, L> a<A, L> a() {
        return new a<>((h2) null);
    }
}

package com.google.android.gms.measurement.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

final class q4 extends FutureTask implements Comparable {

    /* renamed from: a  reason: collision with root package name */
    private final long f40171a;

    /* renamed from: b  reason: collision with root package name */
    final boolean f40172b;

    /* renamed from: c  reason: collision with root package name */
    private final String f40173c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ s4 f40174d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    q4(s4 s4Var, Runnable runnable, boolean z10, String str) {
        super(runnable, (Object) null);
        this.f40174d = s4Var;
        p.k(str);
        long andIncrement = s4.f40239l.getAndIncrement();
        this.f40171a = andIncrement;
        this.f40173c = str;
        this.f40172b = z10;
        if (andIncrement == Long.MAX_VALUE) {
            s4Var.f40059a.d().r().a("Tasks index overflow");
        }
    }

    public final /* bridge */ /* synthetic */ int compareTo(@NonNull Object obj) {
        q4 q4Var = (q4) obj;
        boolean z10 = this.f40172b;
        if (z10 == q4Var.f40172b) {
            int i10 = (this.f40171a > q4Var.f40171a ? 1 : (this.f40171a == q4Var.f40171a ? 0 : -1));
            if (i10 < 0) {
                return -1;
            }
            if (i10 > 0) {
                return 1;
            }
            this.f40174d.f40059a.d().t().b("Two tasks share the same index. index", Long.valueOf(this.f40171a));
            return 0;
        } else if (!z10) {
            return 1;
        } else {
            return -1;
        }
    }

    /* access modifiers changed from: protected */
    public final void setException(Throwable th2) {
        this.f40174d.f40059a.d().r().b(this.f40173c, th2);
        super.setException(th2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    q4(s4 s4Var, Callable callable, boolean z10, String str) {
        super(callable);
        this.f40174d = s4Var;
        p.k("Task exception on worker thread");
        long andIncrement = s4.f40239l.getAndIncrement();
        this.f40171a = andIncrement;
        this.f40173c = "Task exception on worker thread";
        this.f40172b = z10;
        if (andIncrement == Long.MAX_VALUE) {
            s4Var.f40059a.d().r().a("Tasks index overflow");
        }
    }
}

package h2;

import androidx.annotation.NonNull;
import androidx.work.WorkInfo;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.e0;
import androidx.work.impl.o;
import androidx.work.impl.t;
import androidx.work.impl.u;
import b2.h;
import g2.v;
import java.util.LinkedList;
import java.util.UUID;

public abstract class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final o f15275a = new o();

    class a extends c {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ e0 f15276b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ UUID f15277c;

        a(e0 e0Var, UUID uuid) {
            this.f15276b = e0Var;
            this.f15277c = uuid;
        }

        /* JADX INFO: finally extract failed */
        /* access modifiers changed from: package-private */
        public void g() {
            WorkDatabase o10 = this.f15276b.o();
            o10.e();
            try {
                a(this.f15276b, this.f15277c.toString());
                o10.C();
                o10.j();
                f(this.f15276b);
            } catch (Throwable th2) {
                o10.j();
                throw th2;
            }
        }
    }

    class b extends c {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ e0 f15278b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f15279c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f15280d;

        b(e0 e0Var, String str, boolean z10) {
            this.f15278b = e0Var;
            this.f15279c = str;
            this.f15280d = z10;
        }

        /* JADX INFO: finally extract failed */
        /* access modifiers changed from: package-private */
        public void g() {
            WorkDatabase o10 = this.f15278b.o();
            o10.e();
            try {
                for (String a10 : o10.K().e(this.f15279c)) {
                    a(this.f15278b, a10);
                }
                o10.C();
                o10.j();
                if (this.f15280d) {
                    f(this.f15278b);
                }
            } catch (Throwable th2) {
                o10.j();
                throw th2;
            }
        }
    }

    @NonNull
    public static c b(@NonNull UUID uuid, @NonNull e0 e0Var) {
        return new a(e0Var, uuid);
    }

    @NonNull
    public static c c(@NonNull String str, @NonNull e0 e0Var, boolean z10) {
        return new b(e0Var, str, z10);
    }

    private void e(WorkDatabase workDatabase, String str) {
        v K = workDatabase.K();
        g2.b F = workDatabase.F();
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            WorkInfo.State g10 = K.g(str2);
            if (!(g10 == WorkInfo.State.SUCCEEDED || g10 == WorkInfo.State.FAILED)) {
                K.p(WorkInfo.State.CANCELLED, str2);
            }
            linkedList.addAll(F.a(str2));
        }
    }

    /* access modifiers changed from: package-private */
    public void a(e0 e0Var, String str) {
        e(e0Var.o(), str);
        e0Var.l().r(str);
        for (t c10 : e0Var.m()) {
            c10.c(str);
        }
    }

    @NonNull
    public h d() {
        return this.f15275a;
    }

    /* access modifiers changed from: package-private */
    public void f(e0 e0Var) {
        u.b(e0Var.h(), e0Var.o(), e0Var.m());
    }

    /* access modifiers changed from: package-private */
    public abstract void g();

    public void run() {
        try {
            g();
            this.f15275a.a(h.f7743a);
        } catch (Throwable th2) {
            this.f15275a.a(new h.b.a(th2));
        }
    }
}

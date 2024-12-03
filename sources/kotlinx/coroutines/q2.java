package kotlinx.coroutines;

import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0007J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\t\u0010\nR(\u0010\u000f\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000bj\n\u0012\u0006\u0012\u0004\u0018\u00010\u0002`\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\b\u001a\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0004¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/q2;", "", "Lkotlinx/coroutines/d1;", "a", "()Lkotlinx/coroutines/d1;", "", "c", "()V", "eventLoop", "d", "(Lkotlinx/coroutines/d1;)V", "Ljava/lang/ThreadLocal;", "Lkotlinx/coroutines/internal/CommonThreadLocal;", "b", "Ljava/lang/ThreadLocal;", "ref", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class q2 {

    /* renamed from: a  reason: collision with root package name */
    public static final q2 f32598a = new q2();

    /* renamed from: b  reason: collision with root package name */
    private static final ThreadLocal<d1> f32599b = new ThreadLocal<>();

    private q2() {
    }

    public final d1 a() {
        return f32599b.get();
    }

    public final d1 b() {
        ThreadLocal<d1> threadLocal = f32599b;
        d1 d1Var = threadLocal.get();
        if (d1Var != null) {
            return d1Var;
        }
        d1 a10 = g1.a();
        threadLocal.set(a10);
        return a10;
    }

    public final void c() {
        f32599b.set((Object) null);
    }

    public final void d(d1 d1Var) {
        f32599b.set(d1Var);
    }
}

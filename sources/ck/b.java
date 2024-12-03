package ck;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.j;
import qj.b0;
import qj.w;
import vj.c;

@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJJ\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b0\u0007\"\b\b\u0000\u0010\u0002*\u00020\u0001\"\b\b\u0001\u0010\u0003*\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004H\u0007¨\u0006\f"}, d2 = {"Lck/b;", "", "T", "U", "Lqj/b0;", "s1", "s2", "Lqj/w;", "Lkotlin/Pair;", "a", "<init>", "()V", "rxkotlin"}, k = 1, mv = {1, 4, 0})
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f24947a = new b();

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00028\u0001H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "T", "U", "t", "u", "Lkotlin/Pair;", "a", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;"}, k = 3, mv = {1, 4, 0})
    static final class a<T1, T2, R> implements c<T, U, Pair<? extends T, ? extends U>> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f24948a = new a();

        a() {
        }

        /* renamed from: a */
        public final Pair<T, U> apply(T t10, U u10) {
            j.h(t10, "t");
            j.h(u10, "u");
            return new Pair<>(t10, u10);
        }
    }

    private b() {
    }

    public final <T, U> w<Pair<T, U>> a(b0<T> b0Var, b0<U> b0Var2) {
        j.h(b0Var, "s1");
        j.h(b0Var2, "s2");
        w<Pair<T, U>> S = w.S(b0Var, b0Var2, a.f24948a);
        j.c(S, "Single.zip(s1, s2, BiFun…n { t, u -> Pair(t, u) })");
        return S;
    }
}

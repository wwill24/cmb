package dk;

import io.reactivex.internal.schedulers.ExecutorScheduler;
import io.reactivex.internal.schedulers.i;
import io.reactivex.internal.schedulers.j;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import qj.v;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    static final v f29553a = bk.a.h(new h());

    /* renamed from: b  reason: collision with root package name */
    static final v f29554b = bk.a.e(new b());

    /* renamed from: c  reason: collision with root package name */
    static final v f29555c = bk.a.f(new c());

    /* renamed from: d  reason: collision with root package name */
    static final v f29556d = j.f();

    /* renamed from: e  reason: collision with root package name */
    static final v f29557e = bk.a.g(new f());

    /* renamed from: dk.a$a  reason: collision with other inner class name */
    static final class C0337a {

        /* renamed from: a  reason: collision with root package name */
        static final v f29558a = new io.reactivex.internal.schedulers.a();
    }

    static final class b implements Callable<v> {
        b() {
        }

        /* renamed from: a */
        public v call() throws Exception {
            return C0337a.f29558a;
        }
    }

    static final class c implements Callable<v> {
        c() {
        }

        /* renamed from: a */
        public v call() throws Exception {
            return d.f29559a;
        }
    }

    static final class d {

        /* renamed from: a  reason: collision with root package name */
        static final v f29559a = new io.reactivex.internal.schedulers.d();
    }

    static final class e {

        /* renamed from: a  reason: collision with root package name */
        static final v f29560a = new io.reactivex.internal.schedulers.e();
    }

    static final class f implements Callable<v> {
        f() {
        }

        /* renamed from: a */
        public v call() throws Exception {
            return e.f29560a;
        }
    }

    static final class g {

        /* renamed from: a  reason: collision with root package name */
        static final v f29561a = new i();
    }

    static final class h implements Callable<v> {
        h() {
        }

        /* renamed from: a */
        public v call() throws Exception {
            return g.f29561a;
        }
    }

    public static v a() {
        return bk.a.r(f29554b);
    }

    public static v b(Executor executor) {
        return new ExecutorScheduler(executor, false);
    }

    public static v c() {
        return bk.a.t(f29555c);
    }

    public static v d() {
        return bk.a.v(f29553a);
    }
}

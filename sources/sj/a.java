package sj;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Callable;
import qj.v;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final v f33840a = rj.a.d(new C0396a());

    /* renamed from: sj.a$a  reason: collision with other inner class name */
    static class C0396a implements Callable<v> {
        C0396a() {
        }

        /* renamed from: a */
        public v call() throws Exception {
            return b.f33841a;
        }
    }

    private static final class b {

        /* renamed from: a  reason: collision with root package name */
        static final v f33841a = new b(new Handler(Looper.getMainLooper()), false);
    }

    public static v a() {
        return rj.a.e(f33840a);
    }
}

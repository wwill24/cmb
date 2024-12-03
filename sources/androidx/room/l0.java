package androidx.room;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.room.m;
import io.reactivex.BackpressureStrategy;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import qj.a0;
import qj.h;
import qj.j;
import qj.k;
import qj.o;
import qj.v;
import qj.w;
import qj.y;

@SuppressLint({"PrivateConstructorForUtilityClass"})
public class l0 {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f6880a = new Object();

    class a implements k<Object> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String[] f6881a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RoomDatabase f6882b;

        /* renamed from: androidx.room.l0$a$a  reason: collision with other inner class name */
        class C0076a extends m.c {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ j f6883b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0076a(String[] strArr, j jVar) {
                super(strArr);
                this.f6883b = jVar;
            }

            public void c(@NonNull Set<String> set) {
                if (!this.f6883b.isCancelled()) {
                    this.f6883b.d(l0.f6880a);
                }
            }
        }

        class b implements vj.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ m.c f6885a;

            b(m.c cVar) {
                this.f6885a = cVar;
            }

            public void run() throws Exception {
                a.this.f6882b.m().n(this.f6885a);
            }
        }

        a(String[] strArr, RoomDatabase roomDatabase) {
            this.f6881a = strArr;
            this.f6882b = roomDatabase;
        }

        public void a(j<Object> jVar) throws Exception {
            C0076a aVar = new C0076a(this.f6881a, jVar);
            if (!jVar.isCancelled()) {
                this.f6882b.m().c(aVar);
                jVar.a(io.reactivex.disposables.a.c(new b(aVar)));
            }
            if (!jVar.isCancelled()) {
                jVar.d(l0.f6880a);
            }
        }
    }

    class b implements vj.j<Object, o<T>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ qj.m f6887a;

        b(qj.m mVar) {
            this.f6887a = mVar;
        }

        /* renamed from: a */
        public o<T> apply(Object obj) throws Exception {
            return this.f6887a;
        }
    }

    class c implements a0<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Callable f6888a;

        c(Callable callable) {
            this.f6888a = callable;
        }

        public void a(y<T> yVar) throws Exception {
            try {
                yVar.onSuccess(this.f6888a.call());
            } catch (EmptyResultSetException e10) {
                yVar.d(e10);
            }
        }
    }

    public static <T> h<T> a(RoomDatabase roomDatabase, boolean z10, String[] strArr, Callable<T> callable) {
        v b10 = dk.a.b(d(roomDatabase, z10));
        return b(roomDatabase, strArr).o0(b10).v0(b10).a0(b10).Q(new b(qj.m.d(callable)));
    }

    public static h<Object> b(RoomDatabase roomDatabase, String... strArr) {
        return h.s(new a(strArr, roomDatabase), BackpressureStrategy.LATEST);
    }

    public static <T> w<T> c(Callable<T> callable) {
        return w.k(new c(callable));
    }

    private static Executor d(RoomDatabase roomDatabase, boolean z10) {
        if (z10) {
            return roomDatabase.r();
        }
        return roomDatabase.o();
    }
}

package xj;

import io.reactivex.exceptions.OnErrorNotImplementedException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    static final vj.j<Object, Object> f33964a = new m();

    /* renamed from: b  reason: collision with root package name */
    public static final Runnable f33965b = new j();

    /* renamed from: c  reason: collision with root package name */
    public static final vj.a f33966c = new g();

    /* renamed from: d  reason: collision with root package name */
    static final vj.f<Object> f33967d = new h();

    /* renamed from: e  reason: collision with root package name */
    public static final vj.f<Throwable> f33968e = new k();

    /* renamed from: f  reason: collision with root package name */
    public static final vj.f<Throwable> f33969f = new v();

    /* renamed from: g  reason: collision with root package name */
    public static final vj.k f33970g = new i();

    /* renamed from: h  reason: collision with root package name */
    static final vj.l<Object> f33971h = new w();

    /* renamed from: i  reason: collision with root package name */
    static final vj.l<Object> f33972i = new l();

    /* renamed from: j  reason: collision with root package name */
    static final Callable<Object> f33973j = new u();

    /* renamed from: k  reason: collision with root package name */
    static final Comparator<Object> f33974k = new q();

    /* renamed from: l  reason: collision with root package name */
    public static final vj.f<rn.c> f33975l = new p();

    /* renamed from: xj.a$a  reason: collision with other inner class name */
    static final class C0402a<T> implements vj.f<T> {

        /* renamed from: a  reason: collision with root package name */
        final vj.a f33976a;

        C0402a(vj.a aVar) {
            this.f33976a = aVar;
        }

        public void accept(T t10) throws Exception {
            this.f33976a.run();
        }
    }

    static final class b<T1, T2, R> implements vj.j<Object[], R> {

        /* renamed from: a  reason: collision with root package name */
        final vj.c<? super T1, ? super T2, ? extends R> f33977a;

        b(vj.c<? super T1, ? super T2, ? extends R> cVar) {
            this.f33977a = cVar;
        }

        /* renamed from: a */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 2) {
                return this.f33977a.apply(objArr[0], objArr[1]);
            }
            throw new IllegalArgumentException("Array of size 2 expected but got " + objArr.length);
        }
    }

    static final class c<T1, T2, T3, R> implements vj.j<Object[], R> {

        /* renamed from: a  reason: collision with root package name */
        final vj.g<T1, T2, T3, R> f33978a;

        c(vj.g<T1, T2, T3, R> gVar) {
            this.f33978a = gVar;
        }

        /* renamed from: a */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 3) {
                return this.f33978a.a(objArr[0], objArr[1], objArr[2]);
            }
            throw new IllegalArgumentException("Array of size 3 expected but got " + objArr.length);
        }
    }

    static final class d<T1, T2, T3, T4, R> implements vj.j<Object[], R> {

        /* renamed from: a  reason: collision with root package name */
        final vj.h<T1, T2, T3, T4, R> f33979a;

        d(vj.h<T1, T2, T3, T4, R> hVar) {
            this.f33979a = hVar;
        }

        /* renamed from: a */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 4) {
                return this.f33979a.a(objArr[0], objArr[1], objArr[2], objArr[3]);
            }
            throw new IllegalArgumentException("Array of size 4 expected but got " + objArr.length);
        }
    }

    static final class e<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements vj.j<Object[], R> {

        /* renamed from: a  reason: collision with root package name */
        final vj.i<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> f33980a;

        e(vj.i<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> iVar) {
            this.f33980a = iVar;
        }

        /* renamed from: a */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 9) {
                return this.f33980a.a(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7], objArr[8]);
            }
            throw new IllegalArgumentException("Array of size 9 expected but got " + objArr.length);
        }
    }

    static final class f<T> implements Callable<List<T>> {

        /* renamed from: a  reason: collision with root package name */
        final int f33981a;

        f(int i10) {
            this.f33981a = i10;
        }

        /* renamed from: a */
        public List<T> call() throws Exception {
            return new ArrayList(this.f33981a);
        }
    }

    static final class g implements vj.a {
        g() {
        }

        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    static final class h implements vj.f<Object> {
        h() {
        }

        public void accept(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    static final class i implements vj.k {
        i() {
        }

        public void accept(long j10) {
        }
    }

    static final class j implements Runnable {
        j() {
        }

        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }
    }

    static final class k implements vj.f<Throwable> {
        k() {
        }

        /* renamed from: a */
        public void accept(Throwable th2) {
            bk.a.s(th2);
        }
    }

    static final class l implements vj.l<Object> {
        l() {
        }

        public boolean test(Object obj) {
            return false;
        }
    }

    static final class m implements vj.j<Object, Object> {
        m() {
        }

        public Object apply(Object obj) {
            return obj;
        }

        public String toString() {
            return "IdentityFunction";
        }
    }

    static final class n<T, U> implements Callable<U>, vj.j<T, U> {

        /* renamed from: a  reason: collision with root package name */
        final U f33982a;

        n(U u10) {
            this.f33982a = u10;
        }

        public U apply(T t10) throws Exception {
            return this.f33982a;
        }

        public U call() throws Exception {
            return this.f33982a;
        }
    }

    static final class o<T> implements vj.j<List<T>, List<T>> {

        /* renamed from: a  reason: collision with root package name */
        final Comparator<? super T> f33983a;

        o(Comparator<? super T> comparator) {
            this.f33983a = comparator;
        }

        /* renamed from: a */
        public List<T> apply(List<T> list) {
            Collections.sort(list, this.f33983a);
            return list;
        }
    }

    static final class p implements vj.f<rn.c> {
        p() {
        }

        /* renamed from: a */
        public void accept(rn.c cVar) throws Exception {
            cVar.r(Long.MAX_VALUE);
        }
    }

    static final class q implements Comparator<Object> {
        q() {
        }

        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    static final class r<T> implements vj.a {

        /* renamed from: a  reason: collision with root package name */
        final vj.f<? super qj.p<T>> f33984a;

        r(vj.f<? super qj.p<T>> fVar) {
            this.f33984a = fVar;
        }

        public void run() throws Exception {
            this.f33984a.accept(qj.p.a());
        }
    }

    static final class s<T> implements vj.f<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final vj.f<? super qj.p<T>> f33985a;

        s(vj.f<? super qj.p<T>> fVar) {
            this.f33985a = fVar;
        }

        /* renamed from: a */
        public void accept(Throwable th2) throws Exception {
            this.f33985a.accept(qj.p.b(th2));
        }
    }

    static final class t<T> implements vj.f<T> {

        /* renamed from: a  reason: collision with root package name */
        final vj.f<? super qj.p<T>> f33986a;

        t(vj.f<? super qj.p<T>> fVar) {
            this.f33986a = fVar;
        }

        public void accept(T t10) throws Exception {
            this.f33986a.accept(qj.p.c(t10));
        }
    }

    static final class u implements Callable<Object> {
        u() {
        }

        public Object call() {
            return null;
        }
    }

    static final class v implements vj.f<Throwable> {
        v() {
        }

        /* renamed from: a */
        public void accept(Throwable th2) {
            bk.a.s(new OnErrorNotImplementedException(th2));
        }
    }

    static final class w implements vj.l<Object> {
        w() {
        }

        public boolean test(Object obj) {
            return true;
        }
    }

    public static <T> vj.f<T> a(vj.a aVar) {
        return new C0402a(aVar);
    }

    public static <T> vj.l<T> b() {
        return f33971h;
    }

    public static <T> Callable<List<T>> c(int i10) {
        return new f(i10);
    }

    public static <T> vj.f<T> d() {
        return f33967d;
    }

    public static <T> vj.j<T, T> e() {
        return f33964a;
    }

    public static <T> Callable<T> f(T t10) {
        return new n(t10);
    }

    public static <T> vj.j<List<T>, List<T>> g(Comparator<? super T> comparator) {
        return new o(comparator);
    }

    public static <T> vj.a h(vj.f<? super qj.p<T>> fVar) {
        return new r(fVar);
    }

    public static <T> vj.f<Throwable> i(vj.f<? super qj.p<T>> fVar) {
        return new s(fVar);
    }

    public static <T> vj.f<T> j(vj.f<? super qj.p<T>> fVar) {
        return new t(fVar);
    }

    public static <T1, T2, R> vj.j<Object[], R> k(vj.c<? super T1, ? super T2, ? extends R> cVar) {
        b.e(cVar, "f is null");
        return new b(cVar);
    }

    public static <T1, T2, T3, R> vj.j<Object[], R> l(vj.g<T1, T2, T3, R> gVar) {
        b.e(gVar, "f is null");
        return new c(gVar);
    }

    public static <T1, T2, T3, T4, R> vj.j<Object[], R> m(vj.h<T1, T2, T3, T4, R> hVar) {
        b.e(hVar, "f is null");
        return new d(hVar);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> vj.j<Object[], R> n(vj.i<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> iVar) {
        b.e(iVar, "f is null");
        return new e(iVar);
    }
}

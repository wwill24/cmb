package md;

import com.coffeemeetsbagel.models.util.DateUtils;
import md.a;

abstract class e {

    /* renamed from: a  reason: collision with root package name */
    static final e f41198a = a().f(10485760).d(200).b(10000).c(DateUtils.MILLIS_IN_WEEK).e(81920).a();

    static abstract class a {
        a() {
        }

        /* access modifiers changed from: package-private */
        public abstract e a();

        /* access modifiers changed from: package-private */
        public abstract a b(int i10);

        /* access modifiers changed from: package-private */
        public abstract a c(long j10);

        /* access modifiers changed from: package-private */
        public abstract a d(int i10);

        /* access modifiers changed from: package-private */
        public abstract a e(int i10);

        /* access modifiers changed from: package-private */
        public abstract a f(long j10);
    }

    e() {
    }

    static a a() {
        return new a.b();
    }

    /* access modifiers changed from: package-private */
    public abstract int b();

    /* access modifiers changed from: package-private */
    public abstract long c();

    /* access modifiers changed from: package-private */
    public abstract int d();

    /* access modifiers changed from: package-private */
    public abstract int e();

    /* access modifiers changed from: package-private */
    public abstract long f();
}

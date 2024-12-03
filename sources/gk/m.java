package gk;

import kotlin.jvm.internal.DefaultConstructorMarker;

public final class m implements Comparable<m> {

    /* renamed from: b  reason: collision with root package name */
    public static final a f29704b = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final long f29705a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private /* synthetic */ m(long j10) {
        this.f29705a = j10;
    }

    public static final /* synthetic */ m a(long j10) {
        return new m(j10);
    }

    public static long b(long j10) {
        return j10;
    }

    public static boolean c(long j10, Object obj) {
        return (obj instanceof m) && j10 == ((m) obj).h();
    }

    public static int d(long j10) {
        return Long.hashCode(j10);
    }

    public static String e(long j10) {
        return r.c(j10);
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return r.b(h(), ((m) obj).h());
    }

    public boolean equals(Object obj) {
        return c(this.f29705a, obj);
    }

    public final /* synthetic */ long h() {
        return this.f29705a;
    }

    public int hashCode() {
        return d(this.f29705a);
    }

    public String toString() {
        return e(this.f29705a);
    }
}

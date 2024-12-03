package gk;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class p implements Comparable<p> {

    /* renamed from: b  reason: collision with root package name */
    public static final a f29710b = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final short f29711a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private /* synthetic */ p(short s10) {
        this.f29711a = s10;
    }

    public static final /* synthetic */ p a(short s10) {
        return new p(s10);
    }

    public static short b(short s10) {
        return s10;
    }

    public static boolean c(short s10, Object obj) {
        return (obj instanceof p) && s10 == ((p) obj).h();
    }

    public static int d(short s10) {
        return Short.hashCode(s10);
    }

    public static String e(short s10) {
        return String.valueOf(s10 & 65535);
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return j.i(h() & 65535, ((p) obj).h() & 65535);
    }

    public boolean equals(Object obj) {
        return c(this.f29711a, obj);
    }

    public final /* synthetic */ short h() {
        return this.f29711a;
    }

    public int hashCode() {
        return d(this.f29711a);
    }

    public String toString() {
        return e(this.f29711a);
    }
}

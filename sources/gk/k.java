package gk;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jivesoftware.smack.datatypes.UInt32;

public final class k implements Comparable<k> {

    /* renamed from: b  reason: collision with root package name */
    public static final a f29699b = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final int f29700a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private /* synthetic */ k(int i10) {
        this.f29700a = i10;
    }

    public static final /* synthetic */ k a(int i10) {
        return new k(i10);
    }

    public static int b(int i10) {
        return i10;
    }

    public static boolean c(int i10, Object obj) {
        return (obj instanceof k) && i10 == ((k) obj).h();
    }

    public static int d(int i10) {
        return Integer.hashCode(i10);
    }

    public static String e(int i10) {
        return String.valueOf(((long) i10) & UInt32.MAX_VALUE_LONG);
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return r.a(h(), ((k) obj).h());
    }

    public boolean equals(Object obj) {
        return c(this.f29700a, obj);
    }

    public final /* synthetic */ int h() {
        return this.f29700a;
    }

    public int hashCode() {
        return d(this.f29700a);
    }

    public String toString() {
        return e(this.f29700a);
    }
}

package gk;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class i implements Comparable<i> {

    /* renamed from: b  reason: collision with root package name */
    public static final a f29694b = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final byte f29695a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private /* synthetic */ i(byte b10) {
        this.f29695a = b10;
    }

    public static final /* synthetic */ i a(byte b10) {
        return new i(b10);
    }

    public static byte b(byte b10) {
        return b10;
    }

    public static boolean c(byte b10, Object obj) {
        return (obj instanceof i) && b10 == ((i) obj).h();
    }

    public static int d(byte b10) {
        return Byte.hashCode(b10);
    }

    public static String e(byte b10) {
        return String.valueOf(b10 & 255);
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return j.i(h() & 255, ((i) obj).h() & 255);
    }

    public boolean equals(Object obj) {
        return c(this.f29695a, obj);
    }

    public final /* synthetic */ byte h() {
        return this.f29695a;
    }

    public int hashCode() {
        return d(this.f29695a);
    }

    public String toString() {
        return e(this.f29695a);
    }
}

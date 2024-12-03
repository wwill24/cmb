package vk;

import kotlin.jvm.internal.DefaultConstructorMarker;

public final class g extends e {

    /* renamed from: e  reason: collision with root package name */
    public static final a f33936e = new a((DefaultConstructorMarker) null);

    /* renamed from: f  reason: collision with root package name */
    private static final g f33937f = new g(1, 0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public g(long j10, long j11) {
        super(j10, j11, 1);
    }

    public boolean equals(Object obj) {
        if (obj instanceof g) {
            if (!isEmpty() || !((g) obj).isEmpty()) {
                g gVar = (g) obj;
                if (!(b() == gVar.b() && d() == gVar.d())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean g(long j10) {
        return b() <= j10 && j10 <= d();
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((((long) 31) * (b() ^ (b() >>> 32))) + (d() ^ (d() >>> 32)));
    }

    public boolean isEmpty() {
        return b() > d();
    }

    public String toString() {
        return b() + ".." + d();
    }
}

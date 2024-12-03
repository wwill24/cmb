package kotlin.ranges;

import kotlin.jvm.internal.DefaultConstructorMarker;

public final class IntRange extends a {

    /* renamed from: e  reason: collision with root package name */
    public static final a f32146e = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final IntRange f32147f = new IntRange(1, 0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final IntRange a() {
            return IntRange.f32147f;
        }
    }

    public IntRange(int i10, int i11) {
        super(i10, i11, 1);
    }

    public boolean equals(Object obj) {
        if (obj instanceof IntRange) {
            if (!isEmpty() || !((IntRange) obj).isEmpty()) {
                IntRange intRange = (IntRange) obj;
                if (!(b() == intRange.b() && d() == intRange.d())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (b() * 31) + d();
    }

    public boolean isEmpty() {
        return b() > d();
    }

    public boolean m(int i10) {
        return b() <= i10 && i10 <= d();
    }

    public Integer n() {
        return Integer.valueOf(d());
    }

    public Integer o() {
        return Integer.valueOf(b());
    }

    public String toString() {
        return b() + ".." + d();
    }
}

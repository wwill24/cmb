package kotlin.ranges;

import kk.c;
import kotlin.collections.b0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import vk.d;

public class a implements Iterable<Integer>, qk.a {

    /* renamed from: d  reason: collision with root package name */
    public static final C0370a f32148d = new C0370a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final int f32149a;

    /* renamed from: b  reason: collision with root package name */
    private final int f32150b;

    /* renamed from: c  reason: collision with root package name */
    private final int f32151c;

    /* renamed from: kotlin.ranges.a$a  reason: collision with other inner class name */
    public static final class C0370a {
        private C0370a() {
        }

        public /* synthetic */ C0370a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final a a(int i10, int i11, int i12) {
            return new a(i10, i11, i12);
        }
    }

    public a(int i10, int i11, int i12) {
        if (i12 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (i12 != Integer.MIN_VALUE) {
            this.f32149a = i10;
            this.f32150b = c.c(i10, i11, i12);
            this.f32151c = i12;
        } else {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
    }

    public final int b() {
        return this.f32149a;
    }

    public final int d() {
        return this.f32150b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            if (!isEmpty() || !((a) obj).isEmpty()) {
                a aVar = (a) obj;
                if (!(this.f32149a == aVar.f32149a && this.f32150b == aVar.f32150b && this.f32151c == aVar.f32151c)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public final int f() {
        return this.f32151c;
    }

    /* renamed from: g */
    public b0 iterator() {
        return new d(this.f32149a, this.f32150b, this.f32151c);
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f32149a * 31) + this.f32150b) * 31) + this.f32151c;
    }

    public boolean isEmpty() {
        if (this.f32151c > 0) {
            if (this.f32149a > this.f32150b) {
                return true;
            }
        } else if (this.f32149a < this.f32150b) {
            return true;
        }
        return false;
    }

    public String toString() {
        int i10;
        StringBuilder sb2;
        if (this.f32151c > 0) {
            sb2 = new StringBuilder();
            sb2.append(this.f32149a);
            sb2.append("..");
            sb2.append(this.f32150b);
            sb2.append(" step ");
            i10 = this.f32151c;
        } else {
            sb2 = new StringBuilder();
            sb2.append(this.f32149a);
            sb2.append(" downTo ");
            sb2.append(this.f32150b);
            sb2.append(" step ");
            i10 = -this.f32151c;
        }
        sb2.append(i10);
        return sb2.toString();
    }
}

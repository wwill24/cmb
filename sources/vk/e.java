package vk;

import kk.c;
import kotlin.collections.c0;
import kotlin.jvm.internal.DefaultConstructorMarker;

public class e implements Iterable<Long>, qk.a {

    /* renamed from: d  reason: collision with root package name */
    public static final a f33928d = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final long f33929a;

    /* renamed from: b  reason: collision with root package name */
    private final long f33930b;

    /* renamed from: c  reason: collision with root package name */
    private final long f33931c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public e(long j10, long j11, long j12) {
        if (j12 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (j12 != Long.MIN_VALUE) {
            this.f33929a = j10;
            this.f33930b = c.d(j10, j11, j12);
            this.f33931c = j12;
        } else {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
    }

    public final long b() {
        return this.f33929a;
    }

    public final long d() {
        return this.f33930b;
    }

    /* renamed from: f */
    public c0 iterator() {
        return new f(this.f33929a, this.f33930b, this.f33931c);
    }
}

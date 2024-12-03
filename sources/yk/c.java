package yk;

import com.mparticle.kits.MPSideloadedKit;
import kotlin.jvm.internal.j;
import kotlin.time.DurationUnit;
import vk.g;

public final class c {
    /* access modifiers changed from: private */
    public static final long h(long j10, int i10) {
        return a.h((j10 << 1) + ((long) i10));
    }

    /* access modifiers changed from: private */
    public static final long i(long j10) {
        return a.h((j10 << 1) + 1);
    }

    /* access modifiers changed from: private */
    public static final long j(long j10) {
        if (new g(-4611686018426L, 4611686018426L).g(j10)) {
            return k(m(j10));
        }
        return i(j.k(j10, -4611686018427387903L, 4611686018427387903L));
    }

    /* access modifiers changed from: private */
    public static final long k(long j10) {
        return a.h(j10 << 1);
    }

    /* access modifiers changed from: private */
    public static final long l(long j10) {
        if (new g(-4611686018426999999L, 4611686018426999999L).g(j10)) {
            return k(j10);
        }
        return i(n(j10));
    }

    /* access modifiers changed from: private */
    public static final long m(long j10) {
        return j10 * ((long) MPSideloadedKit.MIN_SIDELOADED_KIT);
    }

    /* access modifiers changed from: private */
    public static final long n(long j10) {
        return j10 / ((long) MPSideloadedKit.MIN_SIDELOADED_KIT);
    }

    public static final long o(int i10, DurationUnit durationUnit) {
        j.g(durationUnit, "unit");
        if (durationUnit.compareTo(DurationUnit.SECONDS) <= 0) {
            return k(d.b((long) i10, durationUnit, DurationUnit.NANOSECONDS));
        }
        return p((long) i10, durationUnit);
    }

    public static final long p(long j10, DurationUnit durationUnit) {
        j.g(durationUnit, "unit");
        DurationUnit durationUnit2 = DurationUnit.NANOSECONDS;
        long b10 = d.b(4611686018426999999L, durationUnit2, durationUnit);
        if (new g(-b10, b10).g(j10)) {
            return k(d.b(j10, durationUnit, durationUnit2));
        }
        return i(j.k(d.a(j10, durationUnit, DurationUnit.MILLISECONDS), -4611686018427387903L, 4611686018427387903L));
    }
}

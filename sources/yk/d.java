package yk;

import kotlin.jvm.internal.j;
import kotlin.time.DurationUnit;

class d {
    public static final long a(long j10, DurationUnit durationUnit, DurationUnit durationUnit2) {
        j.g(durationUnit, "sourceUnit");
        j.g(durationUnit2, "targetUnit");
        return durationUnit2.b().convert(j10, durationUnit.b());
    }

    public static final long b(long j10, DurationUnit durationUnit, DurationUnit durationUnit2) {
        j.g(durationUnit, "sourceUnit");
        j.g(durationUnit2, "targetUnit");
        return durationUnit2.b().convert(j10, durationUnit.b());
    }
}

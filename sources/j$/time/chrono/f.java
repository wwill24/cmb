package j$.time.chrono;

import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.o;
import java.util.Objects;

public interface f extends Comparable {
    static f c(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        f fVar = (f) temporalAccessor.k(o.a());
        return fVar != null ? fVar : g.f42585a;
    }
}

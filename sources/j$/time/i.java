package j$.time;

import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.p;

public final /* synthetic */ class i implements p {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f42702a;

    public /* synthetic */ i(int i10) {
        this.f42702a = i10;
    }

    public final Object a(TemporalAccessor temporalAccessor) {
        switch (this.f42702a) {
            case 0:
                return LocalDateTime.o(temporalAccessor);
            case 1:
                return OffsetDateTime.m(temporalAccessor);
            default:
                return ZonedDateTime.m(temporalAccessor);
        }
    }
}

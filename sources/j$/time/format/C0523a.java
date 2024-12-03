package j$.time.format;

import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.o;
import j$.time.temporal.p;

/* renamed from: j$.time.format.a  reason: case insensitive filesystem */
public final /* synthetic */ class C0523a implements p {
    public final Object a(TemporalAccessor temporalAccessor) {
        int i10 = w.f42681j;
        ZoneId zoneId = (ZoneId) temporalAccessor.k(o.g());
        if (zoneId == null || (zoneId instanceof ZoneOffset)) {
            return null;
        }
        return zoneId;
    }
}

package j$.time.temporal;

import j$.time.LocalDate;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.chrono.f;
import j$.time.l;

public final /* synthetic */ class n implements p, l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f42736a;

    public /* synthetic */ n(int i10) {
        this.f42736a = i10;
    }

    public Object a(TemporalAccessor temporalAccessor) {
        switch (this.f42736a) {
            case 0:
                return (ZoneId) temporalAccessor.k(o.f42737a);
            case 1:
                return (f) temporalAccessor.k(o.f42738b);
            case 2:
                return (q) temporalAccessor.k(o.f42739c);
            case 3:
                a aVar = a.OFFSET_SECONDS;
                if (temporalAccessor.i(aVar)) {
                    return ZoneOffset.u(temporalAccessor.a(aVar));
                }
                return null;
            case 4:
                ZoneId zoneId = (ZoneId) temporalAccessor.k(o.f42737a);
                return zoneId != null ? zoneId : (ZoneId) temporalAccessor.k(o.f42740d);
            case 5:
                a aVar2 = a.EPOCH_DAY;
                if (temporalAccessor.i(aVar2)) {
                    return LocalDate.x(temporalAccessor.j(aVar2));
                }
                return null;
            default:
                a aVar3 = a.NANO_OF_DAY;
                if (temporalAccessor.i(aVar3)) {
                    return l.u(temporalAccessor.j(aVar3));
                }
                return null;
        }
    }

    public k h(k kVar) {
        int i10 = this.f42736a;
        int a10 = kVar.a(a.DAY_OF_WEEK);
        if (a10 == i10) {
            return kVar;
        }
        int i11 = a10 - i10;
        return kVar.f((long) (i11 >= 0 ? 7 - i11 : -i11), b.DAYS);
    }
}

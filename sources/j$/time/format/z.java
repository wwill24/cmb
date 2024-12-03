package j$.time.format;

import j$.time.LocalDate;
import j$.time.ZoneId;
import j$.time.chrono.b;
import j$.time.chrono.f;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.m;
import j$.time.temporal.o;
import j$.time.temporal.p;
import j$.time.temporal.s;

final class z implements TemporalAccessor {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f42694a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ TemporalAccessor f42695b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ f f42696c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ ZoneId f42697d;

    z(LocalDate localDate, TemporalAccessor temporalAccessor, f fVar, ZoneId zoneId) {
        this.f42694a = localDate;
        this.f42695b = temporalAccessor;
        this.f42696c = fVar;
        this.f42697d = zoneId;
    }

    public final s e(m mVar) {
        return (this.f42694a == null || !mVar.isDateBased()) ? this.f42695b.e(mVar) : ((LocalDate) this.f42694a).e(mVar);
    }

    public final boolean i(m mVar) {
        return (this.f42694a == null || !mVar.isDateBased()) ? this.f42695b.i(mVar) : ((LocalDate) this.f42694a).i(mVar);
    }

    public final long j(m mVar) {
        return (this.f42694a == null || !mVar.isDateBased()) ? this.f42695b.j(mVar) : ((LocalDate) this.f42694a).j(mVar);
    }

    public final Object k(p pVar) {
        return pVar == o.a() ? this.f42696c : pVar == o.g() ? this.f42697d : pVar == o.e() ? this.f42695b.k(pVar) : pVar.a(this);
    }
}

package j$.time.chrono;

import j$.time.ZonedDateTime;
import j$.time.temporal.a;
import j$.time.temporal.k;
import j$.time.temporal.m;
import j$.time.temporal.r;

public interface e extends k, Comparable {
    int a(m mVar) {
        if (!(mVar instanceof a)) {
            return super.a(mVar);
        }
        int i10 = d.f42584a[((a) mVar).ordinal()];
        if (i10 != 1) {
            return i10 != 2 ? ((ZonedDateTime) this).u().a(mVar) : ((ZonedDateTime) this).n().r();
        }
        throw new r("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
    }

    int compareTo(Object obj) {
        e eVar = (e) obj;
        int compare = Long.compare(l(), eVar.l());
        if (compare != 0) {
            return compare;
        }
        ZonedDateTime zonedDateTime = (ZonedDateTime) this;
        ZonedDateTime zonedDateTime2 = (ZonedDateTime) eVar;
        int q10 = zonedDateTime.v().q() - zonedDateTime2.v().q();
        if (q10 != 0 || (q10 = zonedDateTime.u().compareTo(zonedDateTime2.u())) != 0 || (q10 = zonedDateTime.o().n().compareTo(zonedDateTime2.o().n())) != 0) {
            return q10;
        }
        zonedDateTime.s().getClass();
        g gVar = g.f42585a;
        zonedDateTime2.s().getClass();
        gVar.getClass();
        gVar.getClass();
        return 0;
    }

    long l() {
        ZonedDateTime zonedDateTime = (ZonedDateTime) this;
        return ((zonedDateTime.s().F() * 86400) + ((long) zonedDateTime.v().A())) - ((long) zonedDateTime.n().r());
    }
}

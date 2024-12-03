package j$.time.temporal;

import j$.time.d;
import java.util.Objects;
import org.jivesoftware.smackx.xdata.FormField;

public interface TemporalAccessor {
    int a(m mVar) {
        s e10 = e(mVar);
        if (e10.g()) {
            long j10 = j(mVar);
            if (e10.h(j10)) {
                return (int) j10;
            }
            throw new d("Invalid value for " + mVar + " (valid values " + e10 + "): " + j10);
        }
        throw new r("Invalid field " + mVar + " for get() method, use getLong() instead");
    }

    s e(m mVar) {
        if (!(mVar instanceof a)) {
            Objects.requireNonNull(mVar, FormField.ELEMENT);
            return mVar.d(this);
        } else if (i(mVar)) {
            return mVar.e();
        } else {
            throw new r("Unsupported field: " + mVar);
        }
    }

    boolean i(m mVar);

    long j(m mVar);

    Object k(p pVar) {
        if (pVar == o.f42737a || pVar == o.f42738b || pVar == o.f42739c) {
            return null;
        }
        return pVar.a(this);
    }
}

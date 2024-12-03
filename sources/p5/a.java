package p5;

import hb.c;
import kotlin.jvm.internal.j;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final c f17030a;

    public a(c cVar) {
        j.g(cVar, "sharedPrefs");
        this.f17030a = cVar;
    }

    public final boolean a(long j10) {
        if (j10 <= 10800000) {
            return false;
        }
        long t10 = this.f17030a.t("read_receipt_upsell_timestamp");
        long currentTimeMillis = t10 - System.currentTimeMillis();
        if (this.f17030a.l("read_receipt_upsell_counter") >= 2) {
            return false;
        }
        if (t10 == 0 || currentTimeMillis > 1209600000) {
            return true;
        }
        return false;
    }

    public final void b() {
        this.f17030a.b("read_receipt_upsell_timestamp", System.currentTimeMillis());
        this.f17030a.c("read_receipt_upsell_counter", this.f17030a.l("read_receipt_upsell_counter") + 1);
    }
}

package o7;

import com.coffeemeetsbagel.bakery.h1;
import com.coffeemeetsbagel.models.util.DateUtils;
import hb.c;
import java.util.HashMap;
import java.util.UUID;

public class a implements h1.b {

    /* renamed from: a  reason: collision with root package name */
    private final c f16832a;

    public a(h1 h1Var, c cVar) {
        this.f16832a = cVar;
        h1Var.f(this);
    }

    private void a() {
        HashMap hashMap = new HashMap();
        hashMap.put("name", "Session Start");
        hashMap.put("id", UUID.randomUUID().toString());
        hashMap.put("install_id", this.f16832a.r("analytics_events_install_id"));
        hashMap.put("fired_at", DateUtils.getFormattedUtcDate(System.currentTimeMillis(), DateUtils.DATE_WITH_TIME_PATTERN_ISO_8601_Z_MS));
    }

    public void P() {
    }

    public void S() {
        a();
    }
}

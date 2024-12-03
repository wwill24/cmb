package we;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.measurement.zzcl;
import com.google.android.gms.measurement.internal.q3;
import com.google.android.gms.measurement.internal.u4;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    private final h f42118a;

    public i(h hVar) {
        p.k(hVar);
        this.f42118a = hVar;
    }

    public final void a(Context context, Intent intent) {
        u4 H = u4.H(context, (zzcl) null, (Long) null);
        q3 d10 = H.d();
        if (intent == null) {
            d10.w().a("Receiver called with null intent");
            return;
        }
        H.b();
        String action = intent.getAction();
        d10.v().b("Local receiver got", action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            d10.v().a("Starting wakeful intent.");
            this.f42118a.a(context, className);
        } else if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
            d10.w().a("Install Referrer Broadcasts are deprecated");
        }
    }
}

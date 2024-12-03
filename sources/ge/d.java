package ge;

import android.content.Context;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.internal.v;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.t;
import com.google.android.gms.common.internal.u;
import com.google.android.gms.internal.base.zaf;
import com.google.android.gms.tasks.Task;

public final class d extends c implements t {

    /* renamed from: a  reason: collision with root package name */
    private static final a.g f40867a;

    /* renamed from: b  reason: collision with root package name */
    private static final a.C0480a f40868b;

    /* renamed from: c  reason: collision with root package name */
    private static final a f40869c;

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ int f40870d = 0;

    static {
        a.g gVar = new a.g();
        f40867a = gVar;
        c cVar = new c();
        f40868b = cVar;
        f40869c = new a("ClientTelemetry.API", cVar, gVar);
    }

    public d(Context context, u uVar) {
        super(context, f40869c, uVar, c.a.f38516c);
    }

    public final Task<Void> a(TelemetryData telemetryData) {
        v.a a10 = v.a();
        a10.d(zaf.zaa);
        a10.c(false);
        a10.b(new b(telemetryData));
        return doBestEffortWrite(a10.a());
    }
}

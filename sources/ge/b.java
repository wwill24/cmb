package ge;

import com.google.android.gms.common.api.internal.q;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class b implements q {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TelemetryData f40866a;

    public /* synthetic */ b(TelemetryData telemetryData) {
        this.f40866a = telemetryData;
    }

    public final void accept(Object obj, Object obj2) {
        TelemetryData telemetryData = this.f40866a;
        int i10 = d.f40870d;
        ((a) ((e) obj).getService()).c(telemetryData);
        ((TaskCompletionSource) obj2).setResult(null);
    }
}

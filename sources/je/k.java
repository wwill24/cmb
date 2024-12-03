package je;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.w;
import com.google.android.gms.common.moduleinstall.ModuleAvailabilityResponse;
import com.google.android.gms.common.moduleinstall.internal.i;
import com.google.android.gms.tasks.TaskCompletionSource;

final class k extends a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f41063a;

    k(i iVar, TaskCompletionSource taskCompletionSource) {
        this.f41063a = taskCompletionSource;
    }

    public final void c0(Status status, ModuleAvailabilityResponse moduleAvailabilityResponse) {
        w.c(status, moduleAvailabilityResponse, this.f41063a);
    }
}

package je;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.w;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;
import com.google.android.gms.common.moduleinstall.internal.i;
import com.google.android.gms.tasks.TaskCompletionSource;

final class l extends a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f41064a;

    l(i iVar, TaskCompletionSource taskCompletionSource) {
        this.f41064a = taskCompletionSource;
    }

    public final void b0(Status status, ModuleInstallResponse moduleInstallResponse) {
        w.c(status, moduleInstallResponse, this.f41064a);
    }
}

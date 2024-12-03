package je;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;
import com.google.android.gms.common.moduleinstall.internal.i;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.atomic.AtomicReference;

public final /* synthetic */ class h implements SuccessContinuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AtomicReference f41058a;

    public /* synthetic */ h(AtomicReference atomicReference) {
        this.f41058a = atomicReference;
    }

    public final Task then(Object obj) {
        AtomicReference atomicReference = this.f41058a;
        Void voidR = (Void) obj;
        int i10 = i.f39128d;
        if (atomicReference.get() != null) {
            return Tasks.forResult((ModuleInstallResponse) atomicReference.get());
        }
        return Tasks.forException(new ApiException(Status.f38502j));
    }
}

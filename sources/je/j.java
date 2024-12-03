package je;

import com.google.android.gms.common.api.internal.q;
import com.google.android.gms.common.moduleinstall.internal.ApiFeatureRequest;
import com.google.android.gms.common.moduleinstall.internal.c;
import com.google.android.gms.common.moduleinstall.internal.i;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class j implements q {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i f41061a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ApiFeatureRequest f41062b;

    public /* synthetic */ j(i iVar, ApiFeatureRequest apiFeatureRequest) {
        this.f41061a = iVar;
        this.f41062b = apiFeatureRequest;
    }

    public final void accept(Object obj, Object obj2) {
        i iVar = this.f41061a;
        ApiFeatureRequest apiFeatureRequest = this.f41062b;
        ((c) ((com.google.android.gms.common.moduleinstall.internal.j) obj).getService()).c(new k(iVar, (TaskCompletionSource) obj2), apiFeatureRequest);
    }
}

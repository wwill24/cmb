package je;

import com.google.android.gms.common.api.internal.q;
import com.google.android.gms.common.moduleinstall.internal.ApiFeatureRequest;
import com.google.android.gms.common.moduleinstall.internal.c;
import com.google.android.gms.common.moduleinstall.internal.j;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class i implements q {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.common.moduleinstall.internal.i f41059a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ApiFeatureRequest f41060b;

    public /* synthetic */ i(com.google.android.gms.common.moduleinstall.internal.i iVar, ApiFeatureRequest apiFeatureRequest) {
        this.f41059a = iVar;
        this.f41060b = apiFeatureRequest;
    }

    public final void accept(Object obj, Object obj2) {
        com.google.android.gms.common.moduleinstall.internal.i iVar = this.f41059a;
        ApiFeatureRequest apiFeatureRequest = this.f41060b;
        ((c) ((j) obj).getService()).f(new l(iVar, (TaskCompletionSource) obj2), apiFeatureRequest, (g) null);
    }
}

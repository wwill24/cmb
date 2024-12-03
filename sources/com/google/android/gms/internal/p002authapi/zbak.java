package com.google.android.gms.internal.p002authapi;

import com.google.android.gms.auth.api.identity.SavePasswordRequest;
import com.google.android.gms.common.api.internal.q;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api.zbak  reason: invalid package */
public final /* synthetic */ class zbak implements q {
    public final /* synthetic */ zbao zba;
    public final /* synthetic */ SavePasswordRequest zbb;

    public /* synthetic */ zbak(zbao zbao, SavePasswordRequest savePasswordRequest) {
        this.zba = zbao;
        this.zbb = savePasswordRequest;
    }

    public final void accept(Object obj, Object obj2) {
        zbao zbao = this.zba;
        SavePasswordRequest savePasswordRequest = this.zbb;
        ((zbz) ((zbw) obj).getService()).zbd(new zban(zbao, (TaskCompletionSource) obj2), (SavePasswordRequest) p.k(savePasswordRequest));
    }
}

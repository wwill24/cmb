package com.google.android.gms.internal.p002authapi;

import com.google.android.gms.auth.api.identity.SaveAccountLinkingTokenRequest;
import com.google.android.gms.common.api.internal.q;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api.zbaj  reason: invalid package */
public final /* synthetic */ class zbaj implements q {
    public final /* synthetic */ zbao zba;
    public final /* synthetic */ SaveAccountLinkingTokenRequest zbb;

    public /* synthetic */ zbaj(zbao zbao, SaveAccountLinkingTokenRequest saveAccountLinkingTokenRequest) {
        this.zba = zbao;
        this.zbb = saveAccountLinkingTokenRequest;
    }

    public final void accept(Object obj, Object obj2) {
        zbao zbao = this.zba;
        SaveAccountLinkingTokenRequest saveAccountLinkingTokenRequest = this.zbb;
        ((zbz) ((zbw) obj).getService()).zbc(new zbam(zbao, (TaskCompletionSource) obj2), (SaveAccountLinkingTokenRequest) p.k(saveAccountLinkingTokenRequest));
    }
}

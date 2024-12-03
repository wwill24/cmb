package com.google.android.play.core.integrity;

import com.google.android.gms.tasks.Task;

final class m implements IntegrityManager {

    /* renamed from: a  reason: collision with root package name */
    private final t f20487a;

    m(t tVar) {
        this.f20487a = tVar;
    }

    public final Task<IntegrityTokenResponse> requestIntegrityToken(IntegrityTokenRequest integrityTokenRequest) {
        return this.f20487a.b(integrityTokenRequest);
    }
}

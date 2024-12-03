package com.google.android.play.core.integrity;

import com.google.android.play.core.integrity.IntegrityTokenRequest;

final class a extends IntegrityTokenRequest.Builder {

    /* renamed from: a  reason: collision with root package name */
    private String f20474a;

    /* renamed from: b  reason: collision with root package name */
    private Long f20475b;

    a() {
    }

    public final IntegrityTokenRequest build() {
        String str = this.f20474a;
        if (str != null) {
            return new c(str, this.f20475b, (b) null);
        }
        throw new IllegalStateException("Missing required properties: nonce");
    }

    public final IntegrityTokenRequest.Builder setCloudProjectNumber(long j10) {
        this.f20475b = Long.valueOf(j10);
        return this;
    }

    public final IntegrityTokenRequest.Builder setNonce(String str) {
        if (str != null) {
            this.f20474a = str;
            return this;
        }
        throw new NullPointerException("Null nonce");
    }
}

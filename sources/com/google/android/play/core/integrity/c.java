package com.google.android.play.core.integrity;

final class c extends IntegrityTokenRequest {

    /* renamed from: a  reason: collision with root package name */
    private final String f20476a;

    /* renamed from: b  reason: collision with root package name */
    private final Long f20477b;

    /* synthetic */ c(String str, Long l10, b bVar) {
        this.f20476a = str;
        this.f20477b = l10;
    }

    public final Long cloudProjectNumber() {
        return this.f20477b;
    }

    public final boolean equals(Object obj) {
        Long l10;
        if (obj == this) {
            return true;
        }
        if (obj instanceof IntegrityTokenRequest) {
            IntegrityTokenRequest integrityTokenRequest = (IntegrityTokenRequest) obj;
            if (!this.f20476a.equals(integrityTokenRequest.nonce()) || ((l10 = this.f20477b) != null ? !l10.equals(integrityTokenRequest.cloudProjectNumber()) : integrityTokenRequest.cloudProjectNumber() != null)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i10;
        int hashCode = this.f20476a.hashCode() ^ 1000003;
        Long l10 = this.f20477b;
        if (l10 == null) {
            i10 = 0;
        } else {
            i10 = l10.hashCode();
        }
        return (hashCode * 1000003) ^ i10;
    }

    public final String nonce() {
        return this.f20476a;
    }

    public final String toString() {
        String str = this.f20476a;
        Long l10 = this.f20477b;
        return "IntegrityTokenRequest{nonce=" + str + ", cloudProjectNumber=" + l10 + "}";
    }
}

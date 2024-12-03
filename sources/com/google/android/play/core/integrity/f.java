package com.google.android.play.core.integrity;

final class f extends IntegrityTokenResponse {

    /* renamed from: a  reason: collision with root package name */
    private final String f20479a;

    /* synthetic */ f(String str, e eVar) {
        this.f20479a = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof IntegrityTokenResponse) {
            return this.f20479a.equals(((IntegrityTokenResponse) obj).token());
        }
        return false;
    }

    public final int hashCode() {
        return this.f20479a.hashCode() ^ 1000003;
    }

    public final String toString() {
        String str = this.f20479a;
        return "IntegrityTokenResponse{token=" + str + "}";
    }

    public final String token() {
        return this.f20479a;
    }
}

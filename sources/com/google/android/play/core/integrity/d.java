package com.google.android.play.core.integrity;

final class d extends w {

    /* renamed from: a  reason: collision with root package name */
    private String f20478a;

    d() {
    }

    /* access modifiers changed from: package-private */
    public final w a(String str) {
        this.f20478a = str;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final IntegrityTokenResponse b() {
        String str = this.f20478a;
        if (str != null) {
            return new f(str, (e) null);
        }
        throw new IllegalStateException("Missing required properties: token");
    }
}

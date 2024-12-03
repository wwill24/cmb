package io.sentry;

import io.sentry.util.l;
import java.net.URI;
import java.util.HashMap;

final class c2 {

    /* renamed from: a  reason: collision with root package name */
    private final SentryOptions f31157a;

    public c2(SentryOptions sentryOptions) {
        this.f31157a = (SentryOptions) l.c(sentryOptions, "options is required");
    }

    /* access modifiers changed from: package-private */
    public b2 a() {
        String str;
        m mVar = new m(this.f31157a.getDsn());
        URI c10 = mVar.c();
        String uri = c10.resolve(c10.getPath() + "/envelope/").toString();
        String a10 = mVar.a();
        String b10 = mVar.b();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Sentry sentry_version=7,sentry_client=");
        sb2.append(this.f31157a.getSentryClientName());
        sb2.append(",sentry_key=");
        sb2.append(a10);
        if (b10 == null || b10.length() <= 0) {
            str = "";
        } else {
            str = ",sentry_secret=" + b10;
        }
        sb2.append(str);
        String sb3 = sb2.toString();
        String sentryClientName = this.f31157a.getSentryClientName();
        HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", sentryClientName);
        hashMap.put("X-Sentry-Auth", sb3);
        return new b2(uri, hashMap);
    }
}

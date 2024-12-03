package io.sentry.transport;

import io.sentry.util.l;
import java.net.Authenticator;
import java.net.PasswordAuthentication;

final class u extends Authenticator {

    /* renamed from: a  reason: collision with root package name */
    private final String f31673a;

    /* renamed from: b  reason: collision with root package name */
    private final String f31674b;

    u(String str, String str2) {
        this.f31673a = (String) l.c(str, "user is required");
        this.f31674b = (String) l.c(str2, "password is required");
    }

    /* access modifiers changed from: protected */
    public PasswordAuthentication getPasswordAuthentication() {
        if (getRequestorType() == Authenticator.RequestorType.PROXY) {
            return new PasswordAuthentication(this.f31673a, this.f31674b.toCharArray());
        }
        return null;
    }
}

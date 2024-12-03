package io.sentry.transport;

import java.net.Authenticator;

final class l {

    /* renamed from: a  reason: collision with root package name */
    private static final l f31663a = new l();

    private l() {
    }

    public static l a() {
        return f31663a;
    }

    public void b(Authenticator authenticator) {
        Authenticator.setDefault(authenticator);
    }
}

package io.sentry.android.core.internal.util;

import io.sentry.SentryLevel;
import io.sentry.d;
import org.jetbrains.annotations.ApiStatus;
import org.jivesoftware.smack.packet.Session;

@ApiStatus.Internal
public class c {
    public static d a(String str) {
        d dVar = new d();
        dVar.p(Session.ELEMENT);
        dVar.m("state", str);
        dVar.l("app.lifecycle");
        dVar.n(SentryLevel.INFO);
        return dVar;
    }
}

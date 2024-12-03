package org.jivesoftware.smack;

import javax.net.ssl.SSLContext;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.util.SslContextFactory;

public final /* synthetic */ class k implements SslContextFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SSLContext f24126a;

    public /* synthetic */ k(SSLContext sSLContext) {
        this.f24126a = sSLContext;
    }

    public final SSLContext createSslContext() {
        return ConnectionConfiguration.Builder.lambda$setCustomSSLContext$0(this.f24126a);
    }
}

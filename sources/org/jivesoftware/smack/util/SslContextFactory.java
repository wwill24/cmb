package org.jivesoftware.smack.util;

import javax.net.ssl.SSLContext;

public interface SslContextFactory {
    SSLContext createSslContext();
}

package org.jivesoftware.smack.proxy;

import org.jivesoftware.smack.util.Function;

public final /* synthetic */ class b implements Function {
    public final Object apply(Object obj) {
        return new Socks4ProxySocketConnection((ProxyInfo) obj);
    }
}

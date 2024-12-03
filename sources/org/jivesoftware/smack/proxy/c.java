package org.jivesoftware.smack.proxy;

import org.jivesoftware.smack.util.Function;

public final /* synthetic */ class c implements Function {
    public final Object apply(Object obj) {
        return new Socks5ProxySocketConnection((ProxyInfo) obj);
    }
}

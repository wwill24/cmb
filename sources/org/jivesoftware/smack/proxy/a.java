package org.jivesoftware.smack.proxy;

import org.jivesoftware.smack.util.Function;

public final /* synthetic */ class a implements Function {
    public final Object apply(Object obj) {
        return new HTTPProxySocketConnection((ProxyInfo) obj);
    }
}

package io.sentry;

import java.net.InetAddress;
import java.util.concurrent.Callable;

public final /* synthetic */ class x implements Callable {
    public final Object call() {
        return InetAddress.getLocalHost();
    }
}

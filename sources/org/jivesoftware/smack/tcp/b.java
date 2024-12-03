package org.jivesoftware.smack.tcp;

import org.jivesoftware.smack.util.rce.RemoteConnectionEndpoint;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConnectionAttemptState f24146a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RemoteConnectionEndpoint.InetSocketAddressCoupling f24147b;

    public /* synthetic */ b(ConnectionAttemptState connectionAttemptState, RemoteConnectionEndpoint.InetSocketAddressCoupling inetSocketAddressCoupling) {
        this.f24146a = connectionAttemptState;
        this.f24147b = inetSocketAddressCoupling;
    }

    public final void run() {
        this.f24146a.lambda$establishTcpConnection$1(this.f24147b);
    }
}

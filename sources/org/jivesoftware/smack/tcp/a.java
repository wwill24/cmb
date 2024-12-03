package org.jivesoftware.smack.tcp;

import java.io.IOException;
import org.jivesoftware.smack.util.rce.RemoteConnectionEndpoint;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConnectionAttemptState f24143a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IOException f24144b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RemoteConnectionEndpoint.InetSocketAddressCoupling f24145c;

    public /* synthetic */ a(ConnectionAttemptState connectionAttemptState, IOException iOException, RemoteConnectionEndpoint.InetSocketAddressCoupling inetSocketAddressCoupling) {
        this.f24143a = connectionAttemptState;
        this.f24144b = iOException;
        this.f24145c = inetSocketAddressCoupling;
    }

    public final void run() {
        this.f24143a.lambda$establishTcpConnection$0(this.f24144b, this.f24145c);
    }
}

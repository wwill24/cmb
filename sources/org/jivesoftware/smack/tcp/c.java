package org.jivesoftware.smack.tcp;

import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import org.jivesoftware.smack.SmackReactor;
import org.jivesoftware.smack.util.rce.RemoteConnectionEndpoint;

public final /* synthetic */ class c implements SmackReactor.ChannelSelectedCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConnectionAttemptState f24148a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RemoteConnectionEndpoint.InetSocketAddressCoupling f24149b;

    public /* synthetic */ c(ConnectionAttemptState connectionAttemptState, RemoteConnectionEndpoint.InetSocketAddressCoupling inetSocketAddressCoupling) {
        this.f24148a = connectionAttemptState;
        this.f24149b = inetSocketAddressCoupling;
    }

    public final void onChannelSelected(SelectableChannel selectableChannel, SelectionKey selectionKey) {
        this.f24148a.lambda$establishTcpConnection$2(this.f24149b, selectableChannel, selectionKey);
    }
}

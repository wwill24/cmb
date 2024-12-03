package org.jivesoftware.smack.tcp;

import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import org.jivesoftware.smack.SmackReactor;

public final /* synthetic */ class p implements SmackReactor.ChannelSelectedCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XmppTcpTransportModule f24160a;

    public /* synthetic */ p(XmppTcpTransportModule xmppTcpTransportModule) {
        this.f24160a = xmppTcpTransportModule;
    }

    public final void onChannelSelected(SelectableChannel selectableChannel, SelectionKey selectionKey) {
        this.f24160a.onChannelSelected(selectableChannel, selectionKey);
    }
}

package org.jivesoftware.smack.c2s.internal;

import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.util.ListIterator;
import java.util.Queue;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.SmackReactor;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.XmppInputOutputFilter;
import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnection;
import org.jivesoftware.smack.c2s.XmppClientToServerTransport;
import org.jivesoftware.smack.debugger.SmackDebugger;
import org.jivesoftware.smack.fsm.ConnectionStateEvent;
import org.jivesoftware.smack.internal.SmackTlsContext;
import org.jivesoftware.smack.packet.Nonza;
import org.jivesoftware.smack.packet.TopLevelStreamElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.Consumer;
import org.jivesoftware.smack.util.Supplier;
import org.jivesoftware.smack.xml.XmlPullParser;

public abstract class ModularXmppClientToServerConnectionInternal {
    public final ModularXmppClientToServerConnection connection;
    public final Queue<TopLevelStreamElement> outgoingElementsQueue;
    private final SmackReactor reactor;
    public final SmackDebugger smackDebugger;

    public ModularXmppClientToServerConnectionInternal(ModularXmppClientToServerConnection modularXmppClientToServerConnection, SmackReactor smackReactor, SmackDebugger smackDebugger2, Queue<TopLevelStreamElement> queue) {
        this.connection = modularXmppClientToServerConnection;
        this.reactor = smackReactor;
        this.smackDebugger = smackDebugger2;
        this.outgoingElementsQueue = queue;
    }

    public abstract void addXmppInputOutputFilter(XmppInputOutputFilter xmppInputOutputFilter);

    public abstract void asyncGo(Runnable runnable);

    public abstract void fireFirstLevelElementSendListeners(TopLevelStreamElement topLevelStreamElement);

    public abstract XmlEnvironment getOutgoingStreamXmlEnvironment();

    public abstract SmackTlsContext getSmackTlsContext();

    public abstract ListIterator<XmppInputOutputFilter> getXmppInputOutputFilterBeginIterator();

    public abstract ListIterator<XmppInputOutputFilter> getXmppInputOutputFilterEndIterator();

    public abstract void invokeConnectionStateMachineListener(ConnectionStateEvent connectionStateEvent);

    public abstract void newStreamOpenWaitForFeaturesSequence(String str) throws InterruptedException, SmackException.NoResponseException, SmackException.NotConnectedException, SmackException, XMPPException;

    public abstract void notifyConnectionError(Exception exc);

    public abstract void notifyWaitingThreads();

    public abstract void onStreamClosed();

    public abstract void onStreamOpen(XmlPullParser xmlPullParser);

    public abstract void parseAndProcessElement(String str);

    public SelectionKey registerWithSelector(SelectableChannel selectableChannel, int i10, SmackReactor.ChannelSelectedCallback channelSelectedCallback) throws ClosedChannelException {
        return this.reactor.registerWithSelector(selectableChannel, i10, channelSelectedCallback);
    }

    public abstract <SN extends Nonza, FN extends Nonza> SN sendAndWaitForResponse(Nonza nonza, Class<SN> cls, Class<FN> cls2) throws SmackException.NoResponseException, SmackException.NotConnectedException, XMPPException.FailedNonzaException, InterruptedException;

    public abstract void setCompressionEnabled(boolean z10);

    public void setInterestOps(SelectionKey selectionKey, int i10) {
        this.reactor.setInterestOps(selectionKey, i10);
    }

    public abstract void setTransport(XmppClientToServerTransport xmppClientToServerTransport);

    public abstract void waitForConditionOrThrowConnectionException(Supplier<Boolean> supplier, String str) throws InterruptedException, SmackException, XMPPException;

    public final void withSmackDebugger(Consumer<SmackDebugger> consumer) {
        SmackDebugger smackDebugger2 = this.smackDebugger;
        if (smackDebugger2 != null) {
            consumer.accept(smackDebugger2);
        }
    }
}

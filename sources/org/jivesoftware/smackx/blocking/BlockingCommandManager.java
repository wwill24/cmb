package org.jivesoftware.smackx.blocking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.ConnectionListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler;
import org.jivesoftware.smack.iqrequest.IQRequestHandler;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;
import org.jivesoftware.smackx.blocking.element.BlockListIQ;
import org.jivesoftware.smackx.blocking.element.UnblockContactsIQ;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jxmpp.jid.Jid;

public final class BlockingCommandManager extends Manager {
    private static final Map<XMPPConnection, BlockingCommandManager> INSTANCES = new WeakHashMap();
    public static final String NAMESPACE = "urn:xmpp:blocking";
    /* access modifiers changed from: private */
    public final Set<AllJidsUnblockedListener> allJidsUnblockedListeners = new CopyOnWriteArraySet();
    /* access modifiers changed from: private */
    public volatile List<Jid> blockListCached;
    /* access modifiers changed from: private */
    public final Set<JidsBlockedListener> jidsBlockedListeners = new CopyOnWriteArraySet();
    /* access modifiers changed from: private */
    public final Set<JidsUnblockedListener> jidsUnblockedListeners = new CopyOnWriteArraySet();

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() {
            public void connectionCreated(XMPPConnection xMPPConnection) {
                BlockingCommandManager.getInstanceFor(xMPPConnection);
            }
        });
    }

    private BlockingCommandManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        IQ.Type type = IQ.Type.set;
        IQRequestHandler.Mode mode = IQRequestHandler.Mode.sync;
        xMPPConnection.registerIQRequestHandler(new AbstractIqRequestHandler(BlockContactsIQ.ELEMENT, "urn:xmpp:blocking", type, mode) {
            public IQ handleIQRequest(IQ iq) {
                BlockContactsIQ blockContactsIQ = (BlockContactsIQ) iq;
                if (BlockingCommandManager.this.blockListCached == null) {
                    List unused = BlockingCommandManager.this.blockListCached = new ArrayList();
                }
                List<Jid> jids = blockContactsIQ.getJids();
                BlockingCommandManager.this.blockListCached.addAll(jids);
                for (JidsBlockedListener onJidsBlocked : BlockingCommandManager.this.jidsBlockedListeners) {
                    onJidsBlocked.onJidsBlocked(jids);
                }
                return IQ.createResultIQ(blockContactsIQ);
            }
        });
        xMPPConnection.registerIQRequestHandler(new AbstractIqRequestHandler(UnblockContactsIQ.ELEMENT, "urn:xmpp:blocking", type, mode) {
            public IQ handleIQRequest(IQ iq) {
                UnblockContactsIQ unblockContactsIQ = (UnblockContactsIQ) iq;
                if (BlockingCommandManager.this.blockListCached == null) {
                    List unused = BlockingCommandManager.this.blockListCached = new ArrayList();
                }
                List<Jid> jids = unblockContactsIQ.getJids();
                if (jids == null) {
                    BlockingCommandManager.this.blockListCached.clear();
                    for (AllJidsUnblockedListener onAllJidsUnblocked : BlockingCommandManager.this.allJidsUnblockedListeners) {
                        onAllJidsUnblocked.onAllJidsUnblocked();
                    }
                } else {
                    BlockingCommandManager.this.blockListCached.removeAll(jids);
                    for (JidsUnblockedListener onJidsUnblocked : BlockingCommandManager.this.jidsUnblockedListeners) {
                        onJidsUnblocked.onJidsUnblocked(jids);
                    }
                }
                return IQ.createResultIQ(unblockContactsIQ);
            }
        });
        xMPPConnection.addConnectionListener(new ConnectionListener() {
            public void authenticated(XMPPConnection xMPPConnection, boolean z10) {
                if (!z10) {
                    List unused = BlockingCommandManager.this.blockListCached = null;
                }
            }
        });
    }

    public static synchronized BlockingCommandManager getInstanceFor(XMPPConnection xMPPConnection) {
        BlockingCommandManager blockingCommandManager;
        synchronized (BlockingCommandManager.class) {
            Map<XMPPConnection, BlockingCommandManager> map = INSTANCES;
            blockingCommandManager = map.get(xMPPConnection);
            if (blockingCommandManager == null) {
                blockingCommandManager = new BlockingCommandManager(xMPPConnection);
                map.put(xMPPConnection, blockingCommandManager);
            }
        }
        return blockingCommandManager;
    }

    public void addAllJidsUnblockedListener(AllJidsUnblockedListener allJidsUnblockedListener) {
        this.allJidsUnblockedListeners.add(allJidsUnblockedListener);
    }

    public void addJidsBlockedListener(JidsBlockedListener jidsBlockedListener) {
        this.jidsBlockedListeners.add(jidsBlockedListener);
    }

    public void addJidsUnblockedListener(JidsUnblockedListener jidsUnblockedListener) {
        this.jidsUnblockedListeners.add(jidsUnblockedListener);
    }

    public void blockContacts(List<Jid> list) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        connection().createStanzaCollectorAndSend(new BlockContactsIQ(list)).nextResultOrThrow();
    }

    public List<Jid> getBlockList() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        if (this.blockListCached == null) {
            this.blockListCached = ((BlockListIQ) connection().createStanzaCollectorAndSend(new BlockListIQ()).nextResultOrThrow()).getBlockedJidsCopy();
        }
        return Collections.unmodifiableList(this.blockListCached);
    }

    public boolean isSupportedByServer() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return ServiceDiscoveryManager.getInstanceFor(connection()).serverSupportsFeature("urn:xmpp:blocking");
    }

    public void removeAllJidsUnblockedListener(AllJidsUnblockedListener allJidsUnblockedListener) {
        this.allJidsUnblockedListeners.remove(allJidsUnblockedListener);
    }

    public void removeJidsBlockedListener(JidsBlockedListener jidsBlockedListener) {
        this.jidsBlockedListeners.remove(jidsBlockedListener);
    }

    public void removeJidsUnblockedListener(JidsUnblockedListener jidsUnblockedListener) {
        this.jidsUnblockedListeners.remove(jidsUnblockedListener);
    }

    public void unblockAll() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        connection().createStanzaCollectorAndSend(new UnblockContactsIQ()).nextResultOrThrow();
    }

    public void unblockContacts(List<Jid> list) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        connection().createStanzaCollectorAndSend(new UnblockContactsIQ(list)).nextResultOrThrow();
    }
}

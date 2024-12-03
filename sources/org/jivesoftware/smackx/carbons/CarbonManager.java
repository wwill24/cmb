package org.jivesoftware.smackx.carbons;

import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.AsyncButOrdered;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.ConnectionListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.FromMatchesFilter;
import org.jivesoftware.smack.filter.OrFilter;
import org.jivesoftware.smack.filter.StanzaExtensionFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.filter.StanzaTypeFilter;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.util.ExceptionCallback;
import org.jivesoftware.smack.util.SuccessCallback;
import org.jivesoftware.smackx.carbons.packet.Carbon;
import org.jivesoftware.smackx.carbons.packet.CarbonExtension;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jxmpp.jid.BareJid;
import org.jxmpp.jid.EntityFullJid;

public final class CarbonManager extends Manager {
    private static final StanzaFilter CARBON_EXTENSION_FILTER = new AndFilter(new OrFilter(new StanzaExtensionFilter(CarbonExtension.Direction.sent.name(), "urn:xmpp:carbons:2"), new StanzaExtensionFilter(CarbonExtension.Direction.received.name(), "urn:xmpp:carbons:2")), StanzaTypeFilter.MESSAGE);
    private static boolean ENABLED_BY_DEFAULT = false;
    private static Map<XMPPConnection, CarbonManager> INSTANCES = new WeakHashMap();
    /* access modifiers changed from: private */
    public static final Logger LOGGER = Logger.getLogger(CarbonManager.class.getName());
    /* access modifiers changed from: private */
    public final StanzaListener carbonsListener;
    /* access modifiers changed from: private */
    public final AsyncButOrdered<BareJid> carbonsListenerAsyncButOrdered = new AsyncButOrdered<>();
    private volatile boolean enabledByDefault = ENABLED_BY_DEFAULT;
    /* access modifiers changed from: private */
    public volatile boolean enabled_state = false;
    /* access modifiers changed from: private */
    public final Set<CarbonCopyReceivedListener> listeners = new CopyOnWriteArraySet();

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() {
            public void connectionCreated(XMPPConnection xMPPConnection) {
                CarbonManager.getInstanceFor(xMPPConnection);
            }
        });
    }

    private CarbonManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        ServiceDiscoveryManager.getInstanceFor(xMPPConnection).addFeature("urn:xmpp:carbons:2");
        this.carbonsListener = new StanzaListener() {
            public void processStanza(Stanza stanza) {
                final Message message = (Message) stanza;
                CarbonExtension from = CarbonExtension.from(message);
                final CarbonExtension.Direction direction = from.getDirection();
                final Message forwardedStanza = from.getForwarded().getForwardedStanza();
                CarbonManager.this.carbonsListenerAsyncButOrdered.performAsyncButOrdered(forwardedStanza.getFrom().i1(), new Runnable() {
                    public void run() {
                        for (CarbonCopyReceivedListener onCarbonCopyReceived : CarbonManager.this.listeners) {
                            onCarbonCopyReceived.onCarbonCopyReceived(direction, forwardedStanza, message);
                        }
                    }
                });
            }
        };
        xMPPConnection.addConnectionListener(new ConnectionListener() {
            public void authenticated(XMPPConnection xMPPConnection, boolean z10) {
                if (!z10) {
                    boolean unused = CarbonManager.this.enabled_state = false;
                    try {
                        if (CarbonManager.this.shouldCarbonsBeEnabled() && CarbonManager.this.isSupportedByServer()) {
                            CarbonManager.this.setCarbonsEnabled(true);
                        }
                    } catch (InterruptedException | SmackException.NoResponseException | SmackException.NotConnectedException | XMPPException.XMPPErrorException e10) {
                        CarbonManager.LOGGER.log(Level.WARNING, "Cannot check for Carbon support and / or enable carbons.", e10);
                    }
                }
                CarbonManager.this.addCarbonsListener(xMPPConnection);
            }

            public void connectionClosed() {
                boolean unused = CarbonManager.this.enabled_state = false;
                CarbonManager.this.connection().removeSyncStanzaListener(CarbonManager.this.carbonsListener);
            }
        });
        addCarbonsListener(xMPPConnection);
    }

    /* access modifiers changed from: private */
    public void addCarbonsListener(XMPPConnection xMPPConnection) {
        EntityFullJid user = xMPPConnection.getUser();
        if (user != null) {
            xMPPConnection.addSyncStanzaListener(this.carbonsListener, new AndFilter(CARBON_EXTENSION_FILTER, FromMatchesFilter.createBare(user)));
        }
    }

    private static IQ carbonsEnabledIQ(boolean z10) {
        if (z10) {
            return new Carbon.Enable();
        }
        return new Carbon.Disable();
    }

    public static synchronized CarbonManager getInstanceFor(XMPPConnection xMPPConnection) {
        CarbonManager carbonManager;
        synchronized (CarbonManager.class) {
            carbonManager = INSTANCES.get(xMPPConnection);
            if (carbonManager == null) {
                carbonManager = new CarbonManager(xMPPConnection);
                INSTANCES.put(xMPPConnection, carbonManager);
            }
        }
        return carbonManager;
    }

    private void sendUseCarbons(final boolean z10, ExceptionCallback<Exception> exceptionCallback) {
        this.enabledByDefault = z10;
        connection().sendIqRequestAsync(carbonsEnabledIQ(z10)).onSuccess(new SuccessCallback<IQ>() {
            public void onSuccess(IQ iq) {
                boolean unused = CarbonManager.this.enabled_state = z10;
            }
        }).onError(exceptionCallback);
    }

    public static void setEnabledByDefault(boolean z10) {
        ENABLED_BY_DEFAULT = z10;
    }

    /* access modifiers changed from: private */
    public boolean shouldCarbonsBeEnabled() {
        return this.enabledByDefault;
    }

    public boolean addCarbonCopyReceivedListener(CarbonCopyReceivedListener carbonCopyReceivedListener) {
        return this.listeners.add(carbonCopyReceivedListener);
    }

    public void disableCarbons() throws XMPPException, SmackException, InterruptedException {
        setCarbonsEnabled(false);
    }

    public void disableCarbonsAsync(ExceptionCallback<Exception> exceptionCallback) {
        sendUseCarbons(false, exceptionCallback);
    }

    public void enableCarbons() throws XMPPException, SmackException, InterruptedException {
        setCarbonsEnabled(true);
    }

    public void enableCarbonsAsync(ExceptionCallback<Exception> exceptionCallback) {
        sendUseCarbons(true, exceptionCallback);
    }

    public boolean getCarbonsEnabled() {
        return this.enabled_state;
    }

    public boolean isSupportedByServer() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return ServiceDiscoveryManager.getInstanceFor(connection()).serverSupportsFeature("urn:xmpp:carbons:2");
    }

    public boolean removeCarbonCopyReceivedListener(CarbonCopyReceivedListener carbonCopyReceivedListener) {
        return this.listeners.remove(carbonCopyReceivedListener);
    }

    @Deprecated
    public void sendCarbonsEnabled(boolean z10) {
        sendUseCarbons(z10, (ExceptionCallback<Exception>) null);
    }

    public synchronized void setCarbonsEnabled(boolean z10) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        this.enabledByDefault = z10;
        if (this.enabled_state != z10) {
            connection().createStanzaCollectorAndSend(carbonsEnabledIQ(z10)).nextResultOrThrow();
            this.enabled_state = z10;
        }
    }

    @Deprecated
    public static void disableCarbons(Message message) {
        message.addExtension(CarbonExtension.Private.INSTANCE);
    }
}

package org.jivesoftware.smackx.iqlast;

import java.util.Map;
import java.util.WeakHashMap;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.StanzaTypeFilter;
import org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler;
import org.jivesoftware.smack.iqrequest.IQRequestHandler;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.iqlast.packet.LastActivity;
import org.jxmpp.jid.Jid;

public final class LastActivityManager extends Manager {
    private static boolean enabledPerDefault = true;
    private static final Map<XMPPConnection, LastActivityManager> instances = new WeakHashMap();
    /* access modifiers changed from: private */
    public boolean enabled = false;
    private volatile long lastMessageSent;

    /* renamed from: org.jivesoftware.smackx.iqlast.LastActivityManager$5  reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$packet$Presence$Mode;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                org.jivesoftware.smack.packet.Presence$Mode[] r0 = org.jivesoftware.smack.packet.Presence.Mode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jivesoftware$smack$packet$Presence$Mode = r0
                org.jivesoftware.smack.packet.Presence$Mode r1 = org.jivesoftware.smack.packet.Presence.Mode.available     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$jivesoftware$smack$packet$Presence$Mode     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jivesoftware.smack.packet.Presence$Mode r1 = org.jivesoftware.smack.packet.Presence.Mode.chat     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.iqlast.LastActivityManager.AnonymousClass5.<clinit>():void");
        }
    }

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() {
            public void connectionCreated(XMPPConnection xMPPConnection) {
                LastActivityManager.getInstanceFor(xMPPConnection);
            }
        });
    }

    private LastActivityManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        xMPPConnection.addStanzaSendingListener(new StanzaListener() {
            public void processStanza(Stanza stanza) {
                Presence.Mode mode = ((Presence) stanza).getMode();
                if (mode != null) {
                    int i10 = AnonymousClass5.$SwitchMap$org$jivesoftware$smack$packet$Presence$Mode[mode.ordinal()];
                    if (i10 == 1 || i10 == 2) {
                        LastActivityManager.this.resetIdleTime();
                    }
                }
            }
        }, StanzaTypeFilter.PRESENCE);
        xMPPConnection.addStanzaSendingListener(new StanzaListener() {
            public void processStanza(Stanza stanza) {
                if (((Message) stanza).getType() != Message.Type.error) {
                    LastActivityManager.this.resetIdleTime();
                }
            }
        }, StanzaTypeFilter.MESSAGE);
        xMPPConnection.registerIQRequestHandler(new AbstractIqRequestHandler("query", LastActivity.NAMESPACE, IQ.Type.get, IQRequestHandler.Mode.async) {
            public IQ handleIQRequest(IQ iq) {
                if (!LastActivityManager.this.enabled) {
                    return IQ.createErrorResponse(iq, StanzaError.Condition.not_acceptable);
                }
                LastActivity lastActivity = new LastActivity();
                lastActivity.setType(IQ.Type.result);
                lastActivity.setTo(iq.getFrom());
                lastActivity.setFrom(iq.getTo());
                lastActivity.setStanzaId(iq.getStanzaId());
                lastActivity.setLastActivity(LastActivityManager.this.getIdleTime());
                return lastActivity;
            }
        });
        if (enabledPerDefault) {
            enable();
        }
        resetIdleTime();
        instances.put(xMPPConnection, this);
    }

    /* access modifiers changed from: private */
    public long getIdleTime() {
        return (System.currentTimeMillis() - this.lastMessageSent) / 1000;
    }

    public static synchronized LastActivityManager getInstanceFor(XMPPConnection xMPPConnection) {
        LastActivityManager lastActivityManager;
        synchronized (LastActivityManager.class) {
            lastActivityManager = instances.get(xMPPConnection);
            if (lastActivityManager == null) {
                lastActivityManager = new LastActivityManager(xMPPConnection);
            }
        }
        return lastActivityManager;
    }

    /* access modifiers changed from: private */
    public void resetIdleTime() {
        this.lastMessageSent = System.currentTimeMillis();
    }

    public static void setEnabledPerDefault(boolean z10) {
        enabledPerDefault = z10;
    }

    public synchronized void disable() {
        ServiceDiscoveryManager.getInstanceFor(connection()).removeFeature(LastActivity.NAMESPACE);
        this.enabled = false;
    }

    public synchronized void enable() {
        ServiceDiscoveryManager.getInstanceFor(connection()).addFeature(LastActivity.NAMESPACE);
        this.enabled = true;
    }

    public LastActivity getLastActivity(Jid jid) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return (LastActivity) connection().createStanzaCollectorAndSend(new LastActivity(jid)).nextResultOrThrow();
    }

    public boolean isLastActivitySupported(Jid jid) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return ServiceDiscoveryManager.getInstanceFor(connection()).supportsFeature(jid, LastActivity.NAMESPACE);
    }
}

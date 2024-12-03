package org.jivesoftware.smackx.dox;

import java.io.IOException;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.logging.Logger;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler;
import org.jivesoftware.smack.iqrequest.IQRequestHandler;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smack.util.RandomUtil;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.dox.element.DnsIq;
import org.jxmpp.jid.Jid;
import org.minidns.dnsmessage.DnsMessage;
import org.minidns.dnsmessage.a;

public final class DnsOverXmppManager extends Manager {
    private static final Map<XMPPConnection, DnsOverXmppManager> INSTANCES = new WeakHashMap();
    /* access modifiers changed from: private */
    public static final Logger LOGGER = Logger.getLogger(DnsOverXmppManager.class.getName());
    private static final String NAMESPACE = "urn:xmpp:dox:0";
    private static DnsOverXmppResolver defaultResolver;
    private final AbstractIqRequestHandler dnsIqRequestHandler = new AbstractIqRequestHandler(DnsIq.ELEMENT, "urn:xmpp:dox:0", IQ.Type.get, IQRequestHandler.Mode.async) {
        public IQ handleIQRequest(IQ iq) {
            DnsOverXmppResolver access$000 = DnsOverXmppManager.this.resolver;
            if (access$000 == null) {
                Logger access$100 = DnsOverXmppManager.LOGGER;
                access$100.info("Resolver was null while attempting to handle " + iq);
                return null;
            }
            DnsMessage dnsMessage = ((DnsIq) iq).getDnsMessage();
            try {
                DnsMessage resolve = access$000.resolve(dnsMessage);
                if (dnsMessage.f33582a != resolve.f33582a) {
                    resolve = resolve.a().y(dnsMessage.f33582a).s();
                }
                DnsIq dnsIq = new DnsIq(resolve);
                dnsIq.setType(IQ.Type.result);
                return dnsIq;
            } catch (IOException e10) {
                return IQ.createErrorResponse(iq, ((StanzaError.Builder) StanzaError.getBuilder().setType(StanzaError.Type.CANCEL).setCondition(StanzaError.Condition.internal_server_error).setDescriptiveEnText("Exception while resolving your DNS query", e10)).build());
            }
        }
    };
    private boolean enabled;
    /* access modifiers changed from: private */
    public DnsOverXmppResolver resolver = defaultResolver;
    private final ServiceDiscoveryManager serviceDiscoveryManager;

    private DnsOverXmppManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.serviceDiscoveryManager = ServiceDiscoveryManager.getInstanceFor(xMPPConnection);
    }

    public static synchronized DnsOverXmppManager getInstanceFor(XMPPConnection xMPPConnection) {
        DnsOverXmppManager dnsOverXmppManager;
        synchronized (DnsOverXmppManager.class) {
            Map<XMPPConnection, DnsOverXmppManager> map = INSTANCES;
            dnsOverXmppManager = map.get(xMPPConnection);
            if (dnsOverXmppManager == null) {
                dnsOverXmppManager = new DnsOverXmppManager(xMPPConnection);
                map.put(xMPPConnection, dnsOverXmppManager);
            }
        }
        return dnsOverXmppManager;
    }

    public static void setDefaultDnsOverXmppResolver(DnsOverXmppResolver dnsOverXmppResolver) {
        defaultResolver = dnsOverXmppResolver;
    }

    public synchronized void disable() {
        if (this.enabled) {
            XMPPConnection connection = connection();
            if (connection != null) {
                this.serviceDiscoveryManager.removeFeature("urn:xmpp:dox:0");
                connection.unregisterIQRequestHandler(this.dnsIqRequestHandler);
            }
        }
    }

    public synchronized void enable() {
        if (!this.enabled) {
            if (this.resolver != null) {
                XMPPConnection connection = connection();
                if (connection != null) {
                    connection.registerIQRequestHandler(this.dnsIqRequestHandler);
                    this.serviceDiscoveryManager.addFeature("urn:xmpp:dox:0");
                    return;
                }
                return;
            }
            throw new IllegalStateException("No DnsOverXmppResolver configured");
        }
    }

    public boolean isSupported(Jid jid) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return this.serviceDiscoveryManager.supportsFeature(jid, "urn:xmpp:dox:0");
    }

    public DnsMessage query(Jid jid, a aVar) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return query(jid, DnsMessage.d().r(aVar).y(RandomUtil.nextSecureRandomInt()).B(true).s());
    }

    public synchronized void setDnsOverXmppResolver(DnsOverXmppResolver dnsOverXmppResolver) {
        this.resolver = dnsOverXmppResolver;
        if (dnsOverXmppResolver == null) {
            disable();
        }
    }

    public DnsMessage query(Jid jid, DnsMessage dnsMessage) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return ((DnsIq) connection().sendIqRequestAndWaitForResponse(new DnsIq(dnsMessage, jid))).getDnsMessage();
    }
}

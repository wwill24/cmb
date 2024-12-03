package org.jivesoftware.smackx.bytestreams.socks5;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeoutException;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smackx.bytestreams.BytestreamListener;
import org.jivesoftware.smackx.bytestreams.BytestreamManager;
import org.jivesoftware.smackx.bytestreams.socks5.packet.Bytestream;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;
import org.jxmpp.jid.EntityFullJid;
import org.jxmpp.jid.Jid;

public final class Socks5BytestreamManager extends Manager implements BytestreamManager {
    private static final String SESSION_ID_PREFIX = "js5_";
    private static final Map<XMPPConnection, Socks5BytestreamManager> managers = new WeakHashMap();
    private final List<BytestreamListener> allRequestListeners = Collections.synchronizedList(new LinkedList());
    private boolean annouceLocalStreamHost = true;
    private final List<String> ignoredBytestreamRequests = Collections.synchronizedList(new LinkedList());
    private final InitiationListener initiationListener = new InitiationListener(this);
    private Jid lastWorkingProxy;
    private final Set<Jid> proxyBlacklist = Collections.synchronizedSet(new HashSet());
    private int proxyConnectionTimeout = 10000;
    private boolean proxyPrioritizationEnabled = true;
    private int targetResponseTimeout = 10000;
    private final Map<Jid, BytestreamListener> userListeners = new ConcurrentHashMap();

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() {
            public void connectionCreated(XMPPConnection xMPPConnection) {
                Socks5BytestreamManager.getBytestreamManager(xMPPConnection);
            }
        });
    }

    private Socks5BytestreamManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        activate();
    }

    private void activate() {
        connection().registerIQRequestHandler(this.initiationListener);
        enableService();
    }

    private static Bytestream createBytestreamInitiation(String str, Jid jid, List<Bytestream.StreamHost> list) {
        Bytestream bytestream = new Bytestream(str);
        for (Bytestream.StreamHost addStreamHost : list) {
            bytestream.addStreamHost(addStreamHost);
        }
        bytestream.setType(IQ.Type.set);
        bytestream.setTo(jid);
        return bytestream;
    }

    private static Bytestream createStreamHostRequest(Jid jid) {
        Bytestream bytestream = new Bytestream();
        bytestream.setType(IQ.Type.get);
        bytestream.setTo(jid);
        return bytestream;
    }

    private List<Bytestream.StreamHost> determineStreamHostInfos(List<Jid> list) {
        XMPPConnection connection = connection();
        ArrayList arrayList = new ArrayList();
        if (this.annouceLocalStreamHost) {
            arrayList.addAll(getLocalStreamHost());
        }
        for (Jid next : list) {
            try {
                arrayList.addAll(((Bytestream) connection.createStanzaCollectorAndSend(createStreamHostRequest(next)).nextResultOrThrow()).getStreamHosts());
            } catch (Exception unused) {
                this.proxyBlacklist.add(next);
            }
        }
        return arrayList;
    }

    private void enableService() {
        ServiceDiscoveryManager.getInstanceFor(connection()).addFeature(Bytestream.NAMESPACE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized org.jivesoftware.smackx.bytestreams.socks5.Socks5BytestreamManager getBytestreamManager(org.jivesoftware.smack.XMPPConnection r3) {
        /*
            java.lang.Class<org.jivesoftware.smackx.bytestreams.socks5.Socks5BytestreamManager> r0 = org.jivesoftware.smackx.bytestreams.socks5.Socks5BytestreamManager.class
            monitor-enter(r0)
            if (r3 != 0) goto L_0x0008
            r3 = 0
            monitor-exit(r0)
            return r3
        L_0x0008:
            java.util.Map<org.jivesoftware.smack.XMPPConnection, org.jivesoftware.smackx.bytestreams.socks5.Socks5BytestreamManager> r1 = managers     // Catch:{ all -> 0x001c }
            java.lang.Object r2 = r1.get(r3)     // Catch:{ all -> 0x001c }
            org.jivesoftware.smackx.bytestreams.socks5.Socks5BytestreamManager r2 = (org.jivesoftware.smackx.bytestreams.socks5.Socks5BytestreamManager) r2     // Catch:{ all -> 0x001c }
            if (r2 != 0) goto L_0x001a
            org.jivesoftware.smackx.bytestreams.socks5.Socks5BytestreamManager r2 = new org.jivesoftware.smackx.bytestreams.socks5.Socks5BytestreamManager     // Catch:{ all -> 0x001c }
            r2.<init>(r3)     // Catch:{ all -> 0x001c }
            r1.put(r3, r2)     // Catch:{ all -> 0x001c }
        L_0x001a:
            monitor-exit(r0)
            return r2
        L_0x001c:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.bytestreams.socks5.Socks5BytestreamManager.getBytestreamManager(org.jivesoftware.smack.XMPPConnection):org.jivesoftware.smackx.bytestreams.socks5.Socks5BytestreamManager");
    }

    private static String getNextSessionID() {
        return SESSION_ID_PREFIX + StringUtils.secureOnlineAttackSafeRandomString();
    }

    private boolean supportsSocks5(Jid jid) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return ServiceDiscoveryManager.getInstanceFor(connection()).supportsFeature(jid, Bytestream.NAMESPACE);
    }

    public void addIncomingBytestreamListener(BytestreamListener bytestreamListener) {
        this.allRequestListeners.add(bytestreamListener);
    }

    public List<Jid> determineProxies() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        XMPPConnection connection = connection();
        ServiceDiscoveryManager instanceFor = ServiceDiscoveryManager.getInstanceFor(connection);
        ArrayList arrayList = new ArrayList();
        for (DiscoverItems.Item next : instanceFor.discoverItems(connection.getXMPPServiceDomain()).getItems()) {
            if (!this.proxyBlacklist.contains(next.getEntityID())) {
                try {
                    if (instanceFor.discoverInfo(next.getEntityID()).hasIdentity("proxy", "bytestreams")) {
                        arrayList.add(next.getEntityID());
                    } else {
                        this.proxyBlacklist.add(next.getEntityID());
                    }
                } catch (SmackException.NoResponseException | XMPPException.XMPPErrorException unused) {
                    this.proxyBlacklist.add(next.getEntityID());
                }
            }
        }
        return arrayList;
    }

    public synchronized void disableService() {
        XMPPConnection connection = connection();
        connection.unregisterIQRequestHandler(this.initiationListener);
        this.initiationListener.shutdown();
        this.allRequestListeners.clear();
        this.userListeners.clear();
        this.lastWorkingProxy = null;
        this.proxyBlacklist.clear();
        this.ignoredBytestreamRequests.clear();
        Map<XMPPConnection, Socks5BytestreamManager> map = managers;
        map.remove(connection);
        if (map.size() == 0) {
            Socks5Proxy.getSocks5Proxy().stop();
        }
        ServiceDiscoveryManager instanceFor = ServiceDiscoveryManager.getInstanceFor(connection);
        if (instanceFor != null) {
            instanceFor.removeFeature(Bytestream.NAMESPACE);
        }
    }

    /* access modifiers changed from: protected */
    public List<BytestreamListener> getAllRequestListeners() {
        return this.allRequestListeners;
    }

    /* access modifiers changed from: protected */
    public XMPPConnection getConnection() {
        return connection();
    }

    /* access modifiers changed from: protected */
    public List<String> getIgnoredBytestreamRequests() {
        return this.ignoredBytestreamRequests;
    }

    public List<Bytestream.StreamHost> getLocalStreamHost() {
        Socks5Proxy.getSocks5Proxy();
        ArrayList arrayList = new ArrayList();
        EntityFullJid user = connection().getUser();
        for (Socks5Proxy next : Socks5Proxy.getRunningProxies()) {
            List<InetAddress> localAddresses = next.getLocalAddresses();
            if (!localAddresses.isEmpty()) {
                int port = next.getPort();
                for (InetAddress next2 : localAddresses) {
                    if (!next2.isLoopbackAddress()) {
                        arrayList.add(new Bytestream.StreamHost((Jid) user, next2, port));
                    }
                }
            }
        }
        return arrayList;
    }

    public int getProxyConnectionTimeout() {
        if (this.proxyConnectionTimeout <= 0) {
            this.proxyConnectionTimeout = 10000;
        }
        return this.proxyConnectionTimeout;
    }

    public int getTargetResponseTimeout() {
        if (this.targetResponseTimeout <= 0) {
            this.targetResponseTimeout = 10000;
        }
        return this.targetResponseTimeout;
    }

    /* access modifiers changed from: protected */
    public BytestreamListener getUserListener(Jid jid) {
        return this.userListeners.get(jid);
    }

    public void ignoreBytestreamRequestOnce(String str) {
        this.ignoredBytestreamRequests.add(str);
    }

    public boolean isAnnouncingLocalStreamHostEnabled() {
        return this.annouceLocalStreamHost;
    }

    public boolean isProxyPrioritizationEnabled() {
        return this.proxyPrioritizationEnabled;
    }

    public void removeIncomingBytestreamListener(BytestreamListener bytestreamListener) {
        this.allRequestListeners.remove(bytestreamListener);
    }

    /* access modifiers changed from: protected */
    public void replyRejectPacket(IQ iq) throws SmackException.NotConnectedException, InterruptedException {
        connection().sendStanza(IQ.createErrorResponse(iq, StanzaError.getBuilder(StanzaError.Condition.not_acceptable).build()));
    }

    public void setAnnounceLocalStreamHost(boolean z10) {
        this.annouceLocalStreamHost = z10;
    }

    public void setProxyConnectionTimeout(int i10) {
        this.proxyConnectionTimeout = i10;
    }

    public void setProxyPrioritizationEnabled(boolean z10) {
        this.proxyPrioritizationEnabled = z10;
    }

    public void setTargetResponseTimeout(int i10) {
        this.targetResponseTimeout = i10;
    }

    public void addIncomingBytestreamListener(BytestreamListener bytestreamListener, Jid jid) {
        this.userListeners.put(jid, bytestreamListener);
    }

    public void removeIncomingBytestreamListener(Jid jid) {
        this.userListeners.remove(jid);
    }

    public Socks5BytestreamSession establishSession(Jid jid) throws XMPPException, IOException, InterruptedException, SmackException {
        return establishSession(jid, getNextSessionID());
    }

    public Socks5BytestreamSession establishSession(Jid jid, String str) throws IOException, InterruptedException, XMPPException, SmackException.NoResponseException, SmackException.NotConnectedException, SmackException.SmackMessageException, SmackException.FeatureNotSupportedException {
        XMPPConnection connection = connection();
        if (supportsSocks5(jid)) {
            ArrayList arrayList = new ArrayList();
            Bytestream.StreamHost streamHost = null;
            try {
                arrayList.addAll(determineProxies());
                e = null;
            } catch (XMPPException.XMPPErrorException e10) {
                e = e10;
            }
            List<Bytestream.StreamHost> determineStreamHostInfos = determineStreamHostInfos(arrayList);
            if (!determineStreamHostInfos.isEmpty()) {
                String createDigest = Socks5Utils.createDigest(str, connection.getUser(), jid);
                if (this.proxyPrioritizationEnabled && this.lastWorkingProxy != null) {
                    Iterator<Bytestream.StreamHost> it = determineStreamHostInfos.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Bytestream.StreamHost next = it.next();
                        if (next.getJID().Y(this.lastWorkingProxy)) {
                            streamHost = next;
                            break;
                        }
                    }
                    if (streamHost != null) {
                        determineStreamHostInfos.remove(streamHost);
                        determineStreamHostInfos.add(0, streamHost);
                    }
                }
                Socks5Proxy socks5Proxy = Socks5Proxy.getSocks5Proxy();
                try {
                    socks5Proxy.addTransfer(createDigest);
                    Bytestream createBytestreamInitiation = createBytestreamInitiation(str, jid, determineStreamHostInfos);
                    Bytestream.StreamHost streamHost2 = createBytestreamInitiation.getStreamHost(((Bytestream) connection.createStanzaCollectorAndSend(createBytestreamInitiation).nextResultOrThrow((long) getTargetResponseTimeout())).getUsedHost().getJID());
                    if (streamHost2 != null) {
                        Socket socket = new Socks5ClientForInitiator(streamHost2, createDigest, connection, str, jid).getSocket(getProxyConnectionTimeout());
                        this.lastWorkingProxy = streamHost2.getJID();
                        Socks5BytestreamSession socks5BytestreamSession = new Socks5BytestreamSession(socket, streamHost2.getJID().Y(connection.getUser()));
                        socks5Proxy.removeTransfer(createDigest);
                        return socks5BytestreamSession;
                    }
                    throw new SmackException.SmackMessageException("Remote user responded with unknown host");
                } catch (TimeoutException e11) {
                    throw new IOException("Timeout while connecting to SOCKS5 proxy", e11);
                } catch (Throwable th2) {
                    socks5Proxy.removeTransfer(createDigest);
                    throw th2;
                }
            } else if (e != null) {
                throw e;
            } else {
                throw new SmackException.SmackMessageException("no SOCKS5 proxies available");
            }
        } else {
            throw new SmackException.FeatureNotSupportedException("SOCKS5 Bytestream", jid);
        }
    }
}

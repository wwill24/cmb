package org.jivesoftware.smackx.bytestreams.ibb;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import net.bytebuddy.jar.asm.Opcodes;
import org.jivesoftware.smack.AbstractConnectionClosedListener;
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
import org.jivesoftware.smackx.bytestreams.ibb.packet.Open;
import org.jxmpp.jid.Jid;

public final class InBandBytestreamManager extends Manager implements BytestreamManager {
    public static final int MAXIMUM_BLOCK_SIZE = 65535;
    private static final String SESSION_ID_PREFIX = "jibb_";
    private static final Map<XMPPConnection, InBandBytestreamManager> managers = new WeakHashMap();
    private final List<BytestreamListener> allRequestListeners = Collections.synchronizedList(new LinkedList());
    private final CloseListener closeListener;
    private final DataListener dataListener;
    private int defaultBlockSize = Opcodes.ACC_SYNTHETIC;
    /* access modifiers changed from: private */
    public final List<String> ignoredBytestreamRequests = Collections.synchronizedList(new LinkedList());
    private final InitiationListener initiationListener;
    private int maximumBlockSize = 65535;
    /* access modifiers changed from: private */
    public final Map<String, InBandBytestreamSession> sessions = new ConcurrentHashMap();
    private StanzaType stanza = StanzaType.IQ;
    private final Map<Jid, BytestreamListener> userListeners = new ConcurrentHashMap();

    public enum StanzaType {
        IQ,
        MESSAGE
    }

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() {
            public void connectionCreated(XMPPConnection xMPPConnection) {
                InBandBytestreamManager.getByteStreamManager(xMPPConnection);
            }
        });
    }

    private InBandBytestreamManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        xMPPConnection.addConnectionListener(new AbstractConnectionClosedListener() {
            public void connectionTerminated() {
                InBandBytestreamManager.this.sessions.clear();
                InBandBytestreamManager.this.ignoredBytestreamRequests.clear();
            }
        });
        InitiationListener initiationListener2 = new InitiationListener(this);
        this.initiationListener = initiationListener2;
        xMPPConnection.registerIQRequestHandler(initiationListener2);
        DataListener dataListener2 = new DataListener(this);
        this.dataListener = dataListener2;
        xMPPConnection.registerIQRequestHandler(dataListener2);
        CloseListener closeListener2 = new CloseListener(this);
        this.closeListener = closeListener2;
        xMPPConnection.registerIQRequestHandler(closeListener2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamManager getByteStreamManager(org.jivesoftware.smack.XMPPConnection r3) {
        /*
            java.lang.Class<org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamManager> r0 = org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamManager.class
            monitor-enter(r0)
            if (r3 != 0) goto L_0x0008
            r3 = 0
            monitor-exit(r0)
            return r3
        L_0x0008:
            java.util.Map<org.jivesoftware.smack.XMPPConnection, org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamManager> r1 = managers     // Catch:{ all -> 0x001c }
            java.lang.Object r2 = r1.get(r3)     // Catch:{ all -> 0x001c }
            org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamManager r2 = (org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamManager) r2     // Catch:{ all -> 0x001c }
            if (r2 != 0) goto L_0x001a
            org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamManager r2 = new org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamManager     // Catch:{ all -> 0x001c }
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
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamManager.getByteStreamManager(org.jivesoftware.smack.XMPPConnection):org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamManager");
    }

    private static String getNextSessionID() {
        return SESSION_ID_PREFIX + StringUtils.secureOnlineAttackSafeRandomString();
    }

    public void addIncomingBytestreamListener(BytestreamListener bytestreamListener) {
        this.allRequestListeners.add(bytestreamListener);
    }

    /* access modifiers changed from: protected */
    public List<BytestreamListener> getAllRequestListeners() {
        return this.allRequestListeners;
    }

    /* access modifiers changed from: protected */
    public XMPPConnection getConnection() {
        return connection();
    }

    public int getDefaultBlockSize() {
        return this.defaultBlockSize;
    }

    /* access modifiers changed from: protected */
    public List<String> getIgnoredBytestreamRequests() {
        return this.ignoredBytestreamRequests;
    }

    public int getMaximumBlockSize() {
        return this.maximumBlockSize;
    }

    /* access modifiers changed from: protected */
    public Map<String, InBandBytestreamSession> getSessions() {
        return this.sessions;
    }

    public StanzaType getStanza() {
        return this.stanza;
    }

    /* access modifiers changed from: protected */
    public BytestreamListener getUserListener(Jid jid) {
        return this.userListeners.get(jid);
    }

    public void ignoreBytestreamRequestOnce(String str) {
        this.ignoredBytestreamRequests.add(str);
    }

    public void removeIncomingBytestreamListener(BytestreamListener bytestreamListener) {
        this.allRequestListeners.remove(bytestreamListener);
    }

    /* access modifiers changed from: protected */
    public void replyItemNotFoundPacket(IQ iq) throws SmackException.NotConnectedException, InterruptedException {
        connection().sendStanza(IQ.createErrorResponse(iq, StanzaError.Condition.item_not_found));
    }

    /* access modifiers changed from: protected */
    public void replyRejectPacket(IQ iq) throws SmackException.NotConnectedException, InterruptedException {
        connection().sendStanza(IQ.createErrorResponse(iq, StanzaError.Condition.not_acceptable));
    }

    public void setDefaultBlockSize(int i10) {
        if (i10 <= 0 || i10 > 65535) {
            throw new IllegalArgumentException("Default block size must be between 1 and 65535");
        }
        this.defaultBlockSize = i10;
    }

    public void setMaximumBlockSize(int i10) {
        if (i10 <= 0 || i10 > 65535) {
            throw new IllegalArgumentException("Maximum block size must be between 1 and 65535");
        }
        this.maximumBlockSize = i10;
    }

    public void setStanza(StanzaType stanzaType) {
        this.stanza = stanzaType;
    }

    public void addIncomingBytestreamListener(BytestreamListener bytestreamListener, Jid jid) {
        this.userListeners.put(jid, bytestreamListener);
    }

    public void removeIncomingBytestreamListener(Jid jid) {
        this.userListeners.remove(jid);
    }

    public InBandBytestreamSession establishSession(Jid jid) throws XMPPException, SmackException, InterruptedException {
        return establishSession(jid, getNextSessionID());
    }

    public InBandBytestreamSession establishSession(Jid jid, String str) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        Open open = new Open(str, this.defaultBlockSize, this.stanza);
        open.setTo(jid);
        XMPPConnection connection = connection();
        connection.createStanzaCollectorAndSend(open).nextResultOrThrow();
        InBandBytestreamSession inBandBytestreamSession = new InBandBytestreamSession(connection, open, jid);
        this.sessions.put(str, inBandBytestreamSession);
        return inBandBytestreamSession;
    }
}

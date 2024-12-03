package org.jivesoftware.smackx.bytestreams.socks5;

import com.facebook.internal.security.CertificateUtil;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import mm.a;
import mm.b;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smackx.bytestreams.BytestreamRequest;
import org.jivesoftware.smackx.bytestreams.socks5.Socks5Exception;
import org.jivesoftware.smackx.bytestreams.socks5.packet.Bytestream;
import org.jxmpp.jid.Jid;

public class Socks5BytestreamRequest implements BytestreamRequest {
    private static final a<String, Integer> ADDRESS_BLACKLIST = new b(100, BLACKLIST_LIFETIME);
    private static final long BLACKLIST_LIFETIME = 7200000;
    private static final int BLACKLIST_MAX_SIZE = 100;
    private static int DEFAULT_CONNECTION_FAILURE_THRESHOLD = 2;
    private Bytestream bytestreamRequest;
    private int connectionFailureThreshold = DEFAULT_CONNECTION_FAILURE_THRESHOLD;
    private Socks5BytestreamManager manager;
    private int minimumConnectTimeout = 2000;
    private int totalConnectTimeout = 10000;

    protected Socks5BytestreamRequest(Socks5BytestreamManager socks5BytestreamManager, Bytestream bytestream) {
        this.manager = socks5BytestreamManager;
        this.bytestreamRequest = bytestream;
    }

    private void cancelRequest(Map<Bytestream.StreamHost, Exception> map) throws SmackException.NotConnectedException, InterruptedException, Socks5Exception.CouldNotConnectToAnyProvidedSocks5Host, Socks5Exception.NoSocks5StreamHostsProvided {
        Socks5Exception.CouldNotConnectToAnyProvidedSocks5Host couldNotConnectToAnyProvidedSocks5Host;
        String str;
        Socks5Exception.NoSocks5StreamHostsProvided noSocks5StreamHostsProvided = null;
        if (map.isEmpty()) {
            Socks5Exception.NoSocks5StreamHostsProvided noSocks5StreamHostsProvided2 = new Socks5Exception.NoSocks5StreamHostsProvided();
            str = noSocks5StreamHostsProvided2.getMessage();
            noSocks5StreamHostsProvided = noSocks5StreamHostsProvided2;
            couldNotConnectToAnyProvidedSocks5Host = null;
        } else {
            couldNotConnectToAnyProvidedSocks5Host = Socks5Exception.CouldNotConnectToAnyProvidedSocks5Host.construct(map);
            str = couldNotConnectToAnyProvidedSocks5Host.getMessage();
        }
        this.manager.getConnection().sendStanza(IQ.createErrorResponse((IQ) this.bytestreamRequest, StanzaError.from(StanzaError.Condition.item_not_found, str).build()));
        if (noSocks5StreamHostsProvided != null) {
            throw noSocks5StreamHostsProvided;
        }
        throw couldNotConnectToAnyProvidedSocks5Host;
    }

    private Bytestream createUsedHostResponse(Bytestream.StreamHost streamHost) {
        Bytestream bytestream = new Bytestream(this.bytestreamRequest.getSessionID());
        bytestream.setTo(this.bytestreamRequest.getFrom());
        bytestream.setType(IQ.Type.result);
        bytestream.setStanzaId(this.bytestreamRequest.getStanzaId());
        bytestream.setUsedHost(streamHost.getJID());
        return bytestream;
    }

    private static int getConnectionFailures(String str) {
        Integer a10 = ADDRESS_BLACKLIST.a(str);
        if (a10 != null) {
            return a10.intValue();
        }
        return 0;
    }

    public static int getDefaultConnectFailureThreshold() {
        return DEFAULT_CONNECTION_FAILURE_THRESHOLD;
    }

    private static void incrementConnectionFailures(String str) {
        a<String, Integer> aVar = ADDRESS_BLACKLIST;
        Integer a10 = aVar.a(str);
        int i10 = 1;
        if (a10 != null) {
            i10 = 1 + a10.intValue();
        }
        aVar.put(str, Integer.valueOf(i10));
    }

    public static void setDefaultConnectFailureThreshold(int i10) {
        DEFAULT_CONNECTION_FAILURE_THRESHOLD = i10;
    }

    public int getConnectFailureThreshold() {
        return this.connectionFailureThreshold;
    }

    public Jid getFrom() {
        return this.bytestreamRequest.getFrom();
    }

    public int getMinimumConnectTimeout() {
        int i10 = this.minimumConnectTimeout;
        if (i10 <= 0) {
            return 2000;
        }
        return i10;
    }

    public String getSessionID() {
        return this.bytestreamRequest.getSessionID();
    }

    public int getTotalConnectTimeout() {
        int i10 = this.totalConnectTimeout;
        if (i10 <= 0) {
            return 10000;
        }
        return i10;
    }

    public void reject() throws SmackException.NotConnectedException, InterruptedException {
        this.manager.replyRejectPacket(this.bytestreamRequest);
    }

    public void setConnectFailureThreshold(int i10) {
        this.connectionFailureThreshold = i10;
    }

    public void setMinimumConnectTimeout(int i10) {
        this.minimumConnectTimeout = i10;
    }

    public void setTotalConnectTimeout(int i10) {
        this.totalConnectTimeout = i10;
    }

    public Socks5BytestreamSession accept() throws InterruptedException, XMPPException.XMPPErrorException, Socks5Exception.CouldNotConnectToAnyProvidedSocks5Host, SmackException.NotConnectedException, Socks5Exception.NoSocks5StreamHostsProvided {
        Bytestream.StreamHost streamHost;
        Socket socket;
        List<Bytestream.StreamHost> streamHosts = this.bytestreamRequest.getStreamHosts();
        HashMap hashMap = new HashMap();
        if (streamHosts.size() == 0) {
            cancelRequest(hashMap);
        }
        String createDigest = Socks5Utils.createDigest(this.bytestreamRequest.getSessionID(), this.bytestreamRequest.getFrom(), this.manager.getConnection().getUser());
        int max = Math.max(getTotalConnectTimeout() / streamHosts.size(), getMinimumConnectTimeout());
        Iterator<Bytestream.StreamHost> it = streamHosts.iterator();
        while (true) {
            streamHost = null;
            if (!it.hasNext()) {
                socket = null;
                break;
            }
            streamHost = it.next();
            String str = streamHost.getAddress() + CertificateUtil.DELIMITER + streamHost.getPort();
            int connectionFailures = getConnectionFailures(str);
            int i10 = this.connectionFailureThreshold;
            if (i10 <= 0 || connectionFailures < i10) {
                try {
                    socket = new Socks5Client(streamHost, createDigest).getSocket(max);
                    break;
                } catch (IOException | TimeoutException | SmackException | XMPPException e10) {
                    hashMap.put(streamHost, e10);
                    incrementConnectionFailures(str);
                }
            }
        }
        if (streamHost == null || socket == null) {
            cancelRequest(hashMap);
        }
        this.manager.getConnection().sendStanza(createUsedHostResponse(streamHost));
        return new Socks5BytestreamSession(socket, streamHost.getJID().Y(this.bytestreamRequest.getFrom()));
    }
}

package org.jivesoftware.smackx.bob;

import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler;
import org.jivesoftware.smack.iqrequest.IQRequestHandler;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.util.SHA1;
import org.jivesoftware.smackx.bob.element.BoBIQ;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jxmpp.jid.Jid;
import org.jxmpp.util.cache.LruCache;

public final class BoBManager extends Manager {
    private static final LruCache<ContentId, BoBData> BOB_CACHE = new LruCache<>(128);
    private static final Map<XMPPConnection, BoBManager> INSTANCES = new WeakHashMap();
    public static final String NAMESPACE = "urn:xmpp:bob";
    /* access modifiers changed from: private */
    public final Map<ContentId, BoBInfo> bobs = new ConcurrentHashMap();

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() {
            public void connectionCreated(XMPPConnection xMPPConnection) {
                BoBManager.getInstanceFor(xMPPConnection);
            }
        });
    }

    private BoBManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        ServiceDiscoveryManager.getInstanceFor(xMPPConnection).addFeature("urn:xmpp:bob");
        xMPPConnection.registerIQRequestHandler(new AbstractIqRequestHandler("data", "urn:xmpp:bob", IQ.Type.get, IQRequestHandler.Mode.async) {
            public IQ handleIQRequest(IQ iq) {
                BoBIQ boBIQ = (BoBIQ) iq;
                ContentId contentId = boBIQ.getContentId();
                BoBInfo boBInfo = (BoBInfo) BoBManager.this.bobs.get(contentId);
                if (boBInfo == null) {
                    return null;
                }
                BoBIQ boBIQ2 = new BoBIQ(contentId, boBInfo.getData());
                boBIQ2.setType(IQ.Type.result);
                boBIQ2.setTo(boBIQ.getFrom());
                return boBIQ2;
            }
        });
    }

    public static synchronized BoBManager getInstanceFor(XMPPConnection xMPPConnection) {
        BoBManager boBManager;
        synchronized (BoBManager.class) {
            Map<XMPPConnection, BoBManager> map = INSTANCES;
            boBManager = map.get(xMPPConnection);
            if (boBManager == null) {
                boBManager = new BoBManager(xMPPConnection);
                map.put(xMPPConnection, boBManager);
            }
        }
        return boBManager;
    }

    public BoBInfo addBoB(BoBData boBData) {
        ContentId contentId = new ContentId(SHA1.hex(boBData.getContent()), "sha1");
        BoBInfo boBInfo = new BoBInfo(Collections.unmodifiableSet(Collections.singleton(contentId)), boBData);
        this.bobs.put(contentId, boBInfo);
        return boBInfo;
    }

    public boolean isSupportedByServer() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return ServiceDiscoveryManager.getInstanceFor(connection()).serverSupportsFeature("urn:xmpp:bob");
    }

    public BoBInfo removeBoB(ContentId contentId) {
        BoBInfo remove = this.bobs.remove(contentId);
        if (remove == null) {
            return null;
        }
        for (ContentId remove2 : remove.getHashes()) {
            this.bobs.remove(remove2);
        }
        return remove;
    }

    public BoBData requestBoB(Jid jid, ContentId contentId) throws SmackException.NotLoggedInException, SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        LruCache<ContentId, BoBData> lruCache = BOB_CACHE;
        BoBData a10 = lruCache.a(contentId);
        if (a10 != null) {
            return a10;
        }
        BoBIQ boBIQ = new BoBIQ(contentId);
        boBIQ.setType(IQ.Type.get);
        boBIQ.setTo(jid);
        BoBData boBData = ((BoBIQ) getAuthenticatedConnectionOrThrow().createStanzaCollectorAndSend(boBIQ).nextResultOrThrow()).getBoBData();
        lruCache.put(contentId, boBData);
        return boBData;
    }
}

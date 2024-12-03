package org.jivesoftware.smackx.iot.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaCollector;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.iqrequest.IQRequestHandler;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.iot.IoTManager;
import org.jivesoftware.smackx.iot.Thing;
import org.jivesoftware.smackx.iot.data.element.IoTDataRequest;
import org.jivesoftware.smackx.iot.data.element.IoTFieldsExtension;
import org.jivesoftware.smackx.iot.data.filter.IoTFieldsExtensionFilter;
import org.jivesoftware.smackx.iot.element.NodeInfo;
import org.jxmpp.jid.EntityFullJid;

public final class IoTDataManager extends IoTManager {
    private static final Map<XMPPConnection, IoTDataManager> INSTANCES = new WeakHashMap();
    /* access modifiers changed from: private */
    public static final Logger LOGGER = Logger.getLogger(IoTDataManager.class.getName());
    private final AtomicInteger nextSeqNr = new AtomicInteger();
    /* access modifiers changed from: private */
    public final Map<NodeInfo, Thing> things = new ConcurrentHashMap();

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() {
            public void connectionCreated(XMPPConnection xMPPConnection) {
                if (IoTManager.isAutoEnableActive()) {
                    IoTDataManager.getInstanceFor(xMPPConnection);
                }
            }
        });
    }

    private IoTDataManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        xMPPConnection.registerIQRequestHandler(new IoTManager.IoTIqRequestHandler("req", "urn:xmpp:iot:sensordata", IQ.Type.get, IQRequestHandler.Mode.async) {
            /* JADX WARNING: Code restructure failed: missing block: B:3:0x000a, code lost:
                r0 = (org.jivesoftware.smackx.iot.Thing) org.jivesoftware.smackx.iot.data.IoTDataManager.access$000(r3.this$0).get(org.jivesoftware.smackx.iot.element.NodeInfo.EMPTY);
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public org.jivesoftware.smack.packet.IQ handleIoTIqRequest(org.jivesoftware.smack.packet.IQ r4) {
                /*
                    r3 = this;
                    org.jivesoftware.smackx.iot.data.element.IoTDataRequest r4 = (org.jivesoftware.smackx.iot.data.element.IoTDataRequest) r4
                    boolean r0 = r4.isMomentary()
                    r1 = 0
                    if (r0 != 0) goto L_0x000a
                    return r1
                L_0x000a:
                    org.jivesoftware.smackx.iot.data.IoTDataManager r0 = org.jivesoftware.smackx.iot.data.IoTDataManager.this
                    java.util.Map r0 = r0.things
                    org.jivesoftware.smackx.iot.element.NodeInfo r2 = org.jivesoftware.smackx.iot.element.NodeInfo.EMPTY
                    java.lang.Object r0 = r0.get(r2)
                    org.jivesoftware.smackx.iot.Thing r0 = (org.jivesoftware.smackx.iot.Thing) r0
                    if (r0 != 0) goto L_0x001b
                    return r1
                L_0x001b:
                    org.jivesoftware.smackx.iot.data.ThingMomentaryReadOutRequest r2 = r0.getMomentaryReadOutRequestHandler()
                    if (r2 != 0) goto L_0x0022
                    return r1
                L_0x0022:
                    org.jivesoftware.smackx.iot.data.IoTDataManager$2$1 r1 = new org.jivesoftware.smackx.iot.data.IoTDataManager$2$1
                    r1.<init>(r4, r0)
                    r2.momentaryReadOutRequest(r1)
                    org.jivesoftware.smackx.iot.data.element.IoTDataReadOutAccepted r0 = new org.jivesoftware.smackx.iot.data.element.IoTDataReadOutAccepted
                    r0.<init>(r4)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.iot.data.IoTDataManager.AnonymousClass2.handleIoTIqRequest(org.jivesoftware.smack.packet.IQ):org.jivesoftware.smack.packet.IQ");
            }
        });
    }

    public static synchronized IoTDataManager getInstanceFor(XMPPConnection xMPPConnection) {
        IoTDataManager ioTDataManager;
        synchronized (IoTDataManager.class) {
            Map<XMPPConnection, IoTDataManager> map = INSTANCES;
            ioTDataManager = map.get(xMPPConnection);
            if (ioTDataManager == null) {
                ioTDataManager = new IoTDataManager(xMPPConnection);
                map.put(xMPPConnection, ioTDataManager);
            }
        }
        return ioTDataManager;
    }

    public void installThing(Thing thing) {
        this.things.put(thing.getNodeInfo(), thing);
    }

    /* JADX INFO: finally extract failed */
    public List<IoTFieldsExtension> requestMomentaryValuesReadOut(EntityFullJid entityFullJid) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        XMPPConnection connection = connection();
        int incrementAndGet = this.nextSeqNr.incrementAndGet();
        IoTDataRequest ioTDataRequest = new IoTDataRequest(incrementAndGet, true);
        ioTDataRequest.setTo(entityFullJid);
        IoTFieldsExtensionFilter ioTFieldsExtensionFilter = new IoTFieldsExtensionFilter(incrementAndGet, true);
        IoTFieldsExtensionFilter ioTFieldsExtensionFilter2 = new IoTFieldsExtensionFilter(incrementAndGet, false);
        StanzaCollector createStanzaCollector = connection.createStanzaCollector((StanzaFilter) ioTFieldsExtensionFilter);
        StanzaCollector createStanzaCollector2 = connection.createStanzaCollector(StanzaCollector.newConfiguration().setStanzaFilter(ioTFieldsExtensionFilter2).setCollectorToReset(createStanzaCollector));
        try {
            connection.createStanzaCollectorAndSend(ioTDataRequest).nextResultOrThrow();
            createStanzaCollector.nextResult();
            createStanzaCollector2.cancel();
            int collectedCount = createStanzaCollector2.getCollectedCount();
            ArrayList arrayList = new ArrayList(collectedCount);
            for (int i10 = 0; i10 < collectedCount; i10++) {
                arrayList.add(IoTFieldsExtension.from((Message) createStanzaCollector2.pollResult()));
            }
            return arrayList;
        } catch (Throwable th2) {
            createStanzaCollector2.cancel();
            throw th2;
        }
    }

    public Thing uninstallThing(Thing thing) {
        return uninstallThing(thing.getNodeInfo());
    }

    public Thing uninstallThing(NodeInfo nodeInfo) {
        return this.things.remove(nodeInfo);
    }
}

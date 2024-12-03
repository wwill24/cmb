package org.jivesoftware.smackx.iot.control;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.iqrequest.IQRequestHandler;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.iot.IoTManager;
import org.jivesoftware.smackx.iot.Thing;
import org.jivesoftware.smackx.iot.control.element.IoTSetRequest;
import org.jivesoftware.smackx.iot.control.element.IoTSetResponse;
import org.jivesoftware.smackx.iot.control.element.SetData;
import org.jivesoftware.smackx.iot.element.NodeInfo;
import org.jxmpp.jid.FullJid;

public final class IoTControlManager extends IoTManager {
    private static final Map<XMPPConnection, IoTControlManager> INSTANCES = new WeakHashMap();
    /* access modifiers changed from: private */
    public final Map<NodeInfo, Thing> things = new ConcurrentHashMap();

    private IoTControlManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        xMPPConnection.registerIQRequestHandler(new IoTManager.IoTIqRequestHandler("set", "urn:xmpp:iot:control", IQ.Type.set, IQRequestHandler.Mode.async) {
            public IQ handleIoTIqRequest(IQ iq) {
                ThingControlRequest controlRequestHandler;
                IoTSetRequest ioTSetRequest = (IoTSetRequest) iq;
                Thing thing = (Thing) IoTControlManager.this.things.get(NodeInfo.EMPTY);
                if (thing == null || (controlRequestHandler = thing.getControlRequestHandler()) == null) {
                    return null;
                }
                try {
                    controlRequestHandler.processRequest(ioTSetRequest.getFrom(), ioTSetRequest.getSetData());
                    return new IoTSetResponse(ioTSetRequest);
                } catch (XMPPException.XMPPErrorException e10) {
                    return IQ.createErrorResponse((IQ) ioTSetRequest, e10.getStanzaError());
                }
            }
        });
    }

    public static synchronized IoTControlManager getInstanceFor(XMPPConnection xMPPConnection) {
        IoTControlManager ioTControlManager;
        synchronized (IoTControlManager.class) {
            Map<XMPPConnection, IoTControlManager> map = INSTANCES;
            ioTControlManager = map.get(xMPPConnection);
            if (ioTControlManager == null) {
                ioTControlManager = new IoTControlManager(xMPPConnection);
                map.put(xMPPConnection, ioTControlManager);
            }
        }
        return ioTControlManager;
    }

    public void installThing(Thing thing) {
        this.things.put(thing.getNodeInfo(), thing);
    }

    public IoTSetResponse setUsingIq(FullJid fullJid, SetData setData) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return setUsingIq(fullJid, (Collection<? extends SetData>) Collections.singleton(setData));
    }

    public Thing uninstallThing(Thing thing) {
        return uninstallThing(thing.getNodeInfo());
    }

    public IoTSetResponse setUsingIq(FullJid fullJid, Collection<? extends SetData> collection) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        IoTSetRequest ioTSetRequest = new IoTSetRequest(collection);
        ioTSetRequest.setTo(fullJid);
        return (IoTSetResponse) connection().createStanzaCollectorAndSend(ioTSetRequest).nextResultOrThrow();
    }

    public Thing uninstallThing(NodeInfo nodeInfo) {
        return this.things.remove(nodeInfo);
    }
}

package org.jivesoftware.smackx.iot.discovery;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler;
import org.jivesoftware.smack.iqrequest.IQRequestHandler;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.disco.packet.DiscoverInfo;
import org.jivesoftware.smackx.iot.IoTManager;
import org.jivesoftware.smackx.iot.Thing;
import org.jivesoftware.smackx.iot.control.IoTControlManager;
import org.jivesoftware.smackx.iot.data.IoTDataManager;
import org.jivesoftware.smackx.iot.discovery.element.IoTClaimed;
import org.jivesoftware.smackx.iot.discovery.element.IoTDisown;
import org.jivesoftware.smackx.iot.discovery.element.IoTDisowned;
import org.jivesoftware.smackx.iot.discovery.element.IoTMine;
import org.jivesoftware.smackx.iot.discovery.element.IoTRegister;
import org.jivesoftware.smackx.iot.discovery.element.IoTRemove;
import org.jivesoftware.smackx.iot.discovery.element.IoTRemoved;
import org.jivesoftware.smackx.iot.discovery.element.IoTUnregister;
import org.jivesoftware.smackx.iot.discovery.element.Tag;
import org.jivesoftware.smackx.iot.element.NodeInfo;
import org.jivesoftware.smackx.iot.provisioning.IoTProvisioningManager;
import org.jxmpp.jid.BareJid;
import org.jxmpp.jid.Jid;

public final class IoTDiscoveryManager extends Manager {
    private static final Map<XMPPConnection, IoTDiscoveryManager> INSTANCES = new WeakHashMap();
    /* access modifiers changed from: private */
    public static final Logger LOGGER = Logger.getLogger(IoTDiscoveryManager.class.getName());
    private Jid preconfiguredRegistry;
    private final Map<NodeInfo, ThingState> things = new HashMap();
    private final Set<Jid> usedRegistries = new HashSet();

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() {
            public void connectionCreated(XMPPConnection xMPPConnection) {
                if (IoTManager.isAutoEnableActive()) {
                    IoTDiscoveryManager.getInstanceFor(xMPPConnection);
                }
            }
        });
    }

    private IoTDiscoveryManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        IQ.Type type = IQ.Type.set;
        IQRequestHandler.Mode mode = IQRequestHandler.Mode.sync;
        xMPPConnection.registerIQRequestHandler(new AbstractIqRequestHandler(IoTClaimed.ELEMENT, "urn:xmpp:iot:discovery", type, mode) {
            public IQ handleIQRequest(IQ iq) {
                if (!IoTDiscoveryManager.this.isRegistry(iq.getFrom())) {
                    Logger access$000 = IoTDiscoveryManager.LOGGER;
                    Level level = Level.SEVERE;
                    access$000.log(level, "Received control stanza from non-registry entity: " + iq);
                    return null;
                }
                IoTClaimed ioTClaimed = (IoTClaimed) iq;
                Jid jid = ioTClaimed.getJid();
                IoTDiscoveryManager.this.getStateFor(ioTClaimed.getNodeInfo()).setOwner(jid.i1());
                Logger access$0002 = IoTDiscoveryManager.LOGGER;
                access$0002.info("Our thing got claimed by " + jid + ". " + ioTClaimed);
                try {
                    IoTProvisioningManager.getInstanceFor(IoTDiscoveryManager.this.connection()).sendFriendshipRequest(jid.i1());
                } catch (InterruptedException | SmackException.NotConnectedException e10) {
                    IoTDiscoveryManager.LOGGER.log(Level.WARNING, "Could not friendship owner", e10);
                }
                return IQ.createResultIQ(iq);
            }
        });
        xMPPConnection.registerIQRequestHandler(new AbstractIqRequestHandler("disown", "urn:xmpp:iot:discovery", type, mode) {
            public IQ handleIQRequest(IQ iq) {
                if (!IoTDiscoveryManager.this.isRegistry(iq.getFrom())) {
                    Logger access$000 = IoTDiscoveryManager.LOGGER;
                    Level level = Level.SEVERE;
                    access$000.log(level, "Received control stanza from non-registry entity: " + iq);
                    return null;
                }
                Jid from = iq.getFrom();
                NodeInfo nodeInfo = ((IoTDisowned) iq).getNodeInfo();
                ThingState access$100 = IoTDiscoveryManager.this.getStateFor(nodeInfo);
                if (!from.Y(access$100.getRegistry())) {
                    Logger access$0002 = IoTDiscoveryManager.LOGGER;
                    access$0002.severe("Received <disowned/> for " + nodeInfo + " from " + from + " but this is not the registry " + access$100.getRegistry() + " of the thing.");
                    return null;
                }
                if (access$100.isOwned()) {
                    access$100.setUnowned();
                } else {
                    Logger access$0003 = IoTDiscoveryManager.LOGGER;
                    access$0003.fine("Received <disowned/> for " + nodeInfo + " but thing was not owned.");
                }
                return IQ.createResultIQ(iq);
            }
        });
        xMPPConnection.registerIQRequestHandler(new AbstractIqRequestHandler(IoTRemoved.ELEMENT, "urn:xmpp:iot:discovery", type, IQRequestHandler.Mode.async) {
            public IQ handleIQRequest(IQ iq) {
                if (!IoTDiscoveryManager.this.isRegistry(iq.getFrom())) {
                    Logger access$000 = IoTDiscoveryManager.LOGGER;
                    Level level = Level.SEVERE;
                    access$000.log(level, "Received control stanza from non-registry entity: " + iq);
                    return null;
                }
                IoTRemoved ioTRemoved = (IoTRemoved) iq;
                IoTDiscoveryManager.this.getStateFor(ioTRemoved.getNodeInfo()).setRemoved();
                try {
                    IoTProvisioningManager.getInstanceFor(IoTDiscoveryManager.this.connection()).unfriend(ioTRemoved.getFrom());
                } catch (InterruptedException | SmackException.NotConnectedException e10) {
                    IoTDiscoveryManager.LOGGER.log(Level.SEVERE, "Could not unfriend registry after <removed/>", e10);
                }
                return IQ.createResultIQ(iq);
            }
        });
    }

    public static synchronized IoTDiscoveryManager getInstanceFor(XMPPConnection xMPPConnection) {
        IoTDiscoveryManager ioTDiscoveryManager;
        synchronized (IoTDiscoveryManager.class) {
            Map<XMPPConnection, IoTDiscoveryManager> map = INSTANCES;
            ioTDiscoveryManager = map.get(xMPPConnection);
            if (ioTDiscoveryManager == null) {
                ioTDiscoveryManager = new IoTDiscoveryManager(xMPPConnection);
                map.put(xMPPConnection, ioTDiscoveryManager);
            }
        }
        return ioTDiscoveryManager;
    }

    private void interactWithRegistry(Jid jid) throws SmackException.NotConnectedException, InterruptedException {
        if (this.usedRegistries.add(jid)) {
            IoTProvisioningManager.getInstanceFor(connection()).sendFriendshipRequestIfRequired(jid.i1());
        }
    }

    public IoTClaimed claimThing(Collection<Tag> collection) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return claimThing(collection, true);
    }

    public void disownThing(Jid jid) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        disownThing(jid, NodeInfo.EMPTY);
    }

    public Jid findRegistry() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        Jid jid = this.preconfiguredRegistry;
        if (jid != null) {
            return jid;
        }
        List<DiscoverInfo> findServicesDiscoverInfo = ServiceDiscoveryManager.getInstanceFor(connection()).findServicesDiscoverInfo("urn:xmpp:iot:discovery", true, true);
        if (!findServicesDiscoverInfo.isEmpty()) {
            return findServicesDiscoverInfo.get(0).getFrom();
        }
        return null;
    }

    public ThingState getStateFor(Thing thing) {
        return this.things.get(thing.getNodeInfo());
    }

    public boolean isRegistry(BareJid bareJid) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        Objects.requireNonNull(bareJid, "JID argument must not be null");
        if (!bareJid.Y(findRegistry()) && !this.usedRegistries.contains(bareJid)) {
            return false;
        }
        return true;
    }

    public ThingState registerThing(Thing thing) throws SmackException.NotConnectedException, InterruptedException, SmackException.NoResponseException, XMPPException.XMPPErrorException, IoTClaimedException {
        return registerThing(findRegistry(), thing);
    }

    public void removeThing(BareJid bareJid) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        removeThing(bareJid, NodeInfo.EMPTY);
    }

    public void unregister() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        unregister(NodeInfo.EMPTY);
    }

    /* access modifiers changed from: private */
    public ThingState getStateFor(NodeInfo nodeInfo) {
        ThingState thingState = this.things.get(nodeInfo);
        if (thingState != null) {
            return thingState;
        }
        ThingState thingState2 = new ThingState(nodeInfo);
        this.things.put(nodeInfo, thingState2);
        return thingState2;
    }

    public IoTClaimed claimThing(Collection<Tag> collection, boolean z10) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return claimThing(findRegistry(), collection, z10);
    }

    public void disownThing(Jid jid, NodeInfo nodeInfo) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        disownThing(findRegistry(), jid, nodeInfo);
    }

    public void removeThing(BareJid bareJid, NodeInfo nodeInfo) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        removeThing(findRegistry(), bareJid, nodeInfo);
    }

    public void unregister(NodeInfo nodeInfo) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        unregister(findRegistry(), nodeInfo);
    }

    public ThingState registerThing(Jid jid, Thing thing) throws SmackException.NotConnectedException, InterruptedException, SmackException.NoResponseException, XMPPException.XMPPErrorException, IoTClaimedException {
        XMPPConnection connection = connection();
        IoTRegister ioTRegister = new IoTRegister(thing.getMetaTags(), thing.getNodeInfo(), thing.isSelfOwened());
        ioTRegister.setTo(jid);
        IQ iq = (IQ) connection.createStanzaCollectorAndSend(ioTRegister).nextResultOrThrow();
        if (!(iq instanceof IoTClaimed)) {
            ThingState stateFor = getStateFor(thing.getNodeInfo());
            stateFor.setRegistry(jid.i1());
            interactWithRegistry(jid);
            IoTDataManager.getInstanceFor(connection).installThing(thing);
            IoTControlManager.getInstanceFor(connection).installThing(thing);
            return stateFor;
        }
        throw new IoTClaimedException((IoTClaimed) iq);
    }

    public IoTClaimed claimThing(Jid jid, Collection<Tag> collection, boolean z10) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        interactWithRegistry(jid);
        IoTMine ioTMine = new IoTMine(collection, z10);
        ioTMine.setTo(jid);
        IoTClaimed ioTClaimed = (IoTClaimed) connection().createStanzaCollectorAndSend(ioTMine).nextResultOrThrow();
        IoTProvisioningManager.getInstanceFor(connection()).sendFriendshipRequest(ioTClaimed.getJid().i1());
        return ioTClaimed;
    }

    public void disownThing(Jid jid, Jid jid2, NodeInfo nodeInfo) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        interactWithRegistry(jid);
        IoTDisown ioTDisown = new IoTDisown(jid2, nodeInfo);
        ioTDisown.setTo(jid);
        connection().createStanzaCollectorAndSend(ioTDisown).nextResultOrThrow();
    }

    public void removeThing(Jid jid, BareJid bareJid, NodeInfo nodeInfo) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        interactWithRegistry(jid);
        IoTRemove ioTRemove = new IoTRemove(bareJid, nodeInfo);
        ioTRemove.setTo(jid);
        connection().createStanzaCollectorAndSend(ioTRemove).nextResultOrThrow();
    }

    public void unregister(Jid jid, NodeInfo nodeInfo) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        interactWithRegistry(jid);
        IoTUnregister ioTUnregister = new IoTUnregister(nodeInfo);
        ioTUnregister.setTo(jid);
        connection().createStanzaCollectorAndSend(ioTUnregister).nextResultOrThrow();
        getStateFor(nodeInfo).setUnregistered();
        XMPPConnection connection = connection();
        IoTDataManager.getInstanceFor(connection).uninstallThing(nodeInfo);
        IoTControlManager.getInstanceFor(connection).uninstallThing(nodeInfo);
    }

    public boolean isRegistry(Jid jid) {
        try {
            return isRegistry(jid.i1());
        } catch (InterruptedException | SmackException.NoResponseException | SmackException.NotConnectedException | XMPPException.XMPPErrorException e10) {
            Logger logger = LOGGER;
            Level level = Level.WARNING;
            logger.log(level, "Could not determine if " + jid + " is a registry", e10);
            return false;
        }
    }
}

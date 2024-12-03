package org.jivesoftware.smackx.geoloc;

import java.util.Map;
import java.util.WeakHashMap;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.MessageBuilder;
import org.jivesoftware.smackx.geoloc.packet.GeoLocation;
import org.jivesoftware.smackx.geoloc.provider.GeoLocationProvider;
import org.jivesoftware.smackx.pep.PepEventListener;
import org.jivesoftware.smackx.pep.PepManager;
import org.jivesoftware.smackx.pubsub.PayloadItem;
import org.jivesoftware.smackx.pubsub.PubSubException;
import org.jivesoftware.smackx.xdata.provider.FormFieldChildElementProviderManager;
import org.jxmpp.jid.Jid;

public final class GeoLocationManager extends Manager {
    public static final String GEOLOCATION_NODE = "http://jabber.org/protocol/geoloc";
    private static final Map<XMPPConnection, GeoLocationManager> INSTANCES = new WeakHashMap();
    private final PepManager pepManager;

    static {
        FormFieldChildElementProviderManager.addFormFieldChildElementProvider(GeoLocationProvider.GeoLocationFormFieldChildElementProvider.INSTANCE);
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() {
            public void connectionCreated(XMPPConnection xMPPConnection) {
                GeoLocationManager.getInstanceFor(xMPPConnection);
            }
        });
    }

    private GeoLocationManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.pepManager = PepManager.getInstanceFor(xMPPConnection);
    }

    public static synchronized GeoLocationManager getInstanceFor(XMPPConnection xMPPConnection) {
        GeoLocationManager geoLocationManager;
        synchronized (GeoLocationManager.class) {
            Map<XMPPConnection, GeoLocationManager> map = INSTANCES;
            geoLocationManager = map.get(xMPPConnection);
            if (geoLocationManager == null) {
                geoLocationManager = new GeoLocationManager(xMPPConnection);
                map.put(xMPPConnection, geoLocationManager);
            }
        }
        return geoLocationManager;
    }

    public static boolean isGeoLocationMessage(Message message) {
        return GeoLocation.from(message) != null;
    }

    public boolean addGeoLocationListener(PepEventListener<GeoLocation> pepEventListener) {
        return this.pepManager.addPepEventListener("http://jabber.org/protocol/geoloc", GeoLocation.class, pepEventListener);
    }

    public void publishGeoLocation(GeoLocation geoLocation) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException, PubSubException.NotALeafNodeException {
        this.pepManager.publish("http://jabber.org/protocol/geoloc", new PayloadItem(geoLocation));
    }

    public boolean removeGeoLocationListener(PepEventListener<GeoLocation> pepEventListener) {
        return this.pepManager.removePepEventListener(pepEventListener);
    }

    public void sendGeoLocationToJid(GeoLocation geoLocation, Jid jid) throws InterruptedException, SmackException.NotConnectedException {
        XMPPConnection connection = connection();
        connection.sendStanza(((MessageBuilder) ((MessageBuilder) connection.getStanzaFactory().buildMessageStanza().to(jid)).addExtension(geoLocation)).build());
    }

    public void stopPublishingGeolocation() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException, PubSubException.NotALeafNodeException {
        this.pepManager.publish("http://jabber.org/protocol/geoloc", new PayloadItem(GeoLocation.EMPTY_GEO_LOCATION));
    }
}

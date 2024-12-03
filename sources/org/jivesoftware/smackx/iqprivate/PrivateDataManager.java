package org.jivesoftware.smackx.iqprivate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackConfiguration;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.iqprivate.packet.DefaultPrivateData;
import org.jivesoftware.smackx.iqprivate.packet.PrivateData;
import org.jivesoftware.smackx.iqprivate.packet.PrivateDataIQ;
import org.jivesoftware.smackx.iqprivate.provider.PrivateDataProvider;

public final class PrivateDataManager extends Manager {
    private static final PrivateData DUMMY_PRIVATE_DATA = new PrivateData() {
        public String getElementName() {
            return "smackDummyPrivateData";
        }

        public String getNamespace() {
            return SmackConfiguration.SMACK_URL_STRING;
        }

        public CharSequence toXML() {
            return '<' + getElementName() + " xmlns='" + getNamespace() + "'/>";
        }
    };
    private static final Map<XMPPConnection, PrivateDataManager> instances = new WeakHashMap();
    private static final Map<QName, PrivateDataProvider> privateDataProviders = new HashMap();

    public static class PrivateDataIQProvider extends IQProvider<PrivateDataIQ> {
        public PrivateDataIQ parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
            PrivateData privateData = null;
            boolean z10 = false;
            while (!z10) {
                XmlPullParser.Event next = xmlPullParser.next();
                if (next == XmlPullParser.Event.START_ELEMENT) {
                    String name = xmlPullParser.getName();
                    String namespace = xmlPullParser.getNamespace();
                    PrivateDataProvider privateDataProvider = PrivateDataManager.getPrivateDataProvider(name, namespace);
                    if (privateDataProvider != null) {
                        privateData = privateDataProvider.parsePrivateData(xmlPullParser);
                    } else {
                        DefaultPrivateData defaultPrivateData = new DefaultPrivateData(name, namespace);
                        boolean z11 = false;
                        while (!z11) {
                            XmlPullParser.Event next2 = xmlPullParser.next();
                            if (next2 == XmlPullParser.Event.START_ELEMENT) {
                                String name2 = xmlPullParser.getName();
                                XmlPullParser.Event next3 = xmlPullParser.next();
                                if (next3 == XmlPullParser.Event.TEXT_CHARACTERS) {
                                    defaultPrivateData.setValue(name2, xmlPullParser.getText());
                                } else if (next3 == XmlPullParser.Event.END_ELEMENT) {
                                    defaultPrivateData.setValue(name2, "");
                                }
                            } else if (next2 == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getName().equals(name)) {
                                z11 = true;
                            }
                        }
                        privateData = defaultPrivateData;
                    }
                } else if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getName().equals("query")) {
                    z10 = true;
                }
            }
            return new PrivateDataIQ(privateData);
        }
    }

    private PrivateDataManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        instances.put(xMPPConnection, this);
    }

    public static void addPrivateDataProvider(String str, String str2, PrivateDataProvider privateDataProvider) {
        privateDataProviders.put(new QName(str2, str), privateDataProvider);
    }

    public static synchronized PrivateDataManager getInstanceFor(XMPPConnection xMPPConnection) {
        PrivateDataManager privateDataManager;
        synchronized (PrivateDataManager.class) {
            privateDataManager = instances.get(xMPPConnection);
            if (privateDataManager == null) {
                privateDataManager = new PrivateDataManager(xMPPConnection);
            }
        }
        return privateDataManager;
    }

    public static PrivateDataProvider getPrivateDataProvider(String str, String str2) {
        return privateDataProviders.get(new QName(str2, str));
    }

    public static void removePrivateDataProvider(String str, String str2) {
        privateDataProviders.remove(new QName(str2, str));
    }

    public PrivateData getPrivateData(String str, String str2) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return ((PrivateDataIQ) connection().createStanzaCollectorAndSend(new PrivateDataIQ(str, str2)).nextResultOrThrow()).getPrivateData();
    }

    public boolean isSupported() throws SmackException.NoResponseException, SmackException.NotConnectedException, InterruptedException, XMPPException.XMPPErrorException {
        try {
            setPrivateData(DUMMY_PRIVATE_DATA);
            return true;
        } catch (XMPPException.XMPPErrorException e10) {
            if (e10.getStanzaError().getCondition() == StanzaError.Condition.service_unavailable) {
                return false;
            }
            throw e10;
        }
    }

    public void setPrivateData(PrivateData privateData) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        connection().createStanzaCollectorAndSend(new PrivateDataIQ(privateData)).nextResultOrThrow();
    }
}

package org.jivesoftware.smackx.csi.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.csi.packet.ClientStateIndication;

public class ClientStateIndicationFeatureProvider extends ExtensionElementProvider<ClientStateIndication.Feature> {
    public ClientStateIndication.Feature parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        return ClientStateIndication.Feature.INSTANCE;
    }
}

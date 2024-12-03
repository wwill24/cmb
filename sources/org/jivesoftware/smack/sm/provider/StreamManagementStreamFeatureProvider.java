package org.jivesoftware.smack.sm.provider;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smack.xml.XmlPullParser;

public class StreamManagementStreamFeatureProvider extends ExtensionElementProvider<StreamManagement.StreamManagementFeature> {
    public StreamManagement.StreamManagementFeature parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) {
        return StreamManagement.StreamManagementFeature.INSTANCE;
    }
}

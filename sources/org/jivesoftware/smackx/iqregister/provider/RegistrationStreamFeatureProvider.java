package org.jivesoftware.smackx.iqregister.provider;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smackx.iqregister.packet.Registration;

public class RegistrationStreamFeatureProvider extends ExtensionElementProvider<Registration.Feature> {
    public Registration.Feature parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) {
        return Registration.Feature.INSTANCE;
    }
}

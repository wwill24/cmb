package org.jivesoftware.smack.roster.provider;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.roster.packet.RosterVer;
import org.jivesoftware.smack.xml.XmlPullParser;

public class RosterVerStreamFeatureProvider extends ExtensionElementProvider<RosterVer> {
    public RosterVer parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) {
        return RosterVer.INSTANCE;
    }
}

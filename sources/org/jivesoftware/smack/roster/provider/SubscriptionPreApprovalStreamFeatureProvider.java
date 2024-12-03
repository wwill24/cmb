package org.jivesoftware.smack.roster.provider;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.roster.packet.SubscriptionPreApproval;
import org.jivesoftware.smack.xml.XmlPullParser;

public class SubscriptionPreApprovalStreamFeatureProvider extends ExtensionElementProvider<SubscriptionPreApproval> {
    public SubscriptionPreApproval parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) {
        return SubscriptionPreApproval.INSTANCE;
    }
}

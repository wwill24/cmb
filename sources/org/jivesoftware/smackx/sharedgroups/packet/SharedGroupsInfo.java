package org.jivesoftware.smackx.sharedgroups.packet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;

public class SharedGroupsInfo extends IQ {
    public static final String ELEMENT = "sharedgroup";
    public static final String NAMESPACE = "http://www.jivesoftware.org/protocol/sharedgroup";
    private final List<String> groups = new ArrayList();

    public static class Provider extends IQProvider<SharedGroupsInfo> {
        public SharedGroupsInfo parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
            SharedGroupsInfo sharedGroupsInfo = new SharedGroupsInfo();
            boolean z10 = false;
            while (!z10) {
                XmlPullParser.Event next = xmlPullParser.next();
                if (next == XmlPullParser.Event.START_ELEMENT && xmlPullParser.getName().equals("group")) {
                    sharedGroupsInfo.getGroups().add(xmlPullParser.nextText());
                } else if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getName().equals(SharedGroupsInfo.ELEMENT)) {
                    z10 = true;
                }
            }
            return sharedGroupsInfo;
        }
    }

    public SharedGroupsInfo() {
        super(ELEMENT, NAMESPACE);
    }

    public List<String> getGroups() {
        return this.groups;
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        for (String element : this.groups) {
            iQChildElementXmlStringBuilder.element("group", element);
        }
        return iQChildElementXmlStringBuilder;
    }
}

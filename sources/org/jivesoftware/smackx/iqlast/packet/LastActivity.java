package org.jivesoftware.smackx.iqlast.packet;

import java.io.IOException;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jxmpp.jid.Jid;

public class LastActivity extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "jabber:iq:last";
    public long lastActivity;
    public String message;

    public static class Provider extends IQProvider<LastActivity> {
        public LastActivity parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
            LastActivity lastActivity = new LastActivity();
            String attributeValue = xmlPullParser.getAttributeValue("", "seconds");
            if (attributeValue != null) {
                try {
                    lastActivity.setLastActivity(Long.parseLong(attributeValue));
                } catch (NumberFormatException e10) {
                    throw new IOException("Could not parse last activity number", e10);
                }
            }
            lastActivity.setMessage(xmlPullParser.nextText());
            return lastActivity;
        }
    }

    public LastActivity() {
        super("query", NAMESPACE);
        this.lastActivity = -1;
        setType(IQ.Type.get);
    }

    /* access modifiers changed from: private */
    public void setMessage(String str) {
        this.message = str;
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.optLongAttribute("seconds", Long.valueOf(this.lastActivity));
        iQChildElementXmlStringBuilder.setEmptyElement();
        return iQChildElementXmlStringBuilder;
    }

    public long getIdleTime() {
        return this.lastActivity;
    }

    public String getStatusMessage() {
        return this.message;
    }

    public void setLastActivity(long j10) {
        this.lastActivity = j10;
    }

    public LastActivity(Jid jid) {
        this();
        setTo(jid);
    }
}

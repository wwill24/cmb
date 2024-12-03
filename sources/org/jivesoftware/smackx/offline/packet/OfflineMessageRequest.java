package org.jivesoftware.smackx.offline.packet;

import com.google.firebase.remoteconfig.RemoteConfigComponent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.iot.data.element.NodeElement;

public class OfflineMessageRequest extends IQ {
    public static final String ELEMENT = "offline";
    public static final String NAMESPACE = "http://jabber.org/protocol/offline";
    private boolean fetch = false;
    private final List<Item> items = new ArrayList();
    private boolean purge = false;

    public static class Item {
        private String action;
        private String jid;
        private String node;

        public Item(String str) {
            this.node = str;
        }

        public String getAction() {
            return this.action;
        }

        public String getJid() {
            return this.jid;
        }

        public String getNode() {
            return this.node;
        }

        public void setAction(String str) {
            this.action = str;
        }

        public void setJid(String str) {
            this.jid = str;
        }

        public String toXML() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("<item");
            if (getAction() != null) {
                sb2.append(" action=\"");
                sb2.append(getAction());
                sb2.append('\"');
            }
            if (getJid() != null) {
                sb2.append(" jid=\"");
                sb2.append(getJid());
                sb2.append('\"');
            }
            if (getNode() != null) {
                sb2.append(" node=\"");
                sb2.append(getNode());
                sb2.append('\"');
            }
            sb2.append("/>");
            return sb2.toString();
        }
    }

    public static class Provider extends IQProvider<OfflineMessageRequest> {
        private static Item parseItem(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
            Item item = new Item(xmlPullParser.getAttributeValue("", NodeElement.ELEMENT));
            item.setAction(xmlPullParser.getAttributeValue("", "action"));
            item.setJid(xmlPullParser.getAttributeValue("", "jid"));
            boolean z10 = false;
            while (!z10) {
                if (xmlPullParser.next() == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getName().equals("item")) {
                    z10 = true;
                }
            }
            return item;
        }

        public OfflineMessageRequest parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
            OfflineMessageRequest offlineMessageRequest = new OfflineMessageRequest();
            boolean z10 = false;
            while (!z10) {
                XmlPullParser.Event next = xmlPullParser.next();
                if (next == XmlPullParser.Event.START_ELEMENT) {
                    if (xmlPullParser.getName().equals("item")) {
                        offlineMessageRequest.addItem(parseItem(xmlPullParser));
                    } else if (xmlPullParser.getName().equals("purge")) {
                        offlineMessageRequest.setPurge(true);
                    } else if (xmlPullParser.getName().equals(RemoteConfigComponent.FETCH_FILE_NAME)) {
                        offlineMessageRequest.setFetch(true);
                    }
                } else if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getName().equals(OfflineMessageRequest.ELEMENT)) {
                    z10 = true;
                }
            }
            return offlineMessageRequest;
        }
    }

    public OfflineMessageRequest() {
        super(ELEMENT, "http://jabber.org/protocol/offline");
    }

    public void addItem(Item item) {
        synchronized (this.items) {
            this.items.add(item);
        }
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        synchronized (this.items) {
            for (Item xml : this.items) {
                iQChildElementXmlStringBuilder.append((CharSequence) xml.toXML());
            }
        }
        if (this.purge) {
            iQChildElementXmlStringBuilder.append((CharSequence) "<purge/>");
        }
        if (this.fetch) {
            iQChildElementXmlStringBuilder.append((CharSequence) "<fetch/>");
        }
        return iQChildElementXmlStringBuilder;
    }

    public List<Item> getItems() {
        List<Item> unmodifiableList;
        synchronized (this.items) {
            unmodifiableList = Collections.unmodifiableList(new ArrayList(this.items));
        }
        return unmodifiableList;
    }

    public boolean isFetch() {
        return this.fetch;
    }

    public boolean isPurge() {
        return this.purge;
    }

    public void setFetch(boolean z10) {
        this.fetch = z10;
    }

    public void setPurge(boolean z10) {
        this.purge = z10;
    }
}

package org.jivesoftware.smackx.mam.element;

import java.util.List;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.MessageView;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.forward.packet.Forwarded;
import org.jxmpp.jid.Jid;

public class MamElements {
    public static final String NAMESPACE = "urn:xmpp:mam:2";

    public static class AlwaysJidListElement implements Element {
        private final List<Jid> alwaysJids;

        AlwaysJidListElement(List<Jid> list) {
            this.alwaysJids = list;
        }

        public CharSequence toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
            xmlStringBuilder.openElement("always");
            for (Jid element : this.alwaysJids) {
                xmlStringBuilder.element("jid", (CharSequence) element);
            }
            xmlStringBuilder.closeElement("always");
            return xmlStringBuilder;
        }
    }

    public static class MamResultExtension implements ExtensionElement {
        public static final String ELEMENT = "result";
        public static final QName QNAME = new QName("urn:xmpp:mam:2", ELEMENT);
        private final Forwarded<Message> forwarded;

        /* renamed from: id  reason: collision with root package name */
        private final String f24217id;
        private String queryId;

        public MamResultExtension(String str, String str2, Forwarded<Message> forwarded2) {
            if (StringUtils.isEmpty(str2)) {
                throw new IllegalArgumentException("id must not be null or empty");
            } else if (forwarded2 != null) {
                this.f24217id = str2;
                this.forwarded = forwarded2;
                this.queryId = str;
            } else {
                throw new IllegalArgumentException("forwarded must no be null");
            }
        }

        public static MamResultExtension from(MessageView messageView) {
            return (MamResultExtension) messageView.getExtension(MamResultExtension.class);
        }

        public String getElementName() {
            return ELEMENT;
        }

        public Forwarded<Message> getForwarded() {
            return this.forwarded;
        }

        public String getId() {
            return this.f24217id;
        }

        public final String getNamespace() {
            return "urn:xmpp:mam:2";
        }

        public final String getQueryId() {
            return this.queryId;
        }

        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.optAttribute("queryid", getQueryId());
            xmlStringBuilder.optAttribute("id", getId());
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.append((Element) getForwarded());
            xmlStringBuilder.closeElement((NamedElement) this);
            return xmlStringBuilder;
        }
    }

    public static class NeverJidListElement implements Element {
        private List<Jid> neverJids;

        public NeverJidListElement(List<Jid> list) {
            this.neverJids = list;
        }

        public CharSequence toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
            xmlStringBuilder.openElement("never");
            for (Jid element : this.neverJids) {
                xmlStringBuilder.element("jid", (CharSequence) element);
            }
            xmlStringBuilder.closeElement("never");
            return xmlStringBuilder;
        }
    }
}

package org.jivesoftware.smackx.chat_markers.element;

import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.chat_markers.ChatMarkersState;

public class ChatMarkersElements {
    public static final String NAMESPACE = "urn:xmpp:chat-markers:0";

    public static class AcknowledgedExtension extends ChatMarkerExtensionWithId {
        public static final String ELEMENT;
        public static final QName QNAME;

        static {
            String obj = ChatMarkersState.acknowledged.toString();
            ELEMENT = obj;
            QNAME = new QName(ChatMarkersElements.NAMESPACE, obj);
        }

        public AcknowledgedExtension(String str) {
            super(str);
        }

        public static AcknowledgedExtension from(Message message) {
            return (AcknowledgedExtension) message.getExtension(AcknowledgedExtension.class);
        }

        public String getElementName() {
            return ELEMENT;
        }

        public String getNamespace() {
            return ChatMarkersElements.NAMESPACE;
        }
    }

    protected static abstract class ChatMarkerExtensionWithId implements ExtensionElement {

        /* renamed from: id  reason: collision with root package name */
        protected final String f24200id;

        protected ChatMarkerExtensionWithId(String str) {
            this.f24200id = (String) StringUtils.requireNotNullNorEmpty(str, "Message ID must not be null");
        }

        public final String getId() {
            return this.f24200id;
        }

        public final XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
            xmlStringBuilder.attribute("id", this.f24200id);
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }
    }

    public static class DisplayedExtension extends ChatMarkerExtensionWithId {
        public static final String ELEMENT;
        public static final QName QNAME;

        static {
            String obj = ChatMarkersState.displayed.toString();
            ELEMENT = obj;
            QNAME = new QName(ChatMarkersElements.NAMESPACE, obj);
        }

        public DisplayedExtension(String str) {
            super(str);
        }

        public static DisplayedExtension from(Message message) {
            return (DisplayedExtension) message.getExtension(DisplayedExtension.class);
        }

        public String getElementName() {
            return ELEMENT;
        }

        public String getNamespace() {
            return ChatMarkersElements.NAMESPACE;
        }
    }

    public static final class MarkableExtension implements ExtensionElement {
        public static final String ELEMENT;
        public static final MarkableExtension INSTANCE = new MarkableExtension();
        public static final QName QNAME;

        static {
            String obj = ChatMarkersState.markable.toString();
            ELEMENT = obj;
            QNAME = new QName(ChatMarkersElements.NAMESPACE, obj);
        }

        private MarkableExtension() {
        }

        public static MarkableExtension from(Message message) {
            return (MarkableExtension) message.getExtension(MarkableExtension.class);
        }

        public String getElementName() {
            return ELEMENT;
        }

        public String getNamespace() {
            return ChatMarkersElements.NAMESPACE;
        }

        public CharSequence toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }
    }

    public static class ReceivedExtension extends ChatMarkerExtensionWithId {
        public static final String ELEMENT;
        public static final QName QNAME;

        static {
            String obj = ChatMarkersState.received.toString();
            ELEMENT = obj;
            QNAME = new QName(ChatMarkersElements.NAMESPACE, obj);
        }

        public ReceivedExtension(String str) {
            super(str);
        }

        public static ReceivedExtension from(Message message) {
            return (ReceivedExtension) message.getExtension(ReceivedExtension.class);
        }

        public String getElementName() {
            return ELEMENT;
        }

        public String getNamespace() {
            return ChatMarkersElements.NAMESPACE;
        }
    }
}

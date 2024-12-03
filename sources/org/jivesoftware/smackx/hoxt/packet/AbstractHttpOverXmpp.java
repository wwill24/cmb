package org.jivesoftware.smackx.hoxt.packet;

import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.shim.packet.HeadersExtension;

public abstract class AbstractHttpOverXmpp extends IQ {
    public static final String NAMESPACE = "urn:xmpp:http";
    private final Data data;
    private final HeadersExtension headers;
    private final String version;

    public static class Base64 extends HoxExtensionElement {
        public static final String ELEMENT = "base64";
        private final String text;

        public Base64(String str) {
            super();
            this.text = str;
        }

        public String getElementName() {
            return ELEMENT;
        }

        public String getText() {
            return this.text;
        }

        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.optTextChild(this.text, this);
            return xmlStringBuilder;
        }
    }

    public static abstract class Builder<B extends Builder<B, C>, C extends AbstractHttpOverXmpp> {
        /* access modifiers changed from: private */
        public Data data;
        /* access modifiers changed from: private */
        public HeadersExtension headers;
        /* access modifiers changed from: private */
        public String version = "1.1";

        public abstract C build();

        /* access modifiers changed from: protected */
        public abstract B getThis();

        public B setData(Data data2) {
            this.data = data2;
            return getThis();
        }

        public B setHeaders(HeadersExtension headersExtension) {
            this.headers = headersExtension;
            return getThis();
        }

        public B setVersion(String str) {
            this.version = str;
            return getThis();
        }
    }

    public static class ChunkedBase64 extends HoxExtensionElement {
        public static final String ELEMENT = "chunkedBase64";
        private final String streamId;

        public ChunkedBase64(String str) {
            super();
            this.streamId = str;
        }

        public String getElementName() {
            return ELEMENT;
        }

        public String getStreamId() {
            return this.streamId;
        }

        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.attribute(Base64BinaryChunk.ATTRIBUTE_STREAM_ID, this.streamId);
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }
    }

    public static class Data extends HoxExtensionElement {
        public static final String ELEMENT = "data";
        private final NamedElement child;

        public Data(NamedElement namedElement) {
            super();
            this.child = namedElement;
        }

        public NamedElement getChild() {
            return this.child;
        }

        public String getElementName() {
            return "data";
        }

        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.append((Element) this.child);
            xmlStringBuilder.closeElement((NamedElement) this);
            return xmlStringBuilder;
        }
    }

    private static abstract class HoxExtensionElement implements ExtensionElement {
        private HoxExtensionElement() {
        }

        public final String getNamespace() {
            return "urn:xmpp:http";
        }
    }

    public static class Ibb extends HoxExtensionElement {
        public static final String ELEMENT = "ibb";
        private final String sid;

        public Ibb(String str) {
            super();
            this.sid = str;
        }

        public String getElementName() {
            return ELEMENT;
        }

        public String getSid() {
            return this.sid;
        }

        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.attribute("sid", this.sid);
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }
    }

    public static class Text extends HoxExtensionElement {
        public static final String ELEMENT = "text";
        private final String text;

        public Text(String str) {
            super();
            this.text = str;
        }

        public String getElementName() {
            return "text";
        }

        public String getText() {
            return this.text;
        }

        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.optTextChild(this.text, this);
            return xmlStringBuilder;
        }
    }

    public static class Xml extends HoxExtensionElement {
        public static final String ELEMENT = "xml";
        private final String text;

        public Xml(String str) {
            super();
            this.text = str;
        }

        public String getElementName() {
            return ELEMENT;
        }

        public String getText() {
            return this.text;
        }

        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.optTextChild(this.text, this);
            return xmlStringBuilder;
        }
    }

    protected AbstractHttpOverXmpp(String str, Builder<?, ?> builder) {
        super(str, "urn:xmpp:http");
        this.headers = builder.headers;
        this.data = builder.data;
        this.version = (String) Objects.requireNonNull(builder.version, "version must not be null");
    }

    public Data getData() {
        return this.data;
    }

    public HeadersExtension getHeaders() {
        return this.headers;
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        IQ.IQChildElementXmlStringBuilder iQHoxtChildElementBuilder = getIQHoxtChildElementBuilder(iQChildElementXmlStringBuilder);
        iQHoxtChildElementBuilder.optAppend((Element) this.headers);
        iQHoxtChildElementBuilder.optAppend((Element) this.data);
        return iQHoxtChildElementBuilder;
    }

    /* access modifiers changed from: protected */
    public abstract IQ.IQChildElementXmlStringBuilder getIQHoxtChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder);

    public String getVersion() {
        return this.version;
    }
}

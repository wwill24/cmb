package org.jivesoftware.smack.compress.packet;

import java.util.Objects;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.Nonza;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;

public class Failure implements Nonza {
    public static final String ELEMENT = "failure";
    public static final String NAMESPACE = "http://jabber.org/protocol/compress";
    public static final QName QNAME = new QName("http://jabber.org/protocol/compress", "failure");
    private final CompressFailureError compressFailureError;
    private final StanzaError stanzaError;

    public enum CompressFailureError {
        setup_failed,
        processing_failed,
        unsupported_method;
        
        private final String compressFailureError;

        public String toString() {
            return this.compressFailureError;
        }
    }

    public Failure(CompressFailureError compressFailureError2) {
        this(compressFailureError2, (StanzaError) null);
    }

    public CompressFailureError getCompressFailureError() {
        return this.compressFailureError;
    }

    public String getElementName() {
        return "failure";
    }

    public String getNamespace() {
        return "http://jabber.org/protocol/compress";
    }

    public StanzaError getStanzaError() {
        return this.stanzaError;
    }

    public Failure(CompressFailureError compressFailureError2, StanzaError stanzaError2) {
        Objects.requireNonNull(compressFailureError2);
        this.compressFailureError = compressFailureError2;
        this.stanzaError = stanzaError2;
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.emptyElement((Enum<?>) this.compressFailureError);
        xmlStringBuilder.optElement(this.stanzaError);
        xmlStringBuilder.closeElement((NamedElement) this);
        return xmlStringBuilder;
    }
}

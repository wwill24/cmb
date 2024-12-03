package org.jivesoftware.smack.sasl.packet;

import java.util.Map;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.AbstractError;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.Nonza;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.sasl.SASLError;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;

public interface SaslNonza extends Nonza {
    public static final String NAMESPACE = "urn:ietf:params:xml:ns:xmpp-sasl";

    public static class AuthMechanism implements SaslNonza {
        public static final String ELEMENT = "auth";
        public static final QName QNAME = new QName("urn:ietf:params:xml:ns:xmpp-sasl", ELEMENT);
        private final String authenticationText;
        private final String mechanism;

        public AuthMechanism(String str, String str2) {
            this.mechanism = (String) Objects.requireNonNull(str, "SASL mechanism shouldn't be null.");
            this.authenticationText = (String) StringUtils.requireNotNullNorEmpty(str2, "SASL authenticationText must not be null nor empty (RFC6120 6.4.2)");
        }

        public String getAuthenticationText() {
            return this.authenticationText;
        }

        public String getElementName() {
            return ELEMENT;
        }

        public String getMechanism() {
            return this.mechanism;
        }

        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.attribute("mechanism", this.mechanism).rightAngleBracket();
            xmlStringBuilder.escape(this.authenticationText);
            xmlStringBuilder.closeElement((NamedElement) this);
            return xmlStringBuilder;
        }
    }

    public static class Challenge implements SaslNonza {
        public static final String ELEMENT = "challenge";
        public static final QName QNAME = new QName("urn:ietf:params:xml:ns:xmpp-sasl", ELEMENT);
        private final String data;

        public Challenge(String str) {
            this.data = StringUtils.returnIfNotEmptyTrimmed(str);
        }

        public String getData() {
            return this.data;
        }

        public String getElementName() {
            return ELEMENT;
        }

        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.optTextChild(this.data, this);
            return xmlStringBuilder;
        }
    }

    public static class Response implements SaslNonza {
        public static final String ELEMENT = "response";
        public static final QName QNAME = new QName("urn:ietf:params:xml:ns:xmpp-sasl", "response");
        private final String authenticationText;

        public Response() {
            this.authenticationText = null;
        }

        public String getAuthenticationText() {
            return this.authenticationText;
        }

        public String getElementName() {
            return "response";
        }

        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.optTextChild(this.authenticationText, this);
            return xmlStringBuilder;
        }

        public Response(String str) {
            this.authenticationText = StringUtils.returnIfNotEmptyTrimmed(str);
        }
    }

    public static class SASLFailure extends AbstractError implements SaslNonza {
        public static final String ELEMENT = "failure";
        public static final QName QNAME = new QName("urn:ietf:params:xml:ns:xmpp-sasl", "failure");
        private final SASLError saslError;
        private final String saslErrorString;

        public SASLFailure(String str) {
            this(str, (Map<String, String>) null);
        }

        public String getElementName() {
            return "failure";
        }

        public SASLError getSASLError() {
            return this.saslError;
        }

        public String getSASLErrorString() {
            return this.saslErrorString;
        }

        public String toString() {
            return toXML().toString();
        }

        public SASLFailure(String str, Map<String, String> map) {
            super(map);
            SASLError fromString = SASLError.fromString(str);
            if (fromString == null) {
                this.saslError = SASLError.not_authorized;
            } else {
                this.saslError = fromString;
            }
            this.saslErrorString = str;
        }

        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
            xmlStringBuilder.halfOpenElement("failure").xmlnsAttribute("urn:ietf:params:xml:ns:xmpp-sasl").rightAngleBracket();
            xmlStringBuilder.emptyElement(this.saslErrorString);
            addDescriptiveTextsAndExtensions(xmlStringBuilder);
            xmlStringBuilder.closeElement("failure");
            return xmlStringBuilder;
        }
    }

    public static class Success implements SaslNonza {
        public static final String ELEMENT = "success";
        public static final QName QNAME = new QName("urn:ietf:params:xml:ns:xmpp-sasl", "success");
        private final String data;

        public Success(String str) {
            this.data = StringUtils.returnIfNotEmptyTrimmed(str);
        }

        public String getData() {
            return this.data;
        }

        public String getElementName() {
            return "success";
        }

        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.optTextChild(this.data, this);
            return xmlStringBuilder;
        }
    }

    String getNamespace() {
        return "urn:ietf:params:xml:ns:xmpp-sasl";
    }
}

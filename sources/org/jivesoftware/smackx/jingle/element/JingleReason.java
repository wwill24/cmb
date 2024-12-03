package org.jivesoftware.smackx.jingle.element;

import java.util.HashMap;
import java.util.Map;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.FullyQualifiedElement;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;

public class JingleReason implements FullyQualifiedElement {
    public static final JingleReason Busy = new JingleReason(Reason.busy);
    public static final JingleReason Cancel = new JingleReason(Reason.cancel);
    public static final JingleReason ConnectivityError = new JingleReason(Reason.connectivity_error);
    public static final JingleReason Decline = new JingleReason(Reason.decline);
    public static final String ELEMENT = "reason";
    public static final JingleReason Expired = new JingleReason(Reason.expired);
    public static final JingleReason FailedApplication = new JingleReason(Reason.failed_application);
    public static final JingleReason FailedTransport = new JingleReason(Reason.failed_transport);
    public static final JingleReason GeneralError = new JingleReason(Reason.general_error);
    public static final JingleReason Gone = new JingleReason(Reason.gone);
    public static final JingleReason IncompatibleParameters = new JingleReason(Reason.incompatible_parameters);
    public static final JingleReason MediaError = new JingleReason(Reason.media_error);
    public static final String NAMESPACE = "urn:xmpp:jingle:1";
    public static final JingleReason SecurityError = new JingleReason(Reason.security_error);
    public static final JingleReason Success = new JingleReason(Reason.success);
    public static final String TEXT_ELEMENT = "text";
    public static final JingleReason Timeout = new JingleReason(Reason.timeout);
    public static final JingleReason UnsupportedApplications = new JingleReason(Reason.unsupported_applications);
    public static final JingleReason UnsupportedTransports = new JingleReason(Reason.unsupported_transports);
    private final ExtensionElement element;
    protected final Reason reason;
    private final String text;

    public static class AlternativeSession extends JingleReason {
        public static final String SID = "sid";
        private final String sessionId;

        public AlternativeSession(String str) {
            this(str, (String) null, (ExtensionElement) null);
        }

        public String getAlternativeSessionId() {
            return this.sessionId;
        }

        public AlternativeSession(String str, String str2, ExtensionElement extensionElement) {
            super(Reason.alternative_session, str2, extensionElement);
            if (!StringUtils.isNullOrEmpty((CharSequence) str)) {
                this.sessionId = str;
                return;
            }
            throw new NullPointerException("SessionID must not be null or empty.");
        }

        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((NamedElement) this);
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.openElement(this.reason.asString);
            xmlStringBuilder.openElement("sid");
            xmlStringBuilder.append((CharSequence) this.sessionId);
            xmlStringBuilder.closeElement("sid");
            xmlStringBuilder.closeElement(this.reason.asString);
            xmlStringBuilder.closeElement((NamedElement) this);
            return xmlStringBuilder;
        }
    }

    public enum Reason {
        alternative_session,
        busy,
        cancel,
        connectivity_error,
        decline,
        expired,
        failed_application,
        failed_transport,
        general_error,
        gone,
        incompatible_parameters,
        media_error,
        security_error,
        success,
        timeout,
        unsupported_applications,
        unsupported_transports;
        
        protected static final Map<String, Reason> LUT = null;
        protected final String asString;

        static {
            LUT = new HashMap(values().length);
            for (Reason reason : values()) {
                LUT.put(reason.toString(), reason);
            }
        }

        public static Reason fromString(String str) {
            Reason reason = LUT.get(str);
            if (reason != null) {
                return reason;
            }
            throw new IllegalArgumentException("Unknown reason: " + str);
        }

        public String toString() {
            return this.asString;
        }
    }

    public JingleReason(Reason reason2) {
        this(reason2, (String) null, (ExtensionElement) null);
    }

    public static AlternativeSession AlternativeSession(String str) {
        return new AlternativeSession(str);
    }

    public Reason asEnum() {
        return this.reason;
    }

    public ExtensionElement getElement() {
        return this.element;
    }

    public String getElementName() {
        return ELEMENT;
    }

    public String getNamespace() {
        return "urn:xmpp:jingle:1";
    }

    public String getText() {
        return this.text;
    }

    public JingleReason(Reason reason2, String str, ExtensionElement extensionElement) {
        this.reason = reason2;
        this.text = str;
        this.element = extensionElement;
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.emptyElement((Enum<?>) this.reason);
        xmlStringBuilder.optElement("text", this.text);
        xmlStringBuilder.optAppend((Element) this.element);
        xmlStringBuilder.closeElement((NamedElement) this);
        return xmlStringBuilder;
    }
}

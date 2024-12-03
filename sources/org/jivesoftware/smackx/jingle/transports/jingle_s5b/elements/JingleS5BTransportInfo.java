package org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements;

import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.jingle.element.JingleContentTransportInfo;

public abstract class JingleS5BTransportInfo implements JingleContentTransportInfo {
    public static final String NAMESPACE = "urn:xmpp:jingle:transports:s5b:1";

    public static final class CandidateActivated extends JingleS5BCandidateTransportInfo {
        public static final String ELEMENT = "candidate-activated";

        public CandidateActivated(String str) {
            super(str);
        }

        public String getElementName() {
            return ELEMENT;
        }
    }

    public static final class CandidateError extends JingleS5BTransportInfo {
        public static final String ELEMENT = "candidate-error";
        public static final CandidateError INSTANCE = new CandidateError();

        private CandidateError() {
        }

        public boolean equals(Object obj) {
            return obj == INSTANCE;
        }

        public String getElementName() {
            return ELEMENT;
        }

        public int hashCode() {
            return toXML().toString().hashCode();
        }

        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
            xmlStringBuilder.halfOpenElement((NamedElement) this);
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }
    }

    public static final class CandidateUsed extends JingleS5BCandidateTransportInfo {
        public static final String ELEMENT = "candidate-used";

        public CandidateUsed(String str) {
            super(str);
        }

        public String getElementName() {
            return ELEMENT;
        }
    }

    public static abstract class JingleS5BCandidateTransportInfo extends JingleS5BTransportInfo {
        public static final String ATTR_CID = "cid";
        private final String candidateId;

        protected JingleS5BCandidateTransportInfo(String str) {
            this.candidateId = str;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof JingleS5BCandidateTransportInfo)) {
                return false;
            }
            return toXML().toString().equals(((JingleS5BCandidateTransportInfo) obj).toXML().toString());
        }

        public final String getCandidateId() {
            return this.candidateId;
        }

        public final int hashCode() {
            return getCandidateId().toString().hashCode();
        }

        public final XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.attribute("cid", getCandidateId());
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }
    }

    public static final class ProxyError extends JingleS5BTransportInfo {
        public static final String ELEMENT = "proxy-error";
        public static final ProxyError INSTANCE = new ProxyError();

        private ProxyError() {
        }

        public boolean equals(Object obj) {
            return obj == INSTANCE;
        }

        public String getElementName() {
            return ELEMENT;
        }

        public int hashCode() {
            return toXML().toString().hashCode();
        }

        public CharSequence toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
            xmlStringBuilder.halfOpenElement((NamedElement) this);
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }
    }

    public final String getNamespace() {
        return "urn:xmpp:jingle:transports:s5b:1";
    }
}

package org.jivesoftware.smackx.muc.packet;

import java.util.Date;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.last_interaction.element.IdleElement;
import org.jxmpp.util.XmppDateTime;

public class MUCInitialPresence implements ExtensionElement {
    public static final String ELEMENT = "x";
    public static final String NAMESPACE = "http://jabber.org/protocol/muc";
    public static final QName QNAME = new QName("http://jabber.org/protocol/muc", "x");
    private History history;
    private String password;

    public static class History implements NamedElement {
        public static final String ELEMENT = "history";
        private final int maxChars;
        private final int maxStanzas;
        private final int seconds;
        private final Date since;

        public History(int i10, int i11, int i12, Date date) {
            if (i10 >= 0 || i11 >= 0 || i12 >= 0 || date != null) {
                this.maxChars = i10;
                this.maxStanzas = i11;
                this.seconds = i12;
                this.since = date;
                return;
            }
            throw new IllegalArgumentException();
        }

        public String getElementName() {
            return "history";
        }

        public int getMaxChars() {
            return this.maxChars;
        }

        public int getMaxStanzas() {
            return this.maxStanzas;
        }

        public int getSeconds() {
            return this.seconds;
        }

        public Date getSince() {
            return this.since;
        }

        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((NamedElement) this);
            xmlStringBuilder.optIntAttribute("maxchars", getMaxChars());
            xmlStringBuilder.optIntAttribute("maxstanzas", getMaxStanzas());
            xmlStringBuilder.optIntAttribute("seconds", getSeconds());
            if (getSince() != null) {
                xmlStringBuilder.attribute(IdleElement.ATTR_SINCE, XmppDateTime.i(getSince()));
            }
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }
    }

    @Deprecated
    public MUCInitialPresence() {
    }

    public static MUCInitialPresence from(Stanza stanza) {
        return (MUCInitialPresence) stanza.getExtension(MUCInitialPresence.class);
    }

    @Deprecated
    public static MUCInitialPresence getFrom(Stanza stanza) {
        return from(stanza);
    }

    public String getElementName() {
        return "x";
    }

    public History getHistory() {
        return this.history;
    }

    public String getNamespace() {
        return "http://jabber.org/protocol/muc";
    }

    public String getPassword() {
        return this.password;
    }

    @Deprecated
    public void setHistory(History history2) {
        this.history = history2;
    }

    @Deprecated
    public void setPassword(String str) {
        this.password = str;
    }

    public MUCInitialPresence(String str, int i10, int i11, int i12, Date date) {
        this.password = str;
        if (i10 > -1 || i11 > -1 || i12 > -1 || date != null) {
            this.history = new History(i10, i11, i12, date);
        } else {
            this.history = null;
        }
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.optElement("password", getPassword());
        xmlStringBuilder.optElement(getHistory());
        xmlStringBuilder.closeElement((NamedElement) this);
        return xmlStringBuilder;
    }
}

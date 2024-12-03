package org.jivesoftware.smackx.muc.packet;

import java.io.Serializable;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.jingle.element.JingleReason;
import org.jxmpp.jid.EntityBareJid;

public class Destroy implements NamedElement, Serializable {
    public static final String ELEMENT = "destroy";
    private static final long serialVersionUID = 1;
    private final EntityBareJid jid;
    private final String reason;

    public Destroy(Destroy destroy) {
        this(destroy.jid, destroy.reason);
    }

    public String getElementName() {
        return ELEMENT;
    }

    public EntityBareJid getJid() {
        return this.jid;
    }

    public String getReason() {
        return this.reason;
    }

    public Destroy(EntityBareJid entityBareJid, String str) {
        this.jid = entityBareJid;
        this.reason = str;
    }

    public Destroy clone() {
        return new Destroy(this);
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((NamedElement) this);
        xmlStringBuilder.optAttribute("jid", (CharSequence) getJid());
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.optElement(JingleReason.ELEMENT, getReason());
        xmlStringBuilder.closeElement((NamedElement) this);
        return xmlStringBuilder;
    }
}

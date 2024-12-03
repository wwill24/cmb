package org.jivesoftware.smackx.muc.packet;

import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.jingle.element.JingleReason;
import org.jivesoftware.smackx.muc.MUCAffiliation;
import org.jivesoftware.smackx.muc.MUCRole;
import org.jxmpp.jid.Jid;
import org.jxmpp.jid.parts.Resourcepart;

public class MUCItem implements NamedElement {
    public static final String ELEMENT = "item";
    private final Jid actor;
    private final Resourcepart actorNick;
    private final MUCAffiliation affiliation;
    private final Jid jid;
    private final Resourcepart nick;
    private final String reason;
    private final MUCRole role;

    public MUCItem(MUCAffiliation mUCAffiliation) {
        this(mUCAffiliation, (MUCRole) null, (Jid) null, (String) null, (Jid) null, (Resourcepart) null, (Resourcepart) null);
    }

    public Jid getActor() {
        return this.actor;
    }

    public Resourcepart getActorNick() {
        return this.actorNick;
    }

    public MUCAffiliation getAffiliation() {
        return this.affiliation;
    }

    public String getElementName() {
        return "item";
    }

    public Jid getJid() {
        return this.jid;
    }

    public Resourcepart getNick() {
        return this.nick;
    }

    public String getReason() {
        return this.reason;
    }

    public MUCRole getRole() {
        return this.role;
    }

    public MUCItem(MUCRole mUCRole) {
        this((MUCAffiliation) null, mUCRole, (Jid) null, (String) null, (Jid) null, (Resourcepart) null, (Resourcepart) null);
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((NamedElement) this);
        xmlStringBuilder.optAttribute("affiliation", (Enum<?>) getAffiliation());
        xmlStringBuilder.optAttribute("jid", (CharSequence) getJid());
        xmlStringBuilder.optAttribute("nick", (CharSequence) getNick());
        xmlStringBuilder.optAttribute("role", (Enum<?>) getRole());
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.optElement(JingleReason.ELEMENT, getReason());
        if (getActor() != null) {
            xmlStringBuilder.halfOpenElement("actor").attribute("jid", (CharSequence) getActor()).closeEmptyElement();
        }
        xmlStringBuilder.closeElement("item");
        return xmlStringBuilder;
    }

    public MUCItem(MUCRole mUCRole, Resourcepart resourcepart) {
        this((MUCAffiliation) null, mUCRole, (Jid) null, (String) null, (Jid) null, resourcepart, (Resourcepart) null);
    }

    public MUCItem(MUCAffiliation mUCAffiliation, Jid jid2, String str) {
        this(mUCAffiliation, (MUCRole) null, (Jid) null, str, jid2, (Resourcepart) null, (Resourcepart) null);
    }

    public MUCItem(MUCAffiliation mUCAffiliation, Jid jid2) {
        this(mUCAffiliation, (MUCRole) null, (Jid) null, (String) null, jid2, (Resourcepart) null, (Resourcepart) null);
    }

    public MUCItem(MUCRole mUCRole, Resourcepart resourcepart, String str) {
        this((MUCAffiliation) null, mUCRole, (Jid) null, str, (Jid) null, resourcepart, (Resourcepart) null);
    }

    public MUCItem(MUCAffiliation mUCAffiliation, MUCRole mUCRole, Jid jid2, String str, Jid jid3, Resourcepart resourcepart, Resourcepart resourcepart2) {
        this.affiliation = mUCAffiliation;
        this.role = mUCRole;
        this.actor = jid2;
        this.reason = str;
        this.jid = jid3;
        this.nick = resourcepart;
        this.actorNick = resourcepart2;
    }
}

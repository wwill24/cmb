package org.jivesoftware.smackx.stanza_content_encryption.element;

import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.EqualsUtil;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jxmpp.jid.Jid;

public abstract class JidAffixElement implements NamedElement, AffixElement {
    public static final String ATTR_JID = "jid";
    private final Jid jid;

    public JidAffixElement(Jid jid2) {
        this.jid = (Jid) Objects.requireNonNull(jid2, "Value of 'jid' MUST NOT be null.");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$equals$0(EqualsUtil.Builder builder, JidAffixElement jidAffixElement) {
        builder.append(getJid(), jidAffixElement.getJid()).append(getElementName(), jidAffixElement.getElementName());
    }

    public final boolean equals(Object obj) {
        return EqualsUtil.equals(this, obj, new a(this));
    }

    public Jid getJid() {
        return this.jid;
    }

    public final int hashCode() {
        return (getElementName() + getJid().toString()).hashCode();
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        return new XmlStringBuilder((NamedElement) this).attribute("jid", (CharSequence) getJid()).closeEmptyElement();
    }
}

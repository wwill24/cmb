package org.jivesoftware.smackx.stanza_content_encryption.element;

import org.jxmpp.jid.Jid;

public class ToAffixElement extends JidAffixElement {
    public static final String ELEMENT = "to";

    public ToAffixElement(Jid jid) {
        super(jid);
    }

    public String getElementName() {
        return "to";
    }
}

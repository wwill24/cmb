package org.jivesoftware.smackx.stanza_content_encryption.element;

import org.jxmpp.jid.Jid;

public class FromAffixElement extends JidAffixElement {
    public static final String ELEMENT = "from";

    public FromAffixElement(Jid jid) {
        super(jid);
    }

    public String getElementName() {
        return "from";
    }
}

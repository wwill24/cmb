package org.jivesoftware.smackx.pep;

import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jxmpp.jid.EntityBareJid;

public interface PepEventListener<E extends ExtensionElement> {
    void onPepEvent(EntityBareJid entityBareJid, E e10, String str, Message message);
}

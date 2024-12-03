package org.jivesoftware.smackx.ox_im;

import cn.k;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.ox.OpenPgpContact;
import org.jivesoftware.smackx.ox.element.SigncryptElement;

public interface OxMessageListener {
    void newIncomingOxMessage(OpenPgpContact openPgpContact, Message message, SigncryptElement signcryptElement, k kVar);
}

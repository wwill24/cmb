package org.jivesoftware.smackx.ox.listener;

import cn.k;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.ox.OpenPgpContact;
import org.jivesoftware.smackx.ox.element.SigncryptElement;

public interface SigncryptElementReceivedListener {
    void signcryptElementReceived(OpenPgpContact openPgpContact, Message message, SigncryptElement signcryptElement, k kVar);
}

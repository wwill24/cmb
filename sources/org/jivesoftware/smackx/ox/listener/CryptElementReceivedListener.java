package org.jivesoftware.smackx.ox.listener;

import cn.k;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.ox.OpenPgpContact;
import org.jivesoftware.smackx.ox.element.CryptElement;

public interface CryptElementReceivedListener {
    void cryptElementReceived(OpenPgpContact openPgpContact, Message message, CryptElement cryptElement, k kVar);
}

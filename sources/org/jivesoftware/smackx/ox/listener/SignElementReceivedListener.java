package org.jivesoftware.smackx.ox.listener;

import cn.k;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.ox.OpenPgpContact;
import org.jivesoftware.smackx.ox.element.SignElement;

public interface SignElementReceivedListener {
    void signElementReceived(OpenPgpContact openPgpContact, Message message, SignElement signElement, k kVar);
}

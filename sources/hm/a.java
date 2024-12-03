package hm;

import cn.k;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.ox.OpenPgpContact;
import org.jivesoftware.smackx.ox.element.SigncryptElement;
import org.jivesoftware.smackx.ox.listener.SigncryptElementReceivedListener;
import org.jivesoftware.smackx.ox_im.OXInstantMessagingManager;

public final /* synthetic */ class a implements SigncryptElementReceivedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OXInstantMessagingManager f23479a;

    public /* synthetic */ a(OXInstantMessagingManager oXInstantMessagingManager) {
        this.f23479a = oXInstantMessagingManager;
    }

    public final void signcryptElementReceived(OpenPgpContact openPgpContact, Message message, SigncryptElement signcryptElement, k kVar) {
        this.f23479a.signcryptElementReceivedListener(openPgpContact, message, signcryptElement, kVar);
    }
}

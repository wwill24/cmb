package org.jivesoftware.smackx.ox;

import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.ox.element.PublicKeysListElement;
import org.jivesoftware.smackx.pep.PepEventListener;
import org.jxmpp.jid.EntityBareJid;

public final /* synthetic */ class a implements PepEventListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OpenPgpManager f24218a;

    public /* synthetic */ a(OpenPgpManager openPgpManager) {
        this.f24218a = openPgpManager;
    }

    public final void onPepEvent(EntityBareJid entityBareJid, ExtensionElement extensionElement, String str, Message message) {
        this.f24218a.lambda$new$0(entityBareJid, (PublicKeysListElement) extensionElement, str, message);
    }
}

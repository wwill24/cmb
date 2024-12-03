package org.jivesoftware.smack.chat2;

import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Presence;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.EntityFullJid;
import org.jxmpp.jid.Jid;

public final class Chat extends Manager {
    private final EntityBareJid jid;
    Presence lastPresenceOfLockedResource;
    volatile EntityFullJid lockedResource;

    /* renamed from: org.jivesoftware.smack.chat2.Chat$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$packet$Message$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                org.jivesoftware.smack.packet.Message$Type[] r0 = org.jivesoftware.smack.packet.Message.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jivesoftware$smack$packet$Message$Type = r0
                org.jivesoftware.smack.packet.Message$Type r1 = org.jivesoftware.smack.packet.Message.Type.normal     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$jivesoftware$smack$packet$Message$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jivesoftware.smack.packet.Message$Type r1 = org.jivesoftware.smack.packet.Message.Type.chat     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.chat2.Chat.AnonymousClass1.<clinit>():void");
        }
    }

    Chat(XMPPConnection xMPPConnection, EntityBareJid entityBareJid) {
        super(xMPPConnection);
        this.jid = entityBareJid;
    }

    public EntityBareJid getXmppAddressOfChatPartner() {
        return this.jid;
    }

    public void send(CharSequence charSequence) throws SmackException.NotConnectedException, InterruptedException {
        send(connection().getStanzaFactory().buildMessageStanza().ofType(Message.Type.chat).setBody(charSequence).build());
    }

    /* access modifiers changed from: package-private */
    public void unlockResource() {
        this.lockedResource = null;
        this.lastPresenceOfLockedResource = null;
    }

    public void send(Message message) throws SmackException.NotConnectedException, InterruptedException {
        int i10 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$packet$Message$Type[message.getType().ordinal()];
        if (i10 == 1 || i10 == 2) {
            Jid jid2 = this.lockedResource;
            if (jid2 == null) {
                jid2 = this.jid;
            }
            message.setTo(jid2);
            connection().sendStanza(message);
            return;
        }
        throw new IllegalArgumentException("Message must be of type 'normal' or 'chat'");
    }
}

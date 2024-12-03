package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class s0 extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final s0 f14837c = new s0();

    private s0() {
        super(50, 51);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("CREATE TABLE IF NOT EXISTS `connection_details` (`profileId` TEXT NOT NULL, `unreadMessageCount` INTEGER NOT NULL, `lastMessageText` TEXT, `lastMessageDate` TEXT, `pairReadReceiptDate` TEXT, `lastSenderProfileId` TEXT, `lastMessageReadTimestamp` TEXT, PRIMARY KEY(`profileId`))");
    }
}

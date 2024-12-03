package org.jivesoftware.smack.roster.packet;

import org.jivesoftware.smack.roster.packet.RosterPacket;
import org.jivesoftware.smack.util.EqualsUtil;

public final /* synthetic */ class a implements EqualsUtil.EqualsComperator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RosterPacket.Item f24140a;

    public /* synthetic */ a(RosterPacket.Item item) {
        this.f24140a = item;
    }

    public final void compare(EqualsUtil.Builder builder, Object obj) {
        this.f24140a.lambda$equals$0(builder, (RosterPacket.Item) obj);
    }
}

package org.jivesoftware.smack.roster;

import org.jivesoftware.smack.util.EqualsUtil;

public final /* synthetic */ class b implements EqualsUtil.EqualsComperator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RosterEntry f24139a;

    public /* synthetic */ b(RosterEntry rosterEntry) {
        this.f24139a = rosterEntry;
    }

    public final void compare(EqualsUtil.Builder builder, Object obj) {
        this.f24139a.lambda$equals$0(builder, (RosterEntry) obj);
    }
}

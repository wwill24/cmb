package org.jivesoftware.smack.roster;

import org.jivesoftware.smack.util.EqualsUtil;

public final /* synthetic */ class a implements EqualsUtil.EqualsComperator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RosterEntry f24138a;

    public /* synthetic */ a(RosterEntry rosterEntry) {
        this.f24138a = rosterEntry;
    }

    public final void compare(EqualsUtil.Builder builder, Object obj) {
        this.f24138a.lambda$equalsDeep$1(builder, (RosterEntry) obj);
    }
}

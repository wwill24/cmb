package org.jivesoftware.smackx.jingle;

import org.jivesoftware.smack.util.EqualsUtil;

public final /* synthetic */ class a implements EqualsUtil.EqualsComperator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ JingleSession f24216a;

    public /* synthetic */ a(JingleSession jingleSession) {
        this.f24216a = jingleSession;
    }

    public final void compare(EqualsUtil.Builder builder, Object obj) {
        this.f24216a.lambda$equals$0(builder, (JingleSession) obj);
    }
}

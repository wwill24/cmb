package org.jivesoftware.smackx.usertune.element;

import org.jivesoftware.smack.util.EqualsUtil;

public final /* synthetic */ class a implements EqualsUtil.EqualsComperator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserTuneElement f24235a;

    public /* synthetic */ a(UserTuneElement userTuneElement) {
        this.f24235a = userTuneElement;
    }

    public final void compare(EqualsUtil.Builder builder, Object obj) {
        this.f24235a.lambda$equals$0(builder, (UserTuneElement) obj);
    }
}

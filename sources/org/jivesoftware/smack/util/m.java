package org.jivesoftware.smack.util;

import org.jivesoftware.smack.util.EqualsUtil;

public final /* synthetic */ class m implements EqualsUtil.EqualsComperator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Pair f24192a;

    public /* synthetic */ m(Pair pair) {
        this.f24192a = pair;
    }

    public final void compare(EqualsUtil.Builder builder, Object obj) {
        this.f24192a.lambda$equals$1(builder, (Pair) obj);
    }
}

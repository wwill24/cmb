package org.jivesoftware.smackx.disco.packet;

import org.jivesoftware.smack.util.EqualsUtil;
import org.jivesoftware.smackx.disco.packet.DiscoverInfo;

public final /* synthetic */ class c implements EqualsUtil.EqualsComperator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DiscoverInfo.Identity f24208a;

    public /* synthetic */ c(DiscoverInfo.Identity identity) {
        this.f24208a = identity;
    }

    public final void compare(EqualsUtil.Builder builder, Object obj) {
        this.f24208a.lambda$equals$0(builder, (DiscoverInfo.Identity) obj);
    }
}

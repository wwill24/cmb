package org.jivesoftware.smackx.disco.packet;

import org.jivesoftware.smack.util.EqualsUtil;
import org.jivesoftware.smackx.disco.packet.DiscoverInfo;

public final /* synthetic */ class a implements EqualsUtil.EqualsComperator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DiscoverInfo.Feature f24206a;

    public /* synthetic */ a(DiscoverInfo.Feature feature) {
        this.f24206a = feature;
    }

    public final void compare(EqualsUtil.Builder builder, Object obj) {
        this.f24206a.lambda$equals$0(builder, (DiscoverInfo.Feature) obj);
    }
}

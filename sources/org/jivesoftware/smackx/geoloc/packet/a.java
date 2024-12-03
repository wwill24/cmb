package org.jivesoftware.smackx.geoloc.packet;

import org.jivesoftware.smack.util.EqualsUtil;

public final /* synthetic */ class a implements EqualsUtil.EqualsComperator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeoLocation f24214a;

    public /* synthetic */ a(GeoLocation geoLocation) {
        this.f24214a = geoLocation;
    }

    public final void compare(EqualsUtil.Builder builder, Object obj) {
        this.f24214a.lambda$equals$1(builder, (GeoLocation) obj);
    }
}

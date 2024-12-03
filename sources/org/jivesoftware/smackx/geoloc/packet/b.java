package org.jivesoftware.smackx.geoloc.packet;

import org.jivesoftware.smack.util.HashCode;

public final /* synthetic */ class b implements HashCode.Calculator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeoLocation f24215a;

    public /* synthetic */ b(GeoLocation geoLocation) {
        this.f24215a = geoLocation;
    }

    public final void calculateHash(HashCode.Builder builder) {
        this.f24215a.lambda$hashCode$0(builder);
    }
}

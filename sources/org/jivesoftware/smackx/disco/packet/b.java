package org.jivesoftware.smackx.disco.packet;

import org.jivesoftware.smack.util.HashCode;
import org.jivesoftware.smackx.disco.packet.DiscoverInfo;

public final /* synthetic */ class b implements HashCode.Calculator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DiscoverInfo.Identity f24207a;

    public /* synthetic */ b(DiscoverInfo.Identity identity) {
        this.f24207a = identity;
    }

    public final void calculateHash(HashCode.Builder builder) {
        this.f24207a.lambda$hashCode$1(builder);
    }
}

package org.jivesoftware.smackx.caps;

import org.jivesoftware.smack.packet.PresenceBuilder;
import org.jivesoftware.smack.util.Consumer;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EntityCapsManager f24199a;

    public /* synthetic */ a(EntityCapsManager entityCapsManager) {
        this.f24199a = entityCapsManager;
    }

    public final void accept(Object obj) {
        this.f24199a.addCapsExtension((PresenceBuilder) obj);
    }
}

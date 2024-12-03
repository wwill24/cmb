package org.jivesoftware.smackx.fallback_indication;

import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.fallback_indication.element.FallbackIndicationElement;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FallbackIndicationManager f24210a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Message f24211b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FallbackIndicationElement f24212c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f24213d;

    public /* synthetic */ b(FallbackIndicationManager fallbackIndicationManager, Message message, FallbackIndicationElement fallbackIndicationElement, String str) {
        this.f24210a = fallbackIndicationManager;
        this.f24211b = message;
        this.f24212c = fallbackIndicationElement;
        this.f24213d = str;
    }

    public final void run() {
        this.f24210a.lambda$fallbackIndicationElementListener$0(this.f24211b, this.f24212c, this.f24213d);
    }
}

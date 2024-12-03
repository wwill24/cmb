package org.jivesoftware.smack.filter;

import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.util.Predicate;

public final /* synthetic */ class a implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StanzaFilter f24115a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Class f24116b;

    public /* synthetic */ a(StanzaFilter stanzaFilter, Class cls) {
        this.f24115a = stanzaFilter;
        this.f24116b = cls;
    }

    public final boolean test(Object obj) {
        return this.f24115a.lambda$asPredicate$0(this.f24116b, (Stanza) obj);
    }
}

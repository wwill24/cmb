package org.jivesoftware.smack.filter;

import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.util.Predicate;

public interface StanzaFilter extends Predicate<Stanza> {
    /* access modifiers changed from: private */
    /* synthetic */ boolean lambda$asPredicate$0(Class cls, Stanza stanza) {
        if (!cls.isAssignableFrom(stanza.getClass())) {
            return false;
        }
        return accept(stanza);
    }

    boolean accept(Stanza stanza);

    <S extends Stanza> Predicate<S> asPredicate(Class<?> cls) {
        return new a(this, cls);
    }

    boolean test(Stanza stanza) {
        return accept(stanza);
    }
}

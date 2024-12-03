package org.jxmpp.jid;

import java.io.Serializable;
import org.jxmpp.jid.parts.Resourcepart;

public interface Jid extends Comparable<Jid>, CharSequence, Serializable {
    EntityFullJid A1();

    boolean B0();

    boolean E();

    Resourcepart F();

    boolean G1();

    FullJid O();

    DomainBareJid R0();

    boolean R1();

    EntityBareJid S();

    boolean W0();

    boolean Y(CharSequence charSequence);

    String c0();

    DomainFullJid d1();

    boolean f0();

    EntityBareJid h1();

    EntityFullJid i0();

    BareJid i1();

    boolean j1();

    EntityJid m0();

    EntityFullJid m1();

    boolean t0();

    String toString();

    Resourcepart u();
}

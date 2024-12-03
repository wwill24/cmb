package org.jxmpp.jid.impl;

import org.jxmpp.a;
import org.jxmpp.jid.BareJid;
import org.jxmpp.jid.DomainBareJid;
import org.jxmpp.jid.DomainFullJid;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.EntityFullJid;
import org.jxmpp.jid.EntityJid;
import org.jxmpp.jid.FullJid;
import org.jxmpp.jid.parts.Localpart;
import org.jxmpp.jid.parts.Resourcepart;
import org.jxmpp.stringprep.XmppStringprepException;

public final class LocalAndDomainpartJid extends AbstractJid implements EntityBareJid {
    private static final long serialVersionUID = 1;
    private final DomainBareJid domainBareJid;
    private final Localpart localpart;

    LocalAndDomainpartJid(String str, String str2, a aVar) throws XmppStringprepException {
        this.domainBareJid = new DomainpartJid(str2, aVar);
        this.localpart = Localpart.b(str, aVar);
    }

    public EntityBareJid E0() {
        return this;
    }

    public boolean G1() {
        return true;
    }

    public FullJid O() {
        return null;
    }

    public DomainBareJid R0() {
        return this.domainBareJid;
    }

    public Localpart c1() {
        return this.localpart;
    }

    public DomainFullJid d1() {
        return null;
    }

    public EntityBareJid h1() {
        return this;
    }

    public BareJid i1() {
        return this;
    }

    public EntityJid m0() {
        return this;
    }

    public EntityFullJid m1() {
        return null;
    }

    public String toString() {
        String str = this.cache;
        if (str != null) {
            return str;
        }
        String str2 = c1().toString() + '@' + this.domainBareJid.toString();
        this.cache = str2;
        return str2;
    }

    public Resourcepart u() {
        return null;
    }
}

package org.jxmpp.jid.impl;

import org.jxmpp.a;
import org.jxmpp.jid.BareJid;
import org.jxmpp.jid.DomainBareJid;
import org.jxmpp.jid.DomainFullJid;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.EntityFullJid;
import org.jxmpp.jid.EntityJid;
import org.jxmpp.jid.FullJid;
import org.jxmpp.jid.parts.Resourcepart;
import org.jxmpp.stringprep.XmppStringprepException;

public final class DomainAndResourcepartJid extends AbstractJid implements DomainFullJid {
    private static final long serialVersionUID = 1;
    private final DomainBareJid domainBareJid;
    private final Resourcepart resource;

    DomainAndResourcepartJid(String str, String str2, a aVar) throws XmppStringprepException {
        this(new DomainpartJid(str, aVar), Resourcepart.c(str2, aVar));
    }

    public boolean G1() {
        return false;
    }

    public FullJid O() {
        return this;
    }

    public DomainBareJid R0() {
        return this.domainBareJid;
    }

    public DomainFullJid d1() {
        return this;
    }

    public EntityBareJid h1() {
        return null;
    }

    public BareJid i1() {
        return R0();
    }

    public EntityJid m0() {
        return null;
    }

    public EntityFullJid m1() {
        return null;
    }

    public Resourcepart q0() {
        return this.resource;
    }

    public String toString() {
        String str = this.cache;
        if (str != null) {
            return str;
        }
        String str2 = this.domainBareJid.toString() + '/' + this.resource;
        this.cache = str2;
        return str2;
    }

    public Resourcepart u() {
        return q0();
    }

    DomainAndResourcepartJid(DomainBareJid domainBareJid2, Resourcepart resourcepart) {
        this.domainBareJid = (DomainBareJid) AbstractJid.c(domainBareJid2, "The DomainBareJid must not be null");
        this.resource = (Resourcepart) AbstractJid.c(resourcepart, "The Resource must not be null");
    }
}

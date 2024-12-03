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

public final class LocalDomainAndResourcepartJid extends AbstractJid implements EntityFullJid {
    private static final long serialVersionUID = 1;
    private final EntityBareJid bareJid;
    private final Resourcepart resource;
    private String unescapedCache;

    LocalDomainAndResourcepartJid(String str, String str2, String str3, a aVar) throws XmppStringprepException {
        this(new LocalAndDomainpartJid(str, str2, aVar), Resourcepart.c(str3, aVar));
    }

    public EntityBareJid E0() {
        return this.bareJid;
    }

    public boolean G1() {
        return false;
    }

    public FullJid O() {
        return this;
    }

    public DomainBareJid R0() {
        return this.bareJid.R0();
    }

    public Localpart c1() {
        return this.bareJid.c1();
    }

    public DomainFullJid d1() {
        return null;
    }

    public EntityBareJid h1() {
        return E0();
    }

    public BareJid i1() {
        return E0();
    }

    public EntityJid m0() {
        return this;
    }

    public EntityFullJid m1() {
        return this;
    }

    public Resourcepart q0() {
        return this.resource;
    }

    public String toString() {
        String str = this.cache;
        if (str != null) {
            return str;
        }
        String str2 = this.bareJid.toString() + '/' + this.resource;
        this.cache = str2;
        return str2;
    }

    public Resourcepart u() {
        return q0();
    }

    LocalDomainAndResourcepartJid(EntityBareJid entityBareJid, Resourcepart resourcepart) {
        this.bareJid = (EntityBareJid) AbstractJid.c(entityBareJid, "The EntityBareJid must not be null");
        this.resource = (Resourcepart) AbstractJid.c(resourcepart, "The Resourcepart must not be null");
    }
}

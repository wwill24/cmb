package org.jxmpp.jid.impl;

import org.jxmpp.a;
import org.jxmpp.jid.BareJid;
import org.jxmpp.jid.DomainBareJid;
import org.jxmpp.jid.DomainFullJid;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.EntityFullJid;
import org.jxmpp.jid.EntityJid;
import org.jxmpp.jid.FullJid;
import org.jxmpp.jid.parts.Domainpart;
import org.jxmpp.jid.parts.Resourcepart;
import org.jxmpp.stringprep.XmppStringprepException;

public final class DomainpartJid extends AbstractJid implements DomainBareJid {
    private static final long serialVersionUID = 1;
    protected final Domainpart domain;

    DomainpartJid(String str, a aVar) throws XmppStringprepException {
        this(Domainpart.b(str, aVar));
    }

    public boolean G1() {
        return true;
    }

    public FullJid O() {
        return null;
    }

    public DomainBareJid R0() {
        return this;
    }

    public DomainFullJid d1() {
        return null;
    }

    public EntityBareJid h1() {
        return null;
    }

    public BareJid i1() {
        return this;
    }

    public EntityJid m0() {
        return null;
    }

    public EntityFullJid m1() {
        return null;
    }

    public String toString() {
        String str = this.cache;
        if (str != null) {
            return str;
        }
        String part = this.domain.toString();
        this.cache = part;
        return part;
    }

    public Resourcepart u() {
        return null;
    }

    DomainpartJid(Domainpart domainpart) {
        this.domain = (Domainpart) AbstractJid.c(domainpart, "The Domainpart must not be null");
    }
}

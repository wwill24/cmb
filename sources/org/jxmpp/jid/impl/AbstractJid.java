package org.jxmpp.jid.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.jxmpp.jid.DomainBareJid;
import org.jxmpp.jid.DomainFullJid;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.EntityFullJid;
import org.jxmpp.jid.EntityJid;
import org.jxmpp.jid.FullJid;
import org.jxmpp.jid.Jid;
import org.jxmpp.jid.parts.Resourcepart;

public abstract class AbstractJid implements Jid {
    private static final long serialVersionUID = 1;

    /* renamed from: a  reason: collision with root package name */
    private transient String f24264a;
    protected String cache;

    static <O> O c(O o10, String str) {
        if (o10 != null) {
            return o10;
        }
        throw new IllegalArgumentException(str);
    }

    private void d(String str) {
        throw new IllegalStateException("The JID '" + this + "' " + str);
    }

    public EntityFullJid A1() {
        EntityFullJid m12 = m1();
        if (m12 == null) {
            d("can not be converted to EntityBareJid");
        }
        return m12;
    }

    public final boolean B0() {
        return this instanceof EntityFullJid;
    }

    public final boolean E() {
        return this instanceof EntityJid;
    }

    public final Resourcepart F() {
        Resourcepart u10 = u();
        if (u10 == null) {
            d("has no resourcepart");
        }
        return u10;
    }

    public final boolean R1() {
        return this instanceof FullJid;
    }

    public final EntityBareJid S() {
        EntityBareJid h12 = h1();
        if (h12 == null) {
            d("can not be converted to EntityBareJid");
        }
        return h12;
    }

    public final boolean W0() {
        return t0() || B0();
    }

    public final boolean Y(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        return b(charSequence.toString());
    }

    /* renamed from: a */
    public final int compareTo(Jid jid) {
        return toString().compareTo(jid.toString());
    }

    public final boolean b(String str) {
        return toString().equals(str);
    }

    public final String c0() {
        if (this.f24264a == null) {
            try {
                this.f24264a = URLEncoder.encode(toString(), "UTF-8");
            } catch (UnsupportedEncodingException e10) {
                throw new AssertionError(e10);
            }
        }
        return this.f24264a;
    }

    public char charAt(int i10) {
        return toString().charAt(i10);
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof CharSequence) {
            return Y((CharSequence) obj);
        }
        return false;
    }

    public final boolean f0() {
        return this instanceof DomainBareJid;
    }

    public final int hashCode() {
        return toString().hashCode();
    }

    public EntityFullJid i0() {
        EntityFullJid m12 = m1();
        if (m12 == null) {
            d("can not be converted to EntityFullJid");
        }
        return m12;
    }

    public final boolean j1() {
        return this instanceof DomainFullJid;
    }

    public int length() {
        return toString().length();
    }

    public CharSequence subSequence(int i10, int i11) {
        return toString().subSequence(i10, i11);
    }

    public final boolean t0() {
        return this instanceof EntityBareJid;
    }

    public abstract Resourcepart u();
}

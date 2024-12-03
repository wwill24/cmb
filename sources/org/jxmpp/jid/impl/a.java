package org.jxmpp.jid.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import lm.c;
import org.jxmpp.jid.BareJid;
import org.jxmpp.jid.DomainBareJid;
import org.jxmpp.jid.DomainFullJid;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.EntityFullJid;
import org.jxmpp.jid.EntityJid;
import org.jxmpp.jid.FullJid;
import org.jxmpp.jid.Jid;
import org.jxmpp.jid.parts.Resourcepart;
import org.jxmpp.stringprep.XmppStringprepException;
import org.jxmpp.util.cache.LruCache;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final mm.a<String, Jid> f24265a = new LruCache(100);

    /* renamed from: b  reason: collision with root package name */
    private static final mm.a<String, BareJid> f24266b = new LruCache(100);

    /* renamed from: c  reason: collision with root package name */
    private static final mm.a<String, EntityJid> f24267c = new LruCache(100);

    /* renamed from: d  reason: collision with root package name */
    private static final mm.a<String, FullJid> f24268d = new LruCache(100);

    /* renamed from: e  reason: collision with root package name */
    private static final mm.a<String, EntityBareJid> f24269e = new LruCache(100);

    /* renamed from: f  reason: collision with root package name */
    private static final mm.a<String, EntityFullJid> f24270f = new LruCache(100);

    /* renamed from: g  reason: collision with root package name */
    private static final mm.a<String, DomainBareJid> f24271g = new LruCache(100);

    /* renamed from: h  reason: collision with root package name */
    private static final mm.a<String, DomainFullJid> f24272h = new LruCache(100);

    public static BareJid a(CharSequence charSequence) throws XmppStringprepException {
        return b(charSequence.toString());
    }

    public static BareJid b(String str) throws XmppStringprepException {
        return c(str, org.jxmpp.a.b());
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0033  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.jxmpp.jid.BareJid c(java.lang.String r3, org.jxmpp.a r4) throws org.jxmpp.stringprep.XmppStringprepException {
        /*
            boolean r0 = r4.c()
            if (r0 == 0) goto L_0x0011
            mm.a<java.lang.String, org.jxmpp.jid.BareJid> r0 = f24266b
            java.lang.Object r0 = r0.a(r3)
            org.jxmpp.jid.BareJid r0 = (org.jxmpp.jid.BareJid) r0
            if (r0 == 0) goto L_0x0011
            return r0
        L_0x0011:
            java.lang.String r0 = lm.c.f(r3)
            java.lang.String r1 = lm.c.e(r3)
            if (r0 == 0) goto L_0x0028
            int r2 = r0.length()     // Catch:{ XmppStringprepException -> 0x0039 }
            if (r2 != 0) goto L_0x0022
            goto L_0x0028
        L_0x0022:
            org.jxmpp.jid.impl.LocalAndDomainpartJid r2 = new org.jxmpp.jid.impl.LocalAndDomainpartJid     // Catch:{ XmppStringprepException -> 0x0039 }
            r2.<init>(r0, r1, r4)     // Catch:{ XmppStringprepException -> 0x0039 }
            goto L_0x002d
        L_0x0028:
            org.jxmpp.jid.impl.DomainpartJid r2 = new org.jxmpp.jid.impl.DomainpartJid     // Catch:{ XmppStringprepException -> 0x0039 }
            r2.<init>(r1, r4)     // Catch:{ XmppStringprepException -> 0x0039 }
        L_0x002d:
            boolean r4 = r4.c()
            if (r4 == 0) goto L_0x0038
            mm.a<java.lang.String, org.jxmpp.jid.BareJid> r4 = f24266b
            r4.put(r3, r2)
        L_0x0038:
            return r2
        L_0x0039:
            r4 = move-exception
            org.jxmpp.stringprep.XmppStringprepException r0 = new org.jxmpp.stringprep.XmppStringprepException
            r0.<init>((java.lang.String) r3, (java.lang.Exception) r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jxmpp.jid.impl.a.c(java.lang.String, org.jxmpp.a):org.jxmpp.jid.BareJid");
    }

    public static BareJid d(CharSequence charSequence) throws XmppStringprepException {
        return b(s(charSequence.toString()));
    }

    public static DomainBareJid e(String str) throws XmppStringprepException {
        return f(str, org.jxmpp.a.b());
    }

    public static DomainBareJid f(String str, org.jxmpp.a aVar) throws XmppStringprepException {
        DomainBareJid a10;
        if (aVar.c() && (a10 = f24271g.a(str)) != null) {
            return a10;
        }
        try {
            DomainpartJid domainpartJid = new DomainpartJid(c.e(str), aVar);
            if (aVar.c()) {
                f24271g.put(str, domainpartJid);
            }
            return domainpartJid;
        } catch (XmppStringprepException e10) {
            throw new XmppStringprepException(str, (Exception) e10);
        }
    }

    public static EntityBareJid g(CharSequence charSequence) throws XmppStringprepException {
        return h(charSequence.toString());
    }

    public static EntityBareJid h(String str) throws XmppStringprepException {
        return i(str, org.jxmpp.a.b());
    }

    public static EntityBareJid i(String str, org.jxmpp.a aVar) throws XmppStringprepException {
        EntityBareJid a10;
        if (aVar.c() && (a10 = f24269e.a(str)) != null) {
            return a10;
        }
        try {
            LocalAndDomainpartJid localAndDomainpartJid = new LocalAndDomainpartJid(c.f(str), c.e(str), aVar);
            if (aVar.c()) {
                f24269e.put(str, localAndDomainpartJid);
            }
            return localAndDomainpartJid;
        } catch (XmppStringprepException e10) {
            throw new XmppStringprepException(str, (Exception) e10);
        }
    }

    public static EntityFullJid j(String str) throws XmppStringprepException {
        mm.a<String, EntityFullJid> aVar = f24270f;
        EntityFullJid a10 = aVar.a(str);
        if (a10 != null) {
            return a10;
        }
        try {
            EntityFullJid k10 = k(c.f(str), c.e(str), c.g(str));
            aVar.put(str, k10);
            return k10;
        } catch (XmppStringprepException e10) {
            throw new XmppStringprepException(str, (Exception) e10);
        }
    }

    public static EntityFullJid k(String str, String str2, String str3) throws XmppStringprepException {
        return l(str, str2, str3, org.jxmpp.a.b());
    }

    public static EntityFullJid l(String str, String str2, String str3, org.jxmpp.a aVar) throws XmppStringprepException {
        try {
            return new LocalDomainAndResourcepartJid(str, str2, str3, aVar);
        } catch (XmppStringprepException e10) {
            throw new XmppStringprepException(str + '@' + str2 + '/' + str3, (Exception) e10);
        }
    }

    public static EntityFullJid m(EntityBareJid entityBareJid, Resourcepart resourcepart) {
        return new LocalDomainAndResourcepartJid(entityBareJid, resourcepart);
    }

    public static Jid n(CharSequence charSequence) throws XmppStringprepException {
        return o(charSequence.toString());
    }

    public static Jid o(String str) throws XmppStringprepException {
        return q(str, org.jxmpp.a.b());
    }

    public static Jid p(String str, String str2, String str3, org.jxmpp.a aVar) throws XmppStringprepException {
        Jid a10;
        if (!str2.isEmpty()) {
            String c10 = c.c(str, str2, str3);
            if (aVar.c() && (a10 = f24265a.a(c10)) != null) {
                return a10;
            }
            Jid jid = null;
            if (str != null && str3 != null) {
                jid = new LocalDomainAndResourcepartJid(str, str2, str3, aVar);
            } else if (str != null && str3 == null) {
                jid = new LocalAndDomainpartJid(str, str2, aVar);
            } else if (str == null && str3 == null) {
                jid = new DomainpartJid(str2, aVar);
            } else if (str == null && str3 != null) {
                jid = new DomainAndResourcepartJid(str2, str3, aVar);
            }
            if (aVar.c()) {
                f24265a.put(c10, jid);
            }
            return jid;
        }
        throw XmppStringprepException.MissingDomainpart.a(str, str3);
    }

    public static Jid q(String str, org.jxmpp.a aVar) throws XmppStringprepException {
        try {
            return p(c.f(str), c.e(str), c.g(str), aVar);
        } catch (XmppStringprepException e10) {
            throw new XmppStringprepException(str, (Exception) e10);
        }
    }

    public static FullJid r(BareJid bareJid, Resourcepart resourcepart) {
        if (bareJid.t0()) {
            return new LocalDomainAndResourcepartJid((EntityBareJid) bareJid, resourcepart);
        }
        return new DomainAndResourcepartJid((DomainBareJid) bareJid, resourcepart);
    }

    private static String s(CharSequence charSequence) {
        try {
            return URLDecoder.decode(charSequence.toString(), "UTF-8");
        } catch (UnsupportedEncodingException e10) {
            throw new AssertionError(e10);
        }
    }
}

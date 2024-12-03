package jm;

import org.jxmpp.XmppAddressParttype;
import org.jxmpp.stringprep.XmppStringprepException;
import org.jxmpp.util.cache.LruCache;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final mm.a<String, String> f23597a = new LruCache(100);

    /* renamed from: b  reason: collision with root package name */
    private static final mm.a<String, String> f23598b = new LruCache(100);

    /* renamed from: c  reason: collision with root package name */
    private static final mm.a<String, String> f23599c = new LruCache(100);

    static {
        km.a.f();
    }

    public static String a(String str, org.jxmpp.a aVar) throws XmppStringprepException {
        String a10;
        d(str, XmppAddressParttype.domainpart);
        if (aVar.c() && (a10 = f23598b.a(str)) != null) {
            return a10;
        }
        String c10 = aVar.f24261b.c(str);
        if (aVar.c()) {
            f23598b.put(str, c10);
        }
        return c10;
    }

    public static String b(String str, org.jxmpp.a aVar) throws XmppStringprepException {
        String a10;
        d(str, XmppAddressParttype.localpart);
        if (aVar.c() && (a10 = f23597a.a(str)) != null) {
            return a10;
        }
        String a11 = aVar.f24261b.a(str);
        if (aVar.c()) {
            f23597a.put(str, a11);
        }
        return a11;
    }

    public static String c(String str, org.jxmpp.a aVar) throws XmppStringprepException {
        String a10;
        d(str, XmppAddressParttype.resourcepart);
        if (aVar.c() && (a10 = f23599c.a(str)) != null) {
            return a10;
        }
        String b10 = aVar.f24261b.b(str);
        if (aVar.c()) {
            f23599c.put(str, b10);
        }
        return b10;
    }

    private static void d(String str, XmppAddressParttype xmppAddressParttype) throws XmppStringprepException {
        if (str == null) {
            throw new XmppStringprepException(str, xmppAddressParttype + " can't be null");
        } else if (str.isEmpty()) {
            throw new XmppStringprepException(str, xmppAddressParttype + " can't be the empty string");
        }
    }
}

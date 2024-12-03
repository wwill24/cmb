package im;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.Jid;
import org.jxmpp.stringprep.XmppStringprepException;

public class a {
    public static boolean a(Jid jid, Jid jid2) {
        return jid != null ? jid.Y(jid2) : jid2 == null;
    }

    public static void b(Collection<? extends Jid> collection, Collection<? super EntityBareJid> collection2) {
        for (Jid h12 : collection) {
            EntityBareJid h13 = h12.h1();
            if (h13 != null) {
                collection2.add(h13);
            }
        }
    }

    public static List<EntityBareJid> c(Collection<? extends Jid> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        b(collection, arrayList);
        return arrayList;
    }

    public static Set<Jid> d(Collection<? extends CharSequence> collection) {
        HashSet hashSet = new HashSet(collection.size());
        e(collection, hashSet, (List<XmppStringprepException>) null);
        return hashSet;
    }

    public static void e(Collection<? extends CharSequence> collection, Collection<? super Jid> collection2, List<XmppStringprepException> list) {
        for (CharSequence n10 : collection) {
            try {
                collection2.add(org.jxmpp.jid.impl.a.n(n10));
            } catch (XmppStringprepException e10) {
                if (list != null) {
                    list.add(e10);
                } else {
                    throw new AssertionError(e10);
                }
            }
        }
    }

    public static List<String> f(Collection<? extends Jid> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        g(collection, arrayList);
        return arrayList;
    }

    public static void g(Collection<? extends Jid> collection, Collection<? super String> collection2) {
        for (Jid jid : collection) {
            collection2.add(jid.toString());
        }
    }
}

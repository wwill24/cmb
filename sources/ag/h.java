package ag;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static final CopyOnWriteArrayList<g> f18843a = new CopyOnWriteArrayList<>();

    public static g a(String str) throws GeneralSecurityException {
        Iterator<g> it = f18843a.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (next.a(str)) {
                return next;
            }
        }
        throw new GeneralSecurityException("No KMS client does support: " + str);
    }
}

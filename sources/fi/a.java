package fi;

import vj.e;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile e f23433a;

    public static boolean a(e eVar) {
        if (eVar != null) {
            e eVar2 = f23433a;
            if (eVar2 != null) {
                return eVar2.a();
            }
            try {
                return eVar.a();
            } catch (Exception e10) {
                throw uj.a.a(e10);
            }
        } else {
            throw new NullPointerException("defaultChecker == null");
        }
    }
}

package fg;

import hg.e0;
import java.security.GeneralSecurityException;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f23422a = new b().c();
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public static final e0 f23423b;
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public static final e0 f23424c;
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    public static final e0 f23425d;

    static {
        e0 D = e0.D();
        f23423b = D;
        f23424c = D;
        f23425d = D;
        try {
            a();
        } catch (GeneralSecurityException e10) {
            throw new ExceptionInInitializerError(e10);
        }
    }

    @Deprecated
    public static void a() throws GeneralSecurityException {
        b();
    }

    public static void b() throws GeneralSecurityException {
        b.m(true);
        a.n(true);
        d.e();
    }
}

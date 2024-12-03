package dg;

import hg.e0;
import java.security.GeneralSecurityException;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f23345a = new a().c();
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public static final e0 f23346b = e0.D();
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public static final e0 f23347c = e0.D();

    static {
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
        a.n(true);
        c.e();
    }
}

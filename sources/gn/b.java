package gn;

import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import org.bouncycastle.openpgp.PGPException;

public interface b {

    public interface a {
        fn.a build() throws NoSuchAlgorithmException, PGPException, InvalidAlgorithmParameterException;
    }

    /* renamed from: gn.b$b  reason: collision with other inner class name */
    public interface C0496b {
        a a();

        a b(qn.c cVar);
    }

    public interface c {
        C0496b a(String str);
    }

    c a(c cVar);
}

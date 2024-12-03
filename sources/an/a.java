package an;

import java.io.IOException;
import org.bouncycastle.openpgp.PGPException;
import org.pgpainless.algorithm.CompressionAlgorithm;
import org.pgpainless.algorithm.SymmetricKeyAlgorithm;
import qn.c;

public class a {
    public static cn.a a() {
        return new cn.a();
    }

    public static dn.a b() {
        return new dn.a();
    }

    public static byte[] c(byte[] bArr, c cVar) throws IOException, PGPException {
        return pn.a.b(bArr, cVar);
    }

    public static byte[] d(byte[] bArr, c cVar, SymmetricKeyAlgorithm symmetricKeyAlgorithm) throws IOException, PGPException {
        return pn.a.c(bArr, cVar, symmetricKeyAlgorithm, CompressionAlgorithm.UNCOMPRESSED);
    }

    public static gn.a e() {
        return new gn.a();
    }

    public static in.a f() {
        return new in.a();
    }
}

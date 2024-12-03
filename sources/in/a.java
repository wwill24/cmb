package in;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection;
import org.bouncycastle.openpgp.PGPSecretKeyRing;
import org.bouncycastle.openpgp.PGPSecretKeyRingCollection;
import org.bouncycastle.openpgp.PGPUtil;
import org.bouncycastle.openpgp.operator.bc.BcKeyFingerprintCalculator;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f40986a = Charset.forName("UTF-8");

    public static PGPPublicKeyRingCollection b(InputStream inputStream) throws IOException, PGPException {
        return new PGPPublicKeyRingCollection(PGPUtil.getDecoderStream(inputStream), new BcKeyFingerprintCalculator());
    }

    public static PGPSecretKeyRing c(InputStream inputStream) throws IOException, PGPException {
        return new PGPSecretKeyRing(PGPUtil.getDecoderStream(inputStream), new BcKeyFingerprintCalculator());
    }

    public static PGPSecretKeyRingCollection d(InputStream inputStream) throws IOException, PGPException {
        return new PGPSecretKeyRingCollection(PGPUtil.getDecoderStream(inputStream), new BcKeyFingerprintCalculator());
    }

    public PGPPublicKeyRingCollection a(InputStream inputStream) throws IOException, PGPException {
        return b(inputStream);
    }

    public PGPSecretKeyRing e(InputStream inputStream) throws IOException, PGPException {
        return c(inputStream);
    }

    public PGPSecretKeyRing f(byte[] bArr) throws IOException, PGPException {
        return e(new ByteArrayInputStream(bArr));
    }

    public PGPSecretKeyRingCollection g(InputStream inputStream) throws IOException, PGPException {
        return d(inputStream);
    }
}

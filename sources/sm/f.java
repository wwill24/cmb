package sm;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import org.minidns.dnssec.DnssecValidationFailedException;
import org.minidns.record.q;
import rm.b;

public abstract class f implements b {

    /* renamed from: a  reason: collision with root package name */
    private final KeyFactory f33863a;

    /* renamed from: b  reason: collision with root package name */
    private final String f33864b;

    public f(String str, String str2) throws NoSuchAlgorithmException {
        this.f33863a = KeyFactory.getInstance(str);
        this.f33864b = str2;
        Signature.getInstance(str2);
    }

    public boolean a(byte[] bArr, q qVar, org.minidns.record.f fVar) throws DnssecValidationFailedException {
        try {
            PublicKey c10 = c(fVar);
            Signature instance = Signature.getInstance(this.f33864b);
            instance.initVerify(c10);
            instance.update(bArr);
            return instance.verify(d(qVar));
        } catch (NoSuchAlgorithmException e10) {
            throw new AssertionError(e10);
        } catch (ArithmeticException | InvalidKeyException | SignatureException e11) {
            throw new DnssecValidationFailedException("Validating signature failed", e11);
        }
    }

    public KeyFactory b() {
        return this.f33863a;
    }

    /* access modifiers changed from: protected */
    public abstract PublicKey c(org.minidns.record.f fVar) throws DnssecValidationFailedException.DataMalformedException, DnssecValidationFailedException.DnssecInvalidKeySpecException;

    /* access modifiers changed from: protected */
    public abstract byte[] d(q qVar) throws DnssecValidationFailedException.DataMalformedException;
}

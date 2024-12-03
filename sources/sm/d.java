package sm;

import java.io.DataInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import java.security.spec.InvalidKeySpecException;
import org.minidns.dnssec.DnssecValidationFailedException;
import org.minidns.record.f;
import org.minidns.record.q;

class d extends f {

    /* renamed from: c  reason: collision with root package name */
    private static final ECParameterSpec f33861c = new ECParameterSpec(new EllipticCurve(new ECFieldFp(new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFD97", 16)), new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFD94", 16), new BigInteger("A6", 16)), new ECPoint(BigInteger.ONE, new BigInteger("8D91E471E0989CDA27DF505A453F2B7635294F2DDF23E3B122ACC99C9E9F1E14", 16)), new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF6C611070995AD10045841B09B761B893", 16), 1);

    d() throws NoSuchAlgorithmException {
        super("ECGOST3410", "GOST3411withECGOST3410");
    }

    private static void e(byte[] bArr) {
        for (int i10 = 0; i10 < bArr.length / 2; i10++) {
            int length = (bArr.length - i10) - 1;
            byte b10 = bArr[i10];
            bArr[i10] = bArr[length];
            bArr[length] = b10;
        }
    }

    /* access modifiers changed from: protected */
    public PublicKey c(f fVar) throws DnssecValidationFailedException.DataMalformedException, DnssecValidationFailedException.DnssecInvalidKeySpecException {
        DataInputStream j10 = fVar.j();
        try {
            byte[] bArr = new byte[32];
            j10.readFully(bArr);
            e(bArr);
            BigInteger bigInteger = new BigInteger(1, bArr);
            byte[] bArr2 = new byte[32];
            j10.readFully(bArr2);
            e(bArr2);
            try {
                return b().generatePublic(new ECPublicKeySpec(new ECPoint(bigInteger, new BigInteger(1, bArr2)), f33861c));
            } catch (InvalidKeySpecException e10) {
                throw new DnssecValidationFailedException.DnssecInvalidKeySpecException(e10);
            }
        } catch (IOException e11) {
            throw new DnssecValidationFailedException.DataMalformedException(e11, fVar.i());
        }
    }

    /* access modifiers changed from: protected */
    public byte[] d(q qVar) {
        return qVar.i();
    }
}

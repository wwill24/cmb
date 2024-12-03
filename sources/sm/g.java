package sm;

import java.io.DataInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import org.minidns.dnssec.DnssecValidationFailedException;
import org.minidns.record.f;
import org.minidns.record.q;

class g extends f {
    g(String str) throws NoSuchAlgorithmException {
        super("RSA", str);
    }

    /* access modifiers changed from: protected */
    public PublicKey c(f fVar) throws DnssecValidationFailedException.DataMalformedException, DnssecValidationFailedException.DnssecInvalidKeySpecException {
        int i10;
        DataInputStream j10 = fVar.j();
        try {
            int readUnsignedByte = j10.readUnsignedByte();
            if (readUnsignedByte == 0) {
                i10 = 3;
                readUnsignedByte = j10.readUnsignedShort();
            } else {
                i10 = 1;
            }
            byte[] bArr = new byte[readUnsignedByte];
            j10.readFully(bArr);
            int i11 = i10 + readUnsignedByte;
            BigInteger bigInteger = new BigInteger(1, bArr);
            byte[] bArr2 = new byte[(fVar.k() - i11)];
            j10.readFully(bArr2);
            try {
                return b().generatePublic(new RSAPublicKeySpec(new BigInteger(1, bArr2), bigInteger));
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

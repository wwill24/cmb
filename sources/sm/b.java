package sm;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.DSAPublicKeySpec;
import java.security.spec.InvalidKeySpecException;
import org.minidns.dnssec.DnssecValidationFailedException;
import org.minidns.record.f;
import org.minidns.record.q;

class b extends f {
    b(String str) throws NoSuchAlgorithmException {
        super("DSA", str);
    }

    /* access modifiers changed from: protected */
    public PublicKey c(f fVar) throws DnssecValidationFailedException.DataMalformedException, DnssecValidationFailedException.DnssecInvalidKeySpecException {
        DataInputStream j10 = fVar.j();
        try {
            int readUnsignedByte = j10.readUnsignedByte();
            byte[] bArr = new byte[20];
            j10.readFully(bArr);
            BigInteger bigInteger = new BigInteger(1, bArr);
            int i10 = (readUnsignedByte * 8) + 64;
            byte[] bArr2 = new byte[i10];
            j10.readFully(bArr2);
            BigInteger bigInteger2 = new BigInteger(1, bArr2);
            byte[] bArr3 = new byte[i10];
            j10.readFully(bArr3);
            BigInteger bigInteger3 = new BigInteger(1, bArr3);
            byte[] bArr4 = new byte[i10];
            j10.readFully(bArr4);
            try {
                return b().generatePublic(new DSAPublicKeySpec(new BigInteger(1, bArr4), bigInteger2, bigInteger, bigInteger3));
            } catch (InvalidKeySpecException e10) {
                throw new DnssecValidationFailedException.DnssecInvalidKeySpecException(e10);
            }
        } catch (IOException e11) {
            throw new DnssecValidationFailedException.DataMalformedException(e11, fVar.i());
        }
    }

    /* access modifiers changed from: protected */
    public byte[] d(q qVar) throws DnssecValidationFailedException.DataMalformedException {
        int i10;
        int i11;
        int i12;
        DataInputStream j10 = qVar.j();
        try {
            j10.readByte();
            byte[] bArr = new byte[20];
            j10.readFully(bArr);
            byte b10 = bArr[0];
            int i13 = 21;
            if (b10 == 0) {
                i11 = 0;
                while (i11 < 20 && bArr[i11] == 0) {
                    i11++;
                }
                i10 = 20 - i11;
            } else if (b10 < 0) {
                i11 = 0;
                i10 = 21;
            } else {
                i10 = 20;
                i11 = 0;
            }
            byte[] bArr2 = new byte[20];
            j10.readFully(bArr2);
            byte b11 = bArr2[0];
            if (b11 == 0) {
                i12 = 0;
                while (i12 < 20 && bArr2[i12] == 0) {
                    i12++;
                }
                i13 = 20 - i12;
            } else {
                if (b11 >= 0) {
                    i13 = 20;
                }
                i12 = 0;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeByte(48);
            dataOutputStream.writeByte(i10 + i13 + 4);
            dataOutputStream.writeByte(2);
            dataOutputStream.writeByte(i10);
            if (i10 > 20) {
                dataOutputStream.writeByte(0);
            }
            dataOutputStream.write(bArr, i11, 20 - i11);
            dataOutputStream.writeByte(2);
            dataOutputStream.writeByte(i13);
            if (i13 > 20) {
                dataOutputStream.writeByte(0);
            }
            dataOutputStream.write(bArr2, i12, 20 - i12);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e10) {
            throw new DnssecValidationFailedException.DataMalformedException(e10, qVar.i());
        }
    }
}

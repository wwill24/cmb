package sm;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
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

abstract class c extends f {

    /* renamed from: c  reason: collision with root package name */
    private final ECParameterSpec f33857c;

    /* renamed from: d  reason: collision with root package name */
    private final int f33858d;

    public static class a extends c {

        /* renamed from: e  reason: collision with root package name */
        private static BigInteger[] f33859e = {new BigInteger("FFFFFFFF00000001000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFF", 16), new BigInteger("FFFFFFFF00000001000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFC", 16), new BigInteger("5AC635D8AA3A93E7B3EBBD55769886BC651D06B0CC53B0F63BCE3C3E27D2604B", 16), new BigInteger("6B17D1F2E12C4247F8BCE6E563A440F277037D812DEB33A0F4A13945D898C296", 16), new BigInteger("4FE342E2FE1A7F9B8EE7EB4A7C0F9E162BCE33576B315ECECBB6406837BF51F5", 16), new BigInteger("FFFFFFFF00000000FFFFFFFFFFFFFFFFBCE6FAADA7179E84F3B9CAC2FC632551", 16)};

        a() throws NoSuchAlgorithmException {
            super(f33859e, 32, "SHA256withECDSA");
        }
    }

    public static class b extends c {

        /* renamed from: e  reason: collision with root package name */
        private static BigInteger[] f33860e = {new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFF0000000000000000FFFFFFFF", 16), new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFF0000000000000000FFFFFFFC", 16), new BigInteger("B3312FA7E23EE7E4988E056BE3F82D19181D9C6EFE8141120314088F5013875AC656398D8A2ED19D2A85C8EDD3EC2AEF", 16), new BigInteger("AA87CA22BE8B05378EB1C71EF320AD746E1D3B628BA79B9859F741E082542A385502F25DBF55296C3A545E3872760AB7", 16), new BigInteger("3617DE4A96262C6F5D9E98BF9292DC29F8F41DBD289A147CE9DA3113B5F0B8C00A60B1CE1D7E819D7A431D7C90EA0E5F", 16), new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFC7634D81F4372DDF581A0DB248B0A77AECEC196ACCC52973", 16)};

        b() throws NoSuchAlgorithmException {
            super(f33860e, 48, "SHA384withECDSA");
        }
    }

    c(BigInteger[] bigIntegerArr, int i10, String str) throws NoSuchAlgorithmException {
        this(new ECParameterSpec(new EllipticCurve(new ECFieldFp(bigIntegerArr[0]), bigIntegerArr[1], bigIntegerArr[2]), new ECPoint(bigIntegerArr[3], bigIntegerArr[4]), bigIntegerArr[5], 1), i10, str);
    }

    /* access modifiers changed from: protected */
    public PublicKey c(f fVar) throws DnssecValidationFailedException.DataMalformedException, DnssecValidationFailedException.DnssecInvalidKeySpecException {
        DataInputStream j10 = fVar.j();
        try {
            byte[] bArr = new byte[this.f33858d];
            j10.readFully(bArr);
            BigInteger bigInteger = new BigInteger(1, bArr);
            byte[] bArr2 = new byte[this.f33858d];
            j10.readFully(bArr2);
            try {
                return b().generatePublic(new ECPublicKeySpec(new ECPoint(bigInteger, new BigInteger(1, bArr2)), this.f33857c));
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
        DataInputStream j10 = qVar.j();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            byte[] bArr = new byte[this.f33858d];
            j10.readFully(bArr);
            if (bArr[0] < 0) {
                i10 = this.f33858d + 1;
            } else {
                i10 = this.f33858d;
            }
            byte[] bArr2 = new byte[this.f33858d];
            j10.readFully(bArr2);
            if (bArr2[0] < 0) {
                i11 = this.f33858d + 1;
            } else {
                i11 = this.f33858d;
            }
            dataOutputStream.writeByte(48);
            dataOutputStream.writeByte(i10 + i11 + 4);
            dataOutputStream.writeByte(2);
            dataOutputStream.writeByte(i10);
            if (i10 > this.f33858d) {
                dataOutputStream.writeByte(0);
            }
            dataOutputStream.write(bArr);
            dataOutputStream.writeByte(2);
            dataOutputStream.writeByte(i11);
            if (i11 > this.f33858d) {
                dataOutputStream.writeByte(0);
            }
            dataOutputStream.write(bArr2);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e10) {
            throw new DnssecValidationFailedException.DataMalformedException(e10, qVar.i());
        }
    }

    c(ECParameterSpec eCParameterSpec, int i10, String str) throws NoSuchAlgorithmException {
        super("EC", str);
        this.f33858d = i10;
        this.f33857c = eCParameterSpec;
    }
}

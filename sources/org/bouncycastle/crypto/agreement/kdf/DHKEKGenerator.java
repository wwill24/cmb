package org.bouncycastle.crypto.agreement.kdf;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.util.Pack;

public class DHKEKGenerator implements DerivationFunction {
    private ASN1ObjectIdentifier algorithm;
    private final Digest digest;
    private int keySize;
    private byte[] partyAInfo;

    /* renamed from: z  reason: collision with root package name */
    private byte[] f41367z;

    public DHKEKGenerator(Digest digest2) {
        this.digest = digest2;
    }

    public int generateBytes(byte[] bArr, int i10, int i11) throws DataLengthException, IllegalArgumentException {
        byte[] bArr2 = bArr;
        int i12 = i11;
        int i13 = i10;
        if (bArr2.length - i12 >= i13) {
            long j10 = (long) i12;
            int digestSize = this.digest.getDigestSize();
            if (j10 <= 8589934591L) {
                long j11 = (long) digestSize;
                int i14 = (int) (((j10 + j11) - 1) / j11);
                byte[] bArr3 = new byte[this.digest.getDigestSize()];
                int i15 = 0;
                int i16 = 0;
                int i17 = 1;
                while (i16 < i14) {
                    Digest digest2 = this.digest;
                    byte[] bArr4 = this.f41367z;
                    digest2.update(bArr4, i15, bArr4.length);
                    ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
                    ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
                    aSN1EncodableVector2.add(this.algorithm);
                    aSN1EncodableVector2.add(new DEROctetString(Pack.intToBigEndian(i17)));
                    aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
                    byte[] bArr5 = this.partyAInfo;
                    if (bArr5 != null) {
                        aSN1EncodableVector.add(new DERTaggedObject(true, i15, new DEROctetString(bArr5)));
                    }
                    aSN1EncodableVector.add(new DERTaggedObject(true, 2, new DEROctetString(Pack.intToBigEndian(this.keySize))));
                    try {
                        byte[] encoded = new DERSequence(aSN1EncodableVector).getEncoded(ASN1Encoding.DER);
                        this.digest.update(encoded, 0, encoded.length);
                        this.digest.doFinal(bArr3, 0);
                        if (i12 > digestSize) {
                            System.arraycopy(bArr3, 0, bArr2, i13, digestSize);
                            i13 += digestSize;
                            i12 -= digestSize;
                        } else {
                            System.arraycopy(bArr3, 0, bArr2, i13, i12);
                        }
                        i17++;
                        i16++;
                        i15 = 0;
                    } catch (IOException e10) {
                        throw new IllegalArgumentException("unable to encode parameter info: " + e10.getMessage());
                    }
                }
                this.digest.reset();
                return (int) j10;
            }
            throw new IllegalArgumentException("Output length too large");
        }
        throw new OutputLengthException("output buffer too small");
    }

    public Digest getDigest() {
        return this.digest;
    }

    public void init(DerivationParameters derivationParameters) {
        DHKDFParameters dHKDFParameters = (DHKDFParameters) derivationParameters;
        this.algorithm = dHKDFParameters.getAlgorithm();
        this.keySize = dHKDFParameters.getKeySize();
        this.f41367z = dHKDFParameters.getZ();
        this.partyAInfo = dHKDFParameters.getExtraInfo();
    }
}

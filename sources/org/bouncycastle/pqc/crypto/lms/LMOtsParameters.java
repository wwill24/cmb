package org.bouncycastle.pqc.crypto.lms;

import java.util.HashMap;
import java.util.Map;
import net.bytebuddy.jar.asm.Opcodes;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;

public class LMOtsParameters {
    public static final int reserved = 0;
    public static final LMOtsParameters sha256_n32_w1;
    public static final LMOtsParameters sha256_n32_w2;
    public static final LMOtsParameters sha256_n32_w4;
    public static final LMOtsParameters sha256_n32_w8;
    private static final Map<Object, LMOtsParameters> suppliers = new HashMap<Object, LMOtsParameters>() {
        {
            LMOtsParameters lMOtsParameters = LMOtsParameters.sha256_n32_w1;
            put(Integer.valueOf(lMOtsParameters.type), lMOtsParameters);
            LMOtsParameters lMOtsParameters2 = LMOtsParameters.sha256_n32_w2;
            put(Integer.valueOf(lMOtsParameters2.type), lMOtsParameters2);
            LMOtsParameters lMOtsParameters3 = LMOtsParameters.sha256_n32_w4;
            put(Integer.valueOf(lMOtsParameters3.type), lMOtsParameters3);
            LMOtsParameters lMOtsParameters4 = LMOtsParameters.sha256_n32_w8;
            put(Integer.valueOf(lMOtsParameters4.type), lMOtsParameters4);
        }
    };
    private final ASN1ObjectIdentifier digestOID;
    private final int ls;

    /* renamed from: n  reason: collision with root package name */
    private final int f23993n;

    /* renamed from: p  reason: collision with root package name */
    private final int f23994p;
    private final int sigLen;
    /* access modifiers changed from: private */
    public final int type;

    /* renamed from: w  reason: collision with root package name */
    private final int f23995w;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = NISTObjectIdentifiers.id_sha256;
        sha256_n32_w1 = new LMOtsParameters(1, 32, 1, 265, 7, 8516, aSN1ObjectIdentifier);
        sha256_n32_w2 = new LMOtsParameters(2, 32, 2, Opcodes.I2L, 6, 4292, aSN1ObjectIdentifier);
        sha256_n32_w4 = new LMOtsParameters(3, 32, 4, 67, 4, 2180, aSN1ObjectIdentifier);
        sha256_n32_w8 = new LMOtsParameters(4, 32, 8, 34, 0, 1124, aSN1ObjectIdentifier);
    }

    protected LMOtsParameters(int i10, int i11, int i12, int i13, int i14, int i15, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.type = i10;
        this.f23993n = i11;
        this.f23995w = i12;
        this.f23994p = i13;
        this.ls = i14;
        this.sigLen = i15;
        this.digestOID = aSN1ObjectIdentifier;
    }

    public static LMOtsParameters getParametersForType(int i10) {
        return suppliers.get(Integer.valueOf(i10));
    }

    public ASN1ObjectIdentifier getDigestOID() {
        return this.digestOID;
    }

    public int getLs() {
        return this.ls;
    }

    public int getN() {
        return this.f23993n;
    }

    public int getP() {
        return this.f23994p;
    }

    public int getSigLen() {
        return this.sigLen;
    }

    public int getType() {
        return this.type;
    }

    public int getW() {
        return this.f23995w;
    }
}

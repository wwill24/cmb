package org.bouncycastle.jcajce.spec;

import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.rosstandart.RosstandartObjectIdentifiers;
import org.bouncycastle.crypto.engines.GOST28147Engine;
import org.bouncycastle.util.Arrays;

public class GOST28147WrapParameterSpec implements AlgorithmParameterSpec {
    private static Map oidMappings;
    private byte[] sBox;
    private byte[] ukm;

    static {
        HashMap hashMap = new HashMap();
        oidMappings = hashMap;
        hashMap.put(CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_A_ParamSet, "E-A");
        oidMappings.put(CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_B_ParamSet, "E-B");
        oidMappings.put(CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_C_ParamSet, "E-C");
        oidMappings.put(CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_D_ParamSet, "E-D");
        oidMappings.put(RosstandartObjectIdentifiers.id_tc26_gost_28147_param_Z, "Param-Z");
    }

    public GOST28147WrapParameterSpec(String str) {
        this.ukm = null;
        this.sBox = null;
        this.sBox = GOST28147Engine.getSBox(str);
    }

    public GOST28147WrapParameterSpec(String str, byte[] bArr) {
        this(str);
        byte[] bArr2 = new byte[bArr.length];
        this.ukm = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
    }

    public GOST28147WrapParameterSpec(ASN1ObjectIdentifier aSN1ObjectIdentifier, byte[] bArr) {
        this(getName(aSN1ObjectIdentifier));
        this.ukm = Arrays.clone(bArr);
    }

    public GOST28147WrapParameterSpec(byte[] bArr) {
        this.ukm = null;
        this.sBox = null;
        byte[] bArr2 = new byte[bArr.length];
        this.sBox = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
    }

    public GOST28147WrapParameterSpec(byte[] bArr, byte[] bArr2) {
        this(bArr);
        byte[] bArr3 = new byte[bArr2.length];
        this.ukm = bArr3;
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
    }

    private static String getName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String str = (String) oidMappings.get(aSN1ObjectIdentifier);
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("unknown OID: " + aSN1ObjectIdentifier);
    }

    public byte[] getSBox() {
        return Arrays.clone(this.sBox);
    }

    public byte[] getUKM() {
        return Arrays.clone(this.ukm);
    }
}

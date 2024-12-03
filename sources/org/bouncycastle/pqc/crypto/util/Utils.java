package org.bouncycastle.pqc.crypto.util;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.crypto.digests.SHAKEDigest;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.asn1.SPHINCS256KeyParams;
import org.bouncycastle.pqc.crypto.sphincs.SPHINCSKeyParameters;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
import org.bouncycastle.util.Integers;

class Utils {
    static final AlgorithmIdentifier AlgID_qTESLA_p_I;
    static final AlgorithmIdentifier AlgID_qTESLA_p_III;
    static final AlgorithmIdentifier SPHINCS_SHA3_256 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha3_256);
    static final AlgorithmIdentifier SPHINCS_SHA512_256 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha512_256);
    static final AlgorithmIdentifier XMSS_SHA256 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha256);
    static final AlgorithmIdentifier XMSS_SHA512 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha512);
    static final AlgorithmIdentifier XMSS_SHAKE128 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_shake128);
    static final AlgorithmIdentifier XMSS_SHAKE256 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_shake256);
    static final Map categories;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = PQCObjectIdentifiers.qTESLA_p_I;
        AlgID_qTESLA_p_I = new AlgorithmIdentifier(aSN1ObjectIdentifier);
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = PQCObjectIdentifiers.qTESLA_p_III;
        AlgID_qTESLA_p_III = new AlgorithmIdentifier(aSN1ObjectIdentifier2);
        HashMap hashMap = new HashMap();
        categories = hashMap;
        hashMap.put(aSN1ObjectIdentifier, Integers.valueOf(5));
        hashMap.put(aSN1ObjectIdentifier2, Integers.valueOf(6));
    }

    Utils() {
    }

    public static AlgorithmIdentifier getAlgorithmIdentifier(String str) {
        if (str.equals("SHA-1")) {
            return new AlgorithmIdentifier(OIWObjectIdentifiers.idSHA1, DERNull.INSTANCE);
        }
        if (str.equals(McElieceCCA2KeyGenParameterSpec.SHA224)) {
            return new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha224);
        }
        if (str.equals("SHA-256")) {
            return new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha256);
        }
        if (str.equals(McElieceCCA2KeyGenParameterSpec.SHA384)) {
            return new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha384);
        }
        if (str.equals("SHA-512")) {
            return new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha512);
        }
        throw new IllegalArgumentException("unrecognised digest algorithm: " + str);
    }

    static Digest getDigest(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        if (aSN1ObjectIdentifier.equals((ASN1Primitive) NISTObjectIdentifiers.id_sha256)) {
            return new SHA256Digest();
        }
        if (aSN1ObjectIdentifier.equals((ASN1Primitive) NISTObjectIdentifiers.id_sha512)) {
            return new SHA512Digest();
        }
        if (aSN1ObjectIdentifier.equals((ASN1Primitive) NISTObjectIdentifiers.id_shake128)) {
            return new SHAKEDigest(128);
        }
        if (aSN1ObjectIdentifier.equals((ASN1Primitive) NISTObjectIdentifiers.id_shake256)) {
            return new SHAKEDigest(256);
        }
        throw new IllegalArgumentException("unrecognized digest OID: " + aSN1ObjectIdentifier);
    }

    public static String getDigestName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        if (aSN1ObjectIdentifier.equals((ASN1Primitive) OIWObjectIdentifiers.idSHA1)) {
            return "SHA-1";
        }
        if (aSN1ObjectIdentifier.equals((ASN1Primitive) NISTObjectIdentifiers.id_sha224)) {
            return McElieceCCA2KeyGenParameterSpec.SHA224;
        }
        if (aSN1ObjectIdentifier.equals((ASN1Primitive) NISTObjectIdentifiers.id_sha256)) {
            return "SHA-256";
        }
        if (aSN1ObjectIdentifier.equals((ASN1Primitive) NISTObjectIdentifiers.id_sha384)) {
            return McElieceCCA2KeyGenParameterSpec.SHA384;
        }
        if (aSN1ObjectIdentifier.equals((ASN1Primitive) NISTObjectIdentifiers.id_sha512)) {
            return "SHA-512";
        }
        throw new IllegalArgumentException("unrecognised digest algorithm: " + aSN1ObjectIdentifier);
    }

    static AlgorithmIdentifier qTeslaLookupAlgID(int i10) {
        if (i10 == 5) {
            return AlgID_qTESLA_p_I;
        }
        if (i10 == 6) {
            return AlgID_qTESLA_p_III;
        }
        throw new IllegalArgumentException("unknown security category: " + i10);
    }

    static int qTeslaLookupSecurityCategory(AlgorithmIdentifier algorithmIdentifier) {
        return ((Integer) categories.get(algorithmIdentifier.getAlgorithm())).intValue();
    }

    static AlgorithmIdentifier sphincs256LookupTreeAlgID(String str) {
        if (str.equals("SHA3-256")) {
            return SPHINCS_SHA3_256;
        }
        if (str.equals(SPHINCSKeyParameters.SHA512_256)) {
            return SPHINCS_SHA512_256;
        }
        throw new IllegalArgumentException("unknown tree digest: " + str);
    }

    static String sphincs256LookupTreeAlgName(SPHINCS256KeyParams sPHINCS256KeyParams) {
        AlgorithmIdentifier treeDigest = sPHINCS256KeyParams.getTreeDigest();
        if (treeDigest.getAlgorithm().equals((ASN1Primitive) SPHINCS_SHA3_256.getAlgorithm())) {
            return "SHA3-256";
        }
        if (treeDigest.getAlgorithm().equals((ASN1Primitive) SPHINCS_SHA512_256.getAlgorithm())) {
            return SPHINCSKeyParameters.SHA512_256;
        }
        throw new IllegalArgumentException("unknown tree digest: " + treeDigest.getAlgorithm());
    }

    static AlgorithmIdentifier xmssLookupTreeAlgID(String str) {
        if (str.equals("SHA-256")) {
            return XMSS_SHA256;
        }
        if (str.equals("SHA-512")) {
            return XMSS_SHA512;
        }
        if (str.equals("SHAKE128")) {
            return XMSS_SHAKE128;
        }
        if (str.equals("SHAKE256")) {
            return XMSS_SHAKE256;
        }
        throw new IllegalArgumentException("unknown tree digest: " + str);
    }
}

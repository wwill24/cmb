package org.bouncycastle.jce.provider;

import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.PSSParameterSpec;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Null;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.RSASSAPSSparams;
import org.bouncycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.jivesoftware.smack.util.StringUtils;

class X509SignatureUtil {
    private static final ASN1Null derNull = DERNull.INSTANCE;

    X509SignatureUtil() {
    }

    private static String getDigestAlgName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return PKCSObjectIdentifiers.md5.equals((ASN1Primitive) aSN1ObjectIdentifier) ? StringUtils.MD5 : OIWObjectIdentifiers.idSHA1.equals((ASN1Primitive) aSN1ObjectIdentifier) ? "SHA1" : NISTObjectIdentifiers.id_sha224.equals((ASN1Primitive) aSN1ObjectIdentifier) ? "SHA224" : NISTObjectIdentifiers.id_sha256.equals((ASN1Primitive) aSN1ObjectIdentifier) ? "SHA256" : NISTObjectIdentifiers.id_sha384.equals((ASN1Primitive) aSN1ObjectIdentifier) ? "SHA384" : NISTObjectIdentifiers.id_sha512.equals((ASN1Primitive) aSN1ObjectIdentifier) ? "SHA512" : TeleTrusTObjectIdentifiers.ripemd128.equals((ASN1Primitive) aSN1ObjectIdentifier) ? "RIPEMD128" : TeleTrusTObjectIdentifiers.ripemd160.equals((ASN1Primitive) aSN1ObjectIdentifier) ? "RIPEMD160" : TeleTrusTObjectIdentifiers.ripemd256.equals((ASN1Primitive) aSN1ObjectIdentifier) ? "RIPEMD256" : CryptoProObjectIdentifiers.gostR3411.equals((ASN1Primitive) aSN1ObjectIdentifier) ? "GOST3411" : aSN1ObjectIdentifier.getId();
    }

    static String getSignatureName(AlgorithmIdentifier algorithmIdentifier) {
        ASN1Encodable parameters = algorithmIdentifier.getParameters();
        if (parameters != null && !derNull.equals(parameters)) {
            if (algorithmIdentifier.getAlgorithm().equals((ASN1Primitive) PKCSObjectIdentifiers.id_RSASSA_PSS)) {
                RSASSAPSSparams instance = RSASSAPSSparams.getInstance(parameters);
                return getDigestAlgName(instance.getHashAlgorithm().getAlgorithm()) + "withRSAandMGF1";
            } else if (algorithmIdentifier.getAlgorithm().equals((ASN1Primitive) X9ObjectIdentifiers.ecdsa_with_SHA2)) {
                ASN1Sequence instance2 = ASN1Sequence.getInstance(parameters);
                return getDigestAlgName(ASN1ObjectIdentifier.getInstance(instance2.getObjectAt(0))) + "withECDSA";
            }
        }
        return algorithmIdentifier.getAlgorithm().getId();
    }

    static void setSignatureParameters(Signature signature, ASN1Encodable aSN1Encodable) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        if (aSN1Encodable != null && !derNull.equals(aSN1Encodable)) {
            AlgorithmParameters instance = AlgorithmParameters.getInstance(signature.getAlgorithm(), signature.getProvider());
            try {
                instance.init(aSN1Encodable.toASN1Primitive().getEncoded());
                if (signature.getAlgorithm().endsWith("MGF1")) {
                    try {
                        signature.setParameter(instance.getParameterSpec(PSSParameterSpec.class));
                    } catch (GeneralSecurityException e10) {
                        throw new SignatureException("Exception extracting parameters: " + e10.getMessage());
                    }
                }
            } catch (IOException e11) {
                throw new SignatureException("IOException decoding parameters: " + e11.getMessage());
            }
        }
    }
}

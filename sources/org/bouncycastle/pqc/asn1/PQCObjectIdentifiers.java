package org.bouncycastle.pqc.asn1;

import com.coffeemeetsbagel.models.ReportMetadata;
import com.facebook.appevents.AppEventsConstants;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.bc.BCObjectIdentifiers;
import org.bouncycastle.pqc.crypto.gmss.GMSSKeyPairGenerator;
import org.bouncycastle.pqc.crypto.mceliece.McElieceFujisakiCipher;
import org.bouncycastle.pqc.crypto.mceliece.McElieceKobaraImaiCipher;
import org.bouncycastle.pqc.crypto.mceliece.McEliecePointchevalCipher;

public interface PQCObjectIdentifiers {
    public static final ASN1ObjectIdentifier gmss;
    public static final ASN1ObjectIdentifier gmssWithSha1;
    public static final ASN1ObjectIdentifier gmssWithSha224;
    public static final ASN1ObjectIdentifier gmssWithSha256;
    public static final ASN1ObjectIdentifier gmssWithSha384;
    public static final ASN1ObjectIdentifier gmssWithSha512;
    public static final ASN1ObjectIdentifier mcEliece = new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.4.1");
    public static final ASN1ObjectIdentifier mcElieceCca2 = new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.4.2");
    public static final ASN1ObjectIdentifier mcElieceFujisaki = new ASN1ObjectIdentifier(McElieceFujisakiCipher.OID);
    public static final ASN1ObjectIdentifier mcElieceKobara_Imai = new ASN1ObjectIdentifier(McElieceKobaraImaiCipher.OID);
    public static final ASN1ObjectIdentifier mcEliecePointcheval = new ASN1ObjectIdentifier(McEliecePointchevalCipher.OID);
    public static final ASN1ObjectIdentifier newHope = BCObjectIdentifiers.newHope;
    public static final ASN1ObjectIdentifier qTESLA = BCObjectIdentifiers.qTESLA;
    public static final ASN1ObjectIdentifier qTESLA_p_I = BCObjectIdentifiers.qTESLA_p_I;
    public static final ASN1ObjectIdentifier qTESLA_p_III = BCObjectIdentifiers.qTESLA_p_III;
    public static final ASN1ObjectIdentifier rainbow;
    public static final ASN1ObjectIdentifier rainbowWithSha1;
    public static final ASN1ObjectIdentifier rainbowWithSha224;
    public static final ASN1ObjectIdentifier rainbowWithSha256;
    public static final ASN1ObjectIdentifier rainbowWithSha384;
    public static final ASN1ObjectIdentifier rainbowWithSha512;
    public static final ASN1ObjectIdentifier sphincs256 = BCObjectIdentifiers.sphincs256;
    public static final ASN1ObjectIdentifier sphincs256_with_BLAKE512 = BCObjectIdentifiers.sphincs256_with_BLAKE512;
    public static final ASN1ObjectIdentifier sphincs256_with_SHA3_512 = BCObjectIdentifiers.sphincs256_with_SHA3_512;
    public static final ASN1ObjectIdentifier sphincs256_with_SHA512 = BCObjectIdentifiers.sphincs256_with_SHA512;
    public static final ASN1ObjectIdentifier xmss = BCObjectIdentifiers.xmss;
    public static final ASN1ObjectIdentifier xmss_SHA256 = BCObjectIdentifiers.xmss_SHA256;
    public static final ASN1ObjectIdentifier xmss_SHA256ph;
    public static final ASN1ObjectIdentifier xmss_SHA512 = BCObjectIdentifiers.xmss_SHA512;
    public static final ASN1ObjectIdentifier xmss_SHA512ph;
    public static final ASN1ObjectIdentifier xmss_SHAKE128 = BCObjectIdentifiers.xmss_SHAKE128;
    public static final ASN1ObjectIdentifier xmss_SHAKE128ph;
    public static final ASN1ObjectIdentifier xmss_SHAKE256 = BCObjectIdentifiers.xmss_SHAKE256;
    public static final ASN1ObjectIdentifier xmss_SHAKE256ph;
    public static final ASN1ObjectIdentifier xmss_mt = BCObjectIdentifiers.xmss_mt;
    public static final ASN1ObjectIdentifier xmss_mt_SHA256 = BCObjectIdentifiers.xmss_mt_SHA256;
    public static final ASN1ObjectIdentifier xmss_mt_SHA256ph;
    public static final ASN1ObjectIdentifier xmss_mt_SHA512 = BCObjectIdentifiers.xmss_mt_SHA512;
    public static final ASN1ObjectIdentifier xmss_mt_SHA512ph;
    public static final ASN1ObjectIdentifier xmss_mt_SHAKE128;
    public static final ASN1ObjectIdentifier xmss_mt_SHAKE128ph = BCObjectIdentifiers.xmss_mt_SHAKE128ph;
    public static final ASN1ObjectIdentifier xmss_mt_SHAKE256;
    public static final ASN1ObjectIdentifier xmss_mt_SHAKE256ph = BCObjectIdentifiers.xmss_mt_SHAKE256ph;
    public static final ASN1ObjectIdentifier xmss_mt_with_SHA256;
    public static final ASN1ObjectIdentifier xmss_mt_with_SHA512;
    public static final ASN1ObjectIdentifier xmss_mt_with_SHAKE128;
    public static final ASN1ObjectIdentifier xmss_mt_with_SHAKE256;
    public static final ASN1ObjectIdentifier xmss_with_SHA256;
    public static final ASN1ObjectIdentifier xmss_with_SHA512;
    public static final ASN1ObjectIdentifier xmss_with_SHAKE128;
    public static final ASN1ObjectIdentifier xmss_with_SHAKE256;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.5.3.2");
        rainbow = aSN1ObjectIdentifier;
        rainbowWithSha1 = aSN1ObjectIdentifier.branch(AppEventsConstants.EVENT_PARAM_VALUE_YES);
        rainbowWithSha224 = aSN1ObjectIdentifier.branch("2");
        rainbowWithSha256 = aSN1ObjectIdentifier.branch("3");
        rainbowWithSha384 = aSN1ObjectIdentifier.branch(ReportMetadata.ID_TIPS);
        rainbowWithSha512 = aSN1ObjectIdentifier.branch("5");
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier(GMSSKeyPairGenerator.OID);
        gmss = aSN1ObjectIdentifier2;
        gmssWithSha1 = aSN1ObjectIdentifier2.branch(AppEventsConstants.EVENT_PARAM_VALUE_YES);
        gmssWithSha224 = aSN1ObjectIdentifier2.branch("2");
        gmssWithSha256 = aSN1ObjectIdentifier2.branch("3");
        gmssWithSha384 = aSN1ObjectIdentifier2.branch(ReportMetadata.ID_TIPS);
        gmssWithSha512 = aSN1ObjectIdentifier2.branch("5");
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = BCObjectIdentifiers.xmss_SHA256ph;
        xmss_SHA256ph = aSN1ObjectIdentifier3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = BCObjectIdentifiers.xmss_SHA512ph;
        xmss_SHA512ph = aSN1ObjectIdentifier4;
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = BCObjectIdentifiers.xmss_SHAKE128ph;
        xmss_SHAKE128ph = aSN1ObjectIdentifier5;
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = BCObjectIdentifiers.xmss_SHAKE256ph;
        xmss_SHAKE256ph = aSN1ObjectIdentifier6;
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = BCObjectIdentifiers.xmss_mt_SHA256ph;
        xmss_mt_SHA256ph = aSN1ObjectIdentifier7;
        ASN1ObjectIdentifier aSN1ObjectIdentifier8 = BCObjectIdentifiers.xmss_mt_SHA512ph;
        xmss_mt_SHA512ph = aSN1ObjectIdentifier8;
        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = BCObjectIdentifiers.xmss_mt_SHAKE128;
        xmss_mt_SHAKE128 = aSN1ObjectIdentifier9;
        ASN1ObjectIdentifier aSN1ObjectIdentifier10 = BCObjectIdentifiers.xmss_mt_SHAKE256;
        xmss_mt_SHAKE256 = aSN1ObjectIdentifier10;
        xmss_with_SHA256 = aSN1ObjectIdentifier3;
        xmss_with_SHA512 = aSN1ObjectIdentifier4;
        xmss_with_SHAKE128 = aSN1ObjectIdentifier5;
        xmss_with_SHAKE256 = aSN1ObjectIdentifier6;
        xmss_mt_with_SHA256 = aSN1ObjectIdentifier7;
        xmss_mt_with_SHA512 = aSN1ObjectIdentifier8;
        xmss_mt_with_SHAKE128 = aSN1ObjectIdentifier9;
        xmss_mt_with_SHAKE256 = aSN1ObjectIdentifier10;
    }
}

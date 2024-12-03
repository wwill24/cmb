package org.bouncycastle.internal.asn1.bsi;

import com.coffeemeetsbagel.models.ReportMetadata;
import com.facebook.appevents.AppEventsConstants;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public interface BSIObjectIdentifiers {
    public static final ASN1ObjectIdentifier algorithm;
    public static final ASN1ObjectIdentifier bsi_de;
    public static final ASN1ObjectIdentifier ecdsa_plain_RIPEMD160;
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA1;
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA224;
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA256;
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA384;
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA3_224;
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA3_256;
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA3_384;
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA3_512;
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA512;
    public static final ASN1ObjectIdentifier ecdsa_plain_signatures;
    public static final ASN1ObjectIdentifier ecka_eg;
    public static final ASN1ObjectIdentifier ecka_eg_SessionKDF;
    public static final ASN1ObjectIdentifier ecka_eg_SessionKDF_3DES;
    public static final ASN1ObjectIdentifier ecka_eg_SessionKDF_AES128;
    public static final ASN1ObjectIdentifier ecka_eg_SessionKDF_AES192;
    public static final ASN1ObjectIdentifier ecka_eg_SessionKDF_AES256;
    public static final ASN1ObjectIdentifier ecka_eg_X963kdf;
    public static final ASN1ObjectIdentifier ecka_eg_X963kdf_RIPEMD160;
    public static final ASN1ObjectIdentifier ecka_eg_X963kdf_SHA1;
    public static final ASN1ObjectIdentifier ecka_eg_X963kdf_SHA224;
    public static final ASN1ObjectIdentifier ecka_eg_X963kdf_SHA256;
    public static final ASN1ObjectIdentifier ecka_eg_X963kdf_SHA384;
    public static final ASN1ObjectIdentifier ecka_eg_X963kdf_SHA512;
    public static final ASN1ObjectIdentifier id_ecc;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("0.4.0.127.0.7");
        bsi_de = aSN1ObjectIdentifier;
        ASN1ObjectIdentifier branch = aSN1ObjectIdentifier.branch("1.1");
        id_ecc = branch;
        ASN1ObjectIdentifier branch2 = branch.branch("4.1");
        ecdsa_plain_signatures = branch2;
        ecdsa_plain_SHA1 = branch2.branch(AppEventsConstants.EVENT_PARAM_VALUE_YES);
        ecdsa_plain_SHA224 = branch2.branch("2");
        ecdsa_plain_SHA256 = branch2.branch("3");
        ecdsa_plain_SHA384 = branch2.branch(ReportMetadata.ID_TIPS);
        ecdsa_plain_SHA512 = branch2.branch("5");
        ecdsa_plain_RIPEMD160 = branch2.branch("6");
        ecdsa_plain_SHA3_224 = branch2.branch("8");
        ecdsa_plain_SHA3_256 = branch2.branch("9");
        ecdsa_plain_SHA3_384 = branch2.branch("10");
        ecdsa_plain_SHA3_512 = branch2.branch("11");
        algorithm = aSN1ObjectIdentifier.branch(AppEventsConstants.EVENT_PARAM_VALUE_YES);
        ASN1ObjectIdentifier branch3 = branch.branch("5.1");
        ecka_eg = branch3;
        ASN1ObjectIdentifier branch4 = branch3.branch(AppEventsConstants.EVENT_PARAM_VALUE_YES);
        ecka_eg_X963kdf = branch4;
        ecka_eg_X963kdf_SHA1 = branch4.branch(AppEventsConstants.EVENT_PARAM_VALUE_YES);
        ecka_eg_X963kdf_SHA224 = branch4.branch("2");
        ecka_eg_X963kdf_SHA256 = branch4.branch("3");
        ecka_eg_X963kdf_SHA384 = branch4.branch(ReportMetadata.ID_TIPS);
        ecka_eg_X963kdf_SHA512 = branch4.branch("5");
        ecka_eg_X963kdf_RIPEMD160 = branch4.branch("6");
        ASN1ObjectIdentifier branch5 = branch3.branch("2");
        ecka_eg_SessionKDF = branch5;
        ecka_eg_SessionKDF_3DES = branch5.branch(AppEventsConstants.EVENT_PARAM_VALUE_YES);
        ecka_eg_SessionKDF_AES128 = branch5.branch("2");
        ecka_eg_SessionKDF_AES192 = branch5.branch("3");
        ecka_eg_SessionKDF_AES256 = branch5.branch(ReportMetadata.ID_TIPS);
    }
}

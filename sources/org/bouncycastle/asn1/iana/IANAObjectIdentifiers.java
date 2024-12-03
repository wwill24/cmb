package org.bouncycastle.asn1.iana;

import com.coffeemeetsbagel.models.ReportMetadata;
import com.facebook.appevents.AppEventsConstants;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public interface IANAObjectIdentifiers {
    public static final ASN1ObjectIdentifier SNMPv2;
    public static final ASN1ObjectIdentifier _private;
    public static final ASN1ObjectIdentifier directory;
    public static final ASN1ObjectIdentifier experimental;
    public static final ASN1ObjectIdentifier hmacMD5;
    public static final ASN1ObjectIdentifier hmacRIPEMD160;
    public static final ASN1ObjectIdentifier hmacSHA1;
    public static final ASN1ObjectIdentifier hmacTIGER;
    public static final ASN1ObjectIdentifier internet;
    public static final ASN1ObjectIdentifier ipsec;
    public static final ASN1ObjectIdentifier isakmpOakley;
    public static final ASN1ObjectIdentifier mail;
    public static final ASN1ObjectIdentifier mgmt;
    public static final ASN1ObjectIdentifier pkix;
    public static final ASN1ObjectIdentifier security;
    public static final ASN1ObjectIdentifier security_mechanisms;
    public static final ASN1ObjectIdentifier security_nametypes;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.6.1");
        internet = aSN1ObjectIdentifier;
        directory = aSN1ObjectIdentifier.branch(AppEventsConstants.EVENT_PARAM_VALUE_YES);
        mgmt = aSN1ObjectIdentifier.branch("2");
        experimental = aSN1ObjectIdentifier.branch("3");
        _private = aSN1ObjectIdentifier.branch(ReportMetadata.ID_TIPS);
        ASN1ObjectIdentifier branch = aSN1ObjectIdentifier.branch("5");
        security = branch;
        SNMPv2 = aSN1ObjectIdentifier.branch("6");
        mail = aSN1ObjectIdentifier.branch("7");
        ASN1ObjectIdentifier branch2 = branch.branch("5");
        security_mechanisms = branch2;
        security_nametypes = branch.branch("6");
        pkix = branch2.branch("6");
        ASN1ObjectIdentifier branch3 = branch2.branch("8");
        ipsec = branch3;
        ASN1ObjectIdentifier branch4 = branch3.branch(AppEventsConstants.EVENT_PARAM_VALUE_YES);
        isakmpOakley = branch4;
        hmacMD5 = branch4.branch(AppEventsConstants.EVENT_PARAM_VALUE_YES);
        hmacSHA1 = branch4.branch("2");
        hmacTIGER = branch4.branch("3");
        hmacRIPEMD160 = branch4.branch(ReportMetadata.ID_TIPS);
    }
}

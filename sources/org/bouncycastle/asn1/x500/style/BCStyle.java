package org.bouncycastle.asn1.x500.style;

import com.coffeemeetsbagel.models.constants.ProfileConstants;
import com.facebook.appevents.UserDataStore;
import com.facebook.share.internal.ShareConstants;
import com.mparticle.kits.ReportingMessage;
import java.util.Hashtable;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x500.RDN;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.X500NameStyle;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;

public class BCStyle extends AbstractX500NameStyle {
    public static final ASN1ObjectIdentifier BUSINESS_CATEGORY;
    public static final ASN1ObjectIdentifier C;
    public static final ASN1ObjectIdentifier CN;
    public static final ASN1ObjectIdentifier COUNTRY_OF_CITIZENSHIP;
    public static final ASN1ObjectIdentifier COUNTRY_OF_RESIDENCE;
    public static final ASN1ObjectIdentifier DATE_OF_BIRTH;
    public static final ASN1ObjectIdentifier DC;
    public static final ASN1ObjectIdentifier DESCRIPTION;
    public static final ASN1ObjectIdentifier DMD_NAME = new ASN1ObjectIdentifier("2.5.4.54").intern();
    public static final ASN1ObjectIdentifier DN_QUALIFIER;
    private static final Hashtable DefaultLookUp;
    private static final Hashtable DefaultSymbols;
    public static final ASN1ObjectIdentifier E;
    public static final ASN1ObjectIdentifier EmailAddress;
    public static final ASN1ObjectIdentifier GENDER;
    public static final ASN1ObjectIdentifier GENERATION;
    public static final ASN1ObjectIdentifier GIVENNAME;
    public static final ASN1ObjectIdentifier INITIALS;
    public static final X500NameStyle INSTANCE = new BCStyle();
    public static final ASN1ObjectIdentifier L;
    public static final ASN1ObjectIdentifier NAME;
    public static final ASN1ObjectIdentifier NAME_AT_BIRTH;
    public static final ASN1ObjectIdentifier O;
    public static final ASN1ObjectIdentifier ORGANIZATION_IDENTIFIER;
    public static final ASN1ObjectIdentifier OU;
    public static final ASN1ObjectIdentifier PLACE_OF_BIRTH;
    public static final ASN1ObjectIdentifier POSTAL_ADDRESS;
    public static final ASN1ObjectIdentifier POSTAL_CODE;
    public static final ASN1ObjectIdentifier PSEUDONYM;
    public static final ASN1ObjectIdentifier ROLE;
    public static final ASN1ObjectIdentifier SERIALNUMBER;
    public static final ASN1ObjectIdentifier SN = new ASN1ObjectIdentifier("2.5.4.5").intern();
    public static final ASN1ObjectIdentifier ST;
    public static final ASN1ObjectIdentifier STREET;
    public static final ASN1ObjectIdentifier SURNAME;
    public static final ASN1ObjectIdentifier T;
    public static final ASN1ObjectIdentifier TELEPHONE_NUMBER;
    public static final ASN1ObjectIdentifier UID;
    public static final ASN1ObjectIdentifier UNIQUE_IDENTIFIER;
    public static final ASN1ObjectIdentifier UnstructuredAddress;
    public static final ASN1ObjectIdentifier UnstructuredName;
    protected final Hashtable defaultLookUp = AbstractX500NameStyle.copyHashTable(DefaultLookUp);
    protected final Hashtable defaultSymbols = AbstractX500NameStyle.copyHashTable(DefaultSymbols);

    static {
        ASN1ObjectIdentifier intern = new ASN1ObjectIdentifier("2.5.4.6").intern();
        C = intern;
        ASN1ObjectIdentifier intern2 = new ASN1ObjectIdentifier("2.5.4.10").intern();
        O = intern2;
        ASN1ObjectIdentifier intern3 = new ASN1ObjectIdentifier("2.5.4.11").intern();
        OU = intern3;
        ASN1ObjectIdentifier intern4 = new ASN1ObjectIdentifier("2.5.4.12").intern();
        T = intern4;
        ASN1ObjectIdentifier intern5 = new ASN1ObjectIdentifier("2.5.4.3").intern();
        CN = intern5;
        ASN1ObjectIdentifier intern6 = new ASN1ObjectIdentifier("2.5.4.9").intern();
        STREET = intern6;
        ASN1ObjectIdentifier intern7 = new ASN1ObjectIdentifier("2.5.4.5").intern();
        SERIALNUMBER = intern7;
        ASN1ObjectIdentifier intern8 = new ASN1ObjectIdentifier("2.5.4.7").intern();
        L = intern8;
        ASN1ObjectIdentifier intern9 = new ASN1ObjectIdentifier("2.5.4.8").intern();
        ST = intern9;
        ASN1ObjectIdentifier intern10 = new ASN1ObjectIdentifier("2.5.4.4").intern();
        SURNAME = intern10;
        ASN1ObjectIdentifier intern11 = new ASN1ObjectIdentifier("2.5.4.42").intern();
        GIVENNAME = intern11;
        ASN1ObjectIdentifier intern12 = new ASN1ObjectIdentifier("2.5.4.43").intern();
        INITIALS = intern12;
        ASN1ObjectIdentifier intern13 = new ASN1ObjectIdentifier("2.5.4.44").intern();
        GENERATION = intern13;
        ASN1ObjectIdentifier intern14 = new ASN1ObjectIdentifier("2.5.4.45").intern();
        UNIQUE_IDENTIFIER = intern14;
        ASN1ObjectIdentifier intern15 = new ASN1ObjectIdentifier("2.5.4.13").intern();
        DESCRIPTION = intern15;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = intern14;
        ASN1ObjectIdentifier intern16 = new ASN1ObjectIdentifier("2.5.4.15").intern();
        BUSINESS_CATEGORY = intern16;
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = intern16;
        ASN1ObjectIdentifier intern17 = new ASN1ObjectIdentifier("2.5.4.17").intern();
        POSTAL_CODE = intern17;
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = intern17;
        ASN1ObjectIdentifier intern18 = new ASN1ObjectIdentifier("2.5.4.46").intern();
        DN_QUALIFIER = intern18;
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = intern18;
        ASN1ObjectIdentifier intern19 = new ASN1ObjectIdentifier("2.5.4.65").intern();
        PSEUDONYM = intern19;
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = intern19;
        ASN1ObjectIdentifier intern20 = new ASN1ObjectIdentifier("2.5.4.72").intern();
        ROLE = intern20;
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = intern20;
        ASN1ObjectIdentifier intern21 = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.1").intern();
        DATE_OF_BIRTH = intern21;
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = intern21;
        ASN1ObjectIdentifier intern22 = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.2").intern();
        PLACE_OF_BIRTH = intern22;
        ASN1ObjectIdentifier aSN1ObjectIdentifier8 = intern22;
        ASN1ObjectIdentifier intern23 = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.3").intern();
        GENDER = intern23;
        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = intern23;
        ASN1ObjectIdentifier intern24 = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.4").intern();
        COUNTRY_OF_CITIZENSHIP = intern24;
        ASN1ObjectIdentifier aSN1ObjectIdentifier10 = intern24;
        ASN1ObjectIdentifier intern25 = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.5").intern();
        COUNTRY_OF_RESIDENCE = intern25;
        ASN1ObjectIdentifier aSN1ObjectIdentifier11 = intern25;
        ASN1ObjectIdentifier intern26 = new ASN1ObjectIdentifier("1.3.36.8.3.14").intern();
        NAME_AT_BIRTH = intern26;
        ASN1ObjectIdentifier aSN1ObjectIdentifier12 = intern26;
        ASN1ObjectIdentifier intern27 = new ASN1ObjectIdentifier("2.5.4.16").intern();
        POSTAL_ADDRESS = intern27;
        ASN1ObjectIdentifier aSN1ObjectIdentifier13 = intern27;
        ASN1ObjectIdentifier aSN1ObjectIdentifier14 = X509ObjectIdentifiers.id_at_telephoneNumber;
        TELEPHONE_NUMBER = aSN1ObjectIdentifier14;
        ASN1ObjectIdentifier aSN1ObjectIdentifier15 = X509ObjectIdentifiers.id_at_name;
        NAME = aSN1ObjectIdentifier15;
        ASN1ObjectIdentifier aSN1ObjectIdentifier16 = aSN1ObjectIdentifier15;
        ASN1ObjectIdentifier aSN1ObjectIdentifier17 = X509ObjectIdentifiers.id_at_organizationIdentifier;
        ORGANIZATION_IDENTIFIER = aSN1ObjectIdentifier17;
        ASN1ObjectIdentifier aSN1ObjectIdentifier18 = aSN1ObjectIdentifier17;
        ASN1ObjectIdentifier aSN1ObjectIdentifier19 = PKCSObjectIdentifiers.pkcs_9_at_emailAddress;
        EmailAddress = aSN1ObjectIdentifier19;
        ASN1ObjectIdentifier aSN1ObjectIdentifier20 = aSN1ObjectIdentifier14;
        ASN1ObjectIdentifier aSN1ObjectIdentifier21 = PKCSObjectIdentifiers.pkcs_9_at_unstructuredName;
        UnstructuredName = aSN1ObjectIdentifier21;
        ASN1ObjectIdentifier aSN1ObjectIdentifier22 = aSN1ObjectIdentifier21;
        ASN1ObjectIdentifier aSN1ObjectIdentifier23 = PKCSObjectIdentifiers.pkcs_9_at_unstructuredAddress;
        UnstructuredAddress = aSN1ObjectIdentifier23;
        E = aSN1ObjectIdentifier19;
        ASN1ObjectIdentifier aSN1ObjectIdentifier24 = aSN1ObjectIdentifier23;
        ASN1ObjectIdentifier aSN1ObjectIdentifier25 = intern15;
        ASN1ObjectIdentifier aSN1ObjectIdentifier26 = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.25");
        DC = aSN1ObjectIdentifier26;
        ASN1ObjectIdentifier aSN1ObjectIdentifier27 = intern13;
        ASN1ObjectIdentifier aSN1ObjectIdentifier28 = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.1");
        UID = aSN1ObjectIdentifier28;
        Hashtable hashtable = new Hashtable();
        DefaultSymbols = hashtable;
        ASN1ObjectIdentifier aSN1ObjectIdentifier29 = intern12;
        Hashtable hashtable2 = new Hashtable();
        DefaultLookUp = hashtable2;
        hashtable.put(intern, "C");
        hashtable.put(intern2, "O");
        hashtable.put(intern4, "T");
        hashtable.put(intern3, "OU");
        hashtable.put(intern5, "CN");
        hashtable.put(intern8, "L");
        hashtable.put(intern9, "ST");
        hashtable.put(intern7, "SERIALNUMBER");
        hashtable.put(aSN1ObjectIdentifier19, "E");
        hashtable.put(aSN1ObjectIdentifier26, "DC");
        hashtable.put(aSN1ObjectIdentifier28, "UID");
        hashtable.put(intern6, "STREET");
        hashtable.put(intern10, "SURNAME");
        hashtable.put(intern11, "GIVENNAME");
        ASN1ObjectIdentifier aSN1ObjectIdentifier30 = intern11;
        hashtable.put(aSN1ObjectIdentifier29, "INITIALS");
        hashtable.put(aSN1ObjectIdentifier27, "GENERATION");
        hashtable.put(aSN1ObjectIdentifier25, ShareConstants.DESCRIPTION);
        hashtable.put(aSN1ObjectIdentifier6, "ROLE");
        hashtable.put(aSN1ObjectIdentifier24, "unstructuredAddress");
        hashtable.put(aSN1ObjectIdentifier22, "unstructuredName");
        hashtable.put(aSN1ObjectIdentifier, "UniqueIdentifier");
        hashtable.put(aSN1ObjectIdentifier4, "DN");
        hashtable.put(aSN1ObjectIdentifier5, "Pseudonym");
        hashtable.put(aSN1ObjectIdentifier13, "PostalAddress");
        hashtable.put(aSN1ObjectIdentifier12, "NameAtBirth");
        hashtable.put(aSN1ObjectIdentifier10, "CountryOfCitizenship");
        hashtable.put(aSN1ObjectIdentifier11, "CountryOfResidence");
        hashtable.put(aSN1ObjectIdentifier9, "Gender");
        hashtable.put(aSN1ObjectIdentifier8, "PlaceOfBirth");
        hashtable.put(aSN1ObjectIdentifier7, "DateOfBirth");
        hashtable.put(aSN1ObjectIdentifier3, "PostalCode");
        hashtable.put(aSN1ObjectIdentifier2, "BusinessCategory");
        hashtable.put(aSN1ObjectIdentifier20, "TelephoneNumber");
        hashtable.put(aSN1ObjectIdentifier16, "Name");
        ASN1ObjectIdentifier aSN1ObjectIdentifier31 = aSN1ObjectIdentifier18;
        hashtable.put(aSN1ObjectIdentifier31, "organizationIdentifier");
        Hashtable hashtable3 = hashtable2;
        hashtable3.put("c", intern);
        hashtable3.put(ReportingMessage.MessageType.OPT_OUT, intern2);
        hashtable3.put("t", intern4);
        hashtable3.put("ou", intern3);
        hashtable3.put("cn", intern5);
        hashtable3.put("l", intern8);
        hashtable3.put(UserDataStore.STATE, intern9);
        hashtable3.put("sn", intern10);
        hashtable3.put("serialnumber", intern7);
        hashtable3.put("street", intern6);
        hashtable3.put("emailaddress", aSN1ObjectIdentifier19);
        hashtable3.put("dc", aSN1ObjectIdentifier26);
        hashtable3.put(ReportingMessage.MessageType.EVENT, aSN1ObjectIdentifier19);
        hashtable3.put("uid", aSN1ObjectIdentifier28);
        hashtable3.put("surname", intern10);
        hashtable3.put("givenname", aSN1ObjectIdentifier30);
        hashtable3.put("initials", aSN1ObjectIdentifier29);
        hashtable3.put("generation", aSN1ObjectIdentifier27);
        hashtable3.put("description", aSN1ObjectIdentifier25);
        hashtable3.put("role", aSN1ObjectIdentifier6);
        hashtable3.put("unstructuredaddress", aSN1ObjectIdentifier24);
        hashtable3.put("unstructuredname", aSN1ObjectIdentifier22);
        hashtable3.put("uniqueidentifier", aSN1ObjectIdentifier);
        hashtable3.put("dn", aSN1ObjectIdentifier4);
        hashtable3.put("pseudonym", aSN1ObjectIdentifier5);
        hashtable3.put("postaladdress", aSN1ObjectIdentifier13);
        hashtable3.put("nameatbirth", aSN1ObjectIdentifier12);
        hashtable3.put("countryofcitizenship", aSN1ObjectIdentifier10);
        hashtable3.put("countryofresidence", aSN1ObjectIdentifier11);
        hashtable3.put(ProfileConstants.Field.GENDER, aSN1ObjectIdentifier9);
        hashtable3.put("placeofbirth", aSN1ObjectIdentifier8);
        hashtable3.put("dateofbirth", aSN1ObjectIdentifier7);
        hashtable3.put("postalcode", aSN1ObjectIdentifier3);
        hashtable3.put("businesscategory", aSN1ObjectIdentifier2);
        hashtable3.put("telephonenumber", aSN1ObjectIdentifier20);
        hashtable3.put("name", aSN1ObjectIdentifier16);
        hashtable3.put("organizationidentifier", aSN1ObjectIdentifier31);
    }

    protected BCStyle() {
    }

    public ASN1ObjectIdentifier attrNameToOID(String str) {
        return IETFUtils.decodeAttrName(str, this.defaultLookUp);
    }

    /* access modifiers changed from: protected */
    public ASN1Encodable encodeStringValue(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        return (aSN1ObjectIdentifier.equals((ASN1Primitive) EmailAddress) || aSN1ObjectIdentifier.equals((ASN1Primitive) DC)) ? new DERIA5String(str) : aSN1ObjectIdentifier.equals((ASN1Primitive) DATE_OF_BIRTH) ? new ASN1GeneralizedTime(str) : (aSN1ObjectIdentifier.equals((ASN1Primitive) C) || aSN1ObjectIdentifier.equals((ASN1Primitive) SN) || aSN1ObjectIdentifier.equals((ASN1Primitive) DN_QUALIFIER) || aSN1ObjectIdentifier.equals((ASN1Primitive) TELEPHONE_NUMBER)) ? new DERPrintableString(str) : super.encodeStringValue(aSN1ObjectIdentifier, str);
    }

    public RDN[] fromString(String str) {
        return IETFUtils.rDNsFromString(str, this);
    }

    public String[] oidToAttrNames(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return IETFUtils.findAttrNamesForOID(aSN1ObjectIdentifier, this.defaultLookUp);
    }

    public String oidToDisplayName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (String) DefaultSymbols.get(aSN1ObjectIdentifier);
    }

    public String toString(X500Name x500Name) {
        StringBuffer stringBuffer = new StringBuffer();
        RDN[] rDNs = x500Name.getRDNs();
        boolean z10 = true;
        for (RDN appendRDN : rDNs) {
            if (z10) {
                z10 = false;
            } else {
                stringBuffer.append(',');
            }
            IETFUtils.appendRDN(stringBuffer, appendRDN, this.defaultSymbols);
        }
        return stringBuffer.toString();
    }
}

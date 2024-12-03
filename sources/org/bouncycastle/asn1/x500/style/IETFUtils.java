package org.bouncycastle.asn1.x500.style;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1String;
import org.bouncycastle.asn1.DERUniversalString;
import org.bouncycastle.asn1.x500.AttributeTypeAndValue;
import org.bouncycastle.asn1.x500.RDN;
import org.bouncycastle.asn1.x500.X500NameBuilder;
import org.bouncycastle.asn1.x500.X500NameStyle;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;

public class IETFUtils {
    public static void appendRDN(StringBuffer stringBuffer, RDN rdn, Hashtable hashtable) {
        if (rdn.isMultiValued()) {
            AttributeTypeAndValue[] typesAndValues = rdn.getTypesAndValues();
            boolean z10 = true;
            for (int i10 = 0; i10 != typesAndValues.length; i10++) {
                if (z10) {
                    z10 = false;
                } else {
                    stringBuffer.append(SignatureVisitor.EXTENDS);
                }
                appendTypeAndValue(stringBuffer, typesAndValues[i10], hashtable);
            }
        } else if (rdn.getFirst() != null) {
            appendTypeAndValue(stringBuffer, rdn.getFirst(), hashtable);
        }
    }

    public static void appendTypeAndValue(StringBuffer stringBuffer, AttributeTypeAndValue attributeTypeAndValue, Hashtable hashtable) {
        String str = (String) hashtable.get(attributeTypeAndValue.getType());
        if (str == null) {
            str = attributeTypeAndValue.getType().getId();
        }
        stringBuffer.append(str);
        stringBuffer.append(SignatureVisitor.INSTANCEOF);
        stringBuffer.append(valueToString(attributeTypeAndValue.getValue()));
    }

    private static boolean atvAreEqual(AttributeTypeAndValue attributeTypeAndValue, AttributeTypeAndValue attributeTypeAndValue2) {
        if (attributeTypeAndValue == attributeTypeAndValue2) {
            return true;
        }
        return attributeTypeAndValue != null && attributeTypeAndValue2 != null && attributeTypeAndValue.getType().equals((ASN1Primitive) attributeTypeAndValue2.getType()) && canonicalString(attributeTypeAndValue.getValue()).equals(canonicalString(attributeTypeAndValue2.getValue()));
    }

    public static String canonicalString(ASN1Encodable aSN1Encodable) {
        return canonicalize(valueToString(aSN1Encodable));
    }

    public static String canonicalize(String str) {
        int i10 = 0;
        if (str.length() > 0 && str.charAt(0) == '#') {
            ASN1Primitive decodeObject = decodeObject(str);
            if (decodeObject instanceof ASN1String) {
                str = ((ASN1String) decodeObject).getString();
            }
        }
        String lowerCase = Strings.toLowerCase(str);
        int length = lowerCase.length();
        if (length < 2) {
            return lowerCase;
        }
        int i11 = length - 1;
        while (i10 < i11 && lowerCase.charAt(i10) == '\\' && lowerCase.charAt(i10 + 1) == ' ') {
            i10 += 2;
        }
        int i12 = i10 + 1;
        int i13 = i11;
        while (i13 > i12 && lowerCase.charAt(i13 - 1) == '\\' && lowerCase.charAt(i13) == ' ') {
            i13 -= 2;
        }
        if (i10 > 0 || i13 < i11) {
            lowerCase = lowerCase.substring(i10, i13 + 1);
        }
        return stripInternalSpaces(lowerCase);
    }

    private static int convertHex(char c10) {
        if ('0' <= c10 && c10 <= '9') {
            return c10 - '0';
        }
        return (('a' > c10 || c10 > 'f') ? c10 - 'A' : c10 - 'a') + 10;
    }

    public static ASN1ObjectIdentifier decodeAttrName(String str, Hashtable hashtable) {
        if (Strings.toUpperCase(str).startsWith("OID.")) {
            return new ASN1ObjectIdentifier(str.substring(4));
        }
        if (str.charAt(0) >= '0' && str.charAt(0) <= '9') {
            return new ASN1ObjectIdentifier(str);
        }
        ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) hashtable.get(Strings.toLowerCase(str));
        if (aSN1ObjectIdentifier != null) {
            return aSN1ObjectIdentifier;
        }
        throw new IllegalArgumentException("Unknown object id - " + str + " - passed to distinguished name");
    }

    private static ASN1Primitive decodeObject(String str) {
        try {
            return ASN1Primitive.fromByteArray(Hex.decodeStrict(str, 1, str.length() - 1));
        } catch (IOException e10) {
            throw new IllegalStateException("unknown encoding in name: " + e10);
        }
    }

    public static String[] findAttrNamesForOID(ASN1ObjectIdentifier aSN1ObjectIdentifier, Hashtable hashtable) {
        Enumeration elements = hashtable.elements();
        int i10 = 0;
        int i11 = 0;
        while (elements.hasMoreElements()) {
            if (aSN1ObjectIdentifier.equals(elements.nextElement())) {
                i11++;
            }
        }
        String[] strArr = new String[i11];
        Enumeration keys = hashtable.keys();
        while (keys.hasMoreElements()) {
            String str = (String) keys.nextElement();
            if (aSN1ObjectIdentifier.equals(hashtable.get(str))) {
                strArr[i10] = str;
                i10++;
            }
        }
        return strArr;
    }

    private static boolean isHexDigit(char c10) {
        return ('0' <= c10 && c10 <= '9') || ('a' <= c10 && c10 <= 'f') || ('A' <= c10 && c10 <= 'F');
    }

    public static boolean rDNAreEqual(RDN rdn, RDN rdn2) {
        if (rdn.size() != rdn2.size()) {
            return false;
        }
        AttributeTypeAndValue[] typesAndValues = rdn.getTypesAndValues();
        AttributeTypeAndValue[] typesAndValues2 = rdn2.getTypesAndValues();
        if (typesAndValues.length != typesAndValues2.length) {
            return false;
        }
        for (int i10 = 0; i10 != typesAndValues.length; i10++) {
            if (!atvAreEqual(typesAndValues[i10], typesAndValues2[i10])) {
                return false;
            }
        }
        return true;
    }

    public static RDN[] rDNsFromString(String str, X500NameStyle x500NameStyle) {
        X500NameTokenizer x500NameTokenizer = new X500NameTokenizer(str);
        X500NameBuilder x500NameBuilder = new X500NameBuilder(x500NameStyle);
        while (x500NameTokenizer.hasMoreTokens()) {
            String nextToken = x500NameTokenizer.nextToken();
            if (nextToken.indexOf(43) > 0) {
                X500NameTokenizer x500NameTokenizer2 = new X500NameTokenizer(nextToken, SignatureVisitor.EXTENDS);
                X500NameTokenizer x500NameTokenizer3 = new X500NameTokenizer(x500NameTokenizer2.nextToken(), SignatureVisitor.INSTANCEOF);
                String nextToken2 = x500NameTokenizer3.nextToken();
                if (x500NameTokenizer3.hasMoreTokens()) {
                    String nextToken3 = x500NameTokenizer3.nextToken();
                    ASN1ObjectIdentifier attrNameToOID = x500NameStyle.attrNameToOID(nextToken2.trim());
                    if (x500NameTokenizer2.hasMoreTokens()) {
                        Vector vector = new Vector();
                        Vector vector2 = new Vector();
                        while (true) {
                            vector.addElement(attrNameToOID);
                            vector2.addElement(unescape(nextToken3));
                            if (!x500NameTokenizer2.hasMoreTokens()) {
                                x500NameBuilder.addMultiValuedRDN(toOIDArray(vector), toValueArray(vector2));
                                break;
                            }
                            X500NameTokenizer x500NameTokenizer4 = new X500NameTokenizer(x500NameTokenizer2.nextToken(), SignatureVisitor.INSTANCEOF);
                            String nextToken4 = x500NameTokenizer4.nextToken();
                            if (x500NameTokenizer4.hasMoreTokens()) {
                                nextToken3 = x500NameTokenizer4.nextToken();
                                attrNameToOID = x500NameStyle.attrNameToOID(nextToken4.trim());
                            } else {
                                throw new IllegalArgumentException("badly formatted directory string");
                            }
                        }
                    } else {
                        x500NameBuilder.addRDN(attrNameToOID, unescape(nextToken3));
                    }
                } else {
                    throw new IllegalArgumentException("badly formatted directory string");
                }
            } else {
                X500NameTokenizer x500NameTokenizer5 = new X500NameTokenizer(nextToken, SignatureVisitor.INSTANCEOF);
                String nextToken5 = x500NameTokenizer5.nextToken();
                if (x500NameTokenizer5.hasMoreTokens()) {
                    x500NameBuilder.addRDN(x500NameStyle.attrNameToOID(nextToken5.trim()), unescape(x500NameTokenizer5.nextToken()));
                } else {
                    throw new IllegalArgumentException("badly formatted directory string");
                }
            }
        }
        return x500NameBuilder.build().getRDNs();
    }

    public static String stripInternalSpaces(String str) {
        if (str.indexOf("  ") < 0) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        char charAt = str.charAt(0);
        stringBuffer.append(charAt);
        for (int i10 = 1; i10 < str.length(); i10++) {
            char charAt2 = str.charAt(i10);
            if (charAt != ' ' || charAt2 != ' ') {
                stringBuffer.append(charAt2);
                charAt = charAt2;
            }
        }
        return stringBuffer.toString();
    }

    private static ASN1ObjectIdentifier[] toOIDArray(Vector vector) {
        int size = vector.size();
        ASN1ObjectIdentifier[] aSN1ObjectIdentifierArr = new ASN1ObjectIdentifier[size];
        for (int i10 = 0; i10 != size; i10++) {
            aSN1ObjectIdentifierArr[i10] = (ASN1ObjectIdentifier) vector.elementAt(i10);
        }
        return aSN1ObjectIdentifierArr;
    }

    private static String[] toValueArray(Vector vector) {
        int size = vector.size();
        String[] strArr = new String[size];
        for (int i10 = 0; i10 != size; i10++) {
            strArr[i10] = (String) vector.elementAt(i10);
        }
        return strArr;
    }

    private static String unescape(String str) {
        int i10;
        if (str.length() == 0 || (str.indexOf(92) < 0 && str.indexOf(34) < 0)) {
            return str.trim();
        }
        char[] charArray = str.toCharArray();
        StringBuffer stringBuffer = new StringBuffer(str.length());
        if (charArray[0] == '\\' && charArray[1] == '#') {
            i10 = 2;
            stringBuffer.append("\\#");
        } else {
            i10 = 0;
        }
        boolean z10 = false;
        int i11 = 0;
        boolean z11 = false;
        boolean z12 = false;
        char c10 = 0;
        while (i10 != charArray.length) {
            char c11 = charArray[i10];
            if (c11 != ' ') {
                z12 = true;
            }
            if (c11 == '\"') {
                if (!z10) {
                    z11 = !z11;
                }
                stringBuffer.append(c11);
            } else if (c11 == '\\' && !z10 && !z11) {
                i11 = stringBuffer.length();
                z10 = true;
                i10++;
            } else if (c11 != ' ' || z10 || z12) {
                if (z10 && isHexDigit(c11)) {
                    if (c10 != 0) {
                        stringBuffer.append((char) ((convertHex(c10) * 16) + convertHex(c11)));
                        z10 = false;
                        c10 = 0;
                    } else {
                        c10 = c11;
                    }
                    i10++;
                }
                stringBuffer.append(c11);
            } else {
                i10++;
            }
            z10 = false;
            i10++;
        }
        if (stringBuffer.length() > 0) {
            while (stringBuffer.charAt(stringBuffer.length() - 1) == ' ' && i11 != stringBuffer.length() - 1) {
                stringBuffer.setLength(stringBuffer.length() - 1);
            }
        }
        return stringBuffer.toString();
    }

    public static ASN1Encodable valueFromHexString(String str, int i10) throws IOException {
        int length = (str.length() - i10) / 2;
        byte[] bArr = new byte[length];
        for (int i11 = 0; i11 != length; i11++) {
            int i12 = (i11 * 2) + i10;
            char charAt = str.charAt(i12);
            bArr[i11] = (byte) (convertHex(str.charAt(i12 + 1)) | (convertHex(charAt) << 4));
        }
        return ASN1Primitive.fromByteArray(bArr);
    }

    public static String valueToString(ASN1Encodable aSN1Encodable) {
        int i10;
        StringBuffer stringBuffer = new StringBuffer();
        int i11 = 0;
        if (!(aSN1Encodable instanceof ASN1String) || (aSN1Encodable instanceof DERUniversalString)) {
            try {
                stringBuffer.append('#');
                stringBuffer.append(Hex.toHexString(aSN1Encodable.toASN1Primitive().getEncoded(ASN1Encoding.DER)));
            } catch (IOException unused) {
                throw new IllegalArgumentException("Other value has no encoded form");
            }
        } else {
            String string = ((ASN1String) aSN1Encodable).getString();
            if (string.length() > 0 && string.charAt(0) == '#') {
                stringBuffer.append('\\');
            }
            stringBuffer.append(string);
        }
        int length = stringBuffer.length();
        int i12 = 2;
        if (!(stringBuffer.length() >= 2 && stringBuffer.charAt(0) == '\\' && stringBuffer.charAt(1) == '#')) {
            i12 = 0;
        }
        while (i10 != length) {
            char charAt = stringBuffer.charAt(i10);
            if (!(charAt == '\"' || charAt == '\\' || charAt == '+' || charAt == ',')) {
                switch (charAt) {
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                        break;
                    default:
                        i10++;
                        continue;
                }
            }
            stringBuffer.insert(i10, "\\");
            i10 += 2;
            length++;
        }
        if (stringBuffer.length() > 0) {
            while (stringBuffer.length() > i11 && stringBuffer.charAt(i11) == ' ') {
                stringBuffer.insert(i11, "\\");
                i11 += 2;
            }
        }
        int length2 = stringBuffer.length() - 1;
        while (length2 >= 0 && stringBuffer.charAt(length2) == ' ') {
            stringBuffer.insert(length2, '\\');
            length2--;
        }
        return stringBuffer.toString();
    }
}
